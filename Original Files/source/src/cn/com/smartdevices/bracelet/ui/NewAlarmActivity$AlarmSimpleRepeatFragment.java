// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import cn.com.smartdevices.bracelet.view.SimpleAlarmWeekAdapter;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, bf

public class  extends DimPanelFragment
{

    private int a;

    static int a( )
    {
        return .a;
    }

    static int a(a a1, int i)
    {
        a1.a = i;
        return i;
    }

    protected int inflateLayout()
    {
        return 0x7f030042;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        SelectDaysView selectdaysview = (SelectDaysView)view.findViewById(0x7f0a0093);
        a = getArguments().getInt("Days");
        String as[] = getResources().getStringArray(0x7f070002);
        selectdaysview.setAdapter(new SimpleAlarmWeekAdapter(getActivity(), as, a));
        selectdaysview.setOnItemClickListener(new bf(this));
        return view;
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageAlarmNewRepeat");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageAlarmNewRepeat");
    }

    protected void onRightButtomClicked()
    {
        dismiss();
    }

    public ()
    {
    }
}
