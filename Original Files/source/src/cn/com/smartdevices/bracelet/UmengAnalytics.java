// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.util.Log;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

public class UmengAnalytics
{

    public static final String EVENT_ABOUT_CHECK_UPDATE = "AboutCheckUpdate";
    public static final String EVENT_ABOUT_FEEDBACK = "AboutFeedback";
    public static final String EVENT_ABOUT_SEND_FEEDBACK = "AboutSendFeedback";
    public static final String EVENT_ABOUT_USER_AGREEMENT = "AboutUserAgreement";
    public static final String EVENT_ABOUT_VIEW_OFFICIAL_SITE = "AboutViewOfficialSite";
    public static final String EVENT_ALARM_SETTING = "AlarmSetting";
    public static final String EVENT_BINDED_USER_START = "BindedUserStart";
    public static final String EVENT_BLE_CONNECT = "BleConnect";
    public static final String EVENT_BLE_DISCONNECT = "BleDisconnect";
    public static final String EVENT_BLE_SYNC_DATA = "BleSyncData";
    public static final String EVENT_BLE_SYNC_DATA_FIRST = "BleSyncDataFirst";
    public static final String EVENT_BRACELET_BIND_WECHART = "BraceletBindWeChat";
    public static final String EVENT_BRACELET_FIND = "BraceletFind";
    public static final String EVENT_BRACELET_GOAL = "BraceletGoal";
    public static final String EVENT_BRACELET_UNLOCK_SETTING = "BraceletUnlockSetting";
    public static final String EVENT_BTACELET_CALL_NOTIFY = "BraceletCallNotify";
    public static final String EVENT_BTACELET_CALL_NOTIFY_TIME = "BraceletCallNotifyTime";
    public static final String EVENT_BTACELET_HAND = "BraceletHand";
    public static final String EVENT_BTACELET_LIGHT = "BraceletLight";
    public static final String EVENT_BTACELET_UNBIND = "BraceletUnbind";
    public static final String EVENT_CLICK_MAIN_MENU = "ClickMainMenu";
    public static final String EVENT_CLICK_MAIN_MENU_ITEM = "ClickMainMenuItem";
    public static final String EVENT_DYNAMIC_DETAIL_MODIFY_SLEEP_TIME = "DynamicDetailModifySleepTime";
    public static final String EVENT_DYNAMIC_DETAIL_VIEW_CHART_ITEM = "DynamicDetailViewChartItem";
    public static final String EVENT_DYNAMIC_LIST = "DynamicList";
    public static final String EVENT_DYNAMIC_REALSTEP_UPDATE = "DynamicRealStepUpdate";
    public static final String EVENT_EXCEPT_REALTIME_LESS_DETAIL_STEP = "ExceptRealtimeLessDetailStep";
    public static final String EVENT_EXCEPT_REALTIME_MORE_DETAIL_STEP = "ExceptRealtimeMoreDetailStep";
    public static final String EVENT_FIRMWARE_UPGRADE = "FirmwareUpgrade";
    public static final String EVENT_GAME_DISLIKE = "Game_Dislike";
    public static final String EVENT_GAME_VIEW_SIGNUP = "Game_ViewSignup";
    public static final String EVENT_INCOMING_CALL = "IncomingCall";
    public static final String EVENT_LOCATION_EXCEPTION = "LocationException";
    public static final String EVENT_LOCATION_START = "LocationStart";
    public static final String EVENT_SHARE = "Share";
    public static final String EVENT_SHARE_FROM = "ShareFrom";
    public static final String EVENT_SHARE_TO = "ShareTo";
    public static final String EVENT_START_UP = "StartUp";
    public static final String EVENT_START_UP_CONNECT_BRACELET = "StartUpConnectBracelet";
    public static final String EVENT_START_UP_FOUND_BRACELET = "StartUpFoundBracelet";
    public static final String EVENT_START_UP_LOGIN = "StartUpLogin";
    public static final String EVENT_START_UP_NOT_BIND_BRACELET = "StartUpNotBindBracelet";
    public static final String EVENT_START_UP_PAIEING_BRACELET = "StartUpPairingBracelet";
    public static final String EVENT_START_UP_REGISTER = "StartUpRegister";
    public static final String EVENT_START_UP_SCAN_BRACELET = "StartUpScanBracelet";
    public static final String EVENT_START_UP_VIEW_BRACELET_LIST = "StartUpViewBraceletList";
    public static final String EVENT_USER_LOGOUT = "UserLogout";
    public static final String EVENT_USER_SETTING_AGE = "UserSettingAge";
    public static final String EVENT_USER_SETTING_GENDER = "UserSettingGender";
    public static final String EVENT_USER_SETTING_HEIGHT = "UserSettingHeight";
    public static final String EVENT_USER_SETTING_WEIGHT = "UserSettingWeight";
    public static final String EVENT_VIEW_DYNAMIC = "ViewDynamic";
    public static final String EVENT_VIEW_DYNAMIC_DETAIL = "ViewDynamicDetail";
    public static final String EVENT_VIEW_STATISTIC = "ViewStatistic";
    public static final String EVENT_WEATHER_EXCEPTION = "WeatherException";
    public static final String EVENT_WEATHER_OK = "WeatherOK";
    public static final String EVENT_WEATHER_REQUEST_CITY = "WeatherRequestCity";
    public static final String EVENT_WEATHER_REQUEST_CITY_CODE = "WeatherRequestCityCode";
    public static final String EVENT_WEATHER_REQUEST_WEATHER = "WeatherRequestWeather";
    public static final String EVENT_WEATHER_START = "WeatherStart";
    public static final String PAGE_ABOUT = "PageAbout";
    public static final String PAGE_ALARM = "PageAlarm";
    public static final String PAGE_ALARM_NEW = "PageAlarmNew";
    public static final String PAGE_ALARM_NEW_REPEAT = "PageAlarmNewRepeat";
    public static final String PAGE_ALARM_NEW_REPEAT_CUSTOM = "PageAlarmNewRepeatCustom";
    public static final String PAGE_BIND_WECHAT = "PageBindWeChat";
    public static final String PAGE_BRACELET = "PageBracelet";
    public static final String PAGE_BRACELET_CONNECT_FAILED = "PageBraceletConnectFailed";
    public static final String PAGE_BRACELET_GOAL = "PageBraceletGoal";
    public static final String PAGE_BRACELET_HAND = "PageBraceletHand";
    public static final String PAGE_BRACELET_LIGHT = "PageBraceletLight";
    public static final String PAGE_BRACELET_NOT_FOUND = "PageBraceletNotFound";
    public static final String PAGE_BRACELET_NOT_FOUND_HELP = "PageBraceletNotFoundHelp";
    public static final String PAGE_BRACELET_UNBIND = "PageBraceletUnbind";
    public static final String PAGE_DYNAMIC = "PageDynamic";
    public static final String PAGE_DYNAMIC_DETAIL = "PageDynamicDetail";
    public static final String PAGE_DYNAMIC_DETAIL_MODIFY_SLEEP_END = "PageDynamicDetailModifySleepEnd";
    public static final String PAGE_DYNAMIC_DETAIL_MODIFY_SLEEP_START = "PageDynamicDetailModifySleepStart";
    public static final String PAGE_FEEDBACK = "PageFeedback";
    public static final String PAGE_FIRMWARE_UPGRADE = "PageFirmwareUpgrade";
    public static final String PAGE_INSTRUCTION = "PageInstruction";
    public static final String PAGE_PERSON_GUIDE_AGE = "PagePersonGuideAge";
    public static final String PAGE_PERSON_GUIDE_FINISH = "PagePersonGuideFinish";
    public static final String PAGE_PERSON_GUIDE_GENDER = "PagePersonGuideGender";
    public static final String PAGE_PERSON_GUIDE_GOAL = "PagePersonGuideGoal";
    public static final String PAGE_PERSON_GUIDE_HEIGHT = "PagePersonGuideHeight";
    public static final String PAGE_PERSON_GUIDE_WEIGHT = "PagePersonGuideWeight";
    public static final String PAGE_PERSON_INFO = "PagePersonInfo";
    public static final String PAGE_PERSON_INFO_AGE = "PagePersonInfoAge";
    public static final String PAGE_PERSON_INFO_AVATAR_CROP = "PagePersonInfoAvatarCrop";
    public static final String PAGE_PERSON_INFO_AVATAR_SELECTION = "PagePersonInfoAvatarSelection";
    public static final String PAGE_PERSON_INFO_GENDER = "PagePersonInfoGender";
    public static final String PAGE_PERSON_INFO_HEIGHT = "PagePersonInfoHeight";
    public static final String PAGE_PERSON_INFO_WEIGHT = "PagePersonInfoWeight";
    public static final String PAGE_SEARCH_MULTI_BRACELET = "PageSearchMultiBracelet";
    public static final String PAGE_SEARCH_SINGLE_BRACELET = "PageSearchSingleBracelet";
    public static final String PAGE_SHARE = "PageShare";
    public static final String PAGE_START_UP = "PageStartUp";
    public static final String PAGE_STATISTIC = "PageStatistic";
    public static final String PAGE_SYSTEM_LOW = "PageSystemLow";
    public static final String PAGE_SYSTEM_NOT_SUPPORT = "PageSystemNotSupport";
    public static final String PAGE_UNLOCK_HELP = "PageUnlockHelp";
    public static final String PAGE_UNLOCK_INVAILD_HELP = "PageUnlockInvaildHelp";
    public static final String PAGE_WEB_REGISTER = "PageWebRegister";
    public static final String PAGE_WEB_USER_AGREEMENT = "PageWebUserAgreement";
    public static final String VALUE_BIND_WECHART_LAUNCH = "BindWeChatLaunch";
    public static final String VALUE_BIND_WECHART_QRCODE = "BindWeChatQrcode";
    public static final String VALUE_CALL_IDLE = "CallIdle";
    public static final String VALUE_CALL_NOTIFY = "CallNotify";
    public static final String VALUE_CALL_OFFHOOK = "CallOffhook";
    public static final String VALUE_CALL_RING = "CallRing";
    public static final String VALUE_CANCELED = "Canceled";
    public static final String VALUE_CONFIRMED = "Confirmed";
    public static final String VALUE_DYNAMIC_LIST_ITEM_CLICK = "DynamicListItemClick";
    public static final String VALUE_FAILED = "Failed";
    public static final String VALUE_FROM_DYNAMIC_LIST = "FromDynamicList";
    public static final String VALUE_MAIN_MENU_ITEM_ABOUT = "MenuAbout";
    public static final String VALUE_MAIN_MENU_ITEM_ALARM = "MenuAlarm";
    public static final String VALUE_MAIN_MENU_ITEM_BRACELET = "MenuBracelet";
    public static final String VALUE_MAIN_MENU_ITEM_PERSON = "MenuPerson";
    public static final String VALUE_MAIN_MENU_ITEM_SHARE = "MenuShare";
    public static final String VALUE_MODE_SLEEP = "ModeSleep";
    public static final String VALUE_MODE_STEP = "ModeStep";
    public static final String VALUE_MODIFY_SLEEP_TIME_END = "SleepTimeEnd";
    public static final String VALUE_MODIFY_SLEEP_TIME_START = "SleepTimeStart";
    public static final String VALUE_SHARE_FROM_DYNAMIC = "ShareFromDynamic";
    public static final String VALUE_SHARE_FROM_DYNAMIC_DETAIL = "ShareFromDynamicDetail";
    public static final String VALUE_SHARE_FROM_DYNAMIC_LIST = "ShareFromDynamicList";
    public static final String VALUE_SHARE_FROM_STATISTIC = "ShareFromStatistic";
    public static final String VALUE_SHARE_TO_MICHAT = "ShareToMiChat";
    public static final String VALUE_SHARE_TO_QQ = "ShareToQQ";
    public static final String VALUE_SHARE_TO_QQ_ZONE = "ShareToQQZone";
    public static final String VALUE_SHARE_TO_WECHAT = "ShareToWeChat";
    public static final String VALUE_SHARE_TO_WECHAT_FRIENDS = "ShareToWeChatFriends";
    public static final String VALUE_SHARE_TO_WEIBO = "ShareToWeibo";
    public static final String VALUE_SHARE_TYPE_CONTINUE_DAYS = "ShareContinueDays";
    public static final String VALUE_SHARE_TYPE_EVENT = "ShareEvent";
    public static final String VALUE_SHARE_TYPE_MONTHLY_SLEEP = "ShareMonthlySleep";
    public static final String VALUE_SHARE_TYPE_MONTHLY_STEP = "ShareMonthlySteps";
    public static final String VALUE_SHARE_TYPE_NEW_RECORD = "ShareNewRecord";
    public static final String VALUE_SHARE_TYPE_SLEEP = "ShareSleep";
    public static final String VALUE_SHARE_TYPE_STEP_DYNAMIC_LIST = "ShareStepDynamicList";
    public static final String VALUE_SHARE_TYPE_STEP_GOAL_FAILED = "ShareStepGoalFailed";
    public static final String VALUE_SHARE_TYPE_STEP_GOAL_SUCCESS = "ShareStepGoalSuccess";
    public static final String VALUE_SHARE_TYPE_WEEKLY_SLEEP = "ShareWeeklySleep";
    public static final String VALUE_SHARE_TYPE_WEEKLY_STEP = "ShareWeeklySteps";
    public static final String VALUE_SLIDE_DOWN_CONNECT = "SlideDownConnect";
    public static final String VALUE_SLIDE_DOWN_SYNC = "SlideDownSync";
    public static final String VALUE_SLIDE_UP = "SlideUp";
    public static final String VALUE_START_LOGIN = "StartLogin";
    public static final String VALUE_START_REGISTER = "StartRegister";
    public static final String VALUE_STATISTIC_LEVEL_DAILY = "StatisticLevelDaily";
    public static final String VALUE_STATISTIC_LEVEL_MONTHLY = "StatisticLevelMonthly";
    public static final String VALUE_STATISTIC_LEVEL_WEEKLY = "StatisticLevelWeekly";
    public static final String VALUE_SUCCESSED = "Successed";
    public static final String VAULE_FROM_DYNAMIC = "FromDynamic";
    private static final String a = "UmengAnalyticsTracker";
    private static boolean b = true;

    public UmengAnalytics()
    {
    }

    public static void config(boolean flag, boolean flag1, boolean flag2)
    {
        b = flag;
        MobclickAgent.setDebugMode(flag1);
        MobclickAgent.openActivityDurationTrack(flag2);
    }

    public static void endEvent(Context context, String s)
    {
        endEvent(context, s, null);
    }

    public static void endEvent(Context context, String s, String s1)
    {
        if (!b)
        {
            return;
        }
        Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("End Event : ").append(s).append(", Value : ").append(s1).toString());
        if (s1 == null)
        {
            MobclickAgent.onEventEnd(context, s);
            return;
        } else
        {
            MobclickAgent.onEventEnd(context, s, s1);
            return;
        }
    }

    public static void endPage(String s)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("End Page : ").append(s).toString());
            MobclickAgent.onPageEnd(s);
            return;
        }
    }

    public static void endSession(Context context)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("End Session : ").append(context).toString());
            MobclickAgent.onPause(context);
            return;
        }
    }

    public static void event(Context context, String s)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Event : ").append(s).toString());
            MobclickAgent.onEvent(context, s);
            return;
        }
    }

    public static void event(Context context, String s, int i)
    {
        event(context, s, ((HashMap) (null)), i);
    }

    public static void event(Context context, String s, String s1)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Event : ").append(s).append(", Value : ").append(s1).toString());
            MobclickAgent.onEvent(context, s, s1);
            return;
        }
    }

    public static void event(Context context, String s, String s1, String s2)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Event : ").append(s).append(", Key : ").append(s1).append(", Value : ").append(s2).toString());
            HashMap hashmap = new HashMap();
            hashmap.put(s1, s2);
            MobclickAgent.onEvent(context, s, hashmap);
            return;
        }
    }

    public static void event(Context context, String s, String s1, String s2, int i)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s2);
        event(context, s, hashmap, i);
    }

    public static void event(Context context, String s, HashMap hashmap)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Event : ").append(s).append(", Properties : ").append(hashmap).toString());
            MobclickAgent.onEvent(context, s, hashmap);
            return;
        }
    }

    public static void event(Context context, String s, HashMap hashmap, int i)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Event : ").append(s).append(", Properties : ").append(hashmap).append(", Value : ").append(i).toString());
            MobclickAgent.onEventValue(context, s, hashmap, i);
            return;
        }
    }

    public static void exception(Context context, Exception exception1)
    {
        MobclickAgent.reportError(context, exception1);
    }

    public static void exception(Context context, String s)
    {
        MobclickAgent.reportError(context, s);
    }

    public static void startEvent(Context context, String s)
    {
        startEvent(context, s, null);
    }

    public static void startEvent(Context context, String s, String s1)
    {
        if (!b)
        {
            return;
        }
        Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Start Event : ").append(s).append(", Value : ").append(s1).toString());
        if (s1 == null)
        {
            MobclickAgent.onEventBegin(context, s);
            return;
        } else
        {
            MobclickAgent.onEventBegin(context, s, s1);
            return;
        }
    }

    public static void startPage(String s)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Start Page : ").append(s).toString());
            MobclickAgent.onPageStart(s);
            return;
        }
    }

    public static void startSession(Context context)
    {
        if (!b)
        {
            return;
        } else
        {
            Log.v("UmengAnalyticsTracker", (new StringBuilder()).append("Start Session : ").append(context).toString());
            MobclickAgent.onResume(context);
            return;
        }
    }

}
