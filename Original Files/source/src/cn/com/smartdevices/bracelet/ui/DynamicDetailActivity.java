// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, DynamicDetailFragment

public class DynamicDetailActivity extends SystemBarTintActivity
{

    public DynamicDetailActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        disableAutoApplyStatusBarTint();
        Intent intent = getIntent();
        Bundle bundle1 = null;
        if (intent != null)
        {
            bundle1 = intent.getExtras();
        }
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.add(0x1020002, Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/DynamicDetailFragment.getName(), bundle1));
        fragmenttransaction.commit();
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
        AnalyticsTrackerManager.endTimedEvent(new String[] {
            "EventDynamicDetailPage"
        });
        AnalyticsTrackerManager.endSession(this);
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        AnalyticsTrackerManager.startSession(this, Keeper.readPersonInfo().uid);
        AnalyticsTrackerManager.trackTimedEvent("EventDynamicDetailPage");
        UmengAnalytics.startSession(this);
    }
}
