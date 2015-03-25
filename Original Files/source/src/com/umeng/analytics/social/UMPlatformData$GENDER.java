// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;


// Referenced classes of package com.umeng.analytics.social:
//            g, h

public class <init> extends Enum
{

    public static final a FEMALE;
    public static final a MALE;
    private static final a a[];
    public int value;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$GENDER, s);
    }

    public static <init>[] values()
    {
        <init> a_3C_init>[] = a;
        int i = a_3C_init>.length;
        <init> a_3C_init>1[] = new a[i];
        System.arraycopy(a_3C_init>, 0, a_3C_init>1, 0, i);
        return a_3C_init>1;
    }

    static 
    {
        MALE = new g("MALE", 0, 0);
        FEMALE = new h("FEMALE", 1, 1);
        a aa[] = new FEMALE[2];
        aa[0] = MALE;
        aa[1] = FEMALE;
        a = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    value(String s, int i, int j, value value1)
    {
        this(s, i, j);
    }
}
