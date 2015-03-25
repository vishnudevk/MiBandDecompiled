// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package de.greenrobot.dao:
//            AbstractDaoSession

public abstract class AbstractDaoMaster
{

    protected final Map daoConfigMap = new HashMap();
    protected final SQLiteDatabase db;
    protected final int schemaVersion;

    public AbstractDaoMaster(SQLiteDatabase sqlitedatabase, int i)
    {
        db = sqlitedatabase;
        schemaVersion = i;
    }

    public SQLiteDatabase getDatabase()
    {
        return db;
    }

    public int getSchemaVersion()
    {
        return schemaVersion;
    }

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType identityscopetype);

    protected void registerDaoClass(Class class1)
    {
        DaoConfig daoconfig = new DaoConfig(db, class1);
        daoConfigMap.put(class1, daoconfig);
    }
}
