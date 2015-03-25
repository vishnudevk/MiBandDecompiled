// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;

public class SystemNotSupportActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public SystemNotSupportActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362247: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030061);
        ((Button)findViewById(0x7f0a01c7)).setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageSystemNotSupport");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageSystemNotSupport");
        UmengAnalytics.startSession(this);
    }
}
