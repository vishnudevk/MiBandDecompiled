// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

// Referenced classes of package com.xiaomi.channel.openauth:
//            APP2SDKReceiver

public class SDK2APPReceiver extends BroadcastReceiver
{

    public static String AUTH_ACTION_NAME = "com.xiaomi.openauth.action.SDK2APP";

    public SDK2APPReceiver()
    {
    }

    private String a(String s)
    {
        String s1 = null;
        String as[] = s.split(";");
        int i = as.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return s1;
            }
            String as1[] = as[j].split("=");
            if (as1.length == 2 && as1[0].trim().equals("userId"))
            {
                s1 = as1[1].trim();
            }
            j++;
        } while (true);
    }

    public void onReceive(Context context, Intent intent)
    {
        CookieSyncManager.createInstance(context);
        String s = CookieManager.getInstance().getCookie("https://account.xiaomi.com");
        if (!TextUtils.isEmpty(s) && s.contains("userId=") && s.contains("passToken="))
        {
            String s1 = intent.getStringExtra("user_id");
            if (TextUtils.isEmpty(s1) || s1.equals(a(s)))
            {
                Intent intent1 = new Intent(APP2SDKReceiver.AUTH_ACTION_NAME);
                intent1.putExtra("pkg", context.getPackageName());
                context.sendBroadcast(intent1);
            }
        }
    }

}
