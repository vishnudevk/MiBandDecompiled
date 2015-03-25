// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.model.Request;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.infra.galaxy.common:
//            HttpMethodName

public class BasicGalaxyRequest
{

    private InputStream content;
    private URI endpoint;
    private Map headers;
    private HttpMethodName httpMethod;
    private final Request originalRequest;
    private Map parameters;
    private String resourcePath;
    private String serviceName;
    private int timeOffset;

    public BasicGalaxyRequest()
    {
        this(null, "");
    }

    public BasicGalaxyRequest(Request request, String s)
    {
        parameters = new HashMap();
        headers = new HashMap();
        httpMethod = HttpMethodName.POST;
        serviceName = s;
        originalRequest = request;
    }

    public BasicGalaxyRequest(String s)
    {
        this(null, s);
    }

    public void addHeader(String s, String s1)
    {
        headers.put(s, s1);
    }

    public void addParameter(String s, String s1)
    {
        parameters.put(s, s1);
    }

    public InputStream getContent()
    {
        return content;
    }

    public URI getEndpoint()
    {
        return endpoint;
    }

    public Map getHeaders()
    {
        return headers;
    }

    public HttpMethodName getHttpMethod()
    {
        return httpMethod;
    }

    public Request getOriginalRequest()
    {
        return originalRequest;
    }

    public Map getParameters()
    {
        return parameters;
    }

    public String getResourcePath()
    {
        return resourcePath;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public int getTimeOffset()
    {
        return timeOffset;
    }

    public void setContent(InputStream inputstream)
    {
        content = inputstream;
    }

    public void setEndpoint(URI uri)
    {
        endpoint = uri;
    }

    public void setHeaders(Map map)
    {
        headers.clear();
        headers.putAll(map);
    }

    public void setHttpMethod(HttpMethodName httpmethodname)
    {
        httpMethod = httpmethodname;
    }

    public void setParameters(Map map)
    {
        parameters.clear();
        parameters.putAll(map);
    }

    public void setResourcePath(String s)
    {
        resourcePath = s;
    }

    public void setTimeOffset(int i)
    {
        timeOffset = i;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append(getHttpMethod().toString()).append(" ").toString());
        stringbuilder.append((new StringBuilder()).append(getEndpoint().toString()).append(" ").toString());
        StringBuilder stringbuilder1 = (new StringBuilder()).append("/");
        String s;
        if (getResourcePath() != null)
        {
            s = getResourcePath();
        } else
        {
            s = "";
        }
        stringbuilder.append(stringbuilder1.append(s).append(" ").toString());
        if (!getParameters().isEmpty())
        {
            stringbuilder.append("Parameters: (");
            String s3;
            String s4;
            for (Iterator iterator1 = getParameters().keySet().iterator(); iterator1.hasNext(); stringbuilder.append((new StringBuilder()).append(s3).append(": ").append(s4).append(", ").toString()))
            {
                s3 = (String)iterator1.next();
                s4 = (String)getParameters().get(s3);
            }

            stringbuilder.append(") ");
        }
        if (!getHeaders().isEmpty())
        {
            stringbuilder.append("Headers: (");
            String s1;
            String s2;
            for (Iterator iterator = getHeaders().keySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(s1).append(": ").append(s2).append(", ").toString()))
            {
                s1 = (String)iterator.next();
                s2 = (String)getHeaders().get(s1);
            }

            stringbuilder.append(") ");
        }
        return stringbuilder.toString();
    }

    public BasicGalaxyRequest withParameter(String s, String s1)
    {
        addParameter(s, s1);
        return this;
    }

    public BasicGalaxyRequest withTimeOffset(int i)
    {
        setTimeOffset(i);
        return this;
    }
}
