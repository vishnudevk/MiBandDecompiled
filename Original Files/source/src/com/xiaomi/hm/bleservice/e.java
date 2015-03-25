// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.hm.bleservice.gatt.IGattCallback;
import com.xiaomi.hm.bleservice.util.Debug;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

class e
    implements Runnable
{

    final BLEService a;

    e(BLEService bleservice)
    {
        a = bleservice;
        super();
    }

    public void run()
    {
        if (BLEService.access$300(a) != null && (BLEService.access$300(a).getState() == com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE.CONNECTED || BLEService.access$300(a).getState() == com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE.CONNECTING))
        {
            Debug.WARN((new StringBuilder()).append("Quiting HandlerThread postponed for 500ms... (due to m_State=").append(BLEService.access$300(a).getState()).append(")").toString());
            BLEService.access$200(a).postDelayed(this, 500L);
            return;
        } else
        {
            Debug.DEBUG("Quiting HandlerThread...");
            BLEService.access$400(a).quitSafely();
            return;
        }
    }
}
