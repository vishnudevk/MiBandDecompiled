// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
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
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package u.aly:
//            bj, bv, bu, bp, 
//            bq

public class bo
{

    private static final String a = u/aly/bo.getName();
    private Map b;

    public bo()
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
                bj.b(a, "Caught IOException in convertStreamToString()", ioexception3);
                return null;
            }
            return stringbuilder.toString();
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
          goto _L1
        ioexception1;
        bj.b(a, "Caught IOException in convertStreamToString()", ioexception1);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception2)
        {
            bj.b(a, "Caught IOException in convertStreamToString()", ioexception2);
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
            bj.b(a, "Caught IOException in convertStreamToString()", ioexception);
            return null;
        }
        throw exception;
    }

    private JSONObject a(String s)
    {
        int i = (new Random()).nextInt(1000);
        String s1;
        s1 = System.getProperty("line.separator");
        if (s.length() > 1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        bj.b(a, (new StringBuilder(String.valueOf(i))).append(":\tInvalid baseUrl.").toString());
        return null;
        HttpGet httpget;
        bj.a(a, (new StringBuilder(String.valueOf(i))).append(":\tget: ").append(s).toString());
        httpget = new HttpGet(s);
        if (b == null || b.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = b.keySet().iterator();
_L12:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        HttpResponse httpresponse = (new DefaultHttpClient(b())).execute(httpget);
        if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L5; else goto _L4
_L4:
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity == null) goto _L7; else goto _L6
_L6:
        InputStream inputstream;
        Header header;
        Object obj;
        String s2;
        try
        {
            inputstream = httpentity.getContent();
            header = httpresponse.getFirstHeader("Content-Encoding");
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), clientprotocolexception);
            return null;
        }
        catch (Exception exception)
        {
            bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), exception);
            return null;
        }
        if (header == null) goto _L9; else goto _L8
_L8:
        if (!header.getValue().equalsIgnoreCase("gzip")) goto _L9; else goto _L10
_L10:
        bj.a(a, (new StringBuilder(String.valueOf(i))).append("  Use GZIPInputStream get data....").toString());
        obj = new GZIPInputStream(inputstream);
_L13:
        s2 = a(((InputStream) (obj)));
        bj.a(a, (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(s1).append(s2).toString());
        if (s2 == null)
        {
            return null;
        }
          goto _L11
_L3:
        String s3 = (String)iterator.next();
        httpget.addHeader(s3, (String)b.get(s3));
          goto _L12
_L9:
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        if (!header.getValue().equalsIgnoreCase("deflate"))
        {
            break MISSING_BLOCK_LABEL_542;
        }
        bj.a(a, (new StringBuilder(String.valueOf(i))).append("  Use InflaterInputStream get data....").toString());
        obj = new InflaterInputStream(inputstream);
          goto _L13
_L11:
        return new JSONObject(s2);
_L5:
        bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tFailed to send message. StatusCode = ").append(httpresponse.getStatusLine().getStatusCode()).append(bv.a).append(s).toString());
_L7:
        return null;
        obj = inputstream;
          goto _L13
    }

    private JSONObject a(String s, JSONObject jsonobject)
    {
        String s1;
        int i;
        HttpPost httppost;
        DefaultHttpClient defaulthttpclient;
        s1 = jsonobject.toString();
        i = (new Random()).nextInt(1000);
        bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\trequest: ").append(s).append(bv.a).append(s1).toString());
        httppost = new HttpPost(s);
        defaulthttpclient = new DefaultHttpClient(b());
        if (!a()) goto _L2; else goto _L1
_L1:
        byte abyte0[] = bu.a((new StringBuilder("content=")).append(s1).toString(), Charset.defaultCharset().toString());
        httppost.addHeader("Content-Encoding", "deflate");
        httppost.setEntity(new InputStreamEntity(new ByteArrayInputStream(abyte0), abyte0.length));
_L13:
        HttpResponse httpresponse = defaulthttpclient.execute(httppost);
        if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L4; else goto _L3
_L3:
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity == null) goto _L6; else goto _L5
_L5:
        InputStream inputstream;
        Header header;
        Object obj;
        String s2;
        try
        {
            inputstream = httpentity.getContent();
            header = httpresponse.getFirstHeader("Content-Encoding");
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), clientprotocolexception);
            return null;
        }
        catch (IOException ioexception)
        {
            bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), ioexception);
            return null;
        }
        catch (JSONException jsonexception)
        {
            bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), jsonexception);
            return null;
        }
        if (header == null) goto _L8; else goto _L7
_L7:
        if (!header.getValue().equalsIgnoreCase("deflate")) goto _L8; else goto _L9
_L9:
        obj = new InflaterInputStream(inputstream);
_L11:
        s2 = a(((InputStream) (obj)));
        bj.a(a, (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(bv.a).append(s2).toString());
        if (s2 == null)
        {
            return null;
        }
          goto _L10
_L2:
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(new BasicNameValuePair("content", s1));
        httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        continue; /* Loop/switch isn't completed */
_L10:
        return new JSONObject(s2);
_L4:
        bj.c(a, (new StringBuilder(String.valueOf(i))).append(":\tFailed to send message. StatusCode = ").append(httpresponse.getStatusLine().getStatusCode()).append(bv.a).append(s).toString());
        return null;
_L8:
        obj = inputstream;
          goto _L11
_L6:
        return null;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private HttpParams b()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpProtocolParams.setUserAgent(basichttpparams, System.getProperty("http.agent"));
        return basichttpparams;
    }

    private void b(String s)
    {
        if (bv.d(s) || !(bp.c.equals(s.trim()) ^ bp.b.equals(s.trim())))
        {
            throw new RuntimeException((new StringBuilder("\u9A8C\u8BC1\u8BF7\u6C42\u65B9\u5F0F\u5931\u8D25[")).append(s).append("]").toString());
        } else
        {
            return;
        }
    }

    public bo a(Map map)
    {
        b = map;
        return this;
    }

    public bq a(bp bp1, Class class1)
    {
        String s = bp1.c().trim();
        b(s);
        JSONObject jsonobject;
        InvocationTargetException invocationtargetexception;
        IllegalAccessException illegalaccessexception;
        InstantiationException instantiationexception;
        IllegalArgumentException illegalargumentexception;
        NoSuchMethodException nosuchmethodexception;
        SecurityException securityexception;
        bq bq1;
        if (bp.c.equals(s))
        {
            jsonobject = a(bp1.b());
        } else
        if (bp.b.equals(s))
        {
            jsonobject = a(bp1.d, bp1.a());
        } else
        {
            jsonobject = null;
        }
        if (jsonobject == null)
        {
            return null;
        }
        bq1 = (bq)class1.getConstructor(new Class[] {
            org/json/JSONObject
        }).newInstance(new Object[] {
            jsonobject
        });
        return bq1;
        securityexception;
        bj.b(a, "SecurityException", securityexception);
_L2:
        return null;
        nosuchmethodexception;
        bj.b(a, "NoSuchMethodException", nosuchmethodexception);
        continue; /* Loop/switch isn't completed */
        illegalargumentexception;
        bj.b(a, "IllegalArgumentException", illegalargumentexception);
        continue; /* Loop/switch isn't completed */
        instantiationexception;
        bj.b(a, "InstantiationException", instantiationexception);
        continue; /* Loop/switch isn't completed */
        illegalaccessexception;
        bj.b(a, "IllegalAccessException", illegalaccessexception);
        continue; /* Loop/switch isn't completed */
        invocationtargetexception;
        bj.b(a, "InvocationTargetException", invocationtargetexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean a()
    {
        return false;
    }

}
