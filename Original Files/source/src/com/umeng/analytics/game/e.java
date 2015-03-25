// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import com.umeng.analytics.d;
import com.umeng.analytics.f;
import java.util.HashMap;

// Referenced classes of package com.umeng.analytics.game:
//            d, b

class e extends f
{

    final com.umeng.analytics.game.d a;
    private final String b;

    e(com.umeng.analytics.game.d d1, String s)
    {
        a = d1;
        b = s;
        super();
    }

    public void a()
    {
        d.a(a).a(b);
        HashMap hashmap = new HashMap();
        hashmap.put("level", b);
        hashmap.put("status", Integer.valueOf(0));
        if (d.a(a).b != null)
        {
            hashmap.put("user_level", d.a(a).b);
        }
        d.b(a).a(d.c(a), "level", hashmap);
    }
}
