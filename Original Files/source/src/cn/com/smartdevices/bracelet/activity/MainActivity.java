// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity, SystemLowActivity, SystemNotSupportActivity

public class MainActivity extends Activity
{

    private static final String a = "MainActivity";
    private static final int b = 16;

    public MainActivity()
    {
    }

    private void a()
    {
        Intent intent = new Intent();
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        LoginData logindata = Keeper.readLoginData();
        PersonInfo personinfo = Keeper.readPersonInfoBase();
        if (Debug.isEnabled())
        {
            Debug.i("MainActivity", (new StringBuilder()).append("MainActivity onCreate, Person:").append(personinfo).append(", login: ").append(logindata).toString());
        }
        if (logindata == null || !logindata.isValid())
        {
            intent.setClass(this, cn/com/smartdevices/bracelet/activity/LoginActivity);
        } else
        if (personinfo == null || !personinfo.isValid())
        {
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetGenderActivity);
        } else
        if ((braceletbtinfo == null || !BluetoothAdapter.checkBluetoothAddress(braceletbtinfo.address)) && Keeper.readNeedBind() == 1)
        {
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
        } else
        {
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/MainUIActivity);
            Bundle bundle = getIntent().getExtras();
            if (bundle != null)
            {
                intent.putExtras(bundle);
                Debug.i("MainActivity", (new StringBuilder()).append("extras is :").append(bundle).toString());
            } else
            {
                Debug.i("MainActivity", "extras is null!");
            }
        }
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 16)
        {
            a();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
label0:
        {
            super.onCreate(bundle);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            Debug.i("MainActivity", (new StringBuilder()).append("Screen metrics =").append(displaymetrics).toString());
            intent = new Intent();
            if (android.os.Build.VERSION.SDK_INT == 18)
            {
                LoginData logindata = Keeper.readLoginData();
                if (logindata == null || !logindata.isValid())
                {
                    intent.setClass(this, cn/com/smartdevices/bracelet/activity/SystemLowActivity);
                    startActivityForResult(intent, 16);
                    return;
                }
            } else
            if (android.os.Build.VERSION.SDK_INT < 18 && (!Utils.isSupportBle(this) || !Utils.checkDeviceCompatible()))
            {
                break label0;
            }
            a();
            return;
        }
        intent.setClass(this, cn/com/smartdevices/bracelet/activity/SystemNotSupportActivity);
        startActivity(intent);
        finish();
    }
}
