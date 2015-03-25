// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.UnsupportedEncodingException;

// Referenced classes of package com.loopj.android.http:
//            h, i

public class Base64
{

    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    private Base64()
    {
    }

    public static byte[] decode(String s, int j)
    {
        return decode(s.getBytes(), j);
    }

    public static byte[] decode(byte abyte0[], int j)
    {
        return decode(abyte0, 0, abyte0.length, j);
    }

    public static byte[] decode(byte abyte0[], int j, int k, int l)
    {
        h h1 = new h(l, new byte[(k * 3) / 4]);
        if (!h1.a(abyte0, j, k, true))
        {
            throw new IllegalArgumentException("bad base-64");
        }
        if (h1.b == h1.a.length)
        {
            return h1.a;
        } else
        {
            byte abyte1[] = new byte[h1.b];
            System.arraycopy(h1.a, 0, abyte1, 0, h1.b);
            return abyte1;
        }
    }

    public static byte[] encode(byte abyte0[], int j)
    {
        return encode(abyte0, 0, abyte0.length, j);
    }

    public static byte[] encode(byte abyte0[], int j, int k, int l)
    {
        i i1;
        int j1;
        i1 = new i(l, null);
        j1 = 4 * (k / 3);
        if (!i1.e) goto _L2; else goto _L1
_L1:
        if (k % 3 > 0)
        {
            j1 += 4;
        }
_L4:
        if (i1.f && k > 0)
        {
            int k1 = 1 + (k - 1) / 57;
            byte byte0;
            if (i1.g)
            {
                byte0 = 2;
            } else
            {
                byte0 = 1;
            }
            j1 += byte0 * k1;
        }
        i1.a = new byte[j1];
        i1.a(abyte0, j, k, true);
        return i1.a;
_L2:
        switch (k % 3)
        {
        case 1: // '\001'
            j1 += 2;
            break;

        case 2: // '\002'
            j1 += 3;
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String encodeToString(byte abyte0[], int j)
    {
        String s;
        try
        {
            s = new String(encode(abyte0, j), "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    public static String encodeToString(byte abyte0[], int j, int k, int l)
    {
        String s;
        try
        {
            s = new String(encode(abyte0, j, k, l), "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }
}
