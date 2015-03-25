// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, StatisticFragment

public class StatisticActivity extends SystemBarTintActivity
{

    public StatisticActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
        String s;
        super.onCreate(bundle);
        disableAutoApplyStatusBarTint();
        intent = getIntent();
        s = intent.getStringExtra("type");
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.compareTo("weekreport") != 0) goto _L4; else goto _L3
_L3:
        Debug.i("chenee", "weeeeeeeeeeeeeeeeekkkkkkkkkkkk");
_L2:
        Bundle bundle1 = null;
        if (intent != null)
        {
            bundle1 = intent.getExtras();
        }
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.add(0x1020002, Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/StatisticFragment.getName(), bundle1));
        fragmenttransaction.commit();
        return;
_L4:
        if (s.compareTo("monthreport") == 0)
        {
            Debug.i("chenee", "mooooooooooooooooothhhhhhhhhh");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onPause()
    {
        super.onPause();
        AnalyticsTrackerManager.endTimedEvent(new String[] {
            "EventStatisticPage"
        });
        AnalyticsTrackerManager.endSession(this);
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        AnalyticsTrackerManager.startSession(this, Keeper.readPersonInfo().uid);
        AnalyticsTrackerManager.trackTimedEvent("EventStatisticPage");
        UmengAnalytics.startSession(this);
    }
}
