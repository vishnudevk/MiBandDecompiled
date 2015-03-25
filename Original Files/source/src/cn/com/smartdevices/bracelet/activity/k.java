// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            WebActivity

class k extends WebViewClient
{

    final WebActivity a;

    k(WebActivity webactivity)
    {
        a = webactivity;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        WebActivity.access$000(a).setVisibility(4);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        WebActivity.access$000(a).setVisibility(0);
        WebActivity.access$100(a).setVisibility(8);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Debug.i("WebActivity", (new StringBuilder()).append("LoadError : ").append(i).append(", ").append(s).toString());
        if (i == -2)
        {
            WebActivity.access$100(a).setVisibility(0);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview.loadUrl(s);
        return true;
    }
}
