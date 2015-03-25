// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

public class ImageViewUtil
{

    public ImageViewUtil()
    {
    }

    private static Rect a(int i, int j, int k, int l)
    {
        double d = (1.0D / 0.0D);
        double d1 = (1.0D / 0.0D);
        if (k < i)
        {
            d = (double)k / (double)i;
        }
        if (l < j)
        {
            d1 = (double)l / (double)j;
        }
        double d3;
        double d4;
        int i1;
        int j1;
        if (d != (1.0D / 0.0D) || d1 != (1.0D / 0.0D))
        {
            if (d <= d1)
            {
                double d5 = k;
                double d6 = (d5 * (double)j) / (double)i;
                d3 = d5;
                d4 = d6;
            } else
            {
                double d2 = l;
                d3 = (d2 * (double)i) / (double)j;
                d4 = d2;
            }
        } else
        {
            double d7 = j;
            d3 = i;
            d4 = d7;
        }
        if (d3 == (double)k)
        {
            i1 = 0;
            j1 = (int)Math.round(((double)l - d4) / 2D);
        } else
        if (d4 == (double)l)
        {
            i1 = (int)Math.round(((double)k - d3) / 2D);
            j1 = 0;
        } else
        {
            i1 = (int)Math.round(((double)k - d3) / 2D);
            j1 = (int)Math.round(((double)l - d4) / 2D);
        }
        return new Rect(i1, j1, i1 + (int)Math.ceil(d3), j1 + (int)Math.ceil(d4));
    }

    public static Rect getBitmapRectCenterInside(int i, int j, int k, int l)
    {
        return a(i, j, k, l);
    }

    public static Rect getBitmapRectCenterInside(Bitmap bitmap, View view)
    {
        return a(bitmap.getWidth(), bitmap.getHeight(), view.getWidth(), view.getHeight());
    }
}
