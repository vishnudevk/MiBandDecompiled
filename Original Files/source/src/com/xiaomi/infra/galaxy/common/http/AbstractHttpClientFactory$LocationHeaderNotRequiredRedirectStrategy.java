// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            AbstractHttpClientFactory

public final class this._cls0 extends DefaultRedirectStrategy
{

    final AbstractHttpClientFactory this$0;

    public boolean isRedirected(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (httpresponse.getFirstHeader("location") == null && i == 301)
        {
            return false;
        } else
        {
            return super.isRedirected(httprequest, httpresponse, httpcontext);
        }
    }

    public ()
    {
        this$0 = AbstractHttpClientFactory.this;
        super();
    }
}
