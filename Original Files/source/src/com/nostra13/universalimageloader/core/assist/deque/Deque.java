// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.Queue;

public interface Deque
    extends Queue
{

    public abstract boolean add(Object obj);

    public abstract void addFirst(Object obj);

    public abstract void addLast(Object obj);

    public abstract boolean contains(Object obj);

    public abstract Iterator descendingIterator();

    public abstract Object element();

    public abstract Object getFirst();

    public abstract Object getLast();

    public abstract Iterator iterator();

    public abstract boolean offer(Object obj);

    public abstract boolean offerFirst(Object obj);

    public abstract boolean offerLast(Object obj);

    public abstract Object peek();

    public abstract Object peekFirst();

    public abstract Object peekLast();

    public abstract Object poll();

    public abstract Object pollFirst();

    public abstract Object pollLast();

    public abstract Object pop();

    public abstract void push(Object obj);

    public abstract Object remove();

    public abstract boolean remove(Object obj);

    public abstract Object removeFirst();

    public abstract boolean removeFirstOccurrence(Object obj);

    public abstract Object removeLast();

    public abstract boolean removeLastOccurrence(Object obj);

    public abstract int size();
}
