// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import cn.com.smartdevices.bracelet.view.DynamicView;

public class d extends Fragment
{

    private DynamicView a;
    private cn.com.smartdevices.bracelet.chart.util.ity b;
    private int c;
    private PageIndicator d;

    private void a(DynamicView dynamicview, cn.com.smartdevices.bracelet.chart.util._F9__08_ _pf9__08_)
    {
        if (c != 1) goto _L2; else goto _L1
_L1:
        dynamicview.setStepGoal(Keeper.readPersonInfoBaseConfig().getDaySportGoalSteps());
        dynamicview.setStepCount(b.q_02_());
        dynamicview.setStepDistance(ChartData.formatDistance(getActivity(), b.e()));
        dynamicview.setStepCalorie(b.());
        dynamicview.setStepTip(b.());
_L4:
        Debug.i("Dynamic.Main", (new StringBuilder()).append("BindData : ").append(b).append(" , Mode : ").append(c).toString());
        return;
_L2:
        if (c == 16)
        {
            dynamicview.setSleepTime(b.());
            dynamicview.setSleepDeepTime(b.me());
            dynamicview.setSleepTip(b.me());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public DynamicView getDynamicView()
    {
        return a;
    }

    public void notifyDataSetChanged(boolean flag)
    {
        if (a != null)
        {
            a(a, b);
            a.refresh(flag);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.refresh(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            c = bundle1.getInt("Mode");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        DynamicView dynamicview = new DynamicView(getActivity());
        a = (DynamicView)dynamicview;
        a.setMode(c);
        b = ChartData.getDynamicData();
        a(a, b);
        a.refresh();
        a.setIndicator(d);
        return dynamicview;
    }

    public void onResume()
    {
        super.onResume();
        if (!Utils.isBinded())
        {
            a.setBackgroundColor(0xff3c444f);
        }
    }

    public void setConnectingAlpha(Boolean boolean1)
    {
        if (a != null)
        {
            a.setConnectingAlpha(boolean1);
        }
    }

    public void setIndicator(PageIndicator pageindicator)
    {
        d = pageindicator;
        if (a != null)
        {
            a.setIndicator(pageindicator);
        }
    }

    public void setSlideUpPosition(float f)
    {
        if (a != null)
        {
            a.setSlideUpPostion(f);
        }
    }

    public I()
    {
        d = null;
    }
}
