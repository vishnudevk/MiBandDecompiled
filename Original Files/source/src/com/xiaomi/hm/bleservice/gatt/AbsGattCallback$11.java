// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;


// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class val.value
    implements Runnable
{

    final AbsGattCallback this$0;
    final fyCallback val$notifyCB;
    final byte val$value[];

    public void run()
    {
        val$notifyCB.notify(val$value);
    }

    fyCallback()
    {
        this$0 = final_absgattcallback;
        val$notifyCB = fycallback;
        val$value = _5B_B.this;
        super();
    }
}
