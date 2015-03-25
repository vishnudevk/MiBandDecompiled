// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

public class TargetAction
{

    private static final String REGULAR_UNDERSCORE = "[_]";
    private static final String UNDERSCORE = "_";
    private String apiVersion;
    private APILevel level;
    private Operation operation;
    private String serviceName;

    public TargetAction()
    {
    }

    public TargetAction(String s)
    {
        if (!StringUtils.isBlank(s));
        String as[] = s.split("[_]");
        if (as.length == 4);
        serviceName = as[0];
        apiVersion = as[1];
        level = APILevel.fromValue(as[2]);
        operation = Operation.fromValue(as[3]);
        if (level == APILevel.User && operation != Operation.Batch && operation != Operation.Get && operation != Operation.Set && operation != Operation.Scan)
        {
            if (operation == Operation.Delete);
        }
    }

    public String format()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(serviceName).append("_").append(apiVersion).append("_").append(level.name()).append("_").append(operation.name());
        return stringbuilder.toString();
    }

    public String getApiVersion()
    {
        return apiVersion;
    }

    public APILevel getLevel()
    {
        return level;
    }

    public Operation getOperation()
    {
        return operation;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setApiVersion(String s)
    {
        apiVersion = s;
    }

    public void setLevel(APILevel apilevel)
    {
        level = apilevel;
    }

    public void setOperation(Operation operation1)
    {
        operation = operation1;
    }

    public void setServiceName(String s)
    {
        serviceName = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(serviceName).append("_").append(apiVersion).append("_").append(level.name()).append("_").append(operation.name());
        return stringbuilder.toString();
    }

    public void withAPILevel(String s)
    {
        level = APILevel.fromValue(s);
    }

    public void withOperation(String s)
    {
        operation = Operation.fromValue(s);
    }
}
