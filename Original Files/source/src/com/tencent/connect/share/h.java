// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.utils.Util;
import java.util.ArrayList;

// Referenced classes of package com.tencent.connect.share:
//            a

final class h
    implements Runnable
{

    final ArrayList a;
    final Handler b;

    h(ArrayList arraylist, Handler handler)
    {
        a = arraylist;
        b = handler;
        super();
    }

    public void run()
    {
        int i = 0;
        while (i < a.size()) 
        {
            String s = (String)a.get(i);
            if (Util.isValidUrl(s) || !Util.fileExists(s))
            {
                continue;
            }
            android.graphics.Bitmap bitmap = com.tencent.connect.share.a.a(s, 10000);
            if (bitmap == null)
            {
                continue;
            }
            String s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/tmp/").toString();
            String s2 = Util.encrypt(s);
            String s3 = (new StringBuilder()).append("share2qzone_temp").append(s2).append(".jpg").toString();
            if (!com.tencent.connect.share.a.a(s, 640, 10000))
            {
                Log.d("AsynScaleCompressImage", "not out of bound,not compress!");
            } else
            {
                Log.d("AsynScaleCompressImage", "out of bound, compress!");
                s = com.tencent.connect.share.a.a(bitmap, s1, s3);
            }
            if (s != null)
            {
                a.set(i, s);
            }
            i++;
        }
        Message message = b.obtainMessage(101);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("images", a);
        message.setData(bundle);
        b.sendMessage(message);
    }
}
