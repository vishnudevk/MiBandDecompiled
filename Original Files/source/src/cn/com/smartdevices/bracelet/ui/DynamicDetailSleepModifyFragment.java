// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.HashMap;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, PickAdapter, Z

public class DynamicDetailSleepModifyFragment extends DimPanelFragment
    implements OnWheelChangedListener, OnWheelScrollListener
{

    private static final String a = "Dynamic.Detail.SleepModify";
    private TextView b;
    private TextView c;
    private WheelView d;
    private WheelView e;
    private SportDay f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public DynamicDetailSleepModifyFragment()
    {
    }

    private int a()
    {
        return d.getCurrentItem() + h;
    }

    private int a(int i1, int j1)
    {
        if (i1 < 0)
        {
            return -1440 + (j1 + 60 * (i1 + 24));
        } else
        {
            return j1 + i1 * 60;
        }
    }

    static SportDay a(DynamicDetailSleepModifyFragment dynamicdetailsleepmodifyfragment)
    {
        return dynamicdetailsleepmodifyfragment.f;
    }

    private void a(int i1)
    {
        a(i1, false);
    }

    private void a(int i1, boolean flag)
    {
        d.setCurrentItem(i1 - h, flag);
    }

    private void a(View view)
    {
        b = (TextView)view.findViewById(0x7f0a00ce);
        c = (TextView)view.findViewById(0x7f0a00cf);
        d = (WheelView)view.findViewById(0x7f0a00d0);
        e = (WheelView)view.findViewById(0x7f0a00d1);
        Bundle bundle = getArguments();
        f = (SportDay)bundle.getSerializable("CurrentDay");
        g = bundle.getInt("Type");
        h = bundle.getInt("MinHour");
        i = bundle.getInt("MaxHour");
        j = bundle.getInt("CurrentHour");
        k = bundle.getInt("CurrentMinute");
        l = bundle.getInt("LimitStart");
        m = bundle.getInt("LimitEnd");
        g;
        JVM INSTR lookupswitch 2: default 172
    //                   1: 410
    //                   16: 422;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_422;
_L4:
        PickAdapter pickadapter;
        PickAdapter pickadapter1;
        if (j >= 0)
        {
            c.setText(0x7f0d005b);
        } else
        {
            c.setText(0x7f0d005e);
        }
        pickadapter = new PickAdapter(getActivity(), h, i, d, getResources().getColor(0x7f090003), getResources().getColor(0x7f090036), 0x88999999, false, 46, 8, 7, 7, 1);
        pickadapter.setMode(9);
        d.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d00cd), 0x7f090003, 18F).setViewAdapter(pickadapter);
        a(j);
        d.addChangingListener(this);
        d.addScrollingListener(this);
        pickadapter1 = new PickAdapter(getActivity(), 0, 59, e, getResources().getColor(0x7f090003), getResources().getColor(0x7f090036), 0x88999999, true, 46, 8, 7, 7, 1);
        e.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d00f8), 0x7f090003, 18F).setViewAdapter(pickadapter1);
        b(k);
        e.addChangingListener(this);
        e.addScrollingListener(this);
        return;
_L2:
        b.setText(0x7f0d006d);
          goto _L4
        b.setText(0x7f0d006c);
          goto _L4
    }

    private void a(DaySportData daysportdata)
    {
        if (daysportdata == null)
        {
            return;
        }
        SleepInfo sleepinfo = daysportdata.getSleepInfo();
        if (sleepinfo == null)
        {
            sleepinfo = new SleepInfo();
        }
        cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData dynamicdata = ChartData.getDynamicData();
        dynamicdata.setSleepTime(sleepinfo.getSleepCount());
        dynamicdata.setSleepDeepTime(sleepinfo.getNonRemCount());
        dynamicdata.setSleepStartDate(sleepinfo.getStartDate());
        dynamicdata.setSleepStopDate(sleepinfo.getStopDate());
    }

    private int b()
    {
        return e.getCurrentItem() % 60;
    }

    private void b(int i1)
    {
        b(i1, false);
    }

    private void b(int i1, boolean flag)
    {
        e.setCurrentItemLooped(i1, flag);
    }

    private void b(DaySportData daysportdata)
    {
        if (daysportdata == null)
        {
            return;
        }
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("date", f.getKey());
            jsonobject.put("summary", daysportdata.getSummary());
            jsonarray.put(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        WebAPI.syncSummaryToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, jsonarray.toString(), new Z(this));
    }

    private int[] c(int i1)
    {
        int ai[] = new int[2];
        if (i1 < 0)
        {
            ai[0] = -1 + (i1 + 1) / 60;
            ai[1] = i1 % 60;
            if (ai[1] != 0)
            {
                ai[1] = 60 + ai[1];
            }
            return ai;
        } else
        {
            ai[0] = i1 / 60;
            ai[1] = i1 % 60;
            return ai;
        }
    }

    protected int inflateLayout()
    {
        return 0x7f030027;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(getView());
    }

    public void onChanged(WheelView wheelview, int i1, int j1)
    {
label0:
        {
            if (wheelview == d)
            {
                if (a() < 0)
                {
                    break label0;
                }
                c.setText(0x7f0d005b);
            }
            return;
        }
        c.setText(0x7f0d005e);
    }

    protected void onEmptyAreaClicked()
    {
        super.onEmptyAreaClicked();
        if (g != 1) goto _L2; else goto _L1
_L1:
        String s = "SleepTimeStart";
_L4:
        HashMap hashmap = new HashMap();
        hashmap.put("Type", s);
        hashmap.put("Confirm", "False");
        UmengAnalytics.event(getActivity(), "DynamicDetailModifySleepTime", hashmap);
        return;
_L2:
        int i1 = g;
        s = null;
        if (i1 == 16)
        {
            s = "SleepTimeEnd";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onLeftButtonClicked()
    {
        super.onLeftButtonClicked();
        if (g != 1) goto _L2; else goto _L1
_L1:
        String s = "SleepTimeStart";
_L4:
        HashMap hashmap = new HashMap();
        hashmap.put("Type", s);
        hashmap.put("Confirm", "False");
        UmengAnalytics.event(getActivity(), "DynamicDetailModifySleepTime", hashmap);
        return;
_L2:
        int i1 = g;
        s = null;
        if (i1 == 16)
        {
            s = "SleepTimeEnd";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        String s;
        super.onPause();
        s = "PageDynamicDetailModifySleep";
        if (g != 1) goto _L2; else goto _L1
_L1:
        s = "PageDynamicDetailModifySleepStart";
_L4:
        UmengAnalytics.endPage(s);
        return;
_L2:
        if (g == 16)
        {
            s = "PageDynamicDetailModifySleepEnd";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        String s;
        super.onResume();
        s = "PageDynamicDetailModifySleep";
        if (g != 1) goto _L2; else goto _L1
_L1:
        s = "PageDynamicDetailModifySleepStart";
_L4:
        UmengAnalytics.startPage(s);
        return;
_L2:
        if (g == 16)
        {
            s = "PageDynamicDetailModifySleepEnd";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onRightButtomClicked()
    {
        int i1;
        int j1;
        i1 = a();
        j1 = b();
        if (i1 == j && j1 == k) goto _L2; else goto _L1
_L1:
        int k1;
        cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify usersleepmodify;
        k1 = a(i1, j1);
        StringBuilder stringbuilder = (new StringBuilder()).append("Sleep Time Modified : ").append(i1).append(":");
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(j1);
        Debug.i("Dynamic.Detail.SleepModify", stringbuilder.append(String.format("%02d", aobj)).append(" , ").append(k1).append(" , ").append(g).append(" , ").append(f).toString());
        usersleepmodify = ChartData.getDynamicData().getUserSleepModify(f);
        g;
        JVM INSTR lookupswitch 2: default 172
    //                   1: 307
    //                   16: 316;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_316;
_L6:
        ChartData.getDynamicData().putUserSleepModify(f, usersleepmodify);
        DataManager datamanager = DataManager.getInstance();
        DaySportData daysportdata = datamanager.get(f);
        if (daysportdata != null)
        {
            daysportdata.setNeedSync(true);
            daysportdata.setNeedPostProcess(true);
        }
        datamanager.analysis();
        datamanager.saveToDb();
        a(daysportdata);
        EventBus.getDefault().post(new EventDynamicDetailSleepUserModified());
        String s;
        HashMap hashmap;
        if (g == 1)
        {
            s = "SleepTimeStart";
        } else
        {
            int l1 = g;
            s = null;
            if (l1 == 16)
            {
                s = "SleepTimeEnd";
            }
        }
        hashmap = new HashMap();
        hashmap.put("Type", s);
        hashmap.put("Confirm", "True");
        UmengAnalytics.event(getActivity(), "DynamicDetailModifySleepTime", hashmap);
_L2:
        dismiss();
        return;
_L4:
        usersleepmodify.sleepStart = k1;
          goto _L6
        usersleepmodify.sleepEnd = k1;
          goto _L6
    }

    public void onScrollingFinished(WheelView wheelview)
    {
        int k1;
        int i1 = a();
        int j1 = b();
        k1 = a(i1, j1);
        StringBuilder stringbuilder = (new StringBuilder()).append("Selection Time : ").append(i1).append(":");
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(j1);
        Debug.i("Dynamic.Detail.SleepModify", stringbuilder.append(String.format("%02d", aobj)).append(" , ").append(k1).toString());
        if (l <= 0x80000000 || k1 >= l) goto _L2; else goto _L1
_L1:
        int ai[];
        ai = c(l);
        StringBuilder stringbuilder3 = (new StringBuilder()).append("Selection Time Is Before : ").append(ai[0]).append(":");
        Object aobj3[] = new Object[1];
        aobj3[0] = Integer.valueOf(ai[1]);
        Log.w("Dynamic.Detail.SleepModify", stringbuilder3.append(String.format("%02d", aobj3)).toString());
_L4:
        Calendar calendar = Calendar.getInstance();
        int j2 = 60 * calendar.get(11) + calendar.get(12);
        if (k1 > j2 && f.equals(calendar))
        {
            ai = c(j2);
            StringBuilder stringbuilder2 = (new StringBuilder()).append("Selection Time Is After : ").append(ai[0]).append(":");
            Object aobj2[] = new Object[1];
            aobj2[0] = Integer.valueOf(ai[1]);
            Log.w("Dynamic.Detail.SleepModify", stringbuilder2.append(String.format("%02d", aobj2)).toString());
        }
        if (ai != null)
        {
            a(ai[0], true);
            b(ai[1], true);
        }
        return;
_L2:
        int l1 = m;
        ai = null;
        if (l1 > 0x80000000)
        {
            int i2 = m;
            ai = null;
            if (k1 > i2)
            {
                ai = c(m);
                StringBuilder stringbuilder1 = (new StringBuilder()).append("Selection Time Is After : ").append(ai[0]).append(":");
                Object aobj1[] = new Object[1];
                aobj1[0] = Integer.valueOf(ai[1]);
                Log.w("Dynamic.Detail.SleepModify", stringbuilder1.append(String.format("%02d", aobj1)).toString());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onScrollingStarted(WheelView wheelview)
    {
    }
}
