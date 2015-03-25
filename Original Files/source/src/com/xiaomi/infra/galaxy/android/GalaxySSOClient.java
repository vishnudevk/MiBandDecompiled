// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.http.BasicGalaxySSOClient;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.model.GSonMarshaller;

// Referenced classes of package com.xiaomi.infra.galaxy.android:
//            GalaxyServiceProxy

public final class GalaxySSOClient extends BasicGalaxySSOClient
{

    public GalaxySSOClient(ClientConfiguration clientconfiguration)
    {
        super(clientconfiguration, new GalaxyServiceProxy(clientconfiguration), GSonMarshaller.getInstance());
    }

    private GalaxySSOClient(String s)
    {
        super(new GalaxyServiceProxy((new ClientConfiguration(false)).withAppId(s)), GSonMarshaller.getInstance());
    }

    public static GalaxySSOClient createInstance(String s)
    {
        GalaxySSOClient galaxyssoclient;
        try
        {
            galaxyssoclient = new GalaxySSOClient(s);
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            return null;
        }
        return galaxyssoclient;
    }
}
