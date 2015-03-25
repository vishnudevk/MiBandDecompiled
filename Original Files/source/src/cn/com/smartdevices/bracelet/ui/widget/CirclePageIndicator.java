// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.widget:
//            PageIndicator

public class CirclePageIndicator extends View
    implements PageIndicator
{

    private static final int a = -1;
    private float b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private ViewPager f;
    private android.support.v4.view.ViewPager.OnPageChangeListener g;
    private int h;
    private int i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private float o;
    private int p;
    private float q;
    private int r;
    private boolean s;

    public CirclePageIndicator(Context context)
    {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010061);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        c = new Paint(1);
        d = new Paint(1);
        e = new Paint(1);
        q = -1F;
        r = -1;
        if (isInEditMode())
        {
            return;
        }
        Resources resources = getResources();
        int j1 = resources.getColor(0x7f09001a);
        int k1 = resources.getColor(0x7f090019);
        int l1 = resources.getInteger(0x7f0c0000);
        int i2 = resources.getColor(0x7f09001b);
        float f1 = resources.getDimension(0x7f0b0012);
        float f2 = resources.getDimension(0x7f0b0011);
        boolean flag = resources.getBoolean(0x7f080000);
        boolean flag1 = resources.getBoolean(0x7f080001);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.CirclePageIndicator, i1, 0);
        m = typedarray.getBoolean(2, flag);
        l = typedarray.getInt(0, l1);
        c.setStyle(android.graphics.Paint.Style.FILL);
        c.setColor(typedarray.getColor(5, j1));
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setColor(typedarray.getColor(8, i2));
        d.setStrokeWidth(typedarray.getDimension(3, f1));
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setColor(typedarray.getColor(4, k1));
        b = typedarray.getDimension(6, f2);
        n = typedarray.getBoolean(7, flag1);
        o = typedarray.getDimension(9, 12F);
        android.graphics.drawable.Drawable drawable = typedarray.getDrawable(1);
        if (drawable != null)
        {
            setBackgroundDrawable(drawable);
        }
        typedarray.recycle();
        p = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int a(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        int l1;
        if (j1 == 0x40000000 || f == null)
        {
            l1 = k1;
        } else
        {
            int i2 = getCount();
            l1 = (int)(1.0F + ((float)(getPaddingLeft() + getPaddingRight()) + (float)(i2 * 2) * b + (float)(i2 - 1) * o));
            if (j1 == 0x80000000)
            {
                return Math.min(l1, k1);
            }
        }
        return l1;
    }

    private int b(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        if (j1 == 0x40000000)
        {
            return k1;
        }
        int l1 = (int)(1.0F + (2.0F * b + (float)getPaddingTop() + (float)getPaddingBottom()));
        if (j1 == 0x80000000)
        {
            return Math.min(l1, k1);
        } else
        {
            return l1;
        }
    }

    public int getCount()
    {
        if (f == null)
        {
            return 0;
        } else
        {
            return f.getAdapter().getCount();
        }
    }

    public int getFillColor()
    {
        return e.getColor();
    }

    public int getOffset()
    {
        return 0;
    }

    public int getOrientation()
    {
        return l;
    }

    public int getPageColor()
    {
        return c.getColor();
    }

    public float getRadius()
    {
        return b;
    }

    public int getStrokeColor()
    {
        return d.getColor();
    }

    public float getStrokeWidth()
    {
        return d.getStrokeWidth();
    }

    public ViewPager getViewPager()
    {
        return f;
    }

    public boolean isCentered()
    {
        return m;
    }

    public boolean isSnap()
    {
        return n;
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (f != null)
        {
            if ((i1 = getCount()) != 0)
            {
                if (h < 0)
                {
                    setCurrentItem(0);
                }
                if (h >= i1)
                {
                    setCurrentItem(i1 - 1);
                    return;
                }
                int j1;
                int k1;
                int l1;
                int i2;
                float f1;
                float f2;
                float f3;
                int j2;
                int k2;
                if (l == 0)
                {
                    j1 = getWidth();
                    k1 = getPaddingLeft();
                    l1 = getPaddingRight();
                    i2 = getPaddingTop();
                } else
                {
                    j1 = getHeight();
                    k1 = getPaddingTop();
                    l1 = getPaddingBottom();
                    i2 = getPaddingLeft();
                }
                f1 = (float)i2 + b;
                f2 = (float)k1 + b;
                if (m)
                {
                    int i3 = (int)(1.0F + ((float)(i1 * 2) * b + (float)(i1 - 1) * o));
                    f2 += (float)(j1 - k1 - l1 - i3) / 2.0F;
                }
                f3 = b;
                j2 = d.getStrokeWidth() != 0.0F;
                k2 = 0;
                if (j2 > 0)
                {
                    f3 -= d.getStrokeWidth() / 2.0F;
                }
                while (k2 < i1) 
                {
                    float f7 = f2 + (float)k2 * (o + 2.0F * b);
                    float f8;
                    if (l == 0)
                    {
                        f8 = f7;
                        f7 = f1;
                    } else
                    {
                        f8 = f1;
                    }
                    if (c.getAlpha() > 0)
                    {
                        canvas.drawCircle(f8, f7, f3, c);
                    }
                    if (f3 != b)
                    {
                        canvas.drawCircle(f8, f7, b, d);
                    }
                    k2++;
                }
                int l2;
                float f4;
                float f6;
                if (n)
                {
                    l2 = i;
                } else
                {
                    l2 = h;
                }
                f4 = (float)l2 * (o + 2.0F * b);
                if (!n)
                {
                    f4 += j * (o + 2.0F * b);
                }
                if (l == 0)
                {
                    f6 = f2 + f4;
                } else
                {
                    float f5 = f2 + f4;
                    f6 = f1;
                    f1 = f5;
                }
                canvas.drawCircle(f6, f1, b, e);
                return;
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        if (l == 0)
        {
            setMeasuredDimension(a(i1), b(j1));
            return;
        } else
        {
            setMeasuredDimension(b(i1), a(j1));
            return;
        }
    }

    public void onPageScrollStateChanged(int i1)
    {
        k = i1;
        if (g != null)
        {
            g.onPageScrollStateChanged(i1);
        }
    }

    public void onPageScrolled(int i1, float f1, int j1)
    {
        h = i1 - getOffset();
        j = f1;
        invalidate();
        if (g != null)
        {
            g.onPageScrolled(i1, f1, j1);
        }
    }

    public void onPageSelected(int i1)
    {
        if (n || k == 0)
        {
            h = i1 - getOffset();
            i = i1 - getOffset();
            invalidate();
        }
        if (g != null)
        {
            g.onPageSelected(i1);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        h = savedstate.a;
        i = savedstate.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = h;
        return savedstate;
    }

    public void setCentered(boolean flag)
    {
        m = flag;
        invalidate();
    }

    public void setCurrentItem(int i1)
    {
        if (f == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            f.setCurrentItem(i1 + getOffset());
            h = i1;
            invalidate();
            return;
        }
    }

    public void setFillColor(int i1)
    {
        e.setColor(i1);
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        g = onpagechangelistener;
    }

    public void setOrientation(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");

        case 0: // '\0'
        case 1: // '\001'
            l = i1;
            break;
        }
        requestLayout();
    }

    public void setPageColor(int i1)
    {
        c.setColor(i1);
        invalidate();
    }

    public void setRadius(float f1)
    {
        b = f1;
        invalidate();
    }

    public void setSnap(boolean flag)
    {
        n = flag;
        invalidate();
    }

    public void setStrokeColor(int i1)
    {
        d.setColor(i1);
        invalidate();
    }

    public void setStrokeWidth(float f1)
    {
        d.setStrokeWidth(f1);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (f == viewpager)
        {
            return;
        }
        if (f != null)
        {
            f.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            f = viewpager;
            f.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i1)
    {
        setViewPager(viewpager);
        setCurrentItem(i1);
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new b();
        int a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
        }

        SavedState(Parcel parcel, a a1)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
