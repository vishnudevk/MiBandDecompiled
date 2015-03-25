// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.support.v4.content:
//            Loader, a, ModernAsyncTask

public abstract class AsyncTaskLoader extends Loader
{

    static final String a = "AsyncTaskLoader";
    static final boolean b;
    volatile a c;
    volatile a d;
    long e;
    long f;
    Handler g;

    public AsyncTaskLoader(Context context)
    {
        super(context);
        f = -10000L;
    }

    void a()
    {
label0:
        {
            if (d == null && c != null)
            {
                if (c.b)
                {
                    c.b = false;
                    g.removeCallbacks(c);
                }
                if (e <= 0L || SystemClock.uptimeMillis() >= f + e)
                {
                    break label0;
                }
                c.b = true;
                g.postAtTime(c, f + e);
            }
            return;
        }
        c.a(ModernAsyncTask.d, (Void[])null);
    }

    void a(a a1, Object obj)
    {
        onCanceled(obj);
        if (d == a1)
        {
            rollbackContentChanged();
            f = SystemClock.uptimeMillis();
            d = null;
            a();
        }
    }

    void b(a a1, Object obj)
    {
        if (c != a1)
        {
            a(a1, obj);
            return;
        }
        if (isAbandoned())
        {
            onCanceled(obj);
            return;
        } else
        {
            commitContentChanged();
            f = SystemClock.uptimeMillis();
            c = null;
            deliverResult(obj);
            return;
        }
    }

    public boolean cancelLoad()
    {
label0:
        {
            if (c != null)
            {
                if (d == null)
                {
                    break label0;
                }
                if (c.b)
                {
                    c.b = false;
                    g.removeCallbacks(c);
                }
                c = null;
            }
            return false;
        }
        if (c.b)
        {
            c.b = false;
            g.removeCallbacks(c);
            c = null;
            return false;
        }
        boolean flag = c.a(false);
        if (flag)
        {
            d = c;
        }
        c = null;
        return flag;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        if (c != null)
        {
            printwriter.print(s);
            printwriter.print("mTask=");
            printwriter.print(c);
            printwriter.print(" waiting=");
            printwriter.println(c.b);
        }
        if (d != null)
        {
            printwriter.print(s);
            printwriter.print("mCancellingTask=");
            printwriter.print(d);
            printwriter.print(" waiting=");
            printwriter.println(d.b);
        }
        if (e != 0L)
        {
            printwriter.print(s);
            printwriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(e, printwriter);
            printwriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(f, SystemClock.uptimeMillis(), printwriter);
            printwriter.println();
        }
    }

    public abstract Object loadInBackground();

    public void onCanceled(Object obj)
    {
    }

    protected void onForceLoad()
    {
        super.onForceLoad();
        cancelLoad();
        c = new a(this);
        a();
    }

    protected Object onLoadInBackground()
    {
        return loadInBackground();
    }

    public void setUpdateThrottle(long l)
    {
        e = l;
        if (l != 0L)
        {
            g = new Handler();
        }
    }

    public void waitForLoader()
    {
        a a1;
        a1 = c;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        android.support.v4.content.a.a(a1).await();
        return;
        InterruptedException interruptedexception;
        interruptedexception;
    }
}
