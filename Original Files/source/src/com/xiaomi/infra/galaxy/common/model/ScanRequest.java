// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, RowKey, Verifier, CollisionCheckStack, 
//            ComplexCondition

public class ScanRequest extends Request
{

    private List attributes;
    private ComplexCondition condition;
    private int limit;
    private boolean reverse;
    private RowKey startKey;
    private RowKey stopKey;
    private String tableName;
    private String userId;

    public ScanRequest()
    {
        reverse = false;
    }

    public void addAttribute(String s)
    {
        if (attributes == null)
        {
            attributes = new ArrayList();
        }
        attributes.add(s);
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
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = obj instanceof ScanRequest;
        flag = false;
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        ScanRequest scanrequest = (ScanRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        boolean flag13;
        boolean flag16;
        int i;
        int j;
        boolean flag17;
        boolean flag18;
        boolean flag19;
        boolean flag20;
        boolean flag21;
        boolean flag22;
        boolean flag23;
        if (scanrequest.getTableName() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getTableName() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag4 = flag2 ^ flag3;
        flag = false;
        if (flag4)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (scanrequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag23 = scanrequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag23) goto _L4; else goto _L3
_L3:
        boolean flag5;
        boolean flag6;
        if (scanrequest.getAttributes() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getAttributes() == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        flag7 = flag5 ^ flag6;
        flag = false;
        if (flag7)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (scanrequest.getAttributes() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag22 = scanrequest.getAttributes().equals(getAttributes());
        flag = false;
        if (!flag22) goto _L4; else goto _L5
_L5:
        boolean flag8;
        boolean flag9;
        if (scanrequest.getCondition() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getCondition() == null)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        flag10 = flag8 ^ flag9;
        flag = false;
        if (flag10)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (scanrequest.getCondition() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag21 = scanrequest.getCondition().equals(getCondition());
        flag = false;
        if (!flag21) goto _L4; else goto _L6
_L6:
        boolean flag11;
        boolean flag12;
        if (scanrequest.getStartKey() == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (getStartKey() == null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        flag13 = flag11 ^ flag12;
        flag = false;
        if (flag13)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (scanrequest.getStartKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag20 = scanrequest.getStartKey().equals(getStartKey());
        flag = false;
        if (!flag20) goto _L4; else goto _L7
_L7:
        boolean flag14;
        boolean flag15;
        if (scanrequest.getStopKey() == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (getStopKey() == null)
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        flag16 = flag14 ^ flag15;
        flag = false;
        if (flag16)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (scanrequest.getStopKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag19 = scanrequest.getStopKey().equals(getStopKey());
        flag = false;
        if (!flag19) goto _L4; else goto _L8
_L8:
        i = scanrequest.getLimit();
        j = getLimit();
        flag = false;
        if (i == j)
        {
            flag17 = scanrequest.getReverse();
            flag18 = getReverse();
            flag = false;
            if (flag17 == flag18)
            {
                return true;
            }
        }
        if (true) goto _L4; else goto _L9
_L9:
    }

    public List getAttributes()
    {
        return attributes;
    }

    public ComplexCondition getCondition()
    {
        return condition;
    }

    public int getLimit()
    {
        return limit;
    }

    public boolean getReverse()
    {
        return reverse;
    }

    public RowKey getStartKey()
    {
        return startKey;
    }

    public RowKey getStopKey()
    {
        return stopKey;
    }

    public String getTableName()
    {
        return tableName;
    }

    public String getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        RowKey rowkey;
        int i2;
        if (getTableName() == null)
        {
            i = 0;
        } else
        {
            i = getTableName().hashCode();
        }
        j = 31 * (i + 31);
        if (getAttributes() == null)
        {
            k = 0;
        } else
        {
            k = getAttributes().hashCode();
        }
        l = 31 * (k + j);
        if (getCondition() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getCondition().hashCode();
        }
        j1 = 31 * (i1 + l);
        if (getStartKey() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getStartKey().hashCode();
        }
        l1 = 31 * (k1 + j1);
        rowkey = getStopKey();
        i2 = 0;
        if (rowkey != null)
        {
            i2 = getStopKey().hashCode();
        }
        return 31 * (l1 + i2) + getLimit();
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.Scan);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAttributes(List list)
    {
        attributes = list;
    }

    public void setCondition(ComplexCondition complexcondition)
    {
        condition = complexcondition;
    }

    public void setLimit(int i)
    {
        limit = i;
    }

    public void setReverse(boolean flag)
    {
        reverse = flag;
    }

    public void setStartKey(RowKey rowkey)
    {
        startKey = rowkey;
    }

    public void setStopKey(RowKey rowkey)
    {
        stopKey = rowkey;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void setUserId(String s)
    {
        userId = s;
    }

    public void validate()
    {
        Verifier.validateTableName(tableName, false);
        Verifier.validateKeyValues(startKey, false);
        Verifier.validateKeyValues(stopKey, false);
        Verifier.validateAttributeNames(attributes, false);
        if (condition != null)
        {
            condition.check(new CollisionCheckStack());
        }
    }

    public ScanRequest withAttributes(List list)
    {
        setAttributes(list);
        return this;
    }

    public ScanRequest withCondition(ComplexCondition complexcondition)
    {
        setCondition(complexcondition);
        return this;
    }

    public ScanRequest withLimit(int i)
    {
        setLimit(i);
        return this;
    }

    public ScanRequest withReverse(boolean flag)
    {
        setReverse(flag);
        return this;
    }

    public ScanRequest withStartKey(RowKey rowkey)
    {
        setStartKey(rowkey);
        return this;
    }

    public ScanRequest withStopKey(RowKey rowkey)
    {
        setStopKey(rowkey);
        return this;
    }

    public ScanRequest withTableName(String s)
    {
        setTableName(s);
        return this;
    }

    public ScanRequest withUserId(String s)
    {
        setUserId(s);
        return this;
    }
}
