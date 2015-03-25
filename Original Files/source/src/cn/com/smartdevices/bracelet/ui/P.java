// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.view.CustomToast;
import java.io.File;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BraceletSettingsFragment

class P extends BleCallBack
{

    final String b;
    final BraceletSettingsFragment c;

    P(BraceletSettingsFragment braceletsettingsfragment, String s)
    {
        c = braceletsettingsfragment;
        b = s;
        super();
    }

    public void onFinish(Object obj)
    {
        int i;
        super.onFinish(obj);
        i = ((Integer)obj).intValue();
        if (i != 1) goto _L2; else goto _L1
_L1:
        CustomToast.makeText(c.getActivity(), "\u56FA\u4EF6\u5347\u7EA7\u5931\u8D25\uFF01", 1).show();
_L4:
        BraceletSettingsFragment.c(c);
        return;
_L2:
        if (i == 2)
        {
            CustomToast.makeText(c.getActivity(), "\u56FA\u4EF6\u5347\u7EA7\u6210\u529F!", 1).show();
        } else
        if (i == 0)
        {
            CustomToast.makeText(c.getActivity(), "\u56FA\u4EF6\u5347\u7EA7\u72B6\u6001\u672A\u77E5\uFF01", 1).show();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onStart()
    {
        super.onStart();
        BraceletSettingsFragment.a(c, (int)(new File(b)).length());
        BraceletSettingsFragment.a(c);
    }
}
