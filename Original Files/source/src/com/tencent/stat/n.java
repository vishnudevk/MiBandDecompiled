// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import com.tencent.stat.event.Event;

// Referenced classes of package com.tencent.stat:
//            StatStore, b

class n
    implements Runnable
{

    final Event a;
    final b b;
    final StatStore c;

    n(StatStore statstore, Event event, b b1)
    {
        c = statstore;
        a = event;
        b = b1;
        super();
    }

    public void run()
    {
        c.a(a, b);
    }
}
