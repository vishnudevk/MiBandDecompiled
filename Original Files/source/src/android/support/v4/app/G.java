// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            Fragment

final class G
{

    private final String a;
    private final Class b;
    private final Bundle c;
    private Fragment d;

    G(String s, Class class1, Bundle bundle)
    {
        a = s;
        b = class1;
        c = bundle;
    }

    static Fragment a(G g)
    {
        return g.d;
    }

    static Fragment a(G g, Fragment fragment)
    {
        g.d = fragment;
        return fragment;
    }

    static String b(G g)
    {
        return g.a;
    }

    static Class c(G g)
    {
        return g.b;
    }

    static Bundle d(G g)
    {
        return g.c;
    }
}
