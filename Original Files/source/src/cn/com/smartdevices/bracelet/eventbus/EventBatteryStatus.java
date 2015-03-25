// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.eventbus;


public class EventBatteryStatus
{

    public int level;
    public byte status;

    public EventBatteryStatus(byte byte0, int i)
    {
        status = 0;
        level = 0;
        status = byte0;
        level = i;
    }
}
