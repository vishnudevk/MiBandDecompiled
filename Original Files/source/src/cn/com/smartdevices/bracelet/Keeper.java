// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.SharedPreferences;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Utils, Debug, c

public class Keeper
{

    private static final String a = "Keeper";
    private static final String b = "REF_MORING_ALARMS";
    private static SharedPreferences c = null;

    public Keeper()
    {
    }

    public static void KeepLastMonthReportDate(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("LastMonthReportDate", s);
        editor.commit();
    }

    public static void KeepLastWeekReportDate(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("LastWeekReportDate", s);
        editor.commit();
    }

    public static void clearPersonInfo()
    {
        keepPersonInfo(new PersonInfo());
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("person_info_mili_config", "");
        editor.putString("person_info_location", "");
        editor.putString("person_info_total_sport_data", "");
        editor.commit();
    }

    public static SharedPreferences getSharedPref()
    {
        return c;
    }

    public static void init(Context context)
    {
        c = context.getSharedPreferences("keeper", 0);
    }

    public static void keepAlarms(ArrayList arraylist)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        String s = Utils.getGson().toJson(arraylist);
        Debug.i("Keeper", (new StringBuilder()).append("alarmStr =").append(s).toString());
        if (s == null || "null".equals(s))
        {
            s = "";
        }
        editor.putString("alarms", s);
        editor.commit();
    }

    public static void keepApkVersion(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("APKVersion", s);
        editor.commit();
    }

    public static void keepBraceletBtInfo(BraceletBtInfo braceletbtinfo)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("bracelet_bt_name", braceletbtinfo.name);
        if (braceletbtinfo.address != null)
        {
            editor.putString("bracelet_mac_address", braceletbtinfo.address);
        }
        editor.commit();
    }

    public static void keepBraceletStatisticTime(long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("bracelet_statistic_time", l);
        editor.commit();
    }

    public static void keepCheckUpdateApkDate()
    {
        Calendar calendar = Calendar.getInstance();
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("UPDATE_DATE_REF", Utils.getGson().toJson(calendar));
        editor.commit();
    }

    public static void keepConfigDynamicDataInfo(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("configDynamicDataInfo", s);
        editor.commit();
    }

    public static void keepContinueReachGoalRi(ReportInfo reportinfo)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("continue_reach_goal", reportinfo.date);
        editor.putString("continue_reach_report_date", reportinfo.reportDate);
        editor.commit();
    }

    public static void keepDebugFlag(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putBoolean("enable_debug_log", flag);
        editor.commit();
    }

    public static void keepDeviceId(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("device_id", s);
        editor.commit();
    }

    public static void keepDownloadApkId(long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("DOWNLOAD_ID_REF", l);
        editor.commit();
    }

    public static void keepFileDebugFlag(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putBoolean("enable_file_debug_log", flag);
        editor.commit();
    }

    public static void keepGameFailed(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putBoolean("REF_GAME_FAILED", flag);
        editor.commit();
    }

    public static void keepIsPlayEnterAnimation(Boolean boolean1)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putBoolean("isPlayEnterAnimation", boolean1.booleanValue());
        editor.commit();
    }

    public static void keepLatestDBLuaVersion(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("latestDBLuaVersion", s);
        editor.commit();
    }

    public static void keepLocaleStr()
    {
        Locale locale = Locale.getDefault();
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("Locale", locale.toString());
        editor.commit();
    }

    public static void keepLoginData(long l, String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("uid", l);
        editor.putString("security", s);
        editor.commit();
    }

    public static void keepMorningAlarms(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("REF_MORING_ALARMS", s);
        editor.commit();
    }

    public static void keepNeedBind(int i)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt("bind_state", i);
        editor.commit();
    }

    public static void keepNetInfo(NetDataInfo netdatainfo)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt("net_data_state", netdatainfo.dataState);
        editor.putString("net_start_day", netdatainfo.startDate);
        editor.putString("net_stop_day", netdatainfo.stopDate);
        editor.commit();
    }

    public static void keepPersonInfo(PersonInfo personinfo)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("person_info_nickname", personinfo.nickname);
        editor.putString("person_info_avatar_url", personinfo.avatarUrl);
        editor.putString("person_info_avatar_path", personinfo.avatarPath);
        editor.putInt("person_info_age", personinfo.age);
        editor.putInt("person_info_gender", personinfo.gender);
        editor.putInt("person_info_height", personinfo.height);
        editor.putInt("person_info_weight", personinfo.weight);
        editor.putLong("person_info_uid", personinfo.uid);
        editor.putString("person_info_signature", personinfo.personSignature);
        editor.putString("person_info_sh", personinfo.sh);
        editor.putString("device_id", personinfo.deviceId);
        editor.putInt("person_info_need_sync_server", personinfo.getNeedSyncServer());
        if (personinfo.miliConfig != null && personinfo.miliConfig.isValid())
        {
            editor.putString("person_info_mili_config", personinfo.miliConfig.toString());
        }
        if (personinfo.location != null && personinfo.location.isValid())
        {
            editor.putString("person_info_location", personinfo.location.toString());
        }
        if (personinfo.totalSportData != null && personinfo.totalSportData.isValid())
        {
            editor.putString("person_info_total_sport_data", personinfo.totalSportData.toString());
        }
        editor.commit();
        keepAlarms(personinfo.alarmClockItems);
    }

    public static void keepPlayEnterAnimationType(int i)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt("PlayEnterAnimationType", i);
        editor.commit();
    }

    public static void keepPushAlias(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("push_alias", s);
        editor.commit();
    }

    public static void keepRealtimeSteps(int i)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt("dynamic_realtime_steps", i);
        editor.commit();
    }

    public static void keepShareBgItem(ShareBackgroundItem sharebackgrounditem)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("reached_bg_url", sharebackgrounditem.reachedBgUrl);
        editor.putString("unreached_bg_url", sharebackgrounditem.unReachedBgUrl);
        editor.commit();
    }

    public static void keepSwitchOperator(SwitchOperator switchoperator)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt("switch_type", switchoperator.type);
        editor.putBoolean("enable_clear_data", switchoperator.enableClearData);
        editor.putBoolean("enable_write_realtime_steps", switchoperator.enableSteps);
        editor.putInt("realtime_steps", switchoperator.steps);
        editor.putLong("last_uid", switchoperator.lastUid);
        editor.putString("last_mac_address", switchoperator.lastMacAddress);
        editor.putString("switch_date", switchoperator.date);
        editor.commit();
    }

    public static void keepSyncBraceletTime(long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("sync_bracelet_time", l);
        editor.commit();
    }

    public static void keepSyncRealStepTime(long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("sync_real_step_time", l);
        editor.commit();
    }

    public static void keepSyncTime(long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong("sync_time", l);
        editor.commit();
    }

    public static void keepUUID(String s)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("push_uuid", s);
        editor.commit();
    }

    public static ArrayList readAlarms()
    {
        String s = c.getString("alarms", "");
        ArrayList arraylist;
        try
        {
            arraylist = PersonInfo.parseAlarmClockItems(s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return arraylist;
    }

    public static String readApkVersion()
    {
        return c.getString("APKVersion", "85:1.0.20140625.2");
    }

    public static BraceletBtInfo readBraceletBtInfo()
    {
        BraceletBtInfo braceletbtinfo = new BraceletBtInfo();
        braceletbtinfo.name = c.getString("bracelet_bt_name", "");
        braceletbtinfo.address = c.getString("bracelet_mac_address", "");
        return braceletbtinfo;
    }

    public static long readBraceletStatisticTime()
    {
        return c.getLong("bracelet_statistic_time", -1L);
    }

    public static String readConfigDynamicDataInfo()
    {
        return c.getString("configDynamicDataInfo", "{}");
    }

    public static ReportInfo readContinueReachGoalRi()
    {
        ReportInfo reportinfo = new ReportInfo();
        reportinfo.date = c.getString("continue_reach_goal", "");
        reportinfo.reportDate = c.getString("continue_reach_report_date", "");
        return reportinfo;
    }

    public static boolean readDebugFlag()
    {
        return c.getBoolean("enable_debug_log", false);
    }

    public static String readDeviceId()
    {
        return c.getString("device_id", "");
    }

    public static long readDownloadApkId()
    {
        return c.getLong("DOWNLOAD_ID_REF", -1L);
    }

    public static boolean readFileDebugFlag()
    {
        return c.getBoolean("enable_file_debug_log", true);
    }

    public static boolean readGameFailed()
    {
        return c.getBoolean("REF_GAME_FAILED", false);
    }

    public static Boolean readIsPlayEnterAnimation()
    {
        return Boolean.valueOf(c.getBoolean("isPlayEnterAnimation", false));
    }

    public static Calendar readLastCheckUpdateDate()
    {
        String s = c.getString("UPDATE_DATE_REF", "");
        Debug.i("Keeper", (new StringBuilder()).append("last calendar=").append(s).toString());
        return (Calendar)Utils.getGson().fromJson(s, java/util/Calendar);
    }

    public static String readLastMonthReportDate()
    {
        return c.getString("LastMonthReportDate", "");
    }

    public static String readLastWeekReportDate()
    {
        return c.getString("LastWeekReportDate", "");
    }

    public static String readLatestDBLuaVersion()
    {
        return c.getString("latestDBLuaVersion", "20990101001");
    }

    public static String readLocaleStr()
    {
        return c.getString("Locale", "");
    }

    public static LoginData readLoginData()
    {
        LoginData logindata = new LoginData();
        logindata.uid = c.getLong("uid", -1L);
        logindata.security = c.getString("security", null);
        return logindata;
    }

    public static ArrayList readMorningAlarms()
    {
        String s = c.getString("REF_MORING_ALARMS", "");
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)Utils.getGson().fromJson(s, (new c()).getType());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return arraylist;
    }

    public static int readNeedBind()
    {
        return c.getInt("bind_state", 1);
    }

    public static NetDataInfo readNetInfo()
    {
        NetDataInfo netdatainfo = new NetDataInfo();
        netdatainfo.dataState = c.getInt("net_data_state", 0);
        netdatainfo.startDate = c.getString("net_start_day", null);
        netdatainfo.stopDate = c.getString("net_stop_day", null);
        return netdatainfo;
    }

    public static PersonInfo readPersonInfo()
    {
        PersonInfo personinfo = new PersonInfo();
        personinfo.nickname = c.getString("person_info_nickname", personinfo.nickname);
        personinfo.avatarUrl = c.getString("person_info_avatar_url", "");
        personinfo.avatarPath = c.getString("person_info_avatar_path", "");
        personinfo.age = c.getInt("person_info_age", personinfo.age);
        personinfo.gender = c.getInt("person_info_gender", personinfo.gender);
        personinfo.height = c.getInt("person_info_height", personinfo.height);
        personinfo.weight = c.getInt("person_info_weight", personinfo.weight);
        personinfo.uid = c.getLong("person_info_uid", personinfo.uid);
        personinfo.personSignature = c.getString("person_info_signature", "");
        personinfo.sh = c.getString("person_info_sh", "");
        personinfo.location = UserLocationData.fromJsonStr(c.getString("person_info_location", ""));
        personinfo.totalSportData = UserTotalSportData.fromJsonStr(c.getString("person_info_total_sport_data", ""));
        personinfo.deviceId = c.getString("device_id", "");
        personinfo.setNeedSyncServer(c.getInt("person_info_need_sync_server", 0));
        personinfo.miliConfig = MiliConfig.fromJsonStr(c.getString("person_info_mili_config", ""));
        personinfo.alarmClockItems = readAlarms();
        return personinfo;
    }

    public static PersonInfo readPersonInfoBase()
    {
        PersonInfo personinfo = new PersonInfo();
        personinfo.uid = c.getLong("person_info_uid", personinfo.uid);
        personinfo.gender = c.getInt("person_info_gender", personinfo.gender);
        personinfo.height = c.getInt("person_info_height", personinfo.height);
        personinfo.weight = c.getInt("person_info_weight", personinfo.weight);
        personinfo.age = c.getInt("person_info_age", personinfo.age);
        personinfo.miliConfig = MiliConfig.fromJsonStr(c.getString("person_info_mili_config", ""));
        return personinfo;
    }

    public static PersonInfo readPersonInfoBaseConfig()
    {
        PersonInfo personinfo = new PersonInfo();
        personinfo.miliConfig = MiliConfig.fromJsonStr(c.getString("person_info_mili_config", ""));
        return personinfo;
    }

    public static PersonInfo readPersonInfoBaseNeedSync()
    {
        PersonInfo personinfo = new PersonInfo();
        personinfo.setNeedSyncServer(c.getInt("person_info_need_sync_server", 0));
        return personinfo;
    }

    public static PersonInfo readPersonInfoBaseUID()
    {
        PersonInfo personinfo = new PersonInfo();
        personinfo.uid = c.getLong("person_info_uid", personinfo.uid);
        return personinfo;
    }

    public static int readPlayEnterAnimationType()
    {
        return c.getInt("PlayEnterAnimationType", 99);
    }

    public static String readPushAlias()
    {
        return c.getString("push_alias", null);
    }

    public static int readRealtimeSteps()
    {
        return c.getInt("dynamic_realtime_steps", -1);
    }

    public static ShareBackgroundItem readShareBgItem()
    {
        ShareBackgroundItem sharebackgrounditem = new ShareBackgroundItem();
        sharebackgrounditem.reachedBgUrl = c.getString("reached_bg_url", "");
        sharebackgrounditem.unReachedBgUrl = c.getString("unreached_bg_url", "");
        return sharebackgrounditem;
    }

    public static SwitchOperator readSwitchOperator()
    {
        SwitchOperator switchoperator = new SwitchOperator();
        switchoperator.type = c.getInt("switch_type", 0);
        switchoperator.enableClearData = c.getBoolean("enable_clear_data", false);
        switchoperator.enableSteps = c.getBoolean("enable_write_realtime_steps", false);
        switchoperator.steps = c.getInt("realtime_steps", 0);
        switchoperator.lastUid = c.getLong("last_uid", -1L);
        switchoperator.lastMacAddress = c.getString("last_mac_address", "");
        switchoperator.date = c.getString("switch_date", "");
        return switchoperator;
    }

    public static long readSyncBraceletTime()
    {
        return c.getLong("sync_bracelet_time", -1L);
    }

    public static long readSyncRealStepTime()
    {
        return c.getLong("sync_real_step_time", -1L);
    }

    public static long readSyncTime()
    {
        return c.getLong("sync_time", -1L);
    }

    public static String readUUID()
    {
        return c.getString("push_uuid", null);
    }

    public static String readUserName()
    {
        return c.getString("person_info_nickname", "");
    }

}
