// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.eventbus;


public class EventPersonInfoUpdate
{

    public static final String UPDATE_AVATAR = "update_avatar";
    public String type;

    public EventPersonInfoUpdate()
    {
    }

    public EventPersonInfoUpdate(String s)
    {
        type = s;
    }
}
