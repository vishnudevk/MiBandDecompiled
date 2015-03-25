// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.util;

import android.graphics.Rect;

public class AspectRatioUtil
{

    public AspectRatioUtil()
    {
    }

    public static float calculateAspectRatio(float f, float f1, float f2, float f3)
    {
        return (f2 - f) / (f3 - f1);
    }

    public static float calculateAspectRatio(Rect rect)
    {
        return (float)rect.width() / (float)rect.height();
    }

    public static float calculateBottom(float f, float f1, float f2, float f3)
    {
        return f1 + (f2 - f) / f3;
    }

    public static float calculateHeight(float f, float f1, float f2)
    {
        return (f1 - f) / f2;
    }

    public static float calculateLeft(float f, float f1, float f2, float f3)
    {
        return f1 - f3 * (f2 - f);
    }

    public static float calculateRight(float f, float f1, float f2, float f3)
    {
        return f + f3 * (f2 - f1);
    }

    public static float calculateTop(float f, float f1, float f2, float f3)
    {
        return f2 - (f1 - f) / f3;
    }

    public static float calculateWidth(float f, float f1, float f2)
    {
        return f2 * (f1 - f);
    }
}
