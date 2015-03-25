// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            LineChart

public class CubicLineChart extends LineChart
{

    public static final String TYPE = "Cubic";
    private float a;
    private float b;
    private Point c;
    private Point d;
    private Point e;

    public CubicLineChart()
    {
        c = new Point();
        d = new Point();
        e = new Point();
        a = 0.33F;
        b = 1.0F - a;
    }

    public CubicLineChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer, float f)
    {
        super(xymultipleseriesdataset, xymultipleseriesrenderer);
        c = new Point();
        d = new Point();
        e = new Point();
        a = f;
        b = 1.0F - a;
    }

    private void a(List list, Point point, int i, int j, float f)
    {
        float f1 = ((Float)list.get(i)).floatValue();
        float f2 = ((Float)list.get(i + 1)).floatValue();
        float f3 = ((Float)list.get(j)).floatValue();
        float f4 = ((Float)list.get(j + 1)).floatValue();
        float f5 = f3 - f1;
        float f6 = f4 - f2;
        point.setX(f1 + f5 * f);
        point.setY(f2 + f6 * f);
    }

    protected void drawPath(Canvas canvas, List list, Paint paint, boolean flag)
    {
        Path path = new Path();
        path.moveTo(((Float)list.get(0)).floatValue(), ((Float)list.get(1)).floatValue());
        int i = list.size();
        int j;
        int k;
        if (flag)
        {
            j = i - 4;
        } else
        {
            j = i;
        }
        k = 0;
        while (k < j) 
        {
            int i1;
            int j1;
            Point point;
            float f;
            if (k + 2 < j)
            {
                i1 = k + 2;
            } else
            {
                i1 = k;
            }
            if (k + 4 < j)
            {
                j1 = k + 4;
            } else
            {
                j1 = i1;
            }
            a(list, c, k, i1, b);
            d.setX(((Float)list.get(i1)).floatValue());
            d.setY(((Float)list.get(i1 + 1)).floatValue());
            point = e;
            f = a;
            a(list, point, i1, j1, f);
            path.cubicTo(c.getX(), c.getY(), d.getX(), d.getY(), e.getX(), e.getY());
            k += 2;
        }
        if (flag)
        {
            for (int l = j; l < j + 4; l += 2)
            {
                path.lineTo(((Float)list.get(l)).floatValue(), ((Float)list.get(l + 1)).floatValue());
            }

            path.lineTo(((Float)list.get(0)).floatValue(), ((Float)list.get(1)).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    public String getChartType()
    {
        return "Cubic";
    }
}
