// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import java.util.NoSuchElementException;

// Referenced classes of package de.greenrobot.dao.query:
//            CloseableListIterator, LazyList

public class closeWhenDone
    implements CloseableListIterator
{

    private final boolean closeWhenDone;
    private int index;
    final LazyList this$0;

    public void add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public void close()
    {
        LazyList.this.close();
    }

    public boolean hasNext()
    {
        return index < LazyList.access$000(LazyList.this);
    }

    public boolean hasPrevious()
    {
        return index > 0;
    }

    public Object next()
    {
        if (index >= LazyList.access$000(LazyList.this))
        {
            throw new NoSuchElementException();
        }
        Object obj = get(index);
        index = 1 + index;
        if (index == LazyList.access$000(LazyList.this) && closeWhenDone)
        {
            close();
        }
        return obj;
    }

    public int nextIndex()
    {
        return index;
    }

    public Object previous()
    {
        if (index <= 0)
        {
            throw new NoSuchElementException();
        } else
        {
            index = -1 + index;
            return get(index);
        }
    }

    public int previousIndex()
    {
        return -1 + index;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public void set(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public (int i, boolean flag)
    {
        this$0 = LazyList.this;
        super();
        index = i;
        closeWhenDone = flag;
    }
}
