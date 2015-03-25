// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseBleActivity

class l extends BleCallBack
{

    final BaseBleActivity b;

    l(BaseBleActivity basebleactivity)
    {
        b = basebleactivity;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        b.onTogglePairResult(null);
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        b.onTogglePairResult((com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo)obj);
    }

    public void onProgress(int i)
    {
        super.onProgress(i);
        b.onTogglePairProgress(i);
    }
}
