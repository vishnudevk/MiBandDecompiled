// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

public class PreemtiveAuthorizationHttpRequestInterceptor
    implements HttpRequestInterceptor
{

    public PreemtiveAuthorizationHttpRequestInterceptor()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        AuthState authstate = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        CredentialsProvider credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
        HttpHost httphost = (HttpHost)httpcontext.getAttribute("http.target_host");
        if (authstate.getAuthScheme() == null)
        {
            org.apache.http.auth.Credentials credentials = credentialsprovider.getCredentials(new AuthScope(httphost.getHostName(), httphost.getPort()));
            if (credentials != null)
            {
                authstate.setAuthScheme(new BasicScheme());
                authstate.setCredentials(credentials);
            }
        }
    }
}
