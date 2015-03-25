// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xiaomi.market.sdk:
//            g, d, s, XiaomiUpdateAgent, 
//            i, h, e, f

public class c
{

    private static final String a = "MarketConnection";
    private static final int b = 10000;
    private static final int c = 10000;
    private static final int d = 30000;
    protected static final String r = "http";
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected JSONObject v;
    protected URL w;
    protected h x;
    protected String y;
    protected boolean z;

    public c(String s1)
    {
        this(s1, false);
    }

    public c(String s1, String s2)
    {
        this(c(s1, s2), false);
    }

    public c(String s1, boolean flag)
    {
        URL url;
        try
        {
            url = new URL(s1);
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("MarketConnection", (new StringBuilder("URL error: ")).append(malformedurlexception).toString());
            url = null;
        }
        a(url);
        E = flag;
    }

    private g a(int j)
    {
        if (j == 200)
        {
            return g.I;
        } else
        {
            Log.e("MarketConnection", (new StringBuilder("Network Error : ")).append(j).toString());
            return g.N;
        }
    }

    private g a(String s1, String s2, boolean flag, boolean flag1, i j)
    {
        Iterator iterator;
        ArrayList arraylist = new ArrayList();
        arraylist.add(s1);
        iterator = arraylist.iterator();
_L11:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        g g2 = g.K;
_L10:
        return g2;
_L2:
        String s3;
        s3 = (String)iterator.next();
        if (s.b)
        {
            Log.d("MarketConnection", (new StringBuilder("hosted connection url: ")).append(s3).toString());
        }
        URL url = new URL(s3);
        HttpURLConnection httpurlconnection2 = (HttpURLConnection)url.openConnection();
        httpurlconnection2.setConnectTimeout(10000);
        if (!s.d(XiaomiUpdateAgent.a())) goto _L4; else goto _L3
_L3:
        httpurlconnection2.setReadTimeout(10000);
_L12:
        if (!flag) goto _L6; else goto _L5
_L5:
        httpurlconnection2.setRequestMethod("GET");
        httpurlconnection2.setDoOutput(false);
_L13:
        HttpURLConnection httpurlconnection3 = a(httpurlconnection2);
        HttpURLConnection httpurlconnection1 = httpurlconnection3;
        httpurlconnection1.connect();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        if (!TextUtils.isEmpty(s2))
        {
            OutputStream outputstream = httpurlconnection1.getOutputStream();
            outputstream.write(s2.getBytes());
            if (s.b)
            {
                Log.d("MarketConnection", (new StringBuilder("[post]")).append(s2).toString());
            }
            outputstream.close();
        }
        g g3;
        g2 = a(httpurlconnection1.getResponseCode());
        g3 = g.I;
        if (g2 != g3 || j == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        BufferedInputStream bufferedinputstream = new BufferedInputStream(httpurlconnection1.getInputStream(), 8192);
        byte abyte0[] = new byte[1024];
_L14:
        int k = bufferedinputstream.read(abyte0, 0, 1024);
        if (k > 0) goto _L8; else goto _L7
_L7:
        j.flush();
        if (bufferedinputstream == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bufferedinputstream.close();
        if (httpurlconnection1 == null) goto _L10; else goto _L9
_L9:
        httpurlconnection1.disconnect();
        return g2;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        Log.e("MarketConnection", (new StringBuilder(" URL error :")).append(malformedurlexception).toString());
          goto _L11
_L4:
        httpurlconnection2.setReadTimeout(30000);
          goto _L12
        Exception exception3;
        exception3;
        Exception exception;
        HttpURLConnection httpurlconnection;
        httpurlconnection = httpurlconnection2;
        exception = exception3;
_L15:
        Log.e("MarketConnection", (new StringBuilder("Connection Exception for ")).append(url.getHost()).append(" :").append(exception).toString());
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
          goto _L11
_L6:
        httpurlconnection2.setRequestMethod("POST");
        httpurlconnection2.setDoOutput(true);
          goto _L13
        Exception exception2;
        exception2;
        Exception exception1;
        httpurlconnection1 = httpurlconnection2;
        exception1 = exception2;
_L16:
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
        throw exception1;
        d d1;
        d1;
        g g1 = d1.F;
        if (httpurlconnection2 != null)
        {
            httpurlconnection2.disconnect();
        }
        return g1;
_L8:
        j.write(abyte0, 0, k);
          goto _L14
        Exception exception5;
        exception5;
_L18:
        Log.e("MarketConnection", (new StringBuilder("Connection Exception for ")).append(url.getHost()).append(" : read file stream error ").append(exception5).toString());
        j.reset();
        if (bufferedinputstream == null)
        {
            break MISSING_BLOCK_LABEL_545;
        }
        bufferedinputstream.close();
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
          goto _L11
        Exception exception4;
        exception4;
        bufferedinputstream = null;
_L17:
        if (bufferedinputstream == null)
        {
            break MISSING_BLOCK_LABEL_573;
        }
        bufferedinputstream.close();
        throw exception4;
        exception;
        httpurlconnection = httpurlconnection1;
          goto _L15
        exception1;
        httpurlconnection1 = null;
          goto _L16
        exception1;
          goto _L16
        exception1;
        httpurlconnection1 = httpurlconnection;
          goto _L16
        exception;
        httpurlconnection = null;
          goto _L15
        exception4;
          goto _L17
        exception5;
        bufferedinputstream = null;
          goto _L18
    }

    private void a(URL url)
    {
        z = true;
        A = false;
        B = true;
        C = true;
        D = true;
        if (b(url))
        {
            w = url;
        }
    }

    public static String c(String s1, String s2)
    {
        if (TextUtils.isEmpty(s1))
        {
            return s2;
        }
        if (TextUtils.isEmpty(s2))
        {
            return s1;
        }
        if (s1.charAt(-1 + s1.length()) == '/')
        {
            s1 = s1.substring(0, -1 + s1.length());
        }
        if (s2.charAt(0) == '/')
        {
            s2 = s2.substring(1);
        }
        return (new StringBuilder(String.valueOf(s1))).append("/").append(s2).toString();
    }

    protected g a(i j)
    {
        g g1;
        if (w == null)
        {
            g1 = g.J;
        } else
        {
            if (!s.c(XiaomiUpdateAgent.a()))
            {
                return g.K;
            }
            if (x == null)
            {
                getClass();
                x = new h(this);
            }
            h _tmp = x;
            h h1;
            String s1;
            try
            {
                h1 = a(x);
            }
            catch (d d1)
            {
                return d1.F;
            }
            s1 = w.toString();
            if (A && !h1.isEmpty())
            {
                String s4 = w.getQuery();
                String s5 = w.toString();
                String s2;
                String s3;
                long l;
                long l1;
                if (TextUtils.isEmpty(s4))
                {
                    s1 = (new StringBuilder(String.valueOf(s5))).append("?").append(h1.toString()).toString();
                } else
                {
                    s1 = (new StringBuilder(String.valueOf(s5))).append("&").append(h1.toString()).toString();
                }
            }
            try
            {
                s2 = a(s1, h1);
            }
            catch (d d2)
            {
                return d2.F;
            }
            if (s.b)
            {
                Log.d("MarketConnection", (new StringBuilder("connection url: ")).append(s2).toString());
            }
            s3 = "";
            if (!A)
            {
                s3 = h1.toString();
            }
            l = System.currentTimeMillis();
            g1 = a(s2, s3, A, false, j);
            if (s.b)
            {
                l1 = System.currentTimeMillis();
                Log.d("MarketConnection", (new StringBuilder("Time(ms) spent in request: ")).append(l1 - l).append(", ").append(s2).toString());
                return g1;
            }
        }
        return g1;
    }

    protected h a(h h1)
    {
        return h1;
    }

    protected String a(String s1, h h1)
    {
        return s1;
    }

    protected HttpURLConnection a(HttpURLConnection httpurlconnection)
    {
        return httpurlconnection;
    }

    public void a(boolean flag)
    {
        A = flag;
    }

    public g b(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException();
        }
        e e1;
        g g1;
        try
        {
            e1 = new e(this, file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Log.e("MarketConnection", (new StringBuilder("File not found: ")).append(filenotfoundexception).toString());
            throw filenotfoundexception;
        }
        g1 = a(e1);
        try
        {
            e1.close();
            if (g1 != g.I)
            {
                Log.e("MarketConnection", (new StringBuilder("Connection failed : ")).append(g1).toString());
                file.delete();
            }
        }
        catch (IOException ioexception)
        {
            return g1;
        }
        return g1;
    }

    public void b(boolean flag)
    {
        z = flag;
    }

    protected boolean b(URL url)
    {
        while (url == null || !TextUtils.equals(url.getProtocol(), "http")) 
        {
            return false;
        }
        return true;
    }

    public void c(boolean flag)
    {
        B = flag;
    }

    public void d(boolean flag)
    {
        C = flag;
    }

    public JSONObject e()
    {
        return v;
    }

    public void e(boolean flag)
    {
        D = flag;
    }

    public String f()
    {
        return y;
    }

    public h g()
    {
        return x;
    }

    public g h()
    {
        ByteArrayOutputStream bytearrayoutputstream;
        g g1;
        bytearrayoutputstream = new ByteArrayOutputStream();
        g1 = a(new f(this, bytearrayoutputstream));
        if (g1 != g.I)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        v = new JSONObject(bytearrayoutputstream.toString());
_L1:
        Exception exception;
        IOException ioexception;
        JSONException jsonexception;
        g g2;
        IOException ioexception1;
        try
        {
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception2)
        {
            return g1;
        }
        return g1;
        Log.e("MarketConnection", (new StringBuilder("Connection failed : ")).append(g1).toString());
          goto _L1
        jsonexception;
        Log.e("MarketConnection", (new StringBuilder("JSON error: ")).append(jsonexception).toString());
        g2 = g.O;
        try
        {
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception1)
        {
            return g2;
        }
        return g2;
        exception;
        try
        {
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        throw exception;
    }

    public g i()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        g g1 = a(new f(this, bytearrayoutputstream));
        if (g1 == g.I)
        {
            y = bytearrayoutputstream.toString();
        } else
        {
            Log.e("MarketConnection", (new StringBuilder("Connection failed : ")).append(g1).toString());
        }
        try
        {
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception)
        {
            return g1;
        }
        return g1;
    }
}
