// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicFragment

class ac extends Handler
{

    final DynamicFragment a;

    ac(DynamicFragment dynamicfragment)
    {
        a = dynamicfragment;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 4116: 
        case 4117: 
        case 4118: 
        default:
            return;

        case 4113: 
            DynamicFragment.a(a, "\u52A0\u8F7D\u8FD0\u52A8\u6570\u636E", "\u6B63\u5728\u52A0\u8F7D\u8FD0\u52A8\u6570\u636E\uFF0C\u8BF7\u7A0D\u5019...");
            return;

        case 4114: 
            DynamicFragment.c(a);
            Debug.i("DDDD", "Dynamic Update : Data Loaded,Prev/Next Day,Animation");
            DynamicFragment.a(a, false);
            return;

        case 4115: 
            if (DynamicFragment.d(a) != message.arg1)
            {
                UmengAnalytics.event(a.getActivity(), "DynamicRealStepUpdate");
            }
            DynamicFragment.c(a, message.arg1);
            Keeper.keepSyncRealStepTime(System.currentTimeMillis());
            Keeper.keepRealtimeSteps(DynamicFragment.d(a));
            Debug.i("DDDD", "Dynamic Update : Real Steps.");
            DynamicFragment.a(a, true);
            return;

        case 4119: 
            DynamicFragment.e(a);
            return;

        case 4120: 
            DynamicFragment.f(a);
            return;

        case 4121: 
            DynamicFragment.g(a);
            return;
        }
    }
}
