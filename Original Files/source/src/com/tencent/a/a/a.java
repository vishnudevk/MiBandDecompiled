// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Referenced classes of package com.tencent.a.a:
//            g, e, h, b

public class a extends g
    implements android.os.Handler.Callback
{

    private h a;
    private FileWriter b;
    private File c;
    private char d[];
    private volatile e e;
    private volatile e f;
    private volatile e g;
    private volatile e h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(int l, boolean flag, b b1, h h1)
    {
        super(l, flag, b1);
        i = false;
        a(h1);
        e = new e();
        f = new e();
        g = e;
        h = f;
        d = new char[h1.f()];
        h1.b();
        h();
        j = new HandlerThread(h1.c(), h1.i());
        if (j != null)
        {
            j.start();
        }
        if (j.isAlive() && j.getLooper() != null)
        {
            k = new Handler(j.getLooper(), this);
        }
        f();
    }

    public a(h h1)
    {
        this(63, true, b.a, h1);
    }

    private void f()
    {
        if (k != null)
        {
            k.sendEmptyMessageDelayed(1024, c().g());
        }
    }

    private void g()
    {
        while (Thread.currentThread() != j || i) 
        {
            return;
        }
        i = true;
        j();
        h.a(h(), d);
        h.b();
_L2:
        i = false;
        return;
        IOException ioexception;
        ioexception;
        h.b();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        h.b();
        throw exception;
    }

    private Writer h()
    {
        File file = c().a();
        if (file != null && !file.equals(c))
        {
            c = file;
            i();
            try
            {
                b = new FileWriter(c, true);
            }
            catch (IOException ioexception)
            {
                return null;
            }
        }
        return b;
    }

    private void i()
    {
        try
        {
            if (b != null)
            {
                b.flush();
                b.close();
            }
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        if (g != e)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        g = f;
        h = e;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        g = e;
        h = f;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        if (k.hasMessages(1024))
        {
            k.removeMessages(1024);
        }
    }

    protected void a(int l, Thread thread, long l1, String s, String s1, Throwable throwable)
    {
        a(e().a(l, thread, l1, s, s1, throwable));
    }

    public void a(h h1)
    {
        a = h1;
    }

    protected void a(String s)
    {
        g.a(s);
        if (g.a() >= c().f())
        {
            a();
        }
    }

    public void b()
    {
        i();
        j.quit();
    }

    public h c()
    {
        return a;
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1024 1024: default 24
    //                   1024 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        g();
        f();
        if (true) goto _L1; else goto _L3
_L3:
    }
}
