// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleBindWeixinTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, F, G, E

public class BindWeixinActivityNew extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "BindWeixinActivityNew";
    private static final int b = 0;
    private static final int c = 2;
    private static final int d = 3;
    private Button e;
    private TextView f;
    private Handler g;
    private View h;
    private View i;
    private ImageView j;
    private TextView k;
    private IWXAPI l;

    public BindWeixinActivityNew()
    {
        e = null;
        f = null;
        g = null;
        i = null;
        j = null;
        k = null;
        l = null;
    }

    private void a()
    {
        WebAPI.getWeixinQR(Keeper.readLoginData(), Keeper.readDeviceId(), new F(this));
    }

    static void a(BindWeixinActivityNew bindweixinactivitynew)
    {
        bindweixinactivitynew.a();
    }

    private void b()
    {
        h.setVisibility(8);
        f.setBackgroundResource(0x7f090003);
        i.setBackgroundResource(0x7f090003);
        j.setBackgroundResource(0x7f02001b);
        k.setText(0x7f0d0029);
        e.setVisibility(0);
    }

    static void b(BindWeixinActivityNew bindweixinactivitynew)
    {
        bindweixinactivitynew.g();
    }

    private void c()
    {
        h.setVisibility(0);
        f.setBackgroundResource(0x7f090007);
        i.setBackgroundResource(0x7f090007);
        j.setBackgroundResource(0x7f02001c);
        k.setText(0x7f0d0027);
        e.setVisibility(8);
    }

    static void c(BindWeixinActivityNew bindweixinactivitynew)
    {
        bindweixinactivitynew.d();
    }

    static IWXAPI d(BindWeixinActivityNew bindweixinactivitynew)
    {
        return bindweixinactivitynew.l;
    }

    private void d()
    {
        g.sendEmptyMessage(2);
    }

    private void e()
    {
        g.sendEmptyMessage(3);
    }

    static void e(BindWeixinActivityNew bindweixinactivitynew)
    {
        bindweixinactivitynew.e();
    }

    private void f()
    {
        Utils.showProgressDialog(this, 0x7f0d0028);
    }

    static void f(BindWeixinActivityNew bindweixinactivitynew)
    {
        bindweixinactivitynew.f();
    }

    static Handler g(BindWeixinActivityNew bindweixinactivitynew)
    {
        return bindweixinactivitynew.g;
    }

    private void g()
    {
        Utils.hideProgressDialog(this);
    }

    private void h()
    {
        (new BleBindWeixinTask(new G(this))).work();
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        Debug.i("BindWeixinActivityNew", (new StringBuilder()).append("onBleStatusChanged, status = ").append(connstatus).toString());
        if (connstatus.a == 8)
        {
            b();
            applyStatusBarTintAuto();
        } else
        if (connstatus.a < 8)
        {
            c();
            applyStatusBarTintAuto();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361833: 
        case 2131361834: 
        default:
            return;

        case 2131361832: 
            if (Utils.isNetworkConnected(this))
            {
                h();
            } else
            {
                CustomToast.makeText(this, 0x7f0d010c, 0).show();
            }
            UmengAnalytics.event(this, "BraceletBindWeChat", "BindWeChatQrcode");
            return;

        case 2131361835: 
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        e = (Button)findViewById(0x7f0a0028);
        e.setOnClickListener(this);
        h = findViewById(0x7f0a002a);
        f = (TextView)findViewById(0x7f0a002b);
        f.setOnClickListener(this);
        i = findViewById(0x7f0a002c);
        j = (ImageView)findViewById(0x7f0a002d);
        k = (TextView)findViewById(0x7f0a002f);
        g = new E(this);
        EventBus.getDefault().register(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
        l = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111");
        l.registerApp("wx28e2610e92fbe111");
    }

    protected void onResume()
    {
        super.onResume();
        if (Utils.isBraceletConnected())
        {
            b();
            return;
        } else
        {
            c();
            return;
        }
    }
}
