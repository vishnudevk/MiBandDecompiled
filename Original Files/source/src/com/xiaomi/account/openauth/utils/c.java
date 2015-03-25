// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.io.OutputStream;

// Referenced classes of package com.xiaomi.account.openauth.utils:
//            Network

class c extends AsyncTask
{

    private String a;
    private OutputStream b;
    private Network.PostDownloadHandler c;
    private boolean d;
    private Context e;

    public c(String s, OutputStream outputstream, Network.PostDownloadHandler postdownloadhandler)
    {
        this(s, outputstream, postdownloadhandler, false, null);
    }

    public c(String s, OutputStream outputstream, Network.PostDownloadHandler postdownloadhandler, boolean flag, Context context)
    {
        a = s;
        b = outputstream;
        c = postdownloadhandler;
        d = flag;
        e = context;
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.valueOf(Network.downloadFile(a, b, d, e));
    }

    protected void a(Boolean boolean1)
    {
        c.OnPostDownload(boolean1.booleanValue());
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
