// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.nirhart.parallaxscroll.views:
//            ParallaxedView

public class ParallaxScrollView extends ScrollView
{

    private static final int a = 1;
    private static final float b = 1.9F;
    private static final float c = 1.9F;
    private static final String d = "ParallaxedScrollView";
    private static final int m = 0;
    private static final int o = 50;
    private static final boolean p;
    private int e;
    private float f;
    private float g;
    private ArrayList h;
    private Drawable i;
    private View j;
    private View k;
    private int l;
    private int n;
    private OnScrollListener q;

    public ParallaxScrollView(Context context)
    {
        super(context);
        e = 1;
        f = 1.9F;
        g = 1.9F;
        h = new ArrayList();
        i = null;
        j = null;
        k = null;
        l = 0;
    }

    public ParallaxScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = 1;
        f = 1.9F;
        g = 1.9F;
        h = new ArrayList();
        i = null;
        j = null;
        k = null;
        l = 0;
        init(context, attributeset);
    }

    public ParallaxScrollView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = 1;
        f = 1.9F;
        g = 1.9F;
        h = new ArrayList();
        i = null;
        j = null;
        k = null;
        l = 0;
        init(context, attributeset);
    }

    private void a()
    {
        if (getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup))
        {
            ViewGroup viewgroup = (ViewGroup)getChildAt(0);
            int i1 = Math.min(e, viewgroup.getChildCount());
            for (int j1 = 0; j1 < i1; j1++)
            {
                ParallaxedScrollView parallaxedscrollview = new ParallaxedScrollView(viewgroup.getChildAt(j1));
                h.add(parallaxedscrollview);
            }

            j = viewgroup.getChildAt(0);
            k = viewgroup.getChildAt(1);
        }
    }

    private void a(View view, boolean flag)
    {
        if (p)
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            if (byte0 != view.getLayerType())
            {
                view.setLayerType(byte0, null);
                return;
            }
        }
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (k != null)
        {
            int i1 = k.getRight();
            int j1 = k.getTop() - l;
            int k1 = k.getTop();
            int l1 = k.getLeft();
            if (i != null)
            {
                i.setBounds(l1, j1, i1, k1);
                i.draw(canvas);
                return;
            }
        }
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.ParallaxScroll);
        g = typedarray.getFloat(0, 1.9F);
        f = typedarray.getFloat(1, 1.9F);
        e = typedarray.getInt(2, 1);
        typedarray.recycle();
        i = getResources().getDrawable(0x7f020001);
        float f1 = context.getResources().getDisplayMetrics().density;
        l = (int)(0.0F * f1);
        n = (int)(f1 * 50F);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        a();
    }

    protected void onScrollChanged(int i1, int j1, int k1, int l1)
    {
        super.onScrollChanged(i1, j1, k1, l1);
        if (q != null)
        {
            q.onScrollChanged(i1, j1, k1, l1);
        }
        if (j1 >= 0)
        {
            float f1 = g;
            Iterator iterator = h.iterator();
            float f2 = f1;
            while (iterator.hasNext()) 
            {
                ((ParallaxedView)iterator.next()).setOffset((float)j1 / f2);
                f2 *= f;
            }
        }
    }

    protected boolean overScrollBy(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, boolean flag)
    {
        if (j1 + l1 >= 0)
        {
            return super.overScrollBy(i1, j1, k1, l1, i2, j2, k2, n, flag);
        } else
        {
            return super.overScrollBy(i1, 0, k1, 0, i2, j2, k2, l2, flag);
        }
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        q = onscrolllistener;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
    }

    private class ParallaxedScrollView extends ParallaxedView
    {

        final ParallaxScrollView a;

        protected void translatePreICS(View view, float f1)
        {
            view.offsetTopAndBottom((int)f1 - lastOffset);
            lastOffset = (int)f1;
        }

        public ParallaxedScrollView(View view)
        {
            a = ParallaxScrollView.this;
            super(view);
        }
    }


    private class OnScrollListener
    {

        public abstract void onScrollChanged(int i1, int j1, int k1, int l1);
    }

}
