// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity

public class HelpActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public HelpActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362145: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004f);
        findViewById(0x7f0a0161).setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletNotFoundHelp");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletNotFoundHelp");
        UmengAnalytics.startSession(this);
    }
}
