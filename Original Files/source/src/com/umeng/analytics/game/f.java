// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import com.umeng.analytics.d;
import java.util.HashMap;
import u.aly.bj;

// Referenced classes of package com.umeng.analytics.game:
//            d, b, c

class f extends com.umeng.analytics.f
{

    final com.umeng.analytics.game.d a;
    private final String b;
    private final int c;

    f(com.umeng.analytics.game.d d1, String s, int i)
    {
        a = d1;
        b = s;
        c = i;
        super();
    }

    public void a()
    {
        c c1 = d.a(a).b(b);
        if (c1 != null)
        {
            long l = c1.e();
            if (l <= 0L)
            {
                bj.c("MobclickAgent", "level duration is 0");
                return;
            }
            HashMap hashmap = new HashMap();
            hashmap.put("level", b);
            hashmap.put("status", Integer.valueOf(c));
            hashmap.put("duration", Long.valueOf(l));
            if (d.a(a).b != null)
            {
                hashmap.put("user_level", d.a(a).b);
            }
            d.b(a).a(d.c(a), "level", hashmap);
            return;
        } else
        {
            bj.e("MobclickAgent", String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
            return;
        }
    }
}
