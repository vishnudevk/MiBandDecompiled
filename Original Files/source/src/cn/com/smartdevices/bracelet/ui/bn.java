// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            PersonInfoFragment

class bn extends BleCallBack
{

    final PersonInfoFragment b;

    bn(PersonInfoFragment personinfofragment)
    {
        b = personinfofragment;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        CustomToast.makeText(b.getActivity(), b.getActivity().getString(0x7f0d0040), 0).show();
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        Debug.i("PersonInfoFragment", "sync to bracelet ok");
    }

    public void onStart()
    {
        super.onStart();
    }
}
