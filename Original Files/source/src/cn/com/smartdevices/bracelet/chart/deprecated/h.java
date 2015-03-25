// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailChartViewOld, DynamicDetailChartOld

class h
    implements cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener
{

    final DynamicDetailChartViewOld a;

    h(DynamicDetailChartViewOld dynamicdetailchartviewold)
    {
        a = dynamicdetailchartviewold;
        super();
    }

    public void onFinish()
    {
        Debug.i("Chart.DynamicDetailChartView", "Scroll OnFinish!!");
    }

    public void onJustify()
    {
        Debug.i("Chart.DynamicDetailChartView", "Scroll OnJustify!!");
    }

    public boolean onScrollX(int i)
    {
        return false;
    }

    public boolean onScrollY(int i)
    {
        int j = (int)((DynamicDetailChartOld)DynamicDetailChartViewOld.c(a)).getScroll();
        int k = (int)((DynamicDetailChartOld)DynamicDetailChartViewOld.d(a)).getEdgeLength();
        Debug.i("Chart.DynamicDetailChartView", (new StringBuilder()).append("Scrolled : ").append(j).append(" Edge : ").append(k).append(" Distance : ").append(i).toString());
        if (j == 0 && i > 0 || j == k && i < 0)
        {
            return false;
        } else
        {
            ((DynamicDetailChartOld)DynamicDetailChartViewOld.e(a)).scroll(i);
            a.postInvalidateOnAnimation();
            return true;
        }
    }

    public void onStart()
    {
        Debug.i("Chart.DynamicDetailChartView", "Scroll OnStart!!");
    }
}
