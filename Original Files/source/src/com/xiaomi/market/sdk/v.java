// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.os.AsyncTask;

// Referenced classes of package com.xiaomi.market.sdk:
//            XiaomiUpdateAgent, m, t

class v extends AsyncTask
{

    private v()
    {
    }

    v(v v1)
    {
        this();
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.valueOf(m.i(XiaomiUpdateAgent.b()).a(XiaomiUpdateAgent.c()));
    }

    protected void a(Boolean boolean1)
    {
        if (!boolean1.booleanValue())
        {
            t.a();
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
