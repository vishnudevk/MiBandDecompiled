// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.tencent.open:
//            o, TDialog

class p extends Handler
{

    private o a;

    public p(o o1, Looper looper)
    {
        super(looper);
        a = o1;
    }

    public void handleMessage(Message message)
    {
        Log.d("TAG", (new StringBuilder()).append("--handleMessage--msg.WHAT = ").append(message.what).toString());
        message.what;
        JVM INSTR tableswitch 1 5: default 68
    //                   1 69
    //                   2 84
    //                   3 92
    //                   4 127
    //                   5 157;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        o.a(a, (String)message.obj);
        return;
_L3:
        a.onCancel();
        return;
_L4:
        if (TDialog.a() != null && TDialog.a().get() != null)
        {
            TDialog.a((Context)TDialog.a().get(), (String)message.obj);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (TDialog.b() != null && TDialog.b().get() != null)
        {
            ((View)TDialog.b().get()).setVisibility(8);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (TDialog.a() != null && TDialog.a().get() != null)
        {
            TDialog.b((Context)TDialog.a().get(), (String)message.obj);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }
}
