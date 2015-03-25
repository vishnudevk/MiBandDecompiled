// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.google.gson.Gson;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            GalaxyMarshaller

public class GSonMarshaller
    implements GalaxyMarshaller
{

    private static final GSonMarshaller marshaller = new GSonMarshaller();

    public GSonMarshaller()
    {
    }

    public static GSonMarshaller getInstance()
    {
        return marshaller;
    }

    public String marshall(Object obj)
    {
        return (new Gson()).toJson(obj);
    }

    public Object unmarshall(Class class1, String s)
    {
        return (new Gson()).fromJson(s, class1);
    }

}
