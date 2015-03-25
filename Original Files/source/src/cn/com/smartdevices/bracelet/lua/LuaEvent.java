// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.model.ReportData;
import java.util.Locale;
import org.keplerproject.luajava.LuaState;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            ConfigDynamicDataInfo, LuaEventMsgs, LuaManager, LuaAction

public class LuaEvent
{

    private static final String TAG = "LuaEvent";
    private static LuaEvent __instance = null;
    private ConfigDynamicDataInfo cInfo;
    private Context context;
    private LuaEventMsgs lEventMsgs;

    public LuaEvent(Context context1)
    {
        context = null;
        cInfo = null;
        lEventMsgs = null;
        context = context1;
    }

    public static LuaEvent getInstance(Context context1)
    {
        if (__instance == null)
        {
            LuaEvent luaevent = new LuaEvent(context1);
            luaevent.context = context1;
            luaevent.cInfo = ConfigDynamicDataInfo.getInstance();
            luaevent.cInfo.setLuaAction(context1);
            luaevent.lEventMsgs = LuaEventMsgs.getInstance(context1);
            __instance = luaevent;
            __instance.setLocale(Locale.getDefault().toString());
        }
        return __instance;
    }

    public void callLuaFunc(String s, EventGameUpdate eventgameupdate)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), s);
        eventgameupdate.getConfigInfo().setLuaAction(context);
        luastate.pushJavaObject(DaoManager.getInstance().getLuaListDao());
        luastate.pushJavaObject(eventgameupdate.getConfigInfo());
        luamanager.callLua(2, 0);
    }

    public ConfigDynamicDataInfo getConfigDynamicDataInfo()
    {
        return cInfo;
    }

    public String getGameInfo()
    {
        setLocale(Locale.getDefault().toString());
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getGameInfo");
        luastate.pushJavaObject(cInfo);
        luamanager.callLua(1, 0);
        Debug.i("LuaEvent", (new StringBuilder()).append("get lua game info  =").append(cInfo.getGameInfo()).toString());
        return cInfo.getGameInfo();
    }

    public LuaEventMsgs getLuaEventMsg()
    {
        return lEventMsgs;
    }

    public String getLuaVersion()
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "getLuaVersion");
        luastate.pushJavaObject(cInfo);
        luamanager.callLua(1, 0);
        String s = cInfo.getLuaVersion();
        Debug.i("LuaEvent", (new StringBuilder()).append("get lua version from local =").append(cInfo.getLuaVersion()).toString());
        return s;
    }

    public void resetLuaState()
    {
        LuaManager.getInstance().resetLuaState();
    }

    public void setContinueReport(ReportData reportdata)
    {
        cInfo.setShowContinue(Boolean.valueOf(true));
        cInfo.setContinueReport(reportdata);
        lEventMsgs.luaEventAchievementMsg(cInfo);
        cInfo.setShowContinue(Boolean.valueOf(false));
    }

    public void setDefaultMsgs()
    {
        setDefaultMsgs(Boolean.valueOf(false));
    }

    public void setDefaultMsgs(Boolean boolean1)
    {
        cInfo.setIsBind(Boolean.valueOf(Utils.isBinded()));
        if (Utils.isSupportUnlockScreenByBracelet(context))
        {
            boolean flag = Utils.isUseUnlockByBracelet(context);
            boolean flag1 = false;
            if (!flag)
            {
                flag1 = true;
            }
            Boolean boolean2 = Boolean.valueOf(flag1);
            cInfo.setShowUnlockInfo(boolean2);
        } else
        {
            cInfo.setShowUnlockInfo(Boolean.valueOf(false));
        }
        cInfo.save();
        cInfo.setForceRefresh(boolean1);
        lEventMsgs.luaEventDefaultMsg(cInfo);
    }

    public void setGoal()
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        de.greenrobot.daobracelet.LuaListDao lualistdao = DaoManager.getInstance().getLuaListDao();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "dayComplete");
        luastate.pushJavaObject(lualistdao);
        luastate.pushJavaObject(cInfo);
        luamanager.callLua(2, 0);
    }

    public void setLocale(String s)
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setLocale");
        luastate.pushString(s);
        luamanager.callLua(1, 0);
    }

    public void setMonthReport(ReportData reportdata)
    {
        cInfo.setShowMonthReport(Boolean.valueOf(true));
        cInfo.setMonthReport(reportdata);
        lEventMsgs.luaEventAchievementMsg(cInfo);
        cInfo.setShowMonthReport(Boolean.valueOf(false));
    }

    public void setRecord(ReportData reportdata)
    {
        cInfo.setNewRecordReport(reportdata);
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        de.greenrobot.daobracelet.LuaListDao lualistdao = DaoManager.getInstance().getLuaListDao();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "newRecord");
        luastate.pushJavaObject(lualistdao);
        luastate.pushJavaObject(cInfo);
        luamanager.callLua(2, 0);
    }

    public void setSleep(SleepInfo sleepinfo)
    {
        cInfo.setSleepInfo(sleepinfo);
        cInfo.setSleepAverageDeepTime(90);
        cInfo.setSleepPercent(80);
        cInfo.setShowSleep(Boolean.valueOf(true));
        lEventMsgs.luaEventSleepMsg(cInfo);
        cInfo.setShowSleep(Boolean.valueOf(false));
    }

    public void setStep(ActiveItem activeitem)
    {
        if (activeitem.mode != 0 && activeitem.mode != 1);
        cInfo.setActiveItem(activeitem);
        cInfo.setShowActivity(Boolean.valueOf(true));
        lEventMsgs.luaEventActivityMsg(cInfo);
        cInfo.setShowActivity(Boolean.valueOf(false));
    }

    public void setWeekReport(ReportData reportdata)
    {
        cInfo.setShowWeekReport(Boolean.valueOf(true));
        cInfo.setWeekReport(reportdata);
        lEventMsgs.luaEventAchievementMsg(cInfo);
        cInfo.setShowWeekReport(Boolean.valueOf(false));
    }

    public void testAction()
    {
        LuaManager luamanager = LuaManager.getInstance();
        LuaState luastate = luamanager.getLuaState();
        LuaAction luaaction = LuaAction.getInstance(context);
        de.greenrobot.daobracelet.LuaListDao lualistdao = DaoManager.getInstance().getLuaListDao();
        luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "doAction2");
        luastate.pushJavaObject(context);
        luastate.pushJavaObject(luaaction);
        luastate.pushJavaObject(lualistdao);
        luamanager.callLua(3, 0);
    }

    public void testConfig()
    {
    }

    public void testLuaImp(int i)
    {
        lEventMsgs.testLuaImp(i, cInfo);
    }

}
