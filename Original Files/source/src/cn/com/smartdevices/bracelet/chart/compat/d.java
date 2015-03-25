// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.compat;

import android.view.View;

final class d
    implements Runnable
{

    final View a;

    d(View view)
    {
        a = view;
        super();
    }

    public void run()
    {
        a.invalidate();
    }
}
