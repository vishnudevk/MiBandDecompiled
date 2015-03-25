// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            C, D, F, E, 
//            H, G

public class VerticalViewPager extends ViewGroup
{

    private static final int J = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String a = "VerticalViewPager";
    private static final boolean b = false;
    private static final boolean c = false;
    private static final int d = 1;
    private static final int e = 600;
    private static final int f = 25;
    private static final int g[] = {
        0x10100b3
    };
    private static final Comparator h = new C();
    private static final Interpolator i = new D();
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private float F;
    private float G;
    private float H;
    private int I;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private long P;
    private EdgeEffectCompat Q;
    private EdgeEffectCompat R;
    private boolean S;
    private boolean T;
    private int U;
    private OnPageChangeListener V;
    private OnPageChangeListener W;
    private G Z;
    private int aa;
    private final ArrayList j;
    private PagerAdapter k;
    private int l;
    private int m;
    private Parcelable n;
    private ClassLoader o;
    private Scroller p;
    private H q;
    private int r;
    private Drawable s;
    private int t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    public VerticalViewPager(Context context)
    {
        super(context);
        j = new ArrayList();
        m = -1;
        n = null;
        o = null;
        B = 1;
        I = -1;
        S = true;
        aa = 0;
        a();
    }

    public VerticalViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        j = new ArrayList();
        m = -1;
        n = null;
        o = null;
        B = 1;
        I = -1;
        S = true;
        aa = 0;
        a();
    }

    private int a(int i1, float f1, int j1, int k1)
    {
        if (Math.abs(k1) > N && Math.abs(j1) > L)
        {
            if (j1 > 0)
            {
                return i1;
            } else
            {
                return i1 + 1;
            }
        } else
        {
            return (int)(0.5F + (f1 + (float)i1));
        }
    }

    private void a(int i1)
    {
        if (aa != i1)
        {
            aa = i1;
            if (V != null)
            {
                V.onPageScrollStateChanged(i1);
                return;
            }
        }
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        int i2 = i1 + k1;
        if (j1 > 0)
        {
            int k2 = getScrollY();
            int l2 = j1 + l1;
            int i3 = k2 / l2;
            int j3 = (int)(((float)(k2 % l2) / (float)l2 + (float)i3) * (float)i2);
            scrollTo(getScrollX(), j3);
            if (!p.isFinished())
            {
                int k3 = p.getDuration() - p.timePassed();
                p.startScroll(0, j3, i2 * l, 0, k3);
            }
        } else
        {
            int j2 = i2 * l;
            if (j2 != getScrollY())
            {
                h();
                scrollTo(getScrollX(), j2);
                return;
            }
        }
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i1) == I)
        {
            int j1;
            if (i1 == 0)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            G = MotionEventCompat.getY(motionevent, j1);
            I = MotionEventCompat.getPointerId(motionevent, j1);
            if (K != null)
            {
                K.clear();
            }
        }
    }

    private void a(boolean flag)
    {
        if (y != flag)
        {
            y = flag;
        }
    }

    private void b(int i1)
    {
        int j1 = getHeight() + r;
        int k1 = i1 / j1;
        int l1 = i1 % j1;
        float f1 = (float)l1 / (float)j1;
        T = false;
        onPageScrolled(k1, f1, l1);
        if (!T)
        {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else
        {
            return;
        }
    }

    static int[] f()
    {
        return g;
    }

    private void g()
    {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            if (!((LayoutParams)getChildAt(i1).getLayoutParams()).isDecor)
            {
                removeViewAt(i1);
                i1--;
            }
        }

    }

    private void h()
    {
        boolean flag = A;
        if (flag)
        {
            a(false);
            p.abortAnimation();
            int j1 = getScrollX();
            int k1 = getScrollY();
            int l1 = p.getCurrX();
            int i2 = p.getCurrY();
            if (j1 != l1 || k1 != i2)
            {
                scrollTo(l1, i2);
            }
            a(0);
        }
        z = false;
        A = false;
        int i1 = 0;
        boolean flag1 = flag;
        for (; i1 < j.size(); i1++)
        {
            F f1 = (F)j.get(i1);
            if (f1.c)
            {
                flag1 = true;
                f1.c = false;
            }
        }

        if (flag1)
        {
            c();
        }
    }

    private void i()
    {
        C = false;
        D = false;
        if (K != null)
        {
            K.recycle();
            K = null;
        }
    }

    float a(float f1)
    {
        return (float)Math.sin((float)(0.4712389167638204D * (double)(f1 - 0.5F)));
    }

    F a(View view)
    {
        for (int i1 = 0; i1 < j.size(); i1++)
        {
            F f1 = (F)j.get(i1);
            if (k.isViewFromObject(view, f1.a))
            {
                return f1;
            }
        }

        return null;
    }

    OnPageChangeListener a(OnPageChangeListener onpagechangelistener)
    {
        OnPageChangeListener onpagechangelistener1 = W;
        W = onpagechangelistener;
        return onpagechangelistener1;
    }

    void a()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        p = new Scroller(context, i);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        E = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
        L = viewconfiguration.getScaledMinimumFlingVelocity();
        M = viewconfiguration.getScaledMaximumFlingVelocity();
        Q = new EdgeEffectCompat(context);
        R = new EdgeEffectCompat(context);
        N = (int)(25F * context.getResources().getDisplayMetrics().density);
    }

    void a(int i1, int j1)
    {
        a(i1, j1, 0);
    }

    void a(int i1, int j1, int k1)
    {
        if (getChildCount() == 0)
        {
            a(false);
            return;
        }
        int l1 = getScrollX();
        int i2 = getScrollY();
        int j2 = i1 - l1;
        int k2 = j1 - i2;
        if (j2 == 0 && k2 == 0)
        {
            h();
            a(0);
            return;
        }
        a(true);
        A = true;
        a(2);
        int l2 = getHeight();
        int i3 = l2 / 2;
        float f1 = Math.min(1.0F, (1.0F * (float)Math.abs(k2)) / (float)l2);
        float f2 = (float)i3 + (float)i3 * a(f1);
        int j3 = Math.abs(k1);
        int k3;
        int l3;
        if (j3 > 0)
        {
            k3 = 4 * Math.round(1000F * Math.abs(f2 / (float)j3));
        } else
        {
            k3 = (int)(100F * (1.0F + (float)Math.abs(k2) / (float)(l2 + r)));
        }
        l3 = Math.min(k3, 600);
        p.startScroll(l1, i2, j2, k2, l3);
        invalidate();
    }

    void a(int i1, boolean flag, boolean flag1)
    {
        a(i1, flag, flag1, 0);
    }

    void a(int i1, boolean flag, boolean flag1, int j1)
    {
        if (k != null && k.getCount() > 0) goto _L2; else goto _L1
_L1:
        a(false);
_L8:
        return;
_L2:
        if (!flag1 && l == i1 && j.size() != 0)
        {
            a(false);
            return;
        }
        if (i1 >= 0) goto _L4; else goto _L3
_L3:
        i1 = 0;
_L6:
        int k1 = B;
        if (i1 > k1 + l || i1 < l - k1)
        {
            for (int l1 = 0; l1 < j.size(); l1++)
            {
                ((F)j.get(l1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L4:
        if (i1 >= k.getCount())
        {
            i1 = -1 + k.getCount();
        }
        if (true) goto _L6; else goto _L5
_L5:
        boolean flag2;
        int i2;
        if (l != i1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        l = i1;
        c();
        i2 = i1 * (getHeight() + r);
        if (flag)
        {
            a(0, i2, j1);
            if (flag2 && V != null)
            {
                V.onPageSelected(i1);
            }
            if (flag2 && W != null)
            {
                W.onPageSelected(i1);
                return;
            }
        } else
        {
            if (flag2 && V != null)
            {
                V.onPageSelected(i1);
            }
            if (flag2 && W != null)
            {
                W.onPageSelected(i1);
            }
            h();
            scrollTo(0, i2);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    void a(G g1)
    {
        Z = g1;
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        int k1 = arraylist.size();
        int l1 = getDescendantFocusability();
        if (l1 != 0x60000)
        {
            for (int i2 = 0; i2 < getChildCount(); i2++)
            {
                View view = getChildAt(i2);
                if (view.getVisibility() == 0)
                {
                    F f1 = a(view);
                    if (f1 != null && f1.b == l)
                    {
                        view.addFocusables(arraylist, i1, j1);
                    }
                }
            }

        }
        while (l1 == 0x40000 && k1 != arraylist.size() || !isFocusable() || (j1 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode() || arraylist == null) 
        {
            return;
        }
        arraylist.add(this);
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i1 = 0; i1 < getChildCount(); i1++)
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            F f1 = a(view);
            if (f1 != null && f1.b == l)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewGroup.LayoutParams layoutparams1;
        LayoutParams layoutparams2;
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams1 = generateLayoutParams(layoutparams);
        } else
        {
            layoutparams1 = layoutparams;
        }
        layoutparams2 = (LayoutParams)layoutparams1;
        layoutparams2.isDecor = layoutparams2.isDecor | (view instanceof E);
        if (x)
        {
            if (layoutparams2 != null && layoutparams2.isDecor)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                addViewInLayout(view, i1, layoutparams1);
                view.measure(v, w);
                return;
            }
        } else
        {
            super.addView(view, i1, layoutparams1);
            return;
        }
    }

    public boolean arrowScroll(int i1)
    {
        View view;
        View view1;
        view = findFocus();
        if (view == this)
        {
            view = null;
        }
        view1 = FocusFinder.getInstance().findNextFocus(this, view, i1);
        if (view1 == null || view1 == view) goto _L2; else goto _L1
_L1:
        if (i1 != 33) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (view != null && view1.getTop() >= view.getTop())
        {
            flag = d();
        } else
        {
            flag = view1.requestFocus();
        }
_L7:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i1));
        }
        return flag;
_L4:
        if (i1 == 130)
        {
            if (view != null && view1.getTop() <= view.getTop())
            {
                flag = e();
            } else
            {
                flag = view1.requestFocus();
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (i1 == 33 || i1 == 1)
        {
            flag = d();
            continue; /* Loop/switch isn't completed */
        }
        if (i1 == 130 || i1 == 2)
        {
            flag = e();
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    F b(View view)
    {
        do
        {
            android.view.ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return a(view);
            }
        } while (true);
    }

    void b()
    {
        boolean flag = true;
        boolean flag1;
        int i1;
        boolean flag2;
        int j1;
        boolean flag3;
        if (j.size() < 3 && j.size() < k.getCount())
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        i1 = 0;
        flag2 = false;
        j1 = -1;
        flag3 = flag1;
        while (i1 < j.size()) 
        {
            F f1 = (F)j.get(i1);
            int k1 = k.getItemPosition(f1.a);
            int l1;
            boolean flag4;
            int i2;
            boolean flag5;
            int j2;
            if (k1 == -1)
            {
                l1 = i1;
                flag4 = flag2;
                i2 = j1;
                flag5 = flag3;
            } else
            if (k1 == -2)
            {
                j.remove(i1);
                int k2 = i1 - 1;
                if (!flag2)
                {
                    k.startUpdate(this);
                    flag2 = flag;
                }
                k.destroyItem(this, f1.b, f1.a);
                if (l == f1.b)
                {
                    int l2 = Math.max(0, Math.min(l, -1 + k.getCount()));
                    l1 = k2;
                    flag4 = flag2;
                    i2 = l2;
                    flag5 = flag;
                } else
                {
                    l1 = k2;
                    flag4 = flag2;
                    i2 = j1;
                    flag5 = flag;
                }
            } else
            if (f1.b != k1)
            {
                if (f1.b == l)
                {
                    j1 = k1;
                }
                f1.b = k1;
                l1 = i1;
                flag4 = flag2;
                i2 = j1;
                flag5 = flag;
            } else
            {
                l1 = i1;
                flag4 = flag2;
                i2 = j1;
                flag5 = flag3;
            }
            j2 = l1 + 1;
            flag3 = flag5;
            j1 = i2;
            flag2 = flag4;
            i1 = j2;
        }
        if (flag2)
        {
            k.finishUpdate(this);
        }
        Collections.sort(j, h);
        if (j1 >= 0)
        {
            a(j1, false, flag);
        } else
        {
            flag = flag3;
        }
        if (flag)
        {
            c();
            requestLayout();
        }
    }

    void b(int i1, int j1)
    {
        F f1 = new F();
        f1.b = i1;
        f1.a = k.instantiateItem(this, i1);
        if (j1 < 0)
        {
            j.add(f1);
            return;
        } else
        {
            j.add(j1, f1);
            return;
        }
    }

    public boolean beginFakeDrag()
    {
        if (C)
        {
            return false;
        }
        O = true;
        a(1);
        G = 0.0F;
        H = 0.0F;
        long l1;
        MotionEvent motionevent;
        if (K == null)
        {
            K = VelocityTracker.obtain();
        } else
        {
            K.clear();
        }
        l1 = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
        K.addMovement(motionevent);
        motionevent.recycle();
        P = l1;
        return true;
    }

    void c()
    {
_L2:
        return;
        if (k == null || z || getWindowToken() == null) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        int l1;
        int i2;
        k.startUpdate(this);
        int i1 = B;
        j1 = Math.max(0, l - i1);
        k1 = Math.min(-1 + k.getCount(), i1 + l);
        l1 = 0;
        i2 = -1;
_L7:
        if (l1 >= j.size()) goto _L4; else goto _L3
_L3:
        F f4 = (F)j.get(l1);
        if (f4.b >= j1 && f4.b <= k1 || f4.c) goto _L6; else goto _L5
_L5:
        int i4;
        j.remove(l1);
        int i5 = l1 - 1;
        k.destroyItem(this, f4.b, f4.a);
        i4 = i5;
_L16:
        int j4 = f4.b;
        int k4 = i4 + 1;
        i2 = j4;
        l1 = k4;
          goto _L7
_L6:
        if (i2 < k1 && f4.b > j1)
        {
            int l4 = i2 + 1;
            if (l4 < j1)
            {
                l4 = j1;
            }
            while (l4 <= k1 && l4 < f4.b) 
            {
                b(l4, l1);
                l4++;
                l1++;
            }
        }
        break MISSING_BLOCK_LABEL_559;
_L4:
        int k2;
        int j2;
        if (j.size() > 0)
        {
            j2 = ((F)j.get(-1 + j.size())).b;
        } else
        {
            j2 = -1;
        }
        if (j2 < k1)
        {
            int l3 = j2 + 1;
            if (l3 <= j1)
            {
                l3 = j1;
            }
            for (; l3 <= k1; l3++)
            {
                b(l3, -1);
            }

        }
        k2 = 0;
_L14:
        if (k2 >= j.size())
        {
            break MISSING_BLOCK_LABEL_553;
        }
        if (((F)j.get(k2)).b != l) goto _L9; else goto _L8
_L8:
        F f1 = (F)j.get(k2);
_L15:
        PagerAdapter pageradapter = k;
        int l2 = l;
        Object obj;
        View view;
        F f2;
        int i3;
        View view1;
        F f3;
        int j3;
        int k3;
        if (f1 != null)
        {
            obj = f1.a;
        } else
        {
            obj = null;
        }
        pageradapter.setPrimaryItem(this, l2, obj);
        k.finishUpdate(this);
        if (!hasFocus()) goto _L2; else goto _L10
_L10:
        view = findFocus();
        f2 = null;
        if (view != null)
        {
            f2 = b(view);
        }
        i3 = 0;
        if (f2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j3 = f2.b;
        k3 = l;
        i3 = 0;
        if (j3 == k3) goto _L2; else goto _L11
_L11:
        if (i3 >= getChildCount()) goto _L2; else goto _L12
_L12:
        view1 = getChildAt(i3);
        f3 = a(view1);
        if (f3 != null && f3.b == l && view1.requestFocus(2)) goto _L2; else goto _L13
_L13:
        i3++;
          goto _L11
_L9:
        k2++;
          goto _L14
        f1 = null;
          goto _L15
        i4 = l1;
          goto _L16
    }

    protected boolean canScroll(View view, boolean flag, int i1, int j1, int k1)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int l1;
        int i2;
        int j2;
        viewgroup = (ViewGroup)view;
        l1 = view.getScrollX();
        i2 = view.getScrollY();
        j2 = -1 + viewgroup.getChildCount();
_L8:
        if (j2 < 0) goto _L2; else goto _L3
_L3:
        View view1 = viewgroup.getChildAt(j2);
        if (j1 + l1 < view1.getLeft() || j1 + l1 >= view1.getRight() || k1 + i2 < view1.getTop() || k1 + i2 >= view1.getBottom() || !canScroll(view1, true, i1, (j1 + l1) - view1.getLeft(), (k1 + i2) - view1.getTop())) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        j2--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && ViewCompat.canScrollVertically(view, -i1)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!p.isFinished() && p.computeScrollOffset())
        {
            int i1 = getScrollX();
            int j1 = getScrollY();
            int k1 = p.getCurrX();
            int l1 = p.getCurrY();
            if (i1 != k1 || j1 != l1)
            {
                scrollTo(k1, l1);
                b(l1);
            }
            invalidate();
            return;
        } else
        {
            h();
            return;
        }
    }

    boolean d()
    {
        if (l > 0)
        {
            setCurrentItem(-1 + l, true);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        int i1 = getChildCount();
        int j1 = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (j1 < i1)
                {
                    View view = getChildAt(j1);
                    if (view.getVisibility() != 0)
                    {
                        break label0;
                    }
                    F f1 = a(view);
                    if (f1 == null || f1.b != l || !view.dispatchPopulateAccessibilityEvent(accessibilityevent))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j1++;
        } while (true);
    }

    public void draw(Canvas canvas)
    {
        int i1 = 1;
        super.draw(canvas);
        int j1 = ViewCompat.getOverScrollMode(this);
        boolean flag1;
        if (j1 == 0 || j1 == i1 && k != null && k.getCount() > i1)
        {
            boolean flag = Q.isFinished();
            flag1 = false;
            if (!flag)
            {
                int j2 = canvas.save();
                int k2 = getWidth() - getPaddingLeft() - getPaddingRight();
                canvas.rotate(0.0F);
                Q.setSize(k2, getHeight());
                flag1 = false | Q.draw(canvas);
                canvas.restoreToCount(j2);
            }
            if (!R.isFinished())
            {
                int k1 = canvas.save();
                int l1 = getWidth() - getPaddingLeft() - getPaddingRight();
                int i2 = getHeight();
                if (k != null)
                {
                    i1 = k.getCount();
                }
                canvas.rotate(180F);
                canvas.translate(-l1 + getPaddingLeft(), -i1 * (i2 + r) + r);
                R.setSize(l1, i2);
                flag1 |= R.draw(canvas);
                canvas.restoreToCount(k1);
            }
        } else
        {
            Q.finish();
            R.finish();
            flag1 = false;
        }
        if (flag1)
        {
            invalidate();
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = s;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    boolean e()
    {
        if (k != null && l < -1 + k.getCount())
        {
            setCurrentItem(1 + l, true);
            return true;
        } else
        {
            return false;
        }
    }

    public void endFakeDrag()
    {
        if (!O)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else
        {
            VelocityTracker velocitytracker = K;
            velocitytracker.computeCurrentVelocity(1000, M);
            int i1 = (int)VelocityTrackerCompat.getXVelocity(velocitytracker, I);
            z = true;
            int j1 = (int)(G - H);
            int k1 = getScrollY();
            int l1 = getHeight() + r;
            a(a(k1 / l1, (float)(k1 % l1) / (float)l1, i1, j1), true, true, i1);
            i();
            O = false;
            return;
        }
    }

    public boolean executeKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 44
    //                   19: 46
    //                   20: 53
    //                   61: 61;
           goto _L2 _L3 _L4 _L5
_L2:
        return false;
_L3:
        return arrowScroll(33);
_L4:
        return arrowScroll(130);
_L5:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (KeyEventCompat.hasNoModifiers(keyevent))
            {
                return arrowScroll(2);
            }
            if (KeyEventCompat.hasModifiers(keyevent, 1))
            {
                return arrowScroll(1);
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void fakeDragBy(float f1)
    {
        if (!O)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        G = f1 + G;
        float f2 = (float)getScrollY() - f1;
        int i1 = getHeight() + r;
        float f3 = Math.max(0, i1 * (-1 + l));
        float f4 = i1 * Math.min(1 + l, -1 + k.getCount());
        long l1;
        MotionEvent motionevent;
        if (f2 >= f3)
        {
            if (f2 > f4)
            {
                f3 = f4;
            } else
            {
                f3 = f2;
            }
        }
        G = G + (f3 - (float)(int)f3);
        scrollTo(getScrollX(), (int)f3);
        b((int)f3);
        l1 = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(P, l1, 2, 0.0F, G, 0);
        K.addMovement(motionevent);
        motionevent.recycle();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter()
    {
        return k;
    }

    public int getCurrentItem()
    {
        return l;
    }

    public int getOffscreenPageLimit()
    {
        return B;
    }

    public int getPageMargin()
    {
        return r;
    }

    public boolean isFakeDragging()
    {
        return O;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        S = true;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (r > 0 && s != null)
        {
            int i1 = getScrollY();
            int j1 = getHeight();
            int k1 = i1 % (j1 + r);
            if (k1 != 0)
            {
                int l1 = j1 + (i1 - k1);
                s.setBounds(t, l1, u, l1 + r);
                s.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1 = 0xff & motionevent.getAction();
        if (i1 != 3 && i1 != 1) goto _L2; else goto _L1
_L1:
        C = false;
        D = false;
        I = -1;
        if (K != null)
        {
            K.recycle();
            K = null;
        }
_L4:
        return false;
_L2:
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (C)
        {
            return true;
        }
        if (D) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 3: default 112
    //                   0: 310
    //                   2: 146
    //                   6: 385;
           goto _L5 _L6 _L7 _L8
_L5:
        if (!C)
        {
            if (K == null)
            {
                K = VelocityTracker.obtain();
            }
            K.addMovement(motionevent);
        }
        return C;
_L7:
        int j1 = I;
        if (j1 != -1)
        {
            int k1 = MotionEventCompat.findPointerIndex(motionevent, j1);
            float f2 = MotionEventCompat.getX(motionevent, k1);
            float f3 = Math.abs(f2 - F);
            float f4 = MotionEventCompat.getY(motionevent, k1);
            float f5 = f4 - G;
            float f6 = Math.abs(f5);
            if (canScroll(this, false, (int)f5, (int)f2, (int)f4))
            {
                G = f4;
                H = f4;
                F = f2;
                return false;
            }
            if (f6 > (float)E && f6 > f3)
            {
                C = true;
                a(1);
                G = f4;
                a(true);
            } else
            if (f3 > (float)E)
            {
                D = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        F = motionevent.getX();
        float f1 = motionevent.getY();
        H = f1;
        G = f1;
        I = MotionEventCompat.getPointerId(motionevent, 0);
        if (aa == 2)
        {
            C = true;
            D = false;
            a(1);
        } else
        {
            h();
            C = false;
            D = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        if (true) goto _L5; else goto _L9
_L9:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        x = true;
        c();
        x = false;
        i2 = getChildCount();
        j2 = k1 - i1;
        k2 = l1 - j1;
        l2 = getPaddingLeft();
        i3 = getPaddingTop();
        j3 = getPaddingRight();
        k3 = getPaddingBottom();
        l3 = getScrollY();
        i4 = 0;
        j4 = 0;
_L19:
        if (j4 >= i2) goto _L2; else goto _L1
_L1:
        View view = getChildAt(j4);
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.isDecor) goto _L6; else goto _L5
_L5:
        int l5;
        int i6;
        l5 = 7 & layoutparams.gravity;
        i6 = 0x70 & layoutparams.gravity;
        l5;
        JVM INSTR tableswitch 1 5: default 168
    //                   1 321
    //                   2 168
    //                   3 300
    //                   4 168
    //                   5 341;
           goto _L7 _L8 _L7 _L9 _L7 _L10
_L7:
        int k6 = l2;
_L15:
        i6;
        JVM INSTR lookupswitch 3: default 208
    //                   16: 400
    //                   48: 371
    //                   80: 432;
           goto _L11 _L12 _L13 _L14
_L11:
        int l6;
        int j7;
        int k7;
        l6 = i3;
        int l8 = k3;
        j7 = i3;
        k7 = l8;
_L16:
        int k4;
        int l4;
        int i5;
        int j5;
        int l7 = l6 + l3;
        k4 = i4 + 1;
        view.layout(k6, l7, k6 + view.getMeasuredWidth(), l7 + view.getMeasuredHeight());
        l4 = j7;
        k3 = k7;
        i5 = j3;
        j5 = l2;
_L17:
        j4++;
        l2 = j5;
        j3 = i5;
        i3 = l4;
        i4 = k4;
        continue; /* Loop/switch isn't completed */
_L9:
        int i9 = l2 + view.getMeasuredWidth();
        k6 = l2;
        l2 = i9;
          goto _L15
_L8:
        k6 = Math.max((j2 - view.getMeasuredWidth()) / 2, l2);
          goto _L15
_L10:
        int j6 = j2 - j3 - view.getMeasuredWidth();
        j3 += view.getMeasuredWidth();
        k6 = j6;
          goto _L15
_L13:
        int j8 = i3 + view.getMeasuredHeight();
        int k8 = i3;
        k7 = k3;
        j7 = j8;
        l6 = k8;
          goto _L16
_L12:
        l6 = Math.max((k2 - view.getMeasuredHeight()) / 2, i3);
        int i8 = k3;
        j7 = i3;
        k7 = i8;
          goto _L16
_L14:
        l6 = k2 - k3 - view.getMeasuredHeight();
        int i7 = k3 + view.getMeasuredHeight();
        j7 = i3;
        k7 = i7;
          goto _L16
_L6:
        F f1 = a(view);
        if (f1 != null)
        {
            int k5 = i3 + (k2 + r) * f1.b;
            view.layout(l2, k5, l2 + view.getMeasuredWidth(), k5 + view.getMeasuredHeight());
        }
_L4:
        k4 = i4;
        l4 = i3;
        i5 = j3;
        j5 = l2;
          goto _L17
_L2:
        t = l2;
        u = j2 - j3;
        U = i4;
        S = false;
        return;
        if (true) goto _L19; else goto _L18
_L18:
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        setMeasuredDimension(getDefaultSize(0, i1), getDefaultSize(0, j1));
        k1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        l1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        i2 = getChildCount();
        j2 = 0;
_L2:
        int i3;
        int j3;
        if (j2 >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = getChildAt(j2);
        if (view1.getVisibility() == 8)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
        if (layoutparams1 == null || !layoutparams1.isDecor)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        int k3 = 7 & layoutparams1.gravity;
        int l3 = 0x70 & layoutparams1.gravity;
        Debug.i("VerticalViewPager", (new StringBuilder()).append("gravity: ").append(layoutparams1.gravity).append(" hgrav: ").append(k3).append(" vgrav: ").append(l3).toString());
        int i4 = 0x80000000;
        int j4 = 0x80000000;
        boolean flag;
        boolean flag1;
        if (l3 == 48 || l3 == 80)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k3 == 3 || k3 == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            i4 = 0x40000000;
        } else
        if (flag1)
        {
            j4 = 0x40000000;
        }
        view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, i4), android.view.View.MeasureSpec.makeMeasureSpec(l1, j4));
        if (flag)
        {
            i3 = l1 - view1.getMeasuredHeight();
            j3 = k1;
        } else
        {
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_434;
            }
            j3 = k1 - view1.getMeasuredWidth();
            i3 = l1;
        }
_L3:
        j2++;
        k1 = j3;
        l1 = i3;
        if (true) goto _L2; else goto _L1
_L1:
        v = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000);
        w = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000);
        x = true;
        c();
        x = false;
        int k2 = getChildCount();
        for (int l2 = 0; l2 < k2; l2++)
        {
            View view = getChildAt(l2);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams == null || !layoutparams.isDecor)
            {
                view.measure(v, w);
            }
        }

        return;
        i3 = l1;
        j3 = k1;
          goto _L3
    }

    protected void onPageScrolled(int i1, float f1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (U <= 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        k1 = getScrollY();
        l1 = getPaddingTop();
        i2 = getPaddingBottom();
        j2 = getHeight();
        k2 = getChildCount();
        l2 = 0;
_L2:
        View view;
        LayoutParams layoutparams;
        int k3;
        int l3;
        if (l2 >= k2)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        view = getChildAt(l2);
        layoutparams = (LayoutParams)view.getLayoutParams();
        if (layoutparams.isDecor)
        {
            break; /* Loop/switch isn't completed */
        }
        int k5 = i2;
        k3 = l1;
        l3 = k5;
_L7:
        l2++;
        int j4 = l3;
        l1 = k3;
        i2 = j4;
        if (true) goto _L2; else goto _L1
_L1:
        0x70 & layoutparams.gravity;
        JVM INSTR lookupswitch 3: default 144
    //                   1: 217
    //                   48: 188
    //                   80: 249;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_249;
_L3:
        int i3;
        i3 = l1;
        int j5 = i2;
        k3 = l1;
        l3 = j5;
_L8:
        int i4 = (i3 + k1) - view.getTop();
        if (i4 != 0)
        {
            view.offsetTopAndBottom(i4);
        }
          goto _L7
_L5:
        int l4 = l1 + view.getHeight();
        int i5 = l1;
        l3 = i2;
        k3 = l4;
        i3 = i5;
          goto _L8
_L4:
        i3 = Math.max((j2 - view.getMeasuredHeight()) / 2, l1);
        int k4 = i2;
        k3 = l1;
        l3 = k4;
          goto _L8
        i3 = j2 - i2 - view.getMeasuredHeight();
        int j3 = i2 + view.getMeasuredHeight();
        k3 = l1;
        l3 = j3;
          goto _L8
        if (V != null)
        {
            V.onPageScrolled(i1, f1, j1);
        }
        if (W != null)
        {
            W.onPageScrolled(i1, f1, j1);
        }
        T = true;
        return;
          goto _L7
    }

    protected boolean onRequestFocusInDescendants(int i1, Rect rect)
    {
        byte byte0 = -1;
        int j1 = getChildCount();
        int k1;
        if ((i1 & 2) != 0)
        {
            byte0 = 1;
            k1 = 0;
        } else
        {
            k1 = j1 - 1;
            j1 = byte0;
        }
        for (; k1 != j1; k1 += byte0)
        {
            View view = getChildAt(k1);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            F f1 = a(view);
            if (f1 != null && f1.b == l && view.requestFocus(i1, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (k != null)
        {
            k.restoreState(savedstate.b, savedstate.c);
            a(savedstate.a, false, true);
            return;
        } else
        {
            m = savedstate.a;
            n = savedstate.b;
            o = savedstate.c;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = l;
        if (k != null)
        {
            savedstate.b = k.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (j1 != l1)
        {
            a(j1, l1, r, r);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!O) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int i4;
        if (motionevent.getAction() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i4 = motionevent.getEdgeFlags();
        flag = false;
        if (i4 != 0) goto _L4; else goto _L3
_L3:
        PagerAdapter pageradapter;
        pageradapter = k;
        flag = false;
        if (pageradapter == null) goto _L4; else goto _L5
_L5:
        int i1;
        i1 = k.getCount();
        flag = false;
        if (i1 == 0) goto _L4; else goto _L6
_L6:
        int j1;
        boolean flag1;
        if (K == null)
        {
            K = VelocityTracker.obtain();
        }
        K.addMovement(motionevent);
        j1 = 0xff & motionevent.getAction();
        flag1 = false;
        j1;
        JVM INSTR tableswitch 0 6: default 136
    //                   0 147
    //                   1 540
    //                   2 184
    //                   3 683
    //                   4 136
    //                   5 736
    //                   6 768;
           goto _L7 _L8 _L9 _L10 _L11 _L7 _L12 _L13
_L7:
        if (flag1)
        {
            invalidate();
        }
        return true;
_L8:
        h();
        float f12 = motionevent.getY();
        H = f12;
        G = f12;
        I = MotionEventCompat.getPointerId(motionevent, 0);
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L10:
        if (!C)
        {
            int l3 = MotionEventCompat.findPointerIndex(motionevent, I);
            float f9 = Math.abs(MotionEventCompat.getX(motionevent, l3) - F);
            float f10 = MotionEventCompat.getY(motionevent, l3);
            float f11 = Math.abs(f10 - G);
            if (f11 > (float)E && f11 > f9)
            {
                C = true;
                G = f10;
                a(1);
                a(true);
            }
        }
        boolean flag4 = C;
        flag1 = false;
        if (flag4)
        {
            float f1 = MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, I));
            float f2 = G - f1;
            G = f1;
            float f3 = f2 + (float)getScrollY();
            int k2 = getHeight();
            int l2 = k2 + r;
            int i3 = -1 + k.getCount();
            float f4 = Math.max(0, l2 * (-1 + l));
            float f5 = l2 * Math.min(1 + l, i3);
            int k1;
            boolean flag2;
            boolean flag3;
            VelocityTracker velocitytracker;
            int l1;
            int i2;
            int j2;
            float f6;
            boolean flag5;
            if (f3 < f4)
            {
                int k3 = f4 != 0.0F;
                boolean flag7 = false;
                if (k3 == 0)
                {
                    float f8 = -f3;
                    flag7 = Q.onPull(f8 / (float)k2);
                }
                flag5 = flag7;
                f6 = f4;
            } else
            if (f3 > f5)
            {
                int j3 = f5 != (float)(i3 * l2);
                boolean flag6 = false;
                if (j3 == 0)
                {
                    float f7 = f3 - f5;
                    flag6 = R.onPull(f7 / (float)k2);
                }
                flag5 = flag6;
                f6 = f5;
            } else
            {
                f6 = f3;
                flag5 = false;
            }
            G = G + (f6 - (float)(int)f6);
            scrollTo(getScrollX(), (int)f6);
            b((int)f6);
            flag1 = flag5;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        flag3 = C;
        flag1 = false;
        if (flag3)
        {
            velocitytracker = K;
            velocitytracker.computeCurrentVelocity(1000, M);
            l1 = (int)VelocityTrackerCompat.getYVelocity(velocitytracker, I);
            z = true;
            i2 = getHeight() + r;
            j2 = getScrollY();
            a(a(j2 / i2, (float)(j2 % i2) / (float)i2, l1, (int)(MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, I)) - H)), true, true, l1);
            I = -1;
            i();
            flag1 = Q.onRelease() | R.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L11:
        flag2 = C;
        flag1 = false;
        if (flag2)
        {
            a(l, true, true);
            I = -1;
            i();
            flag1 = Q.onRelease() | R.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L12:
        k1 = MotionEventCompat.getActionIndex(motionevent);
        G = MotionEventCompat.getY(motionevent, k1);
        I = MotionEventCompat.getPointerId(motionevent, k1);
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L13:
        a(motionevent);
        G = MotionEventCompat.getY(motionevent, MotionEventCompat.findPointerIndex(motionevent, I));
        flag1 = false;
        if (true) goto _L7; else goto _L14
_L14:
    }

    public void setAdapter(PagerAdapter pageradapter)
    {
        if (k != null)
        {
            k.unregisterDataSetObserver(q);
            k.startUpdate(this);
            for (int i1 = 0; i1 < j.size(); i1++)
            {
                F f1 = (F)j.get(i1);
                k.destroyItem(this, f1.b, f1.a);
            }

            k.finishUpdate(this);
            j.clear();
            g();
            l = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pageradapter1 = k;
        k = pageradapter;
        if (k != null)
        {
            if (q == null)
            {
                q = new H(this, null);
            }
            k.registerDataSetObserver(q);
            z = false;
            if (m >= 0)
            {
                k.restoreState(n, o);
                a(m, false, true);
                m = -1;
                n = null;
                o = null;
            } else
            {
                c();
            }
        }
        if (Z != null && pageradapter1 != pageradapter)
        {
            Z.a(pageradapter1, pageradapter);
        }
    }

    public void setCurrentItem(int i1)
    {
        z = false;
        boolean flag;
        if (!S)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(i1, flag, false);
    }

    public void setCurrentItem(int i1, boolean flag)
    {
        z = false;
        a(i1, flag, false);
    }

    public void setOffscreenPageLimit(int i1)
    {
        if (i1 < 1)
        {
            Debug.w("VerticalViewPager", (new StringBuilder()).append("Requested offscreen page limit ").append(i1).append(" too small; defaulting to ").append(1).toString());
            i1 = 1;
        }
        if (i1 != B)
        {
            B = i1;
            c();
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        V = onpagechangelistener;
    }

    public void setPageMargin(int i1)
    {
        int j1 = r;
        r = i1;
        int k1 = getHeight();
        a(k1, k1, i1, j1);
        requestLayout();
    }

    public void setPageMarginDrawable(int i1)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i1));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        s = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == s;
    }


    private class OnPageChangeListener
    {

        public abstract void onPageScrollStateChanged(int i1);

        public abstract void onPageScrolled(int i1, float f1, int j1);

        public abstract void onPageSelected(int i1);
    }


    private class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public int gravity;
        public boolean isDecor;

        public LayoutParams()
        {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, VerticalViewPager.f());
            gravity = typedarray.getInteger(0, 0);
            typedarray.recycle();
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = ParcelableCompat.newCreator(new I());
        int a;
        Parcelable b;
        ClassLoader c;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentPager.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            parcel.writeParcelable(b, i1);
        }


        SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            if (classloader == null)
            {
                classloader = getClass().getClassLoader();
            }
            a = parcel.readInt();
            b = parcel.readParcelable(classloader);
            c = classloader;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
