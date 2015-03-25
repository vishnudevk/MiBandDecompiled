// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.b;

import android.content.Context;
import java.io.File;

public final class a
{

    private static Context a;

    public a()
    {
    }

    public static final Context a()
    {
        if (a == null)
        {
            return null;
        } else
        {
            return a;
        }
    }

    public static final void a(Context context)
    {
        a = context;
    }

    public static final String b()
    {
        return a().getPackageName();
    }

    public static final File c()
    {
        return a().getFilesDir();
    }
}
