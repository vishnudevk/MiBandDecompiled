// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import java.io.Serializable;

public class BasicStroke
    implements Serializable
{

    public static final BasicStroke DASHED;
    public static final BasicStroke DOTTED;
    public static final BasicStroke SOLID;
    private android.graphics.Paint.Cap a;
    private android.graphics.Paint.Join b;
    private float c;
    private float d[];
    private float e;

    public BasicStroke(android.graphics.Paint.Cap cap, android.graphics.Paint.Join join, float f, float af[], float f1)
    {
        a = cap;
        b = join;
        c = f;
        d = af;
    }

    public android.graphics.Paint.Cap getCap()
    {
        return a;
    }

    public float[] getIntervals()
    {
        return d;
    }

    public android.graphics.Paint.Join getJoin()
    {
        return b;
    }

    public float getMiter()
    {
        return c;
    }

    public float getPhase()
    {
        return e;
    }

    static 
    {
        SOLID = new BasicStroke(android.graphics.Paint.Cap.BUTT, android.graphics.Paint.Join.MITER, 4F, null, 0.0F);
        DASHED = new BasicStroke(android.graphics.Paint.Cap.ROUND, android.graphics.Paint.Join.BEVEL, 10F, new float[] {
            10F, 10F
        }, 1.0F);
        DOTTED = new BasicStroke(android.graphics.Paint.Cap.ROUND, android.graphics.Paint.Join.BEVEL, 5F, new float[] {
            2.0F, 10F
        }, 1.0F);
    }
}
