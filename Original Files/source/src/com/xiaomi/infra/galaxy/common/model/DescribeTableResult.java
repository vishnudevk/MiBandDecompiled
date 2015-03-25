// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result, TableDescription

public class DescribeTableResult extends Result
{

    private TableDescription table;

    public DescribeTableResult()
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
        flag2 = obj instanceof DescribeTableResult;
        flag1 = false;
        if (!flag2) goto _L4; else goto _L5
_L5:
        DescribeTableResult describetableresult = (DescribeTableResult)obj;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (describetableresult.getTable() == null)
        {
            flag3 = flag;
        } else
        {
            flag3 = false;
        }
        if (getTable() != null)
        {
            flag = false;
        }
        flag4 = flag3 ^ flag;
        flag1 = false;
        if (flag4) goto _L4; else goto _L6
_L6:
        if (describetableresult.getTable() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = describetableresult.getTable().equals(getTable());
        flag1 = false;
        if (!flag5) goto _L4; else goto _L7
_L7:
        return super.equals(obj);
    }

    public TableDescription getTable()
    {
        return table;
    }

    public int hashCode()
    {
        int i = 31 * super.hashCode();
        int j;
        if (getTable() == null)
        {
            j = 0;
        } else
        {
            j = getTable().hashCode();
        }
        return j + i;
    }

    public void setTable(TableDescription tabledescription)
    {
        table = tabledescription;
    }

    public DescribeTableResult withTable(TableDescription tabledescription)
    {
        table = tabledescription;
        return this;
    }
}
