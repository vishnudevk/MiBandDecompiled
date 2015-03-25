// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.ui.NewAlarmActivity;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            WeekAdapter

public class SimpleAlarmWeekAdapter extends WeekAdapter
{

    private static final int a = 3;
    private static final String b = "SimpleAlarmWeekAdapter";

    public SimpleAlarmWeekAdapter(Context context, String as[], int i)
    {
        super(context, as, i);
    }

    private boolean a()
    {
        for (int i = 0; i < NewAlarmActivity.FIXED_DAYS.length; i++)
        {
            if (mDays == NewAlarmActivity.FIXED_DAYS[i])
            {
                return false;
            }
        }

        return true;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f030069, null);
        }
        View view1 = view.findViewById(0x7f0a01ff);
        view1.setVisibility(4);
        TextView textview = (TextView)view.findViewById(0x7f0a0200);
        textview.setText(mShowItems[i]);
        textview.setTextColor(mContext.getResources().getColor(0x7f090039));
        Debug.i("SimpleAlarmWeekAdapter", (new StringBuilder()).append("Get view : mdays:").append(mDays).append(", pos:").append(i).append(", day:").append(NewAlarmActivity.FIXED_DAYS[i]).toString());
        if (i == 3)
        {
            if (a())
            {
                textview.setTextColor(mContext.getResources().getColor(0x7f090003));
                view1.setVisibility(0);
            }
        } else
        if (mDays == NewAlarmActivity.FIXED_DAYS[i])
        {
            textview.setTextColor(mContext.getResources().getColor(0x7f090003));
            view1.setVisibility(0);
            return view;
        }
        return view;
    }
}
