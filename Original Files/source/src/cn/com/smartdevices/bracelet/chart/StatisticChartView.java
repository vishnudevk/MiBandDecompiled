// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BaseChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            t, StatisticChart, r, s

public class StatisticChartView extends BaseChartView
{

    private static final String a = "Chart.StatisticChartView";
    private Renderer b;
    private Renderer c;
    private List d;
    private List e;
    private List f;
    private int g;
    private ArrayList h;
    private cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;
    private cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener o;

    public StatisticChartView(Context context)
    {
        this(context, null);
    }

    public StatisticChartView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StatisticChartView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        o = new t(this);
        b = new ColorRenderer(0);
        c = new ColorRenderer(0);
        mChart = new StatisticChart(context);
        mInterpolator = new AccelerateDecelerateInterpolator();
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        mScroller = new ChartScroller(getContext(), o);
        h = new ArrayList();
    }

    static cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback a(StatisticChartView statisticchartview)
    {
        return statisticchartview.i;
    }

    private void a()
    {
        ((StatisticChart)mChart).fillStepData(d);
        ((StatisticChart)mChart).fillSleepData(e);
        ((StatisticChart)mChart).fillDates(f);
        ((StatisticChart)mChart).notifyChanged();
    }

    private void a(StatisticChartData statisticchartdata)
    {
        StatisticChart.StatisticBarItem statisticbaritem = new StatisticChart.StatisticBarItem();
        statisticbaritem.value = statisticchartdata.stepValue;
        statisticbaritem.index = statisticchartdata.index;
        statisticbaritem.setRenderer(b);
        statisticbaritem.setParent(mChart);
        d.add(statisticbaritem);
        StatisticChart.StatisticBarItem statisticbaritem1 = new StatisticChart.StatisticBarItem();
        statisticbaritem1.value = statisticchartdata.sleepValue;
        statisticbaritem1.value1 = statisticchartdata.sleepDeepValue;
        statisticbaritem1.index = statisticchartdata.index;
        statisticbaritem1.setRenderer(c);
        statisticbaritem1.setParent(mChart);
        e.add(statisticbaritem1);
        StatisticChart.DateItem dateitem = new StatisticChart.DateItem();
        dateitem.a = statisticchartdata.index;
        dateitem.b = statisticchartdata.date;
        f.add(dateitem);
    }

    static void a(StatisticChartView statisticchartview, StatisticChartData statisticchartdata)
    {
        statisticchartview.a(statisticchartdata);
    }

    private boolean a(int i1)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) ((StatisticChart.StatisticBarItem)iterator.next())).index == i1)
            {
                return true;
            }
        }

        return false;
    }

    static boolean a(StatisticChartView statisticchartview, int i1)
    {
        return statisticchartview.a(i1);
    }

    static boolean a(StatisticChartView statisticchartview, boolean flag)
    {
        statisticchartview.j = flag;
        return flag;
    }

    static int b(StatisticChartView statisticchartview, int i1)
    {
        int j1 = i1 + statisticchartview.mScrollingOffset;
        statisticchartview.mScrollingOffset = j1;
        return j1;
    }

    static ChartDataLoader b(StatisticChartView statisticchartview)
    {
        return statisticchartview.mLoader;
    }

    static boolean b(StatisticChartView statisticchartview, boolean flag)
    {
        statisticchartview.mIsScrollingPerformed = flag;
        return flag;
    }

    static int c(StatisticChartView statisticchartview, int i1)
    {
        statisticchartview.mScrollingOffset = i1;
        return i1;
    }

    static void c(StatisticChartView statisticchartview)
    {
        statisticchartview.a();
    }

    static boolean c(StatisticChartView statisticchartview, boolean flag)
    {
        statisticchartview.mIsScrollingPerformed = flag;
        return flag;
    }

    static ArrayList d(StatisticChartView statisticchartview)
    {
        return statisticchartview.h;
    }

    static boolean e(StatisticChartView statisticchartview)
    {
        return statisticchartview.j;
    }

    static int f(StatisticChartView statisticchartview)
    {
        return statisticchartview.g;
    }

    static ChartScroller g(StatisticChartView statisticchartview)
    {
        return statisticchartview.mScroller;
    }

    static BaseChart h(StatisticChartView statisticchartview)
    {
        return statisticchartview.mChart;
    }

    static int i(StatisticChartView statisticchartview)
    {
        return statisticchartview.mScrollingOffset;
    }

    static BaseChart j(StatisticChartView statisticchartview)
    {
        return statisticchartview.mChart;
    }

    static ChartScroller k(StatisticChartView statisticchartview)
    {
        return statisticchartview.mScroller;
    }

    static BaseChart l(StatisticChartView statisticchartview)
    {
        return statisticchartview.mChart;
    }

    static ChartDataLoader m(StatisticChartView statisticchartview)
    {
        return statisticchartview.mLoader;
    }

    static boolean n(StatisticChartView statisticchartview)
    {
        return statisticchartview.mIsScrollingPerformed;
    }

    public Animator animRefresh()
    {
        k = -1F;
        l = -1F;
        m = -1F;
        n = -1F;
        return super.animRefresh();
    }

    public Animator animRefresh(long l1, float f1, float f2)
    {
        k = f1;
        l = -1F;
        m = f2;
        n = -1F;
        return animRefresh(l1);
    }

    public Animator animRefreshTo(long l1, float f1, float f2)
    {
        k = -1F;
        l = f1;
        m = -1F;
        n = f2;
        return animRefresh(l1);
    }

    public void clearData()
    {
        e.clear();
        d.clear();
        f.clear();
        ((StatisticChart)mChart).fillStepData(d);
        ((StatisticChart)mChart).fillSleepData(e);
        ((StatisticChart)mChart).fillDates(f);
        h.clear();
        ((StatisticChart)mChart).clearData();
        ((StatisticChart)mChart).notifyChanged();
    }

    public cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem getBarItem(int i1, int j1)
    {
        List list;
        Iterator iterator;
        if (i1 == 16)
        {
            list = e;
        } else
        if (i1 == 1)
        {
            list = d;
        } else
        {
            list = null;
        }
        for (iterator = list.iterator(); iterator.hasNext();)
        {
            StatisticChart.StatisticBarItem statisticbaritem = (StatisticChart.StatisticBarItem)iterator.next();
            if (((cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem) (statisticbaritem)).index == j1)
            {
                return statisticbaritem;
            }
        }

        return null;
    }

    public float getBarItemWidth()
    {
        return ((StatisticChart)mChart).getBarItemWidth();
    }

    public void loadStatisticData(int i1)
    {
        g = i1;
        j = true;
        int j1 = -1 + (1 + ((StatisticChart)mChart).getBarItemCount()) / 2;
        for (int k1 = -1; k1 <= ((StatisticChart)mChart).getBarItemCount(); k1++)
        {
            int i2 = j1 + (i1 - k1);
            Debug.i("Chart.StatisticChartView", (new StringBuilder()).append("Offset : ").append(i2).toString());
            if (!h.contains(Integer.valueOf(i2)) && i.hasData(i2))
            {
                h.add(Integer.valueOf(i2));
            }
        }

        if (h.size() > 0)
        {
            int l1;
            for (Iterator iterator = h.iterator(); iterator.hasNext(); mLoader.loadItemData(l1))
            {
                l1 = ((Integer)iterator.next()).intValue();
            }

        }
    }

    public void offsetTo(int i1)
    {
        ((StatisticChart)mChart).offsetTo(-i1);
    }

    protected void onDraw(Canvas canvas)
    {
        ((StatisticChart)mChart).draw(canvas, mAnimFactor, k, l, m, n);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!mScrollable)
        {
            return false;
        }
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        motionevent.getAction();
        JVM INSTR tableswitch 1 1: default 48
    //                   1 57;
           goto _L1 _L2
_L1:
        return mScroller.onTouchEvent(motionevent);
_L2:
        if (!mIsScrollingPerformed)
        {
            float f1 = motionevent.getX();
            mScroller.scrollX(((StatisticChart)mChart).offsetScrolled(f1));
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void refresh()
    {
        k = -1F;
        l = -1F;
        m = -1F;
        n = -1F;
        super.refresh();
    }

    public void setDataLoader(ChartDataLoader chartdataloader)
    {
        i = chartdataloader.getLoadCallback();
        mLoader = chartdataloader;
        mLoader.setLoadCallback(new r(this));
        ((StatisticChart)mChart).setLoadCallback(new s(this));
    }

    public void setMode(int i1)
    {
        ((StatisticChart)mChart).setMode(i1);
    }

    public void setStepGoal(int i1)
    {
        ((StatisticChart)mChart).setStepGoal(i1);
    }

    public void updateBarItemCount(int i1)
    {
        ((StatisticChart)mChart).updateBarItemCount(i1);
    }

    private class StatisticChartData extends cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData
    {

        public String date;
        public int sleepDeepValue;
        public int sleepValue;
        public int stepValue;

        public StatisticChartData()
        {
        }
    }

}
