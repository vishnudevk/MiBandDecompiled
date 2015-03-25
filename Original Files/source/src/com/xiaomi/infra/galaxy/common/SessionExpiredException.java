// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.Result;

public class SessionExpiredException extends RuntimeException
{

    private static final long serialVersionUID = 1L;
    private String additionMessage;
    private ReturnCode returnCode;

    public SessionExpiredException(ReturnCode returncode)
    {
        returnCode = returncode;
    }

    public SessionExpiredException(ReturnCode returncode, String s)
    {
        super((new StringBuilder()).append(returncode.getResult().getCode()).append(":").append(returncode.getResult().getMessage()).append(",").append(s).toString());
        returnCode = returncode;
        additionMessage = s;
    }

    public SessionExpiredException(String s)
    {
        super(s);
    }

    public SessionExpiredException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public String getAdditionMessage()
    {
        return additionMessage;
    }

    public ReturnCode getReturnCode()
    {
        return returnCode;
    }
}
