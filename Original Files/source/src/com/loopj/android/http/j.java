// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler, k, l

class j
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final BaseJsonHttpResponseHandler d;

    j(BaseJsonHttpResponseHandler basejsonhttpresponsehandler, String s, int i, Header aheader[])
    {
        d = basejsonhttpresponsehandler;
        a = s;
        b = i;
        c = aheader;
        super();
    }

    public void run()
    {
        try
        {
            Object obj = d.parseResponse(a, false);
            d.postRunnable(new k(this, obj));
            return;
        }
        catch (Throwable throwable)
        {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable);
            d.postRunnable(new l(this, throwable));
            return;
        }
    }
}
