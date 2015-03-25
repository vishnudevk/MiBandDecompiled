// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareSportData
{

    public String date;
    public HashMap hourActivityData;
    public int stepCalorie;
    public int stepCount;
    public int stepDistance;

    public ShareSportData()
    {
        hourActivityData = new HashMap();
        stepCount = 0;
        stepDistance = 0;
        stepCalorie = 0;
        date = "";
    }

    public void fromString(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        date = jsonobject.getString("date");
        stepCalorie = jsonobject.getInt("stepCalorie");
        stepCount = jsonobject.getInt("stepCount");
        stepDistance = jsonobject.getInt("stepDistance");
        JSONArray jsonarray = jsonobject.getJSONArray("activities");
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject1 = jsonarray.getJSONObject(i);
            hourActivityData.put(Integer.valueOf(jsonobject1.getInt("hour")), Integer.valueOf(jsonobject1.getInt("activity")));
        }

    }

    public String toString()
    {
        JSONObject jsonobject = new JSONObject();
        JSONException jsonexception;
        JSONArray jsonarray;
        jsonobject.put("date", date);
        jsonobject.put("stepCount", stepCount);
        jsonobject.put("stepDistance", stepDistance);
        jsonobject.put("stepCalorie", stepCalorie);
        jsonarray = new JSONArray();
        hourActivityData.entrySet();
        JSONObject jsonobject1;
        for (Iterator iterator = hourActivityData.entrySet().iterator(); iterator.hasNext(); jsonarray.put(jsonobject1))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            jsonobject1 = new JSONObject();
            jsonobject1.put("hour", ((Integer)entry.getKey()).intValue());
            jsonobject1.put("activity", ((Integer)entry.getValue()).intValue());
        }

          goto _L1
_L3:
        return jsonobject.toString();
_L1:
        try
        {
            jsonobject.put("activities", jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception) { }
        if (true) goto _L3; else goto _L2
_L2:
    }
}
