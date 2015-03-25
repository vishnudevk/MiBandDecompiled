// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.Protocol;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.InputStream;

public class ClientConfiguration
{

    public static final int DEFAULT_MAX_CONNECTIONS = 50;
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final int DEFAULT_SOCKET_TIMEOUT = 50000;
    public static final String DEFAULT_USER_AGENT = GalaxyVersion.getUserAgent();
    private String appId;
    private int connectionTimeout;
    private String endpoint;
    private final boolean keepAlive;
    private int maxConnections;
    private int maxErrorRetry;
    private Protocol protocol;
    private String proxyDomain;
    private String proxyHost;
    private String proxyPassword;
    private int proxyPort;
    private String proxyUsername;
    private String proxyWorkstation;
    private int socketReceiveBufferSizeHint;
    private int socketSendBufferSizeHint;
    private int socketTimeout;
    private InputStream trustStore;
    private String trustStorePassword;
    private String userAgent;

    public ClientConfiguration(ClientConfiguration clientconfiguration, boolean flag)
    {
        userAgent = DEFAULT_USER_AGENT;
        maxErrorRetry = 3;
        protocol = Protocol.HTTPS;
        proxyHost = null;
        proxyPort = -1;
        proxyUsername = null;
        proxyPassword = null;
        proxyDomain = null;
        proxyWorkstation = null;
        maxConnections = 50;
        socketTimeout = 50000;
        connectionTimeout = 50000;
        socketSendBufferSizeHint = 0;
        socketReceiveBufferSizeHint = 0;
        endpoint = "https://sds.api.xiaomi.com";
        connectionTimeout = clientconfiguration.connectionTimeout;
        maxConnections = clientconfiguration.maxConnections;
        maxErrorRetry = clientconfiguration.maxErrorRetry;
        protocol = clientconfiguration.protocol;
        proxyDomain = clientconfiguration.proxyDomain;
        proxyHost = clientconfiguration.proxyHost;
        proxyPassword = clientconfiguration.proxyPassword;
        proxyPort = clientconfiguration.proxyPort;
        proxyUsername = clientconfiguration.proxyUsername;
        proxyWorkstation = clientconfiguration.proxyWorkstation;
        socketTimeout = clientconfiguration.socketTimeout;
        userAgent = clientconfiguration.userAgent;
        socketReceiveBufferSizeHint = clientconfiguration.socketReceiveBufferSizeHint;
        socketSendBufferSizeHint = clientconfiguration.socketSendBufferSizeHint;
        appId = clientconfiguration.appId;
        trustStore = clientconfiguration.trustStore;
        trustStorePassword = clientconfiguration.trustStorePassword;
        endpoint = clientconfiguration.endpoint;
        keepAlive = flag;
    }

    public ClientConfiguration(boolean flag)
    {
        userAgent = DEFAULT_USER_AGENT;
        maxErrorRetry = 3;
        protocol = Protocol.HTTPS;
        proxyHost = null;
        proxyPort = -1;
        proxyUsername = null;
        proxyPassword = null;
        proxyDomain = null;
        proxyWorkstation = null;
        maxConnections = 50;
        socketTimeout = 50000;
        connectionTimeout = 50000;
        socketSendBufferSizeHint = 0;
        socketReceiveBufferSizeHint = 0;
        endpoint = "https://sds.api.xiaomi.com";
        keepAlive = flag;
    }

    public String getAppId()
    {
        return appId;
    }

    public int getConnectionTimeout()
    {
        return connectionTimeout;
    }

    public String getEndpoint()
    {
        return endpoint;
    }

    public int getMaxConnections()
    {
        return maxConnections;
    }

    public int getMaxErrorRetry()
    {
        return maxErrorRetry;
    }

    public Protocol getProtocol()
    {
        return protocol;
    }

    public String getProxyDomain()
    {
        return proxyDomain;
    }

    public String getProxyHost()
    {
        return proxyHost;
    }

    public String getProxyPassword()
    {
        return proxyPassword;
    }

    public int getProxyPort()
    {
        return proxyPort;
    }

    public String getProxyUsername()
    {
        return proxyUsername;
    }

    public String getProxyWorkstation()
    {
        return proxyWorkstation;
    }

    public int[] getSocketBufferSizeHints()
    {
        int ai[] = new int[2];
        ai[0] = socketSendBufferSizeHint;
        ai[1] = socketReceiveBufferSizeHint;
        return ai;
    }

    public int getSocketTimeout()
    {
        return socketTimeout;
    }

    public InputStream getTrustStore()
    {
        return trustStore;
    }

    public String getTrustStorePassword()
    {
        return trustStorePassword;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public boolean isKeepAlive()
    {
        return keepAlive;
    }

    public void setAppId(String s)
    {
        appId = s;
    }

    public void setConnectionTimeout(int i)
    {
        connectionTimeout = i;
    }

    public void setEndpoint(String s)
    {
        endpoint = s;
        if (StringUtils.isNotBlank(s))
        {
            if (s.regionMatches(true, 0, "https://", 0, "https://".length()))
            {
                protocol = Protocol.HTTPS;
            }
            if (s.regionMatches(true, 0, "http://", 0, "http://".length()))
            {
                protocol = Protocol.HTTP;
            }
        }
    }

    public void setMaxConnections(int i)
    {
        maxConnections = i;
    }

    public void setMaxErrorRetry(int i)
    {
        maxErrorRetry = i;
    }

    public void setProtocol(Protocol protocol1)
    {
        if (StringUtils.isNotBlank(endpoint))
        {
            if (endpoint.regionMatches(true, 0, "https://", 0, "https://".length()))
            {
                protocol = Protocol.HTTPS;
                return;
            }
            if (endpoint.regionMatches(true, 0, "http://", 0, "http://".length()))
            {
                protocol = Protocol.HTTP;
                return;
            }
        }
        protocol = protocol1;
    }

    public void setProxyDomain(String s)
    {
        proxyDomain = s;
    }

    public void setProxyHost(String s)
    {
        proxyHost = s;
    }

    public void setProxyPassword(String s)
    {
        proxyPassword = s;
    }

    public void setProxyPort(int i)
    {
        proxyPort = i;
    }

    public void setProxyUsername(String s)
    {
        proxyUsername = s;
    }

    public void setProxyWorkstation(String s)
    {
        proxyWorkstation = s;
    }

    public void setSocketBufferSizeHints(int i, int j)
    {
        socketSendBufferSizeHint = i;
        socketReceiveBufferSizeHint = j;
    }

    public void setSocketTimeout(int i)
    {
        socketTimeout = i;
    }

    public void setTrustStore(InputStream inputstream)
    {
        trustStore = inputstream;
    }

    public void setTrustStorePassword(String s)
    {
        trustStorePassword = s;
    }

    public void setUserAgent(String s)
    {
        userAgent = s;
    }

    public ClientConfiguration withAppId(String s)
    {
        setAppId(s);
        return this;
    }

    public ClientConfiguration withConnectionTimeout(int i)
    {
        setConnectionTimeout(i);
        return this;
    }

    public ClientConfiguration withMaxConnections(int i)
    {
        setMaxConnections(i);
        return this;
    }

    public ClientConfiguration withMaxErrorRetry(int i)
    {
        setMaxErrorRetry(i);
        return this;
    }

    public ClientConfiguration withProtocol(Protocol protocol1)
    {
        setProtocol(protocol1);
        return this;
    }

    public ClientConfiguration withProxyDomain(String s)
    {
        setProxyDomain(s);
        return this;
    }

    public ClientConfiguration withProxyHost(String s)
    {
        setProxyHost(s);
        return this;
    }

    public ClientConfiguration withProxyPassword(String s)
    {
        setProxyPassword(s);
        return this;
    }

    public ClientConfiguration withProxyPort(int i)
    {
        setProxyPort(i);
        return this;
    }

    public ClientConfiguration withProxyUsername(String s)
    {
        setProxyUsername(s);
        return this;
    }

    public ClientConfiguration withProxyWorkstation(String s)
    {
        setProxyWorkstation(s);
        return this;
    }

    public ClientConfiguration withSocketBufferSizeHints(int i, int j)
    {
        setSocketBufferSizeHints(i, j);
        return this;
    }

    public ClientConfiguration withSocketTimeout(int i)
    {
        setSocketTimeout(i);
        return this;
    }

    public ClientConfiguration withUserAgent(String s)
    {
        setUserAgent(s);
        return this;
    }

}
