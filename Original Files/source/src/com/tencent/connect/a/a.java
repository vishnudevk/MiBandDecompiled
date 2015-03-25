// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.a;

import android.content.Context;
import android.util.Log;
import com.tencent.connect.auth.QQToken;
import com.tencent.stat.MtaSDkException;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatService;
import com.tencent.utils.OpenConfig;

public class a
{

    public a()
    {
    }

    public static transient void a(Context context, QQToken qqtoken, String s, String as[])
    {
        b(context, qqtoken);
        StatService.trackCustomEvent(context, s, as);
    }

    public static boolean a(Context context, QQToken qqtoken)
    {
        return OpenConfig.getInstance(context, qqtoken.getAppId()).getBoolean("Common_ta_enable");
    }

    public static void b(Context context, QQToken qqtoken)
    {
        if (a(context, qqtoken))
        {
            StatConfig.setEnableStatService(true);
            return;
        } else
        {
            StatConfig.setEnableStatService(false);
            return;
        }
    }

    public static void c(Context context, QQToken qqtoken)
    {
        b(context, qqtoken);
        String s = qqtoken.getAppId();
        String s1 = (new StringBuilder()).append("Aqc").append(s).toString();
        StatConfig.setAutoExceptionCaught(false);
        StatConfig.setEnableSmartReporting(true);
        StatConfig.setSendPeriodMinutes(1440);
        StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
        StatConfig.setStatReportUrl("http://cgi.connect.qq.com/qqconnectutil/sdk");
        try
        {
            StatService.startStatService(context, s1, "1.0.0");
            return;
        }
        catch (MtaSDkException mtasdkexception)
        {
            Log.e("DEBUG", "MTA init Failed.");
        }
    }

    public static void d(Context context, QQToken qqtoken)
    {
        b(context, qqtoken);
        if (qqtoken.getOpenId() != null)
        {
            StatService.reportQQ(context, qqtoken.getOpenId());
        }
    }
}
