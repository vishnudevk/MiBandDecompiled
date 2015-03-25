// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BleTask.BleResetTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            P, I, J, K, 
//            L, M, N, O, 
//            H

public class BraceletSettingsFragment extends PreferenceFragment
{

    private final int a = 4098;
    private ProgressDialog b;
    private Handler c;

    public BraceletSettingsFragment()
    {
        b = null;
        c = null;
    }

    private void a()
    {
        ArrayList arraylist = Keeper.readAlarms();
        Preference preference = findPreference("settings_alarm_clock");
        if (arraylist == null || arraylist.size() < 1)
        {
            preference.setSummary("\u672A\u5F00\u542F");
            return;
        }
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            if (((AlarmClockItem)iterator.next()).isEnabled())
            {
                preference.setSummary("\u5DF2\u5F00\u542F");
                return;
            }
        }

        preference.setSummary("\u672A\u5F00\u542F");
    }

    private void a(int i)
    {
        if (b == null)
        {
            b = new ProgressDialog(getActivity());
            b.setMax(i);
            b.setProgress(0);
            b.setTitle("\u56FA\u4EF6\u5347\u7EA7");
            b.setMessage("\u5347\u7EA7\u8FDB\u5EA6");
            b.setCancelable(false);
            b.setProgressStyle(1);
            b.setIndeterminate(false);
            b.show();
        }
    }

    static void a(BraceletSettingsFragment braceletsettingsfragment)
    {
        braceletsettingsfragment.f();
    }

    static void a(BraceletSettingsFragment braceletsettingsfragment, int i)
    {
        braceletsettingsfragment.a(i);
    }

    static void a(BraceletSettingsFragment braceletsettingsfragment, String s, String s1)
    {
        braceletsettingsfragment.a(s, s1);
    }

    private void a(String s, String s1)
    {
        (new BleFwUpgradeTask(s, s1, new P(this, s1))).work();
    }

    private void b()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("\u91CD\u7F6E\u624B\u73AF");
        builder.setMessage("\u5C06\u6E05\u9664\u624B\u73AF\u4E2D\u7684\u8FD0\u52A8\u8BB0\u5F55\u548C\u4E2A\u4EBA\u4FE1\u606F\uFF0C\u786E\u5B9A\u91CD\u7F6E\uFF1F");
        builder.setNegativeButton("\u53D6\u6D88", new I(this));
        builder.setPositiveButton("\u786E\u5B9A", new J(this));
        builder.show();
    }

    private void b(int i)
    {
        if (b != null)
        {
            b.setProgress(i);
        }
    }

    static void b(BraceletSettingsFragment braceletsettingsfragment)
    {
        braceletsettingsfragment.d();
    }

    private void c()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setView(LayoutInflater.from(getActivity()).inflate(0x7f030067, null));
        builder.setPositiveButton("\u786E\u5B9A", new K(this));
        builder.setNegativeButton("\u53D6\u6D88", new L(this));
        builder.show();
    }

    static void c(BraceletSettingsFragment braceletsettingsfragment)
    {
        braceletsettingsfragment.g();
    }

    private void d()
    {
        (new BleResetTask(new M(this))).work();
    }

    private void e()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("\u56FA\u4EF6\u5347\u7EA7");
        String s = (new StringBuilder()).append(((BraceletApp)getActivity().getApplication()).getStoragePath()).append("/bracelet.fw").toString();
        File file = new File(s);
        String s1;
        if (file.exists() && file.canRead())
        {
            s1 = (new StringBuilder()).append("\u624B\u73AF\u56FA\u4EF6\u8DEF\u5F84\uFF1A").append(s).append("\n").append("\u786E\u5B9A\u5347\u7EA7\uFF1F").toString();
            builder.setPositiveButton("\u786E\u5B9A", new N(this, s));
        } else
        {
            s1 = (new StringBuilder()).append("\u624B\u73AF\u56FA\u4EF6\u8DEF\u5F84\uFF1A").append(s).append("\u4E0D\u5B58\u5728,").append("\u8BF7\u628A\u56FA\u4EF6\u590D\u5236\u5230\u76EE\u6807\u5730\u5740\u540E\u91CD\u8BD5\uFF01").toString();
        }
        builder.setMessage(s1);
        builder.setNegativeButton("\u53D6\u6D88", new O(this));
        builder.show();
    }

    private void f()
    {
        b(((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getFirmwareUpdatingProgress().progress);
        c.sendEmptyMessageDelayed(4098, 1000L);
    }

    private void g()
    {
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
        c.removeMessages(4098);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050001);
        c = new H(this);
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference)
    {
        if (preference.getKey().equals("settings_bracelet_reset"))
        {
            b();
            return true;
        }
        if (!preference.getKey().equals("settings_fw_upgrade")) goto _L2; else goto _L1
_L1:
        e();
_L4:
        return super.onPreferenceTreeClick(preferencescreen, preference);
_L2:
        if (preference.getKey().equals("settings_push_goals_progress"))
        {
            c();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        super.onResume();
        a();
    }
}
