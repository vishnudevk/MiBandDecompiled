// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            Deque

public interface BlockingDeque
    extends Deque, BlockingQueue
{

    public abstract boolean add(Object obj);

    public abstract void addFirst(Object obj);

    public abstract void addLast(Object obj);

    public abstract boolean contains(Object obj);

    public abstract Object element();

    public abstract Iterator iterator();

    public abstract boolean offer(Object obj);

    public abstract boolean offer(Object obj, long l, TimeUnit timeunit);

    public abstract boolean offerFirst(Object obj);

    public abstract boolean offerFirst(Object obj, long l, TimeUnit timeunit);

    public abstract boolean offerLast(Object obj);

    public abstract boolean offerLast(Object obj, long l, TimeUnit timeunit);

    public abstract Object peek();

    public abstract Object poll();

    public abstract Object poll(long l, TimeUnit timeunit);

    public abstract Object pollFirst(long l, TimeUnit timeunit);

    public abstract Object pollLast(long l, TimeUnit timeunit);

    public abstract void push(Object obj);

    public abstract void put(Object obj);

    public abstract void putFirst(Object obj);

    public abstract void putLast(Object obj);

    public abstract Object remove();

    public abstract boolean remove(Object obj);

    public abstract boolean removeFirstOccurrence(Object obj);

    public abstract boolean removeLastOccurrence(Object obj);

    public abstract int size();

    public abstract Object take();

    public abstract Object takeFirst();

    public abstract Object takeLast();
}
