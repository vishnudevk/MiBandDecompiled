// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public class ImageSize
{

    private static final int a = 9;
    private static final String b = "x";
    private final int c;
    private final int d;

    public ImageSize(int i, int j)
    {
        c = i;
        d = j;
    }

    public ImageSize(int i, int j, int k)
    {
        if (k % 180 == 0)
        {
            c = i;
            d = j;
            return;
        } else
        {
            c = j;
            d = i;
            return;
        }
    }

    public int getHeight()
    {
        return d;
    }

    public int getWidth()
    {
        return c;
    }

    public ImageSize scale(float f)
    {
        return new ImageSize((int)(f * (float)c), (int)(f * (float)d));
    }

    public ImageSize scaleDown(int i)
    {
        return new ImageSize(c / i, d / i);
    }

    public String toString()
    {
        return (new StringBuilder(9)).append(c).append("x").append(d).toString();
    }
}
