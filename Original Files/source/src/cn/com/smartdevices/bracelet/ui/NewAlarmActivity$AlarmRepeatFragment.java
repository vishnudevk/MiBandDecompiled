// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import cn.com.smartdevices.bracelet.view.WeekAdapter;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, be, NewAlarmActivity

public class  extends DimPanelFragment
{

    private SelectDaysView a;
    private int b;

    static int a( )
    {
        return .b;
    }

    static int a(b b1, int i)
    {
        b1.b = i;
        return i;
    }

    static SelectDaysView b(b b1)
    {
        return b1.a;
    }

    protected int inflateLayout()
    {
        return 0x7f030041;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        a = (SelectDaysView)view.findViewById(0x7f0a0093);
        b = getArguments().getInt("Days");
        Debug.i("DDDD", (new StringBuilder()).append("Days : ").append(b).toString());
        String as[] = getResources().getStringArray(0x7f07000d);
        a.setAdapter(new WeekAdapter(getActivity(), as, b));
        a.setOnItemClickListener(new be(this));
        return view;
    }

    protected void onRightButtomClicked()
    {
        dismiss();
        NewAlarmActivity.a((NewAlarmActivity)getActivity(), b);
    }

    public ()
    {
    }
}
