// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            FragmentManager, w, FragmentActivity, Fragment, 
//            J, FragmentManagerState, FragmentState, BackStackState, 
//            l, ae, P, u, 
//            A, x, z, y, 
//            FragmentTransaction

final class v extends FragmentManager
{

    static final Interpolator E = new DecelerateInterpolator(2.5F);
    static final Interpolator F = new DecelerateInterpolator(1.5F);
    static final Interpolator G = new AccelerateInterpolator(2.5F);
    static final Interpolator H = new AccelerateInterpolator(1.5F);
    static final int I = 220;
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;
    public static final int M = 4;
    public static final int N = 5;
    public static final int O = 6;
    static boolean a = false;
    static final String b = "FragmentManager";
    static final boolean c = false;
    static final String d = "android:target_req_state";
    static final String e = "android:target_state";
    static final String f = "android:view_state";
    static final String g = "android:user_visible_hint";
    boolean A;
    Bundle B;
    SparseArray C;
    Runnable D;
    ArrayList h;
    Runnable i[];
    boolean j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    ArrayList n;
    ArrayList o;
    ArrayList p;
    ArrayList q;
    ArrayList r;
    int s;
    FragmentActivity t;
    u u;
    Fragment v;
    boolean w;
    boolean x;
    boolean y;
    String z;

    v()
    {
        s = 0;
        B = null;
        C = null;
        D = new w(this);
    }

    static Animation a(Context context, float f1, float f2)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f2);
        alphaanimation.setInterpolator(F);
        alphaanimation.setDuration(220L);
        return alphaanimation;
    }

    static Animation a(Context context, float f1, float f2, float f3, float f4)
    {
        AnimationSet animationset = new AnimationSet(false);
        ScaleAnimation scaleanimation = new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        scaleanimation.setInterpolator(E);
        scaleanimation.setDuration(220L);
        animationset.addAnimation(scaleanimation);
        AlphaAnimation alphaanimation = new AlphaAnimation(f3, f4);
        alphaanimation.setInterpolator(F);
        alphaanimation.setDuration(220L);
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printwriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (t != null)
        {
            try
            {
                t.dump("  ", null, printwriter, new String[0]);
            }
            catch (Exception exception1)
            {
                Log.e("FragmentManager", "Failed dumping state", exception1);
            }
        } else
        {
            try
            {
                dump("  ", null, printwriter, new String[0]);
            }
            catch (Exception exception)
            {
                Log.e("FragmentManager", "Failed dumping state", exception);
            }
        }
        throw runtimeexception;
    }

    public static int b(int i1)
    {
        switch (i1)
        {
        default:
            return 0;

        case 4097: 
            return 8194;

        case 8194: 
            return 4097;

        case 4099: 
            return 4099;
        }
    }

    public static int b(int i1, boolean flag)
    {
        switch (i1)
        {
        default:
            return -1;

        case 4097: 
            return !flag ? 2 : 1;

        case 8194: 
            return !flag ? 4 : 3;

        case 4099: 
            break;
        }
        return !flag ? 6 : 5;
    }

    private void q()
    {
        if (x)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (z != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Can not perform this action inside of ").append(z).toString());
        } else
        {
            return;
        }
    }

    public int a(l l1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (q != null && q.size() > 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (p == null)
        {
            p = new ArrayList();
        }
        i1 = p.size();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(l1).toString());
        }
        p.add(l1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        int j1;
        j1 = ((Integer)q.remove(-1 + q.size())).intValue();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(j1).append(" with ").append(l1).toString());
        }
        p.set(j1, l1);
        this;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Fragment a(String s1)
    {
        if (k != null && s1 != null)
        {
            for (int i1 = -1 + k.size(); i1 >= 0; i1--)
            {
                Fragment fragment = (Fragment)k.get(i1);
                if (fragment == null)
                {
                    continue;
                }
                Fragment fragment1 = fragment.a(s1);
                if (fragment1 != null)
                {
                    return fragment1;
                }
            }

        }
        return null;
    }

    Animation a(Fragment fragment, int i1, boolean flag, int j1)
    {
        Animation animation = fragment.onCreateAnimation(i1, flag, fragment.V);
        if (animation == null)
        {
            if (fragment.V == 0 || (animation = AnimationUtils.loadAnimation(t, fragment.V)) == null)
            {
                if (i1 == 0)
                {
                    return null;
                }
                int k1 = b(i1, flag);
                if (k1 < 0)
                {
                    return null;
                }
                switch (k1)
                {
                default:
                    if (j1 == 0 && t.getWindow() != null)
                    {
                        j1 = t.getWindow().getAttributes().windowAnimations;
                    }
                    if (j1 == 0)
                    {
                        return null;
                    } else
                    {
                        return null;
                    }

                case 1: // '\001'
                    return a(((Context) (t)), 1.125F, 1.0F, 0.0F, 1.0F);

                case 2: // '\002'
                    return a(((Context) (t)), 1.0F, 0.975F, 1.0F, 0.0F);

                case 3: // '\003'
                    return a(((Context) (t)), 0.975F, 1.0F, 0.0F, 1.0F);

                case 4: // '\004'
                    return a(((Context) (t)), 1.0F, 1.075F, 1.0F, 0.0F);

                case 5: // '\005'
                    return a(((Context) (t)), 0.0F, 1.0F);

                case 6: // '\006'
                    return a(((Context) (t)), 1.0F, 0.0F);
                }
            }
        }
        return animation;
    }

    void a()
    {
        if (k != null)
        {
            int i1 = 0;
            while (i1 < k.size()) 
            {
                Fragment fragment = (Fragment)k.get(i1);
                if (fragment != null)
                {
                    a(fragment);
                }
                i1++;
            }
        }
    }

    public void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        p.set(i1, null);
        if (q == null)
        {
            q = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing back stack index ").append(i1).toString());
        }
        q.add(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(int i1, int j1, int k1, boolean flag)
    {
        if (t == null && i1 != 0)
        {
            throw new IllegalStateException("No activity");
        }
        if (flag || s != i1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        s = i1;
        if (k == null) goto _L1; else goto _L3
_L3:
        int l1;
        boolean flag1;
        l1 = 0;
        flag1 = false;
_L5:
        boolean flag2;
        if (l1 >= k.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Fragment fragment = (Fragment)k.get(l1);
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        a(fragment, i1, j1, k1, false);
        if (fragment.ab == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        flag2 = flag1 | fragment.ab.hasRunningLoaders();
_L6:
        l1++;
        flag1 = flag2;
        if (true) goto _L5; else goto _L4
_L4:
        if (!flag1)
        {
            a();
        }
        if (w && t != null && s == 5)
        {
            t.supportInvalidateOptionsMenu();
            w = false;
            return;
        }
          goto _L1
        flag2 = flag1;
          goto _L6
    }

    public void a(int i1, l l1)
    {
        this;
        JVM INSTR monitorenter ;
        int j1;
        if (p == null)
        {
            p = new ArrayList();
        }
        j1 = p.size();
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(l1).toString());
        }
        p.set(i1, l1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        p.add(null);
        if (q == null)
        {
            q = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding available back stack index ").append(j1).toString());
        }
        q.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(i1).append(" with ").append(l1).toString());
        }
        p.add(l1);
          goto _L4
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(int i1, boolean flag)
    {
        a(i1, 0, 0, flag);
    }

    public void a(Configuration configuration)
    {
        if (l != null)
        {
            for (int i1 = 0; i1 < l.size(); i1++)
            {
                Fragment fragment = (Fragment)l.get(i1);
                if (fragment != null)
                {
                    fragment.a(configuration);
                }
            }

        }
    }

    void a(Parcelable parcelable, ArrayList arraylist)
    {
        if (parcelable != null) goto _L2; else goto _L1
_L1:
        FragmentManagerState fragmentmanagerstate;
        return;
_L2:
        if ((fragmentmanagerstate = (FragmentManagerState)parcelable).a != null)
        {
            if (arraylist != null)
            {
                for (int j2 = 0; j2 < arraylist.size(); j2++)
                {
                    Fragment fragment3 = (Fragment)arraylist.get(j2);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: re-attaching retained ").append(fragment3).toString());
                    }
                    FragmentState fragmentstate1 = fragmentmanagerstate.a[fragment3.u];
                    fragmentstate1.k = fragment3;
                    fragment3.t = null;
                    fragment3.G = 0;
                    fragment3.E = false;
                    fragment3.A = false;
                    fragment3.x = null;
                    if (fragmentstate1.j != null)
                    {
                        fragmentstate1.j.setClassLoader(t.getClassLoader());
                        fragment3.t = fragmentstate1.j.getSparseParcelableArray("android:view_state");
                    }
                }

            }
            k = new ArrayList(fragmentmanagerstate.a.length);
            if (m != null)
            {
                m.clear();
            }
            int i1 = 0;
            while (i1 < fragmentmanagerstate.a.length) 
            {
                FragmentState fragmentstate = fragmentmanagerstate.a[i1];
                if (fragmentstate != null)
                {
                    Fragment fragment2 = fragmentstate.a(t, v);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: active #").append(i1).append(": ").append(fragment2).toString());
                    }
                    k.add(fragment2);
                    fragmentstate.k = null;
                } else
                {
                    k.add(null);
                    if (m == null)
                    {
                        m = new ArrayList();
                    }
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: avail #").append(i1).toString());
                    }
                    m.add(Integer.valueOf(i1));
                }
                i1++;
            }
            if (arraylist != null)
            {
                int i2 = 0;
                while (i2 < arraylist.size()) 
                {
                    Fragment fragment1 = (Fragment)arraylist.get(i2);
                    if (fragment1.y >= 0)
                    {
                        if (fragment1.y < k.size())
                        {
                            fragment1.x = (Fragment)k.get(fragment1.y);
                        } else
                        {
                            Log.w("FragmentManager", (new StringBuilder()).append("Re-attaching retained fragment ").append(fragment1).append(" target no longer exists: ").append(fragment1.y).toString());
                            fragment1.x = null;
                        }
                    }
                    i2++;
                }
            }
            if (fragmentmanagerstate.b != null)
            {
                l = new ArrayList(fragmentmanagerstate.b.length);
                for (int k1 = 0; k1 < fragmentmanagerstate.b.length; k1++)
                {
                    Fragment fragment = (Fragment)k.get(fragmentmanagerstate.b[k1]);
                    if (fragment == null)
                    {
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("No instantiated fragment for index #").append(fragmentmanagerstate.b[k1]).toString()))));
                    }
                    fragment.A = true;
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: added #").append(k1).append(": ").append(fragment).toString());
                    }
                    if (l.contains(fragment))
                    {
                        throw new IllegalStateException("Already added!");
                    }
                    l.add(fragment);
                }

            } else
            {
                l = null;
            }
            if (fragmentmanagerstate.c != null)
            {
                n = new ArrayList(fragmentmanagerstate.c.length);
                int j1 = 0;
                while (j1 < fragmentmanagerstate.c.length) 
                {
                    l l1 = fragmentmanagerstate.c[j1].a(this);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: back stack #").append(j1).append(" (index ").append(l1.x).append("): ").append(l1).toString());
                        l1.a("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                    }
                    n.add(l1);
                    if (l1.x >= 0)
                    {
                        a(l1.x, l1);
                    }
                    j1++;
                }
            } else
            {
                n = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(Fragment fragment)
    {
label0:
        {
            if (fragment.Z)
            {
                if (!j)
                {
                    break label0;
                }
                A = true;
            }
            return;
        }
        fragment.Z = false;
        a(fragment, s, 0, 0, false);
    }

    public void a(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("remove: ").append(fragment).append(" nesting=").append(fragment.G).toString());
        }
        boolean flag;
        if (!fragment.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!fragment.P || flag)
        {
            if (l != null)
            {
                l.remove(fragment);
            }
            if (fragment.S && fragment.T)
            {
                w = true;
            }
            fragment.A = false;
            fragment.B = true;
            int k1;
            if (flag)
            {
                k1 = 0;
            } else
            {
                k1 = 1;
            }
            a(fragment, k1, i1, j1, false);
        }
    }

    void a(Fragment fragment, int i1, int j1, int k1, boolean flag)
    {
        if ((!fragment.A || fragment.P) && i1 > 1)
        {
            i1 = 1;
        }
        if (fragment.B && i1 > fragment.p)
        {
            i1 = fragment.p;
        }
        if (fragment.Z && fragment.p < 4 && i1 > 3)
        {
            i1 = 3;
        }
        if (fragment.p >= i1) goto _L2; else goto _L1
_L1:
        if (fragment.D && !fragment.E)
        {
            return;
        }
        if (fragment.q != null)
        {
            fragment.q = null;
            a(fragment, fragment.r, 0, 0, true);
        }
        fragment.p;
        JVM INSTR tableswitch 0 4: default 148
    //                   0 154
    //                   1 495
    //                   2 792
    //                   3 792
    //                   4 833;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        fragment.p = i1;
        return;
_L4:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("moveto CREATED: ").append(fragment).toString());
        }
        if (fragment.s != null)
        {
            fragment.t = fragment.s.getSparseParcelableArray("android:view_state");
            fragment.x = getFragment(fragment.s, "android:target_state");
            if (fragment.x != null)
            {
                fragment.z = fragment.s.getInt("android:target_req_state", 0);
            }
            fragment.aa = fragment.s.getBoolean("android:user_visible_hint", true);
            if (!fragment.aa)
            {
                fragment.Z = true;
                if (i1 > 3)
                {
                    i1 = 3;
                }
            }
        }
        fragment.I = t;
        fragment.K = v;
        v v1;
        if (v != null)
        {
            v1 = v.J;
        } else
        {
            v1 = t.e;
        }
        fragment.H = v1;
        fragment.U = false;
        fragment.onAttach(t);
        if (!fragment.U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.K == null)
        {
            t.onAttachFragment(fragment);
        }
        if (!fragment.R)
        {
            fragment.b(fragment.s);
        }
        fragment.R = false;
        if (fragment.D)
        {
            fragment.X = fragment.a(fragment.getLayoutInflater(fragment.s), null, fragment.s);
            Animation animation1;
            if (fragment.X != null)
            {
                fragment.Y = fragment.X;
                fragment.X = P.a(fragment.X);
                if (fragment.O)
                {
                    fragment.X.setVisibility(8);
                }
                fragment.onViewCreated(fragment.X, fragment.s);
            } else
            {
                fragment.Y = null;
            }
        }
_L5:
        if (i1 > 1)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto ACTIVITY_CREATED: ").append(fragment).toString());
            }
            if (!fragment.D)
            {
                View view;
                Animation animation;
                ViewGroup viewgroup;
                if (fragment.M != 0)
                {
                    viewgroup = (ViewGroup)u.a(fragment.M);
                    if (viewgroup == null && !fragment.F)
                    {
                        a(((RuntimeException) (new IllegalArgumentException((new StringBuilder()).append("No view found for id 0x").append(Integer.toHexString(fragment.M)).append(" (").append(fragment.getResources().getResourceName(fragment.M)).append(") for fragment ").append(fragment).toString()))));
                    }
                } else
                {
                    viewgroup = null;
                }
                fragment.W = viewgroup;
                fragment.X = fragment.a(fragment.getLayoutInflater(fragment.s), viewgroup, fragment.s);
                if (fragment.X != null)
                {
                    fragment.Y = fragment.X;
                    fragment.X = P.a(fragment.X);
                    if (viewgroup != null)
                    {
                        animation1 = a(fragment, j1, true, k1);
                        if (animation1 != null)
                        {
                            fragment.X.startAnimation(animation1);
                        }
                        viewgroup.addView(fragment.X);
                    }
                    if (fragment.O)
                    {
                        fragment.X.setVisibility(8);
                    }
                    fragment.onViewCreated(fragment.X, fragment.s);
                } else
                {
                    fragment.Y = null;
                }
            }
            fragment.c(fragment.s);
            if (fragment.X != null)
            {
                fragment.a(fragment.s);
            }
            fragment.s = null;
        }
_L6:
        if (i1 > 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto STARTED: ").append(fragment).toString());
            }
            fragment.d();
        }
_L7:
        if (i1 > 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto RESUMED: ").append(fragment).toString());
            }
            fragment.C = true;
            fragment.e();
            fragment.s = null;
            fragment.t = null;
        }
          goto _L8
_L2:
        if (fragment.p <= i1) goto _L8; else goto _L9
_L9:
        fragment.p;
        JVM INSTR tableswitch 1 5: default 956
    //                   1 959
    //                   2 1139
    //                   3 1098
    //                   4 1057
    //                   5 1011;
           goto _L10 _L11 _L12 _L13 _L14 _L15
_L10:
        break; /* Loop/switch isn't completed */
_L11:
        if (i1 < 1)
        {
            if (y && fragment.q != null)
            {
                view = fragment.q;
                fragment.q = null;
                view.clearAnimation();
            }
            if (fragment.q != null)
            {
                fragment.r = i1;
                i1 = 1;
            } else
            {
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("movefrom CREATED: ").append(fragment).toString());
                }
                if (!fragment.R)
                {
                    fragment.k();
                }
                fragment.U = false;
                fragment.onDetach();
                if (!fragment.U)
                {
                    throw new ae((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDetach()").toString());
                }
                if (!flag)
                {
                    if (!fragment.R)
                    {
                        d(fragment);
                    } else
                    {
                        fragment.I = null;
                        fragment.H = null;
                    }
                }
            }
        }
        break; /* Loop/switch isn't completed */
_L15:
        if (i1 < 5)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom RESUMED: ").append(fragment).toString());
            }
            fragment.g();
            fragment.C = false;
        }
_L14:
        if (i1 < 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STARTED: ").append(fragment).toString());
            }
            fragment.h();
        }
_L13:
        if (i1 < 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STOPPED: ").append(fragment).toString());
            }
            fragment.i();
        }
_L12:
        if (i1 < 2)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom ACTIVITY_CREATED: ").append(fragment).toString());
            }
            if (fragment.X != null && !t.isFinishing() && fragment.t == null)
            {
                e(fragment);
            }
            fragment.j();
            if (fragment.X != null && fragment.W != null)
            {
                if (s > 0 && !y)
                {
                    animation = a(fragment, j1, false, k1);
                } else
                {
                    animation = null;
                }
                if (animation != null)
                {
                    fragment.q = fragment.X;
                    fragment.r = i1;
                    animation.setAnimationListener(new A(this, fragment));
                    fragment.X.startAnimation(animation);
                }
                fragment.W.removeView(fragment.X);
            }
            fragment.W = null;
            fragment.X = null;
            fragment.Y = null;
        }
        if (true) goto _L11; else goto _L8
_L8:
        if (true) goto _L3; else goto _L16
_L16:
    }

    public void a(Fragment fragment, boolean flag)
    {
        if (l == null)
        {
            l = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("add: ").append(fragment).toString());
        }
        c(fragment);
        if (!fragment.P)
        {
            if (l.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
            }
            l.add(fragment);
            fragment.A = true;
            fragment.B = false;
            if (fragment.S && fragment.T)
            {
                w = true;
            }
            if (flag)
            {
                b(fragment);
            }
        }
    }

    public void a(FragmentActivity fragmentactivity, u u1, Fragment fragment)
    {
        if (t != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            t = fragmentactivity;
            u = u1;
            v = fragment;
            return;
        }
    }

    public void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            q();
        }
        this;
        JVM INSTR monitorenter ;
        if (t == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (h == null)
        {
            h = new ArrayList();
        }
        h.add(runnable);
        if (h.size() == 1)
        {
            t.d.removeCallbacks(D);
            t.d.post(D);
        }
        this;
        JVM INSTR monitorexit ;
    }

    boolean a(Handler handler, String s1, int i1, int j1)
    {
        if (n != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i3;
        if (s1 != null || i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((i3 = -1 + n.size()) < 0) goto _L1; else goto _L5
_L5:
        ((l)n.remove(i3)).b(true);
        c();
_L8:
        return true;
_L4:
        int k1;
        int l1;
        k1 = -1;
        if (s1 == null && i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = -1 + n.size();
        break MISSING_BLOCK_LABEL_84;
        if (l1 < 0) goto _L1; else goto _L6
_L6:
        if ((j1 & 1) != 0)
        {
            l1--;
            do
            {
                if (l1 < 0)
                {
                    break;
                }
                l l3 = (l)n.get(l1);
                if ((s1 == null || !s1.equals(l3.getName())) && (i1 < 0 || i1 != l3.x))
                {
                    break;
                }
                l1--;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_207;
        do
        {
            {
                if (l1 < 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                l l4 = (l)n.get(l1);
                if (s1 != null && s1.equals(l4.getName()) || i1 >= 0 && i1 == l4.x)
                {
                    continue; /* Loop/switch isn't completed */
                }
                l1--;
            }
        } while (true);
        k1 = l1;
        if (k1 == -1 + n.size()) goto _L1; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (int i2 = -1 + n.size(); i2 > k1; i2--)
        {
            arraylist.add(n.remove(i2));
        }

        int j2 = -1 + arraylist.size();
        int k2 = 0;
        while (k2 <= j2) 
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Popping back stack state: ").append(arraylist.get(k2)).toString());
            }
            l l2 = (l)arraylist.get(k2);
            boolean flag;
            if (k2 == j2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l2.b(flag);
            k2++;
        }
        c();
          goto _L8
    }

    public boolean a(Menu menu)
    {
        boolean flag;
        if (l != null)
        {
            int i1 = 0;
            flag = false;
            for (; i1 < l.size(); i1++)
            {
                Fragment fragment = (Fragment)l.get(i1);
                if (fragment != null && fragment.a(menu))
                {
                    flag = true;
                }
            }

        } else
        {
            flag = false;
        }
        return flag;
    }

    public boolean a(Menu menu, MenuInflater menuinflater)
    {
        ArrayList arraylist = null;
        boolean flag;
        if (l != null)
        {
            int j1 = 0;
            boolean flag1;
            for (flag = false; j1 < l.size(); flag = flag1)
            {
                Fragment fragment1 = (Fragment)l.get(j1);
                if (fragment1 != null && fragment1.a(menu, menuinflater))
                {
                    flag = true;
                    if (arraylist == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(fragment1);
                }
                flag1 = flag;
                j1++;
            }

        } else
        {
            flag = false;
        }
        ArrayList arraylist1 = o;
        int i1 = 0;
        if (arraylist1 != null)
        {
            for (; i1 < o.size(); i1++)
            {
                Fragment fragment = (Fragment)o.get(i1);
                if (arraylist == null || !arraylist.contains(fragment))
                {
                    fragment.onDestroyOptionsMenu();
                }
            }

        }
        o = arraylist;
        return flag;
    }

    public boolean a(MenuItem menuitem)
    {
        ArrayList arraylist;
        boolean flag;
        arraylist = l;
        flag = false;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        int j1;
        j1 = l.size();
        flag = false;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)l.get(i1);
        if (fragment == null || !fragment.a(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onbackstackchangedlistener)
    {
        if (r == null)
        {
            r = new ArrayList();
        }
        r.add(onbackstackchangedlistener);
    }

    void b(Fragment fragment)
    {
        a(fragment, s, 0, 0, false);
    }

    public void b(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("hide: ").append(fragment).toString());
        }
        if (!fragment.O)
        {
            fragment.O = true;
            if (fragment.X != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.X.startAnimation(animation);
                }
                fragment.X.setVisibility(8);
            }
            if (fragment.A && fragment.S && fragment.T)
            {
                w = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    void b(l l1)
    {
        if (n == null)
        {
            n = new ArrayList();
        }
        n.add(l1);
        c();
    }

    public void b(Menu menu)
    {
        if (l != null)
        {
            for (int i1 = 0; i1 < l.size(); i1++)
            {
                Fragment fragment = (Fragment)l.get(i1);
                if (fragment != null)
                {
                    fragment.b(menu);
                }
            }

        }
    }

    public boolean b()
    {
        if (j)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != t.d.getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (h != null && h.size() != 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        this;
        JVM INSTR monitorexit ;
        boolean flag1;
        if (!A)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        int i1 = 0;
        flag1 = false;
        for (; i1 < k.size(); i1++)
        {
            Fragment fragment = (Fragment)k.get(i1);
            if (fragment != null && fragment.ab != null)
            {
                flag1 |= fragment.ab.hasRunningLoaders();
            }
        }

        break; /* Loop/switch isn't completed */
        int j1;
        j1 = h.size();
        if (i == null || i.length < j1)
        {
            i = new Runnable[j1];
        }
        h.toArray(i);
        h.clear();
        t.d.removeCallbacks(D);
        this;
        JVM INSTR monitorexit ;
        j = true;
        for (int k1 = 0; k1 < j1; k1++)
        {
            i[k1].run();
            i[k1] = null;
        }

        break MISSING_BLOCK_LABEL_252;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        j = false;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        if (!flag1)
        {
            A = false;
            a();
        }
        return flag;
    }

    public boolean b(MenuItem menuitem)
    {
        ArrayList arraylist;
        boolean flag;
        arraylist = l;
        flag = false;
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        int j1;
        j1 = l.size();
        flag = false;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)l.get(i1);
        if (fragment == null || !fragment.b(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public FragmentTransaction beginTransaction()
    {
        return new l(this);
    }

    void c()
    {
        if (r != null)
        {
            for (int i1 = 0; i1 < r.size(); i1++)
            {
                ((FragmentManager.OnBackStackChangedListener)r.get(i1)).onBackStackChanged();
            }

        }
    }

    void c(Fragment fragment)
    {
        if (fragment.u < 0)
        {
            if (m == null || m.size() <= 0)
            {
                if (k == null)
                {
                    k = new ArrayList();
                }
                fragment.a(k.size(), v);
                k.add(fragment);
            } else
            {
                fragment.a(((Integer)m.remove(-1 + m.size())).intValue(), v);
                k.set(fragment.u, fragment);
            }
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Allocated fragment index ").append(fragment).toString());
                return;
            }
        }
    }

    public void c(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("show: ").append(fragment).toString());
        }
        if (fragment.O)
        {
            fragment.O = false;
            if (fragment.X != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.X.startAnimation(animation);
                }
                fragment.X.setVisibility(0);
            }
            if (fragment.A && fragment.S && fragment.T)
            {
                w = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    ArrayList d()
    {
        ArrayList arraylist = k;
        ArrayList arraylist1 = null;
        if (arraylist != null)
        {
            int i1 = 0;
            while (i1 < k.size()) 
            {
                Fragment fragment = (Fragment)k.get(i1);
                if (fragment == null || !fragment.Q)
                {
                    continue;
                }
                if (arraylist1 == null)
                {
                    arraylist1 = new ArrayList();
                }
                arraylist1.add(fragment);
                fragment.R = true;
                int j1;
                if (fragment.x != null)
                {
                    j1 = fragment.x.u;
                } else
                {
                    j1 = -1;
                }
                fragment.y = j1;
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("retainNonConfig: keeping retained ").append(fragment).toString());
                }
                i1++;
            }
        }
        return arraylist1;
    }

    void d(Fragment fragment)
    {
        if (fragment.u < 0)
        {
            return;
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing fragment index ").append(fragment).toString());
        }
        k.set(fragment.u, null);
        if (m == null)
        {
            m = new ArrayList();
        }
        m.add(Integer.valueOf(fragment.u));
        t.a(fragment.v);
        fragment.b();
    }

    public void d(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("detach: ").append(fragment).toString());
        }
        if (!fragment.P)
        {
            fragment.P = true;
            if (fragment.A)
            {
                if (l != null)
                {
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("remove from detach: ").append(fragment).toString());
                    }
                    l.remove(fragment);
                }
                if (fragment.S && fragment.T)
                {
                    w = true;
                }
                fragment.A = false;
                a(fragment, 1, i1, j1, false);
            }
        }
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i1;
        i1 = 0;
        String s2 = (new StringBuilder()).append(s1).append("    ").toString();
        if (k != null)
        {
            int i4 = k.size();
            if (i4 > 0)
            {
                printwriter.print(s1);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int j4 = 0; j4 < i4; j4++)
                {
                    Fragment fragment2 = (Fragment)k.get(j4);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j4);
                    printwriter.print(": ");
                    printwriter.println(fragment2);
                    if (fragment2 != null)
                    {
                        fragment2.dump(s2, filedescriptor, printwriter, as);
                    }
                }

            }
        }
        if (l != null)
        {
            int j3 = l.size();
            if (j3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Added Fragments:");
                for (int k3 = 0; k3 < j3; k3++)
                {
                    Fragment fragment1 = (Fragment)l.get(k3);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k3);
                    printwriter.print(": ");
                    printwriter.println(fragment1.toString());
                }

            }
        }
        if (o != null)
        {
            int k2 = o.size();
            if (k2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < k2; i3++)
                {
                    Fragment fragment = (Fragment)o.get(i3);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i3);
                    printwriter.print(": ");
                    printwriter.println(fragment.toString());
                }

            }
        }
        if (n != null)
        {
            int i2 = n.size();
            if (i2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Back Stack:");
                for (int j2 = 0; j2 < i2; j2++)
                {
                    l l3 = (l)n.get(j2);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j2);
                    printwriter.print(": ");
                    printwriter.println(l3.toString());
                    l3.a(s2, filedescriptor, printwriter, as);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if (p == null) goto _L2; else goto _L1
_L1:
        int k1 = p.size();
        if (k1 <= 0) goto _L2; else goto _L3
_L3:
        printwriter.print(s1);
        printwriter.println("Back Stack Indices:");
        int l1 = 0;
_L4:
        if (l1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        l l2 = (l)p.get(l1);
        printwriter.print(s1);
        printwriter.print("  #");
        printwriter.print(l1);
        printwriter.print(": ");
        printwriter.println(l2);
        l1++;
        if (true) goto _L4; else goto _L2
_L2:
        if (q != null && q.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(q.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if (h != null)
        {
            int j1 = h.size();
            if (j1 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Pending Actions:");
                for (; i1 < j1; i1++)
                {
                    Runnable runnable = (Runnable)h.get(i1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i1);
                    printwriter.print(": ");
                    printwriter.println(runnable);
                }

            }
        }
        break MISSING_BLOCK_LABEL_694;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        printwriter.print(s1);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s1);
        printwriter.print("  mActivity=");
        printwriter.println(t);
        printwriter.print(s1);
        printwriter.print("  mContainer=");
        printwriter.println(u);
        if (v != null)
        {
            printwriter.print(s1);
            printwriter.print("  mParent=");
            printwriter.println(v);
        }
        printwriter.print(s1);
        printwriter.print("  mCurState=");
        printwriter.print(s);
        printwriter.print(" mStateSaved=");
        printwriter.print(x);
        printwriter.print(" mDestroyed=");
        printwriter.println(y);
        if (w)
        {
            printwriter.print(s1);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(w);
        }
        if (z != null)
        {
            printwriter.print(s1);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(z);
        }
        if (m != null && m.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(m.toArray()));
        }
        return;
    }

    Parcelable e()
    {
        b();
        if (c)
        {
            x = true;
        }
        if (k != null && k.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i1 = k.size();
        FragmentState afragmentstate[] = new FragmentState[i1];
        int j1 = 0;
        boolean flag = false;
        while (j1 < i1) 
        {
            Fragment fragment = (Fragment)k.get(j1);
            int ai[];
            ArrayList arraylist;
            BackStackState abackstackstate[];
            FragmentManagerState fragmentmanagerstate;
            int k1;
            int l1;
            int i2;
            int j2;
            boolean flag1;
            if (fragment != null)
            {
                if (fragment.u < 0)
                {
                    a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(fragment).append(" has cleared index: ").append(fragment.u).toString()));
                }
                FragmentState fragmentstate = new FragmentState(fragment);
                afragmentstate[j1] = fragmentstate;
                if (fragment.p > 0 && fragmentstate.j == null)
                {
                    fragmentstate.j = f(fragment);
                    if (fragment.x != null)
                    {
                        if (fragment.x.u < 0)
                        {
                            a(new IllegalStateException((new StringBuilder()).append("Failure saving state: ").append(fragment).append(" has target not in fragment manager: ").append(fragment.x).toString()));
                        }
                        if (fragmentstate.j == null)
                        {
                            fragmentstate.j = new Bundle();
                        }
                        putFragment(fragmentstate.j, "android:target_state", fragment.x);
                        if (fragment.z != 0)
                        {
                            fragmentstate.j.putInt("android:target_req_state", fragment.z);
                        }
                    }
                } else
                {
                    fragmentstate.j = fragment.s;
                }
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("Saved state of ").append(fragment).append(": ").append(fragmentstate.j).toString());
                }
                flag1 = true;
            } else
            {
                flag1 = flag;
            }
            j1++;
            flag = flag1;
        }
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a)
        {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (true) goto _L1; else goto _L3
_L3:
label0:
        {
            if (l != null)
            {
                i2 = l.size();
                if (i2 > 0)
                {
                    ai = new int[i2];
                    for (j2 = 0; j2 < i2; j2++)
                    {
                        ai[j2] = ((Fragment)l.get(j2)).u;
                        if (ai[j2] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(l.get(j2)).append(" has cleared index: ").append(ai[j2]).toString()));
                        }
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding fragment #").append(j2).append(": ").append(l.get(j2)).toString());
                        }
                    }

                    break label0;
                }
            }
            ai = null;
        }
        arraylist = n;
        abackstackstate = null;
        if (arraylist != null)
        {
            k1 = n.size();
            abackstackstate = null;
            if (k1 > 0)
            {
                abackstackstate = new BackStackState[k1];
                for (l1 = 0; l1 < k1; l1++)
                {
                    abackstackstate[l1] = new BackStackState(this, (l)n.get(l1));
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding back stack #").append(l1).append(": ").append(n.get(l1)).toString());
                    }
                }

            }
        }
        fragmentmanagerstate = new FragmentManagerState();
        fragmentmanagerstate.a = afragmentstate;
        fragmentmanagerstate.b = ai;
        fragmentmanagerstate.c = abackstackstate;
        return fragmentmanagerstate;
    }

    void e(Fragment fragment)
    {
        if (fragment.Y != null)
        {
            if (C == null)
            {
                C = new SparseArray();
            } else
            {
                C.clear();
            }
            fragment.Y.saveHierarchyState(C);
            if (C.size() > 0)
            {
                fragment.t = C;
                C = null;
                return;
            }
        }
    }

    public void e(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("attach: ").append(fragment).toString());
        }
        if (fragment.P)
        {
            fragment.P = false;
            if (!fragment.A)
            {
                if (l == null)
                {
                    l = new ArrayList();
                }
                if (l.contains(fragment))
                {
                    throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
                }
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("add from attach: ").append(fragment).toString());
                }
                l.add(fragment);
                fragment.A = true;
                if (fragment.S && fragment.T)
                {
                    w = true;
                }
                a(fragment, s, i1, j1, false);
            }
        }
    }

    public boolean executePendingTransactions()
    {
        return b();
    }

    Bundle f(Fragment fragment)
    {
        if (B == null)
        {
            B = new Bundle();
        }
        fragment.d(B);
        Bundle bundle;
        if (!B.isEmpty())
        {
            bundle = B;
            B = null;
        } else
        {
            bundle = null;
        }
        if (fragment.X != null)
        {
            e(fragment);
        }
        if (fragment.t != null)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.t);
        }
        if (!fragment.aa)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.aa);
        }
        return bundle;
    }

    public void f()
    {
        x = false;
    }

    public Fragment findFragmentById(int i1)
    {
        if (l == null) goto _L2; else goto _L1
_L1:
        int k1 = -1 + l.size();
_L8:
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)l.get(k1);
        if (fragment == null || fragment.L != i1) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if (k == null)
            {
                break label0;
            }
            int j1 = -1 + k.size();
            do
            {
                if (j1 < 0)
                {
                    break label0;
                }
                fragment = (Fragment)k.get(j1);
                if (fragment != null && fragment.L == i1)
                {
                    break;
                }
                j1--;
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Fragment findFragmentByTag(String s1)
    {
        if (l == null || s1 == null) goto _L2; else goto _L1
_L1:
        int j1 = -1 + l.size();
_L8:
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)l.get(j1);
        if (fragment == null || !s1.equals(fragment.N)) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        j1--;
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if (k == null || s1 == null)
            {
                break label0;
            }
            int i1 = -1 + k.size();
            do
            {
                if (i1 < 0)
                {
                    break label0;
                }
                fragment = (Fragment)k.get(i1);
                if (fragment != null && s1.equals(fragment.N))
                {
                    break;
                }
                i1--;
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void g()
    {
        x = false;
        a(1, false);
    }

    public FragmentManager.BackStackEntry getBackStackEntryAt(int i1)
    {
        return (FragmentManager.BackStackEntry)n.get(i1);
    }

    public int getBackStackEntryCount()
    {
        if (n != null)
        {
            return n.size();
        } else
        {
            return 0;
        }
    }

    public Fragment getFragment(Bundle bundle, String s1)
    {
        int i1 = bundle.getInt(s1, -1);
        Fragment fragment;
        if (i1 == -1)
        {
            fragment = null;
        } else
        {
            if (i1 >= k.size())
            {
                a(new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s1).append(": index ").append(i1).toString()));
            }
            fragment = (Fragment)k.get(i1);
            if (fragment == null)
            {
                a(new IllegalStateException((new StringBuilder()).append("Fragement no longer exists for key ").append(s1).append(": index ").append(i1).toString()));
                return fragment;
            }
        }
        return fragment;
    }

    public List getFragments()
    {
        return k;
    }

    public void h()
    {
        x = false;
        a(2, false);
    }

    public void i()
    {
        x = false;
        a(4, false);
    }

    public void j()
    {
        x = false;
        a(5, false);
    }

    public void k()
    {
        a(4, false);
    }

    public void l()
    {
        x = true;
        a(3, false);
    }

    public void m()
    {
        a(2, false);
    }

    public void n()
    {
        a(1, false);
    }

    public void o()
    {
        y = true;
        b();
        a(0, false);
        t = null;
        u = null;
        v = null;
    }

    public void p()
    {
        if (l != null)
        {
            for (int i1 = 0; i1 < l.size(); i1++)
            {
                Fragment fragment = (Fragment)l.get(i1);
                if (fragment != null)
                {
                    fragment.f();
                }
            }

        }
    }

    public void popBackStack()
    {
        a(new x(this), false);
    }

    public void popBackStack(int i1, int j1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad id: ").append(i1).toString());
        } else
        {
            a(new z(this, i1, j1), false);
            return;
        }
    }

    public void popBackStack(String s1, int i1)
    {
        a(new y(this, s1, i1), false);
    }

    public boolean popBackStackImmediate()
    {
        q();
        executePendingTransactions();
        return a(t.d, ((String) (null)), -1, 0);
    }

    public boolean popBackStackImmediate(int i1, int j1)
    {
        q();
        executePendingTransactions();
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad id: ").append(i1).toString());
        } else
        {
            return a(t.d, ((String) (null)), i1, j1);
        }
    }

    public boolean popBackStackImmediate(String s1, int i1)
    {
        q();
        executePendingTransactions();
        return a(t.d, s1, -1, i1);
    }

    public void putFragment(Bundle bundle, String s1, Fragment fragment)
    {
        if (fragment.u < 0)
        {
            a(new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString()));
        }
        bundle.putInt(s1, fragment.u);
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onbackstackchangedlistener)
    {
        if (r != null)
        {
            r.remove(onbackstackchangedlistener);
        }
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment)
    {
        if (fragment.u < 0)
        {
            a(new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString()));
        }
        int i1 = fragment.p;
        Fragment.SavedState savedstate = null;
        if (i1 > 0)
        {
            Bundle bundle = f(fragment);
            savedstate = null;
            if (bundle != null)
            {
                savedstate = new Fragment.SavedState(bundle);
            }
        }
        return savedstate;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (v != null)
        {
            DebugUtils.buildShortClassTag(v, stringbuilder);
        } else
        {
            DebugUtils.buildShortClassTag(t, stringbuilder);
        }
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    static 
    {
        a = false;
        int i1 = android.os.Build.VERSION.SDK_INT;
        boolean flag = false;
        if (i1 >= 11)
        {
            flag = true;
        }
        c = flag;
    }
}
