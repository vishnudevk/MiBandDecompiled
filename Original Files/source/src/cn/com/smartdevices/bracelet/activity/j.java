// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            PersonInfoFinishedActivity

class j
    implements Runnable
{

    final WebView a;
    final PersonInfoFinishedActivity b;

    j(PersonInfoFinishedActivity personinfofinishedactivity, WebView webview)
    {
        b = personinfofinishedactivity;
        a = webview;
        super();
    }

    public void run()
    {
        b.findViewById(0x7f0a0097).setVisibility(4);
        a.setVisibility(0);
    }
}
