// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager
{

    private boolean a;

    public CustomViewPager(Context context)
    {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray;
        super(context, attributeset);
        typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.CustomViewPager);
        a = typedarray.getBoolean(0, true);
        typedarray.recycle();
        return;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public boolean isSwipeable()
    {
        return a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return super.onInterceptTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a)
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public void setSwipeable(boolean flag)
    {
        a = flag;
    }
}
