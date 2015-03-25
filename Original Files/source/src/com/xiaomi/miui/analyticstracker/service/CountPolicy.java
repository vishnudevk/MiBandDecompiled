// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.TrackEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            Policy

public class CountPolicy extends Policy
{

    public static final String TAG = "count";
    private static final String a = "CountPolicyEvent";
    private Map b;

    public CountPolicy()
    {
        b = new HashMap();
    }

    public void end()
    {
        String s;
        HashMap hashmap;
        for (Iterator iterator = b.keySet().iterator(); iterator.hasNext(); (new TrackEvent(s, hashmap, ((Integer)b.get(s)).intValue())).dispatch())
        {
            s = (String)iterator.next();
            hashmap = new HashMap();
            hashmap.put("CountPolicyEvent", "counts");
        }

        b.clear();
    }

    public void execute(Event event)
    {
        Integer integer = (Integer)b.get(event.getEventId());
        Integer integer1;
        if (integer == null)
        {
            integer1 = new Integer(1);
        } else
        {
            integer1 = Integer.valueOf(1 + integer.intValue());
        }
        b.put(event.getEventId(), integer1);
    }

    public void prepare()
    {
    }
}
