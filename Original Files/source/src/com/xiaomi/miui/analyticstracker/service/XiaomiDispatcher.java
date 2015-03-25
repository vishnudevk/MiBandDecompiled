// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import com.xiaomi.miui.analyticstracker.Dispatchable;
import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.LogEvent;
import com.xiaomi.miui.analyticstracker.TrackEvent;
import com.xiaomi.miui.analyticstracker.TrackPageViewEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            XiaomiServer

public class XiaomiDispatcher
    implements Dispatchable
{

    public static final String TAG = "xiaomi";
    private static final String c = "_event_id_";
    private static final String d = "_event_type_";
    private static final String e = "_event_value_";
    private static final String f = "_event_track_time_";
    private static final String g = "_app_package_";
    private static final String h = "_log_event_class_";
    private static final String i = "_log_event_message_";
    private XiaomiServer a;
    private String b;

    public XiaomiDispatcher()
    {
        a = XiaomiServer.getInstance();
    }

    private Map a(Event event)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_event_id_", event.getEventId());
        hashmap.put("_event_type_", event.getType());
        hashmap.put("_event_track_time_", Long.valueOf(event.getTrackTime()));
        hashmap.put("_app_package_", b);
        return hashmap;
    }

    public void dispatchEvent(TrackEvent trackevent)
    {
        if (a != null)
        {
            Map map = a(trackevent);
            Map map1 = trackevent.getParam();
            if (map1 != null)
            {
                String s;
                for (Iterator iterator = map1.keySet().iterator(); iterator.hasNext(); map.put(s, map1.get(s)))
                {
                    s = (String)iterator.next();
                }

            }
            map.put("_event_value_", Long.valueOf(trackevent.getValue()));
            a.send(map);
        }
    }

    public void dispatchLog(LogEvent logevent)
    {
        if (a != null)
        {
            Map map = a(logevent);
            map.put("_log_event_class_", logevent.getErrorClass());
            map.put("_log_event_message_", logevent.getMessage());
            a.send(map);
        }
    }

    public void dispatchPageView(TrackPageViewEvent trackpageviewevent)
    {
        if (a != null)
        {
            Map map = a(trackpageviewevent);
            a.send(map);
        }
    }

    public void start(Context context, String s)
    {
        a.init();
        b = s;
    }

    public void stop()
    {
        a.close();
    }
}
