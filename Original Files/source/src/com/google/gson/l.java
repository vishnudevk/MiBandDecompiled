// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

// Referenced classes of package com.google.gson:
//            TypeAdapter

class l extends TypeAdapter
{

    private TypeAdapter a;

    l()
    {
    }

    public void a(TypeAdapter typeadapter)
    {
        if (a != null)
        {
            throw new AssertionError();
        } else
        {
            a = typeadapter;
            return;
        }
    }

    public Object read(JsonReader jsonreader)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.read(jsonreader);
        }
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.write(jsonwriter, obj);
            return;
        }
    }
}
