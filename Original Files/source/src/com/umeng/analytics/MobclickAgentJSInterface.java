// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.umeng.analytics:
//            k

public class MobclickAgentJSInterface
{

    private Context a;

    public MobclickAgentJSInterface(Context context, WebView webview)
    {
        a = context;
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new k(this, null));
    }

    public MobclickAgentJSInterface(Context context, WebView webview, WebChromeClient webchromeclient)
    {
        a = context;
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new k(this, webchromeclient));
    }

    static Context a(MobclickAgentJSInterface mobclickagentjsinterface)
    {
        return mobclickagentjsinterface.a;
    }
}
