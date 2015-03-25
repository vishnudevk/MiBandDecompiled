// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class c
{

    public c()
    {
    }

    public static int a(Context context, float f)
    {
        return (int)(0.5F + f * context.getResources().getDisplayMetrics().density);
    }
}
