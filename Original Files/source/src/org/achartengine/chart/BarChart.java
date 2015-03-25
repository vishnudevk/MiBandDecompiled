// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.chart:
//            XYChart, ClickableArea

public class BarChart extends XYChart
{

    public static final String TYPE = "Bar";
    private static final int a = 12;
    protected Type mType;

    BarChart()
    {
        mType = Type.DEFAULT;
    }

    BarChart(Type type)
    {
        mType = Type.DEFAULT;
        mType = type;
    }

    public BarChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer, Type type)
    {
        super(xymultipleseriesdataset, xymultipleseriesrenderer);
        mType = Type.DEFAULT;
        mType = type;
    }

    private int a(int i, int j, float f)
    {
        return Color.argb(Math.round(f * (float)Color.alpha(i) + (1.0F - f) * (float)Color.alpha(j)), Math.round(f * (float)Color.red(i) + (1.0F - f) * (float)Color.red(j)), Math.round(f * (float)Color.green(i) + (1.0F - f) * (float)Color.green(j)), Math.round(f * (float)Color.blue(i) + (1.0F - f) * (float)Color.blue(j)));
    }

    private void a(Canvas canvas, float f, float f1, float f2, float f3, int i, int j, 
            Paint paint)
    {
        SimpleSeriesRenderer simpleseriesrenderer = mRenderer.getSeriesRendererAt(j);
        if (simpleseriesrenderer.isGradientEnabled())
        {
            double ad[] = new double[2];
            ad[0] = 0.0D;
            ad[1] = simpleseriesrenderer.getGradientStopValue();
            float f4 = (float)toScreenPoint(ad, i)[1];
            double ad1[] = new double[2];
            ad1[0] = 0.0D;
            ad1[1] = simpleseriesrenderer.getGradientStartValue();
            float f5 = (float)toScreenPoint(ad1, i)[1];
            float f6 = Math.max(f4, Math.min(f1, f3));
            float f7 = Math.min(f5, Math.max(f1, f3));
            int k = simpleseriesrenderer.getGradientStopColor();
            int l = simpleseriesrenderer.getGradientStartColor();
            int i1;
            int j1;
            GradientDrawable gradientdrawable;
            if (f1 < f4)
            {
                paint.setColor(k);
                canvas.drawRect(Math.round(f), Math.round(f1), Math.round(f2), Math.round(f6), paint);
                i1 = k;
            } else
            {
                i1 = a(k, l, (f5 - f6) / (f5 - f4));
            }
            if (f3 > f5)
            {
                paint.setColor(l);
                canvas.drawRect(Math.round(f), Math.round(f7), Math.round(f2), Math.round(f3), paint);
                j1 = l;
            } else
            {
                j1 = a(l, k, (f7 - f4) / (f5 - f4));
            }
            gradientdrawable = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, new int[] {
                j1, i1
            });
            gradientdrawable.setBounds(Math.round(f), Math.round(f6), Math.round(f2), Math.round(f7));
            gradientdrawable.draw(canvas);
            return;
        }
        if (Math.abs(f1 - f3) < 1.0F)
        {
            if (f1 < f3)
            {
                f3 = f1 + 1.0F;
            } else
            {
                f3 = f1 - 1.0F;
            }
        }
        canvas.drawRect(Math.round(f), Math.round(f1), Math.round(f2), Math.round(f3), paint);
    }

    protected ClickableArea[] clickableAreasForPoints(List list, List list1, float f, int i, int j)
    {
        int k = mDataset.getSeriesCount();
        int l = list.size();
        ClickableArea aclickablearea[] = new ClickableArea[l / 2];
        float f1 = getHalfDiffX(list, l, k);
        int i1 = 0;
        while (i1 < l) 
        {
            float f2 = ((Float)list.get(i1)).floatValue();
            float f3 = ((Float)list.get(i1 + 1)).floatValue();
            if (mType == Type.STACKED)
            {
                aclickablearea[i1 / 2] = new ClickableArea(new RectF(f2 - f1, Math.min(f3, f), f2 + f1, Math.max(f3, f)), ((Double)list1.get(i1)).doubleValue(), ((Double)list1.get(i1 + 1)).doubleValue());
            } else
            {
                float f4 = (f2 - f1 * (float)k) + f1 * (float)(i * 2);
                aclickablearea[i1 / 2] = new ClickableArea(new RectF(f4, Math.min(f3, f), f4 + 2.0F * f1, Math.max(f3, f)), ((Double)list1.get(i1)).doubleValue(), ((Double)list1.get(i1 + 1)).doubleValue());
            }
            i1 += 2;
        }
        return aclickablearea;
    }

    protected void drawBar(Canvas canvas, float f, float f1, float f2, float f3, float f4, int i, 
            int j, Paint paint)
    {
        int k = mDataset.getSeriesAt(j).getScaleNumber();
        if (mType == Type.STACKED)
        {
            a(canvas, f - f4, f3, f2 + f4, f1, k, j, paint);
            return;
        } else
        {
            float f5 = (f - f4 * (float)i) + f4 * (float)(j * 2);
            a(canvas, f5, f3, f5 + 2.0F * f4, f1, k, j, paint);
            return;
        }
    }

    protected void drawChartValuesText(Canvas canvas, XYSeries xyseries, SimpleSeriesRenderer simpleseriesrenderer, Paint paint, List list, int i, int j)
    {
        int k = mDataset.getSeriesCount();
        int l = list.size();
        float f = getHalfDiffX(list, l, k);
        int i1 = 0;
        while (i1 < l) 
        {
            double d = xyseries.getY(j + i1 / 2);
            if (!isNullValue(d))
            {
                float f1 = ((Float)list.get(i1)).floatValue();
                if (mType == Type.DEFAULT)
                {
                    f1 += f * (float)(i * 2) - f * ((float)k - 1.5F);
                }
                if (d >= 0.0D)
                {
                    drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), d), f1, ((Float)list.get(i1 + 1)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
                } else
                {
                    drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), d), f1, (((Float)list.get(i1 + 1)).floatValue() + simpleseriesrenderer.getChartValuesTextSize() + simpleseriesrenderer.getChartValuesSpacing()) - 3F, paint, 0.0F);
                }
            }
            i1 += 2;
        }
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleseriesrenderer, float f, float f1, int i, Paint paint)
    {
        canvas.drawRect(f, f1 - 6F, f + 12F, f1 + 6F, paint);
    }

    public void drawSeries(Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f, int i, int j)
    {
        int k = mDataset.getSeriesCount();
        int l = list.size();
        paint.setColor(simpleseriesrenderer.getColor());
        paint.setStyle(android.graphics.Paint.Style.FILL);
        float f1 = getHalfDiffX(list, l, k);
        for (int i1 = 0; i1 < l; i1 += 2)
        {
            float f2 = ((Float)list.get(i1)).floatValue();
            drawBar(canvas, f2, f, f2, ((Float)list.get(i1 + 1)).floatValue(), f1, k, i, paint);
        }

        paint.setColor(simpleseriesrenderer.getColor());
    }

    public String getChartType()
    {
        return "Bar";
    }

    protected float getCoeficient()
    {
        return 1.0F;
    }

    public double getDefaultMinimum()
    {
        return 0.0D;
    }

    protected float getHalfDiffX(List list, int i, int j)
    {
        float f = mRenderer.getBarWidth();
        if (f > 0.0F)
        {
            return f / 2.0F;
        }
        int k;
        float f1;
        if (i > 2)
        {
            k = i - 2;
        } else
        {
            k = i;
        }
        f1 = (((Float)list.get(i - 2)).floatValue() - ((Float)list.get(0)).floatValue()) / (float)k;
        if (f1 == 0.0F)
        {
            f1 = 10F;
        }
        if (mType != Type.STACKED)
        {
            f1 /= j;
        }
        return (float)((double)f1 / ((double)getCoeficient() * (1.0D + mRenderer.getBarSpacing())));
    }

    public int getLegendShapeWidth(int i)
    {
        return 12;
    }

    protected boolean isRenderNullValues()
    {
        return true;
    }

    private class Type extends Enum
    {

        public static final Type DEFAULT;
        public static final Type STACKED;
        private static final Type a[];

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(org/achartengine/chart/BarChart$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])a.clone();
        }

        static 
        {
            DEFAULT = new Type("DEFAULT", 0);
            STACKED = new Type("STACKED", 1);
            Type atype[] = new Type[2];
            atype[0] = DEFAULT;
            atype[1] = STACKED;
            a = atype;
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
