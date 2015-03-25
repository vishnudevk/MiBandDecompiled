// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public final class Action extends Enum
{

    private static final Action $VALUES[];
    public static final Action ADD;
    public static final Action PUT;
    private String value;

    private Action(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static Action fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new GalaxyClientException(ReturnCode.SET_ACTION_IS_BLANK);
        }
        if ("PUT".equals(s))
        {
            return PUT;
        }
        if ("ADD".equals(s))
        {
            return ADD;
        } else
        {
            throw new GalaxyClientException(ReturnCode.SET_ACTION_IS_INVALID, s);
        }
    }

    public static Action valueOf(String s)
    {
        return (Action)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/Action, s);
    }

    public static Action[] values()
    {
        return (Action[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        PUT = new Action("PUT", 0, "PUT");
        ADD = new Action("ADD", 1, "ADD");
        Action aaction[] = new Action[2];
        aaction[0] = PUT;
        aaction[1] = ADD;
        $VALUES = aaction;
    }
}
