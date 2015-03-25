// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

// Referenced classes of package com.nostra13.universalimageloader.core.imageaware:
//            ImageAware

public class NonViewAware
    implements ImageAware
{

    protected final ImageSize imageSize;
    protected final String imageUri;
    protected final ViewScaleType scaleType;

    public NonViewAware(ImageSize imagesize, ViewScaleType viewscaletype)
    {
        this(null, imagesize, viewscaletype);
    }

    public NonViewAware(String s, ImageSize imagesize, ViewScaleType viewscaletype)
    {
        if (imagesize == null)
        {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewscaletype == null)
        {
            throw new IllegalArgumentException("scaleType must not be null");
        } else
        {
            imageUri = s;
            imageSize = imagesize;
            scaleType = viewscaletype;
            return;
        }
    }

    public int getHeight()
    {
        return imageSize.getHeight();
    }

    public int getId()
    {
        if (TextUtils.isEmpty(imageUri))
        {
            return super.hashCode();
        } else
        {
            return imageUri.hashCode();
        }
    }

    public ViewScaleType getScaleType()
    {
        return scaleType;
    }

    public int getWidth()
    {
        return imageSize.getWidth();
    }

    public View getWrappedView()
    {
        return null;
    }

    public boolean isCollected()
    {
        return false;
    }

    public boolean setImageBitmap(Bitmap bitmap)
    {
        return true;
    }

    public boolean setImageDrawable(Drawable drawable)
    {
        return true;
    }
}
