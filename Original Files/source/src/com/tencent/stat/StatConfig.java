// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat:
//            a, StatReportStrategy, c, StatStore, 
//            StatService

public class StatConfig
{

    private static int A = 4096;
    static a a = new a(2);
    static a b = new a(1);
    static String c = "__HIBERNATE__";
    static String d = "";
    private static StatLogger e = StatCommonHelper.getLogger();
    private static StatReportStrategy f;
    private static boolean g = true;
    private static int h = 30000;
    private static int i = 1024;
    public static boolean isAutoExceptionCaught = true;
    private static int j = 30;
    private static int k = 3;
    private static int l = 30;
    private static String m = null;
    private static String n;
    private static String o;
    private static int p = 1440;
    private static int q = 1024;
    private static boolean r = true;
    private static long s = 0L;
    private static long t = 0x493e0L;
    private static String u = "http://pingma.qq.com:80/mstat/report";
    private static int v = 0;
    private static volatile int w = 0;
    private static int x = 20;
    private static int y = 0;
    private static boolean z = false;

    public StatConfig()
    {
    }

    static int a()
    {
        return j;
    }

    static String a(Context context)
    {
        return StatCommonHelper.decode(StatPreferences.getString(context, "_mta_ky_tag_", null));
    }

    static void a(int i1)
    {
        com/tencent/stat/StatConfig;
        JVM INSTR monitorenter ;
        w = i1;
        com/tencent/stat/StatConfig;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(Context context, String s1)
    {
        if (s1 != null)
        {
            StatPreferences.putString(context, "_mta_ky_tag_", StatCommonHelper.encode(s1));
        }
    }

    static void a(a a1)
    {
        if (a1.a == b.a)
        {
            b = a1;
            b(b.b);
        } else
        if (a1.a == a.a)
        {
            a = a1;
            return;
        }
    }

    static void a(a a1, JSONObject jsonobject)
    {
        Iterator iterator = jsonobject.keys();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (!s1.equalsIgnoreCase("v")) goto _L4; else goto _L3
_L3:
        a1.d = jsonobject.getInt(s1);
          goto _L5
        JSONException jsonexception;
        jsonexception;
        e.e(jsonexception);
_L10:
        return;
_L4:
        if (!s1.equalsIgnoreCase("c")) goto _L7; else goto _L6
_L6:
        String s2 = jsonobject.getString("c");
        if (s2.length() > 0)
        {
            a1.b = new JSONObject(s2);
        }
          goto _L5
        Throwable throwable;
        throwable;
        e.e(throwable);
        return;
_L7:
        if (!s1.equalsIgnoreCase("m")) goto _L5; else goto _L8
_L8:
        a1.c = jsonobject.getString("m");
          goto _L5
_L2:
        StatStore statstore = StatStore.getInstance(com.tencent.stat.c.a());
        if (statstore == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        statstore.a(a1);
        if (a1.a != b.a) goto _L10; else goto _L9
_L9:
        b(a1.b);
        c(a1.b);
        return;
          goto _L5
    }

    static void a(JSONObject jsonobject)
    {
        Iterator iterator = jsonobject.keys();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (!s1.equalsIgnoreCase(Integer.toString(b.a))) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject2 = jsonobject.getJSONObject(s1);
        a(b, jsonobject2);
          goto _L5
        JSONException jsonexception;
        jsonexception;
        e.e(jsonexception);
_L2:
        return;
_L4:
        if (!s1.equalsIgnoreCase(Integer.toString(a.a)))
        {
            continue; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject(s1);
        a(a, jsonobject1);
          goto _L5
        if (!s1.equalsIgnoreCase("rs")) goto _L2; else goto _L6
_L6:
        StatReportStrategy statreportstrategy = StatReportStrategy.getStatReportStrategy(jsonobject.getInt(s1));
        if (statreportstrategy == null) goto _L5; else goto _L7
_L7:
        f = statreportstrategy;
        e.d((new StringBuilder()).append("Change to ReportStrategy:").append(statreportstrategy.name()).toString());
          goto _L5
    }

    static boolean a(int i1, int j1, int k1)
    {
        return i1 >= j1 && i1 <= k1;
    }

    private static boolean a(String s1)
    {
        if (s1 != null)
        {
            if (n == null)
            {
                n = s1;
                return true;
            }
            if (!n.contains(s1))
            {
                n = (new StringBuilder()).append(n).append("|").append(s1).toString();
                return true;
            }
        }
        return false;
    }

    static HttpHost b()
    {
        if (m != null && m.length() > 0)
        {
            String s1 = m;
            String as[] = s1.split(":");
            int i1 = 80;
            if (as.length == 2)
            {
                s1 = as[0];
                i1 = Integer.parseInt(as[1]);
            }
            return new HttpHost(s1, i1);
        } else
        {
            return null;
        }
    }

    static void b(int i1)
    {
        if (i1 < 0)
        {
            return;
        } else
        {
            y = i1;
            return;
        }
    }

    static void b(JSONObject jsonobject)
    {
        StatReportStrategy statreportstrategy;
        try
        {
            statreportstrategy = StatReportStrategy.getStatReportStrategy(jsonobject.getInt("rs"));
        }
        catch (JSONException jsonexception)
        {
            e.d("rs not found.");
            return;
        }
        if (statreportstrategy == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        setStatSendStrategy(statreportstrategy);
        e.debug((new StringBuilder()).append("Change to ReportStrategy: ").append(statreportstrategy.name()).toString());
    }

    static void c()
    {
        com/tencent/stat/StatConfig;
        JVM INSTR monitorenter ;
        w = 1 + w;
        com/tencent/stat/StatConfig;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void c(JSONObject jsonobject)
    {
        try
        {
            String s1 = jsonobject.getString(c);
            e.d((new StringBuilder()).append("hibernateVer:").append(s1).append(", current version:").append("1.0.0").toString());
            long l1 = StatCommonHelper.getSDKLongVersion(s1);
            if (StatCommonHelper.getSDKLongVersion("1.0.0") <= l1)
            {
                StatPreferences.putLong(com.tencent.stat.c.a(), c, l1);
                setEnableStatService(false);
                e.warn((new StringBuilder()).append("MTA has disable for SDK version of ").append(s1).append(" or lower.").toString());
            }
            return;
        }
        catch (JSONException jsonexception)
        {
            e.d("__HIBERNATE__ not found.");
        }
    }

    static void d()
    {
        y = 1 + y;
    }

    static int e()
    {
        return y;
    }

    public static String getAppKey(Context context)
    {
        if (n != null)
        {
            return n;
        }
        if (context != null && n == null)
        {
            n = StatCommonHelper.getAppKey(context);
        }
        if (n == null || n.trim().length() == 0)
        {
            e.error("AppKey can not be null or empty, please read Developer's Guide first!");
        }
        return n;
    }

    public static int getCurSessionStatReportCount()
    {
        return w;
    }

    public static String getCustomProperty(String s1)
    {
        String s2;
        try
        {
            s2 = a.b.getString(s1);
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return s2;
    }

    public static String getCustomProperty(String s1, String s2)
    {
        String s3;
        try
        {
            s3 = a.b.getString(s1);
        }
        catch (JSONException jsonexception)
        {
            return s2;
        }
        if (s3 != null)
        {
            s2 = s3;
        }
        return s2;
    }

    public static String getInstallChannel(Context context)
    {
        if (o != null)
        {
            return o;
        }
        o = StatCommonHelper.getInstallChannel(context);
        if (o == null || o.trim().length() == 0)
        {
            e.e("installChannel can not be null or empty, please read Developer's Guide first!");
        }
        return o;
    }

    public static int getMaxBatchReportCount()
    {
        return l;
    }

    public static int getMaxDaySessionNumbers()
    {
        return x;
    }

    public static int getMaxParallelTimmingEvents()
    {
        return q;
    }

    public static int getMaxReportEventLength()
    {
        return A;
    }

    public static int getMaxSendRetryCount()
    {
        return k;
    }

    public static int getMaxSessionStatReportCount()
    {
        return v;
    }

    public static int getMaxStoreEventCount()
    {
        return i;
    }

    public static String getQQ()
    {
        return d;
    }

    public static int getSendPeriodMinutes()
    {
        return p;
    }

    public static int getSessionTimoutMillis()
    {
        return h;
    }

    public static String getStatReportUrl()
    {
        return u;
    }

    public static StatReportStrategy getStatSendStrategy()
    {
        return f;
    }

    public static boolean isAutoExceptionCaught()
    {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable()
    {
        return StatCommonHelper.getLogger().isDebugEnable();
    }

    public static boolean isEnableSmartReporting()
    {
        return r;
    }

    public static boolean isEnableStatService()
    {
        return g;
    }

    public static void setAppKey(Context context, String s1)
    {
        if (context == null)
        {
            e.error("ctx in StatConfig.setAppKey() is null");
        } else
        {
            if (s1 == null || s1.length() > 256)
            {
                e.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
                return;
            }
            if (n == null)
            {
                n = a(context);
            }
            if (a(s1) | a(StatCommonHelper.getAppKey(context)))
            {
                a(context, n);
                return;
            }
        }
    }

    public static void setAppKey(String s1)
    {
        if (s1 == null)
        {
            e.error("appkey in StatConfig.setAppKey() is null");
            return;
        }
        if (s1.length() > 256)
        {
            e.error("The length of appkey cann't exceed 256 bytes.");
            return;
        } else
        {
            n = s1;
            return;
        }
    }

    public static void setAutoExceptionCaught(boolean flag)
    {
        isAutoExceptionCaught = flag;
    }

    public static void setDebugEnable(boolean flag)
    {
        StatCommonHelper.getLogger().setDebugEnable(flag);
    }

    public static void setEnableSmartReporting(boolean flag)
    {
        r = flag;
    }

    public static void setEnableStatService(boolean flag)
    {
        g = flag;
        if (!flag)
        {
            e.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setInstallChannel(String s1)
    {
        if (s1.length() > 128)
        {
            e.error("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        } else
        {
            o = s1;
            return;
        }
    }

    public static void setMaxBatchReportCount(int i1)
    {
        if (!a(i1, 2, 1000))
        {
            e.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
            return;
        } else
        {
            l = i1;
            return;
        }
    }

    public static void setMaxDaySessionNumbers(int i1)
    {
        if (i1 <= 0)
        {
            e.e("maxDaySessionNumbers must be greater than 0.");
            return;
        } else
        {
            x = i1;
            return;
        }
    }

    public static void setMaxParallelTimmingEvents(int i1)
    {
        if (!a(i1, 1, 4096))
        {
            e.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
            return;
        } else
        {
            q = i1;
            return;
        }
    }

    public static void setMaxReportEventLength(int i1)
    {
        if (i1 <= 0)
        {
            e.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
            return;
        } else
        {
            A = i1;
            return;
        }
    }

    public static void setMaxSendRetryCount(int i1)
    {
        if (!a(i1, 1, 10))
        {
            e.error("setMaxSendRetryCount can not exceed the range of [1,10].");
            return;
        } else
        {
            k = i1;
            return;
        }
    }

    public static void setMaxSessionStatReportCount(int i1)
    {
        if (i1 < 0)
        {
            e.error("maxSessionStatReportCount cannot be less than 0.");
            return;
        } else
        {
            v = i1;
            return;
        }
    }

    public static void setMaxStoreEventCount(int i1)
    {
        if (!a(i1, 0, 0x7a120))
        {
            e.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
            return;
        } else
        {
            i = i1;
            return;
        }
    }

    public static void setQQ(Context context, String s1)
    {
        StatService.reportQQ(context, s1);
    }

    public static void setSendPeriodMinutes(int i1)
    {
        if (!a(i1, 1, 10080))
        {
            e.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
            return;
        } else
        {
            p = i1;
            return;
        }
    }

    public static void setSessionTimoutMillis(int i1)
    {
        if (!a(i1, 1000, 0x5265c00))
        {
            e.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
            return;
        } else
        {
            h = i1;
            return;
        }
    }

    public static void setStatReportUrl(String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            e.error("statReportUrl cannot be null or empty.");
            return;
        } else
        {
            u = s1;
            return;
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statreportstrategy)
    {
        f = statreportstrategy;
        e.d((new StringBuilder()).append("Change to statSendStrategy: ").append(statreportstrategy).toString());
    }

    static 
    {
        f = StatReportStrategy.APP_LAUNCH;
    }
}
