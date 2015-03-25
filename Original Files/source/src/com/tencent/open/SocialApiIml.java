// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.a.a.c;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            j, k, PKDialog, TDialog, 
//            b, i

public class SocialApiIml extends BaseApi
{

    ProgressDialog a;
    private Activity b;

    public SocialApiIml(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public SocialApiIml(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    private j a(Bundle bundle, String s, String s1, IUiListener iuilistener)
    {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
        j j1 = new j();
        j1.a = intent;
        j1.c = bundle;
        j1.d = s1;
        j1.e = iuilistener;
        j1.b = s;
        return j1;
    }

    private void a(Activity activity, Intent intent, String s, Bundle bundle, String s1, IUiListener iuilistener)
    {
        Log.i("SocialApiIml", (new StringBuilder()).append("SocialApiIml handleIntent ").append(s).append(" params=").append(bundle).append(" activityIntent=").append(intent).toString());
        if (intent != null)
        {
            intent.putExtra("key_action", s);
            intent.putExtra("key_params", bundle);
            mActivityIntent = intent;
            startAssitActivity(activity, iuilistener);
        } else
        {
            Intent intent1 = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
            k k1 = new k(this, iuilistener, s, s1, bundle);
            Intent intent2 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
            if (intent2 != null && intent1 != null && intent1.getComponent() != null && intent2.getComponent() != null && intent1.getComponent().getPackageName().equals(intent2.getComponent().getPackageName()))
            {
                intent2.putExtra("oauth_consumer_key", mToken.getAppId());
                intent2.putExtra("openid", mToken.getOpenId());
                intent2.putExtra("access_token", mToken.getAccessToken());
                intent2.putExtra("key_action", "action_check_token");
                mActivityIntent = intent2;
                if (hasActivityForIntent())
                {
                    startAssitActivity(activity, k1);
                    return;
                }
            } else
            {
                String s2 = Util.encrypt((new StringBuilder()).append("tencent&sdk&qazxc***14969%%").append(mToken.getAccessToken()).append(mToken.getAppId()).append(mToken.getOpenId()).append("qzone3.4").toString());
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("encry_token", s2);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                k1.onComplete(jsonobject);
                return;
            }
        }
    }

    private void a(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.voice");
        String s = ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/not_support.html?");
        if (intent == null && a())
        {
            if (a == null || !a.isShowing())
            {
                a = new ProgressDialog(activity);
                a.setTitle("\u8BF7\u7A0D\u5019");
                a.show();
            }
            a(activity, "action_voice", ((IUiListener) (new a(a(bundle, "action_voice", s, iuilistener)))));
            return;
        } else
        {
            a(activity, intent, "action_voice", bundle, s, iuilistener);
            return;
        }
    }

    private void a(Activity activity, String s, Bundle bundle, IUiListener iuilistener)
    {
        Intent intent;
        b = activity;
        intent = getAgentIntentWithTarget("com.tencent.open.agent.RequestFreegiftActivity");
        bundle.putAll(composeActivityParams());
        if (!"action_ask".equals(s)) goto _L2; else goto _L1
_L1:
        bundle.putString("type", "request");
_L4:
        a(activity, intent, s, bundle, ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iuilistener);
        return;
_L2:
        if ("action_gift".equals(s))
        {
            bundle.putString("type", "freegift");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Context context, String s, Bundle bundle, String s1, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", mToken.getAppId());
        if (mToken.isSessionValid())
        {
            bundle.putString("access_token", mToken.getAccessToken());
        }
        String s2 = mToken.getOpenId();
        if (s2 != null)
        {
            bundle.putString("openid", s2);
        }
        StringBuilder stringbuilder;
        String s3;
        try
        {
            bundle.putString("pf", mContext.getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            bundle.putString("pf", "openmobile_android");
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append(s1);
        stringbuilder.append(Util.encodeUrl(bundle));
        s3 = stringbuilder.toString();
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog TDialog");
        if ("action_challenge".equals(s) || "action_brag".equals(s))
        {
            com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog PKDialog");
            (new PKDialog(b, s, s3, iuilistener, mToken)).show();
            return;
        } else
        {
            (new TDialog(b, s, s3, iuilistener, mToken)).show();
            return;
        }
    }

    static void a(SocialApiIml socialapiiml)
    {
        socialapiiml.c();
    }

    static void a(SocialApiIml socialapiiml, Activity activity, Intent intent, String s, Bundle bundle, String s1, IUiListener iuilistener)
    {
        socialapiiml.a(activity, intent, s, bundle, s1, iuilistener);
    }

    static void a(SocialApiIml socialapiiml, Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        socialapiiml.a(activity, bundle, iuilistener);
    }

    static void a(SocialApiIml socialapiiml, Context context, String s, Bundle bundle, String s1, IUiListener iuilistener)
    {
        socialapiiml.a(context, s, bundle, s1, iuilistener);
    }

    static Activity b(SocialApiIml socialapiiml)
    {
        return socialapiiml.b;
    }

    static Context c(SocialApiIml socialapiiml)
    {
        return socialapiiml.mContext;
    }

    private void c()
    {
        if (!b.isFinishing() && a != null && a.isShowing())
        {
            a.dismiss();
            a = null;
        }
    }

    protected void a(Activity activity, String s, IUiListener iuilistener)
    {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
        intent.putExtra("key_action", "action_check");
        Bundle bundle = new Bundle();
        bundle.putString("apiName", s);
        intent.putExtra("key_params", bundle);
        mActivityIntent = intent;
        startAssitActivity(activity, iuilistener);
    }

    protected boolean a()
    {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.CheckFunctionActivity");
        return SystemUtils.isActivityExist(mContext, intent);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a(activity, "action_ask", bundle, iuilistener);
    }

    public void brag(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.BragActivity");
        bundle.putAll(composeActivityParams());
        a(activity, intent, "action_brag", bundle, ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?"), iuilistener);
    }

    public void challenge(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.ChallengeActivity");
        bundle.putAll(composeActivityParams());
        a(activity, intent, "action_challenge", bundle, ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?"), iuilistener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a(activity, "action_gift", bundle, iuilistener);
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString("version", Util.getAppVersion(activity));
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.AppGradeActivity");
        if (intent == null && a())
        {
            a = new ProgressDialog(activity);
            a.setMessage("\u8BF7\u7A0D\u5019...");
            a.show();
            a(activity, "action_grade", new a(a(bundle, "action_grade", "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iuilistener)));
            return;
        } else
        {
            a(activity, intent, "action_grade", bundle, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", iuilistener);
            return;
        }
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.AppInvitationActivity");
        bundle.putAll(composeActivityParams());
        a(activity, intent, "action_invite", bundle, ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), iuilistener);
    }

    public void reactive(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.ReactiveActivity");
        bundle.putAll(composeActivityParams());
        String s = ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/reactive/sdk_reactive.html?");
        if (intent == null && a())
        {
            a = new ProgressDialog(activity);
            a.setMessage("\u8BF7\u7A0D\u5019...");
            a.show();
            bundle.putString("type", "reactive");
            a(activity, "action_reactive", new a(a(bundle, "action_reactive", s, iuilistener)));
            return;
        } else
        {
            bundle.putString("sendImg", bundle.getString("img"));
            bundle.remove("img");
            a(activity, intent, "action_reactive", bundle, s, iuilistener);
            return;
        }
    }

    public void story(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        b = activity;
        Intent intent = getAgentIntentWithTarget("com.tencent.open.agent.SendStoryActivity");
        bundle.putAll(composeActivityParams());
        a(activity, intent, "action_story", bundle, ServerSetting.getInstance().getEnvUrl(mContext, "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iuilistener);
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        Log.v("voice", (new StringBuilder()).append("voice params=").append(bundle).toString());
        b = activity;
        bundle.putAll(composeActivityParams());
        bundle.putString("version", Util.getAppVersion(activity));
        if (!com.tencent.open.b.a())
        {
            iuilistener.onError(new UiError(-12, "\u68C0\u6D4B\u4E0D\u5230SD\u5361\uFF0C\u65E0\u6CD5\u53D1\u9001\u8BED\u97F3\uFF01", "\u68C0\u6D4B\u4E0D\u5230SD\u5361\uFF0C\u65E0\u6CD5\u53D1\u9001\u8BED\u97F3\uFF01"));
            return;
        }
        if (bundle.containsKey("image_date"))
        {
            Bitmap bitmap = (Bitmap)bundle.getParcelable("image_date");
            if (bitmap != null)
            {
                a = new ProgressDialog(activity);
                a.setTitle("\u8BF7\u7A0D\u5019\uFF0C\u6B63\u5728\u67E5\u8BE2\u2026");
                a.show();
                (new b(new i(this, bundle, activity, iuilistener))).execute(new Bitmap[] {
                    bitmap
                });
                return;
            }
        }
        a(activity, bundle, iuilistener);
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

    private class a
        implements IUiListener
    {

        j a;
        final SocialApiIml b;

        public void onCancel()
        {
            SocialApiIml.a(b);
            com.tencent.open.b.a(a.c.getString("image_date"));
            SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
        }

        public void onComplete(Object obj)
        {
            boolean flag;
            JSONObject jsonobject;
            Log.d("TAG", (new StringBuilder()).append("CheckListener--onComplete--response = ").append(obj.toString()).toString());
            flag = false;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            jsonobject = (JSONObject)obj;
            boolean flag1 = jsonobject.getBoolean("check_result");
            flag = flag1;
_L1:
            SocialApiIml.a(b);
            JSONException jsonexception;
            if (flag)
            {
                Log.d("TAG", (new StringBuilder()).append("CheckListener---delayStartParam.agentIntent = ").append(a.a).append(" delayStartParam.action = ").append(a.b).toString());
                SocialApiIml.a(b, SocialApiIml.b(b), a.a, a.b, a.c, a.d, a.e);
                return;
            } else
            {
                com.tencent.open.b.a(a.c.getString("image_date"));
                SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
                return;
            }
            jsonexception;
            jsonexception.printStackTrace();
            flag = false;
              goto _L1
        }

        public void onError(UiError uierror)
        {
            SocialApiIml.a(b);
            com.tencent.open.b.a(a.c.getString("image_date"));
            SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
        }

        public a(j j1)
        {
            b = SocialApiIml.this;
            super();
            a = j1;
        }
    }

}
