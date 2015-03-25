// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;

// Referenced classes of package com.tencent.weiyun:
//            f, FileManager

class h extends Thread
{

    final f a;

    h(f f1)
    {
        a = f1;
        super();
    }

    public void run()
    {
        Uri uri = Uri.parse(f.c(a));
        String s = (new StringBuilder()).append(SystemClock.elapsedRealtime()).append("__").append(uri.getLastPathSegment()).toString();
        Bundle bundle = FileManager.a(a.a);
        bundle.putString("sha", f.d(a));
        bundle.putString("md5", f.e(a));
        bundle.putString("size", (new StringBuilder()).append(f.f(a)).append("").toString());
        bundle.putString("name", s);
        bundle.putString("upload_type", "control");
        try
        {
            org.json.JSONObject jsonobject = HttpUtils.request(FileManager.b(a.a), f.g(a), f.a(a, f.h(a)), bundle, "GET");
            Message message5 = f.i(a).obtainMessage();
            message5.what = 0;
            message5.obj = jsonobject;
            f.i(a).sendMessage(message5);
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            Message message4 = f.i(a).obtainMessage();
            message4.what = -3;
            message4.obj = malformedurlexception.getMessage();
            f.i(a).sendMessage(message4);
            return;
        }
        catch (IOException ioexception)
        {
            Message message3 = f.i(a).obtainMessage();
            message3.obj = ioexception.getMessage();
            message3.what = -2;
            f.i(a).sendMessage(message3);
            return;
        }
        catch (JSONException jsonexception)
        {
            Message message2 = f.i(a).obtainMessage();
            message2.obj = jsonexception.getMessage();
            message2.what = -4;
            f.i(a).sendMessage(message2);
            return;
        }
        catch (com.tencent.utils.HttpUtils.NetworkUnavailableException networkunavailableexception)
        {
            Message message1 = f.i(a).obtainMessage();
            message1.obj = networkunavailableexception.getMessage();
            message1.what = -10;
            f.i(a).sendMessage(message1);
            return;
        }
        catch (com.tencent.utils.HttpUtils.HttpStatusException httpstatusexception)
        {
            Message message = f.i(a).obtainMessage();
            message.obj = httpstatusexception.getMessage();
            message.what = -9;
            f.i(a).sendMessage(message);
            return;
        }
    }
}
