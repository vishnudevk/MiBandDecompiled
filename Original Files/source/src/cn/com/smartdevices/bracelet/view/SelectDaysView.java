// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            WeekAdapter

public class SelectDaysView extends LinearLayout
{

    private ListView a;
    private Context b;
    private int c;
    private String d[];
    private WeekAdapter e;

    public SelectDaysView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SelectDaysView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        b = null;
        c = 0;
        d = null;
        b = context;
        View view = LayoutInflater.from(b).inflate(0x7f030064, null);
        a = (ListView)view.findViewById(0x7f0a01d7);
        addView(view);
    }

    public int getDays()
    {
        return e.getDays();
    }

    public void setAdapter(WeekAdapter weekadapter)
    {
        e = weekadapter;
        a.setAdapter(weekadapter);
    }

    public void setDays(int i)
    {
        e.setDays(i);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        a.setOnItemClickListener(onitemclicklistener);
    }
}
