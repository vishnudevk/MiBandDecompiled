// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.tencent.weiyun:
//            a, WeiyunFile

class d extends Thread
{

    final a a;

    d(a a1)
    {
        a = a1;
        super();
    }

    public void run()
    {
        String s;
        DefaultHttpClient defaulthttpclient;
        InputStream inputstream;
        FileOutputStream fileoutputstream;
        byte abyte0[];
        InputStream inputstream1;
        int k;
        long l2;
        long l3;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 15000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpProtocolParams.setUserAgent(basichttpparams, "TX_QQF_ANDROID");
        s = (new StringBuilder()).append("http://").append(com.tencent.weiyun.a.i(a)).append(":").append(com.tencent.weiyun.a.j(a)).append("/ftn_handler/").append(com.tencent.weiyun.a.k(a)).append("/").toString();
        if (!TextUtils.isEmpty(com.tencent.weiyun.a.l(a)))
        {
            s = (new StringBuilder()).append(s).append("?size=").append(com.tencent.weiyun.a.l(a)).toString();
        }
        defaulthttpclient = new DefaultHttpClient(basichttpparams);
        inputstream = null;
        File file = new File(com.tencent.weiyun.a.c(a));
        long l1;
        HttpGet httpget1;
        HttpResponse httpresponse1;
        int i1;
        int j1;
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Message message5 = com.tencent.weiyun.a.h(a).obtainMessage();
            message5.what = -2;
            message5.obj = filenotfoundexception.getMessage();
            com.tencent.weiyun.a.h(a).sendMessage(message5);
            return;
        }
        abyte0 = new byte[0x40000];
        if (!TextUtils.isEmpty(com.tencent.weiyun.a.e(a))) goto _L2; else goto _L1
_L1:
        long l;
        if (com.tencent.weiyun.a.d(a).getFileSize() > 0x40000L)
        {
            l = 0x40000L;
        } else
        {
            l = com.tencent.weiyun.a.d(a).getFileSize();
        }
        l1 = l + 0L;
        k = 0;
        l2 = 0L;
        inputstream1 = null;
        l3 = l1;
_L13:
        if (l3 > com.tencent.weiyun.a.d(a).getFileSize()) goto _L4; else goto _L3
_L3:
        httpget1 = new HttpGet(s);
        httpget1.addHeader("Accept-Encoding", "gzip");
        httpget1.addHeader("Host", com.tencent.weiyun.a.i(a));
        httpget1.addHeader("Connection", "Keep-Alive");
        httpget1.addHeader("Cookie", (new StringBuilder()).append(com.tencent.weiyun.a.m(a)).append("=").append(com.tencent.weiyun.a.n(a)).toString());
        httpget1.addHeader("Pragma", "no-cache");
        httpget1.addHeader("RANGE", (new StringBuilder()).append("bytes=").append(l2).append("-").append(l3).append("").toString());
        httpresponse1 = defaulthttpclient.execute(httpget1);
        Log.i("weiyun_test", (new StringBuilder()).append("uploadFileToWeiyun doDownloadPic response:").append(httpresponse1.toString()).toString());
        i1 = httpresponse1.getStatusLine().getStatusCode();
        if (i1 != 200 && i1 != 206) goto _L4; else goto _L5
_L5:
        inputstream1 = httpresponse1.getEntity().getContent();
_L8:
        j1 = inputstream1.read(abyte0);
        if (j1 <= 0) goto _L7; else goto _L6
_L6:
        fileoutputstream.write(abyte0, 0, j1);
        l2 += j1;
          goto _L8
        Exception exception1;
        exception1;
        if (++k <= 10) goto _L7; else goto _L9
_L9:
        exception1.printStackTrace();
        Log.e("weiyun_test", (new StringBuilder()).append("uploadFileToWeiyun doDownloadPic error:").append(exception1.getMessage()).append("").toString());
        Message message4 = com.tencent.weiyun.a.h(a).obtainMessage();
        message4.what = -2;
        message4.obj = exception1.getMessage();
        com.tencent.weiyun.a.h(a).sendMessage(message4);
_L4:
        fileoutputstream.close();
        inputstream1.close();
        Message message2 = com.tencent.weiyun.a.h(a).obtainMessage();
        message2.what = 2;
        com.tencent.weiyun.a.h(a).sendMessage(message2);
        return;
_L7:
        if (com.tencent.weiyun.a.d(a).getFileSize() - l3 <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        long l4;
        Message message3;
        if (com.tencent.weiyun.a.d(a).getFileSize() - l2 > 0x40000L)
        {
            l4 = 0x40000L;
        } else
        {
            l4 = com.tencent.weiyun.a.d(a).getFileSize() - l2;
        }
        l3 = l4 + l2;
        message3 = com.tencent.weiyun.a.h(a).obtainMessage();
        message3.what = 1;
        message3.obj = (new StringBuilder()).append((100L * l3) / com.tencent.weiyun.a.d(a).getFileSize()).append("").toString();
        com.tencent.weiyun.a.h(a).sendMessage(message3);
        continue; /* Loop/switch isn't completed */
_L2:
        HttpGet httpget = new HttpGet(s);
        httpget.addHeader("Accept-Encoding", "gzip");
        httpget.addHeader("Host", com.tencent.weiyun.a.i(a));
        httpget.addHeader("Connection", "Keep-Alive");
        httpget.addHeader("Cookie", (new StringBuilder()).append(com.tencent.weiyun.a.m(a)).append("=").append(com.tencent.weiyun.a.n(a)).append("").toString());
        httpget.addHeader("Pragma", "no-cache");
        HttpResponse httpresponse;
        int i;
        int j;
        try
        {
            httpresponse = defaulthttpclient.execute(httpget);
            Log.i("weiyun_test", (new StringBuilder()).append("uploadFileToWeiyun doDownloadPic response:").append(httpresponse.toString()).toString());
            i = httpresponse.getStatusLine().getStatusCode();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.e("weiyun_test", (new StringBuilder()).append("uploadFileToWeiyun doDownloadPic error:").append(exception.getMessage()).append("").toString());
            Message message = com.tencent.weiyun.a.h(a).obtainMessage();
            message.what = -2;
            message.obj = exception.getMessage();
            com.tencent.weiyun.a.h(a).sendMessage(message);
            try
            {
                fileoutputstream.close();
                inputstream.close();
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }
        if (i != 200)
        {
            inputstream = null;
            if (i != 206)
            {
                break MISSING_BLOCK_LABEL_1182;
            }
        }
        inputstream = httpresponse.getEntity().getContent();
_L10:
        j = inputstream.read(abyte0);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_1182;
        }
        fileoutputstream.write(abyte0, 0, j);
          goto _L10
        inputstream1 = inputstream;
        if (true) goto _L4; else goto _L11
_L11:
        IOException ioexception1;
        ioexception1;
        Message message1 = com.tencent.weiyun.a.h(a).obtainMessage();
        message1.what = -2;
        message1.obj = ioexception1.getMessage();
        com.tencent.weiyun.a.h(a).sendMessage(message1);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
