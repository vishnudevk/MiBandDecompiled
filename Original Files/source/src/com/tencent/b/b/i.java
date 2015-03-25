// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.net.Proxy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.tencent.b.b:
//            u, j, t, h, 
//            b, d, v

public final class i
{

    private static int a = 0;
    private static boolean b;

    private static u a(HttpURLConnection httpurlconnection, boolean flag)
    {
        int k;
        int l;
        InputStream inputstream;
        k = 1;
        l = 0;
        inputstream = null;
        u u1;
        String s;
        u1 = new u();
        s = httpurlconnection.getContentType();
        String s1 = "GBK";
        if (s == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i1;
        as = s.split(";");
        i1 = as.length;
        int j1 = 0;
          goto _L3
_L2:
        u1.b = s1;
        if (!flag) goto _L5; else goto _L4
_L4:
        if (s == null) goto _L7; else goto _L6
_L6:
        if (!s.contains("vnd.wap.wml")) goto _L7; else goto _L8
_L8:
        inputstream = null;
        if (k == 0) goto _L5; else goto _L9
_L9:
        httpurlconnection.disconnect();
        httpurlconnection.connect();
_L5:
        inputstream = httpurlconnection.getInputStream();
        if (inputstream == null) goto _L11; else goto _L10
_L10:
        byte abyte0[];
        u1.a = new byte[0];
        abyte0 = new byte[1024];
_L12:
        int k1 = inputstream.read(abyte0);
        if (k1 <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l += k1;
        byte abyte1[] = new byte[l];
        System.arraycopy(u1.a, 0, abyte1, 0, u1.a.length);
        System.arraycopy(abyte0, 0, abyte1, u1.a.length, k1);
        u1.a = abyte1;
        if (k1 > 0) goto _L12; else goto _L11
_L11:
        Exception exception;
        String s2;
        String as1[];
        String s3;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1)
            {
                return u1;
            }
        }
        return u1;
_L13:
        s2 = as[j1];
        if (!s2.contains("charset"))
        {
            break MISSING_BLOCK_LABEL_250;
        }
        as1 = s2.split("=");
        if (as1.length <= k)
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = as1[1].trim();
        s1 = s3;
        break; /* Loop/switch isn't completed */
        j1++;
        continue; /* Loop/switch isn't completed */
_L7:
        k = 0;
          goto _L8
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception;
_L3:
        if (j1 < i1) goto _L13; else goto _L2
    }

    public static u a(boolean flag, String s, String s1, String s2, byte abyte0[], boolean flag1, boolean flag2)
    {
        boolean flag3;
        DataOutputStream dataoutputstream;
        flag3 = true;
        dataoutputstream = null;
        if (!t.d())
        {
            throw new h();
        }
        HttpURLConnection httpurlconnection2 = a(s, flag2);
        HttpURLConnection httpurlconnection1 = httpurlconnection2;
        boolean flag4 = com.tencent.b.b.b.a(null);
        dataoutputstream = null;
        if (!flag4) goto _L2; else goto _L1
_L1:
        if (!com.tencent.b.b.b.a(httpurlconnection1.getURL().getHost()));
_L7:
        if (!flag) goto _L4; else goto _L3
_L3:
        httpurlconnection1.setRequestMethod("GET");
_L8:
        httpurlconnection1.setConnectTimeout(d.a());
        httpurlconnection1.setReadTimeout(d.b());
        httpurlconnection1.setRequestProperty("User-Agent", s1);
        httpurlconnection1.setDoInput(true);
        if (flag)
        {
            flag3 = false;
        }
        httpurlconnection1.setDoOutput(flag3);
        httpurlconnection1.setUseCaches(false);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        httpurlconnection1.setRequestProperty("Connection", "Keep-Alive");
        d.a(httpurlconnection1);
        httpurlconnection1.connect();
        d.c();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        dataoutputstream = null;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        int k = abyte0.length;
        dataoutputstream = null;
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        DataOutputStream dataoutputstream1 = new DataOutputStream(httpurlconnection1.getOutputStream());
        dataoutputstream1.write(abyte0);
        dataoutputstream1.flush();
        dataoutputstream1.close();
        int l = httpurlconnection1.getResponseCode();
        if (l != 200 && l != 206) goto _L6; else goto _L5
_L5:
        u u1;
        d.d();
        u1 = a(httpurlconnection1, flag);
        int i1;
        i1 = 0;
        dataoutputstream = null;
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        byte abyte1[] = u1.a;
        i1 = 0;
        dataoutputstream = null;
        if (abyte1 == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        i1 = u1.a.length;
        d.a(i1);
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
        return u1;
_L2:
        httpurlconnection1.setRequestProperty("Host", null);
          goto _L7
        j j1;
        j1;
        HttpURLConnection httpurlconnection = httpurlconnection1;
_L11:
        d.a(true);
        throw j1;
        Exception exception;
        exception;
        httpurlconnection1 = httpurlconnection;
_L9:
        if (dataoutputstream != null)
        {
            dataoutputstream.close();
        }
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
        throw exception;
_L4:
        httpurlconnection1.setRequestMethod("POST");
          goto _L8
        Exception exception1;
        exception1;
_L10:
        d.a(false);
        throw exception1;
        exception;
          goto _L9
_L6:
        if (l != 202 && l != 201 && l != 204 && l != 205 && l != 304 && l != 305 && l != 408 && l != 502 && l != 504 && l != 503)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        throw new IOException("doGetOrPost retry");
        throw new j((new StringBuilder("response code is ")).append(l).toString());
        exception;
        dataoutputstream = null;
        httpurlconnection1 = null;
          goto _L9
        exception;
        dataoutputstream = dataoutputstream1;
          goto _L9
        exception1;
        dataoutputstream = null;
        httpurlconnection1 = null;
          goto _L10
        exception1;
        dataoutputstream = dataoutputstream1;
          goto _L10
        j1;
        dataoutputstream = null;
        httpurlconnection = null;
          goto _L11
        j1;
        dataoutputstream = dataoutputstream1;
        httpurlconnection = httpurlconnection1;
          goto _L11
    }

    private static HttpURLConnection a(String s, boolean flag)
    {
        HttpURLConnection httpurlconnection;
        URL url;
        httpurlconnection = null;
        boolean flag1;
        try
        {
            url = new URL(s);
        }
        catch (MalformedURLException malformedurlexception1)
        {
            malformedurlexception1.printStackTrace();
            return null;
        }
        if (t.c())
        {
            flag1 = false;
        } else
        {
            v.a();
            if (com.tencent.b.b.b.a(Proxy.getDefaultHost()))
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
        }
        if (!flag1)
        {
            HttpURLConnection httpurlconnection5;
            try
            {
                httpurlconnection5 = (HttpURLConnection)url.openConnection();
            }
            catch (IOException ioexception1)
            {
                ioexception1.printStackTrace();
                return null;
            }
            return httpurlconnection5;
        }
        if (a != 0 || b) goto _L2; else goto _L1
_L1:
        b = true;
        URL url1 = new URL("http://ls.map.soso.com/monitor/monitor.html");
        java.net.Proxy proxy;
        String s2 = Proxy.getDefaultHost();
        int l = Proxy.getDefaultPort();
        if (l == -1)
        {
            l = 80;
        }
        InetSocketAddress inetsocketaddress1 = new InetSocketAddress(s2, l);
        proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetsocketaddress1);
        HttpURLConnection httpurlconnection4 = (HttpURLConnection)url1.openConnection(proxy);
        boolean flag2;
        httpurlconnection4.setRequestMethod("GET");
        httpurlconnection4.setConnectTimeout(15000);
        httpurlconnection4.setReadTimeout(45000);
        httpurlconnection4.setRequestProperty("User-Agent", "QQ Map Mobile");
        httpurlconnection4.setDoInput(true);
        httpurlconnection4.setDoOutput(false);
        httpurlconnection4.setUseCaches(false);
        flag2 = a(httpurlconnection4);
        httpurlconnection4.connect();
        if (!flag2) goto _L4; else goto _L3
_L3:
        a(1);
_L7:
        if (httpurlconnection4 != null)
        {
            httpurlconnection4.disconnect();
        }
_L2:
        a;
        JVM INSTR tableswitch 2 2: default 268
    //                   2 386;
           goto _L5 _L6
_L5:
        String s1;
        int k;
        s1 = Proxy.getDefaultHost();
        k = Proxy.getDefaultPort();
        Exception exception;
        HttpURLConnection httpurlconnection3;
        Exception exception1;
        if (k == -1)
        {
            k = 80;
        }
        HttpURLConnection httpurlconnection1;
        HttpURLConnection httpurlconnection2;
        Exception exception3;
        MalformedURLException malformedurlexception;
        try
        {
            InetSocketAddress inetsocketaddress = new InetSocketAddress(s1, k);
            httpurlconnection2 = (HttpURLConnection)url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP, inetsocketaddress));
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        return httpurlconnection2;
        malformedurlexception;
        b = false;
          goto _L2
_L4:
        a(2);
          goto _L7
        exception3;
        httpurlconnection3 = httpurlconnection4;
        exception = exception3;
_L10:
        exception.printStackTrace();
        a(2);
        if (httpurlconnection3 != null)
        {
            httpurlconnection3.disconnect();
        }
          goto _L2
        exception1;
_L9:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw exception1;
_L6:
        httpurlconnection1 = a(url, s);
        return httpurlconnection1;
        Exception exception2;
        exception2;
        httpurlconnection = httpurlconnection4;
        exception1 = exception2;
        continue; /* Loop/switch isn't completed */
        exception1;
        httpurlconnection = httpurlconnection3;
        if (true) goto _L9; else goto _L8
_L8:
        exception;
        httpurlconnection3 = null;
          goto _L10
    }

    private static HttpURLConnection a(URL url, String s)
    {
        int k = 80;
        String s1 = Proxy.getDefaultHost();
        int l = Proxy.getDefaultPort();
        if (l == -1)
        {
            l = k;
        }
        String s2 = url.getHost();
        int i1 = url.getPort();
        String s3;
        URL url1;
        HttpURLConnection httpurlconnection;
        if (i1 != -1)
        {
            k = i1;
        }
        if (s.indexOf((new StringBuilder(String.valueOf(s2))).append(":").append(k).toString()) != -1)
        {
            s3 = s.replaceFirst((new StringBuilder(String.valueOf(s2))).append(":").append(k).toString(), (new StringBuilder(String.valueOf(s1))).append(":").append(l).toString());
        } else
        {
            s3 = s.replaceFirst(s2, (new StringBuilder(String.valueOf(s1))).append(":").append(l).toString());
        }
        try
        {
            url1 = new URL(s3);
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        httpurlconnection = (HttpURLConnection)url1.openConnection();
        httpurlconnection.setRequestProperty("X-Online-Host", (new StringBuilder(String.valueOf(s2))).append(":").append(k).toString());
        return httpurlconnection;
    }

    private static void a(int k)
    {
        if (a == k)
        {
            return;
        } else
        {
            a = k;
            return;
        }
    }

    private static boolean a(HttpURLConnection httpurlconnection)
    {
        InputStream inputstream = null;
        boolean flag;
        inputstream = httpurlconnection.getInputStream();
        flag = httpurlconnection.getContentType().equals("text/html");
        if (flag) goto _L2; else goto _L1
_L1:
        boolean flag2;
        if (inputstream != null)
        {
            inputstream.close();
        }
        flag2 = false;
_L4:
        return flag2;
_L2:
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L5:
        boolean flag1;
        if (inputstream.available() > 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        flag1 = (new String(bytearrayoutputstream.toByteArray())).trim().equals("1");
        flag2 = flag1;
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        inputstream.close();
        return flag2;
        bytearrayoutputstream.write(inputstream.read());
          goto _L5
        Exception exception;
        exception;
        if (inputstream != null)
        {
            inputstream.close();
        }
        throw exception;
    }

}
