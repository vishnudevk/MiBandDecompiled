// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothDevice;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwUpgradeActivity

class ar
    implements android.view.animation.Animation.AnimationListener
{

    final FwUpgradeActivity a;

    ar(FwUpgradeActivity fwupgradeactivity)
    {
        a = fwupgradeactivity;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        FwUpgradeActivity.i(a).setVisibility(4);
        CustomToast.makeText(FwUpgradeActivity.c(a), a.getString(0x7f0d00b5), 0).show();
        if (FwUpgradeActivity.j(a) != null)
        {
            Utils.removeBond(android/bluetooth/BluetoothDevice, FwUpgradeActivity.j(a));
        }
        a.finish();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
