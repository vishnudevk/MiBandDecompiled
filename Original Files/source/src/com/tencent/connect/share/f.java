// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.utils.Util;

// Referenced classes of package com.tencent.connect.share:
//            a

final class f
    implements Runnable
{

    final String a;
    final Handler b;

    f(String s, Handler handler)
    {
        a = s;
        b = handler;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = com.tencent.connect.share.a.a(a, 140);
        if (bitmap != null)
        {
            String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/tmp/").toString();
            String s1 = Util.encrypt(a);
            String s2 = (new StringBuilder()).append("share2qq_temp").append(s1).append(".jpg").toString();
            String s3;
            if (!com.tencent.connect.share.a.a(a, 140, 140))
            {
                Log.d("AsynScaleCompressImage", "not out of bound,not compress!");
                s3 = a;
            } else
            {
                Log.d("AsynScaleCompressImage", "out of bound,compress!");
                s3 = com.tencent.connect.share.a.a(bitmap, s, s2);
            }
            if (s3 != null)
            {
                Message message1 = b.obtainMessage(101);
                message1.obj = s3;
                b.sendMessage(message1);
                return;
            }
        }
        Message message = b.obtainMessage(102);
        message.arg1 = 3;
        b.sendMessage(message);
    }
}
