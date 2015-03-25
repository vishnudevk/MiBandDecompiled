// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.DownloadManager;
import android.app.FragmentManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleSetPersonalInfoTask;
import cn.com.smartdevices.bracelet.activity.WebActivity;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.ui.ApkUpgradeFragment;
import cn.com.smartdevices.bracelet.ui.DimPanelFragment;
import cn.com.smartdevices.bracelet.ui.ProgressBarFragment;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.BraceletHttpClient;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.market.sdk.UpdateResponse;
import com.xiaomi.market.sdk.XiaomiUpdateAgent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug, Keeper, h, i, 
//            BraceletApp, DataManager, f, BraceletImageLoader, 
//            g, e

public class Utils
{

    public static final String APK_PATH = "APK_PATH";
    public static final String CHANGE_LOG = "CHANGE_LOG";
    public static final boolean DEBUG = true;
    public static final String DEVICE_TYPE = "0";
    public static final boolean DISABLE_BAIDU_LOCATION = true;
    public static final boolean USE_MILIAO_ICON = true;
    public static final boolean USE_MILIAO_NICKNAME = true;
    public static final String VERSION_NAME = "VERSION_NAME";
    private static final String a = "Utils";
    private static Gson b;
    private static final String c[] = {
        "MI 2", "MI 2S"
    };
    private static final String d[] = {
        "jt>", "aku", "blv", "cmw", "dnx", "eoy", "fpz", "gq!", "hr(", "is)"
    };

    public Utils()
    {
    }

    public static String URLDecodeStr(String s)
    {
        String s1;
        try
        {
            s1 = URLDecoder.decode(s, "utf-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            return s;
        }
        return s1;
    }

    private static int a(android.graphics.BitmapFactory.Options options, int j, int k)
    {
        int l = options.outHeight;
        int i1 = options.outWidth;
        int j1 = 1;
        if (l > k || i1 > j)
        {
            int k1 = l / 2;
            for (int l1 = i1 / 2; k1 / j1 > k && l1 / j1 > j; j1 *= 2) { }
        }
        return j1;
    }

    private static String a(Context context, int j)
    {
        DecimalFormat decimalformat = new DecimalFormat("#.#");
        float f1 = (float)j / 42000F;
        float f2 = Math.round(f1);
        if (f2 > f1)
        {
            f2 -= 0.5F;
        }
        String s1;
        if ((float)j > 42000F)
        {
            String s2 = decimalformat.format(f2);
            if ((double)Math.abs(f2 - f1) < 0.10000000000000001D)
            {
                s1 = context.getString(0x7f0d00e9, new Object[] {
                    s2
                });
            } else
            {
                s1 = context.getString(0x7f0d00ea, new Object[] {
                    s2
                });
            }
        } else
        if (Math.abs(j - 21000) < 500)
        {
            s1 = context.getString(0x7f0d00c0, new Object[] {
                "1"
            });
        } else
        if (j > 21000)
        {
            s1 = context.getString(0x7f0d00c1, new Object[] {
                "1"
            });
        } else
        {
            float f3 = (float)j / 400F;
            float f4 = Math.round(f3);
            if (f4 > f3)
            {
                f4 -= 0.5F;
            }
            String s = decimalformat.format(f4);
            if (f4 == 0.0F)
            {
                s1 = "";
            } else
            {
                s1 = context.getString(0x7f0d0163, new Object[] {
                    s
                });
            }
        }
        Debug.i("Utils", (new StringBuilder()).append("maraton:").append(j).append(", str=").append(s1).toString());
        return s1;
    }

    static void a(UpdateResponse updateresponse, Activity activity, String s)
    {
        b(updateresponse, activity, s);
    }

    private static String b(Context context, int j)
    {
        int k = j / 9;
        String s;
        if (k == 0)
        {
            s = "";
        } else
        {
            DecimalFormat decimalformat = new DecimalFormat("#.#");
            s = (new StringBuilder()).append(k).append(context.getString(0x7f0d00be)).toString();
            if (k >= 1000)
            {
                return (new StringBuilder()).append(decimalformat.format((double)k / 1000D)).append(context.getString(0x7f0d00db)).toString();
            }
        }
        return s;
    }

    private static void b(UpdateResponse updateresponse, Activity activity, String s)
    {
        if (activity == null || updateresponse == null)
        {
            Debug.i("Utils", "showUpdateDlg return with NULL pointer!");
            return;
        }
        if (!TextUtils.isEmpty(updateresponse.updateLog))
        {
            Debug.i("Utils", (new StringBuilder()).append("mi shop updateLog=").append(updateresponse.updateLog).toString());
            s = updateresponse.updateLog;
        }
        Bundle bundle = new Bundle();
        bundle.putString("VERSION_NAME", updateresponse.versionName);
        bundle.putString("CHANGE_LOG", s);
        bundle.putString("APK_PATH", updateresponse.path);
        DimPanelFragment.showPanel(activity, cn/com/smartdevices/bracelet/ui/ApkUpgradeFragment, bundle);
    }

    public static void bytesToDayDataTest(String s, String s1, byte abyte0[])
    {
        int j = abyte0.length;
        Debug.i(s, (new StringBuilder()).append("=============================").append(s1).append("============================i").toString());
        for (int k = 0; k < j; k += 3)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData(abyte0[k + 1], abyte0[k + 2], abyte0[k]);
            Debug.i(s, (new SportData(k / 3, 0xff & activitydata.category, 0xff & activitydata.intensity, 0xff & activitydata.steps)).toString());
        }

        Debug.i(s, (new StringBuilder()).append("=============================").append(s1).append("============================o").toString());
    }

    public static int calculateInSampleSize1(android.graphics.BitmapFactory.Options options, int j, int k)
    {
        int k1;
label0:
        {
            int l = options.outHeight;
            int i1 = options.outWidth;
            int j1 = 1;
            if (l > k || i1 > j)
            {
                j1 = Math.round((float)l / (float)k);
                k1 = Math.round((float)i1 / (float)j);
                if (j1 <= k1)
                {
                    break label0;
                }
            }
            return j1;
        }
        return k1;
    }

    public static void checkApkUpgrade(Activity activity, boolean flag)
    {
        Calendar calendar = Calendar.getInstance();
        if (!compaireDateCalendarA_before_B(Keeper.readLastCheckUpdateDate(), calendar) && !flag)
        {
            Debug.i("Utils", "Today has checked upgrade.");
            return;
        }
        Keeper.keepCheckUpdateApkDate();
        if (flag)
        {
            CustomToast.makeText(activity, 0x7f0d0044, 0).show();
        }
        BraceletHttpClient.client.get("https://hm.xiaomi.com/huami.health.changelog.json", new h(flag));
    }

    public static boolean checkDeviceCompatible()
    {
        String s = Build.MODEL;
        Debug.i("Utils", (new StringBuilder()).append("model:").append(s).toString());
        String as[] = c;
        int j = as.length;
        int k = 0;
        do
        {
label0:
            {
                boolean flag = false;
                if (k < j)
                {
                    if (!as[k].equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k++;
        } while (true);
    }

    public static boolean checkInputText(String s)
    {
        while (s == null || s.length() < 1 || s.length() > 20) 
        {
            return false;
        }
        return true;
    }

    public static String checkNull(String s)
    {
        if (s == null || s.equals("null"))
        {
            s = "";
        }
        return s;
    }

    public static final boolean checkSystemRequirement()
    {
        Debug.i("Utils", (new StringBuilder()).append("Sdk : ").append(android.os.Build.VERSION.SDK_INT).append(" model:").append(Build.MODEL).toString());
        return android.os.Build.VERSION.SDK_INT >= 18;
    }

    public static void checkXiaomiApkUpdate(Activity activity, boolean flag, String s)
    {
        Debug.i("Utils", "checkXiaomiApkUpdate");
        XiaomiUpdateAgent.setUpdateAutoPopup(false);
        XiaomiUpdateAgent.setUpdateListener(new i(activity, s, flag));
        XiaomiUpdateAgent.update(activity);
    }

    public static boolean compaireDateCalendarA_before_B(Calendar calendar, Calendar calendar1)
    {
        if (calendar != null && calendar1 != null)
        {
            int j = calendar.get(1);
            int k = calendar1.get(1);
            int l = calendar.get(6);
            int i1 = calendar1.get(6);
            int j1 = l + j * 365;
            int k1 = i1 + k * 365;
            Debug.i("Utils", (new StringBuilder()).append("totalA =").append(j1).append(", totalB=").append(k1).toString());
            if (j1 >= k1)
            {
                return false;
            }
        }
        return true;
    }

    public static void connect(BluetoothDevice bluetoothdevice, boolean flag)
    {
        Debug.i("Utils", (new StringBuilder()).append("connect device=").append(bluetoothdevice.getAddress()).append(",  ").append(bluetoothdevice.getName()).toString());
        Debug.f("Utils", (new StringBuilder()).append("connect device=").append(bluetoothdevice.getAddress()).append(",  ").append(bluetoothdevice.getName()).toString());
        cn.com.smartdevices.bracelet.BraceletApp.BLEService.stopScan();
        MiLiProfile miliprofile = (MiLiProfile)cn.com.smartdevices.bracelet.BraceletApp.BLEService.newConnection(bluetoothdevice, com/xiaomi/hm/bleservice/profile/MiLiProfile);
        miliprofile.setAutoReconnect(flag);
        miliprofile.connect();
    }

    public static float convertDpToPixel(float f1, Context context)
    {
        return f1 * ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static float convertPixelsToDp(float f1, Context context)
    {
        return f1 / ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static ArrayList copy(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList(arraylist.size());
        try
        {
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); arraylist1.add(((SportData)iterator.next()).copy())) { }
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            clonenotsupportedexception.printStackTrace();
            arraylist1.clear();
        }
        return arraylist1;
    }

    public static ArrayList copyBySerialize(ArrayList arraylist)
    {
        ArrayList arraylist1;
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            (new ObjectOutputStream(bytearrayoutputstream)).writeObject(arraylist);
            arraylist1 = (ArrayList)(new ObjectInputStream(new ByteArrayInputStream(bytearrayoutputstream.toByteArray()))).readObject();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Debug.i("WPJ", exception.getMessage());
            return new ArrayList();
        }
        return arraylist1;
    }

    public static Bitmap createImageSafely(String s, int j, int k)
    {
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = calculateInSampleSize1(options, j, k);
        options.inJustDecodeBounds = false;
        Bitmap bitmap1 = BitmapFactory.decodeFile(s, options);
        Bitmap bitmap = bitmap1;
_L2:
        Debug.i("WPJ", (new StringBuilder()).append("createImageSafely:").append(bitmap.getWidth()).append(",").append(bitmap.getHeight()).append("==").append(options.inSampleSize).toString());
        return bitmap;
        Exception exception;
        exception;
        bitmap = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String encodeTel(String s)
    {
        String s1;
        String s2;
        int j;
        s1 = s.replace("+", "");
        if (s1.startsWith("86"))
        {
            s1 = s1.substring(2, s1.length());
        }
        s2 = "";
        j = 0;
_L2:
        String s3;
        if (j >= s1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        int k = Integer.valueOf((new StringBuilder()).append(s1.charAt(j)).append("").toString()).intValue();
        int l = (int)(3D * Math.random());
        char c1 = d[k].charAt(l);
        s3 = (new StringBuilder()).append(s2).append(c1).toString();
        s2 = s3;
        j++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
_L1:
        return s2;
    }

    public static int getCalendarDay(Calendar calendar)
    {
        return 365 * calendar.get(1) + calendar.get(6);
    }

    public static String getContinueReachGoalShareTips(Context context, ReportData reportdata)
    {
        int j = reportdata.getSteps();
        int k = reportdata.getDistance();
        int l = reportdata.getContinueDays();
        int i1 = reportdata.getRunDistance();
        String s = a(context, k);
        String s1 = (new StringBuilder()).append(j / l).append("").toString();
        String as[] = context.getResources().getStringArray(0x7f070000);
        String s2 = "";
        int j1 = as.length;
        if (j1 >= 0)
        {
            s2 = as[Calendar.getInstance().get(6) % j1];
        }
        String as1[] = ChartData.formatDistance(context, k - i1);
        String s3 = (new StringBuilder()).append(as1[0]).append(as1[1]).toString();
        if (i1 <= 0)
        {
            return context.getString(0x7f0d015e, new Object[] {
                s3, s1, s, s2
            });
        } else
        {
            String as2[] = ChartData.formatDistance(context, i1);
            return context.getString(0x7f0d015f, new Object[] {
                s3, (new StringBuilder()).append(as2[0]).append(as2[1]).toString(), s, s2
            });
        }
    }

    public static String getDateStringFromMillisecond(Context context, String s, String s1)
    {
        if (s == null)
        {
            s = "MM/dd HH:mm";
        }
        if (s1 == null)
        {
            return context.getString(0x7f0d011f);
        }
        SimpleDateFormat simpledateformat;
        Long long2;
        Long long3;
        Date date;
        String s2;
        String s3;
        int j;
        Object aobj[];
        try
        {
            simpledateformat = new SimpleDateFormat(s);
            Long long1 = Long.valueOf(System.currentTimeMillis());
            Long.valueOf(0L);
            if (s1.length() < 13)
            {
                long2 = Long.valueOf(1000L * Long.parseLong(s1));
            } else
            {
                long2 = Long.valueOf(Long.parseLong(s1));
            }
            long3 = Long.valueOf(Long.valueOf(long1.longValue() - long2.longValue()).longValue() / 60000L);
            if (long3.longValue() == 0L)
            {
                return context.getString(0x7f0d011f);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (long3.longValue() > 0L && long3.longValue() < 60L)
        {
            aobj = new Object[1];
            aobj[0] = (new StringBuilder()).append("").append(long3).toString();
            return context.getString(0x7f0d0021, aobj);
        }
        date = new Date(long2.longValue());
        if (long3.longValue() > 60L && long3.longValue() < 1440L)
        {
            s3 = simpledateformat.format(date);
            j = s3.length();
            return (new StringBuilder()).append(context.getString(0x7f0d01b9)).append(" ").append(s3.substring(j - 5, j)).toString();
        }
        s2 = simpledateformat.format(date);
        return s2;
    }

    public static ShareData getDayShareTips(Context context, int j, int k, int l, int i1, ShareData sharedata)
    {
        int j1 = Keeper.readPersonInfo().getDaySportGoalSteps();
        String as[] = ChartData.formatDistance(context, k);
        String s = (new StringBuilder()).append(as[0]).append(as[1]).toString();
        String s1;
        String s2;
        if (l > 0)
        {
            String as1[] = ChartData.formatDistance(context, l);
            Object aobj1[] = new Object[3];
            aobj1[0] = s;
            aobj1[1] = (new StringBuilder()).append(as1[0]).append(as1[1]).toString();
            aobj1[2] = Integer.valueOf(i1);
            s1 = context.getString(0x7f0d016c, aobj1);
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = Integer.valueOf(i1);
            s1 = context.getString(0x7f0d0169, aobj);
        }
        if (j1 > j)
        {
            sharedata.setType(1);
            sharedata.title = context.getString(0x7f0d016f);
            s2 = (new StringBuilder()).append(s1).append(context.getString(0x7f0d0160)).toString();
        } else
        {
            sharedata.setType(0);
            sharedata.title = context.getString(0x7f0d0171);
            s2 = (new StringBuilder()).append(s1).append(context.getString(0x7f0d0161)).toString();
        }
        sharedata.content = (new StringBuilder()).append("").append(j).toString();
        sharedata.description = s2;
        sharedata.contentUnit = context.getString(0x7f0d01c4);
        return sharedata;
    }

    public static void getDayShareTips(Context context, StepsInfo stepsinfo, ShareData sharedata)
    {
        getDayShareTips(context, stepsinfo.getStepsCount(), stepsinfo.getDistance(), stepsinfo.getRunDistance(), stepsinfo.getCalories(), sharedata);
    }

    public static int getFwVersion(byte abyte0[])
    {
        return (0xff & abyte0[1059]) << 24 | (0xff & abyte0[1058]) << 16 | (0xff & abyte0[1057]) << 8 | 0xff & abyte0[1056];
    }

    public static Gson getGson()
    {
        if (b == null)
        {
            b = new Gson();
        }
        return b;
    }

    public static void getMainUIShareTips(Context context, DaySportData daysportdata, ShareData sharedata)
    {
        int j = ChartData.getDynamicData().getCurrentMode();
        if (j != 1) goto _L2; else goto _L1
_L1:
        StepsInfo stepsinfo = daysportdata.getStepsInfo();
        String s4 = ChartData.formatTimeLength(context, stepsinfo.getStepsTimeCount());
        String s5 = "";
        if (stepsinfo.getRunTimeCount() > 0)
        {
            s5 = (new StringBuilder()).append(", ").append(context.getString(0x7f0d0134)).append(ChartData.formatTimeLength(context, stepsinfo.getRunTimeCount())).toString();
        }
        String s6 = context.getString(0x7f0d0160);
        sharedata.setType(1);
        if (stepsinfo.getStepsCount() >= Keeper.readPersonInfo().getDaySportGoalSteps())
        {
            s6 = context.getString(0x7f0d0161);
            sharedata.setType(0);
        }
        sharedata.description = context.getString(0x7f0d00e6, new Object[] {
            s4, s5, s6
        });
_L4:
        return;
_L2:
        if (j != 16) goto _L4; else goto _L3
_L3:
        SleepInfo sleepinfo;
        String s;
        String s1;
        String s2;
        String s3;
        int k;
        sleepinfo = daysportdata.getSleepInfo();
        s = ChartData.formatTime(sleepinfo.getStartDateMin());
        s1 = ChartData.formatTime(sleepinfo.getStopDateMin());
        s2 = ChartData.formatTimeLength(context, sleepinfo.getRemCount());
        Debug.i("Utils", (new StringBuilder()).append("awake num = ").append(sleepinfo.getAwakeNum()).append(", count = ").append(sleepinfo.getAwakeCount()).toString());
        s3 = "";
        k = sleepinfo.getAwakeNum();
        if (k != 1) goto _L6; else goto _L5
_L5:
        s3 = context.getString(0x7f0d001c);
_L8:
        sharedata.description = context.getString(0x7f0d00e7, new Object[] {
            s2, s3, s, s1
        });
        return;
_L6:
        if (k > 1)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(sleepinfo.getAwakeNum());
            s3 = context.getString(0x7f0d001b, aobj);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String getMiuiBuildTimestamp(Context context)
    {
        return getSystemProperties(context, "ro.build.date.utc");
    }

    public static String getMiuiBuildVersion(Context context)
    {
        return getSystemProperties(context, "ro.build.version.incremental");
    }

    public static String getMiuiVersionCode(Context context)
    {
        return getSystemProperties(context, "ro.miui.ui.version.code");
    }

    public static String getMiuiVersionName(Context context)
    {
        return getSystemProperties(context, "ro.miui.ui.version.name");
    }

    public static String getMonthShareTips(Context context, int j, int k, int l, String s, int i1, int j1)
    {
        int k1 = k - j1;
        String as[] = ChartData.formatDistance(context, k1);
        String s1 = (new StringBuilder()).append(as[0]).append(as[1]).toString();
        String s2 = (new DecimalFormat("#.#")).format(1E-04F * (float)k1);
        String s3 = a(context, k1);
        if (j1 > 0)
        {
            String as1[] = ChartData.formatDistance(context, j1);
            String s4 = (new StringBuilder()).append(as1[0]).append(as1[1]).toString();
            Object aobj1[] = new Object[6];
            aobj1[0] = s1;
            aobj1[1] = s4;
            aobj1[2] = s3;
            aobj1[3] = s2;
            aobj1[4] = s;
            aobj1[5] = (new StringBuilder()).append(i1).append("").toString();
            return context.getString(0x7f0d016b, aobj1);
        } else
        {
            Object aobj[] = new Object[6];
            aobj[0] = s1;
            aobj[1] = s3;
            aobj[2] = Integer.valueOf(l);
            aobj[3] = s2;
            aobj[4] = s;
            aobj[5] = (new StringBuilder()).append(i1).append("").toString();
            return context.getString(0x7f0d016a, aobj);
        }
    }

    public static String getPhoneNum(Context context)
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getLine1Number();
        Debug.i("Utils", (new StringBuilder()).append("get tel =").append(s).toString());
        if (s == null)
        {
            s = "";
        }
        return s;
    }

    public static String getPostUrl()
    {
        LoginData logindata = Keeper.readLoginData();
        String s = "";
        if (logindata != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("userid", (new StringBuilder()).append("").append(logindata.uid).toString());
            hashmap.put("security", logindata.security);
            hashmap.put("username", Keeper.readUserName());
            s = BraceletHttpClient.getParamString(hashmap);
        }
        return s;
    }

    public static String getStringFromBytes(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "";
        }
        String s;
        try
        {
            s = new String(abyte0);
        }
        catch (Exception exception)
        {
            Debug.i("chenee", (new StringBuilder()).append("Utils.java getStringFromBytes error:").append(exception.getMessage()).toString());
            return "";
        }
        return s;
    }

    public static String getSyncTime(Context context, int j)
    {
        long l = Keeper.readSyncTime();
        if (!isToday(l))
        {
            return context.getString(0x7f0d0077);
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm");
            Date date = new Date(l);
            Object aobj[] = new Object[1];
            aobj[0] = simpledateformat.format(date);
            return context.getString(j, aobj);
        }
    }

    public static String getSystemProperties(Context context, String s)
    {
        String s1;
        try
        {
            Class class1 = context.getClassLoader().loadClass("android.os.SystemProperties");
            Method method = class1.getMethod("get", new Class[] {
                java/lang/String
            });
            Object aobj[] = new Object[1];
            aobj[0] = new String(s);
            s1 = (String)method.invoke(class1, aobj);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw illegalargumentexception;
        }
        catch (Exception exception)
        {
            return "";
        }
        return s1;
    }

    public static String getWeekShareTips(Context context, int j, int k, String s, int l, int i1)
    {
        int j1 = j - i1;
        String as[] = ChartData.formatDistance(context, j1);
        String s1 = (new StringBuilder()).append(as[0]).append(as[1]).toString();
        String s2 = a(context, j1);
        if (i1 <= 0)
        {
            if (s2 != "" && s2 != null)
            {
                s2 = (new StringBuilder()).append(", ").append(s2).toString();
            }
            Object aobj1[] = new Object[5];
            aobj1[0] = s1;
            aobj1[1] = s2;
            aobj1[2] = Integer.valueOf(k);
            aobj1[3] = s;
            aobj1[4] = (new StringBuilder()).append(l).append("").toString();
            return context.getString(0x7f0d016d, aobj1);
        } else
        {
            String as1[] = ChartData.formatDistance(context, i1);
            String s3 = (new StringBuilder()).append(as1[0]).append(as1[1]).toString();
            Object aobj[] = new Object[5];
            aobj[0] = s1;
            aobj[1] = s3;
            aobj[2] = s2;
            aobj[3] = s;
            aobj[4] = (new StringBuilder()).append(l).append("").toString();
            return context.getString(0x7f0d016e, aobj);
        }
    }

    public static void gotoWeb(String s, String s1, Activity activity)
    {
        Intent intent = new Intent(activity, cn/com/smartdevices/bracelet/activity/WebActivity);
        intent.putExtra("web_type", 2);
        intent.putExtra("web_url", s);
        intent.putExtra("Label", s1);
        activity.startActivity(intent);
    }

    public static void hideProgressDialog(Activity activity)
    {
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        DialogFragment dialogfragment;
        try
        {
            dialogfragment = (DialogFragment)activity.getFragmentManager().findFragmentByTag(cn/com/smartdevices/bracelet/ui/ProgressBarFragment.getName());
        }
        catch (Exception exception)
        {
            return;
        }
        if (dialogfragment == null) goto _L1; else goto _L3
_L3:
        dialogfragment.dismiss();
        return;
    }

    public static boolean isBinded()
    {
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        return braceletbtinfo != null && BluetoothAdapter.checkBluetoothAddress(braceletbtinfo.address);
    }

    public static boolean isBraceletConnected()
    {
        if (cn.com.smartdevices.bracelet.BraceletApp.BLEService == null)
        {
            return false;
        }
        MiLiProfile miliprofile = (MiLiProfile)cn.com.smartdevices.bracelet.BraceletApp.BLEService.getDefaultPeripheral();
        boolean flag;
        if (miliprofile != null && miliprofile.getProfileState() == 1 && miliprofile.getState() == com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE.CONNECTED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static boolean isNetworkConnected(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager.getActiveNetworkInfo() != null)
        {
            return connectivitymanager.getActiveNetworkInfo().isConnected();
        } else
        {
            return false;
        }
    }

    public static boolean isOnceBinded()
    {
        BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
        return braceletbtinfo != null && !TextUtils.isEmpty(braceletbtinfo.address);
    }

    public static boolean isSupportBle(Context context)
    {
        boolean flag = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        Debug.i("Utils", (new StringBuilder()).append("isSupportBle:").append(flag).toString());
        return flag;
    }

    public static boolean isSupportMiuiUnlock(Context context)
    {
        String s = getSystemProperties(context, "sys.keyguard.bleunlock");
        Debug.i("Utils", (new StringBuilder()).append("unlock:").append(s).toString());
        return s != null && s.equals("true");
    }

    public static boolean isSupportUnlockScreenByBracelet(Context context)
    {
        if (isSupportBle(context))
        {
            String s = getSystemProperties(context, "ro.miui.ui.version.name");
            String s1 = getSystemProperties(context, "ro.miui.ui.version.code");
            Debug.i("Utils", (new StringBuilder()).append("isSupportUnlockScreenByBracelet:miui version name=").append(s).append(",miui version code=").append(s1).toString());
            if (s1 != null && s1.length() != 0 && s != null && s.length() != 0 && Integer.valueOf(s1).intValue() >= 3)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isToday(long l)
    {
        Time time = new Time();
        time.set(l);
        int j = time.year;
        int k = time.month;
        int i1 = time.monthDay;
        time.set(System.currentTimeMillis());
        return j == time.year && k == time.month && i1 == time.monthDay;
    }

    public static boolean isTodayReachGoal()
    {
        int j = Keeper.readPersonInfo().getDaySportGoalSteps();
        SportDay sportday = DataManager.getInstance().getCurDay();
        DaySportData daysportdata = DataManager.getInstance().get(sportday);
        return daysportdata.getStepsInfo() != null && daysportdata.getStepsInfo().getStepsCount() >= j;
    }

    public static boolean isUseUnlockByBracelet(Context context)
    {
        int j;
        try
        {
            j = android.provider.Settings.Secure.getInt(context.getContentResolver(), "bluetooth_unlock_status");
        }
        catch (android.provider.Settings.SettingNotFoundException settingnotfoundexception)
        {
            settingnotfoundexception.printStackTrace();
            return false;
        }
        return j == 1;
    }

    public static boolean isViewContains(View view, int j, int k)
    {
        boolean flag = true;
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int l = ai[0];
        int i1 = ai[flag];
        int j1 = view.getWidth();
        int k1 = view.getHeight();
        if (j < l || j > l + j1 || k < i1 || k > i1 + k1)
        {
            flag = false;
        }
        return flag;
    }

    public static boolean isWeixinSupportJump(Context context)
    {
        if (WXAPIFactory.createWXAPI(context, "wx28e2610e92fbe111").isWXAppInstalled())
        {
            int j;
            try
            {
                j = context.getPackageManager().getPackageInfo("com.tencent.mm", 0).versionCode;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                return false;
            }
            if (j >= 480)
            {
                return true;
            }
        }
        return false;
    }

    public static String purgeJson(String s)
    {
        Debug.i("Utils", (new StringBuilder()).append("\n====>         before purge json :").append(s).toString());
        String s1 = s.replace("\"[", "[").replace("]\"", "]").replace("}\"", "}").replace("\"{", "{").replace("\\\"", "\"").replace("\\/", "/");
        Debug.i("Utils", (new StringBuilder()).append("\n====>         after purge json([], {},\\\", \\/) :").append(s1).toString());
        return s1;
    }

    public static void queryDownloadStatus(Activity activity)
    {
        DownloadManager downloadmanager;
        long l;
        Cursor cursor;
        downloadmanager = (DownloadManager)activity.getSystemService("download");
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        l = Keeper.readDownloadApkId();
        query.setFilterById(new long[] {
            l
        });
        cursor = downloadmanager.query(query);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        cursor.getInt(cursor.getColumnIndex("status"));
        JVM INSTR lookupswitch 5: default 120
    //                   1: 129
    //                   2: 137
    //                   4: 121
    //                   8: 146
    //                   16: 234;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return;
_L5:
        Debug.i("Utils", "STATUS_PAUSED");
_L3:
        Debug.i("Utils", "STATUS_PENDING");
_L4:
        Debug.i("Utils", "STATUS_RUNNING");
        return;
_L6:
        Debug.i("Utils", (new StringBuilder()).append("STATUS_SUCCESSFUL download_id=").append(l).toString());
        Uri uri = downloadmanager.getUriForDownloadedFile(l);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.setFlags(0x10000000);
        activity.startActivity(intent);
        CustomToast.makeText(activity, 0x7f0d0016, 1).show();
        Keeper.keepDownloadApkId(-1L);
        return;
_L7:
        Debug.i("Utils", "STATUS_FAILED");
        long al[] = new long[1];
        al[0] = Keeper.readDownloadApkId();
        downloadmanager.remove(al);
        Keeper.keepDownloadApkId(-1L);
        CustomToast.makeText(activity, 0x7f0d006a, 1).show();
        return;
    }

    public static boolean removeBond(Class class1, BluetoothDevice bluetoothdevice)
    {
        boolean flag;
        try
        {
            flag = ((Boolean)class1.getMethod("removeBond", new Class[0]).invoke(bluetoothdevice, new Object[0])).booleanValue();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public static String saveBitmapToFile(Bitmap bitmap)
    {
        return saveBitmapToFile(bitmap, 90);
    }

    public static String saveBitmapToFile(Bitmap bitmap, int j)
    {
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/tmp.jpg").toString();
        saveBitmapToFile(s, bitmap, j);
        return s;
    }

    public static boolean saveBitmapToFile(String s, Bitmap bitmap)
    {
        return saveBitmapToFile(s, bitmap, 90);
    }

    public static boolean saveBitmapToFile(String s, Bitmap bitmap, int j)
    {
        File file;
        file = new File(s);
        if (file.exists())
        {
            file.delete();
        }
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        boolean flag1 = bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, j, fileoutputstream);
        boolean flag;
        flag = flag1;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception2)
            {
                ioexception2.printStackTrace();
                return flag;
            }
        }
_L2:
        return flag;
        Exception exception;
        exception;
        fileoutputstream = null;
_L5:
        exception.printStackTrace();
        flag = false;
        if (fileoutputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            fileoutputstream.close();
        }
        catch (IOException ioexception1)
        {
            ioexception1.printStackTrace();
            return false;
        }
        return false;
        Exception exception1;
        exception1;
        fileoutputstream = null;
_L4:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw exception1;
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
          goto _L5
    }

    public static void sendUserInfo2Mili()
    {
        PersonInfo personinfo = Keeper.readPersonInfo();
        if (!personinfo.isValid())
        {
            Debug.i("Utils", (new StringBuilder()).append("                 sendUserInfo2Mili, Person info InValid =").append(personinfo).append("\n").toString());
        }
        (new BleSetPersonalInfoTask(personinfo, new f())).work();
    }

    public static void setAutoReconnect(boolean flag)
    {
        if (cn.com.smartdevices.bracelet.BraceletApp.BLEService != null)
        {
            MiLiProfile miliprofile = (MiLiProfile)cn.com.smartdevices.bracelet.BraceletApp.BLEService.getDefaultPeripheral();
            if (miliprofile != null)
            {
                Debug.i("Utils", (new StringBuilder()).append("Set auto reconnect :").append(flag).toString());
                miliprofile.setAutoReconnect(flag);
                return;
            }
        }
        Debug.i("Utils", "Set auto reconnect fail");
    }

    public static void showProgressDialog(Activity activity, int j)
    {
        if (activity == null)
        {
            return;
        }
        hideProgressDialog(activity);
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("REF_PROGRESS_INFO", activity.getString(j));
            DimPanelFragment.showPanel(activity, cn/com/smartdevices/bracelet/ui/ProgressBarFragment, bundle);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static void switchBracelet(Context context, int j)
    {
        SwitchOperator switchoperator = new SwitchOperator();
        switchoperator.type = j;
        boolean flag;
        boolean flag1;
        DataManager datamanager;
        DaySportData daysportdata;
        Intent intent;
        if (j == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        switchoperator.enableClearData = flag;
        if (j == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        switchoperator.enableSteps = flag1;
        if (j == 1)
        {
            switchoperator.lastUid = Keeper.readLoginData().uid;
            switchoperator.lastMacAddress = Keeper.readBraceletBtInfo().address;
        }
        switchoperator.date = (new SportDay()).getKey();
        datamanager = DataManager.getInstance();
        daysportdata = datamanager.get(datamanager.getStopDay());
        if (daysportdata != null)
        {
            StepsInfo stepsinfo = daysportdata.getStepsInfo();
            if (stepsinfo != null)
            {
                switchoperator.steps = stepsinfo.getStepsCount();
            }
        }
        Keeper.keepSwitchOperator(switchoperator);
        if (cn.com.smartdevices.bracelet.BraceletApp.BLEService != null)
        {
            MiLiProfile miliprofile = (MiLiProfile)cn.com.smartdevices.bracelet.BraceletApp.BLEService.getDefaultPeripheral();
            if (miliprofile != null)
            {
                miliprofile.setAutoReconnect(false);
                miliprofile.disconnect();
            }
        }
        intent = new Intent();
        intent.setAction("com.xiaomi.hm.health.ACTION_DEVICE_UNBIND_APPLICATION");
        context.sendBroadcast(intent);
    }

    public static void updateAvatarUI(PersonInfo personinfo, ImageView imageview)
    {
        String s = personinfo.avatarPath;
        Bitmap bitmap = null;
        if (s != null)
        {
            boolean flag = personinfo.avatarPath.equals("");
            bitmap = null;
            if (!flag)
            {
                Uri uri = Uri.fromFile(new File(personinfo.avatarPath));
                bitmap = BraceletImageLoader.getInstance().loadImageSync(uri.toString());
                Debug.i("Utils", (new StringBuilder()).append("path=").append(personinfo.avatarPath).append(" avatarBitmap=").append(bitmap).toString());
                if (bitmap != null)
                {
                    imageview.setBackground(new BitmapDrawable(Util.clipToRoundBitmap(bitmap)));
                }
            }
        }
        if (bitmap == null)
        {
            Debug.i("Utils", (new StringBuilder()).append("avatar Url =").append(personinfo.avatarUrl).toString());
            BraceletImageLoader.getInstance().displayRoundImage(personinfo.avatarUrl, imageview);
        }
    }

    public static void updateProfile(PersonInfo personinfo)
    {
        if (!personinfo.isValid())
        {
            Debug.i("Utils", "personInfo is inValid!");
            return;
        } else
        {
            WebAPI.updateProfile(Keeper.readLoginData(), personinfo, new g(personinfo));
            return;
        }
    }

    public static void updateProfile(PersonInfo personinfo, HashMap hashmap, OperationCallback operationcallback)
    {
        WebAPI.updateProfile(Keeper.readLoginData(), hashmap, new e(operationcallback, personinfo));
    }

}
