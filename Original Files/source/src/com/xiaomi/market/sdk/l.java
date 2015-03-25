// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;


// Referenced classes of package com.xiaomi.market.sdk:
//            k

public final class l
    implements k
{

    public static final String aA = "diff_url";
    public static final String aB = "diff_hash";
    public static final String aE = "update_download";
    public static final String aF = "package_name";
    public static final String aG = "download_id";
    public static final String aH = "apk_path";
    public static final String aI = "CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));";
    public static final String aJ[] = {
        "update_download.package_name", "update_download.download_id", "update_download.version_code", "update_download.apk_url", "update_download.apk_hash", "update_download.diff_url", "update_download.diff_hash", "update_download.apk_path"
    };
    public static final String av = "version_code";
    public static final String ax = "apk_url";
    public static final String ay = "apk_hash";

    public l()
    {
    }

}
