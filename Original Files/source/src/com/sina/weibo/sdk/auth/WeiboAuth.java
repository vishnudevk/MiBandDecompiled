// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.content.Context;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import java.util.LinkedHashMap;

// Referenced classes of package com.sina.weibo.sdk.auth:
//            WeiboDialog, WeiboAuthListener

public class WeiboAuth
{

    private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    public static final int OBTAIN_AUTH_CODE = 0;
    public static final int OBTAIN_AUTH_TOKEN = 1;
    public static final String TAG = "Weibo_web_login";
    private AuthInfo mAuthInfo;
    private Context mContext;

    public WeiboAuth(Context context, AuthInfo authinfo)
    {
        mContext = context;
        mAuthInfo = authinfo;
    }

    public WeiboAuth(Context context, String s, String s1, String s2)
    {
        mContext = context;
        mAuthInfo = new AuthInfo(context, s, s1, s2);
    }

    private void startDialog(WeiboAuthListener weiboauthlistener, int i)
    {
        if (weiboauthlistener == null)
        {
            return;
        }
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        linkedhashmap.put("client_id", mAuthInfo.mAppKey);
        linkedhashmap.put("redirect_uri", mAuthInfo.mRedirectUrl);
        linkedhashmap.put("scope", mAuthInfo.mScope);
        linkedhashmap.put("response_type", "code");
        linkedhashmap.put("display", "mobile");
        if (1 == i)
        {
            linkedhashmap.put("packagename", mAuthInfo.mPackageName);
            linkedhashmap.put("key_hash", mAuthInfo.mKeyHash);
        }
        String s = (new StringBuilder("https://open.weibo.cn/oauth2/authorize?")).append(Utility.packUrl(linkedhashmap)).toString();
        if (!NetworkHelper.hasInternetPermission(mContext))
        {
            UIUtils.showAlert(mContext, "Error", "Application requires permission to access the Internet");
            return;
        }
        if (NetworkHelper.isNetworkAvailable(mContext))
        {
            (new WeiboDialog(mContext, s, weiboauthlistener, this)).show();
            return;
        } else
        {
            String s1 = ResourceManager.getString(mContext, 2);
            LogUtil.i("Weibo_web_login", (new StringBuilder("String: ")).append(s1).toString());
            UIUtils.showToast(mContext, s1, 0);
            return;
        }
    }

    public void anthorize(WeiboAuthListener weiboauthlistener)
    {
        authorize(weiboauthlistener, 1);
    }

    public void authorize(WeiboAuthListener weiboauthlistener, int i)
    {
        startDialog(weiboauthlistener, i);
    }

    public AuthInfo getAuthInfo()
    {
        return mAuthInfo;
    }

    public void setAuthInfo(AuthInfo authinfo)
    {
        mAuthInfo = authinfo;
    }

    private class AuthInfo
    {

        private String mAppKey;
        private Bundle mBundle;
        private String mKeyHash;
        private String mPackageName;
        private String mRedirectUrl;
        private String mScope;

        private void initAuthBundle()
        {
            mBundle = new Bundle();
            mBundle.putString("appKey", mAppKey);
            mBundle.putString("redirectUri", mRedirectUrl);
            mBundle.putString("scope", mScope);
            mBundle.putString("packagename", mPackageName);
            mBundle.putString("key_hash", mKeyHash);
        }

        public String getAppKey()
        {
            return mAppKey;
        }

        public Bundle getAuthBundle()
        {
            return mBundle;
        }

        public String getRedirectUrl()
        {
            return mRedirectUrl;
        }

        public String getScope()
        {
            return mScope;
        }






        public AuthInfo(Context context, String s, String s1, String s2)
        {
            mAppKey = "";
            mRedirectUrl = "";
            mScope = "";
            mPackageName = "";
            mKeyHash = "";
            mBundle = null;
            mAppKey = s;
            mRedirectUrl = s1;
            mScope = s2;
            mPackageName = context.getPackageName();
            mKeyHash = Utility.getSign(context, mPackageName);
            initAuthBundle();
        }
    }

}
