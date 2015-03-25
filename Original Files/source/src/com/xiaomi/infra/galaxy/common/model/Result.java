// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public class Result
{

    public static final int SUCCESS = 1;
    protected int code;
    protected String message;

    public Result()
    {
        code = 1;
        message = "success";
    }

    public Result(int i, String s)
    {
        code = i;
        message = s;
    }

    public Result(Result result)
    {
        this(result.getCode(), result.getMessage());
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if (obj == null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        flag1 = obj instanceof Result;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        Result result;
        int i;
        int j;
        result = (Result)obj;
        i = result.getCode();
        j = getCode();
        flag = false;
        if (i != j) goto _L4; else goto _L6
_L6:
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (result.getMessage() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getMessage() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag4 = flag2 ^ flag3;
        flag = false;
        if (flag4) goto _L4; else goto _L7
_L7:
        if (result.getMessage() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = result.getMessage().equals(getMessage());
        flag = false;
        if (!flag5) goto _L4; else goto _L8
_L8:
        return true;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public int hashCode()
    {
        int i = 31 * (31 + getCode());
        int j;
        if (getMessage() == null)
        {
            j = 0;
        } else
        {
            j = getMessage().hashCode();
        }
        return j + i;
    }

    public void setCode(int i)
    {
        code = i;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setResult(Result result)
    {
        setCode(result.getCode());
        setMessage(result.getMessage());
    }
}
