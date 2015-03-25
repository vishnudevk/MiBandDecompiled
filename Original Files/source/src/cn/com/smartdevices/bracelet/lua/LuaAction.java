// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import java.util.List;
import org.keplerproject.luajava.LuaState;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            LuaManager, ConfigDynamicDataInfo

public class LuaAction
{

    private static LuaAction __instance = null;
    private Context context;

    public LuaAction(Context context1)
    {
        context = null;
        context = context1;
    }

    public static LuaAction getInstance()
    {
        if (__instance == null)
        {
            return null;
        } else
        {
            return __instance;
        }
    }

    public static LuaAction getInstance(Context context1)
    {
        if (__instance == null)
        {
            LuaAction luaaction = new LuaAction(context1);
            luaaction.context = context1;
            __instance = luaaction;
        }
        return __instance;
    }

    public void clearDB()
    {
        DaoManager.getInstance().getLuaListDao().deleteAll();
    }

    public void delMsg(WhereCondition wherecondition, WhereCondition wherecondition1)
    {
        QueryBuilder querybuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
        querybuilder.where(wherecondition, new WhereCondition[0]);
        if (wherecondition1 != null)
        {
            querybuilder.where(wherecondition1, new WhereCondition[0]);
        }
        querybuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public void delMsg4(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition wherecondition2, WhereCondition wherecondition3)
    {
        QueryBuilder querybuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
        querybuilder.where(wherecondition, new WhereCondition[0]);
        if (wherecondition1 != null)
        {
            querybuilder.where(wherecondition1, new WhereCondition[0]);
        }
        if (wherecondition2 != null)
        {
            querybuilder.where(wherecondition2, new WhereCondition[0]);
        }
        if (wherecondition3 != null)
        {
            querybuilder.where(wherecondition3, new WhereCondition[0]);
        }
        querybuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public void doLuaAction(String s)
    {
        Debug.i("chenee", (new StringBuilder()).append("-------------\n").append(s).toString());
        Debug.i("chenee", "--------------------\n");
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = LuaManager.getInstance().getLuaState();
        luastate.LdoString(s);
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "doAction");
        luastate.pushJavaObject(context);
        luastate.pushJavaObject(__instance);
        luamanager.callLua(2, 0);
    }

    public ConfigDynamicDataInfo getConfigInfo()
    {
        return ConfigDynamicDataInfo.getInstance();
    }

    public int getCount(WhereCondition wherecondition, WhereCondition wherecondition1)
    {
        QueryBuilder querybuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
        querybuilder.where(wherecondition, new WhereCondition[0]);
        if (wherecondition1 != null)
        {
            querybuilder.where(wherecondition1, new WhereCondition[0]);
        }
        return (int)querybuilder.count();
    }

    public int getCount4(WhereCondition wherecondition, WhereCondition wherecondition1, WhereCondition wherecondition2, WhereCondition wherecondition3)
    {
        QueryBuilder querybuilder = DaoManager.getInstance().getLuaListDao().queryBuilder();
        querybuilder.where(wherecondition, new WhereCondition[0]);
        if (wherecondition1 != null)
        {
            querybuilder.where(wherecondition1, new WhereCondition[0]);
        }
        if (wherecondition2 != null)
        {
            querybuilder.where(wherecondition2, new WhereCondition[0]);
        }
        if (wherecondition2 != null)
        {
            querybuilder.where(wherecondition2, new WhereCondition[0]);
        }
        return (int)querybuilder.count();
    }

    public LuaListDao getDao()
    {
        return DaoManager.getInstance().getLuaListDao();
    }

    public Intent getIntentFromString(String s)
    {
        Debug.i("chenee", (new StringBuilder()).append("luaAction,classname is: ").append(s).toString());
        Class class1 = null;
        if (s != null)
        {
            Class class2;
            try
            {
                class2 = Class.forName(s);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                classnotfoundexception.printStackTrace();
                Debug.i("chenee", classnotfoundexception.getMessage());
                return null;
            }
            class1 = class2;
        }
        return new Intent(context, class1);
    }

    public Boolean getIsBind()
    {
        return Boolean.valueOf(Utils.isBinded());
    }

    public void putExtra(Intent intent, String s, Object obj)
    {
        if (obj instanceof String)
        {
            intent.putExtra(s, (String)obj);
        } else
        {
            if (obj instanceof Byte)
            {
                intent.putExtra(s, (Byte)obj);
                return;
            }
            if (obj instanceof Integer)
            {
                intent.putExtra(s, ((Integer)obj).intValue());
                return;
            }
        }
    }

    public int queryCount(QueryBuilder querybuilder)
    {
        return (int)querybuilder.count();
    }

    public void queryDel(QueryBuilder querybuilder)
    {
        querybuilder.buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public LuaList queryLastItem(QueryBuilder querybuilder)
    {
        Property aproperty[] = new Property[1];
        aproperty[0] = de.greenrobot.daobracelet.LuaListDao.Properties.Id;
        querybuilder.orderDesc(aproperty);
        List list = querybuilder.list();
        if (list.size() > 0)
        {
            return (LuaList)list.get(0);
        } else
        {
            return null;
        }
    }

    public void queryWhere(QueryBuilder querybuilder, WhereCondition wherecondition)
    {
        querybuilder.where(wherecondition, new WhereCondition[0]);
    }

}
