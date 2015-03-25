// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

// Referenced classes of package com.google.gson.internal.bind:
//            TypeAdapters, f

public final class MapTypeAdapterFactory
    implements TypeAdapterFactory
{

    private final ConstructorConstructor a;
    private final boolean b;

    public MapTypeAdapterFactory(ConstructorConstructor constructorconstructor, boolean flag)
    {
        a = constructorconstructor;
        b = flag;
    }

    private TypeAdapter a(Gson gson, Type type)
    {
        if (type == Boolean.TYPE || type == java/lang/Boolean)
        {
            return TypeAdapters.BOOLEAN_AS_STRING;
        } else
        {
            return gson.getAdapter(TypeToken.get(type));
        }
    }

    static boolean a(MapTypeAdapterFactory maptypeadapterfactory)
    {
        return maptypeadapterfactory.b;
    }

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Type type = typetoken.getType();
        if (!java/util/Map.isAssignableFrom(typetoken.getRawType()))
        {
            return null;
        } else
        {
            Type atype[] = com.google.gson.internal..Gson.Types.getMapKeyAndValueTypes(type, com.google.gson.internal..Gson.Types.getRawType(type));
            TypeAdapter typeadapter = a(gson, atype[0]);
            TypeAdapter typeadapter1 = gson.getAdapter(TypeToken.get(atype[1]));
            com.google.gson.internal.ObjectConstructor objectconstructor = a.get(typetoken);
            return new f(this, gson, atype[0], typeadapter, atype[1], typeadapter1, objectconstructor);
        }
    }
}
