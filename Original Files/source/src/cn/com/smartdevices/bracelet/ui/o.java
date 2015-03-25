// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            n, BaseSCActivity

class o extends BleCallBack
{

    final n b;

    o(n n1)
    {
        b = n1;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        if (obj == null)
        {
            return;
        }
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo = (com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo)obj;
        byte byte0 = 5;
        if (batteryinfo.status == 2)
        {
            byte0 = 10;
        }
        if (batteryinfo.level <= byte0)
        {
            BaseSCActivity.e(b.a);
            return;
        } else
        {
            BaseSCActivity.f(b.a);
            return;
        }
    }
}
