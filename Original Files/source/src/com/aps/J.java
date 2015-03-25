// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aps:
//            I, y, as

final class J extends Handler
{

    private I a;

    J(I i)
    {
        a = i;
        super();
    }

    public final void handleMessage(Message message)
    {
        try
        {
            switch (message.what)
            {
            case 1: // '\001'
                if (y.d(a.a) != null)
                {
                    y.d(a.a).a((String)message.obj);
                    return;
                }
                break;
            }
        }
        catch (Exception exception) { }
    }
}
