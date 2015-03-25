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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, AttributeValue, Verifier, Action, 
//            AttributeType, ComplexCondition, Condition

public class SetRequest extends Request
{

    private String action;
    private Map attributeValues;
    private ComplexCondition condition;
    private Map key;
    private String tableName;
    private String userId;

    public SetRequest()
    {
    }

    public SetRequest addAttributeValue(String s, Object obj)
    {
        if (attributeValues == null)
        {
            attributeValues = new HashMap();
        }
        AttributeValue.putAttributeValueInMap(attributeValues, s, obj);
        return this;
    }

    public SetRequest addKey(String s, Object obj)
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
        flag1 = obj instanceof SetRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        SetRequest setrequest = (SetRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        boolean flag13;
        boolean flag16;
        boolean flag17;
        boolean flag18;
        boolean flag19;
        boolean flag20;
        boolean flag21;
        if (setrequest.getTableName() == null)
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
        if (setrequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag21 = setrequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag21) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (setrequest.getAction() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getAction() == null)
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
        if (setrequest.getAction() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag20 = setrequest.getAction().equals(getAction());
        flag = false;
        if (!flag20) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (setrequest.getAttributeValues() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getAttributeValues() == null)
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
        if (setrequest.getAttributeValues() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag19 = setrequest.getAttributeValues().equals(getAttributeValues());
        flag = false;
        if (!flag19) goto _L4; else goto _L11
_L11:
        boolean flag11;
        boolean flag12;
        if (setrequest.getCondition() == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (getCondition() == null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        flag13 = flag11 ^ flag12;
        flag = false;
        if (flag13) goto _L4; else goto _L12
_L12:
        if (setrequest.getCondition() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag18 = setrequest.getCondition().equals(getCondition());
        flag = false;
        if (!flag18) goto _L4; else goto _L13
_L13:
        boolean flag14;
        boolean flag15;
        if (setrequest.getKey() == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (getKey() == null)
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        flag16 = flag14 ^ flag15;
        flag = false;
        if (flag16) goto _L4; else goto _L14
_L14:
        if (setrequest.getKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag17 = setrequest.getKey().equals(getKey());
        flag = false;
        if (!flag17) goto _L4; else goto _L15
_L15:
        return true;
    }

    public String getAction()
    {
        return action;
    }

    public Map getAttributeValues()
    {
        return attributeValues;
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
        int i1;
        int j1;
        int k1;
        int l1;
        Map map;
        int i2;
        if (getTableName() == null)
        {
            i = 0;
        } else
        {
            i = getTableName().hashCode();
        }
        j = 31 * (i + 31);
        if (getAction() == null)
        {
            k = 0;
        } else
        {
            k = getAction().hashCode();
        }
        l = 31 * (k + j);
        if (getAttributeValues() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getAttributeValues().hashCode();
        }
        j1 = 31 * (i1 + l);
        if (getCondition() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getCondition().hashCode();
        }
        l1 = 31 * (k1 + j1);
        map = getKey();
        i2 = 0;
        if (map != null)
        {
            i2 = getKey().hashCode();
        }
        return l1 + i2;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.Set);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAction(String s)
    {
        action = s;
    }

    public void setAttributeValues(Map map)
    {
        attributeValues = map;
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
        Verifier.validateTableName(tableName, false);
        Verifier.validateKeyValues(key, false);
        Action action1;
        try
        {
            action1 = Action.fromValue(action);
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            throw galaxyclientexception;
        }
        if (attributeValues != null && !attributeValues.isEmpty())
        {
            Iterator iterator = attributeValues.entrySet().iterator();
label0:
            do
            {
                String s;
                AttributeValue attributevalue;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    s = (String)entry.getKey();
                    attributevalue = (AttributeValue)entry.getValue();
                    Verifier.validateAttributeValue(s, attributevalue, false);
                } while (action1 != Action.ADD);
                AttributeType attributetype = AttributeType.fromValue(attributevalue.getType());
                switch (_cls1..SwitchMap.com.xiaomi.infra.galaxy.common.model.AttributeType[attributetype.ordinal()])
                {
                default:
                    throw new GalaxyClientException(ReturnCode.NEED_INTEGER_ATTRIBUTE_VALUE, (new StringBuilder()).append(s).append("(").append(attributetype).append(")").toString());

                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    break;
                }
            } while (true);
        }
        if (condition != null)
        {
            if (action1 == Action.PUT)
            {
                if (condition.getComplexConditions() != null)
                {
                    throw new GalaxyClientException(ReturnCode.COMPLEX_CONDITION_NOT_SUPPORTED, "put action expected 0 or 1 simple condition");
                }
                if (condition.getConditions() != null && condition.getConditions().size() != 1)
                {
                    throw new GalaxyClientException(ReturnCode.UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS, (new StringBuilder()).append("put action expected 0 or 1, but got ").append(condition.getConditions().size()).append(" condition").toString());
                }
                if (condition.getConditions() != null && !condition.getConditions().isEmpty())
                {
                    Condition condition1 = (Condition)condition.getConditions().get(0);
                    if (condition1 != null)
                    {
                        condition1.validate();
                    }
                }
            } else
            if (action1 == Action.ADD)
            {
                throw new GalaxyClientException(ReturnCode.CONDITION_NOT_SUPPORTED, "add action not use condition");
            }
        }
    }

    public SetRequest withAction(Action action1)
    {
        setAction(action1.name());
        return this;
    }

    public SetRequest withAttributeValues(Map map)
    {
        setAttributeValues(map);
        return this;
    }

    public SetRequest withCondition(ComplexCondition complexcondition)
    {
        setCondition(complexcondition);
        return this;
    }

    public SetRequest withKey(Map map)
    {
        setKey(map);
        return this;
    }

    public SetRequest withTableName(String s)
    {
        setTableName(s);
        return this;
    }

    public SetRequest withUserId(String s)
    {
        setUserId(s);
        return this;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[];

        static 
        {
            $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType = new int[AttributeType.values().length];
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT8.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT16.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT32.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType[AttributeType.INT64.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3)
            {
                return;
            }
        }
    }

}
