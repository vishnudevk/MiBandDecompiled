// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;


// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class this._cls0
    implements Runnable
{

    final AbsGattCallback this$0;

    public void run()
    {
        disconnectInternal();
    }

    ()
    {
        this$0 = AbsGattCallback.this;
        super();
    }
}
