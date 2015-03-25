// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xiaomi.account.openauth.utils:
//            a, b, c

public class Network
{

    public static final String CMWAP_GATEWAY = "10.0.0.172";
    public static final String CMWAP_HEADER_HOST_KEY = "X-Online-Host";
    public static final int CMWAP_PORT = 80;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final Pattern ContentTypePattern_Charset = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern ContentTypePattern_MimeType = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern ContentTypePattern_XmlEncoding = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final String NETWORK_TYPE_3GNET = "3gnet";
    public static final String NETWORK_TYPE_3GWAP = "3gwap";
    public static final String NETWORK_TYPE_CHINATELECOM = "#777";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int READ_TIMEOUT = 15000;
    public static final String RESPONSE_BODY = "RESPONSE_BODY";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String USER_AGENT = "User-Agent";
    public static final String UserAgent_PC_Chrome = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
    public static final String UserAgent_PC_Chrome_6_0_464_0 = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
    private static final String a = "com.xiaomi.common.Network";
    private static final int b = 200;
    private static HostnameVerifier c = new a();
    private static TrustManager d = new b();

    public Network()
    {
    }

    public static void beginDownloadFile(String s, OutputStream outputstream, Context context, boolean flag, PostDownloadHandler postdownloadhandler)
    {
        (new c(s, outputstream, postdownloadhandler, flag, context)).execute(new Void[0]);
    }

    public static void beginDownloadFile(String s, OutputStream outputstream, PostDownloadHandler postdownloadhandler)
    {
        (new c(s, outputstream, postdownloadhandler)).execute(new Void[0]);
    }

    public static String doHttpPost(Context context, String s, List list)
    {
        return doHttpPost(context, s, list, null, null, null, null);
    }

    public static String doHttpPost(Context context, String s, List list, Map map, HttpHeaderInfo httpheaderinfo, String s1, String s2)
    {
        HttpURLConnection httpurlconnection;
        TrustManager atrustmanager[];
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("url");
        }
        HttpsURLConnection.setDefaultHostnameVerifier(c);
        httpurlconnection = getHttpUrlConnection(context, new URL(s));
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(15000);
        httpurlconnection.setRequestMethod("POST");
        atrustmanager = new TrustManager[1];
        atrustmanager[0] = d;
        SSLContext sslcontext1 = SSLContext.getInstance("SSL");
        SSLContext sslcontext = sslcontext1;
        sslcontext.init(null, atrustmanager, new SecureRandom());
_L5:
        javax.net.ssl.SSLSocketFactory sslsocketfactory = sslcontext.getSocketFactory();
        ((HttpsURLConnection)httpurlconnection).setSSLSocketFactory(sslsocketfactory);
        if (!TextUtils.isEmpty(s1))
        {
            httpurlconnection.setRequestProperty("User-Agent", s1);
        }
        if (s2 != null)
        {
            httpurlconnection.setRequestProperty("Cookie", s2);
        }
        if (map == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = map.keySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        KeyManagementException keymanagementexception1;
        int i;
        NoSuchAlgorithmException nosuchalgorithmexception1;
        String s3 = fromParamListToString(list);
        KeyManagementException keymanagementexception;
        String s9;
        NoSuchAlgorithmException nosuchalgorithmexception;
        if (s3 == null)
        {
            throw new IllegalArgumentException("nameValuePairs");
        }
        httpurlconnection.setDoOutput(true);
        byte abyte0[] = s3.getBytes();
        httpurlconnection.getOutputStream().write(abyte0, 0, abyte0.length);
        httpurlconnection.getOutputStream().flush();
        httpurlconnection.getOutputStream().close();
        i = httpurlconnection.getResponseCode();
        Log.d("com.xiaomi.common.Network", (new StringBuilder("Http POST Response Code: ")).append(i).toString());
          goto _L4
        nosuchalgorithmexception;
        sslcontext = null;
        nosuchalgorithmexception1 = nosuchalgorithmexception;
_L13:
        nosuchalgorithmexception1.printStackTrace();
          goto _L5
        keymanagementexception;
        sslcontext = null;
        keymanagementexception1 = keymanagementexception;
_L12:
        keymanagementexception1.printStackTrace();
          goto _L5
_L3:
        s9 = (String)iterator.next();
        httpurlconnection.setRequestProperty(s9, (String)map.get(s9));
          goto _L6
_L4:
        if (httpheaderinfo == null) goto _L8; else goto _L7
_L7:
        int j;
        httpheaderinfo.ResponseCode = i;
        if (httpheaderinfo.AllHeaders == null)
        {
            httpheaderinfo.AllHeaders = new HashMap();
        }
        j = 0;
_L10:
        String s7;
        String s8;
        s7 = httpurlconnection.getHeaderFieldKey(j);
        s8 = httpurlconnection.getHeaderField(j);
        if (s7 != null || s8 != null) goto _L9; else goto _L8
_L8:
        BufferedReader bufferedreader;
        String s4;
        StringBuffer stringbuffer;
        String s5;
        bufferedreader = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(httpurlconnection.getInputStream())));
        s4 = bufferedreader.readLine();
        stringbuffer = new StringBuffer();
        s5 = System.getProperty("line.separator");
_L11:
        if (s4 == null)
        {
            String s6 = stringbuffer.toString();
            bufferedreader.close();
            return s6;
        }
        break MISSING_BLOCK_LABEL_497;
_L9:
        httpheaderinfo.AllHeaders.put(s7, s8);
        j = 1 + (j + 1);
          goto _L10
        stringbuffer.append(s4);
        stringbuffer.append(s5);
        s4 = bufferedreader.readLine();
          goto _L11
        keymanagementexception1;
          goto _L12
        nosuchalgorithmexception1;
          goto _L13
    }

    public static JSONObject doHttpPostWithResponseStatus(Context context, String s, List list, Map map, String s1, String s2)
    {
        JSONObject jsonobject;
        DefaultHttpClient defaulthttpclient;
        if (context == null)
        {
            throw new IllegalArgumentException("context");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("url");
        }
        jsonobject = new JSONObject();
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 15000);
        if (!TextUtils.isEmpty(s1))
        {
            HttpProtocolParams.setUserAgent(basichttpparams, s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            basichttpparams.setParameter("Cookie", s2);
        }
        defaulthttpclient = new DefaultHttpClient(basichttpparams);
        if (!isCmwap(context)) goto _L2; else goto _L1
_L1:
        HttpPost httppost;
        URL url = new URL(s);
        String s3 = getCMWapUrl(url);
        String s4 = url.getHost();
        httppost = new HttpPost(s3);
        httppost.addHeader("X-Online-Host", s4);
_L6:
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (list.size() != 0)
        {
            httppost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        }
        HttpResponse httpresponse = defaulthttpclient.execute(httppost);
        String s5 = "";
        int i;
        org.apache.http.HttpEntity httpentity;
        i = httpresponse.getStatusLine().getStatusCode();
        httpentity = httpresponse.getEntity();
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        s5 = EntityUtils.toString(httpentity);
        jsonobject.put("RESPONSE_CODE", i);
        jsonobject.put("RESPONSE_BODY", s5);
        if (!jsonobject.has("RESPONSE_CODE") || !jsonobject.has("RESPONSE_BODY"))
        {
            jsonobject.remove("RESPONSE_CODE");
            jsonobject.remove("RESPONSE_BODY");
        }
_L3:
        return jsonobject;
_L2:
        httppost = new HttpPost(s);
        continue; /* Loop/switch isn't completed */
        ParseException parseexception;
        parseexception;
        Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", parseexception);
        if (!jsonobject.has("RESPONSE_CODE") || !jsonobject.has("RESPONSE_BODY"))
        {
            jsonobject.remove("RESPONSE_CODE");
            jsonobject.remove("RESPONSE_BODY");
            return jsonobject;
        }
          goto _L3
        IOException ioexception;
        ioexception;
        Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", ioexception);
        if (!jsonobject.has("RESPONSE_CODE") || !jsonobject.has("RESPONSE_BODY"))
        {
            jsonobject.remove("RESPONSE_CODE");
            jsonobject.remove("RESPONSE_BODY");
            return jsonobject;
        }
          goto _L3
        JSONException jsonexception;
        jsonexception;
        Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", jsonexception);
        if (jsonobject.has("RESPONSE_CODE") && jsonobject.has("RESPONSE_BODY")) goto _L3; else goto _L4
_L4:
        jsonobject.remove("RESPONSE_CODE");
        jsonobject.remove("RESPONSE_BODY");
        return jsonobject;
        Exception exception;
        exception;
        if (!jsonobject.has("RESPONSE_CODE") || !jsonobject.has("RESPONSE_BODY"))
        {
            jsonobject.remove("RESPONSE_CODE");
            jsonobject.remove("RESPONSE_BODY");
        }
        throw exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static boolean downloadFile(String s, OutputStream outputstream)
    {
        return downloadFile(s, outputstream, false, null);
    }

    public static boolean downloadFile(String s, OutputStream outputstream, Context context)
    {
        URL url = new URL(s);
        if (!isCmwap(context)) goto _L2; else goto _L1
_L1:
        HttpURLConnection httpurlconnection;
        int j;
        HttpURLConnection.setFollowRedirects(false);
        String s1 = getCMWapUrl(url);
        String s2 = url.getHost();
        httpurlconnection = (HttpURLConnection)(new URL(s1)).openConnection();
        httpurlconnection.setRequestProperty("X-Online-Host", s2);
        j = httpurlconnection.getResponseCode();
          goto _L3
_L6:
        InputStream inputstream;
        byte abyte0[];
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(15000);
        httpurlconnection.connect();
        inputstream = httpurlconnection.getInputStream();
        abyte0 = new byte[1024];
_L5:
        int i = inputstream.read(abyte0);
        if (i <= 0)
        {
            String s3;
            URL url1;
            String s4;
            String s5;
            try
            {
                inputstream.close();
                outputstream.close();
            }
            catch (IOException ioexception)
            {
                Log.e("com.xiaomi.common.Network", (new StringBuilder("error while download file")).append(ioexception).toString());
                return false;
            }
            return true;
        }
          goto _L4
_L7:
        s3 = httpurlconnection.getHeaderField("location");
        if (TextUtils.isEmpty(s3))
        {
            break; /* Loop/switch isn't completed */
        }
        url1 = new URL(s3);
        s4 = getCMWapUrl(url1);
        s5 = url1.getHost();
        httpurlconnection = (HttpURLConnection)(new URL(s4)).openConnection();
        httpurlconnection.setRequestProperty("X-Online-Host", s5);
        j = httpurlconnection.getResponseCode();
        continue; /* Loop/switch isn't completed */
_L2:
        httpurlconnection = (HttpURLConnection)url.openConnection();
        HttpURLConnection.setFollowRedirects(true);
        break; /* Loop/switch isn't completed */
_L4:
        outputstream.write(abyte0, 0, i);
          goto _L5
_L3:
        if (j >= 300 && j < 400) goto _L7; else goto _L6
    }

    public static boolean downloadFile(String s, OutputStream outputstream, boolean flag, Context context)
    {
        InputStream inputstream = null;
        InputStream inputstream2;
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(15000);
        HttpURLConnection.setFollowRedirects(true);
        httpurlconnection.connect();
        inputstream2 = httpurlconnection.getInputStream();
        inputstream = inputstream2;
        byte abyte0[] = new byte[1024];
_L4:
        int i = inputstream.read(abyte0);
        if (i != -1) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
_L6:
        Exception exception;
        IOException ioexception2;
        InputStream inputstream1;
        boolean flag1;
        boolean flag3;
        if (flag2)
        {
            flag3 = false;
        } else
        {
            flag3 = true;
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception6) { }
        }
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            catch (IOException ioexception5)
            {
                return flag3;
            }
        }
        return flag3;
_L2:
        outputstream.write(abyte0, 0, i);
        if (!flag || context == null) goto _L4; else goto _L3
_L3:
        flag1 = isWifi(context);
        if (flag1) goto _L4; else goto _L5
_L5:
        flag2 = true;
          goto _L6
        ioexception2;
        inputstream1 = null;
_L10:
        Log.e("com.xiaomi.common.Network", (new StringBuilder("error while download file")).append(ioexception2).toString());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception4) { }
        }
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            catch (IOException ioexception3) { }
        }
        return false;
        exception;
_L8:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1) { }
        }
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception;
        exception;
        inputstream = inputstream1;
        if (true) goto _L8; else goto _L7
_L7:
        ioexception2;
        inputstream1 = inputstream;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static String downloadXml(Context context, URL url)
    {
        return downloadXml(context, url, false, null, "UTF-8", ((String) (null)));
    }

    public static String downloadXml(Context context, URL url, String s, String s1, Map map, HttpHeaderInfo httpheaderinfo)
    {
        InputStream inputstream = null;
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        inputstream = downloadXmlAsStream(context, url, s, s1, map, httpheaderinfo);
        stringbuilder = new StringBuilder(1024);
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"), 1024);
_L1:
        String s2 = bufferedreader.readLine();
        if (s2 == null)
        {
            Exception exception;
            IOException ioexception;
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                catch (IOException ioexception1)
                {
                    Log.e("com.xiaomi.common.Network", (new StringBuilder("Failed to close responseStream")).append(ioexception1.toString()).toString());
                }
            }
            return stringbuilder.toString();
        }
        stringbuilder.append(s2);
        stringbuilder.append("\r\n");
          goto _L1
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                Log.e("com.xiaomi.common.Network", (new StringBuilder("Failed to close responseStream")).append(ioexception.toString()).toString());
            }
        }
        throw exception;
    }

    public static String downloadXml(Context context, URL url, boolean flag, String s, String s1, String s2)
    {
        InputStream inputstream = null;
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        inputstream = downloadXmlAsStream(context, url, s, s2);
        stringbuilder = new StringBuilder(1024);
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream, s1), 1024);
_L1:
        String s3 = bufferedreader.readLine();
        if (s3 == null)
        {
            Exception exception;
            IOException ioexception;
            if (inputstream != null)
            {
                try
                {
                    inputstream.close();
                }
                catch (IOException ioexception1)
                {
                    Log.e("com.xiaomi.common.Network", (new StringBuilder("Failed to close responseStream")).append(ioexception1.toString()).toString());
                }
            }
            return stringbuilder.toString();
        }
        stringbuilder.append(s3);
        stringbuilder.append("\r\n");
          goto _L1
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                Log.e("com.xiaomi.common.Network", (new StringBuilder("Failed to close responseStream")).append(ioexception.toString()).toString());
            }
        }
        throw exception;
    }

    public static InputStream downloadXmlAsStream(Context context, URL url)
    {
        return downloadXmlAsStream(context, url, null, null, null, null);
    }

    public static InputStream downloadXmlAsStream(Context context, URL url, String s, String s1)
    {
        return downloadXmlAsStream(context, url, s, s1, null, null);
    }

    public static InputStream downloadXmlAsStream(Context context, URL url, String s, String s1, Map map, HttpHeaderInfo httpheaderinfo)
    {
        HttpURLConnection httpurlconnection;
        TrustManager atrustmanager[];
        if (context == null)
        {
            throw new IllegalArgumentException("context");
        }
        if (url == null)
        {
            throw new IllegalArgumentException("url");
        }
        HttpsURLConnection.setDefaultHostnameVerifier(c);
        HttpURLConnection.setFollowRedirects(true);
        httpurlconnection = getHttpUrlConnection(context, url);
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(15000);
        atrustmanager = new TrustManager[1];
        atrustmanager[0] = d;
        SSLContext sslcontext1 = SSLContext.getInstance("SSL");
        SSLContext sslcontext = sslcontext1;
        sslcontext.init(null, atrustmanager, new SecureRandom());
_L7:
        javax.net.ssl.SSLSocketFactory sslsocketfactory = sslcontext.getSocketFactory();
        ((HttpsURLConnection)httpurlconnection).setSSLSocketFactory(sslsocketfactory);
        if (!TextUtils.isEmpty(s))
        {
            httpurlconnection.setRequestProperty("User-Agent", s);
        }
        if (s1 != null)
        {
            httpurlconnection.setRequestProperty("Cookie", s1);
        }
        if (map == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = map.keySet().iterator();
_L8:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        if (httpheaderinfo == null || !url.getProtocol().equals("http") && !url.getProtocol().equals("https")) goto _L5; else goto _L4
_L4:
        int i;
        httpheaderinfo.ResponseCode = httpurlconnection.getResponseCode();
        if (httpheaderinfo.AllHeaders == null)
        {
            httpheaderinfo.AllHeaders = new HashMap();
        }
        i = 0;
_L9:
        String s2;
        String s3;
        s2 = httpurlconnection.getHeaderFieldKey(i);
        s3 = httpurlconnection.getHeaderField(i);
        if (s2 != null || s3 != null) goto _L6; else goto _L5
_L5:
        InputStream inputstream1 = httpurlconnection.getInputStream();
        InputStream inputstream = inputstream1;
_L10:
        return new DoneHandlerInputStream(inputstream);
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        NoSuchAlgorithmException nosuchalgorithmexception1;
        sslcontext = null;
        nosuchalgorithmexception1 = nosuchalgorithmexception;
_L12:
        nosuchalgorithmexception1.printStackTrace();
          goto _L7
        KeyManagementException keymanagementexception;
        keymanagementexception;
        KeyManagementException keymanagementexception1;
        sslcontext = null;
        keymanagementexception1 = keymanagementexception;
_L11:
        keymanagementexception1.printStackTrace();
          goto _L7
_L3:
        String s4 = (String)iterator.next();
        httpurlconnection.setRequestProperty(s4, (String)map.get(s4));
          goto _L8
_L6:
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3))
        {
            httpheaderinfo.AllHeaders.put(s2, s3);
        }
        i++;
          goto _L9
        IOException ioexception;
        ioexception;
        inputstream = httpurlconnection.getErrorStream();
          goto _L10
        keymanagementexception1;
          goto _L11
        nosuchalgorithmexception1;
          goto _L12
    }

    public static InputStream downloadXmlAsStreamWithoutRedirect(URL url, String s, String s1)
    {
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(15000);
        if (!TextUtils.isEmpty(s))
        {
            httpurlconnection.setRequestProperty("User-Agent", s);
        }
        if (s1 != null)
        {
            httpurlconnection.setRequestProperty("Cookie", s1);
        }
        int i = httpurlconnection.getResponseCode();
        InputStream inputstream;
        if (i < 300 || i >= 400)
        {
            inputstream = httpurlconnection.getInputStream();
        } else
        {
            inputstream = null;
        }
        return new DoneHandlerInputStream(inputstream);
    }

    public static String fromParamListToString(List list)
    {
        StringBuffer stringbuffer;
        Iterator iterator;
        stringbuffer = new StringBuffer();
        iterator = list.iterator();
_L2:
        if (!iterator.hasNext())
        {
            NameValuePair namevaluepair;
            UnsupportedEncodingException unsupportedencodingexception;
            StringBuffer stringbuffer1;
            if (stringbuffer.length() > 0)
            {
                stringbuffer1 = stringbuffer.deleteCharAt(-1 + stringbuffer.length());
            } else
            {
                stringbuffer1 = stringbuffer;
            }
            return stringbuffer1.toString();
        }
        namevaluepair = (NameValuePair)iterator.next();
        if (namevaluepair.getValue() == null) goto _L2; else goto _L1
_L1:
        stringbuffer.append(URLEncoder.encode(namevaluepair.getName(), "UTF-8"));
        stringbuffer.append("=");
        stringbuffer.append(URLEncoder.encode(namevaluepair.getValue(), "UTF-8"));
        stringbuffer.append("&");
          goto _L2
        unsupportedencodingexception;
        Log.d("com.xiaomi.common.Network", (new StringBuilder("Failed to convert from param list to string: ")).append(unsupportedencodingexception.toString()).toString());
        Log.d("com.xiaomi.common.Network", (new StringBuilder("pair: ")).append(namevaluepair.toString()).toString());
        return null;
    }

    public static String getActiveConnPoint(Context context)
    {
        if (isWIFIConnected(context))
        {
            return "wifi";
        }
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return "";
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return "";
        } else
        {
            return networkinfo.getExtraInfo();
        }
    }

    public static String getActiveNetworkName(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return "null";
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return "null";
        }
        if (TextUtils.isEmpty(networkinfo.getSubtypeName()))
        {
            return networkinfo.getTypeName();
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = networkinfo.getTypeName();
            aobj[1] = networkinfo.getSubtypeName();
            return String.format("%s-%s", aobj);
        }
    }

    public static int getActiveNetworkType(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return -1;
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return -1;
        } else
        {
            return networkinfo.getType();
        }
    }

    public static String getCMWapUrl(URL url)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery()))
        {
            stringbuilder.append("?").append(url.getQuery());
        }
        return stringbuilder.toString();
    }

    public static HttpHeaderInfo getHttpHeaderInfo(String s, String s1, String s2)
    {
        URL url = new URL(s);
        if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https"))
        {
            return null;
        }
        HttpURLConnection httpurlconnection;
        HttpURLConnection.setFollowRedirects(false);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        if (s.indexOf("wap") != -1) goto _L2; else goto _L1
_L1:
        httpurlconnection.setConnectTimeout(5000);
        httpurlconnection.setReadTimeout(5000);
_L4:
        if (!TextUtils.isEmpty(s1))
        {
            httpurlconnection.setRequestProperty("User-Agent", s1);
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        httpurlconnection.setRequestProperty("Cookie", s2);
        HttpHeaderInfo httpheaderinfo;
        httpheaderinfo = new HttpHeaderInfo();
        httpheaderinfo.ResponseCode = httpurlconnection.getResponseCode();
        httpheaderinfo.UserAgent = s1;
        int i = 0;
_L5:
        String s3;
        String s4;
        s3 = httpurlconnection.getHeaderFieldKey(i);
        s4 = httpurlconnection.getHeaderField(i);
          goto _L3
_L2:
        httpurlconnection.setConnectTimeout(15000);
        httpurlconnection.setReadTimeout(15000);
          goto _L4
        malformedurlexception;
        Log.e("com.xiaomi.common.Network", "Failed to transform URL", malformedurlexception);
_L6:
        return null;
_L3:
        MalformedURLException malformedurlexception;
        if (s3 == null && s4 == null)
        {
            return httpheaderinfo;
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if (s3.equals("content-type"))
        {
            httpheaderinfo.ContentType = s4;
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        if (s3.equals("location"))
        {
            URI uri = new URI(s4);
            if (!uri.isAbsolute())
            {
                uri = (new URI(s)).resolve(uri);
            }
            httpheaderinfo.realUrl = uri.toString();
        }
        i++;
          goto _L5
        IOException ioexception;
        ioexception;
        Log.e("com.xiaomi.common.Network", "Failed to get mime type", ioexception);
          goto _L6
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        Log.e("com.xiaomi.common.Network", "Failed to parse URI", urisyntaxexception);
          goto _L6
    }

    public static InputStream getHttpPostAsStream(URL url, String s, Map map, String s1, String s2)
    {
        if (url == null)
        {
            throw new IllegalArgumentException("url");
        }
        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(5000);
        httpurlconnection.setReadTimeout(15000);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setDoOutput(true);
        if (!TextUtils.isEmpty(s1))
        {
            httpurlconnection.setRequestProperty("User-Agent", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            httpurlconnection.setRequestProperty("Cookie", s2);
        }
        httpurlconnection.getOutputStream().write(s.getBytes());
        httpurlconnection.getOutputStream().flush();
        httpurlconnection.getOutputStream().close();
        map.put("ResponseCode", (new StringBuilder(String.valueOf(httpurlconnection.getResponseCode()))).toString());
        int i = 0;
        do
        {
            String s3 = httpurlconnection.getHeaderFieldKey(i);
            String s4 = httpurlconnection.getHeaderField(i);
            if (s3 == null && s4 == null)
            {
                return httpurlconnection.getInputStream();
            }
            map.put(s3, s4);
            i++;
        } while (true);
    }

    public static HttpURLConnection getHttpUrlConnection(Context context, URL url)
    {
        if (isCtwap(context))
        {
            return (HttpURLConnection)url.openConnection(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!isCmwap(context))
        {
            return (HttpURLConnection)url.openConnection();
        } else
        {
            String s = url.getHost();
            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(getCMWapUrl(url))).openConnection();
            httpurlconnection.addRequestProperty("X-Online-Host", s);
            return httpurlconnection;
        }
    }

    public static boolean hasNetwork(Context context)
    {
        return getActiveNetworkType(context) >= 0;
    }

    public static boolean isCmwap(Context context)
    {
        ConnectivityManager connectivitymanager;
        NetworkInfo networkinfo;
        String s;
        if ("CN".equalsIgnoreCase(((TelephonyManager)context.getSystemService("phone")).getSimCountryIso()))
        {
            if ((connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity")) != null && (networkinfo = connectivitymanager.getActiveNetworkInfo()) != null && (!TextUtils.isEmpty(s = networkinfo.getExtraInfo()) && s.length() >= 3 && !s.contains("ctwap")))
            {
                return s.regionMatches(true, -3 + s.length(), "wap", 0, 3);
            }
        }
        return false;
    }

    public static boolean isCtwap(Context context)
    {
        if (!"CN".equalsIgnoreCase(((TelephonyManager)context.getSystemService("phone")).getSimCountryIso()))
        {
            return false;
        }
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return false;
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return false;
        }
        String s = networkinfo.getExtraInfo();
        if (TextUtils.isEmpty(s) || s.length() < 3)
        {
            return false;
        }
        return s.contains("ctwap");
    }

    public static boolean isWIFIConnected(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return false;
        }
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return false;
        }
        return 1 == networkinfo.getType();
    }

    public static boolean isWifi(Context context)
    {
        return getActiveNetworkType(context) == 1;
    }

    public static String tryDetectCharsetEncoding(URL url, String s)
    {
        DoneHandlerInputStream donehandlerinputstream;
        HttpURLConnection httpurlconnection;
        String s1;
        donehandlerinputstream = null;
        if (url == null)
        {
            throw new IllegalArgumentException("url");
        }
        HttpURLConnection.setFollowRedirects(true);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(5000);
        httpurlconnection.setReadTimeout(15000);
        if (!TextUtils.isEmpty(s))
        {
            httpurlconnection.setRequestProperty("User-Agent", s);
        }
        s1 = httpurlconnection.getContentType();
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        Matcher matcher = ContentTypePattern_Charset.matcher(s1);
        if (!matcher.matches() || matcher.groupCount() < 3) goto _L4; else goto _L3
_L3:
        String s2 = matcher.group(2);
        if (TextUtils.isEmpty(s2)) goto _L4; else goto _L5
_L5:
        Log.v("com.xiaomi.common.Network", (new StringBuilder("HTTP charset detected is: ")).append(s2).toString());
_L18:
        if (!TextUtils.isEmpty(s2)) goto _L7; else goto _L6
_L6:
        Matcher matcher1 = ContentTypePattern_MimeType.matcher(s1);
        if (!matcher1.matches() || matcher1.groupCount() < 2) goto _L7; else goto _L8
_L8:
        String s3 = matcher1.group(1);
        if (TextUtils.isEmpty(s3)) goto _L7; else goto _L9
_L9:
        String s4 = s3.toLowerCase();
        if (!s4.startsWith("application/") || !s4.startsWith("application/xml") && !s4.endsWith("+xml")) goto _L7; else goto _L10
_L10:
        DoneHandlerInputStream donehandlerinputstream1 = new DoneHandlerInputStream(httpurlconnection.getInputStream());
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(donehandlerinputstream1));
_L14:
        String s5 = bufferedreader.readLine();
        if (s5 != null) goto _L12; else goto _L11
_L11:
        if (donehandlerinputstream1 != null)
        {
            donehandlerinputstream1.close();
        }
_L7:
        return s2;
_L12:
        String s6 = s5.trim();
        if (s6.length() == 0) goto _L14; else goto _L13
_L13:
        Matcher matcher2 = ContentTypePattern_XmlEncoding.matcher(s6);
        if (!matcher2.matches() || matcher2.groupCount() < 3) goto _L11; else goto _L15
_L15:
        String s7 = matcher2.group(2);
        if (TextUtils.isEmpty(s7)) goto _L11; else goto _L16
_L16:
        Log.v("com.xiaomi.common.Network", (new StringBuilder("XML charset detected is: ")).append(s7).toString());
        s2 = s7;
          goto _L11
        Exception exception;
        exception;
_L17:
        if (donehandlerinputstream != null)
        {
            donehandlerinputstream.close();
        }
        throw exception;
        exception;
        donehandlerinputstream = donehandlerinputstream1;
        if (true) goto _L17; else goto _L4
_L4:
        s2 = null;
        if (true) goto _L18; else goto _L2
_L2:
        return null;
    }

    public static String uploadFile(String s, File file, String s1)
    {
        BufferedReader bufferedreader = null;
        if (file.exists()) goto _L2; else goto _L1
_L1:
        String s5 = null;
_L8:
        return s5;
_L2:
        String s2 = file.getName();
        HttpURLConnection httpurlconnection;
        DataOutputStream dataoutputstream1;
        httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setReadTimeout(15000);
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
        httpurlconnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
        httpurlconnection.setFixedLengthStreamingMode(77 + s2.length() + (int)file.length() + s1.length());
        dataoutputstream1 = new DataOutputStream(httpurlconnection.getOutputStream());
        FileInputStream fileinputstream1;
        dataoutputstream1.writeBytes("--*****\r\n");
        dataoutputstream1.writeBytes((new StringBuilder("Content-Disposition: form-data; name=\"")).append(s1).append("\";filename=\"").append(file.getName()).append("\"").append("\r\n").toString());
        dataoutputstream1.writeBytes("\r\n");
        fileinputstream1 = new FileInputStream(file);
        byte abyte0[] = new byte[1024];
_L9:
        int i = fileinputstream1.read(abyte0);
        if (i != -1) goto _L4; else goto _L3
_L3:
        StringBuffer stringbuffer;
        BufferedReader bufferedreader1;
        dataoutputstream1.writeBytes("\r\n");
        dataoutputstream1.writeBytes("--");
        dataoutputstream1.writeBytes("*****");
        dataoutputstream1.writeBytes("--");
        dataoutputstream1.writeBytes("\r\n");
        dataoutputstream1.flush();
        stringbuffer = new StringBuffer();
        bufferedreader1 = new BufferedReader(new InputStreamReader(new DoneHandlerInputStream(httpurlconnection.getInputStream())));
_L10:
        String s3 = bufferedreader1.readLine();
        if (s3 != null) goto _L6; else goto _L5
_L5:
        String s4 = stringbuffer.toString();
        s5 = s4;
        if (fileinputstream1 != null)
        {
            try
            {
                fileinputstream1.close();
            }
            catch (IOException ioexception1)
            {
                Log.e("com.xiaomi.common.Network", "error while closing strean", ioexception1);
                return s5;
            }
        }
        if (dataoutputstream1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        dataoutputstream1.close();
        if (bufferedreader1 == null) goto _L8; else goto _L7
_L7:
        bufferedreader1.close();
        return s5;
_L4:
        dataoutputstream1.write(abyte0, 0, i);
        dataoutputstream1.flush();
          goto _L9
        Exception exception;
        exception;
        DataOutputStream dataoutputstream;
        FileInputStream fileinputstream;
        dataoutputstream = dataoutputstream1;
        fileinputstream = fileinputstream1;
_L11:
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        fileinputstream.close();
        if (dataoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_435;
        }
        dataoutputstream.close();
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception)
            {
                Log.e("com.xiaomi.common.Network", "error while closing strean", ioexception);
            }
        }
        throw exception;
_L6:
        stringbuffer.append(s3);
          goto _L10
        exception;
        bufferedreader = bufferedreader1;
        dataoutputstream = dataoutputstream1;
        fileinputstream = fileinputstream1;
          goto _L11
        exception;
        bufferedreader = null;
        dataoutputstream = null;
        fileinputstream = null;
          goto _L11
        exception;
        dataoutputstream = dataoutputstream1;
        bufferedreader = null;
        fileinputstream = null;
          goto _L11
    }


    private class HttpHeaderInfo
    {

        public Map AllHeaders;
        public String ContentType;
        public int ResponseCode;
        public String UserAgent;
        public String realUrl;

        public String toString()
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(ResponseCode);
            aobj[1] = AllHeaders.toString();
            return String.format("resCode = %1$d, headers = %2$s", aobj);
        }

        public HttpHeaderInfo()
        {
        }
    }


    private class DoneHandlerInputStream extends FilterInputStream
    {

        private boolean a;

        public int read(byte abyte0[], int i, int j)
        {
            if (!a)
            {
                int k = super.read(abyte0, i, j);
                if (k != -1)
                {
                    return k;
                }
            }
            a = true;
            return -1;
        }

        public DoneHandlerInputStream(InputStream inputstream)
        {
            super(inputstream);
        }
    }

}
