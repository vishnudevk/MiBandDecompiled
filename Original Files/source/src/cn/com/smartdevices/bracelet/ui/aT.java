// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity, SettingActivity

class aT extends BroadcastReceiver
{

    final MainUIActivity a;

    aT(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        Debug.i("MainUIActivity", (new StringBuilder()).append("action : ").append(s).toString());
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(s))
        {
            Debug.i("intent", (new StringBuilder()).append("").append(intent.getLongExtra("extra_download_id", 0L)).toString());
            Utils.queryDownloadStatus(a);
        } else
        if ("ACTION_BATTERY_LOW".equals(s))
        {
            ActivityManager activitymanager = (ActivityManager)a.getSystemService("activity");
            List list = activitymanager.getRunningTasks(50);
            if (list != null)
            {
                Iterator iterator = list.iterator();
                int i = -1;
                while (iterator.hasNext()) 
                {
                    android.app.ActivityManager.RunningTaskInfo runningtaskinfo = (android.app.ActivityManager.RunningTaskInfo)iterator.next();
                    ComponentName componentname = runningtaskinfo.baseActivity;
                    Debug.i("MainUIActivity", (new StringBuilder()).append("recent activity:").append(componentname.getClassName()).toString());
                    Intent intent1;
                    int j;
                    if (componentname.getClassName().contains("cn.com.smartdevices.bracelet.ui.MainUIActivity"))
                    {
                        j = runningtaskinfo.id;
                    } else
                    {
                        j = i;
                    }
                    i = j;
                }
            } else
            {
                i = -1;
            }
            if (i != -1)
            {
                activitymanager.moveTaskToFront(i, 0);
            }
            intent1 = new Intent(context, cn/com/smartdevices/bracelet/ui/SettingActivity);
            intent1.setFlags(0x10000000);
            context.startActivity(intent1);
            return;
        }
    }
}
