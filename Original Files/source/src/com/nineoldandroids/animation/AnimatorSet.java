// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nineoldandroids.animation:
//            Animator, e, c, ValueAnimator, 
//            b, ObjectAnimator, d, a

public final class AnimatorSet extends Animator
{

    boolean b;
    private ArrayList c;
    private HashMap d;
    private ArrayList e;
    private ArrayList f;
    private boolean g;
    private b h;
    private boolean i;
    private long j;
    private ValueAnimator k;
    private long l;

    public AnimatorSet()
    {
        c = new ArrayList();
        d = new HashMap();
        e = new ArrayList();
        f = new ArrayList();
        g = true;
        h = null;
        b = false;
        i = false;
        j = 0L;
        k = null;
        l = -1L;
    }

    static ArrayList a(AnimatorSet animatorset)
    {
        return animatorset.c;
    }

    private void a()
    {
        if (!g) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i2;
        int j2;
        f.clear();
        arraylist = new ArrayList();
        i2 = e.size();
        j2 = 0;
_L8:
        if (j2 < i2) goto _L4; else goto _L3
_L3:
        ArrayList arraylist1 = new ArrayList();
_L9:
        if (arraylist.size() > 0) goto _L6; else goto _L5
_L5:
        g = false;
        if (f.size() != e.size())
        {
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        }
          goto _L7
_L4:
        e e4 = (e)e.get(j2);
        if (e4.b == null || e4.b.size() == 0)
        {
            arraylist.add(e4);
        }
        j2++;
          goto _L8
_L6:
        int k2;
        int l2;
        k2 = arraylist.size();
        l2 = 0;
_L12:
label0:
        {
            if (l2 < k2)
            {
                break label0;
            }
            arraylist.clear();
            arraylist.addAll(arraylist1);
            arraylist1.clear();
        }
          goto _L9
        e e2;
        e2 = (e)arraylist.get(l2);
        f.add(e2);
        if (e2.e == null) goto _L11; else goto _L10
_L10:
        int i3;
        int j3;
        i3 = e2.e.size();
        j3 = 0;
_L13:
        if (j3 < i3)
        {
            break MISSING_BLOCK_LABEL_232;
        }
_L11:
        l2++;
          goto _L12
        e e3 = (e)e2.e.get(j3);
        e3.d.remove(e2);
        if (e3.d.size() == 0)
        {
            arraylist1.add(e3);
        }
        j3++;
          goto _L13
_L2:
        int i1;
        int j1;
        i1 = e.size();
        j1 = 0;
_L17:
        if (j1 < i1) goto _L14; else goto _L7
_L7:
        return;
_L14:
        e e1 = (e)e.get(j1);
        if (e1.b == null || e1.b.size() <= 0) goto _L16; else goto _L15
_L15:
        int k1;
        int l1;
        k1 = e1.b.size();
        l1 = 0;
_L18:
        if (l1 < k1)
        {
            break MISSING_BLOCK_LABEL_358;
        }
_L16:
        e1.f = false;
        j1++;
          goto _L17
        c c1 = (c)e1.b.get(l1);
        if (e1.d == null)
        {
            e1.d = new ArrayList();
        }
        if (!e1.d.contains(c1.c))
        {
            e1.d.add(c1.c);
        }
        l1++;
          goto _L18
    }

    static void a(AnimatorSet animatorset, boolean flag)
    {
        animatorset.i = flag;
    }

    static HashMap b(AnimatorSet animatorset)
    {
        return animatorset.d;
    }

    static ArrayList c(AnimatorSet animatorset)
    {
        return animatorset.f;
    }

    static ArrayList d(AnimatorSet animatorset)
    {
        return animatorset.e;
    }

    public void cancel()
    {
        b = true;
        if (!isStarted()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist1;
        Iterator iterator2;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        arraylist1 = (ArrayList)a.clone();
        iterator2 = arraylist1.iterator();
_L8:
        if (iterator2.hasNext()) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = arraylist1;
_L10:
        Iterator iterator1;
        if (k != null && k.isRunning())
        {
            k.cancel();
        } else
        if (f.size() > 0)
        {
            Iterator iterator = f.iterator();
            while (iterator.hasNext()) 
            {
                ((e)iterator.next()).a.cancel();
            }
        }
        if (arraylist == null) goto _L6; else goto _L5
_L5:
        iterator1 = arraylist.iterator();
_L9:
        if (iterator1.hasNext()) goto _L7; else goto _L6
_L6:
        i = false;
_L2:
        return;
_L4:
        ((Animator.AnimatorListener)iterator2.next()).onAnimationCancel(this);
          goto _L8
_L7:
        ((Animator.AnimatorListener)iterator1.next()).onAnimationEnd(this);
          goto _L9
        arraylist = null;
          goto _L10
    }

    public volatile Animator clone()
    {
        return clone();
    }

    public AnimatorSet clone()
    {
        AnimatorSet animatorset;
        HashMap hashmap;
        Iterator iterator;
        animatorset = (AnimatorSet)super.clone();
        animatorset.g = true;
        animatorset.b = false;
        animatorset.i = false;
        animatorset.c = new ArrayList();
        animatorset.d = new HashMap();
        animatorset.e = new ArrayList();
        animatorset.f = new ArrayList();
        hashmap = new HashMap();
        iterator = e.iterator();
_L4:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Iterator iterator3 = e.iterator();
_L6:
        if (!iterator3.hasNext())
        {
            return animatorset;
        }
        break MISSING_BLOCK_LABEL_310;
_L2:
        ArrayList arraylist;
        e e1 = (e)iterator.next();
        e e2 = e1.a();
        hashmap.put(e1, e2);
        animatorset.e.add(e2);
        animatorset.d.put(e2.a, e2);
        e2.b = null;
        e2.c = null;
        e2.e = null;
        e2.d = null;
        arraylist = e2.a.getListeners();
        if (arraylist == null) goto _L4; else goto _L3
_L3:
        Iterator iterator1;
        ArrayList arraylist1;
        iterator1 = arraylist.iterator();
        arraylist1 = null;
_L5:
label0:
        {
            if (iterator1.hasNext())
            {
                break label0;
            }
            if (arraylist1 != null)
            {
                Iterator iterator2 = arraylist1.iterator();
                while (iterator2.hasNext()) 
                {
                    arraylist.remove((Animator.AnimatorListener)iterator2.next());
                }
            }
        }
          goto _L4
        Animator.AnimatorListener animatorlistener = (Animator.AnimatorListener)iterator1.next();
        if (animatorlistener instanceof b)
        {
            if (arraylist1 == null)
            {
                arraylist1 = new ArrayList();
            }
            arraylist1.add(animatorlistener);
        }
          goto _L5
        e e3 = (e)iterator3.next();
        e e4 = (e)hashmap.get(e3);
        if (e3.b != null)
        {
            Iterator iterator4 = e3.b.iterator();
            while (iterator4.hasNext()) 
            {
                c c1 = (c)iterator4.next();
                e4.a(new c((e)hashmap.get(c1.c), c1.d));
            }
        }
          goto _L6
    }

    public void end()
    {
        b = true;
        if (!isStarted()) goto _L2; else goto _L1
_L1:
        if (f.size() == e.size()) goto _L4; else goto _L3
_L3:
        Iterator iterator2;
        a();
        iterator2 = f.iterator();
_L7:
        if (iterator2.hasNext()) goto _L5; else goto _L4
_L4:
        if (k != null)
        {
            k.cancel();
        }
        if (f.size() > 0)
        {
            e e1;
            for (Iterator iterator1 = f.iterator(); iterator1.hasNext(); ((e)iterator1.next()).a.end())
            {
                break MISSING_BLOCK_LABEL_173;
            }

        }
        if (a != null)
        {
            for (Iterator iterator = ((ArrayList)a.clone()).iterator(); iterator.hasNext(); ((Animator.AnimatorListener)iterator.next()).onAnimationEnd(this))
            {
                break MISSING_BLOCK_LABEL_191;
            }

        }
        i = false;
_L2:
        return;
_L5:
        e1 = (e)iterator2.next();
        if (h == null)
        {
            h = new b(this, this);
        }
        e1.a.addListener(h);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public ArrayList getChildAnimations()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return arraylist;
            }
            arraylist.add(((e)iterator.next()).a);
        } while (true);
    }

    public long getDuration()
    {
        return l;
    }

    public long getStartDelay()
    {
        return j;
    }

    public boolean isRunning()
    {
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }
        } while (!((e)iterator.next()).a.isRunning());
        return true;
    }

    public boolean isStarted()
    {
        return i;
    }

    public Builder play(Animator animator)
    {
        if (animator != null)
        {
            g = true;
            return new Builder(animator);
        } else
        {
            return null;
        }
    }

    public void playSequentially(List list)
    {
        if (list != null && list.size() > 0)
        {
            g = true;
            if (list.size() == 1)
            {
                play((Animator)list.get(0));
            } else
            {
                int i1 = 0;
                while (i1 < -1 + list.size()) 
                {
                    play((Animator)list.get(i1)).before((Animator)list.get(i1 + 1));
                    i1++;
                }
            }
        }
    }

    public transient void playSequentially(Animator aanimator[])
    {
        int j1;
label0:
        {
            if (aanimator != null)
            {
                g = true;
                int i1 = aanimator.length;
                j1 = 0;
                if (i1 != 1)
                {
                    break label0;
                }
                play(aanimator[0]);
            }
            return;
        }
        for (; j1 < -1 + aanimator.length; j1++)
        {
            play(aanimator[j1]).before(aanimator[j1 + 1]);
        }

    }

    public void playTogether(Collection collection)
    {
        if (collection == null || collection.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        Builder builder;
        g = true;
        iterator = collection.iterator();
        builder = null;
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        Animator animator = (Animator)iterator.next();
        if (builder == null)
        {
            builder = play(animator);
        } else
        {
            builder.with(animator);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public transient void playTogether(Animator aanimator[])
    {
        boolean flag = true;
        if (aanimator == null) goto _L2; else goto _L1
_L1:
        Builder builder;
        g = flag;
        builder = play(aanimator[0]);
_L5:
        if (flag < aanimator.length) goto _L3; else goto _L2
_L2:
        return;
_L3:
        builder.with(aanimator[flag]);
        flag++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile Animator setDuration(long l1)
    {
        return setDuration(l1);
    }

    public AnimatorSet setDuration(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                l = l1;
                return this;
            }
            ((e)iterator.next()).a.setDuration(l1);
        } while (true);
    }

    public void setInterpolator(Interpolator interpolator)
    {
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((e)iterator.next()).a.setInterpolator(interpolator);
        } while (true);
    }

    public void setStartDelay(long l1)
    {
        j = l1;
    }

    public void setTarget(Object obj)
    {
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Animator animator = ((e)iterator.next()).a;
            if (animator instanceof AnimatorSet)
            {
                ((AnimatorSet)animator).setTarget(obj);
            } else
            if (animator instanceof ObjectAnimator)
            {
                ((ObjectAnimator)animator).setTarget(obj);
            }
        } while (true);
    }

    public void setupEndValues()
    {
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((e)iterator.next()).a.setupEndValues();
        } while (true);
    }

    public void setupStartValues()
    {
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((e)iterator.next()).a.setupStartValues();
        } while (true);
    }

    public void start()
    {
        int i1;
        int j1;
        int k1;
        i1 = 0;
        b = false;
        i = true;
        a();
        j1 = f.size();
        k1 = 0;
_L17:
        if (k1 < j1) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int l1;
        arraylist = new ArrayList();
        l1 = 0;
_L21:
        if (l1 < j1) goto _L4; else goto _L3
_L3:
        if (j > 0L) goto _L6; else goto _L5
_L5:
        Iterator iterator = arraylist.iterator();
_L24:
        if (iterator.hasNext()) goto _L8; else goto _L7
_L7:
        if (a == null) goto _L10; else goto _L9
_L9:
        ArrayList arraylist2;
        int l2;
        int i3;
        arraylist2 = (ArrayList)a.clone();
        l2 = arraylist2.size();
        i3 = 0;
_L25:
        if (i3 < l2) goto _L11; else goto _L10
_L10:
        if (e.size() != 0 || j != 0L) goto _L13; else goto _L12
_L12:
        i = false;
        if (a == null) goto _L13; else goto _L14
_L14:
        ArrayList arraylist1;
        int k2;
        arraylist1 = (ArrayList)a.clone();
        k2 = arraylist1.size();
_L26:
        if (i1 < k2)
        {
            break MISSING_BLOCK_LABEL_555;
        }
_L13:
        return;
_L2:
        e e3;
        ArrayList arraylist3;
        e3 = (e)f.get(k1);
        arraylist3 = e3.a.getListeners();
        if (arraylist3 == null || arraylist3.size() <= 0) goto _L16; else goto _L15
_L15:
        Iterator iterator1 = (new ArrayList(arraylist3)).iterator();
_L18:
        if (iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_234;
        }
_L16:
        k1++;
          goto _L17
        Animator.AnimatorListener animatorlistener = (Animator.AnimatorListener)iterator1.next();
        if ((animatorlistener instanceof d) || (animatorlistener instanceof b))
        {
            e3.a.removeListener(animatorlistener);
        }
          goto _L18
_L4:
        e e1;
        e1 = (e)f.get(l1);
        if (h == null)
        {
            h = new b(this, this);
        }
        if (e1.b != null && e1.b.size() != 0) goto _L20; else goto _L19
_L19:
        arraylist.add(e1);
_L22:
        e1.a.addListener(h);
        l1++;
          goto _L21
_L20:
        int i2;
        int j2;
        i2 = e1.b.size();
        j2 = 0;
_L23:
label0:
        {
            if (j2 < i2)
            {
                break label0;
            }
            e1.c = (ArrayList)e1.b.clone();
        }
          goto _L22
        c c1 = (c)e1.b.get(j2);
        c1.c.a.addListener(new d(this, e1, c1.d));
        j2++;
          goto _L23
_L8:
        e e2 = (e)iterator.next();
        e2.a.start();
        c.add(e2.a);
          goto _L24
_L6:
        k = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        k.setDuration(j);
        k.addListener(new a(this, arraylist));
        k.start();
          goto _L7
_L11:
        ((Animator.AnimatorListener)arraylist2.get(i3)).onAnimationStart(this);
        i3++;
          goto _L25
        ((Animator.AnimatorListener)arraylist1.get(i1)).onAnimationEnd(this);
        i1++;
          goto _L26
    }

    private class Builder
    {

        final AnimatorSet a;
        private e b;

        public Builder after(long l1)
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.setDuration(l1);
            after(((Animator) (valueanimator)));
            return this;
        }

        public Builder after(Animator animator)
        {
            e e1 = (e)AnimatorSet.b(a).get(animator);
            if (e1 == null)
            {
                e1 = new e(animator);
                AnimatorSet.b(a).put(animator, e1);
                AnimatorSet.d(a).add(e1);
            }
            c c1 = new c(e1, 1);
            b.a(c1);
            return this;
        }

        public Builder before(Animator animator)
        {
            e e1 = (e)AnimatorSet.b(a).get(animator);
            if (e1 == null)
            {
                e1 = new e(animator);
                AnimatorSet.b(a).put(animator, e1);
                AnimatorSet.d(a).add(e1);
            }
            e1.a(new c(b, 1));
            return this;
        }

        public Builder with(Animator animator)
        {
            e e1 = (e)AnimatorSet.b(a).get(animator);
            if (e1 == null)
            {
                e1 = new e(animator);
                AnimatorSet.b(a).put(animator, e1);
                AnimatorSet.d(a).add(e1);
            }
            e1.a(new c(b, 0));
            return this;
        }

        Builder(Animator animator)
        {
            a = AnimatorSet.this;
            super();
            b = (e)AnimatorSet.b(AnimatorSet.this).get(animator);
            if (b == null)
            {
                b = new e(animator);
                AnimatorSet.b(AnimatorSet.this).put(animator, b);
                AnimatorSet.d(AnimatorSet.this).add(b);
            }
        }
    }

}
