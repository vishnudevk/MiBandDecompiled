// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

// Referenced classes of package com.google.gson.internal:
//            i, j, k, l, 
//            m, n, o, e, 
//            f, g, d, h, 
//            ObjectConstructor

public final class ConstructorConstructor
{

    private final Map a;

    public ConstructorConstructor(Map map)
    {
        a = map;
    }

    private ObjectConstructor a(Class class1)
    {
        i i1;
        try
        {
            Constructor constructor = class1.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible())
            {
                constructor.setAccessible(true);
            }
            i1 = new i(this, constructor);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return null;
        }
        return i1;
    }

    private ObjectConstructor a(Type type, Class class1)
    {
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                return new j(this);
            }
            if (java/util/EnumSet.isAssignableFrom(class1))
            {
                return new k(this, type);
            }
            if (java/util/Set.isAssignableFrom(class1))
            {
                return new l(this);
            }
            if (java/util/Queue.isAssignableFrom(class1))
            {
                return new m(this);
            } else
            {
                return new n(this);
            }
        }
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (java/util/SortedMap.isAssignableFrom(class1))
            {
                return new o(this);
            }
            if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(TypeToken.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType()))
            {
                return new e(this);
            } else
            {
                return new f(this);
            }
        } else
        {
            return null;
        }
    }

    private ObjectConstructor b(Type type, Class class1)
    {
        return new g(this, class1, type);
    }

    public ObjectConstructor get(TypeToken typetoken)
    {
        Type type = typetoken.getType();
        Class class1 = typetoken.getRawType();
        InstanceCreator instancecreator = (InstanceCreator)a.get(type);
        Object obj;
        if (instancecreator != null)
        {
            obj = new d(this, instancecreator, type);
        } else
        {
            InstanceCreator instancecreator1 = (InstanceCreator)a.get(class1);
            if (instancecreator1 != null)
            {
                return new h(this, instancecreator1, type);
            }
            obj = a(class1);
            if (obj == null)
            {
                obj = a(type, class1);
                if (obj == null)
                {
                    return b(type, class1);
                }
            }
        }
        return ((ObjectConstructor) (obj));
    }

    public String toString()
    {
        return a.toString();
    }
}
