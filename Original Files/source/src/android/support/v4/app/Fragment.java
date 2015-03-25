// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.DebugUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

// Referenced classes of package android.support.v4.app:
//            v, ae, o, J, 
//            FragmentActivity, FragmentManager, LoaderManager

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{

    private static final HashMap a = new HashMap();
    static final int j = 0;
    static final int k = 1;
    static final int l = 2;
    static final int m = 3;
    static final int n = 4;
    static final int o = 5;
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    int G;
    v H;
    FragmentActivity I;
    v J;
    Fragment K;
    int L;
    int M;
    String N;
    boolean O;
    boolean P;
    boolean Q;
    boolean R;
    boolean S;
    boolean T;
    boolean U;
    int V;
    ViewGroup W;
    View X;
    View Y;
    boolean Z;
    boolean aa;
    J ab;
    boolean ac;
    boolean ad;
    int p;
    View q;
    int r;
    Bundle s;
    SparseArray t;
    int u;
    String v;
    Bundle w;
    Fragment x;
    int y;
    int z;

    public Fragment()
    {
        p = 0;
        u = -1;
        y = -1;
        T = true;
        aa = true;
    }

    public static Fragment instantiate(Context context, String s1)
    {
        return instantiate(context, s1, null);
    }

    public static Fragment instantiate(Context context, String s1, Bundle bundle)
    {
        Class class1;
        Fragment fragment;
        try
        {
            class1 = (Class)a.get(s1);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), classnotfoundexception);
        }
        catch (java.lang.InstantiationException instantiationexception)
        {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new InstantiationException((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), illegalaccessexception);
        }
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        class1 = context.getClassLoader().loadClass(s1);
        a.put(s1, class1);
        fragment = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        bundle.setClassLoader(fragment.getClass().getClassLoader());
        fragment.w = bundle;
        return fragment;
    }

    Fragment a(String s1)
    {
        if (s1.equals(v))
        {
            return this;
        }
        if (J != null)
        {
            return J.a(s1);
        } else
        {
            return null;
        }
    }

    View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (J != null)
        {
            J.f();
        }
        return onCreateView(layoutinflater, viewgroup, bundle);
    }

    final void a(int i1, Fragment fragment)
    {
        u = i1;
        if (fragment != null)
        {
            v = (new StringBuilder()).append(fragment.v).append(":").append(u).toString();
            return;
        } else
        {
            v = (new StringBuilder()).append("android:fragment:").append(u).toString();
            return;
        }
    }

    void a(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        if (J != null)
        {
            J.a(configuration);
        }
    }

    final void a(Bundle bundle)
    {
        if (t != null)
        {
            Y.restoreHierarchyState(t);
            t = null;
        }
        U = false;
        onViewStateRestored(bundle);
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onViewStateRestored()").toString());
        } else
        {
            return;
        }
    }

    final boolean a()
    {
        return G > 0;
    }

    boolean a(Menu menu)
    {
        boolean flag = O;
        boolean flag1 = false;
        if (!flag)
        {
            boolean flag2 = S;
            flag1 = false;
            if (flag2)
            {
                boolean flag3 = T;
                flag1 = false;
                if (flag3)
                {
                    flag1 = true;
                    onPrepareOptionsMenu(menu);
                }
            }
            if (J != null)
            {
                flag1 |= J.a(menu);
            }
        }
        return flag1;
    }

    boolean a(Menu menu, MenuInflater menuinflater)
    {
        boolean flag = O;
        boolean flag1 = false;
        if (!flag)
        {
            boolean flag2 = S;
            flag1 = false;
            if (flag2)
            {
                boolean flag3 = T;
                flag1 = false;
                if (flag3)
                {
                    flag1 = true;
                    onCreateOptionsMenu(menu, menuinflater);
                }
            }
            if (J != null)
            {
                flag1 |= J.a(menu, menuinflater);
            }
        }
        return flag1;
    }

    boolean a(MenuItem menuitem)
    {
        while (!O && (S && T && onOptionsItemSelected(menuitem) || J != null && J.a(menuitem))) 
        {
            return true;
        }
        return false;
    }

    void b()
    {
        u = -1;
        v = null;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        G = 0;
        H = null;
        I = null;
        L = 0;
        M = 0;
        N = null;
        O = false;
        P = false;
        R = false;
        ab = null;
        ac = false;
        ad = false;
    }

    void b(Bundle bundle)
    {
        if (J != null)
        {
            J.f();
        }
        U = false;
        onCreate(bundle);
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onCreate()").toString());
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null)
            {
                if (J == null)
                {
                    c();
                }
                J.a(parcelable, null);
                J.g();
            }
        }
    }

    void b(Menu menu)
    {
        if (!O)
        {
            if (S && T)
            {
                onOptionsMenuClosed(menu);
            }
            if (J != null)
            {
                J.b(menu);
            }
        }
    }

    boolean b(MenuItem menuitem)
    {
        while (!O && (onContextItemSelected(menuitem) || J != null && J.b(menuitem))) 
        {
            return true;
        }
        return false;
    }

    void c()
    {
        J = new v();
        J.a(I, new o(this), this);
    }

    void c(Bundle bundle)
    {
        if (J != null)
        {
            J.f();
        }
        U = false;
        onActivityCreated(bundle);
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
        if (J != null)
        {
            J.h();
        }
    }

    void d()
    {
        if (J != null)
        {
            J.f();
            J.b();
        }
        U = false;
        onStart();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStart()").toString());
        }
        if (J != null)
        {
            J.i();
        }
        if (ab != null)
        {
            ab.f();
        }
    }

    void d(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        if (J != null)
        {
            android.os.Parcelable parcelable = J.e();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s1);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(L));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(M));
        printwriter.print(" mTag=");
        printwriter.println(N);
        printwriter.print(s1);
        printwriter.print("mState=");
        printwriter.print(p);
        printwriter.print(" mIndex=");
        printwriter.print(u);
        printwriter.print(" mWho=");
        printwriter.print(v);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(G);
        printwriter.print(s1);
        printwriter.print("mAdded=");
        printwriter.print(A);
        printwriter.print(" mRemoving=");
        printwriter.print(B);
        printwriter.print(" mResumed=");
        printwriter.print(C);
        printwriter.print(" mFromLayout=");
        printwriter.print(D);
        printwriter.print(" mInLayout=");
        printwriter.println(E);
        printwriter.print(s1);
        printwriter.print("mHidden=");
        printwriter.print(O);
        printwriter.print(" mDetached=");
        printwriter.print(P);
        printwriter.print(" mMenuVisible=");
        printwriter.print(T);
        printwriter.print(" mHasMenu=");
        printwriter.println(S);
        printwriter.print(s1);
        printwriter.print("mRetainInstance=");
        printwriter.print(Q);
        printwriter.print(" mRetaining=");
        printwriter.print(R);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(aa);
        if (H != null)
        {
            printwriter.print(s1);
            printwriter.print("mFragmentManager=");
            printwriter.println(H);
        }
        if (I != null)
        {
            printwriter.print(s1);
            printwriter.print("mActivity=");
            printwriter.println(I);
        }
        if (K != null)
        {
            printwriter.print(s1);
            printwriter.print("mParentFragment=");
            printwriter.println(K);
        }
        if (w != null)
        {
            printwriter.print(s1);
            printwriter.print("mArguments=");
            printwriter.println(w);
        }
        if (s != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(s);
        }
        if (t != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedViewState=");
            printwriter.println(t);
        }
        if (x != null)
        {
            printwriter.print(s1);
            printwriter.print("mTarget=");
            printwriter.print(x);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(z);
        }
        if (V != 0)
        {
            printwriter.print(s1);
            printwriter.print("mNextAnim=");
            printwriter.println(V);
        }
        if (W != null)
        {
            printwriter.print(s1);
            printwriter.print("mContainer=");
            printwriter.println(W);
        }
        if (X != null)
        {
            printwriter.print(s1);
            printwriter.print("mView=");
            printwriter.println(X);
        }
        if (Y != null)
        {
            printwriter.print(s1);
            printwriter.print("mInnerView=");
            printwriter.println(X);
        }
        if (q != null)
        {
            printwriter.print(s1);
            printwriter.print("mAnimatingAway=");
            printwriter.println(q);
            printwriter.print(s1);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(r);
        }
        if (ab != null)
        {
            printwriter.print(s1);
            printwriter.println("Loader Manager:");
            ab.dump((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (J != null)
        {
            printwriter.print(s1);
            printwriter.println((new StringBuilder()).append("Child ").append(J).append(":").toString());
            J.dump((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    void e()
    {
        if (J != null)
        {
            J.f();
            J.b();
        }
        U = false;
        onResume();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onResume()").toString());
        }
        if (J != null)
        {
            J.j();
            J.b();
        }
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    void f()
    {
        onLowMemory();
        if (J != null)
        {
            J.p();
        }
    }

    void g()
    {
        if (J != null)
        {
            J.k();
        }
        U = false;
        onPause();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onPause()").toString());
        } else
        {
            return;
        }
    }

    public final FragmentActivity getActivity()
    {
        return I;
    }

    public final Bundle getArguments()
    {
        return w;
    }

    public final FragmentManager getChildFragmentManager()
    {
        if (J != null) goto _L2; else goto _L1
_L1:
        c();
        if (p < 5) goto _L4; else goto _L3
_L3:
        J.j();
_L2:
        return J;
_L4:
        if (p >= 4)
        {
            J.i();
        } else
        if (p >= 2)
        {
            J.h();
        } else
        if (p >= 1)
        {
            J.g();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final FragmentManager getFragmentManager()
    {
        return H;
    }

    public final int getId()
    {
        return L;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        return I.getLayoutInflater();
    }

    public LoaderManager getLoaderManager()
    {
        if (ab != null)
        {
            return ab;
        }
        if (I == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            ad = true;
            ab = I.a(v, ac, true);
            return ab;
        }
    }

    public final Fragment getParentFragment()
    {
        return K;
    }

    public final Resources getResources()
    {
        if (I == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            return I.getResources();
        }
    }

    public final boolean getRetainInstance()
    {
        return Q;
    }

    public final String getString(int i1)
    {
        return getResources().getString(i1);
    }

    public final transient String getString(int i1, Object aobj[])
    {
        return getResources().getString(i1, aobj);
    }

    public final String getTag()
    {
        return N;
    }

    public final Fragment getTargetFragment()
    {
        return x;
    }

    public final int getTargetRequestCode()
    {
        return z;
    }

    public final CharSequence getText(int i1)
    {
        return getResources().getText(i1);
    }

    public boolean getUserVisibleHint()
    {
        return aa;
    }

    public View getView()
    {
        return X;
    }

    void h()
    {
        if (J != null)
        {
            J.l();
        }
        U = false;
        onStop();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStop()").toString());
        } else
        {
            return;
        }
    }

    public final boolean hasOptionsMenu()
    {
        return S;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    void i()
    {
label0:
        {
            if (J != null)
            {
                J.m();
            }
            if (ac)
            {
                ac = false;
                if (!ad)
                {
                    ad = true;
                    ab = I.a(v, ac, false);
                }
                if (ab != null)
                {
                    if (I.k)
                    {
                        break label0;
                    }
                    ab.b();
                }
            }
            return;
        }
        ab.c();
    }

    public final boolean isAdded()
    {
        return I != null && A;
    }

    public final boolean isDetached()
    {
        return P;
    }

    public final boolean isHidden()
    {
        return O;
    }

    public final boolean isInLayout()
    {
        return E;
    }

    public final boolean isMenuVisible()
    {
        return T;
    }

    public final boolean isRemoving()
    {
        return B;
    }

    public final boolean isResumed()
    {
        return C;
    }

    public final boolean isVisible()
    {
        return isAdded() && !isHidden() && X != null && X.getWindowToken() != null && X.getVisibility() == 0;
    }

    void j()
    {
        if (J != null)
        {
            J.n();
        }
        U = false;
        onDestroyView();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroyView()").toString());
        }
        if (ab != null)
        {
            ab.e();
        }
    }

    void k()
    {
        if (J != null)
        {
            J.o();
        }
        U = false;
        onDestroy();
        if (!U)
        {
            throw new ae((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        U = true;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
    }

    public void onAttach(Activity activity)
    {
        U = true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        U = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        U = true;
    }

    public Animation onCreateAnimation(int i1, boolean flag, int j1)
    {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        getActivity().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    public void onDestroy()
    {
        U = true;
        if (!ad)
        {
            ad = true;
            ab = I.a(v, ac, false);
        }
        if (ab != null)
        {
            ab.g();
        }
    }

    public void onDestroyOptionsMenu()
    {
    }

    public void onDestroyView()
    {
        U = true;
    }

    public void onDetach()
    {
        U = true;
    }

    public void onHiddenChanged(boolean flag)
    {
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        U = true;
    }

    public void onLowMemory()
    {
        U = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu)
    {
    }

    public void onPause()
    {
        U = true;
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
    }

    public void onResume()
    {
        U = true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
        U = true;
        if (!ac)
        {
            ac = true;
            if (!ad)
            {
                ad = true;
                ab = I.a(v, ac, false);
            }
            if (ab != null)
            {
                ab.a();
            }
        }
    }

    public void onStop()
    {
        U = true;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
    }

    public void onViewStateRestored(Bundle bundle)
    {
        U = true;
    }

    public void registerForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(this);
    }

    public void setArguments(Bundle bundle)
    {
        if (u >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        } else
        {
            w = bundle;
            return;
        }
    }

    public void setHasOptionsMenu(boolean flag)
    {
        if (S != flag)
        {
            S = flag;
            if (isAdded() && !isHidden())
            {
                I.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(SavedState savedstate)
    {
        if (u >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle;
        if (savedstate != null && savedstate.a != null)
        {
            bundle = savedstate.a;
        } else
        {
            bundle = null;
        }
        s = bundle;
    }

    public void setMenuVisibility(boolean flag)
    {
        if (T != flag)
        {
            T = flag;
            if (S && isAdded() && !isHidden())
            {
                I.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setRetainInstance(boolean flag)
    {
        if (flag && K != null)
        {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        } else
        {
            Q = flag;
            return;
        }
    }

    public void setTargetFragment(Fragment fragment, int i1)
    {
        x = fragment;
        z = i1;
    }

    public void setUserVisibleHint(boolean flag)
    {
        if (!aa && flag && p < 4)
        {
            H.a(this);
        }
        aa = flag;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Z = flag1;
    }

    public void startActivity(Intent intent)
    {
        if (I == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            I.startActivityFromFragment(this, intent, -1);
            return;
        }
    }

    public void startActivityForResult(Intent intent, int i1)
    {
        if (I == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            I.startActivityFromFragment(this, intent, i1);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, stringbuilder);
        if (u >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(u);
        }
        if (L != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(L));
        }
        if (N != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(N);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void unregisterForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(null);
    }


    private class InstantiationException extends RuntimeException
    {

        public InstantiationException(String s1, Exception exception)
        {
            super(s1, exception);
        }
    }


    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new p();
        final Bundle a;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeBundle(a);
        }


        SavedState(Bundle bundle)
        {
            a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classloader)
        {
            a = parcel.readBundle();
            if (classloader != null && a != null)
            {
                a.setClassLoader(classloader);
            }
        }
    }

}
