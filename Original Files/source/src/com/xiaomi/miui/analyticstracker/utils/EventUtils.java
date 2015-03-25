// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import java.io.File;

public class EventUtils
{

    public static final String COLUMN_ID = "event_id";
    public static final String COLUMN_PARAM = "param";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_VALUE = "value";
    public static final int DEFAULT_MAXSAVE = 7;
    public static final String FIRST_DATE = "first_date";
    public static final int TYPE_EVENT = 2;
    public static final int TYPE_LOG = 1;
    public static final int TYPE_TRACKPAGEVIEW = 3;

    public EventUtils()
    {
    }

    public static void deleteDatabaseFile(Context context, String s)
    {
        context.deleteDatabase(s);
        Object aobj[] = new Object[1];
        aobj[0] = context.getDatabasePath(s).getAbsolutePath();
        File file = new File(String.format("%s-journal", aobj));
        if (file.exists())
        {
            file.delete();
        }
    }

    public static boolean enableWrite(Context context)
    {
        return true;
    }

    public static int getDatabaseIndexFromTime(long l)
    {
        return getDay(l) % 7;
    }

    public static String getDatabaseName()
    {
        return getDatabaseName(getDay(System.currentTimeMillis()) % 7);
    }

    public static String getDatabaseName(int i)
    {
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        return String.format("analytics_%d.db", aobj);
    }

    public static int getDay(long l)
    {
        return (int)(l / 0x5265c00L);
    }
}
