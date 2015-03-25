// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

// Referenced classes of package com.nineoldandroids.animation:
//            h, i, j

public abstract class Keyframe
    implements Cloneable
{

    float a;
    Class b;
    boolean c;
    private Interpolator d;

    public Keyframe()
    {
        d = null;
        c = false;
    }

    public static Keyframe ofFloat(float f)
    {
        return new h(f);
    }

    public static Keyframe ofFloat(float f, float f1)
    {
        return new h(f, f1);
    }

    public static Keyframe ofInt(float f)
    {
        return new i(f);
    }

    public static Keyframe ofInt(float f, int k)
    {
        return new i(f, k);
    }

    public static Keyframe ofObject(float f)
    {
        return new j(f, null);
    }

    public static Keyframe ofObject(float f, Object obj)
    {
        return new j(f, obj);
    }

    public abstract Keyframe clone();

    public volatile Object clone()
    {
        return clone();
    }

    public float getFraction()
    {
        return a;
    }

    public Interpolator getInterpolator()
    {
        return d;
    }

    public Class getType()
    {
        return b;
    }

    public abstract Object getValue();

    public boolean hasValue()
    {
        return c;
    }

    public void setFraction(float f)
    {
        a = f;
    }

    public void setInterpolator(Interpolator interpolator)
    {
        d = interpolator;
    }

    public abstract void setValue(Object obj);
}
