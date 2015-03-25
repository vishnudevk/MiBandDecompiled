// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            WeekAdapter

public class DayRepeatAdapter extends WeekAdapter
{

    private static final String a = "DayRepeatAdapter";

    public DayRepeatAdapter(Context context, String as[], int i)
    {
        super(context, as, i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f03006a, null);
        }
        TextView textview = (TextView)view.findViewById(0x7f0a0200);
        textview.setText(mShowItems[i]);
        textview.setTextColor(mContext.getResources().getColor(0x7f090039));
        ImageView imageview = (ImageView)view.findViewById(0x7f0a0201);
        boolean flag;
        if ((mDays & AlarmClockItem.WEEK_MASK[i]) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Debug.i("DayRepeatAdapter", (new StringBuilder()).append("mDays =").append(mDays).append(", checkbox = ").append(imageview).toString());
            imageview.setImageResource(0x7f02004b);
            return view;
        } else
        {
            imageview.setImageResource(0x7f02004c);
            return view;
        }
    }
}
