// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BraceletSettingsFragment

class H extends Handler
{

    final BraceletSettingsFragment a;

    H(BraceletSettingsFragment braceletsettingsfragment)
    {
        a = braceletsettingsfragment;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 4098: 
            BraceletSettingsFragment.a(a);
            break;
        }
    }
}
