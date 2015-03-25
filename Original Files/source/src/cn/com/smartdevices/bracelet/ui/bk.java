// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            PersonInfoFragment

class bk
    implements DimPanelFragment.OpClickListener
{

    final PersonInfoFragment a;

    bk(PersonInfoFragment personinfofragment)
    {
        a = personinfofragment;
        super();
    }

    public void onEmptyAreaClicked(DialogFragment dialogfragment)
    {
    }

    public void onLeftClicked(DialogFragment dialogfragment)
    {
        dialogfragment.dismiss();
        PersonInfoFragment.d(a);
    }

    public void onRightClicked(DialogFragment dialogfragment)
    {
        dialogfragment.dismiss();
    }
}
