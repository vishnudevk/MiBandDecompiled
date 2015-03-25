// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.a.a.c;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.OpenConfig;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            AssistActivity, Constants

public abstract class BaseApi
{

    protected static final String ACTION_CHECK_TOKEN = "action_check_token";
    protected static final String ACTIVITY_AGENT = "com.tencent.open.agent.AgentActivity";
    protected static final String ACTIVITY_ENCRY_TOKEN = "com.tencent.open.agent.EncryTokenActivity";
    protected static final String DEFAULT_PF = "openmobile_android";
    protected static final String PARAM_ENCRY_EOKEN = "encry_token";
    protected static final String PLATFORM = "desktop_m_qq";
    protected static final String PREFERENCE_PF = "pfStore";
    protected static final String VERSION = "android";
    private static final String a = "key_request_code";
    private static final int b;
    public static String businessId = null;
    public static String installChannel = null;
    public static boolean isOEM = false;
    public static String registerChannel = null;
    protected static int sRequestCode = 1000;
    protected Intent mActivityIntent;
    protected Context mContext;
    protected QQAuth mQQAuth;
    protected List mTaskList;
    protected QQToken mToken;
    protected IUiListener mUiListener;

    public BaseApi(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        mTaskList = null;
        mActivityIntent = null;
        mUiListener = null;
        mContext = context;
        mQQAuth = qqauth;
        mToken = qqtoken;
        mTaskList = new ArrayList();
    }

    public BaseApi(Context context, QQToken qqtoken)
    {
        this(context, null, qqtoken);
    }

    private Intent a()
    {
        return new Intent(mContext, com/tencent/connect/common/AssistActivity);
    }

    Intent b()
    {
        return mActivityIntent;
    }

    protected Bundle composeActivityParams()
    {
        Bundle bundle = new Bundle();
        bundle.putString("appid", mToken.getAppId());
        if (mToken.isSessionValid())
        {
            bundle.putString("keystr", mToken.getAccessToken());
            bundle.putString("keytype", "0x80");
        }
        String s = mToken.getOpenId();
        if (s != null)
        {
            bundle.putString("hopenid", s);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedpreferences = mContext.getSharedPreferences("pfStore", 0);
        if (isOEM)
        {
            bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(installChannel).append("-").append("android").append("-").append(registerChannel).append("-").append(businessId).toString());
        } else
        {
            bundle.putString("pf", sharedpreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "2.1");
        bundle.putString("sdkp", "a");
        return bundle;
    }

    protected Bundle composeCGIParams()
    {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", "2.1");
        bundle.putString("sdkp", "a");
        if (mToken != null && mToken.isSessionValid())
        {
            bundle.putString("access_token", mToken.getAccessToken());
            bundle.putString("oauth_consumer_key", mToken.getAppId());
            bundle.putString("openid", mToken.getOpenId());
        }
        bundle.putString("appid_for_getting_config", mToken.getAppId());
        SharedPreferences sharedpreferences = mContext.getSharedPreferences("pfStore", 0);
        if (isOEM)
        {
            bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(installChannel).append("-").append("android").append("-").append(registerChannel).append("-").append(businessId).toString());
            return bundle;
        } else
        {
            bundle.putString("pf", sharedpreferences.getString("pf", "openmobile_android"));
            return bundle;
        }
    }

    protected Intent getAgentIntent()
    {
        return getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    }

    protected Intent getAgentIntentWithTarget(String s)
    {
        Intent intent = new Intent();
        Intent intent1;
        for (intent1 = getTargetActivityIntent(s); intent1 == null || intent1.getComponent() == null;)
        {
            return null;
        }

        intent.setClassName(intent1.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    protected Intent getTargetActivityIntent(String s)
    {
        Intent intent;
        Intent intent1;
        String s1;
        intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, s);
        intent1 = new Intent();
        intent1.setClassName(Constants.PACKAGE_QQ, s);
        s1 = SystemUtils.getAppVersionName(mContext, Constants.PACKAGE_QZONE);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (!SystemUtils.isActivityExist(mContext, intent1)) goto _L4; else goto _L3
_L3:
        return intent1;
_L4:
        return null;
_L2:
        String s2 = OpenConfig.getInstance(mContext, mToken.getAppId()).getString("Common_SSO_QzoneVersion");
        if (TextUtils.isEmpty(s2))
        {
            s2 = "4.0";
        }
        if (SystemUtils.compareVersion(s1, "3.4") >= 0 && SystemUtils.compareVersion(s1, s2) < 0)
        {
            boolean flag = SystemUtils.isActivityExist(mContext, intent);
            Intent intent2 = null;
            if (flag)
            {
                boolean flag1 = SystemUtils.isAppSignatureValid(mContext, intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE);
                intent2 = null;
                if (flag1)
                {
                    intent2 = intent;
                }
            }
            return intent2;
        }
        if (!SystemUtils.isActivityExist(mContext, intent1))
        {
            if (!SystemUtils.isActivityExist(mContext, intent) || !SystemUtils.isAppSignatureValid(mContext, intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE))
            {
                intent = null;
            }
            return intent;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    protected boolean hasActivityForIntent()
    {
        if (mActivityIntent != null)
        {
            return SystemUtils.isActivityExist(mContext, mActivityIntent);
        } else
        {
            return false;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Iterator iterator = mTaskList.iterator();
        IUiListener iuilistener;
        do
        {
            boolean flag = iterator.hasNext();
            iuilistener = null;
            if (!flag)
            {
                break;
            }
            ApiTask apitask = (ApiTask)iterator.next();
            if (apitask.mRequestCode != i)
            {
                continue;
            }
            iuilistener = apitask.mListener;
            mTaskList.remove(apitask);
            break;
        } while (true);
        if (iuilistener == null)
        {
            return;
        }
        if (j == -1)
        {
            int k = intent.getIntExtra("key_error_code", 0);
            if (k == 0)
            {
                String s = intent.getStringExtra("key_response");
                if (s != null)
                {
                    try
                    {
                        iuilistener.onComplete(Util.parseJson(s));
                    }
                    catch (JSONException jsonexception)
                    {
                        iuilistener.onError(new UiError(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", s));
                        c.a("openSDK_LOG", "OpenUi, onActivityResult, json error", jsonexception);
                    }
                } else
                {
                    c.b("openSDK_LOG", "OpenUi, onActivityResult, onComplete");
                    iuilistener.onComplete(new JSONObject());
                }
            } else
            {
                c.d("openSDK_LOG", (new StringBuilder()).append("OpenUi, onActivityResult, onError = ").append(k).append("").toString());
                iuilistener.onError(new UiError(k, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
            }
        } else
        {
            c.b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
            iuilistener.onCancel();
        }
        c.a().b();
    }

    protected void startAssitActivity(Activity activity, IUiListener iuilistener)
    {
        AssistActivity.setApiObject(this);
        int i = sRequestCode;
        sRequestCode = i + 1;
        mActivityIntent.putExtra("key_request_code", i);
        mTaskList.add(new ApiTask(i, iuilistener));
        activity.startActivity(a());
    }


    private class ApiTask
    {

        final BaseApi a;
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iuilistener)
        {
            a = BaseApi.this;
            super();
            mRequestCode = i;
            mListener = iuilistener;
        }
    }

}
