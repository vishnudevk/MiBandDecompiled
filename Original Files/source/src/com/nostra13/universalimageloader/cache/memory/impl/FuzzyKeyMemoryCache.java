// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache
    implements MemoryCache
{

    private final MemoryCache a;
    private final Comparator b;

    public FuzzyKeyMemoryCache(MemoryCache memorycache, Comparator comparator)
    {
        a = memorycache;
        b = comparator;
    }

    public void clear()
    {
        a.clear();
    }

    public Bitmap get(String s)
    {
        return (Bitmap)a.get(s);
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public Collection keys()
    {
        return a.keys();
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        MemoryCache memorycache = a;
        memorycache;
        JVM INSTR monitorenter ;
        Iterator iterator = a.keys().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (b.compare(s, s1) != 0) goto _L4; else goto _L3
_L3:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a.remove(s1);
        memorycache;
        JVM INSTR monitorexit ;
        return a.put(s, bitmap);
        Exception exception;
        exception;
        memorycache;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        s1 = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        a.remove(s);
    }
}
