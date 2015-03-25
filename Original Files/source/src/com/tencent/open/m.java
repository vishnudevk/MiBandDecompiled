// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

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

// Referenced classes of package com.tencent.open:
//            TDialog, o, l

class m extends WebViewClient
{

    final TDialog a;

    private m(TDialog tdialog)
    {
        a = tdialog;
        super();
    }

    m(TDialog tdialog, l l)
    {
        this(tdialog);
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (TDialog.b() != null && TDialog.b().get() != null)
        {
            ((View)TDialog.b().get()).setVisibility(8);
        }
        TDialog.c(a).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Util.logd("TDialog", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
        if (TDialog.b() != null && TDialog.b().get() != null)
        {
            ((View)TDialog.b().get()).setVisibility(0);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        TDialog.b(a).onError(new UiError(i, s, s1));
        if (TDialog.a() != null && TDialog.a().get() != null)
        {
            Toast.makeText((Context)TDialog.a().get(), "\u7F51\u7EDC\u8FDE\u63A5\u5F02\u5E38\u6216\u7CFB\u7EDF\u9519\u8BEF", 0).show();
        }
        a.dismiss();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Util.logd("TDialog", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
        if (s.startsWith(ServerSetting.getInstance().getEnvUrl((Context)TDialog.a().get(), "auth://tauth.qq.com/")))
        {
            TDialog.b(a).onComplete(Util.parseUrlToJson(s));
            if (a.isShowing())
            {
                a.dismiss();
            }
            return true;
        }
        if (s.startsWith("auth://cancel"))
        {
            TDialog.b(a).onCancel();
            if (a.isShowing())
            {
                a.dismiss();
            }
            return true;
        }
        if (s.startsWith("auth://close"))
        {
            if (a.isShowing())
            {
                a.dismiss();
            }
            return true;
        }
        if (s.startsWith("download://"))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(s.substring("download://".length()))));
            if (TDialog.a() != null && TDialog.a().get() != null)
            {
                ((Context)TDialog.a().get()).startActivity(intent);
            }
            return true;
        } else
        {
            return false;
        }
    }
}
