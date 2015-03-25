// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRULimitedMemoryCache extends LimitedMemoryCache
{

    private static final int a = 10;
    private static final float b = 1.1F;
    private final Map c = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));

    public LRULimitedMemoryCache(int i)
    {
        super(i);
    }

    public void clear()
    {
        c.clear();
        super.clear();
    }

    protected Reference createReference(Bitmap bitmap)
    {
        return new WeakReference(bitmap);
    }

    public Bitmap get(String s)
    {
        c.get(s);
        return super.get(s);
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    protected int getSize(Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        if (super.put(s, bitmap))
        {
            c.put(s, bitmap);
            return true;
        } else
        {
            return false;
        }
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        c.remove(s);
        super.remove(s);
    }

    protected Bitmap removeNext()
    {
        Map map = c;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator;
        boolean flag;
        iterator = c.entrySet().iterator();
        flag = iterator.hasNext();
        Bitmap bitmap;
        bitmap = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        bitmap = (Bitmap)((java.util.Map.Entry)iterator.next()).getValue();
        iterator.remove();
        map;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
