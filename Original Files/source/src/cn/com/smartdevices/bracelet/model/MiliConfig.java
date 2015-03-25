// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import java.util.Calendar;

public class MiliConfig
{

    public static final String BLUE = "BLUE";
    public static final String GREEN = "GREEN";
    public static final String LEFT_HAND = "LEFT_HAND";
    public static final String ORANGE = "ORANGE";
    public static final String RED = "RED";
    public static final String RIGHT_HAND = "RIGHT_HAND";
    private static final String TAG = "MiliConfig";
    public Calendar firstUseDate;
    public int goalStepsCount;
    public int inComingCallNotifyTime;
    public String lightColor;
    public String wearHand;

    public MiliConfig()
    {
        lightColor = "BLUE";
        wearHand = "LEFT_HAND";
        goalStepsCount = -1;
        inComingCallNotifyTime = 276;
    }

    public static MiliConfig fromJsonStr(String s)
    {
        MiliConfig miliconfig = (MiliConfig)Utils.getGson().fromJson(s, cn/com/smartdevices/bracelet/model/MiliConfig);
        if (miliconfig == null)
        {
            miliconfig = new MiliConfig();
        }
        return miliconfig;
    }

    public boolean isValid()
    {
        boolean flag;
        if (lightColor != null && !lightColor.equals("") && wearHand != null && !wearHand.equals("") && goalStepsCount > 0 && (inComingCallNotifyTime == -1 || inComingCallNotifyTime >= 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.i("MiliConfig", (new StringBuilder()).append("isValid=").append(flag).append(", ").append(this).toString());
        return flag;
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
}
