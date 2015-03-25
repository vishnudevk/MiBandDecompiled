// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.google.gson:
//            JsonArray, JsonNull, JsonObject, JsonPrimitive

public abstract class JsonElement
{

    public JsonElement()
    {
    }

    abstract JsonElement b();

    Boolean c()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigDecimal getAsBigDecimal()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public char getAsCharacter()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public JsonArray getAsJsonArray()
    {
        if (isJsonArray())
        {
            return (JsonArray)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Array.");
        }
    }

    public JsonNull getAsJsonNull()
    {
        if (isJsonNull())
        {
            return (JsonNull)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Null.");
        }
    }

    public JsonObject getAsJsonObject()
    {
        if (isJsonObject())
        {
            return (JsonObject)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Not a JSON Object: ").append(this).toString());
        }
    }

    public JsonPrimitive getAsJsonPrimitive()
    {
        if (isJsonPrimitive())
        {
            return (JsonPrimitive)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Primitive.");
        }
    }

    public long getAsLong()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray()
    {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull()
    {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject()
    {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive()
    {
        return this instanceof JsonPrimitive;
    }

    public String toString()
    {
        String s;
        try
        {
            StringWriter stringwriter = new StringWriter();
            JsonWriter jsonwriter = new JsonWriter(stringwriter);
            jsonwriter.setLenient(true);
            Streams.write(this, jsonwriter);
            s = stringwriter.toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return s;
    }
}
