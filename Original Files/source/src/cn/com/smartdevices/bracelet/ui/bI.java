// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;

class bI extends Handler
{

    final SettingFirmwareActivity.SettingFirmwareFragment a;

    bI(SettingFirmwareActivity.SettingFirmwareFragment settingfirmwarefragment)
    {
        a = settingfirmwarefragment;
        super();
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            SettingFirmwareActivity.SettingFirmwareFragment.b(a, (OtaVersionInfo)message.obj);
            SettingFirmwareActivity.SettingFirmwareFragment.c(a, SettingFirmwareActivity.SettingFirmwareFragment.a(a));
            return;

        case 4098: 
            SettingFirmwareActivity.SettingFirmwareFragment.b(a);
            break;
        }
    }
}
