// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.tencent.utils:
//            AsynLoadImg, Util

class b
    implements Runnable
{

    final AsynLoadImg a;

    b(AsynLoadImg asynloadimg)
    {
        a = asynloadimg;
        super();
    }

    public void run()
    {
        Log.v("AsynLoadImg", "saveFileRunnable:");
        String s = Util.encrypt(AsynLoadImg.b(a));
        String s1 = (new StringBuilder()).append("share_qq_").append(s).append(".jpg").toString();
        String s2 = (new StringBuilder()).append(AsynLoadImg.a()).append(s1).toString();
        File file = new File(s2);
        Message message = AsynLoadImg.c(a).obtainMessage();
        if (file.exists())
        {
            message.arg1 = 0;
            message.obj = s2;
            Log.v("AsynLoadImg", (new StringBuilder()).append("file exists: time:").append(System.currentTimeMillis() - AsynLoadImg.d(a)).toString());
        } else
        {
            android.graphics.Bitmap bitmap = AsynLoadImg.getbitmap(AsynLoadImg.b(a));
            boolean flag;
            if (bitmap != null)
            {
                flag = a.saveFile(bitmap, s1);
            } else
            {
                Log.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                flag = false;
            }
            if (flag)
            {
                message.arg1 = 0;
                message.obj = s2;
            } else
            {
                message.arg1 = 1;
            }
            Log.v("AsynLoadImg", (new StringBuilder()).append("file not exists: download time:").append(System.currentTimeMillis() - AsynLoadImg.d(a)).toString());
        }
        AsynLoadImg.c(a).sendMessage(message);
    }
}
