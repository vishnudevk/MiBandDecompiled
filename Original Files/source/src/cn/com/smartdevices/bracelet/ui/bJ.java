// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;

class bJ
    implements android.content.DialogInterface.OnClickListener
{

    final String a;
    final SettingFirmwareActivity.SettingFirmwareFragment b;

    bJ(SettingFirmwareActivity.SettingFirmwareFragment settingfirmwarefragment, String s)
    {
        b = settingfirmwarefragment;
        a = s;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        SettingFirmwareActivity.SettingFirmwareFragment.a(b, braceletbtinfo.address, a);
        dialoginterface.dismiss();
    }
}
