// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.internal.DaoConfig;

// Referenced classes of package de.greenrobot.daobracelet:
//            LuaZipFile, DaoSession

public class LuaZipFileDao extends AbstractDao
{

    public static final String TABLENAME = "LUA_ZIP_FILE";

    public LuaZipFileDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public LuaZipFileDao(DaoConfig daoconfig, DaoSession daosession)
    {
        super(daoconfig, daosession);
    }

    public static void createTable(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        String s;
        if (flag)
        {
            s = "IF NOT EXISTS ";
        } else
        {
            s = "";
        }
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(s).append("'LUA_ZIP_FILE' (").append("'_id' INTEGER PRIMARY KEY ,").append("'VERSION' TEXT,").append("'DATE' TEXT,").append("'ZIP_FILE' BLOB);").toString());
    }

    public static void dropTable(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("DROP TABLE ");
        String s;
        if (flag)
        {
            s = "IF EXISTS ";
        } else
        {
            s = "";
        }
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'LUA_ZIP_FILE'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, LuaZipFile luazipfile)
    {
        sqlitestatement.clearBindings();
        Long long1 = luazipfile.getId();
        if (long1 != null)
        {
            sqlitestatement.bindLong(1, long1.longValue());
        }
        String s = luazipfile.getVersion();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        String s1 = luazipfile.getDate();
        if (s1 != null)
        {
            sqlitestatement.bindString(3, s1);
        }
        byte abyte0[] = luazipfile.getZipFile();
        if (abyte0 != null)
        {
            sqlitestatement.bindBlob(4, abyte0);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (LuaZipFile)obj);
    }

    public Long getKey(LuaZipFile luazipfile)
    {
        if (luazipfile != null)
        {
            return luazipfile.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((LuaZipFile)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public LuaZipFile readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        boolean flag;
        byte abyte0[];
        if (cursor.isNull(i + 0))
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(cursor.getLong(i + 0));
        }
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        if (cursor.isNull(i + 2))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 2);
        }
        flag = cursor.isNull(i + 3);
        abyte0 = null;
        if (!flag)
        {
            abyte0 = cursor.getBlob(i + 3);
        }
        return new LuaZipFile(long1, s, s1, abyte0);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, LuaZipFile luazipfile, int i)
    {
        Long long1;
        String s;
        String s1;
        boolean flag;
        byte abyte0[];
        if (cursor.isNull(i + 0))
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(cursor.getLong(i + 0));
        }
        luazipfile.setId(long1);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        luazipfile.setVersion(s);
        if (cursor.isNull(i + 2))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 2);
        }
        luazipfile.setDate(s1);
        flag = cursor.isNull(i + 3);
        abyte0 = null;
        if (!flag)
        {
            abyte0 = cursor.getBlob(i + 3);
        }
        luazipfile.setZipFile(abyte0);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (LuaZipFile)obj, i);
    }

    public Long readKey(Cursor cursor, int i)
    {
        if (cursor.isNull(i + 0))
        {
            return null;
        } else
        {
            return Long.valueOf(cursor.getLong(i + 0));
        }
    }

    public volatile Object readKey(Cursor cursor, int i)
    {
        return readKey(cursor, i);
    }

    protected Long updateKeyAfterInsert(LuaZipFile luazipfile, long l)
    {
        luazipfile.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((LuaZipFile)obj, l);
    }
}
