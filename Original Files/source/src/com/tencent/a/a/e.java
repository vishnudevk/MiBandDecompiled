// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class e
    implements Iterable
{

    private ConcurrentLinkedQueue a;
    private AtomicInteger b;

    public e()
    {
        a = null;
        b = null;
        a = new ConcurrentLinkedQueue();
        b = new AtomicInteger(0);
    }

    public int a()
    {
        return b.get();
    }

    public int a(String s)
    {
        int i = s.length();
        a.add(s);
        return b.addAndGet(i);
    }

    public void a(Writer writer, char ac[])
    {
        if (writer == null || ac == null || ac.length == 0)
        {
            return;
        }
        int i = ac.length;
        Iterator iterator1 = iterator();
        int j = 0;
        int k = i;
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            int l = s.length();
            int i1 = 0;
            while (l > 0) 
            {
                int j1;
                int k1;
                if (k > l)
                {
                    j1 = l;
                } else
                {
                    j1 = k;
                }
                s.getChars(i1, i1 + j1, ac, j);
                k -= j1;
                j += j1;
                l -= j1;
                k1 = j1 + i1;
                if (k == 0)
                {
                    writer.write(ac, 0, i);
                    k = i;
                    i1 = k1;
                    j = 0;
                } else
                {
                    i1 = k1;
                }
            }
        }
        if (j > 0)
        {
            writer.write(ac, 0, j);
        }
        writer.flush();
    }

    public void b()
    {
        a.clear();
        b.set(0);
    }

    public Iterator iterator()
    {
        return a.iterator();
    }
}
