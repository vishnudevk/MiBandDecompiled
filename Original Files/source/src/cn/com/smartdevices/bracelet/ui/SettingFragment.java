// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.BleTask.BleGetBatteryInfoTask;
import cn.com.smartdevices.bracelet.BleTask.BleNotifyTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import de.greenrobot.event.EventBus;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bP, bQ, bO, bN, 
//            bS, bR, UnBindActivity, SearchSingleBraceletActivity, 
//            SystemBarTintActivity, HealthGoalsActivity, PersonInfoSetLightColorFragment, DimPanelFragment, 
//            PersonInfoWearHandFragment, BindWeixinActivityNew, BindWeixinActivity, SettingInComingCallTimeFragment, 
//            UnlockScreenHelperActivity, bT

public class SettingFragment extends Fragment
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener
{

    public static final long BAT_ANIM_DURATION = 500L;
    public static final String REF_MILI_NAME = "REF_MILI_NAME";
    private static final String a = "SettingFragment";
    private static final int b = 256;
    private static final int c = 100;
    private static final long d = 10L;
    private static final int e = 76;
    private static final boolean f;
    private RotateAnimation A;
    private float B;
    private Switch C;
    private View D;
    private boolean E;
    private int F;
    private TextView G;
    private View H;
    private TextView I;
    private cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener J;
    private com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo g;
    private PersonInfo h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private LinePieChartView q;
    private Animator r;
    private TextView s;
    private TextView t;
    private View u;
    private ImageView v;
    private String w;
    private AsyncTask x;
    private TextView y;
    private SlidingUpPanelLayout z;

    public SettingFragment()
    {
        g = null;
        k = null;
        C = null;
        H = null;
        I = null;
        J = new bP(this);
    }

    private long a(int i1)
    {
        return (long)(100 - i1);
    }

    static long a(SettingFragment settingfragment, int i1)
    {
        return settingfragment.a(i1);
    }

    static PersonInfo a(SettingFragment settingfragment)
    {
        return settingfragment.h;
    }

    static com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo a(SettingFragment settingfragment, com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo)
    {
        settingfragment.g = batteryinfo;
        return batteryinfo;
    }

    private void a()
    {
        boolean flag = true;
        if (Utils.isBraceletConnected())
        {
            h();
            g = c();
            if (g != null)
            {
                c(flag);
                flag = false;
            }
            a(flag);
            return;
        } else
        {
            i();
            return;
        }
    }

    private void a(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            return;
        } else
        {
            float f2 = 90F - f1 * 90F;
            q.setRotationX(f2);
            q.setAlpha(f1);
            float f3 = -B * (1.0F - f1);
            D.setTranslationY(f3);
            m.setAlpha(f1);
            n.setAlpha(f1);
            return;
        }
    }

    private void a(View view)
    {
        z = (SlidingUpPanelLayout)view.findViewById(0x7f0a01a0);
        z.setOverlayed(true);
        z.setEnableDragViewTouchEvents(true);
        z.setPanelSlideListener(J);
        view.findViewById(0x7f0a0034).setOnClickListener(this);
        j = (TextView)view.findViewById(0x7f0a01b6);
        i = (TextView)view.findViewById(0x7f0a01a6);
        k = (TextView)view.findViewById(0x7f0a01b4);
        y = (TextView)view.findViewById(0x7f0a01b8);
        H = view.findViewById(0x7f0a01a3);
        H.setOnClickListener(this);
        I = (TextView)view.findViewById(0x7f0a01a4);
        view.findViewById(0x7f0a01a5).setOnClickListener(this);
        view.findViewById(0x7f0a01b3).setOnClickListener(this);
        view.findViewById(0x7f0a01a7).setOnClickListener(this);
        view.findViewById(0x7f0a01a9).setOnClickListener(this);
        view.findViewById(0x7f0a01b1).setOnClickListener(this);
        view.findViewById(0x7f0a01b5).setOnClickListener(this);
        view.findViewById(0x7f0a01ae).setOnClickListener(this);
        view.findViewById(0x7f0a01b7).setOnClickListener(this);
        View view1 = view.findViewById(0x7f0a01ab);
        view1.setOnClickListener(this);
        if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
        {
            view.findViewById(0x7f0a01ad).setVisibility(8);
            view1.setVisibility(8);
        }
        l = (TextView)view.findViewById(0x7f0a016a);
        u = view.findViewById(0x7f0a016b);
        m = (TextView)view.findViewById(0x7f0a016d);
        n = (TextView)view.findViewById(0x7f0a016e);
        v = (ImageView)view.findViewById(0x7f0a016c);
        D = view.findViewById(0x7f0a0168);
        o = view.findViewById(0x7f0a002a);
        p = view.findViewById(0x7f0a01a2);
        q = (LinePieChartView)view.findViewById(0x7f0a0169);
        q.setMode(1);
        s = (TextView)view.findViewById(0x7f0a01a8);
        t = (TextView)view.findViewById(0x7f0a01aa);
        B = TypedValue.applyDimension(1, 76F, getResources().getDisplayMetrics());
        if (h.getInComingCallTime() == 255)
        {
            h.setInComingCallTime(20);
            h.disableInComingCallTime();
            Keeper.keepPersonInfo(h);
        }
        G = (TextView)view.findViewById(0x7f0a01af);
        C = (Switch)view.findViewById(0x7f0a01b0);
        C.setOnCheckedChangeListener(new bQ(this));
    }

    static void a(SettingFragment settingfragment, float f1)
    {
        settingfragment.a(f1);
    }

    static void a(SettingFragment settingfragment, boolean flag)
    {
        settingfragment.c(flag);
    }

    private void a(boolean flag)
    {
        (new BleGetBatteryInfoTask(new bO(this, flag))).work();
    }

    private boolean a(Animation animation)
    {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    static boolean a(SettingFragment settingfragment, Animation animation)
    {
        return settingfragment.a(animation);
    }

    private Animator b(int i1)
    {
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch2(100, i1, l));
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(q.animRefresh(), 500L);
        return cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
    }

    static RotateAnimation b(SettingFragment settingfragment)
    {
        return settingfragment.A;
    }

    private void b()
    {
        WebAPI.updateProfile(Keeper.readLoginData(), h, new bN(this));
    }

    static void b(SettingFragment settingfragment, boolean flag)
    {
        settingfragment.a(flag);
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            H.setEnabled(true);
            I.setTextColor(getResources().getColor(0x7f090039));
            return;
        } else
        {
            H.setEnabled(false);
            I.setTextColor(getResources().getColor(0x7f090020));
            return;
        }
    }

    private com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo c()
    {
        MiLiProfile miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
        if (miliprofile != null)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo batteryinfo = miliprofile.getCachedBatteryInfo();
            if (batteryinfo != null)
            {
                g = batteryinfo;
                Debug.i("SettingFragment", (new StringBuilder()).append("getCachedBatteryInfo = ").append(g).toString());
            }
        }
        return g;
    }

    static com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo c(SettingFragment settingfragment)
    {
        return settingfragment.g;
    }

    private void c(boolean flag)
    {
        Debug.i("SettingFragment", (new StringBuilder()).append("updateLeftBattery mBatteryInfo =").append(g).append(", isVisible=").append(isVisible()).append(", showAnimation = ").append(flag).toString());
        if (g == null || getActivity() == null) goto _L2; else goto _L1
_L1:
        g.status;
        JVM INSTR tableswitch 0 4: default 108
    //                   0 109
    //                   1 109
    //                   2 688
    //                   3 758
    //                   4 109;
           goto _L2 _L3 _L3 _L4 _L5 _L3
_L2:
        return;
_L3:
        b(true);
        q.dismissLoading();
        q.setMode(1);
        if (g.level <= 5)
        {
            n.setVisibility(0);
        } else
        {
            n.setVisibility(8);
        }
        if (g.lastCharge.get(1) == 2000)
        {
            Calendar calendar = h.getFirstUseDate();
            if (calendar == null)
            {
                calendar = Calendar.getInstance();
                h.setFirstUseDate(Calendar.getInstance());
                h.setNeedSyncServer(2);
                Keeper.keepPersonInfo(h);
                b();
            }
            int j1 = Calendar.getInstance().get(6) - calendar.get(6);
            if (j1 == 0)
            {
                w = getResources().getString(0x7f0d00a0);
            } else
            {
                String s2 = getResources().getText(0x7f0d00a1).toString();
                Object aobj1[] = new Object[1];
                aobj1[0] = Integer.valueOf(j1);
                w = String.format(s2, aobj1);
            }
            if (j1 == 1)
            {
                w = w.replace("days", "day");
            }
        } else
        {
            Debug.i("SettingFragment", (new StringBuilder()).append("today=").append(Calendar.getInstance().get(6)).append(" last=").append(g.lastCharge.get(6)).toString());
            int i1 = Calendar.getInstance().get(6) - g.lastCharge.get(6);
            if (i1 == 0)
            {
                w = getResources().getString(0x7f0d0138);
            } else
            {
                String s1 = getResources().getText(0x7f0d0137).toString();
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i1);
                w = String.format(s1, aobj);
            }
            if (i1 == 1)
            {
                w = w.replace("days", "day");
            }
            if (h.getFirstUseDate() != null)
            {
                h.setFirstUseDate(null);
                h.setNeedSyncServer(2);
                Keeper.keepPersonInfo(h);
                b();
            }
        }
        m.setText(w);
        if (r != null && r.isStarted())
        {
            r.end();
        }
        if (flag)
        {
            r = b(g.level);
            q.postDelayed(new bS(this), 350L);
        } else
        {
            q.setMaxValue(100L);
            q.setValue(a(g.level));
            l.setText((new StringBuilder()).append(g.level).append("").toString());
        }
        v.setVisibility(8);
        l.setVisibility(0);
        u.setVisibility(0);
        return;
_L4:
        q.setMode(2);
        q.showLoading(10L);
        m.setText(0x7f0d001f);
        v.setImageResource(0x7f0200a0);
        v.setVisibility(0);
        l.setVisibility(8);
        u.setVisibility(8);
        b(false);
        return;
_L5:
        q.dismissLoading();
        q.setMaxValue(100L);
        q.setValue(a(100));
        q.setMode(1);
        m.setText(0x7f0d001e);
        v.setVisibility(8);
        l.setText("100");
        l.setVisibility(0);
        u.setVisibility(0);
        return;
    }

    static ImageView d(SettingFragment settingfragment)
    {
        return settingfragment.v;
    }

    private void d()
    {
        if (a(A))
        {
            return;
        }
        int i1 = 1 + F;
        F = i1;
        if (i1 >= 3)
        {
            F = -1000;
            CustomToast.makeText(getActivity(), 0x7f0d009c, 1).show();
        }
        (new BleNotifyTask(null)).work();
        v.setVisibility(0);
        A.reset();
        v.startAnimation(A);
    }

    static TextView e(SettingFragment settingfragment)
    {
        return settingfragment.l;
    }

    private void e()
    {
        A = new RotateAnimation(-5F, 5F, 0, Utils.convertDpToPixel(16F, getActivity()), 0, Utils.convertDpToPixel(33F, getActivity()));
        A.setAnimationListener(new bR(this));
        A.setDuration(50L);
        A.setRepeatCount(20);
        A.setInterpolator(new AccelerateDecelerateInterpolator());
        A.setRepeatMode(2);
    }

    static View f(SettingFragment settingfragment)
    {
        return settingfragment.u;
    }

    private void f()
    {
        startActivity(new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/UnBindActivity));
    }

    static LinePieChartView g(SettingFragment settingfragment)
    {
        return settingfragment.q;
    }

    private void g()
    {
        Intent intent = new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
        intent.setFlags(0x10008000);
        startActivity(intent);
    }

    static TextView h(SettingFragment settingfragment)
    {
        return settingfragment.m;
    }

    private void h()
    {
        Debug.i("SettingFragment", "enableUI");
        o.setVisibility(4);
        k.setVisibility(0);
        p.setBackgroundResource(0x7f090003);
        l.setVisibility(0);
        u.setVisibility(0);
        v.setVisibility(4);
    }

    static Animator i(SettingFragment settingfragment)
    {
        return settingfragment.r;
    }

    private void i()
    {
        o.setVisibility(0);
        k.setVisibility(4);
        p.setBackgroundResource(0x7f090007);
        m.setText(0x7f0d003d);
        l.setVisibility(4);
        u.setVisibility(4);
        q.dismissLoading();
        v.setImageResource(0x7f0200bc);
        v.setVisibility(0);
        q.setMaxValue(100L);
        q.setValue(100L);
        q.setMode(0);
        q.refresh(false);
        if (Utils.isBinded())
        {
            y.setText(0x7f0d01ba);
            return;
        } else
        {
            y.setText(0x7f0d0025);
            return;
        }
    }

    private void j()
    {
        n();
        o();
        m();
        l();
        k();
    }

    private void k()
    {
        TextView textview;
        Object aobj[];
        if (h.isInComingCallEnabled())
        {
            C.setChecked(true);
        } else
        {
            C.setChecked(false);
        }
        Debug.i("SettingFragment", (new StringBuilder()).append("inComingCallTime = ").append(h.getInComingCallTime()).toString());
        textview = G;
        aobj = new Object[1];
        aobj[0] = Integer.valueOf(h.getInComingCallTime());
        textview.setText(getString(0x7f0d00d0, aobj));
    }

    private void l()
    {
        if ("LEFT_HAND".equals(h.getMiliWearHand()))
        {
            t.setText(0x7f0d00dd);
            return;
        } else
        {
            t.setText(0x7f0d013c);
            return;
        }
    }

    private void m()
    {
        if ("BLUE".equals(h.getMiliColor()))
        {
            s.setText(0x7f0d0031);
        } else
        {
            if ("ORANGE".equals(h.getMiliColor()))
            {
                s.setText(0x7f0d0121);
                return;
            }
            if ("GREEN".equals(h.getMiliColor()))
            {
                s.setText(0x7f0d00bf);
                return;
            }
            if ("RED".equals(h.getMiliColor()))
            {
                s.setText(0x7f0d0135);
                return;
            }
        }
    }

    private void n()
    {
        i.setText((new StringBuilder()).append(h.getDaySportGoalSteps()).append(getString(0x7f0d01b0)).toString());
    }

    public static SettingFragment newInstance()
    {
        SettingFragment settingfragment = new SettingFragment();
        settingfragment.setArguments(new Bundle());
        return settingfragment;
    }

    private void o()
    {
        MiLiProfile miliprofile;
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo;
        if (BraceletApp.BLEService != null)
        {
            if ((miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()) != null && (deviceinfo = miliprofile.getCachedDeviceInfo()) != null)
            {
                j.setText(deviceinfo.getFirmwareVersionStr());
                return;
            }
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Debug.i("SettingFragment", (new StringBuilder()).append("onActivityResult: ").append(i1).append(" result:").append(j1).toString());
        if (i1 == 256 && j1 == -1)
        {
            h = Keeper.readPersonInfo();
            n();
        }
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        if (connstatus.a != 8) goto _L2; else goto _L1
_L1:
        Debug.i("SettingFragment", "connect success");
        if (Utils.isBraceletConnected())
        {
            h();
            Activity activity1 = getActivity();
            if (activity1 != null)
            {
                ((SystemBarTintActivity)activity1).applyStatusBarTintAuto();
            }
        }
        if (g != null) goto _L4; else goto _L3
_L3:
        a(true);
_L6:
        return;
_L4:
        c(false);
        return;
_L2:
        if (connstatus.a == 9)
        {
            Debug.i("SettingFragment", "sync data start");
            return;
        }
        if (connstatus.a == 10)
        {
            Debug.i("SettingFragment", (new StringBuilder()).append("sync data progress : ").append(connstatus.b).toString());
            return;
        }
        if (connstatus.a == 11)
        {
            Debug.i("SettingFragment", "sync data stop");
            return;
        }
        if (connstatus.a < 8)
        {
            i();
            Activity activity = getActivity();
            if (activity != null)
            {
                ((SystemBarTintActivity)activity).applyStatusBarTintAuto();
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 11: default 104
    //                   2131361844: 105
    //                   2131362211: 163
    //                   2131362213: 120
    //                   2131362215: 178
    //                   2131362217: 189
    //                   2131362219: 332
    //                   2131362222: 313
    //                   2131362225: 261
    //                   2131362227: 142
    //                   2131362229: 200
    //                   2131362231: 147;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        return;
_L2:
        if (getActivity() != null)
        {
            getActivity().finish();
            return;
        }
          goto _L1
_L4:
        startActivityForResult(new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/HealthGoalsActivity), 256);
        return;
_L10:
        f();
        return;
_L12:
        if (Utils.isBinded())
        {
            f();
            return;
        } else
        {
            g();
            return;
        }
_L3:
        d();
        UmengAnalytics.event(getActivity(), "BraceletFind");
        return;
_L5:
        DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSetLightColorFragment);
        return;
_L6:
        DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoWearHandFragment);
        return;
_L11:
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        Activity activity = getActivity();
        Object aobj[] = new Object[2];
        aobj[0] = braceletbtinfo.name;
        aobj[1] = braceletbtinfo.address;
        String s1 = activity.getString(0x7f0d0039, aobj);
        CustomToast.makeText(getActivity(), s1, 1).show();
        return;
_L9:
        Intent intent1;
        if (Utils.isWeixinSupportJump(getActivity()))
        {
            intent1 = new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/BindWeixinActivityNew);
        } else
        {
            intent1 = new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/BindWeixinActivity);
        }
        startActivity(intent1);
        return;
_L8:
        SettingInComingCallTimeFragment settingincomingcalltimefragment = new SettingInComingCallTimeFragment();
        DimPanelFragment.showPanel(getActivity(), settingincomingcalltimefragment);
        return;
_L7:
        Intent intent = new Intent();
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/UnlockScreenHelperActivity);
        getActivity().startActivity(intent);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        EventBus.getDefault().register(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f03005c, viewgroup, false);
        h = Keeper.readPersonInfo();
        a(view);
        e();
        E = true;
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (C.isChecked())
        {
            UmengAnalytics.event(getActivity(), "BraceletCallNotify", "ON");
            UmengAnalytics.event(getActivity(), "BraceletCallNotifyTime", h.getInComingCallTime());
            return;
        } else
        {
            UmengAnalytics.event(getActivity(), "BraceletCallNotify", "OFF");
            return;
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        Debug.i("SettingFragment", "onDestroyView");
        if (x != null)
        {
            x.cancel(true);
            x = null;
        }
    }

    public void onEvent(EventBatteryStatus eventbatterystatus)
    {
        Debug.i("SettingFragment", (new StringBuilder()).append("EventBatteryStatus onEvent: status = ").append(eventbatterystatus.status).append(", charges =").append(eventbatterystatus.level).toString());
        a(false);
    }

    public void onEvent(EventSettingFragmentUpdate eventsettingfragmentupdate)
    {
        h = Keeper.readPersonInfo();
        Debug.i("SettingFragment", (new StringBuilder()).append("update ... ui ").append(h).toString());
        j();
        b();
    }

    public boolean onLongClick(View view)
    {
        switch (view.getId())
        {
        default:
            return true;

        case 2131362211: 
            break;
        }
        if (x == null)
        {
            Debug.i("SettingFragment", "mShowOffTask start ");
            d();
            x = (new bT(this, null)).execute(new String[0]);
            return true;
        } else
        {
            Debug.i("SettingFragment", (new StringBuilder()).append("mShowOffTask").append(x).append(" cancel ").toString());
            x.cancel(true);
            x = null;
            return true;
        }
    }

    public void onPause()
    {
        super.onPause();
        if (a(A))
        {
            v.clearAnimation();
            v.setVisibility(4);
        }
        AnalyticsTrackerManager.endTimedEvent(new String[] {
            "EventSettingPage"
        });
        UmengAnalytics.endPage("PageBracelet");
    }

    public void onResume()
    {
        super.onResume();
        Debug.i("SettingFragment", "onResume");
        j();
        if (E)
        {
            a();
            E = false;
        }
        if (!isHidden())
        {
            AnalyticsTrackerManager.trackTimedEvent("EventSettingPage");
        }
        if (h.getNeedSyncServer() != 0)
        {
            EventBus.getDefault().post(new EventPersonInfoUpdate());
        }
        UmengAnalytics.startPage("PageBracelet");
    }
}
