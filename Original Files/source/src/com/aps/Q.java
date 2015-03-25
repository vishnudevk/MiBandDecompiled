// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.aps:
//            c, t, q, P

class Q extends DefaultHandler
{

    public c a;
    private String b;

    private Q()
    {
        a = new c();
        b = "";
    }

    Q(P p)
    {
        this();
    }

    public void characters(char ac[], int i, int j)
    {
        b = String.valueOf(ac, i, j);
    }

    public void endElement(String s, String s1, String s2)
    {
        if (s1.equals("retype"))
        {
            a.e(b);
        } else
        if (s1.equals("adcode"))
        {
            a.h(b);
        } else
        if (s1.equals("citycode"))
        {
            a.f(b);
        } else
        if (s1.equals("radius"))
        {
            try
            {
                a.a(Float.valueOf(b).floatValue());
            }
            catch (Throwable throwable5)
            {
                throwable5.printStackTrace();
                t.a(throwable5);
                a.a(3891F);
            }
        } else
        if (s1.equals("cenx"))
        {
            try
            {
                b = q.a(Double.valueOf(b), "#.000000");
                a.a(Double.valueOf(b).doubleValue());
            }
            catch (Throwable throwable4)
            {
                throwable4.printStackTrace();
                t.a(throwable4);
                a.a(0.0D);
            }
        } else
        if (s1.equals("ceny"))
        {
            try
            {
                b = q.a(Double.valueOf(b), "#.000000");
                a.b(Double.valueOf(b).doubleValue());
            }
            catch (Throwable throwable3)
            {
                throwable3.printStackTrace();
                t.a(throwable3);
                a.b(0.0D);
            }
        } else
        if (s1.equals("desc"))
        {
            a.g(b);
        } else
        if (s1.equals("country"))
        {
            a.i(b);
        } else
        if (s1.equals("province"))
        {
            a.j(b);
        } else
        if (s1.equals("city"))
        {
            a.k(b);
        } else
        if (s1.equals("road"))
        {
            a.l(b);
        } else
        if (s1.equals("street"))
        {
            a.m(b);
        } else
        if (s1.equals("poiname"))
        {
            a.n(b);
        } else
        if (s1.equals("BIZ"))
        {
            if (a.m() == null)
            {
                a.a(new JSONObject());
            }
            try
            {
                a.m().put("BIZ", b);
            }
            catch (Throwable throwable2)
            {
                throwable2.printStackTrace();
            }
        } else
        {
label0:
            {
                if (!s1.equals("flr"))
                {
                    break label0;
                }
                a.b(b);
            }
        }
_L5:
        if (a.m() == null)
        {
            a.a(new JSONObject());
        }
        if (!s1.equals("eab")) goto _L2; else goto _L1
_L1:
        a.m().put(s1, b);
_L9:
        return;
        if (!s1.equals("pid")) goto _L4; else goto _L3
_L3:
        a.a(b);
          goto _L5
_L4:
        if (!s1.equals("apiTime")) goto _L5; else goto _L6
_L6:
        if ("".equals(b)) goto _L5; else goto _L7
_L7:
        long l = Long.parseLong(b);
        a.a(l);
          goto _L5
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        t.a(throwable);
        a.a(t.a());
          goto _L5
_L2:
        try
        {
            if (s1.equals("ctl"))
            {
                a.m().put(s1, b);
                return;
            }
        }
        catch (Throwable throwable1)
        {
            throwable1.printStackTrace();
            return;
        }
        if (s1.equals("suc"))
        {
            a.m().put(s1, b);
            return;
        }
        if (!s1.equals("spa")) goto _L9; else goto _L8
_L8:
        a.m().put(s1, b);
        return;
          goto _L5
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
    {
        b = "";
    }
}
