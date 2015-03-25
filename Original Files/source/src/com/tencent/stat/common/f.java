// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import java.io.File;

class f
{

    private static int a = -1;

    public static boolean a()
    {
        String as[];
        int i;
        if (a == 1)
        {
            return true;
        }
        if (a == 0)
        {
            return false;
        }
        as = (new String[] {
            "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"
        });
        i = 0;
_L2:
        File file;
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        file = new File((new StringBuilder()).append(as[i]).append("su").toString());
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        a = 1;
        return true;
        Exception exception;
        exception;
        a = 0;
        return false;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
