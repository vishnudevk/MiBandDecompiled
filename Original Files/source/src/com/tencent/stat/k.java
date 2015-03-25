// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


// Referenced classes of package com.tencent.stat:
//            StatStore

class k
    implements Runnable
{

    final StatStore a;

    k(StatStore statstore)
    {
        a = statstore;
        super();
    }

    public void run()
    {
        StatStore.a(a);
    }
}
