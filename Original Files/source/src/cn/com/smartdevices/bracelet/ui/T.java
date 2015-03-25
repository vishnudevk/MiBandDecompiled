// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicDetailFragment

class T
    implements Runnable
{

    final View a;
    final DynamicDetailFragment b;

    T(DynamicDetailFragment dynamicdetailfragment, View view)
    {
        b = dynamicdetailfragment;
        a = view;
        super();
    }

    public void run()
    {
        DynamicDetailFragment.a(b, a, DynamicDetailFragment.i(b));
    }
}
