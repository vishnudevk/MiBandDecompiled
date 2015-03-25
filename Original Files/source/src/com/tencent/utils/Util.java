// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.utils:
//            SystemUtils, e, HttpUtils

public class Util
{

    private static final String a = com/tencent/utils/Util.getName();
    private static boolean b = true;
    private static String c = "0123456789ABCDEF";

    public Util()
    {
    }

    private static char a(int i)
    {
        int j = i & 0xf;
        if (j < 10)
        {
            return (char)(j + 48);
        } else
        {
            return (char)(97 + (j - 10));
        }
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

    private static void a(Context context, String s, String s1, String s2)
    {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s, s1));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(0x40000000);
        intent.addFlags(0x10000000);
        intent.setData(Uri.parse(s2));
        context.startActivity(intent);
    }

    private static boolean a(Context context)
    {
        PackageInfo packageinfo;
        String s;
        int i;
        boolean flag;
        boolean flag1;
        Signature asignature[];
        NoSuchAlgorithmException nosuchalgorithmexception;
        MessageDigest messagedigest;
        String s1;
        boolean flag2;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            s = packageinfo.versionName;
            i = SystemUtils.compareVersion(s, "4.3");
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        flag = false;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        flag1 = s.startsWith("4.4");
        flag = false;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        asignature = packageinfo.signatures;
        flag = false;
        if (asignature == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(asignature[0].toByteArray());
        s1 = toHexString(messagedigest.digest());
        messagedigest.reset();
        flag2 = s1.equals("d8391a394d4a179e6fe7bdb8a301258b");
        flag = false;
        if (flag2)
        {
            flag = true;
        }
        return flag;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
        return false;
    }

    public static Bundle decodeUrl(String s)
    {
        Bundle bundle = new Bundle();
        if (s != null)
        {
            String as[] = s.split("&");
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String as1[] = as[j].split("=");
                if (as1.length == 2)
                {
                    bundle.putString(URLDecoder.decode(as1[0]), URLDecoder.decode(as1[1]));
                }
            }

        }
        return bundle;
    }

    public static JSONObject decodeUrlToJson(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            jsonobject = new JSONObject();
        }
        if (s != null)
        {
            String as[] = s.split("&");
            int i = as.length;
            int j = 0;
            while (j < i) 
            {
                String as1[] = as[j].split("=");
                if (as1.length == 2)
                {
                    try
                    {
                        jsonobject.put(URLDecoder.decode(as1[0]), URLDecoder.decode(as1[1]));
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                    }
                }
                j++;
            }
        }
        return jsonobject;
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
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(s)).append("=").toString());
                    as = (String[])bundle.getStringArray(s);
                    if (as != null)
                    {
                        int i = 0;
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

    public static String encrypt(String s)
    {
        byte abyte0[];
        StringBuilder stringbuilder;
        int i;
        int j;
        byte byte0;
        String s1;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return s;
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        stringbuilder = new StringBuilder();
        i = abyte0.length;
        j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte0[j];
        stringbuilder.append(a(byte0 >>> 4));
        stringbuilder.append(a(byte0));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s1 = stringbuilder.toString();
        s = s1;
        return s;
    }

    public static boolean fileExists(String s)
    {
        File file;
        if (s != null)
        {
            if ((file = new File(s)) != null && file.exists())
            {
                return true;
            }
        }
        return false;
    }

    public static String getAppVersion(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        String s;
        try
        {
            s = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e(a, (new StringBuilder()).append("getAppVersion error").append(namenotfoundexception.getMessage()).toString());
            namenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }

    public static final String getApplicationLable(Context context)
    {
        if (context != null)
        {
            CharSequence charsequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (charsequence != null)
            {
                return charsequence.toString();
            }
        }
        return null;
    }

    public static String getUserIp()
    {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        if (enumeration == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L4:
        if (!enumeration1.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        String s = inetaddress.getHostAddress().toString();
        return s;
        SocketException socketexception;
        socketexception;
        logd("Tencent-Util", socketexception.toString());
        return "";
    }

    public static boolean hasSDCard()
    {
        boolean flag = Environment.getExternalStorageState().equals("mounted");
        File file = null;
        if (flag)
        {
            file = Environment.getExternalStorageDirectory();
        }
        return file != null;
    }

    public static String hexToString(String s)
    {
        int i = 0;
        if ("0x".equals(s.substring(0, 2)))
        {
            s = s.substring(2);
        }
        byte abyte0[] = new byte[s.length() / 2];
        while (i < abyte0.length) 
        {
            int j = i * 2;
            int k = 2 + i * 2;
            try
            {
                abyte0[i] = (byte)(0xff & Integer.parseInt(s.substring(j, k), 16));
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
            i++;
        }
        String s1;
        try
        {
            s1 = new String(abyte0, "utf-8");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return s;
        }
        return s1;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isMobileQQSupportShare(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        boolean flag;
        try
        {
            i = SystemUtils.compareVersion(packagemanager.getPackageInfo("com.tencent.mobileqq", 0).versionName, "4.1");
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.d("checkMobileQQ", "error");
            return false;
        }
        flag = false;
        if (i >= 0)
        {
            flag = true;
        }
        return flag;
    }

    public static final boolean isValidPath(String s)
    {
        File file;
        if (s != null)
        {
            if ((file = new File(s)) != null && file.exists())
            {
                return true;
            }
        }
        return false;
    }

    public static final boolean isValidUrl(String s)
    {
        while (s == null || !s.startsWith("http://") && !s.startsWith("https://")) 
        {
            return false;
        }
        return true;
    }

    public static void logd(String s, String s1)
    {
        if (b)
        {
            Log.d(s, s1);
        }
    }

    public static boolean openBrowser(Context context, String s)
    {
        boolean flag1 = a(context);
        boolean flag = flag1;
        if (!flag) goto _L2; else goto _L1
_L1:
        a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", s);
          goto _L3
_L2:
        a(context, "com.android.browser", "com.android.browser.BrowserActivity", s);
          goto _L3
        Exception exception6;
        exception6;
_L4:
        if (flag)
        {
            try
            {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", s);
            }
            catch (Exception exception3)
            {
                try
                {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", s);
                }
                catch (Exception exception4)
                {
                    try
                    {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", s);
                    }
                    catch (Exception exception5)
                    {
                        return false;
                    }
                }
            }
        } else
        {
            try
            {
                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", s);
            }
            catch (Exception exception1)
            {
                try
                {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", s);
                }
                catch (Exception exception2)
                {
                    return false;
                }
            }
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    public static JSONObject parseJson(String s)
    {
        if (s.equals("false"))
        {
            s = "{value : false}";
        }
        if (s.equals("true"))
        {
            s = "{value : true}";
        }
        if (s.contains("allback("))
        {
            s = s.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (s.contains("online"))
        {
            s = (new StringBuilder()).append("{online:").append(s.charAt(-2 + s.length())).append("}").toString();
        }
        return new JSONObject(s);
    }

    public static Bundle parseUrl(String s)
    {
        String s1 = s.replace("auth://", "http://");
        Bundle bundle;
        try
        {
            URL url = new URL(s1);
            bundle = decodeUrl(url.getQuery());
            bundle.putAll(decodeUrl(url.getRef()));
        }
        catch (MalformedURLException malformedurlexception)
        {
            return new Bundle();
        }
        return bundle;
    }

    public static JSONObject parseUrlToJson(String s)
    {
        String s1 = s.replace("auth://", "http://");
        JSONObject jsonobject;
        try
        {
            URL url = new URL(s1);
            jsonobject = decodeUrlToJson(null, url.getQuery());
            decodeUrlToJson(jsonobject, url.getRef());
        }
        catch (MalformedURLException malformedurlexception)
        {
            return new JSONObject();
        }
        return jsonobject;
    }

    public static void reportBernoulli(Context context, String s, long l, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", s1);
        bundle.putString("strValue", s1);
        bundle.putString("nValue", s);
        bundle.putString("qver", "2.1");
        if (l != 0L)
        {
            bundle.putLong("elt", l);
        }
        (new e(context, bundle)).start();
    }

    public static void showAlert(Context context, String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.create().show();
    }

    public static final String subString(String s, int i, String s1, String s2)
    {
        int j = 0;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = "";
_L6:
        return s;
_L2:
        Exception exception;
        int k;
        int l;
        String s3;
        String s4;
        Exception exception1;
        String s5;
        if (TextUtils.isEmpty(s1))
        {
            s1 = "UTF-8";
        }
        if (s.getBytes(s1).length <= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = 0;
_L4:
        if (j >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        l = s.substring(j, j + 1).getBytes(s1).length;
        if (k + l <= i)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        s3 = s.substring(0, j);
        s4 = s3;
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        s5 = (new StringBuilder()).append(s4).append(s2).toString();
        s4 = s5;
        return s4;
        k += l;
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        exception;
_L8:
        System.out.println((new StringBuilder()).append("StructMsg sSubString error : ").append(exception.getMessage()).toString());
        return s;
        exception1;
        s = s4;
        exception = exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String toHexString(String s)
    {
        byte abyte0[] = s.getBytes();
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(c.charAt((0xf0 & abyte0[i]) >> 4));
            stringbuilder.append(c.charAt((0xf & abyte0[i]) >> 0));
        }

        return stringbuilder.toString();
    }

    public static String toHexString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toString(0xff & abyte0[i], 16);
            if (s.length() == 1)
            {
                s = (new StringBuilder()).append("0").append(s).toString();
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static Statistic upload(Context context, String s, Bundle bundle)
    {
        if (context != null)
        {
            ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
            if (connectivitymanager != null)
            {
                NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
                if (networkinfo == null || !networkinfo.isAvailable())
                {
                    throw new HttpUtils.NetworkUnavailableException("network unavailable");
                }
            }
        }
        Bundle bundle1 = new Bundle(bundle);
        String s1 = bundle1.getString("appid_for_getting_config");
        bundle1.remove("appid_for_getting_config");
        HttpClient httpclient = HttpUtils.getHttpClient(context, s1, s);
        HttpPost httppost = new HttpPost(s);
        Bundle bundle2 = new Bundle();
        Iterator iterator = bundle1.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s3 = (String)iterator.next();
            Object obj = bundle1.get(s3);
            if (obj instanceof byte[])
            {
                bundle2.putByteArray(s3, (byte[])(byte[])obj);
            }
        } while (true);
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
                String s2 = (String)iterator1.next();
                l++;
                bytearrayoutputstream.write((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s2).append("\"; filename=\"").append("value.file").append("\"").append("\r\n").toString().getBytes());
                bytearrayoutputstream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                byte abyte1[] = bundle2.getByteArray(s2);
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
        int i = 0 + abyte0.length;
        bytearrayoutputstream.close();
        httppost.setEntity(new ByteArrayEntity(abyte0));
        HttpResponse httpresponse = httpclient.execute(httppost);
        int j = httpresponse.getStatusLine().getStatusCode();
        if (j == 200)
        {
            return new Statistic(a(httpresponse), i);
        } else
        {
            throw new HttpUtils.HttpStatusException((new StringBuilder()).append("http status code error:").append(j).toString());
        }
    }


    private class Statistic
    {

        public long reqSize;
        public String response;
        public long rspSize;

        public Statistic(String s, int i)
        {
            response = s;
            reqSize = i;
            if (response != null)
            {
                rspSize = response.length();
            }
        }
    }

}
