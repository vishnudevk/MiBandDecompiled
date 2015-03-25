// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;

// Referenced classes of package android.support.v13.app:
//            d, c, a, b

public class FragmentCompat
{

    static final b a;

    public FragmentCompat()
    {
    }

    public static void setMenuVisibility(Fragment fragment, boolean flag)
    {
        a.a(fragment, flag);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean flag)
    {
        a.b(fragment, flag);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            a = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new c();
        } else
        {
            a = new a();
        }
    }
}
