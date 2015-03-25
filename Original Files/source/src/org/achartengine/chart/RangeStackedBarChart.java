// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;


// Referenced classes of package org.achartengine.chart:
//            RangeBarChart

public class RangeStackedBarChart extends RangeBarChart
{

    public static final String TYPE = "RangeStackedBar";

    RangeStackedBarChart()
    {
        super(BarChart.Type.STACKED);
    }

    public String getChartType()
    {
        return "RangeStackedBar";
    }
}
