// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.nostra13.universalimageloader.cache.memory:
//            BaseMemoryCache

public abstract class LimitedMemoryCache extends BaseMemoryCache
{

    private static final int a = 16;
    private static final int b = 0x1000000;
    private final int c;
    private final AtomicInteger d = new AtomicInteger();
    private final List e = Collections.synchronizedList(new LinkedList());

    public LimitedMemoryCache(int i)
    {
        c = i;
        if (i > 0x1000000)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(16);
            L.w("You set too large memory cache size (more than %1$d Mb)", aobj);
        }
    }

    public void clear()
    {
        e.clear();
        d.set(0);
        super.clear();
    }

    protected abstract int getSize(Bitmap bitmap);

    protected int getSizeLimit()
    {
        return c;
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        int i = getSize(bitmap);
        int j = getSizeLimit();
        int k = d.get();
        boolean flag = false;
        if (i < j)
        {
            int l = k;
            do
            {
                if (l + i <= j)
                {
                    break;
                }
                Bitmap bitmap1 = removeNext();
                if (e.remove(bitmap1))
                {
                    l = d.addAndGet(-getSize(bitmap1));
                }
            } while (true);
            e.add(bitmap);
            d.addAndGet(i);
            flag = true;
        }
        super.put(s, bitmap);
        return flag;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        Bitmap bitmap = super.get(s);
        if (bitmap != null && e.remove(bitmap))
        {
            d.addAndGet(-getSize(bitmap));
        }
        super.remove(s);
    }

    protected abstract Bitmap removeNext();
}
