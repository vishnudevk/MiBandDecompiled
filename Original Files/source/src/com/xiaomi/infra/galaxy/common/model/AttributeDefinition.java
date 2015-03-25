// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeType

public class AttributeDefinition
{

    private String attributeName;
    private String attributeType;

    public AttributeDefinition()
    {
    }

    public AttributeDefinition(String s, AttributeType attributetype)
    {
        attributeName = s;
        attributeType = attributetype.toString();
    }

    public AttributeDefinition(String s, String s1)
    {
        setAttributeName(s);
        setAttributeType(s1);
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
        flag1 = obj instanceof AttributeDefinition;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        AttributeDefinition attributedefinition = (AttributeDefinition)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        if (attributedefinition.getAttributeName() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getAttributeName() == null)
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
        if (attributedefinition.getAttributeName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag9 = attributedefinition.getAttributeName().equals(getAttributeName());
        flag = false;
        if (!flag9) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (attributedefinition.getAttributeType() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getAttributeType() == null)
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
        if (attributedefinition.getAttributeType() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag8 = attributedefinition.getAttributeType().equals(getAttributeType());
        flag = false;
        if (!flag8) goto _L4; else goto _L9
_L9:
        return true;
    }

    public String getAttributeName()
    {
        return attributeName;
    }

    public String getAttributeType()
    {
        return attributeType;
    }

    public int hashCode()
    {
        int i;
        int j;
        String s;
        int k;
        if (getAttributeName() == null)
        {
            i = 0;
        } else
        {
            i = getAttributeName().hashCode();
        }
        j = 31 * (i + 31);
        s = getAttributeType();
        k = 0;
        if (s != null)
        {
            k = getAttributeType().hashCode();
        }
        return j + k;
    }

    public void setAttributeName(String s)
    {
        attributeName = s;
    }

    public void setAttributeType(String s)
    {
        attributeType = s;
    }

    public void validate()
    {
        if (StringUtils.isBlank(attributeName))
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_BLANK);
        }
        if (attributeName.length() > 255)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_TOO_LONG, attributeName);
        }
        if (!Constants.AttributeNamePattern.matcher(attributeName).matches())
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_NAME_IS_INVALID, attributeName);
        }
        try
        {
            AttributeType.fromValue(attributeType);
            return;
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_INVALID, (new StringBuilder()).append(attributeName).append("(").append(attributeType).append(")").toString());
        }
    }

    public AttributeDefinition withAttributeName(String s)
    {
        attributeName = s;
        return this;
    }

    public AttributeDefinition withAttributeType(AttributeType attributetype)
    {
        attributeType = attributetype.toString();
        return this;
    }

    public AttributeDefinition withAttributeType(String s)
    {
        attributeType = s;
        return this;
    }
}
