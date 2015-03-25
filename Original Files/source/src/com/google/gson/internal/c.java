// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class c
    implements Serializable, WildcardType
{

    private static final long serialVersionUID;
    private final Type a;
    private final Type b;

    public c(Type atype[], Type atype1[])
    {
        boolean flag = true;
        super();
        boolean flag1;
        boolean flag2;
        if (atype1.length <= flag)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        .Gson.Preconditions.checkArgument(flag1);
        if (atype.length == flag)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        .Gson.Preconditions.checkArgument(flag2);
        if (atype1.length == flag)
        {
            .Gson.Preconditions.checkNotNull(atype1[0]);
            .Gson.Types.a(atype1[0]);
            if (atype[0] != java/lang/Object)
            {
                flag = false;
            }
            .Gson.Preconditions.checkArgument(flag);
            b = .Gson.Types.canonicalize(atype1[0]);
            a = java/lang/Object;
            return;
        } else
        {
            .Gson.Preconditions.checkNotNull(atype[0]);
            .Gson.Types.a(atype[0]);
            b = null;
            a = .Gson.Types.canonicalize(atype[0]);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof WildcardType) && .Gson.Types.equals(this, (WildcardType)obj);
    }

    public Type[] getLowerBounds()
    {
        if (b != null)
        {
            Type atype[] = new Type[1];
            atype[0] = b;
            return atype;
        } else
        {
            return .Gson.Types.a;
        }
    }

    public Type[] getUpperBounds()
    {
        Type atype[] = new Type[1];
        atype[0] = a;
        return atype;
    }

    public int hashCode()
    {
        int i;
        if (b != null)
        {
            i = 31 + b.hashCode();
        } else
        {
            i = 1;
        }
        return i ^ 31 + a.hashCode();
    }

    public String toString()
    {
        if (b != null)
        {
            return (new StringBuilder()).append("? super ").append(.Gson.Types.typeToString(b)).toString();
        }
        if (a == java/lang/Object)
        {
            return "?";
        } else
        {
            return (new StringBuilder()).append("? extends ").append(.Gson.Types.typeToString(a)).toString();
        }
    }
}
