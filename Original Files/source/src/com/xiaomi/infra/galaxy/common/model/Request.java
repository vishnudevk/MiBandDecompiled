// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public abstract class Request
{

    public Request()
    {
    }

    public BasicGalaxyRequest getGalaxyRequest(String s, APILevel apilevel)
    {
        validate();
        return internalGetGalaxyRequest(s, apilevel);
    }

    protected abstract BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel);

    public void setRequestContent(BasicGalaxyRequest basicgalaxyrequest, String s)
    {
        basicgalaxyrequest.addHeader("Content-Type", "application/x-xiaomi-json-1.0");
        basicgalaxyrequest.setHttpMethod(HttpMethodName.POST);
        try
        {
            byte abyte0[] = s.getBytes("UTF-8");
            basicgalaxyrequest.setContent(new ByteArrayInputStream(abyte0));
            basicgalaxyrequest.addHeader("Content-Length", Integer.toString(abyte0.length));
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
    }

    public abstract void validate();
}
