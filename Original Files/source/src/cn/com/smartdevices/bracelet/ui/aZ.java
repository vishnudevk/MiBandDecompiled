// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentManager;
import android.view.View;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MiliRenameFragment, SettingFragment

class aZ extends BleCallBack
{

    final MiliRenameFragment b;

    aZ(MiliRenameFragment milirenamefragment)
    {
        b = milirenamefragment;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        b.mRightButton.setEnabled(true);
        CustomToast.makeText(b.getActivity(), 0x7f0d014a, 0).show();
        if (((Integer)obj).intValue() == 0)
        {
            CustomToast.makeText(b.getActivity(), 0x7f0d00f3, 1).show();
            return;
        } else
        {
            CustomToast.makeText(b.getActivity(), 0x7f0d00f2, 1).show();
            return;
        }
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        CustomToast.makeText(b.getActivity(), 0x7f0d014b, 0).show();
        android.app.Fragment fragment = b.getFragmentManager().findFragmentByTag(cn/com/smartdevices/bracelet/ui/SettingFragment.getName());
        if (fragment == null);
        Debug.i("MiliRenameFragment", (new StringBuilder()).append("miliFragment = ").append(fragment).toString());
        b.dismiss();
    }
}
