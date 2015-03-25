// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.eventbus;

import cn.com.smartdevices.bracelet.lua.ConfigDynamicDataInfo;

public class EventGameUpdate
{

    ConfigDynamicDataInfo configInfo;

    public EventGameUpdate()
    {
        configInfo = new ConfigDynamicDataInfo();
    }

    public ConfigDynamicDataInfo getConfigInfo()
    {
        return configInfo;
    }
}
