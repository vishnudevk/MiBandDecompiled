// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


// Referenced classes of package com.tencent.stat:
//            b, StatStore, StatConfig, h

class j
    implements b
{

    final h a;

    j(h h)
    {
        a = h;
        super();
    }

    public void a()
    {
        if (StatStore.getInstance().getNumStoredEvents() >= StatConfig.getMaxBatchReportCount())
        {
            StatStore.getInstance().a(StatConfig.getMaxBatchReportCount());
        }
    }

    public void b()
    {
    }
}
