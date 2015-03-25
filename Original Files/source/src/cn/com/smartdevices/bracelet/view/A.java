// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.view.animation.Interpolator;

final class A
    implements Interpolator
{

    A()
    {
    }

    public float getInterpolation(float f)
    {
        float f1 = f - 1.0F;
        return 1.0F + f1 * (f1 * (f1 * (f1 * f1)));
    }
}
