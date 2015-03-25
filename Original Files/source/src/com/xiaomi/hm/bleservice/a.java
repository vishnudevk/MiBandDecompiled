// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import com.xiaomi.hm.bleservice.util.Debug;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

class a
    implements Thread.UncaughtExceptionHandler
{

    final BLEService a;

    a(BLEService bleservice)
    {
        a = bleservice;
        super();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Debug.TRACE();
        throwable.printStackTrace();
    }
}
