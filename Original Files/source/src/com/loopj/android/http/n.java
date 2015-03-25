// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            m, BaseJsonHttpResponseHandler

class n
    implements Runnable
{

    final Object a;
    final m b;

    n(m m1, Object obj)
    {
        b = m1;
        a = obj;
        super();
    }

    public void run()
    {
        b.e.onFailure(b.b, b.c, b.d, b.a, a);
    }
}
