// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingFeedbackFragment

class bF
    implements android.view.View.OnClickListener
{

    final SettingFeedbackFragment a;

    bF(SettingFeedbackFragment settingfeedbackfragment)
    {
        a = settingfeedbackfragment;
        super();
    }

    public void onClick(View view)
    {
        if (a.getActivity() != null)
        {
            a.getActivity().finish();
        }
    }
}
