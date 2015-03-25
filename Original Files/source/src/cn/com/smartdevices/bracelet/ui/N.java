// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BraceletSettingsFragment

class N
    implements android.content.DialogInterface.OnClickListener
{

    final String a;
    final BraceletSettingsFragment b;

    N(BraceletSettingsFragment braceletsettingsfragment, String s)
    {
        b = braceletsettingsfragment;
        a = s;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        BraceletSettingsFragment.a(b, braceletbtinfo.address, a);
        dialoginterface.dismiss();
    }
}
