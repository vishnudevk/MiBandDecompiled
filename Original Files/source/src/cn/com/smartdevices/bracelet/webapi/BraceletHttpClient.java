// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package cn.com.smartdevices.bracelet.webapi:
//            ClientConstant, ClientUtil

public class BraceletHttpClient
{

    public static AsyncHttpClient client;
    public static SyncHttpClient syncClient;

    public BraceletHttpClient()
    {
    }

    private static String a(String s, String s1)
    {
        return (new StringBuilder()).append("https://hm.xiaomi.com/").append(s).append(s1).toString();
    }

    public static String getParamString(HashMap hashmap)
    {
        Iterator iterator = hashmap.entrySet().iterator();
        String s;
        String s3;
        for (s = "?"; iterator.hasNext(); s = s3)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s1 = (new StringBuilder()).append(s).append((String)entry.getKey()).toString();
            String s2 = (new StringBuilder()).append(s1).append("=").toString();
            s3 = (new StringBuilder()).append(s2).append((String)entry.getValue()).toString();
            if (iterator.hasNext())
            {
                s3 = (new StringBuilder()).append(s3).append("&").toString();
            }
        }

        return s;
    }

    public static HashMap getSysHm(LoginData logindata)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("userid", (new StringBuilder()).append("").append(logindata.uid).toString());
        hashmap.put("security", logindata.security);
        hashmap.put("v", "1.0");
        hashmap.put("appid", (new StringBuilder()).append("").append(ClientConstant.CLIENT_ID).toString());
        hashmap.put("callid", (new StringBuilder()).append("").append(System.currentTimeMillis()).toString());
        hashmap.put("lang", Locale.getDefault().getLanguage());
        return hashmap;
    }

    public static RequestParams getSysRp(LoginData logindata)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.put("userid", (new StringBuilder()).append("").append(logindata.uid).toString());
        requestparams.put("security", logindata.security);
        requestparams.put("v", "1.0");
        requestparams.put("appid", (new StringBuilder()).append("").append(ClientConstant.CLIENT_ID).toString());
        requestparams.put("callid", (new StringBuilder()).append("").append(System.currentTimeMillis()).toString());
        requestparams.put("lang", Locale.getDefault().getLanguage());
        return requestparams;
    }

    public static String getUrl(String s)
    {
        String s1 = (new StringBuilder()).append("https://hm.xiaomi.com/").append(s).toString();
        Debug.i("URL", s1);
        return s1;
    }

    public static String getUrl(String s, HashMap hashmap)
    {
        return a(s, getParamString(ClientUtil.getParamMap(hashmap)));
    }

    public static String getUrlNoHttps(String s)
    {
        String s1 = (new StringBuilder()).append("http://hm.xiaomi.com/").append(s).toString();
        Debug.i("URL", s1);
        return s1;
    }

    public static String postUrl(String s, HashMap hashmap)
    {
        return a(s, getParamString(ClientUtil.getSysParamMap(hashmap)));
    }

    static 
    {
        client = new AsyncHttpClient();
        syncClient = new SyncHttpClient();
        client.setTimeout(20000);
        syncClient.setTimeout(20000);
    }
}
