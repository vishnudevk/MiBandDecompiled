// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.util.Base64;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.utils.SaltGenerate;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class XiaomiServer
{

    private static final String a = "http://tracking.miui.com/tracks";
    private static final String b = "XIAOMI_SERVER";
    private static final String c = "_app_package_";
    private static final String d = "miui-track_danfa_";
    private static final String e = "t";
    private static final String f = "value";
    private static final String g = "s";
    private static XiaomiServer h;
    private static Object i = new Object();
    private HttpPost j;
    private HttpClient k;

    private XiaomiServer()
    {
    }

    public static XiaomiServer getInstance()
    {
        if (h == null)
        {
            synchronized (i)
            {
                if (h == null)
                {
                    h = new XiaomiServer();
                }
            }
        }
        return h;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void close()
    {
        j = null;
        k = null;
    }

    public void init()
    {
        k = new DefaultHttpClient();
        j = new HttpPost("http://tracking.miui.com/tracks");
    }

    public boolean send(Map map)
    {
        boolean flag;
        JSONObject jsonobject;
        LinkedList linkedlist;
        HttpClient httpclient = k;
        flag = false;
        if (httpclient == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        HttpPost httppost = j;
        flag = false;
        if (httppost == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        flag = false;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        jsonobject = new JSONObject(map);
        String s = new String(Base64.encodeToString(jsonobject.toString().getBytes(), 2));
        linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("t", (new StringBuilder()).append("miui-track_danfa_").append(jsonobject.optString("_app_package_", "null")).toString()));
        linkedlist.add(new BasicNameValuePair("value", s));
        linkedlist.add(new BasicNameValuePair("s", SaltGenerate.getKeyFromParams(linkedlist)));
        HttpResponse httpresponse;
        int l;
        j.setEntity(new UrlEncodedFormEntity(linkedlist, "UTF-8"));
        httpresponse = k.execute(j);
        l = httpresponse.getStatusLine().getStatusCode();
        flag = false;
        if (200 != l)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        String s1;
        s1 = (new JSONObject(EntityUtils.toString(httpresponse.getEntity()))).getString("status");
        if (!s1.equals("ok"))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        flag = true;
        Log.i("XIAOMI_SERVER", (new StringBuilder()).append(jsonobject.optString("_app_package_", "null")).append(" sent OK.").toString());
        return flag;
        Log.i("XIAOMI_SERVER", s1);
        return false;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        return flag;
        ClientProtocolException clientprotocolexception;
        clientprotocolexception;
        clientprotocolexception.printStackTrace();
        return flag;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return flag;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return flag;
        Exception exception;
        exception;
        exception.printStackTrace();
        return flag;
    }

}
