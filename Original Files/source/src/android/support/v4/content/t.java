// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v4.content:
//            s, ModernAsyncTask, o

class t extends Handler
{

    private t()
    {
    }

    t(o o)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        s s1 = (s)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            ModernAsyncTask.c(s1.a, s1.b[0]);
            return;

        case 2: // '\002'
            s1.a.b(s1.b);
            break;
        }
    }
}
