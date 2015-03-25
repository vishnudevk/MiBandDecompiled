// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.nineoldandroids.animation:
//            Animator, C, D, E, 
//            F, G, IntEvaluator, FloatEvaluator, 
//            H, PropertyValuesHolder, TypeEvaluator

public class ValueAnimator extends Animator
{

    private static long F = 0L;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int b = 0;
    static final int c = 1;
    static final int d = 0;
    static final int e = 1;
    static final int f = 2;
    private static final long m = 10L;
    private static ThreadLocal n = new ThreadLocal();
    private static final ThreadLocal o = new C();
    private static final ThreadLocal p = new D();
    private static final ThreadLocal q = new E();
    private static final ThreadLocal r = new F();
    private static final ThreadLocal s = new G();
    private static final Interpolator t = new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator u = new IntEvaluator();
    private static final TypeEvaluator v = new FloatEvaluator();
    private long A;
    private boolean B;
    private boolean C;
    private long D;
    private long E;
    private int G;
    private int H;
    private Interpolator I;
    private ArrayList J;
    long g;
    long h;
    int i;
    boolean j;
    PropertyValuesHolder k[];
    HashMap l;
    private boolean w;
    private int x;
    private float y;
    private boolean z;

    public ValueAnimator()
    {
        h = -1L;
        w = false;
        x = 0;
        y = 0.0F;
        z = false;
        i = 0;
        B = false;
        C = false;
        j = false;
        D = 300L;
        E = 0L;
        G = 0;
        H = 1;
        I = t;
        J = null;
    }

    static long a(ValueAnimator valueanimator)
    {
        return valueanimator.E;
    }

    static void a(ValueAnimator valueanimator, boolean flag)
    {
        valueanimator.B = flag;
    }

    private void a(boolean flag)
    {
        if (Looper.myLooper() == null)
        {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        w = flag;
        x = 0;
        i = 0;
        C = true;
        z = false;
        ((ArrayList)p.get()).add(this);
        if (E != 0L) goto _L2; else goto _L1
_L1:
        setCurrentPlayTime(getCurrentPlayTime());
        i = 0;
        B = true;
        if (a == null) goto _L2; else goto _L3
_L3:
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = (ArrayList)a.clone();
        i1 = arraylist.size();
        j1 = 0;
_L6:
        if (j1 < i1) goto _L4; else goto _L2
_L2:
        H h1 = (H)n.get();
        if (h1 == null)
        {
            h1 = new H(null);
            n.set(h1);
        }
        h1.sendEmptyMessage(0);
        return;
_L4:
        ((Animator.AnimatorListener)arraylist.get(j1)).onAnimationStart(this);
        j1++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(ValueAnimator valueanimator, long l1)
    {
        return valueanimator.b(l1);
    }

    static ThreadLocal b()
    {
        return o;
    }

    static void b(ValueAnimator valueanimator)
    {
        valueanimator.i();
    }

    private boolean b(long l1)
    {
        if (!z)
        {
            z = true;
            A = l1;
        } else
        {
            long l2 = l1 - A;
            if (l2 > E)
            {
                g = l1 - (l2 - E);
                i = 1;
                return true;
            }
        }
        return false;
    }

    static ThreadLocal c()
    {
        return q;
    }

    static void c(ValueAnimator valueanimator)
    {
        valueanimator.h();
    }

    public static void clearAllAnimations()
    {
        ((ArrayList)o.get()).clear();
        ((ArrayList)p.get()).clear();
        ((ArrayList)q.get()).clear();
    }

    static ThreadLocal d()
    {
        return p;
    }

    static ThreadLocal e()
    {
        return s;
    }

    static ThreadLocal f()
    {
        return r;
    }

    static long g()
    {
        return F;
    }

    public static int getCurrentAnimationsCount()
    {
        return ((ArrayList)o.get()).size();
    }

    public static long getFrameDelay()
    {
        return F;
    }

    private void h()
    {
        ((ArrayList)o.get()).remove(this);
        ((ArrayList)p.get()).remove(this);
        ((ArrayList)q.get()).remove(this);
        i = 0;
        if (!B || a == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = (ArrayList)a.clone();
        i1 = arraylist.size();
        j1 = 0;
_L5:
        if (j1 < i1) goto _L3; else goto _L2
_L2:
        B = false;
        C = false;
        return;
_L3:
        ((Animator.AnimatorListener)arraylist.get(j1)).onAnimationEnd(this);
        j1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void i()
    {
        a();
        ((ArrayList)o.get()).add(this);
        if (E <= 0L || a == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = (ArrayList)a.clone();
        i1 = arraylist.size();
        j1 = 0;
_L5:
        if (j1 < i1) goto _L3; else goto _L2
_L2:
        return;
_L3:
        ((Animator.AnimatorListener)arraylist.get(j1)).onAnimationStart(this);
        j1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static transient ValueAnimator ofFloat(float af[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setFloatValues(af);
        return valueanimator;
    }

    public static transient ValueAnimator ofInt(int ai[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setIntValues(ai);
        return valueanimator;
    }

    public static transient ValueAnimator ofObject(TypeEvaluator typeevaluator, Object aobj[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setObjectValues(aobj);
        valueanimator.setEvaluator(typeevaluator);
        return valueanimator;
    }

    public static transient ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder apropertyvaluesholder[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setValues(apropertyvaluesholder);
        return valueanimator;
    }

    public static void setFrameDelay(long l1)
    {
        F = l1;
    }

    void a()
    {
        if (j) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        i1 = k.length;
        j1 = 0;
_L6:
        if (j1 < i1) goto _L4; else goto _L3
_L3:
        j = true;
_L2:
        return;
_L4:
        k[j1].a();
        j1++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void a(float f1)
    {
        float f2;
        int i1;
        int j1;
        f2 = I.getInterpolation(f1);
        y = f2;
        i1 = k.length;
        j1 = 0;
_L5:
        if (j1 < i1) goto _L2; else goto _L1
_L1:
        if (J == null) goto _L4; else goto _L3
_L3:
        int k1;
        int l1;
        k1 = J.size();
        l1 = 0;
_L6:
        if (l1 < k1)
        {
            break MISSING_BLOCK_LABEL_75;
        }
_L4:
        return;
_L2:
        k[j1].a(f2);
        j1++;
          goto _L5
        ((AnimatorUpdateListener)J.get(l1)).onAnimationUpdate(this);
        l1++;
          goto _L6
    }

    boolean a(long l1)
    {
        boolean flag;
        float f1;
        float f2;
        int j1;
        flag = false;
        if (i == 0)
        {
            i = 1;
            if (h < 0L)
            {
                g = l1;
            } else
            {
                g = l1 - h;
                h = -1L;
            }
        }
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        int i1;
        if (D > 0L)
        {
            f1 = (float)(l1 - g) / (float)D;
        } else
        {
            f1 = 1.0F;
        }
        if (f1 < 1.0F)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        if (x >= G && G != -1) goto _L2; else goto _L1
_L1:
        if (a == null) goto _L4; else goto _L3
_L3:
        i1 = a.size();
        j1 = 0;
_L6:
        if (j1 < i1) goto _L5; else goto _L4
_L4:
        if (H == 2)
        {
            boolean flag1;
            if (w)
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            w = flag1;
        }
        x = x + (int)f1;
        f2 = f1 % 1.0F;
        g = g + D;
_L7:
        if (w)
        {
            f2 = 1.0F - f2;
        }
        a(f2);
        return flag;
_L5:
        ((Animator.AnimatorListener)a.get(j1)).onAnimationRepeat(this);
        j1++;
          goto _L6
_L2:
        f2 = Math.min(f1, 1.0F);
        flag = true;
          goto _L7
        f2 = f1;
        flag = false;
          goto _L7
    }

    public void addUpdateListener(AnimatorUpdateListener animatorupdatelistener)
    {
        if (J == null)
        {
            J = new ArrayList();
        }
        J.add(animatorupdatelistener);
    }

    public void cancel()
    {
        if (i == 0 && !((ArrayList)p.get()).contains(this) && !((ArrayList)q.get()).contains(this)) goto _L2; else goto _L1
_L1:
        if (!B || a == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = ((ArrayList)a.clone()).iterator();
_L7:
        if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
        h();
_L2:
        return;
_L5:
        ((Animator.AnimatorListener)iterator.next()).onAnimationCancel(this);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public volatile Animator clone()
    {
        return clone();
    }

    public ValueAnimator clone()
    {
        ValueAnimator valueanimator = (ValueAnimator)super.clone();
        if (J == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int k1;
        int l1;
        arraylist = J;
        valueanimator.J = new ArrayList();
        k1 = arraylist.size();
        l1 = 0;
_L6:
        if (l1 < k1) goto _L3; else goto _L2
_L2:
        PropertyValuesHolder apropertyvaluesholder[];
        valueanimator.h = -1L;
        valueanimator.w = false;
        valueanimator.x = 0;
        valueanimator.j = false;
        valueanimator.i = 0;
        valueanimator.z = false;
        apropertyvaluesholder = k;
        if (apropertyvaluesholder == null) goto _L5; else goto _L4
_L4:
        int i1;
        int j1;
        i1 = apropertyvaluesholder.length;
        valueanimator.k = new PropertyValuesHolder[i1];
        valueanimator.l = new HashMap(i1);
        j1 = 0;
_L7:
        if (j1 < i1)
        {
            break MISSING_BLOCK_LABEL_148;
        }
_L5:
        return valueanimator;
_L3:
        valueanimator.J.add((AnimatorUpdateListener)arraylist.get(l1));
        l1++;
          goto _L6
        PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[j1].clone();
        valueanimator.k[j1] = propertyvaluesholder;
        valueanimator.l.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
        j1++;
          goto _L7
    }

    public void end()
    {
        if (!((ArrayList)o.get()).contains(this) && !((ArrayList)p.get()).contains(this))
        {
            z = false;
            i();
        } else
        if (!j)
        {
            a();
        }
        if (G > 0 && (1 & G) == 1)
        {
            a(0.0F);
        } else
        {
            a(1.0F);
        }
        h();
    }

    public float getAnimatedFraction()
    {
        return y;
    }

    public Object getAnimatedValue()
    {
        if (k != null && k.length > 0)
        {
            return k[0].b();
        } else
        {
            return null;
        }
    }

    public Object getAnimatedValue(String s1)
    {
        PropertyValuesHolder propertyvaluesholder = (PropertyValuesHolder)l.get(s1);
        if (propertyvaluesholder != null)
        {
            return propertyvaluesholder.b();
        } else
        {
            return null;
        }
    }

    public long getCurrentPlayTime()
    {
        if (!j || i == 0)
        {
            return 0L;
        } else
        {
            return AnimationUtils.currentAnimationTimeMillis() - g;
        }
    }

    public long getDuration()
    {
        return D;
    }

    public Interpolator getInterpolator()
    {
        return I;
    }

    public int getRepeatCount()
    {
        return G;
    }

    public int getRepeatMode()
    {
        return H;
    }

    public long getStartDelay()
    {
        return E;
    }

    public PropertyValuesHolder[] getValues()
    {
        return k;
    }

    public boolean isRunning()
    {
        boolean flag = true;
        if (i != flag && !B)
        {
            flag = false;
        }
        return flag;
    }

    public boolean isStarted()
    {
        return C;
    }

    public void removeAllUpdateListeners()
    {
        if (J == null)
        {
            return;
        } else
        {
            J.clear();
            J = null;
            return;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorupdatelistener)
    {
        if (J != null)
        {
            J.remove(animatorupdatelistener);
            if (J.size() == 0)
            {
                J = null;
                return;
            }
        }
    }

    public void reverse()
    {
        boolean flag;
        if (w)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        w = flag;
        if (i == 1)
        {
            long l1 = AnimationUtils.currentAnimationTimeMillis();
            long l2 = l1 - g;
            g = l1 - (D - l2);
            return;
        } else
        {
            a(true);
            return;
        }
    }

    public void setCurrentPlayTime(long l1)
    {
        a();
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        if (i != 1)
        {
            h = l1;
            i = 2;
        }
        g = l2 - l1;
        a(l2);
    }

    public volatile Animator setDuration(long l1)
    {
        return setDuration(l1);
    }

    public ValueAnimator setDuration(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("Animators cannot have negative duration: ")).append(l1).toString());
        } else
        {
            D = l1;
            return this;
        }
    }

    public void setEvaluator(TypeEvaluator typeevaluator)
    {
        if (typeevaluator != null && k != null && k.length > 0)
        {
            k[0].setEvaluator(typeevaluator);
        }
    }

    public transient void setFloatValues(float af[])
    {
        if (af == null || af.length == 0)
        {
            return;
        }
        if (k == null || k.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofFloat("", af);
            setValues(apropertyvaluesholder);
        } else
        {
            k[0].setFloatValues(af);
        }
        j = false;
    }

    public transient void setIntValues(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            return;
        }
        if (k == null || k.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofInt("", ai);
            setValues(apropertyvaluesholder);
        } else
        {
            k[0].setIntValues(ai);
        }
        j = false;
    }

    public void setInterpolator(Interpolator interpolator)
    {
        if (interpolator != null)
        {
            I = interpolator;
            return;
        } else
        {
            I = new LinearInterpolator();
            return;
        }
    }

    public transient void setObjectValues(Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return;
        }
        if (k == null || k.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofObject("", null, aobj);
            setValues(apropertyvaluesholder);
        } else
        {
            k[0].setObjectValues(aobj);
        }
        j = false;
    }

    public void setRepeatCount(int i1)
    {
        G = i1;
    }

    public void setRepeatMode(int i1)
    {
        H = i1;
    }

    public void setStartDelay(long l1)
    {
        E = l1;
    }

    public transient void setValues(PropertyValuesHolder apropertyvaluesholder[])
    {
        int i1 = apropertyvaluesholder.length;
        k = apropertyvaluesholder;
        l = new HashMap(i1);
        int j1 = 0;
        do
        {
            if (j1 >= i1)
            {
                j = false;
                return;
            }
            PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[j1];
            l.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
            j1++;
        } while (true);
    }

    public void start()
    {
        a(false);
    }

    public String toString()
    {
        String s1 = (new StringBuilder("ValueAnimator@")).append(Integer.toHexString(hashCode())).toString();
        if (k == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L5:
        if (i1 < k.length) goto _L3; else goto _L2
_L2:
        return s1;
_L3:
        s1 = (new StringBuilder(String.valueOf(s1))).append("\n    ").append(k[i1].toString()).toString();
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        F = 10L;
    }

    private class AnimatorUpdateListener
    {

        public abstract void onAnimationUpdate(ValueAnimator valueanimator);
    }

}
