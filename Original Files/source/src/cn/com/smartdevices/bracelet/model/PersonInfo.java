// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            UserTotalSportData, UserLocationData, MiliConfig, AlarmClockItem

public class PersonInfo
{

    public static final int INCOMING_CALL_DEFAULT = 276;
    public static final int INCOMING_CALL_DEFAULT_SEC = 20;
    public static final int INCOMING_CALL_DISABLE_BIT = 256;
    public static final int SYNC_AVATAR_NEEDED = 1;
    public static final int SYNC_OK = 0;
    public static final int SYNC_PERSON_NEEDED = 2;
    private static final String TAG = "PersonInfo";
    public int age;
    public ArrayList alarmClockItems;
    public String avatarPath;
    public String avatarUrl;
    public String birthday;
    public String createTime;
    public String deviceId;
    public int gender;
    public int gid;
    public int height;
    public String lastLoginTime;
    public UserLocationData location;
    public MiliConfig miliConfig;
    private int needSyncServer;
    public String nickname;
    public String personSignature;
    public String pinyin;
    public String sh;
    public String source;
    public int state;
    public UserTotalSportData totalSportData;
    public long uid;
    public int weight;

    public PersonInfo()
    {
        nickname = "";
        avatarUrl = "";
        avatarPath = "";
        gender = -1;
        height = -1;
        weight = -1;
        birthday = "";
        age = -1;
        createTime = "";
        lastLoginTime = "";
        uid = -1L;
        source = "";
        state = 0;
        gid = -1;
        personSignature = "";
        pinyin = "#";
        sh = "";
        deviceId = "";
        totalSportData = new UserTotalSportData();
        location = new UserLocationData();
        alarmClockItems = new ArrayList();
        miliConfig = new MiliConfig();
        needSyncServer = 0;
    }

    public static ArrayList parseAlarmClockItems(String s)
    {
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)Utils.getGson().fromJson(s, (new _cls1()).getType());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return arraylist;
    }

    public void clearNeedSyncServer()
    {
        needSyncServer = 0;
    }

    public void disableInComingCallTime()
    {
        miliConfig.inComingCallNotifyTime = 0x100 | getInComingCallTime();
        Debug.i("PersonInfo", (new StringBuilder()).append("disable incoming = ").append(miliConfig.inComingCallNotifyTime).toString());
    }

    public void enableInComingCallTime()
    {
        miliConfig.inComingCallNotifyTime = 0xff & getInComingCallTime();
        Debug.i("PersonInfo", (new StringBuilder()).append("enable incoming = ").append(miliConfig.inComingCallNotifyTime).toString());
    }

    public ArrayList getAlarmClockItems()
    {
        if (alarmClockItems == null)
        {
            alarmClockItems = new ArrayList();
        }
        if (alarmClockItems.size() < 3)
        {
            ArrayList arraylist = Keeper.readMorningAlarms();
            int i = 0;
            int j = alarmClockItems.size();
            while (j < 3) 
            {
                AlarmClockItem alarmclockitem = new AlarmClockItem();
                int k;
                if (arraylist != null && arraylist.size() > i)
                {
                    alarmclockitem.setCalendar((Calendar)arraylist.get(i));
                    k = i + 1;
                } else
                {
                    k = i;
                }
                alarmClockItems.add(alarmclockitem);
                j++;
                i = k;
            }
            Keeper.keepPersonInfo(this);
            Debug.i("PersonInfo", (new StringBuilder()).append("add new alarm size=").append(alarmClockItems.size()).toString());
        }
        return alarmClockItems;
    }

    public int getDaySportGoalSteps()
    {
        return miliConfig.goalStepsCount;
    }

    public Calendar getFirstUseDate()
    {
        return miliConfig.firstUseDate;
    }

    public int getInComingCallTime()
    {
        return 0xff & miliConfig.inComingCallNotifyTime;
    }

    public String getMiliColor()
    {
        return miliConfig.lightColor;
    }

    public String getMiliWearHand()
    {
        return miliConfig.wearHand;
    }

    public int getNeedSyncServer()
    {
        return needSyncServer;
    }

    public boolean isInComingCallEnabled()
    {
        boolean flag;
        if ((0x100 & miliConfig.inComingCallNotifyTime) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.i("PersonInfo", (new StringBuilder()).append("isInComingCallEnabled = ").append(flag).toString());
        return flag;
    }

    public boolean isValid()
    {
        return uid != -1L && gender != -1 && height != -1 && weight != -1 && age != -1 && getDaySportGoalSteps() > 0;
    }

    public void setDaySportGoals(int i)
    {
        miliConfig.goalStepsCount = i;
    }

    public void setFirstUseDate(Calendar calendar)
    {
        miliConfig.firstUseDate = calendar;
    }

    public void setInComingCallTime(int i)
    {
        miliConfig.inComingCallNotifyTime = i | 0x100 & miliConfig.inComingCallNotifyTime;
        Debug.i("PersonInfo", (new StringBuilder()).append("set incoming = ").append(miliConfig.inComingCallNotifyTime).toString());
    }

    public void setMiliColor(String s)
    {
        miliConfig.lightColor = s;
    }

    public void setMiliConfig(MiliConfig miliconfig)
    {
        miliConfig = miliconfig;
    }

    public void setMiliWearHand(String s)
    {
        miliConfig.wearHand = s;
    }

    public void setNeedSyncServer(int i)
    {
        needSyncServer = i | needSyncServer;
    }

    public String toString()
    {
        return Utils.getGson().toJson(this);
    }

    private class _cls1 extends TypeToken
    {

        _cls1()
        {
        }
    }

}
