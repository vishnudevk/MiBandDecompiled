// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public final class Comparator extends Enum
{

    private static final Comparator $VALUES[];
    public static final Comparator EQ;
    public static final Comparator GE;
    public static final Comparator GT;
    public static final Comparator LE;
    public static final Comparator LT;
    public static final Comparator NE;
    private String value;

    private Comparator(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static Comparator fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("EQ".equals(s))
        {
            return EQ;
        }
        if ("NE".equals(s))
        {
            return NE;
        }
        if ("GT".equals(s))
        {
            return GT;
        }
        if ("GE".equals(s))
        {
            return GE;
        }
        if ("LT".equals(s))
        {
            return LT;
        }
        if ("LE".equals(s))
        {
            return LE;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static Comparator valueOf(String s)
    {
        return (Comparator)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/Comparator, s);
    }

    public static Comparator[] values()
    {
        return (Comparator[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        EQ = new Comparator("EQ", 0, "EQ");
        NE = new Comparator("NE", 1, "NE");
        GT = new Comparator("GT", 2, "GT");
        GE = new Comparator("GE", 3, "GE");
        LT = new Comparator("LT", 4, "LT");
        LE = new Comparator("LE", 5, "LE");
        Comparator acomparator[] = new Comparator[6];
        acomparator[0] = EQ;
        acomparator[1] = NE;
        acomparator[2] = GT;
        acomparator[3] = GE;
        acomparator[4] = LT;
        acomparator[5] = LE;
        $VALUES = acomparator;
    }
}
