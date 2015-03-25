// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimator, d, c, f, 
//            e

class b extends ViewPropertyAnimator
{

    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 4;
    private static final int o = 8;
    private static final int p = 16;
    private static final int q = 32;
    private static final int r = 64;
    private static final int s = 128;
    private static final int t = 256;
    private static final int u = 512;
    private static final int v = 511;
    ArrayList a;
    private final WeakReference b;
    private long c;
    private boolean d;
    private long e;
    private boolean f;
    private Interpolator g;
    private boolean h;
    private com.nineoldandroids.animation.Animator.AnimatorListener i;
    private d j;
    private Runnable w;
    private HashMap x;

    b(View view)
    {
        d = false;
        e = 0L;
        f = false;
        h = false;
        i = null;
        j = new d(this, null);
        a = new ArrayList();
        w = new c(this);
        x = new HashMap();
        b = new WeakReference(view);
    }

    private float a(int i1)
    {
        View view = (View)b.get();
        if (view == null) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 10: default 108
    //                   1: 110
    //                   2: 115
    //                   4: 135
    //                   8: 140
    //                   16: 120
    //                   32: 125
    //                   64: 130
    //                   128: 145
    //                   256: 150
    //                   512: 155;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L2:
        return 0.0F;
_L3:
        return view.getTranslationX();
_L4:
        return view.getTranslationY();
_L7:
        return view.getRotation();
_L8:
        return view.getRotationX();
_L9:
        return view.getRotationY();
_L5:
        return view.getScaleX();
_L6:
        return view.getScaleY();
_L10:
        return view.getX();
_L11:
        return view.getY();
_L12:
        return view.getAlpha();
    }

    private void a()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            1.0F
        });
        ArrayList arraylist = (ArrayList)a.clone();
        a.clear();
        int i1 = arraylist.size();
        int j1 = 0;
        int k1 = 0;
        do
        {
            if (j1 >= i1)
            {
                x.put(valueanimator, new f(k1, arraylist));
                valueanimator.addUpdateListener(j);
                valueanimator.addListener(j);
                if (f)
                {
                    valueanimator.setStartDelay(e);
                }
                if (d)
                {
                    valueanimator.setDuration(c);
                }
                if (h)
                {
                    valueanimator.setInterpolator(g);
                }
                valueanimator.start();
                return;
            }
            k1 |= ((e)arraylist.get(j1)).a;
            j1++;
        } while (true);
    }

    private void a(int i1, float f1)
    {
        float f2 = a(i1);
        a(i1, f2, f1 - f2);
    }

    private void a(int i1, float f1, float f2)
    {
        if (x.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = x.keySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Animator animator = null;
_L5:
        if (animator != null)
        {
            animator.cancel();
        }
_L2:
        e e1 = new e(i1, f1, f2);
        a.add(e1);
        View view = (View)b.get();
        if (view != null)
        {
            view.removeCallbacks(w);
            view.post(w);
        }
        return;
_L4:
        f f3;
        animator = (Animator)iterator.next();
        f3 = (f)x.get(animator);
        if (!f3.a(i1) || f3.a != 0) goto _L6; else goto _L5
    }

    static void a(b b1)
    {
        b1.a();
    }

    static void a(b b1, int i1, float f1)
    {
        b1.c(i1, f1);
    }

    static void a(b b1, com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener)
    {
        b1.i = animatorlistener;
    }

    static com.nineoldandroids.animation.Animator.AnimatorListener b(b b1)
    {
        return b1.i;
    }

    private void b(int i1, float f1)
    {
        a(i1, a(i1), f1);
    }

    static HashMap c(b b1)
    {
        return b1.x;
    }

    private void c(int i1, float f1)
    {
        View view = (View)b.get();
        if (view == null) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 10: default 108
    //                   1: 109
    //                   2: 115
    //                   4: 139
    //                   8: 145
    //                   16: 121
    //                   32: 127
    //                   64: 133
    //                   128: 151
    //                   256: 157
    //                   512: 163;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L2:
        return;
_L3:
        view.setTranslationX(f1);
        return;
_L4:
        view.setTranslationY(f1);
        return;
_L7:
        view.setRotation(f1);
        return;
_L8:
        view.setRotationX(f1);
        return;
_L9:
        view.setRotationY(f1);
        return;
_L5:
        view.setScaleX(f1);
        return;
_L6:
        view.setScaleY(f1);
        return;
_L10:
        view.setX(f1);
        return;
_L11:
        view.setY(f1);
        return;
_L12:
        view.setAlpha(f1);
        return;
    }

    static WeakReference d(b b1)
    {
        return b1.b;
    }

    public ViewPropertyAnimator alpha(float f1)
    {
        a(512, f1);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f1)
    {
        b(512, f1);
        return this;
    }

    public void cancel()
    {
        if (x.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = ((HashMap)x.clone()).keySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        a.clear();
        View view = (View)b.get();
        if (view != null)
        {
            view.removeCallbacks(w);
        }
        return;
_L3:
        ((Animator)iterator.next()).cancel();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public long getDuration()
    {
        if (d)
        {
            return c;
        } else
        {
            return (new ValueAnimator()).getDuration();
        }
    }

    public long getStartDelay()
    {
        if (f)
        {
            return e;
        } else
        {
            return 0L;
        }
    }

    public ViewPropertyAnimator rotation(float f1)
    {
        a(16, f1);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f1)
    {
        b(16, f1);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f1)
    {
        a(32, f1);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f1)
    {
        b(32, f1);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f1)
    {
        a(64, f1);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f1)
    {
        b(64, f1);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f1)
    {
        a(4, f1);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f1)
    {
        b(4, f1);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f1)
    {
        a(8, f1);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f1)
    {
        b(8, f1);
        return this;
    }

    public ViewPropertyAnimator setDuration(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("Animators cannot have negative duration: ")).append(l1).toString());
        } else
        {
            d = true;
            c = l1;
            return this;
        }
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator)
    {
        h = true;
        g = interpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener)
    {
        i = animatorlistener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("Animators cannot have negative duration: ")).append(l1).toString());
        } else
        {
            f = true;
            e = l1;
            return this;
        }
    }

    public void start()
    {
        a();
    }

    public ViewPropertyAnimator translationX(float f1)
    {
        a(1, f1);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f1)
    {
        b(1, f1);
        return this;
    }

    public ViewPropertyAnimator translationY(float f1)
    {
        a(2, f1);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f1)
    {
        b(2, f1);
        return this;
    }

    public ViewPropertyAnimator x(float f1)
    {
        a(128, f1);
        return this;
    }

    public ViewPropertyAnimator xBy(float f1)
    {
        b(128, f1);
        return this;
    }

    public ViewPropertyAnimator y(float f1)
    {
        a(256, f1);
        return this;
    }

    public ViewPropertyAnimator yBy(float f1)
    {
        b(256, f1);
        return this;
    }
}
