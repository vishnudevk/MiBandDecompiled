// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            b

public class q
{

    public String aU;
    public String aV;
    public String aW;
    public boolean aX;
    public String packageName;
    public String sourceDir;
    public int versionCode;
    public String versionName;

    private q()
    {
        packageName = "";
        aU = "";
        versionCode = 0;
        versionName = "";
        aV = "";
        sourceDir = "";
        aW = "";
        aX = false;
    }

    public static q h(String s)
    {
        q q1 = new q();
        q1.packageName = s;
        return q1;
    }

    public String n()
    {
        if (TextUtils.isEmpty(sourceDir))
        {
            return null;
        }
        if (TextUtils.isEmpty(aW))
        {
            return b.a(new File(sourceDir));
        } else
        {
            return aW;
        }
    }
}
