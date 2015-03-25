// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            j, i

public class PersonInfoFinishedActivity extends SystemBarTintActivity
{

    private static Handler a = new Handler();

    public PersonInfoFinishedActivity()
    {
    }

    private void a()
    {
        WebView webview = (WebView)findViewById(0x7f0a0174);
        WebSettings websettings = webview.getSettings();
        websettings.setUseWideViewPort(true);
        websettings.setLoadWithOverviewMode(true);
        webview.setLayerType(1, null);
        webview.loadUrl("file:///android_asset/set_finish.gif");
        a.postDelayed(new j(this, webview), 1000L);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030053);
        ((Button)findViewById(0x7f0a0176)).setOnClickListener(new i(this));
        a();
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideFinish");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideFinish");
        UmengAnalytics.startSession(this);
    }

}
