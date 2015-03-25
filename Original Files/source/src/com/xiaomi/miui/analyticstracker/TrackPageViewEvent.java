// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            Event, Dispatchable, j

public class TrackPageViewEvent extends Event
{

    private static final String a = "_pageview_event_";

    public TrackPageViewEvent()
    {
        mType = Integer.valueOf(3);
        mEventId = "_pageview_event_";
    }

    public void dispatch()
    {
        if (sDispatcher != null)
        {
            for (Iterator iterator = sDispatcher.iterator(); iterator.hasNext(); ((Dispatchable)iterator.next()).dispatchPageView(this)) { }
        }
    }

    public void writeEvent(j j1)
    {
        if (j1 != null)
        {
            j1.a(mType, mEventId, "", (new StringBuilder()).append(mTrackTime).append("").toString(), Boolean.toString(false));
        }
    }
}
