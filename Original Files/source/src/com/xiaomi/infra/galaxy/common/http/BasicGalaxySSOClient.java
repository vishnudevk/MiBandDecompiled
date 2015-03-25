// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.auth.BasicGalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.MiSSOSigner;
import com.xiaomi.infra.galaxy.common.auth.MiSSOToken;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            GalaxyClient, GalaxyServiceClient, ClientConfiguration, ExecutionContext

public class BasicGalaxySSOClient extends GalaxyClient
{

    private MiSSOSigner miSSOSigner;
    private MiSSOToken ssoToken;

    public BasicGalaxySSOClient(ClientConfiguration clientconfiguration, GalaxyServiceClient galaxyserviceclient, GalaxyMarshaller galaxymarshaller)
    {
        super(clientconfiguration, galaxyserviceclient, galaxymarshaller);
        miSSOSigner = MiSSOSigner.getInstance();
    }

    public BasicGalaxySSOClient(GalaxyServiceClient galaxyserviceclient, GalaxyMarshaller galaxymarshaller)
    {
        ClientConfiguration clientconfiguration;
        if (galaxyserviceclient == null)
        {
            clientconfiguration = null;
        } else
        {
            clientconfiguration = galaxyserviceclient.getConfiguration();
        }
        this(clientconfiguration, galaxyserviceclient, galaxymarshaller);
    }

    protected Object invoke(BasicGalaxyRequest basicgalaxyrequest, Class class1)
    {
        basicgalaxyrequest.addHeader("X-XiaoMi-Appid", clientConfiguration.getAppId());
        ExecutionContext executioncontext = new ExecutionContext();
        executioncontext.setMarshaller(marshaller);
        if (ssoToken == null || StringUtils.isBlank(ssoToken.getUserId()) || StringUtils.isBlank(ssoToken.getServiceToken()))
        {
            basicgalaxyrequest.addHeader("X-XiaoMi-Access-Method", "anonymous");
        } else
        {
            BasicGalaxyCredentials basicgalaxycredentials = new BasicGalaxyCredentials("", ssoToken.getSecurity());
            executioncontext.setSigner(miSSOSigner);
            executioncontext.setCredentials(basicgalaxycredentials);
            basicgalaxyrequest.addHeader("X-XiaoMi-Access-Method", "misso");
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("userId=").append(ssoToken.getUserId()).append("; ");
            stringbuilder.append("serviceToken=").append(ssoToken.getServiceToken());
            basicgalaxyrequest.addHeader("Cookie", stringbuilder.toString());
        }
        return serviceClient.execute(basicgalaxyrequest, class1, executioncontext);
    }

    public void setSSOToken(MiSSOToken missotoken)
    {
        ssoToken = missotoken;
    }
}
