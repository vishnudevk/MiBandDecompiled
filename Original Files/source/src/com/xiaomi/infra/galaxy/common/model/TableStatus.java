// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public final class TableStatus extends Enum
{

    private static final TableStatus $VALUES[];
    public static final TableStatus CREATING;
    public static final TableStatus DISABLED;
    public static final TableStatus DISABLING;
    public static final TableStatus ENABLED;
    public static final TableStatus ENABLING;
    private String value;

    private TableStatus(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static TableStatus fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("CREATING".equals(s))
        {
            return CREATING;
        }
        if ("DISABLING".equals(s))
        {
            return DISABLING;
        }
        if ("ENABLING".equals(s))
        {
            return ENABLING;
        }
        if ("DISABLED".equals(s))
        {
            return DISABLED;
        }
        if ("ENABLED".equals(s))
        {
            return ENABLED;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static TableStatus valueOf(String s)
    {
        return (TableStatus)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/TableStatus, s);
    }

    public static TableStatus[] values()
    {
        return (TableStatus[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        CREATING = new TableStatus("CREATING", 0, "CREATING");
        DISABLING = new TableStatus("DISABLING", 1, "DISABLING");
        ENABLING = new TableStatus("ENABLING", 2, "ENABLING");
        DISABLED = new TableStatus("DISABLED", 3, "DISABLED");
        ENABLED = new TableStatus("ENABLED", 4, "ENABLED");
        TableStatus atablestatus[] = new TableStatus[5];
        atablestatus[0] = CREATING;
        atablestatus[1] = DISABLING;
        atablestatus[2] = ENABLING;
        atablestatus[3] = DISABLED;
        atablestatus[4] = ENABLED;
        $VALUES = atablestatus;
    }
}
