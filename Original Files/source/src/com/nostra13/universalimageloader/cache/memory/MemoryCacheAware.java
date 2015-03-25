// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory;

import java.util.Collection;

public interface MemoryCacheAware
{

    public abstract void clear();

    public abstract Object get(Object obj);

    public abstract Collection keys();

    public abstract boolean put(Object obj, Object obj1);

    public abstract void remove(Object obj);
}
