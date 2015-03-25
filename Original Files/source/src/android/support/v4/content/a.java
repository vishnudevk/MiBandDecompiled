// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.support.v4.content:
//            ModernAsyncTask, AsyncTaskLoader

final class a extends ModernAsyncTask
    implements Runnable
{

    Object a;
    boolean b;
    final AsyncTaskLoader c;
    private CountDownLatch e;

    a(AsyncTaskLoader asynctaskloader)
    {
        c = asynctaskloader;
        super();
        e = new CountDownLatch(1);
    }

    static CountDownLatch a(a a1)
    {
        return a1.e;
    }

    protected volatile Object a(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected transient Object a(Void avoid[])
    {
        a = c.onLoadInBackground();
        return a;
    }

    protected void a()
    {
        c.a(this, a);
        e.countDown();
        return;
        Exception exception;
        exception;
        e.countDown();
        throw exception;
    }

    protected void a(Object obj)
    {
        c.b(this, obj);
        e.countDown();
        return;
        Exception exception;
        exception;
        e.countDown();
        throw exception;
    }

    public void run()
    {
        b = false;
        c.a();
    }
}
