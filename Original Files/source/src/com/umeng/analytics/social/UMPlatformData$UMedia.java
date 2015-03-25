// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;


// Referenced classes of package com.umeng.analytics.social:
//            i, j, k, l, 
//            m, n, o, p

public class <init> extends Enum
{

    public static final a DOUBAN;
    public static final a RENREN;
    public static final a SINA_WEIBO;
    public static final a TENCENT_QQ;
    public static final a TENCENT_QZONE;
    public static final a TENCENT_WEIBO;
    public static final a WEIXIN_CIRCLE;
    public static final a WEIXIN_FRIENDS;
    private static final a a[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$UMedia, s);
    }

    public static <init>[] values()
    {
        <init> a_3C_init>[] = a;
        int i1 = a_3C_init>.length;
        <init> a_3C_init>1[] = new a[i1];
        System.arraycopy(a_3C_init>, 0, a_3C_init>1, 0, i1);
        return a_3C_init>1;
    }

    static 
    {
        SINA_WEIBO = new i("SINA_WEIBO", 0);
        TENCENT_WEIBO = new j("TENCENT_WEIBO", 1);
        TENCENT_QZONE = new k("TENCENT_QZONE", 2);
        TENCENT_QQ = new l("TENCENT_QQ", 3);
        WEIXIN_FRIENDS = new m("WEIXIN_FRIENDS", 4);
        WEIXIN_CIRCLE = new n("WEIXIN_CIRCLE", 5);
        RENREN = new o("RENREN", 6);
        DOUBAN = new p("DOUBAN", 7);
        a aa[] = new DOUBAN[8];
        aa[0] = SINA_WEIBO;
        aa[1] = TENCENT_WEIBO;
        aa[2] = TENCENT_QZONE;
        aa[3] = TENCENT_QQ;
        aa[4] = WEIXIN_FRIENDS;
        aa[5] = WEIXIN_CIRCLE;
        aa[6] = RENREN;
        aa[7] = DOUBAN;
        a = aa;
    }

    private (String s, int i1)
    {
        super(s, i1);
    }

    (String s, int i1,  )
    {
        this(s, i1);
    }
}
