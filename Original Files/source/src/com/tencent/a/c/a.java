// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.c;

import java.io.File;

public class a
{

    public a()
    {
    }

    public static boolean a(File file)
    {
        int i = 0;
        if (file == null) goto _L2; else goto _L1
_L1:
        if (!file.isFile()) goto _L4; else goto _L3
_L3:
        if (file.delete()) goto _L6; else goto _L5
_L5:
        file.deleteOnExit();
_L2:
        return false;
_L6:
        return true;
_L4:
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            for (int j = afile.length; i < j; i++)
            {
                a(afile[i]);
            }

            return file.delete();
        }
        if (true) goto _L2; else goto _L7
_L7:
    }
}
