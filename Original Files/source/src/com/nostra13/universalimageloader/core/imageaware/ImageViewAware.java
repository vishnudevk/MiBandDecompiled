// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.reflect.Field;

// Referenced classes of package com.nostra13.universalimageloader.core.imageaware:
//            ViewAware

public class ImageViewAware extends ViewAware
{

    public ImageViewAware(ImageView imageview)
    {
        super(imageview);
    }

    public ImageViewAware(ImageView imageview, boolean flag)
    {
        super(imageview, flag);
    }

    private static int a(Object obj, String s)
    {
        int i;
        Field field = android/widget/ImageView.getDeclaredField(s);
        field.setAccessible(true);
        i = ((Integer)field.get(obj)).intValue();
        if (i > 0 && i < 0x7fffffff)
        {
            return i;
        }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        L.e(exception);
        return 0;
    }

    public int getHeight()
    {
        int i = super.getHeight();
        if (i <= 0)
        {
            ImageView imageview = (ImageView)viewRef.get();
            if (imageview != null)
            {
                return a(imageview, "mMaxHeight");
            }
        }
        return i;
    }

    public ViewScaleType getScaleType()
    {
        ImageView imageview = (ImageView)viewRef.get();
        if (imageview != null)
        {
            return ViewScaleType.fromImageView(imageview);
        } else
        {
            return super.getScaleType();
        }
    }

    public int getWidth()
    {
        int i = super.getWidth();
        if (i <= 0)
        {
            ImageView imageview = (ImageView)viewRef.get();
            if (imageview != null)
            {
                return a(imageview, "mMaxWidth");
            }
        }
        return i;
    }

    public volatile View getWrappedView()
    {
        return getWrappedView();
    }

    public ImageView getWrappedView()
    {
        return (ImageView)super.getWrappedView();
    }

    protected void setImageBitmapInto(Bitmap bitmap, View view)
    {
        ((ImageView)view).setImageBitmap(bitmap);
    }

    protected void setImageDrawableInto(Drawable drawable, View view)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }
}
