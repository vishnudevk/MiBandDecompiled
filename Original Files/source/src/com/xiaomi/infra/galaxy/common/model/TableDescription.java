// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            AccessMethod, TableStatus, TableType, AttributeDefinition

public class TableDescription
{

    private String accessMethod;
    private List attributeDefinitions;
    private Long creationDateTime;
    private Set grantedApps;
    private Long itemCount;
    private List keySchema;
    private String tableName;
    private Long tableSizeBytes;
    private String tableStatus;
    private String tableType;

    public TableDescription()
    {
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
        flag1 = obj instanceof TableDescription;
        flag = false;
        if (!flag1) goto _L4; else goto _L5
_L5:
        TableDescription tabledescription = (TableDescription)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag7;
        boolean flag10;
        int i;
        boolean flag13;
        boolean flag16;
        boolean flag19;
        boolean flag22;
        boolean flag23;
        boolean flag24;
        boolean flag25;
        boolean flag26;
        boolean flag27;
        boolean flag28;
        boolean flag29;
        if (tabledescription.getAttributeDefinitions() == null)
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
        if (tabledescription.getAttributeDefinitions() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag29 = tabledescription.getAttributeDefinitions().equals(getAttributeDefinitions());
        flag = false;
        if (!flag29) goto _L4; else goto _L7
_L7:
        boolean flag5;
        boolean flag6;
        if (tabledescription.getTableName() == null)
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
        if (tabledescription.getTableName() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag28 = tabledescription.getTableName().equals(getTableName());
        flag = false;
        if (!flag28) goto _L4; else goto _L9
_L9:
        boolean flag8;
        boolean flag9;
        if (tabledescription.getTableStatus() == null)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (getTableStatus() == null)
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
        if (tabledescription.getTableStatus() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag27 = tabledescription.getTableStatus().equals(getTableStatus());
        flag = false;
        if (!flag27) goto _L4; else goto _L11
_L11:
        i = tabledescription.getCreationDateTime() != getCreationDateTime();
        flag = false;
        if (i != 0) goto _L4; else goto _L12
_L12:
        boolean flag11;
        boolean flag12;
        if (tabledescription.getTableSizeBytes() == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (getTableSizeBytes() == null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        flag13 = flag11 ^ flag12;
        flag = false;
        if (flag13) goto _L4; else goto _L13
_L13:
        if (tabledescription.getTableSizeBytes() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag26 = tabledescription.getTableSizeBytes().equals(getTableSizeBytes());
        flag = false;
        if (!flag26) goto _L4; else goto _L14
_L14:
        boolean flag14;
        boolean flag15;
        if (tabledescription.getItemCount() == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (getItemCount() == null)
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        flag16 = flag14 ^ flag15;
        flag = false;
        if (flag16) goto _L4; else goto _L15
_L15:
        if (tabledescription.getItemCount() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag25 = tabledescription.getItemCount().equals(getItemCount());
        flag = false;
        if (!flag25) goto _L4; else goto _L16
_L16:
        boolean flag17;
        boolean flag18;
        if (tabledescription.getTableType() == null)
        {
            flag17 = true;
        } else
        {
            flag17 = false;
        }
        if (getTableType() == null)
        {
            flag18 = true;
        } else
        {
            flag18 = false;
        }
        flag19 = flag17 ^ flag18;
        flag = false;
        if (flag19) goto _L4; else goto _L17
_L17:
        if (tabledescription.getTableType() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag24 = tabledescription.getTableType().equals(getTableType());
        flag = false;
        if (!flag24) goto _L4; else goto _L18
_L18:
        boolean flag20;
        boolean flag21;
        if (tabledescription.getAccessMethod() == null)
        {
            flag20 = true;
        } else
        {
            flag20 = false;
        }
        if (getAccessMethod() == null)
        {
            flag21 = true;
        } else
        {
            flag21 = false;
        }
        flag22 = flag20 ^ flag21;
        flag = false;
        if (flag22) goto _L4; else goto _L19
_L19:
        if (tabledescription.getAccessMethod() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag23 = tabledescription.getAccessMethod().equals(getAccessMethod());
        flag = false;
        if (!flag23) goto _L4; else goto _L20
_L20:
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

    public long getCreationDateTime()
    {
        return creationDateTime.longValue();
    }

    public Set getGrantedApps()
    {
        return grantedApps;
    }

    public Long getItemCount()
    {
        return itemCount;
    }

    public List getKeySchema()
    {
        return keySchema;
    }

    public String getTableName()
    {
        return tableName;
    }

    public Long getTableSizeBytes()
    {
        return tableSizeBytes;
    }

    public String getTableStatus()
    {
        return tableStatus;
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
        int i2;
        int j2;
        int k2;
        int l2;
        String s;
        int i3;
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
        if (getTableStatus() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getTableStatus().hashCode();
        }
        j1 = 31 * (31 * (i1 + l) + (int)getCreationDateTime());
        if (getTableSizeBytes() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getTableSizeBytes().hashCode();
        }
        l1 = 31 * (k1 + j1);
        if (getItemCount() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getItemCount().hashCode();
        }
        j2 = 31 * (i2 + l1);
        if (getTableType() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getTableType().hashCode();
        }
        l2 = 31 * (k2 + j2);
        s = getAccessMethod();
        i3 = 0;
        if (s != null)
        {
            i3 = getAccessMethod().hashCode();
        }
        return l2 + i3;
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

    public void setCreationDateTime(long l)
    {
        creationDateTime = Long.valueOf(l);
    }

    public void setGrantedApps(Set set)
    {
        grantedApps = set;
    }

    public void setItemCount(Long long1)
    {
        itemCount = long1;
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

    public void setTableName(String s)
    {
        tableName = s;
    }

    public void setTableSizeBytes(Long long1)
    {
        tableSizeBytes = long1;
    }

    public void setTableStatus(String s)
    {
        tableStatus = s;
    }

    public void setTableType(String s)
    {
        tableType = s;
    }

    public TableDescription withAccessMethod(AccessMethod accessmethod)
    {
        setAccessMethod(accessmethod.name());
        return this;
    }

    public TableDescription withAttributeDefinitions(Collection collection)
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

    public transient TableDescription withAttributeDefinitions(AttributeDefinition aattributedefinition[])
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

    public TableDescription withCreationDateTime(long l)
    {
        creationDateTime = Long.valueOf(l);
        return this;
    }

    public TableDescription withGrantedApps(Set set)
    {
        setGrantedApps(set);
        return this;
    }

    public TableDescription withItemCount(Long long1)
    {
        itemCount = long1;
        return this;
    }

    public TableDescription withKeySchema(Collection collection)
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

    public transient TableDescription withKeySchema(String as[])
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

    public TableDescription withTableName(String s)
    {
        tableName = s;
        return this;
    }

    public TableDescription withTableSizeBytes(Long long1)
    {
        tableSizeBytes = long1;
        return this;
    }

    public TableDescription withTableStatus(TableStatus tablestatus)
    {
        tableStatus = tablestatus.toString();
        return this;
    }

    public TableDescription withTableStatus(String s)
    {
        tableStatus = s;
        return this;
    }

    public TableDescription withTableType(TableType tabletype)
    {
        setTableType(tabletype.name());
        return this;
    }
}
