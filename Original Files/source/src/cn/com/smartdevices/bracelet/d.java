// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import cn.com.smartdevices.bracelet.BleTask.BleInComingCallTask;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            UmengAnalytics

final class d extends TimerTask
{

    final WeakReference a;

    d(WeakReference weakreference)
    {
        a = weakreference;
        super();
    }

    public void run()
    {
        if (a.get() != null)
        {
            UmengAnalytics.event((Context)a.get(), "IncomingCall", "CallNotify");
        }
        (new BleInComingCallTask(null)).work();
    }
}
