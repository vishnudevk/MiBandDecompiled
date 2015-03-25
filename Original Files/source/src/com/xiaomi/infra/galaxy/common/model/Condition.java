// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeValue, Comparator, AttributeType, Verifier

public class Condition
{

    private String attributeName;
    private List attributeValues;
    private String comparator;

    public Condition()
    {
    }

    public Condition addAttributeValue(Object obj)
    {
        if (attributeValues == null)
        {
            attributeValues = new ArrayList();
        }
        AttributeValue.putAttributeValueInList(attributeValues, obj);
        return this;
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
        flag1 = obj instanceof Condition;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        Condition condition = (Condition)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        if (condition.getComparator() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getComparator() == null)
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
        if (condition.getComparator() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag9 = condition.getComparator().equals(getComparator());
        flag = false;
        if (!flag9) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (condition.getAttributeValues() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getAttributeValues() == null)
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
        if (condition.getAttributeValues() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag8 = condition.getAttributeValues().equals(getAttributeValues());
        flag = false;
        if (!flag8) goto _L4; else goto _L9
_L9:
        return true;
    }

    public String getAttributeName()
    {
        return attributeName;
    }

    public List getAttributeValues()
    {
        return attributeValues;
    }

    public String getComparator()
    {
        return comparator;
    }

    public int hashCode()
    {
        int i;
        int j;
        List list;
        int k;
        if (getComparator() == null)
        {
            i = 0;
        } else
        {
            i = getComparator().hashCode();
        }
        j = 31 * (i + 31);
        list = getAttributeValues();
        k = 0;
        if (list != null)
        {
            k = getAttributeValues().hashCode();
        }
        return j + k;
    }

    public void setAttributeName(String s)
    {
        attributeName = s;
    }

    public void setAttributeValues(List list)
    {
        attributeValues = list;
    }

    public void setComparator(String s)
    {
        comparator = s;
    }

    public void validate()
    {
        Comparator comparator1;
        AttributeType attributetype;
        comparator1 = Comparator.fromValue(comparator);
        if (attributeValues == null || attributeValues.size() != 1)
        {
            throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_OPERANDS, "comparator can only use one attribute value");
        }
        attributetype = AttributeType.fromValue(((AttributeValue)attributeValues.get(0)).getType());
        Verifier.validateAttributeValue(attributeName, (AttributeValue)attributeValues.get(0), false);
        _cls1..SwitchMap.com.xiaomi.infra.galaxy.common.model.Comparator[comparator1.ordinal()];
        JVM INSTR tableswitch 1 6: default 128
    //                   1 221
    //                   2 221
    //                   3 179
    //                   4 222
    //                   5 265
    //                   6 308;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new GalaxyClientException(ReturnCode.UNEXPECTED_OPERAND_TYPE, (new StringBuilder()).append(attributetype.name()).append("(comparator:").append(comparator1).append(" ,attributeType").append(attributetype).append(")").toString());
_L3:
        if (AttributeType.BINARY != attributetype && AttributeType.STRING != attributetype && AttributeType.INT8 != attributetype && AttributeType.INT16 != attributetype && AttributeType.INT32 != attributetype && AttributeType.INT64 != attributetype)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return;
_L4:
        if (AttributeType.BINARY == attributetype || AttributeType.STRING == attributetype || AttributeType.INT8 == attributetype || AttributeType.INT16 == attributetype || AttributeType.INT32 == attributetype || AttributeType.INT64 == attributetype)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (AttributeType.BINARY == attributetype || AttributeType.STRING == attributetype || AttributeType.INT8 == attributetype || AttributeType.INT16 == attributetype || AttributeType.INT32 == attributetype || AttributeType.INT64 == attributetype)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (AttributeType.BINARY == attributetype || AttributeType.STRING == attributetype || AttributeType.INT8 == attributetype || AttributeType.INT16 == attributetype || AttributeType.INT32 == attributetype || AttributeType.INT64 == attributetype)
        {
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public Condition withAttributeValues(List list)
    {
        setAttributeValues(list);
        return this;
    }

    public Condition withComparator(Comparator comparator1)
    {
        setComparator(comparator1.name());
        return this;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[];

        static 
        {
            $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator = new int[Comparator.values().length];
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.EQ.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.NE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.GT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.GE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.LT.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator[Comparator.LE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5)
            {
                return;
            }
        }
    }

}
