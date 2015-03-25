// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            s, JsonHttpResponseHandler

class t
    implements Runnable
{

    final Object a;
    final s b;

    t(s s1, Object obj)
    {
        b = s1;
        a = obj;
        super();
    }

    public void run()
    {
        if (a instanceof JSONObject)
        {
            b.e.onFailure(b.b, b.c, b.d, (JSONObject)a);
            return;
        }
        if (a instanceof JSONArray)
        {
            b.e.onFailure(b.b, b.c, b.d, (JSONArray)a);
            return;
        }
        if (a instanceof String)
        {
            b.e.onFailure(b.b, b.c, (String)a, b.d);
            return;
        } else
        {
            b.e.onFailure(b.b, b.c, new JSONException((new StringBuilder()).append("Unexpected response type ").append(a.getClass().getName()).toString()), (JSONObject)null);
            return;
        }
    }
}
