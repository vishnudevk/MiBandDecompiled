// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, UnlockScreenInvalidHelperActivity

public class UnlockScreenHelperActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final int a = 0;
    private static final int b = 1;
    private static final String c = "unlockscreen";
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private LinearLayout j;
    private TextView k;
    private View l;
    private TextView m;
    private FrameLayout n;
    private TextView o;

    public UnlockScreenHelperActivity()
    {
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
    }

    private void a()
    {
        boolean flag = b();
        if (flag)
        {
            d.setEnabled(false);
            g.setText(getString(0x7f0d01d5));
            h.setTextColor(getResources().getColor(0x7f090020));
            e.setEnabled(true);
            f.setTextColor(getResources().getColor(0x7f090039));
        } else
        {
            d.setEnabled(true);
            g.setText(getString(0x7f0d01d6));
            h.setTextColor(getResources().getColor(0x7f090039));
            e.setEnabled(false);
            f.setTextColor(getResources().getColor(0x7f090020));
        }
        if (flag && c())
        {
            k.setVisibility(8);
            j.setVisibility(8);
            i.setVisibility(0);
        } else
        {
            if (!d())
            {
                k.setVisibility(8);
                j.setVisibility(8);
                i.setVisibility(8);
                n.setBackgroundColor(getResources().getColor(0x7f090007));
                o.setVisibility(0);
                return;
            }
            k.setVisibility(0);
            j.setVisibility(0);
            i.setVisibility(8);
            n.setBackgroundColor(getResources().getColor(0x7f090003));
            o.setVisibility(8);
            if (!Utils.isBraceletConnected())
            {
                l.setVisibility(0);
                return;
            }
        }
    }

    private void a(int i1)
    {
        Intent intent = new Intent();
        if (i1 == 1)
        {
            intent.putExtra("android.bluetooth.device.extra.NAME", Keeper.readBraceletBtInfo().address);
        }
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.MiuiSecurityBluetoothSettings"));
        startActivity(intent);
    }

    private boolean b()
    {
        return ((KeyguardManager)getSystemService("keyguard")).isKeyguardSecure();
    }

    private boolean c()
    {
        int j1 = android.provider.Settings.Secure.getInt(getContentResolver(), "bluetooth_unlock_status");
        int i1 = j1;
        String s = android.provider.Settings.Secure.getString(getContentResolver(), "bluetooth_address_to_unlock");
        Debug.i("unlockscreen", (new StringBuilder()).append("isUseUnlock:").append(i1).append(",isUseUnlock:").append(s).toString());
_L1:
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        return i1 == 1;
        settingnotfoundexception;
        i1 = 0;
_L2:
        settingnotfoundexception.printStackTrace();
          goto _L1
        settingnotfoundexception;
          goto _L2
    }

    private boolean d()
    {
        return Utils.isSupportMiuiUnlock(this);
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        if (connstatus.a >= 8)
        {
            l.setVisibility(8);
            n.setBackgroundColor(getResources().getColor(0x7f090003));
            applyStatusBarTintAuto();
        } else
        if (!b() || !c())
        {
            l.setVisibility(0);
            n.setBackgroundColor(getResources().getColor(0x7f090007));
            applyStatusBarTintAuto();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361928: 
            a(1);
            return;

        case 2131361922: 
            finish();
            return;

        case 2131361926: 
            a(0);
            return;

        case 2131361931: 
            startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/UnlockScreenInvalidHelperActivity));
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030012);
        d = findViewById(0x7f0a0086);
        d.setOnClickListener(this);
        e = findViewById(0x7f0a0088);
        e.setOnClickListener(this);
        f = (TextView)findViewById(0x7f0a0089);
        ((TextView)findViewById(0x7f0a0082)).setOnClickListener(this);
        i = (LinearLayout)findViewById(0x7f0a008a);
        j = (LinearLayout)findViewById(0x7f0a0084);
        l = findViewById(0x7f0a008c);
        k = (TextView)findViewById(0x7f0a0083);
        m = (TextView)findViewById(0x7f0a008b);
        int i1 = m.getPaint().getFlags();
        m.getPaint().setFlags(i1 | 8);
        m.setOnClickListener(this);
        g = (TextView)findViewById(0x7f0a0085);
        h = (TextView)findViewById(0x7f0a0087);
        n = (FrameLayout)findViewById(0x7f0a0081);
        o = (TextView)findViewById(0x7f0a008d);
        EventBus.getDefault().registerSticky(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (Utils.isUseUnlockByBracelet(this))
        {
            UmengAnalytics.event(this, "BraceletUnlockSetting", "ON");
            return;
        } else
        {
            UmengAnalytics.event(this, "BraceletUnlockSetting", "OFF");
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageUnlockHelp");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        a();
        UmengAnalytics.startPage("PageUnlockHelp");
        UmengAnalytics.startSession(this);
    }
}
