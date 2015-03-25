// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            XYChart, ScatterChart, ClickableArea, a, 
//            PointStyle

public class LineChart extends XYChart
{

    public static final String TYPE = "Line";
    private static final int a = 30;
    private ScatterChart b;

    LineChart()
    {
    }

    public LineChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer)
    {
        super(xymultipleseriesdataset, xymultipleseriesrenderer);
        b = new ScatterChart(xymultipleseriesdataset, xymultipleseriesrenderer);
    }

    protected ClickableArea[] clickableAreasForPoints(List list, List list1, float f, int i, int j)
    {
        int k = list.size();
        ClickableArea aclickablearea[] = new ClickableArea[k / 2];
        for (int l = 0; l < k; l += 2)
        {
            int i1 = mRenderer.getSelectableBuffer();
            aclickablearea[l / 2] = new ClickableArea(new RectF(((Float)list.get(l)).floatValue() - (float)i1, ((Float)list.get(l + 1)).floatValue() - (float)i1, ((Float)list.get(l)).floatValue() + (float)i1, ((Float)list.get(l + 1)).floatValue() + (float)i1), ((Double)list1.get(l)).doubleValue(), ((Double)list1.get(l + 1)).doubleValue());
        }

        return aclickablearea;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleseriesrenderer, float f, float f1, int i, Paint paint)
    {
        canvas.drawLine(f, f1, f + 30F, f1, paint);
        if (isRenderPoints(simpleseriesrenderer))
        {
            b.drawLegendShape(canvas, simpleseriesrenderer, f + 5F, f1, i, paint);
        }
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f, int i, int j)
    {
        float f1;
        org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine afilloutsideline[];
        int k;
        int l;
        XYSeriesRenderer xyseriesrenderer = (XYSeriesRenderer)simpleseriesrenderer;
        f1 = paint.getStrokeWidth();
        paint.setStrokeWidth(xyseriesrenderer.getLineWidth());
        afilloutsideline = xyseriesrenderer.getFillOutsideLine();
        k = afilloutsideline.length;
        l = 0;
_L10:
        if (l >= k) goto _L2; else goto _L1
_L1:
        org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine filloutsideline;
        ArrayList arraylist;
        filloutsideline = afilloutsideline[l];
        if (filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.NONE)
        {
            continue; /* Loop/switch isn't completed */
        }
        paint.setColor(filloutsideline.getColor());
        arraylist = new ArrayList();
        int ai[] = filloutsideline.getFillRange();
        if (ai == null)
        {
            arraylist.addAll(list);
        } else
        {
            arraylist.addAll(list.subList(2 * ai[0], 2 * ai[1]));
        }
        a.a[filloutsideline.getType().ordinal()];
        JVM INSTR tableswitch 1 5: default 148
    //                   1 187
    //                   2 561
    //                   3 568
    //                   4 575
    //                   5 585;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_585;
_L3:
        throw new RuntimeException("You have added a new type of filling but have not implemented.");
_L4:
        float f2;
        f2 = f;
        break MISSING_BLOCK_LABEL_191;
_L5:
        f2 = f;
          goto _L9
_L6:
        f2 = f;
          goto _L9
_L7:
        f2 = canvas.getHeight();
          goto _L9
        f2 = 0.0F;
_L9:
        if (filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE || filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW)
        {
            ArrayList arraylist1 = new ArrayList();
            boolean flag;
            int i1;
            boolean flag1;
            int j1;
            int k1;
            if (filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && ((Float)arraylist.get(1)).floatValue() < f2 || filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && ((Float)arraylist.get(1)).floatValue() > f2)
            {
                arraylist1.add(arraylist.get(0));
                arraylist1.add(arraylist.get(1));
                flag = true;
            } else
            {
                flag = false;
            }
            i1 = 3;
            flag1 = flag;
            while (i1 < arraylist.size()) 
            {
                float f3 = ((Float)arraylist.get(i1 - 2)).floatValue();
                float f4 = ((Float)arraylist.get(i1)).floatValue();
                int l1;
                boolean flag2;
                if (f3 < f2 && f4 > f2 || f3 > f2 && f4 < f2)
                {
                    float f5 = ((Float)arraylist.get(i1 - 3)).floatValue();
                    float f6 = ((Float)arraylist.get(i1 - 1)).floatValue();
                    arraylist1.add(Float.valueOf(f5 + ((f6 - f5) * (f2 - f3)) / (f4 - f3)));
                    arraylist1.add(Float.valueOf(f2));
                    int i2;
                    boolean flag3;
                    int j2;
                    if (filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && f4 > f2 || filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && f4 < f2)
                    {
                        i1 += 2;
                        flag3 = false;
                    } else
                    {
                        arraylist1.add(Float.valueOf(f6));
                        arraylist1.add(Float.valueOf(f4));
                        flag3 = true;
                    }
                    j2 = i1;
                    flag2 = flag3;
                    l1 = j2;
                } else
                {
                    if (flag1 || filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && f4 < f2 || filloutsideline.getType() == org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && f4 > f2)
                    {
                        arraylist1.add(arraylist.get(i1 - 1));
                        arraylist1.add(Float.valueOf(f4));
                    }
                    l1 = i1;
                    flag2 = flag1;
                }
                i2 = l1 + 2;
                flag1 = flag2;
                i1 = i2;
            }
            arraylist.clear();
            arraylist.addAll(arraylist1);
        }
        j1 = arraylist.size();
        arraylist.set(0, Float.valueOf(1.0F + ((Float)arraylist.get(0)).floatValue()));
        arraylist.add(arraylist.get(j1 - 2));
        arraylist.add(Float.valueOf(f2));
        arraylist.add(arraylist.get(0));
        arraylist.add(arraylist.get(j1 + 1));
        for (k1 = 0; k1 < j1 + 4; k1 += 2)
        {
            if (((Float)arraylist.get(k1 + 1)).floatValue() < 0.0F)
            {
                arraylist.set(k1 + 1, Float.valueOf(0.0F));
            }
        }

        paint.setStyle(android.graphics.Paint.Style.FILL);
        drawPath(canvas, arraylist, paint, true);
        l++;
          goto _L10
_L2:
        paint.setColor(simpleseriesrenderer.getColor());
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        drawPath(canvas, list, paint, false);
        paint.setStrokeWidth(f1);
        return;
    }

    public String getChartType()
    {
        return "Line";
    }

    public int getLegendShapeWidth(int i)
    {
        return 30;
    }

    public ScatterChart getPointsChart()
    {
        return b;
    }

    public boolean isRenderPoints(SimpleSeriesRenderer simpleseriesrenderer)
    {
        return ((XYSeriesRenderer)simpleseriesrenderer).getPointStyle() != PointStyle.POINT;
    }

    protected void setDatasetRenderer(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer)
    {
        super.setDatasetRenderer(xymultipleseriesdataset, xymultipleseriesrenderer);
        b = new ScatterChart(xymultipleseriesdataset, xymultipleseriesrenderer);
    }
}
