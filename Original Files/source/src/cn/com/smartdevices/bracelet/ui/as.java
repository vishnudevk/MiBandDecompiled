// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            FwUpgradeActivity, FwUpgradeFailedActivity

class as
    implements DimPanelFragment.OpClickListener
{

    final FwUpgradeActivity a;

    as(FwUpgradeActivity fwupgradeactivity)
    {
        a = fwupgradeactivity;
        super();
    }

    public void onEmptyAreaClicked(DialogFragment dialogfragment)
    {
        dialogfragment.dismiss();
    }

    public void onLeftClicked(DialogFragment dialogfragment)
    {
        Intent intent = new Intent();
        intent.setClass(FwUpgradeActivity.c(a), cn/com/smartdevices/bracelet/ui/FwUpgradeFailedActivity);
        FwUpgradeActivity.c(a).startActivity(intent);
    }

    public void onRightClicked(DialogFragment dialogfragment)
    {
        dialogfragment.dismiss();
    }
}
