// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

// Referenced classes of package com.xiaomi.infra.galaxy.common.util:
//            Base64Utils

public class StringUtils
{

    public static final int INDEX_NOT_FOUND = -1;

    public StringUtils()
    {
    }

    public static String fromBigDecimal(BigDecimal bigdecimal)
    {
        return bigdecimal.toString();
    }

    public static String fromBigInteger(BigInteger biginteger)
    {
        return biginteger.toString();
    }

    public static String fromBoolean(Boolean boolean1)
    {
        return Boolean.toString(boolean1.booleanValue());
    }

    public static String fromByte(Byte byte1)
    {
        return Byte.toString(byte1.byteValue());
    }

    public static String fromByteBuffer(ByteBuffer bytebuffer)
    {
        if (bytebuffer.hasArray())
        {
            return Base64Utils.encode(bytebuffer.array());
        } else
        {
            byte abyte0[] = new byte[bytebuffer.limit()];
            bytebuffer.get(abyte0);
            return Base64Utils.encode(abyte0);
        }
    }

    public static String fromDouble(Double double1)
    {
        return Double.toString(double1.doubleValue());
    }

    public static String fromFloat(Float float1)
    {
        return Float.toString(float1.floatValue());
    }

    public static String fromInteger(Integer integer)
    {
        return Integer.toString(integer.intValue());
    }

    public static String fromLong(Long long1)
    {
        return Long.toString(long1.longValue());
    }

    public static String fromString(String s)
    {
        return s;
    }

    public static boolean isBlank(CharSequence charsequence)
    {
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        int i = charsequence.length();
        if (i != 0) goto _L3; else goto _L2
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
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
                boolean flag1 = Character.isWhitespace(charsequence.charAt(j));
                flag = false;
                if (!flag1)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static boolean isNotBlank(CharSequence charsequence)
    {
        return !isBlank(charsequence);
    }

    public static boolean isNotEmpty(CharSequence charsequence)
    {
        return !isEmpty(charsequence);
    }

    public static transient String join(String s, String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < as.length; i++)
        {
            stringbuilder.append(as[i].toString());
            if (i < -1 + as.length)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public static String replace(String s, String s1, String s2)
    {
        return replace(s, s1, s2, -1);
    }

    public static String replace(String s, String s1, String s2, int i)
    {
        int j = 64;
        int k;
        if (!isEmpty(s) && !isEmpty(s1) && s2 != null && i != 0)
        {
            if ((k = s.indexOf(s1, 0)) != -1)
            {
                int l = s1.length();
                int i1 = s2.length() - l;
                if (i1 < 0)
                {
                    i1 = 0;
                }
                StringBuilder stringbuilder;
                int j1;
                if (i < 0)
                {
                    j = 16;
                } else
                if (i <= j)
                {
                    j = i;
                }
                stringbuilder = new StringBuilder(j * i1 + s.length());
                j1 = 0;
                do
                {
label0:
                    {
                        if (k != -1)
                        {
                            stringbuilder.append(s.substring(j1, k)).append(s2);
                            j1 = k + l;
                            if (--i != 0)
                            {
                                break label0;
                            }
                        }
                        stringbuilder.append(s.substring(j1));
                        return stringbuilder.toString();
                    }
                    k = s.indexOf(s1, j1);
                } while (true);
            }
        }
        return s;
    }

    public static BigDecimal toBigDecimal(String s)
    {
        return new BigDecimal(s);
    }

    public static BigInteger toBigInteger(String s)
    {
        return new BigInteger(s);
    }

    public static Boolean toBoolean(StringBuilder stringbuilder)
    {
        return Boolean.valueOf(Boolean.getBoolean(stringbuilder.toString()));
    }

    public static Integer toInteger(StringBuilder stringbuilder)
    {
        return Integer.valueOf(Integer.parseInt(stringbuilder.toString()));
    }

    public static String toString(StringBuilder stringbuilder)
    {
        return stringbuilder.toString();
    }

    public static String trim(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.trim();
        }
    }
}
