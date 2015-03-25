// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.utils.AsynLoadImgBack;

final class e extends Handler
{

    final AsynLoadImgBack a;

    e(Looper looper, AsynLoadImgBack asynloadimgback)
    {
        a = asynloadimgback;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        int i;
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 101: // 'e'
            String s = (String)message.obj;
            a.saved(0, s);
            return;

        case 102: // 'f'
            i = message.arg1;
            break;
        }
        a.saved(i, null);
    }
}
