// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package kankan.wheel.widget:
//            OnWheelChangedListener, WheelView

class c
    implements OnWheelChangedListener
{

    final WheelView a;

    c(WheelView wheelview)
    {
        a = wheelview;
        super();
    }

    public void onChanged(WheelView wheelview, int i, int j)
    {
        Debug.i("WheelView", (new StringBuilder()).append("newValue=").append(j).toString());
        a.invalidateWheel(true);
    }
}
