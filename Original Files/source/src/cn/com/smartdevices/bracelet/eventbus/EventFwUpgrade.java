// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.eventbus;


public class EventFwUpgrade
{

    public static final int FW_TYPE_PROGRESS = 1;
    public static final int FW_TYPE_START = 0;
    public static final int FW_TYPE_STOP = 2;
    private Object data;
    private int type;

    public EventFwUpgrade(int i, Object obj)
    {
        type = 0;
        data = null;
        type = i;
        data = obj;
    }

    public Object data()
    {
        return data;
    }

    public int type()
    {
        return type;
    }
}
