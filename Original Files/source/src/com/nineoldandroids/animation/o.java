// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

class o extends IntProperty
{

    o(String s)
    {
        super(s);
    }

    public Integer a(View view)
    {
        return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
    }

    public void a(View view, int i)
    {
        AnimatorProxy.wrap(view).setScrollX(i);
    }

    public Object get(Object obj)
    {
        return a((View)obj);
    }

    public void setValue(Object obj, int i)
    {
        a((View)obj, i);
    }
}
