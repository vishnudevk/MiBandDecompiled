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
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class PersonInfoSettingGenderFragment extends DimPanelFragment
{

    private PersonInfo a;
    private View b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private int h;

    public PersonInfoSettingGenderFragment()
    {
        h = 0;
    }

    private void a()
    {
        int i = a.gender;
        if (i == 1)
        {
            b.setVisibility(0);
            c.setVisibility(4);
            g.setTextColor(getResources().getColor(0x7f090027));
            f.setTextColor(getResources().getColor(0x7f090039));
        } else
        if (i == 0)
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
        return 0x7f030037;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362041 2131362043: default 32
    //                   2131362041 38
    //                   2131362042 32
    //                   2131362043 53;
           goto _L1 _L2 _L1 _L3
_L1:
        super.onClick(view);
        return;
_L2:
        a.gender = 1;
        onRightButtomClicked();
        continue; /* Loop/switch isn't completed */
_L3:
        a.gender = 0;
        onRightButtomClicked();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        b = view.findViewById(0x7f0a0054);
        c = view.findViewById(0x7f0a0055);
        d = view.findViewById(0x7f0a00fb);
        d.setOnClickListener(this);
        e = view.findViewById(0x7f0a00f9);
        e.setOnClickListener(this);
        f = (TextView)view.findViewById(0x7f0a00fc);
        g = (TextView)view.findViewById(0x7f0a00fa);
        h = a.gender;
        a();
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (a.gender == 1)
        {
            UmengAnalytics.event(getActivity(), "UserSettingGender", "Male");
        } else
        if (a.gender == 0)
        {
            UmengAnalytics.event(getActivity(), "UserSettingGender", "Female");
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonInfoGender");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonInfoGender");
    }

    protected void onRightButtomClicked()
    {
        a();
        if (h == a.gender)
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
