// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import com.xiaomi.miui.analyticstracker.AnalyticsTracker;

public final class AnalyticsTrackerManager
{

    public static final String EVENT_DYNAMIC_DETAIL_PAGE = "EventDynamicDetailPage";
    public static final String EVENT_DYNAMIC_PAGE = "EventDynamicPage";
    public static final String EVENT_PERSON_PAGE = "EventPersonPage";
    public static final String EVENT_SETTING_PAGE = "EventSettingPage";
    public static final String EVENT_STATISTIC_PAGE = "EventStatisticPage";
    private static final String a = "AnalyticsTracker";
    private static final boolean b;
    private static AnalyticsTracker c;

    private AnalyticsTrackerManager()
    {
    }

    public static AnalyticsTracker endSession(Context context)
    {
        return null;
    }

    public static transient AnalyticsTracker endTimedEvent(String as[])
    {
        return null;
    }

    public static AnalyticsTracker getTracker()
    {
        if (c == null)
        {
            c = AnalyticsTracker.getInstance();
        }
        return c;
    }

    public static AnalyticsTracker startSession(Context context, long l)
    {
        return null;
    }

    public static AnalyticsTracker trackActive(long l)
    {
        return null;
    }

    public static AnalyticsTracker trackTimedEvent(String s)
    {
        return null;
    }

    public static transient AnalyticsTracker trackTimedEvent(String s, String as[])
    {
        return null;
    }
}
