// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.tauth.UiError;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;

// Referenced classes of package com.tencent.open:
//            PKDialog, g, c

class e extends WebViewClient
{

    final PKDialog a;

    private e(PKDialog pkdialog)
    {
        a = pkdialog;
        super();
    }

    e(PKDialog pkdialog, c c)
    {
        this(pkdialog);
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        PKDialog.c(a).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Util.logd(PKDialog.a(), (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        PKDialog.b(a).onError(new UiError(i, s, s1));
        if (PKDialog.b() != null && PKDialog.b().get() != null)
        {
            Toast.makeText((Context)PKDialog.b().get(), "\u7F51\u7EDC\u8FDE\u63A5\u5F02\u5E38\u6216\u7CFB\u7EDF\u9519\u8BEF", 0).show();
        }
        a.dismiss();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Util.logd(PKDialog.a(), (new StringBuilder()).append("Redirect URL: ").append(s).toString());
        if (s.startsWith(ServerSetting.getInstance().getEnvUrl((Context)PKDialog.b().get(), "auth://tauth.qq.com/")))
        {
            PKDialog.b(a).onComplete(Util.parseUrlToJson(s));
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://cancel"))
        {
            PKDialog.b(a).onCancel();
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://close"))
        {
            a.dismiss();
            return true;
        } else
        {
            return false;
        }
    }
}
