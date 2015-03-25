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
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Request, Verifier, TableType, AccessMethod, 
//            AttributeDefinition, AttributeType

public class CreateTableRequest extends Request
{

    private String accessMethod;
    private List attributeDefinitions;
    private List keySchema;
    private String tableName;
    private String tableType;

    public CreateTableRequest()
    {
    }

    public CreateTableRequest(String s, List list)
    {
        setTableName(s);
        setKeySchema(list);
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
        flag1 = obj instanceof CreateTableRequest;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        CreateTableRequest createtablerequest = (CreateTableRequest)obj;
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
        if (createtablerequest.getAttributeDefinitions() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getAttributeDefinitions() == null)
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
        if (createtablerequest.getAttributeDefinitions() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag21 = createtablerequest.getAttributeDefinitions().equals(getAttributeDefinitions());
        flag = false;
        if (!flag21) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (createtablerequest.getTableName() == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (getTableName() == null)
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
        if (createtablerequest.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag20 = createtablerequest.getTableName().equals(getTableName());
        flag = false;
        if (!flag20) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (createtablerequest.getKeySchema() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getKeySchema() == null)
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
        if (createtablerequest.getKeySchema() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag19 = createtablerequest.getKeySchema().equals(getKeySchema());
        flag = false;
        if (!flag19) goto _L4; else goto _L11
_L11:
        boolean flag11;
        boolean flag12;
        if (createtablerequest.getTableType() == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (getTableType() == null)
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
        if (createtablerequest.getTableType() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag18 = createtablerequest.getTableType().equals(getTableType());
        flag = false;
        if (!flag18) goto _L4; else goto _L13
_L13:
        boolean flag14;
        boolean flag15;
        if (createtablerequest.getAccessMethod() == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (getAccessMethod() == null)
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
        if (createtablerequest.getAccessMethod() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag17 = createtablerequest.getAccessMethod().equals(getAccessMethod());
        flag = false;
        if (!flag17) goto _L4; else goto _L15
_L15:
        return true;
    }

    public String getAccessMethod()
    {
        return accessMethod;
    }

    public List getAttributeDefinitions()
    {
        return attributeDefinitions;
    }

    public List getKeySchema()
    {
        return keySchema;
    }

    public String getTableName()
    {
        return tableName;
    }

    public String getTableType()
    {
        return tableType;
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
        String s;
        int i2;
        if (getAttributeDefinitions() == null)
        {
            i = 0;
        } else
        {
            i = getAttributeDefinitions().hashCode();
        }
        j = 31 * (i + 31);
        if (getTableName() == null)
        {
            k = 0;
        } else
        {
            k = getTableName().hashCode();
        }
        l = 31 * (k + j);
        if (getKeySchema() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getKeySchema().hashCode();
        }
        j1 = 31 * (i1 + l);
        if (getTableType() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getTableType().hashCode();
        }
        l1 = 31 * (k1 + j1);
        s = getAccessMethod();
        i2 = 0;
        if (s != null)
        {
            i2 = getAccessMethod().hashCode();
        }
        return l1 + i2;
    }

    public BasicGalaxyRequest internalGetGalaxyRequest(String s, APILevel apilevel)
    {
        BasicGalaxyRequest basicgalaxyrequest = new BasicGalaxyRequest(this, "Galaxy");
        TargetAction targetaction = new TargetAction();
        targetaction.setApiVersion(GalaxyVersion.getVersion());
        targetaction.setLevel(APILevel.Developer);
        targetaction.setOperation(Operation.CreateTable);
        targetaction.setServiceName("Galaxy");
        basicgalaxyrequest.addHeader("X-XiaoMi-Action", targetaction.format());
        super.setRequestContent(basicgalaxyrequest, s);
        return basicgalaxyrequest;
    }

    public void setAccessMethod(String s)
    {
        accessMethod = s;
    }

    public void setAttributeDefinitions(Collection collection)
    {
        if (collection == null)
        {
            attributeDefinitions = null;
            return;
        } else
        {
            ArrayList arraylist = new ArrayList(collection.size());
            arraylist.addAll(collection);
            attributeDefinitions = arraylist;
            return;
        }
    }

    public void setAttributeDefinitions(List list)
    {
        attributeDefinitions = list;
    }

    public void setKeySchema(Collection collection)
    {
        if (collection == null)
        {
            keySchema = null;
            return;
        } else
        {
            ArrayList arraylist = new ArrayList(collection.size());
            arraylist.addAll(collection);
            keySchema = arraylist;
            return;
        }
    }

    public void setKeySchema(List list)
    {
        keySchema = list;
    }

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void setTableType(String s)
    {
        tableType = s;
    }

    public void validate()
    {
        Verifier.validateTableName(tableName);
        TableType tabletype;
        AccessMethod accessmethod;
        try
        {
            tabletype = TableType.fromValue(tableType);
        }
        catch (Exception exception)
        {
            throw new GalaxyClientException(ReturnCode.TABLE_TYPE_IS_INVALID, tableType);
        }
        try
        {
            accessmethod = AccessMethod.fromValue(accessMethod);
        }
        catch (Exception exception1)
        {
            throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_INVALID, accessMethod);
        }
        if (tabletype == TableType.USER && accessmethod != AccessMethod.LoginReadLoginWrite)
        {
            throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_INVALID, (new StringBuilder()).append("user table can only be accessed by ").append(AccessMethod.LoginReadLoginWrite).append(" access method, actuly :").append(accessMethod).toString());
        }
        if (attributeDefinitions == null || attributeDefinitions.isEmpty())
        {
            throw new GalaxyClientException(ReturnCode.ATTRIBUTE_DEFINITIONS_IS_NULL);
        }
        HashSet hashset = new HashSet();
        Iterator iterator = attributeDefinitions.iterator();
        while (iterator.hasNext()) 
        {
            AttributeDefinition attributedefinition = (AttributeDefinition)iterator.next();
            attributedefinition.validate();
            String s1 = attributedefinition.getAttributeName();
            if (hashset.contains(s1))
            {
                throw new GalaxyClientException(ReturnCode.DUPLICATE_ATTRIBUTE_NAME, s1);
            }
            try
            {
                AttributeType.fromValue(attributedefinition.getAttributeType());
            }
            catch (Exception exception2)
            {
                throw new GalaxyClientException(ReturnCode.ATTRIBUTE_TYPE_IS_INVALID, (new StringBuilder()).append(s1).append("(").append(null).append(")").toString());
            }
            hashset.add(s1);
        }
        if (keySchema != null)
        {
            HashSet hashset1 = new HashSet();
            Iterator iterator1 = keySchema.iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                if (StringUtils.isBlank(s))
                {
                    throw new GalaxyClientException(ReturnCode.KEY_NAME_IS_BLANK);
                }
                if (!hashset.contains(s))
                {
                    throw new GalaxyClientException(ReturnCode.KEY_NAME_IS_UNDEFINED, s);
                }
                if (hashset1.contains(s))
                {
                    throw new GalaxyClientException(ReturnCode.DUPLICATE_KEY_NAME, s);
                }
                hashset1.add(s);
            }
        }
    }

    public CreateTableRequest withAccessMethod(AccessMethod accessmethod)
    {
        setAccessMethod(accessmethod.name());
        return this;
    }

    public CreateTableRequest withAttributeDefinitions(Collection collection)
    {
        if (collection == null)
        {
            attributeDefinitions = null;
            return this;
        } else
        {
            ArrayList arraylist = new ArrayList(collection.size());
            arraylist.addAll(collection);
            attributeDefinitions = arraylist;
            return this;
        }
    }

    public transient CreateTableRequest withAttributeDefinitions(AttributeDefinition aattributedefinition[])
    {
        if (getAttributeDefinitions() == null)
        {
            setAttributeDefinitions(new ArrayList(aattributedefinition.length));
        }
        int i = aattributedefinition.length;
        for (int j = 0; j < i; j++)
        {
            AttributeDefinition attributedefinition = aattributedefinition[j];
            getAttributeDefinitions().add(attributedefinition);
        }

        return this;
    }

    public CreateTableRequest withKeySchema(Collection collection)
    {
        if (collection == null)
        {
            keySchema = null;
            return this;
        } else
        {
            ArrayList arraylist = new ArrayList(collection.size());
            arraylist.addAll(collection);
            keySchema = arraylist;
            return this;
        }
    }

    public transient CreateTableRequest withKeySchema(String as[])
    {
        if (getKeySchema() == null)
        {
            setKeySchema(new ArrayList(as.length));
        }
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            String s = as[j];
            getKeySchema().add(s);
        }

        return this;
    }

    public CreateTableRequest withTableName(String s)
    {
        tableName = s;
        return this;
    }

    public CreateTableRequest withTableType(TableType tabletype)
    {
        setTableType(tabletype.name());
        return this;
    }
}
