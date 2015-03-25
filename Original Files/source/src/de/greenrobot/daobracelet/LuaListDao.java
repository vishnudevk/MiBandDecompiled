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
//            LuaList, DaoSession

public class LuaListDao extends AbstractDao
{

    public static final String TABLENAME = "LUA_LIST";

    public LuaListDao(DaoConfig daoconfig)
    {
        super(daoconfig);
    }

    public LuaListDao(DaoConfig daoconfig, DaoSession daosession)
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
        sqlitedatabase.execSQL((new StringBuilder()).append("CREATE TABLE ").append(s).append("'LUA_LIST' (").append("'_id' INTEGER PRIMARY KEY ,").append("'DATE' TEXT,").append("'TIME' TEXT,").append("'TYPE' TEXT,").append("'RIGHT' TEXT,").append("'INDEX' TEXT,").append("'JSON_STRING' TEXT,").append("'SCRIPT_VERSION' TEXT,").append("'LUA_ACTION_SCRIPT' TEXT,").append("'TEXT1' TEXT,").append("'TEXT2' TEXT,").append("'START' TEXT,").append("'STOP' TEXT);").toString());
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
        sqlitedatabase.execSQL(stringbuilder.append(s).append("'LUA_LIST'").toString());
    }

    protected void bindValues(SQLiteStatement sqlitestatement, LuaList lualist)
    {
        sqlitestatement.clearBindings();
        Long long1 = lualist.getId();
        if (long1 != null)
        {
            sqlitestatement.bindLong(1, long1.longValue());
        }
        String s = lualist.getDate();
        if (s != null)
        {
            sqlitestatement.bindString(2, s);
        }
        String s1 = lualist.getTime();
        if (s1 != null)
        {
            sqlitestatement.bindString(3, s1);
        }
        String s2 = lualist.getType();
        if (s2 != null)
        {
            sqlitestatement.bindString(4, s2);
        }
        String s3 = lualist.getRight();
        if (s3 != null)
        {
            sqlitestatement.bindString(5, s3);
        }
        String s4 = lualist.getIndex();
        if (s4 != null)
        {
            sqlitestatement.bindString(6, s4);
        }
        String s5 = lualist.getJsonString();
        if (s5 != null)
        {
            sqlitestatement.bindString(7, s5);
        }
        String s6 = lualist.getScriptVersion();
        if (s6 != null)
        {
            sqlitestatement.bindString(8, s6);
        }
        String s7 = lualist.getLuaActionScript();
        if (s7 != null)
        {
            sqlitestatement.bindString(9, s7);
        }
        String s8 = lualist.getText1();
        if (s8 != null)
        {
            sqlitestatement.bindString(10, s8);
        }
        String s9 = lualist.getText2();
        if (s9 != null)
        {
            sqlitestatement.bindString(11, s9);
        }
        String s10 = lualist.getStart();
        if (s10 != null)
        {
            sqlitestatement.bindString(12, s10);
        }
        String s11 = lualist.getStop();
        if (s11 != null)
        {
            sqlitestatement.bindString(13, s11);
        }
    }

    protected volatile void bindValues(SQLiteStatement sqlitestatement, Object obj)
    {
        bindValues(sqlitestatement, (LuaList)obj);
    }

    public Long getKey(LuaList lualist)
    {
        if (lualist != null)
        {
            return lualist.getId();
        } else
        {
            return null;
        }
    }

    public volatile Object getKey(Object obj)
    {
        return getKey((LuaList)obj);
    }

    protected boolean isEntityUpdateable()
    {
        return true;
    }

    public LuaList readEntity(Cursor cursor, int i)
    {
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
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
        if (cursor.isNull(i + 3))
        {
            s2 = null;
        } else
        {
            s2 = cursor.getString(i + 3);
        }
        if (cursor.isNull(i + 4))
        {
            s3 = null;
        } else
        {
            s3 = cursor.getString(i + 4);
        }
        if (cursor.isNull(i + 5))
        {
            s4 = null;
        } else
        {
            s4 = cursor.getString(i + 5);
        }
        if (cursor.isNull(i + 6))
        {
            s5 = null;
        } else
        {
            s5 = cursor.getString(i + 6);
        }
        if (cursor.isNull(i + 7))
        {
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 7);
        }
        if (cursor.isNull(i + 8))
        {
            s7 = null;
        } else
        {
            s7 = cursor.getString(i + 8);
        }
        if (cursor.isNull(i + 9))
        {
            s8 = null;
        } else
        {
            s8 = cursor.getString(i + 9);
        }
        if (cursor.isNull(i + 10))
        {
            s9 = null;
        } else
        {
            s9 = cursor.getString(i + 10);
        }
        if (cursor.isNull(i + 11))
        {
            s10 = null;
        } else
        {
            s10 = cursor.getString(i + 11);
        }
        if (cursor.isNull(i + 12))
        {
            s11 = null;
        } else
        {
            s11 = cursor.getString(i + 12);
        }
        return new LuaList(long1, s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
    }

    public volatile Object readEntity(Cursor cursor, int i)
    {
        return readEntity(cursor, i);
    }

    public void readEntity(Cursor cursor, LuaList lualist, int i)
    {
        Long long1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        boolean flag;
        String s11;
        if (cursor.isNull(i + 0))
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(cursor.getLong(i + 0));
        }
        lualist.setId(long1);
        if (cursor.isNull(i + 1))
        {
            s = null;
        } else
        {
            s = cursor.getString(i + 1);
        }
        lualist.setDate(s);
        if (cursor.isNull(i + 2))
        {
            s1 = null;
        } else
        {
            s1 = cursor.getString(i + 2);
        }
        lualist.setTime(s1);
        if (cursor.isNull(i + 3))
        {
            s2 = null;
        } else
        {
            s2 = cursor.getString(i + 3);
        }
        lualist.setType(s2);
        if (cursor.isNull(i + 4))
        {
            s3 = null;
        } else
        {
            s3 = cursor.getString(i + 4);
        }
        lualist.setRight(s3);
        if (cursor.isNull(i + 5))
        {
            s4 = null;
        } else
        {
            s4 = cursor.getString(i + 5);
        }
        lualist.setIndex(s4);
        if (cursor.isNull(i + 6))
        {
            s5 = null;
        } else
        {
            s5 = cursor.getString(i + 6);
        }
        lualist.setJsonString(s5);
        if (cursor.isNull(i + 7))
        {
            s6 = null;
        } else
        {
            s6 = cursor.getString(i + 7);
        }
        lualist.setScriptVersion(s6);
        if (cursor.isNull(i + 8))
        {
            s7 = null;
        } else
        {
            s7 = cursor.getString(i + 8);
        }
        lualist.setLuaActionScript(s7);
        if (cursor.isNull(i + 9))
        {
            s8 = null;
        } else
        {
            s8 = cursor.getString(i + 9);
        }
        lualist.setText1(s8);
        if (cursor.isNull(i + 10))
        {
            s9 = null;
        } else
        {
            s9 = cursor.getString(i + 10);
        }
        lualist.setText2(s9);
        if (cursor.isNull(i + 11))
        {
            s10 = null;
        } else
        {
            s10 = cursor.getString(i + 11);
        }
        lualist.setStart(s10);
        flag = cursor.isNull(i + 12);
        s11 = null;
        if (!flag)
        {
            s11 = cursor.getString(i + 12);
        }
        lualist.setStop(s11);
    }

    public volatile void readEntity(Cursor cursor, Object obj, int i)
    {
        readEntity(cursor, (LuaList)obj, i);
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

    protected Long updateKeyAfterInsert(LuaList lualist, long l)
    {
        lualist.setId(Long.valueOf(l));
        return Long.valueOf(l);
    }

    protected volatile Object updateKeyAfterInsert(Object obj, long l)
    {
        return updateKeyAfterInsert((LuaList)obj, l);
    }
}
