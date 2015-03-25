// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler, s, p

public class JsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String a = "JsonHttpResponseHandler";

    public JsonHttpResponseHandler()
    {
        super("UTF-8");
    }

    public JsonHttpResponseHandler(String s1)
    {
        super(s1);
    }

    public void onFailure(int i, Header aheader[], String s1, Throwable throwable)
    {
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONArray jsonarray)
    {
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
    }

    public final void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        if (abyte0 != null)
        {
            s s1 = new s(this, abyte0, i, aheader, throwable);
            if (!getUseSynchronousMode())
            {
                (new Thread(s1)).start();
                return;
            } else
            {
                s1.run();
                return;
            }
        } else
        {
            Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(i, aheader, throwable, (JSONObject)null);
            return;
        }
    }

    public void onSuccess(int i, Header aheader[], String s1)
    {
    }

    public void onSuccess(int i, Header aheader[], JSONArray jsonarray)
    {
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
    }

    public final void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        if (i != 204)
        {
            p p1 = new p(this, abyte0, i, aheader);
            if (!getUseSynchronousMode())
            {
                (new Thread(p1)).start();
                return;
            } else
            {
                p1.run();
                return;
            }
        } else
        {
            onSuccess(i, aheader, new JSONObject());
            return;
        }
    }

    protected Object parseResponse(byte abyte0[])
    {
        String s1 = null;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        String s2;
        Object obj;
        s2 = getResponseString(abyte0, getCharset());
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = s2.trim();
        if (!s2.startsWith("{") && !s2.startsWith("["))
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = (new JSONTokener(s2)).nextValue();
        String s3 = s2;
        obj = obj1;
        s1 = s3;
_L4:
        if (obj != null)
        {
            return obj;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1 = s2;
        obj = null;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }
}
