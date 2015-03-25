// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, SettingFragment

public class SettingActivity extends SystemBarTintActivity
{

    private static final String a = "SettingActivity";

    public SettingActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        SettingFragment settingfragment = (SettingFragment)getFragmentManager().findFragmentByTag(cn/com/smartdevices/bracelet/ui/SettingFragment.getName());
        Debug.i("SettingActivity", (new StringBuilder()).append("setting fragment =").append(settingfragment).toString());
        if (settingfragment != null)
        {
            settingfragment.onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.add(0x1020002, SettingFragment.newInstance(), cn/com/smartdevices/bracelet/ui/SettingFragment.getName());
        fragmenttransaction.commit();
        Debug.i("SettingActivity", "onCreate");
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Debug.i("SettingActivity", "onNewIntent");
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startSession(this);
    }
}
