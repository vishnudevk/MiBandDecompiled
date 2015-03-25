// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.utils.OpenConfig;
import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package com.tencent.open.a:
//            d, a, c, e

public class b
{

    private static b a = null;
    private long b;
    private int c;
    private boolean d;
    private Random e;
    private d f;
    private ArrayList g;
    private ArrayList h;

    public b()
    {
        b = 0L;
        c = 3;
        d = false;
        g = new ArrayList();
        h = new ArrayList();
        e = new Random();
    }

    static int a(b b1)
    {
        return b1.c;
    }

    static int a(b b1, int i)
    {
        b1.c = i;
        return i;
    }

    public static b a()
    {
        if (a == null)
        {
            a = new b();
        }
        return a;
    }

    private String a(Context context)
    {
        ConnectivityManager connectivitymanager;
        NetworkInfo networkinfo;
        String s;
        String s1;
        try
        {
            connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "unknow";
        }
        if (connectivitymanager != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        Log.e("cgi_report_debug", "ReportManager getAPN failed:ConnectivityManager == null");
        return "no_net";
        networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (networkinfo.isAvailable())
        {
            break MISSING_BLOCK_LABEL_55;
        }
        Log.e("cgi_report_debug", "ReportManager getAPN failed:NetworkInfo == null");
        return "no_net";
        if (!networkinfo.getTypeName().toUpperCase().equals("WIFI"))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Log.i("cgi_report_debug", "ReportManager getAPN type = wifi");
        return "wifi";
        s = networkinfo.getExtraInfo();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        Log.e("cgi_report_debug", "ReportManager getAPN failed:extraInfo == null");
        return "mobile_unknow";
        s1 = s.toLowerCase();
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportManager getAPN type = ").append(s1).toString());
        return s1;
    }

    private void a(Context context, String s)
    {
        Log.i("cgi_report_debug", "ReportManager doUpload start");
        d = true;
        g = f.c();
        f.b();
        h = f.d();
        f.a();
        Bundle bundle = new Bundle();
        bundle.putString("appid", s);
        bundle.putString("releaseversion", "QQConnect_SDK_Android_1_7");
        bundle.putString("device", Build.DEVICE);
        bundle.putString("qua", "V1_AND_OpenSDK_2.1_1077_RDM_B");
        bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,deviceinfo");
        for (int i = 0; i < g.size(); i++)
        {
            bundle.putString((new StringBuilder()).append(i).append("_1").toString(), ((a)g.get(i)).a());
            bundle.putString((new StringBuilder()).append(i).append("_2").toString(), ((a)g.get(i)).b());
            bundle.putString((new StringBuilder()).append(i).append("_3").toString(), ((a)g.get(i)).c());
            bundle.putString((new StringBuilder()).append(i).append("_4").toString(), ((a)g.get(i)).d());
            bundle.putString((new StringBuilder()).append(i).append("_5").toString(), ((a)g.get(i)).e());
            bundle.putString((new StringBuilder()).append(i).append("_6").toString(), ((a)g.get(i)).f());
            bundle.putString((new StringBuilder()).append(i).append("_7").toString(), ((a)g.get(i)).g());
            bundle.putString((new StringBuilder()).append(i).append("_8").toString(), ((a)g.get(i)).h());
            String s2 = (new StringBuilder()).append(com.tencent.open.a.c.b(context)).append(((a)g.get(i)).i()).toString();
            bundle.putString((new StringBuilder()).append(i).append("_9").toString(), s2);
        }

        for (int j = g.size(); j < h.size() + g.size(); j++)
        {
            int k = j - g.size();
            bundle.putString((new StringBuilder()).append(j).append("_1").toString(), ((a)h.get(k)).a());
            bundle.putString((new StringBuilder()).append(j).append("_2").toString(), ((a)h.get(k)).b());
            bundle.putString((new StringBuilder()).append(j).append("_3").toString(), ((a)h.get(k)).c());
            bundle.putString((new StringBuilder()).append(j).append("_4").toString(), ((a)h.get(k)).d());
            bundle.putString((new StringBuilder()).append(j).append("_5").toString(), ((a)h.get(k)).e());
            bundle.putString((new StringBuilder()).append(j).append("_6").toString(), ((a)h.get(k)).f());
            bundle.putString((new StringBuilder()).append(j).append("_7").toString(), ((a)h.get(k)).g());
            bundle.putString((new StringBuilder()).append(j).append("_8").toString(), ((a)h.get(k)).h());
            String s1 = (new StringBuilder()).append(com.tencent.open.a.c.b(context)).append(((a)h.get(k)).i()).toString();
            bundle.putString((new StringBuilder()).append(j).append("_9").toString(), s1);
        }

        a(context, "http://wspeed.qq.com/w.cgi", "POST", bundle);
    }

    private void a(Context context, String s, long l, long l1, long l2, int i, String s1, String s2)
    {
        long l3 = SystemClock.elapsedRealtime() - l;
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportManager updateDB url=").append(s).append(",resultCode=").append(i).append(",timeCost=").append(l3).append(",reqSize=").append(l1).append(",rspSize=").append(l2).toString());
        int j = 100 / b(context, i);
        int k;
        String s3;
        if (j <= 0)
        {
            k = 1;
        } else
        if (j > 100)
        {
            k = 100;
        } else
        {
            k = j;
        }
        s3 = a(context);
        f.a(s3, (new StringBuilder()).append(k).append("").toString(), s, i, l3, l1, l2, s2);
    }

    private void a(Context context, String s, String s1, Bundle bundle)
    {
        (new e(this, s, context, bundle)).start();
    }

    private boolean a(Context context, int i)
    {
        int j = b(context, i);
        if (e.nextInt(100) < j)
        {
            Log.i("cgi_report_debug", "ReportManager availableForFrequency = ture");
            return true;
        } else
        {
            Log.i("cgi_report_debug", "ReportManager availableForFrequency = false");
            return false;
        }
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    private int b(Context context, int i)
    {
        if (i == 0)
        {
            int k = OpenConfig.getInstance(context, null).getInt("Common_CGIReportFrequencySuccess");
            Log.d("OpenConfig_agent", (new StringBuilder()).append("config 4:Common_CGIReportFrequencySuccess     config_value:").append(k).toString());
            if (k == 0)
            {
                k = 10;
            }
            Log.d("OpenConfig_agent", (new StringBuilder()).append("config 4:Common_CGIReportFrequencySuccess     result_value:").append(k).toString());
            return k;
        }
        int j = OpenConfig.getInstance(context, null).getInt("Common_CGIReportFrequencyFailed");
        Log.d("OpenConfig_agent", (new StringBuilder()).append("config 4:Common_CGIReportFrequencyFailed     config_value:").append(j).toString());
        if (j == 0)
        {
            j = 100;
        }
        Log.d("OpenConfig_agent", (new StringBuilder()).append("config 4:Common_CGIReportFrequencyFailed     result_value:").append(j).toString());
        return j;
    }

    static ArrayList b(b b1)
    {
        return b1.g;
    }

    private boolean b(Context context)
    {
        long l = OpenConfig.getInstance(context, null).getLong("Common_CGIReportTimeinterval");
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 5:Common_CGIReportTimeinterval     config_value:").append(l).toString());
        if (l == 0L)
        {
            l = 1200L;
        }
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 5:Common_CGIReportTimeinterval     result_value:").append(l).toString());
        long l1 = System.currentTimeMillis() / 1000L;
        if (b == 0L || l + b <= l1)
        {
            b = l1;
            Log.i("cgi_report_debug", "ReportManager availableForTime = ture");
            return true;
        } else
        {
            Log.i("cgi_report_debug", "ReportManager availableForTime = false");
            return false;
        }
    }

    static d c(b b1)
    {
        return b1.f;
    }

    private boolean c(Context context)
    {
        int i = OpenConfig.getInstance(context, null).getInt("Common_CGIReportMaxcount");
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 6:Common_CGIReportMaxcount     config_value:").append(i).toString());
        if (i == 0)
        {
            i = 20;
        }
        Log.d("OpenConfig_test", (new StringBuilder()).append("config 6:Common_CGIReportMaxcount     result_value:").append(i).toString());
        if (f.e() >= i)
        {
            Log.i("cgi_report_debug", "ReportManager availableForCount = ture");
            return true;
        } else
        {
            Log.i("cgi_report_debug", "ReportManager availableForCount = false");
            return false;
        }
    }

    public void a(Context context, String s, long l, long l1, long l2, int i, String s1)
    {
        a(context, s, l, l1, l2, i, s1, "", null);
    }

    public void a(Context context, String s, long l, long l1, long l2, int i, String s1, String s2, String s3)
    {
        if (s3 == null)
        {
            s3 = "1000067";
        }
        if (f == null)
        {
            f = new d(context);
        }
        if (a(context, i))
        {
            a(context, s, l, l1, l2, i, s1, s2);
            if (!d)
            {
                if (b(context))
                {
                    a(context, s3);
                    return;
                }
                if (c(context))
                {
                    a(context, s3);
                    return;
                }
            }
        }
    }

}
