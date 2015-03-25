// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import cn.com.smartdevices.bracelet.upgrade.UpgradeUtil;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aW
    implements android.content.DialogInterface.OnClickListener
{

    final String a;
    final MainUIActivity b;

    aW(MainUIActivity mainuiactivity, String s)
    {
        b = mainuiactivity;
        a = s;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        UpgradeUtil.downloadApkFile(b.getApplicationContext(), a);
        dialoginterface.dismiss();
    }
}
