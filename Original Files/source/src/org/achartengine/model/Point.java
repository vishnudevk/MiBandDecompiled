// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.io.Serializable;

public final class Point
    implements Serializable
{

    private float a;
    private float b;

    public Point()
    {
    }

    public Point(float f, float f1)
    {
        a = f;
        b = f1;
    }

    public float getX()
    {
        return a;
    }

    public float getY()
    {
        return b;
    }

    public void setX(float f)
    {
        a = f;
    }

    public void setY(float f)
    {
        b = f;
    }
}
