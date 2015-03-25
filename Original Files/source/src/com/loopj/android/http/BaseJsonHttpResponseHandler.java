// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler, m, j

public abstract class BaseJsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String a = "BaseJsonHttpResponseHandler";

    public BaseJsonHttpResponseHandler()
    {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public final void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        if (s != null)
        {
            m m1 = new m(this, s, i, aheader, throwable);
            if (!getUseSynchronousMode())
            {
                (new Thread(m1)).start();
                return;
            } else
            {
                m1.run();
                return;
            }
        } else
        {
            onFailure(i, aheader, throwable, null, null);
            return;
        }
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, String s, Object obj);

    public final void onSuccess(int i, Header aheader[], String s)
    {
        if (i != 204)
        {
            j j1 = new j(this, s, i, aheader);
            if (!getUseSynchronousMode())
            {
                (new Thread(j1)).start();
                return;
            } else
            {
                j1.run();
                return;
            }
        } else
        {
            onSuccess(i, aheader, null, null);
            return;
        }
    }

    public abstract void onSuccess(int i, Header aheader[], String s, Object obj);

    protected abstract Object parseResponse(String s, boolean flag);
}
