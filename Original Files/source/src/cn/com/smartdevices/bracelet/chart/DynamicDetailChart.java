// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            b, d, e

public class DynamicDetailChart extends BarChart
{

    private static final String a = "Chart.DynamicDetailChart";
    private static final int b = 1500;
    private static final float c = 196.6F;
    private static final float d = 160F;
    private d e;
    private e f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public DynamicDetailChart(Context context)
    {
        super(context);
        mXAxis = new b(this, context);
        mXAxis.stroke = (int)(28F * mDensity);
        mXAxis.setPadding((int)(2.5D * (double)mDensity), 0.0F, (int)(2.5D * (double)mDensity), 0.0F);
        e = new d(this, null);
        e.setPadding((int)(8F * mDensity), (int)(130F * mDensity), (int)(8F * mDensity), 0.0F);
        e.setItemPadding(1.0F);
        f = new e(this, null);
        f.setPadding((int)(2.5D * (double)mDensity), (int)(95F * mDensity), (int)(2.5D * (double)mDensity), 0.0F);
        f.setMaxItemValue(1500);
        f.setItemPadding(0.83F * mDensity);
    }

    static float a(DynamicDetailChart dynamicdetailchart, float f1)
    {
        dynamicdetailchart.mScroll = f1;
        return f1;
    }

    static int a(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.i;
    }

    static int a(DynamicDetailChart dynamicdetailchart, int l)
    {
        dynamicdetailchart.i = l;
        return l;
    }

    static int b(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.j;
    }

    static int b(DynamicDetailChart dynamicdetailchart, int l)
    {
        dynamicdetailchart.j = l;
        return l;
    }

    static int c(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.k;
    }

    static int c(DynamicDetailChart dynamicdetailchart, int l)
    {
        dynamicdetailchart.g = l;
        return l;
    }

    static int d(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.g;
    }

    static int d(DynamicDetailChart dynamicdetailchart, int l)
    {
        dynamicdetailchart.h = l;
        return l;
    }

    static int e(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.h;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis f(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.mXAxis;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis g(DynamicDetailChart dynamicdetailchart)
    {
        return dynamicdetailchart.mXAxis;
    }

    public void addSleepData(List list)
    {
        e.addItems(list);
        e.sortItems();
    }

    public void addStepData(List list)
    {
        f.addItems(list);
    }

    public void clearSleepData()
    {
        e.clearItems();
        g = 0;
        h = 0;
        i = 0;
        j = 0;
    }

    public void clearStepData()
    {
        f.clearItems();
        g = 0;
        h = 0;
        i = 0;
        j = 0;
    }

    protected void doScroll(float f1)
    {
        Debug.w("Chart.DynamicDetailChart", (new StringBuilder()).append("Scroll :").append(f1).toString());
        if (mLoadCallback == null)
        {
            return;
        }
        b b1 = (b)mXAxis;
        if (mScroll > 0.0F)
        {
            mScroll = 0.0F;
        }
        if (mScroll < b1.d())
        {
            mScroll = b1.d();
        }
        Debug.w("Chart.DynamicDetailChart", (new StringBuilder()).append("ScrollTo : ").append(mScroll).toString());
        b1.scrollTo(mScroll);
    }

    public void draw(Canvas canvas, float f1)
    {
        e.draw(canvas, f1);
        f.draw(canvas, f1);
        super.draw(canvas, f1);
    }

    public void fillSleepData(List list)
    {
        e.fillItems(list);
    }

    public void fillStepData(List list)
    {
        f.fillItems(list);
    }

    public float getEdgeLength()
    {
        return ((b)mXAxis).d();
    }

    public int getEndTimeIndex()
    {
        return h;
    }

    public BarChart getSleepChart()
    {
        return e;
    }

    public int getStartTimeIndex()
    {
        return g;
    }

    public BarChart getStepChart()
    {
        return f;
    }

    public void justifyStartEndTimeIndex(int l)
    {
        Debug.i("Chart.DynamicDetailChart", (new StringBuilder()).append("Before, Start : ").append(g).append(" End : ").append(h).append(" , StartHour : ").append(i).append(" EndHour : ").append(j).toString());
        if (j - i < l - 1)
        {
            j = i + (l - 1);
            if (j > 23)
            {
                j = 23;
                i = j - (l - 1);
            }
            g = 60 * i;
            h = 60 * j;
        }
        Debug.i("Chart.DynamicDetailChart", (new StringBuilder()).append("After, Start : ").append(g).append(" End : ").append(h).append(" , StartHour : ").append(i).append(" EndHour : ").append(j).toString());
        ((b)mXAxis).notifyChanged();
    }

    public void notifyChanged()
    {
        e.notifyChanged();
        f.notifyChanged();
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        RectF rectf1 = mXAxis.getRect();
        RectF rectf2 = new RectF(rectf);
        rectf2.bottom = rectf1.top;
        f.setRect(rectf2);
        RectF rectf3 = new RectF(rectf);
        rectf3.bottom = rectf1.top;
        e.setRect(rectf3);
    }

    public void setMode(int l)
    {
        k = l;
    }

    public void setOffset(int l)
    {
        b b1 = (b)mXAxis;
        cn.com.smartdevices.bracelet.chart.b.a(b1, l);
        b1.offset = 0;
        b1.a();
    }

    public void setStartEndTimeIndex(int l, int i1)
    {
        Debug.i("Chart.DynamicDetailChart", (new StringBuilder()).append("Sleep Time : ").append(l).append(" , ").append(i1).toString());
        g = l;
        h = i1;
        i = g / 60;
        j = h / 60;
        if (g == h)
        {
            justifyStartEndTimeIndex(8);
        }
    }
}
