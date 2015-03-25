// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.Dispatchable;
import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.EventReader;
import com.xiaomi.miui.analyticstracker.ObjectBuilder;
import com.xiaomi.miui.analyticstracker.utils.EventUtils;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            PolicyHelper, XiaomiDispatcher, Policy

public class DispatcherManager
{

    private static final String f = "DispatcherManager";
    private Map a;
    private ObjectBuilder b;
    private EventReader c;
    private PolicyHelper d;
    private Context e;

    public DispatcherManager(Context context)
    {
        a = new HashMap();
        b = new ObjectBuilder();
        c = new EventReader();
        d = new PolicyHelper();
        e = context;
        b.registerClass(com/xiaomi/miui/analyticstracker/service/XiaomiDispatcher, "xiaomi");
    }

    private void a(String s, List list)
    {
        c.open(e, s);
        Iterator iterator = c.readEvents(null, list).iterator();
        do
        {
            Event event;
            Policy policy;
label0:
            {
                if (iterator.hasNext())
                {
                    event = (Event)iterator.next();
                    policy = d.getPolicy(event.getPolicy());
                    if (policy == null)
                    {
                        continue;
                    }
                    if (SysUtils.isWifiConnected(e) && EventUtils.enableWrite(e))
                    {
                        break label0;
                    }
                }
                c.close();
                return;
            }
            policy.execute(event);
        } while (true);
    }

    public static boolean databaseExist(Context context, String s)
    {
        return context.getDatabasePath(s).exists();
    }

    public void dispatch(List list)
    {
        Dispatchable dispatchable;
        for (Iterator iterator = a.keySet().iterator(); iterator.hasNext(); dispatchable.start(e, (String)a.get(dispatchable)))
        {
            dispatchable = (Dispatchable)iterator.next();
        }

        d.clear();
        int i = EventUtils.getDatabaseIndexFromTime(System.currentTimeMillis());
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j < 7)
                {
                    if (--i < 0)
                    {
                        i += 7;
                    }
                    if (SysUtils.isWifiConnected(e) && EventUtils.enableWrite(e))
                    {
                        break label1;
                    }
                }
                d.end();
                for (Iterator iterator1 = a.keySet().iterator(); iterator1.hasNext(); ((Dispatchable)iterator1.next()).stop()) { }
                break label0;
            }
            String s = EventUtils.getDatabaseName(i);
            if (databaseExist(e, s))
            {
                a(s, list);
            }
            j++;
        } while (true);
    }

    public void switchDispatcher(Map map)
    {
        a.clear();
        if (map != null)
        {
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Dispatchable dispatchable = (Dispatchable)b.buildObject(s);
                if (dispatchable == null)
                {
                    Log.d("DispatcherManager", String.format("server:%s does not exist", new Object[] {
                        s
                    }));
                } else
                {
                    a.put(dispatchable, map.get(s));
                }
            }

            if (map.size() > 0)
            {
                Event.setDispatcher(new ArrayList(a.keySet()));
            }
        }
    }
}
