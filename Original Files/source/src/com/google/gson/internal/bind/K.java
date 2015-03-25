// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class K extends TypeAdapter
{

    K()
    {
    }

    public Boolean a(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        if (jsonreader.peek() == JsonToken.STRING)
        {
            return Boolean.valueOf(Boolean.parseBoolean(jsonreader.nextString()));
        } else
        {
            return Boolean.valueOf(jsonreader.nextBoolean());
        }
    }

    public void a(JsonWriter jsonwriter, Boolean boolean1)
    {
        if (boolean1 == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            jsonwriter.value(boolean1.booleanValue());
            return;
        }
    }

    public Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        a(jsonwriter, (Boolean)obj);
    }
}
