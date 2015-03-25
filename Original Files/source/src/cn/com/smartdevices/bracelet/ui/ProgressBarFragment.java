// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class ProgressBarFragment extends DimPanelFragment
{

    public ProgressBarFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f03003d;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        Bundle bundle1 = getArguments();
        TextView textview = (TextView)view.findViewById(0x7f0a0107);
        if (bundle1 != null)
        {
            textview.setText(bundle1.getString("REF_PROGRESS_INFO", "..."));
        }
        return view;
    }
}
