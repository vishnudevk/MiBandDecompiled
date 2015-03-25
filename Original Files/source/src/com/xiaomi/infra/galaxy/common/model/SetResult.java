// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class SetResult extends Result
{

    private Map attributes;
    private String tableName;

    public SetResult()
    {
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
        flag2 = obj instanceof SetResult;
        flag1 = false;
        if (!flag2) goto _L4; else goto _L5
_L5:
        SetResult setresult = (SetResult)obj;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        if (setresult.getTableName() == null)
        {
            flag3 = flag;
        } else
        {
            flag3 = false;
        }
        if (getTableName() == null)
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
        if (setresult.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag9 = setresult.getTableName().equals(getTableName());
        flag1 = false;
        if (!flag9) goto _L4; else goto _L7
_L7:
        boolean flag6;
        if (setresult.getAttributes() == null)
        {
            flag6 = flag;
        } else
        {
            flag6 = false;
        }
        if (getAttributes() != null)
        {
            flag = false;
        }
        flag7 = flag6 ^ flag;
        flag1 = false;
        if (flag7) goto _L4; else goto _L8
_L8:
        if (setresult.getAttributes() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag8 = setresult.getAttributes().equals(getAttributes());
        flag1 = false;
        if (!flag8) goto _L4; else goto _L9
_L9:
        return super.equals(obj);
    }

    public Map getAttributes()
    {
        return attributes;
    }

    public String getTableName()
    {
        return tableName;
    }

    public int hashCode()
    {
        int i = 31 * super.hashCode();
        int j;
        int k;
        Map map;
        int l;
        if (getTableName() == null)
        {
            j = 0;
        } else
        {
            j = getTableName().hashCode();
        }
        k = 31 * (j + i);
        map = getAttributes();
        l = 0;
        if (map != null)
        {
            l = getAttributes().hashCode();
        }
        return k + l;
    }

    public void setAttributes(Map map)
    {
        attributes = map;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public SetResult withAttributes(Map map)
    {
        setAttributes(map);
        return this;
    }

    public SetResult withTableName(String s)
    {
        setTableName(s);
        return this;
    }
}
