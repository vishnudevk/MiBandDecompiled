// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimator, k, j, m, 
//            l

class i extends ViewPropertyAnimator
{

    private static final int l = 0;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 4;
    private static final int p = 8;
    private static final int q = 16;
    private static final int r = 32;
    private static final int s = 64;
    private static final int t = 128;
    private static final int u = 256;
    private static final int v = 512;
    private static final int w = 511;
    ArrayList a;
    private final AnimatorProxy b;
    private final WeakReference c;
    private long d;
    private boolean e;
    private long f;
    private boolean g;
    private Interpolator h;
    private boolean i;
    private com.nineoldandroids.animation.Animator.AnimatorListener j;
    private k k;
    private Runnable x;
    private HashMap y;

    i(View view)
    {
        e = false;
        f = 0L;
        g = false;
        i = false;
        j = null;
        k = new k(this, null);
        a = new ArrayList();
        x = new j(this);
        y = new HashMap();
        c = new WeakReference(view);
        b = AnimatorProxy.wrap(view);
    }

    private float a(int i1)
    {
        switch (i1)
        {
        default:
            return 0.0F;

        case 1: // '\001'
            return b.getTranslationX();

        case 2: // '\002'
            return b.getTranslationY();

        case 16: // '\020'
            return b.getRotation();

        case 32: // ' '
            return b.getRotationX();

        case 64: // '@'
            return b.getRotationY();

        case 4: // '\004'
            return b.getScaleX();

        case 8: // '\b'
            return b.getScaleY();

        case 128: 
            return b.getX();

        case 256: 
            return b.getY();

        case 512: 
            return b.getAlpha();
        }
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
                y.put(valueanimator, new m(k1, arraylist));
                valueanimator.addUpdateListener(k);
                valueanimator.addListener(k);
                if (g)
                {
                    valueanimator.setStartDelay(f);
                }
                if (e)
                {
                    valueanimator.setDuration(d);
                }
                if (i)
                {
                    valueanimator.setInterpolator(h);
                }
                valueanimator.start();
                return;
            }
            k1 |= ((l)arraylist.get(j1)).a;
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
        if (y.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = y.keySet().iterator();
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
        l l1 = new l(i1, f1, f2);
        a.add(l1);
        View view = (View)c.get();
        if (view != null)
        {
            view.removeCallbacks(x);
            view.post(x);
        }
        return;
_L4:
        m m1;
        animator = (Animator)iterator.next();
        m1 = (m)y.get(animator);
        if (!m1.a(i1) || m1.a != 0) goto _L6; else goto _L5
    }

    static void a(i i1)
    {
        i1.a();
    }

    static void a(i i1, int j1, float f1)
    {
        i1.c(j1, f1);
    }

    static void a(i i1, com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener)
    {
        i1.j = animatorlistener;
    }

    static com.nineoldandroids.animation.Animator.AnimatorListener b(i i1)
    {
        return i1.j;
    }

    private void b(int i1, float f1)
    {
        a(i1, a(i1), f1);
    }

    static HashMap c(i i1)
    {
        return i1.y;
    }

    private void c(int i1, float f1)
    {
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            b.setTranslationX(f1);
            return;

        case 2: // '\002'
            b.setTranslationY(f1);
            return;

        case 16: // '\020'
            b.setRotation(f1);
            return;

        case 32: // ' '
            b.setRotationX(f1);
            return;

        case 64: // '@'
            b.setRotationY(f1);
            return;

        case 4: // '\004'
            b.setScaleX(f1);
            return;

        case 8: // '\b'
            b.setScaleY(f1);
            return;

        case 128: 
            b.setX(f1);
            return;

        case 256: 
            b.setY(f1);
            return;

        case 512: 
            b.setAlpha(f1);
            break;
        }
    }

    static WeakReference d(i i1)
    {
        return i1.c;
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
        if (y.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = ((HashMap)y.clone()).keySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        a.clear();
        View view = (View)c.get();
        if (view != null)
        {
            view.removeCallbacks(x);
        }
        return;
_L3:
        ((Animator)iterator.next()).cancel();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public long getDuration()
    {
        if (e)
        {
            return d;
        } else
        {
            return (new ValueAnimator()).getDuration();
        }
    }

    public long getStartDelay()
    {
        if (g)
        {
            return f;
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
            e = true;
            d = l1;
            return this;
        }
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator)
    {
        i = true;
        h = interpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener)
    {
        j = animatorlistener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("Animators cannot have negative duration: ")).append(l1).toString());
        } else
        {
            g = true;
            f = l1;
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
