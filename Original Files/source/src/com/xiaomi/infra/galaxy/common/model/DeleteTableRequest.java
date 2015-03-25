// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Constants;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request

public class DeleteTableRequest extends Request
{

    private String tableName;

    public DeleteTableRequest()
    {
    }

    public DeleteTableRequest(String s)
    {
        setTableName(s);
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
        flag1 = obj instanceof DeleteTableRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        DeleteTableRequest deletetablerequest = (DeleteTableRequest)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if (deletetablerequest.getTableName() == null)
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
        if (deletetablerequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = deletetablerequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag5) goto _L4; else goto _L7
_L7:
        return true;
    }

    public String getTableName()
    {
        return tableName;
    }

    public int hashCode()
    {
        int i;
        if (getTableName() == null)
        {
            i = 0;
        } else
        {
            i = getTableName().hashCode();
        }
        return i + 31;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(APILevel.Developer);
        targetaction.setOperation(Operation.DeleteTable);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void validate()
    {
        if (StringUtils.isBlank(tableName))
        {
            throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_BLANK);
        }
        if (!Constants.TableNamePattern.matcher(tableName).matches())
        {
            throw new GalaxyClientException(ReturnCode.TABLE_NAME_IS_INVALID, tableName);
        } else
        {
            return;
        }
    }

    public DeleteTableRequest withTableName(String s)
    {
        tableName = s;
        return this;
    }
}
