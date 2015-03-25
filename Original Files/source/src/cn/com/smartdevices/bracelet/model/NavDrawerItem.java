// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class NavDrawerItem
{

    private String count;
    private int icon;
    private boolean isCounterVisible;
    private String title;

    public NavDrawerItem()
    {
        count = "0";
        isCounterVisible = false;
    }

    public NavDrawerItem(String s, int i)
    {
        count = "0";
        isCounterVisible = false;
        title = s;
        icon = i;
    }

    public NavDrawerItem(String s, int i, boolean flag, String s1)
    {
        count = "0";
        isCounterVisible = false;
        title = s;
        icon = i;
        isCounterVisible = flag;
        count = s1;
    }

    public String getCount()
    {
        return count;
    }

    public boolean getCounterVisibility()
    {
        return isCounterVisible;
    }

    public int getIcon()
    {
        return icon;
    }

    public String getTitle()
    {
        return title;
    }

    public void setCount(String s)
    {
        count = s;
    }

    public void setCounterVisibility(boolean flag)
    {
        isCounterVisible = flag;
    }

    public void setIcon(int i)
    {
        icon = i;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
