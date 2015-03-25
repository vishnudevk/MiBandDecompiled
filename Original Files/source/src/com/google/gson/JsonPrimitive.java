// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.google.gson:
//            JsonElement

public final class JsonPrimitive extends JsonElement
{

    private static final Class a[];
    private Object b;

    public JsonPrimitive(Boolean boolean1)
    {
        a(boolean1);
    }

    public JsonPrimitive(Character character)
    {
        a(character);
    }

    public JsonPrimitive(Number number)
    {
        a(number);
    }

    JsonPrimitive(Object obj)
    {
        a(obj);
    }

    public JsonPrimitive(String s)
    {
        a(s);
    }

    private static boolean a(JsonPrimitive jsonprimitive)
    {
        if (jsonprimitive.b instanceof Number)
        {
            Number number = (Number)jsonprimitive.b;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        } else
        {
            return false;
        }
    }

    private static boolean b(Object obj)
    {
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Class class1 = obj.getClass();
        Class aclass[] = a;
        int i = aclass.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= i)
                {
                    break label1;
                }
                if (aclass[j].isAssignableFrom(class1))
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    JsonPrimitive a()
    {
        return this;
    }

    void a(Object obj)
    {
        if (obj instanceof Character)
        {
            b = String.valueOf(((Character)obj).charValue());
            return;
        }
        boolean flag;
        if ((obj instanceof Number) || b(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.gson.internal..Gson.Preconditions.checkArgument(flag);
        b = obj;
    }

    JsonElement b()
    {
        return a();
    }

    Boolean c()
    {
        return (Boolean)b;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        JsonPrimitive jsonprimitive;
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        jsonprimitive = (JsonPrimitive)obj;
        if (b != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (jsonprimitive.b != null)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!a(this) || !a(jsonprimitive))
        {
            break; /* Loop/switch isn't completed */
        }
        if (getAsNumber().longValue() != jsonprimitive.getAsNumber().longValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
label0:
        {
            boolean flag;
label1:
            {
                if (!(b instanceof Number) || !(jsonprimitive.b instanceof Number))
                {
                    break label0;
                }
                double d = getAsNumber().doubleValue();
                double d1 = jsonprimitive.getAsNumber().doubleValue();
                if (d != d1)
                {
                    boolean flag1 = Double.isNaN(d);
                    flag = false;
                    if (!flag1)
                    {
                        break label1;
                    }
                    boolean flag2 = Double.isNaN(d1);
                    flag = false;
                    if (!flag2)
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            return flag;
        }
        return b.equals(jsonprimitive.b);
    }

    public BigDecimal getAsBigDecimal()
    {
        if (b instanceof BigDecimal)
        {
            return (BigDecimal)b;
        } else
        {
            return new BigDecimal(b.toString());
        }
    }

    public BigInteger getAsBigInteger()
    {
        if (b instanceof BigInteger)
        {
            return (BigInteger)b;
        } else
        {
            return new BigInteger(b.toString());
        }
    }

    public boolean getAsBoolean()
    {
        if (isBoolean())
        {
            return c().booleanValue();
        } else
        {
            return Boolean.parseBoolean(getAsString());
        }
    }

    public byte getAsByte()
    {
        if (isNumber())
        {
            return getAsNumber().byteValue();
        } else
        {
            return Byte.parseByte(getAsString());
        }
    }

    public char getAsCharacter()
    {
        return getAsString().charAt(0);
    }

    public double getAsDouble()
    {
        if (isNumber())
        {
            return getAsNumber().doubleValue();
        } else
        {
            return Double.parseDouble(getAsString());
        }
    }

    public float getAsFloat()
    {
        if (isNumber())
        {
            return getAsNumber().floatValue();
        } else
        {
            return Float.parseFloat(getAsString());
        }
    }

    public int getAsInt()
    {
        if (isNumber())
        {
            return getAsNumber().intValue();
        } else
        {
            return Integer.parseInt(getAsString());
        }
    }

    public long getAsLong()
    {
        if (isNumber())
        {
            return getAsNumber().longValue();
        } else
        {
            return Long.parseLong(getAsString());
        }
    }

    public Number getAsNumber()
    {
        if (b instanceof String)
        {
            return new LazilyParsedNumber((String)b);
        } else
        {
            return (Number)b;
        }
    }

    public short getAsShort()
    {
        if (isNumber())
        {
            return getAsNumber().shortValue();
        } else
        {
            return Short.parseShort(getAsString());
        }
    }

    public String getAsString()
    {
        if (isNumber())
        {
            return getAsNumber().toString();
        }
        if (isBoolean())
        {
            return c().toString();
        } else
        {
            return (String)b;
        }
    }

    public int hashCode()
    {
        if (b == null)
        {
            return 31;
        }
        if (a(this))
        {
            long l1 = getAsNumber().longValue();
            return (int)(l1 ^ l1 >>> 32);
        }
        if (b instanceof Number)
        {
            long l = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int)(l ^ l >>> 32);
        } else
        {
            return b.hashCode();
        }
    }

    public boolean isBoolean()
    {
        return b instanceof Boolean;
    }

    public boolean isNumber()
    {
        return b instanceof Number;
    }

    public boolean isString()
    {
        return b instanceof String;
    }

    static 
    {
        Class aclass[] = new Class[16];
        aclass[0] = Integer.TYPE;
        aclass[1] = Long.TYPE;
        aclass[2] = Short.TYPE;
        aclass[3] = Float.TYPE;
        aclass[4] = Double.TYPE;
        aclass[5] = Byte.TYPE;
        aclass[6] = Boolean.TYPE;
        aclass[7] = Character.TYPE;
        aclass[8] = java/lang/Integer;
        aclass[9] = java/lang/Long;
        aclass[10] = java/lang/Short;
        aclass[11] = java/lang/Float;
        aclass[12] = java/lang/Double;
        aclass[13] = java/lang/Byte;
        aclass[14] = java/lang/Boolean;
        aclass[15] = java/lang/Character;
        a = aclass;
    }
}
