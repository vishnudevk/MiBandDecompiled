// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

public class WeekAdapter extends BaseAdapter
{

    private static final String a = "WeekAdapter";
    protected final Context mContext;
    protected int mDays;
    protected int mSetDays;
    protected String mShowItems[];

    public WeekAdapter(Context context, String as[], int i)
    {
        mContext = context;
        mDays = i;
        mShowItems = as;
        Debug.i("WeekAdapter", (new StringBuilder()).append("mDays =").append(Long.toHexString(mDays)).toString());
    }

    public int getCount()
    {
        return mShowItems.length;
    }

    public int getDays()
    {
        return mSetDays;
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
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f030069, null);
        }
        TextView textview = (TextView)view.findViewById(0x7f0a0200);
        textview.setText(mShowItems[i]);
        ImageView imageview = (ImageView)view.findViewById(0x7f0a01ff);
        imageview.setImageResource(0x7f020009);
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
            imageview.setVisibility(0);
            textview.setTextColor(mContext.getResources().getColor(0x7f090027));
            return view;
        } else
        {
            imageview.setVisibility(4);
            textview.setTextColor(mContext.getResources().getColor(0x7f090039));
            return view;
        }
    }

    public void setDays(int i)
    {
        mDays = i;
        notifyDataSetChanged();
    }
}
