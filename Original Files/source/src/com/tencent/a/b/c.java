// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.b;

import android.os.Environment;

// Referenced classes of package com.tencent.a.b:
//            d

public class c
{

    public c()
    {
    }

    public static boolean a()
    {
        String s = Environment.getExternalStorageState();
        return "mounted".equals(s) || "mounted_ro".equals(s);
    }

    public static d b()
    {
        if (!a())
        {
            return null;
        } else
        {
            return d.b(Environment.getExternalStorageDirectory());
        }
    }
}
