// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.view.View;

class e
{

    e()
    {
    }

    public static void a(View view, Drawable drawable)
    {
        view.setBackground(drawable);
    }

    public static void a(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }
}
