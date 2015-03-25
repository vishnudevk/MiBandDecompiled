// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingFeedbackFragment

class bE
    implements android.widget.TextView.OnEditorActionListener
{

    final SettingFeedbackFragment a;

    bE(SettingFeedbackFragment settingfeedbackfragment)
    {
        a = settingfeedbackfragment;
        super();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (6 == i)
        {
            a.onClick(SettingFeedbackFragment.a(a));
            return true;
        } else
        {
            return false;
        }
    }
}
