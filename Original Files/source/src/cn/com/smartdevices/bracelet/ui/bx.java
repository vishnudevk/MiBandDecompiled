// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SettingAboutActivity

class bx extends BroadcastReceiver
{

    final SettingAboutActivity a;

    bx(SettingAboutActivity settingaboutactivity)
    {
        a = settingaboutactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        Debug.i("intent", (new StringBuilder()).append("").append(intent.getLongExtra("extra_download_id", 0L)).toString());
        Utils.queryDownloadStatus(a);
    }
}
