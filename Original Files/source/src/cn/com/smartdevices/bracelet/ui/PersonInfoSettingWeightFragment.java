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
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, PickAdapter

public class PersonInfoSettingWeightFragment extends DimPanelFragment
{

    private PersonInfo a;
    private WheelView b;

    public PersonInfoSettingWeightFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f03003b;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        b = (WheelView)view.findViewById(0x7f0a0100);
        b.setCenterDrawable(0x7f0200bb).setCenterStyle(getString(0x7f0d00da), 25.123F).setViewAdapter(new PickAdapter(getActivity(), 20, 205, b, getResources().getColor(0x7f090027), getResources().getColor(0x7f090036), 0x88999999, false, 46, 8, 7, 7, 1)).setCurrentItem(-20 + a.weight);
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        UmengAnalytics.event(getActivity(), "UserSettingWeight", a.weight);
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonInfoWeight");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonInfoWeight");
    }

    protected void onRightButtomClicked()
    {
        mRightButton.setEnabled(false);
        int i = a.weight;
        a.weight = 20 + b.getCurrentItem();
        if (i == a.weight)
        {
            dismiss();
            return;
        } else
        {
            a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(a);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
            dismiss();
            return;
        }
    }
}
