// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewGroup;

class aw
{

    private aw()
    {
    }

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        viewgroup.setMotionEventSplittingEnabled(flag);
    }
}
