// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.PickAdapter;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.person:
//            PersonInfoBaseActivity, a

public class PersonInfoSetSportGoalActivity extends PersonInfoBaseActivity
    implements android.view.View.OnClickListener
{

    public static final int VALUE_GAP = 1000;
    private static final String a = "PersonInfoSetSportGoalActivity";
    private WheelView b;
    private TextView c;

    public PersonInfoSetSportGoalActivity()
    {
    }

    private void a()
    {
        mPersonInfo.setDaySportGoals(2000 + 1000 * b.getCurrentItem());
        Debug.i("PersonInfoSetSportGoalActivity", (new StringBuilder()).append("goalStep = ").append(mPersonInfo.getDaySportGoalSteps()).toString());
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            setResult(-1);
            finish();
            Intent intent = new Intent();
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
            startActivity(intent);
            return;
        } else
        {
            CustomToast.makeText(this, "\u540C\u6B65\u5230\u670D\u52A1\u5668\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5\uFF01", 0).show();
            return;
        }
    }

    public void onCancel()
    {
        a();
        Debug.i("PersonInfoSetSportGoalActivity", "onCancel");
        super.onCancel();
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f03000d);
        super.onCreate(bundle);
        b = (WheelView)findViewById(0x7f0a0058);
        b.setVisibleItems(5).setCenterDrawable(0x7f0200b9).setCenterStyle(getString(0x7f0d01ad), 0x7f090014, 12, 60F, 5.5F).setViewAdapter(new PickAdapter(this, 2, 30, b, getResources().getColor(0x7f090052), getResources().getColor(0x7f090014), getResources().getColor(0x7f090016), false, 50, 16, 15, 15, 1000));
        c = (TextView)findViewById(0x7f0a0057);
        if (mPersonInfo.age >= 17) goto _L2; else goto _L1
_L1:
        c.setText(0x7f0d0124);
        if (mPersonInfo.getDaySportGoalSteps() < 0)
        {
            mPersonInfo.setDaySportGoals(12000);
        }
_L4:
        int i = (-2000 + mPersonInfo.getDaySportGoalSteps()) / 1000;
        Debug.i("PersonInfoSetSportGoalActivity", (new StringBuilder()).append("curitem:").append(i).toString());
        b.setCurrentItem(i);
        return;
_L2:
        c.setText(0x7f0d0123);
        if (mPersonInfo.getDaySportGoalSteps() < 0)
        {
            mPersonInfo.setDaySportGoals(8000);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onNext()
    {
        a();
        Debug.i("PersonInfoSetSportGoalActivity", "onNext");
        super.onNext();
        mPersonInfo.setNeedSyncServer(2);
        Keeper.keepPersonInfo(mPersonInfo);
        updateProfile(mPersonInfo);
        a(true);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideGoal");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideGoal");
        UmengAnalytics.startSession(this);
    }

    public void updateProfile(PersonInfo personinfo)
    {
        LoginData logindata = Keeper.readLoginData();
        personinfo.uid = logindata.uid;
        WebAPI.updateProfile(logindata, personinfo, new a(this, personinfo));
    }
}
