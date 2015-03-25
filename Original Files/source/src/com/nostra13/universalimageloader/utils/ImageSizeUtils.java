// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            a

public final class ImageSizeUtils
{

    private static final int a = 2048;
    private static ImageSize b;

    private ImageSizeUtils()
    {
    }

    public static int computeImageSampleSize(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        i = imagesize.getWidth();
        j = imagesize.getHeight();
        k = imagesize1.getWidth();
        l = imagesize1.getHeight();
        i1 = i / k;
        j1 = j / l;
        a.a[viewscaletype.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 79
    //                   2 145;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_145;
_L1:
        int k1 = 1;
_L4:
        if (k1 < 1)
        {
            return 1;
        } else
        {
            return k1;
        }
_L2:
        if (flag)
        {
            int j2 = i;
            int k2 = j;
            k1 = 1;
            while (j2 / 2 >= k || k2 / 2 >= l) 
            {
                j2 /= 2;
                k2 /= 2;
                k1 *= 2;
            }
        } else
        {
            k1 = Math.max(i1, j1);
        }
          goto _L4
        if (flag)
        {
            int l1 = i;
            int i2 = j;
            k1 = 1;
            while (l1 / 2 >= k && i2 / 2 >= l) 
            {
                l1 /= 2;
                i2 /= 2;
                k1 *= 2;
            }
        } else
        {
            k1 = Math.min(i1, j1);
        }
          goto _L4
    }

    public static float computeImageScale(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
        int i = imagesize.getWidth();
        int j = imagesize.getHeight();
        int k = imagesize1.getWidth();
        int l = imagesize1.getHeight();
        float f = (float)i / (float)k;
        float f1 = (float)j / (float)l;
        int i1;
        int j1;
        float f2;
        if (viewscaletype == ViewScaleType.FIT_INSIDE && f >= f1 || viewscaletype == ViewScaleType.CROP && f < f1)
        {
            int k1 = (int)((float)j / f);
            i1 = k;
            j1 = k1;
        } else
        {
            i1 = (int)((float)i / f1);
            j1 = l;
        }
        f2 = 1.0F;
        if (!flag && i1 < i && j1 < j || flag && i1 != i && j1 != j)
        {
            f2 = (float)i1 / (float)i;
        }
        return f2;
    }

    public static int computeMinImageSampleSize(ImageSize imagesize)
    {
        int i = imagesize.getWidth();
        int j = imagesize.getHeight();
        int k = b.getWidth();
        int l = b.getHeight();
        return Math.max((int)Math.ceil((float)i / (float)k), (int)Math.ceil((float)j / (float)l));
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageaware, ImageSize imagesize)
    {
        int i = imageaware.getWidth();
        if (i <= 0)
        {
            i = imagesize.getWidth();
        }
        int j = imageaware.getHeight();
        if (j <= 0)
        {
            j = imagesize.getHeight();
        }
        return new ImageSize(i, j);
    }

    static 
    {
        int ai[] = new int[1];
        GLES10.glGetIntegerv(3379, ai, 0);
        int i = Math.max(ai[0], 2048);
        b = new ImageSize(i, i);
    }
}
