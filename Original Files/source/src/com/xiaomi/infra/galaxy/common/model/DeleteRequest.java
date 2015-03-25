// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, AttributeValue, Verifier, ComplexCondition, 
//            Condition

public class DeleteRequest extends Request
{

    private ComplexCondition condition;
    private Map key;
    private String tableName;
    private String userId;

    public DeleteRequest()
    {
    }

    public DeleteRequest addKey(String s, Object obj)
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
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if (obj == null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        flag1 = obj instanceof DeleteRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        DeleteRequest deleterequest = (DeleteRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        if (deleterequest.getTableName() == null)
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
        if (flag4) goto _L4; else goto _L6
_L6:
        if (deleterequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag13 = deleterequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag13) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (deleterequest.getCondition() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getCondition() == null)
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
        if (deleterequest.getCondition() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag12 = deleterequest.getCondition().equals(getCondition());
        flag = false;
        if (!flag12) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (deleterequest.getKey() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getKey() == null)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        flag10 = flag8 ^ flag9;
        flag = false;
        if (flag10) goto _L4; else goto _L10
_L10:
        if (deleterequest.getKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag11 = deleterequest.getKey().equals(getKey());
        flag = false;
        if (!flag11) goto _L4; else goto _L11
_L11:
        return true;
    }

    public ComplexCondition getCondition()
    {
        return condition;
    }

    public Map getKey()
    {
        return key;
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
        Map map;
        int i1;
        if (getTableName() == null)
        {
            i = 0;
        } else
        {
            i = getTableName().hashCode();
        }
        j = 31 * (i + 31);
        if (getCondition() == null)
        {
            k = 0;
        } else
        {
            k = getCondition().hashCode();
        }
        l = 31 * (k + j);
        map = getKey();
        i1 = 0;
        if (map != null)
        {
            i1 = getKey().hashCode();
        }
        return l + i1;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.Delete);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setCondition(ComplexCondition complexcondition)
    {
        condition = complexcondition;
    }

    public void setKey(Map map)
    {
        key = map;
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
        Verifier.validateTableName(tableName);
        if (key == null || key.isEmpty())
        {
            throw new GalaxyClientException(ReturnCode.KEY_VALUES_IS_EMPTY);
        }
        Verifier.validateKeyValues(key, false);
        if (condition != null)
        {
            if (condition.getComplexConditions() != null)
            {
                throw new GalaxyClientException(ReturnCode.COMPLEX_CONDITION_NOT_SUPPORTED, "delete action expected 0 or 1 simple condition");
            }
            if (condition.getConditions() != null && condition.getConditions().size() != 1)
            {
                throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS, (new StringBuilder()).append("delete action expected 0 or 1, but got ").append(condition.getConditions().size()).append(" simple condition").toString());
            }
            ((Condition)condition.getConditions().get(0)).validate();
        }
    }

    public DeleteRequest withCondition(ComplexCondition complexcondition)
    {
        setCondition(complexcondition);
        return this;
    }

    public DeleteRequest withKey(Map map)
    {
        setKey(map);
        return this;
    }

    public DeleteRequest withTableName(String s)
    {
        setTableName(s);
        return this;
    }

    public DeleteRequest withUserId(String s)
    {
        setUserId(s);
        return this;
    }
}
