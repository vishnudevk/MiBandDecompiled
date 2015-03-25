// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.DaoManager;
import de.greenrobot.daobracelet.LuaListDao;
import org.keplerproject.luajava.LuaState;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            LuaManager, ConfigDynamicDataInfo

public class LuaEventMsgs
{

    private static LuaEventMsgs __instance = null;
    private Context context;
    private LuaListDao listDao;

    public LuaEventMsgs()
    {
        listDao = DaoManager.getInstance().getLuaListDao();
        context = null;
    }

    public static LuaEventMsgs getInstance(Context context1)
    {
        if (__instance == null)
        {
            LuaEventMsgs luaeventmsgs = new LuaEventMsgs();
            luaeventmsgs.context = context1;
            LuaManager.getInstance(context1);
            __instance = luaeventmsgs;
        }
        return __instance;
    }

    public void luaEventAchievementMsg(ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getAchievementMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luamanager.callLua(2, 0);
    }

    public void luaEventActivityMsg(ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getActivityMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luamanager.callLua(2, 0);
    }

    public void luaEventDefaultMsg(ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getDefaultMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luamanager.callLua(2, 0);
    }

    public void luaEventSleepMsg(ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSleepMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luamanager.callLua(2, 0);
    }

    public void luaEventSysInfoMsg(ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getSysInfoMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luamanager.callLua(2, 0);
    }

    public void testLuaImp(int i, ConfigDynamicDataInfo configdynamicdatainfo)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getEventMsgs");
        luastate.pushJavaObject(listDao);
        luastate.pushJavaObject(configdynamicdatainfo);
        luastate.pushInteger(i);
        luamanager.callLua(3, 0);
    }

}
