// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import cn.com.smartdevices.bracelet.Utils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class GameStage
{

    private long startTime;
    private int status;
    private long stopTime;
    private String url;

    public GameStage()
    {
    }

    public static GameStage fromJson(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        GameStage gamestage = new GameStage();
        try
        {
            gamestage.startTime = jsonobject.getLong("stime");
            gamestage.stopTime = jsonobject.getLong("etime");
            gamestage.url = jsonobject.getString("url");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return gamestage;
        }
        return gamestage;
    }

    public static Date toDate(long l)
    {
        return new Date(1000L * l);
    }

    public long getStartTime()
    {
        return startTime;
    }

    public long getStopTime()
    {
        return stopTime;
    }

    public String getUrl()
    {
        String s = Utils.getPostUrl();
        return (new StringBuilder()).append(url).append(s).toString();
    }

    public boolean isActive(int i)
    {
        return (long)i >= startTime && (long)i <= stopTime;
    }

    public void setStartTime(long l)
    {
        startTime = l;
    }

    public void setStopTime(long l)
    {
        stopTime = l;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("GameStage: start=").append(toDate(startTime)).append(", stop=").append(toDate(stopTime)).append(", status =").append(status).append(" url = ").append(url).toString();
    }
}
