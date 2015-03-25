// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug, d, Keeper, UmengAnalytics

public class PhoneStateReceiver extends BroadcastReceiver
{

    private static final String a = "PhoneState";
    private static Timer b = null;
    private static TimerTask c = null;

    public PhoneStateReceiver()
    {
    }

    private static void a()
    {
        Debug.i("PhoneState", "in stopTimerTask");
        if (b != null)
        {
            Debug.i("PhoneState", "cancel timer...");
            b.cancel();
            b.purge();
            b = null;
        }
        if (c != null)
        {
            Debug.i("PhoneState", "canel task...");
            c.cancel();
            c = null;
        }
    }

    private static void a(Context context, int i)
    {
        Debug.i("PhoneState", "in startTimerTask");
        WeakReference weakreference = new WeakReference(context);
        b = new Timer();
        c = new d(weakreference);
        b.schedule(c, i);
    }

    public void onReceive(Context context, Intent intent)
    {
        PersonInfo personinfo = Keeper.readPersonInfo();
        if (!personinfo.isInComingCallEnabled())
        {
            return;
        }
        switch (((TelephonyManager)context.getSystemService("phone")).getCallState())
        {
        default:
            return;

        case 0: // '\0'
            Debug.i("PhoneState", "incoming IDLE");
            UmengAnalytics.event(context, "IncomingCall", "CallIdle");
            a();
            return;

        case 1: // '\001'
            Debug.i("PhoneState", (new StringBuilder()).append("RINGING :").append(intent.getStringExtra("incoming_number")).toString());
            UmengAnalytics.event(context, "IncomingCall", "CallRing");
            a(context, 1000 * personinfo.getInComingCallTime());
            return;

        case 2: // '\002'
            Debug.i("PhoneState", (new StringBuilder()).append("incoming ACCEPT :").append(intent.getStringExtra("incoming_number")).toString());
            break;
        }
        UmengAnalytics.event(context, "IncomingCall", "CallOffhook");
        a();
    }

}
