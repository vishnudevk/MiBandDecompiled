// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, PersonInfoFragment

public class PersonInfoActivity extends SystemBarTintActivity
{

    private static final String a = "PersonInfoActivity";

    public PersonInfoActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        PersonInfoFragment personinfofragment = (PersonInfoFragment)getFragmentManager().findFragmentByTag(cn/com/smartdevices/bracelet/ui/PersonInfoFragment.getName());
        Debug.i("PersonInfoActivity", (new StringBuilder()).append("person info fragment =").append(personinfofragment).toString());
        if (personinfofragment != null)
        {
            personinfofragment.onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.add(0x1020002, PersonInfoFragment.newInstance(), cn/com/smartdevices/bracelet/ui/PersonInfoFragment.getName());
        fragmenttransaction.commit();
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startSession(this);
    }
}
