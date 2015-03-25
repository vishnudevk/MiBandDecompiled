// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{

    static final String a = "AES/CBC/PKCS5Padding";
    private static final String b[] = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "a", "b", "c", "d", "e", "f"
    };

    public b()
    {
    }

    private static String a(byte byte0)
    {
        if (byte0 < 0)
        {
            byte0 += 256;
        }
        int i = byte0 / 16;
        int j = byte0 % 16;
        return (new StringBuilder(String.valueOf(b[i]))).append(b[j]).toString();
    }

    static final String a(File file)
    {
        byte abyte0[];
        FileInputStream fileinputstream;
        MessageDigest messagedigest;
        int i;
        abyte0 = new byte[1024];
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return null;
        }
        messagedigest = MessageDigest.getInstance("MD5");
_L1:
        i = fileinputstream.read(abyte0);
        if (i <= 0)
        {
            Exception exception;
            IOException ioexception;
            IOException ioexception1;
            IOException ioexception2;
            NoSuchAlgorithmException nosuchalgorithmexception;
            IOException ioexception3;
            try
            {
                fileinputstream.close();
            }
            catch (IOException ioexception4)
            {
                ioexception4.printStackTrace();
            }
            return b(messagedigest.digest());
        }
        messagedigest.update(abyte0, 0, i);
          goto _L1
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception3)
        {
            ioexception3.printStackTrace();
            return null;
        }
        return null;
        ioexception1;
        ioexception1.printStackTrace();
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception2)
        {
            ioexception2.printStackTrace();
            return null;
        }
        return null;
        exception;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        throw exception;
    }

    static final String a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        messagedigest.update(s.getBytes());
        return b(messagedigest.digest());
    }

    static final String a(String s, String s1)
    {
        byte abyte0[];
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            if ((abyte0 = g(s1)) != null && abyte0.length == 16)
            {
                SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "AES");
                String s2;
                try
                {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretkeyspec, new IvParameterSpec("0102030405060708".getBytes()));
                    s2 = a(cipher.doFinal(s.getBytes()));
                }
                catch (NoSuchAlgorithmException nosuchalgorithmexception)
                {
                    return null;
                }
                catch (NoSuchPaddingException nosuchpaddingexception)
                {
                    return null;
                }
                catch (InvalidKeyException invalidkeyexception)
                {
                    return null;
                }
                catch (InvalidAlgorithmParameterException invalidalgorithmparameterexception)
                {
                    return null;
                }
                catch (IllegalBlockSizeException illegalblocksizeexception)
                {
                    return null;
                }
                catch (BadPaddingException badpaddingexception)
                {
                    return null;
                }
                return s2;
            }
        }
        return null;
    }

    static final String a(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 2);
    }

    static final String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        messagedigest.update(s.getBytes());
        return b(messagedigest.digest());
    }

    static final String b(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        return null;
_L2:
        if ((abyte0 = g(s1)) == null || abyte0.length != 16) goto _L1; else goto _L3
_L3:
        SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "AES");
        Cipher cipher;
        byte abyte1[];
        String s2;
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretkeyspec, new IvParameterSpec("0102030405060708".getBytes()));
            abyte1 = g(s);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return null;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            return null;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            return null;
        }
        catch (InvalidAlgorithmParameterException invalidalgorithmparameterexception)
        {
            return null;
        }
        catch (IllegalBlockSizeException illegalblocksizeexception)
        {
            return null;
        }
        catch (BadPaddingException badpaddingexception)
        {
            return null;
        }
        if (abyte1 == null) goto _L1; else goto _L4
_L4:
        s2 = new String(cipher.doFinal(abyte1));
        return s2;
    }

    private static String b(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuffer.toString();
            }
            stringbuffer.append(a(abyte0[i]));
            i++;
        } while (true);
    }

    static final byte[] c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        messagedigest.update(s.getBytes());
        return messagedigest.digest();
    }

    static final String d(String s)
    {
        return Base64.encodeToString(s.getBytes(), 2);
    }

    static final byte[] e(String s)
    {
        return Base64.encode(s.getBytes(), 2);
    }

    static final String f(String s)
    {
        return new String(Base64.decode(s, 0));
    }

    static final byte[] g(String s)
    {
        return Base64.decode(s, 0);
    }

}
