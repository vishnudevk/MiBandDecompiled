// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import u.aly.bi;
import u.aly.bj;
import u.aly.bv;

public final class g
{

    private static g a = new g();
    private static Context b;
    private static String c;
    private static long d = 0L;
    private static long e = 0L;
    private static final String f = "age";
    private static final String g = "sex";
    private static final String h = "id";
    private static final String i = "url";
    private static final String j = "mobclick_agent_user_";
    private static final String k = "mobclick_agent_online_setting_";
    private static final String l = "mobclick_agent_header_";
    private static final String m = "mobclick_agent_update_";
    private static final String n = "mobclick_agent_state_";
    private static final String o = "mobclick_agent_cached_";
    private static final String p = "mobclick_agent_sealed_";

    public g()
    {
    }

    public static g a(Context context)
    {
        if (b == null)
        {
            b = context.getApplicationContext();
        }
        if (c == null)
        {
            c = context.getPackageName();
        }
        return a;
    }

    private static boolean a(File file)
    {
        long l1 = file.length();
        return file.exists() && l1 > e;
    }

    private SharedPreferences k()
    {
        return b.getSharedPreferences((new StringBuilder("mobclick_agent_user_")).append(c).toString(), 0);
    }

    private String l()
    {
        return (new StringBuilder("mobclick_agent_header_")).append(c).toString();
    }

    private String m()
    {
        return (new StringBuilder("mobclick_agent_cached_")).append(c).append(bi.c(b)).toString();
    }

    private String n()
    {
        return (new StringBuilder("mobclick_agent_sealed_")).append(c).toString();
    }

    public void a(int i1, int j1)
    {
        android.content.SharedPreferences.Editor editor = a(b).g().edit();
        editor.putInt("umeng_net_report_policy", i1);
        editor.putLong("umeng_net_report_interval", j1);
        editor.commit();
    }

    public void a(String s, String s1, int i1, int j1)
    {
        android.content.SharedPreferences.Editor editor = k().edit();
        if (!TextUtils.isEmpty(s))
        {
            editor.putString("id", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            editor.putString("url", s1);
        }
        if (i1 > 0)
        {
            editor.putInt("age", i1);
        }
        editor.putInt("sex", j1);
        editor.commit();
    }

    public void a(byte abyte0[])
    {
        String s = m();
        try
        {
            bv.a(new File(b.getFilesDir(), s), abyte0);
            return;
        }
        catch (Exception exception)
        {
            bj.b("MobclickAgent", exception.getMessage());
        }
    }

    public int[] a()
    {
        SharedPreferences sharedpreferences = g();
        int ai[] = new int[2];
        if (sharedpreferences.getInt("umeng_net_report_policy", -1) != -1)
        {
            ai[0] = sharedpreferences.getInt("umeng_net_report_policy", 1);
            ai[1] = (int)sharedpreferences.getLong("umeng_net_report_interval", 0L);
            return ai;
        } else
        {
            ai[0] = sharedpreferences.getInt("umeng_local_report_policy", 1);
            ai[1] = (int)sharedpreferences.getLong("umeng_local_report_interval", 0L);
            return ai;
        }
    }

    public void b(byte abyte0[])
    {
        try
        {
            bv.a(new File(b.getFilesDir(), n()), abyte0);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public byte[] b()
    {
        String s;
        File file;
        s = m();
        file = new File(b.getFilesDir(), s);
        if (!a(file)) goto _L2; else goto _L1
_L1:
        file.delete();
_L4:
        return null;
_L2:
        if (!file.exists()) goto _L4; else goto _L3
_L3:
        java.io.FileInputStream fileinputstream1 = b.openFileInput(s);
        java.io.FileInputStream fileinputstream = fileinputstream1;
        byte abyte0[] = bv.b(fileinputstream);
        bv.c(fileinputstream);
        return abyte0;
        Exception exception2;
        exception2;
        fileinputstream = null;
_L8:
        exception2.printStackTrace();
        bv.c(fileinputstream);
        return null;
        Exception exception;
        exception;
        Exception exception1;
        fileinputstream = null;
        exception1 = exception;
_L6:
        bv.c(fileinputstream);
        throw exception1;
        exception1;
        if (true) goto _L6; else goto _L5
_L5:
        exception2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Object[] b(Context context)
    {
        SharedPreferences sharedpreferences = k();
        Object aobj[] = new Object[4];
        if (sharedpreferences.contains("id"))
        {
            aobj[0] = sharedpreferences.getString("id", null);
        }
        if (sharedpreferences.contains("url"))
        {
            aobj[1] = sharedpreferences.getString("url", null);
        }
        if (sharedpreferences.contains("age"))
        {
            aobj[2] = Integer.valueOf(sharedpreferences.getInt("age", -1));
        }
        if (sharedpreferences.contains("sex"))
        {
            aobj[3] = Integer.valueOf(sharedpreferences.getInt("sex", -1));
        }
        return aobj;
    }

    public void c()
    {
        b.deleteFile(l());
        b.deleteFile(m());
    }

    public byte[] d()
    {
        String s;
        File file;
        s = n();
        file = new File(b.getFilesDir(), s);
        long l1;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        l1 = file.length();
        if (l1 > 0L)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        return null;
        java.io.FileInputStream fileinputstream1 = b.openFileInput(s);
        java.io.FileInputStream fileinputstream = fileinputstream1;
        byte abyte0[] = bv.b(fileinputstream);
        bv.c(fileinputstream);
        Exception exception;
        return abyte0;
_L1:
        Exception exception2;
        try
        {
            bv.c(fileinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            file.delete();
            exception.printStackTrace();
        }
        return null;
        exception2;
        fileinputstream = null;
_L3:
        exception2.printStackTrace();
          goto _L1
_L2:
        Exception exception1;
        bv.c(fileinputstream);
        throw exception1;
        exception1;
          goto _L2
        exception2;
          goto _L3
        exception1;
        fileinputstream = null;
          goto _L2
    }

    public void e()
    {
        String s = n();
        boolean flag = b.deleteFile(s);
        bj.a("--->", (new StringBuilder("delete envelope:")).append(flag).toString());
    }

    public boolean f()
    {
        String s = n();
        File file = new File(b.getFilesDir(), s);
        return file.exists() && file.length() > 0L;
    }

    public SharedPreferences g()
    {
        return b.getSharedPreferences((new StringBuilder("mobclick_agent_online_setting_")).append(c).toString(), 0);
    }

    public SharedPreferences h()
    {
        return b.getSharedPreferences((new StringBuilder("mobclick_agent_header_")).append(c).toString(), 0);
    }

    public SharedPreferences i()
    {
        return b.getSharedPreferences((new StringBuilder("mobclick_agent_update_")).append(c).toString(), 0);
    }

    public SharedPreferences j()
    {
        return b.getSharedPreferences((new StringBuilder("mobclick_agent_state_")).append(c).toString(), 0);
    }

    static 
    {
        d = 0x48190800L;
        e = 0x200000L;
    }
}
