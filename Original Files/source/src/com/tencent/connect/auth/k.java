// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.tencent.connect.auth:
//            AuthDialog, j

class k
{

    final AuthDialog a;

    private k(AuthDialog authdialog)
    {
        a = authdialog;
        super();
    }

    k(AuthDialog authdialog, j j)
    {
        this(authdialog);
    }

    public void a()
    {
        a(null);
    }

    public void a(String s)
    {
        AuthDialog.f(a).obtainMessage(2, s).sendToTarget();
        a.dismiss();
    }

    public void b(String s)
    {
        AuthDialog.f(a).obtainMessage(3, s).sendToTarget();
    }

    public void c(String s)
    {
        AuthDialog.f(a).obtainMessage(4, s).sendToTarget();
    }
}
