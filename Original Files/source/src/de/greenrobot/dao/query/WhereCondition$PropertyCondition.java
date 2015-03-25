// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import java.util.Date;

public class op extends op
{

    public final String op;
    public final Property property;

    private static Object checkValueForType(Property property1, Object obj)
    {
        if (obj != null && obj.getClass().isArray())
        {
            throw new DaoException("Illegal value: found array, but simple object required");
        }
        if (property1.type != java/util/Date) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof Date)) goto _L4; else goto _L3
_L3:
        obj = Long.valueOf(((Date)obj).getTime());
_L6:
        return obj;
_L4:
        if (obj instanceof Long) goto _L6; else goto _L5
_L5:
        throw new DaoException((new StringBuilder()).append("Illegal date value: expected java.util.Date or Long for value ").append(obj).toString());
_L2:
        if (property1.type != Boolean.TYPE && property1.type != java/lang/Boolean) goto _L6; else goto _L7
_L7:
        int i;
        if (obj instanceof Boolean)
        {
            int j;
            if (((Boolean)obj).booleanValue())
            {
                j = 1;
            } else
            {
                j = 0;
            }
            return Integer.valueOf(j);
        }
        if (!(obj instanceof Number))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((Number)obj).intValue();
        if (i == 0 || i == 1) goto _L6; else goto _L8
_L8:
        throw new DaoException((new StringBuilder()).append("Illegal boolean value: numbers must be 0 or 1, but was ").append(obj).toString());
        if (!(obj instanceof String)) goto _L6; else goto _L9
_L9:
        String s = (String)obj;
        if ("TRUE".equalsIgnoreCase(s))
        {
            return Integer.valueOf(1);
        }
        if ("FALSE".equalsIgnoreCase(s))
        {
            return Integer.valueOf(0);
        } else
        {
            throw new DaoException((new StringBuilder()).append("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was ").append(obj).toString());
        }
    }

    private static Object[] checkValuesForType(Property property1, Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            aobj[i] = checkValueForType(property1, aobj[i]);
        }

        return aobj;
    }

    public void appendTo(StringBuilder stringbuilder, String s)
    {
        if (s != null)
        {
            stringbuilder.append(s).append('.');
        }
        stringbuilder.append('\'').append(property.columnName).append('\'').append(op);
    }

    public (Property property1, String s)
    {
        property = property1;
        op = s;
    }

    public op(Property property1, String s, Object obj)
    {
        super(checkValueForType(property1, obj));
        property = property1;
        op = s;
    }

    public op(Property property1, String s, Object aobj[])
    {
        super(checkValuesForType(property1, aobj));
        property = property1;
        op = s;
    }
}
