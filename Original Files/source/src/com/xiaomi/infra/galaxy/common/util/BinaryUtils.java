// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.xiaomi.infra.galaxy.common.util:
//            Base64Utils

public class BinaryUtils
{

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/util/BinaryUtils);

    public BinaryUtils()
    {
    }

    public static byte[] fromBase64(String s)
    {
        byte abyte0[];
        try
        {
            abyte0 = Base64Utils.decode(s.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            log.warn("Tried to Base64-decode a String with the wrong encoding: ", unsupportedencodingexception);
            return Base64Utils.decode(s.getBytes());
        }
        return abyte0;
    }

    public static byte[] fromHex(String s)
    {
        int i = 0;
        byte abyte0[] = new byte[(1 + s.length()) / 2];
        int k;
        for (int j = 0; j < s.length(); j = k)
        {
            String s1 = s.substring(j, j + 2);
            k = j + 2;
            int l = i + 1;
            abyte0[i] = (byte)Integer.parseInt(s1, 16);
            i = l;
        }

        return abyte0;
    }

    public static String toBase64(byte abyte0[])
    {
        return Base64Utils.encode(abyte0);
    }

    public static String toHex(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        int i = 0;
        while (i < abyte0.length) 
        {
            String s = Integer.toHexString(abyte0[i]);
            if (s.length() == 1)
            {
                stringbuilder.append("0");
            } else
            if (s.length() == 8)
            {
                s = s.substring(6);
            }
            stringbuilder.append(s);
            i++;
        }
        return stringbuilder.toString().toLowerCase(Locale.getDefault());
    }

    public static InputStream toStream(ByteBuffer bytebuffer)
    {
        byte abyte0[] = new byte[bytebuffer.remaining()];
        bytebuffer.get(abyte0);
        return new ByteArrayInputStream(abyte0);
    }

}
