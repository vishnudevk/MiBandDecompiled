// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.DataChart;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.location.LocationManager;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.lua.LuaListAdapter;
import cn.com.smartdevices.bracelet.lua.LuaListAdapterFake;
import cn.com.smartdevices.bracelet.lua.LuaManager;
import cn.com.smartdevices.bracelet.lua.MyListView;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.game.GameManager;
import cn.com.smartdevices.bracelet.upgrade.UpgradeService;
import cn.com.smartdevices.bracelet.upgrade.UpgradeUtil;
import cn.com.smartdevices.bracelet.upgrade.WebServiceClient;
import cn.com.smartdevices.bracelet.weather.WeatherManager;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.event.EventBus;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseSCActivity, aK, aQ, aV, 
//            aW, DynamicFragment, aS, aT, 
//            aX, aY, aG, aH, 
//            aI, aJ, aL, aM, 
//            StatisticActivity, MainMenuFragment, aN, aP, 
//            aR, aF, aU, SettingActivity, 
//            aO

public class MainUIActivity extends BaseSCActivity
    implements android.view.View.OnClickListener
{

    public static final int MSG_NEW_PUSH_MESSAGE = 518;
    public static final int MSG_NEW_PUSH_NEW_USERINFO = 519;
    public static final int REQ_SHARE = 32769;
    public static final boolean TEST_LUA_BY_PULL_DOWN_LISTVIEW = false;
    private static final String b = "MainUIActivity";
    private static final int c = 2;
    private static final int d = 0;
    private static final int e = -2;
    private static final int m = 30000;
    private static final int n = 272;
    private static final int o = 273;
    private static final int p = 274;
    private int A;
    private TextView B;
    private TextView C;
    private String D;
    private View E;
    private View F;
    private MyListView G;
    private View H;
    private LuaEvent I;
    private BaseSCActivity.ConnStatus J;
    private Boolean K;
    private final float L = 1.5F;
    private final float M = 1.27F;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    DynamicFragment a;
    private View aa;
    private boolean ab;
    private boolean ac;
    private Boolean ad;
    private Boolean ae;
    private ValueAnimator af;
    private float ag;
    private boolean ah;
    private cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener ai;
    private boolean aj;
    private boolean ak;
    private ValueAnimator al;
    private boolean f;
    private BroadcastReceiver g;
    private boolean h;
    private LocationManager i;
    private WeatherManager j;
    private View k;
    private GameManager l;
    public Handler mHandler;
    private View q;
    private View r;
    private TextView s;
    private TextView t;
    private SlidingUpPanelLayout u;
    private LuaListAdapter v;
    private TextView w;
    private ImageView x;
    private ProgressBar y;
    private View z;

    public MainUIActivity()
    {
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = -1;
        B = null;
        C = null;
        D = "";
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = new BaseSCActivity.ConnStatus();
        K = Boolean.valueOf(false);
        N = 300;
        O = 1150;
        P = 100;
        Q = 200;
        R = 400;
        S = 100;
        T = 378;
        U = 33;
        V = 66;
        W = 133;
        a = null;
        X = false;
        Y = false;
        Z = false;
        aa = null;
        ab = false;
        ac = false;
        ad = Boolean.valueOf(false);
        ae = Boolean.valueOf(false);
        af = null;
        ag = 1.0F;
        ah = true;
        ai = new aK(this);
        aj = false;
        ak = false;
        al = null;
    }

    static TextView A(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.s;
    }

    static View B(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.q;
    }

    static View C(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.r;
    }

    static View D(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.F;
    }

    static View E(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.E;
    }

    static int F(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.N;
    }

    static int G(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.O;
    }

    static void H(MainUIActivity mainuiactivity)
    {
        mainuiactivity.a();
    }

    static float a(MainUIActivity mainuiactivity, float f1)
    {
        mainuiactivity.ag = f1;
        return f1;
    }

    static WeatherManager a(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.j;
    }

    static Boolean a(MainUIActivity mainuiactivity, Boolean boolean1)
    {
        mainuiactivity.ad = boolean1;
        return boolean1;
    }

    private void a()
    {
        findViewById(0x7f0a01a1).getViewTreeObserver().addOnPreDrawListener(new aQ(this));
    }

    static void a(MainUIActivity mainuiactivity, String s1, String s2)
    {
        mainuiactivity.a(s1, s2);
    }

    private void a(String s1, String s2)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getApplicationContext());
        builder.setTitle(0x7f0d01dc);
        builder.setMessage(s1);
        builder.setNegativeButton(0x1040000, new aV(this));
        builder.setPositiveButton(0x104000a, new aW(this, s2));
        AlertDialog alertdialog = builder.create();
        alertdialog.getWindow().setType(2003);
        alertdialog.show();
    }

    private void a(boolean flag)
    {
        DaoManager.getInstance().getLuaListDao().deleteAll();
        DaoManager.getInstance().getLuaZipFileDao().deleteAll();
        startAnalysisThreadForLuaEvent(flag);
        I.setDefaultMsgs(Boolean.valueOf(flag));
        c(flag);
    }

    static boolean a(MainUIActivity mainuiactivity, boolean flag)
    {
        mainuiactivity.ab = flag;
        return flag;
    }

    static TextView b(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.t;
    }

    static Boolean b(MainUIActivity mainuiactivity, Boolean boolean1)
    {
        mainuiactivity.ae = boolean1;
        return boolean1;
    }

    private void b()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        a = (DynamicFragment)Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/DynamicFragment.getName());
        fragmenttransaction.add(0x7f0a01bf, a, "DynamicFragment");
        fragmenttransaction.commit();
        fragmentmanager.executePendingTransactions();
        p();
        r();
        I = LuaEvent.getInstance(this);
        c();
        aa = findViewById(0x7f0a01b9);
        k = findViewById(0x7f0a01ba);
    }

    private void b(boolean flag)
    {
        X = flag;
    }

    static boolean b(MainUIActivity mainuiactivity, boolean flag)
    {
        mainuiactivity.Z = flag;
        return flag;
    }

    private void c()
    {
        I.setLocale(Locale.getDefault().toString());
        Keeper.keepLatestDBLuaVersion(I.getLuaVersion());
    }

    private void c(boolean flag)
    {
        v.refreshList();
        int i1 = v.getNewItemCount();
        Debug.i("MainUIActivity", (new StringBuilder()).append("refreshListAndDetectBlank forceRefresh= ").append(flag).toString());
        if (!flag && i1 > 0 && Utils.isBinded())
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(i1);
            setTipMsg(getString(0x7f0d007e, aobj), 2);
            Debug.i("MainUIActivity", (new StringBuilder()).append("refreshListAndDetectBlank settips: ").append(i1).toString());
        }
        if (v.getListSize() == 0)
        {
            H.setVisibility(0);
            return;
        } else
        {
            H.setVisibility(8);
            return;
        }
    }

    static boolean c(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.ab;
    }

    static boolean c(MainUIActivity mainuiactivity, boolean flag)
    {
        mainuiactivity.aj = flag;
        return flag;
    }

    static BaseSCActivity.ConnStatus d(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.J;
    }

    private void d()
    {
        try
        {
            PackageInfo packageinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String s1 = packageinfo.versionName;
            int i1 = packageinfo.versionCode;
            String _tmp = packageinfo.packageName;
            Keeper.keepApkVersion((new StringBuilder()).append(i1).append(":").append(s1).toString());
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
    }

    static boolean d(MainUIActivity mainuiactivity, boolean flag)
    {
        mainuiactivity.ah = flag;
        return flag;
    }

    static View e(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.z;
    }

    private void e()
    {
        mHandler = new aS(this);
    }

    static boolean e(MainUIActivity mainuiactivity, boolean flag)
    {
        mainuiactivity.ak = flag;
        return flag;
    }

    static SlidingUpPanelLayout f(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.u;
    }

    private void f()
    {
        g = new aT(this);
        IntentFilter intentfilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        intentfilter.addAction("ACTION_BATTERY_LOW");
        registerReceiver(g, intentfilter);
        EventBus.getDefault().register(this);
    }

    static ProgressBar g(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.y;
    }

    private boolean g()
    {
        I.setLocale(Locale.getDefault().toString());
        i();
        a(true);
        return true;
    }

    static TextView h(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.B;
    }

    private void h()
    {
        if (UpgradeUtil.isNeedCheck(this))
        {
            WebServiceClient.getInstance(this);
            UpgradeService.start(this, 1);
        }
    }

    static TextView i(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.C;
    }

    private void i()
    {
        if ("NewGame".equals(I.getGameInfo()))
        {
            l.processGameEvent("");
            return;
        } else
        {
            l.processGameEvent("game_clear_banner");
            return;
        }
    }

    static ImageView j(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.x;
    }

    private boolean j()
    {
        boolean flag = true;
        if (!X)
        {
            flag = false;
        } else
        if (!Y)
        {
            Y = flag;
            mHandler.sendEmptyMessageDelayed(272, 30000L);
            return flag;
        }
        return flag;
    }

    static TextView k(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.w;
    }

    private boolean k()
    {
        if (!X)
        {
            return false;
        } else
        {
            Y = false;
            Z = false;
            mHandler.removeMessages(272);
            return true;
        }
    }

    static LuaListAdapter l(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.v;
    }

    private void l()
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        valueanimator.setDuration(300L);
        valueanimator.addListener(new aX(this));
        valueanimator.addUpdateListener(new aY(this));
        valueanimator.start();
    }

    static int m(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.R;
    }

    private void m()
    {
        if (ad.booleanValue())
        {
            return;
        } else
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.setDuration(100L);
            valueanimator.addListener(new aG(this));
            valueanimator.addUpdateListener(new aH(this));
            valueanimator.start();
            return;
        }
    }

    private void n()
    {
        c(false);
    }

    static boolean n(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.ac;
    }

    private void o()
    {
        if (ae.booleanValue() && af != null)
        {
            af.end();
        }
        float f1 = Utils.convertDpToPixel(36F, this);
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 2900F
        });
        af = valueanimator;
        valueanimator.setDuration((long)2900F);
        valueanimator.addListener(new aI(this, f1));
        valueanimator.addUpdateListener(new aJ(this, f1));
        valueanimator.start();
    }

    static boolean o(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.Z;
    }

    private void p()
    {
        u = (SlidingUpPanelLayout)findViewById(0x7f0a01b9);
        E = findViewById(0x7f0a01ba);
        F = findViewById(0x7f0a01a1);
        z = findViewById(0x7f0a01bb);
        w = (TextView)findViewById(0x7f0a01c1);
        x = (ImageView)findViewById(0x7f0a0164);
        y = (ProgressBar)findViewById(0x7f0a01bc);
        y.setIndeterminate(true);
        B = (TextView)findViewById(0x7f0a01bd);
        C = (TextView)findViewById(0x7f0a01be);
        u.setOverlayed(true);
        u.setEnableDragViewTouchEvents(true);
        H = findViewById(0x7f0a01c2);
        v = new LuaListAdapter(this, null);
        G = (MyListView)findViewById(0x7f0a01c0);
        G.setAdapter(v);
        G.setParentPanelLayout(u);
        u.setListAdapter(v);
        u.setPanelSlideListener(ai);
        q();
        if (Keeper.readIsPlayEnterAnimation().booleanValue())
        {
            F.setTranslationY(800F);
            Handler handler = new Handler();
            handler.postDelayed(new aL(this, handler), 1000L);
            return;
        }
        E.setBackgroundColor(-1);
        z.setX(N);
        z.setY(O);
        z.setVisibility(0);
        if (a != null)
        {
            a.setVPHight();
        }
        a();
    }

    static boolean p(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.aj;
    }

    private void q()
    {
        LuaListAdapterFake lualistadapterfake = new LuaListAdapterFake(this);
        lualistadapterfake.add("\u6211\u662F\u7B2C\u4E00\u6761", "\u6211\u662F\u526F\u6807\u98981");
        lualistadapterfake.add("\u6211\u662F\u7B2C2\u6761", "\u6211\u662F\u526F\u6807\u98982");
        lualistadapterfake.add("\u6211\u662F\u7B2C3\u6761", "\u6211\u662F\u526F\u6807\u98983");
        ((ListView)findViewById(0x7f0a01c3)).setAdapter(lualistadapterfake);
        lualistadapterfake.notifyDataSetChanged();
    }

    static boolean q(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.k();
    }

    static Boolean r(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.K;
    }

    private void r()
    {
        q = findViewById(0x7f0a00d3);
        q.setOnClickListener(this);
        r = findViewById(0x7f0a00d4);
        r.setOnClickListener(this);
        s = (TextView)findViewById(0x7f0a0073);
        t = (TextView)findViewById(0x7f0a00d5);
        s.setOnClickListener(new aM(this));
    }

    static int s(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.A;
    }

    private void s()
    {
        cn.com.smartdevices.bracelet.model.SportDay sportday = DataManager.getInstance().getCurDay();
        DataManager.getInstance().get(sportday);
        startActivity(DataChart.getInstance().executeLineChart(this, DataManager.getInstance().get(sportday)));
    }

    static float t(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.ag;
    }

    private void t()
    {
        Intent intent = new Intent(this, cn/com/smartdevices/bracelet/ui/StatisticActivity);
        intent.putExtra("Mode", ChartData.getDynamicData().getCurrentMode());
        startActivity(intent);
    }

    private void u()
    {
        if (ak)
        {
            return;
        } else
        {
            ak = true;
            aa.buildDrawingCache();
            MainMenuFragment mainmenufragment = new MainMenuFragment();
            mainmenufragment.setBackground(aa.getDrawingCache());
            mainmenufragment.setListener(new aN(this));
            mainmenufragment.show(getFragmentManager().beginTransaction(), null);
            UmengAnalytics.event(this, "ClickMainMenu");
            return;
        }
    }

    static void u(MainUIActivity mainuiactivity)
    {
        mainuiactivity.m();
    }

    static MyListView v(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.G;
    }

    private void v()
    {
        al = ValueAnimator.ofFloat(new float[] {
            0.0F, 800F
        });
        al.setDuration(500L);
        DecelerateInterpolator decelerateinterpolator = new DecelerateInterpolator();
        al.setInterpolator(decelerateinterpolator);
        al.addListener(new aP(this));
        al.addUpdateListener(new aR(this));
        al.start();
    }

    private void w()
    {
        int i1;
        String s1;
        i1 = ChartData.getDynamicData().getCurrentMode();
        s1 = getString(0x7f0d008f);
        if (!h) goto _L2; else goto _L1
_L1:
        s1 = getString(0x7f0d0020);
_L4:
        s.setText(s1);
        return;
_L2:
        if (i1 == 1)
        {
            s1 = getString(0x7f0d008f);
        } else
        if (i1 == 16)
        {
            s1 = getString(0x7f0d008e);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void w(MainUIActivity mainuiactivity)
    {
        mainuiactivity.v();
    }

    static LocationManager x(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.i;
    }

    static View y(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.aa;
    }

    static View z(MainUIActivity mainuiactivity)
    {
        return mainuiactivity.k;
    }

    public void listAnim()
    {
        LayoutAnimationController layoutanimationcontroller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 0x7f040008));
        layoutanimationcontroller.setOrder(0);
        layoutanimationcontroller.setInterpolator(new DecelerateInterpolator());
        layoutanimationcontroller.setDelay(0.5F);
        G.setLayoutAnimation(layoutanimationcontroller);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        int i1;
        int j1;
        if (connstatus == null)
        {
            return;
        }
        i1 = J.a;
        Debug.i("MainUIActivity", (new StringBuilder()).append("onBleStatusChanged:").append(connstatus).toString());
        J = connstatus;
        j1 = connstatus.a;
        if (w == null)
        {
            Debug.i("MainUIActivity", (new StringBuilder()).append("onBleStatusChanged: mDynamicTip is null").append(connstatus).toString());
            return;
        }
        if (j1 != 1) goto _L2; else goto _L1
_L1:
        k();
        I.setDefaultMsgs();
        restoreDownMsgList();
        if (a != null)
        {
            a.setBindMode();
        }
_L4:
        Debug.i("MainUIActivity", (new StringBuilder()).append("out onBleStatusChanged:").append(connstatus).toString());
        return;
_L2:
        if (j1 == 2)
        {
            pullDownMsgList(getString(0x7f0d0075), getString(0x7f0d007a));
            if (a != null)
            {
                a.setConnectingAlpha(Boolean.valueOf(true));
            }
        } else
        if (j1 == 3)
        {
            j();
            if (!Z)
            {
                pullDownMsgList(getString(0x7f0d0075), getString(0x7f0d007a));
                if (a != null)
                {
                    a.setConnectingAlpha(Boolean.valueOf(true));
                }
            }
        } else
        if (j1 == 4)
        {
            pullDownMsgList(getString(0x7f0d0073), getString(0x7f0d0074), 2, 0.0F);
        } else
        if (j1 == 5)
        {
            j();
            if (!Z)
            {
                pullDownMsgList(getString(0x7f0d0075), getString(0x7f0d007a));
                if (a != null)
                {
                    a.setConnectingAlpha(Boolean.valueOf(true));
                }
            }
        } else
        if (j1 == 6)
        {
            j();
            if (!Z)
            {
                pullDownMsgList(getString(0x7f0d0075), getString(0x7f0d007a));
                if (a != null)
                {
                    a.setConnectingAlpha(Boolean.valueOf(true));
                }
            }
        } else
        if (j1 == 7)
        {
            j();
            if (!Z)
            {
                pullDownMsgList(getString(0x7f0d0075), getString(0x7f0d007a));
                if (a != null)
                {
                    a.setConnectingAlpha(Boolean.valueOf(true));
                }
            }
        } else
        if (j1 == 8)
        {
            k();
            w.setVisibility(8);
            if (a != null && i1 != j1)
            {
                a.setConnectingAlpha(Boolean.valueOf(false));
            }
            mHandler.sendEmptyMessageDelayed(274, 1000L);
        } else
        if (j1 == 9)
        {
            mHandler.removeMessages(274);
            int l1 = Math.max(0, Math.min(100, ((Integer)connstatus.b).intValue()));
            String s2 = getString(0x7f0d007c);
            Object aobj1[] = new Object[1];
            aobj1[0] = Integer.valueOf(l1);
            pullDownMsgList(s2, getString(0x7f0d007d, aobj1));
        } else
        if (j1 == 10)
        {
            int k1 = Math.max(0, Math.min(100, ((Integer)connstatus.b).intValue()));
            String s1 = getString(0x7f0d007c);
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(k1);
            pullDownMsgList(s1, getString(0x7f0d007d, aobj));
        } else
        if (j1 == 11)
        {
            if (((Boolean)connstatus.b).booleanValue())
            {
                restoreDownMsgList();
                i();
            } else
            {
                pullDownMsgList(getString(0x7f0d007b), Utils.getSyncTime(this, 0x7f0d0076), 3, 0.0F);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBtOnOff(EventBtOnOff eventbtonoff)
    {
        Debug.i("MainUIActivity", (new StringBuilder()).append("onBtOnOff:").append(eventbtonoff.type).toString());
        if (eventbtonoff.type == 1)
        {
            ac = true;
            pullDownMsgList(getString(0x7f0d0073), getString(0x7f0d0074), 2, 0.0F);
        } else
        if (eventbtonoff.type == 0 && ac)
        {
            ac = false;
            mHandler.sendEmptyMessage(273);
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362003: 
            t();
            return;

        case 2131362004: 
            u();
            break;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        Debug.i("MainUIActivity", "onConfigurationChanged");
        g();
        Keeper.keepLocaleStr();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005d);
        disableAutoApplyStatusBarTint();
        getWindow().setWindowAnimations(0x7f0e0015);
        l = new GameManager();
        D = getString(0x7f0d0077);
        e();
        f();
        d();
        N = (int)Utils.convertDpToPixel(S, this);
        O = (int)Utils.convertDpToPixel(T, this);
        P = (int)Utils.convertDpToPixel(U, this);
        Q = (int)Utils.convertDpToPixel(V, this);
        R = (int)Utils.convertDpToPixel(W, this);
        b(true);
        b();
        i = LocationManager.getManager(getApplicationContext());
        j = WeatherManager.getManager(getApplicationContext());
        j.registerLocationChanged();
        j.registerWeatherListener(new aF(this));
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
        if (g != null)
        {
            unregisterReceiver(g);
            g = null;
        }
    }

    public void onEvent(EventApkupgrade eventapkupgrade)
    {
        Debug.i("MainUIActivity", (new StringBuilder()).append("onEvent, + changelog=").append(eventapkupgrade.getChangeLog()).append(", force=").append(eventapkupgrade.isForceCheck()).append(" HasWindowfocus=").append(hasWindowFocus()).toString());
        if (f)
        {
            Utils.checkXiaomiApkUpdate(this, eventapkupgrade.isForceCheck(), eventapkupgrade.getChangeLog());
        }
    }

    public void onEvent(EventBatteryStatus eventbatterystatus)
    {
        if (eventbatterystatus == null)
        {
            return;
        }
        Debug.i("MainUIActivity", (new StringBuilder()).append("EventBatteryStatus onEvent: status = ").append(eventbatterystatus.status).append(", charges =").append(eventbatterystatus.level).toString());
        if (eventbatterystatus.status == 1)
        {
            h = true;
        } else
        {
            h = false;
        }
        updateTitle(-2);
    }

    public void onEvent(EventDynamicDetailSleepUserModified eventdynamicdetailsleepusermodified)
    {
        generateSleepReport();
        generateActivitiesReport();
    }

    public void onEvent(EventGameUpdate eventgameupdate)
    {
        Debug.i("MainUIActivity", (new StringBuilder()).append("EventGameUpdate: ").append(eventgameupdate).toString());
        I.callLuaFunc("showGameBanner", eventgameupdate);
        runOnUiThread(new aU(this));
    }

    public void onEvent(EventGoalsUpdated eventgoalsupdated)
    {
        Debug.i("MainUIActivity", "onEvent, EventGoalsUpdated");
        DataManager datamanager = DataManager.getInstance();
        cn.com.smartdevices.bracelet.model.SportDay sportday = DataManager.getInstance().getCurDay();
        DaySportData daysportdata = datamanager.get(sportday);
        datamanager.clearSummaryCache(sportday);
        if (daysportdata != null)
        {
            daysportdata.setNeedSync(true);
        }
        datamanager.saveToDb();
        generateContinueReachGoalReportAsync();
    }

    protected void onHideApp()
    {
        super.onHideApp();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Debug.i("MainUIActivity", "onNewIntent");
        while (intent.getExtras() == null || intent.getIntExtra("notification_enter", 0) != 1) 
        {
            return;
        }
        startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/SettingActivity));
    }

    protected void onPause()
    {
        super.onPause();
        f = false;
        AnalyticsTrackerManager.endSession(this);
        AnalyticsTrackerManager.endTimedEvent(new String[] {
            "EventDynamicPage"
        });
        UmengAnalytics.endSession(this);
        i.cancelLocation();
    }

    protected void onResume()
    {
        super.onResume();
        f = true;
        LuaManager.getInstance().checkServerLua();
        long l1;
        if (!Keeper.readLocaleStr().equals("") && !Keeper.readLocaleStr().equals(Locale.getDefault().toString()))
        {
            Debug.i("MainUIActivity", "setlocale when changed");
            g();
            Keeper.keepLocaleStr();
        } else
        {
            I.setDefaultMsgs();
            n();
        }
        Utils.checkApkUpgrade(this, false);
        Debug.i("MainUIActivity", "onResume");
        l1 = Keeper.readPersonInfoBaseUID().uid;
        AnalyticsTrackerManager.startSession(this, l1);
        AnalyticsTrackerManager.trackActive(l1);
        UmengAnalytics.startSession(this);
        if (Utils.isOnceBinded())
        {
            UmengAnalytics.event(this, "BindedUserStart");
        }
        if (!ac)
        {
            mHandler.sendEmptyMessage(273);
        }
        i.requestLocation("ServiceAmap");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        getWindow().setWindowAnimations(0x1030001);
    }

    public void pullDownMsgList()
    {
        pullDownMsgList(1.27F);
    }

    public void pullDownMsgList(float f1)
    {
        if (u == null)
        {
            Debug.e("chenee", "not init layout");
            return;
        } else
        {
            K = Boolean.valueOf(true);
            z.setScaleX(1.0F);
            z.setScaleY(1.0F);
            z.setAlpha(1.0F);
            z.setTranslationY(O);
            w.setVisibility(8);
            u.smoothSlideTo(f1, 0);
            return;
        }
    }

    public void pullDownMsgList(String s1, String s2)
    {
        pullDownMsgList(s1, s2, 1, 0.0F);
    }

    public void pullDownMsgList(String s1, String s2, int i1, float f1)
    {
        A = i1;
        B.setText(s1);
        C.setText(s2);
        if (i1 == 0)
        {
            float f2 = (f1 - 1.0F) / 0.5F;
            float f3 = (float)(O - P) + f2 * (float)Q;
            z.setTranslationY(f3);
            if (f1 < 1.5F)
            {
                z.setScaleX(1.0F);
                z.setScaleY(1.0F);
                z.setAlpha(1.0F);
            }
            x.setVisibility(0);
            x.setImageResource(0x7f02009c);
            y.setVisibility(8);
            B.setTextColor(0xff555555);
            C.setTextColor(0xff9f9f9f);
            return;
        }
        if (i1 == 2 || i1 == 3)
        {
            K = Boolean.valueOf(false);
            B.setTextColor(0xffdf4c12);
            C.setTextColor(0xffea9f8d);
            x.setVisibility(0);
            x.setImageResource(0x7f02009d);
            y.setVisibility(8);
            pullDownMsgList();
            return;
        } else
        {
            B.setTextColor(0xff555555);
            C.setTextColor(0xff9f9f9f);
            pullDownMsgList();
            x.setVisibility(4);
            y.setVisibility(0);
            return;
        }
    }

    public void restoreDownMsgList()
    {
        if (!K.booleanValue())
        {
            Debug.i("chenee", "not pulled down yet");
            return;
        }
        if (u == null)
        {
            Debug.e("chenee", "not init layout");
            return;
        } else
        {
            K = Boolean.valueOf(false);
            l();
            n();
            return;
        }
    }

    public void setTipMsg(String s1, int i1)
    {
        if (i1 < 0)
        {
            return;
        }
        w.setText(s1);
        if (i1 > 0)
        {
            o();
            w.setOnClickListener(null);
            w.setBackgroundColor(0xe059a712);
            return;
        } else
        {
            w.setVisibility(0);
            w.setOnClickListener(null);
            w.setBackgroundColor(0xe0e17534);
            return;
        }
    }

    public void shareTopHalf()
    {
        int i1;
        if (!ah)
        {
            i1 = 460;
            u.smoothSlideTo(1.0F, 0);
        } else
        {
            i1 = 0;
        }
        q.setVisibility(4);
        r.setVisibility(4);
        z.setVisibility(4);
        aa.postDelayed(new aO(this), i1);
    }

    protected void updateDynamicList(boolean flag)
    {
        Debug.i("chenee", "updateUI.............");
        c(flag);
    }

    public void updateTitle(int i1)
    {
        if (i1 == -2 || h)
        {
            w();
            return;
        } else
        {
            s.setText(i1);
            return;
        }
    }

    public void updateTitle(String s1)
    {
        s.setText(s1);
    }
}
