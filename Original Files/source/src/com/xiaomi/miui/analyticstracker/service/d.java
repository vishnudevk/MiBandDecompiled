// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.util.Log;
import com.xiaomi.miui.analyticstracker.utils.FileUtils;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            b, DispatcherHelper, a

class d
    implements b
{

    final DispatcherHelper a;

    private d(DispatcherHelper dispatcherhelper)
    {
        a = dispatcherhelper;
        super();
    }

    d(DispatcherHelper dispatcherhelper, a a1)
    {
        this(dispatcherhelper);
    }

    public JSONArray a()
    {
        DefaultHttpClient defaulthttpclient;
        String s;
        defaulthttpclient = new DefaultHttpClient();
        s = "";
        File file1 = FileUtils.getFileByName(DispatcherHelper.a(a), "log_config.json", false);
        File file = file1;
_L2:
        if (file == null)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONArray jsonarray1;
        if (!file.exists() || FileUtils.expired(file))
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray1 = new JSONArray(FileUtils.getFileContent(file));
        return jsonarray1;
        IOException ioexception;
        ioexception;
        Log.e("DispatcherHelper", (new StringBuilder()).append("get log config error: ").append(ioexception.getMessage()).toString());
        file = null;
        if (true) goto _L2; else goto _L1
_L1:
        HttpResponse httpresponse;
        StatusLine statusline;
        Object aobj[] = new Object[2];
        aobj[0] = "http://tracking.miui.com/danfa_log_config.json";
        aobj[1] = SysUtils.getAppPackageName(DispatcherHelper.a(a));
        s = String.format("%s?app=%s", aobj);
        httpresponse = defaulthttpclient.execute(new HttpGet(s));
        statusline = httpresponse.getStatusLine();
        if (statusline == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        JSONArray jsonarray;
        if (200 != statusline.getStatusCode())
        {
            break MISSING_BLOCK_LABEL_220;
        }
        String s1 = EntityUtils.toString(httpresponse.getEntity());
        FileUtils.writeFile(file, s1);
        jsonarray = new JSONArray(s1);
        return jsonarray;
        ClientProtocolException clientprotocolexception;
        clientprotocolexception;
        clientprotocolexception.printStackTrace();
_L4:
        return null;
        IOException ioexception1;
        ioexception1;
        ioexception1.printStackTrace();
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        numberformatexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.e("DispatcherHelper", String.format("Error URL Argrment:%s", new Object[] {
            s
        }));
        illegalargumentexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        nullpointerexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        AssertionError assertionerror;
        assertionerror;
        assertionerror.printStackTrace();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Log.e("DispatcherHelper", exception.getMessage());
        exception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }
}
