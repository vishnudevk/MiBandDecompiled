// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class SwitchOperator
{

    public static final int SWITCH_BIND_NEW = 0;
    public static final int SWITCH_EXIT_LOGIN = 1;
    public static final int SWITCH_NONE = -1;
    public String date;
    public boolean enableClearData;
    public boolean enableSteps;
    public String lastMacAddress;
    public long lastUid;
    public int steps;
    public int type;

    public SwitchOperator()
    {
        type = -1;
        steps = 0;
        enableSteps = false;
        enableClearData = false;
        lastUid = -1L;
        lastMacAddress = "";
        date = "";
    }
}
