// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.view.RoundProgressBar;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.io.InputStream;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            at, am, an, ao, 
//            ap, aq, ar, al

public class FwUpgradeActivity extends Activity
{

    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 1000;
    private static String e = "FwUpgradeActivity";
    private Context d;
    private Handler f;
    private boolean g;
    private TextView h;
    private RoundProgressBar i;
    private TextView j;
    private TextView k;
    private BluetoothDevice l;
    private int m;
    private Animator n;

    public FwUpgradeActivity()
    {
        d = null;
        f = null;
        g = false;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = 0;
    }

    static BluetoothDevice a(FwUpgradeActivity fwupgradeactivity, BluetoothDevice bluetoothdevice)
    {
        fwupgradeactivity.l = bluetoothdevice;
        return bluetoothdevice;
    }

    static String a()
    {
        return e;
    }

    private void a(int i1, int j1)
    {
        if (n != null && n.isStarted())
        {
            n.end();
        }
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            i1, j1
        });
        valueanimator.addUpdateListener(new at(this));
        valueanimator.setDuration(1000L);
        valueanimator.start();
        n = valueanimator;
    }

    static void a(FwUpgradeActivity fwupgradeactivity)
    {
        fwupgradeactivity.f();
    }

    static boolean a(FwUpgradeActivity fwupgradeactivity, boolean flag)
    {
        fwupgradeactivity.g = flag;
        return flag;
    }

    static Handler b(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.f;
    }

    private void b()
    {
        getWindow().addFlags(128);
    }

    static Context c(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.d;
    }

    private void c()
    {
        getWindow().clearFlags(128);
    }

    private void d()
    {
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        byte abyte0[];
        try
        {
            InputStream inputstream = getResources().getAssets().open("Mili.fw");
            Debug.i(e, (new StringBuilder()).append("new fw length:").append(inputstream.available()).toString());
            abyte0 = new byte[inputstream.available()];
            inputstream.read(abyte0);
            inputstream.close();
        }
        catch (Exception exception)
        {
            Debug.i(e, exception.getMessage());
            return;
        }
        (new BleFwUpgradeTask(braceletbtinfo.address, abyte0, new am(this))).work();
    }

    static void d(FwUpgradeActivity fwupgradeactivity)
    {
        fwupgradeactivity.e();
    }

    private void e()
    {
        CustomToast.makeText(d, getString(0x7f0d00b1), 0).show();
        finish();
    }

    static void e(FwUpgradeActivity fwupgradeactivity)
    {
        fwupgradeactivity.d();
    }

    static RoundProgressBar f(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.i;
    }

    private void f()
    {
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress progress = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getFirmwareUpdatingProgress();
        int i1;
        if (progress.total == -1)
        {
            m = 0;
            i.setMax(100);
            i1 = 0;
        } else
        if (progress.total == 0)
        {
            m = 100;
            i.setMax(100);
            i1 = 100;
        } else
        {
            i1 = progress.progress;
            i.setMax(progress.total);
        }
        a(m, i1);
        m = i1;
        if (!g && f != null)
        {
            f.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    static TextView g(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.j;
    }

    static TextView h(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.k;
    }

    static TextView i(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.h;
    }

    static BluetoothDevice j(FwUpgradeActivity fwupgradeactivity)
    {
        return fwupgradeactivity.l;
    }

    public void enterAnimation()
    {
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f040001);
        Animation animation1 = AnimationUtils.loadAnimation(this, 0x7f040001);
        Animation animation2 = AnimationUtils.loadAnimation(this, 0x7f040001);
        Animation animation3 = AnimationUtils.loadAnimation(this, 0x7f040001);
        animation.setStartOffset(0L);
        animation1.setStartOffset(100L);
        animation2.setStartOffset(150L);
        animation3.setStartOffset(200L);
        animation3.setAnimationListener(new an(this));
        DecelerateInterpolator decelerateinterpolator = new DecelerateInterpolator(2.0F);
        animation.setInterpolator(decelerateinterpolator);
        animation1.setInterpolator(decelerateinterpolator);
        animation2.setInterpolator(decelerateinterpolator);
        animation3.setInterpolator(decelerateinterpolator);
        i.startAnimation(animation);
        j.startAnimation(animation1);
        k.startAnimation(animation2);
        h.startAnimation(animation3);
    }

    public void finishAnimation()
    {
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f040002);
        Animation animation1 = AnimationUtils.loadAnimation(this, 0x7f040002);
        Animation animation2 = AnimationUtils.loadAnimation(this, 0x7f040002);
        Animation animation3 = AnimationUtils.loadAnimation(this, 0x7f040002);
        animation.setStartOffset(0L);
        animation3.setStartOffset(100L);
        animation2.setStartOffset(150L);
        animation1.setStartOffset(200L);
        animation.setAnimationListener(new ao(this));
        animation1.setAnimationListener(new ap(this));
        animation2.setAnimationListener(new aq(this));
        animation3.setAnimationListener(new ar(this));
        AccelerateInterpolator accelerateinterpolator = new AccelerateInterpolator(2.0F);
        animation.setInterpolator(accelerateinterpolator);
        animation1.setInterpolator(accelerateinterpolator);
        animation2.setInterpolator(accelerateinterpolator);
        animation3.setInterpolator(accelerateinterpolator);
        i.startAnimation(animation);
        j.startAnimation(animation1);
        k.startAnimation(animation2);
        h.startAnimation(animation3);
    }

    public void onBackPressed()
    {
        if (g)
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.i(e, "in onCreate");
        d = this;
        setContentView(0x7f03002c);
        j = (TextView)findViewById(0x7f0a00d9);
        k = (TextView)findViewById(0x7f0a00da);
        h = (TextView)findViewById(0x7f0a00dc);
        i = (RoundProgressBar)findViewById(0x7f0a00db);
        f = new al(this);
        b();
        enterAnimation();
    }

    protected void onDestroy()
    {
        Debug.i(e, "in onDestroy");
        super.onDestroy();
        f.removeCallbacksAndMessages(null);
        f = null;
        c();
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageFirmwareUpgrade");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startSession(this);
        UmengAnalytics.startPage("PageFirmwareUpgrade");
    }

}
