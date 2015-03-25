// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwUpgradeActivity

class am extends BleCallBack
{

    final FwUpgradeActivity b;

    am(FwUpgradeActivity fwupgradeactivity)
    {
        b = fwupgradeactivity;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        FwUpgradeActivity.a(b, true);
        FwUpgradeActivity.b(b).removeMessages(1);
        FwUpgradeActivity.d(b);
        UmengAnalytics.event(FwUpgradeActivity.c(b), "FirmwareUpgrade", "Failed_2");
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        FwUpgradeActivity.a(b, true);
        FwUpgradeActivity.b(b).removeMessages(1);
        if (((Integer)obj).intValue() == 2)
        {
            FwUpgradeActivity.b(b).sendEmptyMessageDelayed(2, 1000L);
            UmengAnalytics.event(FwUpgradeActivity.c(b), "FirmwareUpgrade", "Successed");
            return;
        } else
        {
            FwUpgradeActivity.d(b);
            UmengAnalytics.event(FwUpgradeActivity.c(b), "FirmwareUpgrade", "Failed_1");
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        FwUpgradeActivity.a(b, false);
        if (BraceletApp.BLEService != null)
        {
            MiLiProfile miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
            if (miliprofile != null)
            {
                FwUpgradeActivity.a(b, miliprofile.getDevice());
            }
        }
        FwUpgradeActivity.b(b).sendEmptyMessage(1);
    }
}
