// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import android.util.Log;

// Referenced classes of package com.tencent.mm.sdk.b:
//            a

final class b
    implements a.a
{

    b()
    {
    }

    public final int b()
    {
        return a.a();
    }

    public final void d(String s, String s1)
    {
        if (a.a() <= 2)
        {
            Log.i(s, s1);
        }
    }

    public final void e(String s, String s1)
    {
        if (a.a() <= 1)
        {
            Log.d(s, s1);
        }
    }

    public final void f(String s, String s1)
    {
        if (a.a() <= 4)
        {
            Log.e(s, s1);
        }
    }
}
