// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.OpenConfig;
import com.tencent.utils.Util;
import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.tencent.open.a:
//            b, d

class e extends Thread
{

    final String a;
    final Context b;
    final Bundle c;
    final b d;

    e(b b1, String s, Context context, Bundle bundle)
    {
        d = b1;
        a = s;
        b = context;
        c = bundle;
        super();
    }

    public void run()
    {
        boolean flag;
        int j;
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportManager doUploadItems Thread start, url = ").append(a).toString());
        com.tencent.open.a.b.a(d, OpenConfig.getInstance(b, null).getInt("Common_HttpRetryCount"));
        b b1 = d;
        int i;
        HttpClient httpclient;
        HttpPost httppost;
        if (com.tencent.open.a.b.a(d) == 0)
        {
            i = 3;
        } else
        {
            i = com.tencent.open.a.b.a(d);
        }
        com.tencent.open.a.b.a(b1, i);
        flag = false;
        j = 0;
_L4:
        j++;
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportManager doUploadItems Thread request count = ").append(j).toString());
        httpclient = HttpUtils.getHttpClient(b, null, a);
        httppost = new HttpPost(a);
        httppost.addHeader("Accept-Encoding", "gzip");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httppost.setEntity(new ByteArrayEntity(Util.encodeUrl(c).getBytes()));
        if (httpclient.execute(httppost).getStatusLine().getStatusCode() == 200) goto _L2; else goto _L1
_L1:
        Log.e("cgi_report_debug", "ReportManager doUploadItems : HttpStatuscode != 200");
_L3:
        Exception exception;
        SocketTimeoutException sockettimeoutexception;
        ConnectTimeoutException connecttimeoutexception;
        com.tencent.open.a.b.a(d, false);
        Log.i("cgi_report_debug", (new StringBuilder()).append("ReportManager doUploadItems Thread end, url = ").append(a).toString());
        if (flag)
        {
            Log.i("cgi_report_debug", "ReportManager doUploadItems Thread request success");
            return;
        } else
        {
            Log.e("cgi_report_debug", "ReportManager doUploadItems Thread request failed");
            com.tencent.open.a.b.c(d).a(com.tencent.open.a.b.b(d));
            return;
        }
_L2:
        Log.i("cgi_report_debug", "ReportManager doUploadItems Thread success");
        flag = true;
          goto _L3
        connecttimeoutexception;
_L8:
        connecttimeoutexception.printStackTrace();
        Log.e("cgi_report_debug", "ReportManager doUploadItems : ConnectTimeoutException");
_L5:
        if (j < com.tencent.open.a.b.a(d)) goto _L4; else goto _L3
        sockettimeoutexception;
_L7:
        sockettimeoutexception.printStackTrace();
          goto _L5
        exception;
_L6:
        exception.printStackTrace();
        Log.e("cgi_report_debug", "ReportManager doUploadItems : Exception");
          goto _L3
        Exception exception1;
        exception1;
        exception = exception1;
        flag = true;
          goto _L6
        SocketTimeoutException sockettimeoutexception1;
        sockettimeoutexception1;
        sockettimeoutexception = sockettimeoutexception1;
        flag = true;
          goto _L7
        ConnectTimeoutException connecttimeoutexception1;
        connecttimeoutexception1;
        connecttimeoutexception = connecttimeoutexception1;
        flag = true;
          goto _L8
    }
}
