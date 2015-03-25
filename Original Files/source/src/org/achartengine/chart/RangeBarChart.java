// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            BarChart

public class RangeBarChart extends BarChart
{

    public static final String TYPE = "RangeBar";

    RangeBarChart()
    {
    }

    RangeBarChart(BarChart.Type type)
    {
        super(type);
    }

    public RangeBarChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer, BarChart.Type type)
    {
        super(xymultipleseriesdataset, xymultipleseriesrenderer, type);
    }

    protected void drawChartValuesText(Canvas canvas, XYSeries xyseries, SimpleSeriesRenderer simpleseriesrenderer, Paint paint, List list, int i, int j)
    {
        int k = mDataset.getSeriesCount();
        float f = getHalfDiffX(list, list.size(), k);
        byte byte0 = 0;
        if (j > 0)
        {
            byte0 = 2;
        }
        for (int l = byte0; l < list.size(); l += 4)
        {
            int i1 = j + l / 2;
            float f1 = ((Float)list.get(l)).floatValue();
            if (mType == BarChart.Type.DEFAULT)
            {
                f1 += f * (float)(i * 2) - f * ((float)k - 1.5F);
            }
            if (!isNullValue(xyseries.getY(i1 + 1)) && list.size() > l + 3)
            {
                drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(i1 + 1)), f1, ((Float)list.get(l + 3)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
            }
            if (!isNullValue(xyseries.getY(i1)) && list.size() > l + 1)
            {
                drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(i1)), f1, (((Float)list.get(l + 1)).floatValue() + simpleseriesrenderer.getChartValuesTextSize() + simpleseriesrenderer.getChartValuesSpacing()) - 3F, paint, 0.0F);
            }
        }

    }

    public void drawSeries(Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f, int i, int j)
    {
        int k = mDataset.getSeriesCount();
        int l = list.size();
        paint.setColor(simpleseriesrenderer.getColor());
        paint.setStyle(android.graphics.Paint.Style.FILL);
        float f1 = getHalfDiffX(list, l, k);
        byte byte0 = 0;
        if (j > 0)
        {
            byte0 = 2;
        }
        for (int i1 = byte0; i1 < l; i1 += 4)
        {
            if (list.size() > i1 + 3)
            {
                drawBar(canvas, ((Float)list.get(i1)).floatValue(), ((Float)list.get(i1 + 1)).floatValue(), ((Float)list.get(i1 + 2)).floatValue(), ((Float)list.get(i1 + 3)).floatValue(), f1, k, i, paint);
            }
        }

        paint.setColor(simpleseriesrenderer.getColor());
    }

    public String getChartType()
    {
        return "RangeBar";
    }

    protected float getCoeficient()
    {
        return 0.5F;
    }
}
