// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public final class AttributeAction extends Enum
{

    private static final AttributeAction $VALUES[];
    public static final AttributeAction ADD;
    public static final AttributeAction DELETE;
    public static final AttributeAction PUT;
    private String value;

    private AttributeAction(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static AttributeAction fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("ADD".equals(s))
        {
            return ADD;
        }
        if ("PUT".equals(s))
        {
            return PUT;
        }
        if ("DELETE".equals(s))
        {
            return DELETE;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static AttributeAction valueOf(String s)
    {
        return (AttributeAction)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/AttributeAction, s);
    }

    public static AttributeAction[] values()
    {
        return (AttributeAction[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        ADD = new AttributeAction("ADD", 0, "ADD");
        PUT = new AttributeAction("PUT", 1, "PUT");
        DELETE = new AttributeAction("DELETE", 2, "DELETE");
        AttributeAction aattributeaction[] = new AttributeAction[3];
        aattributeaction[0] = ADD;
        aattributeaction[1] = PUT;
        aattributeaction[2] = DELETE;
        $VALUES = aattributeaction;
    }
}
