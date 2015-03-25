// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.utils.AsynLoadImgBack;

final class g extends Handler
{

    final AsynLoadImgBack a;

    g(Looper looper, AsynLoadImgBack asynloadimgback)
    {
        a = asynloadimgback;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        java.util.ArrayList arraylist;
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 101: // 'e'
            arraylist = message.getData().getStringArrayList("images");
            break;
        }
        a.batchSaved(0, arraylist);
    }
}
