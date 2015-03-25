// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.xiaomi.hm.view:
//            a, GifReDraw

public class GifAnimation
{

    private GifReDraw a;
    private boolean b;
    private Handler c;
    private a d;

    public GifAnimation()
    {
        a = null;
        b = false;
        c = new Handler(Looper.getMainLooper());
        d = new a(this, null);
    }

    static GifReDraw a(GifAnimation gifanimation)
    {
        return gifanimation.a;
    }

    static boolean b(GifAnimation gifanimation)
    {
        return gifanimation.b;
    }

    static a c(GifAnimation gifanimation)
    {
        return gifanimation.d;
    }

    static Handler d(GifAnimation gifanimation)
    {
        return gifanimation.c;
    }

    public void destroy()
    {
        stopAnimation();
        a = null;
    }

    public void pauseAnimation()
    {
        synchronized (d)
        {
            c.removeCallbacks(d);
            b = true;
        }
        return;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void restartAnimation()
    {
        synchronized (d)
        {
            b = false;
            c.post(d);
        }
        return;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void runAnimation()
    {
        b = false;
        c.post(d);
    }

    public void setRedraw(GifReDraw gifredraw)
    {
        a = gifredraw;
    }

    public void stopAnimation()
    {
        pauseAnimation();
    }
}
