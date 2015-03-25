// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleTogglePairTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.BraceletNotFoundActivity;
import cn.com.smartdevices.bracelet.activity.MultiBraceletErrActivity;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.hm.view.GifImageType;
import com.xiaomi.hm.view.GifView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseBleActivity, bv, bq, bs, 
//            br, MainUIActivity, bu, bw, 
//            bt

public class SearchSingleBraceletActivity extends BaseBleActivity
    implements android.view.View.OnClickListener
{

    public static final long CONNECT_TIME_OUT = 60000L;
    public static final int MSG_DEVICE_CONNECTION_FAILED = 4115;
    public static final int NEED_EXIT = 1;
    public static final int NEED_RESEARCH = 0;
    public static final String REF_NOT_KNOCKED = "REF_NOT_KNOCKED";
    private static final String a = "SearchSingleBraceletActivity";
    private static final int b = 2000;
    private static final int f = 4103;
    private static final int g = 4117;
    private static Handler h = null;
    private static final long p = 10000L;
    private static final long q = 1000L;
    private static final int r = 60000;
    private boolean A;
    private boolean B;
    private LinePieChartView C;
    private ImageView D;
    private boolean E;
    private ImageButton F;
    private View G;
    private boolean H;
    private final int c = 8193;
    private final int d = 4097;
    private final int e = 4100;
    private ListView i;
    private ArrayList j;
    private bv k;
    private Context l;
    private int m;
    public boolean mDevMode;
    private final int n = 3;
    private BluetoothDevice o;
    private bu s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private View x;
    private BraceletBtInfo y;
    private GifView z;

    public SearchSingleBraceletActivity()
    {
        mDevMode = false;
        i = null;
        j = new ArrayList();
        k = null;
        l = null;
        m = 0;
        o = null;
        A = false;
        H = false;
    }

    static ArrayList a(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        return searchsinglebraceletactivity.j;
    }

    private void a()
    {
        k = new bv(this);
        G = findViewById(0x7f0a0064);
        i = (ListView)findViewById(0x7f0a0065);
        i.setAdapter(k);
        i.setOnItemClickListener(new bq(this));
        z = (GifView)findViewById(0x7f0a0061);
        x = findViewById(0x7f0a005e);
        t = (TextView)findViewById(0x7f0a005c);
        u = (TextView)findViewById(0x7f0a005d);
        v = (TextView)findViewById(0x7f0a0062);
        v.setText(Html.fromHtml((new StringBuilder()).append("<u>").append(getString(0x7f0d0069)).append("</u>").toString()));
        v.setOnClickListener(this);
        v.setVisibility(0);
        w = (TextView)findViewById(0x7f0a0063);
        w.setOnClickListener(this);
        w.setVisibility(8);
        D = (ImageView)findViewById(0x7f0a0060);
        F = (ImageButton)findViewById(0x7f0a005b);
        F.setOnClickListener(this);
        C = (LinePieChartView)findViewById(0x7f0a005f);
        C.setMode(0);
        C.showLoading();
        findViewById(0x7f0a0034).setOnClickListener(this);
    }

    private void a(BluetoothDevice bluetoothdevice)
    {
        o = bluetoothdevice;
        Utils.connect(bluetoothdevice, false);
        h.sendEmptyMessage(4097);
        h.sendEmptyMessageDelayed(4115, 60000L);
        UmengAnalytics.startEvent(l, "StartUpConnectBracelet");
    }

    static void a(SearchSingleBraceletActivity searchsinglebraceletactivity, BluetoothDevice bluetoothdevice)
    {
        searchsinglebraceletactivity.a(bluetoothdevice);
    }

    private void a(com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo)
    {
        cn.com.smartdevices.bracelet.model.LoginData logindata = Keeper.readLoginData();
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        String s1 = Keeper.readDeviceId();
        SystemInfo systeminfo = new SystemInfo();
        systeminfo.deviceId = s1;
        systeminfo.braceletMacAddress = braceletbtinfo.address;
        systeminfo.miuiVersionCode = Utils.getMiuiVersionCode(l);
        systeminfo.miuiVersionName = Utils.getMiuiVersionName(l);
        systeminfo.phoneBrand = Build.BRAND;
        systeminfo.phoneModel = Build.MODEL;
        systeminfo.phoneSystem = (new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString();
        try
        {
            systeminfo.softVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        }
        catch (Exception exception) { }
        systeminfo.fwVersion = deviceinfo.getFirmwareVersionStr();
        Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("updateSystemInfo:\n").append(systeminfo.toString()).toString());
        WebAPI.updateSystemInfo(logindata, systeminfo, 0, new bs(this));
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            b();
            t.setText(0x7f0d0023);
            u.setText(0x7f0d00a2);
            v.setVisibility(4);
            w.setVisibility(0);
            w.setText(Html.fromHtml("<u>\u6211\u7684\u624B\u73AF\u600E\u4E48\u6CA1\u6709\u4EAE\u706F</u>"));
            C.setVisibility(4);
            D.setVisibility(4);
            E = true;
            return;
        } else
        {
            c();
            t.setText(0x7f0d0143);
            u.setText(0x7f0d0142);
            v.setVisibility(0);
            w.setVisibility(8);
            C.setVisibility(0);
            D.setVisibility(0);
            E = false;
            return;
        }
    }

    static boolean a(SearchSingleBraceletActivity searchsinglebraceletactivity, boolean flag)
    {
        searchsinglebraceletactivity.A = flag;
        return flag;
    }

    private void b()
    {
        z.setVisibility(0);
        z.setGifImage(0x7f02001d);
        z.setOnClickListener(this);
        z.setGifImageType(GifImageType.COVER);
        z.setLoopNumber(4096);
    }

    static void b(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        searchsinglebraceletactivity.i();
    }

    static Context c(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        return searchsinglebraceletactivity.l;
    }

    private void c()
    {
        z.setVisibility(8);
    }

    static int d(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        int i1 = searchsinglebraceletactivity.m;
        searchsinglebraceletactivity.m = i1 + 1;
        return i1;
    }

    private boolean d()
    {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter != null && !bluetoothadapter.isEnabled())
        {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 8193);
            return false;
        } else
        {
            return true;
        }
    }

    static int e(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        return searchsinglebraceletactivity.m;
    }

    private void e()
    {
        h = new br(this);
        Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("mHandler = ").append(h).toString());
    }

    private void f()
    {
        if (BraceletApp.BLEService != null)
        {
            BraceletApp.BLEService.stopScan();
        }
        if (h != null)
        {
            h.removeMessages(4100);
            h.removeMessages(4103);
            h.removeMessages(4117);
            h.removeMessages(4115);
            return;
        } else
        {
            Debug.i("SearchSingleBraceletActivity", "mHandler is NULL!!!!!!!!!!!!!!!!!");
            return;
        }
    }

    static void f(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        searchsinglebraceletactivity.h();
    }

    private void g()
    {
        IGattCallback igattcallback = BraceletApp.BLEService.getDefaultPeripheral();
        if (igattcallback != null)
        {
            ((MiLiProfile)igattcallback).setAutoReconnect(false);
            igattcallback.disconnect();
            Debug.i("SearchSingleBraceletActivity", "\n    =============== disconnect BLE =============== \n");
        }
    }

    static void g(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        searchsinglebraceletactivity.j();
    }

    static bu h(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        return searchsinglebraceletactivity.s;
    }

    private void h()
    {
        if (BraceletApp.BLEService != null)
        {
            Debug.i("SearchSingleBraceletActivity", "startScanBracelet");
            if (j != null)
            {
                j.clear();
                k.notifyDataSetChanged();
            }
            h.removeMessages(4100);
            BLEService bleservice = BraceletApp.BLEService;
            UUID auuid[] = new UUID[1];
            auuid[0] = MiLiProfile.UUID_SERVICE_MILI_SERVICE;
            bleservice.setServiceFilter(auuid);
            BraceletApp.BLEService.startScan(60000);
            h.removeMessages(4103);
            h.sendEmptyMessageDelayed(4103, 60000L);
            h.removeMessages(4117);
            h.sendEmptyMessageDelayed(4117, 10000L);
            UmengAnalytics.startEvent(this, "StartUpScanBracelet");
            return;
        } else
        {
            h.sendEmptyMessageDelayed(4100, 200L);
            return;
        }
    }

    private void i()
    {
        f();
        g();
        Intent intent = new Intent(l, cn/com/smartdevices/bracelet/activity/MultiBraceletErrActivity);
        intent.setFlags(0x4000000);
        if (B)
        {
            intent.putExtra("REF_NOT_KNOCKED", 0x7f0d0063);
        }
        startActivity(intent);
        finish();
    }

    private void j()
    {
        f();
        g();
        startActivity(new Intent(l, cn/com/smartdevices/bracelet/activity/BraceletNotFoundActivity));
        finish();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("requestCode =").append(i1).append(", resultCode=").append(j1).toString());
        if (i1 != 8193) goto _L2; else goto _L1
_L1:
        j1;
        JVM INSTR tableswitch -1 0: default 64
    //                   -1 72
    //                   0 79;
           goto _L2 _L3 _L4
_L2:
        super.onActivityResult(i1, j1, intent);
        return;
_L3:
        h();
        continue; /* Loop/switch isn't completed */
_L4:
        CustomToast.makeText(this, getString(0x7f0d0098), 1).show();
        finish();
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onAuthenticationFailed()
    {
        super.onAuthenticationFailed();
        Debug.i("SearchSingleBraceletActivity", "onAuthenticationFailed");
        a(true);
        if (mDevMode)
        {
            CustomToast.makeText(l, 0x7f0d0128, 1).show();
        }
    }

    public void onBackPressed()
    {
        Keeper.keepBraceletBtInfo(new BraceletBtInfo());
        if (!mDevMode)
        {
            super.onBackPressed();
            return;
        } else
        {
            BleTogglePairTask.waitingNotify(Integer.valueOf(239));
            finish();
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131361844: 49
    //                   2131361883: 58
    //                   2131361890: 129
    //                   2131361891: 115;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        f();
        finish();
        return;
_L3:
        if (BraceletApp.BLEService != null)
        {
            BraceletApp.BLEService.stopScan();
        }
        if (j != null)
        {
            j.clear();
        }
        boolean flag;
        if (!mDevMode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setDevelopUI(flag);
        if (d())
        {
            h();
            return;
        }
          goto _L1
_L5:
        i();
        BleTogglePairTask.waitingNotify(Integer.valueOf(239));
        return;
_L4:
        f();
        g();
        finish();
        startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/MainUIActivity));
        UmengAnalytics.event(this, "StartUpNotBindBracelet");
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000f);
        getWindow().setWindowAnimations(0x7f0e0015);
        H = false;
        Debug.i("SearchSingleBraceletActivity", "onCreate");
        l = this;
        e();
        a();
        Intent intent = getIntent();
        if (intent != null)
        {
            mDevMode = intent.getBooleanExtra("REF_SEARCH_DEV_MODE", false);
            Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("mDevMode = ").append(mDevMode).toString());
        } else
        {
            mDevMode = false;
        }
        setDevelopUI(mDevMode);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Debug.i("SearchSingleBraceletActivity", "onDestroy");
        H = true;
        f();
        if (z != null)
        {
            try
            {
                z.destroy();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            z = null;
        }
    }

    public void onDeviceConnected()
    {
        super.onDeviceConnected();
        Debug.i("SearchSingleBraceletActivity", "search single \u5DF2\u8FDE\u4E0A\u8BBE\u5907! MSG_DEVICE_CONNECTED");
        UmengAnalytics.endEvent(l, "StartUpConnectBracelet");
        UmengAnalytics.event(l, "StartUpConnectBracelet", "Successed");
    }

    public void onDeviceConnectionFailed()
    {
        super.onDeviceConnectionFailed();
        Util.hideProgressDialog();
        Debug.i("SearchSingleBraceletActivity", "onDeviceConnectionFailed");
        i();
        UmengAnalytics.endEvent(l, "StartUpConnectBracelet");
        UmengAnalytics.event(l, "StartUpConnectBracelet", "Failed");
    }

    public void onDeviceDisconnected()
    {
        super.onDeviceDisconnected();
        Util.hideProgressDialog();
        Debug.i("SearchSingleBraceletActivity", "onDeviceDisconnected");
        i();
    }

    public void onDeviceFound(BluetoothDevice bluetoothdevice, int i1)
    {
        bu bu1;
        bu1 = new bu(this);
        bu1.a = bluetoothdevice;
        bu1.b = i1;
        j.add(bu1);
        Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("found mili:").append(bu1.a.getAddress()).append(", ").append(bu1.a.getName()).append(", ").append(bu1.b).append(", divice count:").append(j.size()).toString());
        Debug.f("SearchSingleBraceletActivity", (new StringBuilder()).append("found mili:").append(bu1.a.getAddress()).append(", ").append(bu1.a.getName()).append(", ").append(bu1.b).append(", divice count:").append(j.size()).append(", mBtDevice = ").append(bu1).toString());
        Collections.sort(j, new bw(this, null));
        k.notifyDataSetChanged();
        if (y == null || !bu1.a.getAddress().equals(y.address)) goto _L2; else goto _L1
_L1:
        Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("FOUND last device:").append(y.address).toString());
        s = bu1;
        h.removeMessages(4103);
        h.sendEmptyMessage(4103);
        if (BraceletApp.BLEService != null)
        {
            BraceletApp.BLEService.stopScan();
        }
_L4:
        return;
_L2:
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = bu1;
_L5:
        if (A)
        {
            h.removeMessages(4103);
            h.sendEmptyMessageDelayed(4103, 1000L);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (bu1.b == 0)
        {
            Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("Found a connect device : ").append(bu1.a.getName()).append(",").append(bu1.a.getName()).append(",").append(bu1.b).toString());
            s = bu1;
            h.removeMessages(4103);
            h.sendEmptyMessage(4103);
            return;
        }
        if (bu1.b > s.b)
        {
            Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("Found a bigger signal : ").append(bu1.b).toString());
            s = bu1;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onHideApp()
    {
        Debug.i("SearchSingleBraceletActivity", "onHideApp: finish()");
        g();
        finish();
        Debug.i("SearchSingleBraceletActivity", "**********************************************************");
        Debug.i("SearchSingleBraceletActivity", "*************** Bracelet app, Exit whole process");
        Debug.i("SearchSingleBraceletActivity", "**********************************************************");
        System.exit(-1);
    }

    public void onInitializationFailed()
    {
        super.onInitializationFailed();
        Util.hideProgressDialog();
        Debug.i("SearchSingleBraceletActivity", "onInitializationFailed");
        i();
    }

    public void onInitializationSuccess()
    {
        super.onInitializationSuccess();
        Debug.i("SearchSingleBraceletActivity", "onInitializationSuccess");
        f();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag = true;
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362313 2131362313: default 28
    //                   2131362313 36;
           goto _L1 _L2
_L1:
        flag = super.onOptionsItemSelected(menuitem);
_L4:
        return flag;
_L2:
        if (BraceletApp.BLEService != null)
        {
            BraceletApp.BLEService.stopScan();
        }
        boolean flag1;
        if (!mDevMode)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        setDevelopUI(flag1);
        if (d())
        {
            h();
            return flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        Debug.i("SearchSingleBraceletActivity", "onPause");
        String s1 = "PageSearchSingleBracelet";
        if (mDevMode)
        {
            s1 = "PageSearchMultiBracelet";
        }
        UmengAnalytics.endPage(s1);
        UmengAnalytics.endSession(this);
    }

    public void onResetAuthentiacationSuccess()
    {
        super.onResetAuthentiacationSuccess();
        Debug.i("SearchSingleBraceletActivity", "onResetAuthentiacationSuccess");
    }

    public void onResetAuthenticationFailed()
    {
        super.onResetAuthenticationFailed();
        Debug.i("SearchSingleBraceletActivity", "onResetAuthentiacationFailed");
        if (mDevMode)
        {
            CustomToast.makeText(l, 0x7f0d0063, 0).show();
        }
        B = true;
    }

    protected void onResume()
    {
        super.onResume();
        B = false;
        z.restartGifAnimation();
        Debug.i("SearchSingleBraceletActivity", "onResume");
        String s1 = "PageSearchSingleBracelet";
        if (mDevMode)
        {
            s1 = "PageSearchMultiBracelet";
        }
        UmengAnalytics.startPage(s1);
        UmengAnalytics.startSession(this);
    }

    public void onTogglePairProgress(int i1)
    {
        super.onTogglePairProgress(i1);
    }

    public void onTogglePairResult(com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo)
    {
        super.onTogglePairResult(deviceinfo);
        if (deviceinfo == null)
        {
            Debug.i("SearchSingleBraceletActivity", (new StringBuilder()).append("onTogglePairResult : DeviceInfo = ").append(deviceinfo).toString());
            i();
            UmengAnalytics.event(l, "StartUpPairingBracelet", "Failed");
            return;
        }
        Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!");
        if (H)
        {
            Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
            return;
        }
        BraceletBtInfo braceletbtinfo = new BraceletBtInfo();
        braceletbtinfo.name = o.getName();
        braceletbtinfo.address = o.getAddress();
        Keeper.keepBraceletBtInfo(braceletbtinfo);
        Keeper.keepDeviceId(deviceinfo.deviceID);
        a(deviceinfo);
        LuaEvent.getInstance(l).setDefaultMsgs();
        C.dismissLoading();
        if (H)
        {
            Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
            return;
        }
        int i1;
        if (!E)
        {
            C.showNormalLine();
            t.setText(0x7f0d0024);
            u.setText(0x7f0d01ee);
            D.setImageResource(0x7f020094);
            F.setVisibility(8);
            v.setVisibility(8);
            i1 = 2000;
            Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
            Keeper.keepPlayEnterAnimationType(2);
        } else
        {
            Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
            Keeper.keepPlayEnterAnimationType(1);
            i1 = 0;
        }
        if (H)
        {
            Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
            return;
        } else
        {
            h.postDelayed(new bt(this), i1);
            UmengAnalytics.event(l, "StartUpPairingBracelet", "Successed");
            return;
        }
    }

    protected void setDevelopUI(boolean flag)
    {
        mDevMode = flag;
        j.clear();
        k.notifyDataSetChanged();
        if (mDevMode)
        {
            x.setVisibility(8);
            G.setVisibility(0);
            y = null;
        } else
        {
            y = Keeper.readBraceletBtInfo();
            x.setVisibility(0);
            G.setVisibility(8);
        }
        g();
        f();
        if (d())
        {
            h();
        }
    }

}
