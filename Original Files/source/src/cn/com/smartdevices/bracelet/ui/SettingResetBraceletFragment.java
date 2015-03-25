// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import cn.com.smartdevices.bracelet.BleTask.BleResetTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, bU

public class SettingResetBraceletFragment extends DimPanelFragment
{

    private Activity a;
    private ProgressDialog b;

    public SettingResetBraceletFragment()
    {
        b = null;
    }

    static ProgressDialog a(SettingResetBraceletFragment settingresetbraceletfragment)
    {
        return settingresetbraceletfragment.b;
    }

    static ProgressDialog a(SettingResetBraceletFragment settingresetbraceletfragment, ProgressDialog progressdialog)
    {
        settingresetbraceletfragment.b = progressdialog;
        return progressdialog;
    }

    private void a()
    {
        (new BleResetTask(new bU(this))).work();
    }

    static Activity b(SettingResetBraceletFragment settingresetbraceletfragment)
    {
        return settingresetbraceletfragment.a;
    }

    protected int inflateLayout()
    {
        a = getActivity();
        Debug.i(getTag(), (new StringBuilder()).append("mContext = ").append(a).toString());
        return 0x7f030046;
    }

    protected void onLeftButtonClicked()
    {
        MiLiProfile miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
        if (miliprofile == null)
        {
            dismiss();
            return;
        } else
        {
            miliprofile.setAutoReconnect(false);
            a();
            mRightButton.setEnabled(false);
            return;
        }
    }

    protected void onRightButtomClicked()
    {
        dismiss();
    }
}
