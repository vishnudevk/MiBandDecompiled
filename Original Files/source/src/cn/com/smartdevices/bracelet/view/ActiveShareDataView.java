// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.DynamicShareChartView;
import java.util.HashMap;

public class ActiveShareDataView extends FrameLayout
{

    private DynamicShareChartView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    public ActiveShareDataView(Context context)
    {
        this(context, null, 0);
    }

    public ActiveShareDataView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActiveShareDataView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f030062, this);
        a = (DynamicShareChartView)findViewById(0x7f0a01d0);
        b = (TextView)findViewById(0x7f0a01c9);
        c = (TextView)findViewById(0x7f0a01cb);
        d = (TextView)findViewById(0x7f0a01cf);
        e = (TextView)findViewById(0x7f0a01ce);
    }

    private HashMap a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(Integer.valueOf(1), Integer.valueOf(1000));
        hashmap.put(Integer.valueOf(2), Integer.valueOf(2000));
        hashmap.put(Integer.valueOf(5), Integer.valueOf(3000));
        hashmap.put(Integer.valueOf(7), Integer.valueOf(4000));
        hashmap.put(Integer.valueOf(10), Integer.valueOf(5000));
        hashmap.put(Integer.valueOf(13), Integer.valueOf(6000));
        hashmap.put(Integer.valueOf(14), Integer.valueOf(7000));
        return hashmap;
    }

    public static String[] formatDistance(Context context, int i)
    {
        String as[] = new String[2];
        float f = i;
        if (i >= 1000)
        {
            as[0] = String.valueOf((float)Math.round(100F * (f / 1000F)) / 100F);
            as[1] = context.getString(0x7f0d01c0);
            return as;
        } else
        {
            as[0] = String.valueOf(i);
            as[1] = context.getString(0x7f0d01c1);
            return as;
        }
    }

    public void bindStepData(HashMap hashmap)
    {
        a.bindStepData(hashmap);
    }

    public void setStepCalorie(int i)
    {
        e.setText(String.valueOf(i));
    }

    public void setStepCount(int i)
    {
        b.setText(String.valueOf(i));
    }

    public void setStepDistance(int i)
    {
        String as[] = formatDistance(getContext(), i);
        c.setText(as[0]);
        d.setText(as[1]);
    }
}
