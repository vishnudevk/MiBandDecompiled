// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler, q, r

class p
    implements Runnable
{

    final byte a[];
    final int b;
    final Header c[];
    final JsonHttpResponseHandler d;

    p(JsonHttpResponseHandler jsonhttpresponsehandler, byte abyte0[], int i, Header aheader[])
    {
        d = jsonhttpresponsehandler;
        a = abyte0;
        b = i;
        c = aheader;
        super();
    }

    public void run()
    {
        try
        {
            Object obj = d.parseResponse(a);
            d.postRunnable(new q(this, obj));
            return;
        }
        catch (JSONException jsonexception)
        {
            d.postRunnable(new r(this, jsonexception));
        }
    }
}
