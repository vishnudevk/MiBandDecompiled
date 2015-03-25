// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;


// Referenced classes of package com.tencent.stat:
//            b, StatStore, h

class i
    implements b
{

    final h a;

    i(h h1)
    {
        a = h1;
        super();
    }

    public void a()
    {
        StatStore.getInstance().a(-1);
    }

    public void b()
    {
        StatStore.getInstance().b(h.a(a), null);
    }
}
