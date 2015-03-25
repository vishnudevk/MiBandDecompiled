// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;

public class PersonInfoBaseActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "PersonInfoBaseActivity";
    private View b;
    private View c;
    protected PersonInfo mPersonInfo;

    public PersonInfoBaseActivity()
    {
        b = null;
        c = null;
        mPersonInfo = null;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
            super.onActivityResult(i, j, intent);
            Debug.i("PersonInfoBaseActivity", (new StringBuilder()).append("onActivityResult: ").append(getLocalClassName()).append(", requestCode=").append(i).append(", result:").append(j).toString());
            if (i == 6)
            {
                if (j != -1)
                {
                    break label0;
                }
                Debug.i("PersonInfoBaseActivity", (new StringBuilder()).append("finish page: ").append(getLocalClassName()).toString());
                setResult(-1);
                finish();
            }
            return;
        }
        mPersonInfo = Keeper.readPersonInfo();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        onCancel();
    }

    public void onCancel()
    {
        Debug.i("PersonInfoBaseActivity", "onCancel");
        Keeper.keepPersonInfo(mPersonInfo);
        setResult(0);
        finish();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361953: 
        default:
            return;

        case 2131361952: 
            onCancel();
            return;

        case 2131361954: 
            onNext();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPersonInfo = Keeper.readPersonInfo();
        b = findViewById(0x7f0a00a2);
        b.setOnClickListener(this);
        c = findViewById(0x7f0a00a0);
        c.setOnClickListener(this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onNext()
    {
        Debug.i("PersonInfoBaseActivity", (new StringBuilder()).append("onNext(), personInfo = ").append(mPersonInfo).toString());
        Keeper.keepPersonInfo(mPersonInfo);
    }
}
