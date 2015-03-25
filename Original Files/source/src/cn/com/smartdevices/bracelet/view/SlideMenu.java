// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            A, ScrollDetectors

public class SlideMenu extends ViewGroup
{

    public static final Interpolator DEFAULT_INTERPOLATOR = new A();
    public static final int FLAG_DIRECTION_LEFT = 1;
    public static final int FLAG_DIRECTION_RIGHT = 2;
    public static final int MODE_SLIDE_CONTENT = 2;
    public static final int MODE_SLIDE_WINDOW = 1;
    public static final int STATE_CLOSE = 1;
    public static final int STATE_DRAG = 8;
    public static final int STATE_OPEN_LEFT = 2;
    public static final int STATE_OPEN_MASK = 6;
    public static final int STATE_OPEN_RIGHT = 4;
    public static final int STATE_SCROLL = 16;
    private static final int a = 500;
    private static int b = 0;
    private static final int c = -1;
    private static final int d = 0;
    private static final int e = 1;
    private int A;
    private Rect B;
    private boolean C;
    private int D;
    private int E;
    private OnSlideStateChangeListener F;
    private OnContentTapListener G;
    private VelocityTracker H;
    private Scroller I;
    private Interpolator J;
    private int f;
    private int g;
    private View h;
    private View i;
    private View j;
    private int k;
    private float l;
    private float m;
    private volatile int n;
    private int o;
    private int p;
    private boolean q;
    private Rect r;
    private Drawable s;
    private Drawable t;
    private float u;
    private float v;
    private int w;
    private boolean x;
    private int y;
    private boolean z;

    public SlideMenu(Context context)
    {
        this(context, null);
    }

    public SlideMenu(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010002);
    }

    public SlideMenu(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        y = 2;
        z = true;
        k = ViewConfiguration.get(context).getScaledTouchSlop();
        H = VelocityTracker.obtain();
        r = new Rect();
        B = new Rect();
        b = (int)getStatusBarHeight(context);
        setWillNotDraw(false);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.SlideMenu, i1, 0);
        setPrimaryShadowWidth(typedarray.getDimension(0, 30F));
        setSecondaryShadowWidth(typedarray.getDimension(1, 30F));
        Object obj = typedarray.getDrawable(2);
        if (obj == null)
        {
            android.graphics.drawable.GradientDrawable.Orientation orientation1 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;
            int ai1[] = new int[2];
            ai1[0] = 0;
            ai1[1] = Color.argb(99, 0, 0, 0);
            obj = new GradientDrawable(orientation1, ai1);
        }
        setPrimaryShadowDrawable(((Drawable) (obj)));
        Object obj1 = typedarray.getDrawable(3);
        if (obj1 == null)
        {
            android.graphics.drawable.GradientDrawable.Orientation orientation = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;
            int ai[] = new int[2];
            ai[0] = Color.argb(99, 0, 0, 0);
            ai[1] = 0;
            obj1 = new GradientDrawable(orientation, ai);
        }
        setSecondaryShadowDrawable(((Drawable) (obj1)));
        int j1 = typedarray.getResourceId(7, -1);
        Interpolator interpolator;
        if (-1 == j1)
        {
            interpolator = DEFAULT_INTERPOLATOR;
        } else
        {
            interpolator = AnimationUtils.loadInterpolator(context, j1);
        }
        setInterpolator(interpolator);
        w = typedarray.getInt(6, 3);
        setEdgeSlideEnable(typedarray.getBoolean(4, false));
        setEdgetSlideWidth(typedarray.getDimensionPixelSize(5, 100));
        typedarray.recycle();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a()
    {
        int i1;
        if (n < 0)
        {
            i1 = -1;
        } else
        if (n == 0)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        f = i1;
        switch (f)
        {
        default:
            return;

        case -1: 
            a(i, 4);
            a(j, 0);
            return;

        case 0: // '\0'
            a(i, 4);
            a(j, 4);
            return;

        case 1: // '\001'
            a(i, 0);
            break;
        }
        a(j, 4);
    }

    private void a(int i1)
    {
        int j2;
        float f1;
        int j1 = w;
        int k1;
        int l1;
        int i2;
        if ((j1 & 2) == 2)
        {
            k1 = p;
        } else
        {
            k1 = 0;
        }
        l1 = j1 & 1;
        i2 = 0;
        if (l1 == 1)
        {
            i2 = o;
        }
        j2 = Math.min(k1, Math.max(i1, i2));
        n = j2;
        if (F == null) goto _L2; else goto _L1
_L1:
        if (j2 <= 0) goto _L4; else goto _L3
_L3:
        f1 = (1.0F * (float)j2) / (float)p;
_L6:
        F.onSlideOffsetChange(f1);
_L2:
        a();
        invalidate();
        requestLayout();
        return;
_L4:
        f1 = 0.0F;
        if (j2 < 0)
        {
            f1 = (1.0F * (float)(-j2)) / (float)o;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(Canvas canvas)
    {
        if (h != null)
        {
            int i1 = h.getLeft();
            int j1 = D;
            int k1 = E;
            if (s != null)
            {
                s.setBounds((int)((float)i1 - u), 0, i1, k1);
                s.draw(canvas);
            }
            if (t != null)
            {
                t.setBounds(i1 + j1, 0, (int)((float)(i1 + j1) + v), k1);
                t.draw(canvas);
                return;
            }
        }
    }

    private void a(View view, int i1)
    {
        if (view != null && view.getVisibility() != i1)
        {
            view.setVisibility(i1);
        }
    }

    private boolean a(float f1, float f2)
    {
        View view = h;
        if (view != null)
        {
            view.getHitRect(r);
            return r.contains((int)f1, (int)f2);
        } else
        {
            return false;
        }
    }

    private boolean b()
    {
        View view = (View)getParent();
        return view != null && 0x1020002 == view.getId() && 2 == y && getRootView() == view && 1 == y;
    }

    private boolean b(float f1, float f2)
    {
        Rect rect = B;
        View view = i;
        boolean flag = false;
        if (view != null)
        {
            getHitRect(rect);
            rect.right = A;
            flag = false | rect.contains((int)f1, (int)f2);
        }
        if (j != null)
        {
            getHitRect(rect);
            rect.left = rect.right - A;
            flag |= rect.contains((int)f1, (int)f2);
        }
        return flag;
    }

    public static float getStatusBarHeight(Context context)
    {
        Resources resources = context.getResources();
        int i1 = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (i1 != 0)
        {
            return resources.getDimension(i1);
        } else
        {
            return 0.0F;
        }
    }

    public static void removeViewFromParent(View view)
    {
        ViewGroup viewgroup;
        if (view != null)
        {
            if ((viewgroup = (ViewGroup)view.getParent()) != null)
            {
                viewgroup.removeView(view);
                return;
            }
        }
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (!(layoutparams instanceof LayoutParams))
        {
            throw new IllegalArgumentException("The parameter params must a instance of com.aretha.slidemenu.SlideMenu$LayoutParams");
        }
        if (layoutparams == null)
        {
            return;
        }
        ((LayoutParams)layoutparams).role;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 57
    //                   1 82
    //                   2 98;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        removeView(h);
        h = view;
_L6:
        a();
        super.addView(view, i1, layoutparams);
        return;
_L3:
        removeView(i);
        i = view;
        continue; /* Loop/switch isn't completed */
_L4:
        removeView(j);
        j = view;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final boolean canScroll(View view, int i1, int j1, int k1)
    {
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int l1 = view.getScrollX();
            int i2 = view.getScrollY();
            int j2 = viewgroup.getChildCount();
            for (int k2 = 0; k2 < j2; k2++)
            {
                View view1 = viewgroup.getChildAt(k2);
                int l2 = view1.getLeft();
                int i3 = view1.getTop();
                if (j1 + l1 >= l2 && j1 + l1 < view1.getRight() && k1 + i2 >= i3 && k1 + i2 < view1.getBottom() && view1.getVisibility() == 0 && (ScrollDetectors.canScrollHorizontal(view1, i1) || canScroll(view1, i1, (j1 + l1) - l2, (k1 + i2) - i3)))
                {
                    return true;
                }
            }

        }
        return ViewCompat.canScrollHorizontally(view, -i1);
    }

    public void close(boolean flag)
    {
        if (1 == g)
        {
            return;
        }
        if (flag)
        {
            smoothScrollContentTo(0);
            return;
        } else
        {
            I.abortAnimation();
            a(0);
            setCurrentState(1);
            return;
        }
    }

    public void computeScroll()
    {
label0:
        {
            if (16 == g || isOpen())
            {
                if (!I.computeScrollOffset())
                {
                    break label0;
                }
                a(I.getCurrX());
            }
            return;
        }
        int i1;
        if (n == 0)
        {
            i1 = 1;
        } else
        if (n > 0)
        {
            i1 = 2;
        } else
        {
            i1 = 4;
        }
        setCurrentState(i1);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (1 != keyevent.getAction()) goto _L2; else goto _L1
_L1:
        boolean flag = isOpen();
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 52
    //                   4: 58
    //                   21: 69
    //                   22: 96;
           goto _L2 _L3 _L4 _L5
_L2:
        return super.dispatchKeyEvent(keyevent);
_L3:
        if (flag)
        {
            close(true);
            return true;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (2 == g)
        {
            close(true);
            return true;
        }
        if (!flag)
        {
            open(true, true);
            return true;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (4 == g)
        {
            close(true);
            return true;
        }
        if (!flag)
        {
            open(false, true);
            return true;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void drag(float f1, float f2)
    {
        n = n + (int)(f2 - f1);
        a(n);
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        a(canvas);
    }

    protected void endDrag(float f1, float f2)
    {
        boolean flag;
        n;
        int i1 = f;
        if (Math.abs(f2) > 400F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1;
        JVM INSTR tableswitch -1 1: default 52
    //                   -1 59
    //                   0 120
    //                   1 126;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (f2 < 0.0F && flag || f2 >= 0.0F && !flag)
        {
            smoothScrollContentTo(o, f2);
            return;
        }
        if (f2 > 0.0F && flag || f2 <= 0.0F && !flag)
        {
            smoothScrollContentTo(0, f2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        setCurrentState(1);
        return;
_L4:
        if (f2 > 0.0F && flag || f2 <= 0.0F && !flag)
        {
            smoothScrollContentTo(p, f2);
            return;
        }
        if (f2 < 0.0F && flag || f2 >= 0.0F && !flag)
        {
            smoothScrollContentTo(0, f2);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    public int getCurrentState()
    {
        return g;
    }

    protected Drawable getDefaultContentBackground(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(0x1010054, typedvalue, true);
        return context.getResources().getDrawable(typedvalue.resourceId);
    }

    public float getEdgeSlideWidth()
    {
        return (float)A;
    }

    public Interpolator getInterpolator()
    {
        return J;
    }

    public OnContentTapListener getOnContentTapListener()
    {
        return G;
    }

    public OnSlideStateChangeListener getOnSlideStateChangeListener()
    {
        return F;
    }

    public View getPrimaryMenu()
    {
        return i;
    }

    public Drawable getPrimaryShadowDrawable()
    {
        return s;
    }

    public float getPrimaryShadowWidth()
    {
        return u;
    }

    public View getSecondaryMenu()
    {
        return j;
    }

    public Drawable getSecondaryShadowDrawable()
    {
        return t;
    }

    public float getSecondaryShadowWidth()
    {
        return v;
    }

    public int getSlideDirection()
    {
        return w;
    }

    public int getSlideMode()
    {
        return y;
    }

    public boolean isEdgeSlideEnable()
    {
        return z;
    }

    public boolean isOpen()
    {
        return (6 & g) != 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        float f1;
        float f2;
        int i1;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        i1 = g;
        if (8 != i1 && 16 != i1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 64
    //                   0 66
    //                   1 64
    //                   2 112;
           goto _L3 _L4 _L3 _L5
_L3:
        return false;
_L4:
        m = f1;
        l = f1;
        q = a(f1, f2);
        C = b(f1, f2);
        if (!isOpen() || !q)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        float f3;
        f3 = f1 - l;
        if (z && !C && g == 1)
        {
            return false;
        }
        if (Math.abs(f3) < (float)k || !q || canScroll(this, (int)f3, (int)f1, (int)f2)) goto _L3; else goto _L6
_L6:
        setCurrentState(8);
        return true;
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int j2;
        int k2;
        int l2;
        int i3;
        View view;
        int k3;
        int l3;
        int i2 = getChildCount();
        j2 = getPaddingLeft();
        k2 = getPaddingRight();
        l2 = getPaddingTop();
        int j3;
        if (y == 1)
        {
            i3 = b;
        } else
        {
            i3 = 0;
        }
        j3 = 0;
        if (j3 >= i2)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        view = getChildAt(j3);
        k3 = view.getMeasuredWidth();
        l3 = view.getMeasuredHeight();
        switch (((LayoutParams)view.getLayoutParams()).role)
        {
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            p = k3;
            view.layout(j2, i3 + l2, k3 + j2, l3 + (i3 + l2));
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_191;
_L4:
        j3++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_40;
_L1:
        view.bringToFront();
        view.layout(j2 + n, l2, k3 + j2 + n, l3 + l2);
        continue; /* Loop/switch isn't completed */
        o = -k3;
        view.layout(k1 - k2 - k3, i3 + l2, k1 - k2, l3 + (i3 + l2));
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        k1 = getChildCount();
        l1 = y;
        i2 = b;
        j2 = 0;
        k2 = 0;
        l2 = 0;
_L2:
        View view;
        if (j2 >= k1)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        view = getChildAt(j2);
        switch (((LayoutParams)view.getLayoutParams()).role)
        {
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_117;
_L3:
        l2 = Math.max(l2, view.getMeasuredWidth());
        k2 = Math.max(k2, view.getMeasuredHeight());
        j2++;
        if (true) goto _L2; else goto _L1
_L1:
        measureChild(view, i1, j1);
          goto _L3
        int k3;
        if (l1 == 1)
        {
            k3 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(j1) - i2, android.view.View.MeasureSpec.getMode(j1));
        } else
        {
            k3 = j1;
        }
        measureChild(view, i1, k3);
          goto _L3
        int i3 = l2 + (getPaddingLeft() + getPaddingRight());
        int j3 = k2 + (getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(resolveSize(i3, i1), resolveSize(j3, j1));
        return;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        u = savedstate.primaryShadowWidth;
        v = savedstate.secondaryShadaryWidth;
        w = savedstate.slideDirectionFlag;
        setSlideMode(savedstate.slideMode);
        g = savedstate.currentState;
        n = savedstate.currentContentOffset;
        a();
        requestLayout();
        invalidate();
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.primaryShadowWidth = u;
        savedstate.secondaryShadaryWidth = v;
        savedstate.slideDirectionFlag = w;
        savedstate.slideMode = y;
        savedstate.currentState = g;
        savedstate.currentContentOffset = n;
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        D = i1;
        E = j1;
        if (x)
        {
            resolveSlideMode();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1;
        float f2;
        int i1;
        int j1;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        i1 = g;
        j1 = motionevent.getAction();
        j1;
        JVM INSTR tableswitch 0 4: default 60
    //                   0 66
    //                   1 229
    //                   2 113
    //                   3 229
    //                   4 229;
           goto _L1 _L2 _L3 _L4 _L3 _L3
_L1:
        boolean flag = true;
_L6:
        return flag;
_L2:
        m = f1;
        l = f1;
        q = a(f1, f2);
        C = b(f1, f2);
        if (q)
        {
            I.abortAnimation();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int k1;
        H.addMovement(motionevent);
        if (!z || C)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = g;
        flag = false;
        if (k1 == 1) goto _L6; else goto _L5
_L5:
        if (Math.abs(f1 - l) >= (float)k && q && i1 != 8)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setCurrentState(8);
        }
        if (8 != i1)
        {
            m = f1;
            return false;
        }
        drag(m, f1);
        m = f1;
        continue; /* Loop/switch isn't completed */
_L3:
        if (8 != i1)
        {
            break; /* Loop/switch isn't completed */
        }
        H.computeCurrentVelocity(1000);
        endDrag(f1, H.getXVelocity());
_L9:
        H.clear();
        getParent().requestDisallowInterceptTouchEvent(false);
        C = false;
        q = false;
        if (true) goto _L1; else goto _L7
_L7:
        if (!q || 1 != j1) goto _L9; else goto _L8
_L8:
        performContentTap();
          goto _L9
    }

    public void open(boolean flag, boolean flag1)
    {
        if (isOpen())
        {
            return;
        }
        int i1;
        if (flag)
        {
            i1 = o;
        } else
        {
            i1 = p;
        }
        if (flag1)
        {
            smoothScrollContentTo(i1);
            return;
        }
        I.abortAnimation();
        a(i1);
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 4;
        }
        setCurrentState(byte0);
    }

    public void performContentTap()
    {
        if (isOpen())
        {
            smoothScrollContentTo(0);
        } else
        if (G != null)
        {
            G.onContentTap(this);
            return;
        }
    }

    protected void resolveSlideMode()
    {
        ViewGroup viewgroup = (ViewGroup)getRootView();
        ViewGroup viewgroup1 = (ViewGroup)viewgroup.findViewById(0x1020002);
        View view = h;
        if (viewgroup == null || view == null || getChildCount() == 0)
        {
            return;
        }
        TypedValue typedvalue = new TypedValue();
        getContext().getTheme().resolveAttribute(0x1010054, typedvalue, true);
        switch (y)
        {
        default:
            return;

        case 1: // '\001'
            removeViewFromParent(this);
            LayoutParams layoutparams1 = new LayoutParams(view.getLayoutParams());
            removeViewFromParent(view);
            viewgroup1.addView(view);
            View view3 = viewgroup.getChildAt(0);
            view3.setBackgroundResource(0);
            removeViewFromParent(view3);
            addView(view3, layoutparams1);
            viewgroup.addView(this);
            setBackgroundResource(typedvalue.resourceId);
            return;

        case 2: // '\002'
            setBackgroundResource(0);
            break;
        }
        removeViewFromParent(this);
        View view1 = viewgroup1.getChildAt(0);
        View view2 = h;
        LayoutParams layoutparams = (LayoutParams)view2.getLayoutParams();
        removeViewFromParent(view1);
        removeViewFromParent(view2);
        view2.setBackgroundResource(typedvalue.resourceId);
        viewgroup.addView(view2);
        viewgroup1.addView(this);
        addView(view1, layoutparams);
    }

    protected void setCurrentState(int i1)
    {
        if (F != null && i1 != g)
        {
            F.onSlideStateChange(i1);
        }
        g = i1;
    }

    public void setEdgeSlideEnable(boolean flag)
    {
        z = flag;
    }

    public void setEdgetSlideWidth(int i1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException("Edge slide width must above 0");
        } else
        {
            A = i1;
            return;
        }
    }

    public void setInterpolator(Interpolator interpolator)
    {
        J = interpolator;
        I = new Scroller(getContext(), interpolator);
    }

    public void setOnContentTapListener(OnContentTapListener oncontenttaplistener)
    {
        G = oncontenttaplistener;
    }

    public void setOnSlideStateChangeListener(OnSlideStateChangeListener onslidestatechangelistener)
    {
        F = onslidestatechangelistener;
    }

    public void setPrimaryShadowDrawable(Drawable drawable)
    {
        s = drawable;
    }

    public void setPrimaryShadowWidth(float f1)
    {
        u = f1;
        invalidate();
    }

    public void setSecondaryShadowDrawable(Drawable drawable)
    {
        t = drawable;
    }

    public void setSecondaryShadowWidth(float f1)
    {
        v = f1;
        invalidate();
    }

    public void setSlideDirection(int i1)
    {
        w = i1;
    }

    public void setSlideMode(int i1)
    {
        if (b())
        {
            throw new IllegalStateException("SlidingMenu must be the root of layout");
        }
        if (y == i1)
        {
            return;
        }
        y = i1;
        if (getChildCount() == 0)
        {
            x = true;
            return;
        } else
        {
            resolveSlideMode();
            return;
        }
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public void smoothScrollContentTo(int i1)
    {
        smoothScrollContentTo(i1, 0.0F);
    }

    public void smoothScrollContentTo(int i1, float f1)
    {
        setCurrentState(16);
        int j1 = i1 - n;
        float f2 = Math.abs(f1);
        int k1 = 400;
        if (f2 > 0.0F)
        {
            k1 = 3 * Math.round(1000F * Math.abs((float)j1 / f2));
        }
        int l1 = Math.min(k1, 500);
        I.abortAnimation();
        I.startScroll(n, 0, j1, 0, l1);
        invalidate();
    }


    private class OnSlideStateChangeListener
    {

        public abstract void onSlideOffsetChange(float f1);

        public abstract void onSlideStateChange(int i1);
    }


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        public static final int ROLE_CONTENT = 0;
        public static final int ROLE_PRIMARY_MENU = 1;
        public static final int ROLE_SECONDARY_MENU = 2;
        public int role;

        public LayoutParams(int i1, int j1)
        {
            super(i1, j1);
        }

        public LayoutParams(int i1, int j1, int k1)
        {
            super(i1, j1);
            role = k1;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            TypedArray typedarray;
            int i1;
            int j1;
            super(context, attributeset);
            typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.SlideMenu_Layout, 0, 0);
            i1 = typedarray.getIndexCount();
            j1 = 0;
_L6:
            if (j1 >= i1) goto _L2; else goto _L1
_L1:
            typedarray.getIndex(j1);
            JVM INSTR tableswitch 0 0: default 56
        //                       0 62;
               goto _L3 _L4
_L3:
            j1++;
            continue; /* Loop/switch isn't completed */
_L4:
            role = typedarray.getInt(0, -1);
            if (true) goto _L3; else goto _L2
_L2:
            switch (role)
            {
            default:
                throw new IllegalArgumentException("You must specified a layout_role for this view");

            case 0: // '\0'
                width = -1;
                height = -1;
                // fall through

            case 1: // '\001'
            case 2: // '\002'
                typedarray.recycle();
                break;
            }
            break; /* Loop/switch isn't completed */
            if (true) goto _L6; else goto _L5
_L5:
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            if (layoutparams instanceof LayoutParams)
            {
                role = ((LayoutParams)layoutparams).role;
            }
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new B();
        public int currentContentOffset;
        public int currentState;
        public float primaryShadowWidth;
        public float secondaryShadaryWidth;
        public int slideDirectionFlag;
        public int slideMode;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeFloat(primaryShadowWidth);
            parcel.writeFloat(secondaryShadaryWidth);
            parcel.writeInt(slideDirectionFlag);
            parcel.writeInt(slideMode);
            parcel.writeInt(currentState);
            parcel.writeInt(currentContentOffset);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            primaryShadowWidth = parcel.readFloat();
            secondaryShadaryWidth = parcel.readFloat();
            slideDirectionFlag = parcel.readInt();
            slideMode = parcel.readInt();
            currentState = parcel.readInt();
            currentContentOffset = parcel.readInt();
        }

        SavedState(Parcel parcel, A a1)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private class OnContentTapListener
    {

        public abstract void onContentTap(SlideMenu slidemenu);
    }

}
