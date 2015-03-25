// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            Fragment

public abstract class FragmentTransaction
{

    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    public FragmentTransaction()
    {
    }

    public abstract FragmentTransaction add(int i, Fragment fragment);

    public abstract FragmentTransaction add(int i, Fragment fragment, String s);

    public abstract FragmentTransaction add(Fragment fragment, String s);

    public abstract FragmentTransaction addToBackStack(String s);

    public abstract FragmentTransaction attach(Fragment fragment);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract FragmentTransaction detach(Fragment fragment);

    public abstract FragmentTransaction disallowAddToBackStack();

    public abstract FragmentTransaction hide(Fragment fragment);

    public abstract boolean isAddToBackStackAllowed();

    public abstract boolean isEmpty();

    public abstract FragmentTransaction remove(Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment);

    public abstract FragmentTransaction replace(int i, Fragment fragment, String s);

    public abstract FragmentTransaction setBreadCrumbShortTitle(int i);

    public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence charsequence);

    public abstract FragmentTransaction setBreadCrumbTitle(int i);

    public abstract FragmentTransaction setBreadCrumbTitle(CharSequence charsequence);

    public abstract FragmentTransaction setCustomAnimations(int i, int j);

    public abstract FragmentTransaction setCustomAnimations(int i, int j, int k, int l);

    public abstract FragmentTransaction setTransition(int i);

    public abstract FragmentTransaction setTransitionStyle(int i);

    public abstract FragmentTransaction show(Fragment fragment);
}
