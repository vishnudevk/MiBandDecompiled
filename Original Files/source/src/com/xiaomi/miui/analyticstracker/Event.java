// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import java.util.List;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            j

public abstract class Event
    implements Cloneable
{

    protected static final char SPLITTER = 36;
    protected static List sDispatcher;
    protected String mEventId;
    protected String mPolicy;
    protected long mTrackTime;
    protected Integer mType;

    public Event()
    {
        setTime(System.currentTimeMillis());
    }

    public static void setDispatcher(List list)
    {
        sDispatcher = list;
    }

    public Object clone()
    {
        Event event;
        try
        {
            event = (Event)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            clonenotsupportedexception.printStackTrace();
            return null;
        }
        return event;
    }

    public abstract void dispatch();

    public String getEventId()
    {
        return mEventId;
    }

    public String getPolicy()
    {
        return mPolicy;
    }

    public long getTrackTime()
    {
        return mTrackTime;
    }

    public Integer getType()
    {
        return mType;
    }

    public void restore(Cursor cursor)
    {
        if (cursor != null)
        {
            mEventId = cursor.getString(cursor.getColumnIndexOrThrow("event_id"));
            mTrackTime = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow("time")));
        }
    }

    public void setPolicy(String s)
    {
        mPolicy = s;
    }

    public void setTime(long l)
    {
        mTrackTime = l;
    }

    public abstract void writeEvent(j j);
}
