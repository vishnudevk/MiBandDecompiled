// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.Cursor;
import de.greenrobot.dao.internal.TableStatements;
import java.util.List;

// Referenced classes of package de.greenrobot.dao:
//            AbstractDao

public final class InternalQueryDaoAccess
{

    private final AbstractDao dao;

    public InternalQueryDaoAccess(AbstractDao abstractdao)
    {
        dao = abstractdao;
    }

    public static TableStatements getStatements(AbstractDao abstractdao)
    {
        return abstractdao.getStatements();
    }

    public TableStatements getStatements()
    {
        return dao.getStatements();
    }

    public List loadAllAndCloseCursor(Cursor cursor)
    {
        return dao.loadAllAndCloseCursor(cursor);
    }

    public Object loadCurrent(Cursor cursor, int i, boolean flag)
    {
        return dao.loadCurrent(cursor, i, flag);
    }

    public Object loadUniqueAndCloseCursor(Cursor cursor)
    {
        return dao.loadUniqueAndCloseCursor(cursor);
    }
}
