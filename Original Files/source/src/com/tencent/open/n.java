// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.tencent.open:
//            TDialog, l

class n extends a.a
{

    final TDialog a;

    private n(TDialog tdialog)
    {
        a = tdialog;
        super();
    }

    n(TDialog tdialog, l l)
    {
        this(tdialog);
    }

    public void a()
    {
        e("");
    }

    public void a(String s)
    {
        Log.d("TDialog", "onAddShare");
        d(s);
    }

    public void b()
    {
        Log.d("TDialog", "onCancelInvite");
        e("");
    }

    public void b(String s)
    {
        d(s);
    }

    public void c(String s)
    {
        Log.d("TDialog", "onCancelAddShare");
        e("cancel");
    }

    public void d(String s)
    {
        TDialog.a(a).obtainMessage(1, s).sendToTarget();
        Log.e("onComplete", s);
        a.dismiss();
    }

    public void e(String s)
    {
        Log.d("TDialog", (new StringBuilder()).append("onCancel --msg = ").append(s).toString());
        TDialog.a(a).obtainMessage(2, s).sendToTarget();
        a.dismiss();
    }

    public void f(String s)
    {
        TDialog.a(a).obtainMessage(3, s).sendToTarget();
    }

    public void g(String s)
    {
        TDialog.a(a).obtainMessage(4, s).sendToTarget();
    }
}
