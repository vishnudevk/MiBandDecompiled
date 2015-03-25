// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.DataManager;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicFragment

class ad
    implements Runnable
{

    final int a;
    final int b;
    final DynamicFragment c;

    ad(DynamicFragment dynamicfragment, int i, int j)
    {
        c = dynamicfragment;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        DynamicFragment.h(c).load(a, b);
        DynamicFragment.mHandler.sendEmptyMessage(4114);
    }
}
