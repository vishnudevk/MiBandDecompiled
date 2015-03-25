// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, PickAdapter

public class SettingInComingCallTimeFragment extends DimPanelFragment
{

    private static final int a = 10000;
    private PersonInfo b;
    private WheelView c;

    public SettingInComingCallTimeFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f030045;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        c = (WheelView)view.findViewById(0x7f0a011f);
        c.setVisibleItems(5).setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d0144), 24F).setViewAdapter(new PickAdapter(getActivity(), 3, 30, c, getResources().getColor(0x7f090027), getResources().getColor(0x7f090036), 0x88999999, false, 46, 8, 7, 7, 1));
        if (b.getInComingCallTime() >= 0)
        {
            c.setCurrentItem(-3 + b.getInComingCallTime());
            return view;
        } else
        {
            c.setCurrentItem(9997);
            return view;
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    protected void onRightButtomClicked()
    {
        int i = b.getInComingCallTime();
        b.setInComingCallTime(3 + c.getCurrentItem());
        if (i == b.getInComingCallTime())
        {
            dismiss();
            return;
        } else
        {
            b.setNeedSyncServer(2);
            Keeper.keepPersonInfo(b);
            EventBus.getDefault().post(new EventSettingFragmentUpdate());
            dismiss();
            return;
        }
    }
}
