// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public final class data
{

    public final List data;
    public final Calendar timestamp;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n    timestamp: ").append(DateFormat.getDateTimeInstance().format(timestamp.getTime())).toString());
        stringbuilder.append((new StringBuilder()).append("\n  data.size(): ").append(data.size()).toString());
        return stringbuilder.toString();
    }

    public (Calendar calendar, List list)
    {
        timestamp = calendar;
        data = list;
    }
}
