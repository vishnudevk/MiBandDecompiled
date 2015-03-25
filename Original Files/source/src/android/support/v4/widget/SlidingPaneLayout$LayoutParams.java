// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;

public class weight extends android.view.LayoutParams
{

    private static final int d[] = {
        0x1010181
    };
    boolean a;
    boolean b;
    Paint c;
    public float weight;


    public ()
    {
        super(-1, -1);
        weight = 0.0F;
    }

    public weight(int i, int j)
    {
        super(i, j);
        weight = 0.0F;
    }

    public weight(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        weight = 0.0F;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, d);
        weight = typedarray.getFloat(0, 0.0F);
        typedarray.recycle();
    }

    public weight(weight weight1)
    {
        super(weight1);
        weight = 0.0F;
        weight = weight1.weight;
    }

    public weight(android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
        weight = 0.0F;
    }

    public weight(android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
        weight = 0.0F;
    }
}
