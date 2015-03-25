// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import com.google.gson.Gson;

public class ReportData
{

    public int calories;
    public int continueDays;
    public int distance;
    public int maxContinueDays;
    public int maxDateStep;
    public String maxDateStr;
    public String picture_url;
    public int runDistance;
    public int steps;
    public String timeFrom;
    public String timeTo;
    public int todayComplete;
    public String type;

    public ReportData()
    {
        type = "SHARE_TYPE_LAST_WEEK";
        steps = 0;
        distance = 0;
        calories = 0;
        runDistance = 0;
        timeFrom = "";
        timeTo = "";
        maxDateStr = "";
        maxDateStep = 0;
        continueDays = 0;
        maxContinueDays = 0;
        todayComplete = 0;
    }

    public static ReportData fromJsonStr(String s)
    {
        return (ReportData)Utils.getGson().fromJson(s, cn/com/smartdevices/bracelet/model/ReportData);
    }

    public int getCalories()
    {
        return calories;
    }

    public int getContinueDays()
    {
        return continueDays;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getMaxContinueDays()
    {
        return maxContinueDays;
    }

    public int getMaxDateStep()
    {
        return maxDateStep;
    }

    public String getMaxDateStr()
    {
        return maxDateStr;
    }

    public int getRunDistance()
    {
        return runDistance;
    }

    public int getSteps()
    {
        return steps;
    }

    public String getTimeFrom()
    {
        return timeFrom;
    }

    public String getTimeTo()
    {
        return timeTo;
    }

    public int getTodayComplete()
    {
        return todayComplete;
    }

    public String getType()
    {
        return type;
    }

    public boolean isValid()
    {
        return steps != 0;
    }

    public void setCalories(int i)
    {
        calories = i;
    }

    public void setContinueDays(int i)
    {
        continueDays = i;
    }

    public void setDistance(int i)
    {
        distance = i;
    }

    public void setMaxContinueDays(int i)
    {
        maxContinueDays = i;
    }

    public void setMaxDateStep(int i)
    {
        maxDateStep = i;
    }

    public void setMaxDateStr(String s)
    {
        maxDateStr = s;
    }

    public void setSteps(int i)
    {
        steps = i;
    }

    public void setStepsInfo(StepsInfo stepsinfo)
    {
        steps = stepsinfo.getStepsCount();
        distance = stepsinfo.getDistance();
        calories = stepsinfo.getCalories();
    }

    public void setTimeFrom(String s)
    {
        timeFrom = s;
    }

    public void setTimeTo(String s)
    {
        timeTo = s;
    }

    public void setTodayComplete(int i)
    {
        todayComplete = i;
    }

    public void setType(String s)
    {
        type = s;
    }

    public String toJsonStr()
    {
        return Utils.getGson().toJson(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("report data:\nsteps:").append(steps).append("\n").append("distance:").append(distance).append("\n").append("calories:").append(calories).append("\n").append("timeFrom:").append(timeFrom).append("\n").append("timeTo:").append(timeTo).append("\n").append("maxDateStr:").append(maxDateStr).append("\n").append("maxDateStep:").append(maxDateStep).append("\n").append("continueDays:").append(continueDays).append("\n").append("maxContinueDays:").append(maxContinueDays).append("\n").append("todayComplete:").append(todayComplete).append("\n").toString();
    }
}
