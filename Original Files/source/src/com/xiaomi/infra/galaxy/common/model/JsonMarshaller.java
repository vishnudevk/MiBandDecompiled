// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            GalaxyMarshaller

public class JsonMarshaller
    implements GalaxyMarshaller
{

    private static final JsonMarshaller marshaller = new JsonMarshaller();
    private ObjectMapper mapper;

    private JsonMarshaller()
    {
        mapper = new ObjectMapper();
        mapper.configure(org.codehaus.jackson.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.getSerializationConfig().setSerializationInclusion(org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL);
        mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonMarshaller getInstance()
    {
        return marshaller;
    }

    public String marshall(Object obj)
    {
        String s;
        try
        {
            s = mapper.writeValueAsString(obj);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return s;
    }

    public byte[] marshallBytes(Object obj)
    {
        byte abyte0[];
        try
        {
            abyte0 = mapper.writeValueAsBytes(obj);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return abyte0;
    }

    public Object unmarshall(Class class1, String s)
    {
        Object obj;
        try
        {
            obj = mapper.readValue(s, class1);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return obj;
    }

}
