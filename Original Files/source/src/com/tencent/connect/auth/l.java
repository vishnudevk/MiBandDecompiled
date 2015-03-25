// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.tauth.UiError;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthDialog, m, j

class l extends WebViewClient
{

    final AuthDialog a;

    private l(AuthDialog authdialog)
    {
        a = authdialog;
        super();
    }

    l(AuthDialog authdialog, j j)
    {
        this(authdialog);
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (AuthDialog.b() != null && AuthDialog.b().get() != null)
        {
            ((View)AuthDialog.b().get()).setVisibility(8);
        }
        AuthDialog.d(a).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Util.logd("AuthDialog", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
        if (AuthDialog.b() != null && AuthDialog.b().get() != null)
        {
            ((View)AuthDialog.b().get()).setVisibility(0);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        AuthDialog.e(a).onError(new UiError(i, s, s1));
        if (AuthDialog.a() != null && AuthDialog.a().get() != null)
        {
            Toast.makeText((Context)AuthDialog.a().get(), "\u7F51\u7EDC\u8FDE\u63A5\u5F02\u5E38\u6216\u7CFB\u7EDF\u9519\u8BEF", 0).show();
        }
        a.dismiss();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Util.logd("AuthDialog", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
        if (!s.startsWith("auth://browser")) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = Util.parseUrlToJson(s);
        AuthDialog.a(a, AuthDialog.a(a));
        if (!AuthDialog.b(a)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        if (jsonobject.optString("fail_cb", null) != null)
        {
            a.callJs(jsonobject.optString("fail_cb"), "");
        } else
        if (jsonobject.optInt("fall_to_wv") == 1)
        {
            AuthDialog authdialog = a;
            String s2;
            if (AuthDialog.c(a).indexOf("?") > -1)
            {
                s2 = "&";
            } else
            {
                s2 = "?";
            }
            AuthDialog.a(authdialog, s2);
            AuthDialog.a(a, "browser_error=1");
            AuthDialog.d(a).loadUrl(AuthDialog.c(a));
        } else
        {
            String s1 = jsonobject.optString("redir", null);
            if (s1 != null)
            {
                AuthDialog.d(a).loadUrl(s1);
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (s.startsWith(ServerSetting.getInstance().getEnvUrl((Context)AuthDialog.a().get(), "auth://tauth.qq.com/")))
        {
            AuthDialog.e(a).onComplete(Util.parseUrlToJson(s));
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://cancel"))
        {
            AuthDialog.e(a).onCancel();
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://close"))
        {
            a.dismiss();
            return true;
        }
        if (s.startsWith("download://"))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(s.substring("download://".length()))));
            if (AuthDialog.a() != null && AuthDialog.a().get() != null)
            {
                ((Context)AuthDialog.a().get()).startActivity(intent);
            }
            return true;
        } else
        {
            return false;
        }
    }
}
