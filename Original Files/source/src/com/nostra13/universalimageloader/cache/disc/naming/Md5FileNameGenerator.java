// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.naming;

import com.nostra13.universalimageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.naming:
//            FileNameGenerator

public class Md5FileNameGenerator
    implements FileNameGenerator
{

    private static final String a = "MD5";
    private static final int b = 36;

    public Md5FileNameGenerator()
    {
    }

    private byte[] a(byte abyte0[])
    {
        byte abyte1[];
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte1 = messagedigest.digest();
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            L.e(nosuchalgorithmexception);
            return null;
        }
        return abyte1;
    }

    public String generate(String s)
    {
        return (new BigInteger(a(s.getBytes()))).abs().toString(36);
    }
}
