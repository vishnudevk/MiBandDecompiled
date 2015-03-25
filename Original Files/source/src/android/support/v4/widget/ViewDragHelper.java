// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

// Referenced classes of package android.support.v4.widget:
//            P, Q, ScrollerCompat

public class ViewDragHelper
{

    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String a = "ViewDragHelper";
    private static final int b = 20;
    private static final int c = 256;
    private static final int d = 600;
    private static final Interpolator z = new P();
    private final Runnable A = new Q(this);
    private int e;
    private int f;
    private int g;
    private float h[];
    private float i[];
    private float j[];
    private float k[];
    private int l[];
    private int m[];
    private int n[];
    private int o;
    private VelocityTracker p;
    private float q;
    private float r;
    private int s;
    private int t;
    private ScrollerCompat u;
    private final Callback v;
    private View w;
    private boolean x;
    private final ViewGroup y;

    private ViewDragHelper(Context context, ViewGroup viewgroup, Callback callback)
    {
        g = -1;
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            y = viewgroup;
            v = callback;
            ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
            s = (int)(0.5F + 20F * context.getResources().getDisplayMetrics().density);
            f = viewconfiguration.getScaledTouchSlop();
            q = viewconfiguration.getScaledMaximumFlingVelocity();
            r = viewconfiguration.getScaledMinimumFlingVelocity();
            u = ScrollerCompat.create(context, z);
            return;
        }
    }

    private float a(float f1)
    {
        return (float)Math.sin((float)(0.4712389167638204D * (double)(f1 - 0.5F)));
    }

    private float a(float f1, float f2, float f3)
    {
        float f4 = Math.abs(f1);
        if (f4 < f2)
        {
            f3 = 0.0F;
        } else
        if (f4 > f3)
        {
            if (f1 <= 0.0F)
            {
                return -f3;
            }
        } else
        {
            return f1;
        }
        return f3;
    }

    private int a(int i1, int j1)
    {
        int k1 = y.getLeft() + s;
        int l1 = 0;
        if (i1 < k1)
        {
            l1 = 1;
        }
        if (j1 < y.getTop() + s)
        {
            l1 |= 4;
        }
        if (i1 > y.getRight() - s)
        {
            l1 |= 2;
        }
        if (j1 > y.getBottom() - s)
        {
            l1 |= 8;
        }
        return l1;
    }

    private int a(int i1, int j1, int k1)
    {
        if (i1 == 0)
        {
            return 0;
        }
        int l1 = y.getWidth();
        int i2 = l1 / 2;
        float f1 = Math.min(1.0F, (float)Math.abs(i1) / (float)l1);
        float f2 = (float)i2 + (float)i2 * a(f1);
        int j2 = Math.abs(j1);
        int k2;
        if (j2 > 0)
        {
            k2 = 4 * Math.round(1000F * Math.abs(f2 / (float)j2));
        } else
        {
            k2 = (int)(256F * (1.0F + (float)Math.abs(i1) / (float)k1));
        }
        return Math.min(k2, 600);
    }

    private int a(View view, int i1, int j1, int k1, int l1)
    {
        int i2 = b(k1, (int)r, (int)q);
        int j2 = b(l1, (int)r, (int)q);
        int k2 = Math.abs(i1);
        int l2 = Math.abs(j1);
        int i3 = Math.abs(i2);
        int j3 = Math.abs(j2);
        int k3 = i3 + j3;
        int l3 = k2 + l2;
        float f1;
        float f2;
        int i4;
        int j4;
        if (i2 != 0)
        {
            f1 = (float)i3 / (float)k3;
        } else
        {
            f1 = (float)k2 / (float)l3;
        }
        if (j2 != 0)
        {
            f2 = (float)j3 / (float)k3;
        } else
        {
            f2 = (float)l2 / (float)l3;
        }
        i4 = a(i1, i2, v.getViewHorizontalDragRange(view));
        j4 = a(j1, j2, v.getViewVerticalDragRange(view));
        return (int)(f1 * (float)i4 + f2 * (float)j4);
    }

    private void a()
    {
        if (h == null)
        {
            return;
        } else
        {
            Arrays.fill(h, 0.0F);
            Arrays.fill(i, 0.0F);
            Arrays.fill(j, 0.0F);
            Arrays.fill(k, 0.0F);
            Arrays.fill(l, 0);
            Arrays.fill(m, 0);
            Arrays.fill(n, 0);
            o = 0;
            return;
        }
    }

    private void a(float f1, float f2)
    {
        x = true;
        v.onViewReleased(w, f1, f2);
        x = false;
        if (e == 1)
        {
            a(0);
        }
    }

    private void a(float f1, float f2, int i1)
    {
        c(i1);
        float af[] = h;
        j[i1] = f1;
        af[i1] = f1;
        float af1[] = i;
        k[i1] = f2;
        af1[i1] = f2;
        l[i1] = a((int)f1, (int)f2);
        o = o | 1 << i1;
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = MotionEventCompat.getPointerCount(motionevent);
        for (int j1 = 0; j1 < i1; j1++)
        {
            int k1 = MotionEventCompat.getPointerId(motionevent, j1);
            float f1 = MotionEventCompat.getX(motionevent, j1);
            float f2 = MotionEventCompat.getY(motionevent, j1);
            j[k1] = f1;
            k[k1] = f2;
        }

    }

    private boolean a(float f1, float f2, int i1, int j1)
    {
        float f3 = Math.abs(f1);
        float f4 = Math.abs(f2);
        if ((j1 & l[i1]) == j1 && (j1 & t) != 0 && (j1 & n[i1]) != j1 && (j1 & m[i1]) != j1 && (f3 > (float)f || f4 > (float)f))
        {
            if (f3 < f4 * 0.5F && v.onEdgeLock(j1))
            {
                int ai[] = n;
                ai[i1] = j1 | ai[i1];
                return false;
            }
            if ((j1 & m[i1]) == 0 && f3 > (float)f)
            {
                return true;
            }
        }
        return false;
    }

    private boolean a(int i1, int j1, int k1, int l1)
    {
        int i2 = w.getLeft();
        int j2 = w.getTop();
        int k2 = i1 - i2;
        int l2 = j1 - j2;
        if (k2 == 0 && l2 == 0)
        {
            u.abortAnimation();
            a(0);
            return false;
        } else
        {
            int i3 = a(w, k2, l2, k1, l1);
            u.startScroll(i2, j2, k2, l2, i3);
            a(2);
            return true;
        }
    }

    private boolean a(View view, float f1, float f2)
    {
        boolean flag = true;
        if (view != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        boolean flag1;
        boolean flag2;
        if (v.getViewHorizontalDragRange(view) > 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (v.getViewVerticalDragRange(view) > 0)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        if (!flag1 || !flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f1 * f1 + f2 * f2 <= (float)(f * f))
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Math.abs(f1) <= (float)f)
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (flag2)
        {
            if (Math.abs(f2) <= (float)f)
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    private int b(int i1, int j1, int k1)
    {
        int l1 = Math.abs(i1);
        if (l1 < j1)
        {
            k1 = 0;
        } else
        if (l1 > k1)
        {
            if (i1 <= 0)
            {
                return -k1;
            }
        } else
        {
            return i1;
        }
        return k1;
    }

    private void b()
    {
        p.computeCurrentVelocity(1000, q);
        a(a(VelocityTrackerCompat.getXVelocity(p, g), r, q), a(VelocityTrackerCompat.getYVelocity(p, g), r, q));
    }

    private void b(float f1, float f2, int i1)
    {
        int j1 = 1;
        if (!a(f1, f2, i1, j1))
        {
            j1 = 0;
        }
        if (a(f2, f1, i1, 4))
        {
            j1 |= 4;
        }
        if (a(f1, f2, i1, 2))
        {
            j1 |= 2;
        }
        if (a(f2, f1, i1, 8))
        {
            j1 |= 8;
        }
        if (j1 != 0)
        {
            int ai[] = m;
            ai[i1] = j1 | ai[i1];
            v.onEdgeDragStarted(j1, i1);
        }
    }

    private void b(int i1)
    {
        if (h == null)
        {
            return;
        } else
        {
            h[i1] = 0.0F;
            i[i1] = 0.0F;
            j[i1] = 0.0F;
            k[i1] = 0.0F;
            l[i1] = 0;
            m[i1] = 0;
            n[i1] = 0;
            o = o & (-1 ^ 1 << i1);
            return;
        }
    }

    private void b(int i1, int j1, int k1, int l1)
    {
        int i2 = w.getLeft();
        int j2 = w.getTop();
        int k2;
        int l2;
        if (k1 != 0)
        {
            k2 = v.clampViewPositionHorizontal(w, i1, k1);
            w.offsetLeftAndRight(k2 - i2);
        } else
        {
            k2 = i1;
        }
        if (l1 != 0)
        {
            l2 = v.clampViewPositionVertical(w, j1, l1);
            w.offsetTopAndBottom(l2 - j2);
        } else
        {
            l2 = j1;
        }
        if (k1 != 0 || l1 != 0)
        {
            int i3 = k2 - i2;
            int j3 = l2 - j2;
            v.onViewPositionChanged(w, k2, l2, i3, j3);
        }
    }

    private void c(int i1)
    {
        if (h == null || h.length <= i1)
        {
            float af[] = new float[i1 + 1];
            float af1[] = new float[i1 + 1];
            float af2[] = new float[i1 + 1];
            float af3[] = new float[i1 + 1];
            int ai[] = new int[i1 + 1];
            int ai1[] = new int[i1 + 1];
            int ai2[] = new int[i1 + 1];
            if (h != null)
            {
                System.arraycopy(h, 0, af, 0, h.length);
                System.arraycopy(i, 0, af1, 0, i.length);
                System.arraycopy(j, 0, af2, 0, j.length);
                System.arraycopy(k, 0, af3, 0, k.length);
                System.arraycopy(l, 0, ai, 0, l.length);
                System.arraycopy(m, 0, ai1, 0, m.length);
                System.arraycopy(n, 0, ai2, 0, n.length);
            }
            h = af;
            i = af1;
            j = af2;
            k = af3;
            l = ai;
            m = ai1;
            n = ai2;
        }
    }

    public static ViewDragHelper create(ViewGroup viewgroup, float f1, Callback callback)
    {
        ViewDragHelper viewdraghelper = create(viewgroup, callback);
        viewdraghelper.f = (int)((float)viewdraghelper.f * (1.0F / f1));
        return viewdraghelper;
    }

    public static ViewDragHelper create(ViewGroup viewgroup, Callback callback)
    {
        return new ViewDragHelper(viewgroup.getContext(), viewgroup, callback);
    }

    void a(int i1)
    {
        if (e != i1)
        {
            e = i1;
            v.onViewDragStateChanged(i1);
            if (i1 == 0)
            {
                w = null;
            }
        }
    }

    boolean a(View view, int i1)
    {
        if (view == w && g == i1)
        {
            return true;
        }
        if (view != null && v.tryCaptureView(view, i1))
        {
            g = i1;
            captureChildView(view, i1);
            return true;
        } else
        {
            return false;
        }
    }

    public void abort()
    {
        cancel();
        if (e == 2)
        {
            int i1 = u.getCurrX();
            int j1 = u.getCurrY();
            u.abortAnimation();
            int k1 = u.getCurrX();
            int l1 = u.getCurrY();
            v.onViewPositionChanged(w, k1, l1, k1 - i1, l1 - j1);
        }
        a(0);
    }

    protected boolean canScroll(View view, boolean flag, int i1, int j1, int k1, int l1)
    {
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i2 = view.getScrollX();
            int j2 = view.getScrollY();
            for (int k2 = -1 + viewgroup.getChildCount(); k2 >= 0; k2--)
            {
                View view1 = viewgroup.getChildAt(k2);
                if (k1 + i2 >= view1.getLeft() && k1 + i2 < view1.getRight() && l1 + j2 >= view1.getTop() && l1 + j2 < view1.getBottom() && canScroll(view1, true, i1, j1, (k1 + i2) - view1.getLeft(), (l1 + j2) - view1.getTop()))
                {
                    return true;
                }
            }

        }
        return flag && (ViewCompat.canScrollHorizontally(view, -i1) || ViewCompat.canScrollVertically(view, -j1));
    }

    public void cancel()
    {
        g = -1;
        a();
        if (p != null)
        {
            p.recycle();
            p = null;
        }
    }

    public void captureChildView(View view, int i1)
    {
        if (view.getParent() != y)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (").append(y).append(")").toString());
        } else
        {
            w = view;
            g = i1;
            v.onViewCaptured(view, i1);
            a(1);
            return;
        }
    }

    public boolean checkTouchSlop(int i1)
    {
        int j1 = h.length;
        int k1 = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (k1 < j1)
                {
                    if (!checkTouchSlop(i1, k1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k1++;
        } while (true);
    }

    public boolean checkTouchSlop(int i1, int j1)
    {
        boolean flag = true;
        if (isPointerDown(j1)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        int k1;
        int l1;
        float f1;
        float f2;
        if ((i1 & 1) == flag)
        {
            k1 = ((flag) ? 1 : 0);
        } else
        {
            k1 = 0;
        }
        if ((i1 & 2) == 2)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = 0;
        }
        f1 = j[j1] - h[j1];
        f2 = k[j1] - i[j1];
        if (k1 == 0 || l1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (f1 * f1 + f2 * f2 <= (float)(f * f))
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (k1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Math.abs(f1) <= (float)f)
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (l1 != 0)
        {
            if (Math.abs(f2) <= (float)f)
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public boolean continueSettling(boolean flag)
    {
        if (e == 2)
        {
            boolean flag1 = u.computeScrollOffset();
            int i1 = u.getCurrX();
            int j1 = u.getCurrY();
            int k1 = i1 - w.getLeft();
            int l1 = j1 - w.getTop();
            if (k1 != 0)
            {
                w.offsetLeftAndRight(k1);
            }
            if (l1 != 0)
            {
                w.offsetTopAndBottom(l1);
            }
            if (k1 != 0 || l1 != 0)
            {
                v.onViewPositionChanged(w, i1, j1, k1, l1);
            }
            boolean flag2;
            if (flag1 && i1 == u.getFinalX() && j1 == u.getFinalY())
            {
                u.abortAnimation();
                flag2 = u.isFinished();
            } else
            {
                flag2 = flag1;
            }
            if (!flag2)
            {
                if (flag)
                {
                    y.post(A);
                } else
                {
                    a(0);
                }
            }
        }
        return e == 2;
    }

    public View findTopChildUnder(int i1, int j1)
    {
        for (int k1 = -1 + y.getChildCount(); k1 >= 0; k1--)
        {
            View view = y.getChildAt(v.getOrderedChildIndex(k1));
            if (i1 >= view.getLeft() && i1 < view.getRight() && j1 >= view.getTop() && j1 < view.getBottom())
            {
                return view;
            }
        }

        return null;
    }

    public void flingCapturedView(int i1, int j1, int k1, int l1)
    {
        if (!x)
        {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        } else
        {
            u.fling(w.getLeft(), w.getTop(), (int)VelocityTrackerCompat.getXVelocity(p, g), (int)VelocityTrackerCompat.getYVelocity(p, g), i1, k1, j1, l1);
            a(2);
            return;
        }
    }

    public int getActivePointerId()
    {
        return g;
    }

    public View getCapturedView()
    {
        return w;
    }

    public int getEdgeSize()
    {
        return s;
    }

    public float getMinVelocity()
    {
        return r;
    }

    public int getTouchSlop()
    {
        return f;
    }

    public int getViewDragState()
    {
        return e;
    }

    public boolean isCapturedViewUnder(int i1, int j1)
    {
        return isViewUnder(w, i1, j1);
    }

    public boolean isEdgeTouched(int i1)
    {
        int j1 = l.length;
        int k1 = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (k1 < j1)
                {
                    if (!isEdgeTouched(i1, k1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k1++;
        } while (true);
    }

    public boolean isEdgeTouched(int i1, int j1)
    {
        return isPointerDown(j1) && (i1 & l[j1]) != 0;
    }

    public boolean isPointerDown(int i1)
    {
        return (o & 1 << i1) != 0;
    }

    public boolean isViewUnder(View view, int i1, int j1)
    {
        while (view == null || i1 < view.getLeft() || i1 >= view.getRight() || j1 < view.getTop() || j1 >= view.getBottom()) 
        {
            return false;
        }
        return true;
    }

    public void processTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        int k1;
        i1 = 0;
        j1 = MotionEventCompat.getActionMasked(motionevent);
        k1 = MotionEventCompat.getActionIndex(motionevent);
        if (j1 == 0)
        {
            cancel();
        }
        if (p == null)
        {
            p = VelocityTracker.obtain();
        }
        p.addMovement(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 89
    //                   1 641
    //                   2 294
    //                   3 658
    //                   4 88
    //                   5 175
    //                   6 515;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return;
_L2:
        float f11 = motionevent.getX();
        float f12 = motionevent.getY();
        int k4 = MotionEventCompat.getPointerId(motionevent, 0);
        View view1 = findTopChildUnder((int)f11, (int)f12);
        a(f11, f12, k4);
        a(view1, k4);
        int l4 = l[k4];
        if ((l4 & t) != 0)
        {
            v.onEdgeTouched(l4 & t, k4);
            return;
        }
          goto _L1
_L6:
        int i4;
        float f9;
        float f10;
        int j4;
        i4 = MotionEventCompat.getPointerId(motionevent, k1);
        f9 = MotionEventCompat.getX(motionevent, k1);
        f10 = MotionEventCompat.getY(motionevent, k1);
        a(f9, f10, i4);
        if (e != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        a(findTopChildUnder((int)f9, (int)f10), i4);
        j4 = l[i4];
        if ((j4 & t) == 0) goto _L1; else goto _L8
_L8:
        v.onEdgeTouched(j4 & t, i4);
        return;
        if (!isCapturedViewUnder((int)f9, (int)f10)) goto _L1; else goto _L9
_L9:
        a(w, i4);
        return;
_L4:
        int l2;
        if (e == 1)
        {
            int j3 = MotionEventCompat.findPointerIndex(motionevent, g);
            float f7 = MotionEventCompat.getX(motionevent, j3);
            float f8 = MotionEventCompat.getY(motionevent, j3);
            int k3 = (int)(f7 - j[g]);
            int l3 = (int)(f8 - k[g]);
            b(k3 + w.getLeft(), l3 + w.getTop(), k3, l3);
            a(motionevent);
            return;
        }
        l2 = MotionEventCompat.getPointerCount(motionevent);
_L14:
        if (i1 >= l2) goto _L11; else goto _L10
_L10:
        int i3;
        float f3;
        float f4;
        float f5;
        float f6;
        i3 = MotionEventCompat.getPointerId(motionevent, i1);
        f3 = MotionEventCompat.getX(motionevent, i1);
        f4 = MotionEventCompat.getY(motionevent, i1);
        f5 = f3 - h[i3];
        f6 = f4 - i[i3];
        b(f5, f6, i3);
        if (e != 1) goto _L12; else goto _L11
_L11:
        View view;
        a(motionevent);
        return;
_L12:
        if (a(view = findTopChildUnder((int)f3, (int)f4), f5, f6) && a(view, i3)) goto _L11; else goto _L13
_L13:
        i1++;
          goto _L14
_L7:
        int l1 = MotionEventCompat.getPointerId(motionevent, k1);
        if (e != 1 || l1 != g) goto _L16; else goto _L15
_L15:
        int i2 = MotionEventCompat.getPointerCount(motionevent);
_L21:
        if (i1 >= i2) goto _L18; else goto _L17
_L17:
        int k2 = MotionEventCompat.getPointerId(motionevent, i1);
        if (k2 != g) goto _L20; else goto _L19
_L19:
        i1++;
          goto _L21
_L20:
        float f1;
        float f2;
        f1 = MotionEventCompat.getX(motionevent, i1);
        f2 = MotionEventCompat.getY(motionevent, i1);
        if (findTopChildUnder((int)f1, (int)f2) != w || !a(w, k2)) goto _L19; else goto _L22
_L22:
        int j2 = g;
_L24:
        if (j2 == -1)
        {
            b();
        }
_L16:
        b(l1);
        return;
_L3:
        if (e == 1)
        {
            b();
        }
        cancel();
        return;
_L5:
        if (e == 1)
        {
            a(0.0F, 0.0F);
        }
        cancel();
        return;
_L18:
        j2 = -1;
        if (true) goto _L24; else goto _L23
_L23:
    }

    public void setEdgeTrackingEnabled(int i1)
    {
        t = i1;
    }

    public void setMinVelocity(float f1)
    {
        r = f1;
    }

    public boolean settleCapturedViewAt(int i1, int j1)
    {
        if (!x)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            return a(i1, j1, (int)VelocityTrackerCompat.getXVelocity(p, g), (int)VelocityTrackerCompat.getYVelocity(p, g));
        }
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        i1 = MotionEventCompat.getActionMasked(motionevent);
        j1 = MotionEventCompat.getActionIndex(motionevent);
        if (i1 == 0)
        {
            cancel();
        }
        if (p == null)
        {
            p = VelocityTracker.obtain();
        }
        p.addMovement(motionevent);
        i1;
        JVM INSTR tableswitch 0 6: default 84
    //                   0 94
    //                   1 465
    //                   2 316
    //                   3 465
    //                   4 84
    //                   5 199
    //                   6 453;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_465;
_L7:
        int k1;
        int l1;
        int i2;
        float f1;
        float f2;
        float f3;
        float f4;
        View view;
        float f7;
        float f8;
        int l2;
        View view2;
        int i3;
        return e == 1;
_L2:
        f7 = motionevent.getX();
        f8 = motionevent.getY();
        l2 = MotionEventCompat.getPointerId(motionevent, 0);
        a(f7, f8, l2);
        view2 = findTopChildUnder((int)f7, (int)f8);
        if (view2 == w && e == 2)
        {
            a(view2, l2);
        }
        i3 = l[l2];
        if ((i3 & t) != 0)
        {
            v.onEdgeTouched(i3 & t, l2);
        }
          goto _L7
_L5:
        int j2 = MotionEventCompat.getPointerId(motionevent, j1);
        float f5 = MotionEventCompat.getX(motionevent, j1);
        float f6 = MotionEventCompat.getY(motionevent, j1);
        a(f5, f6, j2);
        if (e == 0)
        {
            int k2 = l[j2];
            if ((k2 & t) != 0)
            {
                v.onEdgeTouched(k2 & t, j2);
            }
        } else
        if (e == 2)
        {
            View view1 = findTopChildUnder((int)f5, (int)f6);
            if (view1 == w)
            {
                a(view1, j2);
            }
        }
          goto _L7
_L4:
        k1 = MotionEventCompat.getPointerCount(motionevent);
        l1 = 0;
_L12:
        if (l1 >= k1) goto _L9; else goto _L8
_L8:
        i2 = MotionEventCompat.getPointerId(motionevent, l1);
        f1 = MotionEventCompat.getX(motionevent, l1);
        f2 = MotionEventCompat.getY(motionevent, l1);
        f3 = f1 - h[i2];
        f4 = f2 - i[i2];
        b(f3, f4, i2);
        if (e != 1) goto _L10; else goto _L9
_L9:
        a(motionevent);
          goto _L7
_L10:
        if ((view = findTopChildUnder((int)f1, (int)f2)) != null && a(view, f3, f4) && a(view, i2)) goto _L9; else goto _L11
_L11:
        l1++;
          goto _L12
_L6:
        b(MotionEventCompat.getPointerId(motionevent, j1));
          goto _L7
        cancel();
          goto _L7
    }

    public boolean smoothSlideViewTo(View view, int i1, int j1)
    {
        w = view;
        g = -1;
        return a(i1, j1, 0, 0);
    }


    private class Callback
    {

        public int clampViewPositionHorizontal(View view, int i1, int j1)
        {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i1, int j1)
        {
            return 0;
        }

        public int getOrderedChildIndex(int i1)
        {
            return i1;
        }

        public int getViewHorizontalDragRange(View view)
        {
            return 0;
        }

        public int getViewVerticalDragRange(View view)
        {
            return 0;
        }

        public void onEdgeDragStarted(int i1, int j1)
        {
        }

        public boolean onEdgeLock(int i1)
        {
            return false;
        }

        public void onEdgeTouched(int i1, int j1)
        {
        }

        public void onViewCaptured(View view, int i1)
        {
        }

        public void onViewDragStateChanged(int i1)
        {
        }

        public void onViewPositionChanged(View view, int i1, int j1, int k1, int l1)
        {
        }

        public void onViewReleased(View view, float f1, float f2)
        {
        }

        public abstract boolean tryCaptureView(View view, int i1);

        public Callback()
        {
        }
    }

}
