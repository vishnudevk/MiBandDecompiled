// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

// Referenced classes of package com.nirhart.parallaxscroll.views:
//            ParallaxedView

public class ParallaxListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{

    private static final float a = 1.9F;
    private static final boolean b;
    private float c;
    private ParallaxedView d;
    private boolean e;
    private android.widget.AbsListView.OnScrollListener f;

    public ParallaxListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 1.9F;
        f = null;
        init(context, attributeset);
    }

    public ParallaxListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = 1.9F;
        f = null;
        init(context, attributeset);
    }

    private void a()
    {
        if (getChildCount() > 0)
        {
            int i = -getChildAt(0).getTop();
            float f1 = c;
            c();
            d.setOffset((float)i / f1);
        }
    }

    private void a(View view)
    {
        d = new ParallaxedListView(view);
    }

    private void b()
    {
        if (d != null && getChildCount() > 0)
        {
            int i = -getChildAt(0).getTop();
            float f1 = c;
            d.setOffset((float)i / f1);
        }
    }

    private void c()
    {
label0:
        {
            if (d == null || !d.is(getChildAt(0)))
            {
                if (d == null)
                {
                    break label0;
                }
                d.setOffset(0.0F);
                d.setView(getChildAt(0));
            }
            return;
        }
        d = new ParallaxedListView(getChildAt(0));
    }

    public void addParallaxedHeaderView(View view)
    {
        super.addHeaderView(view);
        a(view);
    }

    public void addParallaxedHeaderView(View view, Object obj, boolean flag)
    {
        super.addHeaderView(view, obj, flag);
        a(view);
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.ParallaxScroll);
        c = typedarray.getFloat(0, 1.9F);
        e = typedarray.getBoolean(3, false);
        typedarray.recycle();
        super.setOnScrollListener(this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        parallaxScroll();
        if (f != null)
        {
            f.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (f != null)
        {
            f.onScrollStateChanged(abslistview, i);
        }
    }

    protected void parallaxScroll()
    {
        if (e)
        {
            a();
            return;
        } else
        {
            b();
            return;
        }
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        f = onscrolllistener;
    }

    private class ParallaxedListView extends ParallaxedView
    {

        final ParallaxListView a;

        protected void translatePreICS(View view, float f1)
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, f1, f1);
            translateanimation.setDuration(0L);
            translateanimation.setFillAfter(true);
            view.setAnimation(translateanimation);
            translateanimation.start();
        }

        public ParallaxedListView(View view)
        {
            a = ParallaxListView.this;
            super(view);
        }
    }

}
