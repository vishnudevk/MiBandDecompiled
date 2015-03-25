// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.database.DataSetObserver;

// Referenced classes of package kankan.wheel.widget:
//            WheelView

class e extends DataSetObserver
{

    final WheelView a;

    e(WheelView wheelview)
    {
        a = wheelview;
        super();
    }

    public void onChanged()
    {
        a.invalidateWheel(false);
    }

    public void onInvalidated()
    {
        a.invalidateWheel(true);
    }
}
