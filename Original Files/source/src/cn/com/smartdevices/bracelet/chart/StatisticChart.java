// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart:
//            o, q, p

public class StatisticChart extends BarChart
{

    private static final String a = "Chart.StatisticChart";
    private static final int b = 8000;
    private static final int c = 480;
    private static final float d = 2.5F;
    private static final float e = 1.5F;
    private int f;
    private int g;
    private float h;
    private int i;
    private float j;
    private float k;
    private q l;
    private p m;
    private List n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private Paint v;

    public StatisticChart(Context context)
    {
        super(context);
        mPaddingLeft = 1.83F * mDensity;
        mPaddingRight = 1.83F * mDensity;
        mXAxis = new o(this);
        mXAxis.stroke = (int)(28F * mDensity);
        mXAxis.setPadding(mPaddingLeft, 0.0F, mPaddingRight, 0.0F);
        l = new q(this, null);
        l.setItemPadding(0.83F * mDensity);
        l.setPadding(0.0F, (int)(30F * mDensity), 0.0F, 0.0F);
        setStepGoal(8000);
        m = new p(this, null);
        m.setItemPadding(0.83F * mDensity);
        m.setPadding(0.0F, (int)(100F * mDensity), 0.0F, 0.0F);
        setSleepGoal(480);
        n = new ArrayList();
        p = 0xffa1a3b6;
        q = 0xff70738f;
        r = 0xff9193a9;
        s = 0xff656886;
        t = 0xffbae0ed;
        u = 0xff5eb7d6;
        v = new Paint();
        v.setColor(0x33ffffff);
    }

    static float a(StatisticChart statisticchart)
    {
        return statisticchart.h;
    }

    private void a()
    {
        if (g > 0 && mRect != null)
        {
            h = (mRect.width() - mPaddingLeft - mPaddingRight) / (float)g;
            Debug.i("Chart.StatisticChart", (new StringBuilder()).append("Update Bar Item Width : ").append(h).toString());
            j = (int)(mRect.centerX() - h / 2.0F);
            k = (int)(mRect.centerX() + h / 2.0F);
        }
    }

    private void a(Canvas canvas)
    {
        RectF rectf = l.getRect();
        int i1 = l.getMaxItemValue();
        float f1 = rectf.bottom;
        if (i1 > 0 && cn.com.smartdevices.bracelet.chart.q.a(l) > 0.0F)
        {
            f1 -= ChartUtil.itemLevelSize(i1, f, cn.com.smartdevices.bracelet.chart.q.a(l), cn.com.smartdevices.bracelet.chart.q.b(l));
        }
        float af[] = new float[200];
        float f2 = mRect.width() / (float)50;
        float f3 = (2.0F * f2) / 3F;
        for (int j1 = 0; j1 < 50; j1++)
        {
            float f4 = mRect.left + f2 * (float)j1;
            float f5 = f4 + f3;
            af[j1 * 4] = f4;
            af[1 + j1 * 4] = f1;
            af[2 + j1 * 4] = f5;
            af[3 + j1 * 4] = f1;
        }

        canvas.drawLines(af, v);
    }

    static List b(StatisticChart statisticchart)
    {
        return statisticchart.n;
    }

    private void b(Canvas canvas)
    {
        RectF rectf = new RectF(mRect);
        rectf.left = mRect.centerX() - h / 2.0F;
        rectf.right = mRect.centerX() + h / 2.0F;
        rectf.bottom = mXAxis.getRect().top;
        new Paint();
        Path path = new Path();
        path.moveTo(rectf.left + (rectf.width() - 12F * mDensity) / 2.0F, rectf.bottom);
        path.lineTo(rectf.centerX(), rectf.bottom - 6F * mDensity);
        path.lineTo(rectf.right - (rectf.width() - 12F * mDensity) / 2.0F, rectf.bottom);
        path.close();
        Paint paint = new Paint(1);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(0xfff2f2f2);
        canvas.drawPath(path, paint);
    }

    static int c(StatisticChart statisticchart)
    {
        return statisticchart.g;
    }

    static int d(StatisticChart statisticchart)
    {
        return statisticchart.i;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis e(StatisticChart statisticchart)
    {
        return statisticchart.mXAxis;
    }

    static int f(StatisticChart statisticchart)
    {
        return statisticchart.o;
    }

    static int g(StatisticChart statisticchart)
    {
        return statisticchart.p;
    }

    static int h(StatisticChart statisticchart)
    {
        return statisticchart.q;
    }

    static int i(StatisticChart statisticchart)
    {
        return statisticchart.t;
    }

    static int j(StatisticChart statisticchart)
    {
        return statisticchart.u;
    }

    static float k(StatisticChart statisticchart)
    {
        return statisticchart.j;
    }

    static float l(StatisticChart statisticchart)
    {
        return statisticchart.k;
    }

    static int m(StatisticChart statisticchart)
    {
        return statisticchart.s;
    }

    static int n(StatisticChart statisticchart)
    {
        return statisticchart.r;
    }

    public void clearData()
    {
        offsetTo(0);
    }

    protected void doScroll(float f1)
    {
        Debug.i("Chart.StatisticChart", (new StringBuilder()).append("Scroll : ").append(f1).toString());
        if (mLoadCallback != null)
        {
            int i1 = mXAxis.offset;
            mXAxis.scrollTo(mScroll);
            int j1 = mXAxis.offset;
            boolean flag = false;
            int i2;
            if (f1 < 0.0F)
            {
                if (j1 == i1 && mScroll / h < (float)j1)
                {
                    j1++;
                }
                int k2 = j1;
                int l2 = i1;
                for (; k2 > i1; k2--)
                {
                    if (!mLoadCallback.hasData(k2))
                    {
                        Debug.w("Chart.StatisticChart", (new StringBuilder()).append("No Item Data : ").append(k2).toString());
                        flag = true;
                        l2 = k2;
                    }
                }

                i2 = l2 - 1;
            } else
            {
                if (j1 == i1 && -(mScroll / h) < (float)j1)
                {
                    j1--;
                }
                int k1 = j1;
                int l1 = i1;
                for (; k1 < i1; k1++)
                {
                    if (!mLoadCallback.hasData(k1))
                    {
                        Debug.w("Chart.StatisticChart", (new StringBuilder()).append("No Item Data : ").append(k1).toString());
                        flag = true;
                        l1 = k1;
                    }
                }

                i2 = l1 + 1;
            }
            if (flag)
            {
                mScroll = (float)(-i2) * h;
                mXAxis.scrollTo(mScroll);
                int j2 = mXAxis.offset;
                ((StatisticChartView.StatisticChartLoadCallback)mLoadCallback).onOverScrolled();
                j1 = j2;
            }
            Debug.i("Chart.StatisticChart", (new StringBuilder()).append("ScrollTo : ").append(mScroll).toString());
            if (j1 != i1)
            {
                mLoadCallback.loadData(j1);
                return;
            }
        }
    }

    public void draw(Canvas canvas, float f1, float f2, float f3, float f4, float f5)
    {
        ((o)mXAxis).a(canvas, f1, f2, f3);
        if (o != 16) goto _L2; else goto _L1
_L1:
        m.a(canvas, f1, f2, f3, f4, f5);
_L4:
        b(canvas);
        return;
_L2:
        if (o == 1)
        {
            a(canvas);
            l.a(canvas, f1, f2, f3, f4, f5);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void fillDates(List list)
    {
        synchronized (n)
        {
            n.clear();
            n.addAll(list);
        }
        return;
        exception;
        list1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void fillSleepData(List list)
    {
        m.fillItems(list);
    }

    public void fillStepData(List list)
    {
        l.fillItems(list);
    }

    public int getBarItemCount()
    {
        return g;
    }

    public float getBarItemWidth()
    {
        return h;
    }

    public int itemOffset()
    {
        return mXAxis.offset;
    }

    public int justified()
    {
        int i1;
label0:
        {
            i1 = (int)(mScroll % h);
            if ((float)Math.abs(i1) > h / 2.0F)
            {
                if (i1 <= 0)
                {
                    break label0;
                }
                i1 = (int)(-(h - (float)i1));
            }
            return i1;
        }
        return (int)(h + (float)i1);
    }

    public void notifyChanged()
    {
        l.notifyChanged();
        m.notifyChanged();
    }

    public int offsetScrolled(float f1)
    {
        float f2 = mRect.centerX() - h / 2.0F;
        float f3 = mRect.centerX() + h / 2.0F;
        int j1;
        if (f1 < f2)
        {
            j1 = -Math.round((float)(1 + (int)((f2 - f1) / h)) * h);
        } else
        {
            int i1 = f1 != f3;
            j1 = 0;
            if (i1 > 0)
            {
                return -Math.round((float)(-1 + -(int)((f1 - f3) / h)) * h);
            }
        }
        return j1;
    }

    public void offsetTo(int i1)
    {
        mScroll = (float)i1 * h;
        mXAxis.scrollTo(mScroll);
    }

    public void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        a();
        RectF rectf1 = mXAxis.getRect();
        RectF rectf2 = new RectF(rectf);
        rectf2.left = rectf.left + mPaddingLeft;
        rectf2.right = rectf.right - mPaddingRight;
        rectf2.bottom = rectf1.top;
        l.setRect(rectf2);
        RectF rectf3 = new RectF(rectf);
        rectf3.left = rectf.left + mPaddingLeft;
        rectf3.right = rectf.right - mPaddingRight;
        rectf3.bottom = rectf1.top;
        m.setRect(rectf3);
    }

    public void setMode(int i1)
    {
        o = i1;
    }

    public void setSleepGoal(int i1)
    {
        m.setMaxItemValue((int)(1.5F * (float)i1));
    }

    public void setStepGoal(int i1)
    {
        int j1 = 8000;
        if (i1 >= j1)
        {
            j1 = i1;
        }
        l.setMaxItemValue((int)(2.5F * (float)j1));
        f = i1;
    }

    public void updateBarItemCount(int i1)
    {
        g = i1;
        Debug.i("Chart.StatisticChart", (new StringBuilder()).append("Update Bar Item Count : ").append(i1).toString());
        i = (-1 + g) / 2;
        a();
    }
}
