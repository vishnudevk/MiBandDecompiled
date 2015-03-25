// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.upgrade:
//            UpgradeUtil, NewVersionInfo, OtaVersionInfo

public class UpgradeService extends IntentService
{

    public static final int REQUEST_APP_UPGRADE = 1;
    public static final int REQUEST_FIRMWARE_OTA = 2;
    private static final String a = "UpgradeService";

    public UpgradeService()
    {
        super("UpgradeService");
    }

    private void a()
    {
        NewVersionInfo newversioninfo = UpgradeUtil.getNetVersionInfo(this, UpgradeUtil.getUpgradeURL());
        Debug.i("UpgradeService", (new StringBuilder()).append("VersionInfo : ").append(newversioninfo.toString()).toString());
        int i = UpgradeUtil.getApkVersionCode(this, getPackageName());
        if (i < newversioninfo.getVersionCode())
        {
            Message message = new Message();
            message.what = 263;
            Bundle bundle = new Bundle();
            bundle.putString("ChangeLog", newversioninfo.getChangeLog());
            bundle.putInt("NewVersion", newversioninfo.getVersionCode());
            String s = new String();
            if (i < newversioninfo.getVersionCode())
            {
                s = newversioninfo.getFileUrl();
            }
            bundle.putString("DownUrl", s);
            message.setData(bundle);
        }
    }

    private void b()
    {
        OtaVersionInfo otaversioninfo = UpgradeUtil.getOtaVersionInfo(this, UpgradeUtil.getOtaUrl());
        Debug.e("DDDD", (new StringBuilder()).append("OTAInfo : ").append(otaversioninfo).toString());
        if (cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity.SettingFirmwareFragment.mHandler != null)
        {
            Message message = new Message();
            message.what = 1;
            message.obj = otaversioninfo;
            cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity.SettingFirmwareFragment.mHandler.sendMessage(message);
        }
    }

    public static boolean checkFirmwareUpgradeState(OtaVersionInfo otaversioninfo, com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo)
    {
        Debug.e("DDDD", (new StringBuilder()).append("DeviceInfo : ").append(deviceinfo).toString());
        String s = (new StringBuilder()).append(deviceinfo.getFirmwareVersionMajor()).append(".").append(deviceinfo.getFirmwareVersionMinor()).append(deviceinfo.getFirmwareVersionRevision()).append(deviceinfo.getFirmwareVersionBuild()).toString();
        Debug.e("DDDD", (new StringBuilder()).append("DeviceFirmwareVersionCode : ").append(s).toString());
        int i = otaversioninfo.firmwareVersionCode != Float.valueOf(s).floatValue();
        boolean flag = false;
        if (i > 0)
        {
            Debug.e("DDDD", (new StringBuilder()).append("Need Upgrade Firmware : ").append(Float.valueOf(s)).append(" , ").append(otaversioninfo.firmwareVersionCode).toString());
            flag = true;
        }
        return flag;
    }

    public static void start(Context context, int i)
    {
        Intent intent = new Intent(context, cn/com/smartdevices/bracelet/upgrade/UpgradeService);
        intent.putExtra("Request", i);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        switch (intent.getIntExtra("Request", 0))
        {
        default:
            return;

        case 1: // '\001'
            a();
            return;

        case 2: // '\002'
            b();
            break;
        }
    }
}
