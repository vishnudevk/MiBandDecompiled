// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget.adapters;

import android.content.Context;

// Referenced classes of package kankan.wheel.widget.adapters:
//            AbstractWheelTextAdapter

public class NumericWheelAdapter extends AbstractWheelTextAdapter
{

    public static final int DEFAULT_MAX_VALUE = 9;
    private static final int a;
    private int b;
    private int c;
    private String d;

    public NumericWheelAdapter(Context context)
    {
        this(context, 0, 9);
    }

    public NumericWheelAdapter(Context context, int i, int j)
    {
        this(context, i, j, null);
    }

    public NumericWheelAdapter(Context context, int i, int j, String s)
    {
        super(context);
        b = i;
        c = j;
        d = s;
    }

    public int getBASE_BUNDLE()
    {
        return 0;
    }

    public int getInitLoopBase()
    {
        return 0;
    }

    public CharSequence getItemText(int i)
    {
        if (i >= 0 && i < getItemsCount())
        {
            int j = i + b;
            if (d != null)
            {
                String s = d;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(j);
                return String.format(s, aobj);
            } else
            {
                return Integer.toString(j);
            }
        } else
        {
            return null;
        }
    }

    public int getItemsCount()
    {
        return 1 + (c - b);
    }

    public boolean isNeedLoop()
    {
        return false;
    }
}
