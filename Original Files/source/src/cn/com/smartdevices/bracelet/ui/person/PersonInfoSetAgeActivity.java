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
import java.util.Calendar;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.person:
//            PersonInfoBaseActivity, PersonInfoSetHeightActivity

public class PersonInfoSetAgeActivity extends PersonInfoBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "PersonInfoSetAgeActivity";
    private WheelView b;

    public PersonInfoSetAgeActivity()
    {
    }

    private void a()
    {
        mPersonInfo.age = 5 + b.getCurrentItem();
        int i = Calendar.getInstance().get(1) - mPersonInfo.age;
        mPersonInfo.birthday = (new StringBuilder()).append(i).append("-").append("01").toString();
        Debug.i("PersonInfoSetAgeActivity", (new StringBuilder()).append("birthday = ").append(mPersonInfo.birthday).append(", age =").append(mPersonInfo.age).toString());
    }

    public void onCancel()
    {
        a();
        super.onCancel();
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f03000a);
        super.onCreate(bundle);
        b = (WheelView)findViewById(0x7f0a0050);
        b.setVisibleItems(5).setCenterDrawable(0x7f0200b9).setCenterStyle(getString(0x7f0d000c), 0x7f090014, 12, 40F, 5.5F).setViewAdapter(new PickAdapter(this, 5, 100, b, getResources().getColor(0x7f090052), getResources().getColor(0x7f090014), getResources().getColor(0x7f090016), false, 50, 16, 15, 15));
        Intent intent;
        String s;
        String s1;
        if (mPersonInfo.age > 0)
        {
            b.setCurrentItem(-5 + mPersonInfo.age);
        } else
        {
            b.setCurrentItem(15);
        }
        intent = getIntent();
        s = intent.getStringExtra("miliao_icon_url");
        if (s != null && s.length() > 0)
        {
            mPersonInfo.avatarUrl = s;
        }
        s1 = intent.getStringExtra("miliao_nick_name");
        if (s1 != null && s1.length() > 0)
        {
            mPersonInfo.nickname = intent.getStringExtra("miliao_nick_name");
        }
    }

    public void onNext()
    {
        a();
        super.onNext();
        Intent intent = new Intent();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetHeightActivity);
        startActivityForResult(intent, 6);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideAge");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideAge");
        UmengAnalytics.startSession(this);
    }
}
