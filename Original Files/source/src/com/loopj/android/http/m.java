// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler, n, o

class m
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final Throwable d;
    final BaseJsonHttpResponseHandler e;

    m(BaseJsonHttpResponseHandler basejsonhttpresponsehandler, String s, int i, Header aheader[], Throwable throwable)
    {
        e = basejsonhttpresponsehandler;
        a = s;
        b = i;
        c = aheader;
        d = throwable;
        super();
    }

    public void run()
    {
        try
        {
            Object obj = e.parseResponse(a, true);
            e.postRunnable(new n(this, obj));
            return;
        }
        catch (Throwable throwable)
        {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable);
        }
        e.postRunnable(new o(this));
    }
}
