// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;

public class MultiBraceletErrActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "MultiBraceletErrActivity";

    public MultiBraceletErrActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 6 && j == -1)
        {
            finish();
        }
    }

    public void onClick(View view)
    {
        Intent intent = new Intent();
        switch (view.getId())
        {
        default:
            return;

        case 2131362161: 
            intent.putExtra("REF_SEARCH_DEV_MODE", false);
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
            startActivity(intent);
            finish();
            return;

        case 2131362160: 
            intent.putExtra("REF_SEARCH_DEV_MODE", true);
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
            startActivityForResult(intent, 6);
            UmengAnalytics.event(this, "StartUpViewBraceletList");
            return;

        case 2131361944: 
            Keeper.keepNeedBind(0);
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/MainUIActivity);
            startActivity(intent);
            finish();
            UmengAnalytics.event(this, "StartUpNotBindBracelet");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030052);
        int i = getIntent().getIntExtra("REF_NOT_KNOCKED", -1);
        Debug.i("MultiBraceletErrActivity", (new StringBuilder()).append("infoResId ").append(i).toString());
        if (i > 0)
        {
            ((TextView)findViewById(0x7f0a016f)).setText(i);
        }
        findViewById(0x7f0a0171).setOnClickListener(this);
        findViewById(0x7f0a0170).setOnClickListener(this);
        TextView textview = (TextView)findViewById(0x7f0a0098);
        textview.setText(Html.fromHtml((new StringBuilder()).append("<u>").append(getString(0x7f0d0069)).append("</u>").toString()));
        textview.setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletConnectFailed");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletConnectFailed");
        UmengAnalytics.startSession(this);
    }
}
