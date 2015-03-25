// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            ay, az, aH, aC, 
//            aA, PagerAdapter, MotionEventCompat, ViewCompat, 
//            ViewConfigurationCompat, aD, aB, VelocityTrackerCompat, 
//            KeyEventCompat, aF, aE

public class ViewPager extends ViewGroup
{

    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final int T = -1;
    private static final String a = "ViewPager";
    private static final int ab = 2;
    private static final int ap = 0;
    private static final int aq = 1;
    private static final int ar = 2;
    private static final aH au = new aH();
    private static final boolean b = false;
    private static final boolean c = false;
    private static final int d = 1;
    private static final int e = 600;
    private static final int f = 25;
    private static final int g = 16;
    private static final int h = 400;
    private static final int i[] = {
        0x10100b3
    };
    private static final Comparator k = new ay();
    private static final Interpolator l = new az();
    private float A;
    private float B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private VelocityTracker U;
    private int V;
    private int W;
    private int Z;
    private int aa;
    private boolean ac;
    private long ad;
    private EdgeEffectCompat ae;
    private EdgeEffectCompat af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private int aj;
    private OnPageChangeListener ak;
    private OnPageChangeListener al;
    private aE am;
    private PageTransformer an;
    private Method ao;
    private int as;
    private ArrayList at;
    private final Runnable av;
    private int aw;
    private int j;
    private final ArrayList m;
    private final aC n;
    private final Rect o;
    private PagerAdapter p;
    private int q;
    private int r;
    private Parcelable s;
    private ClassLoader t;
    private Scroller u;
    private aF v;
    private int w;
    private Drawable x;
    private int y;
    private int z;

    public ViewPager(Context context)
    {
        super(context);
        m = new ArrayList();
        n = new aC();
        o = new Rect();
        r = -1;
        s = null;
        t = null;
        A = -3.402823E+38F;
        B = 3.402823E+38F;
        H = 1;
        S = -1;
        ag = true;
        ah = false;
        av = new aA(this);
        aw = 0;
        a();
    }

    public ViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m = new ArrayList();
        n = new aC();
        o = new Rect();
        r = -1;
        s = null;
        t = null;
        A = -3.402823E+38F;
        B = 3.402823E+38F;
        H = 1;
        S = -1;
        ag = true;
        ah = false;
        av = new aA(this);
        aw = 0;
        a();
    }

    private int a(int i1, float f1, int j1, int k1)
    {
        if (Math.abs(k1) > Z && Math.abs(j1) > V)
        {
            if (j1 <= 0)
            {
                i1++;
            }
        } else
        {
            float f2;
            if (i1 >= q)
            {
                f2 = 0.4F;
            } else
            {
                f2 = 0.6F;
            }
            i1 = (int)(f2 + (f1 + (float)i1));
        }
        if (m.size() > 0)
        {
            aC ac1 = (aC)m.get(0);
            aC ac2 = (aC)m.get(-1 + m.size());
            i1 = Math.max(ac1.b, Math.min(i1, ac2.b));
        }
        return i1;
    }

    private Rect a(Rect rect, View view)
    {
        Rect rect1;
        if (rect == null)
        {
            rect1 = new Rect();
        } else
        {
            rect1 = rect;
        }
        if (view == null)
        {
            rect1.set(0, 0, 0, 0);
            return rect1;
        }
        rect1.left = view.getLeft();
        rect1.right = view.getRight();
        rect1.top = view.getTop();
        rect1.bottom = view.getBottom();
        ViewGroup viewgroup;
        for (ViewParent viewparent = view.getParent(); (viewparent instanceof ViewGroup) && viewparent != this; viewparent = viewgroup.getParent())
        {
            viewgroup = (ViewGroup)viewparent;
            rect1.left = rect1.left + viewgroup.getLeft();
            rect1.right = rect1.right + viewgroup.getRight();
            rect1.top = rect1.top + viewgroup.getTop();
            rect1.bottom = rect1.bottom + viewgroup.getBottom();
        }

        return rect1;
    }

    static PagerAdapter a(ViewPager viewpager)
    {
        return viewpager.p;
    }

    private void a(int i1, int j1, int k1, int l1)
    {
        if (j1 > 0 && !m.isEmpty())
        {
            int j2 = k1 + (i1 - getPaddingLeft() - getPaddingRight());
            int k2 = l1 + (j1 - getPaddingLeft() - getPaddingRight());
            int l2 = (int)(((float)getScrollX() / (float)k2) * (float)j2);
            scrollTo(l2, getScrollY());
            if (!u.isFinished())
            {
                int i3 = u.getDuration() - u.timePassed();
                aC ac2 = b(q);
                u.startScroll(l2, 0, (int)(ac2.e * (float)i1), 0, i3);
            }
        } else
        {
            aC ac1 = b(q);
            float f1;
            int i2;
            if (ac1 != null)
            {
                f1 = Math.min(ac1.e, B);
            } else
            {
                f1 = 0.0F;
            }
            i2 = (int)(f1 * (float)(i1 - getPaddingLeft() - getPaddingRight()));
            if (i2 != getScrollX())
            {
                b(false);
                scrollTo(i2, getScrollY());
                return;
            }
        }
    }

    private void a(int i1, boolean flag, int j1, boolean flag1)
    {
        aC ac1 = b(i1);
        int k1;
        if (ac1 != null)
        {
            k1 = (int)((float)h() * Math.max(A, Math.min(ac1.e, B)));
        } else
        {
            k1 = 0;
        }
        if (flag)
        {
            a(k1, 0, j1);
            if (flag1 && ak != null)
            {
                ak.onPageSelected(i1);
            }
            if (flag1 && al != null)
            {
                al.onPageSelected(i1);
            }
            return;
        }
        if (flag1 && ak != null)
        {
            ak.onPageSelected(i1);
        }
        if (flag1 && al != null)
        {
            al.onPageSelected(i1);
        }
        b(false);
        scrollTo(k1, 0);
        d(k1);
    }

    static void a(ViewPager viewpager, int i1)
    {
        viewpager.c(i1);
    }

    private void a(aC ac1, int i1, aC ac2)
    {
        int j1 = p.getCount();
        int k1 = h();
        float f1;
        if (k1 > 0)
        {
            f1 = (float)w / (float)k1;
        } else
        {
            f1 = 0.0F;
        }
        if (ac2 != null)
        {
            int i4 = ac2.b;
            if (i4 < ac1.b)
            {
                float f9 = f1 + (ac2.e + ac2.d);
                int l4 = i4 + 1;
                for (int i5 = 0; l4 <= ac1.b && i5 < m.size(); l4++)
                {
                    aC ac6;
                    for (ac6 = (aC)m.get(i5); l4 > ac6.b && i5 < -1 + m.size(); ac6 = (aC)m.get(i5))
                    {
                        i5++;
                    }

                    for (; l4 < ac6.b; l4++)
                    {
                        f9 += f1 + p.getPageWidth(l4);
                    }

                    ac6.e = f9;
                    f9 += f1 + ac6.d;
                }

            } else
            if (i4 > ac1.b)
            {
                int j4 = -1 + m.size();
                float f8 = ac2.e;
                for (int k4 = i4 - 1; k4 >= ac1.b && j4 >= 0; k4--)
                {
                    aC ac5;
                    for (ac5 = (aC)m.get(j4); k4 < ac5.b && j4 > 0; ac5 = (aC)m.get(j4))
                    {
                        j4--;
                    }

                    for (; k4 > ac5.b; k4--)
                    {
                        f8 -= f1 + p.getPageWidth(k4);
                    }

                    f8 -= f1 + ac5.d;
                    ac5.e = f8;
                }

            }
        }
        int l1 = m.size();
        float f2 = ac1.e;
        int i2 = -1 + ac1.b;
        float f3;
        float f4;
        if (ac1.b == 0)
        {
            f3 = ac1.e;
        } else
        {
            f3 = -3.402823E+38F;
        }
        A = f3;
        if (ac1.b == j1 - 1)
        {
            f4 = (ac1.e + ac1.d) - 1.0F;
        } else
        {
            f4 = 3.402823E+38F;
        }
        B = f4;
        int k3;
        for (int j2 = i1 - 1; j2 >= 0; j2 = k3)
        {
            aC ac4 = (aC)m.get(j2);
            float f7 = f2;
            int l3;
            for (; i2 > ac4.b; i2 = l3)
            {
                PagerAdapter pageradapter1 = p;
                l3 = i2 - 1;
                f7 -= f1 + pageradapter1.getPageWidth(i2);
            }

            f2 = f7 - (f1 + ac4.d);
            ac4.e = f2;
            if (ac4.b == 0)
            {
                A = f2;
            }
            k3 = j2 - 1;
            i2--;
        }

        float f5 = f1 + (ac1.e + ac1.d);
        int k2 = 1 + ac1.b;
        int i3;
        for (int l2 = i1 + 1; l2 < l1; l2 = i3)
        {
            aC ac3 = (aC)m.get(l2);
            float f6 = f5;
            int j3;
            for (; k2 < ac3.b; k2 = j3)
            {
                PagerAdapter pageradapter = p;
                j3 = k2 + 1;
                f6 += f1 + pageradapter.getPageWidth(k2);
            }

            if (ac3.b == j1 - 1)
            {
                B = (f6 + ac3.d) - 1.0F;
            }
            ac3.e = f6;
            f5 = f6 + (f1 + ac3.d);
            i3 = l2 + 1;
            k2++;
        }

        ah = false;
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i1) == S)
        {
            int j1;
            if (i1 == 0)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            O = MotionEventCompat.getX(motionevent, j1);
            S = MotionEventCompat.getPointerId(motionevent, j1);
            if (U != null)
            {
                U.clear();
            }
        }
    }

    private boolean a(float f1, float f2)
    {
        return f1 < (float)M && f2 > 0.0F || f1 > (float)(getWidth() - M) && f2 < 0.0F;
    }

    static int b(ViewPager viewpager)
    {
        return viewpager.q;
    }

    private void b(boolean flag)
    {
label0:
        {
            boolean flag1;
            int i1;
            boolean flag2;
            if (aw == 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                d(false);
                u.abortAnimation();
                int j1 = getScrollX();
                int k1 = getScrollY();
                int l1 = u.getCurrX();
                int i2 = u.getCurrY();
                if (j1 != l1 || k1 != i2)
                {
                    scrollTo(l1, i2);
                }
            }
            G = false;
            i1 = 0;
            flag2 = flag1;
            for (; i1 < m.size(); i1++)
            {
                aC ac1 = (aC)m.get(i1);
                if (ac1.c)
                {
                    ac1.c = false;
                    flag2 = true;
                }
            }

            if (flag2)
            {
                if (!flag)
                {
                    break label0;
                }
                ViewCompat.postOnAnimation(this, av);
            }
            return;
        }
        av.run();
    }

    private boolean b(float f1)
    {
        boolean flag = true;
        float f2 = O - f1;
        O = f1;
        float f3 = f2 + (float)getScrollX();
        int i1 = h();
        float f4 = (float)i1 * A;
        float f5 = (float)i1 * B;
        aC ac1 = (aC)m.get(0);
        aC ac2 = (aC)m.get(-1 + m.size());
        boolean flag1;
        float f6;
        boolean flag2;
        if (ac1.b != 0)
        {
            f4 = ac1.e * (float)i1;
            flag1 = false;
        } else
        {
            flag1 = flag;
        }
        if (ac2.b != -1 + p.getCount())
        {
            f6 = ac2.e * (float)i1;
            flag = false;
        } else
        {
            f6 = f5;
        }
        if (f3 < f4)
        {
            flag2 = false;
            if (flag1)
            {
                float f7 = f4 - f3;
                flag2 = ae.onPull(Math.abs(f7) / (float)i1);
            }
        } else
        if (f3 > f6)
        {
            flag2 = false;
            if (flag)
            {
                float f8 = f3 - f6;
                flag2 = af.onPull(Math.abs(f8) / (float)i1);
            }
            f4 = f6;
        } else
        {
            f4 = f3;
            flag2 = false;
        }
        O = O + (f4 - (float)(int)f4);
        scrollTo((int)f4, getScrollY());
        d((int)f4);
        return flag2;
    }

    private void c(int i1)
    {
        if (aw != i1)
        {
            aw = i1;
            if (an != null)
            {
                boolean flag;
                if (i1 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                c(flag);
            }
            if (ak != null)
            {
                ak.onPageScrollStateChanged(i1);
                return;
            }
        }
    }

    private void c(boolean flag)
    {
        int i1 = getChildCount();
        int j1 = 0;
        while (j1 < i1) 
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            ViewCompat.setLayerType(getChildAt(j1), byte0, null);
            j1++;
        }
    }

    private void d(boolean flag)
    {
        if (F != flag)
        {
            F = flag;
        }
    }

    private boolean d(int i1)
    {
        boolean flag;
        if (m.size() == 0)
        {
            ai = false;
            onPageScrolled(0, 0.0F, 0);
            boolean flag1 = ai;
            flag = false;
            if (!flag1)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            aC ac1 = j();
            int j1 = h();
            int k1 = j1 + w;
            float f1 = (float)w / (float)j1;
            int l1 = ac1.b;
            float f2 = ((float)i1 / (float)j1 - ac1.e) / (f1 + ac1.d);
            int i2 = (int)(f2 * (float)k1);
            ai = false;
            onPageScrolled(l1, f2, i2);
            if (!ai)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
    }

    static int[] f()
    {
        return i;
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

    private int h()
    {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private void i()
    {
        if (as != 0)
        {
            int i1;
            if (at == null)
            {
                at = new ArrayList();
            } else
            {
                at.clear();
            }
            i1 = getChildCount();
            for (int j1 = 0; j1 < i1; j1++)
            {
                View view = getChildAt(j1);
                at.add(view);
            }

            Collections.sort(at, au);
        }
    }

    private aC j()
    {
        int i1 = h();
        float f1;
        float f2;
        float f3;
        float f4;
        int j1;
        int k1;
        boolean flag;
        aC ac1;
        if (i1 > 0)
        {
            f1 = (float)getScrollX() / (float)i1;
        } else
        {
            f1 = 0.0F;
        }
        if (i1 > 0)
        {
            f2 = (float)w / (float)i1;
        } else
        {
            f2 = 0.0F;
        }
        f3 = 0.0F;
        f4 = 0.0F;
        j1 = -1;
        k1 = 0;
        flag = true;
        ac1 = null;
        do
        {
label0:
            {
                if (k1 < m.size())
                {
                    aC ac2 = (aC)m.get(k1);
                    int l1;
                    aC ac3;
                    float f5;
                    float f6;
                    int i2;
                    float f7;
                    int j2;
                    if (!flag && ac2.b != j1 + 1)
                    {
                        aC ac4 = n;
                        ac4.e = f2 + (f3 + f4);
                        ac4.b = j1 + 1;
                        ac4.d = p.getPageWidth(ac4.b);
                        l1 = k1 - 1;
                        ac3 = ac4;
                    } else
                    {
                        l1 = k1;
                        ac3 = ac2;
                    }
                    f5 = ac3.e;
                    f6 = f2 + (f5 + ac3.d);
                    if (flag || f1 >= f5)
                    {
                        if (f1 >= f6 && l1 != -1 + m.size())
                        {
                            break label0;
                        }
                        ac1 = ac3;
                    }
                }
                return ac1;
            }
            i2 = ac3.b;
            f7 = ac3.d;
            j2 = l1 + 1;
            f4 = f5;
            j1 = i2;
            f3 = f7;
            ac1 = ac3;
            k1 = j2;
            flag = false;
        } while (true);
    }

    private void k()
    {
        I = false;
        J = false;
        if (U != null)
        {
            U.recycle();
            U = null;
        }
    }

    float a(float f1)
    {
        return (float)Math.sin((float)(0.4712389167638204D * (double)(f1 - 0.5F)));
    }

    OnPageChangeListener a(OnPageChangeListener onpagechangelistener)
    {
        OnPageChangeListener onpagechangelistener1 = al;
        al = onpagechangelistener;
        return onpagechangelistener1;
    }

    aC a(View view)
    {
        for (int i1 = 0; i1 < m.size(); i1++)
        {
            aC ac1 = (aC)m.get(i1);
            if (p.isViewFromObject(view, ac1.a))
            {
                return ac1;
            }
        }

        return null;
    }

    void a()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        u = new Scroller(context, l);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f1 = context.getResources().getDisplayMetrics().density;
        N = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
        V = (int)(400F * f1);
        W = viewconfiguration.getScaledMaximumFlingVelocity();
        ae = new EdgeEffectCompat(context);
        af = new EdgeEffectCompat(context);
        Z = (int)(25F * f1);
        aa = (int)(2.0F * f1);
        L = (int)(16F * f1);
        ViewCompat.setAccessibilityDelegate(this, new aD(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    void a(int i1)
    {
        byte byte0;
        aC ac1;
        int k1;
        int l1;
        int i2;
        int j2;
        aC ac2;
        aC ac3;
        aC ac7;
        int l3;
        float f2;
        int j4;
        int k4;
        int l4;
        float f3;
        aC ac9;
        int k5;
        int l5;
        aC ac12;
        float f6;
        android.content.res.Resources.NotFoundException notfoundexception;
        String s1;
        String s2;
        if (q != i1)
        {
            byte byte1;
            aC ac15;
            if (q < i1)
            {
                byte1 = 66;
            } else
            {
                byte1 = 17;
            }
            ac15 = b(q);
            q = i1;
            ac1 = ac15;
            byte0 = byte1;
        } else
        {
            byte0 = 2;
            ac1 = null;
        }
        if (p != null) goto _L2; else goto _L1
_L1:
        i();
_L4:
        return;
_L2:
        if (G)
        {
            i();
            return;
        }
        if (getWindowToken() == null) goto _L4; else goto _L3
_L3:
        p.startUpdate(this);
        int j1 = H;
        k1 = Math.max(0, q - j1);
        l1 = p.getCount();
        i2 = Math.min(l1 - 1, j1 + q);
        if (l1 == j) goto _L6; else goto _L5
_L5:
        s2 = getResources().getResourceName(getId());
        s1 = s2;
_L7:
        throw new IllegalStateException((new StringBuilder()).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ").append(j).append(", found: ").append(l1).append(" Pager id: ").append(s1).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(p.getClass()).toString());
        notfoundexception;
        s1 = Integer.toHexString(getId());
        if (true) goto _L7; else goto _L6
_L6:
        j2 = 0;
_L23:
        if (j2 >= m.size())
        {
            break MISSING_BLOCK_LABEL_1294;
        }
        ac2 = (aC)m.get(j2);
        if (ac2.b < q) goto _L9; else goto _L8
_L8:
        if (ac2.b != q)
        {
            break MISSING_BLOCK_LABEL_1294;
        }
_L32:
        if (ac2 == null && l1 > 0)
        {
            ac3 = b(q, j2);
        } else
        {
            ac3 = ac2;
        }
        if (ac3 == null) goto _L11; else goto _L10
_L10:
        int k3 = j2 - 1;
        PagerAdapter pageradapter;
        int k2;
        int l2;
        int i3;
        View view2;
        LayoutParams layoutparams;
        aC ac6;
        float f1;
        int i4;
        int i5;
        int j5;
        if (k3 >= 0)
        {
            ac7 = (aC)m.get(k3);
        } else
        {
            ac7 = null;
        }
        l3 = h();
        if (l3 <= 0)
        {
            f1 = 0.0F;
        } else
        {
            f1 = (2.0F - ac3.d) + (float)getPaddingLeft() / (float)l3;
        }
        i4 = -1 + q;
        f2 = 0.0F;
        j4 = i4;
        k4 = j2;
        l4 = k3;
_L24:
        if (j4 < 0) goto _L13; else goto _L12
_L12:
        if (f2 < f1 || j4 >= k1) goto _L15; else goto _L14
_L14:
        if (ac7 != null) goto _L16; else goto _L13
_L13:
        f3 = ac3.d;
        i5 = k4 + 1;
        if (f3 >= 2.0F) goto _L18; else goto _L17
_L17:
        aC ac8;
        float f4;
        if (i5 < m.size())
        {
            ac8 = (aC)m.get(i5);
        } else
        {
            ac8 = null;
        }
        if (l3 <= 0)
        {
            f4 = 0.0F;
        } else
        {
            f4 = 2.0F + (float)getPaddingRight() / (float)l3;
        }
        j5 = 1 + q;
        ac9 = ac8;
        k5 = i5;
        l5 = j5;
_L26:
        if (l5 >= l1) goto _L18; else goto _L19
_L19:
        if (f3 < f4 || l5 <= i2) goto _L21; else goto _L20
_L20:
        if (ac9 != null) goto _L22; else goto _L18
_L18:
        a(ac3, k4, ac1);
          goto _L11
_L9:
        j2++;
          goto _L23
_L16:
        if (j4 == ac7.b && !ac7.c)
        {
            m.remove(l4);
            p.destroyItem(this, j4, ac7.a);
            l4--;
            k4--;
            if (l4 >= 0)
            {
                ac7 = (aC)m.get(l4);
            } else
            {
                ac7 = null;
            }
        }
_L25:
        j4--;
          goto _L24
_L15:
        if (ac7 != null && j4 == ac7.b)
        {
            f2 += ac7.d;
            if (--l4 >= 0)
            {
                ac7 = (aC)m.get(l4);
            } else
            {
                ac7 = null;
            }
        } else
        {
            f2 += b(j4, l4 + 1).d;
            k4++;
            if (l4 >= 0)
            {
                ac7 = (aC)m.get(l4);
            } else
            {
                ac7 = null;
            }
        }
          goto _L25
_L22:
        if (l5 == ac9.b && !ac9.c)
        {
            m.remove(k5);
            p.destroyItem(this, l5, ac9.a);
            float f7;
            aC ac14;
            float f10;
            if (k5 < m.size())
            {
                ac14 = (aC)m.get(k5);
            } else
            {
                ac14 = null;
            }
            f10 = f3;
            ac12 = ac14;
            f6 = f10;
        } else
        {
            float f9 = f3;
            ac12 = ac9;
            f6 = f9;
        }
        l5++;
        f7 = f6;
        ac9 = ac12;
        f3 = f7;
          goto _L26
_L21:
        if (ac9 != null && l5 == ac9.b)
        {
            float f8 = f3 + ac9.d;
            aC ac13;
            if (++k5 < m.size())
            {
                ac13 = (aC)m.get(k5);
            } else
            {
                ac13 = null;
            }
            ac12 = ac13;
            f6 = f8;
        } else
        {
            aC ac10 = b(l5, k5);
            k5++;
            float f5 = f3 + ac10.d;
            aC ac11;
            if (k5 < m.size())
            {
                ac11 = (aC)m.get(k5);
            } else
            {
                ac11 = null;
            }
            ac12 = ac11;
            f6 = f5;
        }
        break MISSING_BLOCK_LABEL_992;
_L11:
        pageradapter = p;
        k2 = q;
        Object obj;
        if (ac3 != null)
        {
            obj = ac3.a;
        } else
        {
            obj = null;
        }
        pageradapter.setPrimaryItem(this, k2, obj);
        p.finishUpdate(this);
        l2 = getChildCount();
        for (i3 = 0; i3 < l2; i3++)
        {
            view2 = getChildAt(i3);
            layoutparams = (LayoutParams)view2.getLayoutParams();
            layoutparams.d = i3;
            if (!layoutparams.isDecor && layoutparams.a == 0.0F)
            {
                ac6 = a(view2);
                if (ac6 != null)
                {
                    layoutparams.a = ac6.d;
                    layoutparams.c = ac6.b;
                }
            }
        }

        i();
        if (!hasFocus()) goto _L4; else goto _L27
_L27:
        View view = findFocus();
        aC ac4;
        int j3;
        View view1;
        aC ac5;
        if (view != null)
        {
            ac4 = b(view);
        } else
        {
            ac4 = null;
        }
        if (ac4 != null && ac4.b == q) goto _L4; else goto _L28
_L28:
        j3 = 0;
_L31:
        if (j3 >= getChildCount()) goto _L4; else goto _L29
_L29:
        view1 = getChildAt(j3);
        ac5 = a(view1);
        if (ac5 != null && ac5.b == q && view1.requestFocus(byte0)) goto _L4; else goto _L30
_L30:
        j3++;
          goto _L31
        ac2 = null;
          goto _L32
    }

    void a(int i1, int j1)
    {
        a(i1, j1, 0);
    }

    void a(int i1, int j1, int k1)
    {
        if (getChildCount() == 0)
        {
            d(false);
            return;
        }
        int l1 = getScrollX();
        int i2 = getScrollY();
        int j2 = i1 - l1;
        int k2 = j1 - i2;
        if (j2 == 0 && k2 == 0)
        {
            b(false);
            c();
            c(0);
            return;
        }
        d(true);
        c(2);
        int l2 = h();
        int i3 = l2 / 2;
        float f1 = Math.min(1.0F, (1.0F * (float)Math.abs(j2)) / (float)l2);
        float f2 = (float)i3 + (float)i3 * a(f1);
        int j3 = Math.abs(k1);
        int k3;
        int l3;
        if (j3 > 0)
        {
            k3 = 4 * Math.round(1000F * Math.abs(f2 / (float)j3));
        } else
        {
            float f3 = (float)l2 * p.getPageWidth(q);
            k3 = (int)(100F * (1.0F + (float)Math.abs(j2) / (f3 + (float)w)));
        }
        l3 = Math.min(k3, 600);
        u.startScroll(l1, i2, j2, k2, l3);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void a(int i1, boolean flag, boolean flag1)
    {
        a(i1, flag, flag1, 0);
    }

    void a(int i1, boolean flag, boolean flag1, int j1)
    {
        if (p == null || p.getCount() <= 0)
        {
            d(false);
            return;
        }
        if (!flag1 && q == i1 && m.size() != 0)
        {
            d(false);
            return;
        }
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L4:
        int k1 = H;
        if (i1 > k1 + q || i1 < q - k1)
        {
            for (int l1 = 0; l1 < m.size(); l1++)
            {
                ((aC)m.get(l1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i1 >= p.getCount())
        {
            i1 = -1 + p.getCount();
        }
        if (true) goto _L4; else goto _L3
_L3:
        int i2 = q;
        boolean flag2 = false;
        if (i2 != i1)
        {
            flag2 = true;
        }
        if (ag)
        {
            q = i1;
            if (flag2 && ak != null)
            {
                ak.onPageSelected(i1);
            }
            if (flag2 && al != null)
            {
                al.onPageSelected(i1);
            }
            requestLayout();
            return;
        } else
        {
            a(i1);
            a(i1, flag, j1, flag2);
            return;
        }
    }

    void a(aE ae1)
    {
        am = ae1;
    }

    void a(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        Method method;
        Object aobj[];
        if (ao == null)
        {
            try
            {
                Class aclass[] = new Class[1];
                aclass[0] = Boolean.TYPE;
                ao = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", aclass);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", nosuchmethodexception);
            }
        }
        method = ao;
        aobj = new Object[1];
        aobj[0] = Boolean.valueOf(flag);
        method.invoke(this, aobj);
        return;
        Exception exception;
        exception;
        Log.e("ViewPager", "Error changing children drawing order", exception);
        return;
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
                    aC ac1 = a(view);
                    if (ac1 != null && ac1.b == q)
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
            aC ac1 = a(view);
            if (ac1 != null && ac1.b == q)
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
        layoutparams2.isDecor = layoutparams2.isDecor | (view instanceof aB);
        if (E)
        {
            if (layoutparams2 != null && layoutparams2.isDecor)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                layoutparams2.b = true;
                addViewInLayout(view, i1, layoutparams1);
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
        View view = findFocus();
        if (view != this) goto _L2; else goto _L1
_L1:
        View view1 = null;
_L13:
        View view2 = FocusFinder.getInstance().findNextFocus(this, view1, i1);
        if (view2 == null || view2 == view1) goto _L4; else goto _L3
_L3:
        if (i1 != 17) goto _L6; else goto _L5
_L5:
        boolean flag;
        boolean flag1;
        int l1 = a(o, view2).left;
        int i2 = a(o, view1).left;
        ViewParent viewparent;
        StringBuilder stringbuilder;
        ViewParent viewparent1;
        if (view1 != null && l1 >= i2)
        {
            flag = d();
        } else
        {
            flag = view2.requestFocus();
        }
_L16:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i1));
        }
        return flag;
_L2:
        if (view == null) goto _L8; else goto _L7
_L7:
        viewparent = view.getParent();
_L12:
        if (!(viewparent instanceof ViewGroup))
        {
            break MISSING_BLOCK_LABEL_375;
        }
        if (viewparent != this) goto _L10; else goto _L9
_L9:
        flag1 = true;
_L18:
        if (flag1) goto _L8; else goto _L11
_L10:
        viewparent = viewparent.getParent();
          goto _L12
_L11:
        stringbuilder = new StringBuilder();
        stringbuilder.append(view.getClass().getSimpleName());
        for (viewparent1 = view.getParent(); viewparent1 instanceof ViewGroup; viewparent1 = viewparent1.getParent())
        {
            stringbuilder.append(" => ").append(viewparent1.getClass().getSimpleName());
        }

        Log.e("ViewPager", (new StringBuilder()).append("arrowScroll tried to find focus based on non-child current focused view ").append(stringbuilder.toString()).toString());
        view1 = null;
          goto _L13
_L6:
        if (i1 != 66) goto _L15; else goto _L14
_L14:
        int j1 = a(o, view2).left;
        int k1 = a(o, view1).left;
        if (view1 != null && j1 <= k1)
        {
            flag = e();
        } else
        {
            flag = view2.requestFocus();
        }
          goto _L16
_L4:
label0:
        {
            if (i1 != 17 && i1 != 1)
            {
                break label0;
            }
            flag = d();
        }
          goto _L16
        if (i1 != 66 && i1 != 2) goto _L15; else goto _L17
_L17:
        flag = e();
          goto _L16
_L15:
        flag = false;
          goto _L16
_L8:
        view1 = view;
          goto _L13
        flag1 = false;
          goto _L18
    }

    aC b(int i1)
    {
        for (int j1 = 0; j1 < m.size(); j1++)
        {
            aC ac1 = (aC)m.get(j1);
            if (ac1.b == i1)
            {
                return ac1;
            }
        }

        return null;
    }

    aC b(int i1, int j1)
    {
        aC ac1 = new aC();
        ac1.b = i1;
        ac1.a = p.instantiateItem(this, i1);
        ac1.d = p.getPageWidth(i1);
        if (j1 < 0 || j1 >= m.size())
        {
            m.add(ac1);
            return ac1;
        } else
        {
            m.add(j1, ac1);
            return ac1;
        }
    }

    aC b(View view)
    {
        do
        {
            ViewParent viewparent = view.getParent();
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
        int i1 = p.getCount();
        j = i1;
        boolean flag;
        int j1;
        boolean flag1;
        int k1;
        boolean flag2;
        int l1;
        if (m.size() < 1 + 2 * H && m.size() < i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j1 = q;
        flag1 = false;
        k1 = j1;
        flag2 = flag;
        l1 = 0;
        while (l1 < m.size()) 
        {
            aC ac1 = (aC)m.get(l1);
            int k2 = p.getItemPosition(ac1.a);
            int l2;
            boolean flag3;
            int i3;
            boolean flag4;
            int j3;
            if (k2 == -1)
            {
                l2 = l1;
                flag3 = flag1;
                i3 = k1;
                flag4 = flag2;
            } else
            if (k2 == -2)
            {
                m.remove(l1);
                int k3 = l1 - 1;
                if (!flag1)
                {
                    p.startUpdate(this);
                    flag1 = true;
                }
                p.destroyItem(this, ac1.b, ac1.a);
                int i2;
                int j2;
                LayoutParams layoutparams;
                if (q == ac1.b)
                {
                    int l3 = Math.max(0, Math.min(q, i1 - 1));
                    l2 = k3;
                    flag3 = flag1;
                    i3 = l3;
                    flag4 = true;
                } else
                {
                    l2 = k3;
                    flag3 = flag1;
                    i3 = k1;
                    flag4 = true;
                }
            } else
            if (ac1.b != k2)
            {
                if (ac1.b == q)
                {
                    k1 = k2;
                }
                ac1.b = k2;
                l2 = l1;
                flag3 = flag1;
                i3 = k1;
                flag4 = true;
            } else
            {
                l2 = l1;
                flag3 = flag1;
                i3 = k1;
                flag4 = flag2;
            }
            j3 = l2 + 1;
            flag2 = flag4;
            k1 = i3;
            flag1 = flag3;
            l1 = j3;
        }
        if (flag1)
        {
            p.finishUpdate(this);
        }
        Collections.sort(m, k);
        if (flag2)
        {
            i2 = getChildCount();
            for (j2 = 0; j2 < i2; j2++)
            {
                layoutparams = (LayoutParams)getChildAt(j2).getLayoutParams();
                if (!layoutparams.isDecor)
                {
                    layoutparams.a = 0.0F;
                }
            }

            a(k1, false, true);
            requestLayout();
        }
    }

    public boolean beginFakeDrag()
    {
        if (I)
        {
            return false;
        }
        ac = true;
        c(1);
        O = 0.0F;
        Q = 0.0F;
        long l1;
        MotionEvent motionevent;
        if (U == null)
        {
            U = VelocityTracker.obtain();
        } else
        {
            U.clear();
        }
        l1 = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
        U.addMovement(motionevent);
        motionevent.recycle();
        ad = l1;
        return true;
    }

    void c()
    {
        a(q);
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
        if (flag && ViewCompat.canScrollHorizontally(view, -i1)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean canScrollHorizontally(int i1)
    {
        boolean flag = true;
        if (p != null)
        {
            int j1 = h();
            int k1 = getScrollX();
            if (i1 < 0)
            {
                if (k1 <= (int)((float)j1 * A))
                {
                    flag = false;
                }
                return flag;
            }
            if (i1 > 0)
            {
                if (k1 >= (int)((float)j1 * B))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!u.isFinished() && u.computeScrollOffset())
        {
            int i1 = getScrollX();
            int j1 = getScrollY();
            int k1 = u.getCurrX();
            int l1 = u.getCurrY();
            if (i1 != k1 || j1 != l1)
            {
                scrollTo(k1, l1);
                if (!d(k1))
                {
                    u.abortAnimation();
                    scrollTo(0, l1);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        } else
        {
            b(true);
            return;
        }
    }

    boolean d()
    {
        if (q > 0)
        {
            setCurrentItem(-1 + q, true);
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
        if (accessibilityevent.getEventType() != 4096) goto _L2; else goto _L1
_L1:
        boolean flag = super.dispatchPopulateAccessibilityEvent(accessibilityevent);
_L4:
        return flag;
_L2:
        int i1 = getChildCount();
        int j1 = 0;
        do
        {
            flag = false;
            if (j1 >= i1)
            {
                continue;
            }
            View view = getChildAt(j1);
            if (view.getVisibility() == 0)
            {
                aC ac1 = a(view);
                if (ac1 != null && ac1.b == q && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
                {
                    return true;
                }
            }
            j1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int i1 = ViewCompat.getOverScrollMode(this);
        boolean flag1;
        if (i1 == 0 || i1 == 1 && p != null && p.getCount() > 1)
        {
            boolean flag = ae.isFinished();
            flag1 = false;
            if (!flag)
            {
                int i2 = canvas.save();
                int j2 = getHeight() - getPaddingTop() - getPaddingBottom();
                int k2 = getWidth();
                canvas.rotate(270F);
                canvas.translate(-j2 + getPaddingTop(), A * (float)k2);
                ae.setSize(j2, k2);
                flag1 = false | ae.draw(canvas);
                canvas.restoreToCount(i2);
            }
            if (!af.isFinished())
            {
                int j1 = canvas.save();
                int k1 = getWidth();
                int l1 = getHeight() - getPaddingTop() - getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -(1.0F + B) * (float)k1);
                af.setSize(l1, k1);
                flag1 |= af.draw(canvas);
                canvas.restoreToCount(j1);
            }
        } else
        {
            ae.finish();
            af.finish();
            flag1 = false;
        }
        if (flag1)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = x;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    boolean e()
    {
        if (p != null && q < -1 + p.getCount())
        {
            setCurrentItem(1 + q, true);
            return true;
        } else
        {
            return false;
        }
    }

    public void endFakeDrag()
    {
        if (!ac)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else
        {
            VelocityTracker velocitytracker = U;
            velocitytracker.computeCurrentVelocity(1000, W);
            int i1 = (int)VelocityTrackerCompat.getXVelocity(velocitytracker, S);
            G = true;
            int j1 = h();
            int k1 = getScrollX();
            aC ac1 = j();
            a(a(ac1.b, ((float)k1 / (float)j1 - ac1.e) / ac1.d, i1, (int)(O - Q)), true, true, i1);
            k();
            ac = false;
            return;
        }
    }

    public boolean executeKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 44
    //                   21: 46
    //                   22: 53
    //                   61: 60;
           goto _L2 _L3 _L4 _L5
_L2:
        return false;
_L3:
        return arrowScroll(17);
_L4:
        return arrowScroll(66);
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
        if (!ac)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        O = f1 + O;
        float f2 = (float)getScrollX() - f1;
        int i1 = h();
        float f3 = (float)i1 * A;
        float f4 = (float)i1 * B;
        aC ac1 = (aC)m.get(0);
        aC ac2 = (aC)m.get(-1 + m.size());
        float f5;
        float f6;
        long l1;
        MotionEvent motionevent;
        if (ac1.b != 0)
        {
            f5 = ac1.e * (float)i1;
        } else
        {
            f5 = f3;
        }
        if (ac2.b != -1 + p.getCount())
        {
            f6 = ac2.e * (float)i1;
        } else
        {
            f6 = f4;
        }
        if (f2 >= f5)
        {
            if (f2 > f6)
            {
                f5 = f6;
            } else
            {
                f5 = f2;
            }
        }
        O = O + (f5 - (float)(int)f5);
        scrollTo((int)f5, getScrollY());
        d((int)f5);
        l1 = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(ad, l1, 2, O, 0.0F, 0);
        U.addMovement(motionevent);
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
        return p;
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        if (as == 2)
        {
            j1 = i1 - 1 - j1;
        }
        return ((LayoutParams)((View)at.get(j1)).getLayoutParams()).d;
    }

    public int getCurrentItem()
    {
        return q;
    }

    public int getOffscreenPageLimit()
    {
        return H;
    }

    public int getPageMargin()
    {
        return w;
    }

    public boolean isFakeDragging()
    {
        return ac;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        ag = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(av);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (w <= 0 || x == null || m.size() <= 0 || p == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        float f1;
        aC ac1;
        float f2;
        int k1;
        int i2;
        int j2;
        int k2;
        i1 = getScrollX();
        j1 = getWidth();
        f1 = (float)w / (float)j1;
        ac1 = (aC)m.get(0);
        f2 = ac1.e;
        k1 = m.size();
        int l1 = ac1.b;
        i2 = ((aC)m.get(k1 - 1)).b;
        j2 = 0;
        k2 = l1;
_L6:
        if (k2 >= i2) goto _L2; else goto _L3
_L3:
        ArrayList arraylist;
        for (; k2 > ac1.b && j2 < k1; ac1 = (aC)arraylist.get(j2))
        {
            arraylist = m;
            j2++;
        }

        float f4;
        if (k2 == ac1.b)
        {
            f4 = (ac1.e + ac1.d) * (float)j1;
            f2 = f1 + (ac1.e + ac1.d);
        } else
        {
            float f3 = p.getPageWidth(k2);
            f4 = (f2 + f3) * (float)j1;
            f2 += f3 + f1;
        }
        if (f4 + (float)w > (float)i1)
        {
            x.setBounds((int)f4, y, (int)(0.5F + (f4 + (float)w)), z);
            x.draw(canvas);
        }
        if (f4 <= (float)(i1 + j1)) goto _L4; else goto _L2
_L2:
        return;
_L4:
        k2++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1 = 0xff & motionevent.getAction();
        if (i1 != 3 && i1 != 1) goto _L2; else goto _L1
_L1:
        I = false;
        J = false;
        S = -1;
        if (U != null)
        {
            U.recycle();
            U = null;
        }
_L4:
        return false;
_L2:
        if (i1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (I)
        {
            return true;
        }
        if (J) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 3: default 112
    //                   0: 386
    //                   2: 139
    //                   6: 516;
           goto _L5 _L6 _L7 _L8
_L5:
        if (U == null)
        {
            U = VelocityTracker.obtain();
        }
        U.addMovement(motionevent);
        return I;
_L7:
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int j1 = S;
        if (j1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        int k1 = MotionEventCompat.findPointerIndex(motionevent, j1);
        f3 = MotionEventCompat.getX(motionevent, k1);
        f4 = f3 - O;
        f5 = Math.abs(f4);
        f6 = MotionEventCompat.getY(motionevent, k1);
        f7 = Math.abs(f6 - R);
        if (f4 != 0.0F && !a(O, f4) && canScroll(this, false, (int)f4, (int)f3, (int)f6))
        {
            O = f3;
            P = f6;
            J = true;
            return false;
        }
        if (f5 <= (float)N || 0.5F * f5 <= f7) goto _L10; else goto _L9
_L9:
        I = true;
        c(1);
        float f8;
        if (f4 > 0.0F)
        {
            f8 = Q + (float)N;
        } else
        {
            f8 = Q - (float)N;
        }
        O = f8;
        P = f6;
        d(true);
_L11:
        if (I && b(f3))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (f7 > (float)N)
        {
            J = true;
        }
        if (true) goto _L11; else goto _L6
_L6:
        float f1 = motionevent.getX();
        Q = f1;
        O = f1;
        float f2 = motionevent.getY();
        R = f2;
        P = f2;
        S = MotionEventCompat.getPointerId(motionevent, 0);
        J = false;
        u.computeScrollOffset();
        if (aw == 2 && Math.abs(u.getFinalX() - u.getCurrX()) > aa)
        {
            u.abortAnimation();
            G = false;
            c();
            I = true;
            c(1);
        } else
        {
            b(false);
            I = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        a(motionevent);
        if (true) goto _L5; else goto _L12
_L12:
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
        i2 = getChildCount();
        j2 = k1 - i1;
        k2 = l1 - j1;
        l2 = getPaddingLeft();
        i3 = getPaddingTop();
        j3 = getPaddingRight();
        k3 = getPaddingBottom();
        l3 = getScrollX();
        i4 = 0;
        j4 = 0;
_L14:
        if (j4 >= i2) goto _L2; else goto _L1
_L1:
        View view1 = getChildAt(j4);
        if (view1.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
        if (!layoutparams1.isDecor) goto _L4; else goto _L5
_L5:
        int j6;
        int k6;
        j6 = 7 & layoutparams1.gravity;
        k6 = 0x70 & layoutparams1.gravity;
        j6;
        JVM INSTR tableswitch 1 5: default 152
    //                   1 305
    //                   2 152
    //                   3 284
    //                   4 152
    //                   5 325;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        int i7 = l2;
_L15:
        k6;
        JVM INSTR lookupswitch 3: default 192
    //                   16: 384
    //                   48: 355
    //                   80: 416;
           goto _L10 _L11 _L12 _L13
_L10:
        int j7;
        int l7;
        int i8;
        j7 = i3;
        int j9 = k3;
        l7 = i3;
        i8 = j9;
_L16:
        int j5;
        int k5;
        int l5;
        int i6;
        int j8 = i7 + l3;
        view1.layout(j8, j7, j8 + view1.getMeasuredWidth(), j7 + view1.getMeasuredHeight());
        j5 = i4 + 1;
        k5 = l7;
        k3 = i8;
        l5 = j3;
        i6 = l2;
_L17:
        j4++;
        l2 = i6;
        j3 = l5;
        i3 = k5;
        i4 = j5;
          goto _L14
_L8:
        int k9 = l2 + view1.getMeasuredWidth();
        i7 = l2;
        l2 = k9;
          goto _L15
_L7:
        i7 = Math.max((j2 - view1.getMeasuredWidth()) / 2, l2);
          goto _L15
_L9:
        int l6 = j2 - j3 - view1.getMeasuredWidth();
        j3 += view1.getMeasuredWidth();
        i7 = l6;
          goto _L15
_L12:
        int l8 = i3 + view1.getMeasuredHeight();
        int i9 = i3;
        i8 = k3;
        l7 = l8;
        j7 = i9;
          goto _L16
_L11:
        j7 = Math.max((k2 - view1.getMeasuredHeight()) / 2, i3);
        int k8 = k3;
        l7 = i3;
        i8 = k8;
          goto _L16
_L13:
        j7 = k2 - k3 - view1.getMeasuredHeight();
        int k7 = k3 + view1.getMeasuredHeight();
        l7 = i3;
        i8 = k7;
          goto _L16
_L2:
        int k4 = j2 - l2 - j3;
        for (int l4 = 0; l4 < i2; l4++)
        {
            View view = getChildAt(l4);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams.isDecor)
            {
                continue;
            }
            aC ac1 = a(view);
            if (ac1 == null)
            {
                continue;
            }
            int i5 = l2 + (int)((float)k4 * ac1.e);
            if (layoutparams.b)
            {
                layoutparams.b = false;
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)k4 * layoutparams.a), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k2 - i3 - k3, 0x40000000));
            }
            view.layout(i5, i3, i5 + view.getMeasuredWidth(), i3 + view.getMeasuredHeight());
        }

        y = i3;
        z = k2 - k3;
        aj = i4;
        if (ag)
        {
            a(q, false, 0, false);
        }
        ag = false;
        return;
_L4:
        j5 = i4;
        k5 = i3;
        l5 = j3;
        i6 = l2;
          goto _L17
    }

    protected void onMeasure(int i1, int j1)
    {
        int l1;
        int i2;
        int j2;
        int k2;
        setMeasuredDimension(getDefaultSize(0, i1), getDefaultSize(0, j1));
        int k1 = getMeasuredWidth();
        M = Math.min(k1 / 10, L);
        l1 = k1 - getPaddingLeft() - getPaddingRight();
        i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        j2 = getChildCount();
        k2 = 0;
_L3:
        if (k2 >= j2) goto _L2; else goto _L1
_L1:
        View view1 = getChildAt(k2);
        if (view1.getVisibility() == 8)
        {
            continue; /* Loop/switch isn't completed */
        }
        LayoutParams layoutparams1 = (LayoutParams)view1.getLayoutParams();
        if (layoutparams1 == null || !layoutparams1.isDecor)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j3 = 7 & layoutparams1.gravity;
        int k3 = 0x70 & layoutparams1.gravity;
        int l3 = 0x80000000;
        int i4 = 0x80000000;
        boolean flag;
        boolean flag1;
        int j4;
        int k4;
        if (k3 == 48 || k3 == 80)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j3 == 3 || j3 == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            l3 = 0x40000000;
        } else
        if (flag1)
        {
            i4 = 0x40000000;
        }
        if (layoutparams1.width != -2)
        {
            j4 = 0x40000000;
            int l2;
            int i3;
            View view;
            LayoutParams layoutparams;
            int l4;
            if (layoutparams1.width != -1)
            {
                k4 = layoutparams1.width;
            } else
            {
                k4 = l1;
            }
        } else
        {
            j4 = l3;
            k4 = l1;
        }
        if (layoutparams1.height == -2)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        i4 = 0x40000000;
        if (layoutparams1.height == -1)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        l4 = layoutparams1.height;
        view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(k4, j4), android.view.View.MeasureSpec.makeMeasureSpec(l4, i4));
        if (flag)
        {
            i2 -= view1.getMeasuredHeight();
        } else
        if (flag1)
        {
            l1 -= view1.getMeasuredWidth();
        }
        k2++;
          goto _L3
_L2:
        C = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000);
        D = android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000);
        E = true;
        c();
        E = false;
        l2 = getChildCount();
        for (i3 = 0; i3 < l2; i3++)
        {
            view = getChildAt(i3);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams == null || !layoutparams.isDecor)
            {
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)l1 * layoutparams.a), 0x40000000), D);
            }
        }

        return;
        l4 = i2;
        break MISSING_BLOCK_LABEL_254;
    }

    protected void onPageScrolled(int i1, float f1, int j1)
    {
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (aj <= 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        j2 = getScrollX();
        k2 = getPaddingLeft();
        l2 = getPaddingRight();
        i3 = getWidth();
        j3 = getChildCount();
        k3 = 0;
_L2:
        View view1;
        LayoutParams layoutparams;
        int j4;
        int k4;
        if (k3 >= j3)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        view1 = getChildAt(k3);
        layoutparams = (LayoutParams)view1.getLayoutParams();
        if (layoutparams.isDecor)
        {
            break; /* Loop/switch isn't completed */
        }
        int j6 = l2;
        j4 = k2;
        k4 = j6;
_L7:
        k3++;
        int i5 = k4;
        k2 = j4;
        l2 = i5;
        if (true) goto _L2; else goto _L1
_L1:
        7 & layoutparams.gravity;
        JVM INSTR tableswitch 1 5: default 144
    //                   1 217
    //                   2 144
    //                   3 188
    //                   4 144
    //                   5 249;
           goto _L3 _L4 _L3 _L5 _L3 _L6
_L6:
        break MISSING_BLOCK_LABEL_249;
_L3:
        int l3;
        l3 = k2;
        int i6 = l2;
        j4 = k2;
        k4 = i6;
_L8:
        int l4 = (l3 + j2) - view1.getLeft();
        if (l4 != 0)
        {
            view1.offsetLeftAndRight(l4);
        }
          goto _L7
_L5:
        int k5 = k2 + view1.getWidth();
        int l5 = k2;
        k4 = l2;
        j4 = k5;
        l3 = l5;
          goto _L8
_L4:
        l3 = Math.max((i3 - view1.getMeasuredWidth()) / 2, k2);
        int j5 = l2;
        j4 = k2;
        k4 = j5;
          goto _L8
        l3 = i3 - l2 - view1.getMeasuredWidth();
        int i4 = l2 + view1.getMeasuredWidth();
        j4 = k2;
        k4 = i4;
          goto _L8
        if (ak != null)
        {
            ak.onPageScrolled(i1, f1, j1);
        }
        if (al != null)
        {
            al.onPageScrolled(i1, f1, j1);
        }
        if (an != null)
        {
            int k1 = getScrollX();
            int l1 = getChildCount();
            int i2 = 0;
            while (i2 < l1) 
            {
                View view = getChildAt(i2);
                if (!((LayoutParams)view.getLayoutParams()).isDecor)
                {
                    float f2 = (float)(view.getLeft() - k1) / (float)h();
                    an.transformPage(view, f2);
                }
                i2++;
            }
        }
        ai = true;
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
            aC ac1 = a(view);
            if (ac1 != null && ac1.b == q && view.requestFocus(i1, rect))
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
        if (p != null)
        {
            p.restoreState(savedstate.b, savedstate.c);
            a(savedstate.a, false, true);
            return;
        } else
        {
            r = savedstate.a;
            s = savedstate.b;
            t = savedstate.c;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = q;
        if (p != null)
        {
            savedstate.b = p.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1)
        {
            a(i1, k1, w, w);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        if (ac)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (p == null || p.getCount() == 0)
        {
            return false;
        }
        if (U == null)
        {
            U = VelocityTracker.obtain();
        }
        U.addMovement(motionevent);
        i1 = 0xff & motionevent.getAction();
        flag = false;
        i1;
        JVM INSTR tableswitch 0 6: default 120
    //                   0 130
    //                   1 383
    //                   2 206
    //                   3 534
    //                   4 120
    //                   5 586
    //                   6 617;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        if (flag)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
_L2:
        u.abortAnimation();
        G = false;
        c();
        I = true;
        c(1);
        float f6 = motionevent.getX();
        Q = f6;
        O = f6;
        float f7 = motionevent.getY();
        R = f7;
        P = f7;
        S = MotionEventCompat.getPointerId(motionevent, 0);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!I)
        {
            int j2 = MotionEventCompat.findPointerIndex(motionevent, S);
            float f1 = MotionEventCompat.getX(motionevent, j2);
            float f2 = Math.abs(f1 - O);
            float f3 = MotionEventCompat.getY(motionevent, j2);
            float f4 = Math.abs(f3 - P);
            if (f2 > (float)N && f2 > f4)
            {
                I = true;
                boolean flag3;
                float f5;
                if (f1 - Q > 0.0F)
                {
                    f5 = Q + (float)N;
                } else
                {
                    f5 = Q - (float)N;
                }
                O = f5;
                P = f3;
                c(1);
                d(true);
            }
        }
        flag3 = I;
        flag = false;
        if (flag3)
        {
            flag = false | b(MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, S)));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        boolean flag2 = I;
        flag = false;
        if (flag2)
        {
            VelocityTracker velocitytracker = U;
            velocitytracker.computeCurrentVelocity(1000, W);
            int k1 = (int)VelocityTrackerCompat.getXVelocity(velocitytracker, S);
            G = true;
            int l1 = h();
            int i2 = getScrollX();
            aC ac1 = j();
            a(a(ac1.b, ((float)i2 / (float)l1 - ac1.e) / ac1.d, k1, (int)(MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, S)) - Q)), true, true, k1);
            S = -1;
            k();
            flag = ae.onRelease() | af.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        boolean flag1 = I;
        flag = false;
        if (flag1)
        {
            a(q, true, 0, false);
            S = -1;
            k();
            flag = ae.onRelease() | af.onRelease();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int j1 = MotionEventCompat.getActionIndex(motionevent);
        O = MotionEventCompat.getX(motionevent, j1);
        S = MotionEventCompat.getPointerId(motionevent, j1);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L7:
        a(motionevent);
        O = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, S));
        flag = false;
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void removeView(View view)
    {
        if (E)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(PagerAdapter pageradapter)
    {
        if (p != null)
        {
            p.unregisterDataSetObserver(v);
            p.startUpdate(this);
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                aC ac1 = (aC)m.get(i1);
                p.destroyItem(this, ac1.b, ac1.a);
            }

            p.finishUpdate(this);
            m.clear();
            g();
            q = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pageradapter1 = p;
        p = pageradapter;
        j = 0;
        if (p != null)
        {
            if (v == null)
            {
                v = new aF(this, null);
            }
            p.registerDataSetObserver(v);
            G = false;
            boolean flag = ag;
            ag = true;
            j = p.getCount();
            if (r >= 0)
            {
                p.restoreState(s, t);
                a(r, false, true);
                r = -1;
                s = null;
                t = null;
            } else
            if (!flag)
            {
                c();
            } else
            {
                requestLayout();
            }
        }
        if (am != null && pageradapter1 != pageradapter)
        {
            am.a(pageradapter1, pageradapter);
        }
    }

    public void setCurrentItem(int i1)
    {
        G = false;
        boolean flag;
        if (!ag)
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
        G = false;
        a(i1, flag, false);
    }

    public void setOffscreenPageLimit(int i1)
    {
        if (i1 < 1)
        {
            Log.w("ViewPager", (new StringBuilder()).append("Requested offscreen page limit ").append(i1).append(" too small; defaulting to ").append(1).toString());
            i1 = 1;
        }
        if (i1 != H)
        {
            H = i1;
            c();
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onpagechangelistener)
    {
        ak = onpagechangelistener;
    }

    public void setPageMargin(int i1)
    {
        int j1 = w;
        w = i1;
        int k1 = getWidth();
        a(k1, k1, i1, j1);
        requestLayout();
    }

    public void setPageMarginDrawable(int i1)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i1));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        x = drawable;
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

    public void setPageTransformer(boolean flag, PageTransformer pagetransformer)
    {
        int i1 = 1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag1;
            int j1;
            int k1;
            if (pagetransformer != null)
            {
                flag1 = i1;
            } else
            {
                flag1 = false;
            }
            if (an != null)
            {
                j1 = i1;
            } else
            {
                j1 = 0;
            }
            if (flag1 != j1)
            {
                k1 = i1;
            } else
            {
                k1 = 0;
            }
            an = pagetransformer;
            a(flag1);
            if (flag1)
            {
                if (flag)
                {
                    i1 = 2;
                }
                as = i1;
            } else
            {
                as = 0;
            }
            if (k1 != 0)
            {
                c();
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == x;
    }


    private class OnPageChangeListener
    {

        public abstract void onPageScrollStateChanged(int i1);

        public abstract void onPageScrolled(int i1, float f1, int j1);

        public abstract void onPageSelected(int i1);
    }


    private class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        float a;
        boolean b;
        int c;
        int d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams()
        {
            super(-1, -1);
            a = 0.0F;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            a = 0.0F;
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, ViewPager.f());
            gravity = typedarray.getInteger(0, 48);
            typedarray.recycle();
        }
    }


    private class PageTransformer
    {

        public abstract void transformPage(View view, float f1);
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = ParcelableCompat.newCreator(new aG());
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
