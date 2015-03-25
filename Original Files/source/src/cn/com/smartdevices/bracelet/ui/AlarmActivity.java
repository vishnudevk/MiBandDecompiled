// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.google.gson.Gson;
import de.greenrobot.event.EventBus;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, b, e, c, 
//            d, a

public class AlarmActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public static final int ALARM_NUM = 3;
    public static final String ALARM_TIME = "alarmtime";
    public static final String ALERT = "alert";
    public static final String DAYS_OF_WEEK = "daysofweek";
    public static final String ENABLED = "enabled";
    public static final String HOUR = "hour";
    public static final String ID = "_id";
    public static final String MESSAGE = "message";
    public static final String MINUTES = "minutes";
    public static final String REF_ALARM_INDEX = "ref_alarm_index";
    public static final String VIBRATE = "vibrate";
    private static final int a = 257;
    private static final int b = 1;
    private static final String c = "AlarmActivity";
    private static final String d = "ALARM_ONCE_TRIGGLED";
    private static final String l = "content://com.android.deskclock/alarm";
    private Activity e;
    private Handler f;
    private PersonInfo g;
    private ListView h;
    private e i;
    private ArrayList j;
    private int k;
    private BroadcastReceiver m;
    private View n;
    private TextView o;
    private View p;
    private boolean q;

    public AlarmActivity()
    {
        j = new ArrayList();
    }

    static int a(AlarmActivity alarmactivity, int i1)
    {
        alarmactivity.k = i1;
        return i1;
    }

    private void a()
    {
        n.setVisibility(8);
        p.setBackgroundResource(0x7f090003);
    }

    private void a(ContentResolver contentresolver)
    {
        Cursor cursor;
        ArrayList arraylist;
        String s = android.provider.Settings.System.getString(contentresolver, "alarm_alert");
        String s1 = android.provider.Settings.System.getString(contentresolver, "next_alarm_formatted");
        Debug.i("AlarmActivity", (new StringBuilder()).append("system alarm = ").append(s).append(", nextAlarm=").append(s1).toString());
        Uri uri = Uri.parse("content://com.android.deskclock/alarm");
        cursor = e.getContentResolver().query(uri, new String[] {
            "_id", "hour", "minutes", "daysofweek", "enabled"
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        arraylist = null;
_L2:
        int i1;
        int j1;
        if (!cursor.moveToNext())
        {
            break MISSING_BLOCK_LABEL_368;
        }
        Debug.i("AlarmActivity", (new StringBuilder()).append("id: ").append(cursor.getInt(0)).append("\t hour: ").append(cursor.getInt(cursor.getColumnIndex("hour"))).append(", min=").append(cursor.getInt(cursor.getColumnIndex("minutes"))).append(", enabled=").append(cursor.getInt(cursor.getColumnIndex("enabled"))).toString());
        i1 = cursor.getInt(cursor.getColumnIndex("hour"));
        j1 = cursor.getInt(cursor.getColumnIndex("minutes"));
        Exception exception1;
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndex("enabled")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || i1 < 5 || i1 > 10) goto _L2; else goto _L1
_L1:
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        arraylist = new ArrayList(3);
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i1);
        calendar.set(12, j1);
        arraylist.add(calendar);
          goto _L2
        exception1;
        exception1.printStackTrace();
        cursor.close();
        return;
        if (arraylist == null) goto _L4; else goto _L3
_L3:
        if (arraylist.size() <= 0) goto _L4; else goto _L5
_L5:
        Debug.i("AlarmActivity", Utils.getGson().toJson(arraylist));
        Keeper.keepMorningAlarms(Utils.getGson().toJson(arraylist));
_L7:
        cursor.close();
        return;
_L4:
        Keeper.keepMorningAlarms("");
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    static void a(AlarmActivity alarmactivity)
    {
        alarmactivity.g();
    }

    static void a(AlarmActivity alarmactivity, ContentResolver contentresolver)
    {
        alarmactivity.a(contentresolver);
    }

    static PersonInfo b(AlarmActivity alarmactivity)
    {
        return alarmactivity.g;
    }

    private void b()
    {
        n.setVisibility(0);
        p.setBackgroundResource(0x7f090007);
    }

    static Activity c(AlarmActivity alarmactivity)
    {
        return alarmactivity.e;
    }

    private void c()
    {
        m = new b(this);
        e.registerReceiver(m, new IntentFilter("ALARM_ONCE_TRIGGLED"));
    }

    static ArrayList d(AlarmActivity alarmactivity)
    {
        return alarmactivity.j;
    }

    private void d()
    {
        h = (ListView)findViewById(0x7f0a0091);
        i = new e(this);
        h.setAdapter(i);
        n = findViewById(0x7f0a002a);
        o = (TextView)findViewById(0x7f0a0034);
        o.setOnClickListener(this);
        p = findViewById(0x7f0a0090);
    }

    private void e()
    {
        try
        {
            h();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        j = g.getAlarmClockItems();
    }

    static boolean e(AlarmActivity alarmactivity)
    {
        return alarmactivity.q;
    }

    private void f()
    {
        f.removeMessages(1);
        f.sendMessageDelayed(f.obtainMessage(1), 2000L);
    }

    static void f(AlarmActivity alarmactivity)
    {
        alarmactivity.f();
    }

    static int g(AlarmActivity alarmactivity)
    {
        return alarmactivity.k;
    }

    private void g()
    {
        HashMap hashmap = new HashMap();
        try
        {
            String s = URLEncoder.encode(Utils.getGson().toJson(j), "utf-8");
            hashmap.put("alarm_clock", s);
            Debug.i("AlarmActivity", (new StringBuilder()).append("alarm encoded str = ").append(s).toString());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        Utils.updateProfile(g, hashmap, new c(this));
    }

    private void h()
    {
        ContentResolver contentresolver = e.getContentResolver();
        contentresolver.registerContentObserver(Uri.parse("content://com.android.deskclock/alarm"), true, new d(this, null, contentresolver));
        a(contentresolver);
    }

    public static void setAlarmItems(AlarmClockItem alarmclockitem, Context context)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), alarmclockitem.getHour(), alarmclockitem.getMinute(), 0);
        Calendar calendar1 = Calendar.getInstance();
        if (alarmclockitem.getDays() == AlarmClockItem.ALARM_ONCE && calendar.before(calendar1))
        {
            calendar.add(6, 1);
            Debug.i("AlarmActivity", (new StringBuilder()).append("after add one day :").append(calendar).toString());
        }
        alarmclockitem.setCalendar(calendar);
        alarmclockitem.setUpdate(true);
        if (alarmclockitem.getDays() == AlarmClockItem.ALARM_ONCE)
        {
            long l1 = calendar.getTimeInMillis();
            Intent intent = new Intent("ALARM_ONCE_TRIGGLED");
            PendingIntent pendingintent = PendingIntent.getBroadcast(context, calendar.hashCode(), intent, 0x8000000);
            ((AlarmManager)context.getSystemService("alarm")).set(0, l1, pendingintent);
        }
    }

    public void checkOnceAlarmIfExpired()
    {
        j = g.getAlarmClockItems();
        Calendar calendar = Calendar.getInstance();
        Iterator iterator = j.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AlarmClockItem alarmclockitem = (AlarmClockItem)iterator.next();
            if (alarmclockitem.getDays() == AlarmClockItem.ALARM_ONCE && alarmclockitem.getCalendar().before(calendar))
            {
                alarmclockitem.setEnabled(false);
            }
        } while (true);
        Keeper.keepPersonInfo(g);
        i.notifyDataSetChanged();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 257 && j1 == -1)
        {
            AlarmClockItem alarmclockitem = AlarmClockItem.fromJson(intent.getStringExtra("alarms"));
            j.set(k, alarmclockitem);
            i.notifyDataSetChanged();
            g.setNeedSyncServer(2);
            Keeper.keepPersonInfo(g);
            f();
        }
    }

    public void onBleStatusChanged(BaseSCActivity.ConnStatus connstatus)
    {
        if (connstatus.a == 8)
        {
            a();
            applyStatusBarTintAuto();
        } else
        if (connstatus.a < 8)
        {
            b();
            applyStatusBarTintAuto();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        EventBus.getDefault().register(this, "onBleStatusChanged", cn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus, new Class[0]);
        setContentView(0x7f030015);
        e = this;
        f = new a(this);
        g = Keeper.readPersonInfo();
        e();
        d();
        c();
        if (!Utils.isBraceletConnected())
        {
            b();
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        e.unregisterReceiver(m);
        Iterator iterator = j.iterator();
        int i1 = 0;
        int j1 = 0;
        while (iterator.hasNext()) 
        {
            AlarmClockItem alarmclockitem = (AlarmClockItem)iterator.next();
            String s;
            int k1;
            int l1;
            if (alarmclockitem.isEnabled())
            {
                if (!alarmclockitem.isSmartWakeup())
                {
                    int i2 = j1 + 1;
                    k1 = i1;
                    l1 = i2;
                } else
                {
                    k1 = i1 + 1;
                    l1 = j1;
                }
            } else
            {
                k1 = i1;
                l1 = j1;
            }
            j1 = l1;
            i1 = k1;
        }
        s = (new StringBuilder()).append("Normal:").append(j1).append(", Smart:").append(i1).toString();
        UmengAnalytics.event(e, "AlarmSetting", s);
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageAlarm");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        checkOnceAlarmIfExpired();
        new DateFormat();
        q = DateFormat.is24HourFormat(this);
        if (i != null)
        {
            i.notifyDataSetChanged();
        }
        UmengAnalytics.startPage("PageAlarm");
        UmengAnalytics.startSession(this);
    }
}
