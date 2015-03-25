// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import java.lang.reflect.Type;

// Referenced classes of package com.google.gson:
//            JsonSerializationContext, Gson, JsonElement

class h
    implements JsonSerializationContext
{

    final Gson a;

    h(Gson gson)
    {
        a = gson;
        super();
    }

    public JsonElement serialize(Object obj)
    {
        return a.toJsonTree(obj);
    }

    public JsonElement serialize(Object obj, Type type)
    {
        return a.toJsonTree(obj, type);
    }
}
