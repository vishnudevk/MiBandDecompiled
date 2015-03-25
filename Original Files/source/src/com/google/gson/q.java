// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.reflect.TypeToken;

// Referenced classes of package com.google.gson:
//            TypeAdapterFactory, JsonSerializer, JsonDeserializer, o, 
//            p, Gson, TypeAdapter

class q
    implements TypeAdapterFactory
{

    private final TypeToken a;
    private final boolean b;
    private final Class c;
    private final JsonSerializer d;
    private final JsonDeserializer e;

    private q(Object obj, TypeToken typetoken, boolean flag, Class class1)
    {
        JsonSerializer jsonserializer;
        JsonDeserializer jsondeserializer;
        boolean flag1;
        if (obj instanceof JsonSerializer)
        {
            jsonserializer = (JsonSerializer)obj;
        } else
        {
            jsonserializer = null;
        }
        d = jsonserializer;
        if (obj instanceof JsonDeserializer)
        {
            jsondeserializer = (JsonDeserializer)obj;
        } else
        {
            jsondeserializer = null;
        }
        e = jsondeserializer;
        if (d != null || e != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        com.google.gson.internal..Gson.Preconditions.checkArgument(flag1);
        a = typetoken;
        b = flag;
        c = class1;
    }

    q(Object obj, TypeToken typetoken, boolean flag, Class class1, p p)
    {
        this(obj, typetoken, flag, class1);
    }

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        boolean flag;
        if (a != null)
        {
            if (a.equals(typetoken) || b && a.getType() == typetoken.getRawType())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = c.isAssignableFrom(typetoken.getRawType());
        }
        if (flag)
        {
            return new o(d, e, gson, typetoken, this, null);
        } else
        {
            return null;
        }
    }
}
