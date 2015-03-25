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
//            PersonInfoBaseActivity, PersonInfoSetWeightActivity

public class PersonInfoSetHeightActivity extends PersonInfoBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "PersonInfoSetHeightActivity";
    private WheelView b;

    public PersonInfoSetHeightActivity()
    {
    }

    private void a()
    {
        mPersonInfo.height = 90 + b.getCurrentItem();
        Debug.i("PersonInfoSetHeightActivity", (new StringBuilder()).append("height = ").append(mPersonInfo.height).toString());
    }

    public void onCancel()
    {
        a();
        Debug.i("PersonInfoSetHeightActivity", "onCancel");
        super.onCancel();
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f03000c);
        super.onCreate(bundle);
        b = (WheelView)findViewById(0x7f0a0056);
        b.setVisibleItems(5).setCenterDrawable(0x7f0200b9).setCenterStyle(getString(0x7f0d0046), 0x7f090014, 12, 40F, 5.5F).setViewAdapter(new PickAdapter(this, 90, 230, b, getResources().getColor(0x7f090052), getResources().getColor(0x7f090014), getResources().getColor(0x7f090016), false, 50, 16, 15, 15));
        if (mPersonInfo.height > 0)
        {
            b.setCurrentItem(-90 + mPersonInfo.height);
            return;
        } else
        {
            b.setCurrentItem(80);
            return;
        }
    }

    public void onNext()
    {
        a();
        Debug.i("PersonInfoSetHeightActivity", "onNext");
        super.onNext();
        Intent intent = new Intent();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetWeightActivity);
        startActivityForResult(intent, 6);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideHeight");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideHeight");
        UmengAnalytics.startSession(this);
    }
}
