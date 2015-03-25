// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            GalaxyCredentials

public interface Signer
{

    public abstract void sign(BasicGalaxyRequest basicgalaxyrequest, GalaxyCredentials galaxycredentials);
}
