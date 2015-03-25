// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            e, AsyncHttpClient

class b
    implements HttpResponseInterceptor
{

    final AsyncHttpClient a;

    b(AsyncHttpClient asynchttpclient)
    {
        a = asynchttpclient;
        super();
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
    {
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity != null) goto _L2; else goto _L1
_L1:
        Header header;
        return;
_L2:
        if ((header = httpentity.getContentEncoding()) != null)
        {
            HeaderElement aheaderelement[] = header.getElements();
            int i = aheaderelement.length;
            int j = 0;
            while (j < i) 
            {
                if (aheaderelement[j].getName().equalsIgnoreCase("gzip"))
                {
                    httpresponse.setEntity(new e(httpentity));
                    return;
                }
                j++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
