// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import java.util.List;

// Referenced classes of package com.tencent.stat:
//            StatStore

class m
    implements Runnable
{

    final List a;
    final StatStore b;

    m(StatStore statstore, List list)
    {
        b = statstore;
        a = list;
        super();
    }

    public void run()
    {
        StatStore.a(b, a);
    }
}
