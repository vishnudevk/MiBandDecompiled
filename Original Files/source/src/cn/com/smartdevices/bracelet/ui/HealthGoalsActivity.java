// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetGoalsTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, PickAdapter, au, av

public class HealthGoalsActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "HealthGoalsActivity";
    private static final int b = 1000;
    private PersonInfo c;
    private WheelView d;
    private TextView e;

    public HealthGoalsActivity()
    {
    }

    static PersonInfo a(HealthGoalsActivity healthgoalsactivity)
    {
        return healthgoalsactivity.c;
    }

    private void a()
    {
        d = (WheelView)findViewById(0x7f0a0058);
        d.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d01ad), 0x7f090036, 12, 60F, 5.5F).setViewAdapter(new PickAdapter(this, 2, 30, d, getResources().getColor(0x7f090039), getResources().getColor(0x7f090037), getResources().getColor(0x7f090038), false, 50, 16, 15, 15, 1000));
        e = (TextView)findViewById(0x7f0a0057);
        if (c.age >= 17) goto _L2; else goto _L1
_L1:
        e.setText(0x7f0d0124);
        if (c.getDaySportGoalSteps() < 0)
        {
            c.setDaySportGoals(12000);
        }
_L4:
        int i = (-2000 + c.getDaySportGoalSteps()) / 1000;
        Debug.i("HealthGoalsActivity", (new StringBuilder()).append("curitem:").append(i).toString());
        d.setCurrentItem(i);
        findViewById(0x7f0a0041).setOnClickListener(this);
        findViewById(0x7f0a0042).setOnClickListener(this);
        return;
_L2:
        e.setText(0x7f0d0123);
        if (c.getDaySportGoalSteps() < 0)
        {
            c.setDaySportGoals(8000);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b()
    {
        int i = c.getDaySportGoalSteps();
        int j = 2000 + 1000 * d.getCurrentItem();
        if (i == j)
        {
            setResult(-1);
            finish();
            return;
        } else
        {
            c.setDaySportGoals(j);
            Debug.i("HealthGoalsActivity", (new StringBuilder()).append("goalStep = ").append(c.getDaySportGoalSteps()).toString());
            (new BleSetGoalsTask(c.getDaySportGoalSteps(), new au(this))).work();
            Keeper.keepPersonInfo(c);
            updateProfile(c);
            Debug.i("HealthGoalsActivity", "sync goal to mili ok.");
            EventBus.getDefault().post(new EventGoalsUpdated());
            setResult(-1);
            finish();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361857: 
            finish();
            return;

        case 2131361858: 
            b();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004e);
        c = Keeper.readPersonInfo();
        a();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        UmengAnalytics.event(this, "BraceletGoal", c.getDaySportGoalSteps());
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
        super.onResume();
        UmengAnalytics.endPage("PageBraceletGoal");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletGoal");
        UmengAnalytics.startSession(this);
    }

    public void updateProfile(PersonInfo personinfo)
    {
        LoginData logindata = Keeper.readLoginData();
        personinfo.uid = logindata.uid;
        WebAPI.updateProfile(logindata, personinfo, new av(this, personinfo));
    }
}
