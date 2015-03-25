// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingFragment

class bQ
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final SettingFragment a;

    bQ(SettingFragment settingfragment)
    {
        a = settingfragment;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            SettingFragment.a(a).enableInComingCallTime();
        } else
        {
            SettingFragment.a(a).disableInComingCallTime();
        }
        SettingFragment.a(a).setNeedSyncServer(2);
        Keeper.keepPersonInfo(SettingFragment.a(a));
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
    }
}
