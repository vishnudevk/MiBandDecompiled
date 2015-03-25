// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.SystemClock;

// Referenced classes of package com.xiaomi.hm.view:
//            GifAnimation, GifReDraw

class a
    implements Runnable
{

    final GifAnimation a;

    private a(GifAnimation gifanimation)
    {
        a = gifanimation;
        super();
    }

    a(GifAnimation gifanimation, a a1)
    {
        this(gifanimation);
    }

    public void run()
    {
        int i = GifAnimation.a(a).reDraw();
        if (!GifAnimation.b(a))
        {
            if (i > 0)
            {
                SystemClock.sleep(i);
            }
            synchronized (GifAnimation.c(a))
            {
                if (!GifAnimation.b(a))
                {
                    GifAnimation.d(a).post(GifAnimation.c(a));
                }
            }
            return;
        } else
        {
            return;
        }
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
