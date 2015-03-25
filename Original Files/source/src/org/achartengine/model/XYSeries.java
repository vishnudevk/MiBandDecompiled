// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import org.achartengine.util.IndexXYMap;
import org.achartengine.util.XYEntry;

public class XYSeries
    implements Serializable
{

    private static final double h = 9.9999999999999998E-13D;
    private String a;
    private final IndexXYMap b;
    private double c;
    private double d;
    private double e;
    private double f;
    private final int g;
    private List i;
    private final IndexXYMap j;

    public XYSeries(String s)
    {
        this(s, 0);
    }

    public XYSeries(String s, int k)
    {
        b = new IndexXYMap();
        c = 1.7976931348623157E+308D;
        d = -1.7976931348623157E+308D;
        e = 1.7976931348623157E+308D;
        f = -1.7976931348623157E+308D;
        i = new ArrayList();
        j = new IndexXYMap();
        a = s;
        g = k;
        a();
    }

    private void a()
    {
        c = 1.7976931348623157E+308D;
        d = -1.7976931348623157E+308D;
        e = 1.7976931348623157E+308D;
        f = -1.7976931348623157E+308D;
        int k = getItemCount();
        for (int l = 0; l < k; l++)
        {
            a(getX(l), getY(l));
        }

    }

    private void a(double d1, double d2)
    {
        c = Math.min(c, d1);
        d = Math.max(d, d1);
        e = Math.min(e, d2);
        f = Math.max(f, d2);
    }

    public void add(double d1, double d2)
    {
        this;
        JVM INSTR monitorenter ;
        for (; b.get(Double.valueOf(d1)) != null; d1 += getPadding()) { }
        b.put(Double.valueOf(d1), Double.valueOf(d2));
        a(d1, d2);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void add(int k, double d1, double d2)
    {
        this;
        JVM INSTR monitorenter ;
        for (; b.get(Double.valueOf(d1)) != null; d1 += getPadding()) { }
        b.put(k, Double.valueOf(d1), Double.valueOf(d2));
        a(d1, d2);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void addAnnotation(String s, double d1, double d2)
    {
        i.add(s);
        j.put(Double.valueOf(d1), Double.valueOf(d2));
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        b.clear();
        j.clear();
        a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAnnotationAt(int k)
    {
        return (String)i.get(k);
    }

    public int getAnnotationCount()
    {
        return i.size();
    }

    public double getAnnotationX(int k)
    {
        return ((Double)j.getXByIndex(k)).doubleValue();
    }

    public double getAnnotationY(int k)
    {
        return ((Double)j.getYByIndex(k)).doubleValue();
    }

    public int getIndexForKey(double d1)
    {
        return b.getIndexForKey(Double.valueOf(d1));
    }

    public int getItemCount()
    {
        this;
        JVM INSTR monitorenter ;
        int k = b.size();
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public double getMaxX()
    {
        return d;
    }

    public double getMaxY()
    {
        return f;
    }

    public double getMinX()
    {
        return c;
    }

    public double getMinY()
    {
        return e;
    }

    protected double getPadding()
    {
        return 9.9999999999999998E-13D;
    }

    public SortedMap getRange(double d1, double d2, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        SortedMap sortedmap2;
        SortedMap sortedmap1 = b.headMap(Double.valueOf(d1));
        if (!sortedmap1.isEmpty())
        {
            d1 = ((Double)sortedmap1.lastKey()).doubleValue();
        }
        sortedmap2 = b.tailMap(Double.valueOf(d2));
        if (sortedmap2.isEmpty()) goto _L2; else goto _L3
_L3:
        Iterator iterator;
        Double double1;
        iterator = sortedmap2.keySet().iterator();
        double1 = (Double)iterator.next();
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        d2 = ((Double)iterator.next()).doubleValue();
_L2:
        SortedMap sortedmap = b.subMap(Double.valueOf(d1), Double.valueOf(d2));
        this;
        JVM INSTR monitorexit ;
        return sortedmap;
_L5:
        double d3 = double1.doubleValue();
        d2 += d3;
          goto _L2
        Exception exception;
        exception;
        throw exception;
    }

    public int getScaleNumber()
    {
        return g;
    }

    public String getTitle()
    {
        return a;
    }

    public double getX(int k)
    {
        this;
        JVM INSTR monitorenter ;
        double d1 = ((Double)b.getXByIndex(k)).doubleValue();
        this;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public double getY(int k)
    {
        this;
        JVM INSTR monitorenter ;
        double d1 = ((Double)b.getYByIndex(k)).doubleValue();
        this;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public void remove(int k)
    {
        this;
        JVM INSTR monitorenter ;
        XYEntry xyentry = b.removeByIndex(k);
        double d1 = ((Double)xyentry.getKey()).doubleValue();
        double d2 = ((Double)xyentry.getValue()).doubleValue();
        if (d1 == c || d1 == d || d2 == e || d2 == f)
        {
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void removeAnnotation(int k)
    {
        i.remove(k);
        j.removeByIndex(k);
    }

    public void setTitle(String s)
    {
        a = s;
    }
}
