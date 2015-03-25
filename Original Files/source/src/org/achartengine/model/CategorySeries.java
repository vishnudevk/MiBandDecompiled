// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.achartengine.model:
//            XYSeries

public class CategorySeries
    implements Serializable
{

    private String a;
    private List b;
    private List c;

    public CategorySeries(String s)
    {
        b = new ArrayList();
        c = new ArrayList();
        a = s;
    }

    public void add(double d)
    {
        this;
        JVM INSTR monitorenter ;
        add((new StringBuilder()).append(b.size()).append("").toString(), d);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void add(String s, double d)
    {
        this;
        JVM INSTR monitorenter ;
        b.add(s);
        c.add(Double.valueOf(d));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        b.clear();
        c.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCategory(int i)
    {
        this;
        JVM INSTR monitorenter ;
        String s = (String)b.get(i);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public int getItemCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = b.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public String getTitle()
    {
        return a;
    }

    public double getValue(int i)
    {
        this;
        JVM INSTR monitorenter ;
        double d = ((Double)c.get(i)).doubleValue();
        this;
        JVM INSTR monitorexit ;
        return d;
        Exception exception;
        exception;
        throw exception;
    }

    public void remove(int i)
    {
        this;
        JVM INSTR monitorenter ;
        b.remove(i);
        c.remove(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void set(int i, String s, double d)
    {
        this;
        JVM INSTR monitorenter ;
        b.set(i, s);
        c.set(i, Double.valueOf(d));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public XYSeries toXYSeries()
    {
        XYSeries xyseries = new XYSeries(a);
        Iterator iterator = c.iterator();
        int j;
        for (int i = 0; iterator.hasNext(); i = j)
        {
            double d = ((Double)iterator.next()).doubleValue();
            j = i + 1;
            xyseries.add(j, d);
        }

        return xyseries;
    }
}
