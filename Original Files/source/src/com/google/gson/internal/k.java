// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

// Referenced classes of package com.google.gson.internal:
//            ObjectConstructor, ConstructorConstructor

class k
    implements ObjectConstructor
{

    final Type a;
    final ConstructorConstructor b;

    k(ConstructorConstructor constructorconstructor, Type type)
    {
        b = constructorconstructor;
        a = type;
        super();
    }

    public Object construct()
    {
        if (a instanceof ParameterizedType)
        {
            Type type = ((ParameterizedType)a).getActualTypeArguments()[0];
            if (type instanceof Class)
            {
                return EnumSet.noneOf((Class)type);
            } else
            {
                throw new JsonIOException((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
            }
        } else
        {
            throw new JsonIOException((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
        }
    }
}
