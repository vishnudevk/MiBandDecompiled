// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class c
{

    WeakReference a;
    long b;
    String c;

    public void a()
    {
        WebView webview = (WebView)a.get();
        if (webview == null)
        {
            return;
        } else
        {
            webview.loadUrl((new StringBuilder()).append("javascript:window.JsBridge&&JsBridge.callback(").append(b).append(",{'r':1,'result':'no such method'})").toString());
            return;
        }
    }

    public void a(Object obj)
    {
        WebView webview;
        String s;
        webview = (WebView)a.get();
        if (webview == null)
        {
            return;
        }
        s = "'undefined'";
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        String s1 = ((String)obj).replace("\\", "\\\\").replace("'", "\\'");
        s = (new StringBuilder()).append("'").append(s1).append("'").toString();
_L4:
        webview.loadUrl((new StringBuilder()).append("javascript:window.JsBridge&&JsBridge.callback(").append(b).append(",{'r':0,'result':").append(s).append("});").toString());
        return;
_L2:
        if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float))
        {
            s = obj.toString();
        } else
        if (obj instanceof Boolean)
        {
            s = obj.toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(String s)
    {
        WebView webview = (WebView)a.get();
        if (webview != null)
        {
            webview.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    public w(WebView webview, long l, String s)
    {
        a = new WeakReference(webview);
        b = l;
        c = s;
    }
}
