// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.aps.a;
import com.aps.b;
import com.aps.j;
import com.aps.k;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amap.api.location:
//            a, AMapLocation, j

public class c
    implements Runnable
{

    k a;
    private boolean b;
    private Thread c;
    private Context d;
    private long e;
    private com.amap.api.location.j f;
    private com.amap.api.location.a g;

    protected c(Context context, com.amap.api.location.j j1, com.amap.api.location.a a1)
    {
        JSONObject jsonobject;
        a = null;
        b = true;
        c = null;
        e = 2000L;
        g = a1;
        b = true;
        d = context;
        a = new a();
        com.amap.api.location.core.c.a(context);
        a.a(context, a1.a);
        a.a((new StringBuilder()).append("api_serverSDK_130905##S128DF1572465B890OE3F7A13167KLEI##").append(com.amap.api.location.core.c.b(context)).append(",").append(com.amap.api.location.core.c.b()).toString());
        jsonobject = new JSONObject();
        JSONObject jsonobject1;
        String s;
        jsonobject.put("key", com.amap.api.location.core.c.b(context));
        jsonobject.put("X-INFO", com.amap.api.location.core.c.a(context).b("loc"));
        jsonobject1 = new JSONObject();
        s = com.amap.api.location.core.c.a(context).c();
        jsonobject1.put("ex", com.aps.b.a(s.getBytes("UTF-8")));
_L1:
        jsonobject.put("X-BIZ", jsonobject1);
        jsonobject.put("User-Agent", "AMAP Location SDK Android 1.2.0");
_L2:
        a.a(jsonobject);
        f = j1;
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
          goto _L2
    }

    private AMapLocation a(com.aps.c c1)
    {
        AMapLocation amaplocation = new AMapLocation("");
        amaplocation.setProvider("lbs");
        amaplocation.setLatitude(c1.e());
        amaplocation.setLongitude(c1.d());
        amaplocation.setAccuracy(c1.f());
        amaplocation.setTime(c1.g());
        amaplocation.setPoiId(c1.b());
        amaplocation.setFloor(c1.c());
        amaplocation.setAMapException(c1.a());
        Bundle bundle = new Bundle();
        bundle.putString("citycode", c1.j());
        bundle.putString("desc", c1.k());
        bundle.putString("adcode", c1.l());
        amaplocation.setExtras(bundle);
        String s = c1.j();
        String s1 = c1.k();
        String s2 = c1.l();
        try
        {
            a(amaplocation, s, s2, s1);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return amaplocation;
        }
        return amaplocation;
    }

    private void a(AMapLocation amaplocation, String s, String s1, String s2)
    {
        String as[];
        as = s2.split(" ");
        amaplocation.setCityCode(s);
        amaplocation.setAdCode(s1);
        if (s.equals("") || !a(s)) goto _L2; else goto _L1
_L1:
        if (as.length > 2)
        {
            amaplocation.setCity(as[0]);
            amaplocation.setDistrict(as[1]);
            amaplocation.a(as[2]);
        }
        if (as.length > 3)
        {
            amaplocation.a((new StringBuilder()).append(as[2]).append(as[3]).toString());
        }
_L4:
        amaplocation.b(s2.replace(" ", ""));
        return;
_L2:
        if (as.length > 3)
        {
            amaplocation.setProvince(as[0]);
            amaplocation.setCity(as[1]);
            amaplocation.setDistrict(as[2]);
            amaplocation.a(as[3]);
        }
        if (as.length > 4)
        {
            amaplocation.a((new StringBuilder()).append(as[3]).append(as[4]).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean a(String s)
    {
        return s.endsWith("010") || s.endsWith("021") || s.endsWith("022") || s.endsWith("023");
    }

    private com.aps.c b()
    {
        com.aps.c c1 = c();
        if (c1 == null)
        {
            c1 = new com.aps.c();
            c1.a(new AMapLocException("\u672A\u77E5\u7684\u9519\u8BEF"));
        }
        return c1;
    }

    private com.aps.c c()
    {
        k k1;
        com.aps.c c2;
        com.aps.c c3;
        try
        {
            k1 = a;
        }
        catch (AMapLocException amaplocexception)
        {
            com.aps.c c1 = new com.aps.c();
            c1.a(amaplocexception);
            return c1;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        c2 = null;
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        c3 = a.a();
        c2 = c3;
        return c2;
    }

    private boolean d()
    {
        int i = System.currentTimeMillis() - g.d != 5L * e;
        boolean flag = false;
        if (i > 0)
        {
            g.c = false;
            flag = true;
        }
        return flag;
    }

    void a()
    {
        b = false;
        if (c != null)
        {
            c.interrupt();
        }
        a.b();
        a = null;
    }

    void a(long l)
    {
        if (l > e)
        {
            e = l;
        }
    }

    void a(PendingIntent pendingintent)
    {
        a.a(pendingintent);
    }

    void a(j j1, PendingIntent pendingintent)
    {
        a.a(j1, pendingintent);
    }

    void b(PendingIntent pendingintent)
    {
        a.b(pendingintent);
    }

    void b(j j1, PendingIntent pendingintent)
    {
        a.b(j1, pendingintent);
    }

    public void run()
    {
        Looper.prepare();
        c = Thread.currentThread();
_L6:
        if (!b || Thread.currentThread().isInterrupted()) goto _L2; else goto _L1
_L1:
        c = Thread.currentThread();
        if (g.c && !d()) goto _L4; else goto _L3
_L3:
        boolean flag = g.e;
        if (flag) goto _L5; else goto _L4
_L4:
        Thread.sleep(e);
        if (true)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (g.e && (!g.c || d()))
        {
            Message message4 = new Message();
            message4.obj = null;
            message4.what = 100;
            f.sendMessage(message4);
        }
        if (com.amap.api.location.core.a.a() == -1)
        {
            com.amap.api.location.core.a.a(d);
        }
        Throwable throwable1;
        Thread.sleep(e);
          goto _L6
_L2:
        return;
_L5:
        com.aps.c c1 = b();
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_551;
        }
        AMapLocation amaplocation = a(c1);
        Throwable throwable;
        Exception exception;
        Message message;
        Throwable throwable2;
        Message message1;
        Message message2;
        Throwable throwable3;
        Message message3;
        for (AMapLocation amaplocation1 = amaplocation; amaplocation1 == null; amaplocation1 = null)
        {
            break MISSING_BLOCK_LABEL_249;
        }

        if (g.e && (!g.c || d()))
        {
            message2 = new Message();
            message2.obj = amaplocation1;
            message2.what = 100;
            f.sendMessage(message2);
        }
        if (com.amap.api.location.core.a.a() == -1)
        {
            com.amap.api.location.core.a.a(d);
        }
        Thread.sleep(e);
          goto _L6
        throwable2;
        throwable2.printStackTrace();
        if (true)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        if (g.e && (!g.c || d()))
        {
            message1 = new Message();
            message1.obj = null;
            message1.what = 100;
            f.sendMessage(message1);
        }
        if (com.amap.api.location.core.a.a() == -1)
        {
            com.amap.api.location.core.a.a(d);
        }
        Thread.sleep(e);
          goto _L6
        exception;
        if (true)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        if (g.e && (!g.c || d()))
        {
            message = new Message();
            message.obj = null;
            message.what = 100;
            f.sendMessage(message);
        }
        if (com.amap.api.location.core.a.a() == -1)
        {
            com.amap.api.location.core.a.a(d);
        }
        Thread.sleep(e);
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return;
        throwable3;
        if (true)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        if (g.e && (!g.c || d()))
        {
            message3 = new Message();
            message3.obj = null;
            message3.what = 100;
            f.sendMessage(message3);
        }
        if (com.amap.api.location.core.a.a() == -1)
        {
            com.amap.api.location.core.a.a(d);
        }
        try
        {
            Thread.sleep(e);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
          goto _L2
    }
}
