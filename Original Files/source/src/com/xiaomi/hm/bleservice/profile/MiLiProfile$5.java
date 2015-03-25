// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.util.Debug;

// Referenced classes of package com.xiaomi.hm.bleservice.profile:
//            MiLiProfile

class this._cls0
    implements com.xiaomi.hm.bleservice.gatt.INotifyCallback
{

    final MiLiProfile this$0;

    public void notify(byte abyte0[])
    {
        byte byte0;
        int i;
        boolean flag;
        if (abyte0.length == 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        byte0 = abyte0[9];
        i = 0xff & abyte0[0];
        byte0;
        JVM INSTR tableswitch 0 4: default 64
    //                   0 75
    //                   1 139
    //                   2 147
    //                   3 155
    //                   4 163;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Debug.WARN(">>> UNEXPECTED <<<");
        return;
_L2:
        Debug.WARN(">>> UNEXPECTED <<<");
_L8:
        Intent intent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
        intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
        intent.putExtra(BLEService.INTENT_EXTRA_PARAM, byte0);
        intent.putExtra(BLEService.INTENT_EXTRA_PARAM_EXT, i);
        BLEService.getBroadcastManager().sendBroadcast(intent);
        return;
_L3:
        Debug.DEBUG("Battery low");
        continue; /* Loop/switch isn't completed */
_L4:
        Debug.DEBUG("Battery charging");
        continue; /* Loop/switch isn't completed */
_L5:
        Debug.DEBUG("Battery full (charging)");
        continue; /* Loop/switch isn't completed */
_L6:
        Debug.DEBUG("Battery charger off");
        if (true) goto _L8; else goto _L7
_L7:
    }

    r()
    {
        this$0 = MiLiProfile.this;
        super();
    }
}
