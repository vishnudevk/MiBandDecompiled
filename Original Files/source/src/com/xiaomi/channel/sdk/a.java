// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

// Referenced classes of package com.xiaomi.channel.sdk:
//            e, b, AccountManager

class a extends e
{

    final AccountManager a;
    private final Account f;
    private final String g;

    a(AccountManager accountmanager, Activity activity, Handler handler, AccountManagerCallback accountmanagercallback, Account account, String s)
    {
        a = accountmanager;
        f = account;
        g = s;
        super(accountmanager, activity, handler, accountmanagercallback);
    }

    static AccountManager a(a a1)
    {
        return a1.a;
    }

    static void a(a a1, Object obj)
    {
        a1.set(obj);
    }

    public void a()
    {
        (new Thread(new b(this, f, g))).run();
    }
}
