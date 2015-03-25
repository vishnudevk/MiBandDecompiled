// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BraceletSettingsFragment

class J
    implements android.content.DialogInterface.OnClickListener
{

    final BraceletSettingsFragment a;

    J(BraceletSettingsFragment braceletsettingsfragment)
    {
        a = braceletsettingsfragment;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        BraceletSettingsFragment.b(a);
    }
}
