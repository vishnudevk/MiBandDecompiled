// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.os.Binder;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            BLEService

public final class a extends Binder
{

    final BLEService a;

    public BLEService getService()
    {
        return a;
    }

    public (BLEService bleservice)
    {
        a = bleservice;
        super();
    }
}
