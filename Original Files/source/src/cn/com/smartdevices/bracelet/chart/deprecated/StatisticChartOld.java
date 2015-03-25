// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            p, q

public class StatisticChartOld extends BarChart
{

    public static final int BAR_ITEM_SIZE = 8;
    private static final String a = "Chart.StatisticChart";
    private static float b;
    private q c;
    private q d;
    private float e;
    private float f;
    private Paint g;
    private int h;
    private int i;
    private Paint j;
    private Paint k;
    private Bitmap l;
    private Bitmap m;
    private Paint n;
    private List o;
    private View p;

    public StatisticChartOld(Context context)
    {
        super(context);
        e = 3F;
        f = 2.0F;
        mPaddingRight = (int)(22F * mDensity);
        mXAxis = new p(this);
        mXAxis.stroke = (int)(14F * mDensity);
        mXAxis.setPadding(0.0F, 0.0F, mPaddingRight, 0.0F);
        h = 10000;
        i = 100;
        c = new q(this, null);
        c.setMaxItemValue((int)(1.6000000000000001D * (double)h));
        c.setItemPadding(1.0F);
        d = new q(this, null);
        d.setMaxItemValue((int)(1.2D * (double)i));
        d.setItemPadding(1.0F);
        g = new Paint();
        g.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        j = new Paint();
        j.setColor(0x80fff000);
        j.setStrokeWidth(1.0F);
        k = new Paint();
        k.setColor(0x80ffffff);
        k.setStrokeWidth(1.0F);
        n = new Paint(1);
        n.setDither(true);
        l = ((BitmapDrawable)context.getResources().getDrawable(0x7f02004a)).getBitmap();
        m = ((BitmapDrawable)context.getResources().getDrawable(0x7f020049)).getBitmap();
        o = new ArrayList();
    }

    static float a()
    {
        return b;
    }

    static List a(StatisticChartOld statisticchartold)
    {
        return statisticchartold.o;
    }

    private void a(Canvas canvas)
    {
        g.setColor(0x80c6ff00);
        RectF rectf = new RectF(c.getRect());
        rectf.right = rectf.right - b;
        canvas.drawRect(rectf, g);
        g.setColor(0x804139ce);
        RectF rectf1 = new RectF(d.getRect());
        rectf1.right = rectf1.right - b;
        canvas.drawRect(rectf1, g);
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis b(StatisticChartOld statisticchartold)
    {
        return statisticchartold.mXAxis;
    }

    private void b(Canvas canvas)
    {
        float f1 = mRect.right - 19F * mDensity;
        RectF rectf = c.getRect();
        float f2 = rectf.bottom - ((float)h / (float)c.getMaxItemValue()) * rectf.height();
        canvas.drawLine(0.0F, f2, f1, f2, j);
        ChartUtil.drawBitmapCenter(canvas, (int)f1, (int)f2, mDensityScale, false, true, l, n);
        RectF rectf1 = d.getRect();
        float f3 = rectf1.bottom - ((float)i / (float)d.getMaxItemValue()) * rectf1.height();
        canvas.drawLine(0.0F, f3, f1, f3, k);
        ChartUtil.drawBitmapCenter(canvas, (int)f1, (int)f3, mDensityScale, false, true, m, n);
    }

    protected void doScroll(float f1)
    {
        if (mLoadCallback == null)
        {
            return;
        }
        p p1 = (p)mXAxis;
        int i1 = p1.offset;
        p1.scrollTo(mScroll);
        int j1 = p1.offset;
        boolean flag = false;
        int i2;
        if (f1 < 0.0F)
        {
            int j2 = j1 + 1;
            int k2 = i1;
            for (; j2 > i1; j2--)
            {
                if (!mLoadCallback.hasData(j2))
                {
                    Debug.w("Chart.StatisticChart", (new StringBuilder()).append("No Item Data : ").append(j2).toString());
                    flag = true;
                    k2 = j2;
                }
            }

            i2 = k2 - 1;
        } else
        {
            int k1 = j1 - 1;
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
        Debug.i("Chart.StatisticChart", (new StringBuilder()).append("ScrollTo : ").append(mScroll).toString());
        if (flag)
        {
            mScroll = (float)(-i2) * b;
            p1.scrollTo(mScroll);
            ((StatisticChartViewOld.StatisticChartLoadCallback)mLoadCallback).onOverScrolled();
        }
        mLoadCallback.loadData(p1.offset);
    }

    public void draw(Canvas canvas, float f1)
    {
        d.draw(canvas, f1);
        c.draw(canvas, f1);
        a(canvas);
        b(canvas);
        super.draw(canvas, f1);
    }

    public void fillDates(List list)
    {
        synchronized (o)
        {
            o.clear();
            o.addAll(list);
        }
        return;
        exception;
        list1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void fillSleepData(List list)
    {
        d.fillItems(list);
    }

    public void fillStepData(List list)
    {
        c.fillItems(list);
    }

    public int itemOffset()
    {
        return ((p)mXAxis).offset;
    }

    public int justified()
    {
        int i1;
label0:
        {
            i1 = (int)(mScroll % b);
            if ((float)Math.abs(i1) > b / 2.0F)
            {
                if (i1 <= 0)
                {
                    break label0;
                }
                i1 = (int)(-(b - (float)i1));
            }
            return i1;
        }
        return (int)(b + (float)i1);
    }

    public void notifyChanged()
    {
        c.notifyChanged();
        d.notifyChanged();
    }

    public int offsetScroll(float f1)
    {
        return -(int)((float)(int)((mRect.right - mPaddingRight - f1) / b) * b);
    }

    public void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        b = 45F * mDensity;
        RectF rectf1 = new RectF(rectf);
        rectf1.top = rectf1.top + 3F * mDensity;
        rectf1.right = rectf.right - mPaddingRight;
        rectf1.bottom = rectf.bottom * (e / (e + f));
        c.setRect(rectf1);
        RectF rectf2 = new RectF(rectf);
        rectf2.top = rectf1.bottom + 3F * mDensity;
        rectf2.right = rectf.right - mPaddingRight;
        d.setRect(rectf2);
    }

    public void setContainerView(View view)
    {
        p = view;
    }

    public void setStepGoal(int i1)
    {
        h = i1;
        c.setMaxItemValue((int)(1.6000000000000001D * (double)h));
        notifyChanged();
    }
}
