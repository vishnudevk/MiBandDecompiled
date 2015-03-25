// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;


// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

class g
    implements Runnable
{

    final BLEService a;

    g(BLEService bleservice)
    {
        a = bleservice;
        super();
    }

    public void run()
    {
        a.stopScan();
    }
}
