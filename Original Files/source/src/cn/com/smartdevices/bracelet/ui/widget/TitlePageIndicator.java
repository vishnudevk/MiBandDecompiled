// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.widget:
//            PageIndicator

public class TitlePageIndicator extends View
    implements PageIndicator
{

    private static final float a = 0.25F;
    private static final float b = 0.05F;
    private static final String c = "";
    private static final int v = -1;
    private Set A;
    private ViewPager d;
    private android.support.v4.view.ViewPager.OnPageChangeListener e;
    private int f;
    private float g;
    private int h;
    private final Paint i;
    private boolean j;
    private int k;
    private int l;
    private Path m;
    private final Rect n;
    private final Paint o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private int w;
    private float x;
    private int y;
    private boolean z;

    public TitlePageIndicator(Context context)
    {
        this(context, null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010064);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        f = -1;
        i = new Paint();
        m = new Path();
        n = new Rect();
        o = new Paint();
        x = -1F;
        y = -1;
        A = new HashSet();
        if (isInEditMode())
        {
            return;
        }
        Resources resources = getResources();
        int j1 = resources.getColor(0x7f09001c);
        float f1 = resources.getDimension(0x7f0b0014);
        float f2 = resources.getDimension(0x7f0b0017);
        int k1 = resources.getColor(0x7f09001d);
        boolean flag = resources.getBoolean(0x7f080002);
        int l1 = resources.getColor(0x7f09001e);
        float f3 = resources.getDimension(0x7f0b0018);
        float f4 = resources.getDimension(0x7f0b0019);
        float f5 = resources.getDimension(0x7f0b001a);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.TitlePageIndicator, i1, 0);
        p = typedarray.getDimension(7, f1);
        q = typedarray.getDimension(9, f2);
        u = typedarray.getDimension(12, f5);
        r = typedarray.getDimension(11, f4);
        l = typedarray.getColor(3, k1);
        k = typedarray.getColor(1, l1);
        j = typedarray.getBoolean(10, flag);
        s = typedarray.getDimension(13, 0.0F);
        t = typedarray.getDimension(14, 0.0F);
        float f6 = typedarray.getDimension(0, f3);
        int i2 = typedarray.getColor(5, j1);
        i.setTextSize(f6);
        i.setAntiAlias(true);
        o.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        o.setColor(i2);
        android.graphics.drawable.Drawable drawable = typedarray.getDrawable(2);
        if (drawable != null)
        {
            setBackground(drawable);
        }
        typedarray.recycle();
        w = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private Rect a(int i1, Paint paint)
    {
        Rect rect = new Rect();
        CharSequence charsequence = a(i1);
        rect.right = (int)paint.measureText(charsequence, 0, charsequence.length());
        rect.bottom = (int)(paint.descent() - paint.ascent());
        return rect;
    }

    private CharSequence a(int i1)
    {
        Object obj = d.getAdapter().getPageTitle(i1);
        if (obj == null)
        {
            obj = "";
        }
        return ((CharSequence) (obj));
    }

    private ArrayList a(Paint paint)
    {
        ArrayList arraylist = new ArrayList();
        int i1 = d.getAdapter().getCount();
        int j1 = (getWidth() - (int)s - (int)t) / i1;
        for (int k1 = 0; k1 < i1; k1++)
        {
            Rect rect = a(k1, paint);
            int l1 = rect.right - rect.left;
            int i2 = rect.bottom - rect.top;
            rect.left = (int)s + (j1 - l1) / 2 + k1 * j1;
            rect.right = l1 + rect.left;
            rect.top = 0;
            rect.bottom = i2;
            arraylist.add(rect);
        }

        return arraylist;
    }

    public void clearBadges()
    {
        A.clear();
    }

    public void clearBadges(Integer integer)
    {
        A.remove(integer);
    }

    public int getCount()
    {
        if (d == null)
        {
            return 0;
        } else
        {
            return d.getAdapter().getCount();
        }
    }

    public float getFooterIndicatorHeight()
    {
        return p;
    }

    public int getOffset()
    {
        return 0;
    }

    public int getSelectedColor()
    {
        return l;
    }

    public int getTextColor()
    {
        return k;
    }

    public float getTextSize()
    {
        return i.getTextSize();
    }

    public float getTitlePadding()
    {
        return r;
    }

    public float getTopPadding()
    {
        return u;
    }

    public Typeface getTypeface()
    {
        return i.getTypeface();
    }

    public boolean isSelectedBold()
    {
        return j;
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (d != null)
        {
            if ((i1 = d.getAdapter().getCount()) != 0)
            {
                if (f == -1 && d != null)
                {
                    f = d.getCurrentItem();
                }
                ArrayList arraylist = a(i);
                int j1 = arraylist.size();
                if (f >= j1)
                {
                    setCurrentItem(j1 - 1);
                    return;
                }
                int k1 = getLeft();
                int l1 = getWidth();
                int i2 = getHeight();
                int j2 = k1 + l1;
                int k2 = f;
                int i3;
                float f2;
                boolean flag;
                boolean flag1;
                float f3;
                int j3;
                int k3;
                if ((double)g <= 0.5D)
                {
                    float f7 = g;
                    i3 = k2;
                    f2 = f7;
                } else
                {
                    int l2 = k2 + 1;
                    float f1 = 1.0F - g;
                    i3 = l2;
                    f2 = f1;
                }
                if (f2 <= 0.25F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (f2 <= 0.05F)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                f3 = (0.25F - f2) / 0.25F;
                j3 = k >>> 24;
                k3 = 0;
                while (k3 < i1) 
                {
                    Rect rect = (Rect)arraylist.get(k3);
                    if ((rect.left <= k1 || rect.left >= j2) && (rect.right <= k1 || rect.right >= j2))
                    {
                        continue;
                    }
                    boolean flag2;
                    CharSequence charsequence;
                    Paint paint;
                    boolean flag3;
                    Integer integer;
                    if (k3 == i3)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    charsequence = a(k3);
                    paint = i;
                    if (flag2 && flag1 && j)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    paint.setFakeBoldText(flag3);
                    i.setColor(k);
                    if (flag2 && flag)
                    {
                        i.setAlpha(j3 - (int)(f3 * (float)j3));
                    }
                    if (k3 < j1 - 1)
                    {
                        Rect rect2 = (Rect)arraylist.get(k3 + 1);
                        if ((float)rect.right + r > (float)rect2.left)
                        {
                            int i4 = rect.right - rect.left;
                            rect.left = (int)((float)(rect2.left - i4) - r);
                            rect.right = i4 + rect.left;
                        }
                    }
                    canvas.drawText(charsequence, 0, charsequence.length(), rect.left, (float)rect.bottom + u, i);
                    if (flag2 && flag)
                    {
                        i.setColor(l);
                        i.setAlpha((int)(f3 * (float)(l >>> 24)));
                        canvas.drawText(charsequence, 0, charsequence.length(), rect.left, (float)rect.bottom + u, i);
                    }
                    integer = Integer.valueOf(k3);
                    if (A.contains(integer))
                    {
                        Rect rect1 = a(k3, i);
                        int l3 = rect1.right - rect1.left;
                        int _tmp = rect1.bottom - rect1.top;
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 0x7f02000c), 5 + (l3 + rect.left), rect.top + rect.height() / 2, null);
                    }
                    k3++;
                }
                float f4 = p;
                float f5 = ((float)getWidth() - s - t) / (1.0F * (float)i1);
                float f6 = s + f5 * ((float)f + g) + f5 / 2.0F;
                m.reset();
                m.moveTo(f6, (float)i2 - f4);
                m.lineTo(f6 + f4, i2);
                m.lineTo(f6 - f4, i2);
                m.close();
                canvas.drawPath(m, o);
                return;
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        float f1;
        if (android.view.View.MeasureSpec.getMode(j1) == 0x40000000)
        {
            f1 = android.view.View.MeasureSpec.getSize(j1);
        } else
        {
            n.setEmpty();
            n.bottom = (int)(i.descent() - i.ascent());
            f1 = (float)(n.bottom - n.top) + q + u + p;
        }
        setMeasuredDimension(k1, (int)f1);
    }

    public void onPageScrollStateChanged(int i1)
    {
        h = i1;
        if (e != null)
        {
            e.onPageScrollStateChanged(i1);
        }
    }

    public void onPageScrolled(int i1, float f1, int j1)
    {
        f = i1;
        g = f1;
        invalidate();
        if (e != null)
        {
            e.onPageScrolled(i1, f1, j1);
        }
    }

    public void onPageSelected(int i1)
    {
        if (h == 0)
        {
            f = i1;
            invalidate();
        }
        if (e != null)
        {
            e.onPageSelected(i1);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        f = savedstate.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = f;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (d == null || d.getAdapter().getCount() == 0)
        {
            return false;
        }
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 84
    //                   0 86
    //                   1 198
    //                   2 105
    //                   3 198
    //                   4 84
    //                   5 315
    //                   6 343;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        y = MotionEventCompat.getPointerId(motionevent, 0);
        x = motionevent.getX();
        return true;
_L6:
        float f1 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, y));
        float f2 = f1 - x;
        if (!z && Math.abs(f2) > (float)w)
        {
            z = true;
        }
        if (z)
        {
            x = f1;
            if (d.isFakeDragging() || d.beginFakeDrag())
            {
                d.fakeDragBy(f2);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (z) goto _L10; else goto _L9
_L9:
        ArrayList arraylist;
        int l1;
        int i2;
        int j2;
        arraylist = a(i);
        l1 = arraylist.size();
        i2 = (int)motionevent.getX();
        j2 = 0;
_L14:
        if (j2 >= l1) goto _L10; else goto _L11
_L11:
        Rect rect = (Rect)arraylist.get(j2);
        if (i2 <= rect.left || i2 >= rect.right) goto _L13; else goto _L12
_L12:
        d.setCurrentItem(j2);
_L10:
        z = false;
        y = -1;
        if (d.isFakeDragging())
        {
            d.endFakeDrag();
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        j2++;
          goto _L14
_L7:
        int k1 = MotionEventCompat.getActionIndex(motionevent);
        x = MotionEventCompat.getX(motionevent, k1);
        y = MotionEventCompat.getPointerId(motionevent, k1);
        return true;
        continue; /* Loop/switch isn't completed */
_L8:
        int i1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i1) == y)
        {
            int j1;
            if (i1 == 0)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            y = MotionEventCompat.getPointerId(motionevent, j1);
        }
        x = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, y));
        return true;
        if (true) goto _L1; else goto _L15
_L15:
    }

    public void setBadges(Integer integer)
    {
        A.add(integer);
    }

    public void setCurrentItem(int i1)
    {
        if (d == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            d.setCurrentItem(i1);
            f = i1;
            invalidate();
            return;
        }
    }

    public void setFooterColor(int i1)
    {
        o.setColor(i1);
        invalidate();
    }

    public void setFooterIndicatorHeight(float f1)
    {
        p = f1;
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        e = onpagechangelistener;
    }

    public void setSelectedBold(boolean flag)
    {
        j = flag;
        invalidate();
    }

    public void setSelectedColor(int i1)
    {
        l = i1;
        invalidate();
    }

    public void setTextColor(int i1)
    {
        i.setColor(i1);
        k = i1;
        invalidate();
    }

    public void setTextSize(float f1)
    {
        i.setTextSize(f1);
        invalidate();
    }

    public void setTitlePadding(float f1)
    {
        r = f1;
        invalidate();
    }

    public void setTopPadding(float f1)
    {
        u = f1;
        invalidate();
    }

    public void setTypeface(Typeface typeface)
    {
        i.setTypeface(typeface);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (d == viewpager)
        {
            return;
        }
        if (d != null)
        {
            d.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            d = viewpager;
            d.setOnPageChangeListener(this);
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

        public static final android.os.Parcelable.Creator CREATOR = new d();
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

        SavedState(Parcel parcel, c c1)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
