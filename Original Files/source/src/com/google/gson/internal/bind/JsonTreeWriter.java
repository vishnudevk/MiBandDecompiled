// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.gson.internal.bind:
//            e

public final class JsonTreeWriter extends JsonWriter
{

    private static final Writer a = new e();
    private static final JsonPrimitive b = new JsonPrimitive("closed");
    private final List c = new ArrayList();
    private String d;
    private JsonElement e;

    public JsonTreeWriter()
    {
        super(a);
        e = JsonNull.INSTANCE;
    }

    private JsonElement a()
    {
        return (JsonElement)c.get(-1 + c.size());
    }

    private void a(JsonElement jsonelement)
    {
        if (d != null)
        {
            if (!jsonelement.isJsonNull() || getSerializeNulls())
            {
                ((JsonObject)a()).add(d, jsonelement);
            }
            d = null;
            return;
        }
        if (c.isEmpty())
        {
            e = jsonelement;
            return;
        }
        JsonElement jsonelement1 = a();
        if (jsonelement1 instanceof JsonArray)
        {
            ((JsonArray)jsonelement1).add(jsonelement);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginArray()
    {
        JsonArray jsonarray = new JsonArray();
        a(jsonarray);
        c.add(jsonarray);
        return this;
    }

    public JsonWriter beginObject()
    {
        JsonObject jsonobject = new JsonObject();
        a(jsonobject);
        c.add(jsonobject);
        return this;
    }

    public void close()
    {
        if (!c.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            c.add(b);
            return;
        }
    }

    public JsonWriter endArray()
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (a() instanceof JsonArray)
        {
            c.remove(-1 + c.size());
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public JsonWriter endObject()
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (a() instanceof JsonObject)
        {
            c.remove(-1 + c.size());
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public void flush()
    {
    }

    public JsonElement get()
    {
        if (!c.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected one JSON element but was ").append(c).toString());
        } else
        {
            return e;
        }
    }

    public JsonWriter name(String s)
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (a() instanceof JsonObject)
        {
            d = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public JsonWriter nullValue()
    {
        a(JsonNull.INSTANCE);
        return this;
    }

    public JsonWriter value(double d1)
    {
        if (!isLenient() && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(d1).toString());
        } else
        {
            a(new JsonPrimitive(Double.valueOf(d1)));
            return this;
        }
    }

    public JsonWriter value(long l)
    {
        a(new JsonPrimitive(Long.valueOf(l)));
        return this;
    }

    public JsonWriter value(Number number)
    {
        if (number == null)
        {
            return nullValue();
        }
        if (!isLenient())
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(number).toString());
            }
        }
        a(new JsonPrimitive(number));
        return this;
    }

    public JsonWriter value(String s)
    {
        if (s == null)
        {
            return nullValue();
        } else
        {
            a(new JsonPrimitive(s));
            return this;
        }
    }

    public JsonWriter value(boolean flag)
    {
        a(new JsonPrimitive(Boolean.valueOf(flag)));
        return this;
    }

}
