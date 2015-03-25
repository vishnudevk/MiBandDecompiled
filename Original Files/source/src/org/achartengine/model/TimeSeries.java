// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.util.Date;

// Referenced classes of package org.achartengine.model:
//            XYSeries

public class TimeSeries extends XYSeries
{

    public TimeSeries(String s)
    {
        super(s);
    }

    public void add(Date date, double d)
    {
        this;
        JVM INSTR monitorenter ;
        super.add(date.getTime(), d);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected double getPadding()
    {
        return 1.0D;
    }
}
