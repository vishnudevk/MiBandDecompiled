// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class ScanAppUserResult extends Result
{

    private List items;
    private String lastUserId;
    private int scannedCount;
    private String tableName;

    public ScanAppUserResult()
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
        flag2 = obj instanceof ScanAppUserResult;
        flag1 = false;
        if (!flag2) goto _L4; else goto _L5
_L5:
        ScanAppUserResult scanappuserresult = (ScanAppUserResult)obj;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        int i;
        int j;
        boolean flag8;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        if (scanappuserresult.getTableName() == null)
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
        if (scanappuserresult.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag13 = scanappuserresult.getTableName().equals(getTableName());
        flag1 = false;
        if (!flag13) goto _L4; else goto _L7
_L7:
        i = scanappuserresult.getScannedCount();
        j = getScannedCount();
        flag1 = false;
        if (i != j) goto _L4; else goto _L8
_L8:
        boolean flag6;
        boolean flag7;
        if (scanappuserresult.getItems() == null)
        {
            flag6 = flag;
        } else
        {
            flag6 = false;
        }
        if (getItems() == null)
        {
            flag7 = flag;
        } else
        {
            flag7 = false;
        }
        flag8 = flag6 ^ flag7;
        flag1 = false;
        if (flag8) goto _L4; else goto _L9
_L9:
        if (scanappuserresult.getItems() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag12 = scanappuserresult.getItems().equals(getItems());
        flag1 = false;
        if (!flag12) goto _L4; else goto _L10
_L10:
        boolean flag9;
        if (scanappuserresult.getLastUserId() == null)
        {
            flag9 = flag;
        } else
        {
            flag9 = false;
        }
        if (getLastUserId() != null)
        {
            flag = false;
        }
        flag10 = flag9 ^ flag;
        flag1 = false;
        if (flag10) goto _L4; else goto _L11
_L11:
        if (scanappuserresult.getLastUserId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag11 = scanappuserresult.getLastUserId().equals(getLastUserId());
        flag1 = false;
        if (!flag11) goto _L4; else goto _L12
_L12:
        return super.equals(obj);
    }

    public List getItems()
    {
        return items;
    }

    public String getLastUserId()
    {
        return lastUserId;
    }

    public int getScannedCount()
    {
        return scannedCount;
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
        int l;
        int i1;
        String s;
        int j1;
        if (getTableName() == null)
        {
            j = 0;
        } else
        {
            j = getTableName().hashCode();
        }
        k = 31 * (31 * (j + i) + getScannedCount());
        if (getItems() == null)
        {
            l = 0;
        } else
        {
            l = getItems().hashCode();
        }
        i1 = 31 * (l + k);
        s = getLastUserId();
        j1 = 0;
        if (s != null)
        {
            j1 = getLastUserId().hashCode();
        }
        return i1 + j1;
    }

    public void setItems(List list)
    {
        items = list;
    }

    public void setLastUserId(String s)
    {
        lastUserId = s;
    }

    public void setScannedCount(int i)
    {
        scannedCount = i;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public ScanAppUserResult withItems(List list)
    {
        setItems(list);
        return this;
    }

    public ScanAppUserResult withLastUserId(String s)
    {
        setLastUserId(s);
        return this;
    }

    public ScanAppUserResult withScannedCount(int i)
    {
        setScannedCount(i);
        return this;
    }

    public ScanAppUserResult withTableName(String s)
    {
        setTableName(s);
        return this;
    }
}
