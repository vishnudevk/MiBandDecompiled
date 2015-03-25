// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.xiaomi.account.openauth:
//            c, AuthorizeHelper

public class XiaomiOAuthorize
{

    private static final String a = "code";
    private static final String b = "token";
    private static OnOAuthInterface c;
    private static ThreadPoolExecutor d;

    public XiaomiOAuthorize()
    {
    }

    static OnOAuthInterface a()
    {
        return c;
    }

    private static void a(Activity activity, long l, String s, String s1, Bundle bundle, int i)
    {
        android.accounts.Account aaccount[] = AccountManager.get(activity).getAccountsByType("com.xiaomi");
        if (aaccount.length > 0)
        {
            c c1 = new c(activity, l, s, s1, bundle, i, aaccount);
            d.execute(c1);
            return;
        } else
        {
            AuthorizeHelper.startAuthorizeActivityForResult(activity, l, s, s1, bundle.getString("scope"), bundle.getString("state"), i);
            return;
        }
    }

    public static void setOnOAuthInterface(OnOAuthInterface onoauthinterface)
    {
        c = onoauthinterface;
    }

    public static void startGetAccessToken(Activity activity, long l, String s, Bundle bundle, int i)
    {
        Bundle bundle1;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        } else
        {
            bundle1 = bundle;
        }
        a(activity, l, s, "token", bundle1, i);
    }

    public static void startGetOAuthCode(Activity activity, long l, String s, Bundle bundle, int i)
    {
        Bundle bundle1;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        } else
        {
            bundle1 = bundle;
        }
        a(activity, l, s, "code", bundle1, i);
    }

    static 
    {
        d = new ThreadPoolExecutor(1, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}
