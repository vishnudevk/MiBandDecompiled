// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.os.Bundle;

final class j
{

    private final String a;
    private final Class b;
    private final Bundle c;
    private Fragment d;

    j(String s, Class class1, Bundle bundle)
    {
        a = s;
        b = class1;
        c = bundle;
    }

    static Fragment a(j j1)
    {
        return j1.d;
    }

    static Fragment a(j j1, Fragment fragment)
    {
        j1.d = fragment;
        return fragment;
    }

    static String b(j j1)
    {
        return j1.a;
    }

    static Class c(j j1)
    {
        return j1.b;
    }

    static Bundle d(j j1)
    {
        return j1.c;
    }
}
