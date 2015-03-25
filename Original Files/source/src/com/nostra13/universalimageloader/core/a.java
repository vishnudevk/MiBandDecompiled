// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class a
    implements ThreadFactory
{

    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;

    a(int i, String s)
    {
        e = i;
        SecurityManager securitymanager = System.getSecurityManager();
        ThreadGroup threadgroup;
        if (securitymanager != null)
        {
            threadgroup = securitymanager.getThreadGroup();
        } else
        {
            threadgroup = Thread.currentThread().getThreadGroup();
        }
        b = threadgroup;
        d = (new StringBuilder()).append(s).append(a.getAndIncrement()).append("-thread-").toString();
    }

    public Thread newThread(Runnable runnable)
    {
        Thread thread = new Thread(b, runnable, (new StringBuilder()).append(d).append(c.getAndIncrement()).toString(), 0L);
        if (thread.isDaemon())
        {
            thread.setDaemon(false);
        }
        thread.setPriority(e);
        return thread;
    }

}
