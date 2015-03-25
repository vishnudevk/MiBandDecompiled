// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;

public class UserTotalSportData
{

    public String averageSteps;
    public String calories;
    public String distance;
    public int iAverageSteps;
    public int iCalories;
    public int iDistance;
    public int iPoints;
    public int iSteps;
    public int iTotalwearingdays;
    public String points;
    public String steps;
    public String totalwearingdays;

    public UserTotalSportData()
    {
        distance = "";
        averageSteps = "";
        totalwearingdays = "";
        calories = "";
        steps = "";
        points = "";
        iDistance = 0;
        iAverageSteps = 0;
        iTotalwearingdays = 0;
        iCalories = 0;
        iSteps = 0;
        iPoints = 0;
    }

    public static UserTotalSportData fromJsonStr(String s)
    {
        UserTotalSportData usertotalsportdata = (UserTotalSportData)Utils.getGson().fromJson(s, cn/com/smartdevices/bracelet/model/UserTotalSportData);
        if (usertotalsportdata == null)
        {
            usertotalsportdata = new UserTotalSportData();
        }
        return usertotalsportdata;
    }

    public boolean isValid()
    {
        return !"".equals(averageSteps) && !"".equals(distance) && !"".equals(totalwearingdays);
    }

    public String toString()
    {
        String s = Utils.getGson().toJson(this);
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    public void translate()
    {
        distance = (new StringBuilder()).append("").append(iDistance).toString();
        averageSteps = (new StringBuilder()).append("").append(iAverageSteps).toString();
        totalwearingdays = (new StringBuilder()).append("").append(iTotalwearingdays).toString();
        calories = (new StringBuilder()).append("").append(iCalories).toString();
        steps = (new StringBuilder()).append("").append(iSteps).toString();
        points = (new StringBuilder()).append("").append(iPoints).toString();
    }
}
