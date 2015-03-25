// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import com.amap.api.location.core.AMapLocException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aps:
//            t

public class c
{

    private String a;
    private double b;
    private double c;
    private float d;
    private float e;
    private float f;
    private long g;
    private AMapLocException h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private JSONObject v;

    public c()
    {
        a = "";
        b = 0.0D;
        c = 0.0D;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        g = 0L;
        h = new AMapLocException();
        i = "new";
        j = "";
        k = "";
        l = "";
        m = "";
        n = "";
        o = "";
        p = "";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
        v = null;
    }

    public c(JSONObject jsonobject)
    {
        a = "";
        b = 0.0D;
        c = 0.0D;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        g = 0L;
        h = new AMapLocException();
        i = "new";
        j = "";
        k = "";
        l = "";
        m = "";
        n = "";
        o = "";
        p = "";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
        v = null;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        a = jsonobject.getString("provider");
        b = jsonobject.getDouble("lon");
        c = jsonobject.getDouble("lat");
        d = jsonobject.getLong("accuracy");
        e = jsonobject.getLong("speed");
        f = jsonobject.getLong("bearing");
        i = jsonobject.getString("type");
        j = jsonobject.getString("retype");
        k = jsonobject.getString("citycode");
        l = jsonobject.getString("desc");
        m = jsonobject.getString("adcode");
        n = jsonobject.getString("country");
        o = jsonobject.getString("province");
        p = jsonobject.getString("city");
        q = jsonobject.getString("road");
        s = jsonobject.getString("poiname");
        u = jsonobject.getString("floor");
        t = jsonobject.getString("poiid");
        g = jsonobject.getLong("time");
        return;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        com.aps.t.a(throwable);
        return;
    }

    public AMapLocException a()
    {
        return h;
    }

    public void a(double d1)
    {
        b = d1;
    }

    public void a(float f1)
    {
        d = f1;
    }

    public void a(long l1)
    {
        g = l1;
    }

    public void a(AMapLocException amaplocexception)
    {
        h = amaplocexception;
    }

    public void a(String s1)
    {
        t = s1;
    }

    public void a(JSONObject jsonobject)
    {
        v = jsonobject;
    }

    public String b()
    {
        return t;
    }

    public void b(double d1)
    {
        c = d1;
    }

    public void b(String s1)
    {
        u = s1;
    }

    public String c()
    {
        return u;
    }

    public void c(String s1)
    {
        a = s1;
    }

    public double d()
    {
        return b;
    }

    public void d(String s1)
    {
        i = s1;
    }

    public double e()
    {
        return c;
    }

    public void e(String s1)
    {
        j = s1;
    }

    public float f()
    {
        return d;
    }

    public void f(String s1)
    {
        k = s1;
    }

    public long g()
    {
        return g;
    }

    public void g(String s1)
    {
        l = s1;
    }

    public String h()
    {
        return i;
    }

    public void h(String s1)
    {
        m = s1;
    }

    public String i()
    {
        return j;
    }

    public void i(String s1)
    {
        n = s1;
    }

    public String j()
    {
        return k;
    }

    public void j(String s1)
    {
        o = s1;
    }

    public String k()
    {
        return l;
    }

    public void k(String s1)
    {
        p = s1;
    }

    public String l()
    {
        return m;
    }

    public void l(String s1)
    {
        q = s1;
    }

    public JSONObject m()
    {
        return v;
    }

    public void m(String s1)
    {
        r = s1;
    }

    public String n()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("provider", a);
            jsonobject.put("lon", b);
            jsonobject.put("lat", c);
            jsonobject.put("accuracy", d);
            jsonobject.put("speed", e);
            jsonobject.put("bearing", f);
            jsonobject.put("time", g);
            jsonobject.put("type", i);
            jsonobject.put("retype", j);
            jsonobject.put("citycode", k);
            jsonobject.put("desc", l);
            jsonobject.put("adcode", m);
            jsonobject.put("country", n);
            jsonobject.put("province", o);
            jsonobject.put("city", p);
            jsonobject.put("road", q);
            jsonobject.put("street", r);
            jsonobject.put("poiname", s);
            jsonobject.put("poiid", t);
            jsonobject.put("floor", u);
        }
        catch (JSONException jsonexception)
        {
            com.aps.t.a(jsonexception);
            jsonobject = null;
        }
        if (jsonobject == null)
        {
            return null;
        } else
        {
            return jsonobject.toString();
        }
    }

    public void n(String s1)
    {
        s = s1;
    }
}
