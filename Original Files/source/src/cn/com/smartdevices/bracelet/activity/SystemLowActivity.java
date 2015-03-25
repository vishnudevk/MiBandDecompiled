// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;

public class SystemLowActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public SystemLowActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361858: 
            setResult(-1);
            break;
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030060);
        ((Button)findViewById(0x7f0a0042)).setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageSystemLow");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageSystemLow");
        UmengAnalytics.startSession(this);
    }
}
