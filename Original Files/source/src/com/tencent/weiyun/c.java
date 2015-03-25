// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;

// Referenced classes of package com.tencent.weiyun:
//            a, FileManager, WeiyunFile

class c extends Thread
{

    final a a;

    c(a a1)
    {
        a = a1;
        super();
    }

    public void run()
    {
        Bundle bundle = FileManager.c(a.a);
        bundle.putString("file_id", com.tencent.weiyun.a.d(a).getFileId());
        if (!TextUtils.isEmpty(com.tencent.weiyun.a.e(a)))
        {
            bundle.putString("thumb", com.tencent.weiyun.a.e(a));
        }
        try
        {
            org.json.JSONObject jsonobject = HttpUtils.request(FileManager.d(a.a), com.tencent.weiyun.a.f(a), com.tencent.weiyun.a.a(a, com.tencent.weiyun.a.g(a)), bundle, "GET");
            Message message5 = com.tencent.weiyun.a.h(a).obtainMessage();
            message5.what = 0;
            message5.obj = jsonobject;
            com.tencent.weiyun.a.h(a).sendMessage(message5);
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            Message message4 = com.tencent.weiyun.a.h(a).obtainMessage();
            message4.what = -3;
            message4.obj = malformedurlexception.getMessage();
            com.tencent.weiyun.a.h(a).sendMessage(message4);
            return;
        }
        catch (IOException ioexception)
        {
            Message message3 = com.tencent.weiyun.a.h(a).obtainMessage();
            message3.obj = ioexception.getMessage();
            message3.what = -2;
            com.tencent.weiyun.a.h(a).sendMessage(message3);
            return;
        }
        catch (JSONException jsonexception)
        {
            Message message2 = com.tencent.weiyun.a.h(a).obtainMessage();
            message2.obj = jsonexception.getMessage();
            message2.what = -4;
            com.tencent.weiyun.a.h(a).sendMessage(message2);
            return;
        }
        catch (com.tencent.utils.HttpUtils.NetworkUnavailableException networkunavailableexception)
        {
            Message message1 = com.tencent.weiyun.a.h(a).obtainMessage();
            message1.obj = networkunavailableexception.getMessage();
            message1.what = -10;
            com.tencent.weiyun.a.h(a).sendMessage(message1);
            return;
        }
        catch (com.tencent.utils.HttpUtils.HttpStatusException httpstatusexception)
        {
            Message message = com.tencent.weiyun.a.h(a).obtainMessage();
            message.obj = httpstatusexception.getMessage();
            message.what = -9;
            com.tencent.weiyun.a.h(a).sendMessage(message);
            return;
        }
    }
}
