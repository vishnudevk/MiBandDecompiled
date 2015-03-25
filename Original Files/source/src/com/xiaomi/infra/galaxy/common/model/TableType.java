// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public final class TableType extends Enum
{

    private static final TableType $VALUES[];
    public static final TableType APP;
    public static final TableType USER;
    private String value;

    private TableType(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static TableType fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new GalaxyClientException(ReturnCode.TABLE_TYPE_IS_BLANK);
        }
        if ("USER".equals(s))
        {
            return USER;
        }
        if ("APP".equals(s))
        {
            return APP;
        } else
        {
            throw new GalaxyClientException(ReturnCode.TABLE_TYPE_IS_INVALID, s);
        }
    }

    public static TableType valueOf(String s)
    {
        return (TableType)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/TableType, s);
    }

    public static TableType[] values()
    {
        return (TableType[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        USER = new TableType("USER", 0, "USER");
        APP = new TableType("APP", 1, "APP");
        TableType atabletype[] = new TableType[2];
        atabletype[0] = USER;
        atabletype[1] = APP;
        $VALUES = atabletype;
    }
}
