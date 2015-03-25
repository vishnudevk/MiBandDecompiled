// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            j, BaseJsonHttpResponseHandler

class l
    implements Runnable
{

    final Throwable a;
    final j b;

    l(j j1, Throwable throwable)
    {
        b = j1;
        a = throwable;
        super();
    }

    public void run()
    {
        b.d.onFailure(b.b, b.c, a, b.a, null);
    }
}
