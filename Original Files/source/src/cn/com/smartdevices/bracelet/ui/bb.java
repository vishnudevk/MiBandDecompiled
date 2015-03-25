// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            NewAlarmActivity

class bb
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final NewAlarmActivity a;

    bb(NewAlarmActivity newalarmactivity)
    {
        a = newalarmactivity;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            NewAlarmActivity.a(a).setDuration(30);
            return;
        } else
        {
            NewAlarmActivity.a(a).setDuration(0);
            return;
        }
    }
}
