// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.HashMap;
import java.util.Map;

public final class AttributeType extends Enum
{

    private static final AttributeType $VALUES[];
    public static final AttributeType BINARY;
    public static final AttributeType BOOL;
    public static final AttributeType DOUBLE;
    public static final AttributeType FLOAT;
    public static final AttributeType INT16;
    public static final AttributeType INT32;
    public static final AttributeType INT64;
    public static final AttributeType INT8;
    public static final AttributeType STRING;
    static final Map lookupMap;
    private String value;

    private AttributeType(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static AttributeType fromValue(String s)
    {
        AttributeType attributetype = (AttributeType)lookupMap.get(s);
        if (attributetype == null)
        {
            if (s == null || "".equals(s))
            {
                throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_BLANK);
            } else
            {
                throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_INVALID, s);
            }
        } else
        {
            return attributetype;
        }
    }

    public static AttributeType valueOf(String s)
    {
        return (AttributeType)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/AttributeType, s);
    }

    public static AttributeType[] values()
    {
        return (AttributeType[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        int i = 0;
        BOOL = new AttributeType("BOOL", 0, "BOOL");
        INT8 = new AttributeType("INT8", 1, "INT8");
        INT16 = new AttributeType("INT16", 2, "INT16");
        INT32 = new AttributeType("INT32", 3, "INT32");
        INT64 = new AttributeType("INT64", 4, "INT64");
        FLOAT = new AttributeType("FLOAT", 5, "FLOAT");
        DOUBLE = new AttributeType("DOUBLE", 6, "DOUBLE");
        STRING = new AttributeType("STRING", 7, "STRING");
        BINARY = new AttributeType("BINARY", 8, "BINARY");
        AttributeType aattributetype[] = new AttributeType[9];
        aattributetype[0] = BOOL;
        aattributetype[1] = INT8;
        aattributetype[2] = INT16;
        aattributetype[3] = INT32;
        aattributetype[4] = INT64;
        aattributetype[5] = FLOAT;
        aattributetype[6] = DOUBLE;
        aattributetype[7] = STRING;
        aattributetype[8] = BINARY;
        $VALUES = aattributetype;
        lookupMap = new HashMap();
        AttributeType aattributetype1[] = values();
        for (int j = aattributetype1.length; i < j; i++)
        {
            AttributeType attributetype = aattributetype1[i];
            if (lookupMap.containsKey(attributetype.value))
            {
                throw new RuntimeException("Duplicated enum value");
            }
            lookupMap.put(attributetype.value, attributetype);
        }

    }
}
