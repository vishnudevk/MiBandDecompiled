// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public abstract class AbstractChart
    implements Serializable
{

    public AbstractChart()
    {
    }

    private String a(String s, float f, Paint paint)
    {
        int i = s.length();
        int j = 0;
        String s1;
        for (s1 = s; paint.measureText(s1) > f && j < i; s1 = (new StringBuilder()).append(s.substring(0, i - j)).append("...").toString())
        {
            j++;
        }

        if (j == i)
        {
            s1 = "...";
        }
        return s1;
    }

    private static float[] a(float f, float f1, float f2, float f3, int i, int j)
    {
        float f4 = 0.0F;
        float f5;
        float f6;
        if (f1 > (float)i)
        {
            float f19 = (f3 - f1) / (f2 - f);
            float f20 = (((float)i - f1) + f19 * f) / f19;
            float f21 = i;
            if (f20 < 0.0F)
            {
                f21 = f1 - f19 * f;
                f20 = 0.0F;
            } else
            if (f20 > (float)j)
            {
                f20 = j;
                f21 = (f1 + f19 * (float)j) - f19 * f;
            }
            f5 = f21;
            f6 = f20;
        } else
        if (f1 < 0.0F)
        {
            float f15 = (f3 - f1) / (f2 - f);
            float f16 = (-f1 + f15 * f) / f15;
            float f8;
            float f9;
            int k;
            float f10;
            float f11;
            float f12;
            float f17;
            float f18;
            if (f16 < 0.0F)
            {
                f18 = f1 - f15 * f;
                f17 = 0.0F;
            } else
            if (f16 > (float)j)
            {
                f17 = j;
                f18 = (f1 + f15 * (float)j) - f15 * f;
            } else
            {
                f17 = f16;
                f18 = 0.0F;
            }
            f5 = f18;
            f6 = f17;
        } else
        {
            f5 = f1;
            f6 = f;
        }
        if (f3 > (float)i)
        {
            float f13 = (f3 - f1) / (f2 - f);
            float f14 = (((float)i - f1) + f13 * f) / f13;
            float f7 = i;
            if (f14 < 0.0F)
            {
                f7 = f1 - f13 * f;
            } else
            if (f14 > (float)j)
            {
                f4 = j;
                f7 = (f1 + f13 * (float)j) - f13 * f;
            } else
            {
                f4 = f14;
            }
        } else
        if (f3 < 0.0F)
        {
            f8 = (f3 - f1) / (f2 - f);
            f9 = (-f1 + f8 * f) / f8;
            if (f9 < 0.0F)
            {
                f12 = f1 - f8 * f;
                f9 = 0.0F;
                f10 = f12;
            } else
            {
                k = f9 != (float)j;
                f10 = 0.0F;
                if (k > 0)
                {
                    f9 = j;
                    f10 = (f1 + f8 * (float)j) - f8 * f;
                }
            }
            f11 = f10;
            f4 = f9;
            f7 = f11;
        } else
        {
            f7 = f3;
            f4 = f2;
        }
        return (new float[] {
            f6, f5, f4, f7
        });
    }

    public abstract void draw(Canvas canvas, int i, int j, int k, int l, Paint paint);

    protected void drawBackground(DefaultRenderer defaultrenderer, Canvas canvas, int i, int j, int k, int l, Paint paint, 
            boolean flag, int i1)
    {
        if (defaultrenderer.isApplyBackgroundColor() || flag)
        {
            if (flag)
            {
                paint.setColor(i1);
            } else
            {
                paint.setColor(defaultrenderer.getBackgroundColor());
            }
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect(i, j, i + k, j + l, paint);
        }
    }

    protected void drawLabel(Canvas canvas, String s, DefaultRenderer defaultrenderer, List list, int i, int j, float f, 
            float f1, float f2, float f3, int k, int l, int i1, Paint paint, 
            boolean flag, boolean flag1)
    {
        if (defaultrenderer.isShowLabels() || flag1)
        {
            paint.setColor(i1);
            double d = Math.toRadians(90F - (f2 + f3 / 2.0F));
            double d1 = Math.sin(d);
            double d2 = Math.cos(d);
            int j1 = Math.round((float)i + (float)(d1 * (double)f));
            int k1 = Math.round((float)j + (float)(d2 * (double)f));
            int l1 = Math.round((float)i + (float)(d1 * (double)f1));
            int i2 = Math.round((float)j + (float)(d2 * (double)f1));
            float f4 = defaultrenderer.getLabelsTextSize();
            float f5 = Math.max(f4 / 2.0F, 10F);
            paint.setTextAlign(android.graphics.Paint.Align.LEFT);
            if (j1 > l1)
            {
                f5 = -f5;
                paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
            }
            float f6 = f5;
            float f7 = f6 + (float)l1;
            float f8 = i2;
            float f9 = (float)l - f7;
            if (j1 > l1)
            {
                f9 = f7 - (float)k;
            }
            String s1 = a(s, f9, paint);
            float f10 = paint.measureText(s1);
            boolean flag2 = false;
            while (!flag2 && flag) 
            {
                boolean flag3 = false;
                int k2 = list.size();
                int l2 = 0;
                float f11 = f8;
                while (l2 < k2 && !flag3) 
                {
                    RectF rectf = (RectF)list.get(l2);
                    int j2;
                    boolean flag4;
                    float f12;
                    if (rectf.intersects(f7, f11, f7 + f10, f11 + f4))
                    {
                        f12 = Math.max(f11, rectf.bottom);
                        flag4 = true;
                    } else
                    {
                        flag4 = flag3;
                        f12 = f11;
                    }
                    l2++;
                    f11 = f12;
                    flag3 = flag4;
                }
                if (!flag3)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                f8 = f11;
            }
            if (flag)
            {
                j2 = (int)(f8 - f4 / 2.0F);
                canvas.drawLine(j1, k1, l1, j2, paint);
                canvas.drawLine(l1, j2, f6 + (float)l1, j2, paint);
            } else
            {
                paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            }
            canvas.drawText(s1, f7, f8, paint);
            if (flag)
            {
                list.add(new RectF(f7, f8, f7 + f10, f8 + f4));
            }
        }
    }

    protected int drawLegend(Canvas canvas, DefaultRenderer defaultrenderer, String as[], int i, int j, int k, int l, 
            int i1, int j1, Paint paint, boolean flag)
    {
        float f = 32F;
        if (defaultrenderer.isShowLegend())
        {
            float f1 = i;
            float f2 = f + (float)((k + i1) - j1);
            paint.setTextAlign(android.graphics.Paint.Align.LEFT);
            paint.setTextSize(defaultrenderer.getLegendTextSize());
            int k1 = Math.min(as.length, defaultrenderer.getSeriesRendererCount());
            int l1 = 0;
            while (l1 < k1) 
            {
                SimpleSeriesRenderer simpleseriesrenderer = defaultrenderer.getSeriesRendererAt(l1);
                float f3 = getLegendShapeWidth(l1);
                float f4;
                if (simpleseriesrenderer.isShowLegendItem())
                {
                    String s = as[l1];
                    float af[];
                    float f5;
                    int i2;
                    if (as.length == defaultrenderer.getSeriesRendererCount())
                    {
                        paint.setColor(simpleseriesrenderer.getColor());
                    } else
                    {
                        paint.setColor(0xffcccccc);
                    }
                    af = new float[s.length()];
                    paint.getTextWidths(s, af);
                    f5 = 0.0F;
                    i2 = af.length;
                    for (int j2 = 0; j2 < i2; j2++)
                    {
                        f5 += af[j2];
                    }

                    float f6 = f5 + (10F + f3);
                    float f7 = f1 + f6;
                    if (l1 > 0 && getExceed(f7, defaultrenderer, j, l))
                    {
                        f1 = i;
                        f2 += defaultrenderer.getLegendTextSize();
                        float f9 = f + defaultrenderer.getLegendTextSize();
                        f7 = f1 + f6;
                        f4 = f9;
                    } else
                    {
                        f4 = f;
                    }
                    if (getExceed(f7, defaultrenderer, j, l))
                    {
                        float f8 = (float)j - f1 - f3 - 10F;
                        if (isVertical(defaultrenderer))
                        {
                            f8 = (float)l - f1 - f3 - 10F;
                        }
                        int k2 = paint.breakText(s, true, f8, af);
                        s = (new StringBuilder()).append(s.substring(0, k2)).append("...").toString();
                    }
                    if (!flag)
                    {
                        drawLegendShape(canvas, simpleseriesrenderer, f1, f2, l1, paint);
                        drawString(canvas, s, 5F + (f1 + f3), f2 + 5F, paint);
                    }
                    f1 += f6;
                } else
                {
                    f4 = f;
                }
                l1++;
                f = f4;
            }
        }
        return Math.round(f + defaultrenderer.getLegendTextSize());
    }

    public abstract void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleseriesrenderer, float f, float f1, int i, Paint paint);

    protected void drawPath(Canvas canvas, List list, Paint paint, boolean flag)
    {
        Path path = new Path();
        int i = canvas.getHeight();
        int j = canvas.getWidth();
        if (list.size() < 4)
        {
            return;
        }
        float af[] = a(((Float)list.get(0)).floatValue(), ((Float)list.get(1)).floatValue(), ((Float)list.get(2)).floatValue(), ((Float)list.get(3)).floatValue(), i, j);
        path.moveTo(af[0], af[1]);
        path.lineTo(af[2], af[3]);
        int k = list.size();
        int l = 4;
        while (l < k) 
        {
            if ((((Float)list.get(l - 1)).floatValue() >= 0.0F || ((Float)list.get(l + 1)).floatValue() >= 0.0F) && (((Float)list.get(l - 1)).floatValue() <= (float)i || ((Float)list.get(l + 1)).floatValue() <= (float)i))
            {
                float af1[] = a(((Float)list.get(l - 2)).floatValue(), ((Float)list.get(l - 1)).floatValue(), ((Float)list.get(l)).floatValue(), ((Float)list.get(l + 1)).floatValue(), i, j);
                if (!flag)
                {
                    path.moveTo(af1[0], af1[1]);
                }
                path.lineTo(af1[2], af1[3]);
            }
            l += 2;
        }
        if (flag)
        {
            path.lineTo(((Float)list.get(0)).floatValue(), ((Float)list.get(1)).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    protected void drawPath(Canvas canvas, float af[], Paint paint, boolean flag)
    {
        Path path = new Path();
        int i = canvas.getHeight();
        int j = canvas.getWidth();
        if (af.length < 4)
        {
            return;
        }
        float af1[] = a(af[0], af[1], af[2], af[3], i, j);
        path.moveTo(af1[0], af1[1]);
        path.lineTo(af1[2], af1[3]);
        int k = af.length;
        int l = 4;
        while (l < k) 
        {
            if ((af[l - 1] >= 0.0F || af[l + 1] >= 0.0F) && (af[l - 1] <= (float)i || af[l + 1] <= (float)i))
            {
                float af2[] = a(af[l - 2], af[l - 1], af[l], af[l + 1], i, j);
                if (!flag)
                {
                    path.moveTo(af2[0], af2[1]);
                }
                path.lineTo(af2[2], af2[3]);
            }
            l += 2;
        }
        if (flag)
        {
            path.lineTo(af[0], af[1]);
        }
        canvas.drawPath(path, paint);
    }

    protected void drawString(Canvas canvas, String s, float f, float f1, Paint paint)
    {
        if (s != null)
        {
            String as[] = s.split("\n");
            Rect rect = new Rect();
            int i = 0;
            int j = 0;
            for (; i < as.length; i++)
            {
                canvas.drawText(as[i], f, f1 + (float)j, paint);
                paint.getTextBounds(as[i], 0, as[i].length(), rect);
                j = 5 + (j + rect.height());
            }

        }
    }

    protected boolean getExceed(float f, DefaultRenderer defaultrenderer, int i, int j)
    {
        boolean flag;
        if (f > (float)i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isVertical(defaultrenderer))
        {
            return f > (float)j;
        } else
        {
            return flag;
        }
    }

    protected String getLabel(NumberFormat numberformat, double d)
    {
        if (numberformat != null)
        {
            return numberformat.format(d);
        }
        if (d == (double)Math.round(d))
        {
            return (new StringBuilder()).append(Math.round(d)).append("").toString();
        } else
        {
            return (new StringBuilder()).append(d).append("").toString();
        }
    }

    public abstract int getLegendShapeWidth(int i);

    protected int getLegendSize(DefaultRenderer defaultrenderer, int i, float f)
    {
        int j = defaultrenderer.getLegendHeight();
        if (!defaultrenderer.isShowLegend() || j != 0)
        {
            i = j;
        }
        if (!defaultrenderer.isShowLegend() && defaultrenderer.isShowLabels())
        {
            i = (int)(f + (4F * defaultrenderer.getLabelsTextSize()) / 3F);
        }
        return i;
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point)
    {
        return null;
    }

    public boolean isNullValue(double d)
    {
        return Double.isNaN(d) || Double.isInfinite(d) || d == 1.7976931348623157E+308D;
    }

    public boolean isVertical(DefaultRenderer defaultrenderer)
    {
        return (defaultrenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer)defaultrenderer).getOrientation() == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL;
    }
}
