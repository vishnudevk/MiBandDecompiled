// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import java.util.HashMap;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            AnalyticsTracker

class b extends HashMap
{

    final String a;
    final AnalyticsTracker b;

    b(AnalyticsTracker analyticstracker, String s)
    {
        b = analyticstracker;
        a = s;
        super();
        put("_client_id_", a);
    }
}
