// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.onlineconfig;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a;
import com.umeng.analytics.b;
import u.aly.bj;
import u.aly.bo;

// Referenced classes of package com.umeng.analytics.onlineconfig:
//            a, b, c

public class nContext extends bo
    implements Runnable
{

    Context a;
    final com.umeng.analytics.onlineconfig.a b;

    private void b()
    {
        nContext ncontext;
        String as[];
        int i;
        com.umeng.analytics.onlineconfig.b b1;
        org.json.JSONObject jsonobject = com.umeng.analytics.onlineconfig.a.a(b, a);
        ncontext = new <init>(b, jsonobject);
        as = a.g;
        i = 0;
        b1 = null;
_L5:
        if (i < as.length) goto _L2; else goto _L1
_L1:
        if (b1 == null)
        {
            com.umeng.analytics.onlineconfig.a.a(b, null);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        ncontext.a(as[i]);
        b1 = (com.umeng.analytics.onlineconfig.b)a(ncontext, com/umeng/analytics/onlineconfig/b);
        if (b1 != null) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (b1.b)
        {
            if (com.umeng.analytics.onlineconfig.a.a(b) != null)
            {
                com.umeng.analytics.onlineconfig.a.a(b).a(b1.c, b1.d);
            }
            com.umeng.analytics.onlineconfig.a.a(b, a, b1);
            com.umeng.analytics.onlineconfig.a.b(b, a, b1);
            com.umeng.analytics.onlineconfig.a.a(b, b1.a);
            return;
        } else
        {
            com.umeng.analytics.onlineconfig.a.a(b, null);
            return;
        }
    }

    public boolean a()
    {
        return false;
    }

    public void run()
    {
        if (AnalyticsConfig.UPDATE_IN_MAIN_PROCESS && !com.umeng.analytics.b.a(a))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        b();
        return;
        Exception exception;
        exception;
        com.umeng.analytics.onlineconfig.a.a(b, null);
        bj.c("MobclickAgent", "reques update error", exception);
        return;
    }

    public (com.umeng.analytics.onlineconfig.a a1, Context context)
    {
        b = a1;
        super();
        a = context.getApplicationContext();
    }
}
