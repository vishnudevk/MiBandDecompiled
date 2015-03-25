// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            Event, EventType

public class PageView extends Event
{

    Long a;
    String b;
    String c;

    public PageView(Context context, String s, int i, Long long1)
    {
        super(context, i);
        a = null;
        c = s;
        b = StatCommonHelper.getActivityName(context);
        a = long1;
    }

    public String getPageId()
    {
        return b;
    }

    public EventType getType()
    {
        return EventType.PAGE_VIEW;
    }

    public boolean onEncode(JSONObject jsonobject)
    {
        jsonobject.put("pi", b);
        StatCommonHelper.jsonPut(jsonobject, "rf", c);
        if (a != null)
        {
            jsonobject.put("du", a);
        }
        return true;
    }
}
