// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LruCache
{

    private final LinkedHashMap a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public LruCache(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            c = i;
            a = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private int a(Object obj, Object obj1)
    {
        int i = sizeOf(obj, obj1);
        if (i < 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("Negative size: ").append(obj).append("=").append(obj1).toString());
        } else
        {
            return i;
        }
    }

    protected Object create(Object obj)
    {
        return null;
    }

    public final int createCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = e;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
    }

    public final void evictAll()
    {
        trimToSize(-1);
    }

    public final int evictionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = f;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object get(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Object obj1 = a.get(obj);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        g = 1 + g;
        this;
        JVM INSTR monitorexit ;
        return obj1;
        h = 1 + h;
        this;
        JVM INSTR monitorexit ;
        Object obj2;
        obj2 = create(obj);
        if (obj2 == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_74;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorenter ;
        Object obj3;
        e = 1 + e;
        obj3 = a.put(obj, obj2);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        a.put(obj, obj3);
_L1:
        this;
        JVM INSTR monitorexit ;
        Exception exception1;
        if (obj3 != null)
        {
            entryRemoved(false, obj, obj2, obj3);
            return obj3;
        } else
        {
            trimToSize(c);
            return obj2;
        }
        b = b + a(obj, obj2);
          goto _L1
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final int hitCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = g;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int maxSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i = c;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int missCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = h;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null || obj1 == null)
        {
            throw new NullPointerException("key == null || value == null");
        }
        this;
        JVM INSTR monitorenter ;
        Object obj2;
        d = 1 + d;
        b = b + a(obj, obj1);
        obj2 = a.put(obj, obj1);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        b = b - a(obj, obj2);
        this;
        JVM INSTR monitorexit ;
        if (obj2 != null)
        {
            entryRemoved(false, obj, obj2, obj1);
        }
        trimToSize(c);
        return obj2;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int putCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = d;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object remove(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Object obj1 = a.remove(obj);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        b = b - a(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            entryRemoved(false, obj, obj1, null);
        }
        return obj1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i = b;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return 1;
    }

    public final Map snapshot()
    {
        this;
        JVM INSTR monitorenter ;
        LinkedHashMap linkedhashmap = new LinkedHashMap(a);
        this;
        JVM INSTR monitorexit ;
        return linkedhashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        int i = g + h;
        int j;
        j = 0;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        j = (100 * g) / i;
        String s;
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(c);
        aobj[1] = Integer.valueOf(g);
        aobj[2] = Integer.valueOf(h);
        aobj[3] = Integer.valueOf(j);
        s = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", aobj);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void trimToSize(int i)
    {
_L2:
        this;
        JVM INSTR monitorenter ;
        if (b < 0 || a.isEmpty() && b != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (b > i && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        Object obj1;
        java.util.Map.Entry entry = (java.util.Map.Entry)a.entrySet().iterator().next();
        obj = entry.getKey();
        obj1 = entry.getValue();
        a.remove(obj);
        b = b - a(obj, obj1);
        f = 1 + f;
        this;
        JVM INSTR monitorexit ;
        entryRemoved(true, obj, obj1, null);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
