// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class NetDataInfo
{

    public static final int DATA_HAVE = 2;
    public static final int DATA_NONE = 1;
    public static final int DATA_UNKNOW;
    public int dataState;
    public String startDate;
    public String stopDate;

    public NetDataInfo()
    {
        dataState = 0;
        startDate = null;
        stopDate = null;
    }

    public boolean hasData()
    {
        return dataState == 2;
    }

    public boolean isUnknow()
    {
        return dataState == 0;
    }
}
