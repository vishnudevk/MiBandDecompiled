// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{

    private final byte a[][];
    private final int b;
    private final int c;

    public ByteMatrix(int i, int j)
    {
        int ai[] = {
            j, i
        };
        a = (byte[][])Array.newInstance(Byte.TYPE, ai);
        b = i;
        c = j;
    }

    public void clear(byte byte0)
    {
        for (int i = 0; i < c; i++)
        {
            for (int j = 0; j < b; j++)
            {
                a[i][j] = byte0;
            }

        }

    }

    public byte get(int i, int j)
    {
        return a[j][i];
    }

    public byte[][] getArray()
    {
        return a;
    }

    public int getHeight()
    {
        return c;
    }

    public int getWidth()
    {
        return b;
    }

    public void set(int i, int j, byte byte0)
    {
        a[j][i] = byte0;
    }

    public void set(int i, int j, int k)
    {
        a[j][i] = (byte)k;
    }

    public void set(int i, int j, boolean flag)
    {
        byte abyte0[] = a[j];
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        abyte0[i] = (byte)k;
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder(2 + 2 * b * c);
        i = 0;
_L5:
        int j;
        if (i >= c)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0;
_L2:
        if (j >= b)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        switch (a[i][j])
        {
        default:
            stringbuilder.append("  ");
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_95;
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder.append(" 0");
          goto _L3
        stringbuilder.append(" 1");
          goto _L3
        stringbuilder.append('\n');
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return stringbuilder.toString();
    }
}
