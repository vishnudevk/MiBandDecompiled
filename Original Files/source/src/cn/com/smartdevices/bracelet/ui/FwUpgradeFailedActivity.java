// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity

public class FwUpgradeFailedActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public FwUpgradeFailedActivity()
    {
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361840: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030002);
        findViewById(0x7f0a0030).setOnClickListener(this);
    }
}
