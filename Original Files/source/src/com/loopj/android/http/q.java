// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            p, JsonHttpResponseHandler

class q
    implements Runnable
{

    final Object a;
    final p b;

    q(p p1, Object obj)
    {
        b = p1;
        a = obj;
        super();
    }

    public void run()
    {
        if (a instanceof JSONObject)
        {
            b.d.onSuccess(b.b, b.c, (JSONObject)a);
            return;
        }
        if (a instanceof JSONArray)
        {
            b.d.onSuccess(b.b, b.c, (JSONArray)a);
            return;
        }
        if (a instanceof String)
        {
            b.d.onFailure(b.b, b.c, (String)a, new JSONException("Response cannot be parsed as JSON data"));
            return;
        } else
        {
            b.d.onFailure(b.b, b.c, new JSONException((new StringBuilder()).append("Unexpected response type ").append(a.getClass().getName()).toString()), (JSONObject)null);
            return;
        }
    }
}
