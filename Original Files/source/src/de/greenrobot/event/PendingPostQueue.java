// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


// Referenced classes of package de.greenrobot.event:
//            PendingPost

final class PendingPostQueue
{

    private PendingPost head;
    private PendingPost tail;

    PendingPostQueue()
    {
    }

    void enqueue(PendingPost pendingpost)
    {
        this;
        JVM INSTR monitorenter ;
        if (pendingpost != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("null cannot be enqueued");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (tail == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        tail.next = pendingpost;
        tail = pendingpost;
_L1:
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
label0:
        {
            if (head != null)
            {
                break label0;
            }
            tail = pendingpost;
            head = pendingpost;
        }
          goto _L1
        throw new IllegalStateException("Head present, but no tail");
    }

    PendingPost poll()
    {
        this;
        JVM INSTR monitorenter ;
        PendingPost pendingpost;
        pendingpost = head;
        if (head != null)
        {
            head = head.next;
            if (head == null)
            {
                tail = null;
            }
        }
        this;
        JVM INSTR monitorexit ;
        return pendingpost;
        Exception exception;
        exception;
        throw exception;
    }

    PendingPost poll(int i)
    {
        this;
        JVM INSTR monitorenter ;
        PendingPost pendingpost;
        if (head == null)
        {
            wait(i);
        }
        pendingpost = poll();
        this;
        JVM INSTR monitorexit ;
        return pendingpost;
        Exception exception;
        exception;
        throw exception;
    }
}
