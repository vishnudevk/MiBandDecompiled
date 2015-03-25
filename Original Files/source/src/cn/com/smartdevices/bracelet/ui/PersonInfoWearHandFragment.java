// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetWearLocationTask;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class PersonInfoWearHandFragment extends DimPanelFragment
{

    private PersonInfo a;
    private View b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private String h;

    public PersonInfoWearHandFragment()
    {
    }

    private void a()
    {
        if (a.getMiliWearHand().equals("LEFT_HAND"))
        {
            b.setVisibility(0);
            c.setVisibility(4);
            g.setTextColor(getResources().getColor(0x7f090027));
            f.setTextColor(getResources().getColor(0x7f090039));
        } else
        if (a.getMiliWearHand().equals("RIGHT_HAND"))
        {
            b.setVisibility(4);
            c.setVisibility(0);
            f.setTextColor(getResources().getColor(0x7f090027));
            g.setTextColor(getResources().getColor(0x7f090039));
            return;
        }
    }

    protected int inflateLayout()
    {
        return 0x7f03003c;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131362050: 
        case 2131362051: 
        default:
            return;

        case 2131362049: 
            a.setMiliWearHand("LEFT_HAND");
            onRightButtomClicked();
            return;

        case 2131362052: 
            a.setMiliWearHand("RIGHT_HAND");
            break;
        }
        onRightButtomClicked();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        b = view.findViewById(0x7f0a0102);
        c = view.findViewById(0x7f0a0105);
        d = view.findViewById(0x7f0a0104);
        d.setOnClickListener(this);
        e = view.findViewById(0x7f0a0101);
        e.setOnClickListener(this);
        f = (TextView)view.findViewById(0x7f0a0106);
        g = (TextView)view.findViewById(0x7f0a0103);
        h = a.getMiliWearHand();
        a();
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        UmengAnalytics.event(getActivity(), "BraceletHand", a.getMiliWearHand());
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletHand");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletHand");
    }

    protected void onRightButtomClicked()
    {
        a();
        boolean flag = a.getMiliWearHand().equals("LEFT_HAND");
        byte byte0 = 0;
        if (!flag)
        {
            boolean flag1 = a.getMiliWearHand().equals("RIGHT_HAND");
            byte0 = 0;
            if (flag1)
            {
                byte0 = 1;
            }
        }
        (new BleSetWearLocationTask(null, byte0)).work();
        if (h.equals(a.getMiliWearHand()))
        {
            dismiss();
            return;
        } else
        {
            a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(a);
            EventBus.getDefault().post(new EventSettingFragmentUpdate());
            dismiss();
            return;
        }
    }
}
