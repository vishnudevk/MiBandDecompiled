// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeValue

public class Record
{

    private Map attributes;
    private Map key;
    private String userId;

    public Record()
    {
    }

    public Record addAttributeValue(String s, Object obj)
    {
        if (attributes == null)
        {
            attributes = new HashMap();
        }
        AttributeValue.putAttributeValueInMap(attributes, s, obj);
        return this;
    }

    public Record addKey(String s, Object obj)
    {
        if (key == null)
        {
            key = new HashMap();
        }
        AttributeValue.putAttributeValueInMap(key, s, obj);
        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag;
_L4:
        return flag1;
_L2:
        flag1 = false;
        if (obj == null) goto _L4; else goto _L3
_L3:
        boolean flag2;
        flag2 = obj instanceof Record;
        flag1 = false;
        if (!flag2) goto _L4; else goto _L5
_L5:
        Record record = (Record)obj;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag8;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        if (record.getUserId() == null)
        {
            flag3 = flag;
        } else
        {
            flag3 = false;
        }
        if (getUserId() == null)
        {
            flag4 = flag;
        } else
        {
            flag4 = false;
        }
        flag5 = flag3 ^ flag4;
        flag1 = false;
        if (flag5) goto _L4; else goto _L6
_L6:
        if (record.getUserId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag13 = record.getUserId().equals(getUserId());
        flag1 = false;
        if (!flag13) goto _L4; else goto _L7
_L7:
        boolean flag6;
        boolean flag7;
        if (record.getAttributes() == null)
        {
            flag6 = flag;
        } else
        {
            flag6 = false;
        }
        if (getAttributes() == null)
        {
            flag7 = flag;
        } else
        {
            flag7 = false;
        }
        flag8 = flag6 ^ flag7;
        flag1 = false;
        if (flag8) goto _L4; else goto _L8
_L8:
        if (record.getAttributes() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag12 = record.getAttributes().equals(getAttributes());
        flag1 = false;
        if (!flag12) goto _L4; else goto _L9
_L9:
        boolean flag9;
        if (record.getKey() == null)
        {
            flag9 = flag;
        } else
        {
            flag9 = false;
        }
        if (getKey() != null)
        {
            flag = false;
        }
        flag10 = flag9 ^ flag;
        flag1 = false;
        if (flag10) goto _L4; else goto _L10
_L10:
        if (record.getKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag11 = record.getKey().equals(getKey());
        flag1 = false;
        if (!flag11) goto _L4; else goto _L11
_L11:
        return super.equals(obj);
    }

    public Map getAttributes()
    {
        return attributes;
    }

    public Map getKey()
    {
        return key;
    }

    public String getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        int i = 31 * super.hashCode();
        int j;
        int k;
        String s;
        int l;
        if (getAttributes() == null)
        {
            j = 0;
        } else
        {
            j = getAttributes().hashCode();
        }
        k = 31 * (j + i);
        s = getUserId();
        l = 0;
        if (s != null)
        {
            l = getUserId().hashCode();
        }
        return k + l;
    }

    public void setAttributes(Map map)
    {
        attributes = map;
    }

    public void setKey(Map map)
    {
        key = map;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public Record withAttributes(Map map)
    {
        setAttributes(map);
        return this;
    }

    public Record withKey(Map map)
    {
        setKey(map);
        return this;
    }

    public Record withUserId(String s)
    {
        setUserId(s);
        return this;
    }
}
