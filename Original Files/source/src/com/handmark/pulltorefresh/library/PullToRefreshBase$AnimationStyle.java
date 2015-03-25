// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import com.handmark.pulltorefresh.library.internal.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.RotateLoadingLayout;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            f

public final class I extends Enum
{

    public static final a FLIP;
    public static final a ROTATE;
    private static final a a[];

    static I a()
    {
        return ROTATE;
    }

    static ROTATE a(int i)
    {
        switch (i)
        {
        default:
            return ROTATE;

        case 1: // '\001'
            return FLIP;
        }
    }

    public static FLIP valueOf(String s)
    {
        return (FLIP)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$AnimationStyle, s);
    }

    public static FLIP[] values()
    {
        return (FLIP[])a.clone();
    }

    LoadingLayout a(Context context, e_3B_.clone clone, e_3B_.clone clone1, TypedArray typedarray)
    {
        switch (f.d[ordinal()])
        {
        default:
            return new RotateLoadingLayout(context, clone, clone1, typedarray);

        case 2: // '\002'
            return new FlipLoadingLayout(context, clone, clone1, typedarray);
        }
    }

    static 
    {
        ROTATE = new <init>("ROTATE", 0);
        FLIP = new <init>("FLIP", 1);
         a1[] = new <init>[2];
        a1[0] = ROTATE;
        a1[1] = FLIP;
        a = a1;
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
