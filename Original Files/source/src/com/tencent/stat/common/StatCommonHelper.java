// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.common:
//            StatBase64, RC4, StatLogger, f

public class StatCommonHelper
{

    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static Random e = null;
    private static StatLogger f = null;

    private static Random a()
    {
        if (e == null)
        {
            e = new Random();
        }
        return e;
    }

    public static boolean checkPermission(Context context, String s)
    {
        return context.getPackageManager().checkPermission(s, context.getPackageName()) == 0;
    }

    public static boolean checkPhoneState(Context context)
    {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static Long convertStringToLong(String s, String s1, int i, int j, Long long1)
    {
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        return long1;
_L2:
        String as[];
        if (s1.equalsIgnoreCase(".") || s1.equalsIgnoreCase("|"))
        {
            s1 = (new StringBuilder()).append("\\").append(s1).toString();
        }
        as = s.split(s1);
        if (as.length != j) goto _L1; else goto _L3
_L3:
        Long long2;
        int k;
        Long long3;
        try
        {
            long2 = Long.valueOf(0L);
        }
        catch (NumberFormatException numberformatexception)
        {
            return long1;
        }
        k = 0;
        if (k >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        long3 = Long.valueOf((long)i * (long2.longValue() + Long.valueOf(as[k]).longValue()));
        k++;
        long2 = long3;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_72;
_L4:
        return long2;
    }

    public static String decode(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            String s1;
            try
            {
                s1 = new String(RC4.decrypt(StatBase64.decode(s.getBytes("UTF-8"), 0)), "UTF-8");
            }
            catch (Throwable throwable)
            {
                f.e(throwable);
                return s;
            }
            return s1;
        }
        return s;
    }

    public static byte[] deocdeGZipContent(byte abyte0[])
    {
        GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(abyte0));
        byte abyte1[] = new byte[4096];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(2 * abyte0.length);
        do
        {
            int i = gzipinputstream.read(abyte1);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte1, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public static String encode(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            String s1;
            try
            {
                s1 = new String(StatBase64.encode(RC4.encrypt(s.getBytes("UTF-8")), 0), "UTF-8");
            }
            catch (Throwable throwable)
            {
                f.e(throwable);
                return s;
            }
            return s1;
        }
        return s;
    }

    public static String getActivityName(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return context.getClass().getName();
        }
    }

    public static String getAppKey(Context context)
    {
        if (b != null)
        {
            return b;
        }
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationinfo == null) goto _L2; else goto _L1
_L1:
        String s = applicationinfo.metaData.getString("TA_APPKEY");
        if (s == null) goto _L4; else goto _L3
_L3:
        b = s;
        Exception exception;
        return s;
_L2:
        return null;
_L4:
        try
        {
            f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static String getAppVersion(Context context)
    {
        String s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        s = "unknown";
        return s;
        Exception exception;
        exception;
        Exception exception1;
        s = "";
        exception1 = exception;
_L2:
        f.e(exception1);
        return s;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getCurAppVersion(Context context)
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (Exception exception)
        {
            f.e(exception);
            return "";
        }
        if (s == null)
        {
            s = "";
        }
        return s;
    }

    public static String getDateFormat(long l)
    {
        return (new SimpleDateFormat("yyyyMMdd")).format(new Date(l));
    }

    public static String getDeviceID(Context context)
    {
        if (checkPermission(context, "android.permission.READ_PHONE_STATE"))
        {
            String s = "";
            if (checkPhoneState(context))
            {
                s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
            }
            if (s != null)
            {
                return s;
            } else
            {
                f.error("deviceId is null");
                return null;
            }
        } else
        {
            f.e("Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static String getExternalStorageInfo(Context context)
    {
        String s;
        if (!checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s = Environment.getExternalStorageDirectory().getPath();
        if (s == null)
        {
            return null;
        }
        StatFs statfs = new StatFs(s);
        long l = ((long)statfs.getBlockCount() * (long)statfs.getBlockSize()) / 0xf4240L;
        long l1 = ((long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize()) / 0xf4240L;
        return (new StringBuilder()).append(String.valueOf(l1)).append("/").append(String.valueOf(l)).toString();
        f.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
        Throwable throwable;
        throwable;
        return null;
    }

    public static HttpHost getHttpProxy(Context context)
    {
        if (context == null)
        {
            return null;
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0)
        {
            return null;
        }
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return null;
        }
        if (networkinfo.getTypeName() != null && networkinfo.getTypeName().equalsIgnoreCase("WIFI"))
        {
            return null;
        }
        String s = networkinfo.getExtraInfo();
        if (s == null)
        {
            return null;
        }
        if (!s.equals("cmwap") && !s.equals("3gwap") && !s.equals("uniwap")) goto _L2; else goto _L1
_L1:
        HttpHost httphost = new HttpHost("10.0.0.172", 80);
        return httphost;
        Exception exception;
        exception;
        f.e(exception);
_L4:
        return null;
_L2:
        if (!s.equals("ctwap")) goto _L4; else goto _L3
_L3:
        HttpHost httphost1 = new HttpHost("10.0.0.200", 80);
        return httphost1;
    }

    public static String getInstallChannel(Context context)
    {
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        Object obj = applicationinfo.metaData.get("InstallChannel");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        return obj.toString();
        f.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
_L2:
        return null;
        Exception exception;
        exception;
        f.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getLinkedWay(Context context)
    {
        String s;
        String s1;
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE"))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        s = networkinfo.getTypeName();
        s1 = networkinfo.getExtraInfo();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (!s.equalsIgnoreCase("WIFI")) goto _L2; else goto _L1
_L1:
        s1 = "WIFI";
_L4:
        return s1;
_L2:
        if (!s.equalsIgnoreCase("MOBILE"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s1 != null) goto _L4; else goto _L3
_L3:
        return "MOBILE";
        if (s1 != null) goto _L4; else goto _L5
_L5:
        return s;
        f.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return null;
    }

    public static StatLogger getLogger()
    {
        if (f == null)
        {
            f = new StatLogger("MtaSDK");
            f.setDebugEnable(false);
        }
        return f;
    }

    public static String getMacId(Context context)
    {
        if (c == null || "" == c)
        {
            c = getWifiMacAddress(context);
        }
        return c;
    }

    public static int getNextSessionID()
    {
        return a().nextInt(0x7fffffff);
    }

    public static long getSDKLongVersion(String s)
    {
        return convertStringToLong(s, ".", 100, 3, Long.valueOf(0L)).longValue();
    }

    public static String getSimOperator(Context context)
    {
        if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        boolean flag;
        String s;
        flag = checkPhoneState(context);
        s = null;
        if (!flag) goto _L4; else goto _L3
_L3:
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        String s2 = telephonymanager.getSimOperator();
        String s1 = s2;
_L5:
        s = s1;
_L4:
        return s;
        Exception exception;
        exception;
        f.e(exception);
        s1 = null;
        if (true) goto _L5; else goto _L2
_L2:
        f.e("Could not get permission of android.permission.READ_PHONE_STATE");
        return null;
    }

    public static Integer getTelephonyNetworkType(Context context)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager != null)
        {
            return Integer.valueOf(telephonymanager.getNetworkType());
        } else
        {
            return null;
        }
    }

    public static long getTomorrowStartMilliseconds()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return 0x5265c00L + calendar.getTimeInMillis();
    }

    public static String getUserID(Context context)
    {
        if (a != null && a.trim().length() != 0)
        {
            return a;
        }
        a = getDeviceID(context);
        if (a == null || a.trim().length() == 0)
        {
            a = Integer.toString(a().nextInt(0x7fffffff));
        }
        return a;
    }

    public static String getWifiMacAddress(Context context)
    {
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE"))
        {
            break MISSING_BLOCK_LABEL_49;
        }
        WifiManager wifimanager;
        String s;
        try
        {
            wifimanager = (WifiManager)context.getSystemService("wifi");
        }
        catch (Exception exception)
        {
            f.e(exception);
            return "";
        }
        if (wifimanager == null)
        {
            return "";
        }
        s = wifimanager.getConnectionInfo().getMacAddress();
        return s;
        f.e("Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    public static int hasRootAccess(Context context)
    {
        return !com.tencent.stat.common.f.a() ? 0 : 1;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        if (checkPermission(context, "android.permission.INTERNET"))
        {
            NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo != null && networkinfo.isAvailable())
            {
                return true;
            } else
            {
                f.w("Network error");
                return false;
            }
        } else
        {
            f.warn("can not get the permisson of android.permission.INTERNET");
            return false;
        }
    }

    public static boolean isWiFiActive(Context context)
    {
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) goto _L2; else goto _L1
_L1:
        ConnectivityManager connectivitymanager;
        boolean flag;
        connectivitymanager = (ConnectivityManager)context.getApplicationContext().getSystemService("connectivity");
        flag = false;
        if (connectivitymanager == null) goto _L4; else goto _L3
_L3:
        NetworkInfo anetworkinfo[];
        anetworkinfo = connectivitymanager.getAllNetworkInfo();
        flag = false;
        if (anetworkinfo == null) goto _L4; else goto _L5
_L5:
        int i = 0;
_L9:
        int j;
        j = anetworkinfo.length;
        flag = false;
        if (i >= j) goto _L4; else goto _L6
_L6:
        if (!anetworkinfo[i].getTypeName().equalsIgnoreCase("WIFI") || !anetworkinfo[i].isConnected()) goto _L8; else goto _L7
_L7:
        flag = true;
_L4:
        return flag;
_L8:
        i++;
        if (true) goto _L9; else goto _L2
_L2:
        f.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return false;
    }

    public static boolean isWifiNet(Context context)
    {
        if (checkPermission(context, "android.permission.INTERNET"))
        {
            NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            return networkinfo != null && networkinfo.isAvailable() && networkinfo.getTypeName().equalsIgnoreCase("WIFI");
        } else
        {
            f.warn("can not get the permisson of android.permission.INTERNET");
            return false;
        }
    }

    public static void jsonPut(JSONObject jsonobject, String s, String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            jsonobject.put(s, s1);
        }
    }

    public static String md5sum(String s)
    {
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        String s1;
        int j;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            f.e(nosuchalgorithmexception);
            return "0";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0xff & abyte0[i];
        if (j >= 16)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        stringbuffer.append("0");
        stringbuffer.append(Integer.toHexString(j));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_32;
_L1:
        s1 = stringbuffer.toString();
        return s1;
    }

}
