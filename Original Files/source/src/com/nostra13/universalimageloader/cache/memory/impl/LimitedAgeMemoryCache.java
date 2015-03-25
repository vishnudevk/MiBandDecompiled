// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache
    implements MemoryCache
{

    private final MemoryCache a;
    private final long b;
    private final Map c = Collections.synchronizedMap(new HashMap());

    public LimitedAgeMemoryCache(MemoryCache memorycache, long l)
    {
        a = memorycache;
        b = 1000L * l;
    }

    public void clear()
    {
        a.clear();
        c.clear();
    }

    public Bitmap get(String s)
    {
        Long long1 = (Long)c.get(s);
        if (long1 != null && System.currentTimeMillis() - long1.longValue() > b)
        {
            a.remove(s);
            c.remove(s);
        }
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
        boolean flag = a.put(s, bitmap);
        if (flag)
        {
            c.put(s, Long.valueOf(System.currentTimeMillis()));
        }
        return flag;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        a.remove(s);
        c.remove(s);
    }
}
