// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import org.json.JSONObject;

public abstract class bp
{

    protected static String b = "POST";
    protected static String c = "GET";
    protected String d;

    public bp(String s)
    {
        d = s;
    }

    public abstract JSONObject a();

    public void a(String s)
    {
        d = s;
    }

    public abstract String b();

    protected String c()
    {
        return b;
    }

    public String d()
    {
        return d;
    }

}
