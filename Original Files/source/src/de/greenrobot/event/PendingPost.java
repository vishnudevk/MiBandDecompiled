// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package de.greenrobot.event:
//            Subscription

final class PendingPost
{

    private static final List pendingPostPool = new ArrayList();
    Object event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(Object obj, Subscription subscription1)
    {
        event = obj;
        subscription = subscription1;
    }

    static PendingPost obtainPendingPost(Subscription subscription1, Object obj)
    {
        List list = pendingPostPool;
        list;
        JVM INSTR monitorenter ;
        int i = pendingPostPool.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        PendingPost pendingpost;
        pendingpost = (PendingPost)pendingPostPool.remove(i - 1);
        pendingpost.event = obj;
        pendingpost.subscription = subscription1;
        pendingpost.next = null;
        list;
        JVM INSTR monitorexit ;
        return pendingpost;
        list;
        JVM INSTR monitorexit ;
        return new PendingPost(obj, subscription1);
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void releasePendingPost(PendingPost pendingpost)
    {
        pendingpost.event = null;
        pendingpost.subscription = null;
        pendingpost.next = null;
        synchronized (pendingPostPool)
        {
            if (pendingPostPool.size() < 10000)
            {
                pendingPostPool.add(pendingpost);
            }
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
