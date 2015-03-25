// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingFragment, bN

class bT extends AsyncTask
{

    final SettingFragment a;

    private bT(SettingFragment settingfragment)
    {
        a = settingfragment;
        super();
    }

    bT(SettingFragment settingfragment, bN bn)
    {
        this(settingfragment);
    }

    protected transient String a(String as[])
    {
        MiLiProfile miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
        int i = 0;
        do
        {
label0:
            {
                if (i < 10)
                {
                    if (!isCancelled())
                    {
                        break label0;
                    }
                    Debug.i("SettingFragment", "ShowOffNofifyTask isCancelled");
                }
                return null;
            }
            miliprofile._sendNotification((byte)0);
            Debug.i("SettingFragment", (new StringBuilder()).append("vibrate : ").append(i).toString());
            try
            {
                Thread.sleep(3000L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            i++;
        } while (true);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }
}
