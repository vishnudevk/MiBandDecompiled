// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

public class gravity extends android.view.ms
{

    float a;
    boolean b;
    boolean c;
    public int gravity;

    public _cls9(int i, int j)
    {
        super(i, j);
        gravity = 0;
    }

    public gravity(int i, int j, int k)
    {
        this(i, j);
        gravity = k;
    }

    public gravity(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        gravity = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, DrawerLayout.c());
        gravity = typedarray.getInt(0, 0);
        typedarray.recycle();
    }

    public gravity(gravity gravity1)
    {
        super(gravity1);
        gravity = 0;
        gravity = gravity1.gravity;
    }

    public gravity(android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
        gravity = 0;
    }

    public gravity(android.view.ms ms)
    {
        super(ms);
        gravity = 0;
    }
}
