// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            Event, EventType

public class MonitorStatEvent extends Event
{

    private static String b = null;
    private static String c = null;
    private StatAppMonitor a;

    public MonitorStatEvent(Context context, int i, StatAppMonitor statappmonitor)
    {
        super(context, i);
        a = null;
        a = statappmonitor;
    }

    public EventType getType()
    {
        return EventType.MONITOR_STAT;
    }

    public boolean onEncode(JSONObject jsonobject)
    {
        if (a == null)
        {
            return false;
        }
        jsonobject.put("na", a.getInterfaceName());
        jsonobject.put("rq", a.getReqSize());
        jsonobject.put("rp", a.getRespSize());
        jsonobject.put("rt", a.getResultType());
        jsonobject.put("tm", a.getMillisecondsConsume());
        jsonobject.put("rc", a.getReturnCode());
        jsonobject.put("sp", a.getSampling());
        if (c == null)
        {
            c = StatCommonHelper.getAppVersion(ctx);
        }
        StatCommonHelper.jsonPut(jsonobject, "av", c);
        if (b == null)
        {
            b = StatCommonHelper.getSimOperator(ctx);
        }
        StatCommonHelper.jsonPut(jsonobject, "op", b);
        jsonobject.put("cn", StatCommonHelper.getLinkedWay(ctx));
        return true;
    }

}
