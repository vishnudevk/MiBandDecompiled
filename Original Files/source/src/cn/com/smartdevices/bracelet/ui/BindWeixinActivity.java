// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleBindWeixinTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, A, B, C, 
//            D, z

public class BindWeixinActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 500;
    private static final int h = 500;
    private static final int i = 1;
    private static final int j = 0;
    private static final String k = "BindWeixinActivity";
    private Button l;
    private TextView m;
    private Handler n;
    private String o;
    private MediaScannerConnection p;
    private String q;
    private Button r;
    private View s;

    public BindWeixinActivity()
    {
        l = null;
        m = null;
        n = null;
        o = "";
        p = null;
        q = null;
    }

    private Intent a(String s1)
    {
        return getPackageManager().getLaunchIntentForPackage(s1);
    }

    static String a(BindWeixinActivity bindweixinactivity, String s1)
    {
        bindweixinactivity.o = s1;
        return s1;
    }

    private void a()
    {
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111");
        iwxapi.registerApp("wx28e2610e92fbe111");
        if (iwxapi.isWXAppInstalled())
        {
            iwxapi.openWXApp();
        }
    }

    private void a(int i1)
    {
        if (i1 == 1)
        {
            a(l, false);
            a(r, true);
        } else
        {
            a(l, true);
            a(r, false);
        }
        if (a("com.tencent.mm") == null)
        {
            a(r, false);
            r.setText(0x7f0d0186);
        }
    }

    private void a(Button button, boolean flag)
    {
        button.setEnabled(flag);
        if (flag)
        {
            button.setTextColor(getResources().getColor(0x7f090036));
            return;
        } else
        {
            button.setTextColor(getResources().getColor(0x7f090020));
            return;
        }
    }

    static void a(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.e();
    }

    static void a(BindWeixinActivity bindweixinactivity, int i1)
    {
        bindweixinactivity.a(i1);
    }

    private void b()
    {
        (new BleBindWeixinTask(new A(this))).work();
    }

    static void b(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.f();
    }

    static boolean b(BindWeixinActivity bindweixinactivity, String s1)
    {
        return bindweixinactivity.b(s1);
    }

    private boolean b(String s1)
    {
        BitMatrix bitmatrix;
        int ai[];
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
        bitmatrix = (new QRCodeWriter()).encode(s1, BarcodeFormat.QR_CODE, 500, 500, hashtable);
        ai = new int[0x3d090];
        int i1 = 0;
          goto _L1
_L11:
        int j1;
        if (j1 >= 500) goto _L3; else goto _L2
_L2:
        if (!bitmatrix.get(j1, i1)) goto _L5; else goto _L4
_L4:
        ai[j1 + i1 * 500] = 0xff000000;
          goto _L6
_L5:
        ai[j1 + i1 * 500] = -1;
          goto _L6
        Exception exception;
        exception;
        Exception exception1;
        boolean flag;
        exception1 = exception;
        flag = false;
_L7:
        exception1.printStackTrace();
        return flag;
_L3:
        i1++;
          goto _L1
_L9:
        FileOutputStream fileoutputstream;
        boolean flag1;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.setPixels(ai, 0, 500, 0, 0, 500, 500);
        fileoutputstream = new FileOutputStream(new File(q));
        flag1 = bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
        flag = flag1;
        fileoutputstream.close();
        return flag;
        exception1;
          goto _L7
_L1:
        if (i1 >= 500) goto _L9; else goto _L8
_L8:
        j1 = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        j1++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void c()
    {
        n.sendEmptyMessage(2);
    }

    static void c(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.i();
    }

    private void d()
    {
        n.sendEmptyMessage(3);
    }

    static void d(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.g();
    }

    static Button e(BindWeixinActivity bindweixinactivity)
    {
        return bindweixinactivity.l;
    }

    private void e()
    {
        WebAPI.getWeixinQR(Keeper.readLoginData(), Keeper.readDeviceId(), new B(this));
    }

    private void f()
    {
        (new Thread(new C(this))).start();
    }

    static void f(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.a();
    }

    private void g()
    {
        if (p != null && p.isConnected())
        {
            p.disconnect();
        }
        p = new MediaScannerConnection(this, new D(this));
        p.connect();
    }

    static void g(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.h();
    }

    static Handler h(BindWeixinActivity bindweixinactivity)
    {
        return bindweixinactivity.n;
    }

    private void h()
    {
        Utils.showProgressDialog(this, 0x7f0d002a);
    }

    private void i()
    {
        Utils.hideProgressDialog(this);
    }

    static void i(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.c();
    }

    static String j(BindWeixinActivity bindweixinactivity)
    {
        return bindweixinactivity.o;
    }

    static void k(BindWeixinActivity bindweixinactivity)
    {
        bindweixinactivity.d();
    }

    static String l(BindWeixinActivity bindweixinactivity)
    {
        return bindweixinactivity.q;
    }

    static MediaScannerConnection m(BindWeixinActivity bindweixinactivity)
    {
        return bindweixinactivity.p;
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        Debug.i("BindWeixinActivity", (new StringBuilder()).append("onBleStatusChanged, status = ").append(connstatus).toString());
        if (connstatus.a == 8)
        {
            s.setVisibility(8);
        } else
        if (connstatus.a < 8)
        {
            s.setVisibility(0);
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361829: 
        case 2131361830: 
        case 2131361831: 
        default:
            return;

        case 2131361833: 
            if (Utils.isNetworkConnected(this))
            {
                b();
            } else
            {
                CustomToast.makeText(this, 0x7f0d010c, 0).show();
            }
            UmengAnalytics.event(this, "BraceletBindWeChat", "BindWeChatQrcode");
            return;

        case 2131361832: 
            a();
            UmengAnalytics.event(this, "BraceletBindWeChat", "BindWeChatLaunch");
            return;

        case 2131361828: 
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(getString(0x7f0d001a)).toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        q = (new StringBuilder()).append(file.getAbsolutePath()).append("/").append(getString(0x7f0d002b)).append(".jpg").toString();
        l = (Button)findViewById(0x7f0a0029);
        l.setOnClickListener(this);
        r = (Button)findViewById(0x7f0a0028);
        r.setOnClickListener(this);
        s = findViewById(0x7f0a002a);
        m = (TextView)findViewById(0x7f0a0024);
        m.setOnClickListener(this);
        n = new z(this);
        a(0);
        EventBus.getDefault().register(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (p != null && p.isConnected())
        {
            p.disconnect();
        }
        n.removeCallbacksAndMessages(null);
        n = null;
        EventBus.getDefault().unregister(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBindWeChat");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBindWeChat");
        UmengAnalytics.startSession(this);
    }
}
