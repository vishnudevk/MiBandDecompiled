// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.util.StringUtils;

public final class Operator extends Enum
{

    private static final Operator $VALUES[];
    public static final Operator AND;
    public static final Operator OR;
    private String value;

    private Operator(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static Operator fromValue(String s)
    {
        if (StringUtils.isBlank(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("AND".equals(s))
        {
            return AND;
        }
        if ("OR".equals(s))
        {
            return OR;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static Operator valueOf(String s)
    {
        return (Operator)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/Operator, s);
    }

    public static Operator[] values()
    {
        return (Operator[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        AND = new Operator("AND", 0, "AND");
        OR = new Operator("OR", 1, "OR");
        Operator aoperator[] = new Operator[2];
        aoperator[0] = AND;
        aoperator[1] = OR;
        $VALUES = aoperator;
    }
}
