// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

// Referenced classes of package com.tencent.open:
//            TaskGuide

class s
    implements Runnable
{

    final TaskGuide a;

    s(TaskGuide taskguide)
    {
        a = taskguide;
        super();
    }

    public void run()
    {
        TaskGuide.a(a, TaskGuide.a(a, TaskGuide.f(a)));
        TaskGuide.a(a, TaskGuide.b(a, TaskGuide.g(a)));
        TaskGuide.h(a);
        WindowManager windowmanager = (WindowManager)TaskGuide.i(a).getSystemService("window");
        if (((Activity)TaskGuide.j(a)).isFinishing())
        {
            return;
        }
        if (!TaskGuide.a(a))
        {
            windowmanager.addView(TaskGuide.b(a), TaskGuide.k(a));
        }
        TaskGuide.a(a, true);
        TaskGuide.c(a, 2);
        TaskGuide.l(a);
    }
}
