// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


public final class a extends Enum
{

    public static final PULL_FROM_END BOTH;
    public static final PULL_FROM_END DISABLED;
    public static final PULL_FROM_END MANUAL_REFRESH_ONLY;
    public static PULL_FROM_END PULL_DOWN_TO_REFRESH;
    public static final PULL_FROM_END PULL_FROM_END;
    public static final PULL_FROM_END PULL_FROM_START;
    public static PULL_FROM_END PULL_UP_TO_REFRESH;
    private static final PULL_FROM_END b[];
    private int a;

    static a a()
    {
        return PULL_FROM_START;
    }

    static PULL_FROM_START a(int i)
    {
        PULL_FROM_START apull_from_start[] = values();
        int j = apull_from_start.length;
        for (int k = 0; k < j; k++)
        {
            PULL_FROM_START pull_from_start = apull_from_start[k];
            if (i == pull_from_start.c())
            {
                return pull_from_start;
            }
        }

        return a();
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Mode, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    boolean b()
    {
        return this != DISABLED && this != MANUAL_REFRESH_ONLY;
    }

    int c()
    {
        return a;
    }

    public boolean showFooterLoadingLayout()
    {
        return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }

    public boolean showHeaderLoadingLayout()
    {
        return this == PULL_FROM_START || this == BOTH;
    }

    static 
    {
        DISABLED = new <init>("DISABLED", 0, 0);
        PULL_FROM_START = new <init>("PULL_FROM_START", 1, 1);
        PULL_FROM_END = new <init>("PULL_FROM_END", 2, 2);
        BOTH = new <init>("BOTH", 3, 3);
        MANUAL_REFRESH_ONLY = new <init>("MANUAL_REFRESH_ONLY", 4, 4);
        BOTH aboth[] = new <init>[5];
        aboth[0] = DISABLED;
        aboth[1] = PULL_FROM_START;
        aboth[2] = PULL_FROM_END;
        aboth[3] = BOTH;
        aboth[4] = MANUAL_REFRESH_ONLY;
        b = aboth;
        PULL_DOWN_TO_REFRESH = PULL_FROM_START;
        PULL_UP_TO_REFRESH = PULL_FROM_END;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
