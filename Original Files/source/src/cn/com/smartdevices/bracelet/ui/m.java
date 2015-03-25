// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseBleActivity

class m extends BleCallBack
{

    final int b;
    final android.os.PowerManager.WakeLock c;
    final BaseBleActivity d;

    m(BaseBleActivity basebleactivity, int i, android.os.PowerManager.WakeLock wakelock)
    {
        d = basebleactivity;
        b = i;
        c = wakelock;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        Debug.f(BaseBleActivity.a(d), (new StringBuilder()).append("setLatency failed......").append(b).toString());
        Debug.f(BaseBleActivity.a(d), (new StringBuilder()).append("waklock release......").append(b).toString());
        if (c.isHeld())
        {
            c.release();
        }
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        if (((Integer)obj).intValue() == 8)
        {
            Debug.f(BaseBleActivity.a(d), (new StringBuilder()).append("setLatency success......").append(b).toString());
        } else
        {
            Debug.f(BaseBleActivity.a(d), (new StringBuilder()).append("setLatency failed......").append(b).toString());
        }
        Debug.f(BaseBleActivity.a(d), (new StringBuilder()).append("waklock release......").append(b).toString());
        if (c.isHeld())
        {
            c.release();
        }
    }

    public void onStart()
    {
        super.onStart();
    }
}
