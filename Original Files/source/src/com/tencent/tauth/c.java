// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import com.tencent.connect.a.a;

// Referenced classes of package com.tencent.tauth:
//            LocationApi

class c
    implements Runnable
{

    final String a[];
    final String b;
    final LocationApi c;

    c(LocationApi locationapi, String as[], String s)
    {
        c = locationapi;
        a = as;
        b = s;
        super();
    }

    public void run()
    {
        if (a == null || a.length == 0)
        {
            return;
        }
        String s;
        if ("search_nearby".equals(b))
        {
            s = "id_search_nearby";
        } else
        {
            s = "id_delete_location";
        }
        com.tencent.connect.a.a.a(LocationApi.d(c), LocationApi.e(c), s, a);
    }
}
