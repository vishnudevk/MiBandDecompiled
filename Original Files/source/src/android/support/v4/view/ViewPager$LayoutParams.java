// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.view:
//            ViewPager

public class gravity extends android.view.youtParams
{

    float a;
    boolean b;
    int c;
    int d;
    public int gravity;
    public boolean isDecor;

    public ()
    {
        super(-1, -1);
        a = 0.0F;
    }

    public a(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0.0F;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, ViewPager.f());
        gravity = typedarray.getInteger(0, 48);
        typedarray.recycle();
    }
}
