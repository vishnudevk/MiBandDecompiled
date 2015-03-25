// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.c;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aps:
//            f, t

public class l
{

    private static l a = null;

    private l()
    {
    }

    public static int a(NetworkInfo networkinfo)
    {
        while (networkinfo == null || !networkinfo.isAvailable() || !networkinfo.isConnected()) 
        {
            return -1;
        }
        return networkinfo.getType();
    }

    public static l a()
    {
        if (a == null)
        {
            a = new l();
        }
        return a;
    }

    public static String a(TelephonyManager telephonymanager)
    {
        int i = 0;
        if (telephonymanager != null)
        {
            i = telephonymanager.getNetworkType();
        }
        return (String)f.l.get(i, "UNKNOWN");
    }

    public static HttpClient a(Context context, NetworkInfo networkinfo)
    {
        boolean flag;
        Cursor cursor;
        BasicHttpParams basichttpparams;
        Uri uri;
        ContentResolver contentresolver;
        flag = true;
        cursor = null;
        basichttpparams = new BasicHttpParams();
        if (networkinfo.getType() != 0)
        {
            break MISSING_BLOCK_LABEL_633;
        }
        uri = Uri.parse("content://telephony/carriers/preferapn");
        contentresolver = context.getContentResolver();
        Cursor cursor2 = contentresolver.query(uri, null, null, null, null);
        Cursor cursor1 = cursor2;
        if (cursor1 == null) goto _L2; else goto _L1
_L1:
        if (!cursor1.moveToFirst()) goto _L2; else goto _L3
_L3:
        String s5 = cursor1.getString(cursor1.getColumnIndex("apn"));
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        s5 = s5.toLowerCase(Locale.US);
        t.a(new Object[] {
            "nm|found apn:", s5
        });
        if (s5 == null) goto _L5; else goto _L4
_L4:
        if (!s5.contains("ctwap")) goto _L5; else goto _L6
_L6:
        String s7 = b();
        if (TextUtils.isEmpty(s7)) goto _L8; else goto _L7
_L7:
        boolean flag5 = s7.equals("null");
        if (flag5) goto _L8; else goto _L9
_L9:
        boolean flag4 = flag;
_L19:
        byte byte0;
        String s;
        if (!flag4)
        {
            s7 = "10.0.0.200";
        }
        s = s7;
        byte0 = 80;
_L12:
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L13:
        if (a(s, byte0))
        {
            basichttpparams.setParameter("http.route.default-proxy", new HttpHost(s, byte0, "http"));
        }
        t.a(basichttpparams, 30000);
        HttpProtocolParams.setUseExpectContinue(basichttpparams, false);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
_L5:
        if (s5 == null) goto _L2; else goto _L10
_L10:
        if (!s5.contains("wap")) goto _L2; else goto _L11
_L11:
        String s6;
        boolean flag3;
        s6 = b();
        if (TextUtils.isEmpty(s6))
        {
            break MISSING_BLOCK_LABEL_606;
        }
        flag3 = s6.equals("null");
        boolean flag2;
        if (flag3)
        {
            break MISSING_BLOCK_LABEL_606;
        }
        flag2 = flag;
_L18:
        if (!flag2)
        {
            s6 = "10.0.0.172";
        }
        s = s6;
        byte0 = 80;
          goto _L12
        SecurityException securityexception;
        securityexception;
_L17:
        String s1;
        String s2;
        if (networkinfo.getExtraInfo() == null)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        s1 = networkinfo.getExtraInfo().toLowerCase(Locale.US);
        s2 = b();
        if (s1.indexOf("ctwap") == -1)
        {
            break MISSING_BLOCK_LABEL_439;
        }
        Exception exception;
        Exception exception1;
        Exception exception2;
        String s3;
        boolean flag1;
        String s4;
        SecurityException securityexception1;
        Exception exception3;
        if (!TextUtils.isEmpty(s2) && !s2.equals("null"))
        {
            s4 = s2;
        } else
        {
            s4 = null;
            flag = false;
        }
        if (!flag)
        {
            s4 = "10.0.0.200";
        }
        s = s4;
        byte0 = 80;
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L13
        if (s1.indexOf("wap") == -1)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        if (!TextUtils.isEmpty(s2) && !s2.equals("null"))
        {
            s3 = s2;
            flag1 = flag;
        } else
        {
            s3 = null;
            flag1 = false;
        }
        if (!flag1)
        {
            s3 = "10.0.0.200";
        }
        s = s3;
        byte0 = 80;
        break MISSING_BLOCK_LABEL_426;
        exception1;
        exception2 = exception1;
        cursor1 = null;
_L16:
        t.a(exception2);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        byte0 = -1;
        s = null;
          goto _L13
        exception;
        cursor1 = null;
_L15:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
        exception;
        continue; /* Loop/switch isn't completed */
        exception;
        cursor1 = cursor;
        if (true) goto _L15; else goto _L14
_L14:
        exception3;
        exception2 = exception3;
          goto _L16
        securityexception1;
        cursor = cursor1;
          goto _L17
        byte0 = -1;
        s = null;
        break MISSING_BLOCK_LABEL_426;
        s6 = null;
        flag2 = false;
          goto _L18
_L2:
        byte0 = -1;
        s = null;
          goto _L12
_L8:
        s7 = null;
        flag4 = false;
          goto _L19
        byte0 = -1;
        s = null;
          goto _L13
    }

    private static boolean a(String s, int i)
    {
        return s != null && s.length() > 0 && i != -1;
    }

    private static boolean a(HttpResponse httpresponse)
    {
        Header header = httpresponse.getFirstHeader("Content-Encoding");
        return header != null && header.getValue().equalsIgnoreCase("gzip");
    }

    public static String[] a(JSONObject jsonobject)
    {
        String as[] = {
            null, null, null, null, null
        };
        if (jsonobject == null || "http://apilocate.amap.com/mobile/binary".length() == 0)
        {
            as[0] = "false";
        } else
        {
            try
            {
                String s = jsonobject.getString("key");
                String s1 = jsonobject.getString("X-INFO");
                String s2 = jsonobject.getString("X-BIZ");
                String s3 = jsonobject.getString("User-Agent");
                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s3))
                {
                    as[0] = "true";
                    as[1] = s;
                    as[2] = s1;
                    as[3] = s2;
                    as[4] = s3;
                }
            }
            catch (JSONException jsonexception) { }
            if (as[0] == null || !as[0].equals("true"))
            {
                as[0] = "true";
                return as;
            }
        }
        return as;
    }

    private static String b()
    {
        String s1 = Proxy.getDefaultHost();
        String s = s1;
_L2:
        if (s == null)
        {
            s = "null";
        }
        return s;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String a(Context context, String s, byte abyte0[], String s1)
    {
        if (!TextUtils.isEmpty(s) && abyte0 != null) goto _L2; else goto _L1
_L1:
        String s2 = null;
_L14:
        return s2;
_L2:
        NetworkInfo networkinfo;
        InputStream inputstream;
        GZIPInputStream gzipinputstream;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        StringBuffer stringbuffer;
        String s3;
        networkinfo = t.b(context);
        if (a(networkinfo) == -1)
        {
            return null;
        }
        inputstream = null;
        gzipinputstream = null;
        inputstreamreader = null;
        bufferedreader = null;
        stringbuffer = new StringBuffer();
        s3 = "";
        HttpClient httpclient3 = a(context, networkinfo);
        HttpClient httpclient1 = httpclient3;
        HttpPost httppost1 = new HttpPost(s);
        HttpResponse httpresponse;
        int i;
        ByteArrayEntity bytearrayentity = new ByteArrayEntity(abyte0);
        httppost1.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httppost1.addHeader("User-Agent", "AMAP Location SDK Android 1.2.0");
        httppost1.addHeader("Accept-Encoding", "gzip");
        httppost1.addHeader("Connection", "Keep-Alive");
        httppost1.addHeader("X-INFO", c.a(null).b(s1));
        httppost1.addHeader("ia", "1");
        httppost1.addHeader("key", c.a());
        stringbuffer.delete(0, stringbuffer.length());
        httppost1.setEntity(bytearrayentity);
        httpresponse = httpclient1.execute(httppost1);
        i = httpresponse.getStatusLine().getStatusCode();
        if (i != 200) goto _L4; else goto _L3
_L3:
        InputStream inputstream4 = httpresponse.getEntity().getContent();
        InputStream inputstream2 = inputstream4;
        String s4 = httpresponse.getEntity().getContentType().getValue();
        String s5 = "";
        int j = s4.indexOf("charset=");
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        s5 = s4.substring(j + 8);
        UnknownHostException unknownhostexception;
        BufferedReader bufferedreader1;
        InputStreamReader inputstreamreader1;
        GZIPInputStream gzipinputstream1;
        InputStream inputstream1;
        HttpPost httppost;
        HttpClient httpclient;
        Exception exception;
        GZIPInputStream gzipinputstream2;
        InputStreamReader inputstreamreader2;
        BufferedReader bufferedreader2;
        Exception exception1;
        Exception exception2;
        HttpPost httppost2;
        GZIPInputStream gzipinputstream3;
        BufferedReader bufferedreader3;
        HttpClient httpclient2;
        InputStream inputstream3;
        InputStreamReader inputstreamreader3;
        Throwable throwable5;
        Throwable throwable6;
        SocketException socketexception1;
        SocketTimeoutException sockettimeoutexception1;
        ConnectTimeoutException connecttimeoutexception1;
        Throwable throwable10;
        Exception exception4;
        UnknownHostException unknownhostexception2;
        SocketException socketexception2;
        SocketTimeoutException sockettimeoutexception2;
        ConnectTimeoutException connecttimeoutexception2;
        Throwable throwable11;
        Exception exception5;
        String s6;
        SocketException socketexception3;
        SocketTimeoutException sockettimeoutexception3;
        ConnectTimeoutException connecttimeoutexception3;
        Throwable throwable12;
        UnknownHostException unknownhostexception3;
        String s7;
        UnknownHostException unknownhostexception4;
        SocketException socketexception4;
        SocketTimeoutException sockettimeoutexception4;
        ConnectTimeoutException connecttimeoutexception4;
        Exception exception6;
        SocketException socketexception5;
        SocketTimeoutException sockettimeoutexception5;
        ConnectTimeoutException connecttimeoutexception5;
        Throwable throwable16;
        Exception exception7;
        UnknownHostException unknownhostexception6;
        SocketException socketexception6;
        SocketTimeoutException sockettimeoutexception6;
        ConnectTimeoutException connecttimeoutexception6;
        Throwable throwable17;
        Exception exception8;
        if (TextUtils.isEmpty(s5))
        {
            s6 = "UTF-8";
        } else
        {
            s6 = s5;
        }
        if (!a(httpresponse)) goto _L6; else goto _L5
_L5:
        gzipinputstream2 = new GZIPInputStream(inputstream2);
_L26:
        if (gzipinputstream2 == null) goto _L8; else goto _L7
_L7:
        inputstreamreader2 = new InputStreamReader(gzipinputstream2, s6);
_L12:
        bufferedreader2 = new BufferedReader(inputstreamreader2, 2048);
_L11:
        s7 = bufferedreader2.readLine();
        if (s7 == null) goto _L10; else goto _L9
_L9:
        stringbuffer.append(s7);
          goto _L11
        unknownhostexception3;
        bufferedreader1 = bufferedreader2;
        inputstreamreader1 = inputstreamreader2;
        gzipinputstream1 = gzipinputstream2;
        inputstream1 = inputstream2;
        httppost = httppost1;
        httpclient = httpclient1;
_L13:
        throw new AMapLocException("\u672A\u77E5\u4E3B\u673A - UnKnowHostException");
        exception;
        httpclient1 = httpclient;
        httppost1 = httppost;
        inputstream2 = inputstream1;
        gzipinputstream2 = gzipinputstream1;
        inputstreamreader2 = inputstreamreader1;
        bufferedreader2 = bufferedreader1;
        exception1 = exception;
_L20:
        if (httppost1 != null)
        {
            httppost1.abort();
        }
        if (httpclient1 != null)
        {
            httpclient1.getConnectionManager().shutdown();
        }
        Throwable throwable4;
        SocketException socketexception;
        UnknownHostException unknownhostexception1;
        UnknownHostException unknownhostexception5;
        if (gzipinputstream2 != null)
        {
            try
            {
                gzipinputstream2.close();
            }
            catch (Throwable throwable3) { }
        }
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            catch (Throwable throwable2)
            {
                throwable2.printStackTrace();
            }
        }
        if (inputstreamreader2 != null)
        {
            try
            {
                inputstreamreader2.close();
            }
            catch (Throwable throwable1)
            {
                throwable1.printStackTrace();
            }
        }
        if (bufferedreader2 != null)
        {
            try
            {
                bufferedreader2.close();
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        }
        throw exception1;
_L8:
        inputstreamreader2 = new InputStreamReader(inputstream2, s6);
          goto _L12
        unknownhostexception5;
        gzipinputstream1 = gzipinputstream2;
        inputstream1 = inputstream2;
        httppost = httppost1;
        httpclient = httpclient1;
        bufferedreader1 = null;
        inputstreamreader1 = null;
          goto _L13
_L10:
        s3 = stringbuffer.toString();
        stringbuffer.delete(0, stringbuffer.length());
        s2 = s3;
_L25:
        if (httppost1 != null)
        {
            httppost1.abort();
        }
        if (httpclient1 != null)
        {
            httpclient1.getConnectionManager().shutdown();
        }
        Throwable throwable7;
        Throwable throwable8;
        Throwable throwable9;
        if (gzipinputstream2 != null)
        {
            try
            {
                gzipinputstream2.close();
            }
            catch (Throwable throwable15) { }
        }
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            catch (Throwable throwable14)
            {
                throwable14.printStackTrace();
            }
        }
        if (inputstreamreader2 != null)
        {
            try
            {
                inputstreamreader2.close();
            }
            catch (Throwable throwable13)
            {
                throwable13.printStackTrace();
            }
        }
        if (bufferedreader2 == null)
        {
            break MISSING_BLOCK_LABEL_650;
        }
        bufferedreader2.close();
_L18:
        if (TextUtils.isEmpty(s2))
        {
            return null;
        }
          goto _L14
_L4:
        if (i != 404) goto _L16; else goto _L15
_L15:
        throw new AMapLocException("\u670D\u52A1\u5668\u8FDE\u63A5\u5931\u8D25 - UnknownServiceException");
        unknownhostexception1;
        httppost = httppost1;
        httpclient = httpclient1;
        bufferedreader1 = null;
        inputstreamreader1 = null;
        gzipinputstream1 = null;
        inputstream1 = null;
          goto _L13
        socketexception;
        httpclient1 = null;
        httppost1 = null;
_L24:
        throw new AMapLocException("socket \u8FDE\u63A5\u5F02\u5E38 - SocketException");
_L23:
        throw new AMapLocException("socket \u8FDE\u63A5\u8D85\u65F6 - SocketTimeoutException");
_L22:
        throw new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
        throwable4;
        httppost2 = null;
        gzipinputstream3 = null;
        bufferedreader3 = null;
        s2 = s3;
        httpclient2 = null;
        inputstream3 = null;
        inputstreamreader3 = null;
        throwable5 = throwable4;
_L21:
        throwable5.printStackTrace();
        if (httppost2 != null)
        {
            httppost2.abort();
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
        }
        if (gzipinputstream3 != null)
        {
            try
            {
                gzipinputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable9) { }
        }
        if (inputstream3 != null)
        {
            try
            {
                inputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable8)
            {
                throwable8.printStackTrace();
            }
        }
        if (inputstreamreader3 != null)
        {
            try
            {
                inputstreamreader3.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable7)
            {
                throwable7.printStackTrace();
            }
        }
        if (bufferedreader3 == null) goto _L18; else goto _L17
_L17:
        bufferedreader3.close();
          goto _L18
        throwable6;
_L19:
        throwable6.printStackTrace();
          goto _L18
        throwable6;
          goto _L19
        exception2;
        exception1 = exception2;
        bufferedreader2 = null;
        inputstreamreader2 = null;
        gzipinputstream2 = null;
        inputstream2 = null;
        httppost1 = null;
        httpclient1 = null;
          goto _L20
        exception8;
        exception1 = exception8;
        bufferedreader2 = null;
        inputstreamreader2 = null;
        gzipinputstream2 = null;
        inputstream2 = null;
        httppost1 = null;
          goto _L20
        exception4;
        exception1 = exception4;
        bufferedreader2 = null;
        inputstreamreader2 = null;
        gzipinputstream2 = null;
        inputstream2 = null;
          goto _L20
        exception5;
        exception1 = exception5;
        bufferedreader2 = null;
        inputstreamreader2 = null;
        gzipinputstream2 = null;
          goto _L20
        exception7;
        exception1 = exception7;
        bufferedreader2 = null;
        inputstreamreader2 = null;
          goto _L20
        exception6;
        exception1 = exception6;
        bufferedreader2 = null;
          goto _L20
        exception1;
          goto _L20
        exception1;
        bufferedreader2 = bufferedreader3;
        inputstreamreader2 = inputstreamreader3;
        gzipinputstream2 = gzipinputstream3;
        inputstream2 = inputstream3;
        httppost1 = httppost2;
        httpclient1 = httpclient2;
          goto _L20
        throwable17;
        throwable5 = throwable17;
        String s9 = s3;
        httpclient2 = httpclient1;
        s2 = s9;
        bufferedreader3 = null;
        inputstreamreader3 = null;
        gzipinputstream3 = null;
        inputstream3 = null;
        httppost2 = null;
          goto _L21
        throwable10;
        s2 = s3;
        httpclient2 = httpclient1;
        httppost2 = httppost1;
        throwable5 = throwable10;
        bufferedreader3 = null;
        inputstreamreader3 = null;
        gzipinputstream3 = null;
        inputstream3 = null;
          goto _L21
        throwable11;
        throwable5 = throwable11;
        s2 = s3;
        httpclient2 = httpclient1;
        httppost2 = httppost1;
        inputstream3 = inputstream2;
        bufferedreader3 = null;
        inputstreamreader3 = null;
        gzipinputstream3 = null;
          goto _L21
        throwable16;
        s2 = s3;
        httpclient2 = httpclient1;
        httppost2 = httppost1;
        inputstream3 = inputstream2;
        gzipinputstream3 = gzipinputstream2;
        throwable5 = throwable16;
        bufferedreader3 = null;
        inputstreamreader3 = null;
          goto _L21
        throwable5;
        String s8 = s3;
        httpclient2 = httpclient1;
        httppost2 = httppost1;
        inputstream3 = inputstream2;
        gzipinputstream3 = gzipinputstream2;
        inputstreamreader3 = inputstreamreader2;
        s2 = s8;
        bufferedreader3 = null;
          goto _L21
        throwable12;
        s2 = s3;
        httpclient2 = httpclient1;
        httppost2 = httppost1;
        inputstream3 = inputstream2;
        gzipinputstream3 = gzipinputstream2;
        inputstreamreader3 = inputstreamreader2;
        bufferedreader3 = bufferedreader2;
        throwable5 = throwable12;
          goto _L21
        connecttimeoutexception6;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
        httppost1 = null;
          goto _L22
        connecttimeoutexception1;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
          goto _L22
        connecttimeoutexception2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
          goto _L22
        connecttimeoutexception5;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
          goto _L22
        connecttimeoutexception4;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
          goto _L22
        connecttimeoutexception3;
        bufferedreader = bufferedreader2;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
          goto _L22
        sockettimeoutexception6;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
        httppost1 = null;
          goto _L23
        sockettimeoutexception1;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
          goto _L23
        sockettimeoutexception2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
          goto _L23
        sockettimeoutexception5;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
          goto _L23
        sockettimeoutexception4;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
          goto _L23
        sockettimeoutexception3;
        bufferedreader = bufferedreader2;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
          goto _L23
        socketexception6;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
        httppost1 = null;
          goto _L24
        socketexception1;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
          goto _L24
        socketexception2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
          goto _L24
        socketexception5;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
        inputstreamreader = null;
          goto _L24
        socketexception4;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
        bufferedreader = null;
          goto _L24
        socketexception3;
        bufferedreader = bufferedreader2;
        inputstreamreader = inputstreamreader2;
        gzipinputstream = gzipinputstream2;
        inputstream = inputstream2;
          goto _L24
        unknownhostexception;
        bufferedreader1 = null;
        inputstreamreader1 = null;
        gzipinputstream1 = null;
        inputstream1 = null;
        httppost = null;
        httpclient = null;
          goto _L13
        unknownhostexception6;
        httpclient = httpclient1;
        bufferedreader1 = null;
        inputstreamreader1 = null;
        gzipinputstream1 = null;
        inputstream1 = null;
        httppost = null;
          goto _L13
        unknownhostexception2;
        inputstream1 = inputstream2;
        httppost = httppost1;
        httpclient = httpclient1;
        bufferedreader1 = null;
        inputstreamreader1 = null;
        gzipinputstream1 = null;
          goto _L13
        unknownhostexception4;
        inputstreamreader1 = inputstreamreader2;
        gzipinputstream1 = gzipinputstream2;
        inputstream1 = inputstream2;
        httppost = httppost1;
        httpclient = httpclient1;
        bufferedreader1 = null;
          goto _L13
_L16:
        s2 = s3;
        bufferedreader2 = null;
        inputstreamreader2 = null;
        gzipinputstream2 = null;
        inputstream2 = null;
          goto _L25
_L6:
        gzipinputstream2 = null;
          goto _L26
        Exception exception3;
        exception3;
        inputstream2 = inputstream;
        gzipinputstream2 = gzipinputstream;
        inputstreamreader2 = inputstreamreader;
        bufferedreader2 = bufferedreader;
        exception1 = exception3;
          goto _L20
        SocketTimeoutException sockettimeoutexception;
        sockettimeoutexception;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
        httppost1 = null;
        httpclient1 = null;
          goto _L23
        ConnectTimeoutException connecttimeoutexception;
        connecttimeoutexception;
        bufferedreader = null;
        inputstreamreader = null;
        gzipinputstream = null;
        inputstream = null;
        httppost1 = null;
        httpclient1 = null;
          goto _L22
    }

    public String a(byte abyte0[], Context context)
    {
        NetworkInfo networkinfo;
        HttpClient httpclient;
        HttpPost httppost;
        InputStream inputstream;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        StringBuffer stringbuffer1;
        int i;
        boolean flag;
        StringBuffer stringbuffer2;
        String s;
        networkinfo = t.b(context);
        if (a(networkinfo) == -1)
        {
            return null;
        }
        httpclient = null;
        httppost = null;
        inputstream = null;
        inputstreamreader = null;
        bufferedreader = null;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        stringbuffer1.append("http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&");
        stringbuffer1.append("zei=").append(f.a);
        stringbuffer1.append("&zsi=").append(f.b);
        i = 0;
        flag = false;
        stringbuffer2 = stringbuffer;
        s = "";
_L6:
        InputStream inputstream1;
        HttpPost httppost1;
        HttpClient httpclient1;
        String s1;
        BufferedReader bufferedreader2;
        HttpPost httppost2;
        HttpClient httpclient2;
        InputStream inputstream2;
        InputStreamReader inputstreamreader1;
        BufferedReader bufferedreader4;
        if (i >= 1 || flag)
        {
            stringbuffer1.delete(0, stringbuffer1.length());
            BufferedReader bufferedreader3;
            HttpClient httpclient3;
            ByteArrayEntity bytearrayentity;
            HttpResponse httpresponse;
            UnknownHostException unknownhostexception2;
            String s2;
            if (s.equals(""))
            {
                return null;
            } else
            {
                return s;
            }
        }
        httpclient3 = a(context, networkinfo);
        httpclient2 = httpclient3;
        httppost2 = new HttpPost(stringbuffer1.toString());
        stringbuffer2.delete(0, stringbuffer2.length());
        stringbuffer2.append("application/soap+xml;charset=");
        stringbuffer2.append("UTF-8");
        stringbuffer2.delete(0, stringbuffer2.length());
        httppost2.addHeader("gzipped", "1");
        bytearrayentity = new ByteArrayEntity(t.a(abyte0));
        bytearrayentity.setContentType("application/octet-stream");
        httppost2.setEntity(bytearrayentity);
        httpresponse = httpclient2.execute(httppost2);
        if (httpresponse.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_1467;
        }
        inputstream2 = httpresponse.getEntity().getContent();
        inputstreamreader1 = new InputStreamReader(inputstream2, "UTF-8");
        bufferedreader4 = new BufferedReader(inputstreamreader1, 2048);
_L3:
        s2 = bufferedreader4.readLine();
        if (s2 == null) goto _L2; else goto _L1
_L1:
        stringbuffer2.append(s2);
          goto _L3
        unknownhostexception2;
        inputstream1 = inputstream2;
        s1 = s;
        bufferedreader2 = bufferedreader4;
        httpclient1 = httpclient2;
        inputstreamreader = inputstreamreader1;
        httppost1 = httppost2;
_L16:
        if (httppost1 != null)
        {
            httppost1.abort();
            httppost1 = null;
        }
        if (httpclient1 != null)
        {
            httpclient1.getConnectionManager().shutdown();
            httpclient1 = null;
        }
        if (inputstream1 != null)
        {
            inputstream1.close();
            inputstream1 = null;
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
            inputstreamreader = null;
        }
        if (bufferedreader2 == null) goto _L5; else goto _L4
_L4:
        bufferedreader2.close();
_L8:
        bufferedreader2 = null;
_L5:
        i++;
        bufferedreader3 = bufferedreader2;
        s = s1;
        httpclient = httpclient1;
        httppost = httppost1;
        inputstream = inputstream1;
        bufferedreader = bufferedreader3;
          goto _L6
_L2:
        s = stringbuffer2.toString();
        stringbuffer2.delete(0, stringbuffer2.length());
        stringbuffer2 = null;
        flag = true;
        inputstream1 = inputstream2;
        s1 = s;
        bufferedreader2 = bufferedreader4;
        inputstreamreader = inputstreamreader1;
_L17:
        UnknownHostException unknownhostexception;
        BufferedReader bufferedreader1;
        SocketException socketexception;
        SocketTimeoutException sockettimeoutexception;
        ConnectTimeoutException connecttimeoutexception;
        Exception exception;
        UnknownHostException unknownhostexception1;
        SocketException socketexception1;
        SocketTimeoutException sockettimeoutexception1;
        ConnectTimeoutException connecttimeoutexception1;
        ConnectTimeoutException connecttimeoutexception2;
        SocketTimeoutException sockettimeoutexception2;
        SocketException socketexception2;
        UnknownHostException unknownhostexception3;
        SocketException socketexception3;
        SocketTimeoutException sockettimeoutexception3;
        ConnectTimeoutException connecttimeoutexception3;
        UnknownHostException unknownhostexception4;
        SocketException socketexception4;
        SocketTimeoutException sockettimeoutexception4;
        ConnectTimeoutException connecttimeoutexception4;
        UnknownHostException unknownhostexception5;
        SocketException socketexception5;
        SocketTimeoutException sockettimeoutexception5;
        ConnectTimeoutException connecttimeoutexception5;
        if (httppost2 != null)
        {
            httppost2.abort();
            httppost1 = null;
        } else
        {
            httppost1 = httppost2;
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
            httpclient1 = null;
        } else
        {
            httpclient1 = httpclient2;
        }
        if (inputstream1 != null)
        {
            inputstream1.close();
            inputstream1 = null;
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
            inputstreamreader = null;
        }
        if (bufferedreader2 == null) goto _L5; else goto _L7
_L7:
        bufferedreader2.close();
          goto _L8
        exception;
        bufferedreader = bufferedreader4;
        inputstreamreader = inputstreamreader1;
        inputstream = inputstream2;
_L12:
        if (httppost2 != null)
        {
            httppost2.abort();
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
        }
        if (bufferedreader != null)
        {
            bufferedreader.close();
        }
        throw exception;
        socketexception2;
        inputstream1 = inputstream2;
        s1 = s;
        bufferedreader2 = bufferedreader4;
        inputstreamreader = inputstreamreader1;
_L15:
        if (httppost2 != null)
        {
            httppost2.abort();
            httppost1 = null;
        } else
        {
            httppost1 = httppost2;
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
            httpclient1 = null;
        } else
        {
            httpclient1 = httpclient2;
        }
        if (inputstream1 != null)
        {
            inputstream1.close();
            inputstream1 = null;
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
            inputstreamreader = null;
        }
        if (bufferedreader2 == null) goto _L5; else goto _L9
_L9:
        bufferedreader2.close();
          goto _L8
        sockettimeoutexception2;
        inputstream1 = inputstream2;
        s1 = s;
        bufferedreader2 = bufferedreader4;
        inputstreamreader = inputstreamreader1;
_L14:
        if (httppost2 != null)
        {
            httppost2.abort();
            httppost1 = null;
        } else
        {
            httppost1 = httppost2;
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
            httpclient1 = null;
        } else
        {
            httpclient1 = httpclient2;
        }
        if (inputstream1 != null)
        {
            inputstream1.close();
            inputstream1 = null;
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
            inputstreamreader = null;
        }
        if (bufferedreader2 == null) goto _L5; else goto _L10
_L10:
        bufferedreader2.close();
          goto _L8
        connecttimeoutexception2;
        inputstream1 = inputstream2;
        s1 = s;
        bufferedreader2 = bufferedreader4;
        inputstreamreader = inputstreamreader1;
_L13:
        if (httppost2 != null)
        {
            httppost2.abort();
            httppost1 = null;
        } else
        {
            httppost1 = httppost2;
        }
        if (httpclient2 != null)
        {
            httpclient2.getConnectionManager().shutdown();
            httpclient1 = null;
        } else
        {
            httpclient1 = httpclient2;
        }
        if (inputstream1 != null)
        {
            inputstream1.close();
            inputstream1 = null;
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
            inputstreamreader = null;
        }
        if (bufferedreader2 == null) goto _L5; else goto _L11
_L11:
        bufferedreader2.close();
          goto _L8
        exception;
        httppost2 = httppost;
        httpclient2 = httpclient;
          goto _L12
        exception;
        httppost2 = httppost;
          goto _L12
        exception;
          goto _L12
        exception;
        inputstream = inputstream2;
          goto _L12
        exception;
        inputstreamreader = inputstreamreader1;
        inputstream = inputstream2;
          goto _L12
        connecttimeoutexception;
        httppost2 = httppost;
        httpclient2 = httpclient;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L13
        connecttimeoutexception5;
        httppost2 = httppost;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L13
        connecttimeoutexception1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L13
        connecttimeoutexception4;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L13
        connecttimeoutexception3;
        inputstreamreader = inputstreamreader1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L13
        sockettimeoutexception;
        httppost2 = httppost;
        httpclient2 = httpclient;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L14
        sockettimeoutexception5;
        httppost2 = httppost;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L14
        sockettimeoutexception1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L14
        sockettimeoutexception4;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L14
        sockettimeoutexception3;
        inputstreamreader = inputstreamreader1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L14
        socketexception;
        httppost2 = httppost;
        httpclient2 = httpclient;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L15
        socketexception5;
        httppost2 = httppost;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L15
        socketexception1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L15
        socketexception4;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L15
        socketexception3;
        inputstreamreader = inputstreamreader1;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
          goto _L15
        unknownhostexception;
        bufferedreader1 = bufferedreader;
        inputstream1 = inputstream;
        httppost1 = httppost;
        httpclient1 = httpclient;
        s1 = s;
        bufferedreader2 = bufferedreader1;
          goto _L16
        unknownhostexception5;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
        httppost1 = httppost;
        httpclient1 = httpclient2;
          goto _L16
        unknownhostexception1;
        httpclient1 = httpclient2;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
        httppost1 = httppost2;
          goto _L16
        unknownhostexception4;
        httppost1 = httppost2;
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
        httpclient1 = httpclient2;
          goto _L16
        unknownhostexception3;
        inputstreamreader = inputstreamreader1;
        s1 = s;
        httppost1 = httppost2;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream2;
        httpclient1 = httpclient2;
          goto _L16
        s1 = s;
        bufferedreader2 = bufferedreader;
        inputstream1 = inputstream;
          goto _L17
    }

    public String a(byte abyte0[], Context context, JSONObject jsonobject)
    {
        NetworkInfo networkinfo;
        HttpPost httppost;
        GZIPInputStream gzipinputstream;
        BufferedReader bufferedreader;
        StringBuffer stringbuffer;
        boolean flag;
        int i;
        String s;
        InputStreamReader inputstreamreader;
        InputStream inputstream;
        HttpClient httpclient;
        networkinfo = t.b(context);
        if (a(networkinfo) == -1)
        {
            throw new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
        }
        httppost = null;
        gzipinputstream = null;
        bufferedreader = null;
        stringbuffer = new StringBuffer();
        flag = false;
        i = 0;
        s = "";
        inputstreamreader = null;
        inputstream = null;
        httpclient = null;
_L9:
        if (i >= 1 || flag)
        {
            if (TextUtils.isEmpty(s))
            {
                s = null;
            }
            return s;
        }
        HttpClient httpclient2 = a(context, networkinfo);
        HttpClient httpclient1 = httpclient2;
        HttpPost httppost2;
        String as[];
        as = a(jsonobject);
        httppost2 = new HttpPost("http://apilocate.amap.com/mobile/binary");
        String s1 = "UTF-8";
        HttpResponse httpresponse;
        int j;
        ByteArrayEntity bytearrayentity = new ByteArrayEntity(t.a(abyte0));
        bytearrayentity.setContentType("application/octet-stream");
        httppost2.addHeader("Accept-Encoding", "gzip");
        httppost2.addHeader("gzipped", "1");
        httppost2.addHeader("X-INFO", as[2]);
        httppost2.addHeader("X-BIZ", as[3]);
        httppost2.addHeader("KEY", as[1]);
        httppost2.addHeader("ec", "1");
        if (as[4] != null && as[4].length() > 0)
        {
            httppost2.addHeader("User-Agent", as[4]);
        }
        stringbuffer.delete(0, stringbuffer.length());
        httppost2.setEntity(bytearrayentity);
        httpresponse = httpclient1.execute(httppost2);
        j = httpresponse.getStatusLine().getStatusCode();
        if (j != 200) goto _L2; else goto _L1
_L1:
        String s2;
        inputstream = httpresponse.getEntity().getContent();
        s2 = httpresponse.getEntity().getContentType().getValue();
        String s3 = "";
        int k = s2.indexOf("charset=");
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        s3 = s2.substring(k + 8);
        UnknownHostException unknownhostexception;
        BufferedReader bufferedreader1;
        InputStreamReader inputstreamreader1;
        GZIPInputStream gzipinputstream1;
        InputStream inputstream1;
        HttpPost httppost1;
        Exception exception;
        Exception exception1;
        SocketException socketexception;
        SocketTimeoutException sockettimeoutexception;
        ConnectTimeoutException connecttimeoutexception;
        Throwable throwable2;
        UnknownHostException unknownhostexception1;
        SocketException socketexception1;
        SocketTimeoutException sockettimeoutexception1;
        ConnectTimeoutException connecttimeoutexception1;
        Throwable throwable3;
        SocketException socketexception2;
        SocketTimeoutException sockettimeoutexception2;
        ConnectTimeoutException connecttimeoutexception2;
        Throwable throwable4;
        Exception exception2;
        UnknownHostException unknownhostexception3;
        String s4;
        boolean flag1;
        GZIPInputStream gzipinputstream2;
        StringBuffer stringbuffer1;
        InputStream inputstream2;
        InputStreamReader inputstreamreader2;
        String s6;
        if (!TextUtils.isEmpty(s3))
        {
            s1 = s3;
        }
        if (a(httpresponse))
        {
            gzipinputstream = new GZIPInputStream(inputstream);
        }
        if (gzipinputstream == null) goto _L4; else goto _L3
_L3:
        inputstreamreader = new InputStreamReader(gzipinputstream, s1);
_L8:
        bufferedreader1 = new BufferedReader(inputstreamreader, 2048);
_L7:
        s4 = bufferedreader1.readLine();
        if (s4 == null) goto _L6; else goto _L5
_L5:
        stringbuffer.append(s4);
          goto _L7
        unknownhostexception3;
        inputstreamreader1 = inputstreamreader;
        gzipinputstream1 = gzipinputstream;
        inputstream1 = inputstream;
        httppost1 = httppost2;
        httpclient = httpclient1;
_L12:
        throw new AMapLocException("\u672A\u77E5\u4E3B\u673A - UnKnowHostException");
        exception;
        httpclient1 = httpclient;
        httppost2 = httppost1;
        inputstream = inputstream1;
        gzipinputstream = gzipinputstream1;
        inputstreamreader = inputstreamreader1;
        bufferedreader = bufferedreader1;
        exception1 = exception;
_L13:
        if (httppost2 != null)
        {
            httppost2.abort();
        }
        if (httpclient1 != null)
        {
            httpclient1.getConnectionManager().shutdown();
        }
        UnknownHostException unknownhostexception2;
        SocketException socketexception3;
        String s5;
        InputStreamReader inputstreamreader3;
        InputStreamReader inputstreamreader4;
        if (gzipinputstream != null)
        {
            try
            {
                gzipinputstream.close();
            }
            catch (Throwable throwable1)
            {
                throwable1.printStackTrace();
            }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        }
        if (inputstreamreader != null)
        {
            inputstreamreader.close();
        }
        if (bufferedreader != null)
        {
            bufferedreader.close();
        }
        throw exception1;
_L4:
        inputstreamreader4 = new InputStreamReader(inputstream, s1);
        inputstreamreader = inputstreamreader4;
          goto _L8
_L6:
        s5 = stringbuffer.toString();
        stringbuffer.delete(0, stringbuffer.length());
        flag1 = true;
        gzipinputstream2 = gzipinputstream;
        stringbuffer1 = null;
        inputstream2 = inputstream;
        inputstreamreader2 = inputstreamreader;
        s6 = s5;
_L18:
        if (httppost2 != null)
        {
            httppost2.abort();
            httppost2 = null;
        }
        if (httpclient1 != null)
        {
            httpclient1.getConnectionManager().shutdown();
            httpclient1 = null;
        }
        if (gzipinputstream2 != null)
        {
            try
            {
                gzipinputstream2.close();
            }
            catch (Throwable throwable7)
            {
                throwable7.printStackTrace();
            }
            gzipinputstream2 = null;
        }
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            catch (Throwable throwable6)
            {
                throwable6.printStackTrace();
            }
            inputstream2 = null;
        }
        if (inputstreamreader2 != null)
        {
            inputstreamreader2.close();
            inputstreamreader2 = null;
        }
        if (bufferedreader1 != null)
        {
            bufferedreader1.close();
            bufferedreader1 = null;
        }
        i++;
        stringbuffer = stringbuffer1;
        gzipinputstream = gzipinputstream2;
        httppost = httppost2;
        httpclient = httpclient1;
        inputstreamreader3 = inputstreamreader2;
        inputstream = inputstream2;
        flag = flag1;
        bufferedreader = bufferedreader1;
        s = s6;
        inputstreamreader = inputstreamreader3;
          goto _L9
_L2:
        if (j != 404) goto _L11; else goto _L10
_L10:
        throw new AMapLocException("\u670D\u52A1\u5668\u8FDE\u63A5\u5931\u8D25 - UnknownServiceException");
        unknownhostexception2;
        bufferedreader1 = bufferedreader;
        inputstreamreader1 = inputstreamreader;
        gzipinputstream1 = gzipinputstream;
        inputstream1 = inputstream;
        httppost1 = httppost2;
        httpclient = httpclient1;
          goto _L12
        socketexception3;
        bufferedreader = bufferedreader1;
_L17:
        throw new AMapLocException("socket \u8FDE\u63A5\u5F02\u5E38 - SocketException");
_L16:
        throw new AMapLocException("socket \u8FDE\u63A5\u8D85\u65F6 - SocketTimeoutException");
_L15:
        throw new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
_L14:
        throw new AMapLocException("http\u8FDE\u63A5\u5931\u8D25 - ConnectionException");
        exception2;
        bufferedreader = bufferedreader1;
        exception1 = exception2;
          goto _L13
        exception1;
        httpclient1 = httpclient;
        httppost2 = httppost;
          goto _L13
        exception1;
        httppost2 = httppost;
          goto _L13
        throwable2;
        httpclient1 = httpclient;
        httppost2 = httppost;
          goto _L14
        throwable3;
        httppost2 = httppost;
          goto _L14
        throwable4;
          goto _L14
        connecttimeoutexception;
        httpclient1 = httpclient;
        httppost2 = httppost;
          goto _L15
        connecttimeoutexception1;
        httppost2 = httppost;
          goto _L15
        connecttimeoutexception2;
          goto _L15
        sockettimeoutexception;
        httpclient1 = httpclient;
        httppost2 = httppost;
          goto _L16
        sockettimeoutexception1;
        httppost2 = httppost;
          goto _L16
        sockettimeoutexception2;
          goto _L16
        socketexception;
        httpclient1 = httpclient;
        httppost2 = httppost;
          goto _L17
        socketexception1;
        httppost2 = httppost;
          goto _L17
        socketexception2;
          goto _L17
        unknownhostexception;
        bufferedreader1 = bufferedreader;
        inputstreamreader1 = inputstreamreader;
        gzipinputstream1 = gzipinputstream;
        inputstream1 = inputstream;
        httppost1 = httppost;
          goto _L12
        unknownhostexception1;
        bufferedreader1 = bufferedreader;
        httpclient = httpclient1;
        inputstreamreader1 = inputstreamreader;
        gzipinputstream1 = gzipinputstream;
        inputstream1 = inputstream;
        httppost1 = httppost;
          goto _L12
_L11:
        gzipinputstream2 = gzipinputstream;
        stringbuffer1 = stringbuffer;
        String s7 = s;
        bufferedreader1 = bufferedreader;
        flag1 = flag;
        inputstream2 = inputstream;
        inputstreamreader2 = inputstreamreader;
        s6 = s7;
          goto _L18
        exception1;
          goto _L13
        SocketTimeoutException sockettimeoutexception3;
        sockettimeoutexception3;
        bufferedreader = bufferedreader1;
          goto _L16
        ConnectTimeoutException connecttimeoutexception3;
        connecttimeoutexception3;
        bufferedreader = bufferedreader1;
          goto _L15
        Throwable throwable5;
        throwable5;
        bufferedreader = bufferedreader1;
          goto _L14
    }

}
