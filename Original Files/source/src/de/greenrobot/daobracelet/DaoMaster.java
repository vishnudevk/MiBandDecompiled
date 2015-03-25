// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

// Referenced classes of package de.greenrobot.daobracelet:
//            LuaListDao, LuaZipFileDao, DaoSession

public class DaoMaster extends AbstractDaoMaster
{

    public static final int SCHEMA_VERSION = 6;

    public DaoMaster(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase, 6);
        registerDaoClass(de/greenrobot/daobracelet/LuaListDao);
        registerDaoClass(de/greenrobot/daobracelet/LuaZipFileDao);
    }

    public static void createAllTables(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        LuaListDao.createTable(sqlitedatabase, flag);
        LuaZipFileDao.createTable(sqlitedatabase, flag);
    }

    public static void dropAllTables(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        LuaListDao.dropTable(sqlitedatabase, flag);
        LuaZipFileDao.dropTable(sqlitedatabase, flag);
    }

    public volatile AbstractDaoSession newSession()
    {
        return newSession();
    }

    public volatile AbstractDaoSession newSession(IdentityScopeType identityscopetype)
    {
        return newSession(identityscopetype);
    }

    public DaoSession newSession()
    {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityscopetype)
    {
        return new DaoSession(db, identityscopetype, daoConfigMap);
    }
}
