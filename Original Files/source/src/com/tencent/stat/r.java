// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import java.util.List;

// Referenced classes of package com.tencent.stat:
//            b, q, StatStore

class r
    implements b
{

    final List a;
    final int b;
    final q c;

    r(q q1, List list, int i)
    {
        c = q1;
        a = list;
        b = i;
        super();
    }

    public void a()
    {
        c.b.a(a);
        int i;
        if (c.a == -1)
        {
            i = c.a;
        } else
        {
            i = c.a - a.size();
        }
        if (i == -1 || i > 0)
        {
            c.b.a(i);
        }
    }

    public void b()
    {
        StatStore statstore = c.b;
        statstore.b = statstore.b + b;
        c.b.a(a, 1);
    }
}
