// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class role extends android.view.arams
{

    public static final int ROLE_CONTENT = 0;
    public static final int ROLE_PRIMARY_MENU = 1;
    public static final int ROLE_SECONDARY_MENU = 2;
    public int role;

    public (int i, int j)
    {
        super(i, j);
    }

    public (int i, int j, int k)
    {
        super(i, j);
        role = k;
    }

    public role(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray;
        int i;
        int j;
        super(context, attributeset);
        typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.ayout, 0, 0);
        i = typedarray.getIndexCount();
        j = 0;
_L6:
        if (j >= i) goto _L2; else goto _L1
_L1:
        typedarray.getIndex(j);
        JVM INSTR tableswitch 0 0: default 56
    //                   0 62;
           goto _L3 _L4
_L3:
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        role = typedarray.getInt(0, -1);
        if (true) goto _L3; else goto _L2
_L2:
        switch (role)
        {
        default:
            throw new IllegalArgumentException("You must specified a layout_role for this view");

        case 0: // '\0'
            width = -1;
            height = -1;
            // fall through

        case 1: // '\001'
        case 2: // '\002'
            typedarray.recycle();
            break;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
    }

    public height(android.view.ideMenu.LayoutParams layoutparams)
    {
        super(layoutparams);
        if (layoutparams instanceof height)
        {
            role = ((role)layoutparams).role;
        }
    }
}
