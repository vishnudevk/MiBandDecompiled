// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;

// Referenced classes of package com.aps:
//            af, au

public final class av
{

    private Context a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long j;
    private au k;

    private av(Context context)
    {
        a = null;
        b = true;
        c = 1270;
        d = 310;
        e = 4;
        f = 200;
        g = 1;
        h = 0;
        i = 0;
        j = 0L;
        k = null;
        a = context;
    }

    private static int a(byte abyte0[], int l)
    {
        int i1 = 0;
        int j1 = 0;
        for (; i1 < 4; i1++)
        {
            j1 += (0xff & abyte0[i1 + l]) << (i1 << 3);
        }

        return j1;
    }

    protected static av a(Context context)
    {
        av av1;
        FileInputStream fileinputstream;
        av1 = new av(context);
        av1.h = 0;
        av1.i = 0;
        av1.j = 0x5265c00L * ((0x1b77400L + System.currentTimeMillis()) / 0x5265c00L);
        fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(new File((new StringBuilder()).append(b(context)).append(File.separator).append("data_carrier_status").toString()));
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[32];
_L3:
        int l = fileinputstream1.read(abyte0);
        if (l == -1) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(abyte0, 0, l);
          goto _L3
        Exception exception3;
        exception3;
_L7:
        Exception exception1;
        byte abyte1[];
        Exception exception5;
        boolean flag;
        long l1;
        if (fileinputstream1 != null)
        {
            try
            {
                fileinputstream1.close();
            }
            catch (Exception exception4)
            {
                return av1;
            }
        }
        return av1;
_L2:
        bytearrayoutputstream.flush();
        abyte1 = bytearrayoutputstream.toByteArray();
        if (abyte1 == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        if (abyte1.length < 22)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        if (abyte1[0] != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        av1.b = flag;
        av1.c = 10 * abyte1[1] << 10;
        av1.d = 10 * abyte1[2] << 10;
        av1.e = abyte1[3];
        av1.f = 10 * abyte1[4];
        av1.g = abyte1[5];
        l1 = b(abyte1, 14);
        if (av1.j - l1 < 0x5265c00L)
        {
            av1.j = l1;
            av1.h = a(abyte1, 6);
            av1.i = a(abyte1, 10);
        }
        bytearrayoutputstream.close();
        try
        {
            fileinputstream1.close();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception5)
        {
            return av1;
        }
        return av1;
        exception1;
_L5:
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            catch (Exception exception2) { }
        }
        throw exception1;
        Exception exception;
        exception;
        fileinputstream = fileinputstream1;
        exception1 = exception;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception6;
        exception6;
        fileinputstream1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static byte[] a(long l)
    {
        byte abyte0[] = new byte[8];
        for (int i1 = 0; i1 < 8; i1++)
        {
            abyte0[i1] = (byte)(int)(255L & l >> (i1 << 3));
        }

        return abyte0;
    }

    private static long b(byte abyte0[], int l)
    {
        int i1 = 0;
        int j1 = 0;
        for (; i1 < 8; i1++)
        {
            j1 += (0xff & abyte0[i1 + 14]) << (i1 << 3);
        }

        return (long)j1;
    }

    private static String b(Context context)
    {
        File file;
        int l = Process.myUid();
        file = null;
        if (l != 1000)
        {
            file = af.a(context);
        }
        boolean flag1 = "mounted".equals(Environment.getExternalStorageState());
        boolean flag = flag1;
_L2:
        if ((flag || !af.c()) && file != null)
        {
            return file.getPath();
        } else
        {
            return context.getFilesDir().getPath();
        }
        Exception exception;
        exception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static byte[] c(int l)
    {
        byte abyte0[] = new byte[4];
        for (int i1 = 0; i1 < 4; i1++)
        {
            abyte0[i1] = (byte)(l >> (i1 << 3));
        }

        return abyte0;
    }

    private void g()
    {
        long l = 0x1b77400L + System.currentTimeMillis();
        if (l - j > 0x5265c00L)
        {
            j = 0x5265c00L * (l / 0x5265c00L);
            h = 0;
            i = 0;
        }
    }

    protected final void a(int l)
    {
        g();
        if (l < 0)
        {
            l = 0;
        }
        h = l;
    }

    protected final void a(au au1)
    {
        k = au1;
    }

    protected final boolean a()
    {
        g();
        NetworkInfo networkinfo = ((ConnectivityManager)a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected())
        {
            if (networkinfo.getType() == 1)
            {
                return b && h < c;
            }
            return b && i < d;
        } else
        {
            return b;
        }
    }

    protected final boolean a(String s)
    {
        int l = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        if (!jsonobject.has("e"))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        boolean flag;
        FileOutputStream fileoutputstream;
        byte abyte0[];
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        int i1;
        boolean flag1;
        if (jsonobject.getInt("e") != 0)
        {
            flag1 = l;
        } else
        {
            flag1 = false;
        }
        b = flag1;
        if (jsonobject.has("d"))
        {
            int j1 = jsonobject.getInt("d");
            c = 10 * (j1 & 0x7f) << 10;
            d = 10 * ((j1 & 0xf80) >> 7) << 10;
            e = (0x7f000 & j1) >> 12;
            f = 10 * ((0x3f80000 & j1) >> 19);
            g = (j1 & 0x7c000000) >> 26;
            if (g == 31)
            {
                g = 1500;
            }
            if (k != null)
            {
                k.a();
            }
        }
        if (!jsonobject.has("u")) goto _L2; else goto _L1
_L1:
        i1 = jsonobject.getInt("u");
        if (i1 != 0)
        {
            flag = l;
        } else
        {
            flag = false;
        }
_L9:
        g();
        fileoutputstream = new FileOutputStream(new File((new StringBuilder()).append(b(a)).append(File.separator).append("data_carrier_status").toString()));
        abyte0 = c(h);
        abyte1 = c(i);
        abyte2 = a(j);
        abyte3 = new byte[22];
        Exception exception;
        if (!b)
        {
            l = 0;
        }
        abyte3[0] = (byte)l;
        abyte3[1] = (byte)(c / 10240);
        abyte3[2] = (byte)(d / 10240);
        abyte3[3] = (byte)e;
        abyte3[4] = (byte)(f / 10);
        abyte3[5] = (byte)g;
        abyte3[6] = abyte0[0];
        abyte3[7] = abyte0[1];
        abyte3[8] = abyte0[2];
        abyte3[9] = abyte0[3];
        abyte3[10] = abyte1[0];
        abyte3[11] = abyte1[1];
        abyte3[12] = abyte1[2];
        abyte3[13] = abyte1[3];
        abyte3[14] = abyte2[0];
        abyte3[15] = abyte2[1];
        abyte3[16] = abyte2[2];
        abyte3[17] = abyte2[3];
        abyte3[18] = abyte2[4];
        abyte3[19] = abyte2[5];
        abyte3[20] = abyte2[6];
        abyte3[21] = abyte2[7];
        fileoutputstream.write(abyte3);
        Exception exception1;
        Exception exception3;
        FileOutputStream fileoutputstream1;
        try
        {
            fileoutputstream.close();
        }
        catch (Exception exception6)
        {
            return flag;
        }
_L7:
        return flag;
        exception;
        flag = false;
        continue; /* Loop/switch isn't completed */
        exception3;
        fileoutputstream1 = null;
_L6:
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception4)
            {
                return flag;
            }
            return flag;
        }
        break; /* Loop/switch isn't completed */
        exception1;
        fileoutputstream = null;
_L4:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (Exception exception2) { }
        }
        throw exception1;
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception5;
        exception5;
        fileoutputstream1 = fileoutputstream;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L7; else goto _L2
_L2:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected final int b()
    {
        return e;
    }

    protected final void b(int l)
    {
        g();
        if (l < 0)
        {
            l = 0;
        }
        i = l;
    }

    protected final int c()
    {
        return f;
    }

    protected final int d()
    {
        return g;
    }

    protected final int e()
    {
        g();
        return h;
    }

    protected final int f()
    {
        g();
        return i;
    }
}
