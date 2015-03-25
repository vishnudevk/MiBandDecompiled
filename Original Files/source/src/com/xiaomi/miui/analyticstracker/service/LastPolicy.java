// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            Policy

public class LastPolicy extends Policy
{

    public static final String TAG = "last";
    private Map a;

    public LastPolicy()
    {
        a = new HashMap();
    }

    public void end()
    {
        String s;
        for (Iterator iterator = a.keySet().iterator(); iterator.hasNext(); ((Event)a.get(s)).dispatch())
        {
            s = (String)iterator.next();
        }

        a.clear();
    }

    public void execute(Event event)
    {
        a.put(event.getEventId(), event);
    }

    public void prepare()
    {
    }
}
