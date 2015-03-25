// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

public class DimPanelBottomBar extends FrameLayout
{

    private static final String a = "dark";
    private final TextView b;
    private final TextView c;

    public DimPanelBottomBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DimPanelBottomBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        LayoutInflater.from(context).inflate(0x7f03001c, this);
        c = (TextView)findViewById(0x7f0a00a0);
        b = (TextView)findViewById(0x7f0a00a2);
        View view = findViewById(0x7f0a009f);
        View view1 = findViewById(0x7f0a00a1);
        TypedArray typedarray = getContext().obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.DimPanelFragmentBottomBar);
        String s = typedarray.getString(0);
        String s1 = typedarray.getString(1);
        int j = typedarray.getColor(2, getResources().getColor(0x7f090039));
        int k = typedarray.getColor(3, getResources().getColor(0x7f090039));
        String s2 = typedarray.getString(4);
        Debug.i(getClass().getName(), (new StringBuilder()).append("left:").append(s).append(", right:").append(s1).toString());
        int l = 0x7f020051;
        int i1 = 0x7f020052;
        int j1 = 0x7f020053;
        if ("dark".equals(s2))
        {
            l = 0x7f020050;
            i1 = 0x7f020054;
            j1 = 0x7f020055;
            view1.setBackgroundResource(0x7f090014);
        }
        if (TextUtils.isEmpty(s))
        {
            c.setVisibility(8);
        } else
        {
            c.setText(s);
            c.setVisibility(0);
            c.setBackgroundResource(l);
        }
        if (TextUtils.isEmpty(s1))
        {
            b.setVisibility(8);
        } else
        {
            b.setText(s1);
            b.setVisibility(0);
            b.setBackgroundResource(l);
        }
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            view1.setVisibility(0);
            view.setBackgroundResource(l);
            b.setBackgroundResource(j1);
            c.setBackgroundResource(i1);
        } else
        {
            view1.setVisibility(8);
            view.setBackgroundResource(0x7f090053);
        }
        c.setTextColor(j);
        b.setTextColor(k);
        typedarray.recycle();
    }

    public void setLeftButtonTextColor(int i)
    {
        c.setTextColor(i);
    }

    public void setRightButtonTextColor(int i)
    {
        b.setTextColor(i);
    }
}
