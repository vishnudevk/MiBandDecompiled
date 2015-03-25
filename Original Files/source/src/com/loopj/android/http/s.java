// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler, t, u

class s
    implements Runnable
{

    final byte a[];
    final int b;
    final Header c[];
    final Throwable d;
    final JsonHttpResponseHandler e;

    s(JsonHttpResponseHandler jsonhttpresponsehandler, byte abyte0[], int i, Header aheader[], Throwable throwable)
    {
        e = jsonhttpresponsehandler;
        a = abyte0;
        b = i;
        c = aheader;
        d = throwable;
        super();
    }

    public void run()
    {
        try
        {
            Object obj = e.parseResponse(a);
            e.postRunnable(new t(this, obj));
            return;
        }
        catch (JSONException jsonexception)
        {
            e.postRunnable(new u(this, jsonexception));
        }
    }
}
