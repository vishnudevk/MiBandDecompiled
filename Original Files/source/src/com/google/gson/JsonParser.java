// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

// Referenced classes of package com.google.gson:
//            JsonParseException, JsonElement, JsonSyntaxException, JsonIOException

public final class JsonParser
{

    public JsonParser()
    {
    }

    public JsonElement parse(JsonReader jsonreader)
    {
        boolean flag;
        flag = jsonreader.isLenient();
        jsonreader.setLenient(true);
        JsonElement jsonelement = Streams.parse(jsonreader);
        jsonreader.setLenient(flag);
        return jsonelement;
        StackOverflowError stackoverflowerror;
        stackoverflowerror;
        throw new JsonParseException((new StringBuilder()).append("Failed parsing JSON source: ").append(jsonreader).append(" to Json").toString(), stackoverflowerror);
        Exception exception;
        exception;
        jsonreader.setLenient(flag);
        throw exception;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        throw new JsonParseException((new StringBuilder()).append("Failed parsing JSON source: ").append(jsonreader).append(" to Json").toString(), outofmemoryerror);
    }

    public JsonElement parse(Reader reader)
    {
        JsonElement jsonelement;
        try
        {
            JsonReader jsonreader = new JsonReader(reader);
            jsonelement = parse(jsonreader);
            if (!jsonelement.isJsonNull() && jsonreader.peek() != JsonToken.END_DOCUMENT)
            {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
        }
        catch (MalformedJsonException malformedjsonexception)
        {
            throw new JsonSyntaxException(malformedjsonexception);
        }
        catch (IOException ioexception)
        {
            throw new JsonIOException(ioexception);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new JsonSyntaxException(numberformatexception);
        }
        return jsonelement;
    }

    public JsonElement parse(String s)
    {
        return parse(((Reader) (new StringReader(s))));
    }
}
