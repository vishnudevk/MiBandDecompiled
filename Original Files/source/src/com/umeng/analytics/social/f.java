// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.umeng.analytics.social:
//            e, b, UMPlatformData, a

public abstract class f
{

    private static Map a;

    public f()
    {
    }

    protected static String a(Context context)
    {
        String s = e.d;
        if (!TextUtils.isEmpty(s))
        {
            com.umeng.analytics.social.b.b("MobclickAgent", "use usefully appkey from constant field.");
            return s;
        }
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        String s1 = applicationinfo.metaData.getString("UMENG_APPKEY");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        return s1.trim();
        com.umeng.analytics.social.b.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
_L2:
        return null;
        Exception exception;
        exception;
        com.umeng.analytics.social.b.b("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String a(List list)
    {
        String s;
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            (new UrlEncodedFormEntity(list, "UTF-8")).writeTo(bytearrayoutputstream);
            s = bytearrayoutputstream.toString();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s;
    }

    private static transient List a(UMPlatformData aumplatformdata[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = new StringBuilder();
        StringBuilder stringbuilder2 = new StringBuilder();
        int i = aumplatformdata.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                if (aumplatformdata.length > 0)
                {
                    stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                    stringbuilder1.deleteCharAt(-1 + stringbuilder1.length());
                    stringbuilder2.deleteCharAt(-1 + stringbuilder2.length());
                }
                ArrayList arraylist = new ArrayList();
                arraylist.add(new BasicNameValuePair("platform", stringbuilder.toString()));
                arraylist.add(new BasicNameValuePair("usid", stringbuilder1.toString()));
                if (stringbuilder2.length() > 0)
                {
                    arraylist.add(new BasicNameValuePair("weiboid", stringbuilder2.toString()));
                }
                return arraylist;
            }
            UMPlatformData umplatformdata = aumplatformdata[j];
            stringbuilder.append(umplatformdata.getMeida().toString());
            stringbuilder.append(',');
            stringbuilder1.append(umplatformdata.getUsid());
            stringbuilder1.append(',');
            stringbuilder2.append(umplatformdata.getWeiboId());
            stringbuilder2.append(',');
            j++;
        } while (true);
    }

    private static boolean a(Context context, String s)
    {
        return context.getPackageManager().checkPermission(s, context.getPackageName()) == 0;
    }

    protected static transient String[] a(Context context, String s, UMPlatformData aumplatformdata[])
    {
        ArrayList arraylist;
        String s2;
        if (aumplatformdata == null || aumplatformdata.length == 0)
        {
            throw new a("platform data is null");
        }
        String s1 = a(context);
        if (TextUtils.isEmpty(s1))
        {
            throw new a("can`t get appkey.");
        }
        arraylist = new ArrayList();
        s2 = (new StringBuilder("http://log.umsns.com/share/api/")).append(s1).append("/").toString();
        if (a == null || a.isEmpty())
        {
            a = c(context);
        }
        if (a == null || a.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = a.entrySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        arraylist.add(new BasicNameValuePair("date", String.valueOf(System.currentTimeMillis())));
        arraylist.add(new BasicNameValuePair("channel", e.e));
        if (!TextUtils.isEmpty(s))
        {
            arraylist.add(new BasicNameValuePair("topic", s));
        }
        arraylist.addAll(a(aumplatformdata));
        String s3 = b(aumplatformdata);
        if (s3 == null)
        {
            s3 = "null";
        }
        String s4 = (new StringBuilder(String.valueOf(s2))).append("?").append(a(((List) (arraylist)))).toString();
        com.umeng.analytics.social.b.c("MobclickAgent", (new StringBuilder("URL:")).append(s4).toString());
        com.umeng.analytics.social.b.c("MobclickAgent", (new StringBuilder("BODY:")).append(s3).toString());
        return (new String[] {
            s4, s3
        });
_L3:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static transient String b(UMPlatformData aumplatformdata[])
    {
        JSONObject jsonobject;
        int i;
        int j;
        jsonobject = new JSONObject();
        i = aumplatformdata.length;
        j = 0;
_L8:
        UMPlatformData umplatformdata;
        UMPlatformData.GENDER gender;
        String s;
        JSONObject jsonobject1;
        Exception exception;
        String s1;
        String s2;
        String s3;
        if (j >= i)
        {
            if (jsonobject.length() == 0)
            {
                return null;
            } else
            {
                return jsonobject.toString();
            }
        }
        umplatformdata = aumplatformdata[j];
        gender = umplatformdata.getGender();
        s = umplatformdata.getName();
        if (gender != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        jsonobject1 = new JSONObject();
        if (gender != null) goto _L2; else goto _L1
_L1:
        s1 = "";
_L5:
        try
        {
            jsonobject1.put("gender", s1);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            throw new a("build body exception", exception);
        }
        if (s != null) goto _L4; else goto _L3
_L3:
        s3 = "";
_L6:
        jsonobject1.put("name", s3);
        jsonobject.put(umplatformdata.getMeida().toString(), jsonobject1);
        break MISSING_BLOCK_LABEL_175;
_L2:
        s1 = String.valueOf(gender.value);
          goto _L5
_L4:
        s2 = String.valueOf(s);
        s3 = s2;
          goto _L6
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Map b(Context context)
    {
        HashMap hashmap;
        TelephonyManager telephonymanager;
        hashmap = new HashMap();
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager == null)
        {
            com.umeng.analytics.social.b.e("MobclickAgent", "No IMEI.");
        }
        if (!a(context, "android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        String s3 = telephonymanager.getDeviceId();
        String s = s3;
_L4:
        String s1 = d(context);
        String s2 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(s1))
        {
            hashmap.put("mac", s1);
        }
        if (!TextUtils.isEmpty(s))
        {
            hashmap.put("imei", s);
        }
        if (!TextUtils.isEmpty(s2))
        {
            hashmap.put("android_id", s2);
        }
        return hashmap;
        Exception exception;
        exception;
        com.umeng.analytics.social.b.e("MobclickAgent", "No IMEI.", exception);
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Map c(Context context)
    {
        HashMap hashmap = new HashMap();
        Map map = b(context);
        if (map != null && !map.isEmpty())
        {
            StringBuilder stringbuilder = new StringBuilder();
            StringBuilder stringbuilder1 = new StringBuilder();
            Iterator iterator = map.entrySet().iterator();
            do
            {
                java.util.Map.Entry entry;
                do
                {
                    if (!iterator.hasNext())
                    {
                        if (stringbuilder.length() > 0)
                        {
                            stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                            hashmap.put("deviceid", stringbuilder.toString());
                        }
                        if (stringbuilder1.length() > 0)
                        {
                            stringbuilder1.deleteCharAt(-1 + stringbuilder1.length());
                            hashmap.put("idtype", stringbuilder1.toString());
                        }
                        return hashmap;
                    }
                    entry = (java.util.Map.Entry)iterator.next();
                } while (TextUtils.isEmpty((CharSequence)entry.getValue()));
                stringbuilder1.append((String)entry.getKey()).append(",");
                stringbuilder.append((String)entry.getValue()).append(",");
            } while (true);
        } else
        {
            throw new a("can`t get device id.");
        }
    }

    private static String d(Context context)
    {
        try
        {
            WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE"))
            {
                return wifimanager.getConnectionInfo().getMacAddress();
            }
            com.umeng.analytics.social.b.e("MobclickAgent", "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
        }
        catch (Exception exception)
        {
            com.umeng.analytics.social.b.e("MobclickAgent", (new StringBuilder("Could not get mac address.")).append(exception.toString()).toString());
        }
        return "";
    }
}
