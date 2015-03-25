// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwLowBatteryActivity

class aj
    implements android.view.View.OnClickListener
{

    final FwLowBatteryActivity a;

    aj(FwLowBatteryActivity fwlowbatteryactivity)
    {
        a = fwlowbatteryactivity;
        super();
    }

    public void onClick(View view)
    {
        FwLowBatteryActivity.a(a);
    }
}
