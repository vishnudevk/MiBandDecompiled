// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.b;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.utils:
//            OpenConfig, ServerSetting, Util, c

public class HttpUtils
{

    private HttpUtils()
    {
    }

    private static int a(Context context)
    {
        int i = -1;
        if (android.os.Build.VERSION.SDK_INT >= 11) goto _L2; else goto _L1
_L1:
        if (context == null) goto _L4; else goto _L3
_L3:
        i = Proxy.getPort(context);
        if (i < 0)
        {
            i = Proxy.getDefaultPort();
        }
_L6:
        return i;
_L4:
        return Proxy.getDefaultPort();
_L2:
        String s = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(s))
        {
            int j;
            try
            {
                j = Integer.parseInt(s);
            }
            catch (NumberFormatException numberformatexception)
            {
                return i;
            }
            return j;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static int a(IOException ioexception)
    {
        if (ioexception instanceof CharConversionException)
        {
            return -20;
        }
        if (ioexception instanceof MalformedInputException)
        {
            return -21;
        }
        if (ioexception instanceof UnmappableCharacterException)
        {
            return -22;
        }
        if (ioexception instanceof HttpResponseException)
        {
            return -23;
        }
        if (ioexception instanceof ClosedChannelException)
        {
            return -24;
        }
        if (ioexception instanceof ConnectionClosedException)
        {
            return -25;
        }
        if (ioexception instanceof EOFException)
        {
            return -26;
        }
        if (ioexception instanceof FileLockInterruptionException)
        {
            return -27;
        }
        if (ioexception instanceof FileNotFoundException)
        {
            return -28;
        }
        if (ioexception instanceof HttpRetryException)
        {
            return -29;
        }
        if (ioexception instanceof ConnectTimeoutException)
        {
            return -7;
        }
        if (ioexception instanceof SocketTimeoutException)
        {
            return -8;
        }
        if (ioexception instanceof InvalidPropertiesFormatException)
        {
            return -30;
        }
        if (ioexception instanceof MalformedChunkCodingException)
        {
            return -31;
        }
        if (ioexception instanceof MalformedURLException)
        {
            return -3;
        }
        if (ioexception instanceof NoHttpResponseException)
        {
            return -32;
        }
        if (ioexception instanceof InvalidClassException)
        {
            return -33;
        }
        if (ioexception instanceof InvalidObjectException)
        {
            return -34;
        }
        if (ioexception instanceof NotActiveException)
        {
            return -35;
        }
        if (ioexception instanceof NotSerializableException)
        {
            return -36;
        }
        if (ioexception instanceof OptionalDataException)
        {
            return -37;
        }
        if (ioexception instanceof StreamCorruptedException)
        {
            return -38;
        }
        if (ioexception instanceof WriteAbortedException)
        {
            return -39;
        }
        if (ioexception instanceof ProtocolException)
        {
            return -40;
        }
        if (ioexception instanceof SSLHandshakeException)
        {
            return -41;
        }
        if (ioexception instanceof SSLKeyException)
        {
            return -42;
        }
        if (ioexception instanceof SSLPeerUnverifiedException)
        {
            return -43;
        }
        if (ioexception instanceof SSLProtocolException)
        {
            return -44;
        }
        if (ioexception instanceof BindException)
        {
            return -45;
        }
        if (ioexception instanceof ConnectException)
        {
            return -46;
        }
        if (ioexception instanceof NoRouteToHostException)
        {
            return -47;
        }
        if (ioexception instanceof PortUnreachableException)
        {
            return -48;
        }
        if (ioexception instanceof SyncFailedException)
        {
            return -49;
        }
        if (ioexception instanceof UTFDataFormatException)
        {
            return -50;
        }
        if (ioexception instanceof UnknownHostException)
        {
            return -51;
        }
        if (ioexception instanceof UnknownServiceException)
        {
            return -52;
        }
        if (ioexception instanceof UnsupportedEncodingException)
        {
            return -53;
        }
        return !(ioexception instanceof ZipException) ? -2 : -54;
    }

    private static String a(HttpResponse httpresponse)
    {
        InputStream inputstream = httpresponse.getEntity().getContent();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Header header = httpresponse.getFirstHeader("Content-Encoding");
        Object obj;
        byte abyte0[];
        if (header != null && header.getValue().toLowerCase().indexOf("gzip") > -1)
        {
            obj = new GZIPInputStream(inputstream);
        } else
        {
            obj = inputstream;
        }
        abyte0 = new byte[512];
        do
        {
            int i = ((InputStream) (obj)).read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return new String(bytearrayoutputstream.toByteArray());
            }
        } while (true);
    }

    private static void a(Context context, QQToken qqtoken, String s)
    {
        if (s.indexOf("add_share") > -1 || s.indexOf("upload_pic") > -1 || s.indexOf("add_topic") > -1 || s.indexOf("set_user_face") > -1 || s.indexOf("add_t") > -1 || s.indexOf("add_pic_t") > -1 || s.indexOf("add_pic_url") > -1 || s.indexOf("add_video") > -1)
        {
            com.tencent.connect.a.a.a(context, qqtoken, "requireApi", new String[] {
                s
            });
        }
    }

    private static String b(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            if (context != null)
            {
                String s = Proxy.getHost(context);
                if (TextUtils.isEmpty(s))
                {
                    s = Proxy.getDefaultHost();
                }
                return s;
            } else
            {
                return Proxy.getDefaultHost();
            }
        } else
        {
            return System.getProperty("http.proxyHost");
        }
    }

    public static String encodePostBody(Bundle bundle, String s)
    {
        if (bundle == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i = bundle.size();
        Iterator iterator = bundle.keySet().iterator();
        int j = -1;
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            int k = j + 1;
            Object obj = bundle.get(s1);
            if (!(obj instanceof String))
            {
                j = k;
            } else
            {
                stringbuilder.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s1).append("\"").append("\r\n").append("\r\n").append((String)obj).toString());
                if (k < i - 1)
                {
                    stringbuilder.append((new StringBuilder()).append("\r\n--").append(s).append("\r\n").toString());
                }
                j = k;
            }
        }
        return stringbuilder.toString();
    }

    public static String encodeUrl(Bundle bundle)
    {
        if (bundle == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        boolean flag = true;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if ((obj instanceof String) || (obj instanceof String[]))
            {
                boolean flag1;
                if (obj instanceof String[])
                {
                    String as[];
                    int i;
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(s)).append("=").toString());
                    as = (String[])bundle.getStringArray(s);
                    i = 0;
                    while (i < as.length) 
                    {
                        if (i == 0)
                        {
                            stringbuilder.append(URLEncoder.encode(as[i]));
                        } else
                        {
                            stringbuilder.append(URLEncoder.encode((new StringBuilder()).append(",").append(as[i]).toString()));
                        }
                        i++;
                    }
                    flag1 = flag;
                } else
                {
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(s)).append("=").append(URLEncoder.encode(bundle.getString(s))).toString());
                    flag1 = flag;
                }
                flag = flag1;
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static HttpClient getHttpClient(Context context, String s, String s1)
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        BasicHttpParams basichttpparams;
        int i;
        int j;
        DefaultHttpClient defaulthttpclient;
        NetworkProxy networkproxy;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            try
            {
                KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
                keystore.load(null, null);
                CustomSSLSocketFactory customsslsocketfactory = new CustomSSLSocketFactory(keystore);
                customsslsocketfactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeregistry.register(new Scheme("https", customsslsocketfactory, 443));
            }
            catch (Exception exception)
            {
                schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else
        {
            schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        basichttpparams = new BasicHttpParams();
        i = OpenConfig.getInstance(context, s).getInt("Common_HttpConnectionTimeout");
        if (i == 0)
        {
            i = 15000;
        }
        HttpConnectionParams.setConnectionTimeout(basichttpparams, i);
        j = OpenConfig.getInstance(context, s).getInt("Common_SocketConnectionTimeout");
        if (j == 0)
        {
            j = 30000;
        }
        HttpConnectionParams.setSoTimeout(basichttpparams, j);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpProtocolParams.setUserAgent(basichttpparams, (new StringBuilder()).append("AndroidSDK_").append(android.os.Build.VERSION.SDK).append("_").append(Build.DEVICE).append("_").append(android.os.Build.VERSION.RELEASE).toString());
        defaulthttpclient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        networkproxy = getProxy(context);
        if (networkproxy != null)
        {
            HttpHost httphost = new HttpHost(networkproxy.host, networkproxy.port);
            defaulthttpclient.getParams().setParameter("http.route.default-proxy", httphost);
        }
        return defaulthttpclient;
    }

    public static NetworkProxy getProxy(Context context)
    {
        if (context == null)
        {
            return null;
        }
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return null;
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return null;
        }
        if (networkinfo.getType() == 0)
        {
            String s = b(context);
            int i = a(context);
            if (!TextUtils.isEmpty(s) && i >= 0)
            {
                return new NetworkProxy(s, i, null);
            }
        }
        return null;
    }

    public static Util.Statistic openUrl2(Context context, String s, String s1, Bundle bundle)
    {
        if (context != null)
        {
            ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
            if (connectivitymanager != null)
            {
                NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
                if (networkinfo == null || !networkinfo.isAvailable())
                {
                    throw new NetworkUnavailableException("network unavailable");
                }
            }
        }
        Bundle bundle1;
        String s2;
        HttpClient httpclient;
        int i;
        Object obj;
        int j;
        if (bundle != null)
        {
            bundle1 = new Bundle(bundle);
        } else
        {
            bundle1 = new Bundle();
        }
        s2 = bundle1.getString("appid_for_getting_config");
        bundle1.remove("appid_for_getting_config");
        httpclient = getHttpClient(context, s2, s);
        if (s1.equals("GET"))
        {
            String s5 = encodeUrl(bundle1);
            int i1 = 0 + s5.length();
            HttpResponse httpresponse;
            String s6;
            HttpGet httpget;
            if (s.indexOf("?") == -1)
            {
                s6 = (new StringBuilder()).append(s).append("?").toString();
            } else
            {
                s6 = (new StringBuilder()).append(s).append("&").toString();
            }
            httpget = new HttpGet((new StringBuilder()).append(s6).append(s5).toString());
            httpget.addHeader("Accept-Encoding", "gzip");
            obj = httpget;
            i = i1;
        } else
        if (s1.equals("POST"))
        {
            HttpPost httppost = new HttpPost(s);
            httppost.addHeader("Accept-Encoding", "gzip");
            Bundle bundle2 = new Bundle();
            Iterator iterator = bundle1.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s4 = (String)iterator.next();
                Object obj1 = bundle1.get(s4);
                if (obj1 instanceof byte[])
                {
                    bundle2.putByteArray(s4, (byte[])(byte[])obj1);
                }
            } while (true);
            if (!bundle1.containsKey("method"))
            {
                bundle1.putString("method", s1);
            }
            httppost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httppost.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bytearrayoutputstream.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
            bytearrayoutputstream.write(encodePostBody(bundle1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            if (!bundle2.isEmpty())
            {
                int k = bundle2.size();
                bytearrayoutputstream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
                Iterator iterator1 = bundle2.keySet().iterator();
                int l = -1;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    String s3 = (String)iterator1.next();
                    l++;
                    bytearrayoutputstream.write((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s3).append("\"; filename=\"").append(s3).append("\"").append("\r\n").toString().getBytes());
                    bytearrayoutputstream.write("Content-Type: content/unknown\r\n\r\n".getBytes());
                    byte abyte1[] = bundle2.getByteArray(s3);
                    if (abyte1 != null)
                    {
                        bytearrayoutputstream.write(abyte1);
                    }
                    if (l < k - 1)
                    {
                        bytearrayoutputstream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
                    }
                } while (true);
            }
            bytearrayoutputstream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n".getBytes());
            byte abyte0[] = bytearrayoutputstream.toByteArray();
            i = 0 + abyte0.length;
            bytearrayoutputstream.close();
            httppost.setEntity(new ByteArrayEntity(abyte0));
            obj = httppost;
        } else
        {
            i = 0;
            obj = null;
        }
        httpresponse = httpclient.execute(((HttpUriRequest) (obj)));
        j = httpresponse.getStatusLine().getStatusCode();
        if (j == 200)
        {
            return new Util.Statistic(a(httpresponse), i);
        } else
        {
            throw new HttpStatusException((new StringBuilder()).append("http status code error:").append(j).toString());
        }
    }

    public static JSONObject request(QQToken qqtoken, Context context, String s, Bundle bundle, String s1)
    {
        c.a("openSDK_LOG", "OpenApi request");
        String s2;
        String s3;
        Object obj;
        long l;
        int i;
        long l1;
        int j;
        int k;
        ConnectTimeoutException connecttimeoutexception;
        ConnectTimeoutException connecttimeoutexception1;
        JSONObject jsonobject;
        int i1;
        long l2;
        Object obj1;
        long l3;
        long l4;
        JSONObject jsonobject1;
        long l5;
        SocketTimeoutException sockettimeoutexception;
        SocketTimeoutException sockettimeoutexception1;
        JSONObject jsonobject2;
        JSONException jsonexception;
        IOException ioexception;
        int j1;
        MalformedURLException malformedurlexception;
        NetworkUnavailableException networkunavailableexception;
        HttpStatusException httpstatusexception;
        String s4;
        Exception exception;
        int k1;
        int i2;
        Util.Statistic statistic;
        JSONObject jsonobject3;
        SocketTimeoutException sockettimeoutexception2;
        ConnectTimeoutException connecttimeoutexception2;
        JSONException jsonexception1;
        int j2;
        if (!s.toLowerCase().startsWith("http"))
        {
            s3 = (new StringBuilder()).append(ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/")).append(s).toString();
            s2 = (new StringBuilder()).append(ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/")).append(s).toString();
        } else
        {
            s2 = s;
            s3 = s;
        }
        a(context, qqtoken, s);
        obj = null;
        l = SystemClock.elapsedRealtime();
        i = OpenConfig.getInstance(context, qqtoken.getAppId()).getInt("Common_HttpRetryCount");
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            config_value:").append(i).append("   appid:").append(qqtoken.getAppId()).append("     url:").append(s2).toString());
        if (i == 0)
        {
            i = 3;
        }
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            result_value:").append(i).append("   appid:").append(qqtoken.getAppId()).append("     url:").append(s2).toString());
        l1 = l;
        j = 0;
        k = j + 1;
        statistic = openUrl2(context, s3, s1, bundle);
        jsonobject3 = Util.parseJson(statistic.response);
        jsonobject1 = jsonobject3;
        j2 = jsonobject1.getInt("ret");
        i1 = j2;
_L10:
        l5 = statistic.reqSize;
        l2 = statistic.rspSize;
_L3:
        com.tencent.open.a.b.a().a(context, s2, l1, l5, l2, i1, qqtoken.getAppId());
        return jsonobject1;
        jsonexception1;
        i1 = -4;
        continue; /* Loop/switch isn't completed */
        connecttimeoutexception2;
        jsonobject = jsonobject1;
        connecttimeoutexception1 = connecttimeoutexception2;
_L8:
        connecttimeoutexception1.printStackTrace();
        i1 = -7;
        l2 = 0L;
        if (k >= i) goto _L2; else goto _L1
_L1:
        l1 = SystemClock.elapsedRealtime();
        obj1 = jsonobject;
        l3 = 0L;
_L4:
        if (k < i)
        {
            break MISSING_BLOCK_LABEL_673;
        }
        l4 = l3;
        jsonobject1 = obj1;
        l5 = l4;
          goto _L3
_L2:
        com.tencent.open.a.b.a().a(context, s2, l1, 0L, l2, i1, qqtoken.getAppId());
        throw connecttimeoutexception1;
        sockettimeoutexception2;
        jsonobject2 = jsonobject1;
        sockettimeoutexception1 = sockettimeoutexception2;
_L7:
        sockettimeoutexception1.printStackTrace();
        i1 = -8;
        l2 = 0L;
        if (k < i)
        {
            l1 = SystemClock.elapsedRealtime();
            obj1 = jsonobject2;
            l3 = 0L;
        } else
        {
            com.tencent.open.a.b.a().a(context, s2, l1, 0L, l2, i1, qqtoken.getAppId());
            throw sockettimeoutexception1;
        }
          goto _L4
        httpstatusexception;
        httpstatusexception.printStackTrace();
        s4 = httpstatusexception.getMessage();
        i2 = Integer.parseInt(s4.replace("http status code error:", ""));
        k1 = i2;
_L6:
        com.tencent.open.a.b.a().a(context, s2, l1, 0L, 0L, k1, qqtoken.getAppId());
        throw httpstatusexception;
        exception;
        exception.printStackTrace();
        k1 = -9;
        if (true) goto _L6; else goto _L5
_L5:
        networkunavailableexception;
        networkunavailableexception.printStackTrace();
        throw networkunavailableexception;
        malformedurlexception;
        malformedurlexception.printStackTrace();
        com.tencent.open.a.b.a().a(context, s2, l1, 0L, 0L, -3, qqtoken.getAppId());
        throw malformedurlexception;
        ioexception;
        ioexception.printStackTrace();
        j1 = a(ioexception);
        com.tencent.open.a.b.a().a(context, s2, l1, 0L, 0L, j1, qqtoken.getAppId());
        throw ioexception;
        jsonexception;
        jsonexception.printStackTrace();
        com.tencent.open.a.b.a().a(context, s2, l1, 0L, 0L, -4, qqtoken.getAppId());
        throw jsonexception;
        sockettimeoutexception;
        sockettimeoutexception1 = sockettimeoutexception;
        jsonobject2 = obj;
          goto _L7
        connecttimeoutexception;
        connecttimeoutexception1 = connecttimeoutexception;
        jsonobject = obj;
          goto _L8
        obj = obj1;
        j = k;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void requestAsync(QQToken qqtoken, Context context, String s, Bundle bundle, String s1, IRequestListener irequestlistener)
    {
        c.a("openSDK_LOG", "OpenApi requestAsync");
        (new com.tencent.utils.c(qqtoken, context, s, bundle, s1, irequestlistener)).start();
    }

    public static JSONObject upload(QQToken qqtoken, Context context, String s, Bundle bundle)
    {
        String s1;
        String s2;
        Object obj;
        long l;
        int i;
        long l1;
        int j;
        int k;
        ConnectTimeoutException connecttimeoutexception;
        ConnectTimeoutException connecttimeoutexception1;
        JSONObject jsonobject;
        int i1;
        long l2;
        Object obj1;
        long l3;
        long l4;
        JSONObject jsonobject1;
        long l5;
        SocketTimeoutException sockettimeoutexception;
        SocketTimeoutException sockettimeoutexception1;
        JSONObject jsonobject2;
        JSONException jsonexception;
        IOException ioexception;
        int j1;
        MalformedURLException malformedurlexception;
        NetworkUnavailableException networkunavailableexception;
        HttpStatusException httpstatusexception;
        String s3;
        Exception exception;
        int k1;
        int i2;
        Util.Statistic statistic;
        JSONObject jsonobject3;
        SocketTimeoutException sockettimeoutexception2;
        ConnectTimeoutException connecttimeoutexception2;
        JSONException jsonexception1;
        int j2;
        if (!s.toLowerCase().startsWith("http"))
        {
            s2 = (new StringBuilder()).append(ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/")).append(s).toString();
            s1 = (new StringBuilder()).append(ServerSetting.getInstance().getEnvUrl(context, "https://openmobile.qq.com/")).append(s).toString();
        } else
        {
            s1 = s;
            s2 = s;
        }
        a(context, qqtoken, s);
        obj = null;
        l = SystemClock.elapsedRealtime();
        i = OpenConfig.getInstance(context, qqtoken.getAppId()).getInt("Common_HttpRetryCount");
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            config_value:").append(i).append("   appid:").append(qqtoken.getAppId()).append("     url:").append(s1).toString());
        if (i == 0)
        {
            i = 3;
        }
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            result_value:").append(i).append("   appid:").append(qqtoken.getAppId()).append("     url:").append(s1).toString());
        l1 = l;
        j = 0;
        k = j + 1;
        statistic = Util.upload(context, s2, bundle);
        jsonobject3 = Util.parseJson(statistic.response);
        jsonobject1 = jsonobject3;
        j2 = jsonobject1.getInt("ret");
        i1 = j2;
_L10:
        l5 = statistic.reqSize;
        l2 = statistic.rspSize;
_L3:
        com.tencent.open.a.b.a().a(context, s1, l1, l5, l2, i1, qqtoken.getAppId());
        return jsonobject1;
        jsonexception1;
        i1 = -4;
        continue; /* Loop/switch isn't completed */
        connecttimeoutexception2;
        jsonobject = jsonobject1;
        connecttimeoutexception1 = connecttimeoutexception2;
_L8:
        connecttimeoutexception1.printStackTrace();
        i1 = -7;
        l2 = 0L;
        if (k >= i) goto _L2; else goto _L1
_L1:
        l1 = SystemClock.elapsedRealtime();
        obj1 = jsonobject;
        l3 = 0L;
_L4:
        if (k < i)
        {
            break MISSING_BLOCK_LABEL_662;
        }
        l4 = l3;
        jsonobject1 = obj1;
        l5 = l4;
          goto _L3
_L2:
        com.tencent.open.a.b.a().a(context, s1, l1, 0L, l2, i1, qqtoken.getAppId());
        throw connecttimeoutexception1;
        sockettimeoutexception2;
        jsonobject2 = jsonobject1;
        sockettimeoutexception1 = sockettimeoutexception2;
_L7:
        sockettimeoutexception1.printStackTrace();
        i1 = -8;
        l2 = 0L;
        if (k < i)
        {
            l1 = SystemClock.elapsedRealtime();
            obj1 = jsonobject2;
            l3 = 0L;
        } else
        {
            com.tencent.open.a.b.a().a(context, s1, l1, 0L, l2, i1, qqtoken.getAppId());
            throw sockettimeoutexception1;
        }
          goto _L4
        httpstatusexception;
        httpstatusexception.printStackTrace();
        s3 = httpstatusexception.getMessage();
        i2 = Integer.parseInt(s3.replace("http status code error:", ""));
        k1 = i2;
_L6:
        com.tencent.open.a.b.a().a(context, s1, l1, 0L, 0L, k1, qqtoken.getAppId());
        throw httpstatusexception;
        exception;
        exception.printStackTrace();
        k1 = -9;
        if (true) goto _L6; else goto _L5
_L5:
        networkunavailableexception;
        networkunavailableexception.printStackTrace();
        throw networkunavailableexception;
        malformedurlexception;
        malformedurlexception.printStackTrace();
        com.tencent.open.a.b.a().a(context, s1, l1, 0L, 0L, -3, qqtoken.getAppId());
        throw malformedurlexception;
        ioexception;
        ioexception.printStackTrace();
        j1 = a(ioexception);
        com.tencent.open.a.b.a().a(context, s1, l1, 0L, 0L, j1, qqtoken.getAppId());
        throw ioexception;
        jsonexception;
        jsonexception.printStackTrace();
        com.tencent.open.a.b.a().a(context, s1, l1, 0L, 0L, -4, qqtoken.getAppId());
        throw jsonexception;
        sockettimeoutexception;
        sockettimeoutexception1 = sockettimeoutexception;
        jsonobject2 = obj;
          goto _L7
        connecttimeoutexception;
        connecttimeoutexception1 = connecttimeoutexception;
        jsonobject = obj;
          goto _L8
        obj = obj1;
        j = k;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    private class CustomSSLSocketFactory extends SSLSocketFactory
    {
        private class MyX509TrustManager
            implements X509TrustManager
        {

            X509TrustManager a;

            public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            {
                try
                {
                    a.checkClientTrusted(ax509certificate, s);
                    return;
                }
                catch (CertificateException certificateexception)
                {
                    return;
                }
            }

            public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            {
                try
                {
                    a.checkServerTrusted(ax509certificate, s);
                    return;
                }
                catch (CertificateException certificateexception)
                {
                    return;
                }
            }

            public X509Certificate[] getAcceptedIssuers()
            {
                return a.getAcceptedIssuers();
            }

            MyX509TrustManager()
            {
                KeyStore keystore;
                KeyStore keystore1;
                try
                {
                    keystore1 = KeyStore.getInstance("JKS");
                }
                catch (Exception exception)
                {
                    keystore = null;
                    continue;
                }
                keystore = keystore1;
                do
                {
                    TrustManager[] _tmp = new TrustManager[0];
                    TrustManager atrustmanager[];
                    int i;
                    if (keystore != null)
                    {
                        keystore.load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
                        TrustManagerFactory trustmanagerfactory1 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                        trustmanagerfactory1.init(keystore);
                        atrustmanager = trustmanagerfactory1.getTrustManagers();
                    } else
                    {
                        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustmanagerfactory.init((KeyStore)null);
                        atrustmanager = trustmanagerfactory.getTrustManagers();
                    }
                    i = 0;
                    do
                    {
                        if (i >= atrustmanager.length)
                        {
                            break;
                        }
                        if (atrustmanager[i] instanceof X509TrustManager)
                        {
                            a = (X509TrustManager)atrustmanager[i];
                            return;
                        }
                        i++;
                    } while (true);
                    throw new Exception("Couldn't initialize");
                } while (true);
            }
        }


        private SSLContext a;

        public Socket createSocket()
        {
            return a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String s, int i, boolean flag)
        {
            return a.getSocketFactory().createSocket(socket, s, i, flag);
        }

        public CustomSSLSocketFactory(KeyStore keystore)
        {
            super(keystore);
            a = SSLContext.getInstance("TLS");
            MyX509TrustManager myx509trustmanager;
            try
            {
                myx509trustmanager = new MyX509TrustManager();
            }
            catch (Exception exception)
            {
                myx509trustmanager = null;
            }
            a.init(null, new TrustManager[] {
                myx509trustmanager
            }, null);
        }
    }


    private class NetworkProxy
    {

        public final String host;
        public final int port;

        private NetworkProxy(String s, int i)
        {
            host = s;
            port = i;
        }

        NetworkProxy(String s, int i, com.tencent.utils.c c1)
        {
            this(s, i);
        }
    }


    private class NetworkUnavailableException extends Exception
    {

        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String s)
        {
            super(s);
        }
    }


    private class HttpStatusException extends Exception
    {

        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String s)
        {
            super(s);
        }
    }

}
