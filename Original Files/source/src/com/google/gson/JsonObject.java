// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.gson:
//            JsonElement, JsonNull, JsonPrimitive, JsonArray

public final class JsonObject extends JsonElement
{

    private final LinkedTreeMap a = new LinkedTreeMap();

    public JsonObject()
    {
    }

    private JsonElement a(Object obj)
    {
        if (obj == null)
        {
            return JsonNull.INSTANCE;
        } else
        {
            return new JsonPrimitive(obj);
        }
    }

    JsonObject a()
    {
        JsonObject jsonobject = new JsonObject();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); jsonobject.add((String)entry.getKey(), ((JsonElement)entry.getValue()).b()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return jsonobject;
    }

    public void add(String s, JsonElement jsonelement)
    {
        if (jsonelement == null)
        {
            jsonelement = JsonNull.INSTANCE;
        }
        a.put(s, jsonelement);
    }

    public void addProperty(String s, Boolean boolean1)
    {
        add(s, a(boolean1));
    }

    public void addProperty(String s, Character character)
    {
        add(s, a(character));
    }

    public void addProperty(String s, Number number)
    {
        add(s, a(number));
    }

    public void addProperty(String s, String s1)
    {
        add(s, a(s1));
    }

    JsonElement b()
    {
        return a();
    }

    public Set entrySet()
    {
        return a.entrySet();
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof JsonObject) && ((JsonObject)obj).a.equals(a);
    }

    public JsonElement get(String s)
    {
        return (JsonElement)a.get(s);
    }

    public JsonArray getAsJsonArray(String s)
    {
        return (JsonArray)a.get(s);
    }

    public JsonObject getAsJsonObject(String s)
    {
        return (JsonObject)a.get(s);
    }

    public JsonPrimitive getAsJsonPrimitive(String s)
    {
        return (JsonPrimitive)a.get(s);
    }

    public boolean has(String s)
    {
        return a.containsKey(s);
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public JsonElement remove(String s)
    {
        return (JsonElement)a.remove(s);
    }
}
