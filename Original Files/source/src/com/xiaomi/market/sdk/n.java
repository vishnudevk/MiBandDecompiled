// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            b, m, q, Patcher, 
//            o, p

public class n extends Handler
{

    final m a;

    public n(m m1, Looper looper)
    {
        a = m1;
        super(looper);
    }

    static m a(n n1)
    {
        return n1.a;
    }

    static String a(n n1, String s, String s1)
    {
        return n1.a(s, s1);
    }

    private String a(String s, String s1)
    {
        if (TextUtils.isEmpty(s1) || TextUtils.equals(b.a(new File(s)), s1))
        {
            String s2 = com.xiaomi.market.sdk.m.e(a).getAbsolutePath();
            if (com.xiaomi.market.sdk.m.d(a) != null && !TextUtils.isEmpty(com.xiaomi.market.sdk.m.d(a).sourceDir))
            {
                Patcher.a(com.xiaomi.market.sdk.m.d(a).sourceDir, s2, s);
                return s2;
            }
        }
        return null;
    }

    public void l()
    {
        post(new o(this));
    }

    public void m()
    {
        post(new p(this));
    }
}
