// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, cm

public class UnlockScreenInvalidHelperActivity extends SystemBarTintActivity
{

    public UnlockScreenInvalidHelperActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030013);
        findViewById(0x7f0a008e).setOnClickListener(new cm(this));
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageUnlockInvaildHelp");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageUnlockInvaildHelp");
        UmengAnalytics.startSession(this);
    }
}
