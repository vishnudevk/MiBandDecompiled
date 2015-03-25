// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.api.share.ApiUtils;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            MD5

public class SecurityHelper
{

    private static final String WEIBO_MD5_SIGNATURE = "18da2bf10352443a00a5e046d9fca6bd";

    public SecurityHelper()
    {
    }

    public static boolean checkResponseAppLegal(Context context, Intent intent)
    {
        com.sina.weibo.sdk.api.share.ApiUtils.WeiboInfo weiboinfo;
        weiboinfo = ApiUtils.queryWeiboInfo(context);
        break MISSING_BLOCK_LABEL_5;
        if ((weiboinfo == null || weiboinfo.supportApi > 10352) && weiboinfo != null)
        {
            String s = intent.getStringExtra("_weibo_appPackage");
            if (s == null || intent.getStringExtra("_weibo_transaction") == null || !ApiUtils.validateWeiboSign(context, s))
            {
                return false;
            }
        }
        return true;
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
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent)
    {
        PackageManager packagemanager = context.getPackageManager();
        ResolveInfo resolveinfo;
        if (packagemanager != null)
        {
            if ((resolveinfo = packagemanager.resolveActivity(intent, 0)) != null)
            {
                String s = resolveinfo.activityInfo.packageName;
                boolean flag;
                try
                {
                    flag = containSign(packagemanager.getPackageInfo(s, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    namenotfoundexception.printStackTrace();
                    return false;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return false;
                }
                return flag;
            }
        }
        return false;
    }
}
