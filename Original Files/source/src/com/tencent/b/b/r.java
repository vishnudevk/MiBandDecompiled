// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class r
{

    public static String a(String s)
    {
        byte abyte0[];
        StringBuilder stringbuilder;
        int i;
        int j;
        String s1;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuilder = new StringBuilder();
            i = abyte0.length;
        }
        catch (Exception exception)
        {
            return s;
        }
        j = 0;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(Integer.toHexString(0xff & abyte0[j])).append("");
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_35;
_L1:
        s1 = stringbuilder.toString();
        return s1;
    }

    public static byte[] a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DeflaterOutputStream deflateroutputstream = new DeflaterOutputStream(bytearrayoutputstream);
        try
        {
            deflateroutputstream.write(abyte0, 0, abyte0.length);
            deflateroutputstream.finish();
            deflateroutputstream.flush();
            deflateroutputstream.close();
        }
        catch (Exception exception)
        {
            return null;
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static byte[] b(byte abyte0[])
    {
        int i;
        ByteArrayInputStream bytearrayinputstream;
        InflaterInputStream inflaterinputstream;
        byte abyte1[];
        byte abyte2[];
        i = 0;
        if (abyte0 == null)
        {
            return null;
        }
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        inflaterinputstream = new InflaterInputStream(bytearrayinputstream);
        abyte1 = new byte[0];
        abyte2 = new byte[1024];
_L2:
        byte abyte3[];
        int j;
        IOException ioexception;
        try
        {
            j = inflaterinputstream.read(abyte2);
        }
        catch (Exception exception)
        {
            return null;
        }
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i += j;
        abyte3 = new byte[i];
        System.arraycopy(abyte1, 0, abyte3, 0, abyte1.length);
        System.arraycopy(abyte2, 0, abyte3, abyte1.length, j);
_L3:
        if (j <= 0)
        {
            try
            {
                bytearrayinputstream.close();
                inflaterinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
            return abyte3;
        }
        abyte1 = abyte3;
        if (true) goto _L2; else goto _L1
_L1:
        abyte3 = abyte1;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }
}
