// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthService;

class e
    implements ServiceConnection
{

    private final Context a;
    private final Account b;
    private final Bundle c;

    e(Context context, Account account, Bundle bundle)
    {
        a = context;
        b = account;
        c = bundle;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        com.xiaomi.account.IXiaomiAuthService.Stub.asInterface(ibinder).invalidateAccessToken(b, c);
        a.unbindService(this);
        return;
        SecurityException securityexception;
        securityexception;
        miui.net.IXiaomiAuthService ixiaomiauthservice = miui.net.IXiaomiAuthService.Stub.asInterface(ibinder);
        ixiaomiauthservice.invalidateAccessToken(b, c);
_L2:
        a.unbindService(this);
        return;
        Exception exception2;
        exception2;
        Log.e("XiaomiAuthUtil", "miui.net.IXiaomiAuthService invalidateAccessToken ", exception2);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
        a.unbindService(this);
        throw exception1;
        Exception exception;
        exception;
        Log.e("XiaomiAuthUtil", "com.xiaomi.account.IXiaomiAuthService invalidateAccessToken ", exception);
        a.unbindService(this);
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
