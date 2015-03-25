// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.constants;


public final class APILevel extends Enum
{

    private static final APILevel $VALUES[];
    public static final APILevel Developer;
    public static final APILevel User;
    private String value;

    private APILevel(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static APILevel fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("User".equals(s))
        {
            return User;
        }
        if ("Developer".equals(s))
        {
            return Developer;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static APILevel valueOf(String s)
    {
        return (APILevel)Enum.valueOf(com/xiaomi/infra/galaxy/common/constants/APILevel, s);
    }

    public static APILevel[] values()
    {
        return (APILevel[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        User = new APILevel("User", 0, "User");
        Developer = new APILevel("Developer", 1, "Developer");
        APILevel aapilevel[] = new APILevel[2];
        aapilevel[0] = User;
        aapilevel[1] = Developer;
        $VALUES = aapilevel;
    }
}
