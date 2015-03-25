// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public abstract class BasePushItem
{

    public static final int PUSH_TYPE_DATA = 1;
    public static final int PUSH_TYPE_SYSTEM = 2;
    public static final int PUSH_TYPE_USER;
    public boolean hasRead;
    public int pushType;

    public BasePushItem(int i)
    {
        pushType = 0;
        hasRead = false;
        pushType = i;
    }

    public abstract String getContent();

    public int getType()
    {
        return pushType;
    }
}
