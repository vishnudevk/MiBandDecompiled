// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class MiliExitLoginFragment extends DimPanelFragment
{

    private int a;

    public MiliExitLoginFragment()
    {
        a = 0;
    }

    protected int inflateLayout()
    {
        a = getArguments().getInt("exit_login_type");
        return a != 0 ? 0x7f030032 : 0x7f030031;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (a == 0)
        {
            TextView textview = (TextView)view.findViewById(0x7f0a00e7);
            String s = getString(0x7f0d00ef);
            String s1 = getString(0x7f0d00f0);
            String s2 = getString(0x7f0d00ed);
            String s3;
            if (Utils.isSupportUnlockScreenByBracelet(getActivity()))
            {
                s3 = (new StringBuilder()).append(s).append(s1).append(s2).toString();
            } else
            {
                s3 = (new StringBuilder()).append(s).append(s2).toString();
            }
            textview.setText(s3);
        }
        return view;
    }
}
