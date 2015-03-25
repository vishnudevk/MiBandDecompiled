// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.BleTask.BleSetDeviceNameTask;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, aZ

public class MiliRenameFragment extends DimPanelFragment
{

    private static final String a = "MiliRenameFragment";
    private EditText b;
    private String c;

    public MiliRenameFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f030033;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = getArguments().getString("REF_MILI_NAME");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        b = (EditText)view.findViewById(0x7f0a00e8);
        if (c != null)
        {
            b.setText(c);
            b.setSelection(0, c.length());
        }
        return view;
    }

    protected void onRightButtomClicked()
    {
        mRightButton.setEnabled(false);
        if (TextUtils.isEmpty(b.getText().toString().trim()))
        {
            c = getResources().getString(0x7f0d01c6);
        } else
        {
            c = b.getText().toString().replaceAll("\\s+", "");
        }
        (new BleSetDeviceNameTask(new aZ(this), c)).work();
    }
}
