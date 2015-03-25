// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;


// Referenced classes of package com.xiaomi.market.sdk:
//            s

public class j
{

    public static final String HOST = "host";
    public static final String T = "http://api.developer.xiaomi.com/autoupdate/";
    public static final String U = "http://dev.staging.api.developer.n.xiaomi.com/autoupdate/";
    public static String V = "http://api.developer.xiaomi.com/autoupdate/updateself";
    public static final String W = "packageName";
    public static final String X = "versionCode";
    public static final String Y = "apkHash";
    public static final String Z = "signature";
    public static final String aA = "diffFile";
    public static final String aB = "diffFileHash";
    public static final String aC = "diffFileSize";
    public static final String aD = "source";
    public static final String aa = "clientId";
    public static final String ab = "sdk";
    public static final String ac = "os";
    public static final String ad = "la";
    public static final String ae = "co";
    public static final String af = "xiaomiSDKVersion";
    public static final String ag = "info";
    public static final String ah = "screenSize";
    public static final String ai = "resolution";
    public static final String aj = "density";
    public static final String ak = "touchScreen";
    public static final String al = "glEsVersion";
    public static final String am = "feature";
    public static final String an = "library";
    public static final String ao = "glExtension";
    public static final String ap = "sdk";
    public static final String aq = "version";
    public static final String ar = "release";
    public static final String as = "imei";
    public static final String at = "fitness";
    public static final String au = "updateLog";
    public static final String av = "versionCode";
    public static final String aw = "versionName";
    public static final String ax = "apk";
    public static final String ay = "apkHash";
    public static final String az = "apkSize";

    public j()
    {
    }

    public static void k()
    {
        if (s.c)
        {
            V = "http://dev.staging.api.developer.n.xiaomi.com/autoupdate/updateself";
            return;
        } else
        {
            V = "http://api.developer.xiaomi.com/autoupdate/updateself";
            return;
        }
    }

}
