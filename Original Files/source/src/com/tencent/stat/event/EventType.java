// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;


public final class EventType extends Enum
{

    public static final EventType ADDITION;
    public static final EventType CUSTOM;
    public static final EventType ERROR;
    public static final EventType MONITOR_STAT;
    public static final EventType PAGE_VIEW;
    public static final EventType SESSION_ENV;
    private static final EventType b[];
    private int a;

    private EventType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public int GetIntValue()
    {
        return a;
    }

    static 
    {
        PAGE_VIEW = new EventType("PAGE_VIEW", 0, 1);
        SESSION_ENV = new EventType("SESSION_ENV", 1, 2);
        ERROR = new EventType("ERROR", 2, 3);
        CUSTOM = new EventType("CUSTOM", 3, 1000);
        ADDITION = new EventType("ADDITION", 4, 1001);
        MONITOR_STAT = new EventType("MONITOR_STAT", 5, 1002);
        EventType aeventtype[] = new EventType[6];
        aeventtype[0] = PAGE_VIEW;
        aeventtype[1] = SESSION_ENV;
        aeventtype[2] = ERROR;
        aeventtype[3] = CUSTOM;
        aeventtype[4] = ADDITION;
        aeventtype[5] = MONITOR_STAT;
        b = aeventtype;
    }
}
