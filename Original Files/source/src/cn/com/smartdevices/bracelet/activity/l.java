// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            WebActivity

class l extends WebChromeClient
{

    final WebActivity a;

    l(WebActivity webactivity)
    {
        a = webactivity;
        super();
    }

    public void onProgressChanged(WebView webview, int i)
    {
        WebActivity.access$000(a).setProgress(i + 5);
    }
}
