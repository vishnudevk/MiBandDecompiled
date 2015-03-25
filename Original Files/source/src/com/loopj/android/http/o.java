// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            m, BaseJsonHttpResponseHandler

class o
    implements Runnable
{

    final m a;

    o(m m1)
    {
        a = m1;
        super();
    }

    public void run()
    {
        a.e.onFailure(a.b, a.c, a.d, a.a, null);
    }
}
