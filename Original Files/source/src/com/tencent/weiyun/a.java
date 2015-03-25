// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.File;

// Referenced classes of package com.tencent.weiyun:
//            b, c, d, WeiyunFile, 
//            IDownLoadFileCallBack, FileManager

class a
{

    private static final String b = "https://graph.qq.com/weiyun/download_photo";
    private static final String c = "https://graph.qq.com/weiyun/get_photo_thumb";
    private static final String d = "https://graph.qq.com/weiyun/download_music";
    private static final String e = "https://graph.qq.com/weiyun/download_video";
    private static final String f = "dl_encrypt_url";
    private static final String g = "dl_cookie_name";
    private static final String h = "dl_cookie_value";
    private static final String i = "dl_svr_host";
    private static final String j = "dl_svr_port";
    private static final String k = "dl_thumb_size";
    private static final int l = 10;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private int A;
    private String B;
    private String C;
    final FileManager a;
    private Context p;
    private FileManager.WeiyunFileType q;
    private WeiyunFile r;
    private String s;
    private IDownLoadFileCallBack t;
    private Handler u;
    private File v;
    private String w;
    private String x;
    private String y;
    private String z;

    public a(FileManager filemanager, Context context, FileManager.WeiyunFileType weiyunfiletype, WeiyunFile weiyunfile, String s1, IDownLoadFileCallBack idownloadfilecallback)
    {
        a = filemanager;
        super();
        p = context;
        q = weiyunfiletype;
        r = weiyunfile;
        s = s1;
        t = idownloadfilecallback;
        u = new b(this, p.getMainLooper(), filemanager);
    }

    static int a(a a1, int i1)
    {
        a1.A = i1;
        return i1;
    }

    static IDownLoadFileCallBack a(a a1)
    {
        return a1.t;
    }

    private String a(FileManager.WeiyunFileType weiyunfiletype)
    {
        if (weiyunfiletype == FileManager.WeiyunFileType.ImageFile)
        {
            if (C != null)
            {
                return "https://graph.qq.com/weiyun/get_photo_thumb";
            } else
            {
                return "https://graph.qq.com/weiyun/download_photo";
            }
        }
        if (weiyunfiletype == FileManager.WeiyunFileType.MusicFile)
        {
            return "https://graph.qq.com/weiyun/download_music";
        }
        if (weiyunfiletype == FileManager.WeiyunFileType.VideoFile)
        {
            return "https://graph.qq.com/weiyun/download_video";
        } else
        {
            return "https://graph.qq.com/weiyun/download_photo";
        }
    }

    static String a(a a1, FileManager.WeiyunFileType weiyunfiletype)
    {
        return a1.a(weiyunfiletype);
    }

    static String a(a a1, String s1)
    {
        a1.w = s1;
        return s1;
    }

    static String b(a a1, String s1)
    {
        a1.x = s1;
        return s1;
    }

    private void b()
    {
        (new c(this)).start();
    }

    static void b(a a1)
    {
        a1.c();
    }

    static String c(a a1)
    {
        return a1.s;
    }

    static String c(a a1, String s1)
    {
        a1.y = s1;
        return s1;
    }

    private void c()
    {
        (new d(this)).start();
    }

    static WeiyunFile d(a a1)
    {
        return a1.r;
    }

    static String d(a a1, String s1)
    {
        a1.z = s1;
        return s1;
    }

    static String e(a a1)
    {
        return a1.C;
    }

    static String e(a a1, String s1)
    {
        a1.B = s1;
        return s1;
    }

    static Context f(a a1)
    {
        return a1.p;
    }

    static FileManager.WeiyunFileType g(a a1)
    {
        return a1.q;
    }

    static Handler h(a a1)
    {
        return a1.u;
    }

    static String i(a a1)
    {
        return a1.z;
    }

    static int j(a a1)
    {
        return a1.A;
    }

    static String k(a a1)
    {
        return a1.w;
    }

    static String l(a a1)
    {
        return a1.B;
    }

    static String m(a a1)
    {
        return a1.x;
    }

    static String n(a a1)
    {
        return a1.y;
    }

    public void a()
    {
        if (s == null || q == null || r == null || r.getFileId() == null)
        {
            Message message = u.obtainMessage();
            message.what = -5;
            message.obj = new String("");
            u.sendMessage(message);
            return;
        }
        v = new File(s);
        if (v.exists())
        {
            Message message1 = u.obtainMessage();
            message1.what = -11;
            message1.obj = new String("");
            u.sendMessage(message1);
            return;
        } else
        {
            t.onPrepareStart();
            b();
            return;
        }
    }

    public void a(String s1)
    {
        C = s1;
    }
}
