// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class s
{

    public s()
    {
    }

    public static Object a(String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return null;
        }
        Object obj;
        try
        {
            obj = (new ObjectInputStream(new ByteArrayInputStream(b(s1)))).readObject();
        }
        catch (Exception exception)
        {
            return null;
        }
        return obj;
    }

    public static String a(Serializable serializable)
    {
        if (serializable == null)
        {
            return "";
        }
        String s1;
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(serializable);
            objectoutputstream.close();
            s1 = a(bytearrayoutputstream.toByteArray());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s1;
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuffer.toString();
            }
            stringbuffer.append((char)(97 + (0xf & abyte0[i] >> 4)));
            stringbuffer.append((char)(97 + (0xf & abyte0[i])));
            i++;
        } while (true);
    }

    public static byte[] b(String s1)
    {
        byte abyte0[] = new byte[s1.length() / 2];
        int i = 0;
        do
        {
            if (i >= s1.length())
            {
                return abyte0;
            }
            char c = s1.charAt(i);
            abyte0[i / 2] = (byte)(c - 97 << 4);
            char c1 = s1.charAt(i + 1);
            int j = i / 2;
            abyte0[j] = (byte)(abyte0[j] + (c1 - 97));
            i += 2;
        } while (true);
    }
}
