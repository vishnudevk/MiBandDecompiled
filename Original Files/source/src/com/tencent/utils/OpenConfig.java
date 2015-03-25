// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.utils:
//            d

public class OpenConfig
{

    private static HashMap a = null;
    private static String b = null;
    private Context c;
    private String d;
    private JSONObject e;
    private long f;
    private int g;
    private boolean h;

    private OpenConfig(Context context, String s)
    {
        c = null;
        d = null;
        e = null;
        f = 0L;
        g = 0;
        h = true;
        c = context;
        d = s;
        a();
        b();
    }

    static int a(OpenConfig openconfig, int i)
    {
        openconfig.g = i;
        return i;
    }

    static Context a(OpenConfig openconfig)
    {
        return openconfig.c;
    }

    private String a(String s)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        String s3 = (new StringBuilder()).append(s).append(".").append(d).toString();
_L6:
        java.io.FileInputStream fileinputstream = c.openFileInput(s3);
        Object obj = fileinputstream;
_L7:
        BufferedReader bufferedreader;
        StringBuffer stringbuffer;
        bufferedreader = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
        stringbuffer = new StringBuffer();
_L5:
        String s1 = bufferedreader.readLine();
        if (s1 == null) goto _L4; else goto _L3
_L3:
        stringbuffer.append(s1);
          goto _L5
        IOException ioexception2;
        ioexception2;
        ioexception2.printStackTrace();
        FileNotFoundException filenotfoundexception;
        IOException ioexception;
        InputStream inputstream;
        String s2;
        IOException ioexception4;
        try
        {
            ((InputStream) (obj)).close();
            bufferedreader.close();
        }
        catch (IOException ioexception3)
        {
            ioexception3.printStackTrace();
            return "";
        }
        return "";
_L2:
        s3 = s;
          goto _L6
        filenotfoundexception;
        try
        {
            inputstream = c.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return "";
        }
        obj = inputstream;
          goto _L7
_L4:
        s2 = stringbuffer.toString();
        try
        {
            ((InputStream) (obj)).close();
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception4)
        {
            ioexception4.printStackTrace();
            return s2;
        }
        return s2;
        Exception exception;
        exception;
        try
        {
            ((InputStream) (obj)).close();
            bufferedreader.close();
        }
        catch (IOException ioexception1)
        {
            ioexception1.printStackTrace();
        }
        throw exception;
          goto _L6
    }

    private void a()
    {
        String s = a("com.tencent.open.config.json");
        try
        {
            e = new JSONObject(s);
            return;
        }
        catch (JSONException jsonexception)
        {
            e = new JSONObject();
        }
    }

    static void a(OpenConfig openconfig, JSONObject jsonobject)
    {
        openconfig.a(jsonobject);
    }

    private void a(String s, String s1)
    {
        try
        {
            if (d != null)
            {
                s = (new StringBuilder()).append(s).append(".").append(d).toString();
            }
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(c.openFileOutput(s, 0));
            outputstreamwriter.write(s1);
            outputstreamwriter.flush();
            outputstreamwriter.close();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void a(JSONObject jsonobject)
    {
        b("cgi back, do update");
        e = jsonobject;
        a("com.tencent.open.config.json", jsonobject.toString());
        f = SystemClock.elapsedRealtime();
    }

    private void b()
    {
        if (g != 0)
        {
            b("update thread is running, return");
            return;
        } else
        {
            g = 1;
            Bundle bundle = new Bundle();
            bundle.putString("appid", d);
            bundle.putString("appid_for_getting_config", d);
            bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
            bundle.putString("status_machine", Build.MODEL);
            bundle.putString("status_version", android.os.Build.VERSION.SDK);
            bundle.putString("sdkv", "2.1");
            bundle.putString("sdkp", "a");
            (new d(this, bundle)).start();
            return;
        }
    }

    private void b(String s)
    {
        if (h)
        {
            Log.i("OpenConfig", (new StringBuilder()).append(s).append("; appid: ").append(d).toString());
        }
    }

    private void c()
    {
        int i = e.optInt("Common_frequency");
        if (i == 0)
        {
            i = 1;
        }
        long l = i * 0x36ee80;
        if (SystemClock.elapsedRealtime() - f >= l)
        {
            b();
        }
    }

    public static OpenConfig getInstance(Context context, String s)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        if (s != null)
        {
            b = s;
        }
        OpenConfig openconfig;
        if (s == null)
        {
            if (b != null)
            {
                s = b;
            } else
            {
                s = "0";
            }
        }
        openconfig = (OpenConfig)a.get(s);
        if (openconfig == null)
        {
            openconfig = new OpenConfig(context, s);
            a.put(s, openconfig);
        }
        return openconfig;
    }

    public Object get(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.opt(s);
    }

    public boolean getBoolean(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        Object obj = e.opt(s);
        if (obj != null)
        {
            if (obj instanceof Integer)
            {
                boolean flag;
                if (!obj.equals(Integer.valueOf(0)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
            if (obj instanceof Boolean)
            {
                return ((Boolean)obj).booleanValue();
            }
        }
        return false;
    }

    public double getDouble(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.optDouble(s, 0.0D);
    }

    public int getInt(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.optInt(s);
    }

    public long getLong(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.optLong(s);
    }

    public String getString(String s)
    {
        b((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.optString(s);
    }

}
