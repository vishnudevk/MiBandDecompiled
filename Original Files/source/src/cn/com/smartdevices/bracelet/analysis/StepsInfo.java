// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.analysis;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StepsInfo
{

    public static String KEY_ACTIVITY_LIST = "actives";
    public static String KEY_CALORIES = "cal";
    public static String KEY_CONTINUS_ACTIVE_TIME = "conAct";
    public static String KEY_DISTANCE = "dis";
    public static String KEY_STEPS = "ttl";
    public static String KEY_STEP_INFO = "stp";
    public static String KEY_STEP_RUN_DISTANCE = "runDist";
    public static String KEY_STEP_RUN_TIME = "rn";
    public static String KEY_STEP_WALK_TIME = "wk";
    private static final String a = "StepsInfo";
    private SportDay b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ArrayList i;
    private int j;
    private int k;
    private int l;
    private ArrayList m;

    public StepsInfo()
    {
        b = null;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = new ArrayList();
        j = -1;
        k = 0;
        l = 0;
        m = new ArrayList();
        b = new SportDay();
    }

    public StepsInfo(SportDay sportday)
    {
        b = null;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = new ArrayList();
        j = -1;
        k = 0;
        l = 0;
        m = new ArrayList();
        b = sportday;
    }

    public int getActMinutes()
    {
        return k;
    }

    public ArrayList getActiveList()
    {
        return m;
    }

    public int getCalories()
    {
        return h;
    }

    public int getContinuesActive()
    {
        return l;
    }

    public int getDistance()
    {
        return f;
    }

    public int getRealtimeSteps()
    {
        return j;
    }

    public int getRunDistance()
    {
        return g;
    }

    public int getRunTimeCount()
    {
        return e;
    }

    public SportDay getSportDay()
    {
        return b;
    }

    public ArrayList getStageSteps()
    {
        return i;
    }

    public int getStepsCount()
    {
        return c;
    }

    public int getStepsTimeCount()
    {
        return d;
    }

    public JSONObject getSummaryJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(KEY_STEPS, c);
            jsonobject.put(KEY_DISTANCE, f);
            jsonobject.put(KEY_CALORIES, h);
            jsonobject.put(KEY_CONTINUS_ACTIVE_TIME, l);
            jsonobject.put(KEY_STEP_WALK_TIME, d);
            jsonobject.put(KEY_STEP_RUN_TIME, e);
            jsonobject.put(KEY_STEP_RUN_DISTANCE, g);
            Debug.i("StepsInfo", (new StringBuilder()).append("rundist = ").append(g).toString());
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public void setActMinutes(int i1)
    {
        k = i1;
    }

    public void setActiveList(ArrayList arraylist)
    {
        m.clear();
        m.addAll(arraylist);
    }

    public void setCalories(int i1)
    {
        h = i1;
    }

    public void setContinuesActive(int i1)
    {
        l = i1;
    }

    public void setDistance(int i1)
    {
        f = i1;
    }

    public void setRealtimeSteps(int i1)
    {
        j = i1;
    }

    public void setRunDistance(int i1)
    {
        g = i1;
    }

    public void setRunTimeCount(int i1)
    {
        e = i1;
    }

    public void setStageSteps(ArrayList arraylist)
    {
        i.clear();
        i.addAll(arraylist);
    }

    public void setStepsCount(int i1)
    {
        c = i1;
    }

    public void setStepsTimeCount(int i1)
    {
        d = i1;
    }

}
