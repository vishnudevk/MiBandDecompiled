// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.compat;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.compat:
//            e, c, a

public class Compat
{

    public Compat()
    {
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            e.a(view, runnable);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c.a(view, runnable);
            return;
        } else
        {
            a.a(view, runnable);
            return;
        }
    }

    public static void postOnAnimationInvalidate(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            e.a(view);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c.a(view);
            return;
        } else
        {
            a.a(view);
            return;
        }
    }

    public static void setAlpha(View view, float f)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c.a(view, f);
            return;
        } else
        {
            a.a(view, f);
            return;
        }
    }
}
