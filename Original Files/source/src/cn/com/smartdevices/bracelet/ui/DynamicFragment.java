// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventLoadDataComplete;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.view.DynamicView;
import de.greenrobot.event.EventBus;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            ab, MainUIActivity, af, ad, 
//            ae, ac, aa

public class DynamicFragment extends Fragment
    implements com.xiaomi.hm.bleservice.profile.IMiLiProfile.IRealtimeStepsChangedCB
{

    public static final int LOAD_MORE_BLOGS = 1;
    public static final int MSG_TO_LAST_DAY = 4121;
    public static final int MSG_TO_NEXT_DAY = 4120;
    public static final int MSG_TO_PREV_DAY = 4119;
    public static final int MSG_UPDATE_STEPS = 4115;
    public static final int REFRESH_BLOGS = 0;
    private static final String a = "Dynamic.Main";
    public static Handler mHandler = null;
    private final int b = 4113;
    private final int c = 4114;
    private DataManager d;
    private int e;
    private ViewPager f;
    private PageIndicator g;
    private af h;
    private BaseSCActivity.ConnStatus i;
    private int j;
    private int k;
    private int l;
    private ValueAnimator m;
    private int n;
    private Boolean o;
    private boolean p;
    private Boolean q;

    public DynamicFragment()
    {
        d = DataManager.getInstance();
        e = -1;
        i = new BaseSCActivity.ConnStatus();
        o = Boolean.valueOf(false);
        p = false;
        q = Boolean.valueOf(false);
    }

    static int a(DynamicFragment dynamicfragment)
    {
        return dynamicfragment.n;
    }

    static int a(DynamicFragment dynamicfragment, int i1)
    {
        dynamicfragment.n = i1;
        return i1;
    }

    private ValueAnimator a()
    {
        boolean flag = q.booleanValue();
        ValueAnimator valueanimator = null;
        if (!flag)
        {
            int i1 = j;
            int j1 = k;
            Debug.i("Dynamic.Main", "Build bg switch anim!!");
            ab ab1 = new ab(this);
            View aview[] = new View[1];
            aview[0] = f;
            valueanimator = (ValueAnimator)AnimUtil.animColorTrans(i1, j1, ab1, aview);
        }
        return valueanimator;
    }

    private void a(int i1)
    {
        i1;
        JVM INSTR lookupswitch 2: default 28
    //                   1: 55
    //                   16: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        ((MainUIActivity)getActivity()).updateTitle(0x7f0d008e);
        UmengAnalytics.event(getActivity(), "ViewDynamic", "Mode", "ModeSleep");
        return;
_L2:
        ((MainUIActivity)getActivity()).updateTitle(0x7f0d008f);
        UmengAnalytics.event(getActivity(), "ViewDynamic", "Mode", "ModeStep");
        DynamicView dynamicview = h.b();
        if (dynamicview != null)
        {
            dynamicview.refresh(true);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(int i1, int j1)
    {
        (new Thread(new ad(this, i1, j1))).start();
    }

    private void a(cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData dynamicdata)
    {
        Debug.i("Dynamic.Main", "Update Dynamic Tip!!");
        Calendar calendar = Calendar.getInstance();
        Debug.i("Dynamic.Main", (new StringBuilder()).append("CurrentTime : ").append(calendar).toString());
        Calendar calendar1 = Calendar.getInstance();
        long l1 = Keeper.readSyncTime();
        String s;
        Calendar calendar2;
        long l2;
        String s1;
        if (l1 == -1L)
        {
            calendar1.add(6, -1);
        } else
        {
            calendar1.setTimeInMillis(l1);
        }
        Debug.i("Dynamic.Main", (new StringBuilder()).append("LastSyncTime : ").append(calendar1).toString());
        if ((calendar1.get(6) < calendar.get(6) || calendar1.get(11) < 5) && calendar.get(11) >= 5)
        {
            s = getString(0x7f0d0087);
        } else
        if (!dynamicdata.isWeared())
        {
            s = getString(0x7f0d008d);
        } else
        {
            s = getString(0x7f0d0085);
        }
        dynamicdata.setSleepTip(s);
        calendar2 = Calendar.getInstance();
        l2 = Keeper.readSyncRealStepTime();
        if (l2 == -1L)
        {
            calendar2.add(6, -1);
        } else
        {
            calendar2.setTimeInMillis(l2);
        }
        Debug.i("Dynamic.Main", (new StringBuilder()).append("LastSyncRealStepTime : ").append(calendar2).toString());
        if (calendar2.get(6) < calendar.get(6))
        {
            s1 = getString(0x7f0d008a);
        } else
        {
            long l3 = (int)((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 60000L);
            if (l3 >= 2L)
            {
                if (l3 >= 60L)
                {
                    Object aobj1[] = new Object[1];
                    aobj1[0] = Long.valueOf(l3 / 60L);
                    s1 = getString(0x7f0d0088, aobj1);
                } else
                {
                    Object aobj[] = new Object[1];
                    aobj[0] = Long.valueOf(l3);
                    s1 = getString(0x7f0d0089, aobj);
                }
            } else
            {
                s1 = getString(0x7f0d0086);
            }
        }
        dynamicdata.setStepTip(s1);
    }

    static void a(DynamicFragment dynamicfragment, String s, String s1)
    {
        dynamicfragment.a(s, s1);
    }

    static void a(DynamicFragment dynamicfragment, boolean flag)
    {
        dynamicfragment.a(flag);
    }

    private void a(String s, String s1)
    {
    }

    private void a(boolean flag)
    {
        boolean flag1 = true;
        if (getActivity() != null) goto _L2; else goto _L1
_L1:
        SportDay sportday;
        return;
_L2:
        if ((sportday = d.getStopDay()) == null) goto _L1; else goto _L3
_L3:
        Debug.i("DDDD", (new StringBuilder()).append("Dynamic Current Day : ").append(sportday.formatString()).toString());
        DaySportData daysportdata = d.get(sportday);
        StepsInfo stepsinfo;
        SleepInfo sleepinfo;
        StepsInfo stepsinfo1;
        boolean flag2;
        SleepInfo sleepinfo1;
        int i1;
        int j1;
        int k1;
        Calendar calendar;
        cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData dynamicdata;
        DynamicViewFragment dynamicviewfragment;
        boolean flag3;
        DynamicViewFragment dynamicviewfragment1;
        PersonInfo personinfo;
        double d1;
        DaySportData daysportdata1;
        if (daysportdata != null)
        {
            stepsinfo = daysportdata.getStepsInfo();
            sleepinfo = daysportdata.getSleepInfo();
        } else
        {
            stepsinfo = null;
            sleepinfo = null;
        }
        if (stepsinfo == null)
        {
            stepsinfo1 = new StepsInfo();
        } else
        {
            stepsinfo1 = stepsinfo;
        }
        if (sleepinfo == null)
        {
            sleepinfo = new SleepInfo();
            flag2 = flag1;
        } else
        if (sleepinfo.getSleepCount() == 0)
        {
            flag2 = flag1;
        } else
        {
            flag2 = false;
        }
        if (flag2 && sportday.calendar.get(11) >= 5)
        {
            flag2 = false;
        }
        Debug.i("DDDD", (new StringBuilder()).append("Dynamic Show Previous Day's Sleep Info: ").append(flag2).toString());
        if (!flag2) goto _L5; else goto _L4
_L4:
        d.load(sportday.addDay(-1));
        daysportdata1 = d.get(sportday.addDay(-1));
        if (daysportdata1 == null) goto _L5; else goto _L6
_L6:
        sleepinfo1 = daysportdata1.getSleepInfo();
        if (sleepinfo1 == null)
        {
            sleepinfo1 = new SleepInfo();
        }
_L8:
        i1 = stepsinfo1.getStepsCount();
        j1 = stepsinfo1.getDistance();
        k1 = stepsinfo1.getCalories();
        Debug.i("DDDD", (new StringBuilder()).append("Dynamic Step Info : ").append(i1).append(" , ").append(j1).append(" , ").append(k1).toString());
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Keeper.readSyncRealStepTime());
        if (!(new SportDay(calendar)).equals(sportday))
        {
            e = -1;
            Keeper.keepRealtimeSteps(e);
        }
        if (e != -1)
        {
            if (i1 != e)
            {
                if (i1 > 0)
                {
                    j1 = (j1 * e) / i1;
                    k1 = (k1 * e) / i1;
                } else
                {
                    personinfo = Keeper.readPersonInfo();
                    if (personinfo == null || personinfo.height <= 0)
                    {
                        d1 = 0.71399999999999997D;
                    } else
                    {
                        d1 = (0.41999999999999998D * (double)personinfo.height) / 100D;
                    }
                    j1 = (int)(d1 * (double)e);
                    k1 = (int)((1.1899999999999999D * (2.2046000000000001D * (double)personinfo.weight) * (double)e) / 4000D);
                }
                Debug.i("bxl", (new StringBuilder()).append("set Steps=").append(e).toString());
            }
            i1 = e;
            Debug.i("bxl", (new StringBuilder()).append("setRealtimeSteps=").append(e).toString());
            Debug.i("DDDD", (new StringBuilder()).append("Dynamic Real-Step : ").append(i1).append(" , ").append(j1).append(" , ").append(k1).toString());
        }
        dynamicdata = ChartData.getDynamicData();
        dynamicdata.setStepCount(i1);
        dynamicdata.setStepDistance(j1);
        dynamicdata.setStepCalorie(k1);
        if (!sleepinfo1.getHasSleep() && sleepinfo1.getNosleepReason() == SleepInfo.NOSLEEP_NONWEAR)
        {
            dynamicdata.setWeared(false);
        } else
        {
            dynamicdata.setWeared(flag1);
        }
        dynamicdata.setSleepTime(sleepinfo1.getSleepCount());
        dynamicdata.setSleepDeepTime(sleepinfo1.getNonRemCount());
        dynamicdata.setSleepStartDate(sleepinfo1.getStartDate());
        dynamicdata.setSleepStopDate(sleepinfo1.getStopDate());
        a(dynamicdata);
        dynamicviewfragment = h.c();
        if (!flag)
        {
            flag3 = flag1;
        } else
        {
            flag3 = false;
        }
        dynamicviewfragment.notifyDataSetChanged(flag3);
        dynamicviewfragment1 = h.d();
        if (flag)
        {
            flag1 = false;
        }
        dynamicviewfragment1.notifyDataSetChanged(flag1);
        return;
_L5:
        sleepinfo1 = sleepinfo;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void a(boolean flag, com.xiaomi.hm.bleservice.profile.IMiLiProfile.IRealtimeStepsChangedCB irealtimestepschangedcb)
    {
        if (!Utils.isBraceletConnected())
        {
            return;
        } else
        {
            (new Thread(new ae(this, flag, irealtimestepschangedcb))).start();
            return;
        }
    }

    static ValueAnimator b(DynamicFragment dynamicfragment)
    {
        return dynamicfragment.m;
    }

    private void b()
    {
        mHandler = new ac(this);
    }

    static void b(DynamicFragment dynamicfragment, int i1)
    {
        dynamicfragment.a(i1);
    }

    static int c(DynamicFragment dynamicfragment, int i1)
    {
        dynamicfragment.e = i1;
        return i1;
    }

    private void c()
    {
    }

    static void c(DynamicFragment dynamicfragment)
    {
        dynamicfragment.c();
    }

    static int d(DynamicFragment dynamicfragment)
    {
        return dynamicfragment.e;
    }

    private void d()
    {
        if (d.isStartDay())
        {
            CustomToast.makeText(getActivity(), "\u6CA1\u6709\u66F4\u65E9\u4EE5\u524D\u7684\u6570\u636E\uFF01", 0).show();
            return;
        } else
        {
            d.setCurDay(-1, 0);
            a(0, 0);
            return;
        }
    }

    private void e()
    {
        if (d.isStopDay())
        {
            CustomToast.makeText(getActivity(), "\u628A\u63E1\u73B0\u5728\uFF0C\u5065\u5EB7\u660E\u5929", 0).show();
            return;
        } else
        {
            d.setCurDay(1, 0);
            a(0, 0);
            return;
        }
    }

    static void e(DynamicFragment dynamicfragment)
    {
        dynamicfragment.d();
    }

    private void f()
    {
        if (d.isStopDay())
        {
            return;
        } else
        {
            d.setCurDay(0, 2);
            a(0, 0);
            return;
        }
    }

    static void f(DynamicFragment dynamicfragment)
    {
        dynamicfragment.e();
    }

    static void g(DynamicFragment dynamicfragment)
    {
        dynamicfragment.f();
    }

    static DataManager h(DynamicFragment dynamicfragment)
    {
        return dynamicfragment.d;
    }

    public static DynamicFragment newInstance()
    {
        DynamicFragment dynamicfragment = new DynamicFragment();
        dynamicfragment.setArguments(new Bundle());
        return dynamicfragment;
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        Debug.i("Dynamic.Main", (new StringBuilder()).append("onBleStatusChanged:").append(connstatus).toString());
        i = connstatus;
        int i1 = connstatus.a;
        if (i1 == 8)
        {
            if (!p)
            {
                a(true, this);
            } else
            {
                a(false, this);
            }
        }
        if (i1 == 11 && isAdded())
        {
            Debug.i("DDDD", "Dynamic Update : Data Synced.");
            a(true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        p = false;
        b();
        EventBus.getDefault().register(this, "onGoalsSettingChanged", cn/com/smartdevices/bracelet/eventbus/EventGoalsUpdated, new Class[0]);
        EventBus.getDefault().registerSticky(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
        EventBus.getDefault().registerSticky(this, "onLoadDataComplete", cn/com/smartdevices/bracelet/eventbus/EventLoadDataComplete, new Class[0]);
        Resources resources = getActivity().getResources();
        j = resources.getColor(0x7f09000a);
        k = resources.getColor(0x7f09000b);
        l = resources.getColor(0x7f09000c);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030021, null);
        f = (ViewPager)view.findViewById(0x7f0a0035);
        g = (PageIndicator)view.findViewById(0x7f0a0036);
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            h = new af(this, getFragmentManager());
        } else
        {
            h = new af(this, getChildFragmentManager());
        }
        f.setAdapter(h);
        g.setViewPager(f);
        g.setOnPageChangeListener(new aa(this));
        m = a();
        n = 1;
        f.setCurrentItem(1, false);
        if (o.booleanValue())
        {
            setVPHight();
        }
        setIndicator(g);
        return view;
    }

    public void onDestroy()
    {
        p = true;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach()
    {
        super.onDetach();
        if (mHandler == null)
        {
            return;
        } else
        {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
            return;
        }
    }

    public void onGoalsSettingChanged(EventGoalsUpdated eventgoalsupdated)
    {
        Debug.i("Dynamic.Main", "onGoalsSettingChanged");
        if (isAdded())
        {
            Debug.i("DDDD", "Dynamic Update : Goal Changed.");
            a(true);
        }
    }

    public void onLoadDataComplete(EventLoadDataComplete eventloaddatacomplete)
    {
        Debug.i("Dynamic.Main", "onLoadDataComplete");
        if (isAdded())
        {
            Debug.i("DDDD", "Dynamic Update : Data Loaded,Animation");
            a(false);
        }
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endEvent(getActivity(), "ViewDynamic");
        UmengAnalytics.endPage("PageDynamic");
    }

    public void onResume()
    {
        super.onResume();
        Debug.i("Dynamic.Main", "onResume................");
        p = false;
        a(true, this);
        Debug.i("DDDD", "Dynamic Update : OnResume.");
        a(true);
        UmengAnalytics.startPage("PageDynamic");
        UmengAnalytics.startEvent(getActivity(), "ViewDynamic");
    }

    public void onStop()
    {
        super.onStop();
        Debug.i("Dynamic.Main", "onStop................");
        p = true;
        a(false, this);
    }

    public void process(int i1)
    {
        Debug.i("step", (new StringBuilder()).append("process:").append(i1).toString());
        Message message = new Message();
        message.arg1 = i1;
        message.what = 4115;
        if (mHandler != null)
        {
            mHandler.sendMessage(message);
        }
    }

    public void setBindMode()
    {
        int i1;
        int j1;
        boolean flag;
        if (!Utils.isBinded())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = Boolean.valueOf(flag);
        Debug.i("chenee", (new StringBuilder()).append("set bind mode:").append(q).toString());
        if (q.booleanValue())
        {
            f.setBackgroundColor(l);
            ((MainUIActivity)getActivity()).applyStatusBarTint(l);
            m = null;
            return;
        }
        i1 = n;
        j1 = 0;
        i1;
        JVM INSTR lookupswitch 2: default 124
    //                   1: 160
    //                   16: 152;
           goto _L1 _L2 _L3
_L1:
        f.setBackgroundColor(j1);
        ((MainUIActivity)getActivity()).applyStatusBarTint(j1);
        m = a();
        return;
_L3:
        j1 = j;
        continue; /* Loop/switch isn't completed */
_L2:
        j1 = k;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setConnectingAlpha(Boolean boolean1)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            h.c().setConnectingAlpha(boolean1);
            h.d().setConnectingAlpha(boolean1);
            return;
        }
    }

    public void setIndicator(PageIndicator pageindicator)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            h.c().setIndicator(pageindicator);
            h.d().setIndicator(pageindicator);
            return;
        }
    }

    public void setSlideUpPosition(float f1)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            h.c().setSlideUpPosition(f1);
            h.d().setSlideUpPosition(f1);
            return;
        }
    }

    public void setVPHight()
    {
        if (f == null)
        {
            o = Boolean.valueOf(true);
            return;
        } else
        {
            f.getHeight();
            f.getLayoutParams().height = (int)Utils.convertDpToPixel(372F, getActivity());
            f.requestLayout();
            return;
        }
    }


    private class DynamicViewFragment extends Fragment
    {

        private DynamicView a;
        private cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData b;
        private int c;
        private PageIndicator d;

        private void a(DynamicView dynamicview, cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData dynamicdata)
        {
            if (c != 1) goto _L2; else goto _L1
_L1:
            dynamicview.setStepGoal(Keeper.readPersonInfoBaseConfig().getDaySportGoalSteps());
            dynamicview.setStepCount(b.getStepCount());
            dynamicview.setStepDistance(ChartData.formatDistance(getActivity(), b.getStepDistance()));
            dynamicview.setStepCalorie(b.getStepCalorie());
            dynamicview.setStepTip(b.getStepTip());
_L4:
            Debug.i("Dynamic.Main", (new StringBuilder()).append("BindData : ").append(b).append(" , Mode : ").append(c).toString());
            return;
_L2:
            if (c == 16)
            {
                dynamicview.setSleepTime(b.getSleepTime());
                dynamicview.setSleepDeepTime(b.getSleepDeepTime());
                dynamicview.setSleepTip(b.getSleepTip());
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public DynamicView getDynamicView()
        {
            return a;
        }

        public void notifyDataSetChanged(boolean flag)
        {
            if (a != null)
            {
                a(a, b);
                a.refresh(flag);
            }
        }

        public void onActivityCreated(Bundle bundle)
        {
            super.onActivityCreated(bundle);
            a.refresh(true);
        }

        public void onCreate(Bundle bundle)
        {
            super.onCreate(bundle);
            Bundle bundle1 = getArguments();
            if (bundle1 != null)
            {
                c = bundle1.getInt("Mode");
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            DynamicView dynamicview = new DynamicView(getActivity());
            a = (DynamicView)dynamicview;
            a.setMode(c);
            b = ChartData.getDynamicData();
            a(a, b);
            a.refresh();
            a.setIndicator(d);
            return dynamicview;
        }

        public void onResume()
        {
            super.onResume();
            if (!Utils.isBinded())
            {
                a.setBackgroundColor(0xff3c444f);
            }
        }

        public void setConnectingAlpha(Boolean boolean1)
        {
            if (a != null)
            {
                a.setConnectingAlpha(boolean1);
            }
        }

        public void setIndicator(PageIndicator pageindicator)
        {
            d = pageindicator;
            if (a != null)
            {
                a.setIndicator(pageindicator);
            }
        }

        public void setSlideUpPosition(float f1)
        {
            if (a != null)
            {
                a.setSlideUpPostion(f1);
            }
        }

        public DynamicViewFragment()
        {
            d = null;
        }
    }

}
