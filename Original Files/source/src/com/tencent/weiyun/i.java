// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.os.Handler;
import android.os.Message;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.tencent.weiyun:
//            f

class i extends Thread
{

    final f a;

    i(f f1)
    {
        a = f1;
        super();
    }

    public void run()
    {
        DefaultHttpClient defaulthttpclient;
        int j;
        byte abyte1[];
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 15000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpProtocolParams.setUserAgent(basichttpparams, "TX_QQF_ANDROID");
        defaulthttpclient = new DefaultHttpClient(basichttpparams);
        byte abyte0[] = new byte[0x20000];
        FileInputStream fileinputstream;
        int k;
        try
        {
            fileinputstream = new FileInputStream(f.c(a));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Message message6 = f.i(a).obtainMessage();
            message6.what = -2;
            message6.obj = "";
            f.i(a).sendMessage(message6);
            return;
        }
        j = 0;
_L4:
        if ((long)j >= f.f(a)) goto _L2; else goto _L1
_L1:
        k = fileinputstream.read(abyte0);
        abyte1 = f.a(a, abyte0, k, j);
        j += k;
        if (abyte1 != null) goto _L3; else goto _L2
_L2:
        IOException ioexception1;
        Message message1;
        HttpPost httppost;
        IOException ioexception2;
        Message message2;
        int l;
        Message message3;
        Message message4;
        int i1;
        Message message5;
        int j1;
        try
        {
            fileinputstream.close();
            return;
        }
        catch (IOException ioexception)
        {
            Message message = f.i(a).obtainMessage();
            message.what = -2;
            message.obj = ioexception.getMessage();
            f.i(a).sendMessage(message);
            return;
        }
        break MISSING_BLOCK_LABEL_74;
        ioexception1;
        message1 = f.i(a).obtainMessage();
        message1.what = -2;
        message1.obj = "";
        f.i(a).sendMessage(message1);
          goto _L2
_L3:
        httppost = new HttpPost((new StringBuilder()).append("http://").append(f.j(a)).append("/ftn_handler/?bmd5=").append(f.e(a)).toString());
        httppost.addHeader("Accept-Encoding", "*/*");
        httppost.setHeader("Connection", "Keep-Alive");
        httppost.setHeader("Pragma", "no-cache");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httppost.setEntity(new ByteArrayEntity(abyte1));
        j1 = defaulthttpclient.execute(httppost).getStatusLine().getStatusCode();
        l = j1;
_L5:
        if (l != 200)
        {
            break MISSING_BLOCK_LABEL_524;
        }
        if ((long)j < f.f(a))
        {
            i1 = (int)((100L * (long)j) / f.f(a));
            message5 = f.i(a).obtainMessage();
            message5.what = 1;
            message5.obj = (new StringBuilder()).append(i1).append("").toString();
            f.i(a).sendMessage(message5);
        } else
        {
            message4 = f.i(a).obtainMessage();
            message4.what = 2;
            message4.obj = "";
            f.i(a).sendMessage(message4);
        }
          goto _L4
        ioexception2;
        message2 = f.i(a).obtainMessage();
        message2.what = -2;
        message2.obj = "";
        f.i(a).sendMessage(message2);
        l = 0;
          goto _L5
        message3 = f.i(a).obtainMessage();
        message3.what = -9;
        message3.obj = "";
        f.i(a).sendMessage(message3);
          goto _L2
    }
}
