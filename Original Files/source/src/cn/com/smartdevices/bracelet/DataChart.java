// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import cn.com.smartdevices.bracelet.analysis.StageSteps;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug

public class DataChart
{

    private static DataChart a = null;
    private ArrayList b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public DataChart()
    {
        b = null;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
    }

    public static DataChart getInstance()
    {
        if (a == null)
        {
            a = new DataChart();
        }
        return a;
    }

    public List deepCopy(List list)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        (new ObjectOutputStream(bytearrayoutputstream)).writeObject(list);
        return (List)(new ObjectInputStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()))).readObject();
    }

    public Intent executeBarChart(Context context, DaySportData daysportdata)
    {
        XYMultipleSeriesDataset xymultipleseriesdataset;
        XYSeries xyseries;
        XYSeries xyseries1;
        XYSeries xyseries2;
        XYSeries xyseries3;
        XYSeries xyseries4;
        XYSeries xyseries5;
        ArrayList arraylist;
        int i;
        int j;
        int k;
        String as[] = {
            "\u9759\u6B62", "\u6162\u8D70", "\u8DD1\u6B65", "\u6CA1\u6234", "\u6D45\u7761\u7720", "\u6DF1\u7761\u7720"
        };
        xymultipleseriesdataset = new XYMultipleSeriesDataset();
        xyseries = new XYSeries(as[0]);
        xyseries1 = new XYSeries(as[1]);
        xyseries2 = new XYSeries(as[2]);
        xyseries3 = new XYSeries(as[3]);
        xyseries4 = new XYSeries(as[4]);
        xyseries5 = new XYSeries(as[5]);
        arraylist = daysportdata.data();
        i = arraylist.size();
        j = 0;
        k = 0;
_L9:
        if (k >= 1440)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        if (k >= i) goto _L2; else goto _L1
_L1:
        ((SportData)arraylist.get(k)).getSportMode();
        JVM INSTR tableswitch 0 5: default 204
    //                   0 338
    //                   1 351
    //                   2 364
    //                   3 377
    //                   4 390
    //                   5 403;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        int ai[];
        PointStyle apointstyle[];
        XYMultipleSeriesRenderer xymultipleseriesrenderer;
        int l;
        int i1;
        XYSeriesRenderer xyseriesrenderer;
        int j1;
        int k1;
        int l1;
        if ((k + 1) % 60 == 0)
        {
            xyseries.add(j, c);
            xyseries1.add(j, d);
            xyseries2.add(j, e);
            xyseries3.add(j, f);
            xyseries4.add(j, g);
            xyseries5.add(j, h);
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = 0;
            h = 0;
            l1 = j + 1;
        } else
        {
            l1 = j;
        }
        k++;
        j = l1;
        if (true) goto _L9; else goto _L3
_L3:
        c = 1 + c;
          goto _L2
_L4:
        d = 1 + d;
          goto _L2
_L5:
        e = 1 + e;
          goto _L2
_L6:
        f = 1 + f;
          goto _L2
_L7:
        g = 1 + g;
          goto _L2
_L8:
        h = 1 + h;
          goto _L2
        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesdataset.addSeries(xyseries1);
        xymultipleseriesdataset.addSeries(xyseries2);
        xymultipleseriesdataset.addSeries(xyseries3);
        xymultipleseriesdataset.addSeries(xyseries4);
        xymultipleseriesdataset.addSeries(xyseries5);
        ai = (new int[] {
            0xff00ff00, 0xff0000ff, 0xff00ffff, 0xffff0000, -256, -65281
        });
        apointstyle = new PointStyle[6];
        apointstyle[0] = PointStyle.CIRCLE;
        apointstyle[1] = PointStyle.DIAMOND;
        apointstyle[2] = PointStyle.POINT;
        apointstyle[3] = PointStyle.TRIANGLE;
        apointstyle[4] = PointStyle.SQUARE;
        apointstyle[5] = PointStyle.CIRCLE;
        xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xymultipleseriesrenderer.setAxisTitleTextSize(16F);
        xymultipleseriesrenderer.setChartTitleTextSize(20F);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(15F);
        xymultipleseriesrenderer.setPointSize(5F);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        l = ai.length;
        for (i1 = 0; i1 < l; i1++)
        {
            xyseriesrenderer = new XYSeriesRenderer();
            xyseriesrenderer.setColor(ai[i1]);
            xyseriesrenderer.setPointStyle(apointstyle[i1]);
            xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        }

        j1 = xymultipleseriesrenderer.getSeriesRendererCount();
        for (k1 = 0; k1 < j1; k1++)
        {
            ((XYSeriesRenderer)xymultipleseriesrenderer.getSeriesRendererAt(k1)).setFillPoints(true);
        }

        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4\uFF080-23\u5C0F\u65F6\uFF09");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5C0F\u65F6\u5404\u6D3B\u52A8\u65F6\u95F4(\u5206\u949F)");
        xymultipleseriesrenderer.setXAxisMin(0.0D);
        xymultipleseriesrenderer.setXAxisMax(12D);
        xymultipleseriesrenderer.setYAxisMin(0.0D);
        xymultipleseriesrenderer.setYAxisMax(80D);
        xymultipleseriesrenderer.setAxesColor(0xffcccccc);
        xymultipleseriesrenderer.setLabelsColor(0xffcccccc);
        xymultipleseriesrenderer.setXLabels(10);
        xymultipleseriesrenderer.setYLabels(10);
        xymultipleseriesrenderer.setShowGrid(true);
        xymultipleseriesrenderer.setXLabelsAlign(android.graphics.Paint.Align.CENTER);
        xymultipleseriesrenderer.setYLabelsAlign(android.graphics.Paint.Align.RIGHT);
        xymultipleseriesrenderer.setBarSpacing(0.30000001192092896D);
        return ChartFactory.getBarChartIntent(context, xymultipleseriesdataset, xymultipleseriesrenderer, org.achartengine.chart.BarChart.Type.DEFAULT);
    }

    public Intent executeLineChart(Context context, DaySportData daysportdata)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        ArrayList arraylist4;
        ArrayList arraylist5;
        ArrayList arraylist6;
        int i;
        int j;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        arraylist4 = new ArrayList();
        arraylist5 = new ArrayList();
        arraylist6 = daysportdata.data();
        i = arraylist6.size();
        j = 0;
_L9:
        String as[];
        XYMultipleSeriesDataset xymultipleseriesdataset;
        XYSeries xyseries;
        SportData sportdata6;
        int k3;
label0:
        {
            if (j < i)
            {
                sportdata6 = (SportData)arraylist6.get(j);
                k3 = sportdata6.getSportMode();
                if (k3 != 127)
                {
                    break label0;
                }
            }
            as = (new String[] {
                "\u9759\u6B62", "\u6162\u8D70", "\u8DD1\u6B65", "\u6CA1\u6234", "\u6D45\u7761\u7720", "\u6DF1\u7761\u7720"
            });
            xymultipleseriesdataset = new XYMultipleSeriesDataset();
            xyseries = new XYSeries(as[0]);
            for (int k = 0; k < arraylist.size(); k++)
            {
                SportData sportdata5 = (SportData)arraylist.get(k);
                xyseries.add(sportdata5.getTimeIndex(), sportdata5.getActivity());
            }

            break MISSING_BLOCK_LABEL_319;
        }
        k3;
        JVM INSTR tableswitch 0 5: default 248
    //                   0 254
    //                   1 264
    //                   2 275
    //                   3 286
    //                   4 297
    //                   5 308;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_308;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L10:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
        arraylist.add(sportdata6);
          goto _L10
_L3:
        arraylist1.add(sportdata6);
          goto _L10
_L4:
        arraylist2.add(sportdata6);
          goto _L10
_L5:
        arraylist3.add(sportdata6);
          goto _L10
_L6:
        arraylist4.add(sportdata6);
          goto _L10
        arraylist5.add(sportdata6);
          goto _L10
        XYSeries xyseries1 = new XYSeries(as[1]);
        for (int l = 0; l < arraylist1.size(); l++)
        {
            SportData sportdata4 = (SportData)arraylist1.get(l);
            xyseries1.add(sportdata4.getTimeIndex(), sportdata4.getStep());
        }

        XYSeries xyseries2 = new XYSeries(as[2]);
        for (int i1 = 0; i1 < arraylist2.size(); i1++)
        {
            SportData sportdata3 = (SportData)arraylist2.get(i1);
            xyseries2.add(sportdata3.getTimeIndex(), sportdata3.getStep());
        }

        XYSeries xyseries3 = new XYSeries(as[3]);
        for (int j1 = 0; j1 < arraylist3.size(); j1++)
        {
            SportData sportdata2 = (SportData)arraylist3.get(j1);
            xyseries3.add(sportdata2.getTimeIndex(), sportdata2.getActivity());
        }

        XYSeries xyseries4 = new XYSeries(as[4]);
        for (int k1 = 0; k1 < arraylist4.size(); k1++)
        {
            SportData sportdata1 = (SportData)arraylist4.get(k1);
            xyseries4.add(sportdata1.getTimeIndex(), sportdata1.getActivity());
        }

        XYSeries xyseries5 = new XYSeries(as[5]);
        for (int l1 = 0; l1 < arraylist5.size(); l1++)
        {
            SportData sportdata = (SportData)arraylist5.get(l1);
            xyseries5.add(sportdata.getTimeIndex(), sportdata.getActivity());
        }

        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesdataset.addSeries(xyseries1);
        xymultipleseriesdataset.addSeries(xyseries2);
        xymultipleseriesdataset.addSeries(xyseries3);
        xymultipleseriesdataset.addSeries(xyseries4);
        xymultipleseriesdataset.addSeries(xyseries5);
        int ai[] = {
            0xff00ff00, 0xff0000ff, 0xff00ffff, 0xffff0000, -256, -65281
        };
        PointStyle apointstyle[] = new PointStyle[6];
        apointstyle[0] = PointStyle.CIRCLE;
        apointstyle[1] = PointStyle.DIAMOND;
        apointstyle[2] = PointStyle.POINT;
        apointstyle[3] = PointStyle.TRIANGLE;
        apointstyle[4] = PointStyle.SQUARE;
        apointstyle[5] = PointStyle.CIRCLE;
        XYMultipleSeriesRenderer xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xymultipleseriesrenderer.setAxisTitleTextSize(16F);
        xymultipleseriesrenderer.setChartTitleTextSize(20F);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(15F);
        xymultipleseriesrenderer.setPointSize(5F);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        int i2 = ai.length;
        for (int j2 = 0; j2 < i2; j2++)
        {
            XYSeriesRenderer xyseriesrenderer = new XYSeriesRenderer();
            xyseriesrenderer.setColor(ai[j2]);
            xyseriesrenderer.setPointStyle(apointstyle[j2]);
            xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        }

        int k2 = xymultipleseriesrenderer.getSeriesRendererCount();
        for (int l2 = 0; l2 < k2; l2++)
        {
            ((XYSeriesRenderer)xymultipleseriesrenderer.getSeriesRendererAt(l2)).setFillPoints(true);
        }

        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(11);
        int j3 = calendar.get(12) + i3 * 60;
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4\uFF080-1339\u5206\u949F\uFF09");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5206\u949F\u6D3B\u52A8\u91CF");
        xymultipleseriesrenderer.setXAxisMin(j3 - 60);
        xymultipleseriesrenderer.setXAxisMax(j3 + 10);
        xymultipleseriesrenderer.setYAxisMin(-50D);
        xymultipleseriesrenderer.setYAxisMax(256D);
        xymultipleseriesrenderer.setAxesColor(0xffcccccc);
        xymultipleseriesrenderer.setLabelsColor(0xffcccccc);
        xymultipleseriesrenderer.setXLabels(10);
        xymultipleseriesrenderer.setYLabels(10);
        xymultipleseriesrenderer.setShowGrid(true);
        xymultipleseriesrenderer.setXLabelsAlign(android.graphics.Paint.Align.CENTER);
        xymultipleseriesrenderer.setYLabelsAlign(android.graphics.Paint.Align.RIGHT);
        return ChartFactory.getLineChartIntent(context, xymultipleseriesdataset, xymultipleseriesrenderer, "hi,xiaomi!");
    }

    public View executeLineChartView(Context context, DaySportData daysportdata)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        ArrayList arraylist4;
        ArrayList arraylist5;
        ArrayList arraylist6;
        int i;
        int j;
        if (daysportdata == null)
        {
            return new View(context);
        }
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        arraylist4 = new ArrayList();
        arraylist5 = new ArrayList();
        arraylist6 = daysportdata.data();
        i = arraylist6.size();
        j = 0;
_L6:
        SportData sportdata6;
        int i3;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_1078;
        }
        sportdata6 = (SportData)arraylist6.get(j);
        i3 = sportdata6.getSportMode();
        if (i3 != 127) goto _L2; else goto _L1
_L2:
        switch (i3)
        {
        case 5: // '\005'
            break MISSING_BLOCK_LABEL_320;

        case 0: // '\0'
            arraylist.add(sportdata6);
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            arraylist1.add(sportdata6);
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            arraylist2.add(sportdata6);
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            arraylist3.add(sportdata6);
            continue; /* Loop/switch isn't completed */

        case 4: // '\004'
            arraylist4.add(sportdata6);
            continue; /* Loop/switch isn't completed */
        }
        break;
_L3:
        j++;
        continue; /* Loop/switch isn't completed */
        arraylist5.add(sportdata6);
        if (true) goto _L3; else goto _L1
_L1:
        String as[] = {
            "\u9759\u6B62", "\u6162\u8D70", "\u8DD1\u6B65", "\u6CA1\u6234", "\u6D45\u7761\u7720", "\u6DF1\u7761\u7720"
        };
        XYMultipleSeriesDataset xymultipleseriesdataset = new XYMultipleSeriesDataset();
        XYSeries xyseries = new XYSeries(as[0]);
        for (int k = 0; k < arraylist.size(); k++)
        {
            SportData sportdata5 = (SportData)arraylist.get(k);
            xyseries.add(sportdata5.getTimeIndex(), sportdata5.getActivity());
        }

        XYSeries xyseries1 = new XYSeries(as[1]);
        for (int l = 0; l < arraylist1.size(); l++)
        {
            SportData sportdata4 = (SportData)arraylist1.get(l);
            xyseries1.add(sportdata4.getTimeIndex(), sportdata4.getStep());
        }

        XYSeries xyseries2 = new XYSeries(as[2]);
        for (int i1 = 0; i1 < arraylist2.size(); i1++)
        {
            SportData sportdata3 = (SportData)arraylist2.get(i1);
            xyseries2.add(sportdata3.getTimeIndex(), sportdata3.getStep());
        }

        XYSeries xyseries3 = new XYSeries(as[3]);
        for (int j1 = 0; j1 < arraylist3.size(); j1++)
        {
            SportData sportdata2 = (SportData)arraylist3.get(j1);
            xyseries3.add(sportdata2.getTimeIndex(), sportdata2.getActivity());
        }

        XYSeries xyseries4 = new XYSeries(as[4]);
        for (int k1 = 0; k1 < arraylist4.size(); k1++)
        {
            SportData sportdata1 = (SportData)arraylist4.get(k1);
            xyseries4.add(sportdata1.getTimeIndex(), sportdata1.getActivity());
        }

        XYSeries xyseries5 = new XYSeries(as[5]);
        for (int l1 = 0; l1 < arraylist5.size(); l1++)
        {
            SportData sportdata = (SportData)arraylist5.get(l1);
            xyseries5.add(sportdata.getTimeIndex(), sportdata.getActivity());
        }

        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesdataset.addSeries(xyseries1);
        xymultipleseriesdataset.addSeries(xyseries2);
        xymultipleseriesdataset.addSeries(xyseries3);
        xymultipleseriesdataset.addSeries(xyseries4);
        xymultipleseriesdataset.addSeries(xyseries5);
        int ai[] = {
            0xff00ff00, 0xff0000ff, 0xff00ffff, 0xffff0000, -256, -65281
        };
        PointStyle apointstyle[] = new PointStyle[6];
        apointstyle[0] = PointStyle.CIRCLE;
        apointstyle[1] = PointStyle.DIAMOND;
        apointstyle[2] = PointStyle.POINT;
        apointstyle[3] = PointStyle.TRIANGLE;
        apointstyle[4] = PointStyle.SQUARE;
        apointstyle[5] = PointStyle.CIRCLE;
        XYMultipleSeriesRenderer xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xymultipleseriesrenderer.setAxisTitleTextSize(16F);
        xymultipleseriesrenderer.setChartTitleTextSize(20F);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(15F);
        xymultipleseriesrenderer.setPointSize(5F);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        int i2 = ai.length;
        for (int j2 = 0; j2 < i2; j2++)
        {
            XYSeriesRenderer xyseriesrenderer = new XYSeriesRenderer();
            xyseriesrenderer.setColor(ai[j2]);
            xyseriesrenderer.setPointStyle(apointstyle[j2]);
            xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        }

        int k2 = xymultipleseriesrenderer.getSeriesRendererCount();
        for (int l2 = 0; l2 < k2; l2++)
        {
            ((XYSeriesRenderer)xymultipleseriesrenderer.getSeriesRendererAt(l2)).setFillPoints(true);
        }

        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4\uFF080-1339\u5206\u949F\uFF09");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5206\u949F\u6D3B\u52A8\u91CF");
        xymultipleseriesrenderer.setXAxisMin(j - 60);
        xymultipleseriesrenderer.setXAxisMax(j + 10);
        xymultipleseriesrenderer.setYAxisMin(-50D);
        xymultipleseriesrenderer.setYAxisMax(256D);
        xymultipleseriesrenderer.setAxesColor(0xffcccccc);
        xymultipleseriesrenderer.setLabelsColor(0xffcccccc);
        xymultipleseriesrenderer.setXLabels(10);
        xymultipleseriesrenderer.setYLabels(10);
        xymultipleseriesrenderer.setShowGrid(true);
        xymultipleseriesrenderer.setXLabelsAlign(android.graphics.Paint.Align.CENTER);
        xymultipleseriesrenderer.setYLabelsAlign(android.graphics.Paint.Align.RIGHT);
        xymultipleseriesrenderer.setBackgroundColor(0xff000000);
        return ChartFactory.getLineChartView(context, xymultipleseriesdataset, xymultipleseriesrenderer);
        j = i;
        if (true) goto _L1; else goto _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public View executeLineChartView2(Context context, DaySportData daysportdata, long l)
    {
        if (daysportdata == null)
        {
            return new View(context);
        }
        b = daysportdata.getAnalysisData();
        int i = b.size();
        if (i == 0)
        {
            return new View(context);
        }
        long _tmp = l + (long)(60000 * ((SportData)b.get(i - 1)).getTimeIndex());
        String as[] = {
            "\u6D3B\u52A8", "\u9759\u6B62", "\u6162\u8D70", "\u8DD1\u6B65", "\u6CA1\u6234", "\u6D45\u7761\u7720", "\u6DF1\u7761\u7720"
        };
        XYMultipleSeriesDataset xymultipleseriesdataset = new XYMultipleSeriesDataset();
        XYSeries xyseries = new XYSeries(as[0]);
        new XYSeries(as[1]);
        new XYSeries(as[2]);
        new XYSeries(as[3]);
        new XYSeries(as[4]);
        new XYSeries(as[5]);
        new XYSeries(as[6]);
        XYSeries xyseries1 = new XYSeries(as[1]);
        XYSeries xyseries2 = new XYSeries(as[2]);
        XYSeries xyseries3 = new XYSeries(as[3]);
        XYSeries xyseries4 = new XYSeries(as[4]);
        XYSeries xyseries5 = new XYSeries(as[5]);
        XYSeries xyseries6 = new XYSeries(as[6]);
        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesdataset.addSeries(xyseries1);
        xymultipleseriesdataset.addSeries(xyseries2);
        xymultipleseriesdataset.addSeries(xyseries3);
        xymultipleseriesdataset.addSeries(xyseries4);
        xymultipleseriesdataset.addSeries(xyseries5);
        xymultipleseriesdataset.addSeries(xyseries6);
        ArrayList arraylist = new ArrayList();
        int j = 0;
        for (int k = 1; k < b.size(); k++)
        {
            if (((SportData)b.get(k)).getSportMode() != ((SportData)b.get(k - 1)).getSportMode())
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("start", Integer.valueOf(j));
                hashmap1.put("stop", Integer.valueOf(k - 1));
                hashmap1.put("mode", Integer.valueOf(((SportData)b.get(j)).getSportMode()));
                arraylist.add(hashmap1);
                j = k;
            }
        }

        HashMap hashmap = new HashMap();
        hashmap.put("start", Integer.valueOf(j));
        hashmap.put("stop", Integer.valueOf(-1 + b.size()));
        hashmap.put("mode", Integer.valueOf(((SportData)b.get(j)).getSportMode()));
        arraylist.add(hashmap);
        int i1 = 0;
        do
        {
            if (i1 >= arraylist.size())
            {
                break;
            }
            int j2 = Integer.parseInt(((HashMap)arraylist.get(i1)).get("start").toString());
            int k2 = Integer.parseInt(((HashMap)arraylist.get(i1)).get("stop").toString());
            int l2 = Integer.parseInt(((HashMap)arraylist.get(i1)).get("mode").toString());
            int i3 = j2;
            int j3 = 0;
            for (; i3 <= k2; i3++)
            {
                j3 += ((SportData)b.get(i3)).getActivity();
            }

            int k3 = j3 / ((k2 + 1) - j2);
            if (k3 < 3)
            {
                k3 = 3;
            }
            while (j2 <= k2) 
            {
                if (l2 == 0)
                {
                    xyseries1.add(j2, k3);
                } else
                if (l2 == 1)
                {
                    xyseries2.add(j2, k3);
                } else
                if (l2 == 2)
                {
                    xyseries3.add(j2, k3);
                } else
                if (l2 == 3)
                {
                    xyseries4.add(j2, k3);
                } else
                if (l2 == 4)
                {
                    xyseries5.add(j2, 50D);
                } else
                if (l2 == 5)
                {
                    xyseries6.add(j2, 35D);
                }
                j2++;
            }
            i1++;
        } while (true);
        int ai[] = new int[7];
        ai[0] = 0xff0000ff;
        ai[1] = Color.argb(255, 171, 200, 139);
        ai[2] = Color.argb(255, 245, 143, 152);
        ai[3] = 0xffff0000;
        ai[4] = -256;
        ai[5] = Color.argb(255, 190, 215, 66);
        ai[6] = Color.argb(255, 127, 184, 14);
        PointStyle apointstyle[] = new PointStyle[13];
        apointstyle[0] = PointStyle.POINT;
        apointstyle[1] = PointStyle.SQUARE;
        apointstyle[2] = PointStyle.SQUARE;
        apointstyle[3] = PointStyle.SQUARE;
        apointstyle[4] = PointStyle.SQUARE;
        apointstyle[5] = PointStyle.SQUARE;
        apointstyle[6] = PointStyle.SQUARE;
        apointstyle[7] = PointStyle.SQUARE;
        apointstyle[8] = PointStyle.SQUARE;
        apointstyle[9] = PointStyle.SQUARE;
        apointstyle[10] = PointStyle.SQUARE;
        apointstyle[11] = PointStyle.SQUARE;
        apointstyle[12] = PointStyle.SQUARE;
        XYMultipleSeriesRenderer xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xymultipleseriesrenderer.setAxisTitleTextSize(16F);
        xymultipleseriesrenderer.setChartTitleTextSize(20F);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(15F);
        xymultipleseriesrenderer.setPointSize(5F);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        int j1 = ai.length;
        for (int k1 = 0; k1 < j1; k1++)
        {
            XYSeriesRenderer xyseriesrenderer = new XYSeriesRenderer();
            xyseriesrenderer.setColor(ai[k1]);
            xyseriesrenderer.setPointStyle(apointstyle[k1]);
            xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        }

        int l1 = xymultipleseriesrenderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < l1; i2++)
        {
            ((XYSeriesRenderer)xymultipleseriesrenderer.getSeriesRendererAt(i2)).setFillPoints(true);
        }

        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5206\u949F\u6D3B\u52A8\u91CF");
        xymultipleseriesrenderer.setXAxisMin(0.0D);
        xymultipleseriesrenderer.setXAxisMax(1440D);
        xymultipleseriesrenderer.setYAxisMin(-50D);
        xymultipleseriesrenderer.setYAxisMax(256D);
        xymultipleseriesrenderer.setAxesColor(0xffcccccc);
        xymultipleseriesrenderer.setLabelsColor(0xffcccccc);
        xymultipleseriesrenderer.setXLabels(10);
        xymultipleseriesrenderer.setYLabels(10);
        xymultipleseriesrenderer.setShowGrid(true);
        xymultipleseriesrenderer.setXLabelsAlign(android.graphics.Paint.Align.CENTER);
        xymultipleseriesrenderer.setYLabelsAlign(android.graphics.Paint.Align.RIGHT);
        xymultipleseriesrenderer.setBackgroundColor(-1);
        return ChartFactory.getBarChartView(context, xymultipleseriesdataset, xymultipleseriesrenderer, org.achartengine.chart.BarChart.Type.STACKED);
    }

    public View executeLineChartView3(Context context, DaySportData daysportdata, long l)
    {
        if (daysportdata == null)
        {
            return new View(context);
        }
        ArrayList arraylist = daysportdata.data();
        int i = arraylist.size();
        if (i == 0)
        {
            return new View(context);
        }
        long l1 = l + (long)(60000 * ((SportData)arraylist.get(i - 1)).getTimeIndex());
        Debug.i("BXL", (new StringBuilder()).append("executeLineChartView size=").append(i).toString());
        String as[] = {
            "\u6D3B\u52A8", "\u9759\u6B62", "\u6162\u8D70", "\u8DD1\u6B65", "\u6CA1\u6234", "\u6D45\u7761\u7720", "\u6DF1\u7761\u7720", "\u8D56\u5E8A"
        };
        XYMultipleSeriesDataset xymultipleseriesdataset = new XYMultipleSeriesDataset();
        XYSeries xyseries = new XYSeries(as[0]);
        XYSeries xyseries1 = new XYSeries(as[1]);
        XYSeries xyseries2 = new XYSeries(as[2]);
        XYSeries xyseries3 = new XYSeries(as[3]);
        XYSeries xyseries4 = new XYSeries(as[4]);
        XYSeries xyseries5 = new XYSeries(as[5]);
        XYSeries xyseries6 = new XYSeries(as[6]);
        XYSeries xyseries7 = new XYSeries(as[1]);
        XYSeries xyseries8 = new XYSeries(as[2]);
        XYSeries xyseries9 = new XYSeries(as[3]);
        XYSeries xyseries10 = new XYSeries(as[4]);
        XYSeries xyseries11 = new XYSeries(as[5]);
        XYSeries xyseries12 = new XYSeries(as[6]);
        XYSeries xyseries13 = new XYSeries(as[7]);
        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesdataset.addSeries(xyseries1);
        xymultipleseriesdataset.addSeries(xyseries2);
        xymultipleseriesdataset.addSeries(xyseries3);
        xymultipleseriesdataset.addSeries(xyseries4);
        xymultipleseriesdataset.addSeries(xyseries5);
        xymultipleseriesdataset.addSeries(xyseries6);
        xymultipleseriesdataset.addSeries(xyseries7);
        xymultipleseriesdataset.addSeries(xyseries8);
        xymultipleseriesdataset.addSeries(xyseries9);
        xymultipleseriesdataset.addSeries(xyseries10);
        xymultipleseriesdataset.addSeries(xyseries11);
        xymultipleseriesdataset.addSeries(xyseries12);
        xymultipleseriesdataset.addSeries(xyseries13);
        int j = 0;
        while (j < i) 
        {
            SportData sportdata1 = (SportData)arraylist.get(j);
            int k2 = sportdata1.getSportMode();
            if (k2 != 127)
            {
                long l3 = l + (long)(60000 * sportdata1.getTimeIndex());
                xyseries.add(l3, sportdata1.getActivity());
                if (k2 == 0)
                {
                    xyseries1.add(l3, -5D);
                } else
                if (k2 == 1)
                {
                    xyseries2.add(l3, -10D);
                } else
                if (k2 == 2)
                {
                    xyseries3.add(l3, -15D);
                } else
                if (k2 == 3)
                {
                    xyseries4.add(l3, -20D);
                } else
                if (k2 == 4)
                {
                    xyseries5.add(l3, -25D);
                } else
                if (k2 == 5)
                {
                    xyseries6.add(l3, -30D);
                }
            }
            j++;
        }
        b = daysportdata.getAnalysisData();
        if (b != null && b.size() == i)
        {
            int i2 = 0;
            while (i2 < i) 
            {
                SportData sportdata = (SportData)b.get(i2);
                int j2 = sportdata.getSportMode();
                if (j2 != 127)
                {
                    long l2 = l + (long)(60000 * sportdata.getTimeIndex());
                    if (j2 == 0)
                    {
                        xyseries7.add(l2, 5D);
                    } else
                    if (j2 == 1)
                    {
                        xyseries8.add(l2, 10D);
                    } else
                    if (j2 == 2)
                    {
                        xyseries9.add(l2, 15D);
                    } else
                    if (j2 == 3)
                    {
                        xyseries10.add(l2, 20D);
                    } else
                    if (j2 == 4)
                    {
                        xyseries11.add(l2, 25D);
                    } else
                    if (j2 == 5)
                    {
                        xyseries12.add(l2, 30D);
                    } else
                    if (j2 == 7)
                    {
                        xyseries13.add(l2, 35D);
                    }
                }
                i2++;
            }
        }
        int ai[] = new int[14];
        ai[0] = 0xff0000ff;
        ai[1] = 0xff00ff00;
        ai[2] = 0xff00ffff;
        ai[3] = 0xffff0000;
        ai[4] = -256;
        ai[5] = Color.argb(255, 190, 215, 66);
        ai[6] = Color.argb(255, 127, 184, 14);
        ai[7] = 0xff00ff00;
        ai[8] = 0xff00ffff;
        ai[9] = 0xffff0000;
        ai[10] = -256;
        ai[11] = Color.argb(255, 190, 215, 66);
        ai[12] = Color.argb(255, 127, 184, 14);
        ai[13] = Color.argb(255, 255, 102, 0);
        PointStyle apointstyle[] = new PointStyle[14];
        apointstyle[0] = PointStyle.POINT;
        apointstyle[1] = PointStyle.SQUARE;
        apointstyle[2] = PointStyle.SQUARE;
        apointstyle[3] = PointStyle.SQUARE;
        apointstyle[4] = PointStyle.SQUARE;
        apointstyle[5] = PointStyle.SQUARE;
        apointstyle[6] = PointStyle.SQUARE;
        apointstyle[7] = PointStyle.SQUARE;
        apointstyle[8] = PointStyle.SQUARE;
        apointstyle[9] = PointStyle.SQUARE;
        apointstyle[10] = PointStyle.SQUARE;
        apointstyle[11] = PointStyle.SQUARE;
        apointstyle[12] = PointStyle.SQUARE;
        apointstyle[13] = PointStyle.SQUARE;
        XYMultipleSeriesRenderer xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xymultipleseriesrenderer.setAxisTitleTextSize(16F);
        xymultipleseriesrenderer.setChartTitleTextSize(20F);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(15F);
        xymultipleseriesrenderer.setPointSize(5F);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        int k = ai.length;
        for (int i1 = 0; i1 < k; i1++)
        {
            XYSeriesRenderer xyseriesrenderer = new XYSeriesRenderer();
            xyseriesrenderer.setColor(ai[i1]);
            xyseriesrenderer.setPointStyle(apointstyle[i1]);
            xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        }

        int j1 = xymultipleseriesrenderer.getSeriesRendererCount();
        for (int k1 = 0; k1 < j1; k1++)
        {
            ((XYSeriesRenderer)xymultipleseriesrenderer.getSeriesRendererAt(k1)).setFillPoints(true);
        }

        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5206\u949F\u6D3B\u52A8\u91CF");
        xymultipleseriesrenderer.setXAxisMin(l1 - 0x36ee80L);
        xymultipleseriesrenderer.setXAxisMax(0x36ee80L + l1);
        xymultipleseriesrenderer.setYAxisMin(-50D);
        xymultipleseriesrenderer.setYAxisMax(256D);
        xymultipleseriesrenderer.setAxesColor(0xffcccccc);
        xymultipleseriesrenderer.setLabelsColor(0xffcccccc);
        xymultipleseriesrenderer.setXLabels(10);
        xymultipleseriesrenderer.setYLabels(10);
        xymultipleseriesrenderer.setShowGrid(true);
        xymultipleseriesrenderer.setXLabelsAlign(android.graphics.Paint.Align.CENTER);
        xymultipleseriesrenderer.setYLabelsAlign(android.graphics.Paint.Align.RIGHT);
        xymultipleseriesrenderer.setBackgroundColor(-1);
        return ChartFactory.getTimeChartView(context, xymultipleseriesdataset, xymultipleseriesrenderer, "HH:mm");
    }

    public Intent executePieChart(Context context, DaySportData daysportdata)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        ArrayList arraylist3;
        ArrayList arraylist4;
        ArrayList arraylist5;
        ArrayList arraylist6;
        int i;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        arraylist2 = new ArrayList();
        arraylist3 = new ArrayList();
        arraylist4 = new ArrayList();
        arraylist5 = new ArrayList();
        arraylist6 = daysportdata.data();
        i = 0;
_L9:
        SportData sportdata;
        int j;
label0:
        {
            if (i < arraylist6.size())
            {
                sportdata = (SportData)arraylist6.get(i);
                j = sportdata.getSportMode();
                if (j != 127)
                {
                    break label0;
                }
            }
            CategorySeries categoryseries = new CategorySeries("\u997C\u56FE");
            categoryseries.add("\u9759\u6B62", arraylist.size());
            categoryseries.add("\u6162\u8D70", arraylist1.size());
            categoryseries.add("\u8DD1\u6B65", arraylist2.size());
            categoryseries.add("\u6CA1\u6234", arraylist3.size());
            categoryseries.add("\u6D45\u7761", arraylist4.size());
            categoryseries.add("\u6DF1\u7761", arraylist5.size());
            DefaultRenderer defaultrenderer = new DefaultRenderer();
            SimpleSeriesRenderer simpleseriesrenderer = new SimpleSeriesRenderer();
            simpleseriesrenderer.setColor(0xff0000ff);
            SimpleSeriesRenderer simpleseriesrenderer1 = new SimpleSeriesRenderer();
            simpleseriesrenderer1.setColor(0xffff0000);
            SimpleSeriesRenderer simpleseriesrenderer2 = new SimpleSeriesRenderer();
            simpleseriesrenderer2.setColor(0xffcccccc);
            SimpleSeriesRenderer simpleseriesrenderer3 = new SimpleSeriesRenderer();
            simpleseriesrenderer3.setColor(-256);
            SimpleSeriesRenderer simpleseriesrenderer4 = new SimpleSeriesRenderer();
            simpleseriesrenderer4.setColor(0xff00ffff);
            SimpleSeriesRenderer simpleseriesrenderer5 = new SimpleSeriesRenderer();
            simpleseriesrenderer5.setColor(-65281);
            defaultrenderer.setChartTitle("\u6D3B\u52A8\u997C\u56FE");
            defaultrenderer.setChartTitleTextSize(20F);
            defaultrenderer.setLabelsTextSize(15F);
            defaultrenderer.setLegendTextSize(15F);
            defaultrenderer.setMargins(new int[] {
                20, 30, 15, 10
            });
            defaultrenderer.setStartAngle(0.0F);
            defaultrenderer.setAntialiasing(true);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer1);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer2);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer3);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer4);
            defaultrenderer.addSeriesRenderer(simpleseriesrenderer5);
            return ChartFactory.getPieChartIntent(context, categoryseries, defaultrenderer, "hi");
        }
        j;
        JVM INSTR tableswitch 0 5: default 460
    //                   0 466
    //                   1 476
    //                   2 487
    //                   3 498
    //                   4 509
    //                   5 520;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_520;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L10:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        arraylist.add(sportdata);
          goto _L10
_L3:
        arraylist1.add(sportdata);
          goto _L10
_L4:
        arraylist2.add(sportdata);
          goto _L10
_L5:
        arraylist3.add(sportdata);
          goto _L10
_L6:
        arraylist4.add(sportdata);
          goto _L10
        arraylist5.add(sportdata);
          goto _L10
    }

    public Intent executeStepsBarChart(Context context, StepsInfo stepsinfo)
    {
        XYMultipleSeriesDataset xymultipleseriesdataset = new XYMultipleSeriesDataset();
        ArrayList arraylist = stepsinfo.getStageSteps();
        XYSeries xyseries = new XYSeries("\u8BA1\u6B65");
        Iterator iterator = arraylist.iterator();
        int i = 20;
        while (iterator.hasNext()) 
        {
            StageSteps stagesteps = (StageSteps)iterator.next();
            xyseries.add(stagesteps.time, stagesteps.steps);
            XYMultipleSeriesRenderer xymultipleseriesrenderer;
            XYSeriesRenderer xyseriesrenderer;
            int j;
            if (stagesteps.steps > i)
            {
                j = stagesteps.steps;
            } else
            {
                j = i;
            }
            i = j;
        }
        xymultipleseriesdataset.addSeries(xyseries);
        xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xyseriesrenderer = new XYSeriesRenderer();
        xyseriesrenderer.setColor(-256);
        xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        xymultipleseriesrenderer.setLabelsTextSize(15F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setAxisTitleTextSize(20F);
        xymultipleseriesrenderer.setXTitle("\u65F6\u95F4\uFF080-23\u5C0F\u65F6\uFF09");
        xymultipleseriesrenderer.setYTitle("\u6BCF\u5C0F\u65F6\u6B65\u6570");
        xymultipleseriesrenderer.setXAxisMin(0.0D);
        xymultipleseriesrenderer.setXAxisMax(24D);
        xymultipleseriesrenderer.setYAxisMin(0.0D);
        xymultipleseriesrenderer.setYAxisMax(i + i / 20);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        xymultipleseriesrenderer.setBarSpacing(0.30000001192092896D);
        return ChartFactory.getBarChartIntent(context, xymultipleseriesdataset, xymultipleseriesrenderer, org.achartengine.chart.BarChart.Type.DEFAULT);
    }

    public Intent executeStepsBarChart(Context context, DaySportData daysportdata)
    {
        XYMultipleSeriesDataset xymultipleseriesdataset;
        ArrayList arraylist;
        CategorySeries categoryseries;
        int i;
        int j;
        int k;
        int l;
        xymultipleseriesdataset = new XYMultipleSeriesDataset();
        arraylist = daysportdata.data();
        categoryseries = new CategorySeries("\u8BA1\u6B65");
        i = 0;
        j = 20;
        k = arraylist.size();
        l = 0;
_L3:
        if (l >= 1440) goto _L2; else goto _L1
_L1:
        int i1;
        if (l >= k)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        SportData sportdata = (SportData)arraylist.get(l);
        int j1 = sportdata.getSportMode();
        if (j1 != 1 && j1 != 2)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        i1 = i + sportdata.getStep();
_L4:
        if ((l + 1) % 60 == 0)
        {
            categoryseries.add(i1);
            XYMultipleSeriesRenderer xymultipleseriesrenderer;
            XYSeriesRenderer xyseriesrenderer;
            if (i1 <= j)
            {
                i1 = j;
            }
            i = 0;
        } else
        {
            i = i1;
            i1 = j;
        }
        l++;
        j = i1;
        if (true) goto _L3; else goto _L2
_L2:
        xymultipleseriesdataset.addSeries(categoryseries.toXYSeries());
        xymultipleseriesrenderer = new XYMultipleSeriesRenderer();
        xyseriesrenderer = new XYSeriesRenderer();
        xyseriesrenderer.setColor(-256);
        xymultipleseriesrenderer.addSeriesRenderer(xyseriesrenderer);
        xymultipleseriesrenderer.setLabelsTextSize(20F);
        xymultipleseriesrenderer.setLegendTextSize(20F);
        xymultipleseriesrenderer.setXAxisMin(0.0D);
        xymultipleseriesrenderer.setXAxisMax(24D);
        xymultipleseriesrenderer.setYAxisMin(0.0D);
        xymultipleseriesrenderer.setYAxisMax(j + j / 20);
        xymultipleseriesrenderer.setMargins(new int[] {
            50, 50, 50, 50
        });
        xymultipleseriesrenderer.setAntialiasing(true);
        xymultipleseriesrenderer.setBarSpacing(0.30000001192092896D);
        return ChartFactory.getBarChartIntent(context, xymultipleseriesdataset, xymultipleseriesrenderer, org.achartengine.chart.BarChart.Type.DEFAULT);
        i1 = i;
          goto _L4
    }

}
