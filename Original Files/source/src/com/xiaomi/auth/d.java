// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthService;

// Referenced classes of package com.xiaomi.auth:
//            f

class d
    implements ServiceConnection
{

    private final Account a;
    private final Bundle b;
    private final f c;

    d(Account account, Bundle bundle, f f1)
    {
        a = account;
        b = bundle;
        c = f1;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        Bundle bundle2 = com.xiaomi.account.IXiaomiAuthService.Stub.asInterface(ibinder).getSnsAccessToken(a, b);
        Bundle bundle = bundle2;
_L2:
        c.a(bundle);
        return;
        SecurityException securityexception;
        securityexception;
        miui.net.IXiaomiAuthService ixiaomiauthservice = miui.net.IXiaomiAuthService.Stub.asInterface(ibinder);
        Bundle bundle1;
        try
        {
            bundle1 = ixiaomiauthservice.getMiCloudAccessToken(a, b);
        }
        catch (Exception exception1)
        {
            Log.e("XiaomiAuthUtil", "miui.net.IXiaomiAuthService.getSNSInfo ", exception1);
            bundle = null;
            continue; /* Loop/switch isn't completed */
        }
        bundle = bundle1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Log.e("XiaomiAuthUtil", "com.xiaomi.account.IXiaomiAuthService.getSNSInfo ", exception);
        bundle = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
    }
}
