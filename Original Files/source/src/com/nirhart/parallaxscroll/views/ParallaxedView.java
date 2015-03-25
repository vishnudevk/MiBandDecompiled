// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.view.View;
import java.lang.ref.WeakReference;

public abstract class ParallaxedView
{

    public static boolean isAPI11;
    protected int lastOffset;
    protected WeakReference view;

    public ParallaxedView(View view1)
    {
        lastOffset = 0;
        view = new WeakReference(view1);
    }

    public boolean is(View view1)
    {
        return view1 != null && view != null && view.get() != null && ((View)view.get()).equals(view1);
    }

    public void setOffset(float f)
    {
        View view1;
label0:
        {
            view1 = (View)view.get();
            if (view1 != null)
            {
                if (!isAPI11)
                {
                    break label0;
                }
                view1.setTranslationY(f);
            }
            return;
        }
        translatePreICS(view1, f);
    }

    public void setView(View view1)
    {
        view = new WeakReference(view1);
    }

    protected abstract void translatePreICS(View view1, float f);

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
        isAPI11 = flag;
    }
}
