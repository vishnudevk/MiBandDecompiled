// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item
{

    private Pattern a;
    private String b;
    private Pattern c;
    private long d;
    private Random e;

    public Item(String s, String s1, String s2, long l)
    {
        e = new Random();
        a = Pattern.compile(s);
        b = s1;
        c = Pattern.compile(s2);
        d = l;
    }

    public String getPolicy()
    {
        return b;
    }

    public boolean idMatches(String s)
    {
        return a.matcher(s).matches();
    }

    public boolean isDispatch(String s)
    {
        return d >= (long)(1 + e.nextInt(100)) && c.matcher(s).matches();
    }
}
