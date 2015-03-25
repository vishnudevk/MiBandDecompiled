// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import cn.com.smartdevices.bracelet.chart.base.BaseChart;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            t, StatisticChartOld, r, s

public class StatisticChartViewOld extends BaseChartView
{

    private static final String a = "Chart.StatisticChartView";
    private Renderer b;
    private Renderer c;
    private List d;
    private List e;
    private List f;
    private boolean g;
    private cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener h;

    public StatisticChartViewOld(Context context)
    {
        this(context, null);
    }

    public StatisticChartViewOld(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StatisticChartViewOld(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        h = new t(this);
        b = new ColorRenderer(0xccc6ff00);
        c = new ColorRenderer(0xcc4139ce);
        mChart = new StatisticChartOld(context);
        ((StatisticChartOld)mChart).setContainerView(this);
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        mScroller = new ChartScroller(getContext(), h);
        g = true;
        setLayerType(1, null);
    }

    static int a(StatisticChartViewOld statisticchartviewold, int k)
    {
        int l = k + statisticchartviewold.mScrollingOffset;
        statisticchartviewold.mScrollingOffset = l;
        return l;
    }

    private void a()
    {
        ((StatisticChartOld)mChart).fillStepData(d);
        ((StatisticChartOld)mChart).fillSleepData(e);
        ((StatisticChartOld)mChart).fillDates(f);
        ((StatisticChartOld)mChart).notifyChanged();
    }

    private void a(StatisticChartData statisticchartdata)
    {
        StatisticChartOld.StatisticBarItem statisticbaritem = new StatisticChartOld.StatisticBarItem();
        statisticbaritem.value = statisticchartdata.stepValue;
        statisticbaritem.index = statisticchartdata.index;
        statisticbaritem.setRenderer(b);
        d.add(statisticbaritem);
        StatisticChartOld.StatisticBarItem statisticbaritem1 = new StatisticChartOld.StatisticBarItem();
        statisticbaritem1.value = statisticchartdata.sleepValue;
        statisticbaritem1.index = statisticchartdata.index;
        statisticbaritem1.setRenderer(c);
        e.add(statisticbaritem1);
        StatisticChartOld.DateItem dateitem = new StatisticChartOld.DateItem();
        dateitem.a = statisticchartdata.index;
        dateitem.b = statisticchartdata.date;
        f.add(dateitem);
    }

    static void a(StatisticChartViewOld statisticchartviewold)
    {
        statisticchartviewold.a();
    }

    static void a(StatisticChartViewOld statisticchartviewold, StatisticChartData statisticchartdata)
    {
        statisticchartviewold.a(statisticchartdata);
    }

    static boolean a(StatisticChartViewOld statisticchartviewold, boolean flag)
    {
        statisticchartviewold.g = flag;
        return flag;
    }

    static int b(StatisticChartViewOld statisticchartviewold, int k)
    {
        statisticchartviewold.mScrollingOffset = k;
        return k;
    }

    static boolean b(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.g;
    }

    static boolean b(StatisticChartViewOld statisticchartviewold, boolean flag)
    {
        statisticchartviewold.mIsScrollingPerformed = flag;
        return flag;
    }

    static ChartScroller c(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mScroller;
    }

    static boolean c(StatisticChartViewOld statisticchartviewold, boolean flag)
    {
        statisticchartviewold.mIsScrollingPerformed = flag;
        return flag;
    }

    static BaseChart d(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mChart;
    }

    static int e(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mScrollingOffset;
    }

    static BaseChart f(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mChart;
    }

    static ChartScroller g(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mScroller;
    }

    static BaseChart h(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mChart;
    }

    static ChartDataLoader i(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mLoader;
    }

    static boolean j(StatisticChartViewOld statisticchartviewold)
    {
        return statisticchartviewold.mIsScrollingPerformed;
    }

    public void clearData()
    {
        e.clear();
        d.clear();
        f.clear();
        ((StatisticChartOld)mChart).fillStepData(d);
        ((StatisticChartOld)mChart).fillSleepData(e);
        ((StatisticChartOld)mChart).fillDates(f);
        mLoader.clearData();
        g = true;
        ((StatisticChartOld)mChart).notifyChanged();
    }

    public void loadData(int k)
    {
        for (int l = -1; l <= 8; l++)
        {
            if (mLoader.getItemData(k - l) == null && mLoader.hasItemData(k - l))
            {
                mLoader.putItemData(k - l, new StatisticChartData());
                mLoader.loadItemData(k - l);
            }
        }

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
            mScroller.scrollX(((StatisticChartOld)mChart).offsetScroll(f1));
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setDataLoader(ChartDataLoader chartdataloader)
    {
        mLoader = chartdataloader;
        cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback = chartdataloader.getLoadCallback();
        mLoader.setLoadCallback(new r(this, loadcallback));
        ((StatisticChartOld)mChart).setLoadCallback(new s(this, loadcallback));
    }

    public void setMode(int k)
    {
    }

    public void setStepGoal(int k)
    {
        ((StatisticChartOld)mChart).setStepGoal(k);
        refresh();
    }

    private class StatisticChartData extends cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData
    {

        public String date;
        public int sleepValue;
        public int stepValue;

        public StatisticChartData()
        {
        }
    }

}
