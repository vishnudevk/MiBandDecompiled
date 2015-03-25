// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            e, d

public class ViewCompat
{

    public ViewCompat()
    {
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            e.a(view, runnable);
            return;
        } else
        {
            view.postDelayed(runnable, 16L);
            return;
        }
    }

    public static void setBackground(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            e.a(view, drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void setLayerType(View view, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            d.a(view, i);
        }
    }
}
