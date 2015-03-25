// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v4.view:
//            aB, T, S, Q, 
//            R, ViewPager, PagerAdapter

public class PagerTitleStrip extends ViewGroup
    implements aB
{

    private static final String f = "PagerTitleStrip";
    private static final int o[] = {
        0x1010034, 0x1010095, 0x1010098, 0x10100af
    };
    private static final int p[] = {
        0x101038c
    };
    private static final float q = 0.6F;
    private static final int r = 16;
    private static final R t;
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    int e;
    private int g;
    private float h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final Q m;
    private WeakReference n;
    private int s;

    public PagerTitleStrip(Context context)
    {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = -1;
        h = -1F;
        m = new Q(this, null);
        TextView textview = new TextView(context);
        b = textview;
        addView(textview);
        TextView textview1 = new TextView(context);
        c = textview1;
        addView(textview1);
        TextView textview2 = new TextView(context);
        d = textview2;
        addView(textview2);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, o);
        int i1 = typedarray.getResourceId(0, 0);
        if (i1 != 0)
        {
            b.setTextAppearance(context, i1);
            c.setTextAppearance(context, i1);
            d.setTextAppearance(context, i1);
        }
        int j1 = typedarray.getDimensionPixelSize(1, 0);
        if (j1 != 0)
        {
            setTextSize(0, j1);
        }
        if (typedarray.hasValue(2))
        {
            int k1 = typedarray.getColor(2, 0);
            b.setTextColor(k1);
            c.setTextColor(k1);
            d.setTextColor(k1);
        }
        j = typedarray.getInteger(3, 80);
        typedarray.recycle();
        e = c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6F);
        b.setEllipsize(android.text.TextUtils.TruncateAt.END);
        c.setEllipsize(android.text.TextUtils.TruncateAt.END);
        d.setEllipsize(android.text.TextUtils.TruncateAt.END);
        boolean flag = false;
        if (i1 != 0)
        {
            TypedArray typedarray1 = context.obtainStyledAttributes(i1, p);
            flag = typedarray1.getBoolean(0, false);
            typedarray1.recycle();
        }
        if (flag)
        {
            a(b);
            a(c);
            a(d);
        } else
        {
            b.setSingleLine();
            c.setSingleLine();
            d.setSingleLine();
        }
        i = (int)(16F * context.getResources().getDisplayMetrics().density);
    }

    static float a(PagerTitleStrip pagertitlestrip)
    {
        return pagertitlestrip.h;
    }

    private static void a(TextView textview)
    {
        t.a(textview);
    }

    int a()
    {
        Drawable drawable = getBackground();
        int i1 = 0;
        if (drawable != null)
        {
            i1 = drawable.getIntrinsicHeight();
        }
        return i1;
    }

    void a(int i1, float f1, boolean flag)
    {
        int k2;
        int j3;
        int k3;
        int i6;
        int j6;
        int k6;
        int k7;
        int i8;
        int j8;
        int k8;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int l2;
        int i3;
        int l3;
        int i4;
        int j4;
        float f2;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int l6;
        int i7;
        int j7;
        int l8;
        int i9;
        if (i1 != g)
        {
            a(i1, a.getAdapter());
        } else
        if (!flag && f1 == h)
        {
            return;
        }
        l = true;
        j1 = b.getMeasuredWidth();
        k1 = c.getMeasuredWidth();
        l1 = d.getMeasuredWidth();
        i2 = k1 / 2;
        j2 = getWidth();
        k2 = getHeight();
        l2 = getPaddingLeft();
        i3 = getPaddingRight();
        j3 = getPaddingTop();
        k3 = getPaddingBottom();
        l3 = l2 + i2;
        i4 = i3 + i2;
        j4 = j2 - l3 - i4;
        f2 = 0.5F + f1;
        if (f2 > 1.0F)
        {
            f2--;
        }
        k4 = j2 - i4 - (int)(f2 * (float)j4) - k1 / 2;
        l4 = k4 + k1;
        i5 = b.getBaseline();
        j5 = c.getBaseline();
        k5 = d.getBaseline();
        l5 = Math.max(Math.max(i5, j5), k5);
        i6 = l5 - i5;
        j6 = l5 - j5;
        k6 = l5 - k5;
        l6 = i6 + b.getMeasuredHeight();
        i7 = j6 + c.getMeasuredHeight();
        j7 = k6 + d.getMeasuredHeight();
        k7 = Math.max(Math.max(l6, i7), j7);
        0x70 & j;
        JVM INSTR lookupswitch 2: default 308
    //                   16: 466
    //                   80: 505;
           goto _L1 _L2 _L3
_L1:
        i8 = j3 + i6;
        j8 = j6 + j3;
        k8 = j3 + k6;
_L5:
        c.layout(k4, j8, l4, j8 + c.getMeasuredHeight());
        l8 = Math.min(l2, k4 - i - j1);
        b.layout(l8, i8, j1 + l8, i8 + b.getMeasuredHeight());
        i9 = Math.max(j2 - i3 - l1, l4 + i);
        d.layout(i9, k8, i9 + l1, k8 + d.getMeasuredHeight());
        h = f1;
        l = false;
        return;
_L2:
        int j9 = (k2 - j3 - k3 - k7) / 2;
        i8 = j9 + i6;
        j8 = j6 + j9;
        k8 = j9 + k6;
        continue; /* Loop/switch isn't completed */
_L3:
        int l7 = k2 - k3 - k7;
        i8 = l7 + i6;
        j8 = j6 + l7;
        k8 = l7 + k6;
        if (true) goto _L5; else goto _L4
_L4:
    }

    void a(int i1, PagerAdapter pageradapter)
    {
        int j1;
        CharSequence charsequence;
        TextView textview;
        CharSequence charsequence1;
        int k1;
        CharSequence charsequence2;
        int l1;
        int i2;
        int j2;
        int k2;
        if (pageradapter != null)
        {
            j1 = pageradapter.getCount();
        } else
        {
            j1 = 0;
        }
        k = true;
        if (i1 >= 1 && pageradapter != null)
        {
            charsequence = pageradapter.getPageTitle(i1 - 1);
        } else
        {
            charsequence = null;
        }
        b.setText(charsequence);
        textview = c;
        if (pageradapter != null && i1 < j1)
        {
            charsequence1 = pageradapter.getPageTitle(i1);
        } else
        {
            charsequence1 = null;
        }
        textview.setText(charsequence1);
        k1 = i1 + 1;
        charsequence2 = null;
        if (k1 < j1)
        {
            charsequence2 = null;
            if (pageradapter != null)
            {
                charsequence2 = pageradapter.getPageTitle(i1 + 1);
            }
        }
        d.setText(charsequence2);
        l1 = getWidth() - getPaddingLeft() - getPaddingRight();
        i2 = getHeight() - getPaddingTop() - getPaddingBottom();
        j2 = android.view.View.MeasureSpec.makeMeasureSpec((int)(0.8F * (float)l1), 0x80000000);
        k2 = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x80000000);
        b.measure(j2, k2);
        c.measure(j2, k2);
        d.measure(j2, k2);
        g = i1;
        if (!l)
        {
            a(i1, h, false);
        }
        k = false;
    }

    void a(PagerAdapter pageradapter, PagerAdapter pageradapter1)
    {
        if (pageradapter != null)
        {
            pageradapter.unregisterDataSetObserver(m);
            n = null;
        }
        if (pageradapter1 != null)
        {
            pageradapter1.registerDataSetObserver(m);
            n = new WeakReference(pageradapter1);
        }
        if (a != null)
        {
            g = -1;
            h = -1F;
            a(a.getCurrentItem(), pageradapter1);
            requestLayout();
        }
    }

    public int getTextSpacing()
    {
        return i;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.view.ViewParent viewparent = getParent();
        if (!(viewparent instanceof ViewPager))
        {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewpager = (ViewPager)viewparent;
        PagerAdapter pageradapter = viewpager.getAdapter();
        viewpager.a(m);
        viewpager.a(m);
        a = viewpager;
        PagerAdapter pageradapter1;
        if (n != null)
        {
            pageradapter1 = (PagerAdapter)n.get();
        } else
        {
            pageradapter1 = null;
        }
        a(pageradapter1, pageradapter);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (a != null)
        {
            a(a.getAdapter(), null);
            a.a(null);
            a.a(null);
            a = null;
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (a != null)
        {
            int i2 = h != 0.0F;
            float f1 = 0.0F;
            if (i2 >= 0)
            {
                f1 = h;
            }
            a(g, f1, true);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getMode(i1);
        int l1 = android.view.View.MeasureSpec.getMode(j1);
        int i2 = android.view.View.MeasureSpec.getSize(i1);
        int j2 = android.view.View.MeasureSpec.getSize(j1);
        if (k1 != 0x40000000)
        {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int k2 = a();
        int l2 = getPaddingTop() + getPaddingBottom();
        int i3 = j2 - l2;
        int j3 = android.view.View.MeasureSpec.makeMeasureSpec((int)(0.8F * (float)i2), 0x80000000);
        int k3 = android.view.View.MeasureSpec.makeMeasureSpec(i3, 0x80000000);
        b.measure(j3, k3);
        c.measure(j3, k3);
        d.measure(j3, k3);
        if (l1 == 0x40000000)
        {
            setMeasuredDimension(i2, j2);
            return;
        } else
        {
            setMeasuredDimension(i2, Math.max(k2, l2 + c.getMeasuredHeight()));
            return;
        }
    }

    public void requestLayout()
    {
        if (!k)
        {
            super.requestLayout();
        }
    }

    public void setGravity(int i1)
    {
        j = i1;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f1)
    {
        s = 0xff & (int)(255F * f1);
        int i1 = s << 24 | 0xffffff & e;
        b.setTextColor(i1);
        d.setTextColor(i1);
    }

    public void setTextColor(int i1)
    {
        e = i1;
        c.setTextColor(i1);
        int j1 = s << 24 | 0xffffff & e;
        b.setTextColor(j1);
        d.setTextColor(j1);
    }

    public void setTextSize(int i1, float f1)
    {
        b.setTextSize(i1, f1);
        c.setTextSize(i1, f1);
        d.setTextSize(i1, f1);
    }

    public void setTextSpacing(int i1)
    {
        i = i1;
        requestLayout();
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            t = new T();
        } else
        {
            t = new S();
        }
    }
}
