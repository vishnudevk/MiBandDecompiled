// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;

// Referenced classes of package de.greenrobot.dao.query:
//            AbstractQueryData, DeleteQuery, AbstractQuery

final class <init> extends AbstractQueryData
{

    protected volatile AbstractQuery createQuery()
    {
        return createQuery();
    }

    protected DeleteQuery createQuery()
    {
        return new DeleteQuery(this, dao, sql, (String[])initialValues.clone(), null);
    }

    private (AbstractDao abstractdao, String s, String as[])
    {
        super(abstractdao, s, as);
    }

    t>(AbstractDao abstractdao, String s, String as[], t> t>)
    {
        this(abstractdao, s, as);
    }
}
