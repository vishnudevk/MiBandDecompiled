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
import cn.com.smartdevices.bracelet.BleTask.BleSetColorThemeTask;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class PersonInfoSetLightColorFragment extends DimPanelFragment
{

    private PersonInfo a;
    private String b;
    private View c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;

    public PersonInfoSetLightColorFragment()
    {
    }

    private void a()
    {
        c.setVisibility(4);
        e.setVisibility(4);
        f.setVisibility(4);
        d.setVisibility(4);
        g.setTextColor(getResources().getColor(0x7f090039));
        j.setTextColor(getResources().getColor(0x7f090039));
        i.setTextColor(getResources().getColor(0x7f090039));
        h.setTextColor(getResources().getColor(0x7f090039));
        if (a.getMiliColor().equals("BLUE"))
        {
            g.setTextColor(getResources().getColor(0x7f090027));
            c.setVisibility(0);
        } else
        {
            if (a.getMiliColor().equals("ORANGE"))
            {
                j.setTextColor(getResources().getColor(0x7f090027));
                e.setVisibility(0);
                return;
            }
            if (a.getMiliColor().equals("GREEN"))
            {
                i.setTextColor(getResources().getColor(0x7f090027));
                f.setVisibility(0);
                return;
            }
            if (a.getMiliColor().equals("RED"))
            {
                h.setTextColor(getResources().getColor(0x7f090027));
                d.setVisibility(0);
                return;
            }
        }
    }

    private void a(View view)
    {
        c = view.findViewById(0x7f0a00ed);
        e = view.findViewById(0x7f0a00f0);
        f = view.findViewById(0x7f0a00f3);
        d = view.findViewById(0x7f0a00f6);
        g = (TextView)view.findViewById(0x7f0a00ee);
        j = (TextView)view.findViewById(0x7f0a00f1);
        i = (TextView)view.findViewById(0x7f0a00f4);
        h = (TextView)view.findViewById(0x7f0a00f7);
        view.findViewById(0x7f0a00ec).setOnClickListener(this);
        view.findViewById(0x7f0a00ef).setOnClickListener(this);
        view.findViewById(0x7f0a00f2).setOnClickListener(this);
        view.findViewById(0x7f0a00f5).setOnClickListener(this);
    }

    protected int inflateLayout()
    {
        return 0x7f030035;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362028: 
            a.setMiliColor("BLUE");
            onRightButtomClicked();
            return;

        case 2131362031: 
            a.setMiliColor("ORANGE");
            onRightButtomClicked();
            return;

        case 2131362034: 
            a.setMiliColor("GREEN");
            onRightButtomClicked();
            return;

        case 2131362037: 
            a.setMiliColor("RED");
            break;
        }
        onRightButtomClicked();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        a = Keeper.readPersonInfo();
        b = a.getMiliColor();
        a(view);
        a();
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        UmengAnalytics.event(getActivity(), "BraceletLight", a.getMiliColor());
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageBraceletLight");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageBraceletLight");
    }

    protected void onRightButtomClicked()
    {
        int k = 1542;
        if (!a.getMiliColor().equals("BLUE"))
        {
            if (a.getMiliColor().equals("ORANGE"))
            {
                k = 0x60200;
            } else
            if (a.getMiliColor().equals("GREEN"))
            {
                k = 0x40500;
            } else
            if (a.getMiliColor().equals("RED"))
            {
                k = 0x60102;
            }
        }
        (new BleSetColorThemeTask(null, k)).work();
        a();
        if (b.equals(a.getMiliColor()))
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
