// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            Event, Dispatchable, j

public class TrackEvent extends Event
{

    private Map a;
    private long b;

    public TrackEvent()
    {
        mType = Integer.valueOf(2);
        a = null;
        b = 0L;
    }

    public TrackEvent(String s, Map map, long l)
    {
        mType = Integer.valueOf(2);
        mEventId = s;
        a = map;
        b = l;
    }

    private String a(Map map)
    {
        String s = "";
        if (map != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append('$'))
            {
                String s1 = (String)iterator.next();
                stringbuilder.append(s1);
                stringbuilder.append('$');
                stringbuilder.append((String)map.get(s1));
            }

            s = stringbuilder.toString();
        }
        return s;
    }

    private void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            a = new HashMap();
            String as[] = s.split("\\$");
            for (int i = 0; i < -1 + as.length; i += 2)
            {
                a.put(as[i], as[i + 1]);
            }

        }
    }

    public void dispatch()
    {
        if (sDispatcher != null)
        {
            for (Iterator iterator = sDispatcher.iterator(); iterator.hasNext(); ((Dispatchable)iterator.next()).dispatchEvent(this)) { }
        }
    }

    public Map getParam()
    {
        return a;
    }

    public long getValue()
    {
        return b;
    }

    public void restore(Cursor cursor)
    {
        super.restore(cursor);
        if (cursor != null)
        {
            b = Long.parseLong(cursor.getString(cursor.getColumnIndexOrThrow("value")));
            a(cursor.getString(cursor.getColumnIndexOrThrow("param")));
        }
    }

    public void writeEvent(j j1)
    {
        if (j1 != null)
        {
            j1.a(mType, mEventId, a(a), (new StringBuilder()).append(mTrackTime).append("").toString(), (new StringBuilder()).append(b).append("").toString());
        }
    }
}
