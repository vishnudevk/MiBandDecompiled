// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, FwUpgradeFailedActivity, aj, ak

public class FwLowBatteryActivity extends SystemBarTintActivity
{

    private TextView a;
    private Button b;

    public FwLowBatteryActivity()
    {
        a = null;
        b = null;
    }

    private void a()
    {
        startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/FwUpgradeFailedActivity));
    }

    static void a(FwLowBatteryActivity fwlowbatteryactivity)
    {
        fwlowbatteryactivity.a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030003);
        a = (TextView)findViewById(0x7f0a0031);
        a.getPaint().setFlags(8);
        a.setOnClickListener(new aj(this));
        b = (Button)findViewById(0x7f0a0032);
        b.setOnClickListener(new ak(this));
    }
}
