// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.location;


public class LocationOption
{

    private LocationMode a;
    private int b;
    private boolean c;

    public LocationOption()
    {
    }

    public LocationMode getMode()
    {
        return a;
    }

    public int getUpdateInterval()
    {
        return b;
    }

    public boolean isNeedAddress()
    {
        return c;
    }

    public void setMode(LocationMode locationmode)
    {
        a = locationmode;
    }

    public void setNeedAddress(boolean flag)
    {
        c = flag;
    }

    public void setUpdateInterval(int i)
    {
        b = i;
    }
}
