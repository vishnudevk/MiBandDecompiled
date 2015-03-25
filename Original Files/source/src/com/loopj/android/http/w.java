// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class w extends DefaultRedirectHandler
{

    private static final String a = "http.protocol.redirect-locations";
    private final boolean b;

    public w(boolean flag)
    {
        b = flag;
    }

    public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        Header header = httpresponse.getFirstHeader("location");
        if (header == null)
        {
            throw new ProtocolException((new StringBuilder()).append("Received redirect response ").append(httpresponse.getStatusLine()).append(" but no location header").toString());
        }
        String s = header.getValue().replaceAll(" ", "%20");
        URI uri;
        HttpParams httpparams;
        try
        {
            uri = new URI(s);
        }
        catch (URISyntaxException urisyntaxexception2)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid redirect URI: ").append(s).toString(), urisyntaxexception2);
        }
        httpparams = httpresponse.getParams();
        URI uri1;
        if (!uri.isAbsolute())
        {
            if (httpparams.isParameterTrue("http.protocol.reject-relative-redirect"))
            {
                throw new ProtocolException((new StringBuilder()).append("Relative redirect location '").append(uri).append("' not allowed").toString());
            }
            HttpHost httphost = (HttpHost)httpcontext.getAttribute("http.target_host");
            if (httphost == null)
            {
                throw new IllegalStateException("Target host not available in the HTTP context");
            }
            HttpRequest httprequest = (HttpRequest)httpcontext.getAttribute("http.request");
            URI uri3;
            URI uri4;
            try
            {
                uri4 = URIUtils.resolve(URIUtils.rewriteURI(new URI(httprequest.getRequestLine().getUri()), httphost, true), uri);
            }
            catch (URISyntaxException urisyntaxexception1)
            {
                throw new ProtocolException(urisyntaxexception1.getMessage(), urisyntaxexception1);
            }
            uri1 = uri4;
        } else
        {
            uri1 = uri;
        }
        if (httpparams.isParameterFalse("http.protocol.allow-circular-redirects"))
        {
            RedirectLocations redirectlocations = (RedirectLocations)httpcontext.getAttribute("http.protocol.redirect-locations");
            if (redirectlocations == null)
            {
                redirectlocations = new RedirectLocations();
                httpcontext.setAttribute("http.protocol.redirect-locations", redirectlocations);
            }
            URI uri2;
            if (uri1.getFragment() != null)
            {
                try
                {
                    uri3 = URIUtils.rewriteURI(uri1, new HttpHost(uri1.getHost(), uri1.getPort(), uri1.getScheme()), true);
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    throw new ProtocolException(urisyntaxexception.getMessage(), urisyntaxexception);
                }
                uri2 = uri3;
            } else
            {
                uri2 = uri1;
            }
            if (redirectlocations.contains(uri2))
            {
                throw new CircularRedirectException((new StringBuilder()).append("Circular redirect to '").append(uri2).append("'").toString());
            }
            redirectlocations.add(uri2);
        }
        return uri1;
    }

    public boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        if (!b)
        {
            return false;
        }
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        switch (httpresponse.getStatusLine().getStatusCode())
        {
        case 304: 
        case 305: 
        case 306: 
        default:
            return false;

        case 301: 
        case 302: 
        case 303: 
        case 307: 
            return true;
        }
    }
}
