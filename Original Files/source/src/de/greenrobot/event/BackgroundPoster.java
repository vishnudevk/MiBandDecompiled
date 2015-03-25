// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import android.util.Log;
import java.util.concurrent.ExecutorService;

// Referenced classes of package de.greenrobot.event:
//            PendingPostQueue, PendingPost, EventBus, Subscription

final class BackgroundPoster
    implements Runnable
{

    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue = new PendingPostQueue();

    BackgroundPoster(EventBus eventbus)
    {
        eventBus = eventbus;
    }

    public void enqueue(Subscription subscription, Object obj)
    {
        PendingPost pendingpost = PendingPost.obtainPendingPost(subscription, obj);
        this;
        JVM INSTR monitorenter ;
        queue.enqueue(pendingpost);
        if (!executorRunning)
        {
            executorRunning = true;
            EventBus.executorService.execute(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
_L4:
        PendingPost pendingpost = queue.poll(1000);
        if (pendingpost != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        pendingpost = queue.poll();
        if (pendingpost != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        executorRunning = false;
        this;
        JVM INSTR monitorexit ;
        executorRunning = false;
        return;
        this;
        JVM INSTR monitorexit ;
_L2:
        eventBus.invokeSubscriber(pendingpost);
        if (true) goto _L4; else goto _L3
_L3:
        InterruptedException interruptedexception;
        interruptedexception;
        Log.w("Event", (new StringBuilder(String.valueOf(Thread.currentThread().getName()))).append(" was interruppted").toString(), interruptedexception);
        executorRunning = false;
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        executorRunning = false;
        throw exception;
    }
}
