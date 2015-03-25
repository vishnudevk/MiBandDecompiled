// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            NewAlarmActivity

class bd
    implements DimPanelFragment.OpClickListener
{

    final NewAlarmActivity a;

    bd(NewAlarmActivity newalarmactivity)
    {
        a = newalarmactivity;
        super();
    }

    public void onEmptyAreaClicked(DialogFragment dialogfragment)
    {
    }

    public void onLeftClicked(DialogFragment dialogfragment)
    {
        dialogfragment.dismiss();
    }

    public void onRightClicked(DialogFragment dialogfragment)
    {
        a.setResult(0);
        a.finish();
    }
}
