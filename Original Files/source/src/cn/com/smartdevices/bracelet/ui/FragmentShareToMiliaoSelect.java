// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, ShareActivity

public class FragmentShareToMiliaoSelect extends DimPanelFragment
    implements android.view.View.OnClickListener
{

    public FragmentShareToMiliaoSelect()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f030047;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362082: 
            ((ShareActivity)getActivity()).shareToMiliao(0x18769);
            dismiss();
            return;

        case 2131362080: 
            ((ShareActivity)getActivity()).shareToMiliao(0x18768);
            dismiss();
            return;

        case 2131362081: 
            ((ShareActivity)getActivity()).shareToMiliao(0x1876a);
            dismiss();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        view.findViewById(0x7f0a0122).setOnClickListener(this);
        view.findViewById(0x7f0a0120).setOnClickListener(this);
        view.findViewById(0x7f0a0121).setOnClickListener(this);
        return view;
    }
}
