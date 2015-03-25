// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;

class bH
    implements android.view.View.OnClickListener
{

    final SettingFirmwareActivity.SettingFirmwareFragment a;

    bH(SettingFirmwareActivity.SettingFirmwareFragment settingfirmwarefragment)
    {
        a = settingfirmwarefragment;
        super();
    }

    public void onClick(View view)
    {
        SettingFirmwareActivity.SettingFirmwareFragment.a(a, SettingFirmwareActivity.SettingFirmwareFragment.a(a));
    }
}
