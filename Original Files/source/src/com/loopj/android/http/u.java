// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            s, JsonHttpResponseHandler

class u
    implements Runnable
{

    final JSONException a;
    final s b;

    u(s s1, JSONException jsonexception)
    {
        b = s1;
        a = jsonexception;
        super();
    }

    public void run()
    {
        b.e.onFailure(b.b, b.c, a, (JSONObject)null);
    }
}
