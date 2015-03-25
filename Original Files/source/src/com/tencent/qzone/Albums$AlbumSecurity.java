// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.qzone;


public final class a extends Enum
{

    private static final b b[];
    public static final b friendsOnly;
    public static final b needQuestion;
    public static final b privateOnly;
    public static final b publicToAll;
    private final String a;

    public String getSecurity()
    {
        return a;
    }

    static 
    {
        publicToAll = new <init>("publicToAll", 0, "1");
        privateOnly = new <init>("privateOnly", 1, "2");
        friendsOnly = new <init>("friendsOnly", 2, "4");
        needQuestion = new <init>("needQuestion", 3, "5");
        a aa[] = new <init>[4];
        aa[0] = publicToAll;
        aa[1] = privateOnly;
        aa[2] = friendsOnly;
        aa[3] = needQuestion;
        b = aa;
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}
