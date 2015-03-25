// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

// Referenced classes of package de.greenrobot.event:
//            PendingPostQueue, PendingPost, EventBusException, EventBus, 
//            Subscription

final class HandlerPoster extends Handler
{

    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue = new PendingPostQueue();

    HandlerPoster(EventBus eventbus, Looper looper, int i)
    {
        super(looper);
        eventBus = eventbus;
        maxMillisInsideHandleMessage = i;
    }

    void enqueue(Subscription subscription, Object obj)
    {
        PendingPost pendingpost = PendingPost.obtainPendingPost(subscription, obj);
        this;
        JVM INSTR monitorenter ;
        queue.enqueue(pendingpost);
        if (!handlerActive)
        {
            handlerActive = true;
            if (!sendMessage(obtainMessage()))
            {
                throw new EventBusException("Could not send handler message");
            }
        }
        break MISSING_BLOCK_LABEL_56;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void handleMessage(Message message)
    {
        long l = SystemClock.uptimeMillis();
_L4:
        PendingPost pendingpost = queue.poll();
        if (pendingpost != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        pendingpost = queue.poll();
        if (pendingpost != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        handlerActive = false;
        this;
        JVM INSTR monitorexit ;
        handlerActive = false;
        return;
        this;
        JVM INSTR monitorexit ;
_L2:
        eventBus.invokeSubscriber(pendingpost);
        if (SystemClock.uptimeMillis() - l < (long)maxMillisInsideHandleMessage) goto _L4; else goto _L3
_L3:
        if (!sendMessage(obtainMessage()))
        {
            throw new EventBusException("Could not send handler message");
        }
        break MISSING_BLOCK_LABEL_108;
        Exception exception;
        exception;
        handlerActive = false;
        throw exception;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        handlerActive = true;
        return;
    }
}
