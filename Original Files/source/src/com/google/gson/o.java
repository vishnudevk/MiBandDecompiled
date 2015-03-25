// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

// Referenced classes of package com.google.gson:
//            TypeAdapter, Gson, q, JsonElement, 
//            JsonDeserializer, JsonSerializer, TypeAdapterFactory, p

final class o extends TypeAdapter
{

    private final JsonSerializer a;
    private final JsonDeserializer b;
    private final Gson c;
    private final TypeToken d;
    private final TypeAdapterFactory e;
    private TypeAdapter f;

    private o(JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Gson gson, TypeToken typetoken, TypeAdapterFactory typeadapterfactory)
    {
        a = jsonserializer;
        b = jsondeserializer;
        c = gson;
        d = typetoken;
        e = typeadapterfactory;
    }

    o(JsonSerializer jsonserializer, JsonDeserializer jsondeserializer, Gson gson, TypeToken typetoken, TypeAdapterFactory typeadapterfactory, p p)
    {
        this(jsonserializer, jsondeserializer, gson, typetoken, typeadapterfactory);
    }

    private TypeAdapter a()
    {
        TypeAdapter typeadapter = f;
        if (typeadapter != null)
        {
            return typeadapter;
        } else
        {
            TypeAdapter typeadapter1 = c.getDelegateAdapter(e, d);
            f = typeadapter1;
            return typeadapter1;
        }
    }

    public static TypeAdapterFactory a(TypeToken typetoken, Object obj)
    {
        return new q(obj, typetoken, false, null, null);
    }

    public static TypeAdapterFactory a(Class class1, Object obj)
    {
        return new q(obj, null, false, class1, null);
    }

    public static TypeAdapterFactory b(TypeToken typetoken, Object obj)
    {
        boolean flag;
        if (typetoken.getType() == typetoken.getRawType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new q(obj, typetoken, flag, null, null);
    }

    public Object read(JsonReader jsonreader)
    {
        if (b == null)
        {
            return a().read(jsonreader);
        }
        JsonElement jsonelement = Streams.parse(jsonreader);
        if (jsonelement.isJsonNull())
        {
            return null;
        } else
        {
            return b.deserialize(jsonelement, d.getType(), c.b);
        }
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        if (a == null)
        {
            a().write(jsonwriter, obj);
            return;
        }
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            Streams.write(a.serialize(obj, d.getType(), c.c), jsonwriter);
            return;
        }
    }
}
