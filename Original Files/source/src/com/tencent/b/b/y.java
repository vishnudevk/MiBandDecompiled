// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.tencent.b.b:
//            n

final class y extends Handler
{

    private n a;

    public y(n n1)
    {
        a = n1;
        super(Looper.getMainLooper());
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 9: default 88
    //                   1: 89
    //                   2: 104
    //                   3: 119
    //                   4: 134
    //                   5: 146
    //                   6: 158
    //                   8: 223
    //                   16: 192
    //                   256: 173;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return;
_L2:
        n.a(a, (e.a)message.obj);
        return;
_L3:
        n.a(a, (m.b)message.obj);
        return;
_L4:
        n.a(a, (f.b)message.obj);
        return;
_L5:
        n.a(a, message.arg1);
        return;
_L6:
        n.b(a, message.arg1);
        return;
_L7:
        n.a(a, (Location)message.obj);
        return;
_L10:
        if (n.e(a) == 1)
        {
            n.c(a);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (message.obj != null)
        {
            n.a(a, (String)message.obj);
            n.a(a, null);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        if (message.arg1 == 0)
        {
            n.b(a, (String)message.obj);
            return;
        }
        if (n.f(a) == null || !n.f(a).a())
        {
            n.g(a);
            return;
        }
        if (true) goto _L1; else goto _L11
_L11:
    }
}
