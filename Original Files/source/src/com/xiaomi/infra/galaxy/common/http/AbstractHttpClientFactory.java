// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import org.apache.http.client.HttpClient;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            ClientConfiguration

public abstract class AbstractHttpClientFactory
{

    public AbstractHttpClientFactory()
    {
    }

    public abstract HttpClient createHttpClient(ClientConfiguration clientconfiguration);
}
