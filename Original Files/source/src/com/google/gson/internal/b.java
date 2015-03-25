// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class b
    implements Serializable, ParameterizedType
{

    private static final long serialVersionUID;
    private final Type a;
    private final Type b;
    private final Type c[];

    public transient b(Type type, Type type1, Type atype[])
    {
        boolean flag = true;
        int i = 0;
        super();
        Type type2;
        if (type1 instanceof Class)
        {
            Class class1 = (Class)type1;
            boolean flag1;
            if (type != null || class1.getEnclosingClass() == null)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            .Gson.Preconditions.checkArgument(flag1);
            if (type != null && class1.getEnclosingClass() == null)
            {
                flag = false;
            }
            .Gson.Preconditions.checkArgument(flag);
        }
        if (type == null)
        {
            type2 = null;
        } else
        {
            type2 = .Gson.Types.canonicalize(type);
        }
        a = type2;
        b = .Gson.Types.canonicalize(type1);
        for (c = (Type[])atype.clone(); i < c.length; i++)
        {
            .Gson.Preconditions.checkNotNull(c[i]);
            .Gson.Types.a(c[i]);
            c[i] = .Gson.Types.canonicalize(c[i]);
        }

    }

    public boolean equals(Object obj)
    {
        return (obj instanceof ParameterizedType) && .Gson.Types.equals(this, (ParameterizedType)obj);
    }

    public Type[] getActualTypeArguments()
    {
        return (Type[])c.clone();
    }

    public Type getOwnerType()
    {
        return a;
    }

    public Type getRawType()
    {
        return b;
    }

    public int hashCode()
    {
        return Arrays.hashCode(c) ^ b.hashCode() ^ .Gson.Types.a(a);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(30 * (1 + c.length));
        stringbuilder.append(.Gson.Types.typeToString(b));
        if (c.length == 0)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append("<").append(.Gson.Types.typeToString(c[0]));
        for (int i = 1; i < c.length; i++)
        {
            stringbuilder.append(", ").append(.Gson.Types.typeToString(c[i]));
        }

        return stringbuilder.append(">").toString();
    }
}
