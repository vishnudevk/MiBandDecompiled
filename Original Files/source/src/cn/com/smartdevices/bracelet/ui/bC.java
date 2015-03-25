// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


class bC
    implements Runnable
{

    final SettingAboutActivity.SettingAboutFragment a;

    bC(SettingAboutActivity.SettingAboutFragment settingaboutfragment)
    {
        a = settingaboutfragment;
        super();
    }

    public void run()
    {
        SettingAboutActivity.SettingAboutFragment.d(a);
    }
}
