// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.tencent.utils:
//            AsynLoadImg, AsynLoadImgBack

class a extends Handler
{

    final AsynLoadImg a;

    a(AsynLoadImg asynloadimg, Looper looper)
    {
        a = asynloadimg;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        Log.v("AsynLoadImg", (new StringBuilder()).append("handleMessage:").append(message.arg1).toString());
        if (message.arg1 == 0)
        {
            AsynLoadImg.a(a).saved(message.arg1, (String)message.obj);
            return;
        } else
        {
            AsynLoadImg.a(a).saved(message.arg1, null);
            return;
        }
    }
}
