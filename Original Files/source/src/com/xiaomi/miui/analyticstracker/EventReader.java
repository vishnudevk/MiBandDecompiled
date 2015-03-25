// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            d

public class EventReader
{

    private d a;

    public EventReader()
    {
        a = new d();
    }

    public void close()
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void open(Context context, String s)
    {
        a.a(context, s);
    }

    public List readEvents(String s, List list)
    {
        if (a != null)
        {
            return a.a(s, list);
        } else
        {
            return Collections.emptyList();
        }
    }
}
