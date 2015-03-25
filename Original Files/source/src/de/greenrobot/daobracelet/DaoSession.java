// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

// Referenced classes of package de.greenrobot.daobracelet:
//            LuaListDao, LuaZipFileDao, LuaList, LuaZipFile

public class DaoSession extends AbstractDaoSession
{

    private final LuaListDao luaListDao;
    private final DaoConfig luaListDaoConfig;
    private final LuaZipFileDao luaZipFileDao;
    private final DaoConfig luaZipFileDaoConfig;

    public DaoSession(SQLiteDatabase sqlitedatabase, IdentityScopeType identityscopetype, Map map)
    {
        super(sqlitedatabase);
        luaListDaoConfig = ((DaoConfig)map.get(de/greenrobot/daobracelet/LuaListDao)).clone();
        luaListDaoConfig.initIdentityScope(identityscopetype);
        luaZipFileDaoConfig = ((DaoConfig)map.get(de/greenrobot/daobracelet/LuaZipFileDao)).clone();
        luaZipFileDaoConfig.initIdentityScope(identityscopetype);
        luaListDao = new LuaListDao(luaListDaoConfig, this);
        luaZipFileDao = new LuaZipFileDao(luaZipFileDaoConfig, this);
        registerDao(de/greenrobot/daobracelet/LuaList, luaListDao);
        registerDao(de/greenrobot/daobracelet/LuaZipFile, luaZipFileDao);
    }

    public void clear()
    {
        luaListDaoConfig.getIdentityScope().clear();
        luaZipFileDaoConfig.getIdentityScope().clear();
    }

    public LuaListDao getLuaListDao()
    {
        return luaListDao;
    }

    public LuaZipFileDao getLuaZipFileDao()
    {
        return luaZipFileDao;
    }
}
