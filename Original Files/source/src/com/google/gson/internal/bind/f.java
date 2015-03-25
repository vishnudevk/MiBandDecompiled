// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.gson.internal.bind:
//            m, MapTypeAdapterFactory

final class f extends TypeAdapter
{

    final MapTypeAdapterFactory a;
    private final TypeAdapter b;
    private final TypeAdapter c;
    private final ObjectConstructor d;

    public f(MapTypeAdapterFactory maptypeadapterfactory, Gson gson, Type type, TypeAdapter typeadapter, Type type1, TypeAdapter typeadapter1, ObjectConstructor objectconstructor)
    {
        a = maptypeadapterfactory;
        super();
        b = new m(gson, typeadapter, type);
        c = new m(gson, typeadapter1, type1);
        d = objectconstructor;
    }

    private String a(JsonElement jsonelement)
    {
        if (jsonelement.isJsonPrimitive())
        {
            JsonPrimitive jsonprimitive = jsonelement.getAsJsonPrimitive();
            if (jsonprimitive.isNumber())
            {
                return String.valueOf(jsonprimitive.getAsNumber());
            }
            if (jsonprimitive.isBoolean())
            {
                return Boolean.toString(jsonprimitive.getAsBoolean());
            }
            if (jsonprimitive.isString())
            {
                return jsonprimitive.getAsString();
            } else
            {
                throw new AssertionError();
            }
        }
        if (jsonelement.isJsonNull())
        {
            return "null";
        } else
        {
            throw new AssertionError();
        }
    }

    public Map a(JsonReader jsonreader)
    {
        JsonToken jsontoken = jsonreader.peek();
        if (jsontoken == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        Map map = (Map)d.construct();
        if (jsontoken == JsonToken.BEGIN_ARRAY)
        {
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); jsonreader.endArray())
            {
                jsonreader.beginArray();
                Object obj1 = b.read(jsonreader);
                if (map.put(obj1, c.read(jsonreader)) != null)
                {
                    throw new JsonSyntaxException((new StringBuilder()).append("duplicate key: ").append(obj1).toString());
                }
            }

            jsonreader.endArray();
            return map;
        }
        jsonreader.beginObject();
        while (jsonreader.hasNext()) 
        {
            JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonreader);
            Object obj = b.read(jsonreader);
            if (map.put(obj, c.read(jsonreader)) != null)
            {
                throw new JsonSyntaxException((new StringBuilder()).append("duplicate key: ").append(obj).toString());
            }
        }
        jsonreader.endObject();
        return map;
    }

    public void a(JsonWriter jsonwriter, Map map)
    {
        int i = 0;
        if (map == null)
        {
            jsonwriter.nullValue();
            return;
        }
        if (!MapTypeAdapterFactory.a(a))
        {
            jsonwriter.beginObject();
            java.util.Map.Entry entry1;
            for (Iterator iterator1 = map.entrySet().iterator(); iterator1.hasNext(); c.write(jsonwriter, entry1.getValue()))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
                jsonwriter.name(String.valueOf(entry1.getKey()));
            }

            jsonwriter.endObject();
            return;
        }
        ArrayList arraylist = new ArrayList(map.size());
        ArrayList arraylist1 = new ArrayList(map.size());
        Iterator iterator = map.entrySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            JsonElement jsonelement = b.toJsonTree(entry.getKey());
            arraylist.add(jsonelement);
            arraylist1.add(entry.getValue());
            boolean flag1;
            if (jsonelement.isJsonArray() || jsonelement.isJsonObject())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1 | flag;
        }
        if (flag)
        {
            jsonwriter.beginArray();
            for (; i < arraylist.size(); i++)
            {
                jsonwriter.beginArray();
                Streams.write((JsonElement)arraylist.get(i), jsonwriter);
                c.write(jsonwriter, arraylist1.get(i));
                jsonwriter.endArray();
            }

            jsonwriter.endArray();
            return;
        }
        jsonwriter.beginObject();
        for (; i < arraylist.size(); i++)
        {
            jsonwriter.name(a((JsonElement)arraylist.get(i)));
            c.write(jsonwriter, arraylist1.get(i));
        }

        jsonwriter.endObject();
    }

    public Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        a(jsonwriter, (Map)obj);
    }
}
