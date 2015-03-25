// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class e extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private Drawable a;
    private float b;
    private float c;
    private final Rect d = new Rect();

    public e(Drawable drawable)
    {
        a = drawable;
    }

    public float a()
    {
        return b;
    }

    public void a(float f)
    {
        b = f;
        invalidateSelf();
    }

    public void b(float f)
    {
        c = f;
        invalidateSelf();
    }

    public void clearColorFilter()
    {
        a.clearColorFilter();
    }

    public void draw(Canvas canvas)
    {
        a.copyBounds(d);
        canvas.save();
        canvas.translate(c * (float)d.width() * -b, 0.0F);
        a.draw(canvas);
        canvas.restore();
    }

    public int getChangingConfigurations()
    {
        return a.getChangingConfigurations();
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return super.getConstantState();
    }

    public Drawable getCurrent()
    {
        return a.getCurrent();
    }

    public int getIntrinsicHeight()
    {
        return a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return a.getIntrinsicWidth();
    }

    public int getMinimumHeight()
    {
        return a.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return a.getMinimumWidth();
    }

    public int getOpacity()
    {
        return a.getOpacity();
    }

    public boolean getPadding(Rect rect)
    {
        return a.getPadding(rect);
    }

    public int[] getState()
    {
        return a.getState();
    }

    public Region getTransparentRegion()
    {
        return a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (drawable == a)
        {
            invalidateSelf();
        }
    }

    public boolean isStateful()
    {
        return a.isStateful();
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        a.setBounds(rect);
    }

    protected boolean onStateChange(int ai[])
    {
        a.setState(ai);
        return super.onStateChange(ai);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (drawable == a)
        {
            scheduleSelf(runnable, l);
        }
    }

    public void setAlpha(int i)
    {
        a.setAlpha(i);
    }

    public void setChangingConfigurations(int i)
    {
        a.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, android.graphics.PorterDuff.Mode mode)
    {
        a.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        a.setColorFilter(colorfilter);
    }

    public void setDither(boolean flag)
    {
        a.setDither(flag);
    }

    public void setFilterBitmap(boolean flag)
    {
        a.setFilterBitmap(flag);
    }

    public boolean setState(int ai[])
    {
        return a.setState(ai);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (drawable == a)
        {
            unscheduleSelf(runnable);
        }
    }
}
