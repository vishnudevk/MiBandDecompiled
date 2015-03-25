// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            GalaxyHttpClient, ClientConfiguration, AbstractHttpClientFactory, ExecutionContext

public abstract class GalaxyServiceClient
{

    protected GalaxyHttpClient client;
    protected ClientConfiguration clientConfiguration;
    protected URI endpoint;

    public GalaxyServiceClient(ClientConfiguration clientconfiguration, AbstractHttpClientFactory abstracthttpclientfactory)
    {
        clientConfiguration = clientconfiguration;
        GalaxyHttpClient.setHttpClientFactory(abstracthttpclientfactory);
        client = new GalaxyHttpClient(clientconfiguration);
    }

    public Object execute(BasicGalaxyRequest basicgalaxyrequest, Class class1, ExecutionContext executioncontext)
    {
        basicgalaxyrequest.setEndpoint(endpoint);
        return client.execute(basicgalaxyrequest, class1, executioncontext);
    }

    public ClientConfiguration getConfiguration()
    {
        return clientConfiguration;
    }

    public URI getEndpoint()
    {
        return endpoint;
    }

    public void setConfiguration(ClientConfiguration clientconfiguration)
    {
        clientConfiguration = clientconfiguration;
        client = new GalaxyHttpClient(clientconfiguration);
    }

    public void setEndpoint(String s)
    {
        if (!s.contains("://"))
        {
            s = (new StringBuilder()).append(clientConfiguration.getProtocol().toString()).append("://").append(s).toString();
        }
        try
        {
            endpoint = new URI(s);
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalArgumentException(urisyntaxexception);
        }
    }

    public abstract void shutdown();
}
