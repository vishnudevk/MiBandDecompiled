// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, cl

public class UnBindActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public UnBindActivity()
    {
    }

    private void a()
    {
        Utils.showProgressDialog(this, 0x7f0d01bd);
        Debug.f("switch", "unbind device now!");
        Keeper.keepBraceletBtInfo(new BraceletBtInfo());
        Keeper.keepSyncTime(-1L);
        Keeper.keepSyncRealStepTime(-1L);
        Keeper.keepNeedBind(0);
        Utils.switchBracelet(this, 0);
        (new Handler()).postDelayed(new cl(this), 3000L);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361952: 
            a();
            UmengAnalytics.event(this, "BraceletUnbind", "Confirmed");
            return;

        case 2131361844: 
        case 2131361954: 
            finish();
            UmengAnalytics.event(this, "BraceletUnbind", "Canceled");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030034);
        findViewById(0x7f0a0034).setOnClickListener(this);
        findViewById(0x7f0a00a0).setOnClickListener(this);
        findViewById(0x7f0a00a2).setOnClickListener(this);
        if (!Utils.isSupportUnlockScreenByBracelet(this))
        {
            ((TextView)findViewById(0x7f0a00eb)).setVisibility(4);
        }
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletUnbind");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletUnbind");
        UmengAnalytics.startSession(this);
    }
}
