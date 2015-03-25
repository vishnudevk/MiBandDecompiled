// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;


public class FriendsManager
{

    private static FriendsManager a = null;

    private FriendsManager()
    {
    }

    public static FriendsManager getInstance()
    {
        if (a == null)
        {
            a = new FriendsManager();
        }
        return a;
    }

}
