// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiUtils
{

    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    private static final String TAG = "ApiUtils";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
    private static final String WEIBO_SIGN = "18da2bf10352443a00a5e046d9fca6bd";

    public ApiUtils()
    {
    }

    public static boolean containSign(Signature asignature[], String s)
    {
        if (asignature != null && s != null)
        {
            int i = asignature.length;
            int j = 0;
            while (j < i) 
            {
                if (s.equals(MD5.hexdigest(asignature[j].toByteArray())))
                {
                    LogUtil.d("ApiUtils", "check pass");
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean isWeiboAppSupportAPI(int i)
    {
        return i >= 10350;
    }

    public static WeiboInfo queryWeiboInfo(Context context)
    {
        WeiboInfo weiboinfo = queryWeiboInfoByProvider(context);
        if (weiboinfo == null)
        {
            weiboinfo = queryWeiboInfoByFile(context);
        }
        return weiboinfo;
    }

    private static WeiboInfo queryWeiboInfoByAsset(Context context, String s)
    {
        if (context != null && s != null) goto _L2; else goto _L1
_L1:
        WeiboInfo weiboinfo = null;
_L9:
        return weiboinfo;
_L2:
        byte abyte0[];
        InputStream inputstream1;
        Context context1 = context.createPackageContext(s, 2);
        abyte0 = new byte[1024];
        inputstream1 = context1.getAssets().open("weibo_for_sdk.json");
        InputStream inputstream = inputstream1;
        StringBuilder stringbuilder = new StringBuilder();
_L8:
        int i = inputstream.read(abyte0, 0, 1024);
        if (i != -1) goto _L4; else goto _L3
_L3:
        if (TextUtils.isEmpty(stringbuilder.toString())) goto _L6; else goto _L5
_L5:
        boolean flag = validateWeiboSign(context, s);
        if (flag) goto _L7; else goto _L6
_L6:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        Exception exception;
        Exception exception1;
        JSONException jsonexception;
        IOException ioexception4;
        IOException ioexception2;
        IOException ioexception3;
        IOException ioexception5;
        int j;
        IOException ioexception7;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception6) { }
        }
        return null;
_L4:
        stringbuilder.append(new String(abyte0, 0, i));
          goto _L8
        namenotfoundexception;
_L18:
        namenotfoundexception.printStackTrace();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1) { }
        }
        return null;
_L7:
        j = (new JSONObject(stringbuilder.toString())).optInt("support_api", -1);
        weiboinfo = new WeiboInfo();
        weiboinfo.packageName = s;
        weiboinfo.supportApi = j;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception7)
            {
                return weiboinfo;
            }
            return weiboinfo;
        }
          goto _L9
        ioexception4;
        inputstream = null;
_L17:
        ioexception4.printStackTrace();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception5) { }
        }
        break MISSING_BLOCK_LABEL_142;
        jsonexception;
        inputstream = null;
_L15:
        jsonexception.printStackTrace();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception3) { }
        }
        break MISSING_BLOCK_LABEL_142;
        exception1;
        inputstream = null;
_L13:
        LogUtil.e("ApiUtils", exception1.getMessage());
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception2) { }
        }
        break MISSING_BLOCK_LABEL_142;
        exception;
        inputstream = null;
_L11:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception;
        exception;
        if (true) goto _L11; else goto _L10
_L10:
        exception1;
        if (true) goto _L13; else goto _L12
_L12:
        jsonexception;
        if (true) goto _L15; else goto _L14
_L14:
        ioexception4;
        if (true) goto _L17; else goto _L16
_L16:
        namenotfoundexception;
        inputstream = null;
          goto _L18
    }

    private static WeiboInfo queryWeiboInfoByFile(Context context)
    {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List list = context.getPackageManager().queryIntentServices(intent, 0);
        if (list == null || list.isEmpty())
        {
            return null;
        }
        Iterator iterator = list.iterator();
        WeiboInfo weiboinfo;
        do
        {
            ResolveInfo resolveinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    return null;
                }
                resolveinfo = (ResolveInfo)iterator.next();
            } while (resolveinfo.serviceInfo == null || resolveinfo.serviceInfo.applicationInfo == null || resolveinfo.serviceInfo.applicationInfo.packageName == null || resolveinfo.serviceInfo.applicationInfo.packageName.length() == 0);
            weiboinfo = queryWeiboInfoByAsset(context, resolveinfo.serviceInfo.applicationInfo.packageName);
        } while (weiboinfo == null);
        return weiboinfo;
    }

    public static WeiboInfo queryWeiboInfoByPackage(Context context, String s)
    {
        WeiboInfo weiboinfo;
        if (context == null || s == null)
        {
            weiboinfo = null;
        } else
        {
            weiboinfo = queryWeiboInfoByAsset(context, s);
            if (weiboinfo == null)
            {
                weiboinfo = queryWeiboInfoByProvider(context);
                if (weiboinfo == null || !s.equals(weiboinfo.packageName))
                {
                    return null;
                }
            }
        }
        return weiboinfo;
    }

    private static WeiboInfo queryWeiboInfoByProvider(Context context)
    {
        ContentResolver contentresolver = context.getContentResolver();
        Cursor cursor1 = contentresolver.query(WEIBO_NAME_URI, null, null, null, null);
        Cursor cursor = cursor1;
        if (cursor != null) goto _L2; else goto _L1
_L1:
        WeiboInfo weiboinfo;
        if (cursor != null)
        {
            cursor.close();
        }
        weiboinfo = null;
_L11:
        return weiboinfo;
_L2:
        int i;
        int j;
        i = cursor.getColumnIndex("support_api");
        j = cursor.getColumnIndex("package");
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        String s = cursor.getString(i);
        int l = Integer.parseInt(s);
        int k = l;
_L5:
        String s1 = cursor.getString(j);
        if (TextUtils.isEmpty(s1) || !validateWeiboSign(context, s1))
        {
            break; /* Loop/switch isn't completed */
        }
        weiboinfo = new WeiboInfo();
        weiboinfo.packageName = s1;
        weiboinfo.supportApi = k;
        if (cursor != null)
        {
            cursor.close();
            return weiboinfo;
        }
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        numberformatexception.printStackTrace();
        k = -1;
        if (true) goto _L5; else goto _L4
        Exception exception1;
        exception1;
        cursor = null;
_L9:
        exception1.printStackTrace();
        LogUtil.e("ApiUtils", exception1.getMessage());
        if (cursor != null)
        {
            cursor.close();
        }
_L6:
        return null;
        Exception exception;
        exception;
        cursor = null;
_L7:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L6
        exception;
          goto _L7
        exception1;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static boolean validateWeiboSign(Context context, String s)
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(s, 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        return containSign(packageinfo.signatures, "18da2bf10352443a00a5e046d9fca6bd");
    }


    private class WeiboInfo
    {

        public String packageName;
        public int supportApi;

        public String toString()
        {
            return (new StringBuilder("WeiboInfo: PackageName = ")).append(packageName).append(", supportApi = ").append(supportApi).toString();
        }

        public WeiboInfo()
        {
        }
    }

}
