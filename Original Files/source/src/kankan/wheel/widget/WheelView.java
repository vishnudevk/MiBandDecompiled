// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.adapters.WheelViewAdapter;

// Referenced classes of package kankan.wheel.widget:
//            WheelRecycle, d, e, WheelScroller, 
//            c, ItemsRange, OnWheelChangedListener, OnWheelClickedListener, 
//            OnWheelScrollListener

public class WheelView extends View
{

    private static final int c[] = {
        0xff111111, 0xaaaaaa, 0xaaaaaa
    };
    private static final int d = 10;
    private static final int e = 10;
    private static final int f = 5;
    private static final String g = "WheelView";
    private float A;
    private float B;
    private DataSetObserver C;
    boolean a;
    WheelScroller.ScrollingListener b;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private GradientDrawable l;
    private GradientDrawable m;
    private WheelScroller n;
    private boolean o;
    private int p;
    private LinearLayout q;
    private int r;
    private WheelViewAdapter s;
    private WheelRecycle t;
    private List u;
    private List v;
    private List w;
    private int x;
    private Paint y;
    private String z;

    public WheelView(Context context)
    {
        super(context);
        h = 0;
        i = 5;
        j = 0;
        a = false;
        t = new WheelRecycle(this);
        u = new LinkedList();
        v = new LinkedList();
        w = new LinkedList();
        x = 0x7f0200ba;
        z = "";
        A = 50F;
        B = 80F;
        b = new d(this);
        C = new e(this);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h = 0;
        i = 5;
        j = 0;
        a = false;
        t = new WheelRecycle(this);
        u = new LinkedList();
        v = new LinkedList();
        w = new LinkedList();
        x = 0x7f0200ba;
        z = "";
        A = 50F;
        B = 80F;
        b = new d(this);
        C = new e(this);
        a(context);
    }

    public WheelView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        h = 0;
        i = 5;
        j = 0;
        a = false;
        t = new WheelRecycle(this);
        u = new LinkedList();
        v = new LinkedList();
        w = new LinkedList();
        x = 0x7f0200ba;
        z = "";
        A = 50F;
        B = 80F;
        b = new d(this);
        C = new e(this);
        a(context);
    }

    private int a(int i1, int j1)
    {
        int k1;
        a();
        q.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        q.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        k1 = q.getMeasuredWidth();
        if (j1 != 0x40000000) goto _L2; else goto _L1
_L1:
        q.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1 - 20, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        return i1;
_L2:
        int l1 = Math.max(k1 + 20, getSuggestedMinimumWidth());
        if (j1 != 0x80000000 || i1 >= l1)
        {
            i1 = l1;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private int a(LinearLayout linearlayout)
    {
        if (linearlayout != null && linearlayout.getChildAt(0) != null)
        {
            j = linearlayout.getChildAt(0).getMeasuredHeight();
        }
        return Math.max(j * i - (10 * j) / 50, getSuggestedMinimumHeight());
    }

    static int a(WheelView wheelview)
    {
        return wheelview.p;
    }

    private void a()
    {
        if (k == null)
        {
            k = getContext().getResources().getDrawable(x);
        }
        if (l == null)
        {
            l = new GradientDrawable();
        }
        if (m == null)
        {
            m = new GradientDrawable();
        }
    }

    private void a(int i1)
    {
        p = i1 + p;
        int j1 = b();
        int k1 = p / j1;
        int l1 = h - k1;
        int i2 = s.getItemsCount();
        int j2 = p % j1;
        if (Math.abs(j2) <= j1 / 2)
        {
            j2 = 0;
        }
        if (a && i2 > 0)
        {
            int k2;
            int l2;
            int i3;
            int j3;
            if (j2 > 0)
            {
                int i4 = l1 - 1;
                int j4 = k1 + 1;
                j3 = i4;
                l2 = j4;
            } else
            if (j2 < 0)
            {
                int k3 = l1 + 1;
                int l3 = k1 - 1;
                j3 = k3;
                l2 = l3;
            } else
            {
                j3 = l1;
                l2 = k1;
            }
            for (; j3 < 0; j3 += i2) { }
            k2 = j3 % i2;
        } else
        if (l1 < 0)
        {
            l2 = h;
            k2 = 0;
        } else
        if (l1 >= i2)
        {
            l2 = 1 + (h - i2);
            k2 = i2 - 1;
        } else
        if (l1 > 0 && j2 > 0)
        {
            k2 = l1 - 1;
            l2 = k1 + 1;
        } else
        if (l1 < i2 - 1 && j2 < 0)
        {
            k2 = l1 + 1;
            l2 = k1 - 1;
        } else
        {
            k2 = l1;
            l2 = k1;
        }
        i3 = p;
        if (k2 != h)
        {
            setCurrentItem(k2, false);
        } else
        {
            invalidate();
        }
        p = i3 - l2 * j1;
        if (p > getHeight())
        {
            p = p % getHeight() + getHeight();
        }
    }

    private void a(Context context)
    {
        n = new WheelScroller(getContext(), b);
        y = new Paint();
        addChangingListener(new c(this));
    }

    private void a(Canvas canvas)
    {
        int i1 = (int)(1.5D * (double)b());
        l.setBounds(0, 0, getWidth(), i1);
        l.draw(canvas);
        m.setBounds(0, getHeight() - i1, getWidth(), getHeight());
        m.draw(canvas);
    }

    static void a(WheelView wheelview, int i1)
    {
        wheelview.a(i1);
    }

    private boolean a(int i1, boolean flag)
    {
        View view = c(i1);
        boolean flag1 = false;
        if (view != null)
        {
            if (flag)
            {
                q.addView(view, 0);
            } else
            {
                q.addView(view);
            }
            flag1 = true;
        }
        return flag1;
    }

    static boolean a(WheelView wheelview, boolean flag)
    {
        wheelview.o = flag;
        return flag;
    }

    private int b()
    {
        if (j != 0)
        {
            return j;
        }
        if (q != null && q.getChildAt(0) != null)
        {
            j = q.getChildAt(0).getHeight();
            return j;
        } else
        {
            return getHeight() / i;
        }
    }

    static int b(WheelView wheelview, int i1)
    {
        wheelview.p = i1;
        return i1;
    }

    static WheelScroller b(WheelView wheelview)
    {
        return wheelview.n;
    }

    private void b(int i1, int j1)
    {
        int k1 = i1 - 20;
        q.layout(0, 0, k1, j1);
    }

    private void b(Canvas canvas)
    {
        canvas.save();
        canvas.translate(10F, -((h - r) * b() + (b() - getHeight()) / 2) + p);
        q.draw(canvas);
        canvas.restore();
    }

    private boolean b(int i1)
    {
        return s != null && s.getItemsCount() > 0 && (a || i1 >= 0 && i1 < s.getItemsCount());
    }

    private View c(int i1)
    {
        if (s == null || s.getItemsCount() == 0)
        {
            return null;
        }
        int j1 = s.getItemsCount();
        if (!b(i1))
        {
            return s.getEmptyItem(t.getEmptyItem(), q);
        }
        for (; i1 < 0; i1 += j1) { }
        int k1 = i1 % j1;
        return s.getItem(k1, t.getItem(), q);
    }

    private ItemsRange c()
    {
        if (b() == 0)
        {
            return null;
        }
        int i1 = h;
        int j1;
        for (j1 = 1; j1 * b() < getHeight(); j1 += 2)
        {
            i1--;
        }

        if (p != 0)
        {
            if (p > 0)
            {
                i1--;
            }
            int k1 = j1 + 1;
            int l1 = p / b();
            i1 -= l1;
            j1 = (int)((double)k1 + Math.asin(l1));
        }
        return new ItemsRange(i1, j1);
    }

    private void c(Canvas canvas)
    {
        int i1 = getHeight() / 2;
        int j1 = (int)(1.2D * (double)(b() / 2));
        k.setBounds(0, i1 - j1, getWidth(), j1 + i1);
        canvas.drawText(z, (float)(getWidth() / 2) + B, (float)i1 - A, y);
        k.draw(canvas);
    }

    static boolean c(WheelView wheelview)
    {
        return wheelview.o;
    }

    private boolean d()
    {
        ItemsRange itemsrange;
        boolean flag;
        int i1;
        int k1;
        itemsrange = c();
        if (q != null)
        {
            int l1 = t.recycleItems(q, r, itemsrange);
            int j1;
            if (r != l1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            r = l1;
        } else
        {
            f();
            flag = true;
        }
        if (!flag)
        {
            if (r != itemsrange.getFirst() || q.getChildCount() != itemsrange.getCount())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (r <= itemsrange.getFirst() || r > itemsrange.getLast()) goto _L2; else goto _L1
_L1:
        k1 = -1 + r;
_L7:
        if (k1 >= itemsrange.getFirst() && a(k1, true)) goto _L4; else goto _L3
_L3:
        i1 = r;
        for (j1 = q.getChildCount(); j1 < itemsrange.getCount(); j1++)
        {
            if (!a(j1 + r, false) && q.getChildCount() == 0)
            {
                i1++;
            }
        }

        break; /* Loop/switch isn't completed */
_L4:
        r = k1;
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
        r = itemsrange.getFirst();
        if (true) goto _L3; else goto _L5
_L5:
        r = i1;
        return flag;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void e()
    {
        if (d())
        {
            a(getWidth(), 0x40000000);
            b(getWidth(), getHeight());
        }
    }

    private void f()
    {
        if (q == null)
        {
            q = new LinearLayout(getContext());
            q.setOrientation(1);
        }
    }

    private void g()
    {
        int i1;
        if (q != null)
        {
            t.recycleItems(q, r, new ItemsRange());
        } else
        {
            f();
        }
        i1 = i / 2;
        for (int j1 = i1 + h; j1 >= h - i1; j1--)
        {
            if (a(j1, true))
            {
                r = j1;
            }
        }

    }

    public void addChangingListener(OnWheelChangedListener onwheelchangedlistener)
    {
        u.add(onwheelchangedlistener);
    }

    public void addClickingListener(OnWheelClickedListener onwheelclickedlistener)
    {
        w.add(onwheelclickedlistener);
    }

    public void addScrollingListener(OnWheelScrollListener onwheelscrolllistener)
    {
        v.add(onwheelscrolllistener);
    }

    public int getCurrentItem()
    {
        if (s != null && s.isNeedLoop())
        {
            return h % s.getBASE_BUNDLE();
        } else
        {
            return h;
        }
    }

    public int getRealCurrentItem()
    {
        return h;
    }

    public WheelViewAdapter getViewAdapter()
    {
        return s;
    }

    public int getVisibleItems()
    {
        return i;
    }

    public void invalidateWheel(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        t.clearAll();
        if (q != null)
        {
            q.removeAllViews();
        }
        p = 0;
_L4:
        invalidate();
        return;
_L2:
        if (q != null)
        {
            t.recycleItems(q, r, new ItemsRange());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isCyclic()
    {
        return a;
    }

    protected void notifyChangingListeners(int i1, int j1)
    {
        for (Iterator iterator = u.iterator(); iterator.hasNext(); ((OnWheelChangedListener)iterator.next()).onChanged(this, i1, j1)) { }
    }

    protected void notifyClickListenersAboutClick(int i1)
    {
        for (Iterator iterator = w.iterator(); iterator.hasNext(); ((OnWheelClickedListener)iterator.next()).onItemClicked(this, i1)) { }
    }

    protected void notifyScrollingListenersAboutEnd()
    {
        for (Iterator iterator = v.iterator(); iterator.hasNext(); ((OnWheelScrollListener)iterator.next()).onScrollingFinished(this)) { }
    }

    protected void notifyScrollingListenersAboutStart()
    {
        for (Iterator iterator = v.iterator(); iterator.hasNext(); ((OnWheelScrollListener)iterator.next()).onScrollingStarted(this)) { }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (s != null && s.getItemsCount() > 0)
        {
            e();
            b(canvas);
            c(canvas);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        b(k1 - i1, l1 - j1);
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getMode(i1);
        int l1 = android.view.View.MeasureSpec.getMode(j1);
        int i2 = android.view.View.MeasureSpec.getSize(i1);
        int j2 = android.view.View.MeasureSpec.getSize(j1);
        g();
        int k2 = a(i2, k1);
        if (l1 != 0x40000000)
        {
            int l2 = a(q);
            if (l1 == 0x80000000)
            {
                j2 = Math.min(l2, j2);
            } else
            {
                j2 = l2;
            }
        }
        setMeasuredDimension(k2, j2);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled() || getViewAdapter() == null)
        {
            return true;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 44
    //                   1 73
    //                   2 53;
           goto _L1 _L2 _L3
_L1:
        return n.onTouchEvent(motionevent);
_L3:
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!o)
        {
            int i1 = (int)motionevent.getY() - getHeight() / 2;
            int j1;
            int k1;
            if (i1 > 0)
            {
                j1 = i1 + b() / 2;
            } else
            {
                j1 = i1 - b() / 2;
            }
            k1 = j1 / b();
            if (k1 != 0 && b(k1 + h))
            {
                notifyClickListenersAboutClick(k1 + h);
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void removeChangingListener(OnWheelChangedListener onwheelchangedlistener)
    {
        u.remove(onwheelchangedlistener);
    }

    public void removeClickingListener(OnWheelClickedListener onwheelclickedlistener)
    {
        w.remove(onwheelclickedlistener);
    }

    public void removeScrollingListener(OnWheelScrollListener onwheelscrolllistener)
    {
        v.remove(onwheelscrolllistener);
    }

    public void scroll(int i1, int j1)
    {
        int k1 = i1 * b() - p;
        n.scroll(k1, j1);
    }

    public WheelView setCenterDrawable(int i1)
    {
        x = i1;
        if (k == null)
        {
            k = getContext().getResources().getDrawable(x);
        }
        invalidate();
        return this;
    }

    public WheelView setCenterStyle(String s1, float f1)
    {
        return setCenterStyle(s1, 0x7f090003, 10, f1, 1.5F);
    }

    public WheelView setCenterStyle(String s1, int i1, float f1)
    {
        return setCenterStyle(s1, i1, 10, f1, 1.5F);
    }

    public WheelView setCenterStyle(String s1, int i1, int j1, float f1, float f2)
    {
        z = s1;
        B = TypedValue.applyDimension(1, f1, getResources().getDisplayMetrics());
        A = TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        float f3 = TypedValue.applyDimension(1, j1, getResources().getDisplayMetrics());
        y.setTextSize(f3);
        y.setFakeBoldText(false);
        y.setAntiAlias(true);
        y.setColor(getResources().getColor(i1));
        return this;
    }

    public WheelView setCurrentItem(int i1)
    {
        setCurrentItem(i1, false);
        return this;
    }

    public void setCurrentItem(int i1, boolean flag)
    {
        if (s != null && s.getItemsCount() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j1;
        j1 = s.getItemsCount();
        if (i1 >= 0 && i1 < j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!a) goto _L1; else goto _L3
_L3:
        for (; i1 < 0; i1 += j1) { }
        i1 %= j1;
        if (i1 == h) goto _L1; else goto _L4
_L4:
        if (!flag) goto _L6; else goto _L5
_L5:
        int l1 = i1 - h;
        if (!a) goto _L8; else goto _L7
_L7:
        int i2 = (j1 + Math.min(i1, h)) - Math.max(i1, h);
        if (i2 >= Math.abs(l1)) goto _L8; else goto _L9
_L9:
        if (l1 >= 0)
        {
            i2 = -i2;
        }
_L11:
        scroll(i2, 0);
        return;
_L6:
        p = 0;
        int k1 = h;
        h = i1;
        notifyChangingListeners(k1, h);
        invalidate();
        return;
_L8:
        i2 = l1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public WheelView setCurrentItemLooped(int i1)
    {
        return setCurrentItemLooped(i1, false);
    }

    public WheelView setCurrentItemLooped(int i1, boolean flag)
    {
        if (s.isNeedLoop())
        {
            Debug.i("WheelView", (new StringBuilder()).append("setCurrentItemLooped: ").append(i1).toString());
            i1 += s.getInitLoopBase();
            Debug.i("WheelView", (new StringBuilder()).append(", after add loopbase:").append(i1).toString());
        }
        setCurrentItem(i1, flag);
        return this;
    }

    public void setCyclic(boolean flag)
    {
        a = flag;
        invalidateWheel(false);
    }

    public void setInterpolator(Interpolator interpolator)
    {
        n.setInterpolator(interpolator);
    }

    public WheelView setViewAdapter(WheelViewAdapter wheelviewadapter)
    {
        if (s != null)
        {
            s.unregisterDataSetObserver(C);
        }
        s = wheelviewadapter;
        if (s != null)
        {
            s.registerDataSetObserver(C);
        }
        invalidateWheel(true);
        return this;
    }

    public WheelView setVisibleItems(int i1)
    {
        i = i1;
        return this;
    }

    public void stopScrolling()
    {
        n.stopScrolling();
    }

}
