// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            d, TrackEvent, TrackPageViewEvent, b, 
//            LogEvent

public class AnalyticsTracker
{

    private static final String a = "XIAOMIANALYTICS";
    private static final AnalyticsTracker b = new AnalyticsTracker();
    private static final String c = "_timed_event_";
    private static final String d = "_timed_event_id_";
    private static final String e = "_event_default_param_";
    private static final String f = "_active_";
    private static final String g = "imei";
    private static final String h = "rom_version";
    private static final String i = "model";
    private static final String j = "app_version";
    private static final String k = "_client_id_";
    private static final long l;
    private d m;
    private boolean n;
    private Context o;
    private List p;
    private int q;
    private String r;

    private AnalyticsTracker()
    {
        m = null;
        n = false;
        o = null;
        p = null;
        q = 0;
        r = null;
    }

    private boolean a()
    {
        if (m == null || o == null)
        {
            Log.i("XIAOMIANALYTICS", "method: startSession should be called before tracking events");
            return false;
        } else
        {
            return true;
        }
    }

    public static AnalyticsTracker getInstance()
    {
        return b;
    }

    public void endSession()
    {
        this;
        JVM INSTR monitorenter ;
        if (q <= 0) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = -1 + q;
        q = i1;
        if (i1 != 0) goto _L2; else goto _L3
_L3:
        boolean flag = a();
        if (flag) goto _L4; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        Object aobj[] = new Object[1];
        aobj[0] = o.getPackageName();
        Log.i("XIAOMIANALYTICS", String.format("end session(%s)", aobj));
        o = null;
        m.a();
        m = null;
        p.clear();
        p = null;
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public void endTimedEvent(String s)
    {
        if (p != null) goto _L2; else goto _L1
_L1:
        Log.i("XIAOMIANALYTICS", "there is no timed event");
_L4:
        return;
_L2:
        boolean flag;
        Iterator iterator = p.iterator();
        TrackEvent trackevent;
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            trackevent = (TrackEvent)iterator.next();
        } while (!s.equals(trackevent.getEventId()));
        long l1 = System.currentTimeMillis();
        HashMap hashmap = new HashMap();
        hashmap.put("_timed_event_id_", s);
        trackEvent("_timed_event_", hashmap, l1 - trackevent.getTrackTime());
        iterator.remove();
        flag = true;
_L5:
        if (!flag)
        {
            Log.i("XIAOMIANALYTICS", String.format("the ended event (%s) is not timed", new Object[] {
                s
            }));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag = false;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void onTrackPageView()
    {
        if (!a())
        {
            return;
        } else
        {
            m.a(new TrackPageViewEvent());
            return;
        }
    }

    public void setUseHttps(boolean flag)
    {
        if (flag != n)
        {
            n = flag;
        }
    }

    public void setUserKey(String s)
    {
        r = s;
    }

    public void startSession(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        int i1;
        i1 = q;
        q = i1 + 1;
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        o = context.getApplicationContext();
        m = new d();
        m.a(o);
        p = Collections.synchronizedList(new ArrayList());
        r = SysUtils.getIMEI(o);
        Object aobj[] = new Object[1];
        aobj[0] = o.getPackageName();
        Log.i("XIAOMIANALYTICS", String.format("start session(%s)", aobj));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void trackActive()
    {
        trackActive(SysUtils.getIMEI(o));
    }

    public void trackActive(String s)
    {
        trackTimedEvent("_active_", new b(this, s), false, 0L);
    }

    public void trackError(String s, String s1, String s2)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s2))
        {
            Log.i("XIAOMIANALYTICS", "the id or error class of loged event is null or empty");
        } else
        if (a())
        {
            if (s1 == null)
            {
                s1 = "";
            }
            m.a(new LogEvent(s, s1, s2));
            return;
        }
    }

    public void trackEvent(String s)
    {
        trackTimedEvent(s, null, false, 0L);
    }

    public void trackEvent(String s, long l1)
    {
        trackTimedEvent(s, null, false, l1);
    }

    public void trackEvent(String s, Object obj)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_event_default_param_", obj.toString());
        trackEvent(s, ((Map) (hashmap)));
    }

    public void trackEvent(String s, Map map)
    {
        trackTimedEvent(s, map, false, 0L);
    }

    public void trackEvent(String s, Map map, long l1)
    {
        trackTimedEvent(s, map, false, l1);
    }

    public void trackTimedEvent(String s, Map map, boolean flag)
    {
        trackTimedEvent(s, map, flag, 0L);
    }

    public void trackTimedEvent(String s, Map map, boolean flag, long l1)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Log.i("XIAOMIANALYTICS", "the id of tracked event is null or empty");
_L4:
        return;
_L2:
        if (!a()) goto _L4; else goto _L3
_L3:
        String s1 = SysUtils.getIMEI(o);
        Exception exception;
        Exception exception1;
        Object obj;
        TrackEvent trackevent;
        String s2;
        if (TextUtils.isEmpty(s1))
        {
            s2 = "null";
        } else
        {
            s2 = s1;
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        obj = new HashMap();
_L7:
        ((Map) (obj)).put("imei", s2);
        ((Map) (obj)).put("rom_version", SysUtils.getRomVersion(o));
        ((Map) (obj)).put("model", SysUtils.getModel(o));
        ((Map) (obj)).put("app_version", SysUtils.getAppVersion(o));
        if (r != null && !r.equals(s2) && !((Map) (obj)).containsKey("_client_id_"))
        {
            ((Map) (obj)).put("_client_id_", r);
        }
_L5:
        trackevent = new TrackEvent(s, ((Map) (obj)), l1);
        m.a(trackevent);
        if (flag)
        {
            p.add(trackevent);
            return;
        }
          goto _L4
        exception;
        exception1 = exception;
        obj = map;
_L6:
        Log.e("XIAOMIANALYTICS", exception1.getMessage());
          goto _L5
        exception1;
          goto _L6
        obj = map;
          goto _L7
    }

    public void trackTimedEvent(String s, boolean flag)
    {
        trackTimedEvent(s, null, flag, 0L);
    }

    public void trackTimedEvent(String s, boolean flag, long l1)
    {
        trackTimedEvent(s, null, flag, 0L);
    }

}
