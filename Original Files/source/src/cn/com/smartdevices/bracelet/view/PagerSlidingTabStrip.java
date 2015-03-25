// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            q, p, o

public class PagerSlidingTabStrip extends HorizontalScrollView
{

    private static final int a[] = {
        0x1010095, 0x1010098
    };
    private int A;
    private int B;
    private Locale C;
    private android.widget.LinearLayout.LayoutParams b;
    private android.widget.LinearLayout.LayoutParams c;
    private final q d;
    public android.support.v4.view.ViewPager.OnPageChangeListener delegatePageListener;
    private LinearLayout e;
    private ViewPager f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private Paint k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private Typeface y;
    private int z;

    public PagerSlidingTabStrip(Context context)
    {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        d = new q(this, null);
        h = 0;
        i = 0.0F;
        l = 0xff666666;
        m = 0x1a000000;
        n = 0x1a000000;
        o = false;
        p = true;
        q = 52;
        r = 8;
        s = 2;
        t = 12;
        u = 24;
        v = 1;
        w = 12;
        x = 0xff666666;
        y = null;
        z = 1;
        A = 0;
        B = 0x7f02000b;
        setFillViewport(true);
        setWillNotDraw(false);
        e = new LinearLayout(context);
        e.setOrientation(0);
        e.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(e);
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        q = (int)TypedValue.applyDimension(1, q, displaymetrics);
        r = (int)TypedValue.applyDimension(1, r, displaymetrics);
        s = (int)TypedValue.applyDimension(1, s, displaymetrics);
        t = (int)TypedValue.applyDimension(1, t, displaymetrics);
        u = (int)TypedValue.applyDimension(1, u, displaymetrics);
        v = (int)TypedValue.applyDimension(1, v, displaymetrics);
        w = (int)TypedValue.applyDimension(2, w, displaymetrics);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, a);
        w = typedarray.getDimensionPixelSize(0, w);
        x = typedarray.getColor(1, x);
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.PagerSlidingTabStrip);
        l = typedarray1.getColor(0, l);
        m = typedarray1.getColor(1, m);
        n = typedarray1.getColor(2, n);
        r = typedarray1.getDimensionPixelSize(3, r);
        s = typedarray1.getDimensionPixelSize(4, s);
        t = typedarray1.getDimensionPixelSize(5, t);
        u = typedarray1.getDimensionPixelSize(6, u);
        B = typedarray1.getResourceId(8, B);
        o = typedarray1.getBoolean(9, o);
        q = typedarray1.getDimensionPixelSize(7, q);
        p = typedarray1.getBoolean(10, p);
        typedarray1.recycle();
        j = new Paint();
        j.setAntiAlias(true);
        j.setStyle(android.graphics.Paint.Style.FILL);
        k = new Paint();
        k.setAntiAlias(true);
        k.setStrokeWidth(v);
        b = new android.widget.LinearLayout.LayoutParams(-2, -1);
        c = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
        if (C == null)
        {
            C = getResources().getConfiguration().locale;
        }
    }

    static float a(PagerSlidingTabStrip pagerslidingtabstrip, float f1)
    {
        pagerslidingtabstrip.i = f1;
        return f1;
    }

    static int a(PagerSlidingTabStrip pagerslidingtabstrip, int i1)
    {
        pagerslidingtabstrip.h = i1;
        return i1;
    }

    static ViewPager a(PagerSlidingTabStrip pagerslidingtabstrip)
    {
        return pagerslidingtabstrip.f;
    }

    private void a()
    {
        int i1 = 0;
        while (i1 < g) 
        {
            View view = e.getChildAt(i1);
            view.setBackgroundResource(B);
            if (!(view instanceof TextView))
            {
                continue;
            }
            TextView textview = (TextView)view;
            textview.setTextSize(0, w);
            textview.setTypeface(y, z);
            textview.setTextColor(x);
            if (p)
            {
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    textview.setAllCaps(true);
                } else
                {
                    textview.setText(textview.getText().toString().toUpperCase(C));
                }
            }
            i1++;
        }
    }

    private void a(int i1, int j1)
    {
        ImageButton imagebutton = new ImageButton(getContext());
        imagebutton.setImageResource(j1);
        a(i1, ((View) (imagebutton)));
    }

    private void a(int i1, View view)
    {
        view.setFocusable(true);
        view.setOnClickListener(new p(this, i1));
        view.setPadding(u, 0, u, 0);
        LinearLayout linearlayout = e;
        android.widget.LinearLayout.LayoutParams layoutparams;
        if (o)
        {
            layoutparams = c;
        } else
        {
            layoutparams = b;
        }
        linearlayout.addView(view, i1, layoutparams);
    }

    private void a(int i1, String s1)
    {
        TextView textview = new TextView(getContext());
        textview.setText(s1);
        textview.setGravity(17);
        textview.setSingleLine();
        a(i1, ((View) (textview)));
    }

    static void a(PagerSlidingTabStrip pagerslidingtabstrip, int i1, int j1)
    {
        pagerslidingtabstrip.b(i1, j1);
    }

    static int b(PagerSlidingTabStrip pagerslidingtabstrip)
    {
        return pagerslidingtabstrip.h;
    }

    private void b(int i1, int j1)
    {
        if (g != 0)
        {
            int k1 = j1 + e.getChildAt(i1).getLeft();
            if (i1 > 0 || j1 > 0)
            {
                k1 -= q;
            }
            if (k1 != A)
            {
                A = k1;
                scrollTo(k1, 0);
                return;
            }
        }
    }

    static LinearLayout c(PagerSlidingTabStrip pagerslidingtabstrip)
    {
        return pagerslidingtabstrip.e;
    }

    public int getDividerColor()
    {
        return n;
    }

    public int getDividerPadding()
    {
        return t;
    }

    public int getIndicatorColor()
    {
        return l;
    }

    public int getIndicatorHeight()
    {
        return r;
    }

    public int getScrollOffset()
    {
        return q;
    }

    public boolean getShouldExpand()
    {
        return o;
    }

    public int getTabBackground()
    {
        return B;
    }

    public int getTabPaddingLeftRight()
    {
        return u;
    }

    public int getTextColor()
    {
        return x;
    }

    public int getTextSize()
    {
        return w;
    }

    public int getUnderlineColor()
    {
        return m;
    }

    public int getUnderlineHeight()
    {
        return s;
    }

    public boolean isTextAllCaps()
    {
        return p;
    }

    public void notifyDataSetChanged()
    {
        e.removeAllViews();
        g = f.getAdapter().getCount();
        int i1 = 0;
        while (i1 < g) 
        {
            if (f.getAdapter() instanceof IconTabProvider)
            {
                a(i1, ((IconTabProvider)f.getAdapter()).getPageIconResId(i1));
            } else
            {
                a(i1, f.getAdapter().getPageTitle(i1).toString());
            }
            i1++;
        }
        a();
        getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!isInEditMode() && g != 0)
        {
            int i1 = getHeight();
            j.setColor(l);
            View view = e.getChildAt(h);
            float f1 = view.getLeft();
            float f2 = view.getRight();
            if (i > 0.0F && h < -1 + g)
            {
                View view2 = e.getChildAt(1 + h);
                float f3 = view2.getLeft();
                float f4 = view2.getRight();
                f1 = f3 * i + f1 * (1.0F - i);
                f2 = f4 * i + f2 * (1.0F - i);
            }
            canvas.drawRect(f1, i1 - r, f2, i1, j);
            j.setColor(m);
            canvas.drawRect(0.0F, i1 - s, e.getWidth(), i1, j);
            k.setColor(n);
            int j1 = 0;
            while (j1 < -1 + g) 
            {
                View view1 = e.getChildAt(j1);
                canvas.drawLine(view1.getRight(), t, view1.getRight(), i1 - t, k);
                j1++;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        h = savedstate.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = h;
        return savedstate;
    }

    public void setAllCaps(boolean flag)
    {
        p = flag;
    }

    public void setDividerColor(int i1)
    {
        n = i1;
        invalidate();
    }

    public void setDividerColorResource(int i1)
    {
        n = getResources().getColor(i1);
        invalidate();
    }

    public void setDividerPadding(int i1)
    {
        t = i1;
        invalidate();
    }

    public void setIndicatorColor(int i1)
    {
        l = i1;
        invalidate();
    }

    public void setIndicatorColorResource(int i1)
    {
        l = getResources().getColor(i1);
        invalidate();
    }

    public void setIndicatorHeight(int i1)
    {
        r = i1;
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        delegatePageListener = onpagechangelistener;
    }

    public void setScrollOffset(int i1)
    {
        q = i1;
        invalidate();
    }

    public void setShouldExpand(boolean flag)
    {
        o = flag;
        requestLayout();
    }

    public void setTabBackground(int i1)
    {
        B = i1;
    }

    public void setTabPaddingLeftRight(int i1)
    {
        u = i1;
        a();
    }

    public void setTextColor(int i1)
    {
        x = i1;
        a();
    }

    public void setTextColorResource(int i1)
    {
        x = getResources().getColor(i1);
        a();
    }

    public void setTextSize(int i1)
    {
        w = i1;
        a();
    }

    public void setTypeface(Typeface typeface, int i1)
    {
        y = typeface;
        z = i1;
        a();
    }

    public void setUnderlineColor(int i1)
    {
        m = i1;
        invalidate();
    }

    public void setUnderlineColorResource(int i1)
    {
        m = getResources().getColor(i1);
        invalidate();
    }

    public void setUnderlineHeight(int i1)
    {
        s = i1;
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        f = viewpager;
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            viewpager.setOnPageChangeListener(d);
            notifyDataSetChanged();
            return;
        }
    }


    private class IconTabProvider
    {

        public abstract int getPageIconResId(int i1);
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new r();
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

        SavedState(Parcel parcel, o o1)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
