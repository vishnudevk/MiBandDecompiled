// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            AbstractChart

public abstract class RoundChart extends AbstractChart
{

    protected static final int NO_VALUE = 0x7fffffff;
    protected static final int SHAPE_WIDTH = 10;
    protected int mCenterX;
    protected int mCenterY;
    protected CategorySeries mDataset;
    protected DefaultRenderer mRenderer;

    public RoundChart(CategorySeries categoryseries, DefaultRenderer defaultrenderer)
    {
        mCenterX = 0x7fffffff;
        mCenterY = 0x7fffffff;
        mDataset = categoryseries;
        mRenderer = defaultrenderer;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleseriesrenderer, float f, float f1, int i, Paint paint)
    {
        canvas.drawRect(f, f1 - 5F, f + 10F, f1 + 5F, paint);
    }

    public void drawTitle(Canvas canvas, int i, int j, int k, Paint paint)
    {
        if (mRenderer.isShowLabels())
        {
            paint.setColor(mRenderer.getLabelsColor());
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            paint.setTextSize(mRenderer.getChartTitleTextSize());
            drawString(canvas, mRenderer.getChartTitle(), i + k / 2, (float)j + mRenderer.getChartTitleTextSize(), paint);
        }
    }

    public int getCenterX()
    {
        return mCenterX;
    }

    public int getCenterY()
    {
        return mCenterY;
    }

    public int getLegendShapeWidth(int i)
    {
        return 10;
    }

    public DefaultRenderer getRenderer()
    {
        return mRenderer;
    }

    public void setCenterX(int i)
    {
        mCenterX = i;
    }

    public void setCenterY(int i)
    {
        mCenterY = i;
    }
}
