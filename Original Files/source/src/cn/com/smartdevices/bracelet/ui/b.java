// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            AlarmActivity

class b extends BroadcastReceiver
{

    final AlarmActivity a;

    b(AlarmActivity alarmactivity)
    {
        a = alarmactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        Debug.i("AlarmActivity", (new StringBuilder()).append("Receive: ").append(intent.getAction()).toString());
        a.checkOnceAlarmIfExpired();
    }
}
