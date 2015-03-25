// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.model.game:
//            GameStage

public class GameBriefInfo
{

    private static final int DEFAULT_GOAL = 10000;
    private static final String TAG = "GameBriefInfo";
    private int bonus;
    private int bonusOpenTime;
    private GameStage bonusStage;
    private String defaultUrl;
    private int goal;
    private int id;
    private int like;
    private String name;
    private GameStage playingStage;
    private GameStage registerStage;
    private boolean registered;
    private int serverTime;
    private int startTime;
    private int stopTime;

    public GameBriefInfo()
    {
    }

    public int getBonus()
    {
        return bonus;
    }

    public int getBonusOpenTime()
    {
        return bonusOpenTime;
    }

    public GameStage getBonusStage()
    {
        return bonusStage;
    }

    public String getBonusUrl()
    {
        return bonusStage.getUrl();
    }

    public String getDefaultUrl()
    {
        return (new StringBuilder()).append(defaultUrl).append(Utils.getPostUrl()).toString();
    }

    public String getGamePlayingUrl()
    {
        return playingStage.getUrl();
    }

    public int getGoal()
    {
        return goal;
    }

    public int getId()
    {
        return id;
    }

    public int getLike()
    {
        return like;
    }

    public GameStage getPlayingStage()
    {
        return playingStage;
    }

    public long getRegisterEndTimeStamp()
    {
        return registerStage.getStopTime();
    }

    public String getRegisterUrl()
    {
        Debug.i("GameBriefInfo", (new StringBuilder()).append("getRegisterUrl = ").append(registerStage.getUrl()).toString());
        return registerStage.getUrl();
    }

    public long getServerTime()
    {
        if (serverTime <= 0)
        {
            serverTime = (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
        }
        return (long)serverTime;
    }

    public boolean isGameStart()
    {
        return serverTime >= startTime && serverTime <= stopTime;
    }

    public boolean isInBonusStage()
    {
        if (bonusStage != null)
        {
            return bonusStage.isActive(serverTime);
        } else
        {
            return false;
        }
    }

    public boolean isInGamingStage()
    {
        if (playingStage != null)
        {
            return playingStage.isActive(serverTime);
        } else
        {
            return false;
        }
    }

    public boolean isInRegisterStage()
    {
        if (registerStage != null)
        {
            return registerStage.isActive(serverTime);
        } else
        {
            return false;
        }
    }

    public boolean isRegistered()
    {
        return registered;
    }

    public void setBonus(int i)
    {
        bonus = i;
    }

    public void setBonusOpenTime(int i)
    {
        bonusOpenTime = i;
    }

    public void setBonusStage(GameStage gamestage)
    {
        bonusStage = gamestage;
    }

    public void setDefaultUrl(String s)
    {
        defaultUrl = s;
    }

    public void setGoal(int i)
    {
        if (i >= 0)
        {
            goal = i;
            return;
        } else
        {
            goal = 10000;
            return;
        }
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setLike(int i)
    {
        like = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPlayingStage(GameStage gamestage)
    {
        playingStage = gamestage;
    }

    public void setRegisterStage(GameStage gamestage)
    {
        registerStage = gamestage;
    }

    public void setRegistered(boolean flag)
    {
        Debug.i("GameBriefInfo", (new StringBuilder()).append("Registered = ").append(flag).toString());
        registered = flag;
    }

    public void setServerTime(int i)
    {
        serverTime = i;
    }

    public void setStartTime(int i)
    {
        startTime = i;
    }

    public void setStopTime(int i)
    {
        stopTime = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("\n\nname = ").append(name).append(", id = ").append(id).append(", startTime =").append(GameStage.toDate(startTime)).append("\n Register stage ").append(registerStage).append("\n Playing stage  ").append(playingStage).append("\n Bonus Stage ").append(bonusStage).append("\n goal = ").append(goal).append("\n bonus = ").append(bonus).append("\n bonusOpenTime = ").append(GameStage.toDate(bonusOpenTime)).append("\n serverTime =").append(GameStage.toDate(serverTime)).toString();
    }
}
