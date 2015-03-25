// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.util.MathHelper;

// Referenced classes of package org.achartengine.chart:
//            AbstractChart, ScatterChart, ClickableArea

public abstract class XYChart extends AbstractChart
{

    private float a;
    private float b;
    private Point c;
    private Rect d;
    private final Map e;
    private Map f;
    protected XYMultipleSeriesDataset mDataset;
    protected XYMultipleSeriesRenderer mRenderer;

    protected XYChart()
    {
        e = new HashMap();
        f = new HashMap();
    }

    public XYChart(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer)
    {
        e = new HashMap();
        f = new HashMap();
        mDataset = xymultipleseriesdataset;
        mRenderer = xymultipleseriesrenderer;
    }

    private int a(android.graphics.Paint.Align align)
    {
        int i = 4;
        if (align == android.graphics.Paint.Align.LEFT)
        {
            i = -i;
        }
        return i;
    }

    private List a(List list)
    {
        ArrayList arraylist = new ArrayList(list);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Double double1 = (Double)iterator.next();
            if (double1.isNaN())
            {
                arraylist.remove(double1);
            }
        } while (true);
        return arraylist;
    }

    private void a(Canvas canvas, float f1, boolean flag)
    {
        if (flag)
        {
            canvas.scale(1.0F / a, a);
            canvas.translate(b, -b);
            canvas.rotate(-f1, c.getX(), c.getY());
            return;
        } else
        {
            canvas.rotate(f1, c.getX(), c.getY());
            canvas.translate(-b, b);
            canvas.scale(a, 1.0F / a);
            return;
        }
    }

    private void a(android.graphics.Paint.Cap cap, android.graphics.Paint.Join join, float f1, android.graphics.Paint.Style style, PathEffect patheffect, Paint paint)
    {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f1);
        paint.setPathEffect(patheffect);
        paint.setStyle(style);
    }

    protected abstract ClickableArea[] clickableAreasForPoints(List list, List list1, float f1, int i, int j);

    public void draw(Canvas canvas, int i, int j, int k, int l, Paint paint)
    {
        int i10;
        paint.setAntiAlias(mRenderer.isAntialiasing());
        int i1 = getLegendSize(mRenderer, l / 5, mRenderer.getAxisTitleTextSize());
        int ai[] = mRenderer.getMargins();
        int j1 = i + ai[1];
        int k1 = j + ai[0];
        int l1 = (i + k) - ai[3];
        int i2 = mDataset.getSeriesCount();
        String as[] = new String[i2];
        for (int j2 = 0; j2 < i2; j2++)
        {
            as[j2] = mDataset.getSeriesAt(j2).getTitle();
        }

        int k2;
        int l2;
        org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation orientation;
        int i3;
        int j3;
        int k3;
        boolean flag;
        int l3;
        int j4;
        double ad[];
        double ad1[];
        double ad2[];
        double ad3[];
        boolean aflag[];
        boolean aflag1[];
        boolean aflag2[];
        boolean aflag3[];
        int k4;
        double ad4[];
        double ad5[];
        int l4;
        int i5;
        boolean flag1;
        int j5;
        XYMultipleSeriesRenderer xymultipleseriesrenderer;
        int k5;
        int l5;
        XYMultipleSeriesRenderer xymultipleseriesrenderer1;
        int i6;
        int j6;
        int k6;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        List list;
        Map map;
        Double adouble[];
        double d1;
        double d2;
        double d3;
        XYMultipleSeriesRenderer xymultipleseriesrenderer2;
        int l6;
        boolean flag5;
        int i7;
        boolean flag6;
        XYMultipleSeriesRenderer xymultipleseriesrenderer3;
        int j7;
        float f1;
        int k7;
        int l7;
        android.graphics.Paint.Align align;
        Double adouble1[];
        int i8;
        int j8;
        Double double1;
        float f2;
        String s;
        XYMultipleSeriesRenderer xymultipleseriesrenderer4;
        int k8;
        int l8;
        int i9;
        XYSeries xyseries;
        int j9;
        SimpleSeriesRenderer simpleseriesrenderer;
        ArrayList arraylist;
        ArrayList arraylist1;
        float f3;
        LinkedList linkedlist;
        Exception exception;
        SortedMap sortedmap;
        int k9;
        Iterator iterator;
        int l9;
        Rect rect;
        float f4;
        float f5;
        java.util.Map.Entry entry;
        double d4;
        double d5;
        XYSeries xyseries1;
        int j10;
        double d6;
        double d7;
        double d8;
        double d9;
        if (mRenderer.isFitLegend() && mRenderer.isShowLegend())
        {
            k2 = drawLegend(canvas, mRenderer, as, j1, l1, j, k, l, i1, paint, true);
        } else
        {
            k2 = i1;
        }
        l2 = (j + l) - ai[2] - k2;
        if (d == null)
        {
            d = new Rect();
        }
        d.set(j1, k1, l1, l2);
        drawBackground(mRenderer, canvas, i, j, k, l, paint, false, 0);
        if (paint.getTypeface() == null || mRenderer.getTextTypeface() != null && paint.getTypeface().equals(mRenderer.getTextTypeface()) || !paint.getTypeface().toString().equals(mRenderer.getTextTypefaceName()) || paint.getTypeface().getStyle() != mRenderer.getTextTypefaceStyle())
        {
            if (mRenderer.getTextTypeface() != null)
            {
                paint.setTypeface(mRenderer.getTextTypeface());
            } else
            {
                paint.setTypeface(Typeface.create(mRenderer.getTextTypefaceName(), mRenderer.getTextTypefaceStyle()));
            }
        }
        orientation = mRenderer.getOrientation();
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
        {
            int k10 = l1 - k2;
            i3 = l2 + (k2 - 20);
            j3 = k10;
        } else
        {
            i3 = l2;
            j3 = l1;
        }
        k3 = orientation.getAngle();
        if (k3 == 90)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = (float)l / (float)k;
        b = Math.abs(k - l) / 2;
        if (a < 1.0F)
        {
            b = -1F * b;
        }
        c = new Point((i + k) / 2, (j + l) / 2);
        if (flag)
        {
            a(canvas, k3, false);
        }
        l3 = 0x80000001;
        for (int i4 = 0; i4 < i2; i4++)
        {
            l3 = Math.max(l3, mDataset.getSeriesAt(i4).getScaleNumber());
        }

        j4 = l3 + 1;
        if (j4 >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ad = new double[j4];
        ad1 = new double[j4];
        ad2 = new double[j4];
        ad3 = new double[j4];
        aflag = new boolean[j4];
        aflag1 = new boolean[j4];
        aflag2 = new boolean[j4];
        aflag3 = new boolean[j4];
        for (k4 = 0; k4 < j4; k4++)
        {
            ad[k4] = mRenderer.getXAxisMin(k4);
            ad1[k4] = mRenderer.getXAxisMax(k4);
            ad2[k4] = mRenderer.getYAxisMin(k4);
            ad3[k4] = mRenderer.getYAxisMax(k4);
            aflag[k4] = mRenderer.isMinXSet(k4);
            aflag1[k4] = mRenderer.isMaxXSet(k4);
            aflag2[k4] = mRenderer.isMinYSet(k4);
            aflag3[k4] = mRenderer.isMaxYSet(k4);
            if (e.get(Integer.valueOf(k4)) == null)
            {
                e.put(Integer.valueOf(k4), new double[4]);
            }
        }

        ad4 = new double[j4];
        ad5 = new double[j4];
        l4 = 0;
        while (l4 < i2) 
        {
            xyseries1 = mDataset.getSeriesAt(l4);
            j10 = xyseries1.getScaleNumber();
            if (xyseries1.getItemCount() != 0)
            {
                if (!aflag[j10])
                {
                    d9 = xyseries1.getMinX();
                    ad[j10] = Math.min(ad[j10], d9);
                    ((double[])e.get(Integer.valueOf(j10)))[0] = ad[j10];
                }
                if (!aflag1[j10])
                {
                    d8 = xyseries1.getMaxX();
                    ad1[j10] = Math.max(ad1[j10], d8);
                    ((double[])e.get(Integer.valueOf(j10)))[1] = ad1[j10];
                }
                if (!aflag2[j10])
                {
                    d7 = xyseries1.getMinY();
                    ad2[j10] = Math.min(ad2[j10], (float)d7);
                    ((double[])e.get(Integer.valueOf(j10)))[2] = ad2[j10];
                }
                if (!aflag3[j10])
                {
                    d6 = xyseries1.getMaxY();
                    ad3[j10] = Math.max(ad3[j10], (float)d6);
                    ((double[])e.get(Integer.valueOf(j10)))[3] = ad3[j10];
                }
            }
            l4++;
        }
        for (i5 = 0; i5 < j4; i5++)
        {
            if (ad1[i5] - ad[i5] != 0.0D)
            {
                ad4[i5] = (double)(j3 - j1) / (ad1[i5] - ad[i5]);
            }
            if (ad3[i5] - ad2[i5] != 0.0D)
            {
                ad5[i5] = (float)((double)(i3 - k1) / (ad3[i5] - ad2[i5]));
            }
        }

        flag1 = false;
        f = new HashMap();
        j5 = 0;
_L7:
        if (j5 >= i2) goto _L4; else goto _L3
_L3:
        xyseries = mDataset.getSeriesAt(j5);
        j9 = xyseries.getScaleNumber();
        if (xyseries.getItemCount() != 0) goto _L6; else goto _L5
_L5:
        j5++;
          goto _L7
_L6:
        simpleseriesrenderer = mRenderer.getSeriesRendererAt(j5);
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        f3 = Math.min(i3, (float)((double)i3 + ad5[j9] * ad2[j9]));
        linkedlist = new LinkedList();
        f.put(Integer.valueOf(j5), linkedlist);
        xyseries;
        JVM INSTR monitorenter ;
        sortedmap = xyseries.getRange(ad[j9], ad1[j9], simpleseriesrenderer.isDisplayBoundingPoints());
        k9 = -1;
        iterator = sortedmap.entrySet().iterator();
_L8:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_1654;
        }
        entry = (java.util.Map.Entry)iterator.next();
        d4 = ((Double)entry.getKey()).doubleValue();
        d5 = ((Double)entry.getValue()).doubleValue();
        if (k9 >= 0)
        {
            break MISSING_BLOCK_LABEL_1395;
        }
        if (!isNullValue(d5) || isRenderNullValues())
        {
            k9 = xyseries.getIndexForKey(d4);
        }
        arraylist1.add(entry.getKey());
        arraylist1.add(entry.getValue());
        if (isNullValue(d5))
        {
            break MISSING_BLOCK_LABEL_1505;
        }
        arraylist.add(Float.valueOf((float)((double)j1 + ad4[j9] * (d4 - ad[j9]))));
        arraylist.add(Float.valueOf((float)((double)i3 - ad5[j9] * (d5 - ad2[j9]))));
          goto _L8
        exception;
        xyseries;
        JVM INSTR monitorexit ;
        throw exception;
label0:
        {
            if (!isRenderNullValues())
            {
                break label0;
            }
            arraylist.add(Float.valueOf((float)((double)j1 + ad4[j9] * (d4 - ad[j9]))));
            arraylist.add(Float.valueOf((float)((double)i3 - ad5[j9] * -ad2[j9])));
        }
          goto _L8
        if (arraylist.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1644;
        }
        drawSeries(xyseries, canvas, paint, arraylist, simpleseriesrenderer, f3, j5, orientation, k9);
        linkedlist.addAll(Arrays.asList(clickableAreasForPoints(arraylist, arraylist1, f3, j5, k9)));
        arraylist.clear();
        arraylist1.clear();
        k9 = -1;
        linkedlist.add(null);
          goto _L8
        l9 = xyseries.getAnnotationCount();
        if (l9 <= 0) goto _L10; else goto _L9
_L9:
        paint.setColor(mRenderer.getLabelsColor());
        rect = new Rect();
        i10 = 0;
_L12:
        if (i10 >= l9) goto _L10; else goto _L11
_L11:
        f4 = (float)((double)j1 + ad4[j9] * (xyseries.getAnnotationX(i10) - ad[j9]));
        f5 = (float)((double)i3 - ad5[j9] * (xyseries.getAnnotationY(i10) - ad2[j9]));
        paint.getTextBounds(xyseries.getAnnotationAt(i10), 0, xyseries.getAnnotationAt(i10).length(), rect);
        if (f4 < f4 + (float)rect.width() && f5 < (float)canvas.getHeight())
        {
            drawString(canvas, xyseries.getAnnotationAt(i10), f4, f5, paint);
        }
        break MISSING_BLOCK_LABEL_3432;
_L10:
        if (arraylist.size() > 0)
        {
            drawSeries(xyseries, canvas, paint, arraylist, simpleseriesrenderer, f3, j5, orientation, k9);
            linkedlist.addAll(Arrays.asList(clickableAreasForPoints(arraylist, arraylist1, f3, j5, k9)));
        }
        xyseries;
        JVM INSTR monitorexit ;
        flag1 = true;
          goto _L5
_L4:
        xymultipleseriesrenderer = mRenderer;
        k5 = l - i3;
        l5 = mRenderer.getMarginsColor();
        drawBackground(xymultipleseriesrenderer, canvas, i, i3, k, k5, paint, true, l5);
        drawBackground(mRenderer, canvas, i, j, k, ai[0], paint, true, mRenderer.getMarginsColor());
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
        {
            drawBackground(mRenderer, canvas, i, j, j1 - i, l - j, paint, true, mRenderer.getMarginsColor());
            xymultipleseriesrenderer4 = mRenderer;
            k8 = ai[3];
            l8 = l - j;
            i9 = mRenderer.getMarginsColor();
            drawBackground(xymultipleseriesrenderer4, canvas, j3, j, k8, l8, paint, true, i9);
        } else
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
        {
            xymultipleseriesrenderer1 = mRenderer;
            i6 = k - j3;
            j6 = l - j;
            k6 = mRenderer.getMarginsColor();
            drawBackground(xymultipleseriesrenderer1, canvas, j3, j, i6, j6, paint, true, k6);
            drawBackground(mRenderer, canvas, i, j, j1 - i, l - j, paint, true, mRenderer.getMarginsColor());
        }
        if (mRenderer.isShowLabels() && flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = mRenderer.isShowGridX();
        flag4 = mRenderer.isShowCustomTextGrid();
        if (flag2 || flag3)
        {
            list = a(getXLabels(ad[0], ad1[0], mRenderer.getXLabels()));
            map = getYLabels(ad2, ad3, j4);
            if (flag2)
            {
                paint.setColor(mRenderer.getXLabelsColor());
                paint.setTextSize(mRenderer.getLabelsTextSize());
                paint.setTextAlign(mRenderer.getXLabelsAlign());
            }
            adouble = mRenderer.getXTextLabelLocations();
            d1 = ad4[0];
            d2 = ad[0];
            d3 = ad1[0];
            drawXLabels(list, adouble, canvas, paint, j1, k1, i3, d1, d2, d3);
            drawYLabels(map, canvas, paint, j4, j1, j3, i3, ad5, ad2);
            if (flag2)
            {
                paint.setColor(mRenderer.getLabelsColor());
                for (l7 = 0; l7 < j4; l7++)
                {
                    align = mRenderer.getYAxisAlign(l7);
                    adouble1 = mRenderer.getYTextLabelLocations(l7);
                    i8 = adouble1.length;
                    j8 = 0;
                    while (j8 < i8) 
                    {
                        double1 = adouble1[j8];
                        if (ad2[l7] <= double1.doubleValue() && double1.doubleValue() <= ad3[l7])
                        {
                            f2 = (float)((double)i3 - ad5[l7] * (double1.doubleValue() - ad2[l7]));
                            s = mRenderer.getYTextLabel(double1, l7);
                            paint.setColor(mRenderer.getYLabelsColor(l7));
                            paint.setTextAlign(mRenderer.getYLabelsAlign(l7));
                            if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
                            {
                                if (align == android.graphics.Paint.Align.LEFT)
                                {
                                    canvas.drawLine(j1 + a(align), f2, j1, f2, paint);
                                    drawText(canvas, s, j1, f2 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                                } else
                                {
                                    canvas.drawLine(j3, f2, j3 + a(align), f2, paint);
                                    drawText(canvas, s, j3, f2 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                                }
                                if (flag4)
                                {
                                    paint.setColor(mRenderer.getGridColor());
                                    canvas.drawLine(j1, f2, j3, f2, paint);
                                }
                            } else
                            {
                                canvas.drawLine(j3 - a(align), f2, j3, f2, paint);
                                drawText(canvas, s, j3 + 10, f2 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                                if (flag4)
                                {
                                    paint.setColor(mRenderer.getGridColor());
                                    canvas.drawLine(j3, f2, j1, f2, paint);
                                }
                            }
                        }
                        j8++;
                    }
                }

            }
            if (flag2)
            {
                paint.setColor(mRenderer.getLabelsColor());
                f1 = mRenderer.getAxisTitleTextSize();
                paint.setTextSize(f1);
                paint.setTextAlign(android.graphics.Paint.Align.CENTER);
                if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
                {
                    drawText(canvas, mRenderer.getXTitle(), i + k / 2, f1 + ((float)i3 + (4F * mRenderer.getLabelsTextSize()) / 3F + mRenderer.getXLabelsPadding()), paint, 0.0F);
                    k7 = 0;
                    while (k7 < j4) 
                    {
                        if (mRenderer.getYAxisAlign(k7) == android.graphics.Paint.Align.LEFT)
                        {
                            drawText(canvas, mRenderer.getYTitle(k7), f1 + (float)i, j + l / 2, paint, -90F);
                        } else
                        {
                            drawText(canvas, mRenderer.getYTitle(k7), i + k, j + l / 2, paint, -90F);
                        }
                        k7++;
                    }
                    paint.setTextSize(mRenderer.getChartTitleTextSize());
                    drawText(canvas, mRenderer.getChartTitle(), i + k / 2, (float)j + mRenderer.getChartTitleTextSize(), paint, 0.0F);
                } else
                if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
                {
                    drawText(canvas, mRenderer.getXTitle(), i + k / 2, ((float)(j + l) - f1) + mRenderer.getXLabelsPadding(), paint, -90F);
                    drawText(canvas, mRenderer.getYTitle(), j3 + 20, j + l / 2, paint, 0.0F);
                    paint.setTextSize(mRenderer.getChartTitleTextSize());
                    drawText(canvas, mRenderer.getChartTitle(), f1 + (float)i, k1 + l / 2, paint, 0.0F);
                }
            }
        }
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
        {
            xymultipleseriesrenderer3 = mRenderer;
            j7 = j + (int)mRenderer.getXLabelsPadding();
            drawLegend(canvas, xymultipleseriesrenderer3, as, j1, j3, j7, k, l, k2, paint, false);
        } else
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
        {
            a(canvas, k3, true);
            xymultipleseriesrenderer2 = mRenderer;
            l6 = j + (int)mRenderer.getXLabelsPadding();
            drawLegend(canvas, xymultipleseriesrenderer2, as, j1, j3, l6, k, l, k2, paint, false);
            a(canvas, k3, false);
        }
        if (mRenderer.isShowAxes())
        {
            paint.setColor(mRenderer.getAxesColor());
            canvas.drawLine(j1, i3, j3, i3, paint);
            flag5 = false;
            i7 = 0;
            while (i7 < j4 && !flag5) 
            {
                if (mRenderer.getYAxisAlign(i7) == android.graphics.Paint.Align.RIGHT)
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
                i7++;
                flag5 = flag6;
            }
            if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
            {
                canvas.drawLine(j1, k1, j1, i3, paint);
                if (flag5)
                {
                    canvas.drawLine(j3, k1, j3, i3, paint);
                }
            } else
            if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
            {
                canvas.drawLine(j3, k1, j3, i3, paint);
            }
        }
        if (flag)
        {
            a(canvas, k3, true);
            return;
        }
          goto _L1
        i10++;
          goto _L12
    }

    protected void drawChartValuesText(Canvas canvas, XYSeries xyseries, SimpleSeriesRenderer simpleseriesrenderer, Paint paint, List list, int i, int j)
    {
        if (list.size() > 1)
        {
            float f1 = ((Float)list.get(0)).floatValue();
            float f2 = ((Float)list.get(1)).floatValue();
            int l = 0;
            while (l < list.size()) 
            {
                if (l == 2)
                {
                    if (Math.abs(((Float)list.get(2)).floatValue() - ((Float)list.get(0)).floatValue()) > (float)simpleseriesrenderer.getDisplayChartValuesDistance() || Math.abs(((Float)list.get(3)).floatValue() - ((Float)list.get(1)).floatValue()) > (float)simpleseriesrenderer.getDisplayChartValuesDistance())
                    {
                        drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(j)), ((Float)list.get(0)).floatValue(), ((Float)list.get(1)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
                        drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(j + 1)), ((Float)list.get(2)).floatValue(), ((Float)list.get(3)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
                        f1 = ((Float)list.get(2)).floatValue();
                        f2 = ((Float)list.get(3)).floatValue();
                    }
                } else
                if (l > 2 && (Math.abs(((Float)list.get(l)).floatValue() - f1) > (float)simpleseriesrenderer.getDisplayChartValuesDistance() || Math.abs(((Float)list.get(l + 1)).floatValue() - f2) > (float)simpleseriesrenderer.getDisplayChartValuesDistance()))
                {
                    drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(j + l / 2)), ((Float)list.get(l)).floatValue(), ((Float)list.get(l + 1)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
                    f1 = ((Float)list.get(l)).floatValue();
                    f2 = ((Float)list.get(l + 1)).floatValue();
                }
                l += 2;
            }
        } else
        {
            for (int k = 0; k < list.size(); k += 2)
            {
                drawText(canvas, getLabel(simpleseriesrenderer.getChartValuesFormat(), xyseries.getY(j + k / 2)), ((Float)list.get(k)).floatValue(), ((Float)list.get(k + 1)).floatValue() - simpleseriesrenderer.getChartValuesSpacing(), paint, 0.0F);
            }

        }
    }

    public abstract void drawSeries(Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f1, int i, int j);

    protected void drawSeries(XYSeries xyseries, Canvas canvas, Paint paint, List list, SimpleSeriesRenderer simpleseriesrenderer, float f1, int i, 
            org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation orientation, int j)
    {
        BasicStroke basicstroke = simpleseriesrenderer.getStroke();
        android.graphics.Paint.Cap cap = paint.getStrokeCap();
        android.graphics.Paint.Join join = paint.getStrokeJoin();
        float f2 = paint.getStrokeMiter();
        PathEffect patheffect = paint.getPathEffect();
        android.graphics.Paint.Style style = paint.getStyle();
        if (basicstroke != null)
        {
            float af[] = basicstroke.getIntervals();
            DashPathEffect dashpatheffect = null;
            if (af != null)
            {
                dashpatheffect = new DashPathEffect(basicstroke.getIntervals(), basicstroke.getPhase());
            }
            a(basicstroke.getCap(), basicstroke.getJoin(), basicstroke.getMiter(), android.graphics.Paint.Style.FILL_AND_STROKE, dashpatheffect, paint);
        }
        drawSeries(canvas, paint, list, simpleseriesrenderer, f1, i, j);
        if (isRenderPoints(simpleseriesrenderer))
        {
            ScatterChart scatterchart = getPointsChart();
            if (scatterchart != null)
            {
                scatterchart.drawSeries(canvas, paint, list, simpleseriesrenderer, f1, i, j);
            }
        }
        paint.setTextSize(simpleseriesrenderer.getChartValuesTextSize());
        if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
        {
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        } else
        {
            paint.setTextAlign(android.graphics.Paint.Align.LEFT);
        }
        if (simpleseriesrenderer.isDisplayChartValues())
        {
            paint.setTextAlign(simpleseriesrenderer.getChartValuesTextAlign());
            drawChartValuesText(canvas, xyseries, simpleseriesrenderer, paint, list, i, j);
        }
        if (basicstroke != null)
        {
            a(cap, join, f2, style, patheffect, paint);
        }
    }

    protected void drawText(Canvas canvas, String s, float f1, float f2, Paint paint, float f3)
    {
        float f4 = f3 + (float)(-mRenderer.getOrientation().getAngle());
        if (f4 != 0.0F)
        {
            canvas.rotate(f4, f1, f2);
        }
        drawString(canvas, s, f1, f2, paint);
        if (f4 != 0.0F)
        {
            canvas.rotate(-f4, f1, f2);
        }
    }

    protected void drawXLabels(List list, Double adouble[], Canvas canvas, Paint paint, int i, int j, int k, 
            double d1, double d2, double d3)
    {
        int l = list.size();
        boolean flag = mRenderer.isShowLabels();
        boolean flag1 = mRenderer.isShowGridY();
        for (int i1 = 0; i1 < l; i1++)
        {
            double d4 = ((Double)list.get(i1)).doubleValue();
            float f1 = (float)((double)i + d1 * (d4 - d2));
            if (flag)
            {
                paint.setColor(mRenderer.getXLabelsColor());
                canvas.drawLine(f1, k, f1, (float)k + mRenderer.getLabelsTextSize() / 3F, paint);
                drawText(canvas, getLabel(mRenderer.getLabelFormat(), d4), f1, (float)k + (4F * mRenderer.getLabelsTextSize()) / 3F + mRenderer.getXLabelsPadding(), paint, mRenderer.getXLabelsAngle());
            }
            if (flag1)
            {
                paint.setColor(mRenderer.getGridColor());
                canvas.drawLine(f1, k, f1, j, paint);
            }
        }

        drawXTextLabels(adouble, canvas, paint, flag, i, j, k, d1, d2, d3);
    }

    protected void drawXTextLabels(Double adouble[], Canvas canvas, Paint paint, boolean flag, int i, int j, int k, 
            double d1, double d2, double d3)
    {
        boolean flag1 = mRenderer.isShowCustomTextGrid();
        if (flag)
        {
            paint.setColor(mRenderer.getXLabelsColor());
            int l = adouble.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                Double double1 = adouble[i1];
                if (d2 > double1.doubleValue() || double1.doubleValue() > d3)
                {
                    continue;
                }
                float f1 = (float)((double)i + d1 * (double1.doubleValue() - d2));
                paint.setColor(mRenderer.getXLabelsColor());
                canvas.drawLine(f1, k, f1, (float)k + mRenderer.getLabelsTextSize() / 3F, paint);
                drawText(canvas, mRenderer.getXTextLabel(double1), f1, (float)k + (4F * mRenderer.getLabelsTextSize()) / 3F, paint, mRenderer.getXLabelsAngle());
                if (flag1)
                {
                    paint.setColor(mRenderer.getGridColor());
                    canvas.drawLine(f1, k, f1, j, paint);
                }
            }

        }
    }

    protected void drawYLabels(Map map, Canvas canvas, Paint paint, int i, int j, int k, int l, 
            double ad[], double ad1[])
    {
        org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation orientation = mRenderer.getOrientation();
        boolean flag = mRenderer.isShowGridX();
        boolean flag1 = mRenderer.isShowLabels();
        int i1 = 0;
        do
        {
            if (i1 >= i)
            {
                break;
            }
            paint.setTextAlign(mRenderer.getYLabelsAlign(i1));
            List list = (List)map.get(Integer.valueOf(i1));
            int j1 = list.size();
            int k1 = 0;
            while (k1 < j1) 
            {
                double d1 = ((Double)list.get(k1)).doubleValue();
                android.graphics.Paint.Align align = mRenderer.getYAxisAlign(i1);
                boolean flag2;
                float f1;
                if (mRenderer.getYTextLabel(Double.valueOf(d1), i1) != null)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                f1 = (float)((double)l - ad[i1] * (d1 - ad1[i1]));
                if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
                {
                    if (flag1 && !flag2)
                    {
                        paint.setColor(mRenderer.getYLabelsColor(i1));
                        if (align == android.graphics.Paint.Align.LEFT)
                        {
                            canvas.drawLine(j + a(align), f1, j, f1, paint);
                            drawText(canvas, getLabel(mRenderer.getLabelFormat(), d1), (float)j - mRenderer.getYLabelsPadding(), f1 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                        } else
                        {
                            canvas.drawLine(k, f1, k + a(align), f1, paint);
                            drawText(canvas, getLabel(mRenderer.getLabelFormat(), d1), (float)k + mRenderer.getYLabelsPadding(), f1 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                        }
                    }
                    if (flag)
                    {
                        paint.setColor(mRenderer.getGridColor());
                        canvas.drawLine(j, f1, k, f1, paint);
                    }
                } else
                if (orientation == org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation.VERTICAL)
                {
                    if (flag1 && !flag2)
                    {
                        paint.setColor(mRenderer.getYLabelsColor(i1));
                        canvas.drawLine(k - a(align), f1, k, f1, paint);
                        drawText(canvas, getLabel(mRenderer.getLabelFormat(), d1), (float)(k + 10) + mRenderer.getYLabelsPadding(), f1 - mRenderer.getYLabelsVerticalPadding(), paint, mRenderer.getYLabelsAngle());
                    }
                    if (flag)
                    {
                        paint.setColor(mRenderer.getGridColor());
                        canvas.drawLine(k, f1, j, f1, paint);
                    }
                }
                k1++;
            }
            i1++;
        } while (true);
    }

    public double[] getCalcRange(int i)
    {
        return (double[])e.get(Integer.valueOf(i));
    }

    public abstract String getChartType();

    public XYMultipleSeriesDataset getDataset()
    {
        return mDataset;
    }

    public double getDefaultMinimum()
    {
        return 1.7976931348623157E+308D;
    }

    public ScatterChart getPointsChart()
    {
        return null;
    }

    public XYMultipleSeriesRenderer getRenderer()
    {
        return mRenderer;
    }

    protected Rect getScreenR()
    {
        return d;
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point)
    {
        if (f != null)
        {
            for (int i = -1 + f.size(); i >= 0; i--)
            {
                int j = 0;
                if (f.get(Integer.valueOf(i)) == null)
                {
                    continue;
                }
                for (Iterator iterator = ((List)f.get(Integer.valueOf(i))).iterator(); iterator.hasNext(); j++)
                {
                    ClickableArea clickablearea = (ClickableArea)iterator.next();
                    if (clickablearea == null)
                    {
                        continue;
                    }
                    RectF rectf = clickablearea.getRect();
                    if (rectf != null && rectf.contains(point.getX(), point.getY()))
                    {
                        return new SeriesSelection(i, j, clickablearea.getX(), clickablearea.getY());
                    }
                }

            }

        }
        return super.getSeriesAndPointForScreenCoordinate(point);
    }

    protected List getXLabels(double d1, double d2, int i)
    {
        return MathHelper.getLabels(d1, d2, i);
    }

    protected Map getYLabels(double ad[], double ad1[], int i)
    {
        HashMap hashmap = new HashMap();
        for (int j = 0; j < i; j++)
        {
            hashmap.put(Integer.valueOf(j), a(MathHelper.getLabels(ad[j], ad1[j], mRenderer.getYLabels())));
        }

        return hashmap;
    }

    protected boolean isRenderNullValues()
    {
        return false;
    }

    public boolean isRenderPoints(SimpleSeriesRenderer simpleseriesrenderer)
    {
        return false;
    }

    public void setCalcRange(double ad[], int i)
    {
        e.put(Integer.valueOf(i), ad);
    }

    protected void setDatasetRenderer(XYMultipleSeriesDataset xymultipleseriesdataset, XYMultipleSeriesRenderer xymultipleseriesrenderer)
    {
        mDataset = xymultipleseriesdataset;
        mRenderer = xymultipleseriesrenderer;
    }

    protected void setScreenR(Rect rect)
    {
        d = rect;
    }

    public double[] toRealPoint(float f1, float f2)
    {
        return toRealPoint(f1, f2, 0);
    }

    public double[] toRealPoint(float f1, float f2, int i)
    {
        double d1 = mRenderer.getXAxisMin(i);
        double d2 = mRenderer.getXAxisMax(i);
        double d3 = mRenderer.getYAxisMin(i);
        double d4 = mRenderer.getYAxisMax(i);
        if (d != null)
        {
            double ad1[] = new double[2];
            ad1[0] = d1 + ((double)(f1 - (float)d.left) * (d2 - d1)) / (double)d.width();
            ad1[1] = d3 + ((double)((float)(d.top + d.height()) - f2) * (d4 - d3)) / (double)d.height();
            return ad1;
        } else
        {
            double ad[] = new double[2];
            ad[0] = f1;
            ad[1] = f2;
            return ad;
        }
    }

    public double[] toScreenPoint(double ad[])
    {
        return toScreenPoint(ad, 0);
    }

    public double[] toScreenPoint(double ad[], int i)
    {
        double d1 = mRenderer.getXAxisMin(i);
        double d2 = mRenderer.getXAxisMax(i);
        double d3 = mRenderer.getYAxisMin(i);
        double d4 = mRenderer.getYAxisMax(i);
        if (!mRenderer.isMinXSet(i) || !mRenderer.isMaxXSet(i) || !mRenderer.isMinXSet(i) || !mRenderer.isMaxYSet(i))
        {
            double ad1[] = getCalcRange(i);
            d1 = ad1[0];
            d2 = ad1[1];
            d3 = ad1[2];
            d4 = ad1[3];
        }
        if (d != null)
        {
            double ad2[] = new double[2];
            ad2[0] = ((ad[0] - d1) * (double)d.width()) / (d2 - d1) + (double)d.left;
            ad2[1] = ((d4 - ad[1]) * (double)d.height()) / (d4 - d3) + (double)d.top;
            ad = ad2;
        }
        return ad;
    }
}
