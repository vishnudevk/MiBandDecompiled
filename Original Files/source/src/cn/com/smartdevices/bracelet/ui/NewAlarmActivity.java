// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetAlarmClockTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.Event12HourUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventAmPmUpdate;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, ExitNewAlarmFragment, DimPanelFragment, bd, 
//            AlarmActivity, bc, ba, PickAdapter, 
//            bb

public class NewAlarmActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public static final int FIXED_DAYS[];
    public static final int INDEX_AM = -11;
    public static final int INDEX_PM = -10;
    private static final String a = "NewAlarmActivity";
    private static final int b = 1;
    private static final int c = 30;
    private static final int d = 0;
    private static final int e = 23;
    private static final int f = 1;
    private static final int g;
    private AlarmClockItem h;
    private WheelView i;
    private WheelView j;
    private View k;
    private Context l;
    private TextView m;
    private PersonInfo n;
    private ArrayList o;
    private Switch p;
    private WheelView q;
    private boolean r;
    private PickAdapter s;
    private String t;

    public NewAlarmActivity()
    {
        h = null;
        l = null;
    }

    static AlarmClockItem a(NewAlarmActivity newalarmactivity)
    {
        return newalarmactivity.h;
    }

    private void a()
    {
        b();
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("mItem = ").append(h.toJson()).toString());
        if (h.toJson().equals(t))
        {
            setResult(0);
            finish();
        }
        ExitNewAlarmFragment exitnewalarmfragment = (ExitNewAlarmFragment)DimPanelFragment.instantiate(this, cn/com/smartdevices/bracelet/ui/ExitNewAlarmFragment.getName());
        exitnewalarmfragment.setOpClickListener(new bd(this));
        exitnewalarmfragment.show(getFragmentManager(), cn/com/smartdevices/bracelet/ui/ExitNewAlarmFragment.getName());
    }

    private void a(int i1)
    {
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("updateHourByAmPm : ").append(i1).toString());
        if (r) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = i.getCurrentItem();
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("cur hour =").append(j1).toString());
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        if (j1 >= 12)
        {
            j1 -= 12;
        }
_L6:
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("after hour =").append(j1).toString());
        i.setCurrentItemLooped(j1);
_L2:
        return;
_L4:
        if (j1 < 12)
        {
            j1 += 12;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void a(NewAlarmActivity newalarmactivity, int i1)
    {
        newalarmactivity.c(i1);
    }

    static Context b(NewAlarmActivity newalarmactivity)
    {
        return newalarmactivity.l;
    }

    private void b()
    {
        int i1 = i.getCurrentItem();
        h.set(i1, j.getCurrentItem(), h.isEnabled());
    }

    private void b(int i1)
    {
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("updateAmPmByHour hour=").append(i1).toString());
        if (q != null && !r)
        {
            WheelView wheelview = q;
            int j1;
            if (i1 >= 12)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            wheelview.setCurrentItem(j1);
        }
    }

    private void c(int i1)
    {
        h.setDays(i1);
        m.setText(h.toWeekString(l));
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("onActivityResult : ").append(i1).append(", result:").append(j1).append(" data=").append(intent).toString());
        if (i1 == 1 && j1 == -1)
        {
            c(intent.getIntExtra("Days", 0));
        }
    }

    public void onBackPressed()
    {
        a();
    }

    public void onClick(View view)
    {
        boolean flag = true;
        Switch switch1;
        switch (view.getId())
        {
        case 2131361859: 
        case 2131361860: 
        default:
            return;

        case 2131361858: 
            h.setEnabled(flag);
            b();
            AlarmActivity.setAlarmItems(h, l);
            (new BleSetAlarmClockTask(o, new bc(this))).work();
            Intent intent = new Intent();
            intent.putExtra("alarms", h.toJson().toString());
            setResult(-1, intent);
            finish();
            return;

        case 2131361857: 
            a();
            return;

        case 2131361861: 
            switch1 = p;
            break;
        }
        if (p.isChecked())
        {
            flag = false;
        }
        switch1.setChecked(flag);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030009);
        l = this;
        EventBus.getDefault().register(this);
        k = findViewById(0x7f0a0049);
        k.setOnClickListener(new ba(this));
        m = (TextView)findViewById(0x7f0a004b);
        q = (WheelView)findViewById(0x7f0a004c);
        PickAdapter pickadapter = new PickAdapter(this, -11, -10, q, getResources().getColor(0x7f090003), getResources().getColor(0x7f090036), 0x88999999, false, 46, 6, 5, 7, 1);
        pickadapter.setUIStyle("normal");
        pickadapter.setMode(17);
        q.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle("", 18F).setViewAdapter(pickadapter);
        i = (WheelView)findViewById(0x7f0a004d);
        s = new PickAdapter(this, 0, 23, i, getResources().getColor(0x7f090003), getResources().getColor(0x7f090036), 0x88999999, true, 46, 8, 7, 7, 1);
        s.setMode(16);
        i.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d00cd), 0x7f090003, 18F).setViewAdapter(s);
        j = (WheelView)findViewById(0x7f0a004e);
        j.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d00f8), 0x7f090003, 18F).setViewAdapter(new PickAdapter(this, 0, 59, j, getResources().getColor(0x7f090003), getResources().getColor(0x7f090036), 0x88999999, true, 46, 8, 7, 7, 1));
        int i1 = getIntent().getIntExtra("ref_alarm_index", 0);
        n = Keeper.readPersonInfo();
        o = n.getAlarmClockItems();
        h = (AlarmClockItem)o.get(i1);
        t = h.toJson();
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("mClockItemKey = ").append(t).toString());
        p = (Switch)findViewById(0x7f0a0047);
        boolean flag;
        if (h.getDuration() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.i("NewAlarmActivity", (new StringBuilder()).append("smartSwitch: ").append(flag).append(", mItem duration=").append(h.getDuration()).toString());
        p.setChecked(flag);
        p.setOnCheckedChangeListener(new bb(this));
        findViewById(0x7f0a0045).setOnClickListener(this);
        m.setText(h.toWeekString(l));
        i.setCurrentItemLooped(h.getHour());
        j.setCurrentItemLooped(h.getMinute());
        findViewById(0x7f0a0042).setOnClickListener(this);
        findViewById(0x7f0a0041).setOnClickListener(this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(Event12HourUpdate event12hourupdate)
    {
        b(event12hourupdate.getHour());
    }

    public void onEvent(EventAmPmUpdate eventampmupdate)
    {
        a(eventampmupdate.getAmPm());
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageAlarmNew");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        new DateFormat();
        r = DateFormat.is24HourFormat(this);
        if (r)
        {
            q.setVisibility(8);
            s.setMode(9);
            i.setViewAdapter(s);
        } else
        {
            q.setVisibility(0);
            s.setMode(16);
            i.setViewAdapter(s);
            b(h.getHour());
        }
        UmengAnalytics.startPage("PageAlarmNew");
        UmengAnalytics.startSession(this);
    }

    static 
    {
        int ai[] = new int[4];
        ai[0] = AlarmClockItem.ALARM_ONCE;
        ai[1] = AlarmClockItem.ALARM_EVERY_DAY;
        ai[2] = AlarmClockItem.ALARM_MON_2_FRI;
        ai[3] = -1;
        FIXED_DAYS = ai;
    }
}
