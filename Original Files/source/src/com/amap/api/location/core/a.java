// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.content.Context;
import android.util.Log;
import com.aps.l;
import org.json.JSONObject;

public class a
{

    static String a = "";
    private static int b = -1;

    public a()
    {
    }

    public static int a()
    {
        return b;
    }

    public static boolean a(Context context)
    {
        com/amap/api/location/core/a;
        JVM INSTR monitorenter ;
        boolean flag = true;
        String s1;
        byte abyte0[] = c();
        String s = b();
        s1 = l.a().a(context, s, abyte0, "loc");
        if (s1 == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = a(s1);
        flag = flag1;
_L4:
        com/amap/api/location/core/a;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        b = 0;
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        b = 0;
        throwable.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean a(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        if (!jsonobject.has("status")) goto _L2; else goto _L1
_L1:
        int i = jsonobject.getInt("status");
        if (i != 1) goto _L4; else goto _L3
_L3:
        b = 1;
_L2:
        if (jsonobject.has("info"))
        {
            a = jsonobject.getString("info");
        }
        if (b == 0)
        {
            Log.i("AuthFailure", a);
        }
_L6:
        Exception exception;
        return b == 1;
_L4:
        if (i != 0) goto _L2; else goto _L5
_L5:
        b = 0;
          goto _L2
        exception;
        exception.printStackTrace();
        b = 0;
          goto _L6
    }

    private static String b()
    {
        return "http://restapi.amap.com/log/init";
    }

    private static byte[] c()
    {
        byte abyte0[];
        try
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append("resType=json&encode=UTF-8&ec=1");
            abyte0 = stringbuffer.toString().getBytes("UTF-8");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

}
