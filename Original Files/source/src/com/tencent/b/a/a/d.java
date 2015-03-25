// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.a.a;

import com.tencent.b.b.q;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tencent.b.a.a:
//            c

public class d
{

    private long A;
    public int a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public ArrayList w;
    public boolean x;
    public int y;
    public int z;

    public d()
    {
        a = 1;
        b = 0.0D;
        c = 0.0D;
        d = -1D;
        e = 0.0D;
        f = 0.0D;
        g = 0.0D;
        h = 0;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = false;
        y = 0;
        z = -1;
        A = -1L;
        e = 0.0D;
        d = 0.0D;
        c = 0.0D;
        b = 0.0D;
        p = null;
        o = null;
        n = null;
        m = null;
        x = false;
        A = System.currentTimeMillis();
        y = 0;
        z = -1;
        w = null;
    }

    public d(d d1)
    {
        a = 1;
        b = 0.0D;
        c = 0.0D;
        d = -1D;
        e = 0.0D;
        f = 0.0D;
        g = 0.0D;
        h = 0;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = false;
        y = 0;
        z = -1;
        A = -1L;
        a = d1.a;
        b = d1.b;
        c = d1.c;
        d = d1.d;
        e = d1.e;
        x = d1.x;
        i = d1.i;
        h = 0;
        j = d1.j;
        k = d1.k;
        l = d1.l;
        m = d1.m;
        n = d1.n;
        o = d1.o;
        p = d1.p;
        q = d1.q;
        r = d1.r;
        s = d1.s;
        t = d1.t;
        u = d1.u;
        v = d1.v;
        A = d1.a();
        y = d1.y;
        z = d1.z;
        w = null;
        if (d1.w != null)
        {
            w = new ArrayList();
            c c1;
            for (Iterator iterator = d1.w.iterator(); iterator.hasNext(); w.add(c1))
            {
                c1 = (c)iterator.next();
            }

        }
    }

    public long a()
    {
        return A;
    }

    public void a(String s1)
    {
        l = "Unknown";
        k = "Unknown";
        j = "Unknown";
        i = "Unknown";
        if (s1 != null) goto _L2; else goto _L1
_L1:
        String as[];
        return;
_L2:
        if ((as = s1.split(",")) == null) goto _L1; else goto _L3
_L3:
        int i1;
        i1 = as.length;
        if (i1 > 0)
        {
            i = as[0];
        }
        if (i1 > 1)
        {
            j = as[1];
        }
        if (i1 != 3) goto _L5; else goto _L4
_L4:
        k = as[1];
_L7:
        if (i1 == 3)
        {
            l = as[2];
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (i1 > 3)
        {
            k = as[2];
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (i1 <= 3) goto _L1; else goto _L8
_L8:
        l = as[3];
        return;
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append(z).append(" ").append(y).append(" ");
        String s1;
        StringBuilder stringbuilder2;
        String s2;
        if (x)
        {
            s1 = "Mars";
        } else
        {
            s1 = "WGS84";
        }
        stringbuilder2 = stringbuilder1.append(s1).append(" ");
        if (a == 0)
        {
            s2 = "GPS";
        } else
        {
            s2 = "Network";
        }
        stringbuilder2.append(s2).append("\n");
        stringbuilder.append(b).append(" ").append(c).append("\n");
        stringbuilder.append(d).append(" ").append(e).append("\n");
        stringbuilder.append(f).append(" ").append(g).append("\n");
        if (z == 3 || z == 4)
        {
            stringbuilder.append(i).append(" ").append(j).append(" ").append(k).append(" ").append(l).append(" ").append(m).append(" ").append(n).append(" ").append(o).append(" ").append(p).append("\n");
        }
        if (z == 4 && w != null)
        {
            stringbuilder.append(w.size()).append("\n");
            c c1;
            for (Iterator iterator = w.iterator(); iterator.hasNext(); stringbuilder.append(c1.a).append(",").append(c1.b).append(",").append(c1.c).append(",").append(c1.d).append(",").append(c1.e).append(",").append(c1.f).append("\n"))
            {
                c1 = (c)iterator.next();
            }

        }
        if (z != 7) goto _L2; else goto _L1
_L1:
        if (h != 0) goto _L4; else goto _L3
_L3:
        stringbuilder.append(i).append(" ").append(j).append(" ").append(k).append(" ").append(l).append(" ").append(m).append(" ").append(n).append(" ").append(o).append(" ").append(p).append("\n");
_L2:
        com.tencent.b.b.q.a(stringbuilder.toString());
        return stringbuilder.toString();
_L4:
        if (h == 1)
        {
            stringbuilder.append(i).append(" ").append(q).append(" ").append(r).append(" ").append(s).append(" ").append(t).append(" ").append(u).append(" ").append(v).append("\n");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
