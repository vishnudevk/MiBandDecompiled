// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeValue, RowKey, AttributeType

public class Verifier
{

    public Verifier()
    {
    }

    public static void validateAttributeName(String s, boolean flag)
    {
        if (StringUtils.isBlank(s))
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_BLANK);
        }
        if (s.length() > 255)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_TOO_LONG, s);
        }
        if (flag && !Constants.AttributeNamePattern.matcher(s).matches())
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_INVALID, s);
        } else
        {
            return;
        }
    }

    public static void validateAttributeNames(Collection collection, boolean flag)
    {
        if (collection != null && !collection.isEmpty())
        {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) 
            {
                validateAttributeName((String)iterator.next(), flag);
            }
        }
    }

    public static void validateAttributeValue(String s, AttributeValue attributevalue, boolean flag)
    {
        validateAttributeName(s, flag);
        if (attributevalue == null)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_NULL, s);
        } else
        {
            validateValue(attributevalue.getType(), attributevalue.getValue(), s);
            return;
        }
    }

    public static void validateKeyValues(RowKey rowkey, boolean flag)
    {
        if (rowkey != null)
        {
            validateKeyValues(rowkey.getKey(), flag);
        }
    }

    public static void validateKeyValues(Map map, boolean flag)
    {
        byte byte0;
        Iterator iterator;
        byte byte1;
        byte0 = -1;
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_286;
        }
        iterator = map.entrySet().iterator();
        byte1 = byte0;
_L12:
        AttributeValue attributevalue;
        AttributeType attributetype;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_283;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        String s = (String)entry.getKey();
        attributevalue = (AttributeValue)entry.getValue();
        validateAttributeValue(s, attributevalue, flag);
        attributetype = AttributeType.fromValue(attributevalue.getType());
        _cls1..SwitchMap.com.xiaomi.infra.galaxy.common.model.AttributeType[attributetype.ordinal()];
        JVM INSTR tableswitch 1 9: default 152
    //                   1 163
    //                   2 170
    //                   3 179
    //                   4 188
    //                   5 197
    //                   6 207
    //                   7 216
    //                   8 226
    //                   9 263;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_263;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        int i = byte1;
_L13:
        byte1 = i;
        if (true) goto _L12; else goto _L11
_L11:
        i = byte1;
          goto _L13
_L3:
        i = byte1 + 1;
          goto _L13
_L4:
        i = byte1 + 2;
          goto _L13
_L5:
        i = byte1 + 4;
          goto _L13
_L6:
        i = byte1 + 8;
          goto _L13
_L7:
        i = byte1 + 4;
          goto _L13
_L8:
        i = byte1 + 8;
          goto _L13
_L9:
        int j = attributevalue.getValue().getBytes("utf-8").length;
        i = byte1 + j;
          goto _L13
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        i = byte1;
          goto _L13
        i = byte1 + (3 * attributevalue.getValue().length()) / 4;
          goto _L13
        byte0 = byte1;
        if (byte0 > 1024)
        {
            throw new GalaxyClientException(ReturnCode.KEY_IS_TOO_LONG, (new StringBuilder()).append("").append(byte0).toString());
        } else
        {
            return;
        }
    }

    public static void validateTableName(String s)
    {
        validateTableName(s, true);
    }

    public static void validateTableName(String s, boolean flag)
    {
        if (StringUtils.isBlank(s))
        {
            throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_BLANK);
        }
        if (s.length() > 255)
        {
            throw new GalaxyClientException(ReturnCode.TABLE_NAME_TOO_LONG, s);
        }
        if (flag && !Constants.TableNamePattern.matcher(s).matches())
        {
            throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_INVALID, s);
        } else
        {
            return;
        }
    }

    private static void validateValue(String s, String s1, String s2)
    {
        AttributeType attributetype;
        try
        {
            attributetype = AttributeType.fromValue(s);
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            throw galaxyclientexception;
        }
        _cls1..SwitchMap.com.xiaomi.infra.galaxy.common.model.AttributeType[attributetype.ordinal()];
        JVM INSTR tableswitch 1 9: default 64
    //                   1 106
    //                   2 163
    //                   3 210
    //                   4 257
    //                   5 304
    //                   6 168
    //                   7 168
    //                   8 168
    //                   9 168;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L7
_L4:
        break MISSING_BLOCK_LABEL_210;
_L5:
        break MISSING_BLOCK_LABEL_257;
_L6:
        break MISSING_BLOCK_LABEL_304;
_L7:
        break; /* Loop/switch isn't completed */
_L1:
        throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("unused attribute type of ").append(s2).append("@").append(s).toString());
_L2:
        if (!"true".equalsIgnoreCase(s1) && !"false".equalsIgnoreCase(s1))
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("expected 'true' or 'false' for boolean attribute type of ").append(s2).append("@").append(s1).toString());
        }
        break; /* Loop/switch isn't completed */
_L3:
        Byte.parseByte(s1);
        return;
        Exception exception3;
        exception3;
        throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("expected [-128,127] for int8 attribute type of ").append(s2).append("@").append(s1).toString());
        try
        {
            Short.parseShort(s1);
            return;
        }
        catch (Exception exception2)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("expected [-32768,32767] for int16 attribute type of ").append(s2).append("@").append(s1).toString());
        }
        try
        {
            Integer.parseInt(s1);
            return;
        }
        catch (Exception exception1)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("expected [-2147483648,2147483647] for int32 attribute type of ").append(s2).append("@").append(s1).toString());
        }
        try
        {
            Long.parseLong(s1);
            return;
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_VALUE_IS_INVALID, (new StringBuilder()).append("expected [-9223372036854775808,9223372036854775807] for int64 attribute type of ").append(s2).append("@").append(s1).toString());
        }
    }

    private class _cls1
    {

        static final int $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[];

        static 
        {
            $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType = new int[AttributeType.values().length];
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.BOOL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT8.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT16.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT32.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT64.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.FLOAT.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.DOUBLE.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.STRING.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.BINARY.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror8)
            {
                return;
            }
        }
    }

}
