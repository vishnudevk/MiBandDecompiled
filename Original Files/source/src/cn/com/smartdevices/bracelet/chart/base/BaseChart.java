// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            Chart, Renderer

public abstract class BaseChart
    implements Chart, Chart.Item
{

    protected Context mContext;
    protected float mDensity;
    protected float mDensityScale;
    protected List mItems;
    protected cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback mLoadCallback;
    protected float mPaddingBottom;
    protected float mPaddingLeft;
    protected float mPaddingRight;
    protected float mPaddingTop;
    protected BaseChart mParent;
    protected RectF mRect;
    protected Renderer mRenderer;
    protected float mScroll;

    public BaseChart()
    {
        mDensity = ChartUtil.getDensity();
        mDensityScale = ChartUtil.getDensityScale();
        mItems = new ArrayList();
    }

    public BaseChart(Context context)
    {
        mDensity = ChartUtil.getDensity(context);
        mDensityScale = ChartUtil.getDensityScale(context);
        mContext = context;
        mItems = new ArrayList();
    }

    public void addItem(Chart.Item item)
    {
        synchronized (mItems)
        {
            mItems.add(item);
            onItemsChanged(mItems);
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addItems(List list)
    {
        synchronized (mItems)
        {
            mItems.addAll(list);
            onItemsChanged(mItems);
        }
        return;
        exception;
        list1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearItems()
    {
        synchronized (mItems)
        {
            mItems.clear();
            onItemsChanged(mItems);
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void doScroll(float f)
    {
    }

    public void draw(Canvas canvas)
    {
        draw(canvas, 1.0F);
    }

    public void draw(Canvas canvas, float f)
    {
        draw(canvas, mRect, f);
    }

    protected void draw(Canvas canvas, float f, boolean flag)
    {
        draw(canvas, mRect, f, flag);
    }

    protected abstract void draw(Canvas canvas, RectF rectf, float f);

    protected void draw(Canvas canvas, RectF rectf, float f, boolean flag)
    {
        draw(canvas, rectf, f);
    }

    public void fillItems(List list)
    {
        synchronized (mItems)
        {
            mItems.clear();
            mItems.addAll(list);
            onItemsChanged(mItems);
        }
        return;
        exception;
        list1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Context getContext()
    {
        return mContext;
    }

    public List getItems()
    {
        return mItems;
    }

    public float getPaddingBottom()
    {
        return mPaddingBottom;
    }

    public float getPaddingLeft()
    {
        return mPaddingLeft;
    }

    public float getPaddingRight()
    {
        return mPaddingRight;
    }

    public float getPaddingTop()
    {
        return mPaddingTop;
    }

    public BaseChart getParent()
    {
        return mParent;
    }

    public RectF getRect()
    {
        return mRect;
    }

    public Renderer getRenderer()
    {
        return mRenderer;
    }

    public float getScroll()
    {
        return mScroll;
    }

    public void notifyChanged()
    {
    }

    protected void onItemsChanged(List list)
    {
    }

    protected void onRectChanged(RectF rectf)
    {
    }

    public void scroll(float f)
    {
        mScroll = f + mScroll;
        doScroll(f);
        notifyChanged();
    }

    public void scrollTo(float f)
    {
        float f1 = f - mScroll;
        mScroll = f;
        doScroll(f1);
        notifyChanged();
    }

    public void setLoadCallback(cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback loadcallback)
    {
        mLoadCallback = loadcallback;
    }

    public void setPadding(float f, float f1, float f2, float f3)
    {
        mPaddingLeft = f;
        mPaddingTop = f1;
        mPaddingRight = f2;
        mPaddingBottom = f3;
        notifyChanged();
    }

    public void setParent(BaseChart basechart)
    {
        mParent = basechart;
    }

    public void setRect(Rect rect)
    {
        mRect = new RectF(rect);
        onRectChanged(mRect);
        notifyChanged();
    }

    public void setRect(RectF rectf)
    {
        mRect = rectf;
        onRectChanged(mRect);
        notifyChanged();
    }

    public void setRenderer(Renderer renderer)
    {
        mRenderer = renderer;
    }

    public void sortItems()
    {
    }
}
