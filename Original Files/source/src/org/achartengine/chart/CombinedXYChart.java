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
//            XYChart, TimeChart, LineChart, CubicLineChart, 
//            BarChart, BubbleChart, ScatterChart, RangeBarChart, 
//            RangeStackedBarChart, ClickableArea

public class CombinedXYChart extends XYChart
{

    private XYChart a[];
    private Class b[] = {
        org/achartengine/chart/TimeChart, org/achartengine/chart/LineChart, org/achartengine/chart/CubicLineChart, org/achartengine/chart/BarChart, org/achartengine/chart/BubbleChart, org/achartengine/chart/ScatterChart, org/achartengine/chart/RangeBarChart, org/achartengine/chart/RangeStackedBarChart
    };

    public CombinedXYChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer, String as[])
    {
        int i = 0;
        super(xymultipleseriesdataset, xymultipleseriesrenderer);
        int j = as.length;
        a = new XYChart[j];
        while (i < j) 
        {
            XYMultipleSeriesDataset xymultipleseriesdataset1;
            XYMultipleSeriesRenderer xymultipleseriesrenderer1;
            int k;
            try
            {
                a[i] = a(as[i]);
            }
            catch (Exception exception) { }
            if (a[i] == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown chart type ").append(as[i]).toString());
            }
            xymultipleseriesdataset1 = new XYMultipleSeriesDataset();
            xymultipleseriesdataset1.addSeries(xymultipleseriesdataset.getSeriesAt(i));
            xymultipleseriesrenderer1 = new XYMultipleSeriesRenderer();
            xymultipleseriesrenderer1.setBarSpacing(xymultipleseriesrenderer.getBarSpacing());
            xymultipleseriesrenderer1.setPointSize(xymultipleseriesrenderer.getPointSize());
            k = xymultipleseriesdataset.getSeriesAt(i).getScaleNumber();
            if (xymultipleseriesrenderer.isMinXSet(k))
            {
                xymultipleseriesrenderer1.setXAxisMin(xymultipleseriesrenderer.getXAxisMin(k));
            }
            if (xymultipleseriesrenderer.isMaxXSet(k))
            {
                xymultipleseriesrenderer1.setXAxisMax(xymultipleseriesrenderer.getXAxisMax(k));
            }
            if (xymultipleseriesrenderer.isMinYSet(k))
            {
                xymultipleseriesrenderer1.setYAxisMin(xymultipleseriesrenderer.getYAxisMin(k));
            }
            if (xymultipleseriesrenderer.isMaxYSet(k))
            {
                xymultipleseriesrenderer1.setYAxisMax(xymultipleseriesrenderer.getYAxisMax(k));
            }
            xymultipleseriesrenderer1.addSeriesRenderer(xymultipleseriesrenderer.getSeriesRendererAt(i));
            a[i].setDatasetRenderer(xymultipleseriesdataset1, xymultipleseriesrenderer1);
            i++;
        }
    }

    private XYChart a(String s)
    {
        XYChart xychart = null;
        int i = b.length;
        int j = 0;
        while (j < i && xychart == null) 
        {
            XYChart xychart1 = (XYChart)b[j].newInstance();
            if (!s.equals(xychart1.getChartType()))
            {
                xychart1 = xychart;
            }
            j++;
            xychart = xychart1;
        }
        return xychart;
    }

    protected ClickableArea[] clickableAreasForPoints(List list, List list1, float f, int i, int j)
    {
        return a[i].clickableAreasForPoints(list, list1, f, 0, j);
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleseriesrenderer, float f, float f1, int i, Paint paint)
    {
        a[i].drawLegendShape(canvas, simpleseriesrenderer, f, f1, 0, paint);
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f, int i, int j)
    {
        a[i].setScreenR(getScreenR());
        a[i].setCalcRange(getCalcRange(mDataset.getSeriesAt(i).getScaleNumber()), 0);
        a[i].drawSeries(canvas, paint, list, simpleseriesrenderer, f, 0, j);
    }

    protected void drawSeries(XYSeries xyseries, Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f, int i, 
            org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation orientation, int j)
    {
        a[i].setScreenR(getScreenR());
        a[i].setCalcRange(getCalcRange(mDataset.getSeriesAt(i).getScaleNumber()), 0);
        a[i].drawSeries(xyseries, canvas, paint, list, simpleseriesrenderer, f, 0, orientation, j);
    }

    public String getChartType()
    {
        return "Combined";
    }

    public int getLegendShapeWidth(int i)
    {
        return a[i].getLegendShapeWidth(0);
    }
}
