// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, Q

public class DimPanelFragment extends DialogFragment
    implements android.view.View.OnClickListener
{

    private OpClickListener a;
    protected View mLeftButton;
    protected View mRightButton;

    public DimPanelFragment()
    {
        a = null;
    }

    public static void showPanel(Activity activity, DialogFragment dialogfragment)
    {
        dialogfragment.show(activity.getFragmentManager().beginTransaction(), null);
    }

    public static void showPanel(Activity activity, Class class1)
    {
        android.app.FragmentTransaction fragmenttransaction = activity.getFragmentManager().beginTransaction();
        ((DialogFragment)Fragment.instantiate(activity, class1.getName())).show(fragmenttransaction, class1.getName());
    }

    public static void showPanel(Activity activity, Class class1, Bundle bundle)
    {
        android.app.FragmentTransaction fragmenttransaction = activity.getFragmentManager().beginTransaction();
        ((DialogFragment)Fragment.instantiate(activity, class1.getName(), bundle)).show(fragmenttransaction, class1.getName());
    }

    protected int inflateLayout()
    {
        return 0;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361953: 
        default:
            return;

        case 2131361952: 
            onLeftButtonClicked();
            return;

        case 2131361954: 
            onRightButtomClicked();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i = 0x7f0e0008;
        if (!SystemBarTintActivity.isNotSupport(getActivity()))
        {
            i = 0x7f0e0019;
        }
        setStyle(0, i);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(inflateLayout(), viewgroup, false);
        mLeftButton = view.findViewById(0x7f0a00a0);
        mRightButton = view.findViewById(0x7f0a00a2);
        if (mLeftButton != null)
        {
            mLeftButton.setOnClickListener(this);
        }
        if (mRightButton != null)
        {
            mRightButton.setOnClickListener(this);
        }
        getDialog().setCanceledOnTouchOutside(true);
        View view1 = view.findViewById(0x7f0a00a3);
        if (view1 != null)
        {
            view1.setOnClickListener(new Q(this));
        }
        return view;
    }

    protected void onEmptyAreaClicked()
    {
        if (a != null)
        {
            a.onEmptyAreaClicked(this);
        }
        dismiss();
    }

    protected void onLeftButtonClicked()
    {
        if (a != null)
        {
            a.onLeftClicked(this);
            return;
        } else
        {
            dismiss();
            return;
        }
    }

    protected void onRightButtomClicked()
    {
        if (a != null)
        {
            a.onRightClicked(this);
        }
    }

    protected void setOpClickListener(OpClickListener opclicklistener)
    {
        a = opclicklistener;
    }

    private class OpClickListener
    {

        public abstract void onEmptyAreaClicked(DialogFragment dialogfragment);

        public abstract void onLeftClicked(DialogFragment dialogfragment);

        public abstract void onRightClicked(DialogFragment dialogfragment);
    }

}
