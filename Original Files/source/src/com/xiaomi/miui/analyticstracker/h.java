// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            g, d, Event

class h extends Handler
{

    final g a;

    h(g g1)
    {
        a = g1;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            d.b(a.a);
            return;

        case 2: // '\002'
            d.a(a.a, (Event)message.obj);
            return;

        case 3: // '\003'
            d.c(a.a);
            break;
        }
        d.d(a.a).getLooper().quit();
        d.a(a.a, null);
    }
}
