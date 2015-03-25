// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;

// Referenced classes of package com.umeng.analytics:
//            f, d

class m extends f
{

    final d a;
    private final Context b;

    m(d d1, Context context)
    {
        a = d1;
        b = context;
        super();
    }

    public void a()
    {
        d.b(a, b.getApplicationContext());
    }
}
