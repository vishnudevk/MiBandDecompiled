// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.identityscope;


public interface IdentityScope
{

    public abstract void clear();

    public abstract boolean detach(Object obj, Object obj1);

    public abstract Object get(Object obj);

    public abstract Object getNoLock(Object obj);

    public abstract void lock();

    public abstract void put(Object obj, Object obj1);

    public abstract void putNoLock(Object obj, Object obj1);

    public abstract void remove(Iterable iterable);

    public abstract void remove(Object obj);

    public abstract void reserveRoom(int i);

    public abstract void unlock();
}
