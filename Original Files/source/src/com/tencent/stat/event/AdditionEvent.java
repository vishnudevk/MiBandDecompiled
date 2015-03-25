// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.StatCommonHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            Event, EventType

public class AdditionEvent extends Event
{

    Map a;

    public AdditionEvent(Context context, int i, Map map)
    {
        super(context, i);
        a = null;
        a = map;
    }

    public EventType getType()
    {
        return EventType.ADDITION;
    }

    public boolean onEncode(JSONObject jsonobject)
    {
        StatCommonHelper.jsonPut(jsonobject, "qq", StatConfig.getQQ());
        if (a != null && a.size() > 0)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); jsonobject.put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        return true;
    }
}
