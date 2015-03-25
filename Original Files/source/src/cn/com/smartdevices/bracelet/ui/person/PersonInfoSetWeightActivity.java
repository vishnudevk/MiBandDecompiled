// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.PickAdapter;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.person:
//            PersonInfoBaseActivity, PersonInfoSetSportGoalActivity

public class PersonInfoSetWeightActivity extends PersonInfoBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "PersonInfoSetWeightActivity";
    private WheelView b;

    public PersonInfoSetWeightActivity()
    {
    }

    private void a()
    {
        mPersonInfo.weight = 20 + b.getCurrentItem();
        Debug.i("PersonInfoSetWeightActivity", (new StringBuilder()).append("weight = ").append(mPersonInfo.weight).toString());
    }

    public void onCancel()
    {
        a();
        Debug.i("PersonInfoSetWeightActivity", "onCancel");
        super.onCancel();
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f03000e);
        super.onCreate(bundle);
        b = (WheelView)findViewById(0x7f0a0059);
        b.setVisibleItems(5).setCenterDrawable(0x7f0200b9).setCenterStyle(getString(0x7f0d00da), 0x7f090014, 12, 40F, 5.5F).setViewAdapter(new PickAdapter(this, 20, 205, b, getResources().getColor(0x7f090052), getResources().getColor(0x7f090014), getResources().getColor(0x7f090016), false, 50, 16, 15, 15));
        if (mPersonInfo.weight > 0)
        {
            b.setCurrentItem(-20 + mPersonInfo.weight);
            return;
        } else
        {
            b.setCurrentItem(40);
            return;
        }
    }

    public void onNext()
    {
        a();
        Debug.i("PersonInfoSetWeightActivity", "onNext");
        super.onNext();
        Intent intent = new Intent();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetSportGoalActivity);
        startActivityForResult(intent, 6);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideWeight");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideWeight");
        UmengAnalytics.startSession(this);
    }
}
