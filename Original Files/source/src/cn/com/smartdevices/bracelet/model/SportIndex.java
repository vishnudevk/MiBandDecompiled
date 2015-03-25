// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import org.json.JSONException;
import org.json.JSONObject;

public class SportIndex
{

    public int lenght;
    public int startIndex;
    public int stopIndex;

    public SportIndex()
    {
        startIndex = 0;
        stopIndex = 0;
        lenght = 0;
    }

    public SportIndex(int i, int j)
    {
        startIndex = 0;
        stopIndex = 0;
        lenght = 0;
        startIndex = i;
        stopIndex = j;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("startIndex", 4 * startIndex);
            jsonobject.put("stopIndex", 4 * stopIndex);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public String toString()
    {
        return (new StringBuilder()).append("index:").append(startIndex).append("->").append(stopIndex).toString();
    }
}
