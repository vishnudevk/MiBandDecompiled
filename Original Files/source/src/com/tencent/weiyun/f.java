// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.utils.DataConvert;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.tencent.weiyun:
//            g, h, i, IUploadFileCallBack, 
//            FileManager

class f
{

    private static final String b = "https://graph.qq.com/weiyun/upload_photo";
    private static final String c = "https://graph.qq.com/weiyun/upload_music";
    private static final String d = "https://graph.qq.com/weiyun/upload_video";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    final FileManager a;
    private final Context h;
    private final FileManager.WeiyunFileType i;
    private final String j;
    private final IUploadFileCallBack k;
    private final Handler l;
    private long m;
    private String n;
    private String o;
    private byte p[];
    private String q;

    public f(FileManager filemanager, Context context, FileManager.WeiyunFileType weiyunfiletype, String s, IUploadFileCallBack iuploadfilecallback)
    {
        a = filemanager;
        super();
        h = context;
        i = weiyunfiletype;
        j = s;
        k = iuploadfilecallback;
        l = new g(this, h.getMainLooper(), filemanager);
    }

    static IUploadFileCallBack a(f f1)
    {
        return f1.k;
    }

    private String a(FileManager.WeiyunFileType weiyunfiletype)
    {
        if (weiyunfiletype == FileManager.WeiyunFileType.ImageFile)
        {
            return "https://graph.qq.com/weiyun/upload_photo";
        }
        if (weiyunfiletype == FileManager.WeiyunFileType.MusicFile)
        {
            return "https://graph.qq.com/weiyun/upload_music";
        } else
        {
            return "https://graph.qq.com/weiyun/upload_video";
        }
    }

    static String a(f f1, FileManager.WeiyunFileType weiyunfiletype)
    {
        return f1.a(weiyunfiletype);
    }

    static String a(f f1, String s)
    {
        f1.q = s;
        return s;
    }

    static byte[] a(f f1, byte abyte0[])
    {
        f1.p = abyte0;
        return abyte0;
    }

    static byte[] a(f f1, byte abyte0[], int i1, int j1)
    {
        return f1.a(abyte0, i1, j1);
    }

    private byte[] a(byte abyte0[], int i1, int j1)
    {
        int k1;
        byte abyte1[];
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0, 0, i1);
            o = DataConvert.toHexString(messagedigest.digest());
            messagedigest.reset();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Message message = l.obtainMessage();
            message.what = -2;
            message.obj = nosuchalgorithmexception.getMessage();
            l.sendMessage(message);
            return null;
        }
        k1 = i1 + 340;
        abyte1 = new byte[4 + (4 + (4 + (k1 + 4)))];
        l1 = 0 + DataConvert.putInt2Bytes(0xabcd9876, abyte1, 0);
        i2 = l1 + DataConvert.putInt2Bytes(1000, abyte1, l1);
        j2 = i2 + DataConvert.putInt2Bytes(0, abyte1, i2);
        k2 = j2 + DataConvert.putInt2Bytes(k1, abyte1, j2);
        l2 = k2 + DataConvert.putShort2Bytes(304, abyte1, k2);
        i3 = l2 + DataConvert.putBytes2Bytes(p, abyte1, l2);
        j3 = i3 + DataConvert.putShort2Bytes(20, abyte1, i3);
        k3 = j3 + DataConvert.putString2Bytes(n, abyte1, j3);
        l3 = k3 + DataConvert.putInt2Bytes((int)m, abyte1, k3);
        i4 = l3 + DataConvert.putInt2Bytes(j1, abyte1, l3);
        j4 = i4 + DataConvert.putInt2Bytes(i1, abyte1, i4);
        int _tmp = j4 + DataConvert.putBytes2Bytes(abyte0, i1, abyte1, j4);
        return abyte1;
    }

    private void b()
    {
        (new h(this)).start();
    }

    static void b(f f1)
    {
        f1.c();
    }

    static String c(f f1)
    {
        return f1.j;
    }

    private void c()
    {
        (new i(this)).start();
    }

    static String d(f f1)
    {
        return f1.n;
    }

    static String e(f f1)
    {
        return f1.o;
    }

    static long f(f f1)
    {
        return f1.m;
    }

    static Context g(f f1)
    {
        return f1.h;
    }

    static FileManager.WeiyunFileType h(f f1)
    {
        return f1.i;
    }

    static Handler i(f f1)
    {
        return f1.l;
    }

    static String j(f f1)
    {
        return f1.q;
    }

    public void a()
    {
        if (j == null || !(new File(j)).exists())
        {
            Message message = l.obtainMessage();
            message.what = -5;
            message.obj = new String("");
            l.sendMessage(message);
            return;
        }
        k.onPrepareStart();
        File file = new File(j);
        m = file.length();
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            FileInputStream fileinputstream = new FileInputStream(file);
            DigestInputStream digestinputstream = new DigestInputStream(fileinputstream, messagedigest);
            for (byte abyte0[] = new byte[0x80000]; digestinputstream.read(abyte0) > 0;) { }
            MessageDigest messagedigest1 = digestinputstream.getMessageDigest();
            n = DataConvert.toHexString(messagedigest1.digest());
            messagedigest1.reset();
            fileinputstream.close();
            digestinputstream.close();
        }
        catch (Exception exception)
        {
            Message message1 = l.obtainMessage();
            message1.what = -2;
            message1.obj = new String("");
            l.sendMessage(message1);
            return;
        }
        try
        {
            MessageDigest messagedigest2 = MessageDigest.getInstance("MD5");
            FileInputStream fileinputstream1 = new FileInputStream(file);
            DigestInputStream digestinputstream1 = new DigestInputStream(fileinputstream1, messagedigest2);
            for (byte abyte1[] = new byte[0x80000]; digestinputstream1.read(abyte1) > 0;) { }
            MessageDigest messagedigest3 = digestinputstream1.getMessageDigest();
            o = DataConvert.toHexString(messagedigest3.digest());
            messagedigest3.reset();
            fileinputstream1.close();
            digestinputstream1.close();
        }
        catch (Exception exception1)
        {
            Message message2 = l.obtainMessage();
            message2.what = -2;
            message2.obj = new String("");
            l.sendMessage(message2);
            return;
        }
        b();
    }
}
