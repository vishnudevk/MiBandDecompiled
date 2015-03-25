// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.util.concurrent.ExecutorService;

// Referenced classes of package de.greenrobot.event:
//            PendingPostQueue, PendingPost, EventBus, Subscription

class AsyncPoster
    implements Runnable
{

    private final EventBus eventBus;
    private final PendingPostQueue queue = new PendingPostQueue();

    AsyncPoster(EventBus eventbus)
    {
        eventBus = eventbus;
    }

    public void enqueue(Subscription subscription, Object obj)
    {
        PendingPost pendingpost = PendingPost.obtainPendingPost(subscription, obj);
        queue.enqueue(pendingpost);
        EventBus.executorService.execute(this);
    }

    public void run()
    {
        PendingPost pendingpost = queue.poll();
        if (pendingpost == null)
        {
            throw new IllegalStateException("No pending post available");
        } else
        {
            eventBus.invokeSubscriber(pendingpost);
            return;
        }
    }
}
