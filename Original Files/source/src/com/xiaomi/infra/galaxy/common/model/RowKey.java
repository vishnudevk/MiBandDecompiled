// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AttributeValue

public class RowKey
{

    public static final String BEGIN_USER_ID = "";
    public static final String END_USER_ID = "";
    private Map key;
    private String userId;

    public RowKey()
    {
        userId = null;
        key = null;
    }

    public static RowKey getBeginRowKey()
    {
        RowKey rowkey = new RowKey();
        rowkey.withUserId("");
        return rowkey;
    }

    public static RowKey getEndRowKey()
    {
        RowKey rowkey = new RowKey();
        rowkey.withUserId("");
        return rowkey;
    }

    public RowKey addKey(String s, Object obj)
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
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        RowKey rowkey;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        rowkey = (RowKey)obj;
        if (key == null)
        {
            if (rowkey.key != null)
            {
                return false;
            }
        } else
        if (!key.equals(rowkey.key))
        {
            return false;
        }
        if (userId != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (rowkey.userId == null) goto _L1; else goto _L3
_L3:
        return false;
        if (userId.equals(rowkey.userId)) goto _L1; else goto _L4
_L4:
        return false;
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
        int i;
        int j;
        String s;
        int k;
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        j = 31 * (i + 31);
        s = userId;
        k = 0;
        if (s != null)
        {
            k = userId.hashCode();
        }
        return j + k;
    }

    public void setKey(Map map)
    {
        key = map;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public RowKey withKey(Map map)
    {
        setKey(map);
        return this;
    }

    public RowKey withUserId(String s)
    {
        setUserId(s);
        return this;
    }
}
