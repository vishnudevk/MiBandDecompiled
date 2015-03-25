// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget.adapters;

import android.content.Context;

// Referenced classes of package kankan.wheel.widget.adapters:
//            AbstractWheelTextAdapter

public class ArrayWheelAdapter extends AbstractWheelTextAdapter
{

    private Object a[];

    public ArrayWheelAdapter(Context context, Object aobj[])
    {
        super(context);
        a = aobj;
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
        if (i >= 0 && i < a.length)
        {
            Object obj = a[i];
            if (obj instanceof CharSequence)
            {
                return (CharSequence)obj;
            } else
            {
                return obj.toString();
            }
        } else
        {
            return null;
        }
    }

    public int getItemsCount()
    {
        return a.length;
    }

    public boolean isNeedLoop()
    {
        return false;
    }
}
