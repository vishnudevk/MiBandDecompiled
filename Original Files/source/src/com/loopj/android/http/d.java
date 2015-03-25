// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient, RequestHandle

class d
    implements Runnable
{

    final Context a;
    final boolean b;
    final AsyncHttpClient c;

    d(AsyncHttpClient asynchttpclient, Context context, boolean flag)
    {
        c = asynchttpclient;
        a = context;
        b = flag;
        super();
    }

    public void run()
    {
        List list = (List)AsyncHttpClient.b(c).get(a);
        if (list != null)
        {
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ((RequestHandle)iterator.next()).cancel(b)) { }
            AsyncHttpClient.b(c).remove(a);
        }
    }
}
