// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.android.http.HttpAndroidClientFactory;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.http.GalaxyHttpClient;
import com.xiaomi.infra.galaxy.common.http.GalaxyServiceClient;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

class GalaxyServiceProxy extends GalaxyServiceClient
{

    public GalaxyServiceProxy(ClientConfiguration clientconfiguration)
    {
        super(clientconfiguration, new HttpAndroidClientFactory());
        if (StringUtils.isBlank(clientconfiguration.getAppId()))
        {
            throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK, "galaxy appId is empty");
        }
        if (clientconfiguration.getMaxErrorRetry() > 3)
        {
            clientconfiguration.setMaxErrorRetry(3);
        }
        setEndpoint(clientconfiguration.getEndpoint());
    }

    public void setConfiguration(ClientConfiguration clientconfiguration)
    {
        clientConfiguration = clientconfiguration;
        client = new GalaxyHttpClient(clientconfiguration);
    }

    public void shutdown()
    {
        if (client.getKeepAliveHttpClient() != null)
        {
            client.shutdown();
        }
    }
}
