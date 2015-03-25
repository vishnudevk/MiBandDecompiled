// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.os.Bundle;

// Referenced classes of package com.xiaomi.channel.sdk:
//            c, AccountManager

class d
    implements Runnable
{

    final c a;
    private final Account b;
    private final String c;

    d(c c1, Account account, String s)
    {
        a = c1;
        b = account;
        c = s;
        super();
    }

    public void run()
    {
        Bundle bundle = new Bundle();
        bundle.putString("authtoken", AccountManager.a(com.xiaomi.channel.sdk.c.a(a), b.name, c));
        bundle.putString("authAccount", b.name);
        com.xiaomi.channel.sdk.c.a(a, bundle);
    }
}
