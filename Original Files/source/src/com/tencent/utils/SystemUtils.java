// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.tencent.a.a.c;
import java.security.MessageDigest;
import java.util.List;

// Referenced classes of package com.tencent.utils:
//            Util

public class SystemUtils
{

    public static final String QQ_SHARE_CALLBACK_ACTION = "shareToQQ";
    public static final String QQ_VERSION_NAME_4_1_0 = "4.1.0";
    public static final String QQ_VERSION_NAME_4_2_0 = "4.2.0";
    public static final String QQ_VERSION_NAME_4_3_0 = "4.3.0";
    public static final String QQ_VERSION_NAME_4_5_0 = "4.5.0";
    public static final String QQ_VERSION_NAME_4_6_0 = "4.6.0";
    public static final String QZONE_SHARE_CALLBACK_ACTION = "shareToQzone";

    public SystemUtils()
    {
    }

    public static boolean checkMobileQQ(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        PackageInfo packageinfo1 = packagemanager.getPackageInfo("com.tencent.mobileqq", 0);
        PackageInfo packageinfo = packageinfo1;
_L2:
label0:
        {
            boolean flag = false;
            if (packageinfo == null)
            {
                break label0;
            }
            String s = packageinfo.versionName;
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            int i;
            int j;
            try
            {
                Log.d("MobileQQ verson", s);
                String as[] = s.split("\\.");
                i = Integer.parseInt(as[0]);
                j = Integer.parseInt(as[1]);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return false;
            }
            if (i <= 4)
            {
                flag = false;
                if (i != 4)
                {
                    break label0;
                }
                flag = false;
                if (j < 1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
        namenotfoundexception;
        Log.d("checkMobileQQ", "error");
        namenotfoundexception.printStackTrace();
        packageinfo = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int compareQQVersion(Context context, String s)
    {
        return compareVersion(getAppVersionName(context, "com.tencent.mobileqq"), s);
    }

    public static int compareVersion(String s, String s1)
    {
        if (s != null || s1 != null) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        String as[];
        String as1[];
        int i;
        if (s != null && s1 == null)
        {
            return 1;
        }
        if (s == null && s1 != null)
        {
            return -1;
        }
        as = s.split("\\.");
        as1 = s1.split("\\.");
        i = 0;
_L3:
        int k;
        int l;
        if (i >= as.length || i >= as1.length)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        k = Integer.parseInt(as[i]);
        l = Integer.parseInt(as1[i]);
        if (k < l)
        {
            return -1;
        }
        break MISSING_BLOCK_LABEL_118;
        if (as.length > i)
        {
            return 1;
        }
        int j;
        try
        {
            j = as1.length;
        }
        catch (NumberFormatException numberformatexception)
        {
            return s.compareTo(s1);
        }
        if (j > i)
        {
            return -1;
        }
          goto _L1
        if (k > l)
        {
            return 1;
        }
        i++;
          goto _L3
    }

    public static String getAppName(Context context)
    {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String getAppSignatureMD5(Context context, String s)
    {
        c.a("openSDK_LOG", "OpenUi, getSignValidString");
        MessageDigest messagedigest;
        String s4;
        String s2 = context.getPackageName();
        Signature asignature[] = context.getPackageManager().getPackageInfo(s2, 64).signatures;
        messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(asignature[0].toByteArray());
        String s3 = Util.toHexString(messagedigest.digest());
        messagedigest.reset();
        messagedigest.update((new StringBuilder()).append(s2).append("_").append(s3).append("_").append(s).append("").toString().getBytes());
        s4 = Util.toHexString(messagedigest.digest());
        String s1 = s4;
        messagedigest.reset();
        return s1;
        Exception exception;
        exception;
        Exception exception1;
        s1 = "";
        exception1 = exception;
_L2:
        exception1.printStackTrace();
        c.a("openSDK_LOG", "OpenUi, getSignValidString error", exception1);
        return s1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getAppVersionName(Context context, String s)
    {
        PackageManager packagemanager = context.getPackageManager();
        String s1;
        try
        {
            s1 = packagemanager.getPackageInfo(s, 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        return s1;
    }

    public static String getRealPathFromUri(Activity activity, Uri uri)
    {
        Cursor cursor = activity.managedQuery(uri, new String[] {
            "_data"
        }, null, null, null);
        String s = null;
        if (cursor != null)
        {
            int i = cursor.getColumnIndexOrThrow("_data");
            cursor.moveToFirst();
            s = cursor.getString(i);
        }
        return s;
    }

    public static boolean isActivityExist(Context context, Intent intent)
    {
        while (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) 
        {
            return false;
        }
        return true;
    }

    public static boolean isAppSignatureValid(Context context, String s, String s1)
    {
        c.a("openSDK_LOG", "OpenUi, validateAppSignatureForPackage");
        PackageInfo packageinfo;
        Signature asignature[];
        int i;
        int j;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(s, 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        asignature = packageinfo.signatures;
        i = asignature.length;
        j = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (j < i)
                {
                    if (!Util.encrypt(asignature[j].toCharsString()).equals(s1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }
}
