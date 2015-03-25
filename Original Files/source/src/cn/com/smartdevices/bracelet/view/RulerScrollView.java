// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            u

public class RulerScrollView extends HorizontalScrollView
{

    private static final String a = "RulerScrollView";
    private static final float b = 2.6F;
    private static Handler q = new Handler();
    private GestureDetector c;
    private LayoutInflater d;
    private int e;
    private int f;
    private LinearLayout g;
    private int h;
    private float i;
    private int j;
    private float k;
    private View l;
    private int m;
    private TextView n;
    private TextView o;
    private int p;
    private android.view.GestureDetector.SimpleOnGestureListener r;

    public RulerScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = 0;
        f = 100;
        m = 130;
        p = 0;
        r = new u(this);
        c = new GestureDetector(context, r);
        d = LayoutInflater.from(context);
        d.inflate(0x7f03005a, this);
        g = (LinearLayout)findViewById(0x7f0a019c);
    }

    public RulerScrollView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = 0;
        f = 100;
        m = 130;
        p = 0;
        r = new u(this);
    }

    private float a(int i1, int j1)
    {
        float f1 = (float)(Math.abs((0.5D + (double)i1) * (double)m - (double)j1 - (double)((float)j / 2.0F)) / (double)(2.0F * (float)m));
        if ((double)(1.0F - f1) > 9.9999999999999995E-07D)
        {
            return f1;
        } else
        {
            return 1.0F;
        }
    }

    static Handler a()
    {
        return q;
    }

    private void a(int i1)
    {
        k = Math.round(((float)i1 / i + (float)e + (float)j / 2.0F / i) - 2.6F);
        n.setText((new StringBuilder()).append((int)k).append("").toString());
    }

    static void a(RulerScrollView rulerscrollview)
    {
        rulerscrollview.b();
    }

    private void b()
    {
        Debug.i("RulerScrollView", (new StringBuilder()).append("adjust left from:").append(p).toString());
        p = (int)(i * ((2.6F + (k - (float)e)) - (float)(j / 2) / i));
        Debug.i("RulerScrollView", (new StringBuilder()).append("adjust left to:").append(p).toString());
        smoothScrollTo(getScrollLeft(), 0);
        smoothScrollTo(p, 0);
        invalidate();
    }

    private void b(int i1)
    {
        int j1 = (int)(((float)i1 + (float)j / 2.0F) / (float)m);
        View view = g.getChildAt(j1);
        if (view != null)
        {
            view.findViewById(0x7f0a019b).setAlpha(0.1F);
        }
        if (j1 > 0)
        {
            View view2 = g.getChildAt(j1 - 1);
            float f2 = a(j1 - 1, i1);
            if (view2 != null)
            {
                view2.findViewById(0x7f0a019b).setAlpha(f2);
            }
        }
        if (j1 < -1 + g.getChildCount())
        {
            View view1 = g.getChildAt(j1 + 1);
            float f1 = a(j1 + 1, i1);
            if (view1 != null)
            {
                view1.findViewById(0x7f0a019b).setAlpha(f1);
            }
        }
    }

    public void addView(View view)
    {
        g.addView(view);
    }

    public float getCurValue()
    {
        return k;
    }

    public int getScrollLeft()
    {
        return p;
    }

    protected void onScrollChanged(int i1, int j1, int k1, int l1)
    {
        super.onScrollChanged(i1, j1, k1, l1);
        a(i1);
        b(i1);
        p = i1;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1);
        if (!c.onTouchEvent(motionevent) && motionevent.getAction() == 1)
        {
            b();
        }
        return super.onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        h = g.getWidth();
        j = getWidth();
        i = (float)h / (float)(f - e);
        View view = g.getChildAt(0);
        if (view != null)
        {
            m = view.getWidth();
        }
        a(p);
        b(p);
        scrollTo(p, 0);
    }

    public void setIndicatorView(View view)
    {
        l = view;
        n = (TextView)l.findViewById(0x7f0a0198);
        o = (TextView)l.findViewById(0x7f0a0199);
    }

    public void setScroll(int i1)
    {
        p = i1;
        scrollTo(i1, 0);
    }

    public void setStartEnd(int i1, int j1, String s)
    {
        e = i1;
        f = j1;
        o.setText(s);
    }

}
