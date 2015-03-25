// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.view.DayRepeatAdapter;
import cn.com.smartdevices.bracelet.view.SelectDaysView;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, i

public class AlarmRepeatActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String a = "AlarmRepeatActivity";
    private SelectDaysView b;
    private int c;
    private TextView d;

    public AlarmRepeatActivity()
    {
    }

    static int a(AlarmRepeatActivity alarmrepeatactivity)
    {
        return alarmrepeatactivity.c;
    }

    static int a(AlarmRepeatActivity alarmrepeatactivity, int j)
    {
        alarmrepeatactivity.c = j;
        return j;
    }

    private void a()
    {
        int j = 0;
        int k = 0;
        for (; j < AlarmClockItem.WEEK_MASK.length; j++)
        {
            if ((AlarmClockItem.WEEK_MASK[j] & c) != 0)
            {
                k++;
            }
        }

        Debug.i("AlarmRepeatActivity", (new StringBuilder()).append("bits=").append(k).toString());
        TextView textview = d;
        String s = getString(0x7f0d0012);
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(k);
        textview.setText(String.format(s, aobj));
    }

    static SelectDaysView b(AlarmRepeatActivity alarmrepeatactivity)
    {
        return alarmrepeatactivity.b;
    }

    private void b()
    {
        findViewById(0x7f0a0041).setOnClickListener(this);
        findViewById(0x7f0a0042).setOnClickListener(this);
        d = (TextView)findViewById(0x7f0a0092);
        b = (SelectDaysView)findViewById(0x7f0a0093);
        Debug.i("AlarmRepeatActivity", (new StringBuilder()).append("Days : ").append(c).toString());
        String as[] = getResources().getStringArray(0x7f07000d);
        b.setAdapter(new DayRepeatAdapter(this, as, c));
        b.setOnItemClickListener(new i(this));
    }

    static void c(AlarmRepeatActivity alarmrepeatactivity)
    {
        alarmrepeatactivity.a();
    }

    public void onClick(View view)
    {
        Intent intent;
        switch (view.getId())
        {
        default:
            return;

        case 2131361857: 
            finish();
            return;

        case 2131361858: 
            intent = new Intent();
            break;
        }
        intent.putExtra("Days", c);
        setResult(-1, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030016);
        Intent intent = getIntent();
        if (intent == null)
        {
            c = 0;
        }
        c = intent.getIntExtra("Days", 0);
        b();
        a();
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageAlarmNewRepeatCustom");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageAlarmNewRepeatCustom");
        UmengAnalytics.startSession(this);
    }
}
