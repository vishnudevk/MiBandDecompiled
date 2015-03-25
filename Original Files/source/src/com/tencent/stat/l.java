// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import java.util.List;

// Referenced classes of package com.tencent.stat:
//            StatStore

class l
    implements Runnable
{

    final List a;
    final int b;
    final StatStore c;

    l(StatStore statstore, List list, int i)
    {
        c = statstore;
        a = list;
        b = i;
        super();
    }

    public void run()
    {
        StatStore.a(c, a, b);
    }
}
