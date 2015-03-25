// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
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

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            h, DynamicDetailChartOld, f, g

public class DynamicDetailChartViewOld extends BaseChartView
{

    private static final String a = "Chart.DynamicDetailChartView";
    private Renderer b;
    private Renderer c;
    private Renderer d;
    private Renderer e;
    private Renderer f;
    private ChartScroller g;
    private int h;
    private boolean i;
    private cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener j;

    public DynamicDetailChartViewOld(Context context)
    {
        this(context, null);
    }

    public DynamicDetailChartViewOld(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicDetailChartViewOld(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        j = new h(this);
        b = new ColorRenderer(0xb34139ce);
        c = new ColorRenderer(0x4d4139ce);
        d = new ColorRenderer(0xb3ff7200);
        e = new ColorRenderer(0xb3c6ff00);
        f = new ColorRenderer(0x4dc6ff00);
        mChart = new DynamicDetailChartOld(context);
        mInterpolator = new DecelerateInterpolator();
        mDuration = 500L;
        g = new ChartScroller(getContext(), j);
    }

    static int a(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        return dynamicdetailchartviewold.h;
    }

    private void a(DynamicDetailChartData dynamicdetailchartdata)
    {
        bindStepData(dynamicdetailchartdata.stepData);
        bindSleepData(dynamicdetailchartdata.sleepData);
        ((DynamicDetailChartOld)mChart).notifyChanged();
    }

    static void a(DynamicDetailChartViewOld dynamicdetailchartviewold, DynamicDetailChartData dynamicdetailchartdata)
    {
        dynamicdetailchartviewold.a(dynamicdetailchartdata);
    }

    static boolean a(DynamicDetailChartViewOld dynamicdetailchartviewold, boolean flag)
    {
        dynamicdetailchartviewold.i = flag;
        return flag;
    }

    static boolean b(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        return dynamicdetailchartviewold.i;
    }

    static BaseChart c(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        return dynamicdetailchartviewold.mChart;
    }

    static BaseChart d(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        return dynamicdetailchartviewold.mChart;
    }

    static BaseChart e(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        return dynamicdetailchartviewold.mChart;
    }

    public void bindSleepData(List list)
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = list.iterator();
_L6:
        DynamicDetailChartSleepData dynamicdetailchartsleepdata;
        DynamicDetailChartOld.DynamicDetailBarItem dynamicdetailbaritem;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        dynamicdetailchartsleepdata = (DynamicDetailChartSleepData)iterator.next();
        dynamicdetailbaritem = new DynamicDetailChartOld.DynamicDetailBarItem();
        dynamicdetailbaritem.value = dynamicdetailchartsleepdata.mode;
        dynamicdetailbaritem.index = dynamicdetailchartsleepdata.index;
        dynamicdetailbaritem.scope = dynamicdetailchartsleepdata.length;
        dynamicdetailchartsleepdata.mode;
        JVM INSTR tableswitch 1 3: default 104
    //                   1 138
    //                   2 126
    //                   3 114;
           goto _L1 _L2 _L3 _L4
_L2:
        break MISSING_BLOCK_LABEL_138;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        arraylist.add(dynamicdetailbaritem);
        if (true) goto _L6; else goto _L5
_L5:
        dynamicdetailbaritem.setRenderer(b);
          goto _L7
_L3:
        dynamicdetailbaritem.setRenderer(c);
          goto _L7
        dynamicdetailbaritem.setRenderer(d);
          goto _L7
        ((DynamicDetailChartOld)mChart).addSleepData(arraylist);
        return;
    }

    public void bindStepData(List list)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            DynamicDetailChartStepData dynamicdetailchartstepdata = (DynamicDetailChartStepData)iterator.next();
            DynamicDetailChartOld.DynamicDetailBarItem dynamicdetailbaritem = new DynamicDetailChartOld.DynamicDetailBarItem();
            dynamicdetailbaritem.value = dynamicdetailchartstepdata.step;
            dynamicdetailbaritem.index = dynamicdetailchartstepdata.index;
            dynamicdetailbaritem.scope = 1;
            if (dynamicdetailbaritem.value >= 500)
            {
                dynamicdetailbaritem.setRenderer(e);
            } else
            {
                dynamicdetailbaritem.setRenderer(f);
            }
            arraylist.add(dynamicdetailbaritem);
        }
        ((DynamicDetailChartOld)mChart).addStepData(arraylist);
    }

    public void clearData()
    {
        i = false;
        mLoader.clearData();
        ((DynamicDetailChartOld)mChart).clearStepData();
        ((DynamicDetailChartOld)mChart).clearSleepData();
        ((DynamicDetailChartOld)mChart).notifyChanged();
    }

    public cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData loadDayActiveData(int k)
    {
        h = k;
        cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData itemdata = mLoader.getItemData(k);
        if (itemdata == null && mLoader.hasItemData(k))
        {
            mLoader.putItemData(k, new DynamicDetailChartData());
            mLoader.loadItemData(k);
        }
        if (mLoader.getItemData(k - 1) == null && mLoader.hasItemData(k - 1))
        {
            mLoader.putItemData(k - 1, new DynamicDetailChartData());
            mLoader.loadItemData(k - 1);
            return itemdata;
        } else
        {
            i = true;
            return itemdata;
        }
    }

    public void notifyChanged()
    {
        ((DynamicDetailChartOld)mChart).notifyChanged();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        if (!mScrollable)
        {
            flag = false;
        } else
        {
            flag = g.onTouchEvent(motionevent);
            Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Consumed : ").append(flag).toString());
            if (getParent() != null)
            {
                getParent().requestDisallowInterceptTouchEvent(flag);
                return flag;
            }
        }
        return flag;
    }

    public void refresh()
    {
        Debug.w("Chart.DynamicDetailChartView", "Refresh!!");
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
        Debug.e("Chart.DynamicDetailChartView", (new StringBuilder()).append("Refresh : ").append(flag).toString());
        super.refresh(flag);
    }

    public void setDataLoader(ChartDataLoader chartdataloader)
    {
        mLoader = chartdataloader;
        cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback = chartdataloader.getLoadCallback();
        mLoader.setLoadCallback(new f(this, loadcallback));
        ((DynamicDetailChartOld)mChart).setLoadCallback(new g(this, loadcallback));
    }

    public void setOffset(int k)
    {
        ((DynamicDetailChartOld)mChart).setOffset(k);
    }

    public void setSleepRiseTime(int k, String s, String s1)
    {
        ((DynamicDetailChartOld)mChart).setSleepRiseTime(k, s, s1);
    }

    public void setSleepStartTime(int k, String s, String s1)
    {
        ((DynamicDetailChartOld)mChart).setSleepStartTime(k, s, s1);
    }

    public void setStepTime(String s, String s1)
    {
        ((DynamicDetailChartOld)mChart).setStepTime(s, s1);
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

}
