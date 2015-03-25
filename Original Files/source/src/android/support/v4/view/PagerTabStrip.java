// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

// Referenced classes of package android.support.v4.view:
//            PagerTitleStrip, N, O, ViewPager

public class PagerTabStrip extends PagerTitleStrip
{

    private static final String f = "PagerTabStrip";
    private static final int g = 3;
    private static final int h = 6;
    private static final int i = 16;
    private static final int j = 32;
    private static final int k = 64;
    private static final int l = 1;
    private static final int m = 32;
    private float A;
    private float B;
    private int C;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final Paint t;
    private final Rect u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public PagerTabStrip(Context context)
    {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        t = new Paint();
        u = new Rect();
        v = 255;
        w = false;
        x = false;
        n = e;
        t.setColor(n);
        float f1 = context.getResources().getDisplayMetrics().density;
        o = (int)(0.5F + 3F * f1);
        p = (int)(0.5F + 6F * f1);
        q = (int)(64F * f1);
        s = (int)(0.5F + 16F * f1);
        y = (int)(0.5F + 1.0F * f1);
        r = (int)(0.5F + f1 * 32F);
        C = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        b.setFocusable(true);
        b.setOnClickListener(new N(this));
        d.setFocusable(true);
        d.setOnClickListener(new O(this));
        if (getBackground() == null)
        {
            w = true;
        }
    }

    int a()
    {
        return Math.max(super.a(), r);
    }

    void a(int i1, float f1, boolean flag)
    {
        Rect rect = u;
        int j1 = getHeight();
        int k1 = c.getLeft() - s;
        int l1 = c.getRight() + s;
        int i2 = j1 - o;
        rect.set(k1, i2, l1, j1);
        super.a(i1, f1, flag);
        v = (int)(255F * (2.0F * Math.abs(f1 - 0.5F)));
        rect.union(c.getLeft() - s, i2, c.getRight() + s, j1);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline()
    {
        return w;
    }

    public int getTabIndicatorColor()
    {
        return n;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1 = getHeight();
        int j1 = c.getLeft() - s;
        int k1 = c.getRight() + s;
        int l1 = i1 - o;
        t.setColor(v << 24 | 0xffffff & n);
        canvas.drawRect(j1, l1, k1, i1, t);
        if (w)
        {
            t.setColor(0xff000000 | 0xffffff & n);
            canvas.drawRect(getPaddingLeft(), i1 - y, getWidth() - getPaddingRight(), i1, t);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        float f1;
        float f2;
        i1 = motionevent.getAction();
        if (i1 != 0 && z)
        {
            return false;
        }
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        i1;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 58
    //                   1 122
    //                   2 77;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        A = f1;
        B = f2;
        z = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (Math.abs(f1 - A) > (float)C || Math.abs(f2 - B) > (float)C)
        {
            z = true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (f1 < (float)(c.getLeft() - s))
        {
            a.setCurrentItem(-1 + a.getCurrentItem());
        } else
        if (f1 > (float)(c.getRight() + s))
        {
            a.setCurrentItem(1 + a.getCurrentItem());
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setBackgroundColor(int i1)
    {
        super.setBackgroundColor(i1);
        if (!x)
        {
            boolean flag;
            if ((0xff000000 & i1) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w = flag;
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        if (!x)
        {
            boolean flag;
            if (drawable == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w = flag;
        }
    }

    public void setBackgroundResource(int i1)
    {
        super.setBackgroundResource(i1);
        if (!x)
        {
            boolean flag;
            if (i1 == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w = flag;
        }
    }

    public void setDrawFullUnderline(boolean flag)
    {
        w = flag;
        x = true;
        invalidate();
    }

    public void setPadding(int i1, int j1, int k1, int l1)
    {
        if (l1 < p)
        {
            l1 = p;
        }
        super.setPadding(i1, j1, k1, l1);
    }

    public void setTabIndicatorColor(int i1)
    {
        n = i1;
        t.setColor(n);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i1)
    {
        setTabIndicatorColor(getContext().getResources().getColor(i1));
    }

    public void setTextSpacing(int i1)
    {
        if (i1 < q)
        {
            i1 = q;
        }
        super.setTextSpacing(i1);
    }
}
