// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import java.io.PrintStream;
import java.security.MessageDigest;

public class MD5
{

    private static final char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };

    public MD5()
    {
    }

    public static String hexdigest(String s)
    {
        String s1;
        try
        {
            s1 = hexdigest(s.getBytes());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s1;
    }

    public static String hexdigest(byte abyte0[])
    {
        int i = 0;
        byte abyte1[];
        char ac[];
        int j;
        byte byte0;
        int k;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte1 = messagedigest.digest();
            ac = new char[32];
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        j = 0;
        if (i < 16)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        return new String(ac);
        byte0 = abyte1[i];
        k = j + 1;
        ac[j] = hexDigits[0xf & byte0 >>> 4];
        j = k + 1;
        ac[k] = hexDigits[byte0 & 0xf];
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_28;
        }
    }

    public static void main(String args[])
    {
        System.out.println(hexdigest("c"));
    }

}
