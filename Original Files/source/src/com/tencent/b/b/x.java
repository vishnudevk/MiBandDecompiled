// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.telephony.TelephonyManager;
import java.util.List;

// Referenced classes of package com.tencent.b.b:
//            m

final class x extends Thread
{

    private m a;

    x(m m1)
    {
        a = m1;
        super();
    }

    public final void run()
    {
        if (m.d(a) == null) goto _L2; else goto _L1
_L1:
        List list = m.d(a).getNeighboringCellInfo();
        byte abyte0[] = m.e(a);
        abyte0;
        JVM INSTR monitorenter ;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        m.f(a).clear();
        m.f(a).addAll(list);
        abyte0;
        JVM INSTR monitorexit ;
_L2:
        m.a(a, false);
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
