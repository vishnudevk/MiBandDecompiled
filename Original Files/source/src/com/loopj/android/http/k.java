// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            j, BaseJsonHttpResponseHandler

class k
    implements Runnable
{

    final Object a;
    final j b;

    k(j j1, Object obj)
    {
        b = j1;
        a = obj;
        super();
    }

    public void run()
    {
        b.d.onSuccess(b.b, b.c, b.a, a);
    }
}
