// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.HelpActivity;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.view.CustomToast;

public class BraceletNotFoundActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public BraceletNotFoundActivity()
    {
    }

    public void onBackPressed()
    {
        CustomToast.makeText(this, 0x7f0d0140, 0).show();
        setResult(0);
        finish();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361946: 
            startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity));
            finish();
            return;

        case 2131361944: 
            Keeper.keepNeedBind(0);
            startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/MainUIActivity));
            finish();
            return;

        case 2131361945: 
            startActivity(new Intent(this, cn/com/smartdevices/bracelet/ui/HelpActivity));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030018);
        ((Button)findViewById(0x7f0a009a)).setOnClickListener(this);
        findViewById(0x7f0a0099).setOnClickListener(this);
        TextView textview = (TextView)findViewById(0x7f0a0098);
        textview.setText(Html.fromHtml((new StringBuilder()).append("<u>").append(getString(0x7f0d0069)).append("</u>").toString()));
        textview.setOnClickListener(this);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletNotFound");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletNotFound");
        UmengAnalytics.startSession(this);
    }
}
