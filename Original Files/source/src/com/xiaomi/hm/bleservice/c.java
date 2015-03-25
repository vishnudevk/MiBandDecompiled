// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService, d

class c extends BroadcastReceiver
{

    final BLEService a;

    c(BLEService bleservice)
    {
        a = bleservice;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        BLEService.access$200(a).post(new d(this, context, intent));
    }
}
