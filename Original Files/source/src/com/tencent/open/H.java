// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.tencent.open:
//            d

class H extends WebChromeClient
{

    final d a;

    H(d d1)
    {
        a = d1;
        super();
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        Log.i("WebConsole", (new StringBuilder()).append(s).append(" -- From 222 line ").append(i).append(" of ").append(s1).toString());
        if (android.os.Build.VERSION.SDK_INT == 7)
        {
            a.onConsoleMessage(s);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        Log.i("WebConsole", (new StringBuilder()).append(consolemessage.message()).append(" -- From  111 line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
        if (android.os.Build.VERSION.SDK_INT > 7)
        {
            d d1 = a;
            String s;
            if (consolemessage == null)
            {
                s = "";
            } else
            {
                s = consolemessage.message();
            }
            d1.onConsoleMessage(s);
        }
        return true;
    }
}
