// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.xiaomi.channel.sdk:
//            MLShareApiFactory

class g
    implements Runnable
{

    final MLShareApiFactory a;
    private final Intent b;

    g(MLShareApiFactory mlshareapifactory, Intent intent)
    {
        a = mlshareapifactory;
        b = intent;
        super();
    }

    public void run()
    {
        MLShareApiFactory.a(a).sendBroadcast(b);
    }
}
