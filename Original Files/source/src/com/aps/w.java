// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.util.List;

public final class w
{

    private boolean a;
    private String b;
    private boolean c;
    private double d;
    private double e;

    protected w(List list, String s, String s1, String s2)
    {
        a = false;
        b = "";
        c = false;
        d = 0.0D;
        e = 0.0D;
        b = s2;
        d();
    }

    private void d()
    {
        int i;
        String s;
        i = 0;
        s = b;
        if (s == null || s.length() <= 8) goto _L2; else goto _L1
_L1:
        int l;
        int k = 1;
        l = 0;
        for (; k < -3 + s.length(); k++)
        {
            l ^= s.charAt(k);
        }

        if (!Integer.toHexString(l).equalsIgnoreCase(s.substring(-2 + s.length(), s.length()))) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        if (flag)
        {
            String s1 = b.substring(0, -3 + b.length());
            int j = 0;
            for (; i < s1.length(); i++)
            {
                if (s1.charAt(i) == ',')
                {
                    j++;
                }
            }

            String as[] = s1.split(",", j + 1);
            if (as.length < 6)
            {
                return;
            }
            if (!as[2].equals("") && !as[-3 + as.length].equals("") && !as[-2 + as.length].equals("") && !as[-1 + as.length].equals(""))
            {
                Integer.valueOf(as[2]).intValue();
                d = Double.valueOf(as[-3 + as.length]).doubleValue();
                e = Double.valueOf(as[-2 + as.length]).doubleValue();
                c = true;
            }
        }
        a = c;
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final boolean a()
    {
        return a;
    }

    protected final double b()
    {
        return d;
    }

    protected final double c()
    {
        return e;
    }
}
