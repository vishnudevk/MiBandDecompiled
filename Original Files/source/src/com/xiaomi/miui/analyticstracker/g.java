// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.os.Looper;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            d, h, e

class g extends Thread
{

    final d a;

    private g(d d1)
    {
        a = d1;
        super();
    }

    g(d d1, e e)
    {
        this(d1);
    }

    public void run()
    {
        Looper.prepare();
        synchronized (d.a(a))
        {
            d.a(a, new h(this));
            d.a(a).notify();
        }
        Looper.loop();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
