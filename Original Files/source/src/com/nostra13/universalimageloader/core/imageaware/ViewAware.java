// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

// Referenced classes of package com.nostra13.universalimageloader.core.imageaware:
//            ImageAware

public abstract class ViewAware
    implements ImageAware
{

    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    protected boolean checkActualViewSize;
    protected Reference viewRef;

    public ViewAware(View view)
    {
        this(view, true);
    }

    public ViewAware(View view, boolean flag)
    {
        if (view == null)
        {
            throw new IllegalArgumentException("view must not be null");
        } else
        {
            viewRef = new WeakReference(view);
            checkActualViewSize = flag;
            return;
        }
    }

    public int getHeight()
    {
        View view = (View)viewRef.get();
        if (view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            int i;
            if (checkActualViewSize && layoutparams != null && layoutparams.height != -2)
            {
                i = view.getHeight();
            } else
            {
                i = 0;
            }
            if (i <= 0 && layoutparams != null)
            {
                i = layoutparams.height;
            }
            return i;
        } else
        {
            return 0;
        }
    }

    public int getId()
    {
        View view = (View)viewRef.get();
        if (view == null)
        {
            return super.hashCode();
        } else
        {
            return view.hashCode();
        }
    }

    public ViewScaleType getScaleType()
    {
        return ViewScaleType.CROP;
    }

    public int getWidth()
    {
        View view = (View)viewRef.get();
        if (view != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            int i;
            if (checkActualViewSize && layoutparams != null && layoutparams.width != -2)
            {
                i = view.getWidth();
            } else
            {
                i = 0;
            }
            if (i <= 0 && layoutparams != null)
            {
                i = layoutparams.width;
            }
            return i;
        } else
        {
            return 0;
        }
    }

    public View getWrappedView()
    {
        return (View)viewRef.get();
    }

    public boolean isCollected()
    {
        return viewRef.get() == null;
    }

    public boolean setImageBitmap(Bitmap bitmap)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            View view = (View)viewRef.get();
            if (view != null)
            {
                setImageBitmapInto(bitmap, view);
                return true;
            }
        } else
        {
            L.w("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    protected abstract void setImageBitmapInto(Bitmap bitmap, View view);

    public boolean setImageDrawable(Drawable drawable)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            View view = (View)viewRef.get();
            if (view != null)
            {
                setImageDrawableInto(drawable, view);
                return true;
            }
        } else
        {
            L.w("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    protected abstract void setImageDrawableInto(Drawable drawable, View view);
}
