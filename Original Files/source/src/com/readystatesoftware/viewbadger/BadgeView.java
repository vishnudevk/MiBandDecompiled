// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.readystatesoftware.viewbadger;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;

public class BadgeView extends TextView
{

    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 4;
    public static final int POSITION_CENTER = 5;
    public static final int POSITION_TOP_LEFT = 1;
    public static final int POSITION_TOP_RIGHT = 2;
    private static final int a = 5;
    private static final int b = 5;
    private static final int c = 8;
    private static final int d = 2;
    private static final int e = 0;
    private static final int f = -1;
    private static Animation g;
    private static Animation h;
    private Context i;
    private View j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private ShapeDrawable p;
    private int q;

    public BadgeView(Context context)
    {
        this(context, (AttributeSet)null, 0x1010084);
    }

    public BadgeView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010084);
    }

    public BadgeView(Context context, AttributeSet attributeset, int i1)
    {
        this(context, attributeset, i1, null, 0);
    }

    public BadgeView(Context context, AttributeSet attributeset, int i1, View view, int j1)
    {
        super(context, attributeset, i1);
        a(context, view, j1);
    }

    public BadgeView(Context context, View view)
    {
        this(context, null, 0x1010084, view, 0);
    }

    public BadgeView(Context context, TabWidget tabwidget, int i1)
    {
        this(context, null, 0x1010084, ((View) (tabwidget)), i1);
    }

    private int a(int i1)
    {
        Resources resources = getResources();
        return (int)TypedValue.applyDimension(1, i1, resources.getDisplayMetrics());
    }

    private ShapeDrawable a()
    {
        int i1 = a(8);
        float af[] = new float[8];
        af[0] = i1;
        af[1] = i1;
        af[2] = i1;
        af[3] = i1;
        af[4] = i1;
        af[5] = i1;
        af[6] = i1;
        af[7] = i1;
        ShapeDrawable shapedrawable = new ShapeDrawable(new RoundRectShape(af, null, null));
        shapedrawable.getPaint().setColor(n);
        return shapedrawable;
    }

    private void a(Context context, View view, int i1)
    {
        i = context;
        j = view;
        q = i1;
        k = 2;
        l = a(5);
        m = l;
        n = e;
        setTypeface(Typeface.DEFAULT_BOLD);
        int j1 = a(5);
        setPadding(j1, 0, j1, 0);
        setTextColor(-1);
        g = new AlphaAnimation(0.0F, 1.0F);
        g.setInterpolator(new DecelerateInterpolator());
        g.setDuration(200L);
        h = new AlphaAnimation(1.0F, 0.0F);
        h.setInterpolator(new AccelerateInterpolator());
        h.setDuration(200L);
        o = false;
        if (j != null)
        {
            a(j);
            return;
        } else
        {
            show();
            return;
        }
    }

    private void a(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        android.view.ViewParent viewparent = view.getParent();
        FrameLayout framelayout = new FrameLayout(i);
        if (view instanceof TabWidget)
        {
            View view1 = ((TabWidget)view).getChildTabViewAt(q);
            j = view1;
            ((ViewGroup)view1).addView(framelayout, new android.view.ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            framelayout.addView(this);
            return;
        } else
        {
            ViewGroup viewgroup = (ViewGroup)viewparent;
            int i1 = viewgroup.indexOfChild(view);
            viewgroup.removeView(view);
            viewgroup.addView(framelayout, i1, layoutparams);
            framelayout.addView(view);
            setVisibility(8);
            framelayout.addView(this);
            viewgroup.invalidate();
            return;
        }
    }

    private void a(boolean flag, Animation animation)
    {
        if (getBackground() == null)
        {
            if (p == null)
            {
                p = a();
            }
            setBackgroundDrawable(p);
        }
        b();
        if (flag)
        {
            startAnimation(animation);
        }
        setVisibility(0);
        o = true;
    }

    private void a(boolean flag, Animation animation, Animation animation1)
    {
        boolean flag1 = true;
        if (o)
        {
            if (!flag || animation1 == null)
            {
                flag1 = false;
            }
            b(flag1, animation1);
            return;
        }
        if (!flag || animation == null)
        {
            flag1 = false;
        }
        a(flag1, animation);
    }

    private void b()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        k;
        JVM INSTR tableswitch 1 5: default 52
    //                   1 58
    //                   2 81
    //                   3 104
    //                   4 127
    //                   5 150;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        setLayoutParams(layoutparams);
        return;
_L2:
        layoutparams.gravity = 51;
        layoutparams.setMargins(l, m, 0, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.gravity = 53;
        layoutparams.setMargins(0, m, l, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        layoutparams.gravity = 83;
        layoutparams.setMargins(l, 0, 0, m);
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.gravity = 85;
        layoutparams.setMargins(0, 0, l, m);
        continue; /* Loop/switch isn't completed */
_L6:
        layoutparams.gravity = 17;
        layoutparams.setMargins(0, 0, 0, 0);
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void b(boolean flag, Animation animation)
    {
        setVisibility(8);
        if (flag)
        {
            startAnimation(animation);
        }
        o = false;
    }

    public int decrement(int i1)
    {
        return increment(-i1);
    }

    public int getBadgeBackgroundColor()
    {
        return n;
    }

    public int getBadgePosition()
    {
        return k;
    }

    public int getHorizontalBadgeMargin()
    {
        return l;
    }

    public View getTarget()
    {
        return j;
    }

    public int getVerticalBadgeMargin()
    {
        return m;
    }

    public void hide()
    {
        b(false, null);
    }

    public void hide(Animation animation)
    {
        b(true, animation);
    }

    public void hide(boolean flag)
    {
        b(flag, h);
    }

    public int increment(int i1)
    {
        CharSequence charsequence;
        int j1;
        charsequence = getText();
        j1 = 0;
        if (charsequence == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        int l1 = Integer.parseInt(charsequence.toString());
        j1 = l1;
_L2:
        int k1 = j1 + i1;
        setText(String.valueOf(k1));
        return k1;
        NumberFormatException numberformatexception;
        numberformatexception;
        j1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean isShown()
    {
        return o;
    }

    public void setBadgeBackgroundColor(int i1)
    {
        n = i1;
        p = a();
    }

    public void setBadgeMargin(int i1)
    {
        l = i1;
        m = i1;
    }

    public void setBadgeMargin(int i1, int j1)
    {
        l = i1;
        m = j1;
    }

    public void setBadgePosition(int i1)
    {
        k = i1;
    }

    public void show()
    {
        a(false, null);
    }

    public void show(Animation animation)
    {
        a(true, animation);
    }

    public void show(boolean flag)
    {
        a(flag, g);
    }

    public void toggle()
    {
        a(false, ((Animation) (null)), ((Animation) (null)));
    }

    public void toggle(Animation animation, Animation animation1)
    {
        a(true, animation, animation1);
    }

    public void toggle(boolean flag)
    {
        a(flag, g, h);
    }

    static 
    {
        e = Color.parseColor("#CCFF0000");
    }
}
