// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventSwitchViewMode;
import cn.com.smartdevices.bracelet.eventbus.EventUpdateTitle;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.view.CustomViewPager;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            TabsFragment, StatisticDailyFragment, StatisticWeeklyFragment, StatisticMonthlyFragment, 
//            v

public class StatisticHostFragment extends TabsFragment
    implements android.view.View.OnClickListener
{

    public static final int DEFAULT_MODE = 257;
    public static final int MODE_AVERAGE = 256;
    public static final int MODE_DETAIL = 16;
    public static final int MODE_SIMPLE = 1;
    public static final int MODE_TOTAL = 4096;
    private static final String a = "Statistic.Host";
    public static int sMode;
    private View b;
    private View c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private View h;

    public StatisticHostFragment()
    {
    }

    private int a(Context context)
    {
        int i = 257;
        int j = context.getSharedPreferences("StatisticViewMode", 0).getInt("Mode", i);
        if ((j & 1) == 0 && (j & 0x10) == 0)
        {
            Debug.w("Statistic.Host", (new StringBuilder()).append("Invalid Mode Code : ").append(j).toString());
        } else
        if ((j & 0x100) == 0 && (j & 0x1000) == 0)
        {
            Debug.w("Statistic.Host", (new StringBuilder()).append("Invalid Mode Code : ").append(j).toString());
        } else
        if ((j & 1) > 0 && (j & 0x10) > 0)
        {
            Debug.w("Statistic.Host", (new StringBuilder()).append("Invalid Mode Code : ").append(j).toString());
        } else
        if ((j & 0x100) > 0 && (j & 0x1000) > 0)
        {
            Debug.w("Statistic.Host", (new StringBuilder()).append("Invalid Mode Code : ").append(j).toString());
        } else
        {
            i = j;
        }
        a(context, i);
        Debug.i("Statistic.Host", (new StringBuilder()).append("Read Mode : ").append(Integer.toHexString(i)).toString());
        return i;
    }

    private void a()
    {
        View view = getView().findViewById(0x7f0a001e);
        view.buildDrawingCache();
        android.graphics.Bitmap bitmap = view.getDrawingCache();
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/tmp.jpg").toString();
        Utils.saveBitmapToFile(s, bitmap);
        view.findViewById(0x7f0a001e).destroyDrawingCache();
        Intent intent = new Intent();
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/ShareActivity);
        intent.putExtra("date", d.getText());
        intent.putExtra("Mode", 1);
        intent.putExtra("Image", s);
        startActivityForResult(intent, 32769);
    }

    private void a(int i)
    {
        if ((i & sMode) != 0) goto _L2; else goto _L1
_L1:
        int j = sMode;
        if (i != 1 && i != 16) goto _L4; else goto _L3
_L3:
        j = 0xffffffef & (-2 & sMode);
_L6:
        int k = j | i;
        sMode = k;
        a(((Context) (getActivity())), k);
        b();
        EventBus.getDefault().post(new EventSwitchViewMode());
_L2:
        return;
_L4:
        if (i == 256 || i == 4096)
        {
            j = 0xffffefff & (0xfffffeff & sMode);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(Context context, int i)
    {
        Debug.i("Statistic.Host", (new StringBuilder()).append("Save Mode : ").append(Integer.toHexString(i)).toString());
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("StatisticViewMode", 0).edit();
        editor.putInt("Mode", i);
        editor.commit();
    }

    private void b()
    {
        if ((1 & sMode) <= 0) goto _L2; else goto _L1
_L1:
        e.setActivated(true);
        f.setActivated(false);
_L8:
        if ((0x100 & sMode) <= 0) goto _L4; else goto _L3
_L3:
        g.setActivated(true);
        h.setActivated(false);
_L6:
        return;
_L2:
        if ((0x10 & sMode) > 0)
        {
            e.setActivated(false);
            f.setActivated(true);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((0x1000 & sMode) <= 0) goto _L6; else goto _L5
_L5:
        g.setActivated(false);
        h.setActivated(true);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void fillFragmentTabs(ArrayList arraylist)
    {
        TabsFragment.FragmentTab fragmenttab = new TabsFragment.FragmentTab(this);
        fragmenttab.a = getString(0x7f0d01ed);
        fragmenttab.b = cn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;
        arraylist.add(fragmenttab);
        TabsFragment.FragmentTab fragmenttab1 = new TabsFragment.FragmentTab(this);
        fragmenttab1.a = getString(0x7f0d0101);
        fragmenttab1.b = cn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;
        arraylist.add(fragmenttab1);
        TabsFragment.FragmentTab fragmenttab2 = new TabsFragment.FragmentTab(this);
        fragmenttab2.a = getString(0x7f0d01f0);
        fragmenttab2.b = cn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;
        arraylist.add(fragmenttab2);
    }

    protected int inflateLayout()
    {
        return 0x7f03004a;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mPager.setOnPageChangeListener(new v(this));
        ((CustomViewPager)mPager).setSwipeable(false);
        b = getView().findViewById(0x7f0a0034);
        b.setOnClickListener(this);
        c = getView().findViewById(0x7f0a00aa);
        c.setOnClickListener(this);
        d = (TextView)getView().findViewById(0x7f0a00d7);
        e = getView().findViewById(0x7f0a014f);
        f = getView().findViewById(0x7f0a0150);
        g = getView().findViewById(0x7f0a0152);
        h = getView().findViewById(0x7f0a0153);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        b();
    }

    public void onClick(View view)
    {
        super.onClick(view);
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            getActivity().finish();
            return;

        case 2131361962: 
            a();
            return;

        case 2131362127: 
            a(1);
            return;

        case 2131362128: 
            a(16);
            return;

        case 2131362130: 
            a(256);
            return;

        case 2131362131: 
            a(4096);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        sMode = a(getActivity());
    }

    public void onDestroy()
    {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(EventUpdateTitle eventupdatetitle)
    {
        d.setText(eventupdatetitle.title);
    }
}
