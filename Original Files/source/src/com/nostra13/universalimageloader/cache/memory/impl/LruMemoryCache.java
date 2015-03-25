// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LruMemoryCache
    implements MemoryCache
{

    private final LinkedHashMap a;
    private final int b;
    private int c;

    public LruMemoryCache(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            b = i;
            a = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private int a(String s, Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private void a(int i)
    {
_L1:
        this;
        JVM INSTR monitorenter ;
        if (c < 0 || a.isEmpty() && c != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c > i && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        java.util.Map.Entry entry = (java.util.Map.Entry)a.entrySet().iterator().next();
        if (entry != null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        String s = (String)entry.getKey();
        Bitmap bitmap = (Bitmap)entry.getValue();
        a.remove(s);
        c = c - a(s, bitmap);
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public void clear()
    {
        a(-1);
    }

    public final Bitmap get(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)a.get(s);
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public Collection keys()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(a.keySet());
        this;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public final boolean put(String s, Bitmap bitmap)
    {
        if (s == null || bitmap == null)
        {
            throw new NullPointerException("key == null || value == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap1;
        c = c + a(s, bitmap);
        bitmap1 = (Bitmap)a.put(s, bitmap);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        c = c - a(s, bitmap1);
        this;
        JVM INSTR monitorexit ;
        a(b);
        return true;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public final void remove(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)a.remove(s);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        c = c - a(s, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(b);
        s = String.format("LruCache[maxSize=%d]", aobj);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
