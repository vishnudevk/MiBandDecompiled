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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, AttributeValue, Verifier

public class GetRequest extends Request
{

    private List attributes;
    private Map key;
    private String tableName;
    private String userId;

    public GetRequest()
    {
    }

    public void addAttribute(String s)
    {
        if (attributes == null)
        {
            attributes = new ArrayList();
        }
        attributes.add(s);
    }

    public GetRequest addKey(String s, Object obj)
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
        flag1 = obj instanceof GetRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        GetRequest getrequest = (GetRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        boolean flag13;
        if (getrequest.getTableName() == null)
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
        if (getrequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag13 = getrequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag13) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (getrequest.getKey() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getKey() == null)
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
        if (getrequest.getKey() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag12 = getrequest.getKey().equals(getKey());
        flag = false;
        if (!flag12) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (getrequest.getAttributes() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getAttributes() == null)
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
        if (getrequest.getAttributes() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag11 = getrequest.getAttributes().equals(getAttributes());
        flag = false;
        if (!flag11) goto _L4; else goto _L11
_L11:
        return true;
    }

    public List getAttributes()
    {
        return attributes;
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
        List list;
        int i1;
        if (getTableName() == null)
        {
            i = 0;
        } else
        {
            i = getTableName().hashCode();
        }
        j = 31 * (i + 31);
        if (getKey() == null)
        {
            k = 0;
        } else
        {
            k = getKey().hashCode();
        }
        l = 31 * (k + j);
        list = getAttributes();
        i1 = 0;
        if (list != null)
        {
            i1 = getAttributes().hashCode();
        }
        return l + i1;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(apilevel);
        targetaction.setOperation(Operation.Get);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAttributes(List list)
    {
        attributes = list;
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
        if (key == null || key.isEmpty())
        {
            throw new GalaxyClientException(ReturnCode.KEY_VALUES_IS_EMPTY);
        } else
        {
            Verifier.validateKeyValues(key, false);
            Verifier.validateAttributeNames(attributes, false);
            return;
        }
    }

    public GetRequest withAttributes(List list)
    {
        setAttributes(list);
        return this;
    }

    public GetRequest withKey(Map map)
    {
        key = map;
        return this;
    }

    public GetRequest withTableName(String s)
    {
        setTableName(s);
        return this;
    }

    public GetRequest withUserId(String s)
    {
        setUserId(s);
        return this;
    }
}
