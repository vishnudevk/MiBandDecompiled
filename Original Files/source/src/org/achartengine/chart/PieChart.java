// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            RoundChart, PieMapper

public class PieChart extends RoundChart
{

    private PieMapper a;

    public PieChart(CategorySeries categoryseries, DefaultRenderer defaultrenderer)
    {
        super(categoryseries, defaultrenderer);
        a = new PieMapper();
    }

    public void draw(Canvas canvas, int i, int j, int k, int l, Paint paint)
    {
        paint.setAntiAlias(mRenderer.isAntialiasing());
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setTextSize(mRenderer.getLabelsTextSize());
        int i1 = getLegendSize(mRenderer, l / 5, 0.0F);
        int j1 = i + k;
        int k1 = mDataset.getItemCount();
        String as[] = new String[k1];
        int l1 = 0;
        double d;
        double d2;
        for (d = 0.0D; l1 < k1; d = d2)
        {
            d2 = d + mDataset.getValue(l1);
            as[l1] = mDataset.getCategory(l1);
            l1++;
        }

        int i2;
        int j2;
        float f;
        int k2;
        boolean flag;
        float f1;
        float f2;
        RectF rectf;
        ArrayList arraylist;
        int l2;
        if (mRenderer.isFitLegend())
        {
            i2 = drawLegend(canvas, mRenderer, as, i, j1, j, k, l, i1, paint, true);
        } else
        {
            i2 = i1;
        }
        j2 = (j + l) - i2;
        drawBackground(mRenderer, canvas, i, j, k, l, paint, false, 0);
        f = mRenderer.getStartAngle();
        k2 = (int)(0.34999999999999998D * (double)Math.min(Math.abs(j1 - i), Math.abs(j2 - j)) * (double)mRenderer.getScale());
        if (mCenterX == 0x7fffffff)
        {
            mCenterX = (i + j1) / 2;
        }
        if (mCenterY == 0x7fffffff)
        {
            mCenterY = (j2 + j) / 2;
        }
        a.setDimensions(k2, mCenterX, mCenterY);
        if (!a.areAllSegmentPresent(k1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.clearPieSegments();
        }
        f1 = 0.9F * (float)k2;
        f2 = 1.1F * (float)k2;
        rectf = new RectF(mCenterX - k2, mCenterY - k2, k2 + mCenterX, k2 + mCenterY);
        arraylist = new ArrayList();
        l2 = 0;
        while (l2 < k1) 
        {
            SimpleSeriesRenderer simpleseriesrenderer = mRenderer.getSeriesRendererAt(l2);
            float f3;
            float f4;
            if (simpleseriesrenderer.isGradientEnabled())
            {
                paint.setShader(new RadialGradient(mCenterX, mCenterY, f2, simpleseriesrenderer.getGradientStartColor(), simpleseriesrenderer.getGradientStopColor(), android.graphics.Shader.TileMode.MIRROR));
            } else
            {
                paint.setColor(simpleseriesrenderer.getColor());
            }
            f3 = (float)mDataset.getValue(l2);
            f4 = (float)(360D * ((double)f3 / d));
            if (simpleseriesrenderer.isHighlighted())
            {
                double d1 = Math.toRadians(90F - (f + f4 / 2.0F));
                float f7 = (float)(0.10000000000000001D * (double)k2 * Math.sin(d1));
                float f8 = (float)(0.10000000000000001D * (double)k2 * Math.cos(d1));
                rectf.offset(f7, f8);
                canvas.drawArc(rectf, f, f4, true, paint);
                rectf.offset(-f7, -f8);
            } else
            {
                canvas.drawArc(rectf, f, f4, true, paint);
            }
            paint.setColor(simpleseriesrenderer.getColor());
            paint.setShader(null);
            drawLabel(canvas, mDataset.getCategory(l2), mRenderer, arraylist, mCenterX, mCenterY, f1, f2, f, f4, i, j1, mRenderer.getLabelsColor(), paint, true, false);
            if (mRenderer.isDisplayValues())
            {
                String s = getLabel(mRenderer.getSeriesRendererAt(l2).getChartValuesFormat(), mDataset.getValue(l2));
                DefaultRenderer defaultrenderer = mRenderer;
                int i3 = mCenterX;
                int j3 = mCenterY;
                float f5 = f1 / 2.0F;
                float f6 = f2 / 2.0F;
                int k3 = mRenderer.getLabelsColor();
                drawLabel(canvas, s, defaultrenderer, arraylist, i3, j3, f5, f6, f, f4, i, j1, k3, paint, false, true);
            }
            if (flag)
            {
                a.addPieSegment(l2, f3, f, f4);
            }
            f += f4;
            l2++;
        }
        arraylist.clear();
        drawLegend(canvas, mRenderer, as, i, j1, j, k, l, i2, paint, false);
        drawTitle(canvas, i, j, k, paint);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point)
    {
        return a.getSeriesAndPointForScreenCoordinate(point);
    }
}
