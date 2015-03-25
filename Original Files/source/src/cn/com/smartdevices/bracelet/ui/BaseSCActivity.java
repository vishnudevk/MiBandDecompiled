// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleStatisticTask;
import cn.com.smartdevices.bracelet.BleTask.BleStopSynDataTask;
import cn.com.smartdevices.bracelet.BleTask.BleSyncDataTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import de.greenrobot.event.EventBus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseBleActivity, y, r, n, 
//            p, FwUpgradeActivity, FwLowBatteryActivity, q, 
//            x, s, v, u

public class BaseSCActivity extends BaseBleActivity
{

    private static final int a = 8193;
    private static final int b = 10000;
    private static final int c = 12;
    private static final int d = 1;
    private static final int e = 4096;
    private static final int f = 4097;
    private static final int g = 4098;
    private static final int h = 4099;
    private static final int i = 4104;
    private static final int j = 4112;
    private static final boolean k;
    public static ConnStatus mConnStatus = new ConnStatus();
    private float A;
    private int B;
    private boolean C;
    private Handler l;
    private BraceletBtInfo m;
    private int n;
    private final int o = 3;
    private String p;
    private BroadcastReceiver q;
    private Context r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private float z;

    public BaseSCActivity()
    {
        l = null;
        n = 0;
        p = "BaseSCActivity";
        q = null;
        r = null;
        s = false;
        t = 12;
        u = false;
        v = false;
        w = false;
        x = false;
        y = false;
        z = 0.0F;
        A = 1.0F;
        B = 1;
        C = false;
    }

    static String a(BaseSCActivity basescactivity)
    {
        return basescactivity.p;
    }

    private void a()
    {
        Debug.i(p, "==============================enterInForeground==========================");
        Debug.f(p, "==============================enterInForeground==========================");
        x = false;
        e();
    }

    private void a(int i1, int j1)
    {
        (new Thread(new y(this, i1, j1))).start();
    }

    private void a(int i1, Object obj)
    {
        Debug.i(p, (new StringBuilder()).append("onStatusChanged:").append(i1).toString());
        mConnStatus.a = i1;
        mConnStatus.b = obj;
        i1;
        JVM INSTR tableswitch 1 11: default 100
    //                   1 100
    //                   2 100
    //                   3 196
    //                   4 100
    //                   5 136
    //                   6 100
    //                   7 215
    //                   8 166
    //                   9 227
    //                   10 247
    //                   11 254;
           goto _L1 _L1 _L1 _L2 _L1 _L3 _L1 _L4 _L5 _L6 _L7 _L8
_L1:
        ConnStatus connstatus = new ConnStatus();
        connstatus.b = mConnStatus.b;
        connstatus.a = mConnStatus.a;
        EventBus.getDefault().postSticky(connstatus);
        return;
_L3:
        if (!v)
        {
            UmengAnalytics.endEvent(r, "BleConnect");
            UmengAnalytics.event(r, "BleConnect", "Failed");
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!v)
        {
            UmengAnalytics.endEvent(r, "BleConnect");
            UmengAnalytics.event(r, "BleConnect", "Successed");
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!v)
        {
            UmengAnalytics.startEvent(r, "BleConnect");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        UmengAnalytics.event(r, "BleDisconnect");
        continue; /* Loop/switch isn't completed */
_L6:
        r();
        q();
        UmengAnalytics.startEvent(r, "BleSyncData");
        continue; /* Loop/switch isn't completed */
_L7:
        s();
        continue; /* Loop/switch isn't completed */
_L8:
        t();
        UmengAnalytics.endEvent(r, "BleSyncData");
        if (((Boolean)obj).booleanValue())
        {
            UmengAnalytics.event(r, "BleSyncData", "Successed");
        } else
        {
            UmengAnalytics.event(r, "BleSyncData", "Failed");
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    static void a(BaseSCActivity basescactivity, int i1, Object obj)
    {
        basescactivity.a(i1, obj);
    }

    static void a(BaseSCActivity basescactivity, String s1)
    {
        basescactivity.a(s1);
    }

    static void a(BaseSCActivity basescactivity, boolean flag)
    {
        basescactivity.c(flag);
    }

    private void a(String s1)
    {
        Debug.i(p, (new StringBuilder()).append("bracelet statistic info:").append(s1).toString());
        WebAPI.statisticBracelet(Keeper.readLoginData(), Keeper.readDeviceId(), s1, new r(this));
    }

    private void a(boolean flag)
    {
        String s1 = Keeper.readLastWeekReportDate();
        ReportData reportdata = DataManager.getInstance().getLastWeekReportData();
        Debug.i("chenee", reportdata.toString());
        if (!flag && (!reportdata.isValid() || s1 != null && s1.equals(reportdata.timeFrom)))
        {
            return;
        } else
        {
            Keeper.KeepLastWeekReportDate(reportdata.timeFrom);
            Debug.i("chenee", "set week report .........................");
            LuaEvent.getInstance(this).setWeekReport(reportdata);
            return;
        }
    }

    private boolean a(Context context)
    {
        Debug.i(p, "in isBLEServiceRunning............");
        for (Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator(); iterator.hasNext();)
        {
            android.app.ActivityManager.RunningServiceInfo runningserviceinfo = (android.app.ActivityManager.RunningServiceInfo)iterator.next();
            if (runningserviceinfo.service.getPackageName().equals(getPackageName()) && com/xiaomi/hm/bleservice/BLEService.getName().equals(runningserviceinfo.service.getClassName()))
            {
                return true;
            }
        }

        return false;
    }

    static int b(BaseSCActivity basescactivity)
    {
        int i1 = basescactivity.n;
        basescactivity.n = i1 + 1;
        return i1;
    }

    private void b()
    {
        Debug.i(p, "==============================enterInBackground==========================");
        Debug.f(p, "==============================enterInBackground==========================");
        x = true;
        if (Utils.isBinded())
        {
            d();
            c();
        }
    }

    private void b(boolean flag)
    {
        String s1 = Keeper.readLastMonthReportDate();
        ReportData reportdata = DataManager.getInstance().getLastMonthReportData();
        Debug.i("chenee", (new StringBuilder()).append("last month ").append(reportdata.toString()).toString());
        if (!flag && (!reportdata.isValid() || s1 != null && s1.equals(reportdata.timeFrom)))
        {
            return;
        } else
        {
            Keeper.KeepLastMonthReportDate(reportdata.timeFrom);
            Debug.i("chenee", "set Month report .........................");
            LuaEvent.getInstance(this).setMonthReport(reportdata);
            return;
        }
    }

    static boolean b(BaseSCActivity basescactivity, boolean flag)
    {
        basescactivity.C = flag;
        return flag;
    }

    static int c(BaseSCActivity basescactivity)
    {
        return basescactivity.n;
    }

    private void c()
    {
        AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.hm.health.set_max_latency");
        PendingIntent pendingintent = PendingIntent.getBroadcast(this, 0, intent, 0);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            alarmmanager.setExact(2, 0x1d4c0L + SystemClock.elapsedRealtime(), pendingintent);
            return;
        } else
        {
            alarmmanager.set(2, 0x1d4c0L + SystemClock.elapsedRealtime(), pendingintent);
            return;
        }
    }

    static void c(BaseSCActivity basescactivity, boolean flag)
    {
        basescactivity.a(flag);
    }

    private void c(boolean flag)
    {
        ReportInfo reportinfo = Keeper.readContinueReachGoalRi();
        ReportData reportdata = DataManager.getInstance().getContinueReachGoalReportData();
        if (reportdata.isValid())
        {
            ReportInfo reportinfo1 = new ReportInfo();
            reportinfo1.date = reportdata.timeTo;
            reportinfo1.reportDate = (new SportDay()).getKey();
            Debug.i("chenee", (new StringBuilder()).append(reportinfo.reportDate).append(",").append(reportinfo1.reportDate).toString());
            if (flag || !reportinfo.reportDate.equals(reportinfo1.reportDate) || !reportinfo.date.equals(reportdata.timeTo))
            {
                Debug.i("chenee", reportdata.toString());
                Keeper.keepContinueReachGoalRi(reportinfo1);
                Debug.i("chenee", "continue reach goal report .........................");
                LuaEvent.getInstance(this).setContinueReport(reportdata);
                return;
            }
        }
    }

    private void d()
    {
        AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.hm.health.set_max_latency");
        alarmmanager.cancel(PendingIntent.getBroadcast(this, 0, intent, 0));
    }

    static void d(BaseSCActivity basescactivity, boolean flag)
    {
        basescactivity.b(flag);
    }

    static boolean d(BaseSCActivity basescactivity)
    {
        return basescactivity.k();
    }

    private void e()
    {
        Debug.i(p, "in initBleStatus......");
        Utils.setAutoReconnect(true);
        d();
        if (!a(this))
        {
            Debug.i(p, "BLEService not running......");
            ((BraceletApp)getApplication()).startBLEService();
            startScanBracelet();
        } else
        {
            int i1 = getDeviceStatus();
            int j1 = getProfileStatus();
            Debug.i(p, (new StringBuilder()).append("profileStatus:").append(j1).append(",deviceStatus:").append(i1).append(",connStatus:").append(mConnStatus.a).toString());
            Debug.f(p, (new StringBuilder()).append("profileStatus:").append(j1).append(",deviceStatus:").append(i1).append(",connStatus:").append(mConnStatus.a).toString());
            if (j1 == 0)
            {
                if (mConnStatus.a == -1 || mConnStatus.a == 8 || mConnStatus.a == 11)
                {
                    setLatency(39);
                    f();
                    return;
                }
            } else
            if (i1 == -1 && mConnStatus.a != 3)
            {
                startScanBracelet();
                return;
            } else
            {
                a(3, null);
                return;
            }
        }
    }

    static void e(BaseSCActivity basescactivity)
    {
        basescactivity.j();
    }

    private void f()
    {
        Debug.i(p, (new StringBuilder()).append("mHandler:").append(l).toString());
        Debug.f(p, (new StringBuilder()).append("mHandler:").append(l).toString());
        if (l != null)
        {
            Debug.i(p, (new StringBuilder()).append("last sync time:").append((new Date(Keeper.readSyncTime())).toLocaleString()).append(",current time:").append((new Date()).toLocaleString()).toString());
            Debug.f(p, (new StringBuilder()).append("last sync time:").append((new Date(Keeper.readSyncTime())).toLocaleString()).append(",current time:").append((new Date()).toLocaleString()).toString());
            if (k() || System.currentTimeMillis() - Keeper.readSyncTime() > 0x1d4c0L)
            {
                B = 1;
                l.removeMessages(4104);
                l.sendEmptyMessage(4104);
                return;
            }
        }
    }

    static void f(BaseSCActivity basescactivity)
    {
        basescactivity.i();
    }

    private void g()
    {
        l = new n(this);
        q = new p(this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.USER_PRESENT");
        intentfilter.addAction("com.xiaomi.hm.health.set_max_latency");
        registerReceiver(q, intentfilter);
    }

    static void g(BaseSCActivity basescactivity)
    {
        basescactivity.n();
    }

    private float h()
    {
        long l1 = Keeper.readSyncTime();
        float f1 = 1.0F;
        if (l1 != -1L)
        {
            f1 = 100F / (float)(8 + (int)(1.0D + 0.12D * (double)(2 + (1 + (3 * (int)((System.currentTimeMillis() - l1) / 60000L)) / 20))));
        }
        return f1;
    }

    static void h(BaseSCActivity basescactivity)
    {
        basescactivity.l();
    }

    private void i()
    {
        Intent intent = new Intent();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/FwUpgradeActivity);
        startActivity(intent);
    }

    static boolean i(BaseSCActivity basescactivity)
    {
        return basescactivity.v;
    }

    private void j()
    {
        Intent intent = new Intent();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/FwLowBatteryActivity);
        startActivity(intent);
    }

    static void j(BaseSCActivity basescactivity)
    {
        basescactivity.b();
    }

    static void k(BaseSCActivity basescactivity)
    {
        basescactivity.a();
    }

    private boolean k()
    {
        if (!Utils.isBraceletConnected())
        {
            return false;
        }
        byte abyte0[];
        int i1;
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo;
        try
        {
            InputStream inputstream = getResources().getAssets().open("Mili.fw");
            Debug.i(p, (new StringBuilder()).append("new fw length:").append(inputstream.available()).toString());
            abyte0 = new byte[inputstream.available()];
            inputstream.read(abyte0);
            inputstream.close();
        }
        catch (Exception exception)
        {
            Debug.i(p, exception.getMessage());
            return false;
        }
        i1 = Utils.getFwVersion(abyte0);
        deviceinfo = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getCachedDeviceInfo();
        if (deviceinfo == null)
        {
            return false;
        }
        Debug.i(p, (new StringBuilder()).append("new fw version:").append(i1).append(",fw version:").append(deviceinfo.firmwareVersion).append(",pcb version:").append(deviceinfo.hardwareVersion).toString());
        if (i1 <= deviceinfo.firmwareVersion)
        {
            Debug.i(p, "bracelet firmware is the lastest,do nothing!");
            return false;
        }
        if (deviceinfo.hardwareVersion != 2)
        {
            Debug.i(p, (new StringBuilder()).append("bracelet PCBVersion is : ").append(deviceinfo.hardwareVersion).append(", not PCB 1.4,do nothing!").toString());
            return false;
        } else
        {
            return true;
        }
    }

    static float l(BaseSCActivity basescactivity)
    {
        return basescactivity.z;
    }

    private void l()
    {
        int i1;
        NetworkInfo anetworkinfo[];
        int j1;
        i1 = 1;
        anetworkinfo = ((ConnectivityManager)r.getSystemService("connectivity")).getAllNetworkInfo();
        j1 = 0;
_L3:
        if (j1 >= anetworkinfo.length) goto _L2; else goto _L1
_L1:
        int k1;
        if (anetworkinfo[j1].getType() == i1)
        {
            if (!anetworkinfo[j1].isConnected())
            {
                continue; /* Loop/switch isn't completed */
            }
            k1 = i1;
        } else
        if (anetworkinfo[j1].getType() == 9)
        {
            if (!anetworkinfo[j1].isConnected())
            {
                continue; /* Loop/switch isn't completed */
            }
            k1 = i1;
            i1 = 0;
        } else
        {
            if (anetworkinfo[j1].getType() != 0 || !anetworkinfo[j1].isConnected())
            {
                continue; /* Loop/switch isn't completed */
            }
            k1 = i1;
            i1 = 0;
        }
_L4:
        if (k1 != 0 && i1 != 0)
        {
            m();
        }
        return;
        j1++;
          goto _L3
_L2:
        k1 = 0;
        i1 = 0;
          goto _L4
    }

    private void m()
    {
        if (Keeper.readPersonInfoBaseNeedSync().getNeedSyncServer() != 0)
        {
            Debug.i(p, "Sync person info when net connected");
            Utils.updateProfile(Keeper.readPersonInfo());
        }
    }

    static void m(BaseSCActivity basescactivity)
    {
        basescactivity.p();
    }

    static int n(BaseSCActivity basescactivity)
    {
        int i1 = basescactivity.B;
        basescactivity.B = i1 - 1;
        return i1;
    }

    private void n()
    {
        Debug.i(p, "in statisticBracelet");
        while (System.currentTimeMillis() - Keeper.readBraceletStatisticTime() < 0x1499700L || !Utils.isBraceletConnected() || !Utils.isNetworkConnected(this)) 
        {
            return;
        }
        (new BleStatisticTask(new q(this))).work();
    }

    static Handler o(BaseSCActivity basescactivity)
    {
        return basescactivity.l;
    }

    private void o()
    {
        DataManager datamanager = DataManager.getInstance();
        DaySportData daysportdata = datamanager.get(datamanager.getToday());
        LuaEvent luaevent = LuaEvent.getInstance(this);
        StepsInfo stepsinfo;
        if (daysportdata != null)
        {
            if ((stepsinfo = daysportdata.getStepsInfo()) != null)
            {
                int i1 = stepsinfo.getStepsCount();
                SportDay sportday = DataManager.getInstance().getStartDay();
                if ((new SportDay()).addDay(-7).compare(sportday) > 0)
                {
                    ReportData reportdata = DataManager.getInstance().getStepRecord();
                    Debug.i("chenee", reportdata.toString());
                    if (i1 > reportdata.steps)
                    {
                        Debug.i("chenee", "newRecordReport .........................");
                        reportdata.setStepsInfo(stepsinfo);
                        luaevent.setRecord(reportdata);
                        return;
                    }
                } else
                {
                    Debug.i("chenee", "newRecordReport do nothing.........................");
                    return;
                }
            }
        }
    }

    private void p()
    {
        DataManager datamanager = DataManager.getInstance();
        ArrayList arraylist = datamanager.getNeedSyncDatas();
        if (arraylist == null || arraylist.size() < 1)
        {
            return;
        }
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); jsonarray.put(((UploadData)iterator.next()).toJSONObject())) { }
        Debug.f(p, jsonarray.toString());
        WebAPI.syncToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, jsonarray.toString(), new x(this, datamanager, arraylist));
    }

    static void p(BaseSCActivity basescactivity)
    {
        basescactivity.o();
    }

    private void q()
    {
        Calendar calendar = Calendar.getInstance();
        if (Keeper.readSyncTime() > -1L)
        {
            calendar.setTimeInMillis(Keeper.readSyncTime());
        }
        Calendar calendar1 = Calendar.getInstance();
        if (calendar.get(6) != calendar1.get(6))
        {
            int i1 = calendar1.get(11);
            UmengAnalytics.event(r, "BleSyncDataFirst", i1);
        }
    }

    private void r()
    {
        s = false;
        t = 12;
        if (l != null)
        {
            l.sendEmptyMessageDelayed(4112, 1000L);
        }
    }

    private void s()
    {
        MiLiProfile miliprofile;
        com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress progress;
        miliprofile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
        progress = miliprofile.getActivitySyncingProgress();
        if (progress.total != -1) goto _L2; else goto _L1
_L1:
        t = -1 + t;
        if (t > 0)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        Debug.i(p, "sync data block for 12s,quit now!!!");
        mConnStatus.b = Integer.valueOf(0);
        miliprofile.stopGetActivities();
        (new BleStopSynDataTask(null)).work();
_L4:
        return;
_L2:
        int i1;
        if (progress.total == 0)
        {
            t = 12;
            i1 = 100;
        } else
        {
            t = 12;
            i1 = (100 * progress.progress) / progress.total;
        }
_L5:
        Debug.i(p, (new StringBuilder()).append("sync data progress:").append(progress.toString()).append(", ").append(i1).append("%").toString());
        if (i1 < (int)z)
        {
            i1 = (int)z;
        }
        mConnStatus.b = Integer.valueOf(i1);
        if (s || l == null) goto _L4; else goto _L3
_L3:
        l.sendEmptyMessageDelayed(4112, 1000L);
        return;
        i1 = 0;
          goto _L5
    }

    private void t()
    {
        z = 0.0F;
        t = 12;
        s = true;
        if (l == null)
        {
            return;
        } else
        {
            l.removeMessages(4112);
            l.sendEmptyMessage(4099);
            return;
        }
    }

    public void connect(BluetoothDevice bluetoothdevice)
    {
        Debug.i(p, (new StringBuilder()).append("connect:").append(bluetoothdevice.getName()).append(":").append(bluetoothdevice.getAddress()).toString());
        if (l == null)
        {
            return;
        } else
        {
            l.removeMessages(4097);
            a(3, null);
            Utils.connect(bluetoothdevice, true);
            return;
        }
    }

    public boolean enableBluetooth(boolean flag)
    {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter != null && !bluetoothadapter.isEnabled())
        {
            if (!flag && y)
            {
                return false;
            } else
            {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 8193);
                return false;
            }
        } else
        {
            return true;
        }
    }

    public void generateActivitiesReport()
    {
        DaySportData daysportdata;
        LuaEvent luaevent;
        DataManager datamanager = DataManager.getInstance();
        daysportdata = datamanager.get(datamanager.getToday());
        luaevent = LuaEvent.getInstance(this);
        if (daysportdata != null) goto _L2; else goto _L1
_L1:
        StepsInfo stepsinfo;
        return;
_L2:
        if ((stepsinfo = daysportdata.getStepsInfo()) != null)
        {
            ArrayList arraylist = stepsinfo.getActiveList();
            Debug.i("chenee", "Dump ActiveList:");
            Iterator iterator = arraylist.iterator();
            while (iterator.hasNext()) 
            {
                ActiveItem activeitem = (ActiveItem)iterator.next();
                if (activeitem.flag == 1)
                {
                    luaevent.setGoal();
                } else
                {
                    luaevent.setStep(activeitem);
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void generateContinueReachGoalReportAsync()
    {
        (new Thread(new s(this))).start();
    }

    public void generateSleepReport()
    {
        DataManager datamanager = DataManager.getInstance();
        DaySportData daysportdata = datamanager.get(datamanager.getToday());
        LuaEvent luaevent = LuaEvent.getInstance(this);
        cn.com.smartdevices.bracelet.analysis.SleepInfo sleepinfo;
        if (daysportdata != null)
        {
            if ((sleepinfo = daysportdata.getSleepInfo()) != null)
            {
                Debug.i("chenee", "sleep report .........................");
                luaevent.setSleep(sleepinfo);
                return;
            }
        }
    }

    public boolean isApplicationBroughtToBackground(Context context)
    {
        List list = ((ActivityManager)context.getSystemService("activity")).getRunningTasks(1);
        if (list != null && !list.isEmpty())
        {
            ComponentName componentname = ((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity;
            Debug.i(p, (new StringBuilder()).append("topActivity:").append(componentname.flattenToString()).toString());
            Debug.f(p, (new StringBuilder()).append("topActivity:").append(componentname.flattenToString()).toString());
            if (!componentname.getPackageName().equals(context.getPackageName()))
            {
                return true;
            }
        }
        return false;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Debug.i(p, "onActivityResult");
        if (i1 != 8193) goto _L2; else goto _L1
_L1:
        j1;
        JVM INSTR tableswitch -1 0: default 48
    //                   -1 49
    //                   0 59;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        e();
        y = false;
        return;
_L4:
        CustomToast.makeText(this, getString(0x7f0d0098), 1).show();
        onBtOff();
        y = true;
        return;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onBtOff()
    {
        super.onBtOff();
        EventBus.getDefault().post(new EventBtOnOff(1));
    }

    public void onBtOn()
    {
        super.onBtOn();
        EventBus.getDefault().post(new EventBtOnOff(0));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        r = this;
        w = true;
        Debug.i(p, (new StringBuilder()).append("onCreate:").append(mConnStatus).toString());
        m = Keeper.readBraceletBtInfo();
        g();
        a(0, 0);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(q);
        Debug.i(p, "onDestory..........................................");
        mConnStatus = new ConnStatus();
        l.removeCallbacksAndMessages(null);
        l = null;
        y = false;
    }

    public void onDeviceBatteryStatusChanged(byte byte0, int i1)
    {
        super.onDeviceBatteryStatusChanged(byte0, i1);
        Debug.i(p, (new StringBuilder()).append("onDeviceBatteryStatusChanged:").append(byte0).append(",").append(i1).toString());
        break MISSING_BLOCK_LABEL_43;
        if (byte0 == 0 || byte0 == 2 || byte0 == 3 || byte0 == 1 || byte0 != 4);
        EventBus.getDefault().post(new EventBatteryStatus(byte0, i1));
        return;
    }

    public void onDeviceConnected()
    {
        super.onDeviceConnected();
    }

    public void onDeviceConnectionFailed()
    {
        super.onDeviceConnectionFailed();
        a(5, null);
    }

    public void onDeviceDisconnected()
    {
        super.onDeviceDisconnected();
        Debug.i(p, "onDeviceDisconnected..................................");
        a(7, null);
    }

    public void onDeviceFound(BluetoothDevice bluetoothdevice, int i1)
    {
        Debug.i(p, (new StringBuilder()).append("MSG_BRACELET_FOUND ").append(bluetoothdevice.getName()).append(":").append(bluetoothdevice.getAddress()).toString());
        if (bluetoothdevice.getAddress().equals(m.address) && u)
        {
            Debug.i(p, (new StringBuilder()).append("FOUND last device:").append(m.address).toString());
            connect(bluetoothdevice);
            u = false;
        }
    }

    protected void onHideApp()
    {
        super.onHideApp();
    }

    public void onInitializationFailed()
    {
        super.onInitializationFailed();
        a(5, null);
    }

    protected void onPause()
    {
        w = false;
        Debug.i(p, (new StringBuilder()).append("onPause====isBroughtToBackground:").append(v).append(",").append("isNewActivity:").append(w).toString());
        Debug.f(p, (new StringBuilder()).append("onPause====isBroughtToBackground:").append(v).append(",").append("isNewActivity:").append(w).toString());
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Debug.i(p, (new StringBuilder()).append("onResume====isBroughtToBackground:").append(v).append("-").append("isNewActivity:").append(w).toString());
        Debug.f(p, (new StringBuilder()).append("onResume====isBroughtToBackground:").append(v).append("-").append("isNewActivity:").append(w).toString());
        if (!Utils.isBinded())
        {
            a(1, null);
        } else
        if (enableBluetooth(false) && (v || w))
        {
            a();
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        v = isApplicationBroughtToBackground(this);
        w = false;
        Debug.i(p, (new StringBuilder()).append("onStop====isBroughtToBackground:").append(v).append(",").append("isNewActivity:").append(w).toString());
        Debug.f(p, (new StringBuilder()).append("onStop====isBroughtToBackground:").append(v).append(",").append("isNewActivity:").append(w).toString());
        if (v)
        {
            y = false;
            b();
        }
    }

    public void onTogglePairResult(com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo deviceinfo)
    {
        super.onTogglePairResult(deviceinfo);
        Debug.i(p, (new StringBuilder()).append("onTogglePairResult:").append(deviceinfo).toString());
        Debug.f(p, (new StringBuilder()).append("onTogglePairResult:").append(deviceinfo).toString());
        if (deviceinfo == null)
        {
            a(5, null);
            return;
        }
        a(8, null);
        PowerManager powermanager = (PowerManager)getSystemService("power");
        d();
        Debug.i(p, (new StringBuilder()).append("isEnterInBackground:").append(x).append(",isScreenOn:").append(powermanager.isScreenOn()).toString());
        Debug.f(p, (new StringBuilder()).append("isEnterInBackground:").append(x).append(",isScreenOn:").append(powermanager.isScreenOn()).toString());
        if (x || !powermanager.isScreenOn())
        {
            c();
            return;
        } else
        {
            setLatency(39);
            f();
            return;
        }
    }

    public void startAnalysisThreadForLuaEvent(boolean flag)
    {
        (new Thread(new v(this, flag))).start();
    }

    public void startScanBracelet()
    {
        Debug.i(p, "startScanBracelet..............................");
        if (l == null)
        {
            return;
        }
        a(2, null);
        if (BraceletApp.BLEService != null)
        {
            Debug.i(p, "startScanBracelet");
            l.removeMessages(4096);
            u = true;
            BLEService bleservice = BraceletApp.BLEService;
            UUID auuid[] = new UUID[1];
            auuid[0] = MiLiProfile.UUID_SERVICE_MILI_SERVICE;
            bleservice.setServiceFilter(auuid);
            BraceletApp.BLEService.startScan(10000);
            l.sendEmptyMessageDelayed(4097, 10000L);
            return;
        } else
        {
            l.sendEmptyMessageDelayed(4096, 200L);
            return;
        }
    }

    public void startSyncData()
    {
        Debug.i(p, (new StringBuilder()).append("startSyncData isSyncDataRunning:").append(C).toString());
        Debug.f(p, (new StringBuilder()).append("startSyncData isSyncDataRunning:").append(C).toString());
        if (C)
        {
            return;
        } else
        {
            C = true;
            (new BleSyncDataTask(Keeper.readSyncBraceletTime(), new u(this))).work();
            return;
        }
    }

    protected void updateDynamicList(boolean flag)
    {
    }


    private class ConnStatus
    {

        int a;
        Object b;

        public String toString()
        {
            return (new StringBuilder()).append(a).append(" : ").append(b).toString();
        }

        public ConnStatus()
        {
            a = -1;
            b = null;
        }
    }

}
