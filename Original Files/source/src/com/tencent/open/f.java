// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.tencent.open:
//            PKDialog, c

class f extends a.a
{

    final PKDialog a;

    private f(PKDialog pkdialog)
    {
        a = pkdialog;
        super();
    }

    f(PKDialog pkdialog, c c1)
    {
        this(pkdialog);
    }

    public void a(String s)
    {
        PKDialog.a(a).obtainMessage(1, s).sendToTarget();
        Log.e("onComplete", s);
        a.dismiss();
    }

    public void b(String s)
    {
        PKDialog.a(a).obtainMessage(2, s).sendToTarget();
        a.dismiss();
    }

    public void c(String s)
    {
        PKDialog.a(a).obtainMessage(3, s).sendToTarget();
    }

    public void d(String s)
    {
        PKDialog.a(a).obtainMessage(4, s).sendToTarget();
    }
}
