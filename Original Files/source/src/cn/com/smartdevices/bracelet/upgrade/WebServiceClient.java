// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

// Referenced classes of package cn.com.smartdevices.bracelet.upgrade:
//            UpgradeUtil

public class WebServiceClient
{

    public static final String URL_OTA = "http://ota.app-xae.xiaomi.com/ota_testhm.php";
    public static final String URL_SMARTDEVICES_WEB_SERVICE = "http://ota.app-xae.xiaomi.com/soft_testhm.php";
    public static final String URL_UPGRADE_TEST = "http://10.12.5.10/tmp/";
    private static final int a = 60000;
    private static final int b = 60000;
    private static final String c = "1.0";
    private static final String d = "ch";
    private static final String e = "en";
    private static WebServiceClient f;
    private HttpClient g;
    private Context h;

    private WebServiceClient(Context context)
    {
        g = new DefaultHttpClient();
        HttpParams httpparams = g.getParams();
        httpparams.setIntParameter("http.socket.timeout", 60000);
        httpparams.setIntParameter("http.connection.timeout", 60000);
        h = context;
    }

    private String a(String s, ArrayList arraylist)
    {
        Iterator iterator = arraylist.iterator();
        int i = 0;
        while (iterator.hasNext()) 
        {
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            String s1;
            if (i == 0)
            {
                s1 = "?";
            } else
            {
                s1 = "&";
            }
            s = stringbuilder.append(s1).append(namevaluepair.getName()).append("=").append(namevaluepair.getValue()).toString();
            i++;
        }
        return s;
    }

    private ArrayList a()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        String s9;
        if (true)
        {
            TelephonyManager telephonymanager = (TelephonyManager)h.getSystemService("phone");
            String s1;
            String s2;
            String s3;
            String s4;
            String s5;
            String s6;
            DisplayMetrics displaymetrics;
            Display display;
            String s7;
            String s8;
            if (telephonymanager != null)
            {
                String s10 = (new StringBuilder()).append("").append(telephonymanager.getDeviceId()).toString();
                String s11 = (new StringBuilder()).append("").append(telephonymanager.getSimSerialNumber()).toString();
                String s12 = (new StringBuilder()).append("").append(((WifiManager)h.getSystemService("wifi")).getConnectionInfo().getMacAddress()).toString();
                String s13 = (new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(h.getContentResolver(), "android_id")).toString();
                s = (new UUID((long)s12.hashCode() << 32 | (long)s13.hashCode(), (long)s10.hashCode() << 32 | (long)s11.hashCode())).toString();
            } else
            {
                s = "null";
            }
        } else
        {
            s = null;
        }
        s1 = android.os.Build.VERSION.RELEASE;
        s2 = (new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString();
        s3 = Build.MODEL;
        s4 = h.getPackageName();
        s5 = h.getString(0x7f0d001a);
        s6 = (new StringBuilder()).append("").append(UpgradeUtil.getApkVersionCode(h, h.getPackageName())).toString();
        displaymetrics = new DisplayMetrics();
        display = ((Activity)h).getWindowManager().getDefaultDisplay();
        display.getMetrics(displaymetrics);
        s7 = (new StringBuilder()).append("").append(display.getWidth()).toString();
        s8 = (new StringBuilder()).append("").append(display.getHeight()).toString();
        if (((Activity)h).getResources().getConfiguration().locale.getLanguage().equals(Locale.CHINESE.toString()))
        {
            s9 = "ch";
        } else
        {
            s9 = "en";
        }
        arraylist.add(new BasicNameValuePair("devicecode", s));
        arraylist.add(new BasicNameValuePair("os", s1));
        arraylist.add(new BasicNameValuePair("osversion", s2));
        arraylist.add(new BasicNameValuePair("devicetype", s3));
        arraylist.add(new BasicNameValuePair("package", s4));
        arraylist.add(new BasicNameValuePair("software", s5));
        arraylist.add(new BasicNameValuePair("softv", s6));
        arraylist.add(new BasicNameValuePair("channel", "HHCN"));
        arraylist.add(new BasicNameValuePair("ie", "UTF-8"));
        arraylist.add(new BasicNameValuePair("w", s7));
        arraylist.add(new BasicNameValuePair("h", s8));
        arraylist.add(new BasicNameValuePair("v", "1.0"));
        arraylist.add(new BasicNameValuePair("l", s9));
        return arraylist;
    }

    public static WebServiceClient getInstance(Context context)
    {
        if (f == null)
        {
            f = new WebServiceClient(context);
        }
        return f;
    }

    public InputStream get(String s, ArrayList arraylist)
    {
        HttpResponse httpresponse;
        int i;
        InputStream inputstream;
        InputStream inputstream1;
        try
        {
            HttpGet httpget = new HttpGet(a(s, arraylist));
            httpresponse = g.execute(httpget);
            i = httpresponse.getStatusLine().getStatusCode();
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            clientprotocolexception.printStackTrace();
            return null;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        inputstream = null;
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        inputstream1 = httpresponse.getEntity().getContent();
        inputstream = inputstream1;
        return inputstream;
    }

    public InputStream post(String s, ArrayList arraylist)
    {
        HttpPost httppost = new HttpPost(s);
        ArrayList arraylist1;
        HttpResponse httpresponse;
        int i;
        InputStream inputstream;
        InputStream inputstream1;
        try
        {
            arraylist1 = a();
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            clientprotocolexception.printStackTrace();
            return null;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        arraylist1.addAll(arraylist);
        httppost.setEntity(new UrlEncodedFormEntity(arraylist1, "UTF-8"));
        httpresponse = g.execute(httppost);
        i = httpresponse.getStatusLine().getStatusCode();
        inputstream = null;
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        inputstream1 = httpresponse.getEntity().getContent();
        inputstream = inputstream1;
        return inputstream;
    }
}
