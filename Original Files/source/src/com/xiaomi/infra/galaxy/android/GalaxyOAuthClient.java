// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.http.BasicGalaxyOAuthClient;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.model.GSonMarshaller;

// Referenced classes of package com.xiaomi.infra.galaxy.android:
//            GalaxyServiceProxy

public final class GalaxyOAuthClient extends BasicGalaxyOAuthClient
{

    public GalaxyOAuthClient(ClientConfiguration clientconfiguration)
    {
        super(clientconfiguration, new GalaxyServiceProxy(clientconfiguration), GSonMarshaller.getInstance());
    }

    private GalaxyOAuthClient(String s)
    {
        super(new GalaxyServiceProxy((new ClientConfiguration(false)).withAppId(s)), GSonMarshaller.getInstance());
    }

    public static GalaxyOAuthClient createInstance(String s)
    {
        GalaxyOAuthClient galaxyoauthclient;
        try
        {
            galaxyoauthclient = new GalaxyOAuthClient(s);
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            return null;
        }
        return galaxyoauthclient;
    }
}
