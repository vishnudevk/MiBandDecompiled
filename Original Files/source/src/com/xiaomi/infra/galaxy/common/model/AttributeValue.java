// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeType

public class AttributeValue
{

    private String type;
    private String value;

    public AttributeValue()
    {
    }

    public static AttributeValue createAttributeValue(Object obj)
    {
        if (obj == null)
        {
            throw new GalaxyClientException(ReturnCode.PARAMETER_IS_NULL);
        }
        AttributeValue attributevalue = new AttributeValue();
        if (obj instanceof Boolean)
        {
            attributevalue.withType(AttributeType.BOOL).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Byte)
        {
            attributevalue.withType(AttributeType.INT8).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Short)
        {
            attributevalue.withType(AttributeType.INT16).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Integer)
        {
            attributevalue.withType(AttributeType.INT32).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Long)
        {
            attributevalue.withType(AttributeType.INT64).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Float)
        {
            attributevalue.withType(AttributeType.FLOAT).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof Double)
        {
            attributevalue.withType(AttributeType.DOUBLE).withValue(obj.toString());
            return attributevalue;
        }
        if (obj instanceof String)
        {
            attributevalue.withType(AttributeType.STRING).withValue((String)obj);
            return attributevalue;
        }
        if (obj instanceof byte[])
        {
            attributevalue.withType(AttributeType.BINARY).withValue(Base64Utils.encode((byte[])(byte[])obj));
            return attributevalue;
        } else
        {
            throw new GalaxyClientException(ReturnCode.PARAMETER_TYPE_ERROR);
        }
    }

    protected static void putAttributeValueInList(List list, Object obj)
    {
        list.add(createAttributeValue(obj));
    }

    protected static void putAttributeValueInMap(Map map, String s, Object obj)
    {
        map.put(s, createAttributeValue(obj));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if (obj == null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        flag1 = obj instanceof AttributeValue;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        AttributeValue attributevalue = (AttributeValue)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        if (attributevalue.getType() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getType() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag4 = flag2 ^ flag3;
        flag = false;
        if (flag4) goto _L4; else goto _L6
_L6:
        if (attributevalue.getType() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag9 = attributevalue.getType().equals(getType());
        flag = false;
        if (!flag9) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (attributevalue.getValue() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getValue() == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        flag7 = flag5 ^ flag6;
        flag = false;
        if (flag7) goto _L4; else goto _L8
_L8:
        if (attributevalue.getValue() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag8 = attributevalue.getValue().equals(getValue());
        flag = false;
        if (!flag8) goto _L4; else goto _L9
_L9:
        return true;
    }

    public String getType()
    {
        return type;
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        int i;
        int j;
        String s;
        int k;
        if (getType() == null)
        {
            i = 0;
        } else
        {
            i = getType().hashCode();
        }
        j = 31 * (i + 31);
        s = getValue();
        k = 0;
        if (s != null)
        {
            k = getValue().hashCode();
        }
        return j + k;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AttributeValue [type=").append(type).append(", value=").append(value).append("]").toString();
    }

    public AttributeValue withType(AttributeType attributetype)
    {
        setType(attributetype.name());
        return this;
    }

    public AttributeValue withValue(String s)
    {
        setValue(s);
        return this;
    }
}
