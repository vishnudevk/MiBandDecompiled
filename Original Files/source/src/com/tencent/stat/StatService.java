// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.Env;
import com.tencent.stat.common.SdkProtection;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.User;
import com.tencent.stat.event.AdditionEvent;
import com.tencent.stat.event.CustomEvent;
import com.tencent.stat.event.ErrorEvent;
import com.tencent.stat.event.MonitorStatEvent;
import com.tencent.stat.event.PageView;
import com.tencent.stat.event.SessionEnv;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat:
//            StatConfig, StatStore, a, c, 
//            f, StatReportStrategy, h, StatAppMonitor, 
//            MtaSDkException

public class StatService
{

    private static Handler a;
    private static Map b = new WeakHashMap();
    private static volatile long c = 0L;
    private static volatile long d = 0L;
    private static volatile int e = 0;
    private static volatile String f = "";
    private static volatile String g = "";
    private static Map h = new WeakHashMap();
    private static StatLogger i = StatCommonHelper.getLogger();
    private static Thread.UncaughtExceptionHandler j = null;
    private static boolean k = true;

    public StatService()
    {
    }

    static int a(Context context, boolean flag)
    {
        int l = 1;
        long l1 = System.currentTimeMillis();
        int i1;
        if (flag && l1 - c >= (long)StatConfig.getSessionTimoutMillis())
        {
            i1 = l;
        } else
        {
            i1 = 0;
        }
        c = l1;
        if (d == 0L)
        {
            d = StatCommonHelper.getTomorrowStartMilliseconds();
        }
        if (l1 >= d)
        {
            d = StatCommonHelper.getTomorrowStartMilliseconds();
            if (StatStore.getInstance(context).getUser(context).getType() != l)
            {
                StatStore.getInstance(context).getUser(context).setType(l);
            }
            StatConfig.b(0);
            i1 = l;
        }
        if (!k)
        {
            l = i1;
        }
        if (l != 0)
        {
            if (StatConfig.e() < StatConfig.getMaxDaySessionNumbers())
            {
                c(context);
            } else
            {
                i.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (k)
        {
            SdkProtection.endCheck(context);
            k = false;
        }
        return e;
    }

    static JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            JSONObject jsonobject1 = new JSONObject();
            if (StatConfig.b.d != 0)
            {
                jsonobject1.put("v", StatConfig.b.d);
            }
            jsonobject.put(Integer.toString(StatConfig.b.a), jsonobject1);
            JSONObject jsonobject2 = new JSONObject();
            if (StatConfig.a.d != 0)
            {
                jsonobject2.put("v", StatConfig.a.d);
            }
            jsonobject.put(Integer.toString(StatConfig.a.a), jsonobject2);
        }
        catch (JSONException jsonexception)
        {
            i.e(jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    static void a(Context context)
    {
        while (context == null || a != null || !b(context)) 
        {
            return;
        }
        if (!SdkProtection.beginCheck(context))
        {
            i.error("ooh, Compatibility problem was found in this device!");
            i.error("If you are on debug mode, please delete apk and try again.");
            StatConfig.setEnableStatService(false);
            return;
        }
        StatStore.getInstance(context);
        HandlerThread handlerthread = new HandlerThread("StatService");
        handlerthread.start();
        com.tencent.stat.c.a(context);
        a = new Handler(handlerthread.getLooper());
        j = Thread.getDefaultUncaughtExceptionHandler();
        if (StatConfig.isAutoExceptionCaught())
        {
            Thread.setDefaultUncaughtExceptionHandler(new f(context.getApplicationContext()));
        } else
        {
            i.warn("MTA SDK AutoExceptionCaught is disable");
        }
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH && StatCommonHelper.isNetworkAvailable(context))
        {
            StatStore.getInstance(context).a(-1);
        }
        i.d("Init MTA StatService success.");
    }

    static void a(Context context, Throwable throwable)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            try
            {
                i.error("The Context of StatService.reportSdkSelfException() can not be null!");
                return;
            }
            catch (Throwable throwable1)
            {
                i.e((new StringBuilder()).append("reportSdkSelfException error: ").append(throwable1).toString());
            }
            return;
        }
        ErrorEvent errorevent = new ErrorEvent(context, a(context, false), 99, throwable);
        if (d(context) != null)
        {
            d(context).post(new h(errorevent));
        }
        return;
    }

    static void a(Context context, Map map)
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.sendAdditionEvent() can not be null!");
                return;
            }
            try
            {
                AdditionEvent additionevent = new AdditionEvent(context, a(context, false), map);
                if (d(context) != null)
                {
                    d(context).post(new h(additionevent));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
                return;
            }
        }
    }

    static boolean a(String s)
    {
        return s == null || s.length() == 0;
    }

    static StatLogger b()
    {
        return i;
    }

    static boolean b(Context context)
    {
        long l = StatPreferences.getLong(context, StatConfig.c, 0L);
        if (StatCommonHelper.getSDKLongVersion("1.0.0") <= l)
        {
            StatConfig.setEnableStatService(false);
            return false;
        } else
        {
            return true;
        }
    }

    static Thread.UncaughtExceptionHandler c()
    {
        return j;
    }

    static void c(Context context)
    {
        if (d(context) != null)
        {
            i.d("start new session.");
            e = StatCommonHelper.getNextSessionID();
            StatConfig.a(0);
            StatConfig.d();
            d(context).post(new h(new SessionEnv(context, e, a())));
        }
    }

    public static void commitEvents(Context context, int l)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            i.error("The Context of StatService.commitEvents() can not be null!");
            return;
        }
        if (l < -1 || l == 0)
        {
            i.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            return;
        }
        try
        {
            StatStore.getInstance(context).a(l);
            return;
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
        }
    }

    private static Handler d(Context context)
    {
        a(context);
        return a;
    }

    public static void onPause(Context context)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            i.error("The Context of StatService.onPause() can not be null!");
            return;
        }
        String s;
        Long long1;
        s = StatCommonHelper.getActivityName(context);
        long1 = (Long)h.remove(s);
        if (long1 != null)
        {
            try
            {
                Long long2 = Long.valueOf((System.currentTimeMillis() - long1.longValue()) / 1000L);
                if (long2.longValue() == 0L)
                {
                    long2 = Long.valueOf(1L);
                }
                if (g.equals(s))
                {
                    g = "-";
                }
                PageView pageview = new PageView(context, g, a(context, false), long2);
                if (!pageview.getPageId().equals(f))
                {
                    i.warn("Invalid invocation since previous onResume on diff page.");
                }
                if (d(context) != null)
                {
                    d(context).post(new h(pageview));
                }
                g = s;
                return;
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
            }
            return;
        }
        i.e((new StringBuilder()).append("Starttime for PageID:").append(s).append(" not found, lost onResume()?").toString());
        return;
    }

    public static void onResume(Context context)
    {
        if (StatConfig.isEnableStatService()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (context == null)
        {
            i.error("The Context of StatService.onResume() can not be null!");
            return;
        }
        try
        {
            if (h.size() >= StatConfig.getMaxParallelTimmingEvents())
            {
                i.error((new StringBuilder()).append("The number of page events exceeds the maximum value ").append(Integer.toString(StatConfig.getMaxParallelTimmingEvents())).toString());
                return;
            }
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
            return;
        }
        f = StatCommonHelper.getActivityName(context);
        if (f == null) goto _L1; else goto _L3
_L3:
        if (h.containsKey(f))
        {
            i.e((new StringBuilder()).append("Duplicate PageID : ").append(f).append(", onResume() repeated?").toString());
            return;
        }
        h.put(f, Long.valueOf(System.currentTimeMillis()));
        a(context, true);
        return;
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statappmonitor)
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.reportAppMonitorStat() can not be null!");
                return;
            }
            if (statappmonitor == null)
            {
                i.error("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
                return;
            }
            if (statappmonitor.getInterfaceName() == null)
            {
                i.error("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
                return;
            }
            try
            {
                MonitorStatEvent monitorstatevent = new MonitorStatEvent(context, a(context, false), statappmonitor);
                if (d(context) != null)
                {
                    d(context).post(new h(monitorstatevent));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
                return;
            }
        }
    }

    public static void reportError(Context context, String s)
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.reportError() can not be null!");
                return;
            }
            if (a(s))
            {
                i.error("Error message in StatService.reportError() is empty.");
                return;
            }
            try
            {
                ErrorEvent errorevent = new ErrorEvent(context, a(context, false), s);
                if (d(context) != null)
                {
                    d(context).post(new h(errorevent));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
                return;
            }
        }
    }

    public static void reportException(Context context, Throwable throwable)
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.reportException() can not be null!");
                return;
            }
            if (throwable == null)
            {
                i.error("The Throwable error message of StatService.reportException() can not be null!");
                return;
            }
            ErrorEvent errorevent = new ErrorEvent(context, a(context, false), 1, throwable);
            if (d(context) != null)
            {
                d(context).post(new h(errorevent));
                return;
            }
        }
    }

    public static void reportQQ(Context context, String s)
    {
        if (s == null)
        {
            s = "";
        }
        if (!StatConfig.d.equals(s))
        {
            StatConfig.d = s;
            a(context, ((Map) (null)));
        }
    }

    public static void setEnvAttributes(Context context, Map map)
    {
        if (map == null || map.size() > 512)
        {
            i.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try
        {
            Env.appendEnvAttr(context, map);
            return;
        }
        catch (JSONException jsonexception)
        {
            i.e(jsonexception);
        }
    }

    public static void startNewSession(Context context)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            i.error("The Context of StatService.startNewSession() can not be null!");
            return;
        }
        try
        {
            stopSession();
            a(context, true);
            return;
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
        }
    }

    public static boolean startStatService(Context context, String s, String s1)
    {
        if (!StatConfig.isEnableStatService())
        {
            i.error("MTA StatService is disable.");
            return false;
        }
        i.d((new StringBuilder()).append("MTA SDK version, current: ").append("1.0.0").append(" ,required: ").append(s1).toString());
        if (context == null || s1 == null)
        {
            i.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        }
        if (StatCommonHelper.getSDKLongVersion("1.0.0") < StatCommonHelper.getSDKLongVersion(s1))
        {
            String s3 = (new StringBuilder()).append("MTA SDK version conflicted, current: ").append("1.0.0").append(",required: ").append(s1).toString();
            String s4 = (new StringBuilder()).append(s3).append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/").toString();
            i.error(s4);
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException(s4);
        }
        String s2;
        try
        {
            s2 = StatConfig.getInstallChannel(context);
        }
        catch (Throwable throwable)
        {
            i.e(throwable);
            return false;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        if (s2.length() != 0)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        StatConfig.setInstallChannel("-");
        StatConfig.setAppKey(context, s);
        d(context);
        return true;
    }

    public static void stopSession()
    {
        c = 0L;
    }

    public static transient void trackCustomBeginEvent(Context context, String s, String as[])
    {
        com.tencent.stat.event.CustomEvent.Key key;
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
            return;
        }
        if (a(s))
        {
            i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
            return;
        }
        try
        {
            CustomEvent customevent = new CustomEvent(context, a(context, false), s);
            customevent.setArgs(as);
            key = customevent.getKey();
            if (b.containsKey(key))
            {
                i.error((new StringBuilder()).append("Duplicate CustomEvent key: ").append(key.toString()).append(", trackCustomBeginEvent() repeated?").toString());
                return;
            }
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
            return;
        }
        if (b.size() <= StatConfig.getMaxParallelTimmingEvents())
        {
            b.put(key, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        i.error((new StringBuilder()).append("The number of timedEvent exceeds the maximum value ").append(Integer.toString(StatConfig.getMaxParallelTimmingEvents())).toString());
        return;
    }

    public static void trackCustomBeginKVEvent(Context context, String s, Properties properties)
    {
        com.tencent.stat.event.CustomEvent.Key key;
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        if (context == null)
        {
            i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
            return;
        }
        if (a(s))
        {
            i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
            return;
        }
        try
        {
            CustomEvent customevent = new CustomEvent(context, a(context, false), s);
            customevent.setProperties(properties);
            key = customevent.getKey();
            if (b.containsKey(key))
            {
                i.error((new StringBuilder()).append("Duplicate CustomEvent key: ").append(key.toString()).append(", trackCustomBeginKVEvent() repeated?").toString());
                return;
            }
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
            return;
        }
        if (b.size() <= StatConfig.getMaxParallelTimmingEvents())
        {
            b.put(key, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        i.error((new StringBuilder()).append("The number of timedEvent exceeds the maximum value ").append(Integer.toString(StatConfig.getMaxParallelTimmingEvents())).toString());
        return;
    }

    public static transient void trackCustomEndEvent(Context context, String s, String as[])
    {
        if (StatConfig.isEnableStatService()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CustomEvent customevent;
        Long long2;
        long l;
        if (context == null)
        {
            i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
            return;
        }
        if (a(s))
        {
            i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            return;
        }
        Long long1;
        try
        {
            customevent = new CustomEvent(context, a(context, false), s);
            customevent.setArgs(as);
            long1 = (Long)b.remove(customevent.getKey());
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
            return;
        }
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        long2 = Long.valueOf((System.currentTimeMillis() - long1.longValue()) / 1000L);
        if (long2.longValue() != 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        l = 1L;
_L4:
        customevent.setDuration(Long.valueOf(l).longValue());
        if (d(context) == null) goto _L1; else goto _L3
_L3:
        d(context).post(new h(customevent));
        return;
        l = long2.longValue();
          goto _L4
        i.error((new StringBuilder()).append("No start time found for custom event: ").append(customevent.getKey().toString()).append(", lost trackCustomBeginEvent()?").toString());
        return;
    }

    public static void trackCustomEndKVEvent(Context context, String s, Properties properties)
    {
        if (StatConfig.isEnableStatService()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CustomEvent customevent;
        Long long2;
        long l;
        if (context == null)
        {
            i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
            return;
        }
        if (a(s))
        {
            i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            return;
        }
        Long long1;
        try
        {
            customevent = new CustomEvent(context, a(context, false), s);
            customevent.setProperties(properties);
            long1 = (Long)b.remove(customevent.getKey());
        }
        catch (Throwable throwable)
        {
            a(context, throwable);
            return;
        }
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        long2 = Long.valueOf((System.currentTimeMillis() - long1.longValue()) / 1000L);
        if (long2.longValue() != 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        l = 1L;
_L4:
        customevent.setDuration(Long.valueOf(l).longValue());
        if (d(context) == null) goto _L1; else goto _L3
_L3:
        d(context).post(new h(customevent));
        return;
        l = long2.longValue();
          goto _L4
        i.error((new StringBuilder()).append("No start time found for custom event: ").append(customevent.getKey().toString()).append(", lost trackCustomBeginKVEvent()?").toString());
        return;
    }

    public static transient void trackCustomEvent(Context context, String s, String as[])
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            if (a(s))
            {
                i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            try
            {
                CustomEvent customevent = new CustomEvent(context, a(context, false), s);
                customevent.setArgs(as);
                if (d(context) != null)
                {
                    d(context).post(new h(customevent));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
                return;
            }
        }
    }

    public static void trackCustomKVEvent(Context context, String s, Properties properties)
    {
        if (StatConfig.isEnableStatService())
        {
            if (context == null)
            {
                i.error("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            if (a(s))
            {
                i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            try
            {
                CustomEvent customevent = new CustomEvent(context, a(context, false), s);
                customevent.setProperties(properties);
                if (d(context) != null)
                {
                    d(context).post(new h(customevent));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                a(context, throwable);
                return;
            }
        }
    }

}
