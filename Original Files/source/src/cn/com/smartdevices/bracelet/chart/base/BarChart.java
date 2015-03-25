// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            BaseChart

public class BarChart extends BaseChart
{

    protected float mItemPadding;
    protected int mMaxItemValue;
    protected boolean mMirrored;
    protected boolean mNeedRealign;
    protected Axis mXAxis;
    protected Axis mYAxis;

    public BarChart()
    {
    }

    public BarChart(Context context)
    {
        super(context);
    }

    protected void draw(Canvas canvas, RectF rectf, float f)
    {
        List list = mItems;
        list;
        JVM INSTR monitorenter ;
        int i = mItems.size();
        int j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        ((BarItem)mItems.get(j)).draw(canvas, f, mMirrored);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        list;
        JVM INSTR monitorexit ;
        if (mXAxis != null)
        {
            mXAxis.draw(canvas, f);
        }
        if (mYAxis != null)
        {
            mYAxis.draw(canvas, f);
        }
        return;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getMaxItemValue()
    {
        return mMaxItemValue;
    }

    protected float itemHeight(RectF rectf, BarItem baritem)
    {
        if (baritem.value >= mMaxItemValue)
        {
            return rectf.height() - mPaddingTop - mPaddingBottom;
        } else
        {
            return ((float)baritem.value / (float)mMaxItemValue) * (rectf.height() - mPaddingTop - mPaddingBottom);
        }
    }

    protected float itemOffsetX(RectF rectf, BarItem baritem)
    {
        return (rectf.width() / (float)mItems.size()) * (float)mItems.indexOf(baritem);
    }

    protected float itemOffsetY(RectF rectf, BarItem baritem)
    {
        return 0.0F;
    }

    protected float itemWidth(RectF rectf, BarItem baritem)
    {
        return rectf.width() / (float)mItems.size() - 2.0F * mItemPadding;
    }

    public void notifyChanged()
    {
        synchronized (mItems)
        {
            realignItems(mRect, mItems);
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onItemsChanged(List list)
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            BarItem baritem = (BarItem)iterator.next();
            baritem.mDensity = mDensity;
            baritem.mDensityScale = mDensityScale;
        }

        mNeedRealign = true;
    }

    protected void onRectChanged(RectF rectf)
    {
        if (mXAxis != null)
        {
            RectF rectf1 = new RectF();
            rectf1.left = rectf.left;
            rectf1.top = rectf.bottom - (float)mXAxis.stroke;
            rectf1.right = rectf.right;
            rectf1.bottom = rectf.bottom;
            mXAxis.setRect(rectf1);
        }
        if (mYAxis != null)
        {
            RectF rectf2 = new RectF();
            rectf2.left = rectf.left;
            rectf2.top = rectf.top;
            rectf2.right = rectf.left + (float)mYAxis.stroke;
            rectf2.bottom = rectf.bottom;
            mYAxis.setRect(rectf2);
        }
        mNeedRealign = true;
    }

    protected void realignItems(RectF rectf, List list)
    {
        if (rectf == null || list == null || list.size() == 0)
        {
            return;
        }
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BarItem baritem = (BarItem)iterator.next();
            RectF rectf1;
            float f;
            float f1;
            if (baritem.mRect == null)
            {
                rectf1 = new RectF();
                baritem.mRect = rectf1;
            } else
            {
                rectf1 = baritem.mRect;
            }
            if (mNeedRealign || baritem.mRect == null)
            {
                f = itemWidth(rectf, baritem);
                f1 = itemHeight(rectf, baritem);
            } else
            {
                f = baritem.mRect.width();
                f1 = baritem.mRect.height();
            }
            rectf1.left = rectf.left + mItemPadding;
            rectf1.right = f + rectf1.left;
            if (!mMirrored)
            {
                rectf1.bottom = rectf.bottom - mPaddingBottom;
                rectf1.top = rectf1.bottom - f1;
            } else
            {
                rectf1.top = rectf.top + mPaddingTop;
                rectf1.bottom = f1 + rectf1.top;
            }
            rectf1.offset(itemOffsetX(rectf, baritem), itemOffsetY(rectf, baritem));
            baritem.needDraw = true;
            if (rectf1.right < rectf.left + mPaddingLeft || rectf1.left > rectf.right - mPaddingRight)
            {
                baritem.needDraw = false;
            }
        } while (true);
        mNeedRealign = false;
    }

    public void setItemPadding(float f)
    {
        mItemPadding = f;
    }

    public void setMaxItemValue(int i)
    {
        mMaxItemValue = i;
    }

    public void setNeedRealign(boolean flag)
    {
        mNeedRealign = flag;
    }

    public void sortItems()
    {
        synchronized (mItems)
        {
            Collections.sort(mItems, new BarItemComparator());
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class BarItem extends BaseChart
    {

        public int index;
        public boolean needDraw;
        public int scope;
        public int value;

        protected void draw(Canvas canvas, RectF rectf, float f)
        {
            if (!needDraw)
            {
                return;
            } else
            {
                float f1 = rectf.left + rectf.width() / 2.0F;
                float f2 = rectf.bottom;
                float f3 = rectf.left + rectf.width() / 2.0F;
                float f4 = rectf.bottom - f * rectf.height();
                mRenderer.paint.setStrokeWidth(rectf.width());
                canvas.drawLine(f1, f2, f3, f4, mRenderer.paint);
                return;
            }
        }

        protected void draw(Canvas canvas, RectF rectf, float f, boolean flag)
        {
            if (!needDraw)
            {
                return;
            }
            if (flag)
            {
                float f1 = rectf.left + rectf.width() / 2.0F;
                float f2 = rectf.top;
                float f3 = rectf.left + rectf.width() / 2.0F;
                float f4 = rectf.top + f * rectf.height();
                mRenderer.paint.setStrokeWidth(rectf.width());
                canvas.drawLine(f1, f2, f3, f4, mRenderer.paint);
                return;
            } else
            {
                draw(canvas, rectf, f);
                return;
            }
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append((new StringBuilder()).append("Value : ").append(value).toString()).append(" , ");
            stringbuilder.append((new StringBuilder()).append("Index : ").append(index).toString()).append(" , ");
            stringbuilder.append((new StringBuilder()).append("Scope : ").append(scope).toString()).append(" , ");
            stringbuilder.append((new StringBuilder()).append("NeedDrow : ").append(needDraw).toString());
            return stringbuilder.toString();
        }

        public BarItem()
        {
        }
    }


    private class Axis extends BaseChart
    {

        public int offset;
        public int stroke;
        public int value;

        public Axis()
        {
        }

        public Axis(Context context)
        {
            super(context);
        }
    }


    private class BarItemComparator
        implements Comparator
    {

        public int compare(BarItem baritem, BarItem baritem1)
        {
            return baritem.index - baritem1.index;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((BarItem)obj, (BarItem)obj1);
        }

        public BarItemComparator()
        {
        }
    }

}
