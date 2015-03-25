// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.compat;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.compat:
//            b

class a
{

    a()
    {
    }

    static void a(View view)
    {
        view.postDelayed(new b(view), 10L);
    }

    static void a(View view, float f)
    {
    }

    static void a(View view, Runnable runnable)
    {
        view.postDelayed(runnable, 10L);
    }
}
