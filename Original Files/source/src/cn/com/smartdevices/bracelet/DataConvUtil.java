// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DataConvUtil
{

    public DataConvUtil()
    {
    }

    public static int byteToChar(byte abyte0[], int i)
    {
        return abyte0[i + 0];
    }

    public static int byteToInt(byte abyte0[])
    {
        int i = 0xff & abyte0[0];
        int j = 0xff & abyte0[1];
        int k = 0xff & abyte0[2];
        return (0xff & abyte0[3]) << 24 | (k << 16 | (i | j << 8));
    }

    public static int byteToInt(byte abyte0[], int i)
    {
        int j = 0xff & abyte0[i];
        int k = 0xff & abyte0[i + 1];
        int l = 0xff & abyte0[i + 2];
        return (0xff & abyte0[i + 3]) << 24 | (l << 16 | (j | k << 8));
    }

    public static long byteToLong(byte abyte0[])
    {
        long l = 0xff & abyte0[0];
        long l1 = 0xff & abyte0[1];
        long l2 = 0xff & abyte0[2];
        long l3 = 0xff & abyte0[3];
        long l4 = 0xff & abyte0[4];
        long l5 = 0xff & abyte0[5];
        long l6 = 0xff & abyte0[6];
        long l7 = 0xff & abyte0[7];
        long l8 = l1 << 8;
        long l9 = l2 << 16;
        long l10 = l3 << 24;
        long l11 = l4 << 32;
        long l12 = l5 << 40;
        long l13 = l6 << 48;
        return l7 << 56 | (l13 | (l12 | (l11 | (l10 | (l9 | (l | l8))))));
    }

    public static short byteToShort(byte abyte0[])
    {
        return (short)((short)(0xff & abyte0[0]) | (short)((short)(0xff & abyte0[1]) << 8));
    }

    public static short byteToShort(byte abyte0[], int i)
    {
        ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0, i, 2);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bytebuffer.getShort();
    }

    public static byte[] intToByte(int i)
    {
        byte abyte0[] = new byte[4];
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte0[j] = (new Integer(i & 0xff)).byteValue();
            i >>= 8;
        }

        return abyte0;
    }

    public static byte[] longToByte(long l)
    {
        byte abyte0[] = new byte[8];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (new Long(255L & l)).byteValue();
            l >>= 8;
        }

        return abyte0;
    }

    public static byte[] shortToByte(short word0)
    {
        byte abyte0[] = new byte[2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (new Integer(word0 & 0xff)).byteValue();
            word0 >>= 8;
        }

        return abyte0;
    }
}
