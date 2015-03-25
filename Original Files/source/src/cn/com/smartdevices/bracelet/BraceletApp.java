// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.telephony.TelephonyManager;
import cn.com.smartdevices.bracelet.analysis.DataAnalysis;
import cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyleExtractor;
import cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.hm.bleservice.BLEService;
import java.io.File;
import java.util.UUID;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            a, Debug, Keeper, DataManager, 
//            BraceletImageLoader, DaoManager, UmengAnalytics

public class BraceletApp extends Application
{

    public static BLEService BLEService = null;
    private static final String a = "Millelet";
    private static final String b = "BraceletApp";
    private static Context c;
    private ServiceConnection d;

    public BraceletApp()
    {
        d = new a(this);
    }

    public static Context getContext()
    {
        return c;
    }

    public void finishBLEService()
    {
        unbindService(d);
        stopService(new Intent(this, com/xiaomi/hm/bleservice/BLEService));
    }

    public String getStoragePath()
    {
        String s = Environment.getExternalStorageState();
        Debug.i("BraceletApp", (new StringBuilder()).append("ext state =").append(s).toString());
        File file;
        if ("mounted".equals(s))
        {
            file = getExternalFilesDir("Millelet");
        } else
        {
            file = getFilesDir();
        }
        if (file == null)
        {
            file = getFilesDir();
        }
        if (file == null)
        {
            return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append("Millelet").toString();
        } else
        {
            String s1 = file.getPath();
            Debug.i("BraceletApp", (new StringBuilder()).append("getStoragePath:").append(s1).toString());
            return s1;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        Keeper.init(this);
        Debug.enable(Keeper.readDebugFlag(), Keeper.readFileDebugFlag());
        DataAnalysis.DEBUG = Debug.isEnabled();
        DataManager.init(this);
        BraceletImageLoader.init(this);
        DaoManager.init(this);
        WebRes.init(this);
        startBLEService();
        c = this;
        String s = Keeper.readUUID();
        if (s == null || s.length() < 1)
        {
            TelephonyManager telephonymanager = (TelephonyManager)getSystemService("phone");
            String s1 = (new StringBuilder()).append(" ").append(telephonymanager.getDeviceId()).toString();
            String s2 = (new StringBuilder()).append(" ").append(telephonymanager.getSimSerialNumber()).toString();
            String s3 = (new StringBuilder()).append(" ").append(android.provider.Settings.Secure.getString(getContentResolver(), "android_id")).toString();
            String s4 = (new StringBuilder()).append(" ").append(BluetoothAdapter.getDefaultAdapter().getAddress()).toString();
            UUID uuid = new UUID(s4.hashCode() | s3.hashCode(), s1.hashCode() | s2.hashCode());
            Debug.f("BraceletApp", (new StringBuilder()).append("\ndeviceId:").append(s1).append("\nserialNum:").append(s2).append("\nandroidId:").append(s3).append("\nmacAddress:").append(s4).append("\nuuid:").append(uuid.toString()).toString());
            Keeper.keepUUID(uuid.toString());
        }
        TypefaceManager.addTextStyleExtractor(MIUITextStyleExtractor.getInstance());
        UmengAnalytics.config(true, false, false);
    }

    public void startBLEService()
    {
        BLEService = null;
        Intent intent = new Intent(this, com/xiaomi/hm/bleservice/BLEService);
        startService(intent);
        bindService(intent, d, 1);
    }

}
