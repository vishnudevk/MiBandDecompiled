// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;

class bA
    implements android.content.DialogInterface.OnClickListener
{

    final SettingAboutActivity.SettingAboutFragment a;

    bA(SettingAboutActivity.SettingAboutFragment settingaboutfragment)
    {
        a = settingaboutfragment;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SettingAboutActivity.SettingAboutFragment.c(a);
        dialoginterface.dismiss();
    }
}
