// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.content.Context;
import java.text.DecimalFormat;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.util:
//            ChartUtil

public final class ChartData
{

    public static final String ACTION_DYNAMIC_COMPLETE_GOAL = "RefCompleteGoal";
    public static final String ACTION_DYNAMIC_LIST_VIEW = "DynamicView";
    public static final int HOURS = 24;
    public static final int HOUR_MINUTES = 60;
    public static final String KEY_ACTION = "Action";
    public static final String KEY_DYNAMIC_ACTIVE_TIME = "DynamicActiveTime";
    public static final String KEY_DYNAMIC_ACTIVITY_MODE = "DynamicActivityMode";
    public static final String KEY_DYNAMIC_ACTIVITY_SUB_TITLE = "DynamicActivitySubTitle";
    public static final String KEY_DYNAMIC_END_TIME = "DynamicEndTime";
    public static final String KEY_DYNAMIC_START_TIME = "DynamicStartTime";
    public static final String KEY_DYNAMIC_STEP = "DynamicStep";
    public static final String KEY_DYNAMIC_STEP_DISTANCE = "DynamicStepDistance";
    public static final int MINUTES = 1440;
    public static final String MODE = "Mode";
    public static final int MODE_NONE = 0;
    public static final int MODE_SLEEP = 16;
    public static final int MODE_STEP = 1;
    private static final boolean a;

    public ChartData()
    {
    }

    public static String[] formatDistance(Context context, int i)
    {
        String as[] = new String[2];
        float f = i;
        if (i >= 1000)
        {
            as[0] = (new DecimalFormat("#.#")).format(f / 1000F);
            as[1] = context.getString(0x7f0d01c0);
            return as;
        } else
        {
            as[0] = String.valueOf(i);
            as[1] = context.getString(0x7f0d01c1);
            return as;
        }
    }

    public static String formatTime(int i)
    {
        String as[] = formatTimeHourMin(i);
        return (new StringBuilder()).append(as[0]).append(":").append(as[1]).toString();
    }

    public static String[] formatTimeHourMin(int i)
    {
        if (i < 0)
        {
            i += 1440;
        }
        int j = i / 60;
        int k = i % 60;
        String as[] = new String[2];
        as[0] = String.valueOf(j);
        as[1] = String.valueOf(k);
        if (j < 10)
        {
            as[0] = (new StringBuilder()).append("0").append(as[0]).toString();
        }
        if (k < 10)
        {
            as[1] = (new StringBuilder()).append("0").append(as[1]).toString();
        }
        return as;
    }

    public static String[] formatTimeHourMinLong(int i)
    {
        int j = i / 60;
        int k = i % 60;
        String as[] = new String[2];
        as[0] = String.valueOf(j);
        as[1] = String.valueOf(k);
        if (k < 10)
        {
            as[1] = (new StringBuilder()).append("0").append(as[1]).toString();
        }
        return as;
    }

    public static CharSequence formatTimeLength(Context context, int i, int j)
    {
        String as[] = formatTimeLengthHourMin(i);
        float _tmp = 1.33F * ChartUtil.getDensity();
        if (!as[0].equals("0"))
        {
            Object aobj1[] = new Object[2];
            aobj1[0] = as[0];
            aobj1[1] = as[1];
            return context.getString(0x7f0d01b7, aobj1);
        } else
        {
            Object aobj[] = new Object[1];
            aobj[0] = as[1];
            return context.getString(0x7f0d01b8, aobj);
        }
    }

    public static String formatTimeLength(Context context, int i)
    {
        String as[] = formatTimeLengthHourMin(i);
        if (!as[0].equals("0"))
        {
            Object aobj1[] = new Object[2];
            aobj1[0] = as[0];
            aobj1[1] = as[1];
            return context.getString(0x7f0d01b7, aobj1);
        } else
        {
            Object aobj[] = new Object[1];
            aobj[0] = as[1];
            return context.getString(0x7f0d01b8, aobj);
        }
    }

    public static String[] formatTimeLengthHourMin(int i)
    {
        int j = i / 60;
        int k = i % 60;
        String as[] = new String[2];
        as[0] = String.valueOf(j);
        as[1] = String.valueOf(k);
        if (j > 0 && k < 10)
        {
            as[1] = (new StringBuilder()).append("0").append(as[1]).toString();
        }
        return as;
    }

    public static String formatTimeLengthLong(Context context, int i)
    {
        String as[] = formatTimeHourMinLong(i);
        Object aobj[] = new Object[2];
        aobj[0] = as[0];
        aobj[1] = as[1];
        return context.getString(0x7f0d01b7, aobj);
    }

    public static DynamicData getDynamicData()
    {
        return DynamicData.getData();
    }

    private class DynamicData
    {

        private static DynamicData m;
        private int a;
        private int b;
        private int c;
        private String d;
        private int e;
        private int f;
        private Date g;
        private Date h;
        private String i;
        private boolean j;
        private int k;
        private HashMap l;

        public static DynamicData getData()
        {
            if (m == null)
            {
                m = new DynamicData();
            }
            return m;
        }

        public int getCurrentMode()
        {
            return k;
        }

        public int getSleepDeepTime()
        {
            return f;
        }

        public Date getSleepStartDate()
        {
            return g;
        }

        public Date getSleepStopDate()
        {
            return h;
        }

        public int getSleepTime()
        {
            return e;
        }

        public String getSleepTip()
        {
            return i;
        }

        public int getStepCalorie()
        {
            return c;
        }

        public int getStepCount()
        {
            return a;
        }

        public int getStepDistance()
        {
            return b;
        }

        public String getStepTip()
        {
            return d;
        }

        public UserSleepModify getUserSleepModify(SportDay sportday)
        {
            String s = sportday.getKey();
            UserSleepModify usersleepmodify;
            if (l.containsKey(s))
            {
                usersleepmodify = (UserSleepModify)l.get(s);
            } else
            {
                DataManager datamanager = DataManager.getInstance();
                cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = datamanager.getSummary(sportday);
                usersleepmodify = new UserSleepModify();
                if (summary != null)
                {
                    usersleepmodify.sleepStart = summary.getUserSleepStart();
                    usersleepmodify.sleepEnd = summary.getUserSleepEnd();
                    putUserSleepModify(sportday, usersleepmodify);
                    datamanager.removeSummary(sportday);
                    return usersleepmodify;
                }
            }
            return usersleepmodify;
        }

        public boolean isWeared()
        {
            return j;
        }

        public void putUserSleepModify(SportDay sportday, UserSleepModify usersleepmodify)
        {
            l.put(sportday.getKey(), usersleepmodify);
        }

        public void setCurrentMode(int i1)
        {
            k = i1;
        }

        public void setSleepDeepTime(int i1)
        {
            f = i1;
        }

        public void setSleepStartDate(Date date)
        {
            g = date;
        }

        public void setSleepStopDate(Date date)
        {
            h = date;
        }

        public void setSleepTime(int i1)
        {
            e = i1;
        }

        public void setSleepTip(String s)
        {
            i = s;
        }

        public void setStepCalorie(int i1)
        {
            c = i1;
        }

        public void setStepCount(int i1)
        {
            a = i1;
        }

        public void setStepDistance(int i1)
        {
            b = i1;
        }

        public void setStepTip(String s)
        {
            d = s;
        }

        public void setWeared(boolean flag)
        {
            j = flag;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append((new StringBuilder()).append("StepCount : ").append(a).toString());
            stringbuilder.append((new StringBuilder()).append(", StepDistance : ").append(b).toString());
            stringbuilder.append((new StringBuilder()).append(", StepCalorie : ").append(c).toString());
            stringbuilder.append((new StringBuilder()).append(", SleepTime : ").append(e).toString());
            stringbuilder.append((new StringBuilder()).append(", SleepDeepTime : ").append(f).toString());
            return stringbuilder.toString();
        }

        private DynamicData()
        {
            j = true;
            l = new HashMap();
        }

        private class UserSleepModify
        {

            public int sleepEnd;
            public int sleepStart;

            public UserSleepModify()
            {
                sleepStart = 0x80000000;
                sleepEnd = 0x80000000;
            }
        }

    }

}
