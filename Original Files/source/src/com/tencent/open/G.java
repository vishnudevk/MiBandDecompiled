// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;


// Referenced classes of package com.tencent.open:
//            TaskGuide, t

class G
    implements Runnable
{

    final TaskGuide a;

    private G(TaskGuide taskguide)
    {
        a = taskguide;
        super();
    }

    G(TaskGuide taskguide, t t)
    {
        this(taskguide);
    }

    public void run()
    {
        TaskGuide.q(a);
    }
}
