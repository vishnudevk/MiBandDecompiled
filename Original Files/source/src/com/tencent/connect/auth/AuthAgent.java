// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.a.a.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.Util;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            a, b, QQToken, i, 
//            AuthDialog, h, c

public class AuthAgent extends BaseApi
{

    private IUiListener a;
    private String b;
    private Activity c;
    private IUiListener d;
    private Handler e;

    public AuthAgent(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
        d = new a(this);
        e = new b(this);
    }

    private int a(boolean flag, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(mContext);
        Bundle bundle = composeCGIParams();
        if (flag)
        {
            bundle.putString("isadd", "1");
        }
        bundle.putString("scope", b);
        bundle.putString("client_id", mToken.getAppId());
        String s;
        StringBuilder stringbuilder;
        String s1;
        i l;
        if (isOEM)
        {
            bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(installChannel).append("-").append("android").append("-").append(registerChannel).append("-").append(businessId).toString());
        } else
        {
            bundle.putString("pf", "openmobile_android");
        }
        s = (new StringBuilder()).append(System.currentTimeMillis() / 1000L).append("").toString();
        bundle.putString("sign", SystemUtils.getAppSignatureMD5(mContext, s));
        bundle.putString("time", s);
        bundle.putString("display", "mobile");
        bundle.putString("response_type", "token");
        bundle.putString("redirect_uri", "auth://tauth.qq.com/");
        bundle.putString("cancel_display", "1");
        bundle.putString("switch", "1");
        bundle.putString("status_userip", Util.getUserIp());
        stringbuilder = new StringBuilder();
        stringbuilder.append(ServerSetting.getInstance().getEnvUrl(mContext, "https://openmobile.qq.com/oauth2.0/m_authorize?"));
        stringbuilder.append(Util.encodeUrl(bundle));
        s1 = stringbuilder.toString();
        l = new i(this, mContext, iuilistener, true, false);
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog TDialog");
        (new AuthDialog(c, "action_login", s1, l, mToken)).show();
        return 2;
    }

    static QQToken a(AuthAgent authagent)
    {
        return authagent.mToken;
    }

    private void a()
    {
        mToken.setAccessToken("", "0");
        mToken.setOpenId("");
        doLogin(c, b, a, true);
    }

    static void a(AuthAgent authagent, String s)
    {
        authagent.a(s);
    }

    private void a(String s)
    {
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, EncrytokenListener() validToken()");
        Bundle bundle = composeCGIParams();
        bundle.putString("encrytoken", s);
        HttpUtils.requestAsync(mToken, mContext, "https://openmobile.qq.com/user/user_login_statis", bundle, "POST", new h(this));
    }

    private boolean a(Activity activity, boolean flag)
    {
        Intent intent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
        if (intent != null)
        {
            Bundle bundle = composeCGIParams();
            if (flag)
            {
                bundle.putString("isadd", "1");
            }
            bundle.putString("scope", b);
            bundle.putString("client_id", mToken.getAppId());
            String s;
            if (isOEM)
            {
                bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(installChannel).append("-").append("android").append("-").append(registerChannel).append("-").append(businessId).toString());
            } else
            {
                bundle.putString("pf", "openmobile_android");
            }
            bundle.putString("need_pay", "1");
            bundle.putString("oauth_app_name", SystemUtils.getAppName(mContext));
            s = (new StringBuilder()).append(System.currentTimeMillis() / 1000L).append("").toString();
            bundle.putString("sign", SystemUtils.getAppSignatureMD5(mContext, s));
            bundle.putString("time", s);
            intent.putExtra("key_action", "action_login");
            intent.putExtra("key_params", bundle);
            mActivityIntent = intent;
            if (hasActivityForIntent())
            {
                a = new com.tencent.connect.auth.c(this, a);
                startAssitActivity(activity, a);
                return true;
            }
        }
        return false;
    }

    static QQToken b(AuthAgent authagent)
    {
        return authagent.mToken;
    }

    static QQToken c(AuthAgent authagent)
    {
        return authagent.mToken;
    }

    static QQToken d(AuthAgent authagent)
    {
        return authagent.mToken;
    }

    static void e(AuthAgent authagent)
    {
        authagent.a();
    }

    static Context f(AuthAgent authagent)
    {
        return authagent.mContext;
    }

    static IUiListener g(AuthAgent authagent)
    {
        return authagent.a;
    }

    static Handler h(AuthAgent authagent)
    {
        return authagent.e;
    }

    static Activity i(AuthAgent authagent)
    {
        return authagent.c;
    }

    static Bundle j(AuthAgent authagent)
    {
        return authagent.composeActivityParams();
    }

    static QQToken k(AuthAgent authagent)
    {
        return authagent.mToken;
    }

    public int doLogin(Activity activity, String s, IUiListener iuilistener)
    {
        return doLogin(activity, s, iuilistener, false, false);
    }

    public int doLogin(Activity activity, String s, IUiListener iuilistener, boolean flag)
    {
        return doLogin(activity, s, iuilistener, flag, false);
    }

    public int doLogin(Activity activity, String s, IUiListener iuilistener, boolean flag, boolean flag1)
    {
        b = s;
        c = activity;
        a = iuilistener;
        if (!flag)
        {
            String s1 = mToken.getAccessToken();
            String s2 = mToken.getOpenId();
            String s3 = mToken.getAppId();
            if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
            {
                Intent intent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
                Intent intent1 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
                if (intent1 != null && intent != null && intent.getComponent() != null && intent1.getComponent() != null && intent.getComponent().getPackageName().equals(intent1.getComponent().getPackageName()))
                {
                    intent1.putExtra("oauth_consumer_key", s3);
                    intent1.putExtra("openid", s2);
                    intent1.putExtra("access_token", s1);
                    intent1.putExtra("key_action", "action_check_token");
                    mActivityIntent = intent1;
                    if (hasActivityForIntent())
                    {
                        startAssitActivity(activity, d);
                    }
                } else
                {
                    String s4 = Util.encrypt((new StringBuilder()).append("tencent&sdk&qazxc***14969%%").append(s1).append(s3).append(s2).append("qzone3.4").toString());
                    JSONObject jsonobject = new JSONObject();
                    try
                    {
                        jsonobject.put("encry_token", s4);
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                    }
                    d.onComplete(jsonobject);
                }
                return 3;
            }
        }
        if (a(activity, flag1))
        {
            if (flag)
            {
                Util.reportBernoulli(activity, "10785", 0L, mToken.getAppId());
            }
            com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            return 1;
        } else
        {
            a = new com.tencent.connect.auth.c(this, a);
            return a(flag1, a);
        }
    }

    public void onActivityResult(int l, int i1, Intent intent)
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
            com.tencent.connect.common.BaseApi.ApiTask apitask = (com.tencent.connect.common.BaseApi.ApiTask)iterator.next();
            if (apitask.mRequestCode != l)
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
        if (i1 == -1)
        {
            int j1 = intent.getIntExtra("key_error_code", 0);
            if (j1 == 0)
            {
                String s = intent.getStringExtra("key_response");
                if (s != null)
                {
                    try
                    {
                        JSONObject jsonobject = Util.parseJson(s);
                        if (iuilistener == a)
                        {
                            String s1 = jsonobject.getString("access_token");
                            String s2 = jsonobject.getString("expires_in");
                            String s3 = jsonobject.getString("openid");
                            if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
                            {
                                mToken.setAccessToken(s1, s2);
                                mToken.setOpenId(s3);
                            }
                        }
                        iuilistener.onComplete(jsonobject);
                    }
                    catch (JSONException jsonexception)
                    {
                        iuilistener.onError(new UiError(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", s));
                        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, onActivityResult, json error", jsonexception);
                    }
                } else
                {
                    com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, onActivityResult, onComplete");
                    iuilistener.onComplete(new JSONObject());
                }
            } else
            {
                com.tencent.a.a.c.d("openSDK_LOG", (new StringBuilder()).append("OpenUi, onActivityResult, onError = ").append(j1).append("").toString());
                iuilistener.onError(new UiError(j1, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
            }
        } else
        {
            com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
            iuilistener.onCancel();
        }
        com.tencent.a.a.c.a().b();
    }

    public void writeEncryToken(Context context)
    {
        String s = mToken.getAccessToken();
        String s1 = mToken.getAppId();
        String s2 = mToken.getOpenId();
        String s3;
        WebView webview;
        WebSettings websettings;
        String s4;
        String s5;
        if (s != null && s.length() > 0 && s1 != null && s1.length() > 0 && s2 != null && s2.length() > 0)
        {
            s3 = Util.encrypt((new StringBuilder()).append("tencent&sdk&qazxc***14969%%").append(s).append(s1).append(s2).append("qzone3.4").toString());
        } else
        {
            s3 = null;
        }
        webview = new WebView(context);
        websettings = webview.getSettings();
        websettings.setDomStorageEnabled(true);
        websettings.setJavaScriptEnabled(true);
        websettings.setDatabaseEnabled(true);
        s4 = (new StringBuilder()).append("<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"").append(mToken.getOpenId()).append("_").append(mToken.getAppId()).append("\"]=\"").append(s3).append("\";</script></head><body></body></html>").toString();
        s5 = ServerSetting.getInstance().getEnvUrl(context, "http://qzs.qq.com");
        webview.loadDataWithBaseURL(s5, s4, "text/html", "utf-8", s5);
    }
}
