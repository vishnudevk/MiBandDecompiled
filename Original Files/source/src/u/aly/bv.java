// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package u.aly:
//            bj

public class bv
{

    public static final String a = System.getProperty("line.separator");
    private static final String b = "helper";

    public bv()
    {
    }

    public static String a()
    {
        return a(new Date());
    }

    public static String a(Context context, long l)
    {
        if (l < 1000L)
        {
            return (new StringBuilder(String.valueOf((int)l))).append("B").toString();
        }
        if (l < 0xf4240L)
        {
            return (new StringBuilder(String.valueOf(Math.round((double)(float)l / 1000D)))).append("K").toString();
        }
        if (l < 0x3b9aca00L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.0")).format((double)(float)l / 1000000D)))).append("M").toString();
        } else
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1000000000D)))).append("G").toString();
        }
    }

    public static String a(File file)
    {
        byte abyte0[] = new byte[1024];
        boolean flag;
        MessageDigest messagedigest;
        FileInputStream fileinputstream;
        int i;
        try
        {
            flag = file.isFile();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (!flag)
        {
            return "";
        }
        messagedigest = MessageDigest.getInstance("MD5");
        fileinputstream = new FileInputStream(file);
_L1:
        i = fileinputstream.read(abyte0, 0, 1024);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        fileinputstream.close();
        return String.format("%1$032x", new Object[] {
            new BigInteger(1, messagedigest.digest())
        });
        messagedigest.update(abyte0, 0, i);
          goto _L1
    }

    public static String a(InputStream inputstream)
    {
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        char ac[] = new char[1024];
        StringWriter stringwriter = new StringWriter();
        do
        {
            int i = inputstreamreader.read(ac);
            if (-1 == i)
            {
                return stringwriter.toString();
            }
            stringwriter.write(ac, 0, i);
        } while (true);
    }

    public static String a(String s)
    {
        int i;
        i = 0;
        if (s == null)
        {
            return null;
        }
        byte abyte1[];
        StringBuffer stringbuffer;
        byte abyte0[] = s.getBytes();
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.reset();
        messagedigest.update(abyte0);
        abyte1 = messagedigest.digest();
        stringbuffer = new StringBuffer();
_L1:
        if (i >= abyte1.length)
        {
            return stringbuffer.toString();
        }
        Object aobj[] = new Object[1];
        aobj[0] = Byte.valueOf(abyte1[i]);
        stringbuffer.append(String.format("%02X", aobj));
        i++;
          goto _L1
        Exception exception;
        exception;
        return s.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
    }

    public static String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(date);
        }
    }

    public static void a(Context context, String s)
    {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(s));
    }

    public static void a(File file, String s)
    {
        a(file, s.getBytes());
    }

    public static void a(File file, byte abyte0[])
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        fileoutputstream.write(abyte0);
        fileoutputstream.flush();
        a(((OutputStream) (fileoutputstream)));
        return;
        Exception exception;
        exception;
        a(((OutputStream) (fileoutputstream)));
        throw exception;
    }

    public static void a(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        Exception exception;
        exception;
    }

    public static String b(String s)
    {
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            bj.a("helper", "getMD5 error", nosuchalgorithmexception);
            return "";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            return stringbuffer.toString();
        }
        stringbuffer.append(Integer.toHexString(0xff & abyte0[i]));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_31;
        }
    }

    public static boolean b(Context context, String s)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public static byte[] b(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 == i)
            {
                return bytearrayoutputstream.toByteArray();
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
    }

    public static String c(String s)
    {
        long l;
        try
        {
            l = Long.valueOf(s).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            return s;
        }
        if (l < 1024L)
        {
            return (new StringBuilder(String.valueOf((int)l))).append("B").toString();
        }
        if (l < 0x100000L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1024D)))).append("K").toString();
        }
        if (l < 0x40000000L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1048576D)))).append("M").toString();
        } else
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1073741824D)))).append("G").toString();
        }
    }

    public static void c(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        Exception exception;
        exception;
    }

    public static boolean d(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean e(String s)
    {
        String s1;
        if (!d(s))
        {
            if ((s1 = s.trim().toLowerCase(Locale.US)).startsWith("http://") || s1.startsWith("https://"))
            {
                return true;
            }
        }
        return false;
    }

}
