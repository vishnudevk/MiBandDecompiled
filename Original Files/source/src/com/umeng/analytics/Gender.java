// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import u.aly.ap;

// Referenced classes of package com.umeng.analytics:
//            h, i, j

public class Gender extends Enum
{

    public static final Gender Female;
    public static final Gender Male;
    public static final Gender Unknown;
    private static int a[];
    private static final Gender b[];
    public int value;

    private Gender(String s, int k, int l)
    {
        super(s, k);
        value = l;
    }

    Gender(String s, int k, int l, Gender gender)
    {
        this(s, k, l);
    }

    static int[] a()
    {
        int ai[] = a;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[values().length];
        try
        {
            ai1[Female.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[Male.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai1[Unknown.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        a = ai1;
        return ai1;
    }

    public static Gender getGender(int k)
    {
        switch (k)
        {
        default:
            return Unknown;

        case 1: // '\001'
            return Male;

        case 2: // '\002'
            return Female;
        }
    }

    public static ap transGender(Gender gender)
    {
        switch (a()[gender.ordinal()])
        {
        default:
            return ap.c;

        case 1: // '\001'
            return ap.a;

        case 2: // '\002'
            return ap.b;
        }
    }

    public static Gender valueOf(String s)
    {
        return (Gender)Enum.valueOf(com/umeng/analytics/Gender, s);
    }

    public static Gender[] values()
    {
        Gender agender[] = b;
        int k = agender.length;
        Gender agender1[] = new Gender[k];
        System.arraycopy(agender, 0, agender1, 0, k);
        return agender1;
    }

    public int value()
    {
        return value;
    }

    static 
    {
        Male = new h("Male", 0, 1);
        Female = new i("Female", 1, 2);
        Unknown = new j("Unknown", 2, 0);
        Gender agender[] = new Gender[3];
        agender[0] = Male;
        agender[1] = Female;
        agender[2] = Unknown;
        b = agender;
    }
}
