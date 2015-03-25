// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            by, bA, bB, bz, 
//            bC, bD, SettingFeedbackActivity

public class p extends Fragment
    implements android.view.ttingAboutFragment
{

    private static final String a = "SettingAboutActivity";
    private View b;
    private TextView c;
    private View d;
    private View e;
    private View f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private final int j = 1;
    private final int k = 2;
    private final int l = 3;
    private final int m = 4;
    private ProgressDialog n;
    private int o;
    private Handler p;

    static int a(p p1, int i1)
    {
        p1.o = i1;
        return i1;
    }

    static ProgressDialog a(o o1)
    {
        return o1.n;
    }

    static ProgressDialog a(n n1, ProgressDialog progressdialog)
    {
        n1.n = progressdialog;
        return progressdialog;
    }

    private void a()
    {
        android.app.ettingAboutFragment ettingaboutfragment = new android.app.ettingAboutFragment(getActivity());
        ettingaboutfragment.getActivity("\u4E0A\u4F20\u8C03\u8BD5\u65E5\u5FD7");
        ettingaboutfragment.getActivity("\u8BF7\u786E\u4FDD\u662Fwifi\u7F51\u7EDC\u8FDE\u63A5\uFF0C\u5426\u5219\u4F1A\u8017\u8D39\u60A8\u7684\u6570\u636E\u6D41\u91CF\uFF0C\u786E\u5B9A\u4E0A\u4F20\uFF1F");
        ettingaboutfragment.getActivity("\u786E\u5B9A", new bA(this));
        ettingaboutfragment.ettingAboutFragment("\u53D6\u6D88", new bB(this));
        ettingaboutfragment.ettingAboutFragment();
    }

    private void a(View view)
    {
        b = view.findViewById(0x7f0a0034);
        b.setOnClickListener(this);
        c = (TextView)view.findViewById(0x7f0a010f);
        d = view.findViewById(0x7f0a0117);
        e = view.findViewById(0x7f0a0114);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        view.findViewById(0x7f0a0116).setOnClickListener(this);
        g = (LinearLayout)view.findViewById(0x7f0a0110);
        h = (TextView)view.findViewById(0x7f0a0111);
        i = (TextView)view.findViewById(0x7f0a010d);
        view.findViewById(0x7f0a0112).setOnClickListener(this);
        view.findViewById(0x7f0a0112).setOnLongClickListener(new bz(this));
        f = view.findViewById(0x7f0a010b);
        f.setOnClickListener(this);
    }

    private void b()
    {
        (new Thread(new bC(this))).start();
    }

    static void b(f f1)
    {
        f1.a();
    }

    private void c()
    {
        String s;
        File file;
        byte abyte0[];
        FileInputStream fileinputstream;
        long l1;
        long l2;
        ZipOutputStream zipoutputstream;
        int i1;
        try
        {
            if (p != null)
            {
                p.sendEmptyMessage(1);
            }
            s = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
            String s1 = Environment.getExternalStorageDirectory().getAbsolutePath();
            file = new File((new StringBuilder()).append(s1).append("/mili_log_").append(s).append(".zip").toString());
            if (file.exists())
            {
                file.delete();
            }
            abyte0 = new byte[4096];
            File file1 = new File((new StringBuilder()).append(s1).append("/mili_log.txt").toString());
            fileinputstream = new FileInputStream(file1);
            l1 = file1.length() - 0x3200000L;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
_L3:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        l2 = fileinputstream.skip(l1);
        if (l2 != -1L)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        ZipEntry zipentry = new ZipEntry((new StringBuilder()).append("mili_log_").append(s).append(".txt").toString());
        zipoutputstream = new ZipOutputStream(new FileOutputStream(file));
        zipoutputstream.putNextEntry(zipentry);
_L1:
        i1 = fileinputstream.read(abyte0, 0, abyte0.length);
        if (i1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        zipoutputstream.write(abyte0, 0, i1);
          goto _L1
        l1 -= l2;
        if (true) goto _L3; else goto _L2
_L2:
        zipoutputstream.closeEntry();
        fileinputstream.close();
        zipoutputstream.close();
        WebAPI.uploadLogFileBlock(Keeper.readLoginData(), file, new bD(this, file));
        return;
    }

    static void c(p p1)
    {
        p1.b();
    }

    private void d()
    {
        if (Keeper.readFileDebugFlag())
        {
            Debug.enable(false);
            Keeper.keepDebugFlag(false);
            Keeper.keepFileDebugFlag(false);
            CustomToast.makeText(getActivity(), 0x7f0d0065, 0).show();
            return;
        } else
        {
            Debug.enable(true);
            Keeper.keepDebugFlag(true);
            Keeper.keepFileDebugFlag(true);
            CustomToast.makeText(getActivity(), 0x7f0d0090, 0).show();
            return;
        }
    }

    static void d(getActivity getactivity)
    {
        getactivity.c();
    }

    static Handler e(c c1)
    {
        return c1.p;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            getActivity().finish();
            return;

        case 2131362071: 
            Utils.gotoWeb("file:///android_asset/useragreement.html", getString(0x7f0d01dd), getActivity());
            UmengAnalytics.event(getActivity(), "AboutUserAgreement");
            return;

        case 2131362068: 
            String s = "http://www.mi.com";
            Intent intent;
            if (Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString()))
            {
                s = "http://www.mi.com/en/";
            } else
            if (Locale.SIMPLIFIED_CHINESE.equals(Locale.getDefault()))
            {
                s = "http://www.mi.com";
            } else
            if (Locale.TRADITIONAL_CHINESE.equals(Locale.getDefault()))
            {
                s = "http://www.mi.com/tw/";
            }
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            startActivity(intent);
            UmengAnalytics.event(getActivity(), "AboutViewOfficialSite");
            return;

        case 2131362070: 
            if (Utils.isNetworkConnected(getActivity()))
            {
                Utils.checkApkUpgrade(getActivity(), true);
            } else
            {
                CustomToast.makeText(getActivity(), 0x7f0d010c, 0).show();
            }
            UmengAnalytics.event(getActivity(), "AboutCheckUpdate");
            return;

        case 2131362066: 
            startActivity(new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/SettingFeedbackActivity));
            UmengAnalytics.event(getActivity(), "AboutFeedback");
            return;

        case 2131362059: 
            o = 1 + o;
            if (o == 5)
            {
                d();
            }
            p.removeMessages(4);
            p.sendEmptyMessageDelayed(4, 300L);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030040, viewgroup, false);
        a(view);
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        p.removeCallbacksAndMessages(null);
        p = null;
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageAbout");
    }

    public void onResume()
    {
        super.onResume();
        Debug.i("SettingAboutActivity", "onResume() ");
        try
        {
            PackageInfo packageinfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            i.setText(packageinfo.versionName);
        }
        catch (android.content.pm.boutFragment boutfragment)
        {
            boutfragment.StackTrace();
        }
        UmengAnalytics.startPage("PageAbout");
    }

    public ()
    {
        f = null;
        g = null;
        h = null;
        n = null;
        o = 0;
        p = new by(this);
    }
}
