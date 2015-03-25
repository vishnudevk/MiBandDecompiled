// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.tools;

import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public abstract class AbstractTool
{

    protected AbstractChart mChart;
    protected XYMultipleSeriesRenderer mRenderer;

    public AbstractTool(AbstractChart abstractchart)
    {
        mChart = abstractchart;
        if (abstractchart instanceof XYChart)
        {
            mRenderer = ((XYChart)abstractchart).getRenderer();
        }
    }

    public void checkRange(double ad[], int i)
    {
        if (mChart instanceof XYChart)
        {
            double ad1[] = ((XYChart)mChart).getCalcRange(i);
            if (ad1 != null)
            {
                if (!mRenderer.isMinXSet(i))
                {
                    ad[0] = ad1[0];
                    mRenderer.setXAxisMin(ad[0], i);
                }
                if (!mRenderer.isMaxXSet(i))
                {
                    ad[1] = ad1[1];
                    mRenderer.setXAxisMax(ad[1], i);
                }
                if (!mRenderer.isMinYSet(i))
                {
                    ad[2] = ad1[2];
                    mRenderer.setYAxisMin(ad[2], i);
                }
                if (!mRenderer.isMaxYSet(i))
                {
                    ad[3] = ad1[3];
                    mRenderer.setYAxisMax(ad[3], i);
                }
            }
        }
    }

    public double[] getRange(int i)
    {
        return (new double[] {
            mRenderer.getXAxisMin(i), mRenderer.getXAxisMax(i), mRenderer.getYAxisMin(i), mRenderer.getYAxisMax(i)
        });
    }

    protected void setXRange(double d, double d1, int i)
    {
        mRenderer.setXAxisMin(d, i);
        mRenderer.setXAxisMax(d1, i);
    }

    protected void setYRange(double d, double d1, int i)
    {
        mRenderer.setYAxisMin(d, i);
        mRenderer.setYAxisMax(d1, i);
    }
}
