// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v4.content:
//            LocalBroadcastManager

class l extends Handler
{

    final LocalBroadcastManager a;

    l(LocalBroadcastManager localbroadcastmanager, Looper looper)
    {
        a = localbroadcastmanager;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 1: // '\001'
            LocalBroadcastManager.a(a);
            break;
        }
    }
}
