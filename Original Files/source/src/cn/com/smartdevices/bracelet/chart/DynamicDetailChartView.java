// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            h, DynamicDetailChart, f, g

public class DynamicDetailChartView extends BaseChartView
{

    private static final String a = "Chart.DynamicDetailChartView";
    private Renderer b;
    private Renderer c;
    private Renderer d;
    private Renderer e;
    private Renderer f;
    private Renderer g;
    private Renderer h;
    private Renderer i;
    private Renderer j;
    private Renderer k;
    private ChartScroller l;
    private int m;
    private ArrayList n;
    private int o;
    private DynamicDetailChartLoadCallback p;
    private cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener q;

    public DynamicDetailChartView(Context context)
    {
        this(context, null);
    }

    public DynamicDetailChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicDetailChartView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        q = new h(this);
        b = new ColorRenderer(0x4dffffff);
        c = new ColorRenderer(0x80ffffff);
        d = new ColorRenderer(0x99ff9600);
        e = new ColorRenderer(0x1affffff);
        f = new ColorRenderer(0xccffffff);
        g = new ColorRenderer(0xccffffff);
        h = new ColorRenderer(-27136);
        i = new ColorRenderer(0x33ffffff);
        j = new ColorRenderer(0x4dffffff);
        k = new ColorRenderer(0xccffffff);
        mChart = new DynamicDetailChart(context);
        mInterpolator = new AccelerateDecelerateInterpolator();
        l = new ChartScroller(getContext(), q);
        n = new ArrayList();
    }

    static DynamicDetailChartLoadCallback a(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.p;
    }

    private List a(List list, int i1, int j1)
    {
        Collections.sort(list, new cn.com.smartdevices.bracelet.chart.base.BarChart.BarItemComparator());
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        Object obj = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Sleep : ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).scope).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).value).toString());
            if (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index >= i1)
            {
                if (obj != null)
                {
                    int l1 = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj)).index + ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj)).scope;
                    if (l1 == ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index && ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj)).value == ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).value)
                    {
                        DynamicDetailChart.DynamicDetailBarItem dynamicdetailbaritem2 = new DynamicDetailChart.DynamicDetailBarItem();
                        dynamicdetailbaritem2.index = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj)).index;
                        dynamicdetailbaritem2.scope = (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index + ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).scope) - ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj)).index;
                        dynamicdetailbaritem2.value = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).value;
                        dynamicdetailbaritem2.setRenderer(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).getRenderer());
                        Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Sleep Merge : ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem2)).index).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem2)).scope).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem2)).value).toString());
                        arraylist.remove(obj);
                        arraylist.add(dynamicdetailbaritem2);
                        obj1 = dynamicdetailbaritem2;
                    } else
                    {
                        if (l1 != ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index && l1 > i1 && l1 < j1)
                        {
                            DynamicDetailChart.DynamicDetailBarItem dynamicdetailbaritem1 = new DynamicDetailChart.DynamicDetailBarItem();
                            dynamicdetailbaritem1.index = l1;
                            dynamicdetailbaritem1.scope = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index - l1;
                            dynamicdetailbaritem1.value = 1;
                            dynamicdetailbaritem1.setRenderer(d);
                            Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Sleep Active : ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem1)).index).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem1)).scope).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem1)).value).toString());
                            arraylist.add(dynamicdetailbaritem1);
                        }
                        arraylist.add(obj1);
                    }
                } else
                {
                    int k1 = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index + ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).scope;
                    if (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index > i1 && k1 < j1)
                    {
                        DynamicDetailChart.DynamicDetailBarItem dynamicdetailbaritem = new DynamicDetailChart.DynamicDetailBarItem();
                        dynamicdetailbaritem.index = i1;
                        dynamicdetailbaritem.scope = ((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (obj1)).index - i1;
                        dynamicdetailbaritem.value = 1;
                        dynamicdetailbaritem.setRenderer(d);
                        Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Sleep Active : ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem)).index).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem)).scope).append(" , ").append(((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (dynamicdetailbaritem)).value).toString());
                        arraylist.add(dynamicdetailbaritem);
                    }
                    arraylist.add(obj1);
                }
                obj = obj1;
            }
        } while (true);
        return arraylist;
    }

    private void a(DynamicDetailChartData dynamicdetailchartdata, boolean flag)
    {
        if (o == 16)
        {
            bindSleepData(dynamicdetailchartdata.sleepData, flag);
        }
        if (o == 1)
        {
            bindStepData(dynamicdetailchartdata.stepData);
        }
        ((DynamicDetailChart)mChart).notifyChanged();
    }

    static void a(DynamicDetailChartView dynamicdetailchartview, DynamicDetailChartData dynamicdetailchartdata, boolean flag)
    {
        dynamicdetailchartview.a(dynamicdetailchartdata, flag);
    }

    static int b(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.o;
    }

    static ArrayList c(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.n;
    }

    static int d(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.m;
    }

    static BaseChart e(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.mChart;
    }

    static BaseChart f(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.mChart;
    }

    static BaseChart g(DynamicDetailChartView dynamicdetailchartview)
    {
        return dynamicdetailchartview.mChart;
    }

    public void bindSleepData(List list, boolean flag)
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = list.iterator();
_L7:
        DynamicDetailChartSleepData dynamicdetailchartsleepdata;
        DynamicDetailChart.DynamicDetailBarItem dynamicdetailbaritem;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        dynamicdetailchartsleepdata = (DynamicDetailChartSleepData)iterator.next();
        dynamicdetailbaritem = new DynamicDetailChart.DynamicDetailBarItem();
        dynamicdetailbaritem.index = dynamicdetailchartsleepdata.index;
        dynamicdetailbaritem.scope = dynamicdetailchartsleepdata.length;
        dynamicdetailbaritem.value = dynamicdetailchartsleepdata.mode;
        dynamicdetailchartsleepdata.mode;
        JVM INSTR tableswitch 1 4: default 112
    //                   1 146
    //                   2 134
    //                   3 122
    //                   4 158;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_158;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        arraylist.add(dynamicdetailbaritem);
        if (true) goto _L7; else goto _L6
_L6:
        dynamicdetailbaritem.setRenderer(b);
          goto _L8
_L3:
        dynamicdetailbaritem.setRenderer(c);
          goto _L8
_L2:
        dynamicdetailbaritem.setRenderer(d);
          goto _L8
        dynamicdetailbaritem.setRenderer(e);
          goto _L8
        ArrayList arraylist1 = new ArrayList();
        arraylist1.addAll(((DynamicDetailChart)mChart).getSleepChart().getItems());
        arraylist1.addAll(arraylist);
        if (!flag)
        {
            ((DynamicDetailChart)mChart).fillSleepData(arraylist1);
            return;
        } else
        {
            List list1 = a(arraylist1, ((DynamicDetailChart)mChart).getStartTimeIndex(), ((DynamicDetailChart)mChart).getEndTimeIndex());
            ((DynamicDetailChart)mChart).fillSleepData(list1);
            return;
        }
    }

    public void bindStepData(List list)
    {
        ArrayList arraylist = new ArrayList();
        DynamicDetailChart.DynamicDetailBarItem dynamicdetailbaritem;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(dynamicdetailbaritem))
        {
            DynamicDetailChartStepData dynamicdetailchartstepdata = (DynamicDetailChartStepData)iterator.next();
            dynamicdetailbaritem = new DynamicDetailChart.DynamicDetailBarItem();
            dynamicdetailbaritem.value = dynamicdetailchartstepdata.step;
            dynamicdetailbaritem.index = dynamicdetailchartstepdata.index;
            dynamicdetailbaritem.scope = 1;
            dynamicdetailbaritem.setRenderer(j);
        }

        ((DynamicDetailChart)mChart).addStepData(arraylist);
    }

    public void clearData()
    {
        n.clear();
        mLoader.clearData();
        ((DynamicDetailChart)mChart).clearStepData();
        ((DynamicDetailChart)mChart).clearSleepData();
        ((DynamicDetailChart)mChart).notifyChanged();
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadDynamicData(int i1)
    {
        return loadDynamicData(i1, null);
    }

    public transient cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadDynamicData(int i1, int ai[])
    {
        m = i1;
        cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata = mLoader.getItemData(i1);
        if (itemdata == null && mLoader.hasItemData(i1))
        {
            n.add(Integer.valueOf(i1));
        }
        if (ai != null)
        {
            int k1 = ai.length;
            for (int l1 = 0; l1 < k1; l1++)
            {
                int i2 = ai[l1];
                if (mLoader.getItemData(i2) == null && mLoader.hasItemData(i2))
                {
                    n.add(Integer.valueOf(i2));
                }
            }

        }
        int j1;
        for (Iterator iterator = n.iterator(); iterator.hasNext(); mLoader.loadItemData(j1))
        {
            j1 = ((Integer)iterator.next()).intValue();
            mLoader.putItemData(j1, new DynamicDetailChartData());
        }

        return itemdata;
    }

    public void notifyChanged()
    {
        ((DynamicDetailChart)mChart).notifyChanged();
    }

    public boolean onTouch(float f1, float f2)
    {
        Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("On Touch : ").append(f1).append(",").append(f2).toString());
        if (o != 16) goto _L2; else goto _L1
_L1:
        Iterator iterator1;
        boolean flag1;
        iterator1 = ((DynamicDetailChart)mChart).getSleepChart().getItems().iterator();
        flag1 = false;
_L17:
        cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem1;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_339;
        }
        baritem1 = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator1.next();
        baritem1.value;
        JVM INSTR tableswitch 1 4: default 124
    //                   1 267
    //                   2 255
    //                   3 243
    //                   4 279;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        RectF rectf1;
        rectf1 = baritem1.getRect();
        if (f1 < rectf1.left || f1 > rectf1.right)
        {
            continue; /* Loop/switch isn't completed */
        }
        baritem1.value;
        JVM INSTR tableswitch 1 4: default 188
    //                   1 315
    //                   2 303
    //                   3 291
    //                   4 327;
           goto _L8 _L9 _L10 _L11 _L12
_L8:
        break; /* Loop/switch isn't completed */
_L12:
        break MISSING_BLOCK_LABEL_327;
_L13:
        int k1 = baritem1.index + (int)(((f1 - rectf1.left) / rectf1.width()) * (float)baritem1.scope);
        p.onTouchItem(baritem1.index, baritem1, k1, f1, f2);
        flag1 = true;
        continue; /* Loop/switch isn't completed */
_L6:
        baritem1.setRenderer(b);
          goto _L3
_L5:
        baritem1.setRenderer(c);
          goto _L3
_L4:
        baritem1.setRenderer(d);
          goto _L3
_L7:
        baritem1.setRenderer(e);
          goto _L3
_L11:
        baritem1.setRenderer(f);
          goto _L13
_L10:
        baritem1.setRenderer(g);
          goto _L13
_L9:
        baritem1.setRenderer(h);
          goto _L13
        baritem1.setRenderer(i);
          goto _L13
        boolean flag;
        refresh();
        flag = flag1;
_L15:
        return flag;
_L2:
        int i1;
        i1 = o;
        flag = false;
        if (i1 != 1) goto _L15; else goto _L14
_L14:
        Iterator iterator = ((DynamicDetailChart)mChart).getStepChart().getItems().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            baritem.setRenderer(j);
            RectF rectf = baritem.getRect();
            if (f1 >= rectf.left && f1 <= rectf.right)
            {
                baritem.setRenderer(k);
                int j1 = 60 * baritem.index;
                p.onTouchItem(baritem.index, baritem, j1, f1, f2);
                flag = true;
            }
        } while (true);
        refresh();
        return flag;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (mScrollable) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(flag);
        }
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        switch (motionevent.getAction())
        {
        default:
            return flag;

        case 0: // '\0'
        case 2: // '\002'
            if (!onTouch(f1, f2))
            {
                p.onTouchNothing(f1, f2);
                return flag;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            onTouch(-1F, -1F);
            p.onTouchNothing(f1, f2);
            return flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void refresh()
    {
        if (animRefresh().isStarted())
        {
            return;
        } else
        {
            super.refresh();
            return;
        }
    }

    public void refresh(boolean flag)
    {
        super.refresh(flag);
    }

    public void setDataLoader(ChartDataLoader chartdataloader)
    {
        mLoader = chartdataloader;
        p = (DynamicDetailChartLoadCallback)chartdataloader.getLoadCallback();
        mLoader.setLoadCallback(new f(this));
        ((DynamicDetailChart)mChart).setLoadCallback(new g(this));
    }

    public void setMode(int i1)
    {
        o = i1;
        ((DynamicDetailChart)mChart).setMode(o);
    }

    public void setOffset(int i1)
    {
        ((DynamicDetailChart)mChart).setOffset(i1);
    }

    public void setStartEndTimeIndex(int i1, int j1)
    {
        ((DynamicDetailChart)mChart).setStartEndTimeIndex(i1, j1);
    }

    public void setStepItemSelection(int i1)
    {
        Iterator iterator = ((DynamicDetailChart)mChart).getStepChart().getItems().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem = (cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem)iterator.next();
            if (baritem.index != i1)
            {
                continue;
            }
            baritem.setRenderer(k);
            break;
        } while (true);
    }

    private class DynamicDetailChartData extends cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData
    {

        public String date;
        public String prevDate;
        public List sleepData;
        public List stepData;

        public DynamicDetailChartData()
        {
            date = "";
            prevDate = "";
            sleepData = new ArrayList();
            stepData = new ArrayList();
        }
    }


    private class DynamicDetailChartSleepData
    {

        public static final int MODE_SLEEP_ACTIVE = 1;
        public static final int MODE_SLEEP_DEEP = 3;
        public static final int MODE_SLEEP_SHALLOW = 2;
        public static final int MODE_SLEEP_USER = 4;
        public int index;
        public int length;
        public int mode;

        public DynamicDetailChartSleepData()
        {
        }
    }


    private class DynamicDetailChartStepData
    {

        public int index;
        public int step;

        public DynamicDetailChartStepData()
        {
        }
    }


    private class DynamicDetailChartLoadCallback
        implements cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
    {

        public abstract void onTouchItem(int i1, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem, int j1, float f1, float f2);

        public abstract void onTouchNothing(float f1, float f2);
    }

}
