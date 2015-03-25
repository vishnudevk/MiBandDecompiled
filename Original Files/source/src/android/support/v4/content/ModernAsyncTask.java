// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v4.content:
//            o, t, p, q, 
//            s, r, u

abstract class ModernAsyncTask
{

    private static final String a = "AsyncTask";
    private static final int b = 5;
    private static final int c = 128;
    public static final Executor d;
    private static final int e = 1;
    private static final ThreadFactory f;
    private static final BlockingQueue g;
    private static final int h = 1;
    private static final int i = 2;
    private static final t j = new t(null);
    private static volatile Executor k;
    private final u l = new p(this);
    private final FutureTask m;
    private volatile Status n;
    private final AtomicBoolean o = new AtomicBoolean();

    public ModernAsyncTask()
    {
        n = Status.PENDING;
        m = new q(this, l);
    }

    static Object a(ModernAsyncTask modernasynctask, Object obj)
    {
        return modernasynctask.d(obj);
    }

    static AtomicBoolean a(ModernAsyncTask modernasynctask)
    {
        return modernasynctask.o;
    }

    public static void a(Runnable runnable)
    {
        k.execute(runnable);
    }

    public static void a(Executor executor)
    {
        k = executor;
    }

    public static void b()
    {
        j.getLooper();
    }

    static void b(ModernAsyncTask modernasynctask, Object obj)
    {
        modernasynctask.c(obj);
    }

    static void c(ModernAsyncTask modernasynctask, Object obj)
    {
        modernasynctask.e(obj);
    }

    private void c(Object obj)
    {
        if (!o.get())
        {
            d(obj);
        }
    }

    private Object d(Object obj)
    {
        j.obtainMessage(1, new s(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void e(Object obj)
    {
        if (e())
        {
            b(obj);
        } else
        {
            a(obj);
        }
        n = Status.FINISHED;
    }

    public final transient ModernAsyncTask a(Executor executor, Object aobj[])
    {
        if (n == Status.PENDING) goto _L2; else goto _L1
_L1:
        r.a[n.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        n = Status.RUNNING;
        d();
        l.b = aobj;
        executor.execute(m);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public final Object a(long l1, TimeUnit timeunit)
    {
        return m.get(l1, timeunit);
    }

    protected transient abstract Object a(Object aobj[]);

    protected void a()
    {
    }

    protected void a(Object obj)
    {
    }

    public final boolean a(boolean flag)
    {
        return m.cancel(flag);
    }

    protected void b(Object obj)
    {
        a();
    }

    protected transient void b(Object aobj[])
    {
    }

    public final Status c()
    {
        return n;
    }

    public final transient ModernAsyncTask c(Object aobj[])
    {
        return a(k, aobj);
    }

    protected void d()
    {
    }

    protected final transient void d(Object aobj[])
    {
        if (!e())
        {
            j.obtainMessage(2, new s(this, aobj)).sendToTarget();
        }
    }

    public final boolean e()
    {
        return m.isCancelled();
    }

    public final Object f()
    {
        return m.get();
    }

    static 
    {
        f = new o();
        g = new LinkedBlockingQueue(10);
        d = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, g, f);
        k = d;
    }

    private class Status extends Enum
    {

        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;
        private static final Status a[];

        public static Status valueOf(String s1)
        {
            return (Status)Enum.valueOf(android/support/v4/content/ModernAsyncTask$Status, s1);
        }

        public static Status[] values()
        {
            return (Status[])a.clone();
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            FINISHED = new Status("FINISHED", 2);
            Status astatus[] = new Status[3];
            astatus[0] = PENDING;
            astatus[1] = RUNNING;
            astatus[2] = FINISHED;
            a = astatus;
        }

        private Status(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
