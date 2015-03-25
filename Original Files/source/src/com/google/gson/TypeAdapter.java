// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

// Referenced classes of package com.google.gson:
//            JsonIOException, r, JsonElement

public abstract class TypeAdapter
{

    public TypeAdapter()
    {
    }

    public final Object fromJson(Reader reader)
    {
        return read(new JsonReader(reader));
    }

    public final Object fromJson(String s)
    {
        return fromJson(((Reader) (new StringReader(s))));
    }

    public final Object fromJsonTree(JsonElement jsonelement)
    {
        Object obj;
        try
        {
            obj = read(new JsonTreeReader(jsonelement));
        }
        catch (IOException ioexception)
        {
            throw new JsonIOException(ioexception);
        }
        return obj;
    }

    public final TypeAdapter nullSafe()
    {
        return new r(this);
    }

    public abstract Object read(JsonReader jsonreader);

    public final String toJson(Object obj)
    {
        StringWriter stringwriter = new StringWriter();
        toJson(((Writer) (stringwriter)), obj);
        return stringwriter.toString();
    }

    public final void toJson(Writer writer, Object obj)
    {
        write(new JsonWriter(writer), obj);
    }

    public final JsonElement toJsonTree(Object obj)
    {
        JsonElement jsonelement;
        try
        {
            JsonTreeWriter jsontreewriter = new JsonTreeWriter();
            write(jsontreewriter, obj);
            jsonelement = jsontreewriter.get();
        }
        catch (IOException ioexception)
        {
            throw new JsonIOException(ioexception);
        }
        return jsonelement;
    }

    public abstract void write(JsonWriter jsonwriter, Object obj);
}
