// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Interpolator;

// Referenced classes of package com.tencent.open:
//            TaskGuide

class w
    implements Runnable
{

    boolean a;
    float b;
    final TaskGuide c;

    public w(TaskGuide taskguide, boolean flag)
    {
        c = taskguide;
        super();
        a = false;
        b = 0.0F;
        a = flag;
    }

    public void run()
    {
        boolean flag = true;
        SystemClock.currentThreadTimeMillis();
        b = (float)(0.10000000000000001D + (double)b);
        float f = b;
        if (f > 1.0F)
        {
            f = 1.0F;
        }
        boolean flag1;
        int i;
        if (f >= 1.0F)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        i = (int)(TaskGuide.r(c).getInterpolation(f) * (float)TaskGuide.s(c));
        if (a)
        {
            TaskGuide.k(c).y = i + TaskGuide.t(c);
        } else
        {
            TaskGuide.k(c).y = TaskGuide.t(c) - i;
        }
        Log.d("TAG", (new StringBuilder()).append("mWinParams.y = ").append(TaskGuide.k(c).y).append("deltaDistence = ").append(i).toString());
        if (TaskGuide.a(c))
        {
            TaskGuide.u(c).updateViewLayout(TaskGuide.b(c), TaskGuide.k(c));
            flag = flag1;
        }
        if (flag)
        {
            TaskGuide.v(c);
            return;
        } else
        {
            TaskGuide.x(c).postDelayed(TaskGuide.w(c), 5L);
            return;
        }
    }
}
