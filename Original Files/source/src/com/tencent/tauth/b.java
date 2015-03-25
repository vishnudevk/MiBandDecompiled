// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.os.Message;

// Referenced classes of package com.tencent.tauth:
//            LocationApi, LbsAgent

class b
    implements Runnable
{

    final LocationApi a;

    b(LocationApi locationapi)
    {
        a = locationapi;
        super();
    }

    public void run()
    {
        if (LocationApi.b(a).verifyRegCode())
        {
            Message.obtain(LocationApi.c(a), 103).sendToTarget();
            return;
        } else
        {
            Message.obtain(LocationApi.c(a), 104).sendToTarget();
            return;
        }
    }
}
