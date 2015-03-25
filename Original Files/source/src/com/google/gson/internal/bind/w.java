// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URL;

final class w extends TypeAdapter
{

    w()
    {
    }

    public URL a(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
        } else
        {
            String s = jsonreader.nextString();
            if (!"null".equals(s))
            {
                return new URL(s);
            }
        }
        return null;
    }

    public void a(JsonWriter jsonwriter, URL url)
    {
        String s;
        if (url == null)
        {
            s = null;
        } else
        {
            s = url.toExternalForm();
        }
        jsonwriter.value(s);
    }

    public Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public void write(JsonWriter jsonwriter, Object obj)
    {
        a(jsonwriter, (URL)obj);
    }
}
