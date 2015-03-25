// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.Result;

public class GalaxyClientException extends Exception
{

    private static final long serialVersionUID = 1L;
    private String additionMessage;
    private ReturnCode returnCode;

    public GalaxyClientException(ReturnCode returncode)
    {
        returnCode = returncode;
    }

    public GalaxyClientException(ReturnCode returncode, String s)
    {
        super((new StringBuilder()).append(returncode.getResult().getCode()).append(":").append(returncode.getResult().getMessage()).append(",").append(s).toString());
        returnCode = returncode;
        additionMessage = s;
    }

    public GalaxyClientException(ReturnCode returncode, String s, Throwable throwable)
    {
        super((new StringBuilder()).append(returncode.getResult().getCode()).append(":").append(returncode.getResult().getMessage()).append(",").append(s).toString(), throwable);
        returnCode = returncode;
        additionMessage = s;
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
