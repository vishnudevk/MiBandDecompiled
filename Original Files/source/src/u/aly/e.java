// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.telephony.TelephonyManager;

// Referenced classes of package u.aly:
//            a, bi

public class e extends a
{

    private static final String a = "imei";
    private Context b;

    public e(Context context)
    {
        super("imei");
        b = context;
    }

    public String f()
    {
label0:
        {
            TelephonyManager telephonymanager = (TelephonyManager)b.getSystemService("phone");
            if (telephonymanager != null);
            String s;
            try
            {
                if (!bi.a(b, "android.permission.READ_PHONE_STATE"))
                {
                    break label0;
                }
                s = telephonymanager.getDeviceId();
            }
            catch (Exception exception)
            {
                return null;
            }
            return s;
        }
        return null;
    }
}
