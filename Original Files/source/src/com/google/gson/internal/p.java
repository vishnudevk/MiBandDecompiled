// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

// Referenced classes of package com.google.gson.internal:
//            Excluder

class p extends TypeAdapter
{

    final boolean a;
    final boolean b;
    final Gson c;
    final TypeToken d;
    final Excluder e;
    private TypeAdapter f;

    p(Excluder excluder, boolean flag, boolean flag1, Gson gson, TypeToken typetoken)
    {
        e = excluder;
        a = flag;
        b = flag1;
        c = gson;
        d = typetoken;
        super();
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

    public Object read(JsonReader jsonreader)
    {
        if (a)
        {
            jsonreader.skipValue();
            return null;
        } else
        {
            return a().read(jsonreader);
        }
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        if (b)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            a().write(jsonwriter, obj);
            return;
        }
    }
}
