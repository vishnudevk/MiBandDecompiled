// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


public final class a extends Enum
{

    public static final b MANUAL_REFRESHING;
    public static final b OVERSCROLLING;
    public static final b PULL_TO_REFRESH;
    public static final b REFRESHING;
    public static final b RELEASE_TO_REFRESH;
    public static final b RESET;
    private static final b b[];
    private int a;

    static a a(int i)
    {
        a aa[] = values();
        int j = aa.length;
        for (int k = 0; k < j; k++)
        {
            a a1 = aa[k];
            if (i == a1.a())
            {
                return a1;
            }
        }

        return RESET;
    }

    public static RESET valueOf(String s)
    {
        return (RESET)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$State, s);
    }

    public static RESET[] values()
    {
        return (RESET[])b.clone();
    }

    int a()
    {
        return a;
    }

    static 
    {
        RESET = new <init>("RESET", 0, 0);
        PULL_TO_REFRESH = new <init>("PULL_TO_REFRESH", 1, 1);
        RELEASE_TO_REFRESH = new <init>("RELEASE_TO_REFRESH", 2, 2);
        REFRESHING = new <init>("REFRESHING", 3, 8);
        MANUAL_REFRESHING = new <init>("MANUAL_REFRESHING", 4, 9);
        OVERSCROLLING = new <init>("OVERSCROLLING", 5, 16);
        a aa[] = new <init>[6];
        aa[0] = RESET;
        aa[1] = PULL_TO_REFRESH;
        aa[2] = RELEASE_TO_REFRESH;
        aa[3] = REFRESHING;
        aa[4] = MANUAL_REFRESHING;
        aa[5] = OVERSCROLLING;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
