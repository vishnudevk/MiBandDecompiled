// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

// Referenced classes of package com.xiaomi.auth:
//            f, c, d, b, 
//            e, a

public class XiaomiAuthUtil
{

    private static final String a = "XiaomiAuthUtil";

    public XiaomiAuthUtil()
    {
    }

    private static void a(Context context)
    {
        Looper looper = Looper.myLooper();
        if (looper != null && looper == context.getMainLooper())
        {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        } else
        {
            return;
        }
    }

    public static Bundle getAccessToken(Context context, Account account, Bundle bundle)
    {
        f f1;
        c c1;
        a(context);
        f1 = new f();
        c1 = new c(account, bundle, f1);
        if (!context.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), c1, 1))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        Bundle bundle2 = (Bundle)f1.get();
        context.unbindService(c1);
        return bundle2;
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
        context.unbindService(c1);
        return null;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        context.unbindService(c1);
        return null;
        Exception exception;
        exception;
        context.unbindService(c1);
        throw exception;
        Bundle bundle1 = new Bundle();
        bundle1.putInt("extra_error_code", -1000);
        bundle1.putString("extra_error_description", "cannot connect to auth service");
        context.unbindService(c1);
        return bundle1;
    }

    public static Bundle getSNSInfo(Context context, Account account, Bundle bundle)
    {
        f f1;
        d d1;
        a(context);
        f1 = new f();
        d1 = new d(account, bundle, f1);
        if (!context.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), d1, 1))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        Bundle bundle2 = (Bundle)f1.get();
        context.unbindService(d1);
        return bundle2;
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
        context.unbindService(d1);
        return null;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        context.unbindService(d1);
        return null;
        Exception exception;
        exception;
        context.unbindService(d1);
        throw exception;
        Bundle bundle1 = new Bundle();
        bundle1.putInt("extra_error_code", -1000);
        bundle1.putString("extra_error_description", "cannot connect to auth service");
        context.unbindService(d1);
        return bundle1;
    }

    public static Bundle getXiaomiUserInfo(Context context, Account account, Bundle bundle)
    {
        f f1;
        b b1;
        a(context);
        f1 = new f();
        b1 = new b(account, bundle, f1);
        if (!context.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), b1, 1))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        Bundle bundle2 = (Bundle)f1.get();
        context.unbindService(b1);
        return bundle2;
        InterruptedException interruptedexception;
        interruptedexception;
        Thread.currentThread().interrupt();
        context.unbindService(b1);
        return null;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        context.unbindService(b1);
        return null;
        Exception exception;
        exception;
        context.unbindService(b1);
        throw exception;
        Bundle bundle1 = new Bundle();
        bundle1.putInt("extra_error_code", -1000);
        bundle1.putString("extra_error_description", "cannot connect to auth service");
        context.unbindService(b1);
        return bundle1;
    }

    public static boolean invalidateAccessToken(Context context, Account account, Bundle bundle)
    {
        e e1 = new e(context, account, bundle);
        return context.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), e1, 1);
    }

    public static boolean isServiceSupport(Context context)
    {
        Intent intent;
        a a1;
        intent = new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE");
        a1 = new a();
        boolean flag = context.bindService(intent, a1, 1);
        if (flag)
        {
            context.unbindService(a1);
            return true;
        } else
        {
            context.unbindService(a1);
            return false;
        }
        Exception exception;
        exception;
        context.unbindService(a1);
        throw exception;
    }
}
