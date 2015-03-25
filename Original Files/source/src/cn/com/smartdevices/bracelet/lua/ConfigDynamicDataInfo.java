// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import com.google.gson.Gson;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            a, LuaAction

public class ConfigDynamicDataInfo
{

    private static final String TAG = "ConfigDynamicDataInfo";
    public static ConfigDynamicDataInfo __instance = null;
    private ActiveItem activeItem;
    private ArrayList activeItems;
    private String apkVersion;
    private int battery;
    private int bonus;
    private int continueDay;
    private ReportData continueReport;
    private Boolean dirty;
    private Boolean forceRefresh;
    private int goal;
    private Boolean isBind;
    private LuaAction luaAction;
    private String mGameInfo;
    private String mLuaVersion;
    private ReportData monthReport;
    private int monthStep;
    private ReportData newRecordReport;
    private Boolean newUser;
    private Boolean noData;
    private int percentMonth;
    private int percentWeek;
    private int recordContinue;
    private String recordDate;
    private int recordStep;
    private String right;
    private long serverTimeStamp;
    private Boolean showActivity;
    private Boolean showBattery;
    private Boolean showContinue;
    private Boolean showDayComplete;
    private Boolean showMonthReport;
    private Boolean showNewRecord;
    private Boolean showNoFound;
    private Boolean showSleep;
    private Boolean showUnlockInfo;
    private Boolean showWeekReport;
    private int sleepAverageDeepTime;
    SleepInfo sleepInfo;
    private int sleepPercent;
    private String subTitle;
    private Boolean supportUnlock;
    private long timeStamp;
    private long timeStamp1;
    private long timeStamp2;
    private String title;
    private int totalSteps;
    private String type;
    private String url;
    private ReportData weekReport;
    private int weekStep;

    public ConfigDynamicDataInfo()
    {
        forceRefresh = Boolean.valueOf(false);
        dirty = Boolean.valueOf(false);
        apkVersion = null;
        newUser = Boolean.valueOf(true);
        supportUnlock = Boolean.valueOf(true);
        showUnlockInfo = Boolean.valueOf(true);
        isBind = Boolean.valueOf(true);
        noData = Boolean.valueOf(true);
        showNewRecord = Boolean.valueOf(false);
        recordStep = 0;
        recordDate = "2014-06-12";
        showDayComplete = Boolean.valueOf(false);
        showContinue = Boolean.valueOf(false);
        continueDay = 0;
        recordContinue = 0;
        totalSteps = 0;
        continueReport = null;
        showWeekReport = Boolean.valueOf(false);
        weekStep = 0;
        weekReport = null;
        percentWeek = 50;
        showMonthReport = Boolean.valueOf(false);
        monthStep = 0;
        monthReport = null;
        percentMonth = 50;
        newRecordReport = null;
        showActivity = Boolean.valueOf(false);
        activeItems = null;
        activeItem = null;
        showSleep = Boolean.valueOf(false);
        sleepPercent = 0;
        sleepAverageDeepTime = 0;
        sleepInfo = null;
        showBattery = Boolean.valueOf(false);
        battery = 30;
        showNoFound = Boolean.valueOf(false);
        luaAction = null;
    }

    public static ConfigDynamicDataInfo getInstance()
    {
        if (__instance != null) goto _L2; else goto _L1
_L1:
        ConfigDynamicDataInfo configdynamicdatainfo;
        String s;
        configdynamicdatainfo = new ConfigDynamicDataInfo();
        s = Keeper.readConfigDynamicDataInfo();
        a a1 = (a)(new Gson()).fromJson(s, cn/com/smartdevices/bracelet/lua/a);
        if (a1.a != null)
        {
            configdynamicdatainfo.newUser = a1.a;
        }
        if (a1.b != null)
        {
            configdynamicdatainfo.supportUnlock = a1.b;
        }
        if (a1.c != null)
        {
            configdynamicdatainfo.showUnlockInfo = a1.c;
        }
        configdynamicdatainfo.apkVersion = Keeper.readApkVersion();
        ConfigDynamicDataInfo configdynamicdatainfo1 = configdynamicdatainfo;
_L4:
        __instance = configdynamicdatainfo1;
_L2:
        return __instance;
        Exception exception;
        exception;
        configdynamicdatainfo1 = new ConfigDynamicDataInfo();
        Debug.e("chenee", exception.getMessage());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void genConfigDynamicDataInfo()
    {
    }

    public ActiveItem getActiveItem()
    {
        return activeItem;
    }

    public ArrayList getActiveItems()
    {
        return activeItems;
    }

    public String getApkVersion()
    {
        return apkVersion;
    }

    public int getBattery()
    {
        return battery;
    }

    public int getBonus()
    {
        return bonus;
    }

    public int getContinueDay()
    {
        return continueDay;
    }

    public ReportData getContinueReport()
    {
        return continueReport;
    }

    public Boolean getDirty()
    {
        return dirty;
    }

    public Boolean getForceRefresh()
    {
        return forceRefresh;
    }

    public String getGameInfo()
    {
        return mGameInfo;
    }

    public int getGoal()
    {
        return goal;
    }

    public Boolean getIsBind()
    {
        return isBind;
    }

    public LuaAction getLuaAction()
    {
        return luaAction;
    }

    public String getLuaVersion()
    {
        return mLuaVersion;
    }

    public ReportData getMonthReport()
    {
        return monthReport;
    }

    public int getMonthStep()
    {
        return monthStep;
    }

    public ReportData getNewRecordReport()
    {
        return newRecordReport;
    }

    public Boolean getNewUser()
    {
        if (forceRefresh.booleanValue())
        {
            return forceRefresh;
        } else
        {
            return newUser;
        }
    }

    public Boolean getNoData()
    {
        return noData;
    }

    public int getPercentMonth()
    {
        return percentMonth;
    }

    public int getPercentWeek()
    {
        return percentWeek;
    }

    public int getRecordContinue()
    {
        return recordContinue;
    }

    public String getRecordDate()
    {
        return recordDate;
    }

    public int getRecordStep()
    {
        return recordStep;
    }

    public String getRight()
    {
        return right;
    }

    public long getServerTimeStamp()
    {
        return serverTimeStamp;
    }

    public Boolean getShowActivity()
    {
        return showActivity;
    }

    public Boolean getShowBattery()
    {
        return showBattery;
    }

    public Boolean getShowContinue()
    {
        return showContinue;
    }

    public Boolean getShowDayComplete()
    {
        return showDayComplete;
    }

    public Boolean getShowMonthReport()
    {
        return showMonthReport;
    }

    public Boolean getShowNewRecord()
    {
        return showNewRecord;
    }

    public Boolean getShowNoFound()
    {
        return showNoFound;
    }

    public Boolean getShowSleep()
    {
        return showSleep;
    }

    public Boolean getShowUnlockInfo()
    {
        return showUnlockInfo;
    }

    public Boolean getShowWeekReport()
    {
        return showWeekReport;
    }

    public int getSleepAverageDeepTime()
    {
        return sleepAverageDeepTime;
    }

    public SleepInfo getSleepInfo()
    {
        return sleepInfo;
    }

    public int getSleepPercent()
    {
        return sleepPercent;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public Boolean getSupportUnlock()
    {
        return supportUnlock;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public long getTimeStamp1()
    {
        return timeStamp1;
    }

    public long getTimeStamp2()
    {
        return timeStamp2;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTotalSteps()
    {
        return totalSteps;
    }

    public String getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }

    public ReportData getWeekReport()
    {
        return weekReport;
    }

    public int getWeekStep()
    {
        return weekStep;
    }

    public void save()
    {
        Gson gson = new Gson();
        a a1 = new a(this);
        a1.a = newUser;
        a1.b = showUnlockInfo;
        a1.c = showUnlockInfo;
        Keeper.keepConfigDynamicDataInfo(gson.toJson(a1, cn/com/smartdevices/bracelet/lua/a));
    }

    public void setActiveItem(ActiveItem activeitem)
    {
        activeItem = activeitem;
    }

    public void setActiveItems(ArrayList arraylist)
    {
        activeItems = arraylist;
    }

    public void setApkVersion(String s)
    {
        apkVersion = s;
    }

    public void setBattery(int i)
    {
        battery = i;
    }

    public void setBonus(int i)
    {
        bonus = i;
    }

    public void setContinueDay(int i)
    {
        continueDay = i;
    }

    public void setContinueReport(ReportData reportdata)
    {
        continueReport = reportdata;
    }

    public void setDirty(Boolean boolean1)
    {
        dirty = boolean1;
    }

    public void setForceRefresh(Boolean boolean1)
    {
        forceRefresh = boolean1;
    }

    public void setGameInfo(String s)
    {
        mGameInfo = s;
    }

    public void setGoal(int i)
    {
        goal = i;
    }

    public void setIsBind(Boolean boolean1)
    {
        isBind = boolean1;
    }

    public void setLuaAction(Context context)
    {
        LuaAction _tmp = luaAction;
        luaAction = LuaAction.getInstance(context);
    }

    public void setLuaVersion(String s)
    {
        mLuaVersion = s;
    }

    public void setMonthReport(ReportData reportdata)
    {
        monthReport = reportdata;
    }

    public void setMonthStep(int i)
    {
        monthStep = i;
    }

    public void setNewRecordReport(ReportData reportdata)
    {
        newRecordReport = reportdata;
    }

    public void setNewUser(Boolean boolean1)
    {
        newUser = boolean1;
    }

    public void setNoData(Boolean boolean1)
    {
        noData = boolean1;
    }

    public void setPercentMonth(int i)
    {
        percentMonth = i;
    }

    public void setPercentWeek(int i)
    {
        percentWeek = i;
    }

    public void setRecordContinue(int i)
    {
        recordContinue = i;
    }

    public void setRecordDate(String s)
    {
        recordDate = s;
    }

    public void setRecordStep(int i)
    {
        recordStep = i;
    }

    public void setRight(String s)
    {
        right = s;
    }

    public void setServerTimeStamp(long l)
    {
        serverTimeStamp = l;
    }

    public void setShowActivity(Boolean boolean1)
    {
        showActivity = boolean1;
    }

    public void setShowBattery(Boolean boolean1)
    {
        showBattery = boolean1;
    }

    public void setShowContinue(Boolean boolean1)
    {
        showContinue = boolean1;
    }

    public void setShowDayComplete(Boolean boolean1)
    {
        showDayComplete = boolean1;
    }

    public void setShowMonthReport(Boolean boolean1)
    {
        showMonthReport = boolean1;
    }

    public void setShowNewRecord(Boolean boolean1)
    {
        showNewRecord = boolean1;
    }

    public void setShowNoFound(Boolean boolean1)
    {
        showNoFound = boolean1;
    }

    public void setShowSleep(Boolean boolean1)
    {
        showSleep = boolean1;
    }

    public void setShowUnlockInfo(Boolean boolean1)
    {
        showUnlockInfo = boolean1;
    }

    public void setShowWeekReport(Boolean boolean1)
    {
        showWeekReport = boolean1;
    }

    public void setSleepAverageDeepTime(int i)
    {
        sleepAverageDeepTime = i;
    }

    public void setSleepInfo(SleepInfo sleepinfo)
    {
        sleepInfo = sleepinfo;
    }

    public void setSleepPercent(int i)
    {
        sleepPercent = i;
    }

    public void setSubTitle(String s)
    {
        subTitle = s;
    }

    public void setSupportUnlock(Boolean boolean1)
    {
        supportUnlock = boolean1;
    }

    public void setTimeStamp(long l)
    {
        timeStamp = l;
    }

    public void setTimeStamp1(long l)
    {
        timeStamp1 = l;
    }

    public void setTimeStamp2(long l)
    {
        timeStamp2 = l;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTotalSteps(int i)
    {
        totalSteps = i;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWeekReport(ReportData reportdata)
    {
        weekReport = reportdata;
    }

    public void setWeekStep(int i)
    {
        weekStep = i;
    }

}
