// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            s, n, m, w, 
//            c, q, r

class o
    implements Runnable
{

    final n a;

    o(n n1)
    {
        a = n1;
        super();
    }

    public void run()
    {
        if (!s.a(true))
        {
            Toast.makeText(m.a(n.a(a)), s.a(m.a(n.a(a)).getPackageName(), "string", "xiaomi_external_storage_unavailable"), 0).show();
        } else
        if (m.b(n.a(a)) != null)
        {
            String s1;
            Uri uri;
            File file;
            Uri uri1;
            android.app.DownloadManager.Request request;
            ContentValues contentvalues;
            if (TextUtils.isEmpty(m.c(n.a(a)).i))
            {
                s1 = c.c(m.c(n.a(a)).a, m.c(n.a(a)).f);
            } else
            {
                s1 = c.c(m.c(n.a(a)).a, m.c(n.a(a)).i);
            }
            uri = Uri.parse(s1);
            file = new File((new StringBuilder(String.valueOf(m.a(n.a(a)).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()))).append("/updates").toString());
            if (file != null && !file.exists())
            {
                file.mkdirs();
            }
            m.a(n.a(a), new File((new StringBuilder(String.valueOf(file.getAbsolutePath()))).append("/").append(m.d(n.a(a)).packageName).append(m.c(n.a(a)).d).toString()));
            if (m.e(n.a(a)).exists())
            {
                m.e(n.a(a)).delete();
            }
            uri1 = Uri.parse((new StringBuilder("file://")).append(m.e(n.a(a)).getAbsolutePath()).toString());
            request = new android.app.DownloadManager.Request(uri);
            request.setMimeType("application/apk-ota");
            request.setTitle(m.d(n.a(a)).aU);
            request.setDestinationUri(uri1);
            m.a(n.a(a), m.b(n.a(a)).enqueue(request));
            contentvalues = new ContentValues();
            contentvalues.put("package_name", m.d(n.a(a)).packageName);
            contentvalues.put("download_id", Long.valueOf(m.f(n.a(a))));
            contentvalues.put("version_code", Integer.valueOf(m.c(n.a(a)).d));
            contentvalues.put("apk_url", m.c(n.a(a)).f);
            contentvalues.put("apk_hash", m.c(n.a(a)).g);
            contentvalues.put("diff_url", m.c(n.a(a)).i);
            contentvalues.put("diff_hash", m.c(n.a(a)).j);
            contentvalues.put("apk_path", m.e(n.a(a)).getAbsolutePath());
            r.j(m.a(n.a(a))).a(contentvalues);
            return;
        }
    }
}
