// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;


// Referenced classes of package com.tencent.open:
//            z, u, TaskGuide

class v
    implements Runnable
{

    final Exception a;
    final u b;

    v(u u1, Exception exception)
    {
        b = u1;
        a = exception;
        super();
    }

    public void run()
    {
        z _tmp = z.a;
        z z1;
        if (b.a == 0)
        {
            z1 = TaskGuide.c(b.b);
        } else
        {
            z1 = TaskGuide.d(b.b);
        }
        if (z1 == z.c)
        {
            TaskGuide.a(b.b, b.a, z.d);
            TaskGuide.a(b.b, (new StringBuilder()).append("\u9886\u53D6\u5931\u8D25 :").append(a.getClass().getName()).toString());
        }
        TaskGuide.c(b.b, b.a);
        TaskGuide.e(b.b, 2000);
    }
}
