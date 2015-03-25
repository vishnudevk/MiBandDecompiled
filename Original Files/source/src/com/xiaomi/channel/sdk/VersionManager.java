// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public class VersionManager
{

    public static final int MILIAO_AVAILABLE = 0xfffea06d;
    public static final int MILIAO_NOT_INSTALLED = 0xfffea06f;
    public static final int MILIAO_TOO_OLD = 0xfffea06e;
    private static final String a = "com.xiaomi.channel";

    public VersionManager()
    {
    }

    private static boolean a(Context context, String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        List list;
        return false;
_L2:
        if ((list = context.getPackageManager().getInstalledPackages(0)) != null)
        {
            int i = 0;
            while (i < list.size()) 
            {
                if (s.equals(((PackageInfo)list.get(i)).packageName))
                {
                    return true;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int checkMiliaoVersion(Context context)
    {
        if (!a(context, "com.xiaomi.channel")) goto _L2; else goto _L1
_L1:
        Cursor cursor;
        Uri uri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getInfo");
        cursor = context.getContentResolver().query(uri, new String[] {
            "code", "version"
        }, null, null, null);
        if (cursor == null) goto _L4; else goto _L3
_L3:
        if (!cursor.moveToFirst()) goto _L4; else goto _L5
_L5:
        int j = cursor.getInt(0);
        j;
        JVM INSTR tableswitch 10001 10001: default 88
    //                   10001 115;
           goto _L4 _L6
_L4:
        int i;
        int k;
        if (cursor != null)
        {
            try
            {
                if (!cursor.isClosed())
                {
                    cursor.close();
                }
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.e("miliao_sdk_log", illegalargumentexception.toString());
            }
        }
_L11:
        i = 0xfffea06e;
_L8:
        return i;
_L6:
        k = cursor.getInt(1);
        if (k >= 1)
        {
            i = 0xfffea06d;
        } else
        {
            i = 0xfffea06e;
        }
        if (cursor == null) goto _L8; else goto _L7
_L7:
        if (cursor.isClosed()) goto _L8; else goto _L9
_L9:
        cursor.close();
        return i;
        Exception exception1;
        exception1;
        Log.e("miliao_sdk_log", exception1.toString());
        if (cursor == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!cursor.isClosed())
        {
            cursor.close();
        }
        if (true) goto _L11; else goto _L10
_L10:
        Exception exception;
        exception;
        if (cursor == null) goto _L13; else goto _L12
_L12:
        if (!cursor.isClosed())
        {
            cursor.close();
        }
_L13:
        throw exception;
_L2:
        return 0xfffea06f;
    }

    public static boolean isMiliaoVersionAvailable(Context context)
    {
        List list = context.getPackageManager().getInstalledPackages(0);
        if (list == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i < list.size()) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        PackageInfo packageinfo = (PackageInfo)list.get(i);
        if (!"com.xiaomi.channel".equals(packageinfo.packageName))
        {
            break; /* Loop/switch isn't completed */
        }
        if (packageinfo.versionCode >= 1060)
        {
            return true;
        }
        if (true) goto _L2; else goto _L4
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
