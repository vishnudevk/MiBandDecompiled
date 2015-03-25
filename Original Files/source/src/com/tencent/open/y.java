// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;


// Referenced classes of package com.tencent.open:
//            x, z, TaskGuide

class y
    implements Runnable
{

    final x a;

    y(x x1)
    {
        a = x1;
        super();
    }

    public void run()
    {
        TaskGuide.a(a.a, 2, z.a);
    }
}
