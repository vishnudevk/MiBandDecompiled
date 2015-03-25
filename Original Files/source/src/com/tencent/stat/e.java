// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import java.util.List;

// Referenced classes of package com.tencent.stat:
//            c, b

class e
    implements Runnable
{

    final List a;
    final b b;
    final c c;

    e(c c1, List list, b b1)
    {
        c = c1;
        a = list;
        b = b1;
        super();
    }

    public void run()
    {
        c.a(a, b);
    }
}
