// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.DaySportData;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            BleTask, BleCallBack

public class BleSyncDataTask extends BleTask
{

    private long a;

    public BleSyncDataTask(long l, BleCallBack blecallback)
    {
        super(blecallback);
        a = 0L;
        a = l;
    }

    public void doWork(BleCallBack blecallback)
    {
        Debug.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Debug.i(TAG, "===========================start sync data================================");
        Debug.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Debug.f(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Debug.f(TAG, "===========================start sync data================================");
        Debug.f(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        blecallback.sendOnStartMessage();
        List list = gattPeripheral.getActivities();
        if (list == null)
        {
            Debug.f(TAG, "getActivities return null,now finish!");
            blecallback.sendOnFinishMessage(Long.valueOf(-1L));
            return;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityDataFragment activitydatafragment = (com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityDataFragment)iterator.next();
            List list1 = activitydatafragment.data;
            Calendar calendar = activitydatafragment.timestamp;
            Debug.i(TAG, (new StringBuilder()).append("data size:").append(list1.size()).append(",data time:").append(calendar.getTime().toString()).toString());
            Debug.f(TAG, (new StringBuilder()).append("data size:").append(list1.size()).append(",data time:").append(calendar.getTime().toString()).toString());
            for (Iterator iterator1 = list1.iterator(); iterator1.hasNext(); calendar.add(12, 1))
            {
                com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = (com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData)iterator1.next();
                int i = calendar.get(1);
                int j = calendar.get(2);
                int k = calendar.get(5);
                int l = calendar.get(11);
                int i1 = calendar.get(12) + l * 60;
                DaySportData daysportdata = DataManager.getInstance().getSync(i, j, k);
                if (daysportdata == null)
                {
                    daysportdata = new DaySportData(i, j, k);
                    DataManager.getInstance().add(daysportdata);
                }
                daysportdata.setNeedSync(true);
                daysportdata.setNeedPostProcess(true);
                daysportdata.add(i1, activitydata);
            }

            a = calendar.getTimeInMillis();
        }

        Debug.f(TAG, "analysis...............................before");
        DataManager.getInstance().analysis();
        DataManager.getInstance().updateStepInfoWithRealtimeSteps();
        Debug.f(TAG, "analysis...............................after");
        Debug.f(TAG, "saveToDb...............................before");
        DataManager.getInstance().saveToDb();
        Debug.f(TAG, "saveToDb...............................after");
        Debug.f(TAG, "initDays...............................before");
        DataManager.getInstance().initDays();
        Debug.f(TAG, "initDays...............................after");
        blecallback.sendOnFinishMessage(Long.valueOf(a));
        gattPeripheral.resetActivitySyncingProgress();
        Debug.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Debug.i(TAG, "============================stop sync data================================");
        Debug.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Debug.f(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Debug.f(TAG, "============================stop sync data================================");
        Debug.f(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
