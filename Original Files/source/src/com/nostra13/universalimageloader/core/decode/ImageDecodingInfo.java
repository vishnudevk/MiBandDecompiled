// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.decode;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class ImageDecodingInfo
{

    private final String a;
    private final String b;
    private final String c;
    private final ImageSize d;
    private final ImageScaleType e;
    private final ViewScaleType f;
    private final ImageDownloader g;
    private final Object h;
    private final boolean i;
    private final android.graphics.BitmapFactory.Options j = new android.graphics.BitmapFactory.Options();

    public ImageDecodingInfo(String s, String s1, String s2, ImageSize imagesize, ViewScaleType viewscaletype, ImageDownloader imagedownloader, DisplayImageOptions displayimageoptions)
    {
        a = s;
        b = s1;
        c = s2;
        d = imagesize;
        e = displayimageoptions.getImageScaleType();
        f = viewscaletype;
        g = imagedownloader;
        h = displayimageoptions.getExtraForDownloader();
        i = displayimageoptions.isConsiderExifParams();
        a(displayimageoptions.getDecodingOptions(), j);
    }

    private void a(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inDensity = options.inDensity;
        options1.inDither = options.inDither;
        options1.inInputShareable = options.inInputShareable;
        options1.inJustDecodeBounds = options.inJustDecodeBounds;
        options1.inPreferredConfig = options.inPreferredConfig;
        options1.inPurgeable = options.inPurgeable;
        options1.inSampleSize = options.inSampleSize;
        options1.inScaled = options.inScaled;
        options1.inScreenDensity = options.inScreenDensity;
        options1.inTargetDensity = options.inTargetDensity;
        options1.inTempStorage = options.inTempStorage;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            b(options, options1);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            c(options, options1);
        }
    }

    private void b(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    private void c(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options1)
    {
        options1.inBitmap = options.inBitmap;
        options1.inMutable = options.inMutable;
    }

    public android.graphics.BitmapFactory.Options getDecodingOptions()
    {
        return j;
    }

    public ImageDownloader getDownloader()
    {
        return g;
    }

    public Object getExtraForDownloader()
    {
        return h;
    }

    public String getImageKey()
    {
        return a;
    }

    public ImageScaleType getImageScaleType()
    {
        return e;
    }

    public String getImageUri()
    {
        return b;
    }

    public String getOriginalImageUri()
    {
        return c;
    }

    public ImageSize getTargetSize()
    {
        return d;
    }

    public ViewScaleType getViewScaleType()
    {
        return f;
    }

    public boolean shouldConsiderExifParams()
    {
        return i;
    }
}
