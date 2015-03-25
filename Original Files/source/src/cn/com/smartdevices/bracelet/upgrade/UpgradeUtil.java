// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package cn.com.smartdevices.bracelet.upgrade:
//            NewVersionInfo, WebServiceClient, OtaVersionInfo

public final class UpgradeUtil
{

    public static final String IS_NEED_CHECK = "NeedCheck";
    public static final String IS_NEED_UPLOAD_CONTACTS = "NeedUploadContacts";
    public static final String KEY_CHANGE_LOG = "ChangeLog";
    public static final String KEY_DOWN_URL = "DownUrl";
    public static final String KEY_NEW_VERSION = "NewVersion";
    public static final int MSG_GET_OTA_VERSION_FINISHED = 265;
    public static final int MSG_GET_WATCH_INFO_FINISHED = 264;
    public static final int MSG_UPDATE = 263;
    private static final boolean a;

    private UpgradeUtil()
    {
    }

    public static boolean checkState(Context context, String s, int i)
    {
        String s1 = PreferenceManager.getDefaultSharedPreferences(context).getString(s, "0");
        Date date = new Date();
        String s2 = (new SimpleDateFormat("yyyyMMdd")).format(date);
        int j;
        int k;
        int l;
        boolean flag;
        try
        {
            j = Integer.parseInt(s2);
            k = Integer.parseInt(s1);
        }
        catch (NumberFormatException numberformatexception)
        {
            return false;
        }
        l = j - k;
        flag = false;
        if (l > i)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean checkStateExist(Context context, String s, int i)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(s, "0").compareTo("0") != 0;
    }

    public static boolean downloadApkFile(Context context, String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            performDownload(context, s);
            return true;
        }
    }

    public static int getApkVersionCode(Context context, String s)
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(s, 1);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return 0;
        }
        if (packageinfo == null)
        {
            return 0;
        } else
        {
            return packageinfo.versionCode;
        }
    }

    public static NewVersionInfo getNetVersionInfo(Context context, String s)
    {
        NewVersionInfo newversioninfo;
        InputStream inputstream;
        Element element;
        newversioninfo = new NewVersionInfo();
        WebServiceClient webserviceclient = WebServiceClient.getInstance(context);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("q", "checkupdate"));
        inputstream = webserviceclient.post(s, arraylist);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        element = (new WebServiceClient.DomXMLHandler()).parseXml(inputstream);
        inputstream.close();
_L5:
        if (element == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        String s1 = element.getElementsByTagName("version_code").item(0).getFirstChild().getNodeValue();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        int i = Integer.parseInt(s1);
_L6:
        String s2 = "";
        NodeList nodelist = element.getElementsByTagName("change_log").item(0).getChildNodes();
        int j = 0;
        if (nodelist == null) goto _L4; else goto _L3
_L3:
        String s3;
        if (j >= nodelist.getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = (new StringBuilder()).append(s2).append(nodelist.item(j).getNodeValue()).toString();
        j++;
        s2 = s3;
        if (true) goto _L3; else goto _L4
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L4:
        try
        {
            newversioninfo.setChangeLog(s2);
            newversioninfo.setFileUrl(element.getElementsByTagName("file_url").item(0).getFirstChild().getNodeValue());
            newversioninfo.setMd5(element.getElementsByTagName("md5").item(0).getFirstChild().getNodeValue());
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            i = -1;
        }
_L7:
        newversioninfo.setVersionCode(i);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("NewVersion", i).commit();
        return newversioninfo;
_L2:
        i = -1;
          goto _L6
        i = -1;
          goto _L7
    }

    public static String getOtaUrl()
    {
        return "http://ota.app-xae.xiaomi.com/ota_testhm.php";
    }

    public static OtaVersionInfo getOtaVersionInfo(Context context, String s)
    {
        OtaVersionInfo otaversioninfo;
        InputStream inputstream;
        otaversioninfo = new OtaVersionInfo();
        WebServiceClient webserviceclient = WebServiceClient.getInstance(context);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("devtype", "bracelet"));
        arraylist.add(new BasicNameValuePair("devversion", ""));
        arraylist.add(new BasicNameValuePair("softversion", (new StringBuilder()).append("").append(getApkVersionCode(context, context.getPackageName())).toString()));
        arraylist.add(new BasicNameValuePair("softtype", ""));
        arraylist.add(new BasicNameValuePair("timestamp", (new StringBuilder()).append("").append(System.currentTimeMillis()).toString()));
        inputstream = webserviceclient.get(s, arraylist);
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        Element element = (new WebServiceClient.DomXMLHandler()).parseXml(inputstream);
        inputstream.close();
_L5:
        if (element == null) goto _L2; else goto _L3
_L3:
        Exception exception;
        IOException ioexception;
        String s1;
        String s2;
        try
        {
            otaversioninfo.firmwareUrl = element.getElementsByTagName("url").item(0).getFirstChild().getNodeValue();
            s1 = element.getElementsByTagName("versioncode").item(0).getFirstChild().getNodeValue();
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            return otaversioninfo;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        otaversioninfo.firmwareVersionCode = Float.valueOf(s1).floatValue();
        otaversioninfo.firmwareVersion = element.getElementsByTagName("version").item(0).getFirstChild().getNodeValue();
        otaversioninfo.firmwareInfo = element.getElementsByTagName("verinfo").item(0).getFirstChild().getNodeValue();
        s2 = element.getElementsByTagName("size").item(0).getFirstChild().getNodeValue();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        otaversioninfo.firmwareSize = Integer.valueOf(s2).intValue();
        otaversioninfo.firmwareMd5 = element.getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
_L2:
        return otaversioninfo;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L5; else goto _L4
_L4:
        exception;
        throw exception;
    }

    public static String getUpgradeURL()
    {
        return "http://ota.app-xae.xiaomi.com/soft_testhm.php";
    }

    public static boolean isNeedCheck(Context context)
    {
        String s = PreferenceManager.getDefaultSharedPreferences(context).getString("NeedCheck", "0");
        Date date = new Date();
        return (new SimpleDateFormat("yyyyMMdd")).format(date).compareTo(s) > 0;
    }

    public static void performDownload(Context context, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.setFlags(0x10000000);
        context.startActivity(intent);
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    public static void updateCheckState(Context context)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Date date = new Date();
        String s = (new SimpleDateFormat("yyyyMMdd")).format(date);
        sharedpreferences.edit().putString("NeedCheck", s).commit();
    }

    public static void updateState(Context context, String s)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Date date = new Date();
        String s1 = (new SimpleDateFormat("yyyyMMdd")).format(date);
        sharedpreferences.edit().putString(s, s1).commit();
    }
}
