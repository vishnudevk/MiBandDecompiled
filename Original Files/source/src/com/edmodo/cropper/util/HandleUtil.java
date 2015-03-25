// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.util.TypedValue;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.handle.Handle;

// Referenced classes of package com.edmodo.cropper.util:
//            a

public class HandleUtil
{

    private static final int a = 24;

    public HandleUtil()
    {
    }

    private static boolean a()
    {
        return !CropOverlayView.showGuidelines();
    }

    private static boolean a(float f, float f1, float f2, float f3, float f4)
    {
        return Math.abs(f - f2) <= f4 && Math.abs(f1 - f3) <= f4;
    }

    private static boolean a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return f > f2 && f < f3 && Math.abs(f1 - f4) <= f5;
    }

    private static boolean b(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return Math.abs(f - f2) <= f5 && f1 > f3 && f1 < f4;
    }

    private static boolean c(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return f > f2 && f < f4 && f1 > f3 && f1 < f5;
    }

    public static Pair getOffset(Handle handle, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6;
        f6 = 0.0F;
        if (handle == null)
        {
            return null;
        }
        a.a[handle.ordinal()];
        JVM INSTR tableswitch 1 9: default 68
    //                   1 89
    //                   2 103
    //                   3 118
    //                   4 132
    //                   5 147
    //                   6 158
    //                   7 170
    //                   8 182
    //                   9 194;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        float f9 = 0.0F;
_L12:
        return new Pair(Float.valueOf(f9), Float.valueOf(f6));
_L2:
        f9 = f2 - f;
        f6 = f3 - f1;
        continue; /* Loop/switch isn't completed */
_L3:
        f9 = f4 - f;
        f6 = f3 - f1;
        continue; /* Loop/switch isn't completed */
_L4:
        f9 = f2 - f;
        f6 = f5 - f1;
        continue; /* Loop/switch isn't completed */
_L5:
        f9 = f4 - f;
        f6 = f5 - f1;
        continue; /* Loop/switch isn't completed */
_L6:
        f9 = f2 - f;
        f6 = 0.0F;
        continue; /* Loop/switch isn't completed */
_L7:
        f6 = f3 - f1;
        f9 = 0.0F;
        continue; /* Loop/switch isn't completed */
_L8:
        f9 = f4 - f;
        f6 = 0.0F;
        continue; /* Loop/switch isn't completed */
_L9:
        f6 = f5 - f1;
        f9 = 0.0F;
        continue; /* Loop/switch isn't completed */
_L10:
        float f7 = (f4 + f2) / 2.0F;
        float f8 = (f3 + f5) / 2.0F;
        f9 = f7 - f;
        f6 = f8 - f1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static Handle getPressedHandle(float f, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        if (a(f, f1, f2, f3, f6))
        {
            return Handle.TOP_LEFT;
        }
        if (a(f, f1, f4, f3, f6))
        {
            return Handle.TOP_RIGHT;
        }
        if (a(f, f1, f2, f5, f6))
        {
            return Handle.BOTTOM_LEFT;
        }
        if (a(f, f1, f4, f5, f6))
        {
            return Handle.BOTTOM_RIGHT;
        }
        if (c(f, f1, f2, f3, f4, f5) && a())
        {
            return Handle.CENTER;
        }
        if (a(f, f1, f2, f4, f3, f6))
        {
            return Handle.TOP;
        }
        if (a(f, f1, f2, f4, f5, f6))
        {
            return Handle.BOTTOM;
        }
        if (b(f, f1, f2, f3, f5, f6))
        {
            return Handle.LEFT;
        }
        if (b(f, f1, f4, f3, f5, f6))
        {
            return Handle.RIGHT;
        }
        if (c(f, f1, f2, f3, f4, f5) && !a())
        {
            return Handle.CENTER;
        } else
        {
            return null;
        }
    }

    public static float getTargetRadius(Context context)
    {
        return TypedValue.applyDimension(1, 24F, context.getResources().getDisplayMetrics());
    }
}
