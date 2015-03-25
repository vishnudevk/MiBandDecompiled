// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataChart;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LabFragment extends Fragment
{

    public LabFragment()
    {
    }

    public static LabFragment newInstance()
    {
        LabFragment labfragment = new LabFragment();
        labfragment.setArguments(new Bundle());
        return labfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view;
        LinearLayout linearlayout;
        LinearLayout linearlayout1;
        cn.com.smartdevices.bracelet.model.DaySportData daysportdata;
        String s;
        SimpleDateFormat simpledateformat;
        view = layoutinflater.inflate(0x7f03002f, null);
        (TextView)view.findViewById(0x7f0a00e3);
        linearlayout = (LinearLayout)view.findViewById(0x7f0a00e1);
        linearlayout1 = (LinearLayout)view.findViewById(0x7f0a00e2);
        SportDay sportday = DataManager.getInstance().getCurDay();
        daysportdata = DataManager.getInstance().get(sportday);
        s = sportday.toString();
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpledateformat.parse(s);
        Date date = date1;
_L2:
        linearlayout.addView(DataChart.getInstance().executeLineChartView3(getActivity(), daysportdata, date.getTime()));
        linearlayout1.addView(DataChart.getInstance().executeLineChartView2(getActivity(), daysportdata, date.getTime()));
        linearlayout1.setVisibility(8);
        setHasOptionsMenu(true);
        return view;
        Exception exception;
        exception;
        date = null;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
