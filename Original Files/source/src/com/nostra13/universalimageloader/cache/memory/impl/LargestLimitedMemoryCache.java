// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache
{

    private final Map a = Collections.synchronizedMap(new HashMap());

    public LargestLimitedMemoryCache(int i)
    {
        super(i);
    }

    public void clear()
    {
        a.clear();
        super.clear();
    }

    protected Reference createReference(Bitmap bitmap)
    {
        return new WeakReference(bitmap);
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
            a.put(bitmap, Integer.valueOf(getSize(bitmap)));
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
        Bitmap bitmap = super.get(s);
        if (bitmap != null)
        {
            a.remove(bitmap);
        }
        super.remove(s);
    }

    protected Bitmap removeNext()
    {
        Bitmap bitmap;
        Set set;
        bitmap = null;
        set = a.entrySet();
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = set.iterator();
        Integer integer = null;
_L2:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        Bitmap bitmap1;
        Integer integer1;
        bitmap1 = (Bitmap)entry.getKey();
        integer1 = (Integer)entry.getValue();
        break MISSING_BLOCK_LABEL_160;
        Integer integer2;
        Bitmap bitmap2;
        integer2 = (Integer)entry.getValue();
        if (integer2.intValue() <= integer.intValue())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        bitmap2 = (Bitmap)entry.getKey();
        integer1 = integer2;
        bitmap1 = bitmap2;
        break MISSING_BLOCK_LABEL_160;
        map;
        JVM INSTR monitorexit ;
        a.remove(bitmap);
        return bitmap;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        bitmap1 = bitmap;
        integer1 = integer;
        bitmap = bitmap1;
        integer = integer1;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
