// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;

// Referenced classes of package com.google.gson.internal.bind:
//            j, m, ReflectiveTypeAdapterFactory

class i extends j
{

    final TypeAdapter a;
    final Gson b;
    final TypeToken c;
    final Field d;
    final boolean e;
    final ReflectiveTypeAdapterFactory f;

    i(ReflectiveTypeAdapterFactory reflectivetypeadapterfactory, String s, boolean flag, boolean flag1, Gson gson, TypeToken typetoken, Field field, 
            boolean flag2)
    {
        f = reflectivetypeadapterfactory;
        b = gson;
        c = typetoken;
        d = field;
        e = flag2;
        super(s, flag, flag1);
        a = b.getAdapter(c);
    }

    void a(JsonReader jsonreader, Object obj)
    {
        Object obj1 = a.read(jsonreader);
        if (obj1 != null || !e)
        {
            d.set(obj, obj1);
        }
    }

    void a(JsonWriter jsonwriter, Object obj)
    {
        Object obj1 = d.get(obj);
        (new m(b, a, c.getType())).write(jsonwriter, obj1);
    }
}
