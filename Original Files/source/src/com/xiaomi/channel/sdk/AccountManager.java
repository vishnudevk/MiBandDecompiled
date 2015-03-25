// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.channel.sdk:
//            a, c

public class AccountManager
{

    public static final String KEY_ACCOUNT_NAME = "authAccount";
    public static final String KEY_AUTHTOKEN = "authtoken";
    private static final String a = "service_token_pref";
    private static AccountManager b;
    private Context c;

    public AccountManager(Context context)
    {
        c = context;
    }

    static String a(AccountManager accountmanager, String s, String s1)
    {
        return accountmanager.a(s, s1);
    }

    private String a(String s, String s1)
    {
        String s2 = b(s, s1);
        if (TextUtils.isEmpty(s2))
        {
            s2 = c(s, s1);
            if (!TextUtils.isEmpty(s2))
            {
                android.content.SharedPreferences.Editor editor = c.getSharedPreferences("service_token_pref", 0).edit();
                editor.putString((new StringBuilder(String.valueOf(s1))).append(s).toString(), s2);
                editor.commit();
            }
        }
        return s2;
    }

    private void a()
    {
        Looper looper = Looper.myLooper();
        if (looper != null && looper == c.getMainLooper())
        {
            IllegalStateException illegalstateexception = new IllegalStateException("calling this from your main thread can lead to deadlock");
            Log.e("miliao_sdk_log", "calling this from your main thread can lead to deadlock and/or ANRs", illegalstateexception);
            if (c.getApplicationInfo().targetSdkVersion >= 8)
            {
                throw illegalstateexception;
            }
        }
    }

    static void a(AccountManager accountmanager)
    {
        accountmanager.a();
    }

    private String b(String s, String s1)
    {
        return c.getSharedPreferences("service_token_pref", 0).getString((new StringBuilder(String.valueOf(s1))).append(s).toString(), null);
    }

    private String c(String s, String s1)
    {
        Cursor cursor;
        Uri uri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAuthToken");
        Log.v("miliao_sdk_log", "get auth token from miliao...");
        cursor = c.getContentResolver().query(uri, new String[] {
            "code", "token"
        }, null, new String[] {
            s, s1
        }, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        int i = cursor.getInt(0);
        i;
        JVM INSTR tableswitch 10001 10001: default 100
    //                   10001 135;
           goto _L2 _L4
_L2:
        String s2;
        s2 = null;
        if (cursor != null)
        {
            boolean flag = cursor.isClosed();
            s2 = null;
            if (!flag)
            {
                cursor.close();
            }
        }
_L5:
        return s2;
_L4:
        String s3 = cursor.getString(1);
        s2 = s3;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
            return s2;
        }
          goto _L5
        Exception exception1;
        exception1;
        Log.e("miliao_sdk_log", exception1.toString());
        s2 = null;
        if (cursor == null) goto _L5; else goto _L6
_L6:
        boolean flag1;
        flag1 = cursor.isClosed();
        s2 = null;
        if (flag1) goto _L5; else goto _L7
_L7:
        cursor.close();
        return null;
        Exception exception;
        exception;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw exception;
    }

    public static AccountManager get(Context context)
    {
        com/xiaomi/channel/sdk/AccountManager;
        JVM INSTR monitorenter ;
        AccountManager accountmanager;
        if (b == null)
        {
            b = new AccountManager(context);
        }
        accountmanager = b;
        com/xiaomi/channel/sdk/AccountManager;
        JVM INSTR monitorexit ;
        return accountmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public AccountManagerFuture addAccount(String s, String s1, String as[], Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        return null;
    }

    public Account[] getAccountsByType(String s)
    {
        Cursor cursor;
        Uri uri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAccount");
        cursor = c.getContentResolver().query(uri, new String[] {
            "code", "name"
        }, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        int i = cursor.getInt(0);
        i;
        JVM INSTR tableswitch 10001 10001: default 76
    //                   10001 104;
           goto _L2 _L4
_L2:
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
_L7:
        Account aaccount[] = new Account[0];
_L6:
        String s1;
        return aaccount;
_L4:
        if (TextUtils.isEmpty(s1 = cursor.getString(1))) goto _L2; else goto _L5
_L5:
        aaccount = new Account[1];
        aaccount[0] = new Account(s1, s);
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
            return aaccount;
        }
          goto _L6
        Exception exception1;
        exception1;
        Log.e("miliao_sdk_log", exception1.toString());
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
          goto _L7
        Exception exception;
        exception;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw exception;
    }

    public AccountManagerFuture getAuthToken(Account account, String s, Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        return (new a(this, null, handler, accountmanagercallback, account, s)).b();
    }

    public AccountManagerFuture getAuthToken(Account account, String s, Bundle bundle, boolean flag, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        return (new c(this, null, handler, accountmanagercallback, account, s)).b();
    }

    public void invalidateAuthToken(String s, String s1)
    {
        SharedPreferences sharedpreferences;
        Map map;
        sharedpreferences = c.getSharedPreferences("service_token_pref", 0);
        map = sharedpreferences.getAll();
        if (map == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = map.keySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        android.accounts.AccountManager.get(c).invalidateAuthToken(s, s1);
        return;
_L3:
        String s2 = (String)iterator.next();
        Object obj = map.get(s2);
        if (obj != null && (obj instanceof String) && ((String)obj).equals(s1))
        {
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove(s2);
            editor.commit();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }
}
