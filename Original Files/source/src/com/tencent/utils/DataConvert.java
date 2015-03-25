// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;


public class DataConvert
{

    public DataConvert()
    {
    }

    public static int byteToInt2(byte abyte0[])
    {
        return (abyte0[0] << 24) + (abyte0[1] << 16) + (abyte0[2] << 8) + abyte0[3];
    }

    public static int bytesToInt(byte abyte0[])
    {
        return Integer.parseInt(new String(abyte0));
    }

    public static byte[] intToBytes(int i)
    {
        return String.valueOf(i).getBytes();
    }

    public static byte[] intToBytes2(int i)
    {
        byte abyte0[] = new byte[4];
        for (int j = 0; j < 4; j++)
        {
            abyte0[j] = (byte)(i >> 24 - j * 8);
        }

        return abyte0;
    }

    public static int putBytes2Bytes(byte abyte0[], int i, byte abyte1[], int j)
    {
        for (int k = 0; k < i; k++)
        {
            abyte1[j + k] = abyte0[k];
        }

        return abyte0.length;
    }

    public static int putBytes2Bytes(byte abyte0[], byte abyte1[], int i)
    {
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte1[i + j] = abyte0[j];
        }

        return abyte0.length;
    }

    public static int putInt2Bytes(int i, byte abyte0[], int j)
    {
        byte abyte1[] = intToBytes2(i);
        for (int k = 0; k < abyte1.length; k++)
        {
            abyte0[j + k] = abyte1[k];
        }

        return abyte1.length;
    }

    public static int putShort2Bytes(int i, byte abyte0[], int j)
    {
        byte abyte1[] = intToBytes2(i);
        abyte0[j + 0] = abyte1[2];
        abyte0[j + 1] = abyte1[3];
        return 2;
    }

    public static int putString2Bytes(String s, byte abyte0[], int i)
    {
        byte abyte1[] = string2bytes(s);
        for (int j = 0; j < abyte1.length; j++)
        {
            abyte0[i + j] = abyte1[j];
        }

        return abyte1.length;
    }

    public static byte[] string2ascii(String s)
    {
        int i = s.length();
        byte abyte0[] = new byte[i];
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)Integer.parseInt(s.substring(j, j + 1));
        }

        return abyte0;
    }

    public static byte[] string2bytes(String s)
    {
        String s1 = s.replace(" ", "");
        int i = s1.length();
        int j = i / 2;
        if (i % 2 == 1)
        {
            s1 = (new StringBuilder()).append("0").append(s1).toString();
            int _tmp = i + 1;
            j++;
        }
        byte abyte0[] = new byte[j];
        for (int k = 0; k < j; k++)
        {
            abyte0[k] = (byte)Integer.parseInt(s1.substring(k * 2, 2 + k * 2), 16);
        }

        return abyte0;
    }

    public static String toHexString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toString(0xff & abyte0[i], 16);
            if (s.length() == 1)
            {
                s = (new StringBuilder()).append("0").append(s).toString();
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }
}
