// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Operator, Condition, CollisionCheckStack

public class ComplexCondition
{

    private List complexConditions;
    private List conditions;
    private String operator;

    public ComplexCondition()
    {
    }

    public ComplexCondition addComplexCondition(ComplexCondition complexcondition)
    {
        if (complexConditions == null)
        {
            complexConditions = new ArrayList();
        }
        complexConditions.add(complexcondition);
        return this;
    }

    public ComplexCondition addCondition(Condition condition)
    {
        if (conditions == null)
        {
            conditions = new ArrayList();
        }
        conditions.add(condition);
        return this;
    }

    public void check(CollisionCheckStack collisioncheckstack)
    {
        Operator.fromValue(operator);
        if (conditions != null)
        {
            for (Iterator iterator1 = conditions.iterator(); iterator1.hasNext(); ((Condition)iterator1.next()).validate()) { }
        }
        if (collisioncheckstack == null)
        {
            collisioncheckstack = new CollisionCheckStack();
        }
        if (collisioncheckstack.push(this))
        {
            throw new GalaxyClientException(ReturnCode.CONDITION_CYCLE_REFERENCE, (new StringBuilder()).append("cycle in marshaller, ").append(collisioncheckstack.getCycleString()).toString());
        }
        if (complexConditions != null)
        {
            for (Iterator iterator = complexConditions.iterator(); iterator.hasNext(); ((ComplexCondition)iterator.next()).check(collisioncheckstack)) { }
        }
    }

    public List getComplexConditions()
    {
        return complexConditions;
    }

    public List getConditions()
    {
        return conditions;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setComplexConditions(List list)
    {
        complexConditions = list;
    }

    public void setConditions(List list)
    {
        conditions = list;
    }

    public void setOperator(String s)
    {
        operator = s;
    }

    public ComplexCondition withComplexConditions(List list)
    {
        setComplexConditions(list);
        return this;
    }

    public ComplexCondition withConditions(List list)
    {
        setConditions(list);
        return this;
    }

    public ComplexCondition withOperator(Operator operator1)
    {
        setOperator(operator1.name());
        return this;
    }
}
