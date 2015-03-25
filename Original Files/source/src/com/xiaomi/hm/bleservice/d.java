// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.xiaomi.hm.bleservice:
//            c, BLEService

class d
    implements Runnable
{

    final Context a;
    final Intent b;
    final c c;

    d(c c1, Context context, Intent intent)
    {
        c = c1;
        a = context;
        b = intent;
        super();
    }

    public void run()
    {
        BLEService.access$100(c.a, a, b);
    }
}
