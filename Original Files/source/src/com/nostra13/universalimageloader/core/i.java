// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderConfiguration, DefaultConfigurationFactory, j, l, 
//            q

class i
{

    final ImageLoaderConfiguration a;
    private Executor b;
    private Executor c;
    private Executor d;
    private final Map e = Collections.synchronizedMap(new HashMap());
    private final Map f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();

    i(ImageLoaderConfiguration imageloaderconfiguration)
    {
        a = imageloaderconfiguration;
        b = imageloaderconfiguration.g;
        c = imageloaderconfiguration.h;
        d = DefaultConfigurationFactory.createTaskDistributor();
    }

    static void a(i k)
    {
        k.h();
    }

    static Executor b(i k)
    {
        return k.c;
    }

    static Executor c(i k)
    {
        return k.b;
    }

    private void h()
    {
        if (!a.i && ((ExecutorService)b).isShutdown())
        {
            b = i();
        }
        if (!a.j && ((ExecutorService)c).isShutdown())
        {
            c = i();
        }
    }

    private Executor i()
    {
        return DefaultConfigurationFactory.createExecutor(a.k, a.l, a.m);
    }

    String a(ImageAware imageaware)
    {
        return (String)e.get(Integer.valueOf(imageaware.getId()));
    }

    ReentrantLock a(String s)
    {
        ReentrantLock reentrantlock = (ReentrantLock)f.get(s);
        if (reentrantlock == null)
        {
            reentrantlock = new ReentrantLock();
            f.put(s, reentrantlock);
        }
        return reentrantlock;
    }

    void a()
    {
        g.set(true);
    }

    void a(ImageAware imageaware, String s)
    {
        e.put(Integer.valueOf(imageaware.getId()), s);
    }

    void a(l l)
    {
        d.execute(new j(this, l));
    }

    void a(q q)
    {
        h();
        c.execute(q);
    }

    void a(Runnable runnable)
    {
        d.execute(runnable);
    }

    void a(boolean flag)
    {
        h.set(flag);
    }

    void b()
    {
        g.set(false);
        synchronized (j)
        {
            j.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void b(ImageAware imageaware)
    {
        e.remove(Integer.valueOf(imageaware.getId()));
    }

    void b(boolean flag)
    {
        i.set(flag);
    }

    void c()
    {
        if (!a.i)
        {
            ((ExecutorService)b).shutdownNow();
        }
        if (!a.j)
        {
            ((ExecutorService)c).shutdownNow();
        }
        e.clear();
        f.clear();
    }

    AtomicBoolean d()
    {
        return g;
    }

    Object e()
    {
        return j;
    }

    boolean f()
    {
        return h.get();
    }

    boolean g()
    {
        return i.get();
    }
}
