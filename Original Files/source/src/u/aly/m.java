// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import com.umeng.analytics.AnalyticsConfig;

// Referenced classes of package u.aly:
//            t

public class m
    implements Thread.UncaughtExceptionHandler
{

    private Thread.UncaughtExceptionHandler a;
    private t b;

    public m()
    {
        if (Thread.getDefaultUncaughtExceptionHandler() == this)
        {
            return;
        } else
        {
            a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            return;
        }
    }

    private void a(Throwable throwable)
    {
        if (AnalyticsConfig.CATCH_EXCEPTION)
        {
            b.a(throwable);
            return;
        } else
        {
            b.a(null);
            return;
        }
    }

    public void a(t t1)
    {
        b = t1;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        a(throwable);
        if (a != null && a != Thread.getDefaultUncaughtExceptionHandler())
        {
            a.uncaughtException(thread, throwable);
        }
    }
}
