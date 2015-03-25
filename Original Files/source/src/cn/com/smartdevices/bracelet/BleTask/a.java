// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleCallBack

class a extends Handler
{

    final BleCallBack a;

    a(BleCallBack blecallback)
    {
        a = blecallback;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            a.onStart();
            return;

        case 1: // '\001'
            a.onFinish(message.obj);
            return;

        case 2: // '\002'
            a.onProgress(message.arg1);
            return;

        case 3: // '\003'
            a.onFailed(message.obj);
            break;
        }
    }
}
