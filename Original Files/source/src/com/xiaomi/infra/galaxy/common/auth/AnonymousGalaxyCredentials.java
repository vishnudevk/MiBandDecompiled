// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;


// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            GalaxyCredentials

public class AnonymousGalaxyCredentials
    implements GalaxyCredentials
{

    private String galaxyAppId;

    public AnonymousGalaxyCredentials(String s)
    {
        galaxyAppId = s;
    }

    public String getGalaxyAppId()
    {
        return galaxyAppId;
    }

    public String getGalaxySecretKey()
    {
        return null;
    }
}
