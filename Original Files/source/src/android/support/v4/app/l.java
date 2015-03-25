// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.util.LogWriter;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            FragmentTransaction, Fragment, m, v, 
//            FragmentActivity

final class l extends FragmentTransaction
    implements FragmentManager.BackStackEntry, Runnable
{

    static final String a = "FragmentManager";
    static final int c = 0;
    static final int d = 1;
    static final int e = 2;
    static final int f = 3;
    static final int g = 4;
    static final int h = 5;
    static final int i = 6;
    static final int j = 7;
    int A;
    CharSequence B;
    final v b;
    m k;
    m l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    boolean u;
    String v;
    boolean w;
    int x;
    int y;
    CharSequence z;

    public l(v v1)
    {
        u = true;
        x = -1;
        b = v1;
    }

    private void a(int i1, Fragment fragment, String s1, int j1)
    {
        fragment.H = b;
        if (s1 != null)
        {
            if (fragment.N != null && !s1.equals(fragment.N))
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change tag of fragment ").append(fragment).append(": was ").append(fragment.N).append(" now ").append(s1).toString());
            }
            fragment.N = s1;
        }
        if (i1 != 0)
        {
            if (fragment.L != 0 && fragment.L != i1)
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change container ID of fragment ").append(fragment).append(": was ").append(fragment.L).append(" now ").append(i1).toString());
            }
            fragment.L = i1;
            fragment.M = i1;
        }
        m m1 = new m();
        m1.c = j1;
        m1.d = fragment;
        a(m1);
    }

    public int a()
    {
        return r;
    }

    int a(boolean flag)
    {
        if (w)
        {
            throw new IllegalStateException("commit already called");
        }
        if (v.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Commit: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new LogWriter("FragmentManager")), ((String []) (null)));
        }
        w = true;
        if (t)
        {
            x = b.a(this);
        } else
        {
            x = -1;
        }
        b.a(this, flag);
        return x;
    }

    void a(int i1)
    {
        if (t)
        {
            if (v.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting in ").append(this).append(" by ").append(i1).toString());
            }
            m m1 = k;
            while (m1 != null) 
            {
                if (m1.d != null)
                {
                    Fragment fragment1 = m1.d;
                    fragment1.G = i1 + fragment1.G;
                    if (v.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(m1.d).append(" to ").append(m1.d.G).toString());
                    }
                }
                if (m1.i != null)
                {
                    for (int j1 = -1 + m1.i.size(); j1 >= 0; j1--)
                    {
                        Fragment fragment = (Fragment)m1.i.get(j1);
                        fragment.G = i1 + fragment.G;
                        if (v.a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment).append(" to ").append(fragment.G).toString());
                        }
                    }

                }
                m1 = m1.a;
            }
        }
    }

    void a(m m1)
    {
        if (k == null)
        {
            l = m1;
            k = m1;
        } else
        {
            m1.b = l;
            l.a = m1;
            l = m1;
        }
        m1.e = n;
        m1.f = o;
        m1.g = p;
        m1.h = q;
        m = 1 + m;
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        a(s1, printwriter, true);
    }

    public void a(String s1, PrintWriter printwriter, boolean flag)
    {
        String s2;
        int i1;
        m m2;
        if (flag)
        {
            printwriter.print(s1);
            printwriter.print("mName=");
            printwriter.print(v);
            printwriter.print(" mIndex=");
            printwriter.print(x);
            printwriter.print(" mCommitted=");
            printwriter.println(w);
            if (r != 0)
            {
                printwriter.print(s1);
                printwriter.print("mTransition=#");
                printwriter.print(Integer.toHexString(r));
                printwriter.print(" mTransitionStyle=#");
                printwriter.println(Integer.toHexString(s));
            }
            if (n != 0 || o != 0)
            {
                printwriter.print(s1);
                printwriter.print("mEnterAnim=#");
                printwriter.print(Integer.toHexString(n));
                printwriter.print(" mExitAnim=#");
                printwriter.println(Integer.toHexString(o));
            }
            if (p != 0 || q != 0)
            {
                printwriter.print(s1);
                printwriter.print("mPopEnterAnim=#");
                printwriter.print(Integer.toHexString(p));
                printwriter.print(" mPopExitAnim=#");
                printwriter.println(Integer.toHexString(q));
            }
            if (y != 0 || z != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbTitleRes=#");
                printwriter.print(Integer.toHexString(y));
                printwriter.print(" mBreadCrumbTitleText=");
                printwriter.println(z);
            }
            if (A != 0 || B != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbShortTitleRes=#");
                printwriter.print(Integer.toHexString(A));
                printwriter.print(" mBreadCrumbShortTitleText=");
                printwriter.println(B);
            }
        }
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_813;
        }
        printwriter.print(s1);
        printwriter.println("Operations:");
        s2 = (new StringBuilder()).append(s1).append("    ").toString();
        m m1 = k;
        i1 = 0;
        m2 = m1;
_L13:
        if (m2 == null) goto _L2; else goto _L1
_L1:
        m2.c;
        JVM INSTR tableswitch 0 7: default 420
    //                   0 695
    //                   1 703
    //                   2 711
    //                   3 719
    //                   4 727
    //                   5 735
    //                   6 743
    //                   7 751;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_751;
_L3:
        String s3 = (new StringBuilder()).append("cmd=").append(m2.c).toString();
_L12:
        printwriter.print(s1);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s3);
        printwriter.print(" ");
        printwriter.println(m2.d);
        if (flag)
        {
            if (m2.e != 0 || m2.f != 0)
            {
                printwriter.print(s1);
                printwriter.print("enterAnim=#");
                printwriter.print(Integer.toHexString(m2.e));
                printwriter.print(" exitAnim=#");
                printwriter.println(Integer.toHexString(m2.f));
            }
            if (m2.g != 0 || m2.h != 0)
            {
                printwriter.print(s1);
                printwriter.print("popEnterAnim=#");
                printwriter.print(Integer.toHexString(m2.g));
                printwriter.print(" popExitAnim=#");
                printwriter.println(Integer.toHexString(m2.h));
            }
        }
        if (m2.i != null && m2.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < m2.i.size()) 
            {
                printwriter.print(s2);
                if (m2.i.size() == 1)
                {
                    printwriter.print("Removed: ");
                } else
                {
                    if (j1 == 0)
                    {
                        printwriter.println("Removed:");
                    }
                    printwriter.print(s2);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                }
                printwriter.println(m2.i.get(j1));
                j1++;
            }
        }
        break MISSING_BLOCK_LABEL_800;
_L4:
        s3 = "NULL";
          goto _L12
_L5:
        s3 = "ADD";
          goto _L12
_L6:
        s3 = "REPLACE";
          goto _L12
_L7:
        s3 = "REMOVE";
          goto _L12
_L8:
        s3 = "HIDE";
          goto _L12
_L9:
        s3 = "SHOW";
          goto _L12
_L10:
        s3 = "DETACH";
          goto _L12
        s3 = "ATTACH";
          goto _L12
        m2 = m2.a;
        i1++;
          goto _L13
_L2:
    }

    public FragmentTransaction add(int i1, Fragment fragment)
    {
        a(i1, fragment, ((String) (null)), 1);
        return this;
    }

    public FragmentTransaction add(int i1, Fragment fragment, String s1)
    {
        a(i1, fragment, s1, 1);
        return this;
    }

    public FragmentTransaction add(Fragment fragment, String s1)
    {
        a(0, fragment, s1, 1);
        return this;
    }

    public FragmentTransaction addToBackStack(String s1)
    {
        if (!u)
        {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        } else
        {
            t = true;
            v = s1;
            return this;
        }
    }

    public FragmentTransaction attach(Fragment fragment)
    {
        m m1 = new m();
        m1.c = 7;
        m1.d = fragment;
        a(m1);
        return this;
    }

    public int b()
    {
        return s;
    }

    public void b(boolean flag)
    {
        m m1;
        if (v.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("popFromBackStack: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new LogWriter("FragmentManager")), ((String []) (null)));
        }
        a(-1);
        m1 = l;
_L10:
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_468;
        }
        m1.c;
        JVM INSTR tableswitch 1 7: default 116
    //                   1 147
    //                   2 190
    //                   3 291
    //                   4 319
    //                   5 357
    //                   6 395
    //                   7 433;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_433;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(m1.c).toString());
_L2:
        Fragment fragment7 = m1.d;
        fragment7.V = m1.h;
        b.a(fragment7, android.support.v4.app.v.b(r), s);
_L11:
        m1 = m1.b;
        if (true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = m1.d;
        if (fragment5 != null)
        {
            fragment5.V = m1.h;
            b.a(fragment5, android.support.v4.app.v.b(r), s);
        }
        if (m1.i != null)
        {
            int i1 = 0;
            while (i1 < m1.i.size()) 
            {
                Fragment fragment6 = (Fragment)m1.i.get(i1);
                fragment6.V = m1.g;
                b.a(fragment6, false);
                i1++;
            }
        }
          goto _L11
_L4:
        Fragment fragment4 = m1.d;
        fragment4.V = m1.g;
        b.a(fragment4, false);
          goto _L11
_L5:
        Fragment fragment3 = m1.d;
        fragment3.V = m1.g;
        b.c(fragment3, android.support.v4.app.v.b(r), s);
          goto _L11
_L6:
        Fragment fragment2 = m1.d;
        fragment2.V = m1.h;
        b.b(fragment2, android.support.v4.app.v.b(r), s);
          goto _L11
_L7:
        Fragment fragment1 = m1.d;
        fragment1.V = m1.g;
        b.e(fragment1, android.support.v4.app.v.b(r), s);
          goto _L11
        Fragment fragment = m1.d;
        fragment.V = m1.g;
        b.d(fragment, android.support.v4.app.v.b(r), s);
          goto _L11
        if (flag)
        {
            b.a(b.s, android.support.v4.app.v.b(r), s, true);
        }
        if (x >= 0)
        {
            b.a(x);
            x = -1;
        }
        return;
    }

    public int commit()
    {
        return a(false);
    }

    public int commitAllowingStateLoss()
    {
        return a(true);
    }

    public FragmentTransaction detach(Fragment fragment)
    {
        m m1 = new m();
        m1.c = 6;
        m1.d = fragment;
        a(m1);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack()
    {
        if (t)
        {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        } else
        {
            u = false;
            return this;
        }
    }

    public CharSequence getBreadCrumbShortTitle()
    {
        if (A != 0)
        {
            return b.t.getText(A);
        } else
        {
            return B;
        }
    }

    public int getBreadCrumbShortTitleRes()
    {
        return A;
    }

    public CharSequence getBreadCrumbTitle()
    {
        if (y != 0)
        {
            return b.t.getText(y);
        } else
        {
            return z;
        }
    }

    public int getBreadCrumbTitleRes()
    {
        return y;
    }

    public int getId()
    {
        return x;
    }

    public String getName()
    {
        return v;
    }

    public FragmentTransaction hide(Fragment fragment)
    {
        m m1 = new m();
        m1.c = 4;
        m1.d = fragment;
        a(m1);
        return this;
    }

    public boolean isAddToBackStackAllowed()
    {
        return u;
    }

    public boolean isEmpty()
    {
        return m == 0;
    }

    public FragmentTransaction remove(Fragment fragment)
    {
        m m1 = new m();
        m1.c = 3;
        m1.d = fragment;
        a(m1);
        return this;
    }

    public FragmentTransaction replace(int i1, Fragment fragment)
    {
        return replace(i1, fragment, null);
    }

    public FragmentTransaction replace(int i1, Fragment fragment, String s1)
    {
        if (i1 == 0)
        {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        } else
        {
            a(i1, fragment, s1, 2);
            return this;
        }
    }

    public void run()
    {
        m m1;
        if (v.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Run: ").append(this).toString());
        }
        if (t && x < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        m1 = k;
_L10:
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_639;
        }
        m1.c;
        JVM INSTR tableswitch 1 7: default 116
    //                   1 147
    //                   2 180
    //                   3 470
    //                   4 505
    //                   5 540
    //                   6 575
    //                   7 607;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_607;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(m1.c).toString());
_L2:
        Fragment fragment8 = m1.d;
        fragment8.V = m1.e;
        b.a(fragment8, false);
_L11:
        m1 = m1.a;
        if (true) goto _L10; else goto _L9
_L9:
        Fragment fragment5 = m1.d;
        Fragment fragment6;
        if (b.l != null)
        {
            int i1 = 0;
            fragment6 = fragment5;
            while (i1 < b.l.size()) 
            {
                Fragment fragment7 = (Fragment)b.l.get(i1);
                if (v.a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("OP_REPLACE: adding=").append(fragment6).append(" old=").append(fragment7).toString());
                }
                if (fragment6 == null || fragment7.M == fragment6.M)
                {
                    if (fragment7 == fragment6)
                    {
                        fragment6 = null;
                        m1.d = null;
                    } else
                    {
                        if (m1.i == null)
                        {
                            m1.i = new ArrayList();
                        }
                        m1.i.add(fragment7);
                        fragment7.V = m1.f;
                        if (t)
                        {
                            fragment7.G = 1 + fragment7.G;
                            if (v.a)
                            {
                                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment7).append(" to ").append(fragment7.G).toString());
                            }
                        }
                        b.a(fragment7, r, s);
                    }
                }
                i1++;
            }
        } else
        {
            fragment6 = fragment5;
        }
        if (fragment6 != null)
        {
            fragment6.V = m1.e;
            b.a(fragment6, false);
        }
          goto _L11
_L4:
        Fragment fragment4 = m1.d;
        fragment4.V = m1.f;
        b.a(fragment4, r, s);
          goto _L11
_L5:
        Fragment fragment3 = m1.d;
        fragment3.V = m1.f;
        b.b(fragment3, r, s);
          goto _L11
_L6:
        Fragment fragment2 = m1.d;
        fragment2.V = m1.e;
        b.c(fragment2, r, s);
          goto _L11
_L7:
        Fragment fragment1 = m1.d;
        fragment1.V = m1.f;
        b.d(fragment1, r, s);
          goto _L11
        Fragment fragment = m1.d;
        fragment.V = m1.e;
        b.e(fragment, r, s);
          goto _L11
        b.a(b.s, r, s, true);
        if (t)
        {
            b.b(this);
        }
        return;
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i1)
    {
        A = i1;
        B = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charsequence)
    {
        A = 0;
        B = charsequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i1)
    {
        y = i1;
        z = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charsequence)
    {
        y = 0;
        z = charsequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i1, int j1)
    {
        return setCustomAnimations(i1, j1, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i1, int j1, int k1, int l1)
    {
        n = i1;
        o = j1;
        p = k1;
        q = l1;
        return this;
    }

    public FragmentTransaction setTransition(int i1)
    {
        r = i1;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i1)
    {
        s = i1;
        return this;
    }

    public FragmentTransaction show(Fragment fragment)
    {
        m m1 = new m();
        m1.c = 5;
        m1.d = fragment;
        a(m1);
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (x >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(x);
        }
        if (v != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(v);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
