// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

// Referenced classes of package u.aly:
//            bv

public class bu
{

    public static int a;

    public bu()
    {
    }

    public static String a(byte abyte0[], String s)
    {
        byte abyte1[] = b(abyte0);
        if (abyte1 != null)
        {
            return new String(abyte1, s);
        } else
        {
            return null;
        }
    }

    public static byte[] a(String s, String s1)
    {
        if (bv.d(s))
        {
            return null;
        } else
        {
            return a(s.getBytes(s1));
        }
    }

    public static byte[] a(byte abyte0[])
    {
        Deflater deflater;
        byte abyte1[];
        if (abyte0 == null || abyte0.length <= 0)
        {
            return null;
        }
        deflater = new Deflater();
        deflater.setInput(abyte0);
        deflater.finish();
        abyte1 = new byte[8192];
        a = 0;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L1:
        if (!deflater.finished())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        deflater.end();
        if (bytearrayoutputstream != null)
        {
            bytearrayoutputstream.close();
        }
        return bytearrayoutputstream.toByteArray();
        int i = deflater.deflate(abyte1);
        a = i + a;
        bytearrayoutputstream.write(abyte1, 0, i);
          goto _L1
        Exception exception;
        exception;
_L3:
        if (bytearrayoutputstream != null)
        {
            bytearrayoutputstream.close();
        }
        throw exception;
        Exception exception1;
        exception1;
        exception = exception1;
        bytearrayoutputstream = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static byte[] b(byte abyte0[])
    {
        int i = 0;
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0, 0, abyte0.length);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte1[] = new byte[1024];
        do
        {
            if (inflater.needsInput())
            {
                inflater.end();
                return bytearrayoutputstream.toByteArray();
            }
            int j = inflater.inflate(abyte1);
            bytearrayoutputstream.write(abyte1, i, j);
            i += j;
        } while (true);
    }
}
