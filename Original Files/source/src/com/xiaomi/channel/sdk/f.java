// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.os.Bundle;
import java.util.concurrent.Callable;

// Referenced classes of package com.xiaomi.channel.sdk:
//            AccountManager

class f
    implements Callable
{

    private final AccountManager a;

    f(AccountManager accountmanager)
    {
        a = accountmanager;
        super();
    }

    public Bundle a()
    {
        throw new IllegalStateException("this should never be called");
    }

    public Object call()
    {
        return a();
    }
}
