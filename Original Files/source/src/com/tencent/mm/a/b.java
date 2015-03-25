// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.a;

import java.security.MessageDigest;

public final class b
{

    public static final String a(byte abyte0[])
    {
        int i = 0;
        char ac[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            'a', 'b', 'c', 'd', 'e', 'f'
        };
        byte abyte1[];
        int j;
        char ac1[];
        int k;
        byte byte0;
        int l;
        String s;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte1 = messagedigest.digest();
            j = abyte1.length;
            ac1 = new char[j * 2];
        }
        catch (Exception exception)
        {
            return null;
        }
        k = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = abyte1[i];
        l = k + 1;
        ac1[k] = ac[0xf & byte0 >>> 4];
        k = l + 1;
        ac1[l] = ac[byte0 & 0xf];
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_133;
_L1:
        s = new String(ac1);
        return s;
    }
}
