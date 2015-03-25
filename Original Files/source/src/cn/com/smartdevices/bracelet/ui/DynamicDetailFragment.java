// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StageSteps;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            W, X, T, U, 
//            DynamicDetailSleepModifyFragment, DimPanelFragment, SystemBarTintActivity, S, 
//            Y, V, ShareActivity, R, 
//            BaseSCActivity

public class DynamicDetailFragment extends Fragment
    implements android.view.View.OnClickListener
{

    public static final String KEY_MODIFY_SLEEP_DAY = "CurrentDay";
    public static final String KEY_MODIFY_SLEEP_TIME_CURRENT_HOUR = "CurrentHour";
    public static final String KEY_MODIFY_SLEEP_TIME_CURRENT_MINUTE = "CurrentMinute";
    public static final String KEY_MODIFY_SLEEP_TIME_LIMIT_END = "LimitEnd";
    public static final String KEY_MODIFY_SLEEP_TIME_LIMIT_START = "LimitStart";
    public static final String KEY_MODIFY_SLEEP_TIME_MAX_HOUR = "MaxHour";
    public static final String KEY_MODIFY_SLEEP_TIME_MIN_HOUR = "MinHour";
    public static final String KEY_MODIFY_SLEEP_TYPE = "Type";
    public static final int MODIFY_SLEEP_TYPE_END = 16;
    public static final int MODIFY_SLEEP_TYPE_START = 1;
    private static final String a = "Dynamic.Detail";
    public static Handler sRefreshHander;
    private int A;
    private int B;
    private int C;
    private int D;
    private Animator E;
    private Animator F;
    private Animator G;
    private boolean H;
    private String I;
    private int J;
    private int K;
    private int L;
    private View b;
    private TextView c;
    private TextView d;
    private View e;
    private ImageButton f;
    private View g;
    private View h;
    private View i;
    private View j;
    private DynamicDetailChartView k;
    private TextView l;
    private View m;
    private View n;
    private GestureDetector o;
    private DataManager p;
    private SportDay q;
    private SportDay r;
    private SportDay s;
    private SportDay t;
    private SportDay u;
    private int v;
    private String w;
    private int x;
    private int y;
    private int z;

    public DynamicDetailFragment()
    {
        p = DataManager.getInstance();
    }

    static Animator A(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.F;
    }

    static void B(DynamicDetailFragment dynamicdetailfragment)
    {
        dynamicdetailfragment.d();
    }

    static int a(DynamicDetailFragment dynamicdetailfragment, int i1)
    {
        dynamicdetailfragment.K = i1;
        return i1;
    }

    static int a(DynamicDetailFragment dynamicdetailfragment, Calendar calendar)
    {
        return dynamicdetailfragment.a(calendar);
    }

    private int a(Calendar calendar)
    {
        return -(60 * (-1 + (24 - calendar.get(11))) + (60 - calendar.get(12)));
    }

    private Animator a(float f1, float f2, View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.0F, 1.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(view, "scaleX", new float[] {
            0.0F, 1.0F
        });
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(view, "scaleY", new float[] {
            0.0F, 1.0F
        });
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(objectanimator);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(objectanimator1);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(objectanimator2);
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.setDuration(200L);
        animatorset.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorset;
    }

    private Animator a(int i1, int j1, View view, View view1, int k1, long l1, 
            boolean flag)
    {
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(k.animRefresh(), l1);
        if (!flag)
        {
            W w1 = new W(this);
            View aview[] = new View[2];
            aview[0] = b;
            aview[1] = (View)k.getParent();
            cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(i1, j1, w1, aview), l1 / 2L);
        }
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.addListener(new X(this));
        return animatorset;
    }

    static Animator a(DynamicDetailFragment dynamicdetailfragment, float f1, float f2, View view)
    {
        return dynamicdetailfragment.a(f1, f2, view);
    }

    static Animator a(DynamicDetailFragment dynamicdetailfragment, Animator animator)
    {
        dynamicdetailfragment.F = animator;
        return animator;
    }

    static Animator a(DynamicDetailFragment dynamicdetailfragment, View view)
    {
        return dynamicdetailfragment.b(view);
    }

    static DataManager a(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.p;
    }

    private cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData a(DaySportData daysportdata)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        int i1;
        cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartStepData dynamicdetailchartstepdata;
        Iterator iterator;
        int j1;
        cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartSleepData dynamicdetailchartsleepdata;
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        ArrayList arraylist2 = daysportdata.getAnalysisData();
        i1 = -1;
        dynamicdetailchartstepdata = null;
        iterator = arraylist2.iterator();
        j1 = -1;
        dynamicdetailchartsleepdata = null;
_L15:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        SportData sportdata = (SportData)iterator.next();
        k1 = sportdata.getSportMode();
        l1 = sportdata.getStep();
        i2 = sportdata.getTimeIndex();
        if (j1 == k1 && i2 != 1439) goto _L4; else goto _L3
_L3:
        cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData dynamicdetailchartdata;
        cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartSleepData dynamicdetailchartsleepdata1;
        int j2;
        cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartStepData dynamicdetailchartstepdata1;
        int k2;
        int l2;
        if (dynamicdetailchartsleepdata != null)
        {
            dynamicdetailchartsleepdata.length = i2 - dynamicdetailchartsleepdata.index;
            dynamicdetailchartsleepdata1 = null;
        } else
        {
            dynamicdetailchartsleepdata1 = dynamicdetailchartsleepdata;
        }
        if (k1 != 4 && k1 != 5 && k1 != 7 && k1 != 100) goto _L6; else goto _L5
_L5:
        dynamicdetailchartsleepdata1 = new cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartSleepData();
        arraylist.add(dynamicdetailchartsleepdata1);
        dynamicdetailchartsleepdata1.index = i2;
        dynamicdetailchartsleepdata1.length = 1;
        k1;
        JVM INSTR lookupswitch 4: default 220
    //                   4: 308
    //                   5: 321
    //                   7: 334
    //                   100: 347;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        j2 = k1;
_L16:
        if (k1 == 4 || k1 == 5 || l1 <= 0) goto _L12; else goto _L11
_L11:
        l2 = i2 / 60;
        if (l2 == i1) goto _L14; else goto _L13
_L13:
        dynamicdetailchartstepdata1 = new cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartStepData();
        arraylist1.add(dynamicdetailchartstepdata1);
        dynamicdetailchartstepdata1.index = l2;
        dynamicdetailchartstepdata1.step = l1;
        k2 = l2;
_L17:
        dynamicdetailchartsleepdata = dynamicdetailchartsleepdata1;
        i1 = k2;
        dynamicdetailchartstepdata = dynamicdetailchartstepdata1;
        j1 = j2;
          goto _L15
_L7:
        dynamicdetailchartsleepdata1.mode = 2;
        j2 = k1;
          goto _L16
_L8:
        dynamicdetailchartsleepdata1.mode = 3;
        j2 = k1;
          goto _L16
_L9:
        dynamicdetailchartsleepdata1.mode = 1;
        j2 = k1;
          goto _L16
_L10:
        dynamicdetailchartsleepdata1.mode = 4;
        j2 = k1;
          goto _L16
_L14:
        dynamicdetailchartstepdata.step = l1 + dynamicdetailchartstepdata.step;
_L12:
        dynamicdetailchartstepdata1 = dynamicdetailchartstepdata;
        k2 = i1;
          goto _L17
_L2:
        dynamicdetailchartdata = new cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData();
        if (v != 16) goto _L19; else goto _L18
_L18:
        dynamicdetailchartdata.sleepData = arraylist;
_L21:
        return dynamicdetailchartdata;
_L19:
        if (v != 1) goto _L21; else goto _L20
_L20:
        dynamicdetailchartdata.stepData = arraylist1;
        return dynamicdetailchartdata;
_L4:
        j2 = j1;
        dynamicdetailchartsleepdata1 = dynamicdetailchartsleepdata;
          goto _L16
    }

    static cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData a(DynamicDetailFragment dynamicdetailfragment, DaySportData daysportdata)
    {
        return dynamicdetailfragment.a(daysportdata);
    }

    static SportDay a(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        dynamicdetailfragment.q = sportday;
        return sportday;
    }

    private String a(SportDay sportday)
    {
        return (new StringBuilder()).append(1 + sportday.mon).append(".").append(sportday.day).toString();
    }

    private void a()
    {
        View view = (View)m.getParent().getParent();
        view.post(new T(this, view));
        View view1 = (View)n.getParent().getParent();
        view1.post(new U(this, view1));
    }

    private void a(int i1)
    {
        c.setText(i1);
    }

    private void a(int i1, SportDay sportday)
    {
        java.util.Date date = null;
        int j1 = 23;
        Debug.i("Dynamic.Detail", (new StringBuilder()).append("Show Modify Sleep Time : ").append(i1).toString());
        DaySportData daysportdata = p.get(sportday);
        SleepInfo sleepinfo;
        SleepInfo sleepinfo1;
        java.util.Date date1;
        Calendar calendar;
        Calendar calendar1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify usersleepmodify;
        int j3;
        int k3;
        int l3;
        int i4;
        Bundle bundle;
        int j4;
        int k4;
        if (daysportdata != null)
        {
            sleepinfo = daysportdata.getSleepInfo();
        } else
        {
            sleepinfo = null;
        }
        if (sleepinfo == null)
        {
            sleepinfo1 = new SleepInfo();
        } else
        {
            sleepinfo1 = sleepinfo;
        }
        i1;
        JVM INSTR lookupswitch 2: default 96
    //                   1: 420
    //                   16: 436;
           goto _L1 _L2 _L3
_L1:
        date1 = null;
_L7:
        calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        if (sportday.addDay(-1).equals(calendar))
        {
            k1 = a(calendar);
        } else
        {
            k1 = b(calendar);
        }
        if (sportday.addDay(-1).equals(calendar1))
        {
            l1 = a(calendar1);
        } else
        {
            l1 = b(calendar1);
        }
        if (k1 < 0)
        {
            j4 = -1 + (k1 + 1) / 60;
            k4 = k1 % 60;
            if (k4 != 0)
            {
                j2 = k4 + 60;
                k2 = j4;
            } else
            {
                j2 = k4;
                k2 = j4;
            }
        } else
        {
            i2 = k1 / 60;
            j2 = k1 % 60;
            k2 = i2;
        }
        l2 = k2 - 6;
        i3 = k2 + 6;
        if (l2 < -24)
        {
            l2 = -24;
        }
        if (i3 > j1)
        {
            i3 = j1;
        }
        usersleepmodify = ChartData.getDynamicData().getUserSleepModify(sportday);
        j3 = 0;
        k3 = 0;
        i1;
        JVM INSTR lookupswitch 2: default 280
    //                   1: 495
    //                   16: 517;
           goto _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_517;
_L4:
        l1 = 0x80000000;
        l3 = 0x80000000;
_L8:
        if (!sleepinfo1.getHasSleep() && j3 == 0x80000000)
        {
            if (k3 == 0x80000000)
            {
                l1 = 0x80000000;
                l3 = 0x80000000;
                i4 = -24;
            } else
            {
                i4 = -24;
            }
        } else
        {
            j1 = i3;
            i4 = l2;
        }
        bundle = new Bundle();
        bundle.putSerializable("CurrentDay", sportday);
        bundle.putInt("Type", i1);
        bundle.putInt("MinHour", i4);
        bundle.putInt("MaxHour", j1);
        bundle.putInt("CurrentHour", k2);
        bundle.putInt("CurrentMinute", j2);
        bundle.putInt("LimitStart", l3);
        bundle.putInt("LimitEnd", l1);
        DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/DynamicDetailSleepModifyFragment, bundle);
        return;
_L2:
        date1 = sleepinfo1.getStartDate();
        date = sleepinfo1.getStopDate();
          goto _L7
_L3:
        date1 = sleepinfo1.getStopDate();
        date = sleepinfo1.getStartDate();
          goto _L7
_L5:
        j3 = usersleepmodify.sleepStart;
        k3 = usersleepmodify.sleepEnd;
        l3 = 0x80000000;
          goto _L8
        j3 = usersleepmodify.sleepEnd;
        k3 = usersleepmodify.sleepStart;
        l3 = l1;
        l1 = 0x80000000;
          goto _L8
    }

    private void a(int i1, boolean flag)
    {
        int j1;
        int k1;
        View view;
        View view1;
        int l1;
        int i2;
        if (i1 == 16)
        {
            a(0x7f0d006f);
            f.setImageResource(0x7f020027);
            view = h;
            view1 = g;
            j1 = D;
            k1 = C;
            a();
            UmengAnalytics.event(getActivity(), "ViewDynamicDetail", "Mode", "ModeSleep");
            l1 = 650;
        } else
        if (i1 == 1)
        {
            if (!"DynamicView".equals(w))
            {
                a(0x7f0d0072);
            }
            f.setImageResource(0x7f020024);
            view = g;
            view1 = h;
            j1 = C;
            k1 = D;
            l.setVisibility(4);
            UmengAnalytics.event(getActivity(), "ViewDynamicDetail", "Mode", "ModeStep");
            l1 = 550;
        } else
        {
            j1 = 0;
            k1 = 0;
            view = null;
            view1 = null;
            l1 = 0;
        }
        k.setMode(i1);
        i2 = (int)(160F * ChartUtil.getDensity());
        if (flag)
        {
            b.setBackgroundColor(k1);
            ((View)k.getParent()).setBackgroundColor(k1);
            ((SystemBarTintActivity)getActivity()).applyStatusBarTint(k1);
            AnimUtil.infoSwitch((ViewGroup)view, (ViewGroup)view1);
        } else
        {
            view.setVisibility(0);
            view1.setVisibility(0);
            AnimUtil.animInfoSwitch((ViewGroup)view, (ViewGroup)view1);
        }
        E = a(j1, k1, view, view1, i2, l1, flag);
        sRefreshHander.sendEmptyMessage(0);
    }

    private void a(View view)
    {
        b = view.findViewById(0x7f0a0033);
        c = (TextView)view.findViewById(0x7f0a0034);
        c.setOnClickListener(this);
        d = (TextView)view.findViewById(0x7f0a00a9);
        e = view.findViewById(0x7f0a00aa);
        e.setOnClickListener(this);
        f = (ImageButton)view.findViewById(0x7f0a00ac);
        f.setOnClickListener(this);
        g = view.findViewById(0x7f0a00bb);
        h = view.findViewById(0x7f0a00c6);
        i = view.findViewById(0x7f0a00ad);
        j = view.findViewById(0x7f0a00b2);
        k = (DynamicDetailChartView)view.findViewById(0x7f0a00a7);
        l = (TextView)view.findViewById(0x7f0a00ab);
        m = view.findViewById(0x7f0a00c0);
        n = view.findViewById(0x7f0a00c3);
        m.setVisibility(0);
        n.setVisibility(0);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o = new GestureDetector(getActivity(), new S(this));
        AsyncChartDataLoader asyncchartdataloader = new AsyncChartDataLoader();
        asyncchartdataloader.setLoadCallback(b());
        k.setDataLoader(asyncchartdataloader);
        k.setScrollable(true);
        if ("DynamicView".equals(w) && v == 1)
        {
            k.setScrollable(false);
            ((View)f.getParent()).setVisibility(8);
        }
        k.attach();
    }

    private void a(View view, View view1)
    {
        int i1 = (int)(30F * ChartUtil.getDensity());
        Rect rect = new Rect();
        view1.getHitRect(rect);
        rect.left = rect.left - i1;
        rect.top = rect.top - i1;
        rect.right = i1 + rect.right;
        rect.bottom = i1 + rect.bottom;
        view.setTouchDelegate(new TouchDelegate(rect, view1));
    }

    private void a(ViewGroup viewgroup, ViewGroup viewgroup1)
    {
        viewgroup.setVisibility(4);
        viewgroup1.setVisibility(0);
        AnimationSet animationset = new AnimationSet(true);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(80L);
        animationset.addAnimation(alphaanimation);
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
        translateanimation.setDuration(100L);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        animationset.addAnimation(translateanimation);
        viewgroup1.setLayoutAnimation(new LayoutAnimationController(animationset, 0.7F));
        viewgroup1.requestLayout();
    }

    private void a(SleepInfo sleepinfo, int i1, int j1, View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00bc);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00bd);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00be);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00c1);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00c4);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00c5);
        textview.setText(ChartData.formatTimeLength(getActivity(), sleepinfo.getSleepCount(), 14));
        textview1.setText(ChartData.formatTimeLength(getActivity(), sleepinfo.getNonRemCount(), 14));
        textview2.setText(ChartData.formatTimeLength(getActivity(), sleepinfo.getRemCount(), 14));
        textview3.setText(ChartData.formatTime(i1));
        textview4.setText(ChartData.formatTime(j1));
        textview5.setText(ChartData.formatTimeLength(getActivity(), sleepinfo.getAwakeCount(), 14));
    }

    private void a(StageSteps stagesteps, View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00b3);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00b5);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00b7);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00b6);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00b9);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00ba);
        textview.setText(String.valueOf(stagesteps.steps));
        String as[] = ChartData.formatTimeLengthHourMin(stagesteps.count);
        String as1[];
        if (as[0].equals("0"))
        {
            textview1.setVisibility(8);
            textview3.setVisibility(8);
        } else
        {
            textview1.setVisibility(0);
            textview3.setVisibility(0);
            textview1.setText(as[0]);
        }
        textview2.setText(as[1]);
        as1 = ChartData.formatDistance(getActivity(), stagesteps.distance);
        textview4.setText(as1[0]);
        textview5.setText(as1[1]);
    }

    private void a(StepsInfo stepsinfo, View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f0a00c7);
        TextView textview1 = (TextView)view.findViewById(0x7f0a00c8);
        TextView textview2 = (TextView)view.findViewById(0x7f0a00ba);
        TextView textview3 = (TextView)view.findViewById(0x7f0a00c9);
        TextView textview4 = (TextView)view.findViewById(0x7f0a00cb);
        TextView textview5 = (TextView)view.findViewById(0x7f0a00cc);
        TextView textview6 = (TextView)view.findViewById(0x7f0a00cd);
        textview.setText(String.valueOf(stepsinfo.getStepsCount()));
        String as[] = ChartData.formatDistance(getActivity(), stepsinfo.getDistance());
        textview1.setText(as[0]);
        textview2.setText(as[1]);
        textview3.setText(String.valueOf(stepsinfo.getCalories()));
        textview4.setText(ChartData.formatTimeLength(getActivity(), stepsinfo.getActMinutes(), 14));
        textview5.setText(ChartData.formatTimeLength(getActivity(), stepsinfo.getStepsTimeCount(), 14));
        textview6.setText(ChartData.formatTimeLength(getActivity(), stepsinfo.getRunTimeCount(), 14));
    }

    private void a(cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem, int i1, View view)
    {
        TextView textview;
        TextView textview1;
        TextView textview2;
        String s1;
        String s2;
        textview = (TextView)view.findViewById(0x7f0a00ae);
        textview1 = (TextView)view.findViewById(0x7f0a00b0);
        textview2 = (TextView)view.findViewById(0x7f0a00b1);
        s1 = ChartData.formatTime(baritem.index);
        s2 = ChartData.formatTime(baritem.index + baritem.scope);
        view.findViewById(0x7f0a00af).setVisibility(0);
        baritem.value;
        JVM INSTR tableswitch 1 4: default 104
    //                   1 141
    //                   2 130
    //                   3 119
    //                   4 201;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        textview1.setText(s1);
        textview2.setText(s2);
        return;
_L4:
        textview.setText(0x7f0d0082);
        continue; /* Loop/switch isn't completed */
_L3:
        textview.setText(0x7f0d0084);
        continue; /* Loop/switch isn't completed */
_L2:
        if (baritem.index == K)
        {
            textview.setText(0x7f0d0081);
        } else
        if (baritem.index + baritem.scope == L)
        {
            textview.setText(0x7f0d0080);
        } else
        {
            textview.setText(0x7f0d007f);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        view.findViewById(0x7f0a00af).setVisibility(8);
        textview.setText(0x7f0d010e);
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void a(BaseSCActivity.ConnStatus connstatus)
    {
        Log.d("Dynamic.Detail", (new StringBuilder()).append("Current Sync Status : ").append(connstatus).toString());
        TextView textview;
        switch (connstatus.a)
        {
        default:
            d.setText(Utils.getSyncTime(getActivity(), 0x7f0d008c));
            return;

        case 9: // '\t'
            TextView textview1 = d;
            Object aobj1[] = new Object[1];
            aobj1[0] = Integer.valueOf(0);
            textview1.setText(getString(0x7f0d008b, aobj1));
            return;

        case 10: // '\n'
            textview = d;
            break;
        }
        Object aobj[] = new Object[1];
        aobj[0] = (Integer)connstatus.b;
        textview.setText(getString(0x7f0d008b, aobj));
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, View view, View view1)
    {
        dynamicdetailfragment.a(view, view1);
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, SleepInfo sleepinfo, int i1, int j1, View view)
    {
        dynamicdetailfragment.a(sleepinfo, i1, j1, view);
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, StageSteps stagesteps, View view)
    {
        dynamicdetailfragment.a(stagesteps, view);
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, StepsInfo stepsinfo, View view)
    {
        dynamicdetailfragment.a(stepsinfo, view);
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem baritem, int i1, View view)
    {
        dynamicdetailfragment.a(baritem, i1, view);
    }

    static void a(DynamicDetailFragment dynamicdetailfragment, String s1)
    {
        dynamicdetailfragment.a(s1);
    }

    private void a(String s1)
    {
        c.setText(s1);
    }

    static boolean a(DynamicDetailFragment dynamicdetailfragment, boolean flag)
    {
        dynamicdetailfragment.H = flag;
        return flag;
    }

    private String[] a(Context context, int i1)
    {
        String as[] = new String[2];
        String s1;
        if (i1 < 100)
        {
            s1 = String.valueOf(i1);
        } else
        {
            s1 = String.valueOf(i1);
        }
        as[0] = s1;
        return as;
    }

    static int b(DynamicDetailFragment dynamicdetailfragment, int i1)
    {
        dynamicdetailfragment.L = i1;
        return i1;
    }

    static int b(DynamicDetailFragment dynamicdetailfragment, Calendar calendar)
    {
        return dynamicdetailfragment.b(calendar);
    }

    private int b(Calendar calendar)
    {
        return 60 * calendar.get(11) + calendar.get(12);
    }

    private Animator b(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            1.0F, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(view, "scaleX", new float[] {
            1.0F, 0.0F
        });
        ObjectAnimator objectanimator2 = ObjectAnimator.ofFloat(view, "scaleY", new float[] {
            1.0F, 0.0F
        });
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(objectanimator);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(objectanimator1);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(objectanimator2);
        android.animation.AnimatorSet animatorset = cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
        animatorset.setDuration(200L);
        animatorset.setStartDelay(600L);
        animatorset.setInterpolator(new AccelerateInterpolator(2.0F));
        animatorset.addListener(new Y(this, view));
        return animatorset;
    }

    static Animator b(DynamicDetailFragment dynamicdetailfragment, Animator animator)
    {
        dynamicdetailfragment.G = animator;
        return animator;
    }

    private cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback b()
    {
        return new V(this);
    }

    static SportDay b(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.r;
    }

    static SportDay b(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        dynamicdetailfragment.r = sportday;
        return sportday;
    }

    private void b(int i1)
    {
        ShareData sharedata = c(i1);
        Intent intent = new Intent();
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/ShareActivity);
        intent.putExtra("share_data", sharedata);
        getActivity().startActivity(intent);
    }

    private ShareData c(int i1)
    {
        SportDay sportday;
        DaySportData daysportdata;
        sportday = DataManager.getInstance().getCurDay();
        daysportdata = DataManager.getInstance().get(sportday);
        if (i1 == 16)
        {
            cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData dynamicdata = ChartData.getDynamicData();
            int j1 = dynamicdata.getSleepTime();
            ShareData sharedata3 = new ShareData(2);
            sharedata3.title = getString(0x7f0d0166);
            sharedata3.content = (new StringBuilder()).append(j1).append("").toString();
            r = p.getCurDay();
            sharedata3.time = r.formatStringDay();
            int k1 = dynamicdata.getSleepDeepTime();
            int l1 = dynamicdata.getSleepTime() - k1;
            java.util.Date date = dynamicdata.getSleepStartDate();
            java.util.Date date1 = dynamicdata.getSleepStopDate();
            SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm");
            Object aobj2[] = new Object[6];
            aobj2[0] = Integer.valueOf(k1 / 60);
            aobj2[1] = Integer.valueOf(k1 % 60);
            aobj2[2] = Integer.valueOf(l1 / 60);
            aobj2[3] = Integer.valueOf(l1 % 60);
            aobj2[4] = simpledateformat.format(date);
            aobj2[5] = simpledateformat.format(date1);
            sharedata3.description = getString(0x7f0d0164, aobj2);
            return sharedata3;
        }
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        ShareData sharedata = new ShareData();
        if (!"DynamicView".equals(w)) goto _L4; else goto _L3
_L3:
        String s1;
        sharedata.setType(9);
        s1 = getString(0x7f0d01e0);
        J;
        JVM INSTR tableswitch 0 2: default 316
    //                   0 510
    //                   1 534
    //                   2 522;
           goto _L5 _L6 _L7 _L8
_L5:
        ShareData sharedata2;
        Object aobj[] = new Object[1];
        Object aobj1[] = new Object[2];
        aobj1[0] = ChartData.formatTime(x);
        aobj1[1] = ChartData.formatTime(y);
        aobj[0] = getString(0x7f0d0050, aobj1);
        sharedata.title = getString(0x7f0d0070, aobj);
        sharedata.content = (new StringBuilder()).append(A).append("").toString();
        sharedata.contentUnit = getString(0x7f0d01c4);
        String as[] = ChartData.formatDistance(getActivity(), B);
        String s2 = (new StringBuilder()).append(s1).append(as[0]).append(as[1]).append("\n").toString();
        sharedata.description = (new StringBuilder()).append(s2).append(I).toString();
        sharedata2 = sharedata;
_L9:
        sharedata2.time = sportday.formatStringDay();
        return sharedata2;
_L6:
        s1 = getString(0x7f0d01e0);
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = getString(0x7f0d013d);
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = getString(0x7f0d01e0);
        continue; /* Loop/switch isn't completed */
_L4:
        StepsInfo stepsinfo;
        ShareData sharedata1;
        if (daysportdata == null || daysportdata.getStepsInfo() == null)
        {
            stepsinfo = new StepsInfo();
        } else
        {
            stepsinfo = daysportdata.getStepsInfo();
        }
        sharedata1 = new ShareData(1);
        Utils.getDayShareTips(getActivity(), stepsinfo, sharedata1);
        sharedata2 = sharedata1;
        if (true) goto _L9; else goto _L2
_L2:
        return null;
        if (true) goto _L5; else goto _L10
_L10:
    }

    static SportDay c(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.q;
    }

    static SportDay c(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        dynamicdetailfragment.s = sportday;
        return sportday;
    }

    private void c()
    {
        if (E != null && E.isStarted())
        {
            return;
        }
        k.setScrollable(false);
        i.setVisibility(4);
        j.setVisibility(4);
        H = false;
        if (v != 16) goto _L2; else goto _L1
_L1:
        v = 1;
_L4:
        a(v, false);
        return;
_L2:
        if (v == 1)
        {
            v = 16;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void c(DynamicDetailFragment dynamicdetailfragment, int i1)
    {
        dynamicdetailfragment.a(i1);
    }

    static SportDay d(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.t;
    }

    static SportDay d(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        dynamicdetailfragment.t = sportday;
        return sportday;
    }

    private void d()
    {
        if (v == 16)
        {
            UmengAnalytics.event(getActivity(), "DynamicDetailViewChartItem", "ModeSleep");
        } else
        if (v == 1)
        {
            UmengAnalytics.event(getActivity(), "DynamicDetailViewChartItem", "ModeStep");
            return;
        }
    }

    static SportDay e(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.u;
    }

    static SportDay e(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        dynamicdetailfragment.u = sportday;
        return sportday;
    }

    static SportDay f(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.s;
    }

    static String f(DynamicDetailFragment dynamicdetailfragment, SportDay sportday)
    {
        return dynamicdetailfragment.a(sportday);
    }

    static DynamicDetailChartView g(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.k;
    }

    static int h(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.v;
    }

    static View i(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.m;
    }

    static View j(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.n;
    }

    static String k(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.w;
    }

    static int l(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.A;
    }

    static int m(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.z;
    }

    static int n(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.B;
    }

    static View o(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.j;
    }

    static int p(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.x;
    }

    static int q(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.y;
    }

    static Animator r(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.E;
    }

    static View s(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.h;
    }

    static TextView t(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.l;
    }

    static int u(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.K;
    }

    static int v(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.L;
    }

    static View w(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.g;
    }

    static View x(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.i;
    }

    static Animator y(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.G;
    }

    static boolean z(DynamicDetailFragment dynamicdetailfragment)
    {
        return dynamicdetailfragment.H;
    }

    protected String formatTime(int i1, int j1)
    {
        if (i1 == 0 && j1 == 0)
        {
            return "00:00";
        }
        if (j1 < 10)
        {
            return (new StringBuilder()).append(i1).append(":0").append(j1).toString();
        } else
        {
            return (new StringBuilder()).append(i1).append(":").append(j1).toString();
        }
    }

    protected String[] formatTimeHourMin(int i1)
    {
        int j1 = i1 / 60;
        int k1 = i1 % 60;
        String as[] = new String[2];
        if (j1 > 0)
        {
            as[0] = String.valueOf(j1);
        }
        as[1] = String.valueOf(k1);
        return as;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if ("RefCompleteGoal".equals(w))
        {
            b(v);
            getActivity().finish();
            UmengAnalytics.event(getActivity(), "ShareFrom", "ShareFromDynamic");
            return;
        }
        if ("DynamicView".equals(w))
        {
            UmengAnalytics.event(getActivity(), "ViewDynamicDetail", "From", "FromDynamicList");
        } else
        {
            UmengAnalytics.event(getActivity(), "ViewDynamicDetail", "From", "FromDynamic");
        }
        a(getView());
        sRefreshHander = new R(this);
        a(v, true);
        EventBus.getDefault().register(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            getActivity().finish();
            return;

        case 2131361962: 
            b(v);
            UmengAnalytics.event(getActivity(), "ShareFrom", "ShareFromDynamicDetail");
            return;

        case 2131361964: 
            c();
            return;

        case 2131361984: 
            a(1, r);
            return;

        case 2131361987: 
            a(16, r);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            v = bundle1.getInt("Mode");
            Debug.i("Dynamic.Detail", (new StringBuilder()).append("Mode : ").append(v).toString());
            J = bundle1.getInt("DynamicActivityMode");
            w = bundle1.getString("Action");
            x = bundle1.getInt("DynamicStartTime");
            I = bundle1.getString("DynamicActivitySubTitle");
            y = bundle1.getInt("DynamicEndTime");
            z = bundle1.getInt("DynamicActiveTime");
            A = bundle1.getInt("DynamicStep");
            B = bundle1.getInt("DynamicStepDistance");
        }
        Resources resources = getActivity().getResources();
        C = resources.getColor(0x7f09000a);
        D = resources.getColor(0x7f09000b);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030022, viewgroup, false);
    }

    public void onDestroy()
    {
        sRefreshHander = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach()
    {
        super.onDetach();
        if (k != null)
        {
            k.detach();
        }
    }

    public void onEvent(EventDynamicDetailSleepUserModified eventdynamicdetailsleepusermodified)
    {
        Debug.i("Dynamic.Detail", "User Modified : Reload!!");
        sRefreshHander.sendEmptyMessage(0);
    }

    public void onEvent(BaseSCActivity.ConnStatus connstatus)
    {
        Debug.i("Dynamic.Detail", (new StringBuilder()).append("On BLE Status Changed : ").append(connstatus.a).toString());
        if (isVisible())
        {
            a(connstatus);
            if (connstatus.a == 11 && ((Boolean)connstatus.b).booleanValue())
            {
                sRefreshHander.sendEmptyMessage(0);
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageDynamicDetail");
    }

    public void onResume()
    {
        super.onResume();
        a(BaseSCActivity.mConnStatus);
        UmengAnalytics.startPage("PageDynamicDetail");
    }

    public void onStop()
    {
        super.onStop();
        if (G != null && G.isStarted())
        {
            G.end();
        }
    }
}
