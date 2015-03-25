// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            LineChart

public class TimeChart extends LineChart
{

    public static final long DAY = 0x5265c00L;
    public static final String TYPE = "Time";
    private String a;
    private Double b;

    TimeChart()
    {
    }

    public TimeChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer)
    {
        super(xymultipleseriesdataset, xymultipleseriesrenderer);
    }

    private DateFormat a(double d, double d1)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        Object obj = new SimpleDateFormat(a);
_L4:
        return ((DateFormat) (obj));
        Exception exception;
        exception;
_L2:
        obj = SimpleDateFormat.getDateInstance(2);
        double d2 = d1 - d;
        if (d2 > 86400000D && d2 < 432000000D)
        {
            return SimpleDateFormat.getDateTimeInstance(3, 3);
        }
        if (d2 < 86400000D)
        {
            return SimpleDateFormat.getTimeInstance(2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void drawXLabels(List list, Double adouble[], Canvas canvas, Paint paint, int i, int j, int k, 
            double d, double d1, double d2)
    {
        int l = list.size();
        if (l > 0)
        {
            boolean flag = mRenderer.isShowLabels();
            boolean flag1 = mRenderer.isShowGridY();
            DateFormat dateformat = a(((Double)list.get(0)).doubleValue(), ((Double)list.get(l - 1)).doubleValue());
            for (int i1 = 0; i1 < l; i1++)
            {
                long l1 = Math.round(((Double)list.get(i1)).doubleValue());
                float f = (float)((double)i + d * ((double)l1 - d1));
                if (flag)
                {
                    paint.setColor(mRenderer.getXLabelsColor());
                    canvas.drawLine(f, k, f, (float)k + mRenderer.getLabelsTextSize() / 3F, paint);
                    drawText(canvas, dateformat.format(new Date(l1)), f, (float)k + (4F * mRenderer.getLabelsTextSize()) / 3F + mRenderer.getXLabelsPadding(), paint, mRenderer.getXLabelsAngle());
                }
                if (flag1)
                {
                    paint.setColor(mRenderer.getGridColor());
                    canvas.drawLine(f, k, f, j, paint);
                }
            }

        }
        drawXTextLabels(adouble, canvas, paint, true, i, j, k, d, d1, d2);
    }

    public String getChartType()
    {
        return "Time";
    }

    public String getDateFormat()
    {
        return a;
    }

    protected List getXLabels(double d, double d1, int i)
    {
        ArrayList arraylist = new ArrayList();
        if (!mRenderer.isXRoundedLabels())
        {
            if (mDataset.getSeriesCount() > 0)
            {
                XYSeries xyseries = mDataset.getSeriesAt(0);
                int l = xyseries.getItemCount();
                int i1 = 0;
                int j1 = -1;
                for (int k1 = 0; k1 < l; k1++)
                {
                    double d7 = xyseries.getX(k1);
                    if (d > d7 || d7 > d1)
                    {
                        continue;
                    }
                    i1++;
                    if (j1 < 0)
                    {
                        j1 = k1;
                    }
                }

                if (i1 < i)
                {
                    for (int j2 = j1; j2 < j1 + i1; j2++)
                    {
                        arraylist.add(Double.valueOf(xyseries.getX(j2)));
                    }

                } else
                {
                    float f = (float)i1 / (float)i;
                    int l1 = 0;
                    for (int i2 = 0; i2 < l && l1 < i; i2++)
                    {
                        double d6 = xyseries.getX(Math.round(f * (float)i2));
                        if (d <= d6 && d6 <= d1)
                        {
                            arraylist.add(Double.valueOf(d6));
                            l1++;
                        }
                    }

                }
                return arraylist;
            } else
            {
                return super.getXLabels(d, d1, i);
            }
        }
        if (b == null)
        {
            b = Double.valueOf(86400000D + (d - d % 86400000D) + (double)(1000 * (60 * (new Date(Math.round(d))).getTimezoneOffset())));
        }
        if (i > 25)
        {
            i = 25;
        }
        double d2 = (d1 - d) / (double)i;
        if (d2 <= 0.0D)
        {
            return arraylist;
        }
        double d3 = 86400000D;
        if (d2 <= 86400000D)
        {
            for (; d2 < d3 / 2D; d3 /= 2D) { }
        } else
        {
            for (; d2 > d3; d3 *= 2D) { }
        }
        double d4 = b.doubleValue() - d3 * Math.floor((b.doubleValue() - d) / d3);
        int j = 0;
        double d5 = d4;
        do
        {
            if (d5 >= d1)
            {
                break;
            }
            int k = j + 1;
            if (j > i)
            {
                break;
            }
            arraylist.add(Double.valueOf(d5));
            d5 += d3;
            j = k;
        } while (true);
        return arraylist;
    }

    public void setDateFormat(String s)
    {
        a = s;
    }
}
