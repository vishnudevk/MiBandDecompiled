// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailChartViewOld, i, j, k, 
//            l

public class DynamicDetailFragmentOld extends Fragment
{

    public static Handler sRefreshHander;
    private DynamicDetailChartViewOld a;
    private GestureDetector b;
    private DataManager c;
    private SportDay d;
    private SportDay e;
    private SportDay f;
    private SportDay g;
    private SportDay h;

    public DynamicDetailFragmentOld()
    {
        c = DataManager.getInstance();
    }

    static DynamicDetailChartViewOld.DynamicDetailChartData a(DynamicDetailFragmentOld dynamicdetailfragmentold, DaySportData daysportdata)
    {
        return dynamicdetailfragmentold.a(daysportdata);
    }

    private DynamicDetailChartViewOld.DynamicDetailChartData a(DaySportData daysportdata)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        int i1;
        DynamicDetailChartViewOld.DynamicDetailChartStepData dynamicdetailchartstepdata;
        Iterator iterator;
        int j1;
        DynamicDetailChartViewOld.DynamicDetailChartSleepData dynamicdetailchartsleepdata;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        ArrayList arraylist2 = daysportdata.getAnalysisData();
        i1 = -1;
        dynamicdetailchartstepdata = null;
        iterator = arraylist2.iterator();
        j1 = -1;
        dynamicdetailchartsleepdata = null;
_L14:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        SportData sportdata = (SportData)iterator.next();
        k1 = sportdata.getSportMode();
        l1 = sportdata.getStep();
        i2 = sportdata.getTimeIndex();
        if (j1 == k1 && i2 != 1439) goto _L4; else goto _L3
_L3:
        DynamicDetailChartViewOld.DynamicDetailChartSleepData dynamicdetailchartsleepdata1;
        int j2;
        DynamicDetailChartViewOld.DynamicDetailChartStepData dynamicdetailchartstepdata1;
        int k2;
        int l2;
        if (dynamicdetailchartsleepdata != null)
        {
            dynamicdetailchartsleepdata.length = i2 - dynamicdetailchartsleepdata.index;
            dynamicdetailchartsleepdata1 = null;
        } else
        {
            dynamicdetailchartsleepdata1 = dynamicdetailchartsleepdata;
        }
        if (k1 != 4 && k1 != 5 && k1 != 7) goto _L6; else goto _L5
_L5:
        dynamicdetailchartsleepdata1 = new DynamicDetailChartViewOld.DynamicDetailChartSleepData();
        arraylist.add(dynamicdetailchartsleepdata1);
        dynamicdetailchartsleepdata1.index = i2;
        k1;
        JVM INSTR tableswitch 4 7: default 196
    //                   4 305
    //                   5 318
    //                   6 196
    //                   7 331;
           goto _L6 _L7 _L8 _L6 _L9
_L6:
        j2 = k1;
_L15:
        if (k1 == 126 || k1 == 127 || k1 == 4 || k1 == 5 || k1 == 7 || l1 <= 0) goto _L11; else goto _L10
_L10:
        l2 = i2 / 60;
        if (l2 == i1) goto _L13; else goto _L12
_L12:
        dynamicdetailchartstepdata1 = new DynamicDetailChartViewOld.DynamicDetailChartStepData();
        arraylist1.add(dynamicdetailchartstepdata1);
        dynamicdetailchartstepdata1.index = l2;
        dynamicdetailchartstepdata1.step = l1;
        k2 = l2;
_L16:
        dynamicdetailchartsleepdata = dynamicdetailchartsleepdata1;
        i1 = k2;
        dynamicdetailchartstepdata = dynamicdetailchartstepdata1;
        j1 = j2;
          goto _L14
_L7:
        dynamicdetailchartsleepdata1.mode = 2;
        j2 = k1;
          goto _L15
_L8:
        dynamicdetailchartsleepdata1.mode = 3;
        j2 = k1;
          goto _L15
_L9:
        dynamicdetailchartsleepdata1.mode = 1;
        j2 = k1;
          goto _L15
_L13:
        dynamicdetailchartstepdata.step = l1 + dynamicdetailchartstepdata.step;
_L11:
        dynamicdetailchartstepdata1 = dynamicdetailchartstepdata;
        k2 = i1;
          goto _L16
_L2:
        DynamicDetailChartViewOld.DynamicDetailChartData dynamicdetailchartdata = new DynamicDetailChartViewOld.DynamicDetailChartData();
        dynamicdetailchartdata.sleepData = arraylist;
        dynamicdetailchartdata.stepData = arraylist1;
        return dynamicdetailchartdata;
_L4:
        j2 = j1;
        dynamicdetailchartsleepdata1 = dynamicdetailchartsleepdata;
          goto _L15
    }

    static SportDay a(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.g;
    }

    static SportDay a(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        dynamicdetailfragmentold.e = sportday;
        return sportday;
    }

    private String a(int i1)
    {
        int j1 = i1 / 60;
        int k1 = i1 % 60;
        if (j1 == 0 && k1 == 0)
        {
            return "00:00";
        }
        if (k1 < 10)
        {
            return (new StringBuilder()).append(j1).append(":0").append(k1).toString();
        } else
        {
            return (new StringBuilder()).append(j1).append(":").append(k1).toString();
        }
    }

    private String a(SportDay sportday)
    {
        return (new StringBuilder()).append(1 + sportday.mon).append(".").append(sportday.day).toString();
    }

    static SportDay b(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.e;
    }

    static String b(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        return dynamicdetailfragmentold.a(sportday);
    }

    static SportDay c(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.h;
    }

    static SportDay c(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        dynamicdetailfragmentold.d = sportday;
        return sportday;
    }

    static GestureDetector d(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.b;
    }

    static SportDay d(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        dynamicdetailfragmentold.f = sportday;
        return sportday;
    }

    static DataManager e(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.c;
    }

    static SportDay e(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        dynamicdetailfragmentold.g = sportday;
        return sportday;
    }

    static SportDay f(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.d;
    }

    static SportDay f(DynamicDetailFragmentOld dynamicdetailfragmentold, SportDay sportday)
    {
        dynamicdetailfragmentold.h = sportday;
        return sportday;
    }

    static DynamicDetailChartViewOld g(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.a;
    }

    static SportDay h(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        return dynamicdetailfragmentold.f;
    }

    public static String valueToTime(int i1)
    {
        int j1 = i1 / 60;
        int k1 = i1 % 60;
        if (j1 == 0 && k1 == 0)
        {
            return "00:00";
        }
        if (k1 < 10)
        {
            return (new StringBuilder()).append(j1).append(":0").append(k1).toString();
        } else
        {
            return (new StringBuilder()).append(j1).append(":").append(k1).toString();
        }
    }

    protected String formatTime(int i1, int j1)
    {
        if (i1 == 0 && j1 == 0)
        {
            return "00:00";
        }
        if (j1 < 10)
        {
            return (new StringBuilder()).append(i1).append(":0").append(j1).toString();
        } else
        {
            return (new StringBuilder()).append(i1).append(":").append(j1).toString();
        }
    }

    protected String[] formatTimeHourMin(int i1)
    {
        int j1 = i1 / 60;
        int k1 = i1 % 60;
        String as[] = new String[2];
        if (j1 > 0)
        {
            as[0] = String.valueOf(j1);
        }
        as[1] = String.valueOf(k1);
        return as;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030020, viewgroup, false);
        a = (DynamicDetailChartViewOld)view.findViewById(0x7f0a00a7);
        b = new GestureDetector(getActivity(), new i(this));
        a.setOnTouchListener(new j(this));
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(new k(this));
        a.setDataLoader(asyncchartdataloader);
        a.setScrollable(true);
        sRefreshHander = new l(this);
        sRefreshHander.sendEmptyMessage(0);
        return view;
    }
}
