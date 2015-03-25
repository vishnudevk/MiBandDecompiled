// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

// Referenced classes of package com.nostra13.universalimageloader.core.assist:
//            a

public final class ViewScaleType extends Enum
{

    public static final ViewScaleType CROP;
    public static final ViewScaleType FIT_INSIDE;
    private static final ViewScaleType a[];

    private ViewScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ViewScaleType fromImageView(ImageView imageview)
    {
        switch (a.a[imageview.getScaleType().ordinal()])
        {
        default:
            return CROP;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return FIT_INSIDE;
        }
    }

    public static ViewScaleType valueOf(String s)
    {
        return (ViewScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ViewScaleType, s);
    }

    public static ViewScaleType[] values()
    {
        return (ViewScaleType[])a.clone();
    }

    static 
    {
        FIT_INSIDE = new ViewScaleType("FIT_INSIDE", 0);
        CROP = new ViewScaleType("CROP", 1);
        ViewScaleType aviewscaletype[] = new ViewScaleType[2];
        aviewscaletype[0] = FIT_INSIDE;
        aviewscaletype[1] = CROP;
        a = aviewscaletype;
    }
}
