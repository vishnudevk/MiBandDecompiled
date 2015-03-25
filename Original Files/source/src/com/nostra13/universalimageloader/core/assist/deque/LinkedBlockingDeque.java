// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            BlockingDeque, e, c, d

public class LinkedBlockingDeque extends AbstractQueue
    implements BlockingDeque, Serializable
{

    private static final long serialVersionUID = 0xfa9ddc6ce257fe26L;
    transient e a;
    transient e b;
    final ReentrantLock c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    public LinkedBlockingDeque()
    {
        this(0x7fffffff);
    }

    public LinkedBlockingDeque(int i)
    {
        c = new ReentrantLock();
        f = c.newCondition();
        g = c.newCondition();
        if (i <= 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            e = i;
            return;
        }
    }

    public LinkedBlockingDeque(Collection collection)
    {
        ReentrantLock reentrantlock;
        this(0x7fffffff);
        reentrantlock = c;
        reentrantlock.lock();
        Iterator iterator1 = collection.iterator();
_L2:
        Object obj;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = iterator1.next();
        if (obj != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        throw new NullPointerException();
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        if (c(new e(obj))) goto _L2; else goto _L1
_L1:
        throw new IllegalStateException("Deque full");
        reentrantlock.unlock();
        return;
    }

    private Object a()
    {
        e e1 = a;
        if (e1 == null)
        {
            return null;
        }
        e e2 = e1.c;
        Object obj = e1.a;
        e1.a = null;
        e1.c = e1;
        a = e2;
        if (e2 == null)
        {
            b = null;
        } else
        {
            e2.b = null;
        }
        d = -1 + d;
        g.signal();
        return obj;
    }

    private Object b()
    {
        e e1 = b;
        if (e1 == null)
        {
            return null;
        }
        e e2 = e1.b;
        Object obj = e1.a;
        e1.a = null;
        e1.b = e1;
        b = e2;
        if (e2 == null)
        {
            a = null;
        } else
        {
            e2.c = null;
        }
        d = -1 + d;
        g.signal();
        return obj;
    }

    private boolean b(e e1)
    {
        if (d >= e)
        {
            return false;
        }
        e e2 = a;
        e1.c = e2;
        a = e1;
        if (b == null)
        {
            b = e1;
        } else
        {
            e2.b = e1;
        }
        d = 1 + d;
        f.signal();
        return true;
    }

    private boolean c(e e1)
    {
        if (d >= e)
        {
            return false;
        }
        e e2 = b;
        e1.b = e2;
        b = e1;
        if (a == null)
        {
            a = e1;
        } else
        {
            e2.c = e1;
        }
        d = 1 + d;
        f.signal();
        return true;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        d = 0;
        a = null;
        b = null;
        do
        {
            Object obj = objectinputstream.readObject();
            if (obj == null)
            {
                return;
            }
            add(obj);
        } while (true);
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        e e1;
        objectoutputstream.defaultWriteObject();
        e1 = a;
_L1:
        if (e1 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        objectoutputstream.writeObject(e1.a);
        e1 = e1.c;
          goto _L1
        objectoutputstream.writeObject(null);
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    void a(e e1)
    {
        e e2 = e1.b;
        e e3 = e1.c;
        if (e2 == null)
        {
            a();
            return;
        }
        if (e3 == null)
        {
            b();
            return;
        } else
        {
            e2.c = e3;
            e3.b = e2;
            e1.a = null;
            d = -1 + d;
            g.signal();
            return;
        }
    }

    public boolean add(Object obj)
    {
        addLast(obj);
        return true;
    }

    public void addFirst(Object obj)
    {
        if (!offerFirst(obj))
        {
            throw new IllegalStateException("Deque full");
        } else
        {
            return;
        }
    }

    public void addLast(Object obj)
    {
        if (!offerLast(obj))
        {
            throw new IllegalStateException("Deque full");
        } else
        {
            return;
        }
    }

    public void clear()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        e e2;
        e1.a = null;
        e2 = e1.c;
        e1.b = null;
        e1.c = null;
        e1 = e2;
        if (true) goto _L2; else goto _L1
_L1:
        b = null;
        a = null;
        d = 0;
        g.signalAll();
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean contains(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = obj.equals(e1.a);
        if (flag)
        {
            reentrantlock.unlock();
            return true;
        }
        e1 = e1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Iterator descendingIterator()
    {
        return new c(this, null);
    }

    public int drainTo(Collection collection)
    {
        return drainTo(collection, 0x7fffffff);
    }

    public int drainTo(Collection collection, int i)
    {
        ReentrantLock reentrantlock;
        if (collection == null)
        {
            throw new NullPointerException();
        }
        if (collection == this)
        {
            throw new IllegalArgumentException();
        }
        reentrantlock = c;
        reentrantlock.lock();
        int j = Math.min(i, d);
        int k = 0;
_L2:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        collection.add(a.a);
        a();
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return j;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object element()
    {
        return getFirst();
    }

    public Object getFirst()
    {
        Object obj = peekFirst();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public Object getLast()
    {
        Object obj = peekLast();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public Iterator iterator()
    {
        return new d(this, null);
    }

    public boolean offer(Object obj)
    {
        return offerLast(obj);
    }

    public boolean offer(Object obj, long l, TimeUnit timeunit)
    {
        return offerLast(obj, l, timeunit);
    }

    public boolean offerFirst(Object obj)
    {
        e e1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        reentrantlock = c;
        reentrantlock.lock();
        boolean flag = b(e1);
        reentrantlock.unlock();
        return flag;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean offerFirst(Object obj, long l, TimeUnit timeunit)
    {
        e e1;
        long l1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
_L2:
        boolean flag = b(e1);
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l1 <= 0L)
        {
            reentrantlock.unlock();
            return false;
        }
        long l2 = g.awaitNanos(l1);
        l1 = l2;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return true;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean offerLast(Object obj)
    {
        e e1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        reentrantlock = c;
        reentrantlock.lock();
        boolean flag = c(e1);
        reentrantlock.unlock();
        return flag;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean offerLast(Object obj, long l, TimeUnit timeunit)
    {
        e e1;
        long l1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
_L2:
        boolean flag = c(e1);
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l1 <= 0L)
        {
            reentrantlock.unlock();
            return false;
        }
        long l2 = g.awaitNanos(l1);
        l1 = l2;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return true;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object peek()
    {
        return peekFirst();
    }

    public Object peekFirst()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = a;
        if (e1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        reentrantlock.unlock();
        return obj;
_L2:
        obj = a.a;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object peekLast()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = b;
        if (e1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        reentrantlock.unlock();
        return obj;
_L2:
        obj = b.a;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object poll()
    {
        return pollFirst();
    }

    public Object poll(long l, TimeUnit timeunit)
    {
        return pollFirst(l, timeunit);
    }

    public Object pollFirst()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = a();
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object pollFirst(long l, TimeUnit timeunit)
    {
        ReentrantLock reentrantlock;
        long l2;
        long l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
        l2 = l1;
_L2:
        Object obj = a();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l2 <= 0L)
        {
            reentrantlock.unlock();
            return null;
        }
        long l3 = f.awaitNanos(l2);
        l2 = l3;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object pollLast()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = b();
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object pollLast(long l, TimeUnit timeunit)
    {
        ReentrantLock reentrantlock;
        long l2;
        long l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
        l2 = l1;
_L2:
        Object obj = b();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l2 <= 0L)
        {
            reentrantlock.unlock();
            return null;
        }
        long l3 = f.awaitNanos(l2);
        l2 = l3;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object pop()
    {
        return removeFirst();
    }

    public void push(Object obj)
    {
        addFirst(obj);
    }

    public void put(Object obj)
    {
        putLast(obj);
    }

    public void putFirst(Object obj)
    {
        e e1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        reentrantlock = c;
        reentrantlock.lock();
        for (; !b(e1); g.await()) { }
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return;
    }

    public void putLast(Object obj)
    {
        e e1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        e1 = new e(obj);
        reentrantlock = c;
        reentrantlock.lock();
        for (; !c(e1); g.await()) { }
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return;
    }

    public int remainingCapacity()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i;
        int j;
        i = e;
        j = d;
        int k = i - j;
        reentrantlock.unlock();
        return k;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object remove()
    {
        return removeFirst();
    }

    public boolean remove(Object obj)
    {
        return removeFirstOccurrence(obj);
    }

    public Object removeFirst()
    {
        Object obj = pollFirst();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public boolean removeFirstOccurrence(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = a;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(e1.a))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a(e1);
        reentrantlock.unlock();
        return true;
        e1 = e1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object removeLast()
    {
        Object obj = pollLast();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public boolean removeLastOccurrence(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = b;
_L2:
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(e1.a))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a(e1);
        reentrantlock.unlock();
        return true;
        e1 = e1.b;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public int size()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i = d;
        reentrantlock.unlock();
        return i;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object take()
    {
        return takeFirst();
    }

    public Object takeFirst()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
_L1:
        Object obj = a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        f.await();
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return obj;
    }

    public Object takeLast()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
_L1:
        Object obj = b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        f.await();
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return obj;
    }

    public Object[] toArray()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object aobj[] = new Object[d];
        int i = 0;
        e e1 = a;
_L2:
        int j;
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
        aobj[i] = e1.a;
        e1 = e1.c;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return aobj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object[] toArray(Object aobj[])
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        if (aobj.length < d)
        {
            aobj = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), d);
        }
        int i = 0;
        e e1 = a;
_L2:
        int j;
        if (e1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
        aobj[i] = e1.a;
        e1 = e1.c;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (aobj.length > i)
        {
            aobj[i] = null;
        }
        reentrantlock.unlock();
        return aobj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public String toString()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        e e1 = a;
        if (e1 == null)
        {
            reentrantlock.unlock();
            return "[]";
        }
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append('[');
        e e2 = e1;
_L1:
        Object obj = e2.a;
        if (obj == this)
        {
            obj = "(this Collection)";
        }
        e e3;
        stringbuilder.append(obj);
        e3 = e2.c;
        if (e3 != null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        String s = stringbuilder.append(']').toString();
        reentrantlock.unlock();
        return s;
        stringbuilder.append(',').append(' ');
        e2 = e3;
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
