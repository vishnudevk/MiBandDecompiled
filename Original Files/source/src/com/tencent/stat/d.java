// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.tencent.stat:
//            c

class d extends DefaultConnectionKeepAliveStrategy
{

    final c a;

    d(c c)
    {
        a = c;
        super();
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        long l = super.getKeepAliveDuration(httpresponse, httpcontext);
        if (l == -1L)
        {
            l = 20000L;
        }
        return l;
    }
}
