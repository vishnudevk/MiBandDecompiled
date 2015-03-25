// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            AlarmActivity, f, h

class e extends BaseAdapter
{

    private static final String b = "AlarmAdapter";
    final AlarmActivity a;
    private final String c;

    public e(AlarmActivity alarmactivity)
    {
        a = alarmactivity;
        super();
        c = AlarmActivity.c(alarmactivity).getResources().getString(0x7f0d0045);
    }

    public int getCount()
    {
        Debug.i("AlarmAdapter", "getCount");
        return AlarmActivity.d(a).size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        AlarmClockItem alarmclockitem = (AlarmClockItem)AlarmActivity.d(a).get(i);
        View view1 = LayoutInflater.from(AlarmActivity.c(a)).inflate(0x7f030063, null);
        TextView textview = (TextView)view1.findViewById(0x7f0a01d2);
        TextView textview1 = (TextView)view1.findViewById(0x7f0a01d4);
        TextView textview2 = (TextView)view1.findViewById(0x7f0a01d3);
        TextView textview3 = (TextView)view1.findViewById(0x7f0a01d5);
        if (AlarmActivity.e(a))
        {
            textview2.setVisibility(8);
        } else
        {
            textview2.setVisibility(0);
            if (alarmclockitem.getCalendar().get(9) == 0)
            {
                textview2.setText(0x7f0d0015);
            } else
            {
                textview2.setText(0x7f0d012a);
            }
        }
        textview.setText(alarmclockitem.toTimeString(AlarmActivity.e(a)));
        if (alarmclockitem.isEnabled())
        {
            textview.setTextColor(AlarmActivity.c(a).getResources().getColor(0x7f090039));
            Switch switch1;
            RelativeLayout relativelayout;
            if (alarmclockitem.isSmartWakeup())
            {
                textview1.setText(alarmclockitem.toWeekString(AlarmActivity.c(a)));
                textview3.setVisibility(0);
            } else
            {
                textview1.setText(alarmclockitem.toWeekString(AlarmActivity.c(a)));
                textview3.setVisibility(8);
            }
        } else
        {
            textview.setTextColor(AlarmActivity.c(a).getResources().getColor(0x7f090036));
            textview.setText(alarmclockitem.toTimeString(AlarmActivity.e(a)));
            textview1.setText(c);
        }
        switch1 = (Switch)view1.findViewById(0x7f0a01d6);
        switch1.setChecked(alarmclockitem.isEnabled());
        switch1.setOnCheckedChangeListener(new f(this, alarmclockitem));
        relativelayout = (RelativeLayout)view1.findViewById(0x7f0a01d1);
        relativelayout.setTag(Integer.valueOf(i));
        relativelayout.setOnClickListener(new h(this));
        return view1;
    }
}
