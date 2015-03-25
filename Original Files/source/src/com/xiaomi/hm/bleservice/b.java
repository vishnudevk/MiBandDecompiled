// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

class b extends Handler
{

    final BLEService a;

    b(BLEService bleservice, Looper looper)
    {
        a = bleservice;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        BLEService.access$000(a, message);
    }
}
