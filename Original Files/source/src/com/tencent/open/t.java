// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.view.ViewGroup;

// Referenced classes of package com.tencent.open:
//            TaskGuide, D

class t
    implements Runnable
{

    final int a;
    final TaskGuide b;

    t(TaskGuide taskguide, int i)
    {
        b = taskguide;
        a = i;
        super();
    }

    public void run()
    {
        if (TaskGuide.a(b))
        {
            if (a == 0)
            {
                ((D)TaskGuide.b(b).findViewById(1)).a(TaskGuide.c(b));
            } else
            {
                if (a == 1)
                {
                    ((D)TaskGuide.b(b).findViewById(2)).a(TaskGuide.d(b));
                    return;
                }
                if (a == 2)
                {
                    ((D)TaskGuide.b(b).findViewById(1)).a(TaskGuide.c(b));
                    if (TaskGuide.b(b).getChildCount() > 1)
                    {
                        ((D)TaskGuide.b(b).findViewById(2)).a(TaskGuide.d(b));
                        return;
                    }
                }
            }
        }
    }
}
