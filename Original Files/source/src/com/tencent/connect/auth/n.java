// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.tencent.connect.auth:
//            m, AuthDialog

class n extends Handler
{

    private m a;

    public n(m m1, Looper looper)
    {
        super(looper);
        a = m1;
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 48
    //                   3 56;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        m.a(a, (String)message.obj);
        return;
_L3:
        a.onCancel();
        return;
_L4:
        if (AuthDialog.a() != null && AuthDialog.a().get() != null)
        {
            AuthDialog.a((Context)AuthDialog.a().get(), (String)message.obj);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
