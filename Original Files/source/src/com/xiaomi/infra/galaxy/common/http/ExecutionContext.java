// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.auth.GalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.Signer;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;

public class ExecutionContext
{

    private String contextUserAgent;
    private GalaxyCredentials credentials;
    private GalaxyMarshaller marshaller;
    private Signer signer;

    public ExecutionContext()
    {
    }

    public String getContextUserAgent()
    {
        return contextUserAgent;
    }

    public GalaxyCredentials getCredentials()
    {
        return credentials;
    }

    public GalaxyMarshaller getMarshaller()
    {
        return marshaller;
    }

    public Signer getSigner()
    {
        return signer;
    }

    public void setContextUserAgent(String s)
    {
        contextUserAgent = s;
    }

    public void setCredentials(GalaxyCredentials galaxycredentials)
    {
        credentials = galaxycredentials;
    }

    public void setMarshaller(GalaxyMarshaller galaxymarshaller)
    {
        marshaller = galaxymarshaller;
    }

    public void setSigner(Signer signer1)
    {
        signer = signer1;
    }
}
