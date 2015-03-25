// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


public final class  extends Enum
{

    public static final a HORIZONTAL;
    public static final a VERTICAL;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$Orientation, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        VERTICAL = new <init>("VERTICAL", 0);
        HORIZONTAL = new <init>("HORIZONTAL", 1);
        n_3B_.clone aclone[] = new <init>[2];
        aclone[0] = VERTICAL;
        aclone[1] = HORIZONTAL;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
