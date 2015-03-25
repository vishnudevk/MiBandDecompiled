// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.RC4;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.Event;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat:
//            d, StatConfig, b, e

class c
{

    private static StatLogger c = StatCommonHelper.getLogger();
    private static long d = -1L;
    private static c e = null;
    private static Context f = null;
    DefaultHttpClient a;
    Handler b;

    private c()
    {
        a = null;
        b = null;
        try
        {
            HandlerThread handlerthread = new HandlerThread("StatDispatcher");
            handlerthread.start();
            d = handlerthread.getId();
            b = new Handler(handlerthread.getLooper());
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
            HttpConnectionParams.setSoTimeout(basichttpparams, 10000);
            a = new DefaultHttpClient(basichttpparams);
            a.setKeepAliveStrategy(new d(this));
            if (StatConfig.b() != null)
            {
                a.getParams().setParameter("http.route.default-proxy", StatConfig.b());
            }
            return;
        }
        catch (Throwable throwable)
        {
            c.e(throwable);
        }
    }

    static Context a()
    {
        return f;
    }

    static void a(Context context)
    {
        f = context.getApplicationContext();
    }

    static c b()
    {
        if (e == null)
        {
            e = new c();
        }
        return e;
    }

    void a(Event event, b b1)
    {
        String as[] = new String[1];
        as[0] = event.toJsonString();
        b(Arrays.asList(as), b1);
    }

    void a(List list, b b1)
    {
        StringBuilder stringbuilder;
        HttpPost httppost;
        stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append((String)list.get(i));
            if (i != -1 + list.size())
            {
                stringbuilder.append(",");
            }
        }

        stringbuilder.append("]");
        String s = StatConfig.getStatReportUrl();
        c.i((new StringBuilder()).append("[").append(s).append("]Send request(").append(stringbuilder.toString().length()).append("bytes):").append(stringbuilder.toString()).toString());
        httppost = new HttpPost(s);
        org.apache.http.HttpHost httphost;
        httppost.addHeader("Accept-Encoding", "gzip");
        httppost.setHeader("Connection", "Keep-Alive");
        httppost.removeHeaders("Cache-Control");
        httphost = StatCommonHelper.getHttpProxy(f);
        boolean flag;
        flag = false;
        if (httphost == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        a.getParams().setParameter("http.route.default-proxy", StatCommonHelper.getHttpProxy(f));
        httppost.addHeader("X-Online-Host", "pingma.qq.com:80");
        httppost.addHeader("Accept", "*/*");
        httppost.addHeader("Content-Type", "json");
        flag = true;
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        int j;
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = stringbuilder.toString().getBytes("UTF-8");
        j = abyte0.length;
        if (stringbuilder.length() >= 256) goto _L2; else goto _L1
_L1:
        if (httphost != null) goto _L4; else goto _L3
_L3:
        httppost.addHeader("Content-Encoding", "rc4");
_L23:
        HttpResponse httpresponse;
        httppost.setEntity(new ByteArrayEntity(RC4.encrypt(abyte0)));
        httpresponse = a.execute(httppost);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        a.getParams().removeParameter("http.route.default-proxy");
        HttpEntity httpentity;
        int k;
        long l;
        httpentity = httpresponse.getEntity();
        k = httpresponse.getStatusLine().getStatusCode();
        l = httpentity.getContentLength();
        c.i((new StringBuilder()).append("recv response status code:").append(k).append(", content length:").append(l).toString());
        if (l != 0L) goto _L6; else goto _L5
_L5:
        EntityUtils.toString(httpentity);
        if (k != 200) goto _L8; else goto _L7
_L7:
        if (b1 == null) goto _L10; else goto _L9
_L9:
        b1.a();
        return;
_L4:
        httppost.addHeader("X-Content-Encoding", "rc4");
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        c.e(throwable);
        if (b1 == null) goto _L10; else goto _L11
_L11:
        b1.b();
        return;
        Exception exception;
        exception;
        throw exception;
_L2:
        if (httphost != null)
        {
            break MISSING_BLOCK_LABEL_591;
        }
        httppost.addHeader("Content-Encoding", "rc4,gzip");
_L12:
        bytearrayoutputstream.write(new byte[4]);
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        gzipoutputstream.write(abyte0);
        gzipoutputstream.close();
        abyte0 = bytearrayoutputstream.toByteArray();
        ByteBuffer.wrap(abyte0, 0, 4).putInt(j);
        c.d((new StringBuilder()).append("before Gzip:").append(j).append(" bytes, after Gzip:").append(abyte0.length).append(" bytes").toString());
        continue; /* Loop/switch isn't completed */
        httppost.addHeader("X-Content-Encoding", "rc4,gzip");
          goto _L12
_L8:
        c.error((new StringBuilder()).append("Server response error code:").append(k).toString());
        return;
_L6:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_947;
        }
        InputStream inputstream;
        byte abyte1[];
        Header header;
        inputstream = httpentity.getContent();
        DataInputStream datainputstream = new DataInputStream(inputstream);
        abyte1 = new byte[(int)httpentity.getContentLength()];
        datainputstream.readFully(abyte1);
        header = httpresponse.getFirstHeader("Content-Encoding");
        if (header == null) goto _L14; else goto _L13
_L13:
        if (!header.getValue().equalsIgnoreCase("gzip,rc4")) goto _L16; else goto _L15
_L15:
        byte abyte2[] = RC4.decrypt(StatCommonHelper.deocdeGZipContent(abyte1));
        abyte1 = abyte2;
_L14:
        if (k != 200)
        {
            break MISSING_BLOCK_LABEL_897;
        }
        JSONObject jsonobject;
        c.d(new String(abyte1, "UTF-8"));
        jsonobject = (new JSONObject(new String(abyte1, "UTF-8"))).getJSONObject("cfg");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_786;
        }
        StatConfig.a(jsonobject);
_L20:
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_796;
        }
        b1.a();
_L21:
        inputstream.close();
        return;
_L16:
label0:
        {
            if (!header.getValue().equalsIgnoreCase("rc4,gzip"))
            {
                break label0;
            }
            abyte1 = StatCommonHelper.deocdeGZipContent(RC4.decrypt(abyte1));
        }
          goto _L14
        if (!header.getValue().equalsIgnoreCase("gzip")) goto _L18; else goto _L17
_L17:
        abyte1 = StatCommonHelper.deocdeGZipContent(abyte1);
          goto _L14
_L18:
        if (!header.getValue().equalsIgnoreCase("rc4")) goto _L14; else goto _L19
_L19:
        abyte1 = RC4.decrypt(abyte1);
          goto _L14
        JSONException jsonexception;
        jsonexception;
        c.i(jsonexception.toString());
          goto _L20
        c.error((new StringBuilder()).append("Server response error code:").append(k).append(", error:").append(new String(abyte1, "UTF-8")).toString());
          goto _L21
        EntityUtils.toString(httpentity);
_L10:
        return;
        if (true) goto _L23; else goto _L22
_L22:
    }

    void b(List list, b b1)
    {
        if (list.isEmpty() || b == null)
        {
            return;
        } else
        {
            b.post(new e(this, list, b1));
            return;
        }
    }

}
