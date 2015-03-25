// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class e
{

    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static long b = 5L;
    private static ExecutorService c = Executors.newSingleThreadExecutor();

    public e()
    {
    }

    public static void a()
    {
        try
        {
            if (!a.isShutdown())
            {
                a.shutdown();
            }
            if (!c.isShutdown())
            {
                c.shutdown();
            }
            a.awaitTermination(b, TimeUnit.SECONDS);
            c.awaitTermination(b, TimeUnit.SECONDS);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static void a(Runnable runnable)
    {
        if (a.isShutdown())
        {
            a = Executors.newSingleThreadExecutor();
        }
        a.execute(runnable);
    }

    public static void b(Runnable runnable)
    {
        if (c.isShutdown())
        {
            c = Executors.newSingleThreadExecutor();
        }
        c.execute(runnable);
    }

}
