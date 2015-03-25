// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.analysis.DataAnalysis;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.db.BraceletDbHelper;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            UmengAnalytics, Debug, Utils, Keeper, 
//            b

public class DataManager
{

    public static final int DAY_SPORT_LEN = 1440;
    public static final ArrayList INIT_INDEX_LIST;
    public static final ArrayList INIT_ORIGIN_LIST;
    private static final String a = "DataManager";
    private static DataManager j = null;
    private static Context l = null;
    private BraceletDbHelper b;
    private ConcurrentHashMap c;
    private ConcurrentHashMap d;
    private SportDay e;
    private SportDay f;
    private SportDay g;
    private SportDay h;
    private SportDay i;
    private NetDataInfo k;
    private SportDay m;

    private DataManager(Context context)
    {
        b = null;
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new SportDay();
        f = new SportDay();
        g = new SportDay();
        h = null;
        i = null;
        k = null;
        m = null;
        l = context;
        b = BraceletDbHelper.getInstance();
        initDays();
    }

    private int a(String s, String s1)
    {
        Calendar calendar = SportDay.toCalenday(s);
        return 1 + (int)((SportDay.toCalenday(s1).getTime().getTime() - calendar.getTime().getTime()) / 0x5265c00L);
    }

    private DaySportData a(SportDay sportday)
    {
        byte abyte0[] = b.readOriginData(sportday.getKey());
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        } else
        {
            DaySportData daysportdata = new DaySportData(sportday);
            daysportdata.fromBinaryData(sportday, abyte0);
            return daysportdata;
        }
    }

    private void a()
    {
        b();
        initDays();
    }

    private void a(Context context, int i1, int j1)
    {
        boolean flag = true;
        if (i1 != j1 && context != null)
        {
            boolean flag1;
            if (j1 - i1 < 0)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            if (j1 - i1 <= 0)
            {
                flag = false;
            }
            if (flag1)
            {
                UmengAnalytics.event(context, "ExceptRealtimeLessDetailStep", Math.abs(j1 - i1));
            } else
            if (flag)
            {
                UmengAnalytics.event(context, "ExceptRealtimeMoreDetailStep", Math.abs(j1 - i1));
                return;
            }
        }
    }

    private void a(cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity summaryentity, JSONObject jsonobject)
    {
        JSONObject jsonobject2;
        JSONObject jsonobject1 = jsonobject.getJSONObject("steps_info");
        jsonobject2 = jsonobject.getJSONObject("sleep_info");
        summaryentity.setSteps(jsonobject1.optInt("steps"));
        summaryentity.setStepDistance(jsonobject1.optInt("distance"));
        summaryentity.setStepCalorie(jsonobject1.optInt("calories"));
        summaryentity.setStepActiveTime(jsonobject1.optInt("active_time"));
        summaryentity.setStepContinueTime(jsonobject1.optInt("continus_active_time"));
        summaryentity.setStepWalkTime(jsonobject1.optInt("walk_time"));
        summaryentity.setStepRunTime(jsonobject1.optInt("run_time"));
        summaryentity.setSleep(jsonobject2.optInt("sleep_minutes"));
        summaryentity.setSleepDeepTime(jsonobject2.optInt("nrem_minutes"));
        summaryentity.setSleepShallowTime(jsonobject2.optInt("rem_minutes"));
        long l4 = jsonobject2.getLong("start_date");
        long l1 = l4;
_L1:
        summaryentity.setSleepStartTime(l1);
        long l3 = jsonobject2.getLong("stop_date");
        long l2 = l3;
_L2:
        summaryentity.setSleepRiseTime(l2);
        summaryentity.setSleepWakeTime(jsonobject2.optInt("awake_minutes"));
        JSONObject jsonobject3 = jsonobject.optJSONObject("daysportgoal_info");
        if (jsonobject3 != null)
        {
            summaryentity.setDayStepGoal(jsonobject3.optInt("goalStepsCount"));
        }
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        l1 = java.sql.Date.parse(jsonobject2.getString("start_date"));
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        l2 = java.sql.Date.parse(jsonobject2.getString("stop_date"));
          goto _L2
    }

    private void a(cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity summaryentity, JSONObject jsonobject, int i1)
    {
        JSONObject jsonobject1 = jsonobject.getJSONObject(StepsInfo.KEY_STEP_INFO);
        JSONObject jsonobject2 = jsonobject.getJSONObject(SleepInfo.KEY_SLEEP_INFO);
        summaryentity.setSteps(jsonobject1.optInt(StepsInfo.KEY_STEPS));
        summaryentity.setStepDistance(jsonobject1.optInt(StepsInfo.KEY_DISTANCE));
        summaryentity.setStepCalorie(jsonobject1.optInt(StepsInfo.KEY_CALORIES));
        summaryentity.setStepContinueTime(jsonobject1.optInt(StepsInfo.KEY_CONTINUS_ACTIVE_TIME));
        int j1 = jsonobject1.optInt(StepsInfo.KEY_STEP_WALK_TIME);
        int k1 = jsonobject1.optInt(StepsInfo.KEY_STEP_RUN_TIME);
        int l1 = jsonobject1.optInt(StepsInfo.KEY_STEP_RUN_DISTANCE);
        summaryentity.setStepWalkTime(j1);
        summaryentity.setStepRunTime(k1);
        summaryentity.setStepRunDistance(l1);
        summaryentity.setStepActiveTime(j1 + k1);
        int i2 = jsonobject2.optInt(SleepInfo.KEY_DEEP_MINUTES);
        int j2 = jsonobject2.optInt(SleepInfo.KEY_LIGHT_MINUTES);
        if (i1 == 1)
        {
            summaryentity.setSleepDeepTime(j2);
            summaryentity.setSleepShallowTime(i2);
        } else
        {
            summaryentity.setSleepDeepTime(i2);
            summaryentity.setSleepShallowTime(j2);
        }
        summaryentity.setSleep(i2 + j2);
        summaryentity.setSleepWakeTime(jsonobject2.optInt(SleepInfo.KEY_AWAKE_MINUTES));
        summaryentity.setSleepStartTime(1000L * jsonobject2.getLong(SleepInfo.KEY_START_DATE));
        summaryentity.setSleepRiseTime(1000L * jsonobject2.getLong(SleepInfo.KEY_END_DATE));
        summaryentity.setUserSleepStart(jsonobject2.optInt(SleepInfo.KEY_USER_SLEEP_START, 0x80000000));
        summaryentity.setUserSleepEnd(jsonobject2.optInt(SleepInfo.KEY_USER_SLEEP_END, 0x80000000));
        if (i1 <= 2)
        {
            if (!jsonobject.isNull("daysportgoal_info"))
            {
                summaryentity.setDayStepGoal(jsonobject.optInt("daysportgoal_info"));
            }
            return;
        } else
        {
            summaryentity.setDayStepGoal(jsonobject.optInt("goal"));
            return;
        }
    }

    private DaySportData b(SportDay sportday)
    {
        return a(sportday);
    }

    private void b()
    {
        Debug.i("DataManager", "clear.................................");
        c.clear();
        e = getToday();
        f = getToday();
        g = getToday();
    }

    private void c()
    {
        long l1 = System.currentTimeMillis();
        Debug.i("DataManager", "in loadNetData");
        if (!Utils.isNetworkConnected(l))
        {
            return;
        } else
        {
            WebAPI.syncFromServerNew(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, 3, new b(this));
            long l2 = System.currentTimeMillis();
            Debug.i("DataManager", (new StringBuilder()).append("out loadNetData:").append(l2 - l1).append("ms").toString());
            return;
        }
    }

    public static DataManager getInstance()
    {
        return j;
    }

    public static void init(Context context)
    {
        BraceletDbHelper.create(context);
        if (j == null)
        {
            j = new DataManager(context);
        }
    }

    public void add(DaySportData daysportdata)
    {
        Debug.i("DataManager", (new StringBuilder()).append("add:").append(daysportdata.getSportDay().formatString()).append(",").append(daysportdata.data().size()).toString());
        c.put(daysportdata.getKey(), daysportdata);
        SportDay sportday = daysportdata.getSportDay();
        if (e.compare(sportday) == 1)
        {
            e = sportday;
        }
    }

    public void analysis()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        Debug.f("DataManager", "in analysis");
        iterator = c.entrySet().iterator();
_L2:
        DaySportData daysportdata;
        SportDay sportday;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_153;
            }
            daysportdata = (DaySportData)((java.util.Map.Entry)iterator.next()).getValue();
            sportday = daysportdata.getSportDay();
        } while (daysportdata == null);
        if (!daysportdata.isNeedPostProcess() || !daysportdata.isLocalNeedSync()) goto _L2; else goto _L1
_L1:
        SportDay sportday1;
        DaySportData daysportdata1;
        sportday1 = sportday.addDay(-1);
        daysportdata1 = get(sportday1);
        if (daysportdata1 != null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        daysportdata1 = a(sportday1);
        DaySportData daysportdata2 = get(sportday.addDay(1));
        if (daysportdata1 != null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        daysportdata1 = a(sportday1);
        DataAnalysis.dataPostProcess(l, daysportdata1, daysportdata, daysportdata2);
        removeSummary(sportday);
          goto _L2
        Exception exception;
        exception;
        throw exception;
        Debug.f("DataManager", "out analysis");
        this;
        JVM INSTR monitorexit ;
    }

    public void clearAll()
    {
        c.clear();
        d.clear();
        b.dropAllDatas();
        k = new NetDataInfo();
    }

    public void clearSummaryCache(SportDay sportday)
    {
        if (sportday == null || d == null)
        {
            return;
        } else
        {
            d.remove(sportday.getKey());
            return;
        }
    }

    public int daysOfAllData()
    {
        return b.getCount();
    }

    public DaySportData get(SportDay sportday)
    {
        if (sportday == null)
        {
            return new DaySportData(getToday());
        } else
        {
            return (DaySportData)c.get(sportday.getKey());
        }
    }

    public DaySportData get(String s)
    {
        return (DaySportData)c.get(s);
    }

    public ReportData getContinueReachGoalReportData()
    {
        Debug.i("DataManager", "in getContinueReachGoalReportData");
        Debug.i("DataManager", (new StringBuilder()).append("startDay:").append(e.formatString()).append(",stopDay:").append(f.formatString()).toString());
        SportDay sportday = e;
        SportDay sportday1 = f;
        ReportData reportdata = null;
        ArrayList arraylist = new ArrayList();
        while (sportday1.compare(sportday) >= 0) 
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary1 = getSummary(sportday1);
            if (summary1.getDayStepGoal() <= summary1.getSteps())
            {
                if (reportdata == null)
                {
                    reportdata = new ReportData();
                    arraylist.add(reportdata);
                    reportdata.type = "SHARE_TYPE_CONTIUE_REACH_GOAL";
                    reportdata.timeTo = sportday1.getKey();
                }
                reportdata.timeFrom = sportday1.getKey();
                reportdata.calories = reportdata.calories + summary1.getStepCalorie();
                reportdata.steps = reportdata.steps + summary1.getSteps();
                reportdata.distance = reportdata.distance + summary1.getStepDistance();
                reportdata.runDistance = reportdata.runDistance + summary1.getStepRunDistance();
            } else
            {
                reportdata = null;
            }
            sportday1 = sportday1.addDay(-1);
        }
        int i1 = 0;
        if (arraylist.size() == 0)
        {
            return new ReportData();
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(6, -1);
        cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = getSummary(new SportDay(calendar1));
        boolean flag;
        Iterator iterator;
        if (summary.getSteps() >= summary.getDayStepGoal())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iterator = arraylist.iterator();
        while (iterator.hasNext()) 
        {
            ReportData reportdata2;
            int k1;
            boolean flag1;
label0:
            {
                reportdata2 = (ReportData)iterator.next();
                Debug.i("DataManager", (new StringBuilder()).append(reportdata2.timeFrom).append("--->").append(reportdata2.timeTo).toString());
                k1 = a(reportdata2.timeFrom, reportdata2.timeTo);
                Calendar calendar2 = SportDay.toCalenday(reportdata2.timeTo);
                if (Utils.getCalendarDay(calendar2) != Utils.getCalendarDay(calendar1))
                {
                    int i2 = Utils.getCalendarDay(calendar2);
                    int j2 = Utils.getCalendarDay(calendar);
                    flag1 = false;
                    if (i2 != j2)
                    {
                        break label0;
                    }
                }
                flag1 = false;
                if (flag)
                {
                    flag1 = true;
                }
            }
            Debug.i("DataManager", (new StringBuilder()).append("Found days : ").append(k1).append(", yesterdayReachGoal = ").append(flag).append(", timeTo = ").append(reportdata2.timeTo).toString());
            ReportData reportdata1;
            SportDay sportday2;
            int j1;
            int l1;
            if (k1 >= 2 && k1 > i1 && !flag1)
            {
                Debug.fi("DataManager", (new StringBuilder()).append("Found days max: ").append(k1).append(", yesterdayReachGoal = ").append(flag).append(", timeTo = ").append(reportdata2.timeTo).toString());
                l1 = k1;
            } else
            {
                l1 = i1;
            }
            i1 = l1;
        }
        reportdata1 = (ReportData)arraylist.get(0);
        sportday2 = SportDay.fromString(reportdata1.timeTo);
        j1 = a(reportdata1.timeFrom, reportdata1.timeTo);
        if (sportday2.compare((new SportDay()).addDay(-1)) < 0 || j1 < 2)
        {
            return new ReportData();
        }
        reportdata1.maxContinueDays = i1;
        reportdata1.continueDays = j1;
        if (sportday2.compare(new SportDay()) == 0)
        {
            reportdata1.todayComplete = 1;
        }
        Debug.i("DataManager", "out getContinueReachGoalReportData");
        return reportdata1;
    }

    public SportDay getCurDay()
    {
        return g;
    }

    public ReportData getLastMonthReportData()
    {
        Debug.i("DataManager", "in getLastMonthReportData");
        ReportData reportdata = new ReportData();
        reportdata.type = "SHARE_TYPE_LAST_MONTH";
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        calendar.set(5, 1);
        SportDay sportday = new SportDay(calendar);
        calendar.set(5, 1);
        calendar.add(2, 1);
        calendar.add(5, -1);
        SportDay sportday1 = new SportDay(calendar);
        if (sportday1.compare(e) < 0)
        {
            return reportdata;
        }
        reportdata.timeFrom = sportday.getKey();
        reportdata.timeTo = sportday1.getKey();
        if (sportday.compare(e) < 0)
        {
            sportday = e;
        }
        if (sportday1.compare(f) > 0)
        {
            sportday1 = f;
        }
        Debug.i("DataManager", (new StringBuilder()).append("startDay:").append(sportday.formatString()).append(",stopDay:").append(sportday1.formatString()).toString());
        for (; sportday1.compare(sportday) >= 0; sportday1 = sportday1.addDay(-1))
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = getSummary(sportday1);
            if (summary == null || summary.getSteps() <= 0)
            {
                continue;
            }
            reportdata.distance = reportdata.distance + summary.getStepDistance();
            reportdata.calories = reportdata.calories + summary.getStepCalorie();
            reportdata.steps = reportdata.steps + summary.getSteps();
            if (summary.getSteps() > reportdata.maxDateStep)
            {
                reportdata.maxDateStep = summary.getSteps();
                reportdata.maxDateStr = sportday1.getKey();
            }
        }

        Debug.i("DataManager", "out getLastMonthReportData");
        return reportdata;
    }

    public ReportData getLastWeekReportData()
    {
        Debug.i("DataManager", "in getLastWeekReportData");
        ReportData reportdata = new ReportData();
        reportdata.type = "SHARE_TYPE_LAST_WEEK";
        Calendar calendar = Calendar.getInstance();
        int i1 = calendar.get(7);
        int j1;
        SportDay sportday;
        SportDay sportday1;
        if (i1 == 1)
        {
            j1 = -6;
        } else
        {
            j1 = 2 - i1;
        }
        calendar.add(5, j1 - 7);
        sportday = new SportDay(calendar);
        calendar.add(5, 6);
        sportday1 = new SportDay(calendar);
        if (sportday1.compare(e) < 0)
        {
            return reportdata;
        }
        reportdata.timeFrom = sportday.getKey();
        reportdata.timeTo = sportday1.getKey();
        if (sportday.compare(e) < 0)
        {
            sportday = e;
        }
        if (sportday1.compare(f) > 0)
        {
            sportday1 = f;
        }
        Debug.i("DataManager", (new StringBuilder()).append("startDay:").append(sportday.formatString()).append(",stopDay:").append(sportday1.formatString()).toString());
        for (; sportday1.compare(sportday) >= 0; sportday1 = sportday1.addDay(-1))
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = getSummary(sportday1);
            if (summary == null || summary.getSteps() <= 0)
            {
                continue;
            }
            reportdata.distance = reportdata.distance + summary.getStepDistance();
            reportdata.calories = reportdata.calories + summary.getStepCalorie();
            reportdata.steps = reportdata.steps + summary.getSteps();
            if (summary.getSteps() > reportdata.maxDateStep)
            {
                reportdata.maxDateStep = summary.getSteps();
                reportdata.maxDateStr = sportday1.getKey();
            }
        }

        Debug.i("DataManager", "out getLastWeekReportData");
        return reportdata;
    }

    public ArrayList getNeedSyncDatas()
    {
        return b.readNotSyncDatas();
    }

    public SportDay getStartDay()
    {
        return e;
    }

    public ReportData getStepRecord()
    {
        Debug.i("DataManager", "in getStepRecord");
        Debug.i("DataManager", (new StringBuilder()).append("startDay:").append(e.formatString()).append(",stopDay:").append(f.formatString()).toString());
        ReportData reportdata = new ReportData();
        reportdata.type = "SHARE_TYPE_NEW_RECORD";
        SportDay sportday = e;
        for (SportDay sportday1 = f.addDay(-1); sportday1.compare(sportday) >= 0; sportday1 = sportday1.addDay(-1))
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = getSummary(sportday1);
            if (summary != null && summary.getSteps() > 0 && summary.getSteps() > reportdata.steps)
            {
                reportdata.distance = summary.getStepDistance();
                reportdata.calories = summary.getStepCalorie();
                reportdata.steps = summary.getSteps();
                reportdata.maxDateStep = summary.getSteps();
                reportdata.maxDateStr = sportday1.getKey();
            }
        }

        Debug.i("DataManager", (new StringBuilder()).append("out getStepRecord:").append(reportdata.steps).toString());
        return reportdata;
    }

    public SportDay getStopDay()
    {
        return getToday();
    }

    public cn.com.smartdevices.bracelet.model.DaySportData.Summary getSummary(SportDay sportday)
    {
        Object obj;
        Debug.i("DataManager", (new StringBuilder()).append("Get Summary : ").append(sportday).toString());
        obj = (cn.com.smartdevices.bracelet.model.DaySportData.Summary)d.get(sportday.getKey());
        if (obj != null) goto _L2; else goto _L1
_L1:
        String s;
        s = b.readSummary(sportday.getKey());
        Debug.i("DataManager", (new StringBuilder()).append("Read Summary : ").append(sportday).append(" , ").append(s).toString());
        if (TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        obj = new cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity();
        JSONObject jsonobject;
        int i1;
        jsonobject = new JSONObject(s);
        i1 = jsonobject.optInt("v", 0);
        if (i1 < 1) goto _L6; else goto _L5
_L5:
        try
        {
            a(((cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity) (obj)), jsonobject, i1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
_L8:
        d.put(sportday.getKey(), obj);
_L2:
        return ((cn.com.smartdevices.bracelet.model.DaySportData.Summary) (obj));
_L6:
        a(((cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity) (obj)), jsonobject);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new cn.com.smartdevices.bracelet.model.DaySportData.SummaryEmpty();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public DaySportData getSync(int i1, int j1, int k1)
    {
        SportDay sportday = new SportDay(i1, j1, k1);
        if (!c.containsKey(sportday.getKey()) && sportday.compare(getStopDay()) <= 0 && sportday.compare(m) > 0)
        {
            Debug.i("DataManager", (new StringBuilder()).append("getSync not contains :").append(sportday.getKey()).toString());
            Debug.f("DataManager", (new StringBuilder()).append("getSync not contains :").append(sportday.getKey()).toString());
            load(sportday);
        }
        return get(sportday);
    }

    public SportDay getToday()
    {
        return new SportDay();
    }

    public UserTotalSportData getUserTotalSportData()
    {
        Debug.i("DataManager", "in getUserTotalSportData");
        Debug.i("DataManager", (new StringBuilder()).append("startDay:").append(e.formatString()).append(",stopDay:").append(f.formatString()).toString());
        UserTotalSportData usertotalsportdata = new UserTotalSportData();
        SportDay sportday = e;
        for (SportDay sportday1 = f; sportday1.compare(sportday) >= 0; sportday1 = sportday1.addDay(-1))
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = getSummary(sportday1);
            if (summary != null && summary.getSteps() > 0)
            {
                usertotalsportdata.iDistance = usertotalsportdata.iDistance + summary.getStepDistance();
                usertotalsportdata.iSteps = usertotalsportdata.iSteps + summary.getSteps();
                usertotalsportdata.iTotalwearingdays = 1 + usertotalsportdata.iTotalwearingdays;
            }
        }

        if (usertotalsportdata.iTotalwearingdays != 0)
        {
            usertotalsportdata.iAverageSteps = usertotalsportdata.iSteps / usertotalsportdata.iTotalwearingdays;
        } else
        {
            usertotalsportdata.iAverageSteps = 0;
        }
        usertotalsportdata.translate();
        Debug.i("DataManager", (new StringBuilder()).append("UserTotalSportData:\n").append(usertotalsportdata.toString()).toString());
        Debug.i("DataManager", "out getUserTotalSportData");
        return usertotalsportdata;
    }

    public void initDays()
    {
        Debug.f("DataManager", "in initDays");
        m = new SportDay(2014, 1, 1);
        String as[] = b.dateOfStartAndStop();
        if (as != null)
        {
            e = SportDay.fromString(as[0]);
            f = SportDay.fromString(as[1]);
            g = getStopDay();
            if (e.compare(m) < 0)
            {
                e = m;
            }
            if (f.compare(g) > 0)
            {
                f = g;
            }
            Debug.i("DataManager", (new StringBuilder()).append("localStartDay:").append(e).append("\n").append("localStopDay:").append(f).append("\n").append("curDay:").append(g).toString());
        }
        k = Keeper.readNetInfo();
        if (k.hasData())
        {
            h = SportDay.fromString(k.startDate);
            i = SportDay.fromString(k.stopDate);
        }
        Debug.i("DataManager", (new StringBuilder()).append("netStartDay:").append(h).append("\n").append("netStopDay:").append(i).append("\n").append("curDay:").append(g).toString());
        Debug.f("DataManager", "out initDays");
    }

    public void insertDatas(ArrayList arraylist, int i1)
    {
        Debug.i("DataManager", "insertDatas.......................................0");
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            UploadData uploaddata = (UploadData)iterator.next();
            SportDay sportday = SportDay.fromString(uploaddata.date);
            Debug.i("DataManager", (new StringBuilder()).append("SD:").append(sportday.getKey()).toString());
            DaySportData daysportdata;
            if (c.containsKey(sportday.getKey()))
            {
                daysportdata = (DaySportData)c.get(sportday.getKey());
            } else
            {
                daysportdata = a(sportday);
            }
            if (daysportdata != null)
            {
                Debug.i("DataManager", "dayData not null.................");
                DaySportData daysportdata1 = DaySportData.sFromBinaryData(sportday, uploaddata.data);
                daysportdata1.merge(daysportdata);
                uploaddata.data = daysportdata1.getBinaryData();
            }
        } while (true);
        Debug.i("DataManager", "insertDatas.......................................1");
        b.insertDatas(arraylist, i1);
        Debug.i("DataManager", "insertDatas.......................................2");
        a();
    }

    public boolean isStartDay()
    {
        return g.equals(e);
    }

    public boolean isStopDay()
    {
        return g.equals(getStopDay());
    }

    public int load(SportDay sportday)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        SportDay sportday1;
        SportDay sportday2;
        DaySportData daysportdata5;
        Debug.i("DataManager", (new StringBuilder()).append("load:").append(sportday.formatString()).toString());
        sportday1 = sportday.addDay(-1);
        sportday2 = sportday.addDay(1);
        if (k.isUnknow())
        {
            c();
        }
        if (c.containsKey(sportday.getKey()))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        daysportdata5 = b(sportday);
        if (daysportdata5 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        add(daysportdata5);
        boolean flag1;
        DaySportData daysportdata;
        DaySportData daysportdata1;
        DaySportData daysportdata2;
        DaySportData daysportdata3;
        DaySportData daysportdata4;
        if (sportday1.compare(e) >= 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (c.containsKey(sportday1.getKey()))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        daysportdata4 = b(sportday1);
        if (daysportdata4 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        add(daysportdata4);
        if (sportday2.compare(getStopDay()) > 0)
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (c.containsKey(sportday2.getKey()))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        daysportdata3 = b(sportday2);
        if (daysportdata3 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        add(daysportdata3);
        Debug.i("DataManager", (new StringBuilder()).append("today:").append(sportday.formatString()).append(",yesterday:").append(sportday1.formatString()).append(",tomorrow:").append(sportday2.formatString()).toString());
        daysportdata = get(sportday);
        daysportdata1 = get(sportday1);
        daysportdata2 = get(sportday2);
        if (daysportdata == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        if (daysportdata.isNeedPostProcess())
        {
            DataAnalysis.dataPostProcess(l, daysportdata1, daysportdata, daysportdata2);
        }
        this;
        JVM INSTR monitorexit ;
        return 0;
        Exception exception;
        exception;
        throw exception;
    }

    public void load(int i1, int j1)
    {
        Debug.i("DataManager", (new StringBuilder()).append("load:").append(i1).append(",").append(j1).toString());
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        SportDay sportday = g;
_L4:
        if (sportday != null)
        {
            load(sportday.addDay(i1));
        }
        return;
_L2:
        if (j1 == 1)
        {
            sportday = e;
        } else
        {
            sportday = null;
            if (j1 == 2)
            {
                sportday = getStopDay();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void removeSummary(SportDay sportday)
    {
        Debug.i("DataManager", (new StringBuilder()).append("Remove Summary : ").append(sportday).toString());
        d.remove(sportday.getKey());
    }

    public void saveToDb()
    {
        Debug.f("DataManager", "in saveToDb");
        Iterator iterator = c.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DaySportData daysportdata = (DaySportData)((java.util.Map.Entry)iterator.next()).getValue();
            if (daysportdata.isLocalNeedSync())
            {
                Debug.i("DataManager", (new StringBuilder()).append("saveToDb:").append(daysportdata.getKey()).toString());
                Debug.f("DataManager", (new StringBuilder()).append("saveToDb:").append(daysportdata.getKey()).toString());
                b.write(daysportdata.getKey(), daysportdata.getBinaryData(), daysportdata.getSummary(), daysportdata.getIndexS());
                daysportdata.setLocalNeedSync(false);
            }
        } while (true);
        Debug.f("DataManager", "out saveToDb");
    }

    public void saveToDb(DaySportData daysportdata)
    {
        b.write(daysportdata.getKey(), daysportdata.getBinaryData(), daysportdata.getSummary(), daysportdata.getIndexS());
    }

    public void setCurDay(int i1, int j1)
    {
        SportDay sportday = g;
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        sportday = g;
_L4:
        g = sportday.addDay(i1);
        return;
_L2:
        if (j1 == 1)
        {
            sportday = e;
        } else
        if (j1 == 2)
        {
            sportday = getStopDay();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCurDay(SportDay sportday)
    {
        g = sportday;
    }

    public void updateStepInfoWithRealtimeSteps()
    {
        int i1;
        int j1;
label0:
        {
            i1 = Keeper.readRealtimeSteps();
            Debug.i("DDDD", (new StringBuilder()).append("Dynamic Real-Step : ").append(i1).toString());
            if (i1 > -1)
            {
                SportDay sportday = getStopDay();
                if (sportday != null)
                {
                    DaySportData daysportdata = get(sportday);
                    StepsInfo stepsinfo = null;
                    if (daysportdata != null)
                    {
                        stepsinfo = daysportdata.getStepsInfo();
                    }
                    if (stepsinfo != null)
                    {
                        j1 = stepsinfo.getStepsCount();
                        Debug.i("DDDD", (new StringBuilder()).append("Dynamic Step Info : ").append(j1).toString());
                        if (i1 - j1 <= 0 || i1 - j1 > 512)
                        {
                            break label0;
                        }
                        stepsinfo.setStepsCount(i1);
                        Debug.i("DDDD", (new StringBuilder()).append("Dynamic Step Info Up To : ").append(i1).toString());
                        removeSummary(sportday);
                        daysportdata.setNeedSync(true);
                    }
                }
            }
            return;
        }
        a(l, j1, i1);
    }

    public void updateSyncState(ArrayList arraylist, int i1)
    {
        b.updateSyncState(arraylist, i1);
    }

    static 
    {
        INIT_ORIGIN_LIST = new ArrayList();
        INIT_INDEX_LIST = new ArrayList();
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData((byte)0, (byte)0, (byte)126);
        for (int i1 = 0; i1 < 1440; i1++)
        {
            INIT_ORIGIN_LIST.add(activitydata);
            SportData sportdata = new SportData(i1, 126, 0, 0);
            INIT_INDEX_LIST.add(sportdata);
        }

    }
}
