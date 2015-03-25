// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import cn.com.smartdevices.bracelet.BleTask.BleSetAlarmClockTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            e, AlarmActivity, g

class f
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final AlarmClockItem a;
    final e b;

    f(e e1, AlarmClockItem alarmclockitem)
    {
        b = e1;
        a = alarmclockitem;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        a.setEnabled(flag);
        AlarmActivity.setAlarmItems(a, AlarmActivity.c(b.a));
        Debug.i("AlarmAdapter", (new StringBuilder()).append("set clocks item:").append(a.toJson()).toString());
        b.notifyDataSetChanged();
        (new BleSetAlarmClockTask(AlarmActivity.d(b.a), new g(this, flag))).work();
    }
}
