// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.android.http;

import com.xiaomi.infra.galaxy.common.Protocol;
import com.xiaomi.infra.galaxy.common.http.AbstractHttpClientFactory;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpAndroidClientFactory extends AbstractHttpClientFactory
{

    public HttpAndroidClientFactory()
    {
    }

    public HttpClient createHttpClient(ClientConfiguration clientconfiguration)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, clientconfiguration.getConnectionTimeout());
        HttpConnectionParams.setSoTimeout(basichttpparams, clientconfiguration.getSocketTimeout());
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, true);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        int i = clientconfiguration.getSocketBufferSizeHints()[0];
        int j = clientconfiguration.getSocketBufferSizeHints()[1];
        if (i > 0 || j > 0)
        {
            HttpConnectionParams.setSocketBufferSize(basichttpparams, Math.max(i, j));
        }
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (clientconfiguration.getProtocol() == Protocol.HTTPS)
        {
            schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        return new DefaultHttpClient(new SingleClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }
}
