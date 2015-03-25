// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.view.SelectDaysView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            AlarmRepeatActivity

class i
    implements android.widget.AdapterView.OnItemClickListener
{

    final AlarmRepeatActivity a;

    i(AlarmRepeatActivity alarmrepeatactivity)
    {
        a = alarmrepeatactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int j, long l)
    {
        Debug.i("AlarmRepeatActivity", (new StringBuilder()).append("onItemClick: ").append(j).toString());
        int k = AlarmClockItem.WEEK_MASK[j];
        int i1 = (1 << j & AlarmRepeatActivity.a(a)) >> j;
        Debug.i("AlarmRepeatActivity", (new StringBuilder()).append("thebit at position: ").append(j).append(", thebit=").append(i1).toString());
        AlarmRepeatActivity alarmrepeatactivity = a;
        int j1;
        if (i1 == 0)
        {
            j1 = k | AlarmRepeatActivity.a(a);
        } else
        {
            j1 = AlarmRepeatActivity.a(a) & ~k;
        }
        AlarmRepeatActivity.a(alarmrepeatactivity, j1);
        AlarmRepeatActivity.b(a).setDays(AlarmRepeatActivity.a(a));
        AlarmRepeatActivity.c(a);
    }
}
