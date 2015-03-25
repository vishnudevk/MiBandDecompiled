// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.achartengine.model:
//            XYSeries

public class XYValueSeries extends XYSeries
{

    private List a;
    private double b;
    private double c;

    public XYValueSeries(String s)
    {
        super(s);
        a = new ArrayList();
        b = 1.7976931348623157E+308D;
        c = -1.7976931348623157E+308D;
    }

    private void a()
    {
        b = 1.7976931348623157E+308D;
        c = 1.7976931348623157E+308D;
        int i = getItemCount();
        for (int j = 0; j < i; j++)
        {
            a(getValue(j));
        }

    }

    private void a(double d)
    {
        b = Math.min(b, d);
        c = Math.max(c, d);
    }

    public void add(double d, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        add(d, d1, 0.0D);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void add(double d, double d1, double d2)
    {
        this;
        JVM INSTR monitorenter ;
        super.add(d, d1);
        a.add(Double.valueOf(d2));
        a(d2);
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
        super.clear();
        a.clear();
        a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public double getMaxValue()
    {
        return c;
    }

    public double getMinValue()
    {
        return b;
    }

    public double getValue(int i)
    {
        this;
        JVM INSTR monitorenter ;
        double d = ((Double)a.get(i)).doubleValue();
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
        super.remove(i);
        double d = ((Double)a.remove(i)).doubleValue();
        if (d == b || d == c)
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
}
