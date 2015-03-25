// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.AbstractList;
import java.util.Arrays;

public final class CollisionCheckStack extends AbstractList
{

    static final boolean $assertionsDisabled;
    private Object data[];
    private final int initialHash[] = new int[17];
    private boolean latestPushResult;
    private int next[];
    private int size;
    private boolean useIdentity;

    public CollisionCheckStack()
    {
        size = 0;
        latestPushResult = false;
        useIdentity = true;
        data = new Object[16];
        next = new int[16];
    }

    private void expandCapacity()
    {
        int i = data.length;
        int j = i * 2;
        Object aobj[] = new Object[j];
        int ai[] = new int[j];
        System.arraycopy(((Object) (data)), 0, ((Object) (aobj)), 0, i);
        System.arraycopy(next, 0, ai, 0, i);
        data = aobj;
        next = ai;
    }

    private boolean findDuplicate(Object obj, int i)
    {
        int k;
        for (int j = initialHash[i]; j != 0; j = next[k])
        {
            k = j - 1;
            Object obj1 = data[k];
            if (useIdentity ? obj1 == obj : obj.equals(obj1))
            {
                return true;
            }
        }

        return false;
    }

    private int hash(Object obj)
    {
        int i;
        if (useIdentity)
        {
            i = System.identityHashCode(obj);
        } else
        {
            i = obj.hashCode();
        }
        return (i & 0x7fffffff) % initialHash.length;
    }

    public boolean findDuplicate(Object obj)
    {
        return findDuplicate(obj, hash(obj));
    }

    public Object get(int i)
    {
        return data[i];
    }

    public String getCycleString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = -1 + size();
        Object obj = get(i);
        stringbuilder.append(obj);
        Object obj1;
        do
        {
            stringbuilder.append(" -> ");
            i--;
            obj1 = get(i);
            stringbuilder.append(obj1);
        } while (obj != obj1);
        return stringbuilder.toString();
    }

    public boolean getLatestPushResult()
    {
        return latestPushResult;
    }

    public boolean getUseIdentity()
    {
        return useIdentity;
    }

    public Object peek()
    {
        return data[-1 + size];
    }

    public Object pop()
    {
        size = -1 + size;
        Object obj = data[size];
        data[size] = null;
        int i = next[size];
        if (i < 0)
        {
            return obj;
        }
        int j = hash(obj);
        if (!$assertionsDisabled && initialHash[j] != 1 + size)
        {
            throw new AssertionError();
        } else
        {
            initialHash[j] = i;
            return obj;
        }
    }

    public boolean push(Object obj)
    {
        if (data.length == size)
        {
            expandCapacity();
        }
        data[size] = obj;
        int i = hash(obj);
        boolean flag = findDuplicate(obj, i);
        next[size] = initialHash[i];
        initialHash[i] = 1 + size;
        size = 1 + size;
        latestPushResult = flag;
        return latestPushResult;
    }

    public void pushNocheck(Object obj)
    {
        if (data.length == size)
        {
            expandCapacity();
        }
        data[size] = obj;
        next[size] = -1;
        size = 1 + size;
    }

    public void reset()
    {
        if (size > 0)
        {
            size = 0;
            Arrays.fill(initialHash, 0);
        }
    }

    public void setUseIdentity(boolean flag)
    {
        useIdentity = flag;
    }

    public int size()
    {
        return size;
    }

    static 
    {
        boolean flag;
        if (!com/xiaomi/infra/galaxy/common/model/CollisionCheckStack.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
