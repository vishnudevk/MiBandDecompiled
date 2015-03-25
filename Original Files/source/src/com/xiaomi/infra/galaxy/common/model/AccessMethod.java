// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public final class AccessMethod extends Enum
{

    private static final AccessMethod $VALUES[];
    public static final AccessMethod AnonReadLoginWrite;
    public static final AccessMethod AnonReadOwnerWrite;
    public static final AccessMethod LoginReadLoginWrite;
    public static final AccessMethod LoginReadOwnerWrite;
    private String value;

    private AccessMethod(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static AccessMethod fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_BLANK, "access method is blank");
        }
        if ("AnonReadOwnerWrite".equals(s))
        {
            return AnonReadOwnerWrite;
        }
        if ("LoginReadOwnerWrite".equals(s))
        {
            return LoginReadOwnerWrite;
        }
        if ("AnonReadLoginWrite".equals(s))
        {
            return AnonReadLoginWrite;
        }
        if ("LoginReadLoginWrite".equals(s))
        {
            return LoginReadLoginWrite;
        } else
        {
            throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_INVALID, s);
        }
    }

    public static AccessMethod valueOf(String s)
    {
        return (AccessMethod)Enum.valueOf(com/xiaomi/infra/galaxy/common/model/AccessMethod, s);
    }

    public static AccessMethod[] values()
    {
        return (AccessMethod[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        AnonReadOwnerWrite = new AccessMethod("AnonReadOwnerWrite", 0, "AnonReadOwnerWrite");
        LoginReadOwnerWrite = new AccessMethod("LoginReadOwnerWrite", 1, "LoginReadOwnerWrite");
        AnonReadLoginWrite = new AccessMethod("AnonReadLoginWrite", 2, "AnonReadLoginWrite");
        LoginReadLoginWrite = new AccessMethod("LoginReadLoginWrite", 3, "LoginReadLoginWrite");
        AccessMethod aaccessmethod[] = new AccessMethod[4];
        aaccessmethod[0] = AnonReadOwnerWrite;
        aaccessmethod[1] = LoginReadOwnerWrite;
        aaccessmethod[2] = AnonReadLoginWrite;
        aaccessmethod[3] = LoginReadLoginWrite;
        $VALUES = aaccessmethod;
    }
}
