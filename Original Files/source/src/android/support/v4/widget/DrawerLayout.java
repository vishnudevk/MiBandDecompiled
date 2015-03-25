// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            h, ViewDragHelper, f

public class DrawerLayout extends ViewGroup
{

    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String a = "DrawerLayout";
    private static final int b = 64;
    private static final int c = 0x99000000;
    private static final int d = 160;
    private static final int e = 400;
    private static final boolean f = false;
    private static final boolean g = true;
    private static final float h = 1F;
    private static final int i[] = {
        0x10100b3
    };
    private float A;
    private Drawable B;
    private Drawable C;
    private int j;
    private int k;
    private float l;
    private Paint m;
    private final ViewDragHelper n;
    private final ViewDragHelper o;
    private final h p;
    private final h q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private DrawerListener y;
    private float z;

    public DrawerLayout(Context context)
    {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        k = 0x99000000;
        m = new Paint();
        t = true;
        float f1 = getResources().getDisplayMetrics().density;
        j = (int)(0.5F + 64F * f1);
        float f2 = f1 * 400F;
        p = new h(this, 3);
        q = new h(this, 5);
        n = ViewDragHelper.create(this, 1.0F, p);
        n.setEdgeTrackingEnabled(1);
        n.setMinVelocity(f2);
        p.a(n);
        o = ViewDragHelper.create(this, 1.0F, q);
        o.setEdgeTrackingEnabled(2);
        o.setMinVelocity(f2);
        q.a(o);
        setFocusableInTouchMode(true);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
    }

    static String b(int i1)
    {
        if ((i1 & 3) == 3)
        {
            return "LEFT";
        }
        if ((i1 & 5) == 5)
        {
            return "RIGHT";
        } else
        {
            return Integer.toHexString(i1);
        }
    }

    static int[] c()
    {
        return i;
    }

    private boolean d()
    {
        int i1 = getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            if (((LayoutParams)getChildAt(j1).getLayoutParams()).b)
            {
                return true;
            }
        }

        return false;
    }

    private boolean e()
    {
        return f() != null;
    }

    private View f()
    {
        int i1 = getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            View view = getChildAt(j1);
            if (f(view) && isDrawerVisible(view))
            {
                return view;
            }
        }

        return null;
    }

    private static boolean g(View view)
    {
        Drawable drawable = view.getBackground();
        boolean flag = false;
        if (drawable != null)
        {
            int i1 = drawable.getOpacity();
            flag = false;
            if (i1 == -1)
            {
                flag = true;
            }
        }
        return flag;
    }

    View a()
    {
        int i1 = getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            View view = getChildAt(j1);
            if (((LayoutParams)view.getLayoutParams()).c)
            {
                return view;
            }
        }

        return null;
    }

    View a(int i1)
    {
        int j1 = getChildCount();
        for (int k1 = 0; k1 < j1; k1++)
        {
            View view = getChildAt(k1);
            if ((7 & d(view)) == (i1 & 7))
            {
                return view;
            }
        }

        return null;
    }

    void a(int i1, int j1, View view)
    {
        LayoutParams layoutparams;
        int k1 = 1;
        int l1 = n.getViewDragState();
        int i2 = o.getViewDragState();
        if (l1 != k1 && i2 != k1)
        {
            if (l1 == 2 || i2 == 2)
            {
                k1 = 2;
            } else
            {
                k1 = 0;
            }
        }
        if (view == null || j1 != 0) goto _L2; else goto _L1
_L1:
        layoutparams = (LayoutParams)view.getLayoutParams();
        if (layoutparams.a != 0.0F) goto _L4; else goto _L3
_L3:
        a(view);
_L2:
        if (k1 != r)
        {
            r = k1;
            if (y != null)
            {
                y.onDrawerStateChanged(k1);
            }
        }
        return;
_L4:
        if (layoutparams.a == 1.0F)
        {
            b(view);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    void a(View view)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (layoutparams.c)
        {
            layoutparams.c = false;
            if (y != null)
            {
                y.onDrawerClosed(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    void a(View view, float f1)
    {
        if (y != null)
        {
            y.onDrawerSlide(view, f1);
        }
    }

    void a(boolean flag)
    {
        int i1 = getChildCount();
        int j1 = 0;
        boolean flag1 = false;
        while (j1 < i1) 
        {
            View view = getChildAt(j1);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (f(view) && (!flag || layoutparams.b))
            {
                int k1 = view.getWidth();
                if (a(view, 3))
                {
                    flag1 |= n.smoothSlideViewTo(view, -k1, view.getTop());
                } else
                {
                    flag1 |= o.smoothSlideViewTo(view, getWidth(), view.getTop());
                }
                layoutparams.b = false;
            }
            j1++;
        }
        p.a();
        q.a();
        if (flag1)
        {
            invalidate();
        }
    }

    boolean a(View view, int i1)
    {
        return (i1 & d(view)) == i1;
    }

    void b()
    {
        int i1 = 0;
        if (!x)
        {
            long l1 = SystemClock.uptimeMillis();
            MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            for (int j1 = getChildCount(); i1 < j1; i1++)
            {
                getChildAt(i1).dispatchTouchEvent(motionevent);
            }

            motionevent.recycle();
            x = true;
        }
    }

    void b(View view)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.c)
        {
            layoutparams.c = true;
            if (y != null)
            {
                y.onDrawerOpened(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    void b(View view, float f1)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (f1 == layoutparams.a)
        {
            return;
        } else
        {
            layoutparams.a = f1;
            a(view, f1);
            return;
        }
    }

    float c(View view)
    {
        return ((LayoutParams)view.getLayoutParams()).a;
    }

    void c(View view, float f1)
    {
        float f2 = c(view);
        int i1 = view.getWidth();
        int j1 = (int)(f2 * (float)i1);
        int k1 = (int)(f1 * (float)i1) - j1;
        if (!a(view, 3))
        {
            k1 = -k1;
        }
        view.offsetLeftAndRight(k1);
        b(view, f1);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void closeDrawer(int i1)
    {
        int j1 = GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this));
        View view = a(j1);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No drawer view found with absolute gravity ").append(b(j1)).toString());
        } else
        {
            closeDrawer(view);
            return;
        }
    }

    public void closeDrawer(View view)
    {
        if (!f(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a sliding drawer").toString());
        }
        if (t)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            layoutparams.a = 0.0F;
            layoutparams.c = false;
        } else
        if (a(view, 3))
        {
            n.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
        } else
        {
            o.smoothSlideViewTo(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public void closeDrawers()
    {
        a(false);
    }

    public void computeScroll()
    {
        int i1 = getChildCount();
        float f1 = 0.0F;
        for (int j1 = 0; j1 < i1; j1++)
        {
            f1 = Math.max(f1, ((LayoutParams)getChildAt(j1).getLayoutParams()).a);
        }

        l = f1;
        if (n.continueSettling(true) | o.continueSettling(true))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int d(View view)
    {
        return GravityCompat.getAbsoluteGravity(((LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        int i1;
        boolean flag;
        int j1;
        int k1;
        int i2;
        int k4;
        int l4;
        i1 = getHeight();
        flag = e(view);
        j1 = getWidth();
        k1 = canvas.save();
        i2 = 0;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        k4 = getChildCount();
        l4 = 0;
_L2:
        if (l4 >= k4)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        View view1 = getChildAt(l4);
        if (view1 == view || view1.getVisibility() != 0 || !g(view1) || !f(view1))
        {
            break; /* Loop/switch isn't completed */
        }
        int i5;
        if (view1.getHeight() < i1)
        {
            i5 = j1;
        } else
        {
label0:
            {
                if (!a(view1, 3))
                {
                    break label0;
                }
                int j5 = view1.getRight();
                int j2;
                boolean flag1;
                int k2;
                int l2;
                int i3;
                int j3;
                float f1;
                int k3;
                int l3;
                int i4;
                float f2;
                int j4;
                if (j5 <= i2)
                {
                    j5 = i2;
                }
                i2 = j5;
                i5 = j1;
            }
        }
_L3:
        l4++;
        j1 = i5;
        if (true) goto _L2; else goto _L1
        i5 = view1.getLeft();
        if (i5 < j1) goto _L3; else goto _L1
_L1:
        i5 = j1;
          goto _L3
        canvas.clipRect(i2, 0, j1, getHeight());
        j2 = j1;
        flag1 = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(k1);
        if (l > 0.0F && flag)
        {
            j4 = (int)((float)((0xff000000 & k) >>> 24) * l) << 24 | 0xffffff & k;
            m.setColor(j4);
            canvas.drawRect(i2, 0.0F, j2, getHeight(), m);
        } else
        {
            if (B != null && a(view, 3))
            {
                k3 = B.getIntrinsicWidth();
                l3 = view.getRight();
                i4 = n.getEdgeSize();
                f2 = Math.max(0.0F, Math.min((float)l3 / (float)i4, 1.0F));
                B.setBounds(l3, view.getTop(), k3 + l3, view.getBottom());
                B.setAlpha((int)(255F * f2));
                B.draw(canvas);
                return flag1;
            }
            if (C != null && a(view, 5))
            {
                k2 = C.getIntrinsicWidth();
                l2 = view.getLeft();
                i3 = getWidth() - l2;
                j3 = o.getEdgeSize();
                f1 = Math.max(0.0F, Math.min((float)i3 / (float)j3, 1.0F));
                C.setBounds(l2 - k2, view.getTop(), l2, view.getBottom());
                C.setAlpha((int)(255F * f1));
                C.draw(canvas);
                return flag1;
            }
        }
        return flag1;
    }

    boolean e(View view)
    {
        return ((LayoutParams)view.getLayoutParams()).gravity == 0;
    }

    boolean f(View view)
    {
        return (7 & GravityCompat.getAbsoluteGravity(((LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view))) != 0;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof LayoutParams)
        {
            return new LayoutParams((LayoutParams)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new LayoutParams(layoutparams);
        }
    }

    public int getDrawerLockMode(int i1)
    {
        int j1 = GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this));
        if (j1 == 3)
        {
            return u;
        }
        if (j1 == 5)
        {
            return v;
        } else
        {
            return 0;
        }
    }

    public int getDrawerLockMode(View view)
    {
        int i1 = d(view);
        if (i1 == 3)
        {
            return u;
        }
        if (i1 == 5)
        {
            return v;
        } else
        {
            return 0;
        }
    }

    public boolean isDrawerOpen(int i1)
    {
        View view = a(i1);
        if (view != null)
        {
            return isDrawerOpen(view);
        } else
        {
            return false;
        }
    }

    public boolean isDrawerOpen(View view)
    {
        if (!f(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a drawer").toString());
        } else
        {
            return ((LayoutParams)view.getLayoutParams()).c;
        }
    }

    public boolean isDrawerVisible(int i1)
    {
        View view = a(i1);
        if (view != null)
        {
            return isDrawerVisible(view);
        } else
        {
            return false;
        }
    }

    public boolean isDrawerVisible(View view)
    {
        if (!f(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a drawer").toString());
        }
        return ((LayoutParams)view.getLayoutParams()).a > 0.0F;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        t = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        t = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        i1 = MotionEventCompat.getActionMasked(motionevent);
        flag = n.shouldInterceptTouchEvent(motionevent) | o.shouldInterceptTouchEvent(motionevent);
        i1;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 95
    //                   1 195
    //                   2 164
    //                   3 195;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        boolean flag1 = false;
_L8:
        if (flag || flag1 || d()) goto _L6; else goto _L5
_L5:
        boolean flag2;
        boolean flag3;
        flag3 = x;
        flag2 = false;
        if (!flag3) goto _L7; else goto _L6
_L6:
        flag2 = true;
_L7:
        return flag2;
_L2:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        z = f1;
        A = f2;
        if (l > 0.0F && e(n.findTopChildUnder((int)f1, (int)f2)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w = false;
        x = false;
          goto _L8
_L4:
        if (!n.checkTouchSlop(3))
        {
            continue; /* Loop/switch isn't completed */
        }
        p.a();
        q.a();
        flag1 = false;
          goto _L8
_L3:
        a(true);
        w = false;
        x = false;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && e())
        {
            KeyEventCompat.startTracking(keyevent);
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            View view = f();
            if (view != null && getDrawerLockMode(view) == 0)
            {
                closeDrawers();
            }
            return view != null;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        int k2;
        s = true;
        i2 = k1 - i1;
        j2 = getChildCount();
        k2 = 0;
_L2:
        View view;
        if (k2 >= j2)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        view = getChildAt(k2);
        if (view.getVisibility() != 8)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        k2++;
        if (true) goto _L2; else goto _L1
_L1:
        LayoutParams layoutparams;
label0:
        {
            layoutparams = (LayoutParams)view.getLayoutParams();
            if (!e(view))
            {
                break label0;
            }
            view.layout(layoutparams.leftMargin, layoutparams.topMargin, layoutparams.leftMargin + view.getMeasuredWidth(), layoutparams.topMargin + view.getMeasuredHeight());
        }
          goto _L3
        int l2;
        int i3;
        int j3;
        l2 = view.getMeasuredWidth();
        i3 = view.getMeasuredHeight();
        float f1;
        boolean flag1;
        if (a(view, 3))
        {
            j3 = -l2 + (int)((float)l2 * layoutparams.a);
            f1 = (float)(l2 + j3) / (float)l2;
        } else
        {
            j3 = i2 - (int)((float)l2 * layoutparams.a);
            f1 = (float)(i2 - j3) / (float)l2;
        }
        if (f1 != layoutparams.a)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        0x70 & layoutparams.gravity;
        JVM INSTR lookupswitch 2: default 212
    //                   16: 356
    //                   80: 313;
           goto _L4 _L5 _L6
_L5:
        break MISSING_BLOCK_LABEL_356;
_L4:
        view.layout(j3, layoutparams.topMargin, l2 + j3, i3);
_L7:
        if (flag1)
        {
            b(view, f1);
        }
        int k3;
        int l3;
        int i4;
        int j4;
        if (layoutparams.a > 0.0F)
        {
            i4 = 0;
        } else
        {
            i4 = 4;
        }
        if (view.getVisibility() != i4)
        {
            view.setVisibility(i4);
        }
          goto _L3
_L6:
        j4 = l1 - j1;
        view.layout(j3, j4 - layoutparams.bottomMargin - view.getMeasuredHeight(), l2 + j3, j4 - layoutparams.bottomMargin);
          goto _L7
        k3 = l1 - j1;
        l3 = (k3 - i3) / 2;
        if (l3 < layoutparams.topMargin)
        {
            l3 = layoutparams.topMargin;
        } else
        if (l3 + i3 > k3 - layoutparams.bottomMargin)
        {
            l3 = k3 - layoutparams.bottomMargin - i3;
        }
        view.layout(j3, l3, l2 + j3, i3 + l3);
          goto _L7
        s = false;
        t = false;
        return;
          goto _L3
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        k1 = 300;
        l1 = android.view.View.MeasureSpec.getMode(i1);
        i2 = android.view.View.MeasureSpec.getMode(j1);
        j2 = android.view.View.MeasureSpec.getSize(i1);
        k2 = android.view.View.MeasureSpec.getSize(j1);
        if (l1 == 0x40000000 && i2 == 0x40000000) goto _L2; else goto _L1
_L1:
        if (!isInEditMode()) goto _L4; else goto _L3
_L7:
        if (i2 != 0x80000000) goto _L6; else goto _L5
_L5:
        k1 = k2;
_L8:
        setMeasuredDimension(j2, k1);
        int l2 = getChildCount();
        int i3 = 0;
        while (i3 < l2) 
        {
            View view = getChildAt(i3);
            if (view.getVisibility() != 8)
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (e(view))
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j2 - layoutparams.leftMargin - layoutparams.rightMargin, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k1 - layoutparams.topMargin - layoutparams.bottomMargin, 0x40000000));
                } else
                if (f(view))
                {
                    int j3 = 7 & d(view);
                    if ((0 & j3) != 0)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Child drawer has absolute gravity ").append(b(j3)).append(" but this ").append("DrawerLayout").append(" already has a ").append("drawer view along that edge").toString());
                    }
                    view.measure(getChildMeasureSpec(i1, j + layoutparams.leftMargin + layoutparams.rightMargin, layoutparams.width), getChildMeasureSpec(j1, layoutparams.topMargin + layoutparams.bottomMargin, layoutparams.height));
                } else
                {
                    throw new IllegalStateException((new StringBuilder()).append("Child ").append(view).append(" at index ").append(i3).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ").append("Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                }
            }
            i3++;
        }
        break MISSING_BLOCK_LABEL_403;
_L3:
        if (l1 != 0x80000000 && l1 == 0)
        {
            j2 = k1;
        }
          goto _L7
_L6:
        if (i2 == 0) goto _L8; else goto _L2
_L2:
        k1 = k2;
          goto _L8
_L4:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          goto _L8
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (savedstate.a != 0)
        {
            View view = a(savedstate.a);
            if (view != null)
            {
                openDrawer(view);
            }
        }
        setDrawerLockMode(savedstate.b, 3);
        setDrawerLockMode(savedstate.c, 5);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate;
        int i1;
        int j1;
        savedstate = new SavedState(super.onSaveInstanceState());
        i1 = getChildCount();
        j1 = 0;
_L2:
        View view;
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        view = getChildAt(j1);
        if (f(view))
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        j1++;
        LayoutParams layoutparams;
        if (true) goto _L2; else goto _L1
_L1:
        if (!(layoutparams = (LayoutParams)view.getLayoutParams()).c) goto _L4; else goto _L3
_L3:
        savedstate.a = layoutparams.gravity;
        savedstate.b = u;
        savedstate.c = v;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        n.processTouchEvent(motionevent);
        o.processTouchEvent(motionevent);
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 56
    //                   0 58
    //                   1 94
    //                   2 56
    //                   3 220;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        float f5 = motionevent.getX();
        float f6 = motionevent.getY();
        z = f5;
        A = f6;
        w = false;
        x = false;
        return true;
_L3:
        float f1;
        float f2;
        View view;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        view = n.findTopChildUnder((int)f1, (int)f2);
        if (view == null || !e(view)) goto _L6; else goto _L5
_L5:
        float f3;
        float f4;
        int i1;
        f3 = f1 - z;
        f4 = f2 - A;
        i1 = n.getTouchSlop();
        if (f3 * f3 + f4 * f4 >= (float)(i1 * i1)) goto _L6; else goto _L7
_L7:
        View view1 = a();
        if (view1 == null) goto _L6; else goto _L8
_L8:
        boolean flag;
        if (getDrawerLockMode(view1) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L10:
        a(flag);
        w = false;
        return true;
_L4:
        a(true);
        w = false;
        x = false;
        return true;
_L6:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void openDrawer(int i1)
    {
        int j1 = GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this));
        View view = a(j1);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No drawer view found with absolute gravity ").append(b(j1)).toString());
        } else
        {
            openDrawer(view);
            return;
        }
    }

    public void openDrawer(View view)
    {
        if (!f(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a sliding drawer").toString());
        }
        if (t)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            layoutparams.a = 1.0F;
            layoutparams.c = true;
        } else
        if (a(view, 3))
        {
            n.smoothSlideViewTo(view, 0, view.getTop());
        } else
        {
            o.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        w = flag;
        if (flag)
        {
            a(true);
        }
    }

    public void requestLayout()
    {
        if (!s)
        {
            super.requestLayout();
        }
    }

    public void setDrawerListener(DrawerListener drawerlistener)
    {
        y = drawerlistener;
    }

    public void setDrawerLockMode(int i1)
    {
        setDrawerLockMode(i1, 3);
        setDrawerLockMode(i1, 5);
    }

    public void setDrawerLockMode(int i1, int j1)
    {
        int k1;
        k1 = GravityCompat.getAbsoluteGravity(j1, ViewCompat.getLayoutDirection(this));
        if (k1 == 3)
        {
            u = i1;
        } else
        if (k1 == 5)
        {
            v = i1;
        }
        if (i1 != 0)
        {
            ViewDragHelper viewdraghelper;
            if (k1 == 3)
            {
                viewdraghelper = n;
            } else
            {
                viewdraghelper = o;
            }
            viewdraghelper.cancel();
        }
        i1;
        JVM INSTR tableswitch 1 2: default 64
    //                   1 106
    //                   2 87;
           goto _L1 _L2 _L3
_L1:
        View view1;
        return;
_L3:
        View view;
        if ((view1 = a(k1)) != null)
        {
            openDrawer(view1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((view = a(k1)) != null)
        {
            closeDrawer(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setDrawerLockMode(int i1, View view)
    {
        if (!f(view))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a ").append("drawer with appropriate layout_gravity").toString());
        } else
        {
            setDrawerLockMode(i1, d(view));
            return;
        }
    }

    public void setDrawerShadow(int i1, int j1)
    {
        setDrawerShadow(getResources().getDrawable(i1), j1);
    }

    public void setDrawerShadow(Drawable drawable, int i1)
    {
        int j1 = GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this));
        if ((j1 & 3) == 3)
        {
            B = drawable;
            invalidate();
        }
        if ((j1 & 5) == 5)
        {
            C = drawable;
            invalidate();
        }
    }

    public void setScrimColor(int i1)
    {
        k = i1;
        invalidate();
    }


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        float a;
        boolean b;
        boolean c;
        public int gravity;

        public LayoutParams(int i1, int j1)
        {
            super(i1, j1);
            gravity = 0;
        }

        public LayoutParams(int i1, int j1, int k1)
        {
            this(i1, j1);
            gravity = k1;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            gravity = 0;
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, DrawerLayout.c());
            gravity = typedarray.getInt(0, 0);
            typedarray.recycle();
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            gravity = 0;
            gravity = layoutparams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            gravity = 0;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            gravity = 0;
        }
    }


    private class DrawerListener
    {

        public abstract void onDrawerClosed(View view);

        public abstract void onDrawerOpened(View view);

        public abstract void onDrawerSlide(View view, float f1);

        public abstract void onDrawerStateChanged(int i1);
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new g();
        int a;
        int b;
        int c;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = 0;
            b = 0;
            c = 0;
            a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
            a = 0;
            b = 0;
            c = 0;
        }
    }

}
