// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.aps.b;
import com.aps.t;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

// Referenced classes of package com.amap.api.location.core:
//            e

public class c
{

    static String a = "";
    private static c b = null;
    private static String c = null;
    private static Context d = null;
    private static TelephonyManager e;
    private static ConnectivityManager f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;

    private c()
    {
    }

    public static c a(Context context)
    {
        if (b == null)
        {
            b = new c();
            d = context;
            e = (TelephonyManager)d.getSystemService("phone");
            f = (ConnectivityManager)d.getSystemService("connectivity");
            g = d.getApplicationContext().getPackageName();
            i = i();
            j = g();
            k = h();
            h = d(context);
            a = b(d);
        }
        return b;
    }

    public static String a()
    {
        return a;
    }

    public static String b()
    {
        return g;
    }

    public static String b(Context context)
    {
        if (a == null || a.equals(""))
        {
            try
            {
                a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
            }
            catch (Throwable throwable)
            {
                Log.e("AuthLocation", "key\u9274\u6743\u5931\u8D25");
            }
        }
        return a;
    }

    public static String d()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public static String d(Context context)
    {
        int l = 0;
        byte abyte1[];
        StringBuffer stringbuffer;
        byte abyte0[] = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        abyte1 = MessageDigest.getInstance("SHA1").digest(abyte0);
        stringbuffer = new StringBuffer();
_L1:
        if (l >= abyte1.length)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        String s1 = Integer.toHexString(0xff & abyte1[l]).toUpperCase(Locale.US);
        if (s1.length() == 1)
        {
            stringbuffer.append("0");
        }
        stringbuffer.append(s1);
        stringbuffer.append(":");
        l++;
          goto _L1
        String s = stringbuffer.toString();
        return s;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
_L3:
        return null;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static String e()
    {
        return Build.MODEL;
    }

    public static String g()
    {
        String s;
        try
        {
            PackageManager packagemanager = d.getPackageManager();
            s = (String)packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(d.getPackageName(), 0));
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }

    public static String h()
    {
        PackageManager packagemanager = d.getPackageManager();
        String s;
        try
        {
            s = packagemanager.getPackageInfo(d.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            return "";
        }
        return s;
    }

    private static String i()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)d.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        int l = displaymetrics.widthPixels;
        int i1 = displaymetrics.heightPixels;
        String s;
        if (i1 > l)
        {
            s = (new StringBuilder()).append(l).append("*").append(i1).toString();
        } else
        {
            s = (new StringBuilder()).append(i1).append("*").append(l).toString();
        }
        i = s;
        return i;
    }

    public boolean a(String s)
    {
        while (s == null || s.equals("") || s.equals("0") || s.equals("000") || s.equalsIgnoreCase("nul") || s.equals("999") || s.equals("460") || s.equals("461")) 
        {
            return true;
        }
        return false;
    }

    public String b(String s)
    {
        KeyGenerator keygenerator1 = KeyGenerator.getInstance("AES");
        KeyGenerator keygenerator = keygenerator1;
_L2:
        if (keygenerator == null)
        {
            return "";
        }
        break; /* Loop/switch isn't completed */
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
        keygenerator = null;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            keygenerator.init(256);
            byte abyte0[] = keygenerator.generateKey().getEncoded();
            byte abyte1[];
            byte abyte2[];
            byte abyte3[];
            try
            {
                abyte2 = com.amap.api.location.core.e.a(abyte0, com.amap.api.location.core.e.a(d));
                abyte3 = com.amap.api.location.core.e.a(abyte0, c(s).getBytes("UTF-8"));
                abyte1 = new byte[abyte2.length + abyte3.length];
            }
            catch (Throwable throwable)
            {
                abyte1 = null;
                if (false)
                {
                } else
                {
                    break label0;
                }
            }
            try
            {
                System.arraycopy(abyte2, 0, abyte1, 0, abyte2.length);
                System.arraycopy(abyte3, 0, abyte1, abyte2.length, abyte3.length);
            }
            catch (Throwable throwable1) { }
        }
        return com.aps.b.a(t.a(abyte1));
    }

    public String c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("mod=");
        stringbuilder.append(e());
        stringbuilder.append("&sv=");
        stringbuilder.append(d());
        stringbuilder.append("&nt=");
        stringbuilder.append(f());
        String s = e.getNetworkOperatorName();
        stringbuilder.append("&np=");
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    public String c(Context context)
    {
        String s;
        TelephonyManager telephonymanager;
        s = "";
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager == null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        String s3;
        try
        {
            s1 = telephonymanager.getNetworkOperator();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return s;
        }
        if (s1 == null) goto _L4; else goto _L3
_L3:
        if (s1.length() < 3) goto _L4; else goto _L5
_L5:
        s3 = s1.substring(0, 3);
        s2 = s3;
_L7:
        s = s2;
_L2:
        return s;
_L4:
        s2 = s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String c(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("ia=1&");
        if (a != null && a.length() > 0)
        {
            stringbuilder.append("key=");
            stringbuilder.append(a);
            stringbuilder.append("&");
        }
        stringbuilder.append("ct=android");
        String s1 = e.getDeviceId();
        String s2 = e.getSubscriberId();
        stringbuilder.append("&ime=");
        stringbuilder.append(s1);
        stringbuilder.append("&sim=");
        stringbuilder.append(s2);
        stringbuilder.append("&pkg=");
        stringbuilder.append(g);
        stringbuilder.append("&mod=");
        stringbuilder.append(e());
        stringbuilder.append("&sv=");
        stringbuilder.append(d());
        stringbuilder.append("&nt=");
        stringbuilder.append(f());
        String s3 = e.getNetworkOperatorName();
        stringbuilder.append("&np=");
        stringbuilder.append(s3);
        stringbuilder.append("&ctm=");
        stringbuilder.append(System.currentTimeMillis());
        stringbuilder.append("&re=");
        stringbuilder.append(i);
        stringbuilder.append("&av=");
        stringbuilder.append("V1.2.0");
        stringbuilder.append("&apn=");
        stringbuilder.append(j);
        stringbuilder.append("&apv=");
        stringbuilder.append(k);
        stringbuilder.append("&pro=");
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    public String f()
    {
        if (d.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            return "";
        }
        if (f == null)
        {
            return "";
        }
        NetworkInfo networkinfo = f.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return "";
        } else
        {
            return networkinfo.getTypeName();
        }
    }

}
