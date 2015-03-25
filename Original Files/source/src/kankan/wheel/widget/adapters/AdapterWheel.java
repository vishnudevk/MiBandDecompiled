// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget.adapters;

import android.content.Context;
import kankan.wheel.widget.WheelAdapter;

// Referenced classes of package kankan.wheel.widget.adapters:
//            AbstractWheelTextAdapter

public class AdapterWheel extends AbstractWheelTextAdapter
{

    private WheelAdapter a;

    public AdapterWheel(Context context, WheelAdapter wheeladapter)
    {
        super(context);
        a = wheeladapter;
    }

    public WheelAdapter getAdapter()
    {
        return a;
    }

    public int getBASE_BUNDLE()
    {
        return 0;
    }

    public int getInitLoopBase()
    {
        return 0;
    }

    protected CharSequence getItemText(int i)
    {
        return a.getItem(i);
    }

    public int getItemsCount()
    {
        return a.getItemsCount();
    }

    public boolean isNeedLoop()
    {
        return false;
    }
}
