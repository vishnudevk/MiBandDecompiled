// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.util.Log;

public class a
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public a()
    {
        a = "";
        b = "";
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = "";
    }

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        a = (new StringBuilder()).append(s).append("").toString();
        b = (new StringBuilder()).append(s1).append("").toString();
        c = (new StringBuilder()).append(s2).append("").toString();
        d = (new StringBuilder()).append(s3).append("").toString();
        e = (new StringBuilder()).append(s4).append("").toString();
        f = (new StringBuilder()).append(s5).append("").toString();
        g = (new StringBuilder()).append(s6).append("").toString();
        h = s7;
        i = (new StringBuilder()).append(s8).append("").toString();
        Log.i("report_debug", (new StringBuilder()).append("reportItem apn=").append(a).append(",frequency=").append(b).append(",commandid=").append(c).append(",resultcode=").append(d).append("timecost").append(e).append(",reqsize=").append(f).append(",rspsize=").append(g).append(",deviceinfo=").append(h).append(",detail=").append(i).toString());
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public String f()
    {
        return g;
    }

    public String g()
    {
        return f;
    }

    public String h()
    {
        return i;
    }

    public String i()
    {
        return h;
    }
}
