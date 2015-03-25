// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;

// Referenced classes of package de.greenrobot.dao.query:
//            AbstractQueryData, Query, AbstractQuery

final class offsetPosition extends AbstractQueryData
{

    private final int limitPosition;
    private final int offsetPosition;

    protected volatile AbstractQuery createQuery()
    {
        return createQuery();
    }

    protected Query createQuery()
    {
        return new Query(this, dao, sql, (String[])initialValues.clone(), limitPosition, offsetPosition, null);
    }

    a(AbstractDao abstractdao, String s, String as[], int i, int j)
    {
        super(abstractdao, s, as);
        limitPosition = i;
        offsetPosition = j;
    }
}
