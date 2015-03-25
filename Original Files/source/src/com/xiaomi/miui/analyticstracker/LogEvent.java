// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            Event, Dispatchable, j

public class LogEvent extends Event
{

    private String a;
    private String b;

    public LogEvent()
    {
        mType = Integer.valueOf(1);
        a = "";
        b = "";
    }

    public LogEvent(String s, String s1, String s2)
    {
        mType = Integer.valueOf(1);
        mEventId = s;
        a = s1;
        b = s2;
    }

    private String a()
    {
        StringBuilder stringbuilder = new StringBuilder(a);
        stringbuilder.append('$');
        stringbuilder.append(b);
        return stringbuilder.toString();
    }

    private void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String as[] = s.split("\\$");
            if (as.length > 1)
            {
                a = as[0];
                b = as[1];
            }
        }
    }

    public void dispatch()
    {
        if (sDispatcher != null)
        {
            for (Iterator iterator = sDispatcher.iterator(); iterator.hasNext(); ((Dispatchable)iterator.next()).dispatchLog(this)) { }
        }
    }

    public String getErrorClass()
    {
        return b;
    }

    public String getMessage()
    {
        return a;
    }

    public void restore(Cursor cursor)
    {
        super.restore(cursor);
        if (cursor != null)
        {
            a(cursor.getString(cursor.getColumnIndexOrThrow("param")));
        }
    }

    public void writeEvent(j j1)
    {
        if (j1 != null)
        {
            j1.a(mType, mEventId, a(), (new StringBuilder()).append(mTrackTime).append("").toString(), Boolean.toString(false));
        }
    }
}
