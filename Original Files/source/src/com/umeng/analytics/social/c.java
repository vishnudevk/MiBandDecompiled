// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.umeng.analytics.social:
//            b

public abstract class c
{

    public c()
    {
    }

    private static String a(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 8192);
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            Exception exception;
            IOException ioexception;
            IOException ioexception1;
            IOException ioexception2;
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception3)
            {
                b.b("MobclickAgent", "Caught IOException in convertStreamToString()", ioexception3);
                return null;
            }
            return stringbuilder.toString();
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
          goto _L1
        ioexception1;
        b.b("MobclickAgent", "Caught IOException in convertStreamToString()", ioexception1);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception2)
        {
            b.b("MobclickAgent", "Caught IOException in convertStreamToString()", ioexception2);
            return null;
        }
        return null;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            b.b("MobclickAgent", "Caught IOException in convertStreamToString()", ioexception);
            return null;
        }
        throw exception;
    }

    protected static String a(String s)
    {
        int i = (new Random()).nextInt(1000);
        String s1;
        s1 = System.getProperty("line.separator");
        if (s.length() > 1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        b.b("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tInvalid baseUrl.").toString());
        return null;
        HttpResponse httpresponse;
        HttpGet httpget = new HttpGet(s);
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": GET_URL: ").append(s).toString());
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        httpresponse = (new DefaultHttpClient(basichttpparams)).execute(httpget);
        if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        HttpEntity httpentity = httpresponse.getEntity();
        InputStream inputstream;
        Object obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        Header header;
        String s2;
        try
        {
            inputstream = httpentity.getContent();
            header = httpresponse.getFirstHeader("Content-Encoding");
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), clientprotocolexception);
            return null;
        }
        catch (Exception exception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), exception);
            return null;
        }
        if (header == null) goto _L4; else goto _L3
_L3:
        if (!header.getValue().equalsIgnoreCase("gzip")) goto _L4; else goto _L5
_L5:
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append("  Use GZIPInputStream get data....").toString());
        obj = new GZIPInputStream(inputstream);
_L6:
        s2 = a(((InputStream) (obj)));
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(s1).append(s2).toString());
        if (s2 != null)
        {
            return s2;
        }
        break MISSING_BLOCK_LABEL_451;
_L4:
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        if (!header.getValue().equalsIgnoreCase("deflate"))
        {
            break MISSING_BLOCK_LABEL_444;
        }
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append("  Use InflaterInputStream get data....").toString());
        obj = new InflaterInputStream(inputstream);
          goto _L6
_L2:
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tFailed to get message.").append(s).toString());
        return null;
        obj = inputstream;
          goto _L6
        return null;
    }

    protected static String a(String s, String s1)
    {
        int i;
        String s2;
        DefaultHttpClient defaulthttpclient;
        i = (new Random()).nextInt(1000);
        s2 = System.getProperty("line.separator");
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        defaulthttpclient = new DefaultHttpClient(basichttpparams);
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": POST_URL: ").append(s).toString());
        HttpResponse httpresponse;
        HttpPost httppost = new HttpPost(s);
        if (!TextUtils.isEmpty(s1))
        {
            b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": POST_BODY: ").append(s1).toString());
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(new BasicNameValuePair("data", s1));
            httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        }
        httpresponse = defaulthttpclient.execute(httppost);
        if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        HttpEntity httpentity = httpresponse.getEntity();
        InputStream inputstream;
        Object obj;
        String s3;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        Header header;
        try
        {
            inputstream = httpentity.getContent();
            header = httpresponse.getFirstHeader("Content-Encoding");
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), clientprotocolexception);
            return null;
        }
        catch (IOException ioexception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), ioexception);
            return null;
        }
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        if (!header.getValue().equalsIgnoreCase("deflate"))
        {
            break MISSING_BLOCK_LABEL_412;
        }
        obj = new InflaterInputStream(inputstream);
_L3:
        s3 = a(((InputStream) (obj)));
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(s2).append(s3).toString());
        if (s3 == null)
        {
            return null;
        } else
        {
            return s3;
        }
_L2:
        b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tFailed to send message.").append(s).toString());
        return null;
        obj = inputstream;
          goto _L3
        return null;
    }
}
