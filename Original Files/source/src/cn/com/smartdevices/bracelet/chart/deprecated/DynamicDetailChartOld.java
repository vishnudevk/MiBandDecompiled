// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyle;
import cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            b, d, e

public class DynamicDetailChartOld extends BarChart
{

    private static final String a = "Chart.DynamicDetailChart";
    private static final int b = 1500;
    private d c;
    private e d;
    private float e;
    private float f;
    private float g;
    private int h;
    private String i;
    private String j;
    private int k;
    private String l;
    private String m;
    private String n;
    private String o;
    private Paint p;
    private Paint q;
    private Paint r;

    public DynamicDetailChartOld(Context context)
    {
        super(context);
        e = 1.0F;
        f = 1.0F;
        mYAxis = new b(this);
        mYAxis.stroke = (int)(17F * mDensity);
        mYAxis.setPadding(0.0F, 0.0F, 0.0F, (int)(15F * mDensity));
        c = new d(this, null);
        c.setPadding(0.0F, 0.0F, (int)(60F * mDensity), 0.0F);
        c.setMaxItemValue(3);
        c.setItemPadding(1.0F);
        d = new e(this, null);
        d.setPadding(0.0F, 0.0F, 0.0F, 0.0F);
        d.setMaxItemValue(1500);
        d.setItemPadding(1.0F);
        p = new Paint();
        p.setColor(0x4dffffff);
        p.setStrokeWidth(1.0F);
        q = new Paint(1);
        q.setColor(0x80ffffff);
        r = new Paint(1);
        r.setColor(-1);
        android.graphics.Typeface typeface = TypefaceManager.getInstance().getTypeface(mContext, MIUITextStyle.NORMAL);
        if (typeface != null)
        {
            r.setTypeface(typeface);
        }
        r.setTextSize(13F * mDensity);
        g = 69F * mDensity;
    }

    static float a(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.g;
    }

    static float a(DynamicDetailChartOld dynamicdetailchartold, float f1)
    {
        dynamicdetailchartold.mScroll = f1;
        return f1;
    }

    private void a(Canvas canvas, float f1)
    {
        b b1 = (b)mYAxis;
        Rect rect = new Rect();
        q.setTextSize(11F * mDensity);
        if (i != null)
        {
            float f11 = mRect.left;
            float f12 = f1 * mRect.right;
            float f13 = ((float)h / 1440F) * (mRect.height() - g - b1.getPaddingBottom()) + b1.c() + p.getStrokeWidth() / 2.0F;
            canvas.drawLine(f11, f13, f12, f13, p);
            q.getTextBounds(i, 0, i.length(), rect);
            float f14 = f11 + 55F * mDensity;
            float f15 = f1 * (f13 + (float)rect.height() + 8F * mDensity);
            canvas.drawText(i, f14, f15, r);
            canvas.drawText(j, f14 + (float)rect.width() + 5F * mDensity, f15, q);
        }
        if (l != null)
        {
            float f6 = mRect.left;
            float f7 = f1 * mRect.right;
            float f8 = ((float)k / 1440F) * (mRect.height() - g - b1.getPaddingBottom()) + b1.c() + p.getStrokeWidth() / 2.0F;
            if ((int)f8 > 1)
            {
                canvas.drawLine(f6, f8, f7, f8, p);
            }
            q.getTextBounds(l, 0, l.length(), rect);
            float f9 = f6 + 55F * mDensity;
            float f10 = f1 * (f8 + (float)rect.height() + 8F * mDensity);
            canvas.drawText(l, f9, f10, r);
            canvas.drawText(m, f9 + (float)rect.width() + 5F * mDensity, f10, q);
        }
        if (n == null)
        {
            n = "";
        }
        RectF rectf = mYAxis.getRect();
        q.getTextBounds(n, 0, n.length(), rect);
        float f2 = rectf.centerX() - (float)(rect.width() / 2);
        float f3 = (rectf.bottom - g) + (float)rect.height() + 10F * mDensity + b1.c();
        canvas.drawText(n, f2, f3, q);
        q.setTextSize(18F * mDensity);
        if (o == null)
        {
            o = "";
        }
        int i1 = rect.height();
        q.getTextBounds(o, 0, o.length(), rect);
        float f4 = rectf.centerX() - (float)(rect.width() / 2);
        float f5 = (rectf.bottom - g) + (float)i1 + (float)rect.height() + 18F * mDensity + b1.c();
        canvas.drawText(o, f4, f5, q);
    }

    static int b(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.h;
    }

    static int c(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.k;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis d(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.mYAxis;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis e(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.mYAxis;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis f(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.mYAxis;
    }

    static cn.com.smartdevices.bracelet.chart.base.BarChart.Axis g(DynamicDetailChartOld dynamicdetailchartold)
    {
        return dynamicdetailchartold.mYAxis;
    }

    public void addSleepData(List list)
    {
        c.addItems(list);
    }

    public void addStepData(List list)
    {
        d.addItems(list);
    }

    public void clearSleepData()
    {
        c.clearItems();
        h = 0;
        k = 0;
        i = null;
        l = null;
    }

    public void clearStepData()
    {
        d.clearItems();
        o = null;
    }

    protected void doScroll(float f1)
    {
        Debug.w("Chart.DynamicDetailChart", (new StringBuilder()).append("Scroll :").append(f1).toString());
        if (mLoadCallback == null)
        {
            return;
        }
        b b1 = (b)mYAxis;
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
        c.draw(canvas, f1);
        d.draw(canvas, f1);
        super.draw(canvas, f1);
        a(canvas, f1);
    }

    public void fillSleepData(List list)
    {
        c.fillItems(list);
    }

    public void fillStepData(List list)
    {
        d.fillItems(list);
    }

    public float getEdgeLength()
    {
        return ((b)mYAxis).d();
    }

    public void notifyChanged()
    {
        c.notifyChanged();
        d.notifyChanged();
    }

    protected void onRectChanged(RectF rectf)
    {
        super.onRectChanged(rectf);
        RectF rectf1 = new RectF(mYAxis.getRect());
        rectf1.offset(((rectf.width() - (float)mYAxis.stroke) / (e + f)) * f, 0.0F);
        mYAxis.setRect(rectf1);
        RectF rectf2 = new RectF(rectf);
        rectf2.left = rectf1.right + 1.0F * mDensity;
        d.setRect(rectf2);
        RectF rectf3 = new RectF(rectf);
        rectf3.left = rectf1.right + 1.0F * mDensity;
        c.setRect(rectf3);
    }

    public void setOffset(int i1)
    {
        b b1 = (b)mYAxis;
        cn.com.smartdevices.bracelet.chart.deprecated.b.a(b1, i1);
        b1.offset = 0;
        b1.a();
    }

    public void setSleepRiseTime(int i1, String s, String s1)
    {
        k = i1;
        l = s;
        m = s1;
    }

    public void setSleepStartTime(int i1, String s, String s1)
    {
        h = i1;
        i = s;
        j = s1;
    }

    public void setStepTime(String s, String s1)
    {
        n = s;
        o = s1;
    }
}
