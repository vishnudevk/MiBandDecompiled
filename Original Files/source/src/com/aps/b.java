// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.aps:
//            t

public class b
{

    private String a;
    private Cipher b;

    b()
    {
        a = "AES/CBC/PKCS5Padding";
        b = null;
        SecretKeySpec secretkeyspec = new SecretKeySpec("#a@u!t*o(n)a&v^i".getBytes("UTF-8"), "AES");
        IvParameterSpec ivparameterspec = new IvParameterSpec("_a+m-a=p?a>p<s%3".getBytes("UTF-8"));
        b = Cipher.getInstance(a);
        b.init(2, secretkeyspec, ivparameterspec);
        return;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        t.a(throwable);
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "";
        }
        String s;
        try
        {
            s = com.amap.api.location.core.b.a(abyte0);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return "";
        }
        return s;
    }

    private byte[] a(String s)
    {
        int i;
        byte abyte0[];
        i = 0;
        abyte0 = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        int j;
        j = s.length();
        abyte0 = null;
        if (j == 0) goto _L2; else goto _L3
_L3:
        int k;
        k = s.length() % 2;
        abyte0 = null;
        if (k == 0) goto _L4; else goto _L2
_L2:
        return abyte0;
_L4:
        StringBuilder stringbuilder;
        abyte0 = new byte[s.length() / 2];
        stringbuilder = new StringBuilder();
_L6:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append("0X");
        stringbuilder.append(s.substring(i, i + 2));
        String s1 = stringbuilder.toString();
        abyte0[i / 2] = (byte)Integer.decode(s1).intValue();
        i += 2;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L2; else goto _L7
_L7:
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        t.a(throwable);
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }

    String a(String s, String s1)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        }
        String s2;
        try
        {
            byte abyte0[] = a(s);
            s2 = new String(b.doFinal(abyte0), s1);
        }
        catch (Exception exception)
        {
            t.a(exception);
            return null;
        }
        return s2;
    }
}
