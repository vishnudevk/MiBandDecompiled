// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            VerticalViewPager

public class gravity extends android.view.ewPager.LayoutParams
{

    public int gravity;
    public boolean isDecor;

    public ()
    {
        super(-1, -1);
    }

    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, VerticalViewPager.f());
        gravity = typedarray.getInteger(0, 0);
        typedarray.recycle();
    }
}
