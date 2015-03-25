// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui.person:
//            PersonInfoBaseActivity, PersonInfoSetAgeActivity

public class PersonInfoSetGenderActivity extends PersonInfoBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "PersonInfoSetGenderActivity";
    private ImageView b;
    private ImageView c;
    private View d;
    private DimPanelBottomBar e;

    public PersonInfoSetGenderActivity()
    {
    }

    private void a()
    {
        int i = mPersonInfo.gender;
        if (i == 1)
        {
            b.setImageResource(0x7f020089);
            c.setImageResource(0x7f02005f);
            d.setBackgroundResource(0x7f090004);
            e.setLeftButtonTextColor(getResources().getColor(0x7f090014));
            e.setRightButtonTextColor(getResources().getColor(0x7f090052));
            return;
        }
        if (i == 0)
        {
            c.setImageResource(0x7f020060);
            b.setImageResource(0x7f020088);
            d.setBackgroundResource(0x7f090009);
            e.setLeftButtonTextColor(getResources().getColor(0x7f090014));
            e.setRightButtonTextColor(getResources().getColor(0x7f090052));
            return;
        } else
        {
            e.setLeftButtonTextColor(getResources().getColor(0x7f090014));
            e.setRightButtonTextColor(getResources().getColor(0x7f09001f));
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131361876 2131361877: default 28
    //                   2131361876 34
    //                   2131361877 49;
           goto _L1 _L2 _L3
_L1:
        super.onClick(view);
        return;
_L2:
        mPersonInfo.gender = 1;
        a();
        continue; /* Loop/switch isn't completed */
_L3:
        mPersonInfo.gender = 0;
        a();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        setContentView(0x7f03000b);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String s = intent.getStringExtra("miliao_icon_url");
        if (s != null && s.length() > 0)
        {
            mPersonInfo.avatarUrl = s;
        }
        String s1 = intent.getStringExtra("miliao_nick_name");
        if (s1 != null && s1.length() > 0)
        {
            mPersonInfo.nickname = intent.getStringExtra("miliao_nick_name");
        }
        b = (ImageView)findViewById(0x7f0a0054);
        b.setOnClickListener(this);
        c = (ImageView)findViewById(0x7f0a0055);
        c.setOnClickListener(this);
        e = (DimPanelBottomBar)findViewById(0x7f0a0051);
        d = findViewById(0x7f0a0052);
        a();
    }

    public void onNext()
    {
        super.onNext();
        if (mPersonInfo.gender != 1 && mPersonInfo.gender != 0)
        {
            CustomToast.makeText(this, 0x7f0d0127, 0).show();
            return;
        } else
        {
            Intent intent = new Intent();
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetAgeActivity);
            startActivityForResult(intent, 6);
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonGuideGender");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonGuideGender");
        UmengAnalytics.startSession(this);
    }
}
