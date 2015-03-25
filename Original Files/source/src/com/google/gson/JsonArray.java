// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.gson:
//            JsonElement, JsonNull

public final class JsonArray extends JsonElement
    implements Iterable
{

    private final List a = new ArrayList();

    public JsonArray()
    {
    }

    JsonArray a()
    {
        JsonArray jsonarray = new JsonArray();
        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); jsonarray.add(((JsonElement)iterator1.next()).b())) { }
        return jsonarray;
    }

    public void add(JsonElement jsonelement)
    {
        if (jsonelement == null)
        {
            jsonelement = JsonNull.INSTANCE;
        }
        a.add(jsonelement);
    }

    public void addAll(JsonArray jsonarray)
    {
        a.addAll(jsonarray.a);
    }

    JsonElement b()
    {
        return a();
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof JsonArray) && ((JsonArray)obj).a.equals(a);
    }

    public JsonElement get(int i)
    {
        return (JsonElement)a.get(i);
    }

    public BigDecimal getAsBigDecimal()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsBigDecimal();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public BigInteger getAsBigInteger()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsBigInteger();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public boolean getAsBoolean()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsBoolean();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public byte getAsByte()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsByte();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public char getAsCharacter()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsCharacter();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public double getAsDouble()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsDouble();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public float getAsFloat()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsFloat();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int getAsInt()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsInt();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public long getAsLong()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsLong();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public Number getAsNumber()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsNumber();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public short getAsShort()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsShort();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public String getAsString()
    {
        if (a.size() == 1)
        {
            return ((JsonElement)a.get(0)).getAsString();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public Iterator iterator()
    {
        return a.iterator();
    }

    public int size()
    {
        return a.size();
    }
}
